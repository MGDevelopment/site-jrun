<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.orden.OrdenLocal,
				 com.tmk.orden.PagoOrdenLocal,
				 com.tmk.orden.PagoOrdenLocalHome,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.controllers.intranet.ordenes.OrdenesHelper,
                 com.tmk.kernel.*,
                 java.util.Collection,
                 java.util.Iterator,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%--
				 //com.tmk.src.socio.SocioPK, 
--%>                 
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>

<html>
	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Ordenes pendientes") %>
		<style>
			a { text-decoration:underline};
		</style>
		<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
		<script src="/js/ajax.js" type="text/javascript"></script>
		<script src="/js/prototipe.js" type="text/javascript"></script>
		<script type="text/javascript">

	function handle(connAj, params) {
	    if (params == 'getOrdenByEstadoMedio') {
		    if (connAj.readyState == 4){
				$('tblMensajeLoad').style.display = 'none';
	  			try {

					var obj = eval("(" + connAj.responseText + ")");
					if (obj.ordenes.length > 0) {
						var i;
						for (i=0; i<obj.ordenes.length; i++) {
							//alert(obj.ordenes.length);
							var datos = new Array(9);
							datos[0] = "<a href='javascript:detalleOrden(" + obj.ordenes[i].id_orden + ")'>" + obj.ordenes[i].id_orden + "</a>";
							datos[1] = obj.ordenes[i].medioDeCobro.nombre;
							datos[2] = obj.ordenes[i].codigoCupon;
							datos[3] = obj.ordenes[i].fecha;
							datos[4] = obj.ordenes[i].total;
							datos[5] = 'Sin Consultar';
							addRow($('tblOrden'), datos);
						}
						$('divConsultar').style.display = 'block';
					} else {
						alert('No existen ordenes pendientes');
					}
					$('info').style.display = 'block';
				} catch (e) {
					try {
						$('divMensajeError').innerHTML = obj.Resultado.mensaje[0];
						$('tblMensajeError').style.display = 'block';
					} catch (e) {
						alert('ERROR!! Contacte al administrador');
					}
				}
		    } else {
				$('tblMensajeLoad').style.display = 'block';
		    }
		}

		if (params == 'consultarADineroMail') {

			 if (connAj.readyState == 4){
				$('tblMensajeLoad').style.display = 'none';
	  			try {
					var obj = eval("(" + connAj.responseText + ")");
					if (obj.ordenes.length > 0) {
						var i;
						var ordenesConCambios =0;
						var frm = document.frmOrdenes;
						var estadoAprobado = "color:#33cc33;";
						var estadoVencido = "color:#cc3333;";
						var estadoCargoDiferente = "color:#CC7722;";
						var estadoSinInfo = "color:#888888;";
						for (i=0; i<obj.ordenes.length; i++) {
							//alert(obj.ordenes.length);
							var datos = new Array(9);
							datos[0] = "<a href='javascript:detalleOrden(" + obj.ordenes[i].id_orden + ")'>" + obj.ordenes[i].id_orden + "</a>";
							datos[1] = obj.ordenes[i].medioDeCobro.nombre;
							datos[2] = obj.ordenes[i].codigoCupon;
							datos[3] = obj.ordenes[i].fecha;
							datos[4] = obj.ordenes[i].total;

							if (obj.ordenes[i].estado == '<%=OrdenService.ESTADO_APROBADO%>') {

								ordenesConCambios++;
								datos[6] = "<input name='estado" + ordenesConCambios  + "' type='radio' value='A'>";
								datos[8] = "<input name='estado" + ordenesConCambios  + "' type='radio' value='P' checked>";
								datos[0] = datos[0] + "<input type='hidden' name='orden" + ordenesConCambios + "' value ='" + obj.ordenes[i].id_orden + "' >"
								datos[5] = "<div style='" + estadoAprobado + "'><b>" +  obj.ordenes[i].estado + "</b></div>";
							} else if (obj.ordenes[i].estado == '<%=OrdenService.ESTADO_VENCIDA%>') {
 								ordenesConCambios++;
								datos[7] = "<input name='estado"  + ordenesConCambios + "' type='radio' value='R'>";
								datos[8] = "<input name='estado" + ordenesConCambios  + "' type='radio' value='P' checked>";
								datos[0] = datos[0] + "<input type='hidden' name='orden" + ordenesConCambios + "' value ='" + obj.ordenes[i].id_orden + "' >"
								datos[5] = "<div style='" + estadoVencido + "'><b>" +  obj.ordenes[i].estado + "</b></div>";
							} else if (obj.ordenes[i].estado.startsWith('<%=OrdenService.ESTADO_CARGO_DIFERENTE%>')) {
								ordenesConCambios++;
								datos[6] = "<input name='estado"  + ordenesConCambios + "' type='radio' value='A'>";
								datos[7] = "<input name='estado"  + ordenesConCambios + "' type='radio' value='R'>";
								datos[8] = "<input name='estado" + ordenesConCambios  + "' type='radio' value='P' checked>";
								datos[0] = datos[0] + "<input type='hidden' name='orden" + ordenesConCambios + "' value ='" + obj.ordenes[i].id_orden + "' >"
								datos[5] = "<div style='" + estadoCargoDiferente + "'><b>" +  obj.ordenes[i].estado + "</b></div>";
							} else {
								ordenesConCambios++;
								datos[0] = datos[0] + "<input type='hidden' name='orden" + ordenesConCambios + "' value ='" + obj.ordenes[i].id_orden + "' >"
								datos[5] = "<div style='" + estadoSinInfo + "'><b>" +  obj.ordenes[i].estado + "</b></div>";
								datos[7] = "<input name='estado"  + ordenesConCambios + "' type='radio' value='R'>";
								datos[8] = "<input name='estado" + ordenesConCambios  + "' type='radio' value='P' checked>";

							}
							frm.ordenesConCambios.value = ordenesConCambios;
							addRow($('tblOrden'), datos);
						}
					}
					$('info').style.display = 'block';
					if (ordenesConCambios > 0) {
						frm.btnConfirmar.style.display = 'block';
						$('divConsultar').style.display = 'none';
					}
				} catch (e) {
					try {
						$('divMensajeError').innerHTML = obj.Resultado.mensaje[0];
						$('tblMensajeError').style.display = 'block';
					} catch (e) {
						alert('ERROR!! Contacte al administrador');
					}
				}
		    } else {
			    $('info').style.display = 'none';
				$('tblMensajeLoad').style.display = 'block';
		    }
		}


		if (params == 'confirmarCambiosDeEstado') {


			if (connAj.readyState == 4){
				$('tblMensajeLoad').style.display = 'none';
  				try {
					var obj = eval("(" + connAj.responseText + ")");

					if (obj.Resultado.valor) {
						var i;

						for (i=0; i<obj.Resultado.mensaje.length; i++) {

							var datos = new Array(1);
							datos[0] = obj.Resultado.mensaje[i];
							addRow($('tblResultados'), datos);
						}
					} else {

						if (obj.Resultado.targetRedirect != null) {
							window.location.href = 	obj.Resultado.targetRedirect;
						}
						return;
					}
					$('infoResultados').style.display = 'block';
					$('btnContinuar').style.display = 'block';

				} catch (e) {
				//errro
					alert(e);
				}
			} else {

				deleteRows($('tblOrden'));
				$('info').style.display = 'none';
				$('tblMensajeLoad').style.display = 'block';
			}
		}
	}

	function getOrdenByEstadoMedio() {
		deleteRows($('tblOrden'));
		var valores = 'idEstado=' + "'2'"
			+ '&idMedioCobro=' +  "'<%=Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL%>','<%=Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO%>'";
		ejecutarAjax('/GetOrdenByEstadoMedio?param=' + Math.random(), valores
		, 'POST', 'getOrdenByEstadoMedio');
		return false;
	}

	function consultarADineroMail() {
		deleteRows($('tblOrden'));
		var rangoDesde=document.frmOrdenes.rangoDesdeAConsultar.value;				
		var rangoHasta=document.frmOrdenes.rangoHastaAConsultar.value;
		var valores = 'idEstado=' + "'2'" 
			+ '&rangoDesde=' + rangoDesde
			+ '&rangoHasta=' + rangoHasta
			+ '&idMedioCobro=' +  "'<%=Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL%>','<%=Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO%>'";
		ejecutarAjax('/ConsultarOrdenCuponADM?param=' + Math.random(), valores
		, 'POST', 'consultarADineroMail');
		return false;
	}

	function confirmarCambiosDeEstado() {
		if (confirm('Seguro de confirmar los cambios?')) {
			document.frmOrdenes.btnConfirmar.style.display = 'none';

			var i;
			var frm = document.frmOrdenes;
			var params = '';
			for (i=0; i<frm.elements.length; i++) {
				if (frm.elements[i].type != 'button') {
					if (frm.elements[i].type == 'radio') {
						if (frm.elements[i].checked) {
							params = params + '&' + frm.elements[i].name +
								'=' + frm.elements[i].value;
						}
					} else {
						params = params + '&' + frm.elements[i].name +
								'=' + frm.elements[i].value;
					}
				}
			}
			if (params != '') {
				params = params.substring(1, params.length);
			}
			ejecutarAjax('/ModificarEstadoDeOrden?param=' + Math.random(),params
			, 'POST', 'confirmarCambiosDeEstado');
		}
		return false;


	}

	function addRow(tbl, datos) {
		tbl.insertRow(tbl.rows.length);
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

	function detalleOrden(idOrden){
		window.open('/236-TMK/ordenes/estadoOrden.jsp?idOrden=' + idOrden,'',
		"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=no, copyhistory=no, width=700, height=700");
	}

		</script>
	</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onload="getOrdenByEstadoMedio()">
<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="770" height="100%">
	<tr>
		<td valign="top">
			<table cellpadding="0" cellspacing="0" >
				<tr>
					<td width="1005">
						<table width="100%" cellspacing="0" cellpadding="0" border="0">
							<tr>
								<td colspan="5">
									<table width="100%" align="center" cellpadding="0" cellspacing="0">
                    					<tr>
											<td>
												<jsp:include page="/236-TMK/comunes/header.jsp"/>
											</td>
										</tr>
									</table>
								</td>
							</tr>

						</table>


						<div id="info" style="display:none;">
						<table>
							<tr>
								<td width="70">
								</td>
								<td>
									<br>
									<font color="#990000" style="font-size: 12px;">
										<b>Ordenes pendientes de validacion</b>
									</font>
								</td>
							</tr>
						</table>
						<form name="frmOrdenes">
						<br>
						<table align="center" border="1" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;" width="752" id="tblOrden"><tbody><tr bgcolor="#59B3D9"><td width="50px"><b>Orden</b></td><td><b>Medio de Pago</b></td><td width="70px"><b>Cupon</b></td><td width="70px"><b>Fecha</b></td><td width="50px" align="right"><b>Total</b></td><td  width="120px"><b>Estado</b></td><td align="center"><b>Aprobar</b></td><td align="center"><b>Rechazar</b></td><td align="center"><b>Pendiente</b></td></tr></tbody></table>
						<br>
						<table align="center" border="0" width="752">
							<tr>
								<td>
									<div id="divConsultar" style="display:none">
										Fecha desde(dd/MM/yyyy): <input name="rangoDesdeAConsultar" type="text" value="" />
										Fecha hasta(dd/MM/yyyy):<input name="rangoHastaAConsultar" type="text" value="" />
									<input name="btnConsultar" type="button"  value="Consultar a Dinero Mail" onclick="consultarADineroMail()" >
									</div>
									<input type="hidden" name="ordenesConCambios" value="">
									<input name="btnConfirmar" style="display:none" type="button"  value="Confirmar cambios de Estado" onclick="confirmarCambiosDeEstado()">
								</td>
							</tr>
						</table>
						</form>
						</div>
						<div id="infoResultados" style="display:none">
							<table id="tblResultados" align="center" border="1" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;" width="752" ><tbody><tr bgcolor="#59B3D9"><td><b>Resultados</b></td></tr></tbody></table>
							<br>
							<table align="center" border="0" width="752">
								<tr>
									<td>
										<input id="btnContinuar" style="display:none" type="button"  value="Continuar" onclick="window.location.reload()">
									</td>
								</tr>
							</table>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<table id="tblMensajeLoad"  style="display:none;" align="center" border="0" width="290">
							<tr>
								<td>
									<div id="divMensajeLoad" class="cuadroLoad" style="width:290px;margin-top:30px;" >
			            	      		Procesando...
    		     			        </div>
        			            </td>
        			        </tr>
        			    </table>
					</td>
				</tr>

				<tr>
					<td>
						<table id="tblMensajeError"  style="display:none;" align="center" border="0" width="290">
							<tr>
								<td>
									<div id="divMensajeError" class="cuadroError" >
        			          		</div>
        			            </td>
        			        </tr>
        			    </table>
					</td>
				</tr>

			</table>
		</td>
	</tr>
</table>
</body>
</html>