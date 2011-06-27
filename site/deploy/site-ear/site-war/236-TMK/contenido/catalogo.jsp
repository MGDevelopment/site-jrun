<%@ page import="com.tmk.kernel.*,
                 java.util.Collection,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.MainHelper"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("CONTENIDOS")) {
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

	<script src="/js/ajax.js" type="text/javascript"></script>
	<script src="/js/validationForm.js" type="text/javascript"></script>
	<script src="/js/prototipe.js" type="text/javascript"></script>


	<script type="text/javascript">

		function setSecciones() {
			params = new Array("categoria", "value", document.getElementById('<%=MainHelper.FIELD_ID_SECCION%>'));
			clearCbo('<%=MainHelper.FIELD_ID_SECCION%>');
			clearCbo('<%=MainHelper.FIELD_ID_GRUPO%>');
			clearCbo('<%=MainHelper.FIELD_ID_FAMILIA%>');
			$('articuloCatalogo').style.display='none';
			//clearCbo("subFamilia");
			$("sbtBuscar").disabled = true;
			ejecutarAjax('<%=MainHelper.ACTION_GET_XML_CATEGORIA_BY%>', '', 'POST', params);
		}

		function setGrupos() {
			params = new Array("categoria", "value", document.getElementById('<%=MainHelper.FIELD_ID_GRUPO%>'));
			var cboSeccion = document.getElementById('<%=MainHelper.FIELD_ID_SECCION%>');
			clearCbo('<%=MainHelper.FIELD_ID_GRUPO%>');
			clearCbo('<%=MainHelper.FIELD_ID_FAMILIA%>');
			$('articuloCatalogo').style.display='none';
			//clearCbo("subFamilia");
			$("sbtBuscar").disabled = true;
			if (cboSeccion.options[cboSeccion.selectedIndex].value != 'null') {
				var par = "<%=MainHelper.FIELD_ID_SECCION%>=" + cboSeccion.options[cboSeccion.selectedIndex].value
						+ "&<%=MainHelper.PARAM_INCLUYE_CATEGORIA%>=false";
				ejecutarAjax('<%=MainHelper.ACTION_GET_XML_CATEGORIA_BY%>', par, 'POST', params);
			}
		}

		function setFamilias() {
			params = new Array("categoria", "value", document.getElementById('<%=MainHelper.FIELD_ID_FAMILIA%>'));
			var cboSeccion = document.getElementById('<%=MainHelper.FIELD_ID_SECCION%>');
			var cboGrupo = document.getElementById('<%=MainHelper.FIELD_ID_GRUPO%>');
			clearCbo('<%=MainHelper.FIELD_ID_FAMILIA%>');
			$('articuloCatalogo').style.display='none';
			//clearCbo("subFamilia");
			if (cboGrupo.options[cboGrupo.selectedIndex].value != 'null') {
				var par = "<%=MainHelper.FIELD_ID_SECCION%>=" + cboSeccion.options[cboSeccion.selectedIndex].value
						+ "&<%=MainHelper.FIELD_ID_GRUPO%>=" + cboGrupo.options[cboGrupo.selectedIndex].value
						+ "&<%=MainHelper.PARAM_INCLUYE_CATEGORIA%>=false";
				ejecutarAjax('<%=MainHelper.ACTION_GET_XML_CATEGORIA_BY%>', par, 'POST', params);
			} else {
				$("sbtBuscar").disabled = true;
			}
		}

		/*function setSubFamilias() {
			params = new Array("categoria", "value", document.getElementById("subFamilia"));
			var cboSeccion = document.getElementById("seccion");
			var cboGrupo = document.getElementById("grupo");
			var cboFamilia = document.getElementById("familia");
			clearCbo("subFamilia");
			if (cboFamilia.options[cboFamilia.selectedIndex].value != null) {
				var par = "<%=MainHelper.FIELD_ID_SECCION%>=" + cboSeccion.options[cboSeccion.selectedIndex].value
						+ "&<%=MainHelper.FIELD_ID_GRUPO%>=" + cboGrupo.options[cboGrupo.selectedIndex].value
						+ "&<%=MainHelper.FIELD_ID_FAMILIA%>=" + cboFamilia.options[cboFamilia.selectedIndex].value
						+ "&<%=MainHelper.PARAM_INCLUYE_CATEGORIA%>=false";
				ejecutarAjax('/GetXMLCategoriaBy', par, 'POST', params);
			}
		}*/

		function getArticuloByCategoria() {

			var par = '<%=MainHelper.FIELD_ID_SECCION%>=' + $('<%=MainHelper.FIELD_ID_SECCION%>').options[$('<%=MainHelper.FIELD_ID_SECCION%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_GRUPO%>=' + $('<%=MainHelper.FIELD_ID_GRUPO%>').options[$('<%=MainHelper.FIELD_ID_GRUPO%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_FAMILIA%>=' + $('<%=MainHelper.FIELD_ID_FAMILIA%>').options[$('<%=MainHelper.FIELD_ID_FAMILIA%>').selectedIndex].value;
			var params = new Array("articuloCatalogo");
			ejecutarAjax('<%=MainHelper.ACTION_GET_XML_ARTICULO_BY%>', par, 'POST', params);
			return false;
		}

		function eliminarArticuloDeCatalogo(idArticulo) {
			var par = '<%=MainHelper.FIELD_ID_SECCION%>=' + $('<%=MainHelper.FIELD_ID_SECCION%>').options[$('<%=MainHelper.FIELD_ID_SECCION%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_GRUPO%>=' + $('<%=MainHelper.FIELD_ID_GRUPO%>').options[$('<%=MainHelper.FIELD_ID_GRUPO%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_FAMILIA%>=' + $('<%=MainHelper.FIELD_ID_FAMILIA%>').options[$('<%=MainHelper.FIELD_ID_FAMILIA%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_ARTICULO%>=' + idArticulo;
			var params = new Array("eliminarArticulo", idArticulo);
			ejecutarAjax('<%=MainHelper.ACTION_ELIMINAR_ARTICULO_DE_CATALOGO%>', par, 'POST', params);
			return false;
		}

		function getArticuloById() {
			var par = '<%=MainHelper.FIELD_ID_ARTICULO%>=' + $('idArticulo').value;
			var params = new Array("titulo");
			ejecutarAjax('<%=MainHelper.ACTION_GET_XML_ARTICULO_BY%>', par, 'POST', params);
			return false;
		}

		function agregarArticulo() {
			var par = '<%=MainHelper.FIELD_ID_SECCION%>=' + $('<%=MainHelper.FIELD_ID_SECCION%>').options[$('<%=MainHelper.FIELD_ID_SECCION%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_GRUPO%>=' + $('<%=MainHelper.FIELD_ID_GRUPO%>').options[$('<%=MainHelper.FIELD_ID_GRUPO%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_FAMILIA%>=' + $('<%=MainHelper.FIELD_ID_FAMILIA%>').options[$('<%=MainHelper.FIELD_ID_FAMILIA%>').selectedIndex].value
					+ '&<%=MainHelper.FIELD_ID_ARTICULO%>=' + $('idArticulo').value
					+ '&<%=MainHelper.FIELD_VENCIMIENTO%>=' + $('vencimiento').value;
			$('vencimiento').optional = true;
			$('vencimiento').date = true;
			if (!verify(document.frmArticulosCatalogo)) {
				return false;
			}
			var fechaHoy = new Date();
			var fechaCat = new Date();
			var strFechaCat = $('vencimiento').value;
			fechaCat.setFullYear(strFechaCat.substring(6, 10), strFechaCat.substring(3, 5)-1, strFechaCat.substring(0, 2));
			if (fechaCat != '' && fechaCat< fechaHoy) {
				alert('Ingrese una fecha de vencimiento posterior a hoy');
				$('vencimiento').focus();
				return false;
			}

			var params = new Array("agregarArticulo");
			ejecutarAjax('<%=MainHelper.ACTION_AGREGAR_ARTICULO_DE_CATALOGO%>', par, 'POST', params);
			return false;
		}

		function handle(connAj, addPar) {
			if(connAj.readyState == 4){
				$('error').hide();
				$('success').hide();
				$('space').show();
				try {
					if (addPar[0] == "categoria") {
						addPar[2].options[addPar[2].options.length] = new Option("Seleccione", null);
						var padre = connAj.responseXML.getElementsByTagName(addPar[0]);
						var options = padre[0].getElementsByTagName(addPar[0]);
						for (i=0; i<options.length; i++) {
							var option = new Option (options[i].firstChild.nodeValue + "(" +
														options[i].getAttribute(addPar[1]) + ")",
													options[i].getAttribute(addPar[1]));
							addPar[2].options[addPar[2].options.length] = option;
							if (addPar[2].id=='<%=MainHelper.FIELD_ID_FAMILIA%>') {
								$("sbtBuscar").disabled = false;
							}
						}
					}
					if (addPar[0] == "articuloCatalogo") {
						handleWait(false);
						var articulos = connAj.responseXML.getElementsByTagName("articulos");
//						alert(articulos.length);
						if (articulos.length>0) {
							for (i=0; i<articulos[0].childNodes.length; i++) {
								if (articulos[0].childNodes[i].nodeType == 1) {
									var fila = $('articuloCatalogo').insertRow($('articuloCatalogo').rows.length-1);
									var columna = fila.insertCell(0);
									columna.innerHTML = articulos[0].childNodes[i].getElementsByTagName("idArticulo")[0].firstChild.nodeValue;
									columna = fila.insertCell(1);
									columna.innerHTML = articulos[0].childNodes[i].getElementsByTagName("titulo")[0].firstChild.nodeValue;
									columna = fila.insertCell(2);
									if (articulos[0].childNodes[i].getElementsByTagName("vencimiento").length>0) {
										var fechaHoy = new Date();
										var fechaCat = new Date();
										var strFechaCat = articulos[0].childNodes[i].getElementsByTagName("vencimiento")[0].firstChild.nodeValue;
										fechaCat.setFullYear(strFechaCat.substring(6, 10), strFechaCat.substring(3, 5)-1, strFechaCat.substring(0, 2));
										columna.innerHTML = articulos[0].childNodes[i].getElementsByTagName("vencimiento")[0].firstChild.nodeValue;
										//alert(new Date());
										if (fechaHoy > fechaCat) {
											fila.style.backgroundColor="FFa9a9";
										}
									} else {
										columna.innerHTML = "";
									}
									columna.align ="center";
									columna = fila.insertCell(3);
									columna.innerHTML = "<input style=\"padding:0;height:17;font-size:9\" value=\"Eliminar\" type=button onclick=\"eliminarArticuloDeCatalogo(" + articulos[0].childNodes[i].getElementsByTagName("idArticulo")[0].firstChild.nodeValue + ")\">"
								}
							}
						} else {
							setValues(connAj.responseXML, 'error', null);
							$('error').show();
							$('space').hide();
						}
						$('articuloCatalogo').style.display='';
					}
					if (addPar[0] == "eliminarArticulo") {
						handleWait(false);
						if (setValues(connAj.responseXML, 'success', 'error') == 'success') {
							$('success').show();
							for (i=0; i<$('articuloCatalogo').rows.length; i++) {
								if ($('articuloCatalogo').rows[i].cells[0].innerHTML == addPar[1]) {
									$('articuloCatalogo').deleteRow(i);
									//alert('encontro' + addPar[1]);
								}
							}
							/*armar parafernalia para sacar el articulo de la tabla*/
							//getArticuloByCategoria();
						} else {
							$('error').show();
						}
						$('space').hide();
					}
					if (addPar[0] == "titulo") {
						var articulos = connAj.responseXML.getElementsByTagName("articulos");
						if (articulos.length>0) {
							for (i=0; i<articulos[0].childNodes.length; i++) {
								if (articulos[0].childNodes[i].nodeType == 1) {
									$('titulo').innerHTML = articulos[0].childNodes[i].getElementsByTagName("titulo")[0].firstChild.nodeValue;
									$('titulo').style.color = 'green';
									$('agregar').disabled = false;
								}
							}
						} else {
							$('titulo').innerHTML = 'Articulo inexistente';
							$('titulo').style.color = 'red';
							$('agregar').disabled = true;

						}
						$('titulo').style.fontWeight = 900;
					}
					if (addPar[0] == "agregarArticulo") {
						handleWait(false);
						if (setValues(connAj.responseXML, 'success', 'error') == 'success') {
							$('success').show();
							/**/
							var fila = $('articuloCatalogo').insertRow($('articuloCatalogo').rows.length-1);
							var columna = fila.insertCell(0);
							columna.innerHTML = $('idArticulo').value;
							columna = fila.insertCell(1);
							columna.innerHTML = $('titulo').innerHTML;
							columna = fila.insertCell(2);
							columna.innerHTML = $('vencimiento').value;
							columna.align ="center";
							columna = fila.insertCell(3);
							columna.innerHTML = "<input style=\"padding:0;height:17;font-size:9\" value=\"Eliminar\" type=button onclick=\"eliminarArticuloDeCatalogo(" + $('idArticulo').value + ")\">"
							$('titulo').innerHTML = '';
							$('idArticulo').value = '';
							$('vencimiento').value = '';
							$('agregar').disabled = true;
							/**/
							//getArticuloByCategoria();
						} else {
							$('error').show();
						}
						$('space').hide();
					}
				} catch (e) {
					alert(e);
				}
		    } else {
				if (addPar[0] == "articuloCatalogo") {
					limpiarArticuloCatalogo();
					handleWait(true);
				}
				// no hago nada
		    }
		}

		function clearCbo (cbo) {
			document.getElementById(cbo).length = 0;
		}


		function limpiarArticuloCatalogo() {
			$('articuloCatalogo').hide();
			for (i=$('articuloCatalogo').rows.length-2; i>0; i--) {
				//alert($('articuloCatalogo').childNodes[i]);
				$('articuloCatalogo').deleteRow(i);
			}
			$('titulo').innerHTML = '';
			$('idArticulo').value = '';
			$('vencimiento').value = '';
			$('agregar').disabled = true;
		}


	</script>

</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="setSecciones()">
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
				<form method="post" id="findArticuloBy" name="findArticuloBy" onSubmit="return getArticuloByCategoria()">
				<table border ="1" width="500" align="center" style="border: solid 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;" cellpadding="3">
					<tr>
						<td colspan="2" bgcolor="EEEEEE">
							<b>Seleccione el catálogo a configurar</b>
						</td>
					</tr>
					<tr>
						<td width="80">
							Sección
						</td>
						<td>
							<select id="<%=MainHelper.FIELD_ID_SECCION%>" onchange="setGrupos()" style="width:400px"></select>
						</td>
					</tr>
					<tr>
						<td>
							Grupo
						</td>
						<td>
							<select id="<%=MainHelper.FIELD_ID_GRUPO%>" onchange="setFamilias()" style="width:400px"></select>
						</td>
					</tr>
					<tr>
						<td>
							Familia
						</td>
						<td>
							<select id="<%=MainHelper.FIELD_ID_FAMILIA%>" style="width:400px" onchange="$('articuloCatalogo').style.display='none'"></select>
							<!-- select id="familia" onchange="setSubFamilias()" style="width:400px"></select-->
						</td>
					</tr>
					<!-- tr>
						<td>
							Sub Familia
						</td>
						<td>
							<select id="subFamilia" style="width:400px"></select>
						</td>
					</tr-->
					<tr>
						<td colspan="2" align="right">
							<input id="sbtBuscar" type="submit" value="Buscar" disabled>
						</td>
					</tr>
				</table>
				</form>
				<!-- Buscador -->
				<p>
				<table align="center">
					<tr>
						<td>
							<input type="button" value="Volver" onclick="window.location.href='<%=MainHelper.PAGE_CONTENIDO_INICIO%>'">
						</td>
					</tr>
				</table>
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
				<table width="600" id="wait" align="center"  style="display:none">
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
						<td align="center" style="color:red">
							<div id="msg"></div>
						</td>
					</tr>
				</table>
				<!-- /ERROR -->
				<!-- SPACE -->
				<table id="space">
					<tr>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
				<!-- /SPACE -->
				<!-- Articulos Catalogo-->
				<form name="frmArticulosCatalogo">
					<table border="1" align="center" width="600" style="border: solid 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;display:none" cellpadding="3" id="articuloCatalogo" >
					<tr bgcolor="EEEEEE"><td width="80"><b>ID de Articulo</b></td><td width="376"><b>Título</b></td><td width="90" align="center" valign="center"><b>Vencimiento</b>&nbsp;<span style="background-color:FFa9a9;font-size:5">&nbsp;&nbsp;</span></td><td width="54"></td></tr>
					<tr bgcolor="FCFCFC"><td width="80"><input size="13" type="text" id="idArticulo" onblur="getArticuloById()" onkeypress="$('agregar').disabled=true;$('titulo').innerHTML=''"></td><td><div id="titulo"></div></td><td align="center"><input type="text" size="13" maxlength="12" id="vencimiento"><br>dd/mm/aaaa</td><td width="55"><input style="padding:0;height:17;font-size:9" type="button" id="agregar" value="Agregar" onclick="agregarArticulo()"></td></tr>
					</table>
				</form>
				<!-- Articulos Catalogo-->

			</td>
		</tr>
	</table>
</body>
</html>
