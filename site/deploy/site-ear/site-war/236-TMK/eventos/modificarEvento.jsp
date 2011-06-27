<%@ page import="java.util.Date,
                 java.util.GregorianCalendar,
                 com.tmk.common.SucursalLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.common.SucursalLocal,
                 com.tmk.kernel.Convert,
                 java.text.DecimalFormat,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
				 com.tmk.kernel.site.Evento,
				 com.tmk.setup.Contenido,
                 com.tmk.kernel.Globals" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if(usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("EVENTOS")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>" />
<%	}

	int ID_EVENTO = Convert.toNumber(request.getParameter("ID_EVENTO"), 0);

	Evento evento = Contenido.getSite().getEventos().getEvento(ID_EVENTO);
%>

<script type="text/javascript" src="/js/Validation.js"></script>

<style>
	.titulos
	{
		font-family: Verdana, Arial, Helvetica, sans-serif;
		font-size: 10px;
		font-weight: bold;
	}
</style>


<%	DecimalFormat df = new DecimalFormat("00");
%>

<html>
	<head>
		<%= Globals.estiloBasico() %>

		<script type="text/javascript">
			function modificarEvento() {
				var form = document.formEvento;

				if (isEmpty(form.DESCRIPCION.value)) {
					form.DESCRIPCION.focus();
					alert('Se debe indicar la descripcion del evento ');
					return;
				}

				form.submit();
			}
		</script>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="0" width="770" align="center">
			<tr>
				<td valign="top">
					<table width="100%" cellpadding="0" cellspacing="0">
						<tr>
							<td>
								<jsp:include page="/236-TMK/comunes/header.jsp"/>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr>
				<td valign="top">
					<form name="formEvento" action="/ModificarEvento" method="post">
						<input type="hidden" name="ID_EVENTO" value="<%= ID_EVENTO %>">
						<table bgcolor="#FFFFFF" cellpadding="0" cellspacing="5" height="100%" align="center" width="650" style="border: 1px solid #999999;">
						<tr>
							<td>
								<h3>
									Datos del evento
								</h3>
								<br><br>
							</td>
						</tr>

						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" align="center" width="100%">
									<tr>
										<td class="titulos" width="15%"><b>Fecha: </b></td>
										<td width="15%">
											<% Date fechaInicio = evento.getFecha();%>
											<input type="text" name="FECHA_INICIO" value="<%= fechaInicio.getYear() + 1900 %>-<%= df.format(fechaInicio.getMonth() + 1) %>-<%= df.format(fechaInicio.getDate()) %>" size="13" maxlength="10">
										</td>
										<td class="titulos" width="15%"><b>Hora Inicio:</b> </td>
										<td>
											<select name="HORA_INICIO">
											<%	for(int i = 0; i < 24; i++) {
											%>
													<option <%= (fechaInicio.getHours() == i) && (fechaInicio.getMinutes() == 0)? " selected " : " " %> value="<%= df.format(i) %>:00:00">
 														<%= df.format(i) %>:00
												 	</option>

												 	<option <%= (fechaInicio.getHours() == i) && (fechaInicio.getMinutes() == 15)? " selected " : " " %> value="<%= df.format(i) %>:15:00">
														<%= df.format(i) %>:15
													</option>

												 	<option <%= (fechaInicio.getHours() == i) && (fechaInicio.getMinutes() == 30)? " selected " : " " %> value="<%= df.format(i) %>:30:00">
 														<%= df.format(i) %>:30
													 </option>

												 	<option <%= (fechaInicio.getHours() == i) && (fechaInicio.getMinutes() == 45)? " selected " : " " %> value="<%= df.format(i) %>:45:00">
														<%= df.format(i) %>:45
													</option>
											<%	}
											%>
											</select>
										</td>
									</tr>

								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" align="center" width="100%">
									<tr>
										<td valign="top" class="titulos" width="15%"><b>Descripcion:</b></td>
										<td>
											<textarea name="DESCRIPCION" rows="5" cols="50"><%= evento.getDescripcion() %></textarea>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" align="center" width="100%">
									<tr>
										<td class="titulos" width="15%"><b>Sucursal:</b></td>
										<td>
											<select name="ID_SUCURSAL">
											<%	SucursalLocalHome sucursalHome = (SucursalLocalHome)DBUtil.getHome("Sucursal");
												Iterator sucursales = sucursalHome.findAll().iterator();
												while(sucursales.hasNext()) {
													SucursalLocal sucursal = (SucursalLocal)sucursales.next();
												%>
													<option value="<%= sucursal.getID_SUCURSAL() %>" <%= evento.getSucursal() == sucursal.getID_SUCURSAL().intValue() ? " selected " : "" %>>
 														<%= Convert.capitalizar(sucursal.getDESCRIPCION(), true) %>
													</option>
											<%	}
											%>
											</select>
										</td>
									</tr>
								</table>
							</td>
						</tr>

						<tr>
							<td>
								<table cellpadding="0" cellspacing="0" align="center" width="100%">
									<tr>
										<td class="titulos">
											<b>¿ Activa este evento ?</b>
											<input type="radio" name="ACTIVO" value="true" <%= evento.getActivo() ? " checked " : "" %>>Si
											<input type="radio" name="ACTIVO" value="false" <%= !evento.getActivo() ? " checked " : "" %>>No
										</td>
									</tr>
									<tr>
										<td align="right"></td>
									</tr>
								</table>
							</td>
						</tr>
						</table>

						<table width="700">
							<tr>
								<td>
									<br>
									<a href="javascript:modificarEvento();"><img src="/imagenes/botonActuaizarEvento.gif" border="0" align="right"></a>
									<br><br>
								</td>
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</body>
</html>
