<%@ page import="com.tmk.kernel.Globals"%>
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title("Garantía de Compra Segura en Tematika.com") %>
		<%= Globals.description("Garantía de Compra Segura en Tematika.com") %>
		<%= Globals.keywords("garantía, compra segura, certificado de seguridad, tematika, tematika.com") %>
	</head>


	<style>
		body
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		td
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		select
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		input
		{
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		a
		{
			color: #000000;
			font-family: Verdana, Arial, Sans-Serif;
			font-size: 10px;
		}

		.textoSolapa
		{
			font-weight: bold;
			font-size: 11px;
			text-decoration: none;
		}
	</style>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table width="770" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td width="390">
					<%@include file="/componentes/comunes/logo.jsp"%>
				</td>

				<td width="350" align="right" valign="top">
					<jsp:include page="/componentes/comunes/carrito.jsp" />
				</td>
			</tr>
		</table>

		<table bgcolor="#dce1e6" pad="#C20200" width="745" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td colspan="2" bgcolor="#ffffff">
				<jsp:include page="/componentes/comunes/solapas.jsp?modo=rojo" />
			</td>
		</tr>

		<tr>
			<td colspan="2" align="right" height="33">
				<jsp:include page="/componentes/inicio/buscador.jsp"/>
			</td>
		</tr>

		<tr>


			<td width="750" height="8" style="background:  url(/imagenes/sombrasuperior.gif);">
			</td>
		</tr>

		<tr valign="top" bgcolor="#ffffff">

			<td align="center">
			<br><br>
				<table>
					<tr valign="middle">
						<td><img src="/imagenes/semiCirculoIzq.gif"></td>
						<td><img src="/imagenes/garantia.gif"></td>
						<td><img src="/imagenes/semiCirculoDer.gif"></td>
					</tr>
					</table>


      <table width="667" align="center">
        <tr><td>
			<br><br>
						<hr color="#59B3D9" size="1">
					<div align="left"><font color="#990000" style="font-size=12px;"><b>GARANTIA DE COMPRA SEGURA</b></font><br><br></div>
					<div font color="#990000" style="line-height: 17px; font-size=9px">
					 Cada compra que usted realiza en <%=Globals.NOMBRE_DEL_SITIO%> está protegida. Nuestro sitio posée el Certificado de Seguridad otorgado por Verisign. Esto significa que toda la información enviada a este sitio, si se produce dentro de una sesión de SSL, viaja encriptada y protegida contra el acceso de terceros.<br>
Todos los datos personales que usted ingresa son capturados y encriptados con SSL (secure socket layers), la misma tecnología utilizada por los principales sitios de comercio electrónico en el mundo. Esta tecnología impide que terceros no autorizados puedan acceder a sus datos privados.<br>
Nuestro sitio valida las transacciones en forma online a través de un vínculo X-25 (canal de comunicación similar al utilizado por los cajeros automáticos). En nuestro caso el vínculo es satelital, lo que lo hace aún más seguro. Para asegurar aún más su información, una vez que recibimos sus datos, los almacenamos en un servidor inaccesible desde Internet.<br>
En caso de que, como consecuencia de la violación a una sesión de SSL, terceros no autorizados accedieran a datos suministrados por los usuarios durante una compra en <%=Globals.NOMBRE_DEL_SITIO%>, y se produjeran ilícitos a través del uso de la tarjeta de crédito por personas distintas de su titular, <%=Globals.NOMBRE_DEL_SITIO%> se hará cargo de los importes desconocidos por los usuarios.
</font>
</div>
 </td></tr></table>
      <table width="667" height="91">
        <tr>
		<td align="right">
 			<a href="/"><img src = "/imagenes/botonVolver.gif" border="0"></a>
		</td>
	</tr>
</table>


			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalytics()%>		
	</body>
</html>
