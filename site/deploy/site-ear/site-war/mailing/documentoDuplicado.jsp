<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.setup.Contenido" %>
<%  String LOGIN = Convert.toString(request.getParameter("LOGIN"), ""); 
	String TIPO_DOC = Convert.toString(request.getParameter("TIPO_DOC"), "");
	String NRO_DOC =  Convert.toString(request.getParameter("NRO_DOC"), "");	
%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
<head>
		<%= Globals.estiloBasico() %>
	    <meta name="robots" content="noindex, nofollow">
        <meta name="GOOGLEBOT" content="noindex, nofollow">
		<script src="/js/Validation.js" type="text/javascript"></script>
		<style type="text/css" rel="stylesheet">
	div.TextoNegro
	{
		font-size: 10px;
		font-family: verdana;
		text-transform: uppercase;
		font-weight: bold;
		text-align: center;
	}
	a.EnlaceNegro
	{
		font-size: 10px;
		font-family: verdana;
		color: #000000;
		text-decoration: underline;
	}
	</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">

<table width="740" width="100%" cellspacing="0" cellpadding="3">
<tr>
	<td>
		<a href="<%= Globals.PAGINA_SITIO %>/index.jsp">
			<img src="<%= Globals.PAGINA_SITIO %>/imagenes/<%=Contenido.getLogo()%>" border="0" alt="<%= Contenido.getMensajeLogo() %>">
		</a>
	</td>
</tr>
<tr>
	<td style="border-top: 4px solid #C20200; background-color: #DCE1E6;">
		&nbsp;
	</td>
</tr>
<tr>
	<td>

	<br>

<table style="border-top: 2px solid #59B3D9;" width="590" align="center" cellspacing="0" cellpadding="3">
<tr align="center">
	<td>
	
		<br>
		<table bgcolor="#FFFFDF;" width="600" align="center" style="border-bottom: 3px solid #FF0000; border-top: 3px solid #FF0000;" cellpadding="4">
		<tr valign="middle">
			<td><img src="<%=Globals.PAGINA_SITIO%>/imagenes/miCuenta/baliza.gif"></td>
			<td>
				<div class="TextoNegro">
				Este documento "<%=TIPO_DOC%> <%=NRO_DOC%>" ya ha sido utilizado anteriormente por otro usuario, si ud. es el poseedor de 
				este documento, contáctese a  <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>" style="text-decoration:underline"><%=Globals.MAIL_CALL_CENTER%></a>. 
				Si ya se ha registrado con este número de documento en Temátika.com y no recuerda su clave, haga click <a href="<%=Globals.PAGINA_SITIO%>/miCuenta/recuperarClave.jsp?LOGIN=<%=LOGIN%>"  style="text-decoration:underline">aqui</a> 
				e ingrese la misma dirección de mail con la que se registró,
				y le será remitida su clave nuevamente.
					
				</div>
			</td>
		</tr>
		</table>
	
	
	</td>
</tr>


</table>

</form>

	</td>
</tr>
</table>

</body>
</html>
