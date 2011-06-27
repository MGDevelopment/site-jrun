<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%
	session.removeAttribute("resultadoBusquedaForm");
%>
<div id="seccionTematika">
	<div style="width:850px;  margin:auto; margin-top:15px;">
		<tiles:insert attribute="body"> </tiles:insert>
	</div>
</div>

