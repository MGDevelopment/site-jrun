<%@page import="com.tmk.util.HTML.Template"%>
<%--@page import="com.tmk.controllers.MainHelper"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"--%>
<%
	out.println(request.getAttribute("template"));
	session.setAttribute("PAGINA_ACTUAL","2");
%>
<%
	/*Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/tmpCarrito.htm"));

	try {
		Template tmpCarrito  = new Template(path);
		
		out.println(tmpCarrito.output());
	} catch(Exception e) {
		TmkLogger.info(e);
	}*/
%>
