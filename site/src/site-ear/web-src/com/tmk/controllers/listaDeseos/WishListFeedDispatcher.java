package com.tmk.controllers.listaDeseos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.RAW;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.extended.ISO8601DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.generacion.feed.WishListFeed;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.xml.converter.FeedTitleToStringConverter;
import com.tmk.xml.feed.Author;
import com.tmk.xml.feed.Category;
import com.tmk.xml.feed.Feed;
import com.tmk.xml.feed.Link;
import com.tmk.xml.feed.Title;

public class WishListFeedDispatcher extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String mail = request.getParameter("mail");
			int idWishList = Convert.toNumber(request.getParameter("idWishList"), 0);
			response.setContentType("text/html;charset=ISO-8859-1");
			int page = Convert.toNumber(request.getParameter("page"), 0);


			if (mail != null && idWishList != 0) {
				String fileName = mail + "_" + idWishList + "_" + page;

				File file = new File(Contenido.getServletContext().getRealPath(MainHelper.RES_DIR_CONTENIDOS_ESTATICOS + MainHelper.RES_DIR_WISHLIST_FEED )
						 + "/" + fileName + ".xml");
				if (file.exists()) {
					String strModifiedClient = request.getHeader("If-Modified-Since");
					Date dateModifiedServer = new Date(file.lastModified());
					SimpleDateFormat RFC822DateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z", new  Locale("es", "ES"));
					String strModifiedServer = RFC822DateFormat.format(dateModifiedServer);
					response.setHeader("Last-Modified", strModifiedServer);

					if (strModifiedClient != null) {
						if (!strModifiedClient.equals(strModifiedServer)) {
							//sirvo el archivo
							//TmkLogger.debug("Se modifico lo sirvo de nuvo ");
							MainHelper.printFile(response, file, "text/xml;charset=ISO-8859-1");
						} else{
							//contesto q no hay modificacion
							//TmkLogger.debug("Sin modificacion ");
							response.sendError(HttpServletResponse.SC_NOT_MODIFIED);
						}
					} else {
						//sirvo el archivo
						//TmkLogger.debug("No tengo datos del cliente");
						MainHelper.printFile(response, file, "text/xml;charset=ISO-8859-1");
					}
				} else {
//					archivo no existe
					//chequeo si el socio existe
					try {
						Connection conn = DBUtil.buildConnection();
						try {
							byte [] login = CryptUtil.encriptar(mail.toUpperCase().getBytes());
							Socios2 socio = new Socios2();
							try {
								socio.select(conn, new String[] {"login = '" + new RAW(login).stringValue() + "'"});
								try {
									Feed feed = new Feed();
									feed.setXmlns("http://www.w3.org/2005/Atom");
									feed.setXmlns_opensearch("http://a9.com/-/spec/opensearchrss/1.0/");
									feed.setXmlns_ppg("http://schemas.popego.com/2008");
									feed.setXmlns_gd("http://schemas.google.com/g/2005");
									feed.setId("http://www.tematika.com/feed/userid/" + mail + "/" + 0 + "/wishlist_" + 1 + ".htm");
									Title title = new Title("Lista de Deseos de " +  mail, "text");
									feed.setTitle(title);
									Link link = new Link("self", "application/atom+xml", "http://www.tematika.com/feed/userid/" + mail + "/" + 0 + "/wishlist_" + 1 + ".htm");
									feed.setLink(link);
									feed.setUpdated(new Date());
									Author author = new Author(mail);
									feed.setAuthor(author);
									Category category = new Category ("http://schemas.google.com/g/2005#kind",
												"http://schemas.popego.com#wishlist");
									feed.setCategory(category);
									feed.setOpenSearch_totalResults(new Integer(new Double(0).intValue()));
									feed.setOpenSearch_startIndex (new Integer(new Double((1)).intValue()));
									feed.setOpenSearch_itemsPerPage(new Integer(new Double(WishListFeed.itemsPerPage).intValue()));

//									CREO EL FEED
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
									xstream.registerLocalConverter(Feed.class, "title", new FeedTitleToStringConverter());
									xstream.useAttributeFor(Link.class, "rel");
									xstream.useAttributeFor(Link.class, "type");
									xstream.useAttributeFor(Link.class, "href");
									xstream.registerConverter(new ISO8601DateConverter());
									xstream.useAttributeFor(Category.class, "scheme");
									xstream.useAttributeFor(Category.class, "term");
									xstream.aliasField("openSearch:totalResults", Feed.class, "openSearch_totalResults");
									xstream.aliasField("openSearch:startIndex", Feed.class, "openSearch_startIndex");
									xstream.aliasField("openSearch:itemsPerPage", Feed.class, "openSearch_itemsPerPage");
									PrintWriter out = response.getWriter();
									out.print("<?xml version='1.0' encoding='ISO-8859-1'?>" + xstream.toXML(feed));


								} catch (Exception e) {
									response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
								}
							} catch(Exception e) {
								response.sendError(HttpServletResponse.SC_NOT_FOUND, "No existe el usuario " + mail);
							}
						} catch (Exception e) {
							response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
						} finally {
							conn.close();
						}
					} catch (Exception e) {
						response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
					}
				}
			} else {
				//falta parametro
				response.sendError(HttpServletResponse.SC_BAD_REQUEST, "No se han completado los parametros correctamente.");

			}
		} catch (Exception e) {
			TmkLogger.debug(this.getClass().getName() + "] Error " + e.toString() + MainHelper.getMessage(e));
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

		}
	}


}
