<%@ page import="com.tmk.kernel.Globals"%>

<%	Integer ID_ALIANZA = (Integer)session.getAttribute("Extranet.ID_ALIANZA");
	if(ID_ALIANZA == null) {
%>
		<jsp:forward page="/extranet/index.jsp" />
<%	}
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Extranet") %>
		<%= Globals.keywords("Extranet, Alianzas, Afiliados, Acuerdo, Administración, Ventas") %>
		<style type="text/css">
			table.main
			{
				border-style: solid;
				border-width: 0px 1px 1px 1px
			}

			.titulo{
				background-color: #FF6600;
				font-family: Arial;
				font-size:18px;
				font-weight: bold;
				color: #FFFFFF;
				text-align: center;
			}
		</style>

		<link href="/extranet/estilos/comun.css" rel="stylesheet" type="text/css">
	</head>

	<body background="/imagenes/extranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
		<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770" height="100%">
		<tr>
			<td align="center" valign="top">
				<table align="center" cellpadding="0" cellspacing="0" width="770">
				<tr>
					<td>
						<jsp:include page="/extranet/comunes/header.jsp"/>
						<jsp:include page="/extranet/comunes/solapas.jsp"/>
					</td>
				</tr>
				</table>

				<br><br><br>
				<table width="70%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFEECC">
				<tr align="left" valign="middle">
					<td height="30" colspan="3" align="center" valign="middle" bgcolor="#FF6600" class="titulo">
						Bienvenido a nuestro Programa de Afiliados
					</td>
				</tr>

				<tr align="left" valign="middle">
					<td width="12">&nbsp;</td>
					<td height="103" colspan="2" valign="top" style="font-weight: bold;" class="TextoNegro">
						<br>

          					Estos son los servicios que le ofrecemos, dado que usted ya cuenta
          					con su usuario y password de afiliado:
          				<br>	
            			<ul>
	            			<li>
								Configurar su perfil de afiliado y personalizar su sitio con nuestro
								contenidos.
							</li>
	            			<li>
								Acceder a los movimientos de su cuenta de afiliado y generar
								reportes estadisticos de visitas y ventas.
							</li>
	            			<li>
								Generar el pago de su comisión.
							</li>
							<li>
								Descargar las últimas novedades en formato RSS, personalizadas con el ID de su alianza.
							</li>
						</ul>
             		</td>
				</tr>

				<tr>
					<td></td>
					<td width="404" height="29">&nbsp;</td>
					<td width="157" align="center" valign="middle">
					<strong>
						<font color="#000000" size="2">
							Muchas Gracias.
						</font>
					</strong>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>
	</body>
</html>