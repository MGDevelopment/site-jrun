<%@ page import="com.tmk.kernel.MailUtil, 
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.xml.Resultado,
				 com.tmk.controllers.MainHelper,
				 com.tmk.kernel.TmkLogger,
				 java.util.Vector,
				 com.thoughtworks.xstream.XStream,
				 com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver"%>
<%
	String correoAmigo = Convert.toString(request.getParameter("correoAmigo"), null);
	String correoPropio = Convert.toString(request.getParameter("correoPropio"), null);
	String nombrePropio = Convert.toString(request.getParameter("nombrePropio"), null);
	String urlPage = Convert.toString(request.getParameter("urlPage"), null);
	XStream xstream = new XStream(new JsonHierarchicalStreamDriver()); 
	xstream.alias("Resultado", Resultado.class);
	Resultado resultado = null;
	if (correoAmigo == null || correoPropio == null || nombrePropio == null) {
		Vector campo = new Vector();
		Vector mensaje = new Vector();
		if (correoAmigo == null) {
			mensaje.add("El campo \"Correo de tu amigo\" es requerido.");
			campo.add("correoAmigo");
		}
		if (correoPropio == null) {
			mensaje.add("El campo \"Tu correo\" es requerido.");
			campo.add("correoPropio");
		}
		if (nombrePropio == null) {
			mensaje.add("El campo \"Tu nombre\" es requerido.");
			campo.add("nombrePropio");
		}
		if (campo.size()<2) {
			mensaje.add("Por favor completalo he intenta nuevamente.");
		} else {
			mensaje.add("Por favor completalos he intenta nuevamente.");
		}	 
		resultado = new Resultado (false,(String[]) mensaje.toArray(new String[mensaje.size()]), (String[])campo.toArray(new String[campo.size()]));
	} else if (!MainHelper.esEMail(correoAmigo) || !MainHelper.esEMail(correoPropio)) {
		Vector campo = new Vector();
		Vector mensaje = new Vector();
		if (!MainHelper.esEMail(correoAmigo)) {
			mensaje.add("El campo \"Correo de tu amigo\" no corresponde a un formato de email valido.");
			campo.add("correoAmigo");			
		}
		if (!MainHelper.esEMail(correoPropio)) {
			mensaje.add("El campo \"Tu Correo\" no corresponde a un formato de email valido.");
			campo.add("correoPropio");			
		}
		if (campo.size()<2) {
			mensaje.add("Por favor modificalo he intenta nuevamente.");
		} else {
			mensaje.add("Por favor modificalos he intenta nuevamente.");
		}	 
		resultado = new Resultado (false,(String[]) mensaje.toArray(new String[mensaje.size()]), (String[])campo.toArray(new String[campo.size()]));
	} else {	
		try {
			StringBuffer subject = new StringBuffer(nombrePropio);
			subject.append(" te envia un producto para que lo veas en Tematika.com.");
			StringBuffer body = new StringBuffer("Hola");
			body.append(Globals.ENTER).append(Globals.ENTER).append(Globals.ENTER);
			body.append("Este producto en Tematika.com puede interesarte.").append(Globals.ENTER);
			body.append(Globals.ENTER).append(urlPage);
			body.append(Globals.ENTER).append(Globals.ENTER).append(Globals.ENTER);
			body.append("-").append(nombrePropio).append(" ").append("(").append(correoPropio).append(")");
			MailUtil.sendMail(correoPropio, correoAmigo, subject.toString(), body.toString());
			resultado = new Resultado (true, null, null);
		} catch (Exception e) {
			resultado = new Resultado (false, new String[]{"Se ha producido un error por favor aguarde unos momentos he intentelo nuevamente"}, null);
			String err = "Error en envio de recomendacion] "  + e.toString() + " " + MainHelper.getMessage(e);
			MainHelper.enviarMailDeError(err);
			TmkLogger.error(err);
		}	
	}	
	out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	
%>