<%@ page import="java.util.Iterator,
				 com.tmk.setup.Contenido,
				 com.tmk.orden.OrdenLocalHome,
				 com.tmk.orden.OrdenLocal,
				 com.tmk.orden.PagoOrdenLocal,
				 com.tmk.orden.PagoOrdenLocalHome,
				 com.tmk.service.orden.OrdenService,
				 com.tmk.admin.TarjetaVerificadaLocal,
				 com.tmk.admin.TarjetaVerificadaLocalHome,
				 com.tmk.controllers.intranet.ordenes.TarjetaVerificadaHelper,
				 com.tmk.kernel.*,
				 java.util.Collection"%>

<%	TarjetaVerificadaLocalHome tarjetaVerificadaLocalHome = (TarjetaVerificadaLocalHome)DBUtil.getHome("TarjetaVerificada");

	Iterator tarjetasVerificadasLocal = tarjetaVerificadaLocalHome.findAll().iterator();
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Listado de Tarjetas") %>
		<style>
			a.EnlaceNegro
			{
				font-size: 11px;
				font-family: verdana;
				font-weight: bold;
				color: #000000;
				text-decoration: none;
			}

			p.TextoNegro
			{
				font-size: 11px;
				font-family: verdana;
				font-weight: bold;
				color: #000000;
				text-decoration: none;
			}
			font.TextoBordo
			{
				color: #990000;
				font-size: 12px;
				font-family: verdana;
				text-transform: uppercase;
				font-weight: bold;
				text-align: center;
			}
		</style>

		<script type="text/javascript">
			function datosTarjeta(nroTarjeta, nombreSocio, apellidoSocio, eMail,
									calleEnvio, nroEnvio, edificioEnvio, pisoEnvio, deptoEnvio, cpEnvio,
									calleFacturacion, nroFacturacion, edificioFacturacion, pisoFacturacion, deptoFacturacion, cpFacturacion,
									nivelRiesgo, comentarios) {
				window.open("/236-TMK/ordenes/datosTarjetaVerificada.jsp?<%= TarjetaVerificadaHelper.NUMERO_TARJETA %>=" + nroTarjeta +
							"&<%= TarjetaVerificadaHelper.NOMBRE_SOCIO %>=" + nombreSocio +
							"&<%= TarjetaVerificadaHelper.APELLIDO_SOCIO %>=" + apellidoSocio +
							"&<%= TarjetaVerificadaHelper.EMAIL %>=" + eMail +
							"&<%= TarjetaVerificadaHelper.CALLE_ENVIO %>=" + calleEnvio +
							"&<%= TarjetaVerificadaHelper.EDIFICIO_ENVIO %>=" + edificioEnvio +
							"&<%= TarjetaVerificadaHelper.NUMERO_ENVIO %>=" + nroEnvio +
							"&<%= TarjetaVerificadaHelper.PISO_ENVIO %>=" + pisoEnvio +
							"&<%= TarjetaVerificadaHelper.DEPTO_ENVIO %>=" + deptoEnvio +
							"&<%= TarjetaVerificadaHelper.CP_ENVIO %>=" + cpEnvio +
							"&<%= TarjetaVerificadaHelper.CALLE_FACTURACION %>=" + calleFacturacion +
							"&<%= TarjetaVerificadaHelper.EDIFICIO_FACTURACION %>=" + edificioFacturacion +
							"&<%= TarjetaVerificadaHelper.NUMERO_FACTURACION %>=" + nroFacturacion +
							"&<%= TarjetaVerificadaHelper.PISO_FACTURACION %>=" + pisoFacturacion +
							"&<%= TarjetaVerificadaHelper.DEPTO_FACTURACION %>=" + deptoFacturacion +
							"&<%= TarjetaVerificadaHelper.CP_FACTURACION %>=" + cpFacturacion +
							"&<%= TarjetaVerificadaHelper.NIVEL_RIESGO %>=" + nivelRiesgo +
							"&<%= TarjetaVerificadaHelper.COMENTARIOS %>=" + comentarios,
							"datosTarjetaVerificada",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=450, height=450");
			}

			function agregarTarjeta() {
				window.open("/236-TMK/ordenes/agregarTarjetaVerificada.jsp", "agregarTarjetaVerificada",
							"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, width=480, height=550");
			}
		</script>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table cellpadding="0" cellspacing="0" align="center" bgcolor="#FFFFFF" width="770">
		<tr>
			<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<jsp:include page="/236-TMK/comunes/header.jsp"/>
					</td>
				</tr>
				</table>

				<table width="752" cellspacing="0" cellpadding="0" border="0">
				<tr>
					<td>
						<br><br>
					</td>
				</tr>

				<tr>
					<td height="33" colspan="5" align="center">
						<font class="TextoBordo" >
							Base de datos de tarjetas
						</font>

						<br><br>
						<br><br>

						<table width="650" align="center">
						<tr>
							<td align="right">
								<a href="javascript:agregarTarjeta();">
									<img src="/imagenes/botonAgregar.jpg" alt="Agregar" border="0">
								</a>
							</td>
						</tr>
						</table>
						<hr color="#59B3D9" size="1" width="650">
					</td>
				</tr>
				</table>

				<%	if (tarjetasVerificadasLocal.hasNext()) {
				%>
						<form name="listadoTarjetas">
							<table width="752">
							<tr>
								<td>
									<table width="630" align="center" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;">
									<tr bgcolor="#59B3D9" align="center">
										<td height="25">
											<b>Riesgo</b>
										</td>

										<td>
											<b>Eliminar</b>
										</td>

										<td>
											<b>Nro. Tarjeta</b>
										</td>

										<td>
											<b>Nombre</b>
										</td>

										<td>
											<b>Apellido</b>
										</td>

										<td>
											<b>Envio</b>
										</td>

										<td>
											<b>Facturacion</b>
										</td>

										<td>
											<b>Detalle</b>
										</td>
									</tr>

				<%					TarjetaVerificadaLocal tarjetaVerificadaLocal = null;

									while (tarjetasVerificadasLocal.hasNext()) {
										tarjetaVerificadaLocal = (TarjetaVerificadaLocal) tarjetasVerificadasLocal.next();
				%>
										<tr style="font-size: 12px;" cellspacing="2">
											<td align="center" width="25" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%	NivelDeRiesgoDAO nivelDeRiesgo = NivelDeRiesgoDAO.buscaNivelDeRiesgo(tarjetaVerificadaLocal.getNIVEL_RIESGO());
												%>
												<img src="<%=Contenido.getImagen(nivelDeRiesgo)%>" width="20" height="20" alt="<%=Convert.htmlEscape(nivelDeRiesgo.getNombre())%>">
											</td>

											<td align="center" width="70" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<input type="checkbox">
											</td>

											<td align="center" width="200" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%= Seguridad.desencriptarTarjeta(tarjetaVerificadaLocal.getNRO_TARJETA()) %>
											</td>

											<td align="center" width="180" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%= tarjetaVerificadaLocal.getNOMBRES_SOCIO() %>
											</td>

											<td align="center" width="180" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%= tarjetaVerificadaLocal.getAPELLIDOS_SOCIO() %>
											</td>
											<td  align="center" width="180" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%= tarjetaVerificadaLocal.getCALLE_ENVIO() %>&nbsp;<%= tarjetaVerificadaLocal.getNUMERO_ENVIO() %>
											</td>
											<td  align="center" width="180" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<%= tarjetaVerificadaLocal.getCALLE_FACT() %>&nbsp;<%= tarjetaVerificadaLocal.getNUMERO_FACT() %>
											</td>
											<td height="21" align="center" style="border-collapse: collapse; border: 1px solid; border-color: #D6D3CE #5AB5DE;">
												<a href="javascript:datosTarjeta('<%= Convert.toString(Seguridad.desencriptarTarjeta(tarjetaVerificadaLocal.getNRO_TARJETA())) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getNOMBRES_SOCIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getAPELLIDOS_SOCIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getE_MAIL()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getCALLE_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getNUMERO_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getEDIFICIO_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getPISO_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getDEPTO_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getCP_ENVIO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getCALLE_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getNUMERO_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getEDIFICIO_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getPISO_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getDEPTO_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getCP_FACT()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getNIVEL_RIESGO()) %>',
																				 '<%= Convert.toString(tarjetaVerificadaLocal.getCOMENTARIOS()) %>');">
													Detalle de la tarjeta
												</a>
											</td>
										</tr>
				<%					}
				%>
									</table>

									<br>

									<table width="200" align="right">
									<tr>
										<td>
											<a href="/236-TMK/ordenes">
												<img src="/imagenes/botonVolver.gif" border="0">
											</a>
										</td>
									</tr>
									</table>
								</td>
							</tr>
							</table>
						</form>
				<%	} else {
				%>
						<table width="752" cellspacing="0" cellpadding="0" border="0">
						<tr>
							<td align="center">
								<br><br>
								<b>
									NO HAY TARJETAS PARA MOSTRAR
								</b>
								<br><br>
							</td>
						</tr>
						</table>
				<%	}
				%>
			</td>
		</tr>
		</table>
	</body>
</html>
