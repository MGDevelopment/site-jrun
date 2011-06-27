<%@page import="java.util.Enumeration"%>
<%-- 
	se deja esta jsp, para mantener compatibilidad con los links, que estan indexados por google
	esta jsp pasa todos los parametros del request a ResultadoDeBusquedaAction.java
--%>	
<%		
	Enumeration e = request.getParameterNames();
	StringBuffer params = new StringBuffer("");
	String nombre;
	
	while (e.hasMoreElements()) {
		nombre = e.nextElement().toString();
		params.append(nombre).append("=").append(request.getParameter(nombre)).append("&");
	}
	if(params.length() > 0)
		params = new StringBuffer(params.substring(0,params.length() - 1));
			
	response.sendRedirect("/buscar.do?"+params.toString());
%>