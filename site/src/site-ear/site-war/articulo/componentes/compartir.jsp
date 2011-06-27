

<!-- COMPARTIR A MIS AMIGOS !-->
<%
String urlPage = request.getParameter("urlPage");
String titulo = request.getParameter("titulo");
%>
<div id="cruzCompartir"><a href="javascript:mostrarDiv('compartir');" class="fFooter"><img src="/imagenes/b-cruz.gif" alt="Cerar" border="0" /></a></div>

<div id="detalleCompartir">
	<form name="frmRecomendacion">
	<table width="280" border="0" align="center" cellpadding="0" cellspacing="0">
		<tr>
			<td width="211" align="center">
				<table width="280" border="0" align="center" cellpadding="0" cellspacing="0">
				    <tr>
					    <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/share-delicious.gif" width="16" height="16" /></td>
			      		<td height="25" valign="middle" align="left"><a href="http://del.icio.us/post?url=http://<%=urlPage%>&title=<%=titulo%>" target="_blank" class="FCategorias">del.icio.us</a></td>
					    <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/share-digg.gif" width="16" height="16" /></td>
					    <td height="25" valign="middle" align="left"><a href="http://digg.com/submit?phase=2&url=http://<%=urlPage%>&title=<%=titulo%>" target="_blank" class="FCategorias">Digg</a></td>
				    </tr>
				    <tr>
					    <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/share-google_bmarks.gif" width="16" height="16" /></td>
      					<td height="25" valign="middle" align="left"><a href="http://www.google.com/bookmarks/mark?op=edit&bkmk=http://<%=urlPage%>&title=<%=titulo%>" target="_blank" class="FCategorias">Google Bookmarks</a></td>
				        <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/share-technorati.gif" width="16" height="16" /></td>
				        <td height="25" valign="middle" align="left"><a href="http://technorati.com/faves?add=http://<%=urlPage%>&title=<%=titulo%>" target="_blank" class="FCategorias">Technorati</a></td>
				    </tr>
				    <tr>
					    <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/share-yahoo_myweb.gif" width="16" height="16" /></td>
				        <td height="25" valign="middle" align="left"><a href="http://myweb2.search.yahoo.com/myresults/bookmarklet?u=http://<%=urlPage%>" target="_blank" class="FCategorias">Yahoo! My Web</a></td>
                        <td width="30" height="25" align="center" valign="middle"><img src="/imagenes/ic_meneame.gif" width="16" height="16" /></td>
      					<td height="25" valign="middle" align="left"><a href="http://meneame.net/submit.php?url=http://<%=urlPage%>&title=<%=titulo%>" target="_blank" class="FCategorias">Meneame</a></td>
                    </tr>
                </table>
            </td>
        </tr>
	    		
        <tr id="mensajeLoad" style="display:none;">
    		<td><div style="width:96%; border-top:solid 1px #666; margin-top:20px; padding-top:15px; margin-botton:5px; ">
    			<table  width="280" border="0" align="center" cellpadding="0" cellspacing="0" >
    				<tr>
			    		<td style="padding-top:10px;">
	    					<div  class="cuadroLoad" style="width:260px;">
					           Procesando...
	    			    	</div>
	    			    </td>
	    			</tr>    	
	    		</table></div>	
    		</td>
    	</tr>
    	
        <tr id="titulo">
        	<td class="tituloCompartir">
            	<div style="width:96%; border-top:solid 1px #666; margin-top:20px; padding-top:15px; margin-botton:5px; ">
	            	Envialo por mail:
            	</div>
            </td>
        </tr>
    	
        <tr id="frmEnvio">
        	<td>
        		<table  width="280" border="0" align="center" cellpadding="0" cellspacing="0">
                	<tr>
                		<td colspan="2" style="padding-top:10px">
	                		<div id="mensajeError" class="cuadroError" style="width:230px;display:none">
								           	      		
       			          	</div>
                		</td>
                	</tr>
                	<tr>
                    	<td valign="bottom" class="Ftexto02">Correo de tu amigo: </td>
                        <td>
                        	<div align="left">
                        		<input name="correoAmigo" type="text" class="ayudatext" />
	                        </div>
	                    </td>
                    </tr>
                    <tr>
                    	<td valign="bottom" class="Ftexto02">Tu correo: </td>
                        <td>
                        	<div align="left">
                            	<input name="correoPropio" type="text" class="ayudatext" />
                          	</div>
                        </td>
                    </tr>
                    <tr>
                    	<td valign="bottom" class="Ftexto02">Tu nombre: </td>
                        <td>
                        	<div align="left">
                            	<input name="nombrePropio" type="text" class="ayudatext" />
                            	<input type="hidden" name="urlPage" value="<%=urlPage%>">
                            </div>
                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr id="enviar">
        	<td align="right"><input  name="Enviar" type="button" value="Enviar" style="font-size:11px; margin-right:14px; margin-top:5px;" onclick="enviarRecomendacion()"></td>
        </tr>
    	<tr id="exito" style="display:none;">
        	<td>
        	<div style="width:96%; border-top:solid 1px #666; margin-top:20px; padding-top:15px; margin-botton:5px; ">
		        <div id="registracionExitosa" class="cuadroExitoExterno" style="width:260px;">
		        	<div class="cuadroExito" style="width:240px;">
		            	<div class="cuadroExitoTitulo">
		                	Envio de Recomendación Exitoso!!
		                </div>
		                Gracias por enviar tu recomendación. <br>
		           		Para realizar otra hace click <a onclick="javascript:enviarOtraReco()" style="cursor:pointer;" class="Flink02">aqui</a>
			        </div>                        
				</div>
			</div>	
			</td>
		</tr>		
    </table>
    </form> 
</div>
<!-- CIERRO COMPARTIR A MIS AMIGOS !-->  