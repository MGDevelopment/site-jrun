<%@ page import="java.util.*,com.tmk.kernel.Globals, java.lang.StringBuffer.* "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	int MAX_AÑO = 2020;
	int MAX_PROMOCION = 2;
	StringBuffer dia  = new StringBuffer("");
	StringBuffer mes  = new StringBuffer("");
	StringBuffer anio = new StringBuffer("");
	StringBuffer tipopromocion  = new StringBuffer("");

	for(int i=1;i<32;i++){
		dia.append("<option  value=\""+i+"\">"+i+"</option>" );
	}
	for(int i=1;i<13;i++){
		mes.append("<option value=\""+i+"\">"+i+"</option>" );
	}
	for(int i=2008;i<MAX_AÑO;i++){
		anio.append("<option value=\""+i+"\">"+i+"</option>" );
	}
	/*las opciones de la priomocion */
	tipopromocion.append("<option value= \"envio\" > Por gasto de envio </option>" );
	tipopromocion.append("<option value=\"descuento\" > Por descuentos </option>" );

%>
<html>
	<head>
	<%= Globals.estiloBasico() %>
	<link href="/estilos/comun.css" rel="stylesheet" type="text/css"/>
	<script src="/js/ajax.js" type="text/javascript"></script>
	<script src="/js/jsutil.js" type="text/javascript"></script>
	<script src="/js/validationForm.js" type="text/javascript"></script>
	<script src="/js/prototipe.js" type="text/javascript"></script>
	<style type="text/css">
		.template{
			border:dashed 1px #ff9900;
			background-repeat: no-repeat;
			background-position:left top;
		}
	</style>

	<script type="text/javascript">
/*GetArticulosBy*/
		function GetArticuloBy() {
			var form = $('frmBusqueda');
			var id_articulo = $('id_articulo').value;
			var isbn 		= $('isbn').value;
			if($('btnBuscar').disabled == false){
				if(id_articulo.length == 0 && isbn.length == 0){
					alert("Ingresá al menos una opcion de busquda");
				}else{
					ejecutarAjax('/GetArticuloBy?param='+Math.random()+'&id_articulo='+id_articulo+'&isbn='+isbn,'', 'POST', 'GetArticuloBy');
					return false;
				}
			}
		}
/*generar template*/
		function generarTemplate(){
			var form = document.frmResultado;
			/*SETEO DE LOS CAMPOS HIDDENS*/
			$('hid_articulo').value = $('id').innerHTML;
			var formFecha = document.frmResultado;
			var dia =  formFecha.dia.options[formFecha.dia.selectedIndex].value;
			var mes = formFecha.mes.options[formFecha.mes.selectedIndex].value;
			var anio = formFecha.anio.options[formFecha.anio.selectedIndex].value;
			$('hfecha').value = dia+'/'+mes+'/'+anio;
			form.submit();
/*			$('iframe').src='/GenerarTemplate?'+
						'&id_articulo='+id_articulo+
						'&isbn='+isbn+
						'&fecha='+fecha+
						'&tipoPromocion='+tipoPromocion;
			$('btnGenerar').disabled = false;*/
/*			$('btnVer').style.display = 'block';
			$('btnDescargar').style.display = 'block';*/
			$('btnNuevaBusqueda').style.display = 'block';
		}

/* FUNCIONES HANDLER'S*/
		function handle(connAj, params) {
			switch(params){
				case  'GetArticuloBy':
					if(connAj.readyState == 4){
							$('tblMensajeLoad').style.display = 'none';
							$('tblResultados').style.display = 'block';
						try{
							var obj = eval("(" + connAj.responseText + ")");
							var vecArticulo = obj.Resultado.respuesta;
							var mostrar;

							if(obj.Resultado.valor){
								for(i = 0; i < vecArticulo.length; i++){
									var articulo = new Array(3);
									articulo[0] = vecArticulo[i].id_articulo;
									articulo[1] = vecArticulo[i].titulo;
									/*vertifico que tenga descripcionprincipal*/
									if(typeof (vecArticulo[i].descripcionPrincipal) != "undefined"){
										/*verifico que tengo sinopsis o descripcion principal*/
										if( typeof(vecArticulo[i].descripcionPrincipal[0].texto)!= "undefined"){
											articulo[2] = vecArticulo[i].descripcionPrincipal[0].texto;
											agregarFila(articulo,0);
										}else{
										/*descripcion*/
											articulo[2] = vecArticulo[i].descripcion;
											agregarFila(articulo,1);
										}
									}else{
										articulo[2] = '';
										agregarFila(articulo,0);
									}
									$('btnBuscar').disabled = true;
									$('btnNuevaBusqueda').style.display = 'block';
									$('btnGenerar').disabled = false;
									$('btnGenerar').style.display  = 'block';
									/*desabilito los campos de isbn y id_articulo*/
									$('isbn').disabled  = true;
									$('id_articulo').disabled  = true;
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
										$('btnBuscar').disabled = true;
										$('btnNuevaBusqueda').disabled = true;
									} else {
										/*si hubo campos no completados*/
										if(obj.Resultado.campo){
											alert(obj.Resultado.mensaje[0]);
											$('btnBuscar').disabled = false;
										}else{
											$('tblResultados').style.display= 'none';
											$('divMensaje').className = 'cuadroMensajeWarning';
											$('divMensaje').innerHTML = obj.Resultado.mensaje[0];
											$('tblMensaje').style.display = 'block';
											$('btnNuevaBusqueda').style.display ='block';
										}
										$('btnNuevaBusqueda').disabled = false;
									}
								}
							}
						}
						catch( e ){
							alert(e);
						}
					} else {
						$('tblResultados').style.display = 'none';
						$('tblMensaje').style.display = 'none';
						$('btnBuscar').disabled = true;
						$('tblMensajeLoad').style.display = 'block';
					}
				break;
			}
	}

	function borrar(opcion){
		switch(opcion){
			case '1':
				$('id_articulo').value='';
			break;
			case '2':
				$('isbn').value='';
			break
		}
	}

	function agregarFila(datos,opcion) {
		$('id').innerHTML=datos[0];
		$('titulo').innerHTML=datos[1];
		if(opcion == 0){
			$('sinopsis').innerHTML=datos[2];
		}else{
			$('descripcion').innerHTML=datos[2];
		}

	}

	function nuevaBusqueda(){
		/*habilito los campos de busqueda isbn y id_rrticulo*/
		$('isbn').disabled  = false;
		$('id_articulo').disabled  = false;
		/*borro los datos*/
		$('id').innerHTML='';
		$('titulo').innerHTML='';
		$('sinopsis').innerHTML='';
		$('descripcion').innerHTML='';
		/*oculto botones*/
/*		$('btnVer').style.display = 'none';
		$('btnDescargar').style.display = 'none';*/
		$('btnGenerar').disabled = true;
		$('btnNuevaBusqueda').style.display='none';
		$('btnBuscar').disabled = false;
		/*limpio la template*/
		//$('iframe').style.display = 'none';
	}
	function verTemplate(){
		$('template').style.display='block';
	}
	function verTemplatei(){
		$('iframe').style.display='block';
	}
	</script>

</head>

<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
	<table bgcolor="#FFFFFF" border="0" align="center" cellpadding="0" cellspacing="0"  >
	<!-- HEAD -->
		<TR>
			<TD valign="top">
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>
			</TD>
		</TR>
		<tr height="30px"><td><LABEL class="TextoBordo">Generacion automatica de template</LABEL></td></tr>
		<!-- BUSQUEDA -->
		<form method="POST" name="frmBusqueda" onSubmit="return getArticuloBy()">
		<TR>
			<TD>
				<table border="1" align="center" style="border: thin 1px #DDDDD; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;" cellpadding="3">
					<tr>
						<td colspan="3" bgcolor="EEEEEE" align="center">
							<b>Busqueda de Articulo</b>
						</td>
					</tr>
					<tr>
						<td>ID de Artículo</td>
						<td><input type="text" value='' name="id_articulo" id="id_articulo" onfocus="borrar('2');" onKeyPress="presionarEnter(event,'GetArticuloBy()')"/></td>

					</tr>
					<tr style="display:none;">
						<td>ISBN</td>
						<td><input type="text" value='' name="isbn" id="isbn" onfocus="borrar('1');"/></td>
					</tr>
					<tr>
						<td rowspan="1">
							<input type="button" value="Buscar" id="btnBuscar" name="btnBuscar" onclick="GetArticuloBy();"/>
						</td>
						<td>
							<input type="button"  style="display:none;"value="Nueva busqueda" id="btnNuevaBusqueda" name="btnNuevaBusqueda" onclick="nuevaBusqueda();"/>
						</td>
					</tr>
				</table>
			</TD>
		</form>
		</TR>
		<tr>
			<td>
				<hr style="border-color: #559955; border-style: dotted 1px #559955" width="550">
			</td>
		</tr>
		<!-- MENSAJE -->
		<TR>
			<TD align="center">
				<table id="tblMensaje" style="display:none;" align="center" border="0">
						<tr>
							<td align="center">
								<div id="divMensaje" class="cuadroMensajeError"></div>
							</td>
						</tr>
				</table>
			</TD>
		</TR>
		<!-- PROCESANDO -->
		<TR>
			<TD>
				<table id="tblMensajeLoad" style="display:none;" align="center" border="0" width="290">
						<tr>
							<td>
								<div id="divMensajeLoad" class="cuadroLoad" style="width:290px;border-collapse: collapse; border: 2px solid;">
									Procesando...
								</div>
							</td>
						</tr>
				</table>
			</TD>
		</TR>
		<!-- RESULTADO -->
		<TR align="center">
			<td align="center">
				<table align="center" bgcolor="#FFFFFF" cellpadding="0" cellspacing="0">
					<form name="frmResultado" style="margin:0px;" id="frmResultado" action="/GenerarTemplate" method="POST">
						<tr>
							<td align="center">
								<table id="tblResultados" align="center" border="1" width="" cellpadding="0" cellspacing="0" style="border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;">
									<tbody>
										<tr  align="left" height="21px"/>
											<td align="left"><b>ID</b></td>
											<td align="left">
												<div id="id"></div>
											</td>
										<tr/>
										<tr >
											<td align="left" height="21px"><b>Titulo</b></td>
											<td align="left" >
												<div id="titulo"></div>
											</td>
										</tr>
										<tr align="left" height="21px"/>
											<td align="left" height="20"><b>Descripcion</b></td>
											<td >
												<div id="descripcion"></div>
											</td>
										<tr/>
										<tr align="left" height="21px"/>
											<td align="left" height="20"><b>Sinopsis</b></td>
											<td >
												<div id="sinopsis"></div>
											</td>
										<tr/>
										<TR>
											<TD align="left" height="21px">
												<b><label>Fecha de vencimiento</label></b>
											</TD>
											<TD align="left" width="450">
												<select name="dia" >
													<%out.print(dia);%>
												</select>
												<label>-</label>
												<select name="mes">
													<%out.print(mes);%>
												</select>
												<label>-</label>
												<select name="anio">
													<%out.print(anio);%>
												</select>
											</TD>
										</TR>
										<TR>
											<TD align="left" height="21px">
												<b><label>Tipo de promocion</label></b>
											</TD>
											<TD align="left" height="21px" width="">
												<select name="tipoPromocion" >
													<%out.print(tipopromocion);%>
												</select>
											</TD>
										</TR>
										<TR>
											<td align="left" height="21px">
												<input type="button" style="display:none;" value="Generar Template" id="btnGenerar" name="btnGenerar" style="disabled:true;" onclick="generarTemplate();"/>
												<%-- hidden para id_articulo, isbn, fecha--%>
												<input type="hidden" name="hid_articulo" id="hid_articulo" value="">
												<!-- <input type="hidden" name="hisbn" id="hisbn" value="">-->
												<input type="hidden" name="hfecha" id="hfecha" value="">
												<%-- <input type="button" style="display:none;" value="Generar Template" id="btnGenerar" name="btnGenerar" style="disabled:true;" onclick="generarTemplate2();"/>--%>
											</td>
											<td align="left">
												<table>
													<tr>
														<td>
															<!-- <input style="display:none"type="button" value="Ver" id="btnVer" name="btnVer" onclick="verTemplate();"/>-->
															<input style="display:none"type="button" value="Ver" id="btnVer" name="btnVer" onclick="verTemplatei();"/>
														</td>
														<td>
															<input style="display:none"type="button" value="Descargar" id="btnDescargar" name="btnVer" onclick="alert('se abre el archivo');"/>
														</td>
													</tr>
												</table>
											</td>
										</TR>
									</tbody>
								</table>
							</td>
						</form>
						</tr>
				</table>
			</td>
		</TR>
		<TR align="center">
			<TD align="center">
				<iframe style="align:center;display:none" id="iframe" height="1100x;" width="700px;" class="template"></iframe>
			</TD>
		</TR>
</table>
</body>
</html>