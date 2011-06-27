<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
	<div class="detalleInfoPrinc">	<!-- **** INFO PRINCIPAL DEL PRODUCTO + MODULO DE COMPRA **** -->
		<div id="dTopLeft">
			<tiles:insert name="detalleDeArticulo"/>


		<tiles:insert name="comentario"/>
		<tiles:insert name="lista"/>
		<tiles:insert name="etiqueta" />

</div><!-- **** FIN Info Complementaria **** -->