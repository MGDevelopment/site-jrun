<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<div id="seccionTematika">
	<a href="/<%=Globals.seccion(idSeccion)%>" class="seccionTmkLink" title="home de <%=Globals.textoSolapa(idSeccion)%>"></a>
	<tiles:insert name="arbol" flush="true"/>
	<div style="width:650px;  margin:auto; margin-top:15px;float:left;" id="DivContenedor">
		<tiles:insert name="body" flush="true"/>
   	</div>
</div>
<%=Globals.getGoogleAnalytics()%>