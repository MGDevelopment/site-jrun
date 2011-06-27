<%@ page import="com.tmk.controllers.institucional.ClientesInstitucionalesHelper,
	com.tmk.kernel.Convert"%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 	
<html>
	<head>
		<%
			String RAZON_SOCIAL = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_RAZON_SOCIAL), " ");
		    String NOMBRE_FANTASIA = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_NOMBRE_FANTASIA), " ");
		    String DIRECCION = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_DIRECCION), " ");
			String CIUDAD = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_CIUDAD), " ");
			String PROVINCIA = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_PROVINCIA), " ");
			String PAIS = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_PAIS), " ");
		    String CODIGO_POSTAL = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_CODIGO_POSTAL), " ");
			String TEL = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_TEL), " ");
			String FAX = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_FAX), " ");
			String URL = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_URL), " ");
			String NOMBRE = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_NOMBRE), " ");
			String MAIL = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_MAIL), " ");
			String TELEFONO = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_TELEFONO), " ");
			String COMENTARIO = Convert.toString(request.getParameter(ClientesInstitucionalesHelper.CAMPO_COMENTARIO), " ");
		%>

	</head>

<table width="90%" border="1" cellpadding="2" cellspacing="0" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">

  <TR>
    <TD><strong>Datos Institucionales</strong></TD>
    <TD>&nbsp;</TD>
  </TR>
  <TR>
    <TD width="160">&nbsp; Razon Social:
    </TD>
    <TD width="500"><%= RAZON_SOCIAL%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Nombre de fantasia:</TD>
    <TD><%= NOMBRE_FANTASIA%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Direcci&oacute;n: </TD>
    <TD><%= DIRECCION%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Ciudad:</TD>
    <TD><%= CIUDAD%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Provincia:</TD>
    <TD><%= PROVINCIA%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Pa&iacute;s:</span></TD>
    <TD><%= PAIS%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Codigo Postal:</TD>
    <TD><%= CODIGO_POSTAL%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Tel:</TD>
    <TD><%= TEL%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Fax:</TD>
    <TD><%= FAX%></TD>
  </TR>
  <TR>
    <TD>&nbsp; URL de la instituci&oacute;n:</TD>
    <TD><%= URL%></TD>
  </TR>
  <TR>
    <TD><STRONG>Contacto</STRONG></TD>
    <TD><STRONG>
      <P>&nbsp;</STRONG></TD>
  </TR>
  <TR>
    <TD>&nbsp; Nombres y Apellido:</TD>
    <TD><%= NOMBRE%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Correo electronico:</TD>
    <TD><%= MAIL%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Tel&eacute;fono:</TD>
    <TD><%= TELEFONO%></TD>
  </TR>
  <TR>
    <TD>&nbsp; Comentarios:</TD>
    <TD><%= COMENTARIO%> </TD>
  </TR>
</TABLE>



</body>
</html>
