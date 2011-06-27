<%@ page import="com.tmk.kernel.Globals,
                 java.util.*,
                 com.tmk.service.orden.OrdenService,
				 com.tmk.controllers.intranet.ordenes.OrdenesHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.MedioDeCobroDAO"%>
<%--
				 //com.tmk.setup.Contenido,
                 //com.tmk.kernel.DBUtil,
                 /com.tmk.orden.OrdenLocalHome,
                 //com.tmk.socio.SocioPK,
                 //com.tmk.orden.OrdenLocal,
                 //com.tmk.kernel.Convert,
--%>                 
<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR") ) && !usuarioDAO.tieneAlgunAcceso("ORDEN_BUSCAR")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

<html>
	<head>
		<%= Globals.estiloBasico() %>

		<style type="text/css" rel="stylesheet">
			td
			{
				font-family: verdana;
				font-size: 11px;
			}

			div.TextoNegro
			{
				font-size: 10px;
				font-family: verdana;
				text-transform: uppercase;
				font-weight: bold;
				text-align: center;
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

			a.EnlaceNegro
			{
				font-size: 11px;
				font-family: verdana;
				color: #000000;
				text-decoration: none;
			}
		</style>

		<script type="text/javascript">
			function ordenPorId() {
                var idOrden = window.prompt("Ingrese el Número de la Orden a buscar", "");
                if (idOrden != null) {
                    document.location = '/236-TMK/ordenes/estadoOrden.jsp?idOrden=' + idOrden;
                }
			}
			function socioPorLoginEMail() {
                var email = window.prompt("Ingrese el Login o EMail del socio", "");
                if (email != null) {
                    document.location = '/236-TMK/ordenes/socio.jsp?email=' + email;
                }
			}
			function socioPorSucursalSocio() {
                var sucursal = window.prompt("Ingrese el Número de Sucursal", "");
                if (sucursal != null) {
					var socio = window.prompt("Ingrese la Clave del Socio", "");
					if (sucursal != null) {
	                    document.location = '/236-TMK/ordenes/socio.jsp?sucursal=' + sucursal + '&socio=' + socio;
					}
                }
			}
		</script>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="770" height="100%" >
			<tr>
				<td width="787" valign="top">
					<table width="100%" align="center" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<jsp:include page="/236-TMK/comunes/header.jsp"/>
							</td>
						</tr>
					</table>
					<br><br>

					<table width="650" align="center" >
						<tr>
							<td valign="top">
								<table width="100%" height="150">
								<tr valign="top">
									<td>
										<br>
										<font class="TextoBordo">
											Ordenes
										</font>
										<br><br>
										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR")) {
										%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientes.jsp?<%= OrdenesHelper.ADMNISTRACION %>=SI&<%= OrdenesHelper.MEDIO_COBRO %>=TARJETA" class="EnlaceNegro">
													A aprobar o rechazar
												</a>
												<br><br>
										<%	}
										%>




										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientes.jsp?<%= OrdenesHelper.ADMNISTRACION %>=SI&<%= OrdenesHelper.MEDIO_DE_COBRO%>=<%=Globals.CLAVE_MEDIO_DE_COBRO_FAX%>" class="EnlaceNegro">
													Por Fax
												</a>
												<br><br>
										<%	}
										%>

										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientes.jsp?<%= OrdenesHelper.ADMNISTRACION %>=SI&<%= OrdenesHelper.MEDIO_DE_COBRO%>=<%=Globals.CLAVE_MEDIO_DE_COBRO_RIOHB%>" class="EnlaceNegro">
													Por Rio Home Banking
												</a>
												<br><br>
										<%	}
										%>


										<%MedioDeCobroDAO rioNB = MedioDeCobroDAO.buscaMedioDeCobro(Globals.CLAVE_MEDIO_DE_COBRO_RIONB);%>
										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR") && rioNB.estaHabilitado()) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientes.jsp?<%= OrdenesHelper.ADMNISTRACION %>=SI&<%= OrdenesHelper.MEDIO_DE_COBRO%>=<%=Globals.CLAVE_MEDIO_DE_COBRO_RIONB%>" class="EnlaceNegro">
													Por Rio Net Banking
												</a>
												<br><br>
										<%	}
										%>


										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientes.jsp?<%= OrdenesHelper.ADMNISTRACION %>=SI&<%= OrdenesHelper.MEDIO_DE_COBRO%>=<%=Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO%>" class="EnlaceNegro">
													Por Reembolso
												</a>
												<br><br>
										<%	}
										%>

										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientesCupon.jsp" class="EnlaceNegro">
													Por Cupon de Pago
												</a>
												<br><br>
										<%	}
										%>

										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ordenesPendientesDM.jsp" class="EnlaceNegro">
													Por Dinero Mail
												</a>
												<br><br>
										<%	}									
										%>
										
										<%if (usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR")) {%>
											<img src="/imagenes/intranet/vineta.gif">
											<a href="/236-TMK/ordenes/ordenesPendientesArcash.jsp" class="EnlaceNegro">
												Por Cupones Prepagos Arcash
											</a>
											<br><br>
										<%	} %>

										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR")) {
										%>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="/236-TMK/ordenes/ultimasOrdenes.jsp" class="EnlaceNegro">
													Listado de últimas ordenes
												</a>
												<br><br>
										<%	}
										%>

										<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_BUSCAR")) {
										%>
												<br>
												<font class="TextoBordo">
													Busquedas
												</font>
												<br><br>
												<img src="/imagenes/intranet/vineta.gif">
												<a href="javascript:ordenPorId();">
													Por Número de Orden
												</a>
												<br><br>

										<%	}
										%>

									</td>

									<td>
									<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("SOCIO_BUSCAR")) {
									%>
											<br>
											<font class="TextoBordo">
												Socios
											</font>
											<br><br>

											<img src="/imagenes/intranet/vineta.gif">
											<a href="javascript:socioPorLoginEMail();" class="EnlaceNegro">
												Por Login o EMail
											</a>
											<br><br>

											<img src="/imagenes/intranet/vineta.gif">
											<a href="javascript:socioPorSucursalSocio();" class="EnlaceNegro">
												Por ID de Sucursal e ID de Socio
											</a>
											<br><br>

										<%	if (usuarioDAO.tieneAlgunAcceso("ALERTA_COMPRA_X_SOCIO")) {%>
											<img src="/imagenes/intranet/vineta.gif">
											<a href="/236-TMK/ordenes/alertaCompraSocios.jsp" class="EnlaceNegro">
												Alerta de Compra de Socios
											</a>
											<br><br>
										<% }%>

											<!-- img src="/imagenes/intranet/vineta.gif">
											<a href="/236-TMK/ordenes/ABMAlertas.jsp" class="EnlaceNegro">
												Alerta de compras
											</a>
											<br><br-->
										<%//}
										%>

									<%	}
									%>

									<%	if (usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR")) {
									%>
											<br>
											<font class="TextoBordo">
												Administración de tarjetas
											</font>
											<br><br>

											<img src="/imagenes/intranet/vineta.gif">
											<a href="/236-TMK/ordenes/tarjetaVerificada.jsp" class="EnlaceNegro">
												Base de datos de tarjetas
											</a>
											<br><br>
									<%	} %>
									</td>
								</tr>
							</table>
						<tr>
					</table>

					<br><br>

					<table width="714">
						<tr>
							<td height="35" align="right">
								<a href="/236-TMK/inicio.jsp"> <img src="/imagenes/botonVolver.gif" border="0"></a>
							</td>
						</tr>
					</table>

					<br><br>
				</td>
			</tr>
		</table>
	</body>
</html>