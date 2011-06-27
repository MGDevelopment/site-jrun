/**
 * $Log: ImagenesABaseDaemon.java,v $
 * Revision 1.5  2008/12/03 12:40:49  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.4  2008/05/30 16:06:14  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.3  2006/09/28 14:58:19  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2006/07/17 14:07:49  omsartori
 * - Validacion de tarjetas de bco Rio
 * - Pop promo ABocelli
 * - Ultimos visitados resueltos con un qry
 * - Ejb de articulo eliminado de detalle de articulo
 * - Generacion de detalles -> correccion de commit de autores y editores
 *                                        -> Flag para evitar solapamiento de generaciones
 * - Indice de contenidos tomados de la base de datos. Se elimina el mantenimiento de archivos
 * - Pagina de indice de contenidos resuelta sin EJBs
 * - Webservice cliente para informe de compra de Musica On Line
 *
 * Revision 1.1  2006/05/19 14:24:34  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 */
package com.tmk.procesos;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.tmk.generacion.ContenidosEstaticos;
import com.tmk.kernel.Daemon;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;

public class ImagenesABaseDaemon extends Daemon {

	String ids;

	public ImagenesABaseDaemon(String ids) {
		super(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		this.ids = ids;


	}
	protected void ejecutarTarea() throws Exception {
		try{
			ContenidosEstaticos.inicioMapeo();

		} catch (Exception e) {
	    	TmkLogger.debug("Imagenes a Base, error en mapeo");
		    return;
		}
	//	StringBuffer errores = new StringBuffer();
		//StringBuffer qrys = new StringBuffer();

		try {
			//Connection con = DBUtil.buildConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//Desarrollo Comercial
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@basesdesa:1521:ntora9","comunicaciones","comunicacionesconsuc");
			//Preproduccion TMK
			//Connection con = DriverManager.getConnection("jdbc:oracle:thin:@basesnocriticas:1521:tmk2pre","comunicaciones","comunicacionesconsuc");
			//Produccion Comercial
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@central:1521:S067","msartori","base19800301");
			try {

				PreparedStatement statement = con.prepareStatement( " SELECT id_articulo" +
																	" FROM articulos " +
																	" WHERE id_articulo in (" + ids + ")");

				try {
					ResultSet rs = statement.executeQuery();
					try {
						try {
							PreparedStatement statementUpdate = con.prepareStatement("UPDATE articulos" +
																					" SET archivo_imagen = ? " +
																					" WHERE id_articulo = ? ");

							while (rs.next()) {
								TmkLogger.debug("Procesando:" + rs.getInt("id_articulo"));
								try {
									String tapa;
									if (tieneTapaChica(rs.getInt("id_articulo"))) {
										tapa = "C"; // solo chica
										if (tieneTapaGrande(rs.getInt("id_articulo"))) {
											tapa = "T"; //todas grande/chica
										}
									} else {
										if (tieneTapaGrande(rs.getInt("id_articulo"))) {
											tapa = "G"; // solo grande
										} else {
											tapa = "N"; // ninguna
										}
									}

									statementUpdate.setString(1, tapa);
									statementUpdate.setInt(2, rs.getInt("id_articulo"));
									statementUpdate.execute();

								} catch (Exception e){
									TmkLogger.debug("Imagenes a Base, Fallo en ejecucion de qry de update");
								}
							/*	System.out.print(rs.getInt("id_articulo"));
								System.out.print("Grande: " + tieneTapaChica(rs.getInt("id_articulo")));
								System.out.println("Chica: " + tieneTapaGrande(rs.getInt("id_articulo")));*/
							}
							statementUpdate.close();
						} catch (Exception e) {
							TmkLogger.debug("Imagenes a Base, Fallo en generacion de qry de update");
						}

					} catch (Exception e) {
						TmkLogger.debug("Imagenes a Base, Fallo en recordset");
					}
					rs.close();
				} catch (Exception e) {
					TmkLogger.debug("Imagenes a Base, Fallo en ejecucion de query");
				}
				statement.close();
			} catch (Exception e) {
				TmkLogger.debug("Imagenes a Base, Fallo en query");
			} finally {
				con.close();
			}
		} catch (Exception e) {
			TmkLogger.debug("Imagenes a Base, Fallo en conexion");
		}
	}

	protected String getMensaje() {
		return "Finalizado Marcas de TAPAS";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento());
	}

	boolean tieneTapaGrande(int idArticulo) {
		String dirTapaGrande = Globals.GENERACION_DIRECTORIO + "\\tapas\\grandes";
		File tapa = new File(dirTapaGrande + "\\l" + idArticulo + ".jpg");
		return tapa.exists();
	}

	boolean tieneTapaChica(int idArticulo) {
		String dirTapaChica =  Globals.GENERACION_DIRECTORIO + "\\tapas\\chicas";
		File tapa = new File(dirTapaChica + "\\" + idArticulo + ".jpg");
		return tapa.exists();
	}
}
