<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<div id="seccionTematika2">	
	<div class="arbolCat">
		<div class="arbol">
			<div class="arbolLibros">			
				<div id="width:205px;border:1px solid #F5CFAA;">
					<jsp:include page="/tiles/elemento/miCuenta/rediseno/menuMiCuenta.jsp"/>
				</div>			
			</div>
		</div>
	</div>
	<div style="float:left;width:670px;">
		<div>
			<div style="margin-top:10px">
				<tiles:insert attribute="body"/>				
			</div>
		</div>
	</div>
</div>