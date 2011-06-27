<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<div id="seccionTematika">

	<a href="#" class="panelSeccAct"></a><!-- link a la home de sección correspondiente -->

	<div class="detalleInfoPrinc">	<!-- **** INFO PRINCIPAL DEL PRODUCTO**** -->
		<tiles:insert name="body"/>
	</div><!-- **** FIN Info Complementaria **** -->

</div>