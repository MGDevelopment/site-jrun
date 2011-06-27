<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.admin.AlianzaLocal,
				 com.tmk.admin.AlianzaLocalHome,
				 com.tmk.kernel.DBUtil" %>

<%	Integer idAlianza = new Integer(request.getParameter("ID_ALIANZA"));
	Integer idSeccion = new Integer(request.getParameter("ID_SECCION"));
	AlianzaLocalHome alianzaLocalHome = (AlianzaLocalHome) DBUtil.getHome("Alianza");
	AlianzaLocal alianzaLocal = alianzaLocalHome.findByPrimaryKey(idAlianza);
%>

<b>
	Nuevo Afiliado/Alianza
</b>

<br>
<br>

<table width="80%">
	<tr>
		<td><b>Razón Social: </b></td><td><%=Convert.toString(alianzaLocal.getRAZON_SOCIAL())%></td>
	</tr>
	<tr>
		<td><b>ID: </b></td><td><%=Convert.toString(idAlianza)%></td>
	</tr>
	<tr>
		<td><b>Sección Generica: </b></td><td><%=Convert.toString(idSeccion)%></td>
	</tr>
	<tr>
		<td><b>URL: </b></td><td><%=Convert.toString(alianzaLocal.getURL())%></td>
	</tr>
	<tr>
		<td><b>Tipo de Negocio: </b></td><td><%=Convert.toString(alianzaLocal.getTIPO_NEGOCIO())%></td>
	</tr>
	<tr>
		<td><b>Cuit: </b></td><td><%=Convert.toString(alianzaLocal.getCUIT())%></td>
	</tr>
	<tr>
		<td><b>Usuario: </b></td><td><%=Convert.toString(alianzaLocal.getUSUARIO())%></td>
	</tr>
	<tr>
		<td><b>Clave: </b></td><td><%=Convert.toString(alianzaLocal.getCLAVE())%></td>
	</tr>
	<tr>
		<td><b>Tipo de Contribuyente: </b></td><td><%=Convert.toString(alianzaLocal.getID_TIPO_CONTRIBUYENTE())%></td>
	</tr>
	<tr>
		<td><b>Nombre de Contacto: </b></td><td><%=Convert.toString(alianzaLocal.getNOMBRE_CONTACTO())%></td>
	</tr>
	<tr>
		<td><b>Apellido de Contacto: </b></td><td><%=Convert.toString(alianzaLocal.getAPELLIDO_CONTACTO())%></td>
	</tr>
	<tr>
		<td><b>Cargo: </b></td><td><%=Convert.toString(alianzaLocal.getCARGO_CONTACTO())%></td>
	</tr>
	<tr>
		<td><b>Nombre de Pago Comision: </b></td><td><%=Convert.toString(alianzaLocal.getNOMBRE_PAGO_COMISION())%></td>
	</tr>
	<tr>
		<td><b>Apellido de Pago Comision: </b></td><td><%=Convert.toString(alianzaLocal.getAPELLIDO_PAGO_COMISION())%></td>
	</tr>
	<tr>
		<td><b>Email 1: </b></td><td><%=Convert.toString(alianzaLocal.getE_MAIL_1())%></td>
	</tr>
	<tr>
		<td><b>Email 2: </b></td><td><%=Convert.toString(alianzaLocal.getE_MAIL_2())%></td>
	</tr>
	<tr>
		<td><b>Tipo Comision: </b></td><td><%=Convert.toString(alianzaLocal.getTIPO_COMISION())%></td>
	</tr>
</table>