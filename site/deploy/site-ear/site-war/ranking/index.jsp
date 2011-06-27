<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert" %>
<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
	request.setAttribute("idSeccion", new Integer(idSeccion));
%> 

<tiles:insert definition="seccion.general.ranking"/>
