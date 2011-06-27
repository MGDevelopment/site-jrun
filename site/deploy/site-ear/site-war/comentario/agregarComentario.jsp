<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.controllers.comentario.ComentarioHelper"%>
<%
MainHelper.controlDeModo(request, response);
SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
SocioPK socioMigracion = (SocioPK)session.getAttribute("socioMigracion");
int idComentario = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ID_COMENTARIO), 0);
int idArticulo = Convert.toNumber(request.getParameter(ComentarioHelper.CAMPO_ARTICULO), 0);
if (idArticulo == 0) {
	idArticulo = Convert.toNumber(request.getParameter("ID_ARTICULO"), 0);
}
//out.println(idArticulo);
if(socioPK == null && socioMigracion == null) {
	session.setAttribute("URL_REDIRECT", "/comentario/agregarComentario.jsp?"
				+ ComentarioHelper.CAMPO_ID_COMENTARIO + "=" + idComentario + "&"
				+ ComentarioHelper.CAMPO_ARTICULO + "=" + idArticulo);
%>


<%@page import="com.tmk.controllers.MainHelper"%>
<jsp:forward page="/miCuenta" />
<%	}
	request.setAttribute("idSeccion", new Integer(Globals.SECCION_GENERAL));
%>
<tiles:insert definition="seccion.general.agregar.comentario"/>