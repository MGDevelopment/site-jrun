/**
 * $Log: testDetallesDaemon.java,v $
 * Revision 1.4  2008/05/30 16:06:15  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.3  2006/10/13 19:35:59  oLSuarez
 * Creacion bannerTop en Musica.
 * Creacion de institucional util para todas las home
 *
 * Revision 1.2  2006/06/05 12:40:21  omsartori
 * - Modificacion de nuevas recomendaciones
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

import com.tmk.kernel.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;



//Hitea todos los detalles de articulos articulos habilitados

public class TestDetallesDaemon extends Daemon {
	int desde;
	int hasta;
	
	
	
	public TestDetallesDaemon(int desde, int hasta) {
		super(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
		this.desde = desde;
		this.hasta = hasta;
	}

	protected void ejecutarTarea() throws Exception {

		try {
			Vector<Integer> idArticulos = new Vector<Integer>();
			Connection con = DBUtil.buildConnection();

			try {
				String qry ="select id_articulo from (" +
					   " SELECT id_articulo, rownum cant FROM articulos WHERE categoria_seccion IN (1,3,4,5,6,7,8) AND habilitado_tematika = 'S') where" +
					   " cant>" + desde + " and cant<" + hasta;
			//	System.out.println(qry);
				PreparedStatement statement = con.prepareStatement(qry);
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
							 idArticulos.add(new Integer(rs.getInt("id_Articulo")));
							 TmkLogger.debug("articulo " + rs.getInt("id_Articulo"));
						 }

						 for (int i=0; i<idArticulos.size(); i++) {
						    try {
								HTMLUtil.download(Globals.PAGINA_SITIO + "/articulo/detalleArticulo.jsp?idArticulo=" + idArticulos.get(i));
								TmkLogger.debug("Hiteando " + idArticulos.get(i) + " total: " + i);
						    } catch (Exception e) {
							    TmkLogger.debug("Error Hiteando " + idArticulos.get(i) + " total: " + i + " " + e.toString());
						    }
						 }
					} catch (Exception e) {
                        TmkLogger.debug("Error 1 " + e.toString());
					}
					rs.close();
				} catch (Exception e) {
                    TmkLogger.debug("Error 2 " + e.toString() + " " + desde + " " + hasta);
				}
				statement.close();
			} catch (Exception e) {
                TmkLogger.debug("Error 3 " + e.toString());

			} finally {
				con.close();
			}	
		} catch (Exception e) {
			TmkLogger.debug("Error 4 " + e.toString());
		}


	}

	protected String getMensaje() {
		return "Hiteo de Articulos";
	}

	protected boolean pausada() {
		return (Globals.baseDeDatosEnMantenimiento());
	}

}
