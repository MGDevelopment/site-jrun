<%@ page import="com.tmk.controllers.intranet.ordenes.TarjetaVerificadaHelper,
				 com.tmk.service.orden.OrdenService,
				 com.tmk.orden.OrdenDAO,
				 com.tmk.admin.TarjetaVerificadaLocalHome,
				 com.tmk.admin.TarjetaVerificadaLocal,
                 com.tmk.kernel.*" %>

<%
	String flagMail = request.getParameter("flagMail");

	String numeroTarjeta = Convert.toString(request.getParameter(TarjetaVerificadaHelper.NUMERO_TARJETA), "");
	String nombreSocio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.NOMBRE_SOCIO), "");
	String apellidoSocio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.APELLIDO_SOCIO), "");
	String email = Convert.toString(request.getParameter(TarjetaVerificadaHelper.EMAIL), "");

	String calleEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.CALLE_ENVIO), "");
	String numeroEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.NUMERO_ENVIO), "");
	String edificioEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.EDIFICIO_ENVIO), "");
	String pisoEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.PISO_ENVIO), "");
	String deptoEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.DEPTO_ENVIO), "");
	String cpEnvio = Convert.toString(request.getParameter(TarjetaVerificadaHelper.CP_ENVIO), "");

	String calleFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.CALLE_FACTURACION), "");
	String numeroFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.NUMERO_FACTURACION), "");
	String edificioFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.EDIFICIO_FACTURACION), "");
	String pisoFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.PISO_FACTURACION), "");
	String deptoFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.DEPTO_FACTURACION), "");
	String cpFacturacion = Convert.toString(request.getParameter(TarjetaVerificadaHelper.CP_FACTURACION), "");

	Integer nivelRiesgo = new Integer(request.getParameter(TarjetaVerificadaHelper.NIVEL_RIESGO));
	String comentarios = Convert.toString(request.getParameter(TarjetaVerificadaHelper.COMENTARIOS), "");
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Datos de la tarjeta") %>
		<link rel="stylesheet" href="<%=Globals.PAGINA_SITIO %>/estilos/comun.css" type="text/css">

		<script type="text/javascript">
			function volver() {
				window.close();
			}
		</script>
	</head>
    <%
	    try {
    %>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table width="400" align="center">
		<tr>
			<td>
				<table align="center">

				<tr>
					<td height="33" colspan="5">
						<br>
						<hr color="#59B3D9" size="1" width="350">
						<br><br>
					</td>
				</tr>
				</table>

				<table class="textoClasico" style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="300" border="1" align="center" cellspacing="0" cellpadding="5">
				<tr>
					<td>
						<b>Riesgo<b>
					</td>

					<td>
                    	<%= NivelDeRiesgoDAO.buscaNivelDeRiesgo(nivelRiesgo) %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Nro. de tarjeta:<b>
					</td>

					<td>
                    	<%= numeroTarjeta %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Titular:<b>
					</td>

					<td>
                    	<%= nombreSocio %>,&nbsp;<%= apellidoSocio %>
					</td>
				</tr>

				<tr>
					<td>
						<b>e-mail:<b>
					</td>

					<td>
                    	<%= email %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Domicilio envio:<b>
					</td>

					<td>
						<%= calleEnvio %>&nbsp;
 						<%= numeroEnvio %>
						<%= ("".equals(edificioEnvio))? "": " Ed:" + edificioEnvio %>
						<%= ("".equals(deptoEnvio))? "": " Dpto:" + deptoEnvio %>
						<%= ("".equals(pisoEnvio))? "": " Piso:" + pisoEnvio %>
						<%= ("".equals(cpEnvio))? "": " CP:" + cpEnvio %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Domicilio facturacion:<b>
					</td>

					<td>
						<%= calleFacturacion %>&nbsp;
 						<%= numeroFacturacion %>
						<%= ("".equals(edificioFacturacion))? "": " Ed:" + edificioFacturacion %>
						<%= ("".equals(deptoFacturacion))? "": " Dpto:" + deptoFacturacion %>
						<%= ("".equals(pisoFacturacion))? "": " Piso:" + pisoFacturacion %>
						<%= ("".equals(cpFacturacion))? "": " CP:" + cpFacturacion %>
					</td>
				</tr>

				<tr>
					<td>
						<b>Comentarios:<b>
					</td>

					<td>
						<%= comentarios %>
					</td>
				</tr>
				</table>

				<table align="right">
				<tr>
					<td align="right">
					<%
					if (flagMail == null) {
					%>

						<br><br><br>
						<a href="javascript:volver()">
							<img src="/imagenes/botonVolver.gif" border="0">
						</a>
					<%
					}
					%>
					</td>
				</tr>
				</table>
			</td>
		</tr>
		</table>
	</body>
	<%
	    } catch (Exception e) {
		    TmkLogger.debug("TARJETA VERIFICADA] MAIL error " + e.getMessage());

	}
	%>

</html>