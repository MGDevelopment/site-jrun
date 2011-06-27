<script type="text/javascript">
function continuar() {
	if(!isEmpty(document.buscadorListas.APELLIDOS_NOMBRES.value)) {
		return true;

	} else if(!isEmpty(document.buscadorListas.PROVINCIA_CIUDAD.value))	{
		return true;
	}
	else {
		alert('Indicá al menos una las condiciones para realizar la búsqueda.');
		return false;
	}
}
</script>
<table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	<tr>
    	<td>
    		<table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
            	<tr>
                	<td class="Ftexto02"><strong>BUSCADOR DE LISTAS <br />
						DE DESEOS</strong></td>
                </tr>
                <tr>
                	<td class="moduloordencelda"><span class="Ftexto02"> En este m&oacute;dulo  pod&eacute;s buscar y ver las listas de deseos registradas en tematika.com</span></td>
                </tr>
                <form name="buscadorListas" action="/BuscarListas" method="post" onSubmit="return continuar()">
                <tr>
                	<td class="moduloordencelda"><span class="Ftexto02"><strong>Nombre o correo</strong>:<br />
                		<input name="APELLIDOS_NOMBRES" type="text" class="empleotext" />
                    </span></td>
                </tr>
                <tr>
                	<td class="moduloordencelda"><span class="Ftexto02"><strong>Ciudad o provincia:<br />
                    	<input name="PROVINCIA_CIUDAD" type="text" class="empleotext" />
                        </strong></span></td>
                </tr>

                <tr>
                	<td class="moduloordencelda"><div align="right">
                	<input type="image" src="/imagenes/listaDeseos/b-buscar.gif">
                	<!-- a href="javascript:continuar();"><img src="/imagenes/listaDeseos/b-buscar.gif" alt="Buscar" width="50" height="10" border="0"></a-->

                	</div></td>
                </tr>
               </form>
            </table>
       </td>
    </tr>
</table>