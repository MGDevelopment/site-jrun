/**
 * $Log: IndicesABaseDaemon.java,v $
 * Revision 1.6  2008/09/30 12:32:17  msartori
 * -tunning DBO
 * -Campos left join y campos a buscar en hashset a parte de DBO
 *
 * Revision 1.5  2006/08/14 13:29:24  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.4  2006/07/17 14:07:50  omsartori
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
 * Revision 1.3  2006/06/05 12:40:21  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.2  2006/05/19 14:24:34  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.1  2006/05/03 18:17:04  omsartori
 * - Modificacion de formulario de envio de CV
 * - Modificacion del proceso de generacion de detalles para commit
 * - proceso de indices a DB
 *
 */
package com.tmk.procesos;

import com.tmk.kernel.Daemon;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Convert;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.DriverManager;



//lee todos los indices de un directorio y cambia el nombre indentificado por isbn a id de articulos
//formatea el contenido de los indices

public class IndicesABaseDaemon extends Daemon {
	public IndicesABaseDaemon() {
		super(Daemon.DIEZ_SEGUNDOS, Daemon.UN_DIA - Daemon.DIEZ_MINUTOS);
	}

	protected void ejecutarTarea() throws Exception {
		File directorio = new File("d:\\tematika\\recursos\\asociadas\\indicesPrueba");
		File archivos [] = directorio.listFiles();
		TmkLogger.debug("Migracion de archivos");
		TmkLogger.debug("Cantidad de archivos" + archivos.length);
		try {
			//Connection con = DBUtil.buildConnection();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conDestino = DriverManager.getConnection("jdbc:oracle:thin:@basesdesa:1521:ntora9","yenny","pride");
			//Connection conDestino = DriverManager.getConnection("jdbc:oracle:thin:@central:1521:S067","msartori","base19800301");
			try {

				for (int i=0; i<archivos.length; i++) {
					//TmkLogger.debug("Subida de Indices] " + archivos[i].getName() );
					int idArticulo = Convert.toNumber(archivos[i].getName().replaceAll(".htm", ""), -1);
					BufferedReader reader = new BufferedReader(new FileReader(archivos[i]));
					StringBuffer str = new StringBuffer();
					while (reader.ready()) {
						str.append(reader.readLine()).append("\n");
					}
					reader.close();
					int partes = new Double (Math.ceil(str.length()*1.0/2000*1.0)).intValue();
					for (int j=0; j<partes; j++) {
						try {
							PreparedStatement statement = conDestino.prepareStatement("insert into articulos_textos (id_articulo, tipo, parte, tipo_texto, texto, idioma) values(?, ?, ?, ?, ?, ?)");
							try {
								statement.setInt(1, idArticulo);
								statement.setString(2, "04");
								statement.setInt(3, j+1);
								statement.setString(4, "02");
								statement.setString(5, str.toString().substring(j*2000, Math.min(j*2000 + 2000, str.length())));
								statement.setString(6, "ES");
								try {
									statement.execute();
									//TmkLogger.debug(str.toString().substring(j*2000, Math.min(j*2000 + 2000, str.length())));
									TmkLogger.debug("Subida de Indices] articulo " + idArticulo + " " + (j+1));
								} catch (Exception e) {
									TmkLogger.error("Subida de Indices] ejecucion de statement " + e.toString());
								}
							} catch (Exception e) {
								TmkLogger.error("Subida de Indices] seteo de statement " + e.toString());
							} finally {
								statement.close();
							}
						} catch (Exception e) {
							TmkLogger.error("Subida de Indices] creacion de statement " + e.toString());
						}
					}
				}
			} catch (Exception e) {

			} finally {
				conDestino.close();
			}
		} catch (Exception e) {
			TmkLogger.error("Subida de Indices] error en coneccion " + e.toString());
		}
		/*escribo errores*/
/*		File archivoError = new File("d:\\tematika\\recursos\\asociadas\\error.log");
		FileWriter outs = new FileWriter (archivoError, true);
		try {
			outs.write(errores.toString());
		} catch (Exception e) {

		} finally {
			outs.close();
		}
		*/

	}

	protected String getMensaje() {
		return "Subida de Inidices";
	}

	protected boolean pausada() {
		return false;
	}

}
