<%@ page import="com.tmk.admin.AlianzaSeccionLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.admin.AlianzaSeccionLocal,
                 com.tmk.admin.AlianzaLocalHome,
                 com.tmk.admin.AlianzaLocal,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.Globals" %>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);

	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ALIANZAS")) {
%>
 		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}

	Integer ID_ALIANZA = new Integer(request.getParameter("ID_ALIANZA"));
	AlianzaLocalHome alianzaHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
	AlianzaSeccionLocalHome seccionHome = (AlianzaSeccionLocalHome)DBUtil.getHome("AlianzaSeccion");

	AlianzaLocal alianza = alianzaHome.findByPrimaryKey(ID_ALIANZA);
%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Administración de Alianzas") %>

		<script type="text/javascript" src="/js/Validation.js"></script>
		<script type="text/javascript">
			function actualizarSeccion(ID_SECCION)
			{
				var form = eval('document.seccion_'+ID_SECCION);
				form.action = '/ActualizarSeccion';

				if(form.SECCION_NOMBRE.length == 0) {
					alert('El nombre de la seccion no puede estar vacio.');
				}
				else {
					form.submit();
				}
			}

			function borrarSeccion(ID_SECCION)
			{
				var form = eval('document.seccion_'+ID_SECCION);
				form.action = '/EliminarSeccion';
				form.submit();
			}

			function agregarSeccion() {
				form = document.AgregarSec;

				if (isEmpty(form.SECCION_NOMBRE.value)) {
					alert('Debe ingresar la Seccion');
					return;
				}

				form.submit()
			}
		</script>
	</head>

	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" height="100%" width="770">
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
				<tr>
					<td>
						<jsp:include page="/236-TMK/comunes/header.jsp"/>
					</td>
				</tr>
				</table>
				<br>
				<table width="549" align="center">
				<tr>
					<td width="534">
						<font style= "font-size:20px" color="#003366">
							Secciones de su alianza
						</font>
					</td>
				</tr>
				</table>

				<table width="521" style="border: 1px solid gray;" cellspacing="0" cellpadding="3" align="center">
  				<tr>
					<td bgcolor="#D9D9D9" colspan="3">&nbsp;</td>
				</tr>

				<tr>
					<td width="19"></td>

					<td colspan="2">
						<b>Razon Social:</b> <%= alianza.getRAZON_SOCIAL() %><br>
						<b>URL:</b> <%= alianza.getURL() %>
					</td>
				</tr>

				<tr bgcolor="#D9D9D9">
					<td >&nbsp;</td>

					<td width="356" style="font-weight: bold;">Secciones</td>

					<td width="126" style="font-weight: bold;" ></td>
				</tr>

				<%	Iterator secciones = seccionHome.findVigentes(ID_ALIANZA).iterator();

					while(secciones.hasNext())
					{
						AlianzaSeccionLocal seccion = (AlianzaSeccionLocal)secciones.next();
				%>
						<form name="seccion_<%= seccion.getID_SECCION() %>" method="post">
							<input type="hidden" name="ID_ALIANZA" value="<%= seccion.getID_ALIANZA() %>">
							<input type="hidden" name="ID_SECCION" value="<%= seccion.getID_SECCION() %>">

							<tr>
								<td></td>

									<td >
									<input type="text" name="SECCION_NOMBRE" value="<%= seccion.getSECCION_NOMBRE() %>" size="40">
									<input type="text" name="SECCION_ID" value="<%= seccion.getID_SECCION() %>" size="7" disabled>
								</td>

								<td>
									<a style="color: #000000;" href="javascript:actualizarSeccion(<%= seccion.getID_SECCION() %>);">Modificar</a>

									<%if (!seccion.getID_SECCION().equals(new Integer(1))) {%>
                                    |
									<a style="color: #000000;" href="javascript:borrarSeccion(<%= seccion.getID_SECCION() %>);">Borrar</a>
									<%}%>
								</td>
							</tr>
						</form>
				<%	}
				%>

				<tr bgcolor="#D9D9D9">
					<td >&nbsp;</td>

					<td colspan="2" style="font-weight: bold;">Nueva secci&oacute;n</td>
				</tr>

				<form action="/AgregarSeccion" method="post" name="AgregarSec">
				<tr>
					<td></td>

					<td>
						<input type="hidden" name="ID_ALIANZA" value="<%= ID_ALIANZA %>">
						<input type="text" name="SECCION_NOMBRE" size="50">
					</td>

					<td>
						<a href="javascript:agregarSeccion();"><font color="#000000">Agregar</font></a><br>
					</td>
				</tr>
				</form>
				</table>
			</td>
		</tr>
		</table>
	</body>
</html>