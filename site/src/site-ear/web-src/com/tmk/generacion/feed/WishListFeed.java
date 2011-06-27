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

public class WishListFeed {
	public final static double itemsPerPage = 25.0;
	public static Iterator findSociosByDate(Calendar fecha) throws Exception{
		StringBuffer qry = new StringBuffer("");
		qry.append(" SELECT DISTINCT ld.id_sucursal_socio id_sucursal, ld.id_socio");
		qry.append(" FROM LISTA_DESEOS ld, CARRITO_LISTA_DESEOS cld, SOCIOS2 s, articulos a ");
		qry.append(" WHERE ld.id_socio = cld.id_socio");
		qry.append(" 	AND ld.id_sucursal_socio = cld.id_sucursal_socio");
		qry.append(" 	AND publica = 1");
		qry.append(" 	AND cld.estado = 0");
		qry.append(" 	AND (cld.f_alta > TO_DATE ('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy')");
		qry.append(" 		OR s.f_modi > TO_DATE('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis()))).append("', 'dd/mm/yyyy'))");
		qry.append("	AND ld.id_socio = s.id_socio");
		qry.append("	AND ld.id_sucursal_socio = s.id_sucursal");
		qry.append(" 	AND cld.id_articulo = a.id_articulo");
		qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
		return MainHelper.getRs(qry.toString());
	 }

	public static void generarFeed() throws Exception {
		try {
			Calendar fecha = Calendar.getInstance();
			fecha.set(Calendar.YEAR, 2000);
			fecha.add(Calendar.DATE, -1);
			Iterator it = findSociosByDate(fecha);

			while (it.hasNext()) {
				double cantidadListas = 0;
				String mail ="";
				DynaBean dn = (DynaBean) it.next();
				try {
					StringBuffer qry = new StringBuffer("");
					qry.append(" SELECT s.login , COUNT(DISTINCT 1)  cantidad ");
					qry.append(" FROM lista_deseos ld, ");
					qry.append(" 	carrito_lista_deseos cld, ");
					qry.append(" 	socios2 s, articulos a");
					qry.append(" WHERE ld.id_socio = cld.id_socio");
					qry.append(" 	AND ld.id_sucursal_socio = cld.id_sucursal_socio");
					qry.append(" 	AND publica = 1");
					qry.append(" 	AND cld.estado = 0");
					qry.append(" 	AND cld.f_alta > TO_DATE ('").append(Convert.toStringFromDDMMYYYY(new Timestamp(fecha.getTimeInMillis())));
					qry.append("', 'dd/mm/yyyy')");
					qry.append(" 	AND ld.id_socio = ").append(dn.get("id_socio").toString());
					qry.append(" 	AND ld.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());
					qry.append(" 	AND s.id_socio = ld.id_socio");
					qry.append(" 	AND s.id_sucursal = ld.id_sucursal_socio");
					qry.append(" 	AND cld.id_articulo = a.id_articulo");
					qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
					qry.append(" 	GROUP BY s.login");
					Connection conn = DBUtil.buildConnection();
					try {
						Statement st = conn.createStatement();
						try {
							ResultSet rs = st.executeQuery(qry.toString());
							try {
								if (rs.next()) {
									cantidadListas = rs.getDouble("cantidad");
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
					long pages = Math.round(Math.ceil (cantidadListas / itemsPerPage));
					if (cantidadListas > 0) {
						qry = new StringBuffer("");
						qry.append(" SELECT  f_alta, nvl(f_modi, f_alta) f_modi , palabras_claves, 1 idWishlist");
						qry.append(" FROM lista_deseos ld");
						qry.append(" WHERE ld.id_socio =").append(dn.get("id_socio").toString());
						qry.append(" 	AND ld.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());

						conn = DBUtil.buildConnection();
						try {
							Statement st = conn.createStatement();
							try {
								ResultSet rs = st.executeQuery(qry.toString());
								try {

									/**/
									int idLista = 0;
									int indiceLista = 0;


									for (int i=0; i<pages; i++) {
										Feed feed = new Feed();
										feed.setXmlns("http://www.w3.org/2005/Atom");
										feed.setXmlns_opensearch("http://a9.com/-/spec/opensearchrss/1.0/");
										feed.setXmlns_ppg("http://schemas.popego.com/2008");
										feed.setXmlns_gd("http://schemas.google.com/g/2005");
										feed.setId("http://www.tematika.com/feed/userid/" + mail + "/" + i + "/wishlists.htm");
										Title title = new Title("Listas de Deseos de " +  mail, "text");
										feed.setTitle(title);
										Link link = new Link("self", "application/atom+xml", "http://www.tematika.com/feed/userid/" + mail + "/" + i + "/wishlists.htm");
										feed.setLink(link);
										feed.setUpdated(new Date());
										Author author = new Author(mail);
										feed.setAuthor(author);
										Category category = new Category ("http://schemas.google.com/g/2005#kind",
													"http://schemas.popego.com#wishlists");
										feed.setCategory(category);
										feed.setOpenSearch_totalResults(new Integer(new Double(cantidadListas).intValue()));
										feed.setOpenSearch_startIndex (new Integer(new Double(((i+1)*itemsPerPage-itemsPerPage)+1).intValue()));
										feed.setOpenSearch_itemsPerPage(new Integer(new Double(itemsPerPage).intValue()));

										Entry entry = null;
										//Article article = null;


										while (indiceLista < ((i+1)*itemsPerPage)) {
											if (rs.next()) {
												indiceLista++;
												idLista = rs.getInt("idWishList");
												//TmkLogger.debug("indice " + indiceLista);
												entry = new Entry("http://www.tematika.com/feed/userid/" + mail + "/wishlists/wishlist" + rs.getInt("idWishlist"));
												entry.setPublished(new Date(rs.getTimestamp("f_alta").getTime()));
												entry.setUpdated(new Date(rs.getTimestamp("f_modi").getTime()));
												//Link linkEntry = new Link("alternate", null, "http://www.tematika.com/feed/userid/" + mail + "/wishlists/wishlist" + rs.getInt("idWishlist"));
												Link linkEntry = new Link("alternate", null, "http://www.tematika.com/feed/userid/" + mail + "/0/wishlist_" + rs.getInt("idWishlist") + ".htm");
												entry.setLink(linkEntry);
												Category categoryEntry = new Category ("http://schemas.google.com/g/2005#kind", "http://schemas.popego.com#wishlists");
												entry.setCategory(categoryEntry);
												Title titleEntry = new Title(mail + " wishlist " + rs.getInt("idWishlist"), "text");
												entry.setTitle(titleEntry);
												entry.setSummary(rs.getString("palabras_claves"));
												linkEntry = new Link ("http://schemas.popego.com/2008#wishlist", null, "http://www.tematika.com/feed/userid/" + mail + "/0/wishlist_" + rs.getInt("idWishlist") + ".htm");
												entry.setGdFeedLink(linkEntry);

												//FALTA DATA
												feed.addEntry(entry);

											} else {
												indiceLista = new Double(((i+1)*itemsPerPage)).intValue();
											}
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
										xstream.useAttributeFor("xmlns_gd", String.class);
										xstream.useAttributeFor("xmlns_opensearch", String.class);
										//xstream.useAttributeFor(Title.class, "type");
										//xstream.addImplicitCollection(Title.class, "text");
										xstream.registerLocalConverter(Feed.class, "title", new FeedTitleToStringConverter());
										xstream.registerLocalConverter(Entry.class, "title", new FeedTitleToStringConverter());
										xstream.useAttributeFor(Link.class, "rel");
										xstream.useAttributeFor(Link.class, "type");
										xstream.useAttributeFor(Link.class, "href");
										xstream.registerConverter(new ISO8601DateConverter());
										xstream.useAttributeFor(Category.class, "scheme");
										xstream.useAttributeFor(Category.class, "term");
										xstream.aliasField("openSearch:totalResults", Feed.class, "openSearch_totalResults");
										xstream.aliasField("openSearch:startIndex", Feed.class, "openSearch_startIndex");
										xstream.aliasField("openSearch:itemsPerPage", Feed.class, "openSearch_itemsPerPage");
										xstream.aliasField("gd:feedLink", Entry.class, "gd_feedLink");
										xstream.alias("entry", Entry.class);
										xstream.addImplicitCollection(Feed.class, "entries");
										xstream.omitField(Entry.class, "articles");

										/*File file;
										FileWriter outs;*/
										try {
											StringBuffer fileName = new StringBuffer("");
											fileName.append("/wishListFeed/").append("/indice_").append(mail);
											fileName.append("_").append(i).append(".xml");
											MainHelper.saveFileNet(fileName.toString(), "<?xml version='1.0' encoding='ISO-8859-1'?>" + xstream.toXML(feed), "contenidosEstaticos");

										} catch (Exception e) {
											TmkLogger.error("Generacion de listas de deseos] " + e.toString() + MainHelper.getMessage(e));
										}
										/*LISTADO CON LOS ARTICULOS*/
										double cantidadArticulo = 0;
										qry = new StringBuffer();
										qry.append(" SELECT COUNT(cld.id_articulo) cantidad");
										qry.append(" FROM carrito_lista_deseos cld, articulos a");
										qry.append(" WHERE cld.id_socio = ").append(dn.get("id_socio").toString());
										qry.append(" AND cld.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());
										qry.append(" AND cld.estado = 0");
										qry.append(" AND cld.id_articulo = a.id_articulo");
										qry.append(" AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");

										Connection conn2 = DBUtil.buildConnection();
										try {
											Statement st2 = conn2.createStatement();
											try {
												ResultSet rs2 = st2.executeQuery(qry.toString());
												try {
													if (rs2.next()) {
														cantidadArticulo = rs2.getDouble("cantidad");
													}
												} finally {
													rs2.close();
												}
											} finally {
												st2.close();
											}

										} finally{
											conn2.close();
										}
										long pagesArticulo = Math.round(Math.ceil (cantidadArticulo / itemsPerPage));
										if (cantidadArticulo>0) {
											qry = new StringBuffer();
											qry.append(" SELECT   cld.f_alta, cld.f_modi, a.titulo, a.id_articulo idArticulo,");
											qry.append(" 	NVL (DECODE (a.archivo_imagen,");
											qry.append(" 	'T', 'http://www.tematika.com/tapas/sitio/'");
											qry.append(" 	|| a.id_articulo");
											qry.append(" 	|| 'g0.jpg',");
											qry.append(" 	'G', 'http://www.tematika.com/tapas/sitio/'");
											qry.append(" 	|| a.id_articulo");
											qry.append(" 	|| 'g0.jpg',");
											qry.append(" 	''");
											qry.append(" 	),");
											qry.append(" 	' '");
											qry.append(" 	) imageLink , ");
											qry.append(" 	cs.categoria_seccion , cg.descripcion grupo, cg.categoria_grupo  , DECODE(a.categoria_familia, 0,'',cf.descripcion) familia , cf.categoria_familia ,");
											qry.append(" 	DECODE(a.categoria_subfamilia, 0,'',csf.descripcion) subfamilia, csf.categoria_subfamilia, aut.id_autor, NVL(aut.descripcion2, aut.descripcion) autor,");
											qry.append(" 	REPLACE (a.cod_ext_visual, '-', '') isbn, NVL (cgr.rv_meaning, 'Español') LANGUAGE, ed.nombre editorial,");
											qry.append(" 	ate.texto,  NVL(ate.parte, 1) parte, NVL(a.f_modi, a.f_alta) fmodiArt, NVL(aa.f_modi, aa.f_alta) fmodiAut, NVL(ate.f_modi, ate.f_alta) fmodiAte");
											qry.append(" FROM");
											qry.append(" 	CARRITO_LISTA_DESEOS cld,");
											qry.append(" 	ARTICULOS a ,");
											qry.append(" 	CATEG_SECCIONES cs ,");
											qry.append(" 	CATEG_GRUPOS cg ,");
											qry.append(" 	CATEG_FAMILIAS cf ,");
											qry.append(" 	CATEG_SUBFAMILIAS csf,");
											qry.append(" 	ARTICULOS_AUTORES aa,");
											qry.append(" 	AUTORES aut,");
											qry.append(" 	EDITORES ed,");
											qry.append(" 	ARTICULOS_TEXTOS ate,");
											qry.append(" 	CG_REF_CODES cgr");
											qry.append(" WHERE ");
											qry.append(" 	cld.id_socio = ").append(dn.get("id_socio").toString());
											qry.append(" 	AND cld.id_sucursal_socio = ").append(dn.get("id_sucursal").toString());
											qry.append(" 	AND cld.estado= 0");
											qry.append(" 	AND cld.id_articulo = a.id_Articulo");
											qry.append(" 	AND a.categoria_seccion = cs.categoria_seccion");
											qry.append(" 	AND a.categoria_seccion = cg.categoria_seccion");
											qry.append(" 	AND a.categoria_grupo = cg.categoria_grupo ");
											qry.append(" 	AND a.categoria_seccion = cf.categoria_seccion");
											qry.append(" 	AND a.categoria_grupo = cf.categoria_grupo");
											qry.append(" 	AND a.categoria_familia = cf.categoria_familia ");
											qry.append(" 	AND a.categoria_seccion = csf.categoria_seccion");
											qry.append("	 AND a.categoria_grupo = csf.categoria_grupo");
											qry.append(" 	AND a.categoria_familia = csf.categoria_familia");
											qry.append(" 	AND a.categoria_subfamilia = csf.categoria_subfamilia");
											qry.append(" 	AND a.id_articulo = aa.id_articulo(+)");
											qry.append(" 	AND aa.id_autor = aut.id_autor(+)");
											qry.append(" 	AND (aa.ROLE IS NULL");
											qry.append("	OR (aa.ROLE in ('A01', 'C01') AND a.categoria_seccion IN (1, 3, 4))		");
											qry.append(" 	OR (aa.ROLE in ('D02', 'E01', 'A01') AND a.categoria_seccion = 5)");
											qry.append("    	)");
											qry.append(" 	AND a.id_editor = ed.id_editor(+)");
											qry.append(" 	AND a.id_articulo = ate.id_articulo(+)");
											qry.append(" 	AND (ate.TIPO IS NULL OR ate.tipo = '01')");
											qry.append(" 	AND a.idioma = cgr.RV_LOW_VALUE(+)");
											qry.append(" 	AND cgr.rv_domain = 'IDIOMA'");
											qry.append(" 	AND a.categoria_seccion in (" + Globals.getSeccionesHabilitadasSQL() + ")");
											qry.append(" 	ORDER BY cld.f_alta DESC, a.id_articulo");

											conn2 = DBUtil.buildConnection();
											try {
												Statement st2 = conn2.createStatement();
												try {
													ResultSet rs2 = st2.executeQuery(qry.toString());
													try {
														int indiceArticulo = 0;
														int idArticulo = 0;

														for (int j=0; j<pagesArticulo; j++) {
															feed = new Feed();
															feed.setXmlns("http://www.w3.org/2005/Atom");
															feed.setXmlns_opensearch("http://a9.com/-/spec/opensearchrss/1.0/");
															feed.setXmlns_ppg("http://schemas.popego.com/2008");
															feed.setXmlns_gd("http://schemas.google.com/g/2005");
															feed.setId("http://www.tematika.com/feed/userid/" + mail + "/" + j + "/wishlist_" + idLista + ".htm");
															title = new Title("Lista de Deseos de " +  mail, "text");
															feed.setTitle(title);
															link = new Link("self", "application/atom+xml", "http://www.tematika.com/feed/userid/" + mail + "/" + j + "/wishlist_" + idLista + ".htm");
															feed.setLink(link);
															feed.setUpdated(new Date());
															author = new Author(mail);
															feed.setAuthor(author);
															category = new Category ("http://schemas.google.com/g/2005#kind",
																		"http://schemas.popego.com#wishlist");
															feed.setCategory(category);
															feed.setOpenSearch_totalResults(new Integer(new Double(cantidadArticulo).intValue()));
															feed.setOpenSearch_startIndex (new Integer(new Double(((j+1)*itemsPerPage-itemsPerPage)+1).intValue()));
															feed.setOpenSearch_itemsPerPage(new Integer(new Double(itemsPerPage).intValue()));

															entry = null;
															Article article = null;

															while (indiceArticulo < ((j+1)*itemsPerPage)) {
																if (rs2.next()) {
																	if (idArticulo != rs2.getInt("idArticulo")) {
																		if (idArticulo!=0 & entry!=null) {
																			entry.addArticle(article);
																			feed.addEntry(entry);
																		}
																		indiceArticulo++;
																		idArticulo = rs2.getInt("idArticulo");

																		entry = new Entry("http://www.tematika.com/feed/userid/" + mail + "/" + j + "/wishlist_" + idLista + "/" + Convert.corregir(rs2.getString("titulo"), true).replaceAll(" ", "").toLowerCase());
																		entry.setPublished(new Date(rs2.getTimestamp("f_alta").getTime()));
																		if (rs2.getTimestamp("f_modi") != null) {
																			entry.setUpdated(new Date(rs2.getTimestamp("f_modi").getTime()));
																		} else {
																			entry.setUpdated(new Date(rs2.getTimestamp("f_alta").getTime()));
																		}

																		Category categoryEntry = new Category ("http://schemas.google.com/g/2005#kind", "http://schemas.popego.com#wishListItem");
																		entry.setCategory(categoryEntry);
																		Title titleEntry = new Title(Convert.corregir(rs2.getString("titulo"), true), "text");
																		entry.setTitle(titleEntry);
																		article = new Article();

																		Category categoryArticle;
																		switch (new Integer(rs2.getInt("categoria_seccion")).intValue()) {
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
																		auxCatPK.add(new Integer(rs2.getInt("categoria_seccion")));
																		if (rs2.getInt("categoria_grupo") != 0) {
																			auxCatPK.add(new Integer(rs2.getInt("categoria_grupo")));
																			categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																					Convert.capitalizar(rs2.getString("grupo"), false));
																			article.addCategory(categoryArticle);
																			if (rs2.getInt("categoria_familia") != 0) {
																				auxCatPK.add(new Integer(rs2.getInt("categoria_familia")));
																				categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																						Convert.capitalizar(rs2.getString("familia"), false));
																				article.addCategory(categoryArticle);
																				if (rs2.getInt("categoria_subfamilia") != 0) {
																					auxCatPK.add(new Integer(rs2.getInt("categoria_subfamilia")));
																					categoryArticle = new Category("http://popego.com/schemas/2008/tags.cat",
																							Convert.capitalizar(rs2.getString("subfamilia"), false));
																					article.addCategory(categoryArticle);
																				}
																			}

																		}


																		CategoriaPK catPK = new CategoriaPK((Integer[]) auxCatPK.toArray(new Integer[auxCatPK.size()]));
																		Categoria categoria = CategoriaService.getCategoriaEspecifica(catPK);
																		StringBuffer txtLink = new StringBuffer();
																		txtLink.append("http://www.tematika.com");
																		txtLink.append(CategoriaService.getURL(categoria));
																		txtLink.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(rs2.getString("titulo"), true)).toLowerCase())).append("--").append(rs2.getInt("idArticulo")).append(".htm");

																		article.setId(txtLink.toString());
																		if (rs2.getTimestamp("fmodiAut")== null || rs2.getTimestamp("fmodiArt").after(rs2.getTimestamp("fmodiAut"))) {
																			if (rs2.getTimestamp("fmodiAte")== null || rs2.getTimestamp("fmodiArt").after(rs2.getTimestamp("fmodiAte"))) {
																				article.setUpdated(new Date(rs2.getTimestamp("fmodiArt").getTime()));
																			} else {
																				article.setUpdated(new Date(rs2.getTimestamp("fmodiAte").getTime()));
																			}
																		} else {
																			if (rs2.getTimestamp("fmodiAte")== null || rs2.getTimestamp("fmodiAut").after(rs2.getTimestamp("fmodiAte"))) {
																				article.setUpdated(new Date(rs2.getTimestamp("fmodiAut").getTime()));
																			} else {
																				article.setUpdated(new Date(rs2.getTimestamp("fmodiAte").getTime()));
																			}
																		}

																		Link linkArticle = new Link("alternate", null, txtLink.toString());
																		article.addLink(linkArticle);
																		//Link linkEntry = new Link("alternate", null, "http://www.tematika.com/feed/userid/" + mail + "/" + j + "/wishlist_" + idLista + "/" + Convert.corregir(rs2.getString("titulo"), true).replaceAll(" ", ""));
																		//entry.setLink(linkEntry);
																		entry.setLink(linkArticle);

																		linkArticle = new Link("related", null, rs2.getString("imageLink"));
																		article.addLink(linkArticle);

																		Title titleArticle = new Title(Convert.corregir(rs2.getString("titulo"), true), "text");
																		article.setPpg_title(titleArticle);

																		article.setPpg_isbn(rs2.getString("isbn"));
																		article.setPpg_publisher(Convert.nombrePropio(rs2.getString("editorial"), false));
																	    article.setPpg_language(rs2.getString("language"));

																	}
																    if (rs2.getString("autor") != null) {
																    	article.addAuthor(new Integer(rs2.getInt("id_autor")),
																    			Convert.nombrePropio(rs2.getString("autor"), false));
																    }

																    if (rs2.getString("texto") != null && !"".equals(rs2.getString("texto"))) {
																    	article.setSinopsis(new Integer(rs2.getInt("parte")),
																    		rs2.getString("texto"));
																    }
																} else {
																	indiceArticulo =new Double(((j+1)*itemsPerPage)).intValue();
																}

															}
															if (idArticulo!=0) {
																//Asigno el articulo anterior
																entry.addArticle(article);
																feed.addEntry(entry);
																idArticulo = 0;
															}
		//													CREO EL FEED
															xstream = new XStream(new DomDriver("ISO-8859-1"));
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
																StringBuffer fileName = new StringBuffer("");
																fileName.append(MainHelper.RES_DIR_WISHLIST_FEED).append("/").append(mail);
																fileName.append("_").append(idLista).append("_").append(j).append(".xml");
																MainHelper.saveFileNet(fileName.toString(), "<?xml version='1.0' encoding='ISO-8859-1'?>" + xstream.toXML(feed), "contenidosEstaticos");

															} catch (Exception e) {
																TmkLogger.error("Generacion de listas de deseos] " + e.toString() + MainHelper.getMessage(e));
															}
														}
													} finally {
														rs2.close();
													}
												} finally {
													st2.close();
												}

											} finally{
												conn2.close();
											}
										}
										/*LISTADO CON LOS ARTICULOS*/
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
					MainHelper.enviarMailDeError("WishListFeed] ] Socio" + dn.get("id_socio").toString()
							+ "-" + dn.get("id_sucursal").toString() + " Error " + e.toString() + MainHelper.getMessage(e));
					TmkLogger.error("WishListFeed] ] Socio" + dn.get("id_socio").toString()
							+ "-" + dn.get("id_sucursal").toString() + " Error " + e.toString() + MainHelper.getMessage(e));
				}
			}
		}catch (Exception e) {
			TmkLogger.error("WishListFeed] " + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}
}
