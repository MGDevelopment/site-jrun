<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<%
	session.removeAttribute("resultadoBusquedaForm");	
%>
<div id="seccionTematika">
	<div style="width:800px;  margin:auto; margin-top:0px;" id="DivContenedor">	
		<tiles:insert name="body" flush="true"/>
	</div>
</div>