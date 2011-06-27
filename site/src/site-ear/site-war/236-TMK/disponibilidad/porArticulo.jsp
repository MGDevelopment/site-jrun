<%@ page import="com.tmk.kernel.*,
                 java.util.Collection,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.MainHelper"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("GENERAR_DETALLES_DE_ARTICULOS_ESTATICOS")) {
%>		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>
<html>
	<head>
	<%= Globals.estiloBasico() %>

		<style>
		.titulos{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			font-weight: bold;
		}

		.contenido{
			font-family: Verdana, Arial, Helvetica, sans-serif;
			font-size: 10px;
			text-decoration: none;
			color: #000000;
		}
		</style>

	<script src="/js/ajax.js" type="text/javascript">
	</script>
	<script src="/js/validationForm.js" type="text/javascript">
	</script>
	<script src="/js/prototipe.js" type="text/javascript">
	</script>

	<script type="text/javascript">
		function handle(connAj, params) {
		    if(connAj.readyState == 4){
		    	handleWait(false);
				if (connAj.responseXML != null && connAj.responseXML.firstChild!=null) {
					handleOK(setValues(connAj.responseXML , params[0], params[1]), params[0], params[1]);

				} else {
					alert('Se ha producido un error intente en unos minutos');
				}
		    } else {
				handleWait(true);
		    }
		}

		function getArticuloBy() {
			params = new Array("articulo", "error");
			inicializarTags('articulo');
			document.getElementById('articulo').style.display='none';
			document.getElementById('error').style.display='none';
			document.getElementById('success').style.display='none';
			document.getElementById('regla').style.display='none';
			ejecutarAjax('<%=MainHelper.ACTION_GET_XML_ARTICULO_BY%>',
				'<%=MainHelper.FIELD_ID_ARTICULO%>=' +
				document.findArticuloBy.<%=MainHelper.FIELD_ID_ARTICULO%>.value +
				'&<%=MainHelper.FIELD_ISBN%>=' +
				document.findArticuloBy.<%=MainHelper.FIELD_ISBN%>.value, 'POST', params);
			return false;
		}

		function getReglaBy() {
			params = new Array("regla", "error");
			inicializarTags('regla');
			document.getElementById('regla').style.display='none';
			document.getElementById('error').style.display='none';
			var idArticulo = 0;
			var objHTML = document.getElementById('articulo');
			var divs  = objHTML.getElementsByTagName("DIV");
			for (i=0; i<divs.length; i++) {
				if (divs[i].id == 'idArticulo') {
					idArticulo = divs[i].innerHTML;
				}
			}
			ejecutarAjax('<%=MainHelper.ACTION_GET_XML_REGLA_BY%>', '<%=MainHelper.FIELD_ID_ARTICULO%>=' +	idArticulo, 'POST', params);
			return false;
		}

		function crearNuevaRegla(frm){
			params = new Array("success", "error");
			document.frmEliminarRegla.sbtRegla.disabled = true;
			document.frmNuevaRegla.sbtNuevaRegla.disabled = true;
			document.getElementById('regla').style.display='none';
			document.getElementById('success').style.display='none';
			frm.<%=MainHelper.FIELD_DESCRIPCION%>.nombre = 'descripción';
			frm.<%=MainHelper.FIELD_DESDE%>.date = true;
			frm.<%=MainHelper.FIELD_HASTA%>.date = true;
			frm.<%=MainHelper.FIELD_DESDE%>.optional = true;
			frm.<%=MainHelper.FIELD_HASTA%>.optional = true;

			if (!verify(frm)) {
				document.frmEliminarRegla.sbtRegla.disabled = false;
				document.frmNuevaRegla.sbtNuevaRegla.disabled = false;
				return false;
			}


			var objHTML = document.getElementById('articulo');
			var divs  = objHTML.getElementsByTagName("DIV");
			var par ='';
			for (i=0; i<divs.length; i++) {
				if (divs[i].id == '<%=MainHelper.FIELD_ID_ARTICULO%>') {
					par = par + "&" + divs[i].id + "=";
					par = par + divs[i].innerHTML;
				}
				if(divs[i].id == 'categoriaPK') {
					par = par + "&<%=MainHelper.FIELD_ID_SECCION%>" + "=";
					par = par + divs[i].innerHTML;
				}
			}
			var objHTML = document.getElementById('regla');
			var divs  = objHTML.getElementsByTagName("DIV");
			for (i=0; i<divs.length; i++) {
				if (divs[i].id == '<%=MainHelper.FIELD_SECUENCIA%>'){
				par = par + "&" + divs[i].id + "=";
				par = par + divs[i].innerHTML;
				}

			}
			par = par + "&<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>=" + frm.<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>.options[frm.<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>.selectedIndex].value;
			par = par + "&<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>=" + frm.<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>.options[frm.<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>.selectedIndex].value;
			par = par + "&<%=MainHelper.FIELD_DESCRIPCION%>=" + frm.<%=MainHelper.FIELD_DESCRIPCION%>.value ;
			par = par + "&<%=MainHelper.FIELD_DESDE%>=" + frm.<%=MainHelper.FIELD_DESDE%>.value;
			par = par + "&<%=MainHelper.FIELD_HASTA%>=" + frm.<%=MainHelper.FIELD_HASTA%>.value;
			ejecutarAjax('<%=MainHelper.ACTION_CREAR_REGLA%>', par, 'POST', params);
		    return false;
		}

		function eliminarRegla() {
			params = new Array("success", "error");
			document.getElementById('regla').style.display='none';
			document.frmNuevaRegla.sbtNuevaRegla.disabled = true;
		    var par = "&<%=MainHelper.FIELD_SECUENCIA%>=" + document.getElementById("secuencia").innerHTML;
		    ejecutarAjax('<%=MainHelper.ACTION_ELIMINAR_REGLA%>', par, 'POST', params);
		    return false;
		}

		function handleOK(entidad, entidadOK, entidadErr) {
			document.getElementById(entidad).style.display = '';
			if (entidad == 'articulo') {
				var frm = document.frmNuevaRegla;
				for (i=0; i<frm.<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>.options.length; i++) {
					if (frm.<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>.options[i].value == document.getElementById('habilitadoTematika').innerHTML) {
						frm.<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>.selectedIndex = i;
					}
				}

				for (i=0; i<frm.<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>.options.length; i++) {
					if (frm.<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>.options[i].value == document.getElementById('idDisponibilidad').innerHTML) {
						frm.<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>.selectedIndex = i;
					}
				}
				frm.<%=MainHelper.FIELD_DESCRIPCION%>.value = '';
				frm.<%=MainHelper.FIELD_DESDE%>.value = '';
				frm.<%=MainHelper.FIELD_HASTA%>.value = '';
				document.frmNuevaRegla.sbtNuevaRegla.disabled = false;
				getReglaBy();
			}

			if (entidadOK == 'regla') {
				if (entidad == 'regla') {
					document.getElementById('regla').style.display = '';
					document.frmEliminarRegla.sbtRegla.disabled = false;
				} else {
					document.getElementById('regla').style.display = 'none';
					document.frmEliminarRegla.sbtRegla.disabled = true;
				}
			}

			if (entidad == 'success') {
				getArticuloBy();

				document.getElementById('success').style.display='';
				document.frmNuevaRegla.sbtNuevaRegla.disabled = false;
			}
		}

		function inicializarTags(tag) {
			var objHTML = document.getElementById(tag);
			var divs =objHTML.getElementsByTagName("DIV");
			for (i=0; i<divs.length; i++) {
				divs[i].innerHTML = '';
			}
		}

	</script>

</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
	<table bgcolor="#FFFFFF" border="0" align="center" cellpadding="0" cellspacing="0" height="600px" width="770" >
		<tr>
			<td valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>
				<p>
				<!-- Buscador -->
				<form method="post" name="findArticuloBy" onSubmit="return getArticuloBy()">
				<table border ="1" align="center" style="border: solid 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;" cellpadding="3">
					<tr>
						<td colspan="3" bgcolor="EEEEEE">
							<b>Ingrese el id o ISBN del artículo a actualizar</b>
						</td>
					</tr>
					<tr>
						<td>
							ID de Artículo
						</td>
						<td>
							<input type="text" name="<%=MainHelper.FIELD_ID_ARTICULO%>" value="">
						</td>
						<td rowspan="2">
							<input type="submit" value="Buscar">
						</td>
					</tr>
					<tr>
						<td>
							ISBN
						</td>
						<td>
							<input type="text" name="<%=MainHelper.FIELD_ISBN%>" value="">
						</td>
					</tr>
				</table>
				</form>
				<!-- Buscador -->
				<p>
				<!-- SUCCESS -->
				<table id="success" align="center" style="display:none">
					<tr>
						<td style="color:green">
							<div id="msg"></div>
						</td>
					</tr>
				</table>
				<!-- /SUCCESS -->
				<!-- WAIT -->
				<table width="700" id="wait"  align="center"  style="display:none" height="25">
					<tr bgcolor="EEEEEE">
						<td>
							<div id="msg"></div>
						</td>
					</tr>
				</table>
				<!-- /WAIT -->
				<!-- ERROR -->
				<table id="error" align="center"  style="display:none">
					<tr>
						<td  align="center" style="color:red">
							<div id="msg"></div>
						</td>
					</tr>
				</table>
				<!-- /ERROR -->

				<!-- Info estado Articulo -->
				<form method="post" name="frmNuevaRegla" onSubmit="return crearNuevaRegla(this)">
				<table border="1" width="700" align="center" id="articulo" Style="border: solid 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;display:none" cellpadding="3">
					<tr bgcolor="EEEEEE">
						<td colspan="3"><b>Estado Actual del Artículo</b></td>
					</tr>
					<tr>
						<td width="100" bgcolor="EEEEEE">
							<b>ID de Articulo:</b>
						</td>
						<td colspan="2">
							<div id="idArticulo"></div>
						</td>
					</tr>
					<tr>
						<td width="100" bgcolor="EEEEEE">
							<b>Título:</b>
						</td>
						<td colspan=2>
							<div id="titulo"></div>
						</td>
					</tr>
					<tr>
						<td bgcolor="EEEEEE">
							<b>Habilitado:</b>
						</td>
						<td>
							<div id="habilitadoTematika"></div>
						</td>
						<td>
							<select name="<%=MainHelper.FIELD_HABILITADO_TEMATIKA%>">
								<option value="S">S</option>
								<option value="N">N</option>
							</select>
						</td>
					</tr>
					<tr>
						<td bgcolor="EEEEEE">
							<b>Disponibilidad:</b>
						</td>
						<td>
							<div id="disponibilidad"></div>
							<div style="display:none" id="idDisponibilidad"></div>

						</td>
						<td>
							<select name="<%=MainHelper.FIELD_ID_DISPONIBILIDAD%>">
							<%for (int i=0; i<Globals.DISPONIBILIDADES.length; i++) { %>
								<option value="<%=Globals.DISPONIBILIDADES[i].getId()%>">
								<%=Globals.DISPONIBILIDADES[i].getNombre()%> [<%=Globals.DISPONIBILIDADES[i].getId()%>]
								</option>
							<%}%>
							</select>
						</td>
					</tr>
					<tr>
						<td bgcolor="EEEEEE">
							<b>Descripción:</b>
						</td>
						<td>
						</td>
						<td>
							<input type="text" size="50" maxlength="190" name="<%=MainHelper.FIELD_DESCRIPCION%>">
						</td>
					</tr>
					<tr>
						<td bgcolor="EEEEEE">
							<b>Desde:</b>
						</td>
						<td>
						</td>
						<td>
							<input type="text" size="13" maxlength="10" name="<%=MainHelper.FIELD_DESDE%>"> dd/mm/aaaa
						</td>
					</tr>
					<tr>
						<td bgcolor="EEEEEE">
							<b>Hasta:</b>
						</td>
						<td>
						</td>
						<td>
							<input type="text" size="13" maxlength="10" name="<%=MainHelper.FIELD_HASTA%>"> dd/mm/aaaa
						</td>
					</tr>
					<tr style="display:none">
						<td>
					<!-- ocultos -->
						<div id="categoriaPK"></div>
					<!-- /ocultos -->
						</td>
					</tr>
					<tr>
						<td colspan="3" align="right">
							<input type="submit" value="Crear Nueva Regla" name="sbtNuevaRegla" id="nuevaRegla">
						</td>
					</tr>
				</table>
				</form>
				<!-- Info estado Articulo -->

				<!-- REGLA -->
				<form method="post" name="frmEliminarRegla" onsubmit="return eliminarRegla()">
				<table border="1" width="700" align="center" id="regla" Style="border: solid 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;display:none;" cellpadding="3">
					<tr bgcolor="EEEEEE">
						<td colspan="2"><b>Regla Actual</b></td>
					</tr>
					<tr>
						<td width="100">
							<b>Secuencia:</b>
						</td>
						<td>
							<div id="secuencia"></div>
						</td>
					</tr>
					<tr>
						<td>
							<b>Descripcion:</b>
						</td>
						<td>
							<div id="descripcion"></div>
						</td>
					</tr>
					<tr>
						<td>
							<b>Habilitado:</b>
						</td>
						<td>
							<div id="estado"></div>
						</td>
					</tr>
					<tr>
						<td>
							<b>Disponibilidad:</b>
						</td>
						<td>
							<div id="id__disponibilidad"></div>
						</td>
					</tr>
					<tr>
						<td>
							<b>Desde:</b>
						</td>
						<td>
							<div id="fecha__desde"></div>
						</td>
					</tr>
					<tr>
						<td>
							<b>Hasta:</b>
						</td>
						<td>
							<div id="fecha__hasta"></div>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input name="sbtRegla" type="submit" value="Eliminar Regla">
						</td>
					</tr>
				</table>
				</form>
				<!-- REGLA -->
			</td>
		</tr>
	</table>

</body>
</html>
