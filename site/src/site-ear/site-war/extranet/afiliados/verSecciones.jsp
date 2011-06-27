<%@ page import="com.tmk.admin.AlianzaSeccionLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.admin.AlianzaSeccionLocal,
                 com.tmk.admin.AlianzaLocalHome,
                 com.tmk.admin.AlianzaLocal,
                 com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.controllers.extranet.alianza.AlianzaHelper" %>

<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");

	if(idAlianza == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}

	AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
	AlianzaSeccionLocalHome seccionHome = (AlianzaSeccionLocalHome)DBUtil.getHome("AlianzaSeccion");

	AlianzaLocal alianza = alianzaHome.findByPrimaryKey(idAlianza);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet") %>
     	<script type="text/javascript" src="/js/Validation.js"></script>
		<script type="text/javascript">
			function actualizarSeccion(idSeccion)
			{
				var form = eval('document.seccion_' + idSeccion);
				form.action = '/ActualizarSeccion';

				if(isEmpty(form.<%= AlianzaHelper.NOMBRE_SECCION %>.value)) {
					alert('El nombre de la sección no puede estar vacío.');
				}
				else {
					form.submit();
				}
			}

			function borrarSeccion(idSeccion)
			{
				var form = eval('document.seccion_' + idSeccion);
				form.action = '/EliminarSeccion';
				form.submit();
			}

			function agregarSeccion() {
				form = document.AgregarSec;

				if (isEmpty(form.<%= AlianzaHelper.NOMBRE_SECCION %>.value)) {
					alert('Debés ingresar la Sección');
					return;
				}

				form.submit()
			}
		</script>

		<style type="text/css">
			table.main
			{
				border-style: solid;
				border-width: 0px 1px 1px 1px
			}

			.TextoCampo
			{
				font-size: 13px;
			}
		</style>

		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="/imagenes/intranet/fondo.gif">
		<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="750" height="100%">
		<tr>
			<td valign="top" >

			<table align="center" cellpadding="0" cellspacing="0" width="100%">
		<tr>
			<td>
				<jsp:include page="/extranet/comunes/header.jsp"/>
				<jsp:include page="/extranet/comunes/solapas.jsp"/>
			</td>
		</tr>
		</table>

				<table align="center" width="740">
				<tr>
					<td width="534">
						<br>
						<font style="font-size:12px" color="#003366">
							Secciones de su alianza
						</font>
						<br><br>
					</td>
				</tr>
				</table>

				<table cellspacing="10" cellpadding="0" align="center" width="650" style="border: 1px solid #59B3D9;">
  				<tr>
					<td width="19"></td>

					<td>
						<font class="TextoBordo">
							Razon Social:
						</font>
						<font class="TextoNegro">
 							<%= Convert.toString(alianza.getRAZON_SOCIAL(), "") %>
						</font>
					</td>
				</tr>

				<tr>
					<td></td>

					<td>
						<font class="TextoBordo">
						 	URL:
						</font>
						<font class="TextoNegro">
							<%= Convert.toString(alianza.getURL(), "") %>
						</font>
					</td>
				</tr>

				<tr>
					<td colspan="2" height="10">
					</td>
				</tr>

				<tr>
					<td></td>

					<td>
						<table cellspacing="0" cellpadding="0" align="left" width="100%" border="0">
						<tr>
							<td width="300">
								<font class="TextoBordo">
									Secciones
								</font>
							</td>

							<td width="100" align="center">
								<font class="TextoBordo">
									ID Seccion
								</font>
							</td>

							<td align="center">
								<font class="TextoBordo">
									Acciones
								</font>
							</td>
						</tr>
						</table>
					</td>
				</tr>

				<%	Iterator secciones = seccionHome.findVigentes(idAlianza).iterator();
				%>
				<tr>
					<td></td>

					<td>
						<table cellspacing="0" cellpadding="0" align="left" width="100%" border="0">
						<%	while(secciones.hasNext())
							{
								AlianzaSeccionLocal seccion = (AlianzaSeccionLocal)secciones.next();
						%>
								<form name="seccion_<%= seccion.getID_SECCION() %>" method="post">
									<input type="hidden" name="<%= AlianzaHelper.ID_ALIANZA %>" value="<%= Convert.toString(seccion.getID_ALIANZA(), "") %>">
									<input type="hidden" name="<%= AlianzaHelper.ID_SECCION %>" value="<%= Convert.toString(seccion.getID_SECCION(), "") %>">

									<tr>
										<td width="300">
											<input type="text" name="<%= AlianzaHelper.NOMBRE_SECCION %>" value="<%= Convert.toString(seccion.getSECCION_NOMBRE(), "") %>" size="40" class="TextoCampo">
										</td>

										<td align="center" width="100">
											<p class="TextoCampo">
												<%= Convert.toString(seccion.getID_SECCION(), "") %>
											</p>
										</td>

										<td align="center">
											<a href="javascript:actualizarSeccion(<%= seccion.getID_SECCION() %>);" class="TextoCampo">
												Modificar
											</a>
											<%if (!seccion.getID_SECCION().equals(new Integer(1))) {%>
											|

											<a href="javascript:borrarSeccion(<%= seccion.getID_SECCION() %>);" class="TextoCampo">
												Borrar
											</a>
											<%}%>
										</td>
									</tr>
								</form>
						<%	}
						%>
						</table>
					</td>
				</tr>

				<tr>
					<td></td>

					<td colspan="2" style="font-weight: bold;">
						<br>
						<font class="TextoBordo">
							Nueva secci&oacute;n
						</font>
					</td>
				</tr>


				<tr>
					<td width="19"></td>

					<td>
						<table border="0">
						<tr>
							<td width="400">
                            	<form action="/AgregarSeccion" method="post" name="AgregarSec">
									<input type="hidden" name="<%= AlianzaHelper.ID_ALIANZA %>" value="<%= idAlianza %>">
									<br>
									<input type="text" name="<%= AlianzaHelper.NOMBRE_SECCION %>" size="50" class="TextoCampo">
                                </form>
							</td>

							<td align="center" valign="middle">
								<a href="javascript:agregarSeccion();" class="TextoCampo">
									Agregar
								</a>
							</td>
						</tr>
						</table>
					</td>
				</tr>
				</table>
			</td>
		</tr>

		<tr>
			<td>
				<table width="700">
				<tr>
					<td align="right">
						<br><br>
						<a href="/extranet/afiliados/index.jsp">
							<img src="/imagenes/botonVolver.gif" border="0">
						</a>
						<br><br>
					</td>
				</tr>
				</table>
			</td>
		</tr>
	</table>
<%=Globals.getGoogleAnalyticsSSL()%>
</body>
</html>