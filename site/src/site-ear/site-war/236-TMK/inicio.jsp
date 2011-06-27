<%@ page import="com.tmk.kernel.Globals"%>
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración") %>
	</head>

	<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table cellpadding="0" cellspacing="0" align="center" bgcolor="#FFFFFF" height="100%">
		<tr>
			<td width="752" valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr bgcolor="#DEDBDE">
					<td>
						<jsp:include page="/236-TMK/comunes/header.jsp"/>
					</td>
				</tr>
				</table>

				<br><br>

				<table align="center">
				<tr>
					<td valign="top">
						<table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFEECC">
						<tr align="left" valign="middle">
                			<td height="30" colspan="2" align="center" valign="middle" bgcolor="#FF6600" class="Precios">
								<font color="#FFFFFF" size="5" face="Verdana, Arial, Helvetica, sans-serif">
									<strong>
										Bienvenido a la intranet de Tematika
									</strong>
								</font>
							</td>
						</tr>

						<tr align="left" valign="middle">
							<td height="103" colspan="2" valign="top">
								<p align="center" class="Precios">
									<font color="#000000" size="2" face="Arial, Helvetica, sans-serif">
										<br>
										Usted aqu&iacute; podra realizar las tareas de mantenimiento
										del site y de las alianzas,
									</font>
								</p>

								<p align="center" class="Precios">
									<font color="#000000" size="2" face="Arial, Helvetica, sans-serif">
										validaci&oacute;n de ordenes y la obtenci&oacute;n de reportes.
										<br>
										<br>
                    				</font>
									<font color="#000000" size="3" face="Arial, Helvetica, sans-serif">
                    				</font>
								</p>
							</td>
						</tr>

						<tr>
                			<td width="404" height="29">&nbsp;</td>

							<td width="157" align="center" valign="middle">
								<strong>
									<font color="#000000" size="2" face="Arial, Helvetica, sans-serif">
										Muchas Gracias.
									</font>
								</strong>
							</td>
						</tr>
						</table>
					</td>


				</tr>
				</table>
			</td>
		</tr>
		</table>
	</body>
</html>
