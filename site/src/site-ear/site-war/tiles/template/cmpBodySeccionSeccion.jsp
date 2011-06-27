<%@page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%
	session.removeAttribute("resultadoBusquedaForm");	
%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<div id="seccionTematika">
	 <div style="float:left; display:block;">
		<div  style="position:fixed;"><a href="/<%=Globals.seccion(idSeccion)%>"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de <%=Globals.textoSolapa(idSeccion)%>"></a></div>
	</div>
	<%--<a href="/<%=Globals.seccion(idSeccion)%>" class="seccionTmkLink" title="home de <%=Globals.textoSolapa(idSeccion)%>"></a>--%>
	<tiles:insert name="mesa" />
	<tiles:insert name="arbol" />
	<tiles:insert name="comentario" flush="true"/>
	<%--	
	<tiles:insert name="lista" flush="true"/>	
	<tiles:insert name="usuario" flush="true"/>
	<tiles:insert name="etiqueta" flush="true"/>
	--%>
	<div style="width:650px; padding-top:10px; float:right;" >
	<!-- <div style="width:600px; margin:auto; margin-top:60px;" id="DivContenedor" >-->
		<%
			String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + idSeccion;
	    %>
	    <jsp:include page="<%=ultimosVisitadosPage%>"/>
    </div>
</div>
<%=Globals.getGoogleAnalytics()%>