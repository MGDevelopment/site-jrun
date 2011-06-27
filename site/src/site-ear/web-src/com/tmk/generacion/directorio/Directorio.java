/**
 * $Log: Directorio.java,v $
 * Revision 1.10  2009/02/10 14:43:24  oClopez
 * no message
 *
 * Revision 1.9  2007/11/15 13:52:49  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.8  2007/01/23 17:32:21  oLSuarez
 * Rediseño del mapa de productos
 *
 * Revision 1.7  2007/01/22 17:23:21  oLSuarez
 * Correcciones
 *
 * Revision 1.6  2006/09/28 14:58:19  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.5  2006/03/22 15:01:01  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 *
 * Revision 1.4  2006/02/20 12:38:25  omsartori
 * - webservice y pantalla de comentarios de livra
 * - cheque obsequio DISCO
 * - correccion de grabacion en buffer para modificacion de domicilios
 * - bug tag articulo corregido
 * - inicio de generacion de imagen.
 *
 * Revision 1.3  2006/02/09 16:15:37  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.2  2006/01/31 15:51:35  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.1  2005/09/29 12:45:30  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.1  2005/09/22 18:38:53  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 */
package com.tmk.generacion.directorio;

import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.kernel.*;
import com.tmk.service.categoria.CategoriaService;


import javax.naming.NamingException;



import java.util.Vector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.File;
import java.io.FileWriter;


public class Directorio {

	//private final static int COLUMNAS_LISTADO = 3;
    private final static String [] CARACTERES_DE_GENERACION = {"='A'", "='B'", "='C'", "='D'", "='E'", "='F'", "='G'", "='H'", "='I'", "='J'", "='K'", "='L'", "='M'", "='N'", "='Ñ'", "='O'", "='P'", "='Q'", "='R'", "='S'", "='T'", "='U'", "='V'", "='W'", "='X'", "='Y'", "='Z'", "in ('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')"};
    private final static String NOMBRE_LISTADO = "listado";
	private final static String EXTENSION_LISTADO = "html";
	private final static String [] NOMBRE_LISTADO_ADICIONAL = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "N_", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "09"};

	private static int cantidadPaginas=0;
	private static int posiscionUltimoArticulo=0;
	private static int cantArticulosPorPagina = 15;

	public final static String CARACTERESVALIDOS = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ0123456789";


	private static void setCantidadPaginas(int cantidad){
		cantidadPaginas=cantidad;
	}

	private static int  getCantidadPaginas(){
		return cantidadPaginas;
	}

	private static void setPosiscionUltimoArticulo(int posicion){
		posiscionUltimoArticulo=posicion;
	}

	private static int getPosiscionUltimoArticulo(){
		return posiscionUltimoArticulo;
	}


	private static ArticuloClass[] getTitulos (String caracter)  throws SQLException, NamingException{
		Vector temp = new Vector();
		Connection connection = DBUtil.buildConnection();


		String LETRAS = "'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'";
		String qry;

		qry = "select a.id_articulo, a.titulo, a.categoria_seccion seccion, a.categoria_grupo grupo, catg.descripcion descgrupo" +
			  " from articulos a" +
			  " left join categ_grupos catg on catg.categoria_seccion = a.categoria_seccion and catg.categoria_grupo = a.categoria_grupo " +
			  " where a. habilitado_tematika = 'S' and	( substr(UPPER(a.titulo),1,1) " + caracter + " or " +
			  " ( ( substr(UPPER(a.titulo),1,1) not in (" + LETRAS +")" +
		      " and (substr(UPPER(a.titulo),2,1) " + caracter + " or (substr(UPPER(a.titulo),2,1)=' ' and substr(UPPER(a.titulo),3,1) " + caracter + " ))  ) ) )" +
			  " and a.activo = 'SI'	and a.id_disponibilidad in (select id_disponibilidad from disponibilidades where  pedido_especial = 'N' and id_esquema = 'PROD')" +
			  " and a.categoria_seccion not in 	( select categoria_seccion from estado_articulos where estado !='S'	 and categoria_seccion is not null" +
		      " and categoria_grupo is null and categoria_familia is null and categoria_subfamilia is null)	and a.categoria_grupo not in " +
			  " ( select categoria_grupo from estado_articulos where estado !='S' and categoria_seccion = a.categoria_seccion and categoria_grupo is not null" +
		      " and categoria_familia is null and categoria_subfamilia is null)	and a.categoria_familia not in ( select categoria_familia from estado_articulos" +
		      " where estado !='S' and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia is not null " +
		      " and categoria_subfamilia is null) and a.categoria_subfamilia not in ( select categoria_subfamilia from estado_articulos where estado !='S'" +
		      " and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia = a.categoria_familia" +
		      " and categoria_subfamilia is not null) and precio_venta_vigente >=( select importe_minimo from ( select importe_minimo from estado_articulos where categoria_seccion = 1" +
			  " and (categoria_grupo is null or categoria_grupo = 10) and (categoria_familia is null or categoria_familia = 1) and (categoria_subfamilia is null or categoria_subfamilia = 3)" +
			  " order by importe_minimo) where rownum =1) order by a.titulo";
		//System.out.println(qry);

		try {
			PreparedStatement statement = connection.prepareStatement(qry);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						ArticuloClass articulo = new ArticuloClass(resultSet.getInt("id_articulo"));
						articulo.setTitulo(resultSet.getString("titulo"));
						CategoriaPK categoriaPK = new CategoriaPK(new Integer [] {new Integer(resultSet.getInt("seccion")), new Integer(resultSet.getInt("grupo"))});
						articulo.setCategoria(CategoriaService.getCategoriaEspecifica(categoriaPK));
						/*Vector fila = new Vector(5);
						fila.add(resultSet.getString("id_articulo"));
						fila.add(resultSet.getString("titulo"));
						fila.add(resultSet.getString("seccion"));
						fila.add(resultSet.getString("grupo"));
						fila.add(resultSet.getString("descgrupo"));*/
 						temp.add(articulo);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return (ArticuloClass[]) temp.toArray(new ArticuloClass[temp.size()]);
	}

	private static String generarListado (String caracter, ArticuloClass[] articulos, int pagina) throws SQLException, NamingException{

			StringBuffer str = new StringBuffer("");

			int articuloInicial= 0;

			if(pagina==1){
				articuloInicial=0;
			}else{
				articuloInicial=getPosiscionUltimoArticulo();
			}

			setPosiscionUltimoArticulo(articuloInicial+15);

			int articuloFinal = getPosiscionUltimoArticulo();

			for (int i = articuloInicial; i<Math.min(articuloFinal,articulos.length); i++) {
				//Vector art = (Vector)articulos.get(i);
				try {
					str.append("<tr><td><table width=\"390\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\" class=\"mapaModProd\" >");

					str.append("<tr><td><table width=\"390\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">");

					str.append("<tr><td align=\"left\"><a href=\"").append(CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])).append("\" class=\"FProductosMusica\" > ").append(articulos[i].getTitulo()).append("</a></td></tr>");

					str.append("<tr><td align=\"left\"><a href=\"").append("/categorias/verFamilia.jsp?seccion=").append(articulos[i].getIdSeccion()).append("&grupo=").append(articulos[i].getIdGrupo()).append("\" class=\"Fautores\" >").append(articulos[i].getGrupo()).append("</a></td></tr>");

					str.append("</table></td></tr>");

					str.append("</table></td></tr>");
				} catch (Exception e) {
					TmkLogger.error("Generacion de Directorio, idArticulo=" + articulos[i].getIdArticulo() + " error=" + e.toString());
				}
			}

                int totalPaginas = getCantidadPaginas();

               	if (totalPaginas>1) {
               	str.append("<tr class=\"modulobuscador\">");
               	str.append("<td class=\"celdapaginas\">").append(Globals.ENTER);

               	int paginaActual = pagina;
               		if (paginaActual > 1) {

                         	str.append("<a href=\"/indice/index.jsp?letra=").append(caracter).append("&pagina=").append(paginaActual-1).append("\" class=\"FAyuda\">Anterior</a>");
                         	str.append("<span class=\"Ftexto05\"> | </span>").append(Globals.ENTER);
					}
					for (int x=Math.max(paginaActual-5, 1);
	    					x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {

	    				if (paginaActual == x) {

                        	str.append("<a href=\"/indice/index.jsp?letra=").append(caracter).append("&pagina=").append(x).append("\" class=\"FAyuda\"><b>").append(x).append("</b></a>").append(Globals.ENTER);
	    				} else {
	    					str.append("<a href=\"/indice/index.jsp?letra=").append(caracter).append("&pagina=").append(x).append("\" class=\"FAyuda\">").append(x).append("</a>").append(Globals.ENTER);
	    				}
					}

	                if ( paginaActual < totalPaginas) {
			                str.append("<span class=\"Ftexto05\"> | </span><a href=\"/indice/index.jsp?letra=").append(caracter).append("&pagina=").append(paginaActual+1).append("\" class=\"FAyuda\">Siguiente</a>").append(Globals.ENTER);
	                }
                         str.append("</td>");
                       str.append("</tr>");
               	}
				return str.toString();
	}


	public static void generarDirectorio() throws java.io.IOException, SQLException, NamingException {

		String saveDirectory = "\\directorio\\";

		String directorioDeContenidosEstaticos = Globals.GENERACION_DIRECTORIO;
	    try {
		     File fil = new File( Globals.GENERACION_DIRECTORIO);
		     Process proces = null;
		     if (fil.exists()) {
			    TmkLogger.debug("COMIENZA DESMAPEO");
			    try {
				    proces = Runtime.getRuntime().exec(Globals.GENERACION_SENTENCIA_DE_DESMAPEO);
			    } catch (Exception e) {
				    TmkLogger.error("DESMAPEO] No se genero el proceso");
				    throw new Exception("No se genero el proceso de desmapeo");
			    }
			    if (proces != null) {
				    boolean procesoActivo = true;
				    boolean procesoError = false;
				    while (procesoActivo) {
					    try {
						    if (proces.exitValue() != 0) {
							    procesoError = true;
						    }
						    procesoActivo = false;
					    } catch (Exception e) {

					    }
				    }
				    if (procesoError) {
					    TmkLogger.error("DESPMAPEO] fallo el proceso");
					    throw new Exception ("fallo el proceso de desmapeo");
				    }
				    TmkLogger.debug("DESMAPEO REALIZADO");
			    } else {
			      TmkLogger.error("DESMAPEO] No se genero el proceso");
			      throw new Exception ("No se genero el proceso de desmapeo");
			    }
		     } else {
		          TmkLogger.debug("DESMAPEO] No es necesario");

		     }
	         proces = null;
	         TmkLogger.debug("COMIENZA MAPEO");
		     try {
		        proces = Runtime.getRuntime().exec(Globals.GENERACION_SENTENCIA_DE_MAPEO);
		     } catch (Exception e) {
			     TmkLogger.error("MAPEO] No se genero el proceso");
			     throw new Exception("No se genero el proceso de mapeo");
		     }

		     if (proces != null) {
			    boolean procesoActivo = true;
			    boolean procesoError = false;
			    while (procesoActivo) {
				    try {
					    if (proces.exitValue() != 0) {
						    procesoError = true;
					    }
					    procesoActivo = false;
				    } catch (Exception e) {

				    }
			    }
			    if (procesoError) {
				    TmkLogger.error("MAPEO] fallo el proceso");
				    throw new Exception ("fallo el proceso de mapeo");
			    }
			    TmkLogger.debug("MAPEO REALIZADO");

		    } else {
			    TmkLogger.error("MAPEO] No se genero el proceso");
			    throw new Exception ("No se genero el proceso de mapeo");
		    }

	    } catch (Exception e) {
		    TmkLogger.debug("Error Contenidos Estaticos");
			MailUtil.sendMail(
			Globals.MAIL_MAILER,
			Globals.MAIL_WEBMASTER,
			"Generacion de Directorio.",
			"No se pudo generar el directorio." + e);
		    return;
	    }
        for (int i=0; i<CARACTERES_DE_GENERACION.length; i++) {

        		ArticuloClass[] articulos =  getTitulos (CARACTERES_DE_GENERACION[i]);

        		if (articulos == null || articulos.length==0) {

        			TmkLogger.debug(directorioDeContenidosEstaticos + saveDirectory + NOMBRE_LISTADO + NOMBRE_LISTADO_ADICIONAL[i] + 1 +"." + EXTENSION_LISTADO);

        	 		File fil = new File(directorioDeContenidosEstaticos + saveDirectory + NOMBRE_LISTADO + NOMBRE_LISTADO_ADICIONAL[i] + 1 + "." + EXTENSION_LISTADO);
        	 		FileWriter outs = new FileWriter(fil);
        	 		outs.write("");
        	 		outs.close();
    			}else{

    				setCantidadPaginas((int)Math.ceil((double)articulos.length/cantArticulosPorPagina));

    				for(int pagina=1; pagina <= getCantidadPaginas(); pagina++ ){

    					TmkLogger.debug(directorioDeContenidosEstaticos + saveDirectory + NOMBRE_LISTADO + NOMBRE_LISTADO_ADICIONAL[i] + pagina +"." + EXTENSION_LISTADO);

    					File fil = new File(directorioDeContenidosEstaticos + saveDirectory + NOMBRE_LISTADO + NOMBRE_LISTADO_ADICIONAL[i] + pagina + "." + EXTENSION_LISTADO);
    					FileWriter outs = new FileWriter(fil);
    					outs.write(Convert.toString(generarListado (NOMBRE_LISTADO_ADICIONAL[i], articulos, pagina), ""));
    					outs.close();
    				}
        	 	}
		}
	}
}
