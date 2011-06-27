<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper"%>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}

	int altoImagen = 88;
	int anchoImagen = 59;

	int indice;
	int componente = ContenidoHelper.PAPEL_REGALO;
	int seccion = 0;
	int tipo = 0;
%>

	<style type="text/css" rel="stylesheet">
		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		table.BordeFino
		{
			border-collapse: collapse;
			border: 2px solid;
			border-color: #5AB5DE;
		}
	</style>
	<%= Globals.estiloBasico() %>

<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" width="770" height="100%"><tr><td>
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<jsp:include page="/236-TMK/comunes/header.jsp"/>
			</td>
		</tr>
	</table>

	<table cellspacing="5" width="500" align="center" class="BordeFino">

	<%	PapelesDeRegalo papelesDeRegalo = Contenido.getSite().getPapelesDeRegalo();

		for (int i = 0; i < papelesDeRegalo.getListaProductosTypeItemCount(); i++) {
			ListaProductosTypeItem elementoTypeItem = papelesDeRegalo.getListaProductosTypeItem(i);

			if (elementoTypeItem != null) {
	%>
				<tr>
					<td>
						<%  Producto producto = elementoTypeItem.getProducto();
							indice = i;
						%>

						<%@ include file="itemListaProducto.jsp" %>

						<%	if (i < papelesDeRegalo.getListaProductosTypeItemCount() - 1) {
						%>
								<hr color="#59B3D9" size="1" width="450">
						<%	}
						%>
					</td>
				</tr>
	<%		}
		}
	%>
	</table>


<table width="512" align="center">
  <tr>
		<td width="468">
		</td>

		<td width="32">
			<br><br>
			<a href="/236-TMK/contenido">
				<img src="/imagenes/botonVolver.gif" border="0">
			</a>
		</td>
	</tr>
	</table>
</td></tr></table>
</body>
</html>
