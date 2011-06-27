<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>
<form name="frm_<%= indice %>" action="/ActualizarItemListaProductos">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_COMPONENTE%>" value="<%= componente %>">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_SECCION%>" value="<%= seccion %>">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_TIPO%>" value="<%= tipo %>">
	<input type="hidden" name="<%= ContenidoHelper.CAMPO_INDICE%>" value="<%= indice %>">

	<table cellspacing="5">
	<tr>
		<%	switch(componente) {
				case ContenidoHelper.PAPEL_REGALO:
		%>
					<td>
						Papel de Regalo
						<input type="hidden" value="<%= ContenidoHelper.PAPEL_REGALO %>">
					</td>
		<%			break;
				case ContenidoHelper.RECOMENDADO:
		%>
					<td>
						Producto de Lista de Deseos
						<input type="hidden" value="<%= ContenidoHelper.RECOMENDADO %>">
					</td>
		<%  	    break;

				case ContenidoHelper.RANKING:
		%>
					<td>
						Producto de Ranking
						<input type="hidden" value="<%= ContenidoHelper.RANKING %>">
					</td>
		<%			break;

				default:
					return;
			}
		%>
	</tr>

	<tr>
		<td width="75%">
			<table cellspacing="5" width="100%">
				<tr>
					<td align="right">
						ID:
					</td>
					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_ID %>" value="<%= producto.getId() %>">
					</td>
				</tr>
				<tr>
					<td align="right">
						Texto:
					</td>
					<%	String texto = Convert.toString(producto.getTexto());
					%>
					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_TEXTO %>" value="<%= texto %>">
					</td>
				</tr>
				<tr>
					<td align="right">
						Ayuda:
					</td>
					<%	String hint = Convert.toString(producto.getHint());
					%>
					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_HINT %>" value="<%= hint %>">
					</td>
				</tr>
				<tr>
					<td align="right">Imagen:</td>
					<%	String icono = Convert.toString(producto.getIcono());
					%>
					<td align="center">
						<input size="50" type="text" name="<%= ContenidoHelper.CAMPO_ICONO %>" value="<%= icono %>">
					</td>
				</tr>
			</table>
		</td>
		<td>
			<%@ include file="/componentes/comunes/elementoArticulo.jsp" %>
		</td>
	</tr>

		<tr>
		<td colspan="2" align="right">
			<table width="100" aling="right">
			<tr>
				<td align="right" width="100">
					<br>
					<a href="/DuplicarItemListaProductos?<%= ContenidoHelper.CAMPO_SECCION %>=<%= seccion %>
							&<%= ContenidoHelper.CAMPO_TIPO %>=<%= tipo %>
							&<%= ContenidoHelper.CAMPO_INDICE %>=<%= indice %>
							&<%= ContenidoHelper.CAMPO_COMPONENTE %>=<%= componente %>">
						<img src="/imagenes/botonAgregar.jpg" border="0" alt="Agregar">
					</a>
					<br>
				</td>

				<td align="right" width="100">
					<br>
					<a href="/EliminarItemListaProductos?<%= ContenidoHelper.CAMPO_SECCION %>=<%= seccion %>
									&<%= ContenidoHelper.CAMPO_TIPO %>=<%= tipo %>
									&<%= ContenidoHelper.CAMPO_INDICE %>=<%= indice %>
									&<%= ContenidoHelper.CAMPO_COMPONENTE %>=<%= componente %>">
						<img src="/imagenes/botonEliminar.jpg" border="0" alt="Eliminar">
					</a>
					<br>
				</td>

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
