package com.tmk.controllers.ipn;


import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.xml.dm.ipn.Notificacion;
import com.tmk.xml.dm.ipn.Operacion;

public class NotificacionIPN extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String strNotificacion = request.getParameter("NOTIFICACION");
		 strNotificacion = strNotificacion.replaceAll("NOTIFICACION", "Notificacion");
		 strNotificacion = strNotificacion.replaceAll("TIPONOTIFICACION", "tipoNotificacion");
		 strNotificacion = strNotificacion.replaceAll("OPERACIONES", "operaciones");
		 strNotificacion = strNotificacion.replaceAll("OPERACION", "Operacion");
		 strNotificacion = strNotificacion.replaceAll("TIPO", "tipo");
		 strNotificacion = strNotificacion.replaceAll("ID", "id");
		 XStream xstream = new XStream(new DomDriver());
		 xstream.alias("Notificacion", Notificacion.class);
		 xstream.alias("Operacion", Operacion.class);
		 xstream.alias("operaciones", ArrayList.class);
		
		 Notificacion notificacion = (Notificacion)xstream.fromXML(strNotificacion);
		 
		 StringBuffer strMsj = new StringBuffer("");
		 
		 if (notificacion.esNotificacionDeCambioDeEstado()) {
			 if (notificacion.tieneResultados()) {
				 strMsj.append("Cambio de estado en operaciones con Dinero Mail");
				 for (int i=0; i<notificacion.getOperaciones().length; i++) {
					 if (notificacion.getOperaciones()[i].esNotificacionDeCambioDeEstado()) {
						 strMsj.append(Globals.ENTER).append("Orden: ").append(notificacion.getOperaciones()[i].getId());
					 }	 
				 }
				 MailUtil.sendMail(Globals.MAIL_MAILER, "clopez@ilhsa.com", "TMK Operaciones Dinero Mail - Cambio de estado", strMsj.toString());
			 }
		 }
		

	 }
}
