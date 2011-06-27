<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<div id="seccionTematika">
	<tiles:insert name="body"/>
	<jsp:include page="/templates/templates/tmpListaYLoginModal.htm"/>
</div>
<%=Globals.getGoogleAnalytics()%>