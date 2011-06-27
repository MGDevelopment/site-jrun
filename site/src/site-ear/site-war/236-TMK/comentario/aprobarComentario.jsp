<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
				 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.comentario.ComentarioHelper,
				 com.tmk.common.ComentarioClass"%>
<%
       ComentarioClass comentarios[] = ComentarioClass.getComentariosPorEstado(ComentarioHelper.PENDIENTE);

%>
<html>

<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR"))) {
%>
    	<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>

	<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.estiloBasico() %>
		<%= Globals.title("Lista de Comentarios") %>
	<script type="text/javascript" src="/js/prototype-1.6.0.3.js"></script>
	<style type="text/css" rel="stylesheet">
		font.TituloBordo
		{
			color: #990000;
			font-size: 14px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		font.TextoBordo
		{
			color: #990000;
			font-size: 12px;
			font-family: verdana;
			text-transform: uppercase;
			font-weight: bold;
			text-align: center;
		}

		a.EnlaceNegro
		{
			font-size: 11px;
			font-family: verdana;
			color: #000000;
			text-decoration: none;
		}

		table.BordeFino
		{
			border-collapse: collapse;
			border: 2px solid;
			border-color: #5AB5DE;
		}
	</style>
<script language="javascript">
	/**
	*arma los parametros en base a los datos cargagos en el formulario tomandolos por id
	**/
	var comentariosProcesados = 0;
	function getParametros() {
	    var getstr = "?";
	    var cantidadDeComentarios = $('cantidadDeComentarios').value;
		var radios;
		var indexRadio;
		var cantidadParaNoEnviar = 0;
		var indice = 0;
		
	    for (i = 0; i < cantidadDeComentarios; i++) {
		    radios = document.getElementsByName('estado'+i);
		    try { 
			    for(indexRadio=0;radios[indexRadio].checked == false;indexRadio++);
			    if(radios[indexRadio].value != "N") {	
		            getstr += "id_comentario"+indice +"=" + $('id_comentario'+i).value + "&";
		            getstr += "id_articulo"+indice +"=" + $('id_articulo'+i).value + "&";
		            getstr += "estado"+indice +"=" + radios[indexRadio].value + "&";
		            indice++;	            
			    } else {
			    	cantidadParaNoEnviar++;
			    }
		    } catch(e) {}            
	    }	
	    getstr += "totalCount="+(cantidadDeComentarios-cantidadParaNoEnviar)+ "&"; 
	    return getstr;  	   
	}
	
	function modificarComentarios() {
		//obj.style.display = 'none';
		$('btnActualizar').style.display='none';			 		
		/*obtengo el tabla que contien los datos*/
		var tbl= $('tblResultados');
		/*indicador de cantidad d comentarios procesados->se incrementa cuando se modifican*/
		var aux = $('cantidadDeComentarios');
		if(aux!= null) {
			if(comentariosProcesados == aux.value) {
				$('divMensajesError').innerHTML = 'No existen comentarios por aprobar.';			
				 return;
			}
		}
		/*mensaje de proceso en el div area de mensajes*/
		$('divMensajesError').innerHTML = 'Procesando...';
		var i;		
		new Ajax.Request('/ComentarioPendiente'+getParametros()+'param='+Math.random(),
		{
			method:'post',
			onSuccess: function(transport) {					
		      	/*var obj= transport.responseText.evalJSON();
		      	if(obj.Resultado.valor) {
		      		if(!obj.Resultado.fallaSistema) {
			      		if(!obj.Resultado.targetRedirect) {
			      			$('divMensajesError').innerHTML= '<b>Resultados obtenidos</b><br><br>';
			      			if(obj.Resultado.aux!= null) {
					      	$('btnActualizar').style.display='block';
				      		//oculto las filas que se eliminaron
					      		for(i = 0;i<obj.Resultado.aux.length;i++) {
						      		if(typeof(obj.Resultado.aux[i])!='object'){
						      			var nombreFila = obj.Resultado.aux[i]+'';
						      			var trArriba = $(nombreFila);
						      			var trAbajo = $('_'+nombreFila);					      			
						      			deleteRows(tbl,trArriba.rowIndex);
						      			deleteRows(tbl,trAbajo.rowIndex);
						      			$('divMensajesError').innerHTML += 'comentario &nbsp; ' +obj.Resultado.aux[i] + '&nbsp;estado modificado<br>';// actualizado y posteado en twitter' + '<br>';
			      						comentariosProcesados++;
						      		}
					      		}
				      		}
				      		//informo los mensaje que no se pudieron procesar
				      		if(obj.Resultado.campo != null) {				 
				      			$('btnActualizar').style.display='block';     			
					      		for(i = 0;i<obj.Resultado.campo.length;i++) {
					      			if(typeof(obj.Resultado.campo[i])!='object'){
				      					$('divMensajesError').innerHTML += 'comentario &nbsp;'+obj.Resultado.campo[i] + '&nbsp;Falló la aprobacion' + '<br>';
						      		} 						      		
					      		}
				      		}				      		
						} else {
			      			window.location.href = obj.Resultado.targetRedirect;
			      		}
		      		} else {
		      			window.location.href = obj.Resultado.targetRedirect;
		      		}
		      	} else {
		      		//window.location.href = obj.Resultado.targetRedirect;
		      		window.location.href = '/236-TMK/comentario/original_aprobarComentario.jsp';
		      	}*/
		      	window.location.href = '/236-TMK/comentario/aprobarComentario.jsp';
 			}
 		 }//fin newAjax...
		);
	}
	function deleteRows(tbl,index) {
		tbl.deleteRow(index);
	}
</script>
</head>
<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
<form id="frmComentario" name="frmComentario" action="/ComentarioPendiente">
<table bgcolor="#FFFFFF" align="center" cellpadding="0" cellspacing="0" width="770" height="100%">
 <tr>
  <td valign="top">
	<table cellpadding="0" cellspacing="0" width="770">
		<tr>
			<td>
				<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>
							<jsp:include page="/236-TMK/comunes/header.jsp"/>
						</td>
					</tr>
				</table>
				<br>
                <%
                if (comentarios != null && comentarios.length>0) {
                %>
				<table width="650" align="center">
					<tr><td><div style="border:thin solid;" id="divMensajesError"></div>
				<tr>
					<td>
                        <table id="tblResultados" align="center" cellpadding="2" cellspacing="0" style="border-collapse: collapse; border: 2px solid; border-color: #5AB5DE;">
						    <tr bgcolor="#59B3D9">
								<td width=180>
									<b>Fecha</b>
								</td>
                                <td height="25" width=150>
									<b>Socio</b>
								</td>
                                <td width=80 align="center">
									<b>Evaluación</b>
								</td>
								<td width=80 align="center">
									<b>Aprobar</b>
								</td>
                                <td width=80 align="center">
									<b>Rechazar</b>
								</td>
                                <td width=80 align="center">
									<b>Pendiente</b>
								</td>
						   </tr>
		                   <!--Iterar-->
                           <%
                           int cantComentario=0;
                           for (int i=0; i<Math.min(comentarios.length, 25); i++) {
                                cantComentario++;
                           %>
                           <input type="hidden"  id="<%= ComentarioHelper.CAMPO_ID_COMENTARIO + (i) %>" name="<%= ComentarioHelper.CAMPO_ID_COMENTARIO + (i) %>" value="<%= comentarios[i].getIdComentario()%>">
                           <input type="hidden" id="<%= ComentarioHelper.CAMPO_ARTICULO + (i) %>" name="<%= ComentarioHelper.CAMPO_ARTICULO + (i) %>" value="<%= comentarios[i].getIdArticulo()%>">
                           <tr style="font-size: 12px;" cellspacing="2" id="<%= comentarios[i].getIdComentario()+"-"+comentarios[i].getIdArticulo()%>">
                                <td style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
                                    <%= Convert.toStringLargo(comentarios[i].getFecha())%>
								</td>
								<%
                                    String nombreCompleto = comentarios[i].getNickName();
                   				%>
                                <td style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
                                    <a onclick="javascript:window.open('/236-TMK/ordenes/socio.jsp?sucursal=<%= comentarios[i].getIdSucursalSocio()%>&socio=<%= comentarios[i].getIdSocio()%>','Socio','toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, copyhistory=no, width=800, height=700')" style="cursor:hand;" onmouseover="return window.status='Ver datos personales'" onmouseout="return window.status=''"><%= nombreCompleto %></a>
								</td>
                                <td align="center" style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
								    <%= ComentarioHelper.TEXTOS[comentarios[i].getEvaluacion() - ComentarioHelper.MINIMO_EVALUACION] %>
                                </td>
                                <td align="center" style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
                                    <input type="radio" id="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" name="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" value="<%= ComentarioHelper.APROBADO %>">
								</td>
                                <td align="center" style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
                                    <input type="radio" id="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" name="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" value="<%= ComentarioHelper.RECHAZADO %>">
								</td>
                                <td align="center" style="border-collapse: collapse; border-top: 2px solid; border-color: #5AB5DE;">
                                    <input type="radio" id="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" name="<%= ComentarioHelper.CAMPO_ESTADO%><%= i %>" value="<%= ComentarioHelper.PENDIENTE %>" checked>
								</td>
                          </tr>
                          <tr id="_<%= comentarios[i].getIdComentario()+"-"+comentarios[i].getIdArticulo()%>">
                               <td colspan="6" bgcolor="#FFFFDA">
                                <a onclick="javascript:window.open('/articulo/detalleArticulo.jsp?idArticulo=<%=comentarios[i].getIdArticulo()%>&idSeccion=<%=comentarios[i].getIdSeccion()%>','Articulo','width=600, height=400, scrollbars=yes')" style="cursor:hand;" onmouseover="return window.status='Ver el detalle del artículo'" onmouseout="return window.status=''"><b>Artículo: <%=Convert.corregir(comentarios[i].getTituloArticulo(), true)%></b></a>
                                <br>
                                <%= comentarios[i].getTexto().replaceAll("\n","<br>")%>
                                <br>
                                <br>
                               </td>
                          </tr>
                          <!--Iterar-->
                          <% } %>
						</table>
					</td>
				<tr>
				<tr>
                    <td align="right">
                        <%-- <input src="/imagenes/botonActualizar.gif" type="image" value="Actualizar" onClick="modificarComentarios();">--%>
                        <input id="btnActualizar" src="/imagenes/botonActualizar.gif" type="button" value="Actualizar" onClick="modificarComentarios();" style="bisplay:block;">
                        <input type="hidden" id="cantidadDeComentarios" name="<%= ComentarioHelper.CAMPO_CANTIDAD_COMENTARIO%>" value="<%= cantComentario%>">
                    </td>

                </tr>
				
				</table>
				
               <%
                }
                else {
                    out.println("No existen comentarios por aprobar.");
                }
               %>

					</td>
				</tr>

			</table>
		</td>
	</tr>
</table>
</form>
</body>
</html>
