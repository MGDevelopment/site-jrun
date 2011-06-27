<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<div id="seccionTematika">

	<div style="width:800px;  margin:auto; margin-top:80px;" id="DivContenedor">

		<tiles:insert name="arbol"/>
		<tiles:insert name="resultadoDeBusqueda"/>

	</div>

</div>