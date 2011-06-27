<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<!-- **** SECCION TEMATIKA **** -->
<div id="seccionTematika">
	<tiles:insert name="mesa"/>
	<tiles:insert name="arbol"/>
	
	<tiles:insert name="comentario" flush="true"/>
	<%--<tiles:insert name="lista" flush="true"/>--%>
	<%--<tiles:insert name="usuario" flush="true"/>--%>
	<%--<tiles:insert name="etiqueta" flush="true"/>--%>
		
	<div style="width:900px; padding-top:10px; float:left;" >
	<%String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + idSeccion;%>
		<jsp:include page="<%=ultimosVisitadosPage%>"/>
	</div>
</div>