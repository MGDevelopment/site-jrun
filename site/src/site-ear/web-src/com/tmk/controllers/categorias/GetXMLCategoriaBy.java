package com.tmk.controllers.categorias;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.categoria.CategoriaService;
import com.tmk.xml.converter.CapitalizarDescripcionConverter;
import com.tmk.xml.converter.CategoriaPKConverter;

public class GetXMLCategoriaBy extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), (Integer)null);
		Integer idGrupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO), (Integer)null);
		Integer idFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA), (Integer)null);
		Integer idSubFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SUB_FAMILIA), (Integer)null);
		boolean subCategorias = Convert.toBoolean(request.getParameter(MainHelper.PARAM_SUB_CATEGORIAS), false);
		boolean incluyeCategoria = Convert.toBoolean(request.getParameter(MainHelper.PARAM_INCLUYE_CATEGORIA), true);

		CategoriaPK categoriaPK = null;
		Categoria categoria = null;

		response.setContentType("text/xml");
		PrintWriter out = response.getWriter();
		try {
			out.print("<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");
			XStream xstream = new XStream(new DomDriver());
			xstream.useAttributeFor(Categoria.class, "categoriaPK");
			xstream.aliasAttribute("value", "categoriaPK");
			xstream.alias("categoria", Categoria.class);
			xstream.registerConverter(new CategoriaPKConverter());
			xstream.registerConverter(new CapitalizarDescripcionConverter());
			if (subCategorias) {
				xstream.addImplicitCollection(Categoria.class, "subCategoria");
			} else {
				xstream.omitField(Categoria.class, "subCategoria");
			}
		    xstream.addImplicitCollection(Categoria.class, "descripcion");

			if (idSeccion != null) {
				if (idGrupo != null) {
					if (idFamilia != null) {
						if (idSubFamilia != null) {
							categoriaPK = new CategoriaPK (new Integer[]{idSeccion, idGrupo, idFamilia, idSubFamilia});
						} else {
							categoriaPK = new CategoriaPK (new Integer[]{idSeccion, idGrupo, idFamilia});
						}
					} else {
						categoriaPK = new CategoriaPK (new Integer[]{idSeccion, idGrupo});
					}
				} else {
					categoriaPK = new CategoriaPK (new Integer[]{idSeccion});
				}

				categoria = CategoriaService.getCategoriaByPK(CategoriaService.categoria, categoriaPK, 0);
				if (categoria != null) {
				    if (incluyeCategoria) {
				    	out.print(xstream.toXML(categoria));
				    } else {
				    	out.print(xstream.toXML(categoria.getSubCategoria()).replaceAll("categoria-array", "categoria"));
				    }
				} else {
					out.println("<error>No se encontró la categoria: " + categoriaPK.toString() + " </error>");
				}
			} else {
			    out.print(xstream.toXML(CategoriaService.categoria).replaceAll("categoria-array", "categoria"));
			}
		} catch (Exception e) {
			TmkLogger.error(this.getClass().getName() + "] " + e.toString() + " " + MainHelper.getMessage(e));
		}
		out.close();
	}

}
