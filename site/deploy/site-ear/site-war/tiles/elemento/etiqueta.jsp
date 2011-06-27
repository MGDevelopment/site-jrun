<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<%
	Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/tmpEtiqueta.htm"));
	try {
		Template tmpMnuDcho  = new Template(path);
		out.println(tmpMnuDcho.output());
	} catch(Exception e) {
//		TmkLogger.info(e);
	}

%>

