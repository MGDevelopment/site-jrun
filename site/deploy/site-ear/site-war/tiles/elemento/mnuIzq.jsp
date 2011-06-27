<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>

<%@page import="com.tmk.kernel.Globals"%><tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<%
	try {
		Template tmpMnuIzq  = (Template)ServiceLocator.getTemplateService().getTemplate("mnuTmp");
		tmpMnuIzq.setParam("class","panelSeccionesLeft");
		int fin = MainHelper.getIndexMnuSeccion(idSeccion.intValue());
		for(int i=0; i<fin; i++) {
			tmpMnuIzq.setParam("seccion"+MainHelper.mnuSeccion[i],"true");
		}
		if(fin ==3 && idSeccion.equals(Globals.SECCION_HOME)) {
			tmpMnuIzq.setParam("seccion"+MainHelper.mnuSeccion[3],"true");
		}
		out.println(tmpMnuIzq.output());
	} catch(Exception e) {
		TmkLogger.debug(e);
	}
%>
