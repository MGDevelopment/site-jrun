<html>
	<head>
		<script language="javascript">
			function Comentario(fecha,socio,evaluacion,estado){ 
			    this.fecha = fecha;
			    this.socio = socio;
			    this.evaluacion = evaluacion; 
			    this.estado = estado;			    
			    this.comentaro = new Array();
			    this.posicion=0;
			}				
		</script> 
		<script type="text/javascript" src="/js/prototype-1.6.0.3.js"></script>		
		<script language="javascript">
			/*obengo el json de respuesta del servlet getComentariosPendientes*/
			function getJson() {							
				new Ajax.Request('/GetComentariosPendientes?param=' + Math.random(),        		
	                     { method:'post',
	                       onSuccess: function(transport){
	            				if(transport.readyState==4){
		                        	var obj = transport.responseText.evalJSON();
		                        	var com = obj.comentario;									
		                            //var tabla = $('tblResultados');
		                            for(i = 0; i < com.length; i++){
		                            	//Comentario comentario = new Comentario(com[i].fecha,com[i].socio,com[i].evaluacion,com[i].estado);    
										/*var socio = new Array(4);
										socio[0] = vecfilas[i].cls_nombres;
										socio[1] = vecfilas[i].cls_apellidos;
										socio[2] = vecfilas[i].cls_login;
										socio[3] = '<input name =\"baja\" type =\"radio\" value = "' +vecfilas[i].id_socio+ '-' +vecfilas[i].id_sucursal+ '\">';*/
										//addRow( $ ('tblResultados') ,comentario);
										//alert(comentario[i]);
		                            }
	            				}else {
										            					
	            				}
	                          }
	                     }
	              );		
			}
		</script>
	</head>
	<body onload="getJson();">
	
<table id="tblResultados" align="center" border="1" width="550"	cellpadding="0" cellspacing="0">
			<tr bgcolor="#59b3d9">
				<td width="180"><b>Fecha</b></td>
				<td height="25" width="150"><b>Socio</b></td>
				<td width="80" align="center"><b>Evaluación</b></td>
				<td width="80" align="center"><b>Aprobar</b></td>
				<td width="80" align="center"><b>Rechazar</b></td>
				<td width="80" align="center"><b>Pendiente</b></td>
			</tr>
			<tr>
			
			<tr>
			<tr>
				<td colspan="6">
					<a 	onmouseout="return window.status=''" onmouseover="return window.status='Ver el detalle del artículo'" 
						onclick="javascript:window.open('/articulo/detalleArticulo.jsp?idArticulo=191155&amp;idSeccion=0','Articulo','width=600, height=400, scrollbars=yes')">
						<label id="lblComentario">nada</label>
					</a>
				</td>
			</tr>
		</table>
	</body>
</html>