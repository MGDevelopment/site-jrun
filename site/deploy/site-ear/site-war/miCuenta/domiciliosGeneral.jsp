<%@ page import="com.tmk.setup.Contenido,
				 com.tmk.src.socio.SocioPK,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper,
                 com.tmk.kernel.DatosDomicilio" %>

<%
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI");%>
		<jsp:forward page="/miCuenta" /><%	}
	else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT, "/miCuenta/domicilios.jsp?TIPO_DOMICILIO=ENVI");%>
		<jsp:forward page="<%=MainHelper.PAGE_REGISTRO_SOCIO_CADENA%>" /><%
	}
%>

<%	OrdenDAO ordenDAO = (OrdenDAO)session.getAttribute("ordenDAO");
	String home = "miCuenta";
%>


<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <%SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
			 if (socioPK != null) { %>
			<tr>
				<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            		<tr>
						  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
	                </tr>
    	        </table></td>
	       </tr>
    	   <%}%>

              <jsp:include page="/miCuenta/left.jsp"/>

            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr>
	               <td>
	                <table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
	                  <tr>
	                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
	                  </tr>

	                  <tr>
	                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
	                      <tr>
	                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" >
	                        	<tr>
		                        	<%
										int cantidadDomicilios = 0;
										boolean cargarReceptor = false; // por un kilombo del componente de abajo...
									%>
									<td>
									<%@include file="/componentes/comunes/domiciliosMiCuenta.jsp" %>
									</td>
		                        </tr>
	                        </table></td>
	                      </tr>
	                    </table></td>
	                  </tr>
	                </table></td>
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

            </table></td>
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">AQU&Iacute; SE PRESENTAN TODAS LAS DIRECCIONES QUE USTED TIENE CARGADAS. TENDR&Aacute; QUE SELECCIONAR AQUELLA EN LA QUE QUIERE RECIBIR SU PEDIDO.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Agregar nuevo domicilio</strong>:<br />
                            La direcci&oacute;n que usted cargue le servir&aacute; para utilizarla como direcci&oacute;n de env&iacute;o o de facturaci&oacute;n, cada vez que inicie un proceso de pago se le consultar&aacute;n estos datos.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Modificar el domicilio:</strong><br />
                            Presionando el bot&oacute;n <em>modificar </em>usted es redireccionado al formulario de la direcci&oacute;n previamente seleccionada, donde puede modificar el/los datos que usted desee.</span></td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
<script type="text/JavaScript">
<!--
function volver()
			{
				document.location = "/miCuenta";
			}

			function modificarDireccion()
			{
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

				document.location = "/miCuenta/index.jsp?seccionMiCuenta=3&opcionMenu=1&TIPO_DOMICILIO=" + direccionId + "&HOME=miCuenta";
			}


//-->
</script>


<%=Globals.getGoogleAnalyticsSSL()%>