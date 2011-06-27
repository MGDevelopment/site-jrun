package com.tmk.controllers.articulo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.ArticuloManager;

public class GetTotalArticulosGroupByCat extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String filtro = request.getParameter("filtro");


		PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
		xstream.alias("total", Vector.class);
		Pattern pt= Pattern.compile("(\\{)(\\\"[^\\\"]+\\\")([^:}]*)(\\})");
		String strJSON = "";
		if (filtro == null || "M".equals(filtro)) {
			strJSON = xstream.toXML(ArticuloManager.totalArticulosM);
		}
		if ("Y".equals(filtro)) {
			strJSON = xstream.toXML(ArticuloManager.totalArticulosY);
		}
		if ("T".equals(filtro)) {
			strJSON = xstream.toXML(ArticuloManager.totalArticulos);
		}

		Matcher mt= pt.matcher(strJSON);
		String correctJsonStr= mt.replaceAll("$2");
		out.print(correctJsonStr.replaceAll("\n", "").replaceAll("\r", ""));
	}
}
