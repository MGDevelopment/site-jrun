<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.kernel.Convert"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idGrupo" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idSubFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="mostrarTodos" scope="page" ignore="true" classname="java.lang.Integer"/>
<%	idGrupo = request.getParameter("idGrupo");
	idFamilia = request.getParameter("idFamilia");
	idSubFamilia = request.getParameter("idSubFamilia");
	StringBuffer pk = new StringBuffer("/recursos/contenidosEstaticos/familias/arbol");
	pk.append(idSeccion).append("_");

	if(idGrupo != null && !idGrupo.equals(""))
		pk.append(idGrupo).append("_");

	if(idFamilia != null && !idFamilia.equals(""))
		pk.append(idFamilia).append("_");

	if(idSubFamilia != null && !idSubFamilia.equals(""))
		pk.append(idSubFamilia).append("_");
	pk.append(".html");
	pageContext.include(pk.toString());
%>