<%@ page import="com.tmk.controllers.intranet.ordenes.OrdenesHelper,
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.MedioDeCobroDAO,
				 com.tmk.kernel.Convert,
				 java.util.Date,
				 com.tmk.kernel.TipoDeDocumentoDAO,
				 com.tmk.controllers.intranet.ordenes.OrdenesHelper"
%>

<%	int idOrden = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_), Integer.MIN_VALUE);

	String tipoTarjeta = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_TIPO_TARJETA));
	String numeroTarjeta = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_NUMERO_TARJETA));
	String titular = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_TITULAR));
	String codigoSeguridad = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_CODIGO), "");
	int mes = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_MES), 0);
	int anio = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ANO), 0);
	String tipoDoc = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_TIPO_DOC));
	long numeroDoc = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_NRO_DOC), (long) 0);
	String domicilioEnvio = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_DOMICILIO_ENVIO));

	String informacion = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_INFORMACION), null);
	String error = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_ERROR), null);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Datos de orden por FAX") %>
		<script src="/js/Validation.js">
		</script>

		<script type="text/javascript">
			function volver() {
				opener.document.location.reload();
				window.close();
			}

			function validar() {
				switch (isTarjetaValida(document.datosTarjeta.<%= OrdenesHelper.CAMPO_NUMERO_TARJETA %>.value, <%=Globals.DIGITOS_TARJETA_MINIMO%>, <%=Globals.DIGITOS_TARJETA_MAXIMO%>)) {
					case 1:
						alert('El numero de tarjeta solo debe contener digitos');
						return;

					case 2:
						alert('Al numero de tarjeta le faltan numeros');
						return;

					case 3:
						alert('Al numero de tarjeta le sobran numeros');
						return;
				}

				if (isEmpty(document.datosTarjeta.<%= OrdenesHelper.CAMPO_CODIGO %>.value)) {
					alert('Se tiene que indicar un codigo de seguridad para la tarjeta');
					return;
				}

				if (isEmpty(document.datosTarjeta.<%= OrdenesHelper.CAMPO_TITULAR %>.value)) {
					alert('Se tiene que indicar un titular para la tarjeta');
					return;
				}

				if (isEmpty(document.datosTarjeta.<%= OrdenesHelper.CAMPO_NRO_DOC %>.value)) {
					alert('Se tiene que indicar un numero de identificacion personal');
					return;
				}

				if (isEmpty(document.datosTarjeta.<%= OrdenesHelper.CAMPO_DOMICILIO_ENVIO %>.value)) {
					alert('Se tiene que indicar una direccion de envio');
					return;
				}

				document.datosTarjeta.submit();
			}
		</script>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table width="400" align="center">
		<tr>
			<td>
				<table align="center">

				<tr>
					<td colspan="5">
						<%	if (error != null) {
						%>
								<br>
								<table bgcolor="#FFFFDF;" aling="center" style="border-bottom: 3px solid #FF0000; border-top: 3px solid #FF0000;" cellpadding="4">
								<tr valign="middle">
									<td>
										<img src="/imagenes/intranet/baliza.gif">
									</td>

									<td>
										<b>
											<%= error %>
										</B>
									</td>
								</tr>
								</table>
						<%	} else if (informacion != null ) {
						%>
                        		<br>
								<table bgcolor="#73DF63;" align="center" width="400" style="border-bottom: 3px solid #008200; border-top: 3px solid #008200;" cellpadding="4">
								<tr>
									<td colspan="5">
										<b>
											<%= informacion %>
										</B>
									</td>
								</tr>
								</table>
						<%	} else {
						%>
								<br><br><br>
						<%	}
						%>
					</td>
				</tr>

				<tr>
					<td height="33" colspan="5" aling="center">
						<br>
						<hr color="#59B3D9" size="1" width="350">
					</td>
				</tr>
				</table>

				<table width="250">
				<tr>
					<td>
						<font color="#990000" style="font-size: 12px;">
							<b>Datos de la orden <%= idOrden %></b>
							<br>
						</font>
					</td>
    			</tr>
				</table>

				<form name="datosTarjeta" action="/OrdenFax">
					<table width="300">
						<input type="hidden" name="<%=OrdenesHelper.CAMPO_ID_ORDEN_%>" value="<%=idOrden%>">

						<table class="textoClasico" style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="400" border="1" align="center" cellspacing="0" cellpadding="5">
						<tr>
							<td>
								Tarjeta:
							</td>

							<td>
								<select name="<%= OrdenesHelper.CAMPO_TIPO_TARJETA%>">
									<%	for (int indexFP = 0; indexFP < Globals.MEDIOS_DE_COBRO.length; indexFP++) {
											MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[indexFP];
											if (medioDeCobroDAO.estaHabilitado() && medioDeCobroDAO.esTarjeta()) {
									%>
												<option value="<%= medioDeCobroDAO.getId() %>" <%= medioDeCobroDAO.getId().equals(tipoTarjeta) ? "selected" : ""%>>
													<%= medioDeCobroDAO.getNombre() %>
												</option>
									<%		}
										}
									%>
								</select>
							</td>
						</tr>

						<tr>
							<td>
								Numero:
                            </td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_NUMERO_TARJETA %>" maxlength="40" size="40" value="<%= numeroTarjeta %>">
							</td>
						</tr>

						<tr>
							<td>
								Codigo de seguridad:
                            </td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_CODIGO %>" maxlength="4" size="4" value="<%=codigoSeguridad %>">
							</td>
						</tr>

						<tr>
							<td>
								Fecha de vencimiento:
							</td>

							<td>
								<select name="<%= OrdenesHelper.CAMPO_MES %>">
									<%	for (int indexMes = 1; indexMes <= 12; indexMes++) { %>
											<option value="<%= indexMes %>" select=<%= mes == indexMes ? "selected" : ""%>>
												<%= indexMes %>
											</option>
									<%	}
									%>
								</select>

								<select name="<%= OrdenesHelper.CAMPO_ANO %>">
									<%	int anoActual = new Date().getYear() + 1900;
										int vencimiento = (anio == 0) ? (anoActual + 1) : anio;
										for (int indexAnio = anoActual; indexAnio <= anoActual + 9; indexAnio++) { %>
											<option value="<%=indexAnio%>" <%=(indexAnio == vencimiento) ? "selected" : "" %>>
                    							<%= indexAnio %>
											</option>
									<%	}
									%>
								</select>
                            </td>
						</tr>

						<tr>
							<td>
								Titular:
							</td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_TITULAR %>" size="50" maxlength="50" value="<%= titular %>">
                            </td>
						</tr>

						<tr>
							<td>
								Documento:
							</td>

							<td>
								<select name="<%= OrdenesHelper.CAMPO_TIPO_DOC %>">
									<%	for (int td = 0; td < Globals.TIPOS_DOCUMENTO.length; td++) {
										TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[td]; %>
											<option value="<%= tipoDeDocumentoDAO.getId() %>" select=<%= tipoDeDocumentoDAO.getId().equals(tipoDoc) ? "selected" : ""%>>
												<%= tipoDeDocumentoDAO.getNombre() %>
											</option>
									<%	}
									%>
								</select>

								<input type="text" name="<%= OrdenesHelper.CAMPO_NRO_DOC %>" size="15" maxlength="15" value="<%= Convert.toStringSinFormato(numeroDoc) %>">
                            </td>
						</tr>

						<tr>
							<td>
								Domicilio de env&iacute;o del resumen de su tarjeta
							</td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_DOMICILIO_ENVIO %>" size="50" maxlength="510" value="<%= domicilioEnvio %>">
							</td>
						</tr>
						</table>

						<table align="right">
						<tr>
							<td>
								<% if (informacion == null) {
								%>
										<br><br>
										<a href="javascript:validar();">
											<img src="/imagenes/botonContinuar.gif" border="0">
										</a>
								<%	}
								%>
							</td>

							<td>
								<br><br>
								<a href="javascript:volver()">
									<img src="/imagenes/botonVolver.gif" border="0">
								</a>
							</td>
						</tr>
						</table>
					</table>
				</form>
			</td>
		</tr>
		</table>
	</body>
</html>