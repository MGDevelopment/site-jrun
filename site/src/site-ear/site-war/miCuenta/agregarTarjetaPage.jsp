<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.kernel.TipoDeDocumentoDAO,
                 com.tmk.kernel.Convert" %>


<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/?seccionMiCuenta=12&opcionMenuTarjetas=0");
%>
		<jsp:forward page="/miCuenta/" />
<%}%>

<script type="text/JavaScript">
<!--
		function agregarTarjeta()
		{
			var form = document.formTarjeta;

			switch (isTarjetaValida(document.formTarjeta.NRO_TARJETA.value, <%=Globals.DIGITOS_TARJETA_MINIMO%>, <%=Globals.DIGITOS_TARJETA_MAXIMO%>)) {
				case 1:
					alert('El número de tarjeta sólo debe contener dígitos');
					return;

				case 2:
					alert('Al número de tarjeta le faltan números');
					return;

				case 3:
					alert('Al número de tarjeta le sobran números');
					return;
			}


			if (isEmpty(document.formTarjeta.NRO_TARJETA.value)) {
				alert('Debés ingresar el número de tarjeta');
				return;
			}

			if (isEmpty(document.formTarjeta.NOMBRE_TITULAR.value)) {
				alert('Debés ingresar el apellido y nombre');
				return;
			}


			 if (isNaN(document.formTarjeta.NRO_DOC.value) || isEmpty(document.formTarjeta.NRO_DOC.value)) {
					formTarjeta.NRO_DOC.focus();
					alert('Debés indicar un número');
					return;
			}

			if (isEmpty(document.formTarjeta.DIRECCION_RESUMEN.value)) {
				alert('Debés ingresar el domicilio de envío');
				return;
			}

			form.submit();
		}


		function enviar(fn) {
			if (event.keyCode == 13) {
				eval(fn);
			}
		}
//-->
</script>
<script type="text/javascript" src="/js/Validation.js"></script>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <%
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
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
                  <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                  <form action="/AgregarTarjeta" method="post" name="formTarjeta">
                      <tr>
                        <td height="35" colspan="3" valign="top" class="Ftexto02"><strong>Agregar tarjeta. </strong>Ingrese los datos de su tarjeta.<br />
                          Recuerde que los campos con (<span class="Ftextorojo">*</span>) son obligatorios.</td>
                      </tr>
                      <tr>
                        <td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Tarjeta: </td>
                        <td width="224" colspan="2"><div align="left">
                          <select name="ID_MEDIO_COBRO" onKeyPress="cambiarFoco(event,'document.formTarjeta.NRO_TARJETA');" class="empleomenu4">
								 <%for (int indexFP = 0; indexFP < Globals.MEDIOS_DE_COBRO.length; indexFP++) {
									MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[indexFP];
									if (medioDeCobroDAO.estaHabilitado() && medioDeCobroDAO.esTarjeta()) {
								 %>
                      			    <option value="<%= medioDeCobroDAO.getId() %>"><%= medioDeCobroDAO.getNombre() %></option>
                                    <%}%>
								<%}%>
						  </select>
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> N&uacute;mero de tarjeta: </td>
                        <td colspan="2"><div align="left">
                          <input name="NRO_TARJETA" size="27" maxlength="20" onKeyPress="cambiarFoco(event,'document.formTarjeta.NOMBRE_TITULAR');" type="text" class="ayudatext" />
                        </div></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><span class="Ftextorojo">*</span> Apellido y nombre: </td>
                        <td colspan="2"><div align="left">
                            <input name="NOMBRE_TITULAR" size="40" onKeyPress="cambiarFoco(event,'document.formTarjeta.TIPO_DOC');" type="text" class="ayudatext" />
                        </div></td>
                      </tr>

                      <tr>
                        <td width="142" valign="bottom" class="Ftexto02"> <span class="Ftextorojo">*</span> Identificaci&oacute;n personal: </td>
                        <td width="224" colspan="2"><div align="left">
                          <select name="TIPO_DOC" onKeyPress="cambiarFoco(event,'document.formTarjeta.NRO_DOC');" class="empleomenu4">
								<%	for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
								TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td]; %>
								<option value="<%= tipoDeDocumentoDAO.getId() %>">
									<%= Convert.toString(tipoDeDocumentoDAO.getNombre(),40) %>
								</option>
								<% }%>
						  </select>
                        </div></td>
                      </tr>
                      <tr>
                        <td ></td>
                        <td valign="top" colspan="2"><div align="left">
                          <input name="NRO_DOC"  onKeyPress="cambiarFoco(event,'document.formTarjeta.DIRECCION_RESUMEN');" type="text" class="ayudatext" />
                        </div></td>
                      </tr>

                      <tr>
                        <td valign="bottom" style="padding-top:12px"><div align="left"><span class="Ftextorojo">*</span><span class="Ftexto02"> Domicilio de envio<br />
&nbsp;&nbsp;&nbsp;del resumen de su tarjeta:</span></div></td>
                        <td colspan="2" valign="bottom"><div align="left">
                          <input name="DIRECCION_RESUMEN" size="80"  onKeyPress="enviar(event, 'agregarTarjeta()');" type="text" class="ayudatext" />
                        </div></td>
                      </tr>


                      <tr >
                        <td>&nbsp;</td>
                        <td colspan="2"><br>
                        <div align="right"><a href="javascript:agregarTarjeta();"><img src="/imagenes/miCuenta/b-agregar.gif" alt="Agregar domicilio" width="60" height="10" border="0" class="benviar2" /></a></div></td>
                      </tr>
                      </form>
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
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="162" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table width="148" border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">EN EL FORMULARIO QUE AQU&Iacute; SE PRESENTA, USTED DEBER&Aacute; CARGAR LOS DATOS DE SU TARJETA DE CR&Eacute;DITO.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>N&uacute;mero de Tarjeta</strong>: Ingrese aqu&iacute; el n&uacute;mero que figura en el frente de su tarjeta   de cr&eacute;dito.</span></td>
                        </tr>
                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Nombre y Apellido</strong>: Ingrese aqu&iacute; el nombre y apellido del titular de la tarjeta.</span></td>
                        </tr>

                        <tr>
                          <td class="moduloordencelda"><span class="Ftexto02"><strong>Identificaci&oacute;n personal</strong>: Seleccione de aqu&iacute; que tipo de documento utilizar&aacute; para   su identificaci&oacute;n.</span></td>
                        </tr>


                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>