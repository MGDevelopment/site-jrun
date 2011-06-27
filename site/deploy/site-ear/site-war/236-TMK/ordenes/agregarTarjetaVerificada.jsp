<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.kernel.DBUtil,
				 com.tmk.kernel.NivelDeRiesgoDAO,
				 com.tmk.kernel.PaisDAO,
 				 com.tmk.admin.TarjetaVerificadaLocalHome,
				 com.tmk.admin.TarjetaVerificadaLocal,
				 com.tmk.controllers.intranet.ordenes.TarjetaVerificadaHelper"
%>

<%	String error = Convert.toString(request.getParameter(TarjetaVerificadaHelper.CAMPO_ERROR), "");
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Agregar Tarjeta") %>
		<script type="text/javascript">
			function volver(flag) {
				if (flag) {
					opener.document.location.reload();
					window.close();
				}
			}

			function validar() {
				document.datosTarjeta.submit();
			}
		</script>

		<script type="text/javascript" src="/js/Objetos.js">
		</script>

		<script type="text/javascript" src="/js/Validation.js">
		</script>

		<jsp:include page="/js/Combos.jsp" />
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="volver(<%= "no".equals(error) ? "true" : "false" %>)">
		<table width="450" align="center">
		<tr>
			<td>
				<table align="center">
				<tr>
					<td width="100">
					</td>

					<td valign="top" width="20">
						<img src="/imagenes/miCuenta/bienIsq.gif" width="32" height="52">
					</td>

					<td align="center" valign="middle" width="100" style="color:red">
						<div align="center" class="titulocarrito">
						<h2><b>Tarjeta</b><h2>
						</div>
						<!--<img src="/imagenes/intranet/tituloAgregarTarjeta.gif" alt="Agregar tarjeta">-->
					</td>

					<td valign="top" width="20">
						<img src="/imagenes/miCuenta/bienDer.gif" width="34" height="52">
					</td>

					<td width="100">
					</td>
				</tr>

				<tr>
					<td colspan="5">
						<%	if ("si".equals(error)) {
						%>
								<br>
								<table bgcolor="#FFFFDF;" aling="center" style="border-bottom: 3px solid #FF0000; border-top: 3px solid #FF0000;" cellpadding="4">
								<tr valign="middle">
									<td>
										<img src="/imagenes/intranet/baliza.gif">
									</td>

									<td>
										<b>
											Se produjo un error al grabar la tarjeta
										</b>
									</td>
								</tr>
								</table>
						<%	} else {
						%>

						<%	}
						%>
					</td>
				</tr>

				<tr>
					<td colspan="5" aling="center">
						<br>
						<hr color="#59B3D9" size="1" width="350">
					</td>
				</tr>
				</table>

				<form name="datosTarjeta" action="/AgregarTarjetaVerificada">
					<table class="textoClasico" style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="450" border="1" align="center" cellspacing="0" cellpadding="5">
					<tr>
						<td>
							Nivel de riesgo:
						</td>

						<td>
							<select name="<%= TarjetaVerificadaHelper.NIVEL_RIESGO %>">
								<%	for (int i = 0; i < Globals.NIVELES_DE_RIESGO.length; i++) {
										NivelDeRiesgoDAO nivelDeRiesgoDAO = Globals.NIVELES_DE_RIESGO[i];
								%>
										<option value="<%= nivelDeRiesgoDAO.getId() %>" >
											<%= nivelDeRiesgoDAO.getNombre() %>
										</option>
								<%	}
								%>
							</select>
						</td>
					</tr>

					<tr>
						<td>
							Numero:
						</td>

						<td>
							<input type="text" name="<%= TarjetaVerificadaHelper.NUMERO_TARJETA %>" maxlength="40" size="40">
						</td>
					</tr>

					<tr>
						<td>
							Nombre titular:
						</td>

						<td>
							<input type="text" name="<%= TarjetaVerificadaHelper.NOMBRE_SOCIO %>" maxlength="40" size="40">
						</td>
					</tr>

					<tr>
						<td>
							Apellido titular:
						</td>

						<td>
							<input type="text" name="<%= TarjetaVerificadaHelper.APELLIDO_SOCIO %>" maxlength="40" size="40">
						</td>
					</tr>

					<tr>
						<td>
							e-mai:
						</td>

						<td>
							<input type="text" name="<%= TarjetaVerificadaHelper.EMAIL %>" maxlength="40" size="40">
						</td>
					</tr>

					<tr>
						<td>
							Domicilio envio:
						</td>

						<td>
							<table>
							<tr>
								<td>
									Calle:
									<input type="text" name="<%= TarjetaVerificadaHelper.CALLE_ENVIO %>" size="40" maxlength="40">
								</td>
							</tr>

							<tr>
								<td>
									Numero:
									<input type="text" name="<%= TarjetaVerificadaHelper.NUMERO_ENVIO %>" size="5" maxlength="5">
									&nbsp;
									Piso:
									<input type="text" name="<%= TarjetaVerificadaHelper.PISO_ENVIO %>" size="5" maxlength="5">
									&nbsp;
									Depto:
									<input type="text" name="<%= TarjetaVerificadaHelper.DEPTO_ENVIO %>" size="5" maxlength="5">
								</td>
							</tr>

							<tr>
								<td>
									Edificio:
									<input type="text" name="<%= TarjetaVerificadaHelper.EDIFICIO_ENVIO %>" size="5" maxlength="5">
									&nbsp;
									CP:
									<input type="text" name="<%= TarjetaVerificadaHelper.CP_ENVIO %>" size="5" maxlength="15">
								</td>
							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							Domicilio facturacion:
						</td>

						<td>
							<table>
							<tr>
								<td>
									Calle:
									<input type="text" name="<%= TarjetaVerificadaHelper.CALLE_FACTURACION %>" size="40" maxlength="40">
								</td>
							</tr>

							<tr>
								<td>
									Numero:
									<input type="text" name="<%= TarjetaVerificadaHelper.NUMERO_FACTURACION %>" size="5" maxlength="5">
									&nbsp;
									Piso:
									<input type="text" name="<%= TarjetaVerificadaHelper.PISO_FACTURACION %>" size="5" maxlength="5">
									&nbsp;
									Depto:
									<input type="text" name="<%= TarjetaVerificadaHelper.DEPTO_FACTURACION %>" size="5" maxlength="5">
								</td>
							</tr>

							<tr>
								<td>
									Edificio:
									<input type="text" name="<%= TarjetaVerificadaHelper.EDIFICIO_FACTURACION %>" size="5" maxlength="5">
									&nbsp;
									CP:
									<input type="text" name="<%= TarjetaVerificadaHelper.CP_FACTURACION %>" size="5" maxlength="15">
								</td>                                                                                           							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							Comentarios:
						</td>

						<td>
                        	<input type="text" name="<%= TarjetaVerificadaHelper.COMENTARIOS %>" size="40" maxlength="40">
						</td>
					</tr>
					</table>

					<table align="right">
					<tr>
						<td>
							<br><br>
							<a href="javascript:validar();">
								<img src="/imagenes/botonContinuar.gif" border="0">
							</a>
						</td>

						<td>
							<br><br>
							<a href="javascript:volver(true)">
								<img src="/imagenes/botonVolver.gif" border="0">
							</a>
						</td>
					</tr>
					</table>
				</form>
			</td>
		</tr>
		</table>
	</body>
</html>