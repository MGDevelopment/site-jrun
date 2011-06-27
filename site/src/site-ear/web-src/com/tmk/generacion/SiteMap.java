/* $Log*/

package com.tmk.generacion;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Globals;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.Contenido;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.MailUtil;



public class SiteMap {

	private static String tagSiteMapIndex = "<sitemapindex xmlns=\"http://www.google.com/schemas/sitemap/0.84\">";
	private static String tagSiteMapIndexC = "</sitemapindex>";
	private static String tagSiteMap = "<sitemap>";
	private static String tagSiteMapC =	"</sitemap>";

	private static String tagCabecera = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private static String tagUrlSet = "<urlset xmlns=\"http://www.google.com/schemas/sitemap/0.84\">";
	private static String tagUrlSetC = "</urlset>";
	private static String tagUrl = "<url>";
	private static String tagUrlC = "</url>";
	private static String tagLoc = "<loc>";
	private static String tagLocC = "</loc>";
	private static String prioridadDetalle = "<priority>0.9</priority>";
	private static String prioridadResto = "<priority>0.3</priority>";

	private static StringBuffer error = new StringBuffer("");
	//private static String archivoNuevo = "sitemap_tematikaNUMERO.nvo";
	private static String archivoActual = "sitemap_tematikaNUMERO.xml";
	//private static String archivoBackup = "sitemap_tematikaNUMERO.bak";



	//genera xml de los detalles
	public static void generarSiteMap() {
		StringBuffer data = new StringBuffer("");
	    int contadorUrl = 0;
		int numeroDeArchivo = 1;

		try {
			data.append(tagCabecera);
			data.append(tagUrlSet);
//			HOMES
			try {
				for (int i=0; i<Globals.SECCIONES.length; i++){
					if (Globals.seccionHabilitada(i)) {
						data.append(tagUrl + Globals.ENTER);
						data.append(tagLoc + Globals.ENTER);
						data.append("http://" + Globals.DOMINIO_SITIO + "/" + Globals.seccion(i) + Globals.ENTER);
						data.append(tagLocC +  Globals.ENTER);
						data.append(prioridadResto + Globals.ENTER);
						data.append(tagUrlC + Globals.ENTER);
						contadorUrl++;
					}
				}
			} catch (Exception e) {
				error.append("Homes. Error:").append(e.toString() + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			//FIN HOMES

			//RANKING
			try {

				for (int i=0; i<Contenido.getSite().getRanking().getRankingSeccion().length; i++){
						data.append(tagUrl + Globals.ENTER);
						data.append(tagLoc + Globals.ENTER);
						data.append("http://" + Globals.DOMINIO_SITIO + "/ranking/index.jsp?idSeccion=" + Contenido.getSite().getRanking().getRankingSeccion()[i].getId() + Globals.ENTER);
						data.append(tagLocC +  Globals.ENTER);
						data.append(prioridadResto + Globals.ENTER);
						data.append(tagUrlC + Globals.ENTER);
						contadorUrl++;
				}
			} catch (Exception e) {
				error.append("Ranking. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			//FIN RANKING

			//MAPA DE PRODUCTOS
			try {
				String LETRAS[] ={"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "N_", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "09"};
				for (int i=0; i<LETRAS.length; i++) {
					data.append(tagUrl + Globals.ENTER);
					data.append(tagLoc + Globals.ENTER);
					data.append("http://" + Globals.DOMINIO_SITIO + "/indice/index.jsp?letra=" + LETRAS[i] + Globals.ENTER);
					data.append(tagLocC +  Globals.ENTER);
					data.append(prioridadResto + Globals.ENTER);
					data.append(tagUrlC + Globals.ENTER);
					contadorUrl++;
				}
			} catch (Exception e) {
				error.append("Mapa de productos. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			// FIN MAPA DE PRODUCTOS

			//ENTREVISTAS
			try {
				File directorioDeEntrevistas = new File(Contenido.getServletContext().getRealPath("/asociadas/entrevistas"));
				File [] filEntrevistas = directorioDeEntrevistas.listFiles();
				for (int i=0; i<filEntrevistas.length; i++) {
					if (filEntrevistas[i].getName().indexOf(".txt")> -1) {
						if (contadorUrl == 50000) {
							data.append(tagUrlSetC);
							///Grabo el file
							MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
							data = new StringBuffer();
							contadorUrl = 0;
							numeroDeArchivo++;
							data.append(tagCabecera);
							data.append(tagUrlSet);
						}

						data.append(tagUrl + Globals.ENTER);
						data.append(tagLoc + Globals.ENTER);
						data.append("http://" + Globals.DOMINIO_SITIO + "/detalle/entrevistas.jsp?idArticulo=" + filEntrevistas[i].getName().replaceAll(".txt", "") + Globals.ENTER);
						data.append(tagLocC +  Globals.ENTER);
						data.append(prioridadResto + Globals.ENTER);
						data.append(tagUrlC + Globals.ENTER);
						contadorUrl++;
					}
				}
			} catch (Exception e) {
				error.append("Entrevistas. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			//FIN ENTREVISTAS

//			NOTAS DE PRENSA
			try {
				File directorioDeNotas = new File(Contenido.getServletContext().getRealPath("/asociadas/notasDePrensa"));
				File [] filNotas = directorioDeNotas.listFiles();
				for (int i=0; i<filNotas.length; i++) {
					if (filNotas[i].getName().indexOf(".txt")> -1 && filNotas[i].getName().indexOf("_") == -1) {
						if (contadorUrl == 50000) {
							data.append(tagUrlSetC);
//							/Grabo el file
							MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
							data = new StringBuffer();
							contadorUrl = 0;
							numeroDeArchivo++;
							data.append(tagCabecera);
							data.append(tagUrlSet);
						}
						data.append(tagUrl + Globals.ENTER);
						data.append(tagLoc + Globals.ENTER);
						data.append("http://" + Globals.DOMINIO_SITIO + "/detalle/notasPrensa.jsp?idArticulo=" + filNotas[i].getName().replaceAll(".txt", "") + Globals.ENTER);
						data.append(tagLocC +  Globals.ENTER);
						data.append(prioridadResto + Globals.ENTER);
						data.append(tagUrlC + Globals.ENTER);
						contadorUrl++;
					}
				}
			} catch (Exception e) {
				error.append("Notas de Prensa. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			//FIN NOTAS DE PRENSA

			//PRIMER CAPITULO - ARCHIVO
			try {
				File directorioPrimerCapitulo = new File(Contenido.getServletContext().getRealPath("/asociadas/capitulos"));
				File [] filCapitulo = directorioPrimerCapitulo.listFiles();
				for (int i=0; i<filCapitulo.length; i++) {
					if (filCapitulo[i].getName().indexOf(".txt")> -1) {
						if (contadorUrl == 50000) {
							data.append(tagUrlSetC);
//							/Grabo el file
							MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
							data = new StringBuffer();
							contadorUrl = 0;
							numeroDeArchivo++;
							data.append(tagCabecera);
							data.append(tagCabecera);
						}
						data.append(tagUrl + Globals.ENTER);
						data.append(tagLoc + Globals.ENTER);
						data.append("http://" + Globals.DOMINIO_SITIO + "/detalle/primerCapitulo.jsp?idArticulo=" + filCapitulo[i].getName().replaceAll(".txt", "") + Globals.ENTER);
						data.append(tagLocC +  Globals.ENTER);
						data.append(prioridadResto + Globals.ENTER);
						data.append(tagUrlC + Globals.ENTER);
						contadorUrl++;
					}
				}
			} catch (Exception e) {
				error.append("Primer Capitulo. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			//FIN PRIMER CAPITULO - ARCHIVO

		StringBuffer qry;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
//				PRIMER CAPITULO - BASE
				try {
					qry = new StringBuffer("");
					qry.append(Globals.ENTER).append(" select a.id_articulo");
					qry.append(Globals.ENTER).append(" from articulos a, articulos_textos ate");
					qry.append(Globals.ENTER).append(" where " );
					qry.append(Globals.ENTER).append(" 	a.id_articulo = ate.id_articulo");
					qry.append(Globals.ENTER).append(" 	and ate.tipo = '24'");
					qry.append(Globals.ENTER).append(" 	and ate.parte  = 1 ");
					qry.append(Globals.ENTER).append(" 	and ate.idioma = 'ES'");
					qry.append(Globals.ENTER).append(" 	and a. habilitado_tematika = 'S'");
					qry.append(Globals.ENTER).append(" 	and a.activo = 'SI'");
					qry.append(Globals.ENTER).append(" 	and a.id_disponibilidad in");
					qry.append(Globals.ENTER).append(" 		(select id_disponibilidad from disponibilidades where id_esquema = 'PROD')"); //
					qry.append(Globals.ENTER).append(" 			and a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(Globals.ENTER).append(" 	and a.categoria_grupo not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_grupo from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append(" 			and categoria_seccion = a.categoria_seccion and categoria_grupo is not null");
					qry.append(Globals.ENTER).append(" 			and categoria_familia is null and categoria_subfamilia is null)	");
					qry.append(Globals.ENTER).append(" 	and a.categoria_familia not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_familia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	 	 	and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia is not null");
					qry.append(Globals.ENTER).append("			and categoria_subfamilia is null) ");
					qry.append(Globals.ENTER).append(" 	and a.categoria_subfamilia not in ");
					qry.append(Globals.ENTER).append("		(select categoria_subfamilia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	  		 and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia = a.categoria_familia");
					qry.append(Globals.ENTER).append("			 and categoria_subfamilia is not null) ");
					qry.append(Globals.ENTER).append(" 	and precio_venta_vigente >= ");
					qry.append(Globals.ENTER).append("		(select nvl(min(importe_minimo), 0) from estado_articulos where categoria_seccion = a.categoria_seccion");
					qry.append(Globals.ENTER).append("			  and (categoria_grupo is null or categoria_grupo = a.categoria_grupo) ");
					qry.append(Globals.ENTER).append("			  and (categoria_familia is null or categoria_familia = a.categoria_familia)");
					qry.append(Globals.ENTER).append("			  and (categoria_subfamilia is null or categoria_subfamilia = a.categoria_subfamilia))");

					PreparedStatement st = conn.prepareStatement(qry.toString());

					try {
						ResultSet rs = st.executeQuery();
						try {
							while (rs.next()) {
								if (contadorUrl == 50000) {
									data.append(tagUrlSetC);
									///Grabo el file
									MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
									data = new StringBuffer();
									contadorUrl = 0;
									numeroDeArchivo++;
									data.append(tagCabecera);
									data.append(tagUrlSet);
								}
								data.append(tagUrl + Globals.ENTER);
								data.append(tagLoc + Globals.ENTER);
								data.append("http://" + Globals.DOMINIO_SITIO + "/detalle/primerCapitulo.jsp?idArticulo=" + rs.getInt("id_articulo") + Globals.ENTER);
								data.append(tagLocC + Globals.ENTER);
								data.append(prioridadResto + Globals.ENTER);
								data.append(tagUrlC + Globals.ENTER);
								contadorUrl++;
							}
						} catch (Exception e) {
							error.append("Recorrido de rs primer capitulo. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						error.append("Ejecucion de st primer capitulo. Error:").append(e.toString()  + MainHelper.getMessage(e));
						error.append(Globals.ENTER).append(qry).append(Globals.ENTER);
					} finally {
						st.close();
					}
				} catch (Exception e) {
					error.append("Armado de qry primer capitulo. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
				}
//				FIN PRIMER CAPITULO - BASE

//				INDICES DE CONTENIDO
				try {
					qry = new StringBuffer("");
					qry.append(Globals.ENTER).append(" select a.id_articulo");
					qry.append(Globals.ENTER).append(" from articulos a, articulos_textos ate");
					qry.append(Globals.ENTER).append(" where " );
					qry.append(Globals.ENTER).append(" 	a.id_articulo = ate.id_articulo");
					qry.append(Globals.ENTER).append(" 	and ate.tipo = '04'");
					qry.append(Globals.ENTER).append(" 	and ate.parte  = 1 ");
					qry.append(Globals.ENTER).append(" 	and ate.idioma = 'ES'");
					qry.append(Globals.ENTER).append(" 	and a. habilitado_tematika = 'S'");
					qry.append(Globals.ENTER).append(" 	and a.activo = 'SI'");
					qry.append(Globals.ENTER).append(" 	and a.id_disponibilidad in");
					qry.append(Globals.ENTER).append(" 		(select id_disponibilidad from disponibilidades where id_esquema = 'PROD')");
					qry.append(Globals.ENTER).append(" 	and a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(Globals.ENTER).append(" 	and a.categoria_grupo not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_grupo from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append(" 			and categoria_seccion = a.categoria_seccion and categoria_grupo is not null");
					qry.append(Globals.ENTER).append(" 			and categoria_familia is null and categoria_subfamilia is null)	");
					qry.append(Globals.ENTER).append(" 	and a.categoria_familia not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_familia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	 	 	and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia is not null");
					qry.append(Globals.ENTER).append("			and categoria_subfamilia is null) ");
					qry.append(Globals.ENTER).append(" 	and a.categoria_subfamilia not in ");
					qry.append(Globals.ENTER).append("		(select categoria_subfamilia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	  		 and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia = a.categoria_familia");
					qry.append(Globals.ENTER).append("			 and categoria_subfamilia is not null) ");
					qry.append(Globals.ENTER).append(" 	and precio_venta_vigente >= ");
					qry.append(Globals.ENTER).append("		(select nvl(min(importe_minimo), 0) from estado_articulos where categoria_seccion = a.categoria_seccion");
					qry.append(Globals.ENTER).append("			  and (categoria_grupo is null or categoria_grupo = a.categoria_grupo) ");
					qry.append(Globals.ENTER).append("			  and (categoria_familia is null or categoria_familia = a.categoria_familia)");
					qry.append(Globals.ENTER).append("			  and (categoria_subfamilia is null or categoria_subfamilia = a.categoria_subfamilia))");

					PreparedStatement st = conn.prepareStatement(qry.toString());

					try {
						ResultSet rs = st.executeQuery();
						try {
							while (rs.next()) {
								if (contadorUrl == 50000) {
									data.append(tagUrlSetC);
									///Grabo el file
									MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
									data = new StringBuffer();
									contadorUrl = 0;
									numeroDeArchivo++;

									data.append(tagCabecera);
									data.append(tagUrlSet);

								}
								data.append(tagUrl + Globals.ENTER);
								data.append(tagLoc + Globals.ENTER);
								data.append("http://" + Globals.DOMINIO_SITIO + "/articulo/indiceDeContenidos.jsp?idArticulo=" + rs.getInt("id_articulo") + Globals.ENTER);
								data.append(tagLocC + Globals.ENTER);
								data.append(prioridadResto + Globals.ENTER);
								data.append(tagUrlC + Globals.ENTER);
								contadorUrl++;
							}
						} catch (Exception e) {
							error.append("Recorrido de rs indices de contenido. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						error.append("Ejecucion de st indices de contenido. Error:").append(e.toString()  + MainHelper.getMessage(e));
						error.append(Globals.ENTER).append(qry).append(Globals.ENTER);
					} finally {
						st.close();
					}
				} catch (Exception e) {
					error.append("Armado de qry indices de contenido. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
				}
				// FIN INDICES DE CONTENIDO

//				BIOGRAFIAS
				try {
					qry = new StringBuffer("");
					qry.append(Globals.ENTER).append(" select a.id_articulo, aab.id_autor");
					qry.append(Globals.ENTER).append(" from articulos a, articulos_autores_biografia aab");
					qry.append(Globals.ENTER).append(" where " );
					qry.append(Globals.ENTER).append(" 	a.id_articulo = aab.id_articulo");
					qry.append(Globals.ENTER).append(" 	and a. habilitado_tematika = 'S'");
					qry.append(Globals.ENTER).append(" 	and a.activo = 'SI'");
					qry.append(Globals.ENTER).append(" 	and a.id_disponibilidad in");
					qry.append(Globals.ENTER).append(" 		(select id_disponibilidad from disponibilidades where id_esquema = 'PROD')"); //
					qry.append(Globals.ENTER).append(" 	and a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(Globals.ENTER).append(" 	and a.categoria_grupo not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_grupo from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append(" 			and categoria_seccion = a.categoria_seccion and categoria_grupo is not null");
					qry.append(Globals.ENTER).append(" 			and categoria_familia is null and categoria_subfamilia is null)	");
					qry.append(Globals.ENTER).append(" 	and a.categoria_familia not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_familia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	 	 	and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia is not null");
					qry.append(Globals.ENTER).append("			and categoria_subfamilia is null) ");
					qry.append(Globals.ENTER).append(" 	and a.categoria_subfamilia not in ");
					qry.append(Globals.ENTER).append("		(select categoria_subfamilia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	  		 and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia = a.categoria_familia");
					qry.append(Globals.ENTER).append("			 and categoria_subfamilia is not null) ");
					qry.append(Globals.ENTER).append(" 	and precio_venta_vigente >= ");
					qry.append(Globals.ENTER).append("		(select nvl(min(importe_minimo), 0) from estado_articulos where categoria_seccion = a.categoria_seccion");
					qry.append(Globals.ENTER).append("			  and (categoria_grupo is null or categoria_grupo = a.categoria_grupo) ");
					qry.append(Globals.ENTER).append("			  and (categoria_familia is null or categoria_familia = a.categoria_familia)");
					qry.append(Globals.ENTER).append("			  and (categoria_subfamilia is null or categoria_subfamilia = a.categoria_subfamilia))");

					PreparedStatement st = conn.prepareStatement(qry.toString());

					try {
						ResultSet rs = st.executeQuery();
						try {
							while (rs.next()) {
								if (contadorUrl == 50000) {
									data.append(tagUrlSetC);
									///Grabo el file
									MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
									data = new StringBuffer();
									contadorUrl = 0;
									numeroDeArchivo++;
									data.append(tagCabecera);
									data.append(tagUrlSet);
								}
								data.append(tagUrl + Globals.ENTER);
								data.append(tagLoc + Globals.ENTER);
								data.append("http://" + Globals.DOMINIO_SITIO + "/detalle/biografias.jsp?idArticulo=" + rs.getInt("id_articulo") + "&amp;idAutor=" + rs.getInt("id_autor") + Globals.ENTER);
								data.append(tagLocC + Globals.ENTER);
								data.append(prioridadResto + Globals.ENTER);
								data.append(tagUrlC + Globals.ENTER);
								contadorUrl++;
							}
						} catch (Exception e) {
							error.append("Recorrido de rs biografias. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						error.append("Ejecucion de st biografias. Error:").append(e.toString()  + MainHelper.getMessage(e));
						error.append(Globals.ENTER).append(qry).append(Globals.ENTER);
					} finally {
						st.close();
					}
				} catch (Exception e) {
					error.append("Armado de qry biografias. Error:").append(e.toString()  + MainHelper.getMessage(e)).append(Globals.ENTER);
				}
				//BIOGRAFIAS



				//DETALLE DE ARTICULO
				try {
					qry = new StringBuffer("");
					qry.append(Globals.ENTER).append(" select a.id_articulo, a.titulo, categoria_seccion, categoria_grupo, categoria_familia, categoria_subfamilia");
					qry.append(Globals.ENTER).append(" from articulos a");
					qry.append(Globals.ENTER).append(" where a. habilitado_tematika = 'S'");
					qry.append(Globals.ENTER).append(" 	and a.activo = 'SI'");
					qry.append(Globals.ENTER).append(" 	and a.id_disponibilidad in");
					qry.append(Globals.ENTER).append(" 		(select id_disponibilidad from disponibilidades where id_esquema = 'PROD')");
					qry.append(Globals.ENTER).append("	and a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
					qry.append(Globals.ENTER).append(" 	and a.categoria_grupo not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_grupo from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append(" 			and categoria_seccion = a.categoria_seccion and categoria_grupo is not null");
					qry.append(Globals.ENTER).append(" 			and categoria_familia is null and categoria_subfamilia is null)	");
					qry.append(Globals.ENTER).append(" 	and a.categoria_familia not in ");
					qry.append(Globals.ENTER).append(" 		(select categoria_familia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	 	 	and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia is not null");
					qry.append(Globals.ENTER).append("			and categoria_subfamilia is null) ");
					qry.append(Globals.ENTER).append(" 	and a.categoria_subfamilia not in ");
					qry.append(Globals.ENTER).append("		(select categoria_subfamilia from estado_articulos where estado !='S'");
					qry.append(Globals.ENTER).append("	  		 and categoria_seccion = a.categoria_seccion and categoria_grupo = a.categoria_grupo and categoria_familia = a.categoria_familia");
					qry.append(Globals.ENTER).append("			 and categoria_subfamilia is not null) ");
					qry.append(Globals.ENTER).append(" 	and precio_venta_vigente >= ");
					qry.append(Globals.ENTER).append("		(select nvl(min(importe_minimo), 0) from estado_articulos where categoria_seccion = a.categoria_seccion");
					qry.append(Globals.ENTER).append("			  and (categoria_grupo is null or categoria_grupo = a.categoria_grupo) ");
					qry.append(Globals.ENTER).append("			  and (categoria_familia is null or categoria_familia = a.categoria_familia)");
					qry.append(Globals.ENTER).append("			  and (categoria_subfamilia is null or categoria_subfamilia = a.categoria_subfamilia))");

					PreparedStatement st = conn.prepareStatement(qry.toString());

					try {
						ResultSet rs = st.executeQuery();
						try {
							while (rs.next()) {
								if (contadorUrl == 50000) {
									data.append(tagUrlSetC);
									///Grabo el file
									MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
									data = new StringBuffer();
									contadorUrl = 0;
									numeroDeArchivo++;
									data.append(tagCabecera);
									data.append(tagUrlSet);
								}
								try {
								data.append(tagUrl + Globals.ENTER);
								data.append(tagLoc + Globals.ENTER);
								ArticuloClass articulo = new ArticuloClass(rs.getInt("id_articulo"));
								articulo.setTitulo(rs.getString("titulo"));
								CategoriaPK categoriaPK = new CategoriaPK(new Integer[]{new Integer(rs.getInt("categoria_seccion")),
																						new Integer(rs.getInt("categoria_grupo")),
																						new Integer(rs.getInt("categoria_familia")),
																						new Integer(rs.getInt("categoria_subfamilia"))});
								articulo.setCategoria(CategoriaService.getCategoriaEspecifica(categoriaPK));
								data.append("http://" + Globals.DOMINIO_SITIO + CategoriaService.getURL(articulo.getCategoria()) + ArticuloManager.getURL(articulo) + Globals.ENTER);
								data.append(tagLocC + Globals.ENTER);
								data.append(prioridadDetalle + Globals.ENTER);
								data.append(tagUrlC + Globals.ENTER);
								} catch(Exception e) {
									TmkLogger.debug("Site Map] generador " + e.toString()  + MainHelper.getMessage(e) + " idArticulo:" + rs.getInt("id_articulo"));
								}
								contadorUrl++;
							}
						} catch (Exception e) {
							error.append("Recorrido de rs detalles. Error:").append(e.toString() + MainHelper.getMessage(e)).append(Globals.ENTER);
						} finally {
							rs.close();
						}
					} catch (Exception e) {
						error.append("Ejecucion de st detalles. Error:").append(e.toString() + MainHelper.getMessage(e));
						error.append(Globals.ENTER).append(qry).append(Globals.ENTER);
					} finally {
						st.close();
					}
				} catch (Exception e) {
					error.append("Armado de qry detalles. Error:").append(e.toString() + MainHelper.getMessage(e)).append(Globals.ENTER);
				}
				//FIN DETALLE DE ARTICULO



			} finally {
				conn.close();
			}
		} catch (Exception e) {
			error.append("En coneccion. Error:").append(e.toString() + MainHelper.getMessage(e)).append(Globals.ENTER);
		}
//			RECORRIDO - GRUPOS
			try {
				Categoria[] seccion = CategoriaService.categoria;
				for (int i=0; i<seccion.length;i++) {
					Categoria[] grupo = seccion[i].getSubCategoria();
					for (int j=0; j<grupo.length; j++) {
						Categoria[] familia = grupo[j].getSubCategoria();
						for (int k=0; k<familia.length; k++) {
							if (contadorUrl == 50000) {
								data.append(tagUrlSetC);
								///Grabo el file
								MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
								data = new StringBuffer();
								contadorUrl = 0;
								numeroDeArchivo++;

								data.append(tagCabecera);
								data.append(tagUrlSet);
							}
							StringBuffer aux = new StringBuffer();
							try {
								aux.append(tagUrl).append(Globals.ENTER);
								aux.append(tagLoc).append(Globals.ENTER);
								aux.append("http://").append(Globals.DOMINIO_SITIO).append("/catalogo");
								aux.append(CategoriaService.getURL(CategoriaService.getCategoriaEspecifica(familia[k].getCategoriaPK()))).append(".htm");
								aux.append(Globals.ENTER);
								aux.append(tagLocC).append(Globals.ENTER);
								aux.append(prioridadResto).append(Globals.ENTER);
								aux.append(tagUrlC).append(Globals.ENTER);
								data.append(aux.toString());
								contadorUrl++;
							} catch(Exception e) {
								error.append("Error recorrido de familias pk ").append(familia[k].getCategoriaPK()).append(e.toString()).append(MainHelper.getMessage(e)).append(Globals.ENTER);
							}
						}

						if (contadorUrl == 50000) {
							data.append(tagUrlSetC);
							///Grabo el file
							MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
							data = new StringBuffer();
							contadorUrl = 0;
							numeroDeArchivo++;
							data.append(tagCabecera);
							data.append(tagUrlSet);
						}
						StringBuffer aux = new StringBuffer();
						try {
							aux.append(tagUrl).append(Globals.ENTER);
							aux.append(tagLoc).append(Globals.ENTER);
							aux.append("http://").append(Globals.DOMINIO_SITIO).append("/catalogo");
							aux.append(CategoriaService.getURL(CategoriaService.getCategoriaEspecifica(grupo[j].getCategoriaPK()))).append(".htm");
							aux.append(Globals.ENTER);
							aux.append(tagLocC).append(Globals.ENTER);
							aux.append(prioridadResto).append(Globals.ENTER);
							aux.append(tagUrlC).append(Globals.ENTER);
							data.append(aux.toString());
							contadorUrl++;
						} catch(Exception e) {
							error.append("Error recorrido de familias pk ").append(grupo[j].getCategoriaPK()).append(e.toString()).append(MainHelper.getMessage(e) ).append(Globals.ENTER);
						}
					}
				}
			} catch (Exception e) {
				error.append("Error recorrido de familias").append(e.toString()).append(MainHelper.getMessage(e)).append(Globals.ENTER);
			}
			// FIN RECORRIDO - GRUPOS
			data.append(tagUrlSetC);
			///Grabo el file
			MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
			data = new StringBuffer();
			MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""+numeroDeArchivo), data.toString(), "appRaiz");
			if (error.toString().equals("")) {
				data.append(tagCabecera);
				data.append(tagSiteMapIndex);

				for (int i=0; i<numeroDeArchivo; i++) {
					data.append(tagSiteMap);
					data.append(Globals.ENTER);
					data.append(tagLoc);
					data.append(Globals.ENTER);
					data.append("http://" + Globals.DOMINIO_SITIO + "/" + archivoActual.replaceAll("NUMERO", ""+(i+1)));
					data.append(Globals.ENTER);
					data.append(tagLocC);
					data.append(Globals.ENTER);
					data.append(tagSiteMapC);
					data.append(Globals.ENTER);
				}
				data.append(tagSiteMapIndexC);
				MainHelper.saveFileNet(archivoActual.replaceAll("NUMERO", ""), data.toString(), "appRaiz");
				data = new StringBuffer();
			}
		} catch (Exception e) {
			error.append("Manejo de Archivo. Error:" + e.toString() + MainHelper.getMessage(e)).append(Globals.ENTER);
		} finally  {
			if (!error.toString().equals("")) {
				TmkLogger.error("SiteMap: " + error.toString());
				MailUtil.sendMail(Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Generacion de SiteMap.",
					"No se genero el SiteMap. Error: " + error.toString()
					);
			}
		}
	}

/*	public boolean pausada() {
		return Globals.baseDeDatosEnMantenimiento()
		|| CategoriaService.categoria == null
		|| Calendar.getInstance().get(Calendar.HOUR_OF_DAY) != 6
		|| Calendar.getInstance().get(Calendar.DATE) != 6;
	}*/
}
