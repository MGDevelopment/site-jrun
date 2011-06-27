package com.tmk.generacion.feed;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;

import org.apache.commons.beanutils.DynaBean;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ISO8601DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.xml.converter.FeedTitleToStringConverter;
import com.tmk.xml.feed.Article;
import com.tmk.xml.feed.Author;
import com.tmk.xml.feed.Category;
import com.tmk.xml.feed.Entry;
import com.tmk.xml.feed.Feed;
import com.tmk.xml.feed.Link;
import com.tmk.xml.feed.Title;

public final class ComentarioFeed {
	public final static double itemsPerPage = 25.0;
	public static Iterator findSociosByDate(Calendar fecha) throws Exception{
		StringBuffer qry = new StringBuffer("");
		qry.append(" SELECT DISTINCT ca.id_socio, ca.id_sucursal_socio id_sucursal");
		qry.append(" FROM COMENTARIO_ARTICULOS ca, SOCIOS2 s, articulos a");
		qry.append(" WHERE ca.id_comentario>0");
		qry.append(" 	AND ca.estado = 'A'");
		qry.append(" 	AND (ca.f_modi > TO_DATE('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy')");
		qry.append(" 		OR s.f_modi > TO_DATE('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy'))");
		qry.append(" 	AND ca.id_socio = s.id_socio");
		qry.append(" 	AND ca.id_sucursal_socio = s.id_sucursal");
		qry.append(" 	AND ca.id_articulo = a.id_articulo");
		qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
		return MainHelper.getRs(qry.toString());
	}


	public static void generarFeed() throws Exception {
		try {

			Calendar fecha = Calendar.getInstance();
			fecha.set(Calendar.YEAR, 2004);
			fecha.add(Calendar.DATE, -1);
			Iterator it = findSociosByDate(fecha);

			while (it.hasNext()) {
				DynaBean dn = (DynaBean) it.next();
				try {
					double cantidadComentarios = 0;
					String mail ="";

					//Cantidad de comentarios
					StringBuffer qry = new StringBuffer("");
					qry.append(" SELECT COUNT(ca.id_comentario) cantidad, s.login ");
					qry.append(" FROM comentario_articulos ca, socios2 s, articulos a");
					qry.append(" WHERE ca.id_socio = ").append(dn.get("id_socio").toString());
					qry.append(" 	AND ca.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());
					qry.append("    AND estado= 'A'");
					qry.append("    AND ca.id_socio = s.id_socio");
					qry.append("    AND ca.id_sucursal_socio = s.id_sucursal");
					qry.append(" 	AND (ca.f_modi > to_date('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy')");
					qry.append(" 		OR s.f_modi > TO_DATE('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy'))");
					qry.append(" 	AND id_comentario>0");
					qry.append(" 	AND ca.id_articulo = a.id_articulo");
					qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
				 	qry.append(" GROUP BY s.login ");
					Connection conn = DBUtil.buildConnection();
					try {
						Statement st = conn.createStatement();
						try {
							ResultSet rs = st.executeQuery(qry.toString());
							try {
								if (rs.next()) {
									cantidadComentarios = rs.getDouble("cantidad");
									mail = new String(CryptUtil.desEncriptar(rs.getBytes("login")));
									mail = mail.toLowerCase();
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

					long pages = Math.round(Math.ceil (cantidadComentarios / itemsPerPage));
					if (cantidadComentarios > 0) {
						//Comentarios
						qry = new StringBuffer("");
						qry.append(" SELECT ca.id_comentario, nvl(ca.f_modi,ca.f_alta) f_modi, a.titulo, a.id_articulo, ca.comentario,  evaluacion,");
						qry.append(" 	NVL (DECODE (a.archivo_imagen,");
						qry.append("		'T', 'http://www.tematika.com/tapas/sitio/'");
						qry.append("		|| a.id_articulo");
						qry.append("		|| 'g0.jpg',");
						qry.append("		'G', 'http://www.tematika.com/tapas/sitio/'");
						qry.append("		|| a.id_articulo");
						qry.append("		|| 'g0.jpg',");
						qry.append("		''");
						qry.append("		),");
						qry.append("		' '");
						qry.append("		) imageLink, ");
						qry.append("		cs.categoria_seccion, cg.descripcion grupo, cg.categoria_grupo , DECODE(a.categoria_familia, 0,'',cf.descripcion) familia, cf.categoria_familia,");
						qry.append("		DECODE(a.categoria_subfamilia, 0,'',csf.descripcion) subfamilia, csf.categoria_subfamilia, aut.id_autor, nvl(aut.descripcion2, aut.descripcion) autor,");
						qry.append("		REPLACE (a.cod_ext_visual, '-', '') isbn, NVL (cgr.rv_meaning, 'Español') language, ed.nombre editorial,");
						qry.append("		ate.texto,  nvl(ate.parte, 1) parte, nvl(a.f_modi, a.f_alta) fmodiArt, nvl(aa.f_modi, aa.f_alta) fmodiAut, nvl(ate.f_modi, ate.f_alta) fmodiAte ");
						qry.append(" FROM");
						qry.append("	COMENTARIO_ARTICULOS ca,");
						qry.append("	ARTICULOS a,");
						qry.append("	CATEG_SECCIONES cs,");
						qry.append("	CATEG_GRUPOS cg,");
						qry.append("	CATEG_FAMILIAS cf,");
						qry.append("	CATEG_SUBFAMILIAS csf,");
						qry.append("	ARTICULOS_AUTORES aa,");
						qry.append("	AUTORES aut,");
						qry.append("	EDITORES ed,");
						qry.append("	ARTICULOS_TEXTOS ate,");
						qry.append(" 	CG_REF_CODES cgr");
			 			qry.append(" WHERE ");
						qry.append("	ca.id_socio = ").append(dn.get("id_socio").toString());
						qry.append("	AND ca.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());
						qry.append("	AND ca.estado= 'A'");
						qry.append("	AND ca.id_comentario>0 ");
						qry.append("	AND ca.id_articulo = a.id_Articulo");
						qry.append("	AND a.categoria_seccion = cs.categoria_seccion");
						qry.append("	AND a.categoria_seccion = cg.categoria_seccion");
						qry.append("	AND a.categoria_grupo = cg.categoria_grupo");
						qry.append("	AND a.categoria_seccion = cf.categoria_seccion");
						qry.append("	AND a.categoria_grupo = cf.categoria_grupo");
						qry.append("	AND a.categoria_familia = cf.categoria_familia");
						qry.append("	AND a.categoria_seccion = csf.categoria_seccion");
						qry.append("	AND a.categoria_grupo = csf.categoria_grupo");
						qry.append("	AND a.categoria_familia = csf.categoria_familia");
						qry.append("	AND a.categoria_subfamilia = csf.categoria_subfamilia");
						qry.append("	AND a.id_articulo = aa.id_articulo(+)");
						qry.append("	AND aa.id_autor = aut.id_autor(+)");
						qry.append("	AND (aa.ROLE IS NULL");
						qry.append("		OR (aa.ROLE in ('A01', 'C01') AND a.categoria_seccion IN (1, 3, 4))");
						qry.append("		OR (aa.ROLE in ('D02', 'E01', 'A01') AND a.categoria_seccion = 5)");
						qry.append("	    )");
						qry.append("	AND a.id_editor = ed.id_editor(+)");
						qry.append("	AND a.id_articulo = ate.id_articulo(+)");
						qry.append("	AND (ate.TIPO IS NULL OR ate.tipo = '01')");
						qry.append("	AND  a.idioma = cgr.RV_LOW_VALUE(+)");
						qry.append("	AND cgr.rv_domain = 'IDIOMA'");
						qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
					 	qry.append(" ORDER BY ca.f_modi desc, a.id_articulo");

						conn = DBUtil.buildConnection();
						try {
							Statement st = conn.createStatement();
							try {
								ResultSet rs = st.executeQuery(qry.toString());
								try {
									int idComentario = 0;
									int indiceComentario = 0;

									for (int i=0; i<pages; i++) {
										Feed feed = new Feed();
										feed.setXmlns("http://www.w3.org/2005/Atom");
										feed.setXmlns_opensearch("http://a9.com/-/spec/opensearchrss/1.0/");
										feed.setXmlns_ppg("http://schemas.popego.com/2008");
										feed.setXmlns_gd("http://schemas.google.com/g/2005");
										feed.setId("http://www.tematika.com/feed/userid/" + mail + "/" + i + "/comments.htm");
										Title title = new Title("Comentarios de " +  mail, "text");
										feed.setTitle(title);
										Link link = new Link("self", "application/atom+xml", "http://www.tematika.com/feed/userid/" + mail + "/" + i + "/comments.htm");
										feed.setLink(link);
										feed.setUpdated(new Date());
										Author author = new Author(mail);
										feed.setAuthor(author);
										Category category = new Category ("http://schemas.google.com/g/2005#kind",
													"http://schemas.popego.com#commentlist");
										feed.setCategory(category);
										feed.setOpenSearch_totalResults(new Integer(new Double(cantidadComentarios).intValue()));
										feed.setOpenSearch_startIndex (new Integer(new Double(((i+1)*itemsPerPage-itemsPerPage)+1).intValue()));
										feed.setOpenSearch_itemsPerPage(new Integer(new Double(itemsPerPage).intValue()));

										Entry entry = null;
										Article article = null;


										while (indiceComentario < ((i+1)*itemsPerPage)) {
											if (rs.next()) {
												if (idComentario != rs.getInt("id_comentario")) {
													if (idComentario!=0 & entry!=null) {
														//Asigno el articulo anterior
														entry.addArticle(article);
														feed.addEntry(entry);
													}
													indiceComentario++;
													idComentario = rs.getInt("id_comentario");

													entry = new Entry("http://www.tematika.com/feed/userid/" + mail + "/comments/comment" + rs.getInt("id_comentario"));
													entry.setPublished(new Date(rs.getTimestamp("f_modi").getTime()));
													entry.setUpdated(new Date(rs.getTimestamp("f_modi").getTime()));

													Category categoryEntry = new Category ("http://schemas.google.com/g/2005#kind", "http://schemas.popego.com#comment");
													entry.setCategory(categoryEntry);
													Title titleEntry = new Title(Convert.corregir(rs.getString("titulo"), true), "text");
													entry.setTitle(titleEntry);
													entry.setSummary(rs.getString("comentario"));
													entry.setPpg_rating(new Double(rs.getDouble("evaluacion")));

													article = new Article();

													Category categoryArticle;
													switch (new Integer(rs.getInt("categoria_seccion")).intValue()) {
														case Globals.SECCION_JUGUETES: {
															categoryArticle = new Category("http://schemas.google.com/g/2005#kind",
															"http://schemas.popego.com#product");
														} break;
														case Globals.SECCION_MUSICA: {
															categoryArticle = new Category("http://schemas.google.com/g/2005#kind",
															"http://schemas.popego.com#album");
														} break;
														case Globals.SECCION_PELICULA: {
															categoryArticle = new Category("http://schemas.google.com/g/2005#kind",
															"http://schemas.popego.com#movie");
														} break;
														default: {
															categoryArticle = new Category("http://schemas.google.com/g/2005#kind",
															"http://schemas.popego.com#book");
														}
													}
													article.addCategory(categoryArticle);

													Vector auxCatPK = new Vector();
													auxCatPK.add(new Integer(rs.getInt("categoria_seccion")));
													if (rs.getInt("categoria_grupo") != 0) {
														auxCatPK.add(new Integer(rs.getInt("categoria_grupo")));
														categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																Convert.capitalizar(rs.getString("grupo"), false));
														article.addCategory(categoryArticle);
														if (rs.getInt("categoria_familia") != 0) {
															auxCatPK.add(new Integer(rs.getInt("categoria_familia")));
															categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																	Convert.capitalizar(rs.getString("familia"), false));
															article.addCategory(categoryArticle);
															if (rs.getInt("categoria_subfamilia") != 0) {
																auxCatPK.add(new Integer(rs.getInt("categoria_subfamilia")));
																categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																		Convert.capitalizar(rs.getString("subfamilia"), false));
																article.addCategory(categoryArticle);
															}
														}

													}
													CategoriaPK catPK = new CategoriaPK((Integer[]) auxCatPK.toArray(new Integer[auxCatPK.size()]));
													Categoria categoria = CategoriaService.getCategoriaEspecifica(catPK);
													StringBuffer txtLink = new StringBuffer();
													txtLink.append("http://www.tematika.com");
													txtLink.append(CategoriaService.getURL(categoria));
													txtLink.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(rs.getString("titulo"), true)).toLowerCase())).append("--").append(rs.getInt("id_articulo")).append(".htm");

													article.setId(txtLink.toString());
													if (rs.getTimestamp("fmodiAut")== null || rs.getTimestamp("fmodiArt").after(rs.getTimestamp("fmodiAut"))) {
														if (rs.getTimestamp("fmodiAte")== null || rs.getTimestamp("fmodiArt").after(rs.getTimestamp("fmodiAte"))) {
															article.setUpdated(new Date(rs.getTimestamp("fmodiArt").getTime()));
														} else {
															article.setUpdated(new Date(rs.getTimestamp("fmodiAte").getTime()));
														}
													} else {
														if (rs.getTimestamp("fmodiAte")== null || rs.getTimestamp("fmodiAut").after(rs.getTimestamp("fmodiAte"))) {
															article.setUpdated(new Date(rs.getTimestamp("fmodiAut").getTime()));
														} else {
															article.setUpdated(new Date(rs.getTimestamp("fmodiAte").getTime()));
														}
													}

													Link linkArticle = new Link("alternate", null, txtLink.toString());
													article.addLink(linkArticle);
													//Link linkEntry = new Link("alternate", null, "http://www.tematika.com/feed/userid/" + mail + "/comments/comment" + rs.getInt("id_comentario"));
													//entry.setLink(linkEntry);
													entry.setLink(linkArticle);
													linkArticle = new Link("related", null, rs.getString("imageLink"));
													article.addLink(linkArticle);

													Title titleArticle = new Title(Convert.corregir(rs.getString("titulo"), true), "text");
													article.setPpg_title(titleArticle);

													article.setPpg_isbn(rs.getString("isbn"));
													article.setPpg_publisher(Convert.nombrePropio(rs.getString("editorial"), false));
												    article.setPpg_language(rs.getString("language"));
												}
											    if (rs.getString("autor") != null) {
											    	article.addAuthor(new Integer(rs.getInt("id_autor")),
											    			Convert.nombrePropio(rs.getString("autor"), false));
											    }
											    if (rs.getString("texto") != null && !"".equals(rs.getString("texto"))) {
											    	article.setSinopsis(new Integer(rs.getInt("parte")),
											    		rs.getString("texto"));
											    }
											} else {
												indiceComentario =new Double(((i+1)*itemsPerPage)).intValue();
											}
										}
										if (idComentario!=0) {
											//Asigno el articulo anterior
											entry.addArticle(article);
											feed.addEntry(entry);
											idComentario = 0;
										}

										//CREO EL FEED
										XStream xstream = new XStream(new DomDriver("ISO-8859-1"));
										xstream.setMode(XStream.NO_REFERENCES);
										xstream.alias( "feed", Feed.class);
										xstream.aliasAttribute(Feed.class, "xmlns_ppg", "xmlns:ppg");
										xstream.aliasAttribute(Feed.class, "xmlns_opensearch", "xmlns:openSearch");
										xstream.aliasAttribute(Feed.class, "xmlns_gd", "xmlns:gd");
										xstream.useAttributeFor("xmlns", String.class);
										xstream.useAttributeFor("xmlns_ppg", String.class);
										xstream.useAttributeFor("xmlns_opensearch", String.class);
										xstream.useAttributeFor("xmlns_gd", String.class);
										//xstream.useAttributeFor(Title.class, "type");
										//xstream.addImplicitCollection(Title.class, "text");
										xstream.registerLocalConverter(Feed.class, "title", new FeedTitleToStringConverter());
										xstream.registerLocalConverter(Entry.class, "title", new FeedTitleToStringConverter());
										xstream.registerLocalConverter(Article.class, "ppg_title", new FeedTitleToStringConverter());
										xstream.useAttributeFor(Link.class, "rel");
										xstream.useAttributeFor(Link.class, "type");
										xstream.useAttributeFor(Link.class, "href");
										xstream.registerConverter(new ISO8601DateConverter());
										xstream.useAttributeFor(Category.class, "scheme");
										xstream.useAttributeFor(Category.class, "term");
										xstream.aliasField("openSearch:totalResults", Feed.class, "openSearch_totalResults");
										xstream.aliasField("openSearch:startIndex", Feed.class, "openSearch_startIndex");
										xstream.aliasField("openSearch:itemsPerPage", Feed.class, "openSearch_itemsPerPage");
										xstream.alias("entry", Entry.class);
										xstream.addImplicitCollection(Feed.class, "entries");
										xstream.addImplicitCollection(Entry.class, "articles");
										xstream.aliasField("ppg:rating", Entry.class, "ppg_rating");
										xstream.alias("ppg:article", Article.class);
										xstream.alias("link", Link.class);
										xstream.addImplicitCollection(Article.class, "links");
										xstream.alias("category", Category.class);
										xstream.addImplicitCollection(Article.class, "categories");
										xstream.aliasField("ppg:title", Article.class, "ppg_title");
										xstream.aliasField("ppg:isbn", Article.class, "ppg_isbn");
										xstream.aliasField("ppg:publisher", Article.class, "ppg_publisher");
										xstream.aliasField("ppg:language", Article.class, "ppg_language");
										xstream.aliasField("ppg:description", Article.class, "ppg_description");
										xstream.aliasField("ppg:rating", Article.class, "ppg_rating");
										xstream.omitField(Article.class, "sinopsis");
										xstream.omitField(Article.class, "author");
										xstream.addImplicitCollection(Article.class, "autores");
										xstream.alias("ppg:author", String.class);

										try {
											/**/
											StringBuffer fileName = new StringBuffer("");
											fileName.append(MainHelper.RES_DIR_COMMENT_FEED).append("/").append(mail);
											fileName.append("_").append(i).append(".xml");
											MainHelper.saveFileNet(fileName.toString(), "<?xml version='1.0' encoding='ISO-8859-1'?>" + xstream.toXML(feed), "contenidosEstaticos");
										} catch (Exception e) {
											TmkLogger.error("Generacion de comentario] " + e.toString() + MainHelper.getMessage(e));
										}
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

					}
				} catch (Exception e) {
					//Trapeo aca para poder seguir generando
					MainHelper.enviarMailDeError("ComentarioFeed] Socio" + dn.get("id_socio").toString()
							+ "-" + dn.get("id_sucursal").toString() + " Error " + e.toString() + MainHelper.getMessage(e));
					TmkLogger.error("ComentarioFeed] Socio" + dn.get("id_socio").toString()
							+ "-" + dn.get("id_sucursal").toString() + " Error " + e.toString() + MainHelper.getMessage(e));
				}
			}
		}catch (Exception e) {
			TmkLogger.error("ComentarioFeed] " + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}

}
