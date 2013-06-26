<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="idSeccion" scope="session" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idGrupo" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idSubFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="detalle" scope="page" ignore="true" classname="java.lang.String"/>
<script type="text/javascript" src="/js/dropDownMenu.js"></script>
<script type="text/javascript" src="/js/equalcolumns.js"></script>
<script type="text/javascript" src="/js/menuarbol.js"></script>
<script type="text/javascript" src="/js/buscador.js"></script>
<script type="text/javascript" src="/js/jsutil.js"></script>
<script type="text/javascript" src="/js/carritoNew.js"></script>
<script type="text/javascript" src="/js/popups.js"></script>
<script type="text/javascript" src="/js/mensaje.js"></script>
<%--<script type="text/javascript" src="/js/prototype-1.6.0.3.js"></script>--%>
<%--
<script type="text/javascript">	
	<%@include file="/js/dropDownMenu.js"%>
	<%@include file="/js/equalcolumns.js"%>
	<%@include file="/js/menuarbol.js"%>
	<%@include file="/js/buscador.js"%>
	<%@include file="/js/jsutil.js"%>
	<%@include file="/js/carritoNew.js"%>
	<%@include file="/js/popups.js"%>
	<%@include file="/js/mensaje.js"%>
</script>
--%>
<script>
$(document).ready(function() {
	carrito_ActualizarCarrito();
	getVisualizaMensaje();
});
</script>
<%
		if (idGrupo != null) {
			StringBuffer subSec = new StringBuffer();
			subSec.append("subSeccion=\"_");
			subSec.append(idGrupo);
			if (idFamilia != null) {
				subSec.append("_").append(idFamilia);
				if (idSubFamilia != null) {
					subSec.append("_").append(idSubFamilia);
				}
			}
			subSec.append("\";");
			request.setAttribute("subSeccion",subSec.toString());
		}
		//indica si necesita mesa 
		request.setAttribute("mesa",true);
		if (detalle != null) {
			request.setAttribute("seccionDetalle",detalle);
		}
%>