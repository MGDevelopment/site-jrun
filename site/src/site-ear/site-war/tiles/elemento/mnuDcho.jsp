<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"%>

<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<%
	try {
		Template tmpMnuDcho  = (Template)ServiceLocator.getTemplateService().getTemplate("mnuTmp");
		tmpMnuDcho.setParam("class","panelSecciones");
		int incremento = MainHelper.getIndexMnuSeccion(idSeccion.intValue());
		for(int i = 1 + incremento ; i < MainHelper.mnuSeccion.length;i++) {
			tmpMnuDcho.setParam("seccion"+MainHelper.mnuSeccion[i],"true");
		}
		out.println(tmpMnuDcho.output());
	} catch(Exception e) {
		TmkLogger.info(e);
	}
%>