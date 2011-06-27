<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<script language="Javascript">if(window.history.forward(1) != null) window.history.forward(1);</script>
<div id="seccionTematika">
	<div style="width:800px;  margin:auto; margin-top:0px;" id="DivContenedor">	
		<tiles:insert name="body" flush="true"/>
	</div>
</div>