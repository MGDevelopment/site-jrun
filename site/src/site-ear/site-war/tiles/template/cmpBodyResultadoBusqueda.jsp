<%--@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<div id="seccionTematika">
	<a class="panelSeccAct" href="/<%=Globals.seccion(idSeccion)%>"></a>
	<tiles:insert attribute="body"/>	
</div>--%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<div id="seccionTematika">
	<%if (idSeccion != Globals.SECCION_HOME) {%>
		<a class="panelSeccAct" href="/<%=Globals.seccion(idSeccion)%>"></a>					
	<%}else{%>
		<div style="float:left; display:block;width: 900px;">
			<div  style="float: right;width: 220px;"><a href="/juguetes/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de pasatiempos"></a></div>
			<div  style="float: right;width: 220px;"><a href="/peliculas/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de peliculas"></a></div>
			<div  style="float: right;width: 220px;"><a href="/musica/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de musica"></a></div>
			<div  style="float: right;width: 220px;"><a href="/libros/"><img src="/imagenes/blank.gif" border="0px" width="210px" height="60px" title="home de libros"></a></div>
		</div>
	<%}%>

	<tiles:insert attribute="body"/>	
	<jsp:include page="/templates/templates/tmpListaYLoginModal.htm"/>
</div>