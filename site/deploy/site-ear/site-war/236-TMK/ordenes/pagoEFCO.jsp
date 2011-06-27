<%@ page import="java.util.Date,
 				 com.tmk.kernel.Globals,
				 com.tmk.kernel.MedioDeCobroDAO,
				 com.tmk.kernel.Convert,
				 com.tmk.kernel.DBUtil,
				 com.tmk.controllers.intranet.ordenes.OrdenesHelper,
				 com.tmk.orden.OrdenDAO,
				 com.tmk.service.orden.OrdenService"
%>

<%	int idOrden = Convert.toNumber(request.getParameter(OrdenesHelper.CAMPO_ID_ORDEN_), Integer.MIN_VALUE);

	OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden);

	String telefono = Convert.toString(ordenDAO.getTelefonoContacto());
	String horario = Convert.toString(ordenDAO.getHorarioContacto());
	String comentario = Convert.toString(ordenDAO.getComentario());

	String informacion = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_INFORMACION), null);
	String error = Convert.toString(request.getParameter(OrdenesHelper.CAMPO_ERROR), null);

%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Datos de orden por Efectivo Contrareembolso") %>
		<script src="/js/Validation.js">
		</script>

		<script type="text/javascript">
			function volver() {
				window.close();
			}

			function validar() {
				if (isEmpty(document.datosEFCO.<%= OrdenesHelper.CAMPO_TELEFONO %>.value)) {
					alert('Se tiene que indicar un numero de telefono');
					return;
				}

				if (isEmpty(document.datosEFCO.<%= OrdenesHelper.CAMPO_HORARIO %>.value)) {
					alert('Se tiene que indicar un horario para el contacto');
					return;
				}

				document.datosEFCO.submit();
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

				<form name="datosEFCO" action="/OrdenEFCO">
					<table width="300">
						<input type="hidden" name="<%=OrdenesHelper.CAMPO_ID_ORDEN_%>" value="<%=idOrden%>">

						<table class="textoClasico" style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="400" border="1" align="center" cellspacing="0" cellpadding="5">
						<tr>
							<td>
								Telefono:
							</td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_TELEFONO %>" maxlength="30" size="30" value="<%= telefono %>">
							</td>
						</tr>

						<tr>
							<td>
								Horario:
                            </td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_HORARIO %>" maxlength="10" size="10" value="<%= horario %>">
							</td>
						</tr>

						<tr>
							<td>
								Comentario:
                            </td>

							<td>
								<input type="text" name="<%= OrdenesHelper.CAMPO_COMENTARIO %>" maxlength="50" size="30" value="<%= comentario %>">
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