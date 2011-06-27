<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.DatosDomicilio,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>

<%	
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
	String home = "miCuenta";
%>

<script type="text/javascript">
function continuar() {
	var direccionId = 0;
	var direccionSelected = document.frmDireccion.<%= DatosDomicilio.ID %>;

	if (direccionSelected.length == null ) {
		direccionId = direccionSelected.value;
	} else {
		for(i = 0; i < direccionSelected.length; i++) {
			var ctrl = direccionSelected[i];

			if(ctrl.checked) {
				direccionId = ctrl.value;
				break;
			}
		}
	}

	document.location = "/DireccionLista?TIPO_DOMICILIO=" + direccionId;
}

	function modificarDireccion() {
		var direccionId = 0;
		var direccionSelected = document.frmDireccion.<%= DatosDomicilio.ID %>;

		if (direccionSelected.length == null ) {
			direccionId = direccionSelected.value;
		} else {
			for(i = 0; i < direccionSelected.length; i++) {
				var ctrl = direccionSelected[i];

				if(ctrl.checked) {
					direccionId = ctrl.value;
					break;
				}
			}
		}
		document.location = "/miCuenta/?seccionMiCuenta=15&TIPO_DOMICILIO=" + direccionId + "&HOME=listaDeseos";
	}
</script>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
		<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>          	
            <td class="Gcentro" width="422">
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
            <tr>
            	<td>
              <table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  	<tr>
                    	<td width="50" class="titulosceldas"><img src="/imagenes/listaDeseos/t-listadeseos.gif" alt="Lista de deseos" width="172" height="12" /></td>
                  	</tr>
                  	 <tr>
                    <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td height="55" valign="top" class="Ftexto02"><div align="center"><img src="/imagenes/listaDeseos/listadedeseos-header.gif" alt="Lista de deseos" width="210" height="34" /></div></td>
                              </tr>
               <tr>
               <td>
               	<!--principal  -->
           			<%
					int cantidadDomicilios = 0;
					boolean cargarReceptor = false; // por un kilombo del componente de abajo...
				%>
				<%@ include file="/componentes/comunes/domiciliosDeseos.jsp" %>
            	<!--principal  -->
				</td></tr>
				<tr>
					<td>
						<table width="100%">
						<tr>
					<%	if (cantidadDomicilios > 0) {
					%>
						<td align="right">
						<a href="javascript:continuar();">
							<img src="/imagenes/listaDeseos/b-continuar.gif" border="0">
						</a>
						</td>
					<%	}
					%>
						</tr>
						</table>
					</td>
				</tr>
                </table>
              </td>
              </tr>
              </table>
              </td>
              </tr>
              </table>
              </td>
              </tr>
              		<tr>
                <!-- ultimos visitados -->
                		<td>
	                <%
	            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
	            	%>
	            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
		                </td>
                <!-- ultimos visitados -->
    	          </tr>
        	    </table>
        	</td>
            <td class="Gbarraderecha" width="155">
            <!--BARRRA DERECHA -->
            <table width="155" border="0" cellspacing="0" cellpadding="0">

              <tr>
                <td>
               		<table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
	                  	<tr>
	                    	<td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
	                    <tr>
	                        <td><span class="Ftexto02">AQU&Iacute; SE PRESENTAN TODAS LAS DIRECCIONES QUE USTED TIENE CARGADAS. TENDR&Aacute; QUE SELECCIONAR AQUELLA EN LA QUE QUIERE RECIBIR SU PEDIDO.</span></td>
	                    </tr>
	                    <tr>
	                        <td class="moduloordencelda"><span class="Ftexto02"><strong>Agregar domicilio</strong>:<br />
	                          La direcci&oacute;n que usted cargue le servir&aacute; para utilizarla como direcci&oacute;n de env&iacute;o o de facturaci&oacute;n, cada vez que inicie un proceso de pago se le consultar&aacute;n estos datos.</span></td>
	                    </tr>
	                    <tr>
	                        <td class="moduloordencelda"><span class="Ftexto02"><strong>Modificar el domicilio:</strong><br />
	                          Presionando el bot&oacute;n <em>modificar </em>usted es redireccionado al formulario de la direcci&oacute;n previamente seleccionada, donde puede modificar el/los datos que usted desee..</span></td>
	                    </tr>
   			                 </table></td>
            	        </tr>
               	   </table>
                </td>
              </tr>
            </table>
            </td>
          </tr>
		</table>
	</div>
</div>