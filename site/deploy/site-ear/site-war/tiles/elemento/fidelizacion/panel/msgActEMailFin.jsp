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
					                            <td><strong>Bienvenido al mundo de novedades <span class="extranaranja">eXtra!</span></strong></td>
					                          </tr>
					                        </table></td>
					                    </tr>
					                    <tr>
					                      <td class="punteonargris"><p class="arial12">El proceso
					                          de actualizaci&oacute;n de datos ha concluido y los
					                          200 puntos eXtra! han sido cargados en tu cuenta.*</p>
					                        <p class="arial12">De aqu&iacute; en m&aacute;s comenzar&aacute;s
					                          a recibir nuestra informaci&oacute;n v&iacute;a e-mail.
					                          Recuerda actualizar los datos peri&oacute;dicamente
					                          para mantenerte al tanto de cada una de nuestras acciones
					                          exclusivas.</p></td>
					                    </tr>
					                    <tr>
					                      <td class="punteonargris"><p>&nbsp;</p>
					                        <p><span class="txtgris14">* La acumulaci&oacute;n de
					                          los 200 puntos se realizar&aacute; s&oacute;lo en la
					                          primera actualizaci&oacute;n de datos.</br>
					                          Para visualizar los puntos cerra sesion y volve a loguearte.
					                          </span><span class="Ftexto01"></span></p></td>
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
</div>
</div>
<%=Globals.getGoogleAnalytics()%>
