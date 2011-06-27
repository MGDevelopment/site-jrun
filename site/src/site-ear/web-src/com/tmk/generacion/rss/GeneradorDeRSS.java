package com.tmk.generacion.rss;


import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Hashtable;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import com.tmk.bus.articulo.ArticuloClass;
import com.tmk.bus.articulo.ArticuloManager;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.setup.Contenido;
import com.tmk.util.HTML.Template;
import com.tmk.xml.rss.Item;

public class GeneradorDeRSS{


	private static String setPlantillaRSS(String channelTitle, String channelLink, String channelDescription,
		String channelCopyright, String imageTitle, String imageUrl,
		String imageLink, String categoryDomain, String language,
		String generator) throws Exception {

		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
		MainHelper.RES_TMPL_PATH + "/generacion/rss.htm"));
		Template t = new com.tmk.util.HTML.Template(args);
		t.setParam("channelTitle", channelTitle);
		t.setParam("channelLink", channelLink);
		t.setParam("channelDescription", channelDescription);
		t.setParam("channelCopyright", channelCopyright);
		SimpleDateFormat RFC822DateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", java.util.Locale.ENGLISH);
		Date date = new Date();
		t.setParam("channelPubDate", RFC822DateFormat.format(date));
		t.setParam("imageTitle", imageTitle);
		t.setParam("imageUrl", imageUrl);
		t.setParam("imageLink", imageLink);
		t.setParam("categoryDomain", categoryDomain);
		t.setParam("category", RFC822DateFormat.format(date));
		t.setParam("language", language);
		t.setParam("generator", generator);
		return t.output();
	}

	private static void saveRSSFile(File origen) throws Exception {
		MainHelper.saveExistingFileNet("/rss/" + origen.getName(), origen.getPath(), "appRaiz");

	}

	/*----------------------------------------FIN COMUNES----------------------------------------*/



	/*------------------------------------INI OBTENCION DE DATOS---------------------------------*/
	//Graba en el stream en un archivo local
	private static FileWriter saveArticulosBySeccionFecha(CategoriaPK categoriaPK, int dias, FileWriter outs, boolean esAlianza) throws Exception {
		StringBuffer qry = new StringBuffer();
		//StringBuffer xmlItem = new StringBuffer("");

		switch (categoriaPK.getPK()[0].intValue()) {
			case Globals.SECCION_LIBRO: {
				qry.append(" SELECT a.id_articulo, a.titulo, aut.id_autor, nvl(aut.descripcion2,aut.descripcion) autor, a.id_editor, ed.nombre editorial,");
				qry.append(" 	NVL (TO_NUMBER (ate.parte), 1) partesinop, ate.texto textosinop,");
				qry.append(" 	a.fecha_alta, a.categoria_seccion, a.categoria_grupo, a.categoria_familia,");
				qry.append(" 	a.categoria_subfamilia, aa.orden, aa.ROLE");
				qry.append(" FROM articulos a ");
				qry.append(" 	LEFT JOIN articulos_autores aa");
				qry.append(" 		ON a.id_articulo = aa.id_articulo AND aa.ROLE IN ('A01', 'C01')");
				qry.append(" 	LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
				qry.append(" 	LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
				qry.append(" 	LEFT JOIN articulos_textos ate ON a.id_articulo = ate.id_articulo");
				qry.append(" 		AND ate.tipo = '01'");
				qry.append(" 		AND ate.idioma = 'ES'");
				qry.append(" WHERE ");
				qry.append("    a.categoria_seccion = ").append(Globals.SECCION_LIBRO);
				if (categoriaPK.getPK().length>1) {
					qry.append(" AND a. categoria_grupo = ").append(categoriaPK.getPK()[1].intValue());
				}
				if (categoriaPK.getPK().length>2) {
					qry.append(" AND a. categoria_familia = ").append(categoriaPK.getPK()[2].intValue());
				}
				if (categoriaPK.getPK().length>3) {
					qry.append(" AND a. categoria_subfamilia = ").append(categoriaPK.getPK()[3].intValue());
				}

				if (dias > 0) {
					qry.append(" AND a.fecha_alta > SYSDATE - ").append(dias);
				}
				qry.append(" 	AND a.habilitado_tematika = 'S'");
				qry.append(" ORDER BY a.fecha_alta, a.id_articulo, ate.parte, aa.orden");
				break;
			}
			case Globals.SECCION_JUGUETES: {
				qry.append(" SELECT a.id_articulo, a.titulo, aut.id_autor, aut.descripcion autor, a.id_editor, ed.nombre editorial,");
				qry.append(" 	NVL (TO_NUMBER (ate.parte), 1) partesinop, ate.texto textosinop,");
				qry.append(" 	a.fecha_alta, a.categoria_seccion, a.categoria_grupo, a.categoria_familia,");
				qry.append(" 	a.categoria_subfamilia, aa.orden, aa.ROLE");
				qry.append(" FROM articulos a LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
				qry.append(" 	LEFT JOIN articulos_autores aa");
				qry.append(" 		ON a.id_articulo = aa.id_articulo");
				qry.append(" 		AND (aa.ROLE = 'A01' OR aa.ROLE = 'A09')");
				qry.append(" 	LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
				qry.append(" 	LEFT JOIN articulos_textos ate");
				qry.append(" 		ON a.id_articulo = ate.id_articulo");
				qry.append(" 		AND ate.tipo = '01'");
				qry.append(" 		AND ate.idioma = 'ES'");
				qry.append(" WHERE ");
				qry.append("    a.categoria_seccion = ").append(Globals.SECCION_JUGUETES);
				if (categoriaPK.getPK().length>1) {
					qry.append(" AND a. categoria_grupo = ").append(categoriaPK.getPK()[1].intValue());
				}
				if (categoriaPK.getPK().length>2) {
					qry.append(" AND a. categoria_familia = ").append(categoriaPK.getPK()[2].intValue());
				}
				if (categoriaPK.getPK().length>3) {
					qry.append(" AND a. categoria_subfamilia = ").append(categoriaPK.getPK()[3].intValue());
				}

				if (dias > 0) {
					qry.append(" AND a.fecha_alta > SYSDATE - ").append(dias);
				}
				qry.append(" 	AND a.habilitado_tematika = 'S'");
				qry.append(" ORDER BY a.fecha_alta, a.id_articulo,  ate.parte, aa.orden");
				break;
			}
			case Globals.SECCION_MUSICA: {
				qry.append(" SELECT a.id_articulo, a.titulo, aut.id_autor, aut.descripcion autor, a.id_editor, ed.nombre editorial,");
				qry.append(" 	NVL (atm.nro_tema, NVL (TO_NUMBER (ate.parte), 1)) partesinop,");
				qry.append(" 	NVL (atm.nombre, REPLACE (ate.texto, CHR (10), '<br>')) textosinop,");
				qry.append(" 	a.fecha_alta, a.categoria_seccion, a.categoria_grupo, a.categoria_familia,");
				qry.append(" 	a.categoria_subfamilia, aa.orden, aa.ROLE");
				qry.append(" FROM articulos a ");
				qry.append(" 	LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
				qry.append(" 	LEFT JOIN articulos_autores aa ON a.id_articulo = aa.id_articulo AND aa.ROLE = 'A01'");
				qry.append(" 	LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
				qry.append(" 	LEFT JOIN articulos_textos ate ON a.id_articulo = ate.id_articulo AND ate.tipo = '01'");
				qry.append(" 	LEFT JOIN articulos_temas_musicales atm ON a.id_articulo = atm.id_articulo");
				qry.append(" 	LEFT JOIN tipos_articulos ta ON a.id_tipo_articulo = ta.id_tipo_articulo");
				qry.append(" WHERE ");
				qry.append("    a.categoria_seccion = ").append(Globals.SECCION_MUSICA);
				if (categoriaPK.getPK().length>1) {
					qry.append(" AND a. categoria_grupo = ").append(categoriaPK.getPK()[1].intValue());
				}
				if (categoriaPK.getPK().length>2) {
					qry.append(" AND a. categoria_familia = ").append(categoriaPK.getPK()[2].intValue());
				}
				if (categoriaPK.getPK().length>3) {
					qry.append(" AND a. categoria_subfamilia = ").append(categoriaPK.getPK()[3].intValue());
				}

				if (dias > 0) {
					qry.append(" AND a.fecha_alta > SYSDATE - ").append(dias);
				}
				qry.append(" 	AND a.habilitado_tematika = 'S'");
				qry.append(" ORDER BY a.fecha_alta, a.id_articulo, nro_tema, ate.parte, aa.orden");
				break;
			}
			case Globals.SECCION_PELICULA: {
				qry.append(" SELECT a.id_articulo, a.titulo, aut.id_autor, aut.descripcion autor, a.id_editor, ed.nombre editorial,");
				qry.append(" 	NVL (TO_NUMBER (ate.parte), 1) partesinop, ate.texto textosinop, aa.orden, a.categoria_seccion,");
				qry.append(" 	a.fecha_alta, a.categoria_seccion, a.categoria_grupo, a.categoria_familia,");
				qry.append(" 	a.categoria_subfamilia, aa.orden, aa.ROLE");
				qry.append(" FROM articulos a");
				qry.append(" 	LEFT JOIN editores ed ON a.id_editor = ed.id_editor");
				qry.append(" 	LEFT JOIN articulos_autores aa ON a.id_articulo = aa.id_articulo AND aa.ROLE = 'D02'");
				qry.append(" 	LEFT JOIN autores aut ON aa.id_autor = aut.id_autor");
				qry.append(" 	LEFT JOIN articulos_textos ate");
				qry.append(" 	ON a.id_articulo = ate.id_articulo AND ate.tipo = '01'");
				qry.append(" WHERE ");
				qry.append("    a.categoria_seccion = ").append(Globals.SECCION_PELICULA);
				if (categoriaPK.getPK().length>1) {
					qry.append(" AND a. categoria_grupo = ").append(categoriaPK.getPK()[1].intValue());
				}
				if (categoriaPK.getPK().length>2) {
					qry.append(" AND a. categoria_familia = ").append(categoriaPK.getPK()[2].intValue());
				}
				if (categoriaPK.getPK().length>3) {
					qry.append(" AND a. categoria_subfamilia = ").append(categoriaPK.getPK()[3].intValue());
				}

				if (dias > 0) {
					qry.append(" AND a.fecha_alta > SYSDATE - ").append(dias);
				}
				qry.append(" 	AND a.habilitado_tematika = 'S'");
				qry.append(" ORDER BY a.fecha_alta, a.id_articulo, partesinop,   aa.orden ");
				break;
			}
		}

		Connection conn = DBUtil.buildConnection();
		try {
			Statement st = conn.createStatement();
			try {
				ResultSet rs = st.executeQuery(qry.toString());
				try {
					//Iterator it = MainHelper.getRs(qry.toString());
					//TmkLogger.debug("Qry Ejecutado con exito");
				 	//Vector aux = new Vector();
					//int i = 0;
					ArticuloClass articulo = new ArticuloClass(-1);
					Item item = new Item();
					int idArticuloAnt = 0; //para corte de control
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
					com.thoughtworks.xstream.XStream xstream = new XStream(new DomDriver());
					xstream.alias("item", Item.class );
					xstream.registerConverter(new com.tmk.xml.converter.RFC822DateConverter(java.util.Locale.ENGLISH));
					//int contador=0;
					int i = 0;
					while (rs.next()) {
						//TmkLogger.debug("articulo " + i);
						//DynaBean dyn = (DynaBean) it.next();
						if (rs.getInt("id_articulo")
						 		!= idArticuloAnt) {
							if (articulo.getIdArticulo() != -1) {
								item = new Item(articulo);
								if (esAlianza) {
									item.setAlianzaTag(articulo);
								}
								outs.write(xstream.toXML(item).replaceAll("publisher", "tmk:publisher"));
								//xmlItem.append(xstream.toXML(item).replaceAll("publisher", "tmk:publisher"));
								//aux.add(item);
							}
							articulo = new ArticuloClass( rs.getInt("id_articulo"));
							articulo.setTitulo(rs.getString("titulo"));
							articulo.setEditorial(rs.getString("editorial"));
							CategoriaPK catPK = new CategoriaPK (new Integer[]{
											new Integer(rs.getInt("categoria_seccion")),
											new Integer(rs.getInt("categoria_grupo")),
											new Integer(rs.getInt("categoria_familia")),
											new Integer(rs.getInt("categoria_subfamilia"))
										});
							articulo.setCategoria(CategoriaService.getCategoriaEspecifica(catPK));
							articulo.setFechaAlta(dateFormat.parse(rs.getString("fecha_alta")));
						}
						if (rs.getString("autor") != null) {
							if (rs.getString("role").toString().equals("C01")) {
								articulo.setCompilador(rs.getInt("id_autor"), rs.getString("autor"));
							} else {
								articulo.setAutor(rs.getInt("id_autor"), rs.getString("autor"));
							}
						}
						if (rs.getString("textosinop") != null) {
							articulo.setSinopsis(rs.getInt("partesinop"), rs.getString("textosinop"));
						}


						//<![CDATA[

						idArticuloAnt = articulo.getIdArticulo();
						i++;
					}
					if (i>0) {
						item = new Item(articulo);
						if (esAlianza) {
							item.setAlianzaTag(articulo);
						}
						outs.write(xstream.toXML(item).replaceAll("publisher", "tmk:publisher"));
						//xmlItem.append(xstream.toXML(item).replaceAll("publisher", "tmk:publisher"));
					}

				} finally {
					rs.close();
				}
			} finally {
				st.close();
			}
		} finally {
			conn.close();
		}


		return outs;
 	}

	private static FileWriter saveArticulosMasVendidosBySeccion(int idSeccion, int cantidad, FileWriter outs) throws Exception{
		ArticuloClass articulos [] = ArticuloManager. getArticulosParaTopExtend (idSeccion, -1, -1, cantidad);
		Item item = null;
		com.thoughtworks.xstream.XStream xstream = new XStream(new DomDriver());
		xstream.alias("item", Item.class );
		xstream.registerConverter(new com.tmk.xml.converter.RFC822DateConverter(java.util.Locale.ENGLISH));
		for (int i=0; i<articulos.length; i++) {
			item = new Item(articulos[i]);
			outs.write(xstream.toXML(item).replaceAll("publisher", "tmk:publisher"));
		}
		return outs;
	}

	/*---------------------------------FIN OBTENCION DE DATOS------------------------------------*/


	/*-------------------------------------INI GENERADORES---------------------------------------*/
	public static void generadorDeNovedades() throws Exception {
		Categoria categorias[] = CategoriaService.categoria;

		int diasNovedad = 7;
		for (int i=0; i<categorias.length; i++) {
			String seccionDescripcion = Convert.capitalizar(categorias[i].getDescripcion(),
											false);

			String streamRSS = setPlantillaRSS("Tematika.com - Novedades"
					,"http://" + Globals.DOMINIO_SITIO + "/rss/index.jsp"
					,"Ultimas novedades de " + seccionDescripcion + " en Tematika.com"
					,"Tematika.com - All rights reserved"
					,"Tematika.com - Novedades " + seccionDescripcion
					,"http://" +  Globals.DOMINIO_SITIO + "/imagenes/Logo-Tematika.gif"
					,"http://" +  Globals.DOMINIO_SITIO + "/index.jsp"
					,seccionDescripcion
					,"es-ar"
					,"Exportador de Novedades de " + seccionDescripcion + " RSS Tematika.com"
					);
			File file = new File(Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_AUX_DATA)
					+ "novedades" + seccionDescripcion + ".xml");
			FileWriter outs = new FileWriter(file);
			outs.write(streamRSS);
			outs = saveArticulosBySeccionFecha(
					categorias[i].getCategoriaPK(), diasNovedad, outs, false);
			outs.write("</channel></rss>");
			outs.close();
			saveRSSFile(file);
		}

		for (int i=0; i<categorias.length; i++) {
			String seccionDescripcion = Convert.capitalizar(categorias[i].getDescripcion(),
											false);

			String streamRSS = setPlantillaRSS("Tematika.com - Novedades"
					,"http://" + Globals.DOMINIO_SITIO + "/rss/index.jsp"
					,"Ultimas novedades de " + seccionDescripcion + " en Tematika.com"
					,"Tematika.com - All rights reserved"
					,"Tematika.com - Novedades " + seccionDescripcion
					,"http://" +  Globals.DOMINIO_SITIO + "/imagenes/Logo-Tematika.gif"
					,"http://" +  Globals.DOMINIO_SITIO + "/index.jsp"
					,seccionDescripcion
					,"es-ar"
					,"Exportador de Novedades de " + seccionDescripcion + " RSS Tematika.com"
					);
			File file = new File(Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_AUX_DATA)
					+ "novedadesAlianza" + seccionDescripcion + ".xml");
			FileWriter outs = new FileWriter(file);
			outs.write(streamRSS);
			outs = saveArticulosBySeccionFecha(
					categorias[i].getCategoriaPK(), diasNovedad, outs, true);
			outs.write("</channel></rss>");
			outs.close();
			saveRSSFile(file);
		}
	}

	public static void generadorDeTop() throws Exception {
		Categoria categorias[] = CategoriaService.categoria;
		int articulosEnTop = 0;
		for (int i=0; i<categorias.length; i++) {
			String seccionDescripcion = Convert.capitalizar(categorias[i].getDescripcion(),
											false);
			if (categorias[i].getCategoriaPK().getPK()[0].intValue() == Globals.SECCION_LIBRO) {
				articulosEnTop = 100;
			} else {
				articulosEnTop = 20;
			}
			String streamRSS = setPlantillaRSS("Tematika.com - Ranking"
					,"http://" + Globals.DOMINIO_SITIO + "/ranking/index.jsp?idSeccion="
							+ categorias[i].getCategoriaPK().getPK()[0].intValue()
					,"Ranking de " + seccionDescripcion + " en Tematika.com"
					,"Tematika.com - All rights reserved"
					,"Tematika.com - Ranking " + seccionDescripcion
					,"http://" +  Globals.DOMINIO_SITIO + "/imagenes/Logo-Tematika.gif"
					,"http://" +  Globals.DOMINIO_SITIO + "/ranking/index.jsp?idSeccion="
							+ categorias[i].getCategoriaPK().getPK()[0].intValue()
					,seccionDescripcion
					,"es-ar"
					,"Exportador de Ranking de " + seccionDescripcion + " RSS Tematika.com"
					);
			File file = new File(Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_AUX_DATA)
					+ "ranking" + seccionDescripcion + ".xml");
			FileWriter outs = new FileWriter(file);
			outs.write(streamRSS);
			outs = saveArticulosMasVendidosBySeccion(
					categorias[i].getCategoriaPK().getPK()[0].intValue(), articulosEnTop, outs);

			outs.write("</channel></rss>");
			outs.close();
			saveRSSFile(file);
		}
	}

	public static void  generadorDeCategoria() throws Exception {
		generadorDeCategoriaRecursivo(CategoriaService.categoria);
	}

	private static void generadorDeCategoriaRecursivo(Categoria cat[]) throws Exception {
		try {
			int todosLosArticulos = 0;
			for (int i=0; i<cat.length; i++) {
				if (cat[i].getSubCategoria().length > 0) {
					generadorDeCategoriaRecursivo(cat[i].getSubCategoria());
				}
				if (cat[i].getCategoriaPK().getPK().length>1) {
					String seccionDescripcion = Convert.capitalizar(cat[i].getDescripcion(),
							true);

					try {
						Categoria categoriaEspecifica = CategoriaService.getCategoriaEspecifica(cat[i].getCategoriaPK());
						TmkLogger.debug(cat[i].toString());
						String streamRSS = setPlantillaRSS("Tematika.com - Catalogo de " + seccionDescripcion
						,"http://" + Globals.DOMINIO_SITIO + "/catalogo" + CategoriaService.getURL(categoriaEspecifica) + ".htm"
						,"Catalogo de " + seccionDescripcion + " en Tematika.com"
						,"Tematika.com - All rights reserved"
						,"Tematika.com - Catalogo de " + seccionDescripcion
						,"http://" +  Globals.DOMINIO_SITIO + "/imagenes/Logo-Tematika.gif"
						,"http://" +  Globals.DOMINIO_SITIO + "/catalogo" +  CategoriaService.getURL(categoriaEspecifica) + ".htm"
						,seccionDescripcion
						,"es-ar"
						,"Exportador de Catalogo de " + seccionDescripcion + " RSS Tematika.com"
						);
						File file = new File(Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_AUX_DATA)
								+ categoriaEspecifica.getDescripcionLarga() + ".xml");
						FileWriter outs = new FileWriter(file);
						outs.write(streamRSS);
						outs = saveArticulosBySeccionFecha(
								cat[i].getCategoriaPK(), todosLosArticulos, outs, false);
						outs.write("</channel></rss>");
						outs.close();
						saveRSSFile(file);
						TmkLogger.debug(cat[i].toString() + " grabado ok");
					} catch (Exception e) {
						TmkLogger.error(e.toString() + MainHelper.getMessage(e));
						throw e;
					}
				}

			}
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}

	/*-------------------------------------FIN GENERADORES---------------------------------------*/
}
