<%@ page import="com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.site.Paginas,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.site.Pagina,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>

<script type="text/javascript" src="/js/Validation.js"></script>
<script type="text/javascript">
function validarBuscador() {
	var form = document.formBuscador;
	if (isEmpty(form.<%=BuscadorHelper.TEXTO%>.value)) {
		alert('La búsqueda no puede estar vacía.');
		return false;
	}
	<%int cantidadMinimaDeCaracteresABuscar = 1;%>
	if (form.<%=BuscadorHelper.TEXTO%>.value.length <= <%=cantidadMinimaDeCaracteresABuscar%>) {
		alert('El texto de búsqueda debe ser mayor a <%=cantidadMinimaDeCaracteresABuscar%> caracter');
		return false;
	}
	document.formBuscador.submit();
}

function comboSubmit(event) {
	if (event.keyCode == 13) {
		validarBuscador()
	}
}
</script>
<%
	String claveDeBusqueda = request.getParameter(BuscadorHelper.CATEGORIA_SECCION);
	String texto2 = Convert.toString(request.getParameter(BuscadorHelper.TEXTO), "");
%>


<table width="570" border="0" align="left" cellpadding="0" cellspacing="0" class="buscadortabla">
	<form name="formBuscador" action="<%=BuscadorHelper.PAGINA_BUSCADOR%>" method="post" onSubmit="return validarBuscador()" >
    	<tr>
        	<td>
            	<table width="534" border="0" align="center" cellpadding="0" cellspacing="0">
                	<tr>
                    	<td width="90"><img src="/imagenes/inicio/t-busqueda.gif" alt="B&uacute;squeda en" width="67" height="14" /></td>
	                    <td width="140">
                    	<div align="left">
                      		<select name="<%=BuscadorHelper.CATEGORIA_SECCION%>" onKeyPress="comboSubmit(event)" class="buscadormenu">
					  		<%  Paginas paginasContenido = Contenido.getSite().getPaginas();
								//for (int p = 1; p < paginasContenido.getPaginaCount(); p++) {
								for (int p = 0; p < paginasContenido.getPaginaCount(); p++) {
									Pagina pagina = paginasContenido.getPagina(p);
									int seccion = pagina.getId();
									String texto = (seccion == Globals.SECCION_HOME)? "Todos los Productos"	: Convert.capitalizar(Globals.textoSolapa(seccion), false);
							%>
						  		<option value="<%=seccion%>"><%=texto%></option>
						  	  <%}%>
					  		</select>

                    	</div>
                    	</td>
                    	<td width="246"><div align="left">
                      		<input name="<%=BuscadorHelper.TEXTO%>" type="text" class="buscadortext" value="<%=texto2%>" />
                    	</div></td>
                    	<td width="58" class="buscadorbuscar"><input type="image" src="/imagenes/inicio/b-buscar.gif"></td>
                 	</tr>
                </table>
            </td>
		</tr>
	</form>
</table>