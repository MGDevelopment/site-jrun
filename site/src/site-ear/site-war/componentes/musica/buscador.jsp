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
		alert('La b�squeda no puede estar vac�a.');
		return false;
	}
	<%int cantidadMinimaDeCaracteresABuscar = 1;%>
	if (form.<%=BuscadorHelper.TEXTO%>.value.length <= <%=cantidadMinimaDeCaracteresABuscar%>) {
		alert('El texto de b�squeda debe ser mayor a <%=cantidadMinimaDeCaracteresABuscar%> caracter');
		return false;
	}

	if(isEmpty(form.<%=BuscadorHelper.CLAVE_DE_BUSQUEDA%>.value)){
		form.<%=BuscadorHelper.CATEGORIA_SECCION%>.value = "<%=Globals.SECCION_HOME%>";
	}else{
		form.<%=BuscadorHelper.CATEGORIA_SECCION%>.value = "<%=Globals.SECCION_MUSICA%>";
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
	String claveDeBusqueda = request.getParameter(BuscadorHelper.CLAVE_DE_BUSQUEDA);
	String texto = Convert.toString(request.getParameter(BuscadorHelper.TEXTO), "");
%>

<table width="570" border="0" align="left" cellpadding="0" cellspacing="0" class="buscadortabla">
	<form name="formBuscador" action="<%=BuscadorHelper.PAGINA_BUSCADOR%>" method="post" onSubmit="return validarBuscador()">
		<tr>
    		<td>
	    		<input type="hidden" name="<%=BuscadorHelper.CATEGORIA_SECCION%>" value="<%=Globals.SECCION_MUSICA%>">

    			<table width="534" border="0" align="center" cellpadding="0" cellspacing="0">
            		<tr>
                    	<td width="90"><img src="/imagenes/musica/t-busqueda.gif" alt="B&uacute;squeda en" width="90" height="13" /></td>
                    	<td width="140"><select name="<%=BuscadorHelper.CLAVE_DE_BUSQUEDA%>" onKeyPress="comboSubmit(event)" class="buscadormenu">

                						    <option value="<%=BuscadorHelper.POR_TITULO%>" <%=BuscadorHelper.POR_TITULO.equals(claveDeBusqueda)?"selected":""%>>T&iacute;tulo</option>
                      						<option value="<%=BuscadorHelper.POR_AUTOR%>" <%=BuscadorHelper.POR_AUTOR.equals(claveDeBusqueda)?"selected":""%>>Grupo / Int&eacute;rprete</option>
					                	    <option value="<%=BuscadorHelper.POR_EDITORIAL%>" <%=BuscadorHelper.POR_EDITORIAL.equals(claveDeBusqueda)?"selected":""%>>Sello discogr&aacute;fico</option>
                      						<option value="<%=BuscadorHelper.POR_TEMA_MUSICAL%>" <%=BuscadorHelper.POR_TEMA_MUSICAL.equals(claveDeBusqueda)?"selected":""%>>Tema m&uacute;sical</option>
                      						<option value="<%=BuscadorHelper.POR_PALABRAS_CLAVES%>" <%=BuscadorHelper.POR_PALABRAS_CLAVES.equals(claveDeBusqueda)?"selected":""%>>Palabra Clave</option>
                      						<option value="" <%="".equals(claveDeBusqueda)?"selected":""%>>Todas las categor&iacute;as</option>
                    					</select> </td>
                    	<td width="192"><div align="left"><input name="<%=BuscadorHelper.TEXTO%>" type="text" class="buscadortext" value="<%=texto%>"/></div></td>

                    	<td class="buscadorbuscar" width="59"><input type="image" src="/imagenes/musica/b-buscar.gif"></td>
	                    <td class="buscadorbavanzada"width="53"><% String pagBuscador = "/articulo/buscadorAvanzado.jsp?" + BuscadorHelper.CATEGORIA_SECCION + "=" + Globals.SECCION_MUSICA;%>
	                    <a href="<%=pagBuscador%>"><img src="/imagenes/musica/b-busqavanzada.gif" alt="B&uacute;squeda Avanzada" width="44" height="19" border="0" /></a></td>
		           </tr>
        	   </table>
        	</td>
       </tr>
	</form>
</table>