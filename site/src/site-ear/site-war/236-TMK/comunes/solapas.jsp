<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.usuario.UsuarioHelper"%>

<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null) {%><jsp:forward page="<%=UsuarioHelper.PAGINA_PRINCIPAL_USUARIO%>"/>
<%}%>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td align="right" style="background: url('/imagenes/intranet/fondo_solapas.gif'); repeat-x">

	  <%if (usuarioDAO.tieneAlgunAcceso("EVENTOS")) {%>
	  <a href="/236-TMK/eventos/"><img src="/imagenes/intranet/solapa_eventos.gif" border="0"></a>
	  <%}%>

      <%if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_BUSCAR")) {%>
	  <a href="/236-TMK/ordenes/index.jsp"><img src="/imagenes/intranet/solapa_ordenes.gif" border="0"></a>
	  <%}%>

	  <%if (usuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")) {%>
	  <a href="/236-TMK/contenido/index.jsp"><img src="/imagenes/intranet/solapa_contenidos.gif" border="0"></a>
      <%}%>

	  <%if (usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {%>
	  <a href="/236-TMK/alianzas/index.jsp"><img src="/imagenes/intranet/solapa_alianzas.gif" border="0"></a>
      <%}%>

      <%if (usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {%>
	  <a href="/236-TMK/usuarios/index.jsp"><img src="/imagenes/intranet/solapa_usuarios.gif" border="0"></a>
      <%}%>

      <%if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR")) {%>
	  <a href="/236-TMK/comentario/aprobarComentario.jsp"><img src="/imagenes/intranet/solapa_comentarios.gif" border="0"></a>
      <%}%>

      <%/*Estatización*/%>
      <%if (usuarioDAO.tieneAlgunAcceso("GENERAR_CONTENIDOS_ESTATICOS")) {%>
      <a href="/236-TMK/generacion/index.jsp"><img src="/imagenes/intranet/solapa_generacion.gif" border="0"></a>
      <%}%>

	</td>
  </tr>
  <tr>
    <td height="12" style="background: url('/imagenes/intranet/fondo_renglon.gif');repeat-x"></td>
  </tr>
</table>
