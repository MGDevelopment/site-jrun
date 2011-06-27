<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true"	classname="java.lang.Integer" />
<div id="seccionTematika">
<div style="float: left; display: block;">
<div style="position: fixed;"><a href="/<%=Globals.seccion(idSeccion)%>"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de <%=Globals.textoSolapa(idSeccion)%>"></a></div>
</div>
<tiles:insert attribute="mesa" flush="true" /> 
<tiles:insert attribute="arbol" flush="true" /> 
<tiles:insert name="comentario" flush="true"/> 
<tiles:insert attribute="catalogo" flush="true" />
<%--<jsp:include page="/tiles/elemento/categorias/verFamilia.jsp" flush="true"/> --%>
	<%--<tiles:insert name="lista" flush="true"/>
	<tiles:insert name="usuario" flush="true"/>
	<tiles:insert name="etiqueta" flush="true"/>--%>
<div style="width: 605px; padding-top: 10px; float: right;"><div style="float: left;">
<%
	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion="	+ idSeccion;
%> 
<jsp:include page="<%=ultimosVisitadosPage%>" /></div></div></div>