<%@ page import="com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.Globals"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAcceso("ALIANZAS", 'A')) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración de Alianzas") %>
	</head>

<script type="text/javascript" src="/js/Validation.js"></script>


<script>
function agregar()
{
	var form = document.formAlianza;

	if (isEmpty(form.RAZON_SOCIAL.value)) {
		alert('Debe ingresar la Razon Social');
		return;
	}
	if (isEmpty(form.URL.value)) {
		alert('Debe ingresar URL del Sitio');
		return;
	}

	if (isEmpty(form.NOMBRE_CONTACTO.value)) {
		alert('Debe ingresar el nombre del contacto');
		return;
	}
	if (isEmpty(form.APELLIDO_CONTACTO.value)) {
		alert('Debe ingresar el apellido del contacto');
		return;
	}
	if (isEmpty(form.CARGO_CONTACTO.value)) {
		alert('Debe ingresar el cargo del contacto');
		return;
	}
	if (isEmpty(form.COD_AREA.value)) {
		alert('Debe ingresar el codigo de area');
		return;
	}

	if (isEmpty(form.NRO_TEL.value)) {
		alert('Debe ingresar el numero de telefono del contacto');
		return;
	}

	if (!isMail(form.E_MAIL_1.value)) {
		alert('Debe ingresar un mail valido');
		return;
	}
	if (isEmpty(form.NOMBRE_PAGO_COMISION.value)) {
		alert('Debe ingresar el nombre correspondiente al Pago de comisiones');
		return;
	}
	if (isEmpty(form.APELLIDO_PAGO_COMISION.value)) {
		alert('Debe ingresar el apellido correspondiente al Pago de comisiones');
		return;
	}

	if (!isEmpty(form.PORC_COMISION_PARTICULAR.value) && !esEntero(form.PORC_COMISION_PARTICULAR.value)) {
		alert('Debe ingresar un valor entero en Porcentaje Fijo');
		return;
	}


	if (isEmpty(form.CUIT.value)) {
		alert('Debe ingresar el CUIT');
		return;
	}
	if (isEmpty(form.USUARIO.value)) {
		alert('Debe ingresar usuario');
		return;
	}

	if (isEmpty(form.CLAVE.value)) {
		alert('Debe ingresar la clave');
		return;
	}

	if (isEmpty(form.confirmaClave.value)) {
		alert('Debe confirmar la Clave');
		return;
	}

	if( (form.CLAVE.value) != (form.confirmaClave.value)){
		alert('La clave y su confirmacion deben ser iguales');
		return;
	}

form.submit();


}


</script>


<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table align="center" width="770"><tr bgcolor="#FFFFFF"><td>
<table width="100%" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<jsp:include page="/236-TMK/comunes/header.jsp"/>
		</td>
	</tr>
</table>
<br><br>
<form name="formAlianza" action="/AgregarAlianza" method="post">

        <table border=0 cellpadding="0" cellspacing="0" width="700" style="border: 1px solid #D9D9D9;" align="center">
          <tr>
      <td colspan="2" height="30" bgcolor="#D9D9D9" align="center"><b>Para formar
        parte del Programa de Afiliados el interesado deberá ingresar los siguientes
        datos:</b> </td>
    </tr>
<tr><td colspan="2" height="25"><font color="#990000"><b><br>Informacion del Sitio</b></font></td></tr>
<tr>
	<td colspan="2">
	<table width="467" border=0>
          <tr>
			<td width="3"></td>
			<td width="101" >Razon Social</td>
			<td width="371"><input type="text" name="RAZON_SOCIAL" size="55" style="font-size: 13px;"></td>
		</tr>
		<tr>
		<td width="3"></td>
			<td>URL del Sitio<br>http://</td>
			<td><font size="2"><input type="text" name="URL" size="55" style="font-size: 13px;"></font></td>
		</tr>
	</table>
	</td>
</tr>

<tr><td colspan="2"><font color="#990000"><b><br>Contacto</b></font></td></tr>
<tr>
	<td colspan="2">
		<table width="634" border=0>
                <tr>
				<td width="19"></td>
				<td width="161">Nombre</td>
				<td colspan="5"><input type="text" name="NOMBRE_CONTACTO" style="font-size: 13px;" size="55"></td>
			</tr>
			<tr>
				<td width="19"></td>
				<td>Apellido</td>
				<td colspan="5"><input type="text" name="APELLIDO_CONTACTO" style="font-size: 13px;" size="55"></td>
			</tr>
			<tr>
				  <td width="19" height="26"></td>
				<td>Cargo</td>
				<td colspan="5"><input type="text" name="CARGO_CONTACTO" style="font-size: 13px;" size="55"></td>
			</tr>

			<tr>
				<td width="19"></td>
				  <td>Codigo de Area</td>
				  <td width="34"><input type="text" name="COD_AREA" width="5" size= "5" style="font-size: 13px;"></td>
				  <td width="53">Numero</td>
				  <td width="52"><input type="text" name="NRO_TEL" style="font-size: 13px;" width="17" size="17"></td>  <td width="46" >Interno</td>
				  <td width="239"><input type="text" name="EXT_INT" width="20" size="7" style="font-size: 13px;"></td>
			</tr>

			<tr>
				<td width="19"></td>
				<td>Correo Electronico 1</td>
				<td colspan="5"><input type="text" name="E_MAIL_1" style="font-size: 13px;" size="55"></td>
			</tr>
			<tr>
				<td width="19"></td>
				<td>Correo Electronico 2</td>
				<td colspan="5"><input type="text" name="E_MAIL_2" style="font-size: 13px;" size="55"></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan="2"><font color="#990000"><b><br>
              Pago de comisiones:</b></font></td>

</tr>
<tr>
	        <td colspan="2">
              <table width="492" border="0">
          <tr>
				  <td width="0" height="26"></td>
				  <td width="51"> Nombre</td>
				<td colspan="5"><input type="text" name="NOMBRE_PAGO_COMISION" style="font-size: 13px;" size="55"></td>
			</tr>
			<tr>
				<td width="0"></td>
				<td>Apellido</td>
				<td colspan="3"><input type="text" name="APELLIDO_PAGO_COMISION" style="font-size: 13px;" size="40"></td>
			</tr>

			<tr>
				<td></td>
				<td>Tipo de Comision</td>
				<td>
					<select name="TIPO_COMISION">
						<option value="TPRO">Por Tipo de Producto</option>
						<option value="VOLV">Por Volumen de Ventas</option>
					</select>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>Porcentaje no Fijo</td>
				<td><input name="PORC_COMISION_PARTICULAR" size="9" value="0"></td>
			</tr>
		</table>
	</td>
</tr>

<tr>
	<td colspan="2"><font color="#990000"><b><br>Información de su cuenta:</b></font></td>
</tr>
<tr>
	<td>
		<table>
			<tr>
				<td width="10"></td>
				<td width="147">Tipo de Negocio</td></tr>
			<tr>
				<td></td>

				<td align="right"> Individual <input type="radio" name="TIPO_NEGOCIO" value="0" checked></td>
				<td width="104" align="right"> Corporativo <input type="radio" name="TIPO_NEGOCIO" value="1"></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"> Cuit <input type="radio" name="ident" value="checkbox" checked></td>
				<td align="right"> Cuil <input type="radio" name="ident" value="checkbox"></td>
				        <td width="12" align="right">N</td>
				<td width="144"><input type="text" name="CUIT" style="font-size: 13px;"></td>
			</tr>
		</table>
	</td>
</tr>
<tr>
	<td colspan="2"><font color="#990000"><b><br>Usuario y password:</b></font></td>
</tr>
<tr>
	<td>
		<table width="388">
			<tr>
				<td width="3"></td>
				<td width="162">Usuario</td>
				<td width="207"><input type="text" name="USUARIO" style="font-size: 13px;"></td>
			</tr>
			<tr>
				<td width="3"></td>
				<td>Clave de Acceso</td>
				<td><input type="password" name="CLAVE" style="font-size: 13px;"></td>
			</tr>
			<tr>
				<td width="3"></td>
		        <td>Confirmar Clave de<br> acceso </td>
				<td><input type="password" name="confirmaClave" style="font-size: 13px;"></td>
			</tr>
			<tr>
				<td width="3"></td>
				<td>Condicion frente al IVA</td>
				<td>
					<input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="1" checked> Inscripto
					<input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="0"> No inscripto
				</td>
			</tr>
		</table>
	</td>
</tr>

<tr>
	<td>
		<table>
			<tr>
				<td width="6"></td>
				<td>
				</td>
			</tr>
		</table>




	</td>
</tr>
</table>
<br>
  <table width="700" align="center" border="0">
    <tr>
		<td width="500">
		</td>

    	<td align="right">
			<a href="/236-TMK/inicio.jsp">
				<img src="/imagenes/botonVolver.gif" border="0">
			</a>
		</td>

		<td align="right">
			<a href="javascript:agregar();">
				<img src="/imagenes/botonTerminarAfiliacion.gif" border="0">
			</a>
		</td>
	</tr>
</table>
</form>

</td></tr></table>
</body>
</html>
