<%@page import="com.tmk.kernel.Globals"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>

<%	
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_GENERAL)); 
%> 

<tiles:insert definition="seccion.mensajes"/>