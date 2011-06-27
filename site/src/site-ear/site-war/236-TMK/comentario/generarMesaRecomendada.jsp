<%@ page
	import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.comentario.ComentarioHelper,
				 com.tmk.common.ComentarioClass"%>
<%
       //ComentarioClass comentarios[] = ComentarioClass.getComentariosPorEstado(ComentarioHelper.PENDIENTE);

%>
<html>

<%	
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR"))) {
%>
<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>" />
<%	}
%>
<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">
<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">
<head>
<%= Globals.icon() %>
<%= Globals.charset() %>
<%= Globals.estiloBasico() %>
<%= Globals.title("Lista de Comentarios") %>
<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
<script type="text/javascript">
function eliminarArticuloDeLaMesa(idArticulo) {
	var params = 'param='+Math.random()+'&idArticulo='+idArticulo;
	$.ajax({
		url: '/EliminarArticuloDeLaMesa.do', 
		type: "GET",
		data:params,
		success: function(transport) {
			var div = $('td[id="divResultado"]')[0];
			$(div).html('');
			$(div).html(transport);				
		}
	});
}
function getArticulosRecomendadosMesa(idArticulo) {
	var idSeccion = $('select[id="frmBusquedaIdSeccion"]')[0].value;
	var agrupacion = $('select[id="frmBusquedaAgrupacion"]')[0].value;
	var filtro = $('select[id="frmBusquedaFiltro"]')[0].value;
	var params = 'param='+Math.random()+'&idSeccion='+idSeccion+'&agrupacion='+agrupacion+'&filtro='+filtro;
	$.ajax({
			url: '/GetArticulosRecomendadosMesa.do', 
			type: "GET",
			data:params,
			success: function(transport) {
				var div = $('td[id="divResultado"]')[0];
				$(div).html('');
				$(div).html(transport);				
			}
	});
}
</script>
<style type="text/css" rel="stylesheet">
font.TituloBordo {
	color: #990000;
	font-size: 14px;
	font-family: verdana;
	text-transform: uppercase;
	font-weight: bold;
	text-align: center;
}

font.TextoBordo {
	color: #990000;
	font-size: 12px;
	font-family: verdana;
	text-transform: uppercase;
	font-weight: bold;
	text-align: center;
}

a.EnlaceNegro {
	font-size: 11px;
	font-family: verdana;
	color: #000000;
	text-decoration: none;
}

table.BordeFino {
	border-collapse: collapse;
	border: 2px solid;
	border-color: #5AB5DE;
}
</style>

</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0"
	topmargin="0" marginwidth="0" marginheight="0">

<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0"	width="770" >
	<tr>
		<td valign="top">
		<table cellpadding="0" cellspacing="0" width="770" cellpadding="0" cellspacing="0">
			<tr>
				<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0" cellpadding="0" cellspacing="0">
					<tr>
						<td><jsp:include page="/236-TMK/comunes/header.jsp" /></td>
					</tr>
				</table>
				<br>				
				<form action="/AgregarAListaDeMesa.do" method="get" name="frmAgregar">
				<table width="650" align="center" border="1" cellpadding="0" cellspacing="0">				
					<tr>
						<td>ID Articulo</td>
						<td><input type="text" name="idArticulo" id="idArticulo"
							style="width: 76px;"></td>
					<tr>
					<tr>
						<td>Aplicar a Agrupaci&oacute;n</td>
						<td><select name="agrupacion" id="agrupacion"
							style="width: 164px;">
							<option value="TMKRDA">Tematika recomienda</option>
						</select></td>
					</tr>
					<tr>
						<td>Aplicar a filtro</td>
						<td><select name="filtros" id="filtros" style="width: 164px;">
							<option value="UTM">&Uacute;ltimos tres meses</option>
							<option value="UA">&Uacute;ltimo a&ntilde;o</option>
						</select></td>
					</tr>
					<tr>
						<td>Posicion en la mesa</td>
						<td><input type="text" id="posicion" name="posicion"
							style="width: 50px;"></td>
					</tr>
					<tr>
						<td colspan="3">
						<div id="resultado">
						<%if(request.getAttribute("msg")!=null) {
											out.print(request.getAttribute("msg"));
						}%>
						</div>
						</td>
					<tr>
						</td>
					<tr>
						<td align="center" colspan="3">
						<input id="btnActualizar" type="button" value="Agregar" onclick="javascript:window.document.frmAgregar.submit();"> 
						</td>

					</tr>
			</form>
			<form ACTION="/EliminarArticuloDeLaMesa.do" method="get" name="frmEliminar" >
			<TR>
				<td colspan="2"><!-- Sacar un articulo de la base -->
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<td>ID de Articulo</td>
						<td><input type="text" name="idArticulo" size="8"></td>
						<td>Agrupaci&oacute;n</td>
						<td><select name="agrupacion" id="agrupacion"
							style="width: 164px;">
							<option value="TMKRDA">Tematika recomienda</option>
						</select></td>
						<td><select name="filtros" id="filtros" style="width: 164px;">
							<option value="UTM">&Uacute;ltimos tres meses</option>
							<option value="UA">&Uacute;ltimo a&ntilde;o</option>							
						</select></td>
						<td><input type="button" value="Quitar Articulo!" onclick="javascript:window.document.frmEliminar.submit();"></td>
					</tr>
					<tr>
						<td colspan="6">
						<%if(request.getAttribute("msgErrorDelete")!=null) {
										out.print(request.getAttribute("msgErrorDelete"));
									}%>
						</td>
					</tr>
				</table>
				</td>
			</TR>
		</form>
		</table>
		<form ACTION="/GetArticulosRecomendadosMesa.do" method="get" name="frmArticulosRecomendados" >
			<TR>
				<td colspan="2"><!-- Sacar un articulo de la base -->
				<table border="1">
					<tr>
						<td>Seccion</td>
						<td>
							<select name="frmBusquedaIdSeccion" id="frmBusquedaIdSeccion"
								style="width: 164px;">
								<option value="1">Libros</option>
								<option value="4">Musica</option>
								<option value="5">Peliculas</option>
								<option value="3">Pasatiempos</option>
						</td>
						<td>Agrupaci&oacute;n</td>
						<td><select name="frmBusquedaAgrupacion" id="frmBusquedaAgrupacion"
							style="width: 164px;">
							<option value="TMKRDA">Tematika recomienda</option>
						</select></td>
						<td><select name="frmBusquedaFiltro" id="frmBusquedaFiltro" style="width: 164px;">
							<option value="UTM">&Uacute;ltimos tres meses</option>
							<option value="UA">&Uacute;ltimo a&ntilde;o</option>							
						</select></td>
						<td><input type="button" value="Buscar articulos!" onclick="getArticulosRecomendadosMesa();"></td>
					</tr>
					<tr>
						<td id="divResultado"  colspan="8">
						</td>
					</tr>					
					<tr>
						<td colspan="6">
						<%if(request.getAttribute("msgErrorDeleteLista")!=null) {
										out.print(request.getAttribute("msgErrorDelete"));
									}%>
						</td>
					</tr>
				</table>
				</td>
			</TR>
		</form>
		</td>
		</tr>			
		</table>
		</td>
	</tr>
</table>
</body>
</html>
