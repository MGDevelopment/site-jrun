<%@ page import="com.tmk.kernel.Globals,
	com.tmk.controllers.intranet.admin.UsuarioDAO,
    com.tmk.controllers.intranet.admin.LoginIntranet" %>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ALERTA_COMPRA_X_SOCIO")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
	<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	<html>
	<head>
		<title>Alerta de Compra Usuaios</title>
		<%= Globals.estiloBasico() %>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
		<script src="/js/ajax.js" type="text/javascript"></script>
		<script src="/js/prototipe.js" type="text/javascript"></script>

	<script language="javascript" type="text/javascript">
		<%-- buscar por nombre o apellido busca en el servlet AlertCompraSocios2 --%>
		var ultimoSeleccionado;
		function darDeAlta() {
			<%-- obtengo el nombre y/o el apellido para realizar labusqueda --%>
			var nombre = $('txtNombreBusqueda').value;
			var apellido = $('txtApellidoBusqueda').value;

			<%-- oculto el divMensajeDeError por si hubiese habido alguna ejecucion previa --%>
			$('tblMensaje').style.display = 'none';
			$('btnAlta').style.display='none';

			<%-- verifico que se haya ingresado un valor para buscar
			if( $('txtBusqueda').value == '' ){
				alert('Complete el campo de busqueda');
			}--%>
			if( (nombre.length == 0 || nombre.value == "") && (apellido.length == 0 || apellido.value=="") ){
				alert('Complete el campo de busqueda');
			}
			else{
				var frm = document.frmConsulta;
				//var opcion ='&opcion='+frm.busqueda.options[frm.busqueda.selectedIndex].value + '&valor=' + frm.txtBusqueda.value+ '&orden='+frm.orden.options[frm.orden.selectedIndex].value;
				var opcion ='&nombre=' + nombre + '&apellido='+ apellido +'&ordenadoPor='+frm.orden.options[frm.orden.selectedIndex].value;;
				//ejecutarAjax('/GetSocios2?param='+Math.random()+opcion,'', 'POST', 'darDeAlta');
				ejecutarAjax('/GetSocios2?param='+Math.random()+opcion,'', 'POST', 'darDeAlta');
				return false;
			}
		}

		<%-- efectua el alta usa el servlet AltaAlertaCompraSocios--%>
		function efectuarAlta(){
			var frm = document.frmbus;
			var radios;
			var id_socio=0;
			var id_sucursal=0;

			radios = frm.baja;
			if(typeof (radios.length) != "undefined"){
				for (i = 0; i < radios.length; i++){
					if(radios[i].checked){
						id_socio = radios[i].value.split('-')[0];
						id_sucursal= radios[i].value.split('-')[1];
						$('btnAlta').style.display='none';
						ultimoSeleccionado=i+1;
						break;
					}
				}
			}
			else{
				if(radios.checked){
					id_socio = radios.value.split('-')[0];
					id_sucursal= radios.value.split('-')[1];
					$('btnAlta').style.display='none';
					ultimoSeleccionado=1;
				}
			}

			<%--verifico que se seleccione un socio en los radio button--%>
			if(id_socio == 0 || id_sucursal == 0){
				alert("Seleccione un socio");
			}
			else{
				if ( confirm("¿Incluir Socio en Alerta de Compra?") == true ){
					ejecutarAjax('/AltaAlertaCompraSocios?param='+Math.random() + '&id_socio='+id_socio+ '&id_sucursal='+id_sucursal,'','POST', 'efectuarAlta');
					return false;
				}
				else{
					$('btnAlta').style.display='block';
				}
			}
		}

		<%-- FUNCIONES HANDLER PARA BAJA, BUSCAR TODOS Y BUSCAR POR OPCION --%>
		function handle(connAj, params) {
			switch(params){
				<%-- si el llamado lo hizo la funcion darDeAlta--%>
				case  'darDeAlta':
				if(connAj.readyState == 4){
					$('tblMensajeLoad').style.display = 'none';
					$('tblResultados').style.display = 'block';
					$('btnDarAlta').disabled = false;

					try{
						<%-- Otengo todos los SOCIOS --%>
						obj = eval("(" + connAj.responseText + ")");
						var vectorSocios = obj.Resultado.respuesta;

						if(obj.Resultado.valor){
							deleteRows($('tblResultados'));
							for(i = 0; i < vectorSocios.length; i++){
								<%-- actualiza la tabla con cada elemento del socios --%>
								var socio = new Array(4);
								socio[0] = vectorSocios[i].nombres;
								socio[1] = vectorSocios[i].apellidos;
								socio[2] = vectorSocios[i].cls_loginDesencriptado;
								socio[3] = '<input name =\"baja\" type =\"radio\" value = "' +vectorSocios[i].id_socio+ '-' +vectorSocios[i].id_sucursal+'\">';
								addRow( $ ('tblResultados') ,socio);
							}
							$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
							$('divMensaje').className = 'cuadroMensajeWarning';
							$('tblMensaje').style.display = 'block';
						}
						else{
							if(obj.Resultado.targetRedirect != null){
								window.location.href = 	obj.Resultado.targetRedirect;
							} else {
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
							$('btnAlta').style.display='none';
						}else{
							$('btnAlta').style.display='block';;
						}
					}catch( e ){
						alert(e);
					}
				} else {
					deleteRows($('tblResultados'));
					$('divResultados').style.display='none';
					$('tblResultados').style.display='none';
					$('tblMensajeLoad').style.display = 'block';
					$('btnDarAlta').disabled = true;
				}
			break;

			case 'efectuarAlta':
				if(connAj.readyState == 4){
					$('tblMensajeLoad').style.display = 'none';
					$('tblResultados').style.display = 'block';
					$('tblMensaje').style.display = 'none';

					obj = eval("(" + connAj.responseText + ")");

					if (obj.Resultado.valor) {
						$('tblResultados').deleteRow(ultimoSeleccionado);
						$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
						$('divMensaje').className = 'cuadroMensajeOk';
						$('tblMensaje').style.display = 'block';
					}
					else {
						if (obj.Resultado.targetRedirect != null) {
							window.location.href = 	obj.Resultado.targetRedirect;
						} else {
							$('tblResultados').style.display = 'block';
							$('tblResultados').deleteRow(ultimoSeleccionado);
							if (obj.Resultado.fallaSistema) {
								$('tblResultados').style.display = 'none';
								$('divMensaje').className = 'cuadroError';
								$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
								$('tblMensaje').style.display = 'block';
								return;
							} else {
								if(obj.Resultado.mensaje.length > 1){
									$('divMensaje').className = 'cuadroError';
								}else{
									$('divMensaje').className = 'cuadroMensajeWarning';
								}
								$('divMensaje').innerHTML =  obj.Resultado.mensaje[0];
								$('tblMensaje').style.display = 'block';
							}
						}
					}

					<%--verifico si muestro o no el boton --%>
					if( $('tblResultados').rows.length == 1){
						$('btnAlta').style.display='none';
					}else{
						$('btnAlta').style.display='block';
					}
				<%-- else del readyState--%>
				}else{
					//deleteRows($('tblResultados'));
					$('tblResultados').style.display = 'none';
					$('tblMensaje').style.display = 'none';
					$('tblMensajeLoad').style.display = 'block';
				}
			break;
	}//fin while
}//fin del la funcion

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
		//Borra hasta la 2da porque asume que la primera es cabecera
		function deleteRows(tbl) {
			while(tbl.rows.length>1) {
				tbl.deleteRow(tbl.rows.length-1);
			}
		}

		function comboSubmit(event) {
			if (event.keyCode == 13) {
				darDeAlta()
			}
		}

	</script>
</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" height="100%">
			<%-- fila de cabecera --%>
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
			<%-- fila de formulario de busqueda --%>
			<form name="frmConsulta" id="frmConsulta" onsubmit="return false;">
			<tr>
				<td align="center" colspan="2" height="30" valign="top">
					<p class="TextoBordo">Alerta de Compras por Socio</p>
					<b><a class="tituloLink" href="/236-TMK/ordenes/alertaCompraSocios.jsp"> Socios incluidos en Alerta </a></font>&nbsp;|&nbsp;
					<a class="tituloLinkSeleccionado" href="/236-TMK/ordenes/altaAlertaCompraSocios.jsp"> Incluir nuevos Socios en Alerta </a><br>
					<br>&nbsp;<b>
					<table border="1" cellpadding="1" cellspacing="1" style="border-collapse: collapse; border: 1,5px solid; border-color: #5AB5DE;">
						<tr>
						<td valign="middle">
						<!-- 	<b>Buscar por:</b>
							<select id="busqueda" name="busqueda">
								<option value="nombres">Nombres</option>
								<option value="apellidos">Apellidos</option>
							</select>
						-->
							<!-- <b>Ordenado:</b>
							<select id="orden" name="orden">
								<option value="nombres">Nombres</option>
								<option value="apellidos">Apellidos</option>
							</select>
							-->
							<!-- <input type="text" id="txtBusqueda" name="txtBusqueda" onKeyPress="comboSubmit(event)">-->
							<b>Nombre  <input type="text" id="txtNombreBusqueda" name="txtNombreBusqueda" onKeyPress="comboSubmit(event)">
							<b>Apellido <input type="text" id="txtApellidoBusqueda" name="txtApellidoBusqueda" onKeyPress="comboSubmit(event)">
							<b>Ordenado:</b>
							<select id="orden" name="orden">
								<option value="nombres">Nombres</option>
								<option value="apellidos">Apellidos</option>
							</select>
							<input type="button" value="Buscar Socio" id="btnDarAlta" onclick="darDeAlta();">
					</td></tr></table>
					<br>&nbsp;<br>&nbsp;
					<hr style="border-color: #559955; border-style: dotted 1px #559955" width="550">
				</td>
			</tr>
			</form>
			<%-- fila de procesando--%>
			<tr align="center">
				<td valign="top" align="center">
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
			<%-- fila de mensajes --%>
			<tr align="center">
				<td align="center" valign="top">
					<table id="tblMensaje"  style="display:none;" align="center" border="0">
						<tr>
							<td>
								<div id="divMensaje" class="cuadroMensajeError" ></div>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<%-- fila de datos --%>

			<tr>
				<td>
					<table align="center" bgcolor="#FFFFFF" border="0">
						<tr>
							<td align="center">
									<form name="frmbus"  style="margin:0px;">
									<div id="divResultados" style="display:none;border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;"></div>
									<table width="550" id="tblResultados" align="center" border="1" cellpadding="0" cellspacing="0" style="display:none; border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;">
										<tr bgcolor="#59B3D9" align="left">
											<td align="left" width="150" height="20"><b>Nombre		</b></td>
											<td align="left" width="150"><b>Apellido	</b></td>
											<td align="left" width="200"><b>Mail		</b></td>
											<td align="center" width="50"><b>&nbsp;</b>		</td>
										</tr></table>
									</form>
							</td>
						</tr>
					</table>
				</td>
			</tr>

			<tr align="center">	<td><table><tr><td>
							<input  type="button" name="btnAlta" value="Incluir Socio en Alerta de Compra" id="btnAlta"
							style="display:none;"
							onclick="efectuarAlta();">
					</td></tr></table></td>
			</tr>
	</table>
	</body>
	</html>