<%@ page import="com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.site.Paginas,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Pagina,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>
<%
    /*Modificacion9*/
    String linkNoFollow = "rel='nofollow'";
%>
<script type="text/javascript" src="/js/Validation.js"></script>
<script type="text/javascript">
function validarBuscador() {
	var form = document.formBuscador;
	if (isEmpty(form.<%=BuscadorHelper.TEXTO%>.value)) {
		alert('La busqueda no puede estar vacia.');
		return false;
	}
	<%int cantidadMinimaDeCaracteresABuscar = 1;%>
	if (form.<%=BuscadorHelper.TEXTO%>.value.length <= <%=cantidadMinimaDeCaracteresABuscar%>) {
		alert('El texto de busqueda debe ser mayor a <%=cantidadMinimaDeCaracteresABuscar%> caracter');
		return false;
	}

	formBuscador.submit();
}

function comboSubmit(event) {
	if (event.keyCode == 13) {
		validarBuscador()
	}
}
</script>

<table align="center">
	<form name="formBuscador" action="<%=BuscadorHelper.PAGINA_BUSCADOR%>" method="post" onSubmit="return validarBuscador()">
		<tr>
			<td>
				<b>BUSQUEDA RAPIDA</b>
			</td>
			<td>
				<input type="hidden" name="<%=BuscadorHelper.CATEGORIA_SECCION%>" value="<%=Globals.SECCION_REVISTAS%>">
				<input type="text" name="<%=BuscadorHelper.TEXTO%>" >
			</td>
			<td >
				<select name="<%=BuscadorHelper.CLAVE_DE_BUSQUEDA%>" onKeyPress="comboSubmit(event)">
					<option value="<%=BuscadorHelper.POR_TITULO%>">Por T&iacute;tulo</option>
					<option value="<%=BuscadorHelper.POR_PALABRAS_CLAVES%>">Por Palabras Claves</option>
					<option value="<%=BuscadorHelper.POR_AUTOR%>">Por Autor</option>
					<option value="<%=BuscadorHelper.POR_EDITORIAL%>">Por Editorial</option>
					<option value="<%=BuscadorHelper.POR_ISBN%>">Por ISBN</option>
				</select>
            </td>
			<td valign="bottom">
				<a onClick="javascript:validarBuscador()"><img src="/imagenes/botonBuscar.gif" border=0></a>
			</td>
			<td>
                <% String pagBuscador = "/articulo/buscadorAvanzado.jsp?" + BuscadorHelper.CATEGORIA_SECCION + "=" + Globals.SECCION_REVISTAS;%>
				<a href="<%=pagBuscador%>" <%=linkNoFollow%> style="text-decoration: none; font-weight: bold;">BUSQUEDA AVANZADA</a>
			</td>
		</tr>
	</form>
</table>


