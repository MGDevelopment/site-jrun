
<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 java.util.Enumeration"%>

<%
	if ((!Globals.sitioDisponible()) &&
        (Convert.toBoolean(request.getParameter("CONTROLAR_SERVER"),true)) &&
        (Convert.toBoolean(session.getAttribute("RESPETAR_MODO"), true))) {%>

	<jsp:forward page="/mantenimiento.jsp"/>
<% }
	// Controla si debe continuar
	if (Globals.esModoRelease()) {
		// pasa a modo seguro si debe
		synchronized (session) {
			String referer = request.getRequestURL().toString();
			if (referer != null) {
				// listado de paginas que deben procesarse en modo seguro
				String seguras[] = new String[] {"/compra", "/miCuenta", "/listaDeseos", "/236-TMK", "/extranet", "/afiliados"};
				// Controla si la pagina actual necesita modo seguro
				boolean necesitaSeguridad = false;
				for (int i = 0; (!necesitaSeguridad) && (i < seguras.length); i++) {
					necesitaSeguridad = (referer.indexOf(seguras[i]) >= 0);
				}
				// Recolecta los parametros para pasarlos
				StringBuffer parametros = new StringBuffer();
				Enumeration params = request.getParameterNames();
				while (params.hasMoreElements()) {
					if (parametros.length() == 0) parametros.append("?");
					if (parametros.length() > 1) parametros.append("&");
					String nombreParametro = params.nextElement().toString();
					String valorParametro = request.getParameter(nombreParametro);
					parametros.append(nombreParametro).append("=").append(valorParametro);
				}
				// NO ESTA EN MODO SEGURO Y NECESITA
				if ((necesitaSeguridad) && (referer.indexOf("http:") >= 0)) {
					response.resetBuffer();
					response.sendRedirect(referer.replaceFirst("http:", "https:").replaceFirst("8101","9100") + parametros);
					return;
				}
				// ESTA EN MODO SEGURO Y NO LO NECESITA
				if ((!necesitaSeguridad) && (referer.indexOf("https:") >= 0)) {
					response.resetBuffer();
					response.sendRedirect(referer.replaceFirst("https:", "http:").replaceFirst("9100","8101") + parametros);
					return;
				}
			}
		}
	}


	if (Globals.MODO_APLICACION_HABILITADO) {
		synchronized (session) {
			String referer = request.getRequestURL().toString();
			if ((referer.indexOf("236-TMK")>=0 || referer.indexOf(Globals.DOMINIO_SITIO)==-1) && Globals.esSitio()) {
				response.resetBuffer();
				response.sendRedirect("http://" + Globals.DOMINIO_SITIO);
			}
			if (referer.indexOf(Globals.DOMINIO_INTRANET)==-1 && Globals.esIntranet()) {
				response.resetBuffer();
				response.sendRedirect("http://" + Globals.DOMINIO_INTRANET);
			}
		}
	}
%>
