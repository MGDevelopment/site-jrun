<%@ page import="com.tmk.kernel.Globals,
	com.tmk.controllers.intranet.admin.UsuarioDAO,
    com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ALERTA_COMPRA_X_SOCIO")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<title>Alerta de Compra por Socios</title>
		<%= Globals.estiloBasico() %>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
		<script src="/js/ajax.js" type="text/javascript"></script>
		<script src="/js/prototipe.js" type="text/javascript"></script>

	<script language="javascript" type="text/javascript">
		var obj;
		var borrar;
		function consultarTodos() {
			<%--no mando paramtro por que voy a trer todos los socios de la tabla	ALERTA_COMPRA_SOCIOS--%>
			var frm = document.frmConsulta;
			frm.txtBusqueda.value = '';
			buscarPorOpcion();
		}

		<%--buscar por nombre o apellido o mail--%>
		function buscarPorOpcion() {
			$('btnBaja').style.display='none';
			var frm = document.frmConsulta;
			var opcion ='&opcion='+frm.busqueda.options[frm.busqueda.selectedIndex].value + '&valor=' + frm.txtBusqueda.value;
			ejecutarAjax('/GetAlertaCompraSocios?param='+Math.random()+opcion,'', 'POST', 'buscarPorOpcion');
			return false;

		}

		<%-- dar de baja de socios usamo el valor del radio que se selecciona que tiene el id de socio--%>
		function darBaja(){
			var frm = document.frmbus;
			var radios;
			var id_socio=0;
			var id_sucursa=0;

			radios = frm.baja;
			if(typeof (radios.length) != "undefined"){
				for (i = 0; i < radios.length; i++){
					if(radios[i].checked){
						id_socio = radios[i].value.split('-')[0];
						id_sucursal= radios[i].value.split('-')[1];
						$('btnBaja').style.display='none';
						borrar = i+1;
						break;
					}
				}
			}
			else{
				if(radios.checked){
					id_socio = radios.value.split('-')[0];
					id_sucursal= radios.value.split('-')[1];
					$('btnBaja').style.display='none';
					borrar = 1;
				}
			}

			<%--verifico que se selecciono un socio en los radio button--%>
			if(id_socio == 0 || id_sucursal == 0){
				alert("Seleccione un socio");
			}
			else{
				if(confirm("Confirma quitar el socio de la alerta?")==true){
					ejecutarAjax('/DelAlertaCompraSocios?param='+Math.random() + '&id_socio='+id_socio+ '&id_sucursal='+id_sucursal,'','POST', 'darBaja');
					return false;
				}
				else{
					$('tblMensaje').style.display = 'none';
					$('btnBaja').style.display='block';
				}
			}
		}

		<%-- FUNCIONES HANDLER PARA BAJA, BUSCAR TODOS Y BUSCAR POR OPCION --%>

		function handle(connAj, params) {
			switch(params){
				case  'buscarPorOpcion':
					if(connAj.readyState == 4){
							$('tblMensajeLoad').style.display = 'none';
							$('tblResultados').style.display = 'block';
							$('btnConsultarTodos').disabled = false;
							$('btnBuscarPorOpcion').disabled = false;
						try{
							obj = eval("(" + connAj.responseText + ")");
							var vecSocios = obj.Resultado.respuesta;
							var mostrar;

							if(obj.Resultado.valor){
								deleteRows($('tblResultados'));
								for(i = 0; i < vecSocios.length; i++){
									<%-- actualiza la tabla con cada elemento del socios --%>
									var socio = new Array(4);
									socio[0] = vecSocios[i].cls_nombres;
									socio[1] = vecSocios[i].cls_apellidos;
									socio[2] = vecSocios[i].cls_login;
									socio[3] = '<input name =\"baja\" type =\"radio\" value = "' +vecSocios[i].id_socio+ '-' +vecSocios[i].id_sucursal+ '\">';
									addRow( $ ('tblResultados') ,socio);
								}
							}
							else {
								if(obj.Resultado.targetRedirect != null){
									window.location.href = 	obj.Resultado.targetRedirect;
								}
								else {
									if ( obj.Resultado.fallaSistema){
										$('tblResultados').style.display= 'none';
										$('divMensaje').className = 'cuadroError';
										$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
										$('tblMensaje').style.display = 'block';
									} else {
										$('tblResultados').style.display= 'none';
										$('divMensaje').className = 'cuadroMensajeWarning';
										$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
										$('tblMensaje').style.display = 'block';
									}
								}
							}

							<%--verifico si muestro o no el boton --%>
							if( $('tblResultados').rows.length == 1){
								$('btnBaja').style.display='none';
							}else{
								$('btnBaja').style.display='block';;
							}
						}
						catch( e ){
							alert(e);
						}
					} else {
						deleteRows($('tblResultados'));
						$('tblResultados').style.display = 'none';
						$('tblMensaje').style.display = 'none';
						$('btnBaja').style.display = 'none';
						$('btnConsultarTodos').disabled = true;
						$('btnBuscarPorOpcion').disabled = true;
						$('tblMensajeLoad').style.display = 'block';
					}
				break;
			<%-- si el llamado lo hizo la funcion dar baja--%>
			case  'darBaja':
				if(connAj.readyState == 4){
					$('tblMensajeLoad').style.display = 'none';
					$('tblResultados').style.display = 'block';
					$('tblMensaje').style.display = 'none';

					obj = eval("(" + connAj.responseText + ")");

					if(obj.Resultado.valor){
						$('tblResultados').deleteRow(borrar);
						$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
						$('divMensaje').className = 'cuadroMensajeOk';
						$('tblMensaje').style.display = 'block';
					}
					else{
						if (obj.Resultado.targetRedirect != null) {
							window.location.href = 	obj.Resultado.targetRedirect;
						} else{
							$('tblResultados').style.display = 'block';
							$('tblResultados').deleteRow(borrar);
							if( obj.Resultado.fallaSistema ){
								$('tblResultados').style.display= 'none';
								$('divMensaje').className = 'cuadroError';
								$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
								$('tblMensaje').style.display = 'block';
								return;
							}else {
								$('tblResultados').style.display= 'none';
								$('divMensaje').className = 'cuadroMensajeWarning';
								$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
								$('tblMensaje').style.display = 'block';
						  	}
						}
					}

					<%--verifico si muestro o no el boton --%>
					if( $('tblResultados').rows.length == 1){
						$('btnBaja').style.display='none';
					}else{
						$('btnBaja').style.display='block';;
					}
				}
				else{
//					deleteRows($('tblResultados'));
					$('tblResultados').style.display = 'none';
					$('tblMensaje').style.display = 'none';
					$('tblMensajeLoad').style.display = 'block';
				}
		break;
		}//fin while
	}//fin funcion

	function addRow(tbl, datos) {
		tbl.insertRow(tbl.rows.length);
		if((tbl.rows.length-1) % 2 == 0){
			tbl.rows[tbl.rows.length-1].style.backgroundColor = "#DDDDDD";
		}
		var i;
		for (i=0; i<datos.length; i++) {
			tbl.rows[tbl.rows.length-1].insertCell(i);
			if (datos[i]) {
				tbl.rows[tbl.rows.length-1].cells[i].innerHTML = datos[i];
			} else {
				tbl.rows[tbl.rows.length-1].cells[i].innerHTML = "&nbsp;";
			}
			tbl.rows[tbl.rows.length-1].cells[i].align=tbl.rows[0].cells[i].align;
		}
	}

	<%-- Borra hasta la 2da porque asume que la primera es cabecera --%>
	function deleteRows(tbl) {
		while(tbl.rows.length>1) {
			tbl.deleteRow(tbl.rows.length-1);
		}
	}

	function comboSubmit(event) {
		if (event.keyCode == 13) {
			buscarPorOpcion()
		}
	}
	</script>
</head>

<body  background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" height="100%">
			<tr>
				<td width="787" valign="top" align="center" colspan="2">
						<table width="100%"  cellpadding="0" cellspacing="0">
							<tr>
								<td>
									<jsp:include page="/236-TMK/comunes/header.jsp"/>
								</td>
							</tr>
						</table>
				</td>
			</tr>
			<form name="frmConsulta" id="frmConsulta" onsubmit="return false;">
			<tr>
				<td align="center" colspan="2" height="30px" valign="top">
					<p class="TextoBordo">Alerta de Compras por Socio</p>
					<a class="tituloLinkSeleccionado" href="/236-TMK/ordenes/alertaCompraSocios.jsp"> Socios incluidos en Alerta </a>&nbsp;|&nbsp;
					<b><a class="tituloLink" href="/236-TMK/ordenes/altaAlertaCompraSocios.jsp"> Incluir nuevos Socios en Alerta </a>&nbsp;
					<br>&nbsp;</b>
					<table border="1" cellpadding="1" cellspacing="1" style="border-collapse: collapse; border: 1,5px solid; border-color: #5AB5DE;"><tr><td valign="middle">
					<b>Buscar por:</b>
							<select id="busqueda" name="busqueda">
								<option value="nombres">Nombre</option>
								<option value="apellidos">Apellidos</option>
							</select>
							<input type="text" id="txtBusqueda" name="txtBusqueda" onKeyPress="comboSubmit(event)">
							<input type="button" value="Buscar" id="btnBuscarPorOpcion" onclick="buscarPorOpcion()">
							<input type="button" value="Ver Todos"  id="btnConsultarTodos" onclick="consultarTodos();">
					</td></tr></table>
					<br>&nbsp;<br>&nbsp;
					<hr style="border-color: #559955; border-style: dotted 1px #559955" width="550">
				</td>
			</tr>
			</form>
			<tr align="center">
				<td valign="top">
					<table id="tblMensajeLoad"  style="display:none;" align="center" border="0" width="290">
						<tr>
							<td>
								<div id="divMensajeLoad" class="cuadroLoad" style="width:290px;border-collapse: collapse; border: 2px solid;" >
									Procesando...
								</div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr align="center">
					<td align="center" valign="top">
						<table id="tblMensaje"  style="display:none;" align="center" border="0">
							<tr>
								<td align="center">
									<div id="divMensaje" class="cuadroMensajeError" ></div>
								</td>
							</tr>
						</table>
					</td>
			</tr>
			<tr align="center">
				<td align="center">
					<table align="center" bgcolor="#FFFFFF" cellpadding="0" cellspacing="0">
								<tr>
									<td align="center">
										<form name="frmbus" style="margin:0px;">
											<table id="tblResultados" align="center" border="1" width="550" cellpadding="0" cellspacing="0" style="border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;">
												<tbody>
													<tr bgcolor="#59B3D9" align="left">
														<td align="left" width="150" height="20"><b>Nombre</b></td>
														<td align="left" width="150"><b>Apellido</b></td>
														<td align="left" width="200"><b>Mail</b></td>
														<td align="center" width="50"><b>&nbsp;</b></td>
													</tr>
												</tbody>
											</table>
										</form>
									</td>
								</tr>
						</table>
					</td>
				</tr>
				<tr align="center">
					<td><table ><tr><td>
						<input 	type="button" name="btnBaja" value="Quitar socio seleccionado de alerta" id="btnBaja"
						style="display:none;"
						onclick="darBaja();">
					</td></tr></table>
					</td>
				</tr>
</table>
	</body>
	</html>
