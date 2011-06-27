<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>

<%	id_campo = new StringBuffer().append(seccion).append(tipo).append(indice).toString();

	String id = null;
	String texto = null;
	String hint = null;
	String icono = null;


	if (producto != null) {
		id = String.valueOf(producto.getId());
		texto = Convert.toString(producto.getTexto());
		hint = Convert.toString(producto.getHint());
		icono = Convert.toString(producto.getIcono());
	} else if (link != null) {
		id = Convert.toString(link.getPagina());
		texto = Convert.toString(link.getTexto());
		hint = Convert.toString(link.getHint());
		icono = Convert.toString(link.getIcono());
	}
%>

<form name="frm_<%= id_campo%>" action="/ActualizarItemListaMultiple">
	<a name="<%= id_campo %>">
		&nbsp
	</a>

	<input type="hidden" name="<%= ContenidoHelper.CAMPO_SECCION %>" value="<%= seccion %>">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_TIPO %>" value="<%= tipo %>">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_INDICE %>" value="<%= indice %>">

	<table cellspacing="5">
	<tr>
		<td>
			<select name="<%= ContenidoHelper.CAMPO_COMPONENTE %>">
				<option value="<%= ContenidoHelper.PRODUCTO %>" <%= (producto != null) ? "selected" : "" %>>
					PRODUCTO
				</opction>
				<option value="<%= ContenidoHelper.LINK %>" <%= (link != null) ? "selected" : "" %>>
					LINK
				</opction>
			</select>
		</td>
	</tr>

	<tr>
		<td width="75%">
			<table cellspacing="5" width="100%">
				<tr>
					<td align="right">
						<%	if (producto != null) {
						%>
								ID:
						<%	} else if (link != null) {
						%>
								Pagina:
						<%	}
						%>
					</td>
					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_ID %>" value="<%= id %>">
					</td>
				</tr>
				<tr>
					<td align="right">
						Texto:
					</td>

					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_TEXTO %>" value="<%= texto %>">
					</td>
				</tr>
				<tr>
					<td align="right">
						Ayuda:
					</td>

					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_HINT %>" value="<%= hint %>">
					</td>
				</tr>
				<tr>
					<td align="right">Imagen:</td>

					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_ICONO %>" value="<%= icono %>">
					</td>
				</tr>
			</table>
		</td>
		<td>
			<%	if (producto != null) {
			%>
					<%@ include file="/componentes/comunes/elementoArticulo.jsp" %>
			<%	}
			%>
		</td>
	</tr>

	<tr>
		<td colspan="2" align="right">
			<table width="100" aling="right">
			<tr>
				<%	if (tipo != ContenidoHelper.HOME) {
				%>
						<td align="right" width="100">
							<br>
							<a href="/DuplicarItemListaMultiple?<%= ContenidoHelper.CAMPO_SECCION %>=<%= seccion %>
									&<%= ContenidoHelper.CAMPO_TIPO %>=<%= tipo %>
									&<%= ContenidoHelper.CAMPO_INDICE %>=<%= indice %>">
								<img src="/imagenes/botonAgregar.jpg" border="0" alt="Agregar">
							</a>
							<br>
						</td>

						<td align="right" width="100">
							<br>
							<a href="/EliminarItemListaMultiple?<%= ContenidoHelper.CAMPO_SECCION %>=<%= seccion %>
									&<%= ContenidoHelper.CAMPO_TIPO %>=<%= tipo %>
									&<%= ContenidoHelper.CAMPO_INDICE %>=<%= indice %>">
								<img src="/imagenes/botonEliminar.jpg" border="0" alt="Eliminar">
							</a>
							<br>
						</td>
				<%	}
				%>

				<td align="right" width="100">
					<br>
						<input type="image" src="/imagenes/botonActualizar.jpg" alt="Actualizar">
					<br>
				</td>
			</tr>
			</table>
		</td>
	</tr>
	</table>
</form>