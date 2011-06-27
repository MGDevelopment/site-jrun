<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*,
				 com.tmk.controllers.intranet.contenido.ContenidoHelper"%>
<%@page import="com.tmk.controllers.intranet.admin.UsuarioDAO"%>
<%@page import="com.tmk.controllers.intranet.admin.LoginIntranet"%>
<%
	StringBuffer catalogo  = new StringBuffer("");
	catalogo.append("<option  value=\"libros-ficcion\"> Libros-> Ficcion</option>" );
	catalogo.append("<option  value=\"libros-noaccion\"> Libros-> No Accion</option>" );
	catalogo.append("<option  value=\"libros-infantiles\"> Libros-> Infantiles</option>" );
	catalogo.append("<option  value=\"libros-juveniles\"> Libros-> Juvenilies</option>" );
	catalogo.append("<option  value=\"musica\"> Musica</option>" );
	catalogo.append("<option  value=\"peliculas\"> Peliculas</option>" );
%>
<html>
		if (usuarioDAO == null || !UsuarioDAO.tieneAlgunAcceso("CONTENIDOS", "RANKING_M")){%>
			-- jsp:forward page="<%//=LoginIntranet.PAGINA_PRINCIPAL//%>"/>
		}
<head>
<style type="text/css" rel="stylesheet">
			font.TextoBordo
			{
				color: #990000;
				font-size: 12px;
				font-family: verdana;
				text-transform: uppercase;
				font-weight: bold;
				text-align: center;
			}

			table.BordeFino
			{
				border-collapse: collapse;
				border: 2px solid;
				border-color: #5AB5DE;
			}
</style>
<%=Globals.estiloBasico() %>

<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/prototipe.js" type="text/javascript"></script>
<script language="javascript" type="text/javascript">

/*DEFINICION DE TODAS LAS FUNCIONES NECESARIAS*/
	function buscarCatalogo() {
		$('btnbuscar').style.display='none';
		var frm = document.frmBuscarCatalogo;
		var opcion ='&opcion='+frm.listaCatalogo.options[frm.listaCatalogo.selectedIndex].value;
		ejecutarAjax('/GetListadoCatalogo?param='+Math.random()+opcion,'', 'POST', 'buscarCatalogo');
		return false;
	}
	function handle(connAj, params) {
			switch(params){
				case  'buscarCatalogo':
					if(connAj.readyState == 4){
							$('tblMensajeLoad').style.display = 'none';
							$('tblResultados').style.display = 'block';
						try{
							obj = eval("(" + connAj.responseText + ")");
							var listaCatalogo = obj.Resultado.respuesta;
							var mostrar;

							if(obj.Resultado.valor){
								//deleteRows($('tblResultados'));
								for(i = 0; i < listaCatalogo.length; i++){
									<%-- actualiza la tabla con cada elemento del socios --%>
									var lista = new Array(4);
									lista[0] = listaCatalogo[i].cls_nombres;
									lista[1] = listaCatalogo[i].cls_apellidos;
									lista[2] = listaCatalogo[i].cls_login;
									lista[3] = '<input name =\"baja\" type =\"radio\" value = "' +listaCatalogo[i].id_socio+ '-' +listaCatalogo[i].id_sucursal+ '\">';
									//addRow( $ ('tblResultados') ,socio);
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
								//$('btnBaja').style.display='none';
							}else{
								//$('btnBaja').style.display='block';;
							}
						}
						catch( e ){
							alert(e);
						}
					} else {
						//deleteRows($('tblResultados'));
						$('tblResultados').style.display = 'none';
						$('tblMensaje').style.display = 'none';
						$('tblMensajeLoad').style.display = 'block';
					}
				break;
			}
	}
</script>
</head>
<body background="/imagenes/intranet/fondo.gif" topmargin="0" leftmargin="0" marginheight="0" marginwidth="0">
<table align="center" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" width="770" border="0">
	<tr><!-- TITULO -->
		<td>
			<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
			</table>
		</td>
	</tr>
	<TR>
		<TD align="center">
			<p class="TextoBordo">Ranking</p>
		</TD>
	</TR>
	<TR>	<!-- MENSAJE -->
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
	<!-- SELECCION DE CATALOGO -->
	<form name="frmBuscarCatalogo" id="buscarcatalogo">
		<tr>
			<TD align="center">
				<TABLE>
					<TR>
						<TD>
							VerCatalogo
							<select name="listaCatalogo" >
								<%out.print(catalogo);%>
							</select>
						</TD>
						<TD align="left">
							<input type="button" value="Buscar" id="btnbuscar" name="btnbuscar" style="disabled:true;" onclick="buscarCatalogo();"/>
						</TD>
					</TR>
				</TABLE>
			</TD>
		</tr>
	</form>
	<TR>	<!-- PROCESANDO -->
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
	<!-- LISTADO DEL CATALOGO-->
	<tr>
		<td>
			<table align="center" bgcolor="#FFFFFF" border="0">
				<tr>
					<td align="center">
						<form name="frmListadoCatalogo"  style="margin:0px;">
							<div id="divResultados" style="display:;border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;"></div>
							<table width="550" id="tblResultados" align="center" border="1" cellpadding="0" cellspacing="0" style="display:; border-collapse: collapse; border: 1px solid; border-color: #5AB5DE;">
								<tr bgcolor="#59B3D9" align="left">
									<td align="left" width="150"><b>ID</b></td>
									<td align="left" width="150"><b>Titulo</b></td>
									<td align="left" width="200"><b>Tapa </b></td>
									<td align="center" width="50"><b>&nbsp;  </b> </td>
								</tr>
							</table>
						</form>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
