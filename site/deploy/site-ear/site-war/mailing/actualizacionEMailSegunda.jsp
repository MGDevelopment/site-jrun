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
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style type="text/css">.unsubs:hover {
	FONT: 10px Verdana, Arial, Helvetica, sans-serif; SIZE: 1; COLOR: #003366; TEXT-DECORATION: underline
}
.unsubs {
	FONT: 10px Verdana, Arial; SIZE: 1; COLOR: #003366; TEXT-DECORATION: none
}
.textoblanco {
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 10px;
	color: #FFFFFF;
	text-decoration: none;
}
</style>
</head>

<body bgcolor="#A4D1DD" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td valign="top" bgcolor="#A4D1DD"><table width="600" border="0" align="center" cellpadding="0" cellspacing="0">
        <tr> 
          <td width="600" height="50"><div align="center"><span class="unsubs">Si 
              no pod&eacute;s visualizar correctamente este mensaje </span><a href="<%=Globals.PAGINA_SITIO + ActualizacionEMailManager.CUERPO_EMAIL_SEGUNDA%>?codigo=<%=codigo%>" target="_blank" class="unsubs">clique&aacute; 
              aqu&iacute;</a></div></td>
        </tr>
        <tr> 
          <td width="600"><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_01.gif" width="600" height="50" border="0"></a><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_02.gif" width="600" height="80"><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_03.gif" width="150" height="57" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_04.jpg" width="450" height="57" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_05.gif" width="349" height="263" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_06.jpg" width="251" height="263" border="0"></a><a href="<%=Globals.PAGINA_SITIO +  ActualizacionEMailManager.CONTROLADOR_FIN + "?codigo=" + codigo%>" target="_blank"><img src="<%=Globals.PAGINA_SITIO%>/grupos/fidelizacion/mailing2007/agosto3/datos-1b_07.gif" width="600" height="68" border="0"></a></td>
        </tr>
        <tr> 
          <td height="30"><p align="center" class="unsubscribe"><span class="unsubs">Para 
              no recibir m&aacute;s correos de ILHSA hac&eacute; <a href="http://mail.promocionesextra.com.ar/unsubscribe.php?id=%5Bdesuscrip%5D" target="_blank" class="unsubs">click 
              aqu&iacute;</a></span></p></td>
        </tr>
      </table></td>
  </tr>
</table>
</body>
</html>