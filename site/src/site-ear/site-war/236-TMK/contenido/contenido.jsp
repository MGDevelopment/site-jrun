<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper"%>
<html>
	<%= Globals.estiloBasico() %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);

	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}

	int altoImagen = 88;
	int anchoImagen = 59;

	String id_campo;

	int tipo;
	int indice;

	Producto producto;
	Link link;

	int seccion = Convert.toNumber((request.getParameter(ContenidoHelper.CAMPO_SECCION)), Globals.SECCION_HOME);

	Pagina pagina = Contenido.getPagina(seccion);
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
<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table cellpadding="0" cellspacing="0" align="center" bgcolor="#FFFFFF" width="770">
	<tr>
		<td>
		<table width="100%" align="center" cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<jsp:include page="/236-TMK/comunes/header.jsp"/>
								</td>
							</tr>
						</table>

			<table cellspacing="0" cellpadding="0" align="center" width="650">
			<tr>
				<td>
					<font class="TextoBordo">
						<br>Producto Principal
					</font>

					<br><br>

				</td>
			</tr>
			</table>

			<%	tipo = ContenidoHelper.HOME;
				indice = 0;

				Home home = pagina.getHome();
				if (home != null) {
					producto = home.getProducto();
					link = home.getLink();
			%>
					<table cellspacing="0" cellpadding="0" align="center" width="500" class="BordeFino" aling="center">
					<tr>
						<td>
							<%@ include file="itemListaMultiple.jsp" %>
						</td>
					</tr>
					</table>
			<%	}
			%>

			<table cellspacing="0" cellpadding="0" align="center" width="650">
			<tr>
				<td>
					<br><br>
					<font class="TextoBordo">
						<%	if ( seccion == Globals.SECCION_HOME) {
						%>
								Productos de categorias
						<%	} else {
						%>
								Novedades
						<% }
						%>
					</font>

					<br><br>

				</td>
			</tr>
			</table>

			<table cellspacing="5" width="500" align="center" class="BordeFino">
			<%	tipo = ContenidoHelper.PRIMER_LISTA;

				PrimerLista primeraLista = pagina.getPrimerLista();

				for (int i = 0; i < primeraLista.getListaMultipleTypeItemCount(); i++) {
					ListaMultipleTypeItem elementoTypeItem = primeraLista.getListaMultipleTypeItem(i);

					if (elementoTypeItem != null) {
			%>
						<tr>
							<td>
								<%	producto = elementoTypeItem.getProducto();
									link = elementoTypeItem.getLink();
									indice = i;
								%>

								<%@ include file="itemListaMultiple.jsp" %>

								<%	if (i < primeraLista.getListaMultipleTypeItemCount() - 1) {
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

			<%	if (seccion != Globals.SECCION_HOME) {
			%>
					<table cellspacing="0" cellpadding="0" align="center" width="650">
					<tr>
						<td>
							<br><br>
							<font class="TextoBordo">
								Recomendaciones
							</font>

							<br><br>
						</td>
					</tr>
					</table>

					<table cellspacing="0" cellpadding="0" align="center" width="500">
						<tr>
							<td>
								<table cellspacing="5" width="500" align="center" class="BordeFino">
								<%	tipo = ContenidoHelper.SEGUNDA_LISTA;

									SegundaLista segundaLista = pagina.getSegundaLista();
									for (int i = 0; i < segundaLista.getListaMultipleTypeItemCount(); i++) {

										ListaMultipleTypeItem item = segundaLista.getListaMultipleTypeItem(i);

									%>
										<tr>
											<td>
												<%	producto = item.getProducto();
													link = item.getLink();
													indice = i;
												%>

												<%@ include file="itemListaMultiple.jsp" %>

												<%	if (i < segundaLista.getListaMultipleTypeItemCount() - 1) {
												%>
														<hr color="#59B3D9" size="1" width="450">
												<%	}
												%>
											</td>
										</tr>
								<%}
								%>
								</table>
							</td>
						</tr>
					</table>
			<%	}
			%>


      <table width="513" align="center">
        <tr>
				<td width="550">
				</td>
				<td>
					<br><br>
					<a href="/236-TMK/contenido">
						<img src="/imagenes/botonVolver.gif" border="0">
					</a>
				</td>
			</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>
