<%@ page import="com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.categoria.CategGrupoLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.kernel.Globals,
                 com.tmk.categoria.CategGrupoLocal,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.IdiomaDAO,
                 com.tmk.setup.Contenido" %>

<script type="text/javascript" src="/js/Validation.js" ></script>

<script>
function consultar(){
	form=document.formSearch;
		if (isEmpty(form.<%=BuscadorHelper.POR_TITULO%>.value) &&
		isEmpty(form.<%=BuscadorHelper.POR_AUTOR%>.value) &&
		isEmpty(form.<%=BuscadorHelper.POR_EDITORIAL%>.value) &&
		isEmpty(form.<%=BuscadorHelper.POR_PALABRAS_CLAVES%>.value) &&
		isEmpty(form.<%=BuscadorHelper.POR_ISBN%>.value)) {
			alert ('Debe ingresar al menos un criterio de busqueda');
			return;
		}
	form.submit()
}
</script>

	<table width="616" align="center">
		<tr>
			<td colspan="2"><h3><br><b>Busqueda Avanzada de Libros</b></h3></td>
		</tr>
		<tr>
			<td colspan="2"><b>Ingrese los Criterios de Busqueda</b><br>&nbsp;</td>
		</tr>
		<tr>
			<td width="114" align="right">Titulo: </td>
			<td><input type="text" name="<%=BuscadorHelper.POR_TITULO%>" size="70" maxlength="70" style="font-size: 12px;"></td>
		</tr>
		<tr>
			<td align="right">Autor: </td>
			<td><input type="text" name="<%=BuscadorHelper.POR_AUTOR%>" size="70" maxlength="70" style="font-size: 12px;"></td>
		</tr>
		<tr>
			<td align="right">Editorial: </td>
			<td><input type="text" name="<%=BuscadorHelper.POR_EDITORIAL%>" size="70" maxlength="70" style="font-size: 12px;"></td>
		</tr>
		<tr>
			<td align="right">Palabras Claves: </td>
			<td><input type="text" name="<%=BuscadorHelper.POR_PALABRAS_CLAVES%>" size="70" maxlength="70" style="font-size: 12px;"></td>
		</tr>
		<tr>
			<td align="right">ISBN: </td>
			<td><input type="text" name="<%=BuscadorHelper.POR_ISBN%>" style="font-size: 12px;"></td>
		</tr>
	</table>

	<br>

	<table width="616" align="center">
		<tr>
			<td colspan="5"><br><b>Aplicar Filtros a la Busqueda</b><br>&nbsp;</td>
		</tr>
		<tr>
			<td width="146" align="right">Clasificacion Tematica: </td>
			<td colspan="4">
				<select name="<%=BuscadorHelper.POR_CLASIFICACION_TEMATIKA%>" style="font-size: 12px;">
					<option value="">-No Filtrar-</option>
					<%
						CategGrupoLocalHome grupoHome = (CategGrupoLocalHome)DBUtil.getHome("CategGrupo");
						Iterator grupos = grupoHome.findByCategoria(new Integer(Globals.SECCION_LIBRO)).iterator();
						while (grupos.hasNext()) {
							CategGrupoLocal grupo = (CategGrupoLocal)grupos.next();
					%>
					<option value="<%= grupo.getCATEGORIA_GRUPO() %>"><%= Convert.corregir(grupo.getDESCRIPCION(), true) %></option>
					<%	} %>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">Idioma:</td>
			<td width="98">
				<select name="<%=BuscadorHelper.POR_IDIOMA%>" style="font-size: 12px;">
					<option value="">-No Filtrar-</option>
					<%  for (int i = 0; i < Globals.IDIOMAS.length; i++) {
							IdiomaDAO idiomaDAO = Globals.IDIOMAS[i];
					%>
					<option value="<%= idiomaDAO.getId() %>"><%= idiomaDAO.getNombre() %></option>
				<%}%>
				</select>
			</td>
			<td width="53">Precio:</td>
			<td width="299">
				<select name="<%=BuscadorHelper.POR_PRECIO%>" style="font-size: 12px;">
					<option value="">-No Filtrar-</option>
					<option value="25">Menor a <%= Contenido.precioToString(25) %></option>
					<option value="50">Menor a <%= Contenido.precioToString(50) %></option>
					<option value="75">Menor a <%= Contenido.precioToString(75) %></option>
					<option value="100">Menor a <%= Contenido.precioToString(100) %></option>
				</select>
			</td>
		</tr>
		<tr>
			<td align="right">&nbsp;</td>
			<td colspan="4">&nbsp;</td>
		</tr>
		<tr>
			<td colspan="5" align="right">
				<a href ="javascript:consultar();" style="text-decoration: none; font-weight: bold;" align="middle">
					<img src="/imagenes/buscar.gif" border="0">
				</a>
			</td>
		</tr>
	</table>
