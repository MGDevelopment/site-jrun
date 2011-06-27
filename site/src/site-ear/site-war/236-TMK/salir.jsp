<%@ page import="com.tmk.controllers.intranet.admin.LoginIntranet"%>

<%	session.removeAttribute(LoginIntranet.USUARIO_EXTRANET);
%>

<jsp:forward page="/236-TMK/index.jsp" />