<%@ page import="com.tmk.kernel.DBUtil,
				 com.tmk.admin.*,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper"%>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");

	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}

	int error = Convert.toNumber(request.getParameter(AlianzaHelper.ERROR), AlianzaHelper.NO_ERROR);

	AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
	AlianzaLocal alianza = alianzaHome.findByPrimaryKey(idAlianza);

    String errUsr = (String)session.getAttribute("Extranet.errUsr");
    String errGen = (String)session.getAttribute("Extranet.errGen");
%>


<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet") %>
		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">

        <script type="text/javascript" src="/js/Validation.js">
		</script>

		<script type="text/javascript">
			function validarFormulario(frm) {
				if (isEmpty(formAfiliado.<%= AlianzaHelper.RAZON_SOCIAL %>.value)) {
					alert('Debés ingresar la Razón Social');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.URL %>.value)) {
					alert('Debés ingresar la URL del Sitio');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.NOMBRE_CONTACTO %>.value)) {
					alert('Debés ingresar el nombre del contacto.');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.APELLIDO_CONTACTO %>.value)) {
					alert('Debe ingresar el apellido del contacto');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.CARGO_CONTACTO %>.value)) {
					alert('Debés ingresar el cargo del contacto');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.COD_AREA %>value)) {
					alert('Debés ingresar el código de área');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.NRO_TEL %>.value)) {
					alert('Ingresá el número de teléfono del contacto');
					return;
				}

				if (!isMail(formAfiliado.<%= AlianzaHelper.E_MAIL_1 %>.value)) {
					alert('Debés ingresar un mail valido');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.NOMBRE_PAGO_COMISION %>.value)) {
					alert('Ingresá el nombre correspondiente al Pago de comisiones');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.APELLIDO_PAGO_COMISION %>.value)) {
					alert('Ingresá el apellido correspondiente al Pago de comisiones');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.CUIT %>.value)) {
					alert('Debés ingresar el CUIT o CUIL');
					return;
				}
				if (isEmpty(formAfiliado.<%= AlianzaHelper.USUARIO %>.value)) {
					alert('Debés ingresar usuario');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.CLAVE %>.value)) {
					alert('Debés ingresar la clave');
					return;
				}

				if (isEmpty(formAfiliado.<%= AlianzaHelper.CONFIRMACION_CLAVE %>.value)) {
					alert('Debe confirmar la clave');
					return;
				}

				if ((formAfiliado.<%= AlianzaHelper.CLAVE %>.value) != (formAfiliado.<%= AlianzaHelper.CONFIRMACION_CLAVE %>.value)) {
					alert('La clave y su confirmación deben ser iguales');
					return;
				}

				document.formAfiliado.submit();
			}

			function mostrarError() {
				if (<%= error %> != <%= AlianzaHelper.NO_ERROR %>) {
					var msg;

					switch(<%= error %>) {
						case <%= AlianzaHelper.ERROR_GENERAL %>:
							msg = "Error al actualizar los datos, volvé a intentar.";
							break;
						case <%= AlianzaHelper.ERROR_USUARIO %>:
							msg = "Ya existe ese nombre de usuario. Por favor, elegí otro.";
							break;
					}

					window.alert(msg);
				}
			}
		</script>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
		<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770">
		<tr>
			<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<jsp:include page="/extranet/comunes/header.jsp"/>
						<jsp:include page="/extranet/comunes/solapas.jsp"/>
					</td>
				</tr>
				</table>

				<form name="formAfiliado" action="/ActualizarAlianza" method="post">
					<input type="hidden" name="<%= AlianzaHelper.ID_ALIANZA %>" value="<%= idAlianza %>">

					<table border=0 cellpadding="10" cellspacing="0" width="700" style="border: 1px solid #59B3D9;" align="center">
					<tr>
						<td height="30" bgcolor="#59B3D9" align="center">
							<font class="TextoNegro">
								Modifique los datos que desea cambiar
							</font>
						</td>
					</tr>
<%
    if(errGen != null) {
        session.removeAttribute("Extranet.errUsr");
		%>

                    <tr>
						<td align="center">
							<font color="red">
								<b><%= errGen %></b>
							</font>
						</td>
					</tr>
<%
    }
%>
                    <tr>
						<td>
							<font class="TextoBordo">
								Informacion del Sitio
							</font>
						</td>
					</tr>

					<tr>
						<td>
							<table width="100%" border="0">
							<tr>
								<td width="3"></td>
								<td width="160">Razon Social</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.RAZON_SOCIAL %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getRAZON_SOCIAL(), "") %>" size="55" maxlength="50">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>URL del Sitio http://</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.URL %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getURL(), "") %>" size="55">
								</td>
							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							<font class="TextoBordo">
								Contacto
							</font>
						</td>
					</tr>

					<tr>
						<td>
							<table width="100%" border="0">
							<tr>
								<td width="3"></td>
								<td width="160">Nombre</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.NOMBRE_CONTACTO %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getNOMBRE_CONTACTO(), "") %>" size="55">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Apellido</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.APELLIDO_CONTACTO %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getAPELLIDO_CONTACTO(), "") %>" size="55">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Cargo</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.CARGO_CONTACTO %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getCARGO_CONTACTO(), "") %>" size="55">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Telefono</td>
								<%	AlianzaTelefonoPK alianzaTelefonoPK = new AlianzaTelefonoPK(idAlianza, "PART");
									AlianzaTelefonoLocalHome telefonoHome = (AlianzaTelefonoLocalHome)DBUtil.getHome("AlianzaTelefono");

									try {
										AlianzaTelefonoLocal alianzaTelefonoLocal = telefonoHome.findByPrimaryKey(alianzaTelefonoPK);
								%>
										<td>
											<table>
											<tr>
												<td width="54">Cod. Area</td>
												<td width="24">
													<input type="text" name="<%= AlianzaHelper.COD_AREA %>" width="5" size= "5" style="font-size: 13px;" value="<%= alianzaTelefonoLocal.getCOD_AREA() %>">
												</td>
												<td width="54">Numero</td>
												<td width="53">
													<input type="text" name="<%= AlianzaHelper.NRO_TEL %>" style="font-size: 13px;" width="17" size="17" value="<%= alianzaTelefonoLocal.getNRO_TEL() %>">
												</td>
												<td width="47" >Interno</td>
												<td width="249">
													<input type="text" name="<%= AlianzaHelper.EXT_INT %>" width="20" size="7" style="font-size: 13px;" value="<%= alianzaTelefonoLocal.getEXT_INT() == null ? "" : alianzaTelefonoLocal.getEXT_INT() %>">
												</td>
											</tr>
											</table>
										</td>
								<%	} catch (Exception e) {
								%>
										<td>
											<table>
											<tr>
												<td width="54">Cod. Area</td>
												<td width="24">
													<input type="text" name="<%= AlianzaHelper.COD_AREA %>" width="5" size= "5" style="font-size: 13px;">
												</td>
												<td width="54">Numero</td>
												<td width="53">
													<input type="text" name="<%= AlianzaHelper.NRO_TEL %>" style="font-size: 13px;" width="17" size="17">
												</td>
												<td width="47" >Interno</td>
												<td width="249">
													<input type="text" name="<%= AlianzaHelper.EXT_INT %>" width="20" size="7" style="font-size: 13px;">
												</td>
											</tr>
											</table>
										</td>
								<%	}
								%>
							</tr>

							<tr>
								<td></td>
								<td>Correo Electronico 1</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.E_MAIL_1 %>" style="font-size: 13px;" size="55"  value="<%= Convert.toString(alianza.getE_MAIL_1(), "") %>">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Correo Electronico 2</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.E_MAIL_2 %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getE_MAIL_2(), "") %>" size="55">
								</td>
							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							<font class="TextoBordo">
								Pago de comisiones:
							</font>
						</td>
					</tr>

					<tr>
						<td>
							<table width="100%" border="0">
							<tr>
								<td width="3"></td>
								<td width="160">Nombre</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.NOMBRE_PAGO_COMISION %>" style="font-size: 13px;" size="55" value="<%= Convert.toString(alianza.getNOMBRE_PAGO_COMISION(), "") %>">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Apellido</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.APELLIDO_PAGO_COMISION %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getAPELLIDO_PAGO_COMISION(), "") %>" size="55">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Tipo de Comision</td>
								<td>
									<select name="<%= AlianzaHelper.TIPO_COMISION %>" value="<%= alianza.getTIPO_COMISION() %>" style="font-size: 12px;">
										<option value="TPRO" <%= alianza.getTIPO_COMISION().equals("TPRO") ? "selected" : "" %>>
											Por Tipo de Producto
										</option>

										<option value="VOLV" <%= alianza.getTIPO_COMISION().equals("VOLV") ? "selected" : "" %>>
											Por Volumen de Ventas
										</option>
									</select>
								</td>
							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							<font class="TextoBordo">
								Informaci&oacute;n de su cuenta:
							</font>
						</td>
					</tr>

					<tr>
						<td>
							<table width="100%" border="0">
							<tr>
								<td width="3"></td>
								<td width="160">
									Tipo de Negocio
								</td>

								<td>
									<%	String negocioIndividual="";
										String negocioCorporativo="";

										if (alianza.getTIPO_NEGOCIO().equalsIgnoreCase("0")){
											negocioIndividual = "checked";
										} else {
											negocioCorporativo = "checked";
										}
									%>
									<input type="radio" name="<%= AlianzaHelper.TIPO_NEGOCIO %>" value="0" <%= negocioIndividual %>>
									Individual
									<input type="radio" name="<%= AlianzaHelper.TIPO_NEGOCIO %>" value="1" <%= negocioCorporativo %>>
									Corporativo
								</td>
							</tr>

							<tr>
								<td></td>
								<td>
									CUIT / CUIL
								</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.CUIT %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getCUIT(), "") %>">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>
									Condicion frente al IVA
								</td>
								<td>
									<%	String chequearInscripto= "";
										String chequearNoInscripto="";
										if (alianza.getID_TIPO_CONTRIBUYENTE().intValue()==1) {
											chequearInscripto="checked";
									 	} else {
											chequearNoInscripto="checked";
										}
									%>
									<input type="radio" name="<%= AlianzaHelper.ID_TIPO_CONTRIBUYENTE %>" value="1" <%=chequearInscripto%> >
									Inscripto
									<input type="radio" name="<%= AlianzaHelper.ID_TIPO_CONTRIBUYENTE %>" value="0" <%=chequearNoInscripto%> >
									No inscripto
								</td>
							</tr>
							</table>
						</td>
					</tr>

					<tr>
						<td>
							<font class="TextoBordo">
								Usuario y password:
							</font>
						</td>
					</tr>

					<tr>
						<td>
							<table width="100%" border="0">
							<tr>
								<td width="3"></td>
								<td width="160">
									Usuario
								</td>
								<td>
									<input type="text" name="<%= AlianzaHelper.USUARIO %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getUSUARIO(), "") %>">
                                    &nbsp;
<%
    if(errUsr != null) {
        session.removeAttribute("Extranet.errUsr");
		%>
			    <font color="red">
 				   <b><%= errUsr %></b>
				</font>
                <%= "<script> window.formAfiliado.usuario.focus();</script>"%>
		<%	}
%>

								</td>
							</tr>

							<tr>
								<td></td>
								<td>Clave de Acceso</td>
								<td>
									<input type="password" name="<%= AlianzaHelper.CLAVE %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getCLAVE(), "") %>">
								</td>
							</tr>

							<tr>
								<td></td>
								<td>Confirmar Clave de acceso </td>
								<td>
									<input type="password" name="<%= AlianzaHelper.CONFIRMACION_CLAVE %>" style="font-size: 13px;" value="<%= Convert.toString(alianza.getCLAVE(), "") %>">
								</td>
							</tr>
							</table>
						</td>
					</tr>
					</table>

					<br>

					<table align="center" width="700" border="0">
					<tr>
						<td align="right" width="550">
							<a href="/extranet/afiliados/">
								<img src="/imagenes/botonVolver.gif" border="0">
							</a>
						</td>

						<td align="right">
							<a href="javascript:validarFormulario(document.formAfiliado);">
								<img src="/imagenes/botonActualizar.gif" border="0">
							</a>
						</td>
					</tr>
					</table>
				</form>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>
