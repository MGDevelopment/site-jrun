<%@ page import="com.tmk.kernel.Globals, 
				 com.tmk.controllers.fidelizacion.ActualizacionEMailManager,
				 java.net.URLEncoder, java.net.URLDecoder"%>
				 
<%
String codigo =request.getParameter("codigo");
%>				 
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
<head>
<title>Beneficios eXtra!</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">.unsubs:hover {
	FONT: 10px Verdana, Arial, Helvetica, sans-serif; SIZE: 1; COLOR: #003366; TEXT-DECORATION: underline
}
.unsubs {
	FONT: 10px Verdana, Arial; SIZE: 1; COLOR: #003366; TEXT-DECORATION: none
}
.link:hover {
	FONT: 10px Verdana, Arial, Helvetica, sans-serif; SIZE: 1; COLOR: #CC0000; TEXT-DECORATION: underline
}
.link {
	FONT: 10px Verdana, Arial, Helvetica, sans-serif; SIZE: 1; COLOR: #336600; TEXT-DECORATION: none
}
.texto {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 12px;
	color: #333333;
	text-decoration: none;
}
.extra {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	font-weight: bold;
	color: #666666;
	text-decoration: none;
}
.legales {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	color: #999999;
	text-decoration: none;
}
.legales2 {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 9px;
	color: #333333;
	text-decoration: none;
}
.textoblanco {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: #FFFFFF;
	text-decoration: none;
}
.textobig {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 14px;
	color: #333333;
	text-decoration: none;
}
</style>
</head>

<body bgcolor="#A4D1DD">
<p align="center"><span class="unsubs">Si no pod&eacute;s visualizar correctamente
  este mensaje </span><a href="<%=Globals.PAGINA_SITIO + ActualizacionEMailManager.CUERPO_EMAIL%>?codigo=<%=codigo%>" target="_blank" class="unsubs">clique&aacute; 
  aqu&iacute;</a></p>
<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr> 
    <td width="600"><a href="<%=Globals.PAGINA_SITIO%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_01.gif" width="600" height="50" border="0"></a><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_02.gif" width="600" height="80"><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_03.gif" width="150" height="57" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_04.gif" width="450" height="57" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_05.gif" width="351" height="234" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_06.gif" width="249" height="234" border="0"></a><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_07.gif" width="600" height="63"><a href="<%=Globals.PAGINA_SITIO%>/fidelizacion/panel/puntos.jsp" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/imagenes/fidelizacion/datos-1b_08.gif" width="600" height="64" border="0"></a></td>
  </tr>
</table>
<table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="35"><p align="center" class="unsubscribe"><span class="unsubs">Si 
        no quer&eacute;s recibir m&aacute;s informaci&oacute;n</span> <a href="mailto:info@promocionesextra.com.ar?Subject=Remover" class="unsubs">clique&aacute; 
        aqu&iacute;</a></p>
      </td>
  </tr>
</table>
</body>
</html>