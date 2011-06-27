package com.tmk.controllers.mensaje;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
//import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.mensaje.MensajeService;
import com.tmk.xml.mensaje.Mensajes;

public class GetMensaje extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			Mensajes mensajes =  MensajeService.getMensajeDeUsuario(request);
			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.alias("mensajes", Mensajes.class);
			out.print(Convert.toFixedJSON(xstream.toXML(mensajes)));
		} catch (Exception e) {
			TmkLogger.error(this.getClass().getName() + "]" + e.toString() + MainHelper.getMessage(e));
		}
	}
}
