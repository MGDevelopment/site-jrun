<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<div id="seccionTematika">
	<%if (idSeccion != Globals.SECCION_HOME) {%>
		<a href="/<%=Globals.seccion(idSeccion)%>" class="seccionTmkLink" title="home de <%=Globals.textoSolapa(idSeccion)%>"></a>		
		<tiles:insert name="arbol" flush="true"/>
	<%}else{%>
		<div style="float:left; display:block;width: 900px;">
			<div  style="float: right;width: 220px;"><a href="/juguetes/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de pasatiempos"></a></div>
			<div  style="float: right;width: 220px;"><a href="/peliculas/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de peliculas"></a></div>
			<div  style="float: right;width: 220px;"><a href="/musica/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de musica"></a></div>
			<div  style="float: right;width: 220px;"><a href="/libros/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de libros"></a></div>
		</div>
	<%}%>

	<div style="width:600px; margin:auto; margin-top:60px; float:left" id="DivContenedor" >
		<tiles:insert name="busqueda" flush="true"/>
		<%
			String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + idSeccion;
	    %>
	    <!-- jsp:include page="<%//=ultimosVisitadosPage%>"/-->
    </div>

</div>