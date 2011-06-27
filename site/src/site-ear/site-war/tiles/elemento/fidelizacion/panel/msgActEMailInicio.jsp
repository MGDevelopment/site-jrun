<%@ page import="com.tmk.kernel.Globals"%>

<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px;">
<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td>
    	<br>
    </td>
  </tr>
  <tr>
    <td>
       <!-- Menu -->
 	   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=8";%>
	   <jsp:include page="<%=pageMenu%>"/>
       <!-- Menu -->
     </td>
    </tr>
  <tr>
    	<td>
        	<table width="740" border="0" align="center" cellpadding="0" cellspacing="0">
        		<tr>
		          	<td>
		          		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			              	<tr>
            			    	<td valign="top">
                					<table width="100%" border="0" cellspacing="0" cellpadding="0">
					                    <tr>
                    					  <td height="40" class="punteonargris"><img src="/imagenes/fidelizacion/titulo_10.gif" width="222" height="26"></td>
					                    </tr>
                    					<tr>
						                    <td class="punteonargris">
						                    	<table width="100%" border="0" cellpadding="0" cellspacing="0" class="celeste">
                        							<tr>
							                            <td><strong>Acabas de iniciar el proceso de actualizaci&oacute;n
                							              de tus datos.</strong></td>
							                        </tr>
						                        </table>
						                    </td>
					                    </tr>
                    					<tr>
						                    <td class="punteonargris"><span class="arial12">En instantes
						                        estar&aacute;s recibiendo un e-mail a la nueva casilla
                        						para confirmar los datos ingresados.</span><span class="Ftexto02"></span></td>
					                    </tr>
                    					<tr>
						                    <td class="punteonargris"><img src="/imagenes/fidelizacion/loading.gif" width="158" height="14"></td>
					                    </tr>
                    					<tr>
						                    <td class="punteonargris">&nbsp;</td>
					                    </tr>
					                </table>
				                </td>
                				<td width="165" valign="top" bgcolor="#E79A0B">
                				<!--LEFT-->
            	 				  <% String pageLeft = "/fidelizacion/panel/componentes/left.jsp";%>
								  <jsp:include page="<%=pageLeft%>"/>
               					<!--LEFT-->
                				</td>
					        </tr>
					        <tr>
					          <td height="4"></td>
					        </tr>
					        <tr>
					          <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr>
					                <td width="144" bgcolor="#00708B">&nbsp;</td>
					                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
					              </tr>
					            </table></td>
					        </tr>
     				 	</table>
     				</td>
				  </tr>
			</table>
          </td>
      </tr>
    </table>
</div></div>
<%=Globals.getGoogleAnalytics()%>
