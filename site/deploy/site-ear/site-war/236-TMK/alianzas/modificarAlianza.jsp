<%@ page import="com.tmk.kernel.DBUtil,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.admin.*,
                 com.tmk.kernel.Globals"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAcceso("ALIANZAS", 'M')) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
<%
	Integer ID_ALIANZA = Integer.valueOf(request.getParameter("ID_ALIANZA"));
	AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
	AlianzaLocal alianza = alianzaHome.findByPrimaryKey(ID_ALIANZA);

%>
<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración de Alianzas") %>
	</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770">
 <tr>
  <td>
	<table width="100%" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td>
				<jsp:include page="/236-TMK/comunes/header.jsp"/>
			</td>
		</tr>
	</table>


<form name="formModificar" action="/ActualizarAlianza" method="post">
<input type="hidden" name="ID_ALIANZA" value="<%= ID_ALIANZA %>">


 <table border=0 cellpadding="2" cellspacing="0" width="700" style="border: 1px solid #D9D9D9;" align="center">
   <tr>
      <td colspan="2" height="30" bgcolor="#D9D9D9" align="center"><b>Modifique los datos que desea cambiar</b></td>
    </tr>
    <tr>
	<tr><td height="25" colspan="2"><font color="#990000"><b><br>Informacion del Sitio</b></font></td></tr>
	<tr>
		<td colspan="2">
			<table>
				<tr>
					<td width="3"></td>
					<td >Razon Social</td>
					<td><input type="text" name="RAZON_SOCIAL" size="55" style="font-size: 13px;" value="<%= alianza.getRAZON_SOCIAL() %>"></td>
				</tr>
				<tr>
					<td width="3"></td>
					<td>URL del Sitio<br>http://</td>
					<td><font size="2"><input type="text" name="URL" size="55" style="font-size: 13px;" value="<%= alianza.getURL() %>"></font></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr><td colspan="2"><font color="#990000"><b><br>Contacto</b></font></td></tr>
	<tr><td colspan="2">
	<table width="634" border=0>
                <tr>
				<td width="19"></td>
				<td width="158">Nombre</td>
				<td colspan="5"><input type="text" name="NOMBRE_CONTACTO" style="font-size: 13px;" size="55" value="<%= alianza.getNOMBRE_CONTACTO() %>"></td>
			</tr>
			<tr>
				<td width="19"></td>
				<td>Apellido</td>
				<td colspan="5"><input type="text" name="APELLIDO_CONTACTO" style="font-size: 13px;" size="55" value="<%= alianza.getAPELLIDO_CONTACTO() %>"></td>
			</tr>
			<tr>
				  <td width="19" height="26"></td>
				<td>Cargo</td>
				<td colspan="5"><input type="text" name="CARGO_CONTACTO" style="font-size: 13px;" size="55" value="<%= alianza.getCARGO_CONTACTO() %>"></td>
			</tr>
			<tr>
				<td width="19"></td>
				  <td>Codigo de Area</td>
                  <%
                        AlianzaTelefonoPK alianzaTelefonoPK = new AlianzaTelefonoPK(new Integer(request.getParameter("ID_ALIANZA")),"PART");
                        AlianzaTelefonoLocalHome telefonoHome = (AlianzaTelefonoLocalHome)DBUtil.getHome("AlianzaTelefono");
                        AlianzaTelefonoLocal alianzaTelefonoLocal = telefonoHome.findByPrimaryKey(alianzaTelefonoPK);
                  %>
				  <td width="24"><input type="text" name="COD_AREA" width="5" size= "5" style="font-size: 13px;" value="<%= alianzaTelefonoLocal.getCOD_AREA()%>"></td>
				  <td width="54">Numero</td>
				  <td width="53"><input type="text" name="NRO_TEL" style="font-size: 13px;" width="17" size="17" value= "<%=alianzaTelefonoLocal.getNRO_TEL()%>"></td>  <td width="47" >Interno</td>
				  <td width="249"><input type="text" name="EXT_INT" width="20" size="7" style="font-size: 13px;" value= "<%=alianzaTelefonoLocal.getEXT_INT() == null ? "" : alianzaTelefonoLocal.getEXT_INT() %>"></td>
			</tr>
			<tr>
				<td width="19"></td>
				<td>Correo Electronico 1</td>
				<td colspan="5"><input type="text" name="E_MAIL_1" style="font-size: 13px;" size="55"  value="<%= alianza.getE_MAIL_1() %>"></td>
			</tr>
			<tr>
				<td width="19"></td>
				<td>Correo Electronico 2</td>
				<td colspan="5"><input type="text" name="E_MAIL_2" style="font-size: 13px;" size="55"  value="<%= alianza.getE_MAIL_2() == null ? "":alianza.getE_MAIL_2() %>"></td>
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
						<td colspan="5"><input type="text" name="NOMBRE_PAGO_COMISION" style="font-size: 13px;" size="55" value="<%= alianza.getNOMBRE_PAGO_COMISION() %>"></td>
					</tr>
					<tr>
						<td width="0"></td>
						<td>Apellido</td>
						<td colspan="3"><input type="text" name="APELLIDO_PAGO_COMISION" style="font-size: 13px;" size="40" value="<%= alianza.getAPELLIDO_PAGO_COMISION() %>"></td>
					</tr>
					<tr>
						<td></td>
						<td>Tipo de Comision</td>
						<td>
							<select name="TIPO_COMISION" value="<%= alianza.getTIPO_COMISION() %>">
								<option value="TPRO">Por Tipo de Producto</option>
								<option value="VOLV">Por Volumen de Ventas</option>
							</select>
						</td>
					</tr>
					<tr>
				<td></td>
				<td>Porcentaje no Fijo</td>
				<td><input name="PORC_COMISION_PARTICULAR" size="9" value="<%= alianza.getPORC_COMISION_PARTICULAR() %>"> </td>
			</tr>
			</table>
	</td>
</tr>

	<tr>
		<td colspan="2"><font color="#990000"><b><br>Usuario y password:</b></font></td>
	</tr>
	<tr><td colspan="2">
	<table>
			<tr>
				<td width="10"></td>
				<td width="147">Tipo de Negocio</td></tr>
			<tr>
				<td></td>
                <%
                    String negocioIndividual="";
                    String negocioCorporativo="";
                    if (alianza.getTIPO_NEGOCIO().equalsIgnoreCase("0")){
                        negocioIndividual="checked";
                    }else{
                        negocioCorporativo="checked";
                }%>
				<td align="right"> Individual <input type="radio" name="TIPO_NEGOCIO" value="0" <%=negocioIndividual%>></td>
				<td width="104" align="right"> Corporativo <input type="radio" name="TIPO_NEGOCIO" value="1" <%=negocioCorporativo%> ></td>
			</tr>
			<tr>
				<td></td>
				<td align="right"> Cuit N <input type="text" name="CUIT" style="font-size: 13px;" value=<%=alianza.getCUIT()%>> </td>
				<td align="right"> </td>
				        <td width="12" align="right"></td>
				<td width="144"></td>
			</tr>
		</table>

	</td></tr>



	<tr>
		<td colspan="2"><font color="#990000"><b><br>Usuario y password:</b></font></td>
	</tr>
	<tr><td colspan="2">
	<table width="388">
			<tr>
				<td width="3"></td>
				<td width="162">Usuario</td>
				<td width="207"><input type="text" name="USUARIO" style="font-size: 13px;" value="<%= alianza.getUSUARIO() %>"></td>
			</tr>
			<tr>
				<td width="3"></td>
				<td>Clave de Acceso</td>
				<td><input type="password" name="CLAVE" style="font-size: 13px;" value="<%= alianza.getCLAVE() %>"></td>
			</tr>
			<tr>
				<td width="3"></td>
		        <td>Confirmar Clave de<br> acceso </td>
				<td><input type="password" name="confirmaClave" style="font-size: 13px;" value="<%= alianza.getCLAVE() %>"></td>
			</tr>
			<tr>
				<td width="3"></td>
				<td>Condicion frente al IVA</td>
				<td>
                <%
                    String chequearInscripto= "";
                    String chequearNoInscripto="";
                    if (alianza.getID_TIPO_CONTRIBUYENTE().intValue()==1){
                        chequearInscripto="checked";
                     }else{
                        chequearNoInscripto="checked";
                  %>
                    <%}%>
					<input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="1" <%=chequearInscripto%> > Inscripto
					<input type="radio" name="ID_TIPO_CONTRIBUYENTE" value="0" <%=chequearNoInscripto%> > No inscripto
				</td>
			</tr>
		</table>


		<br><br><br>



	</td></tr>
</table>
<br>
<table align="center" width="700">
	<tr>
		<td colspan="2" align="right">
			<a href="javascript:document.formModificar.submit();">
				<img src="/imagenes/botonTerminarAfiliacion.gif" border="0">
			</a>
		</td>
	</tr>
</table>
</form>
</td></tr></table>
</body>
</html>
