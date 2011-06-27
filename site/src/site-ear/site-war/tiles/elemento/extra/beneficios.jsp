<%@page import="com.tmk.controllers.MainHelper"%>
<div id="seccionTematika">
	<div style="width:830px;  margin:auto; margin-top:80px; " >

		<table width="740" border="0" align="center" cellpadding="0" cellspacing="0" >
		  <tr>
		    <td>
		    	<br>
		    </td>
		  </tr>
		  <tr>
		    <td>
		       <!-- Menu -->
   			   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=2";%>
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
								<table width="100%" border="0" cellpadding="0" cellspacing="0" class="celeste">
		                          <tr>
		                            <td><strong>Eleg&iacute; tu Ciudad y descubr&iacute;
		                              los <font color="#F7B742">Beneficios</font> que
		                              pensamos especialmente <br>
		                              para vos.</strong></td>
		                          </tr>
		                        </table></td>
		                    </tr>
		                    <tr>
		                      <td class="punteonargris">

								<jsp:include page="<%=MainHelper.RES_PAGE_EXTRA_BENEFICIOS%>"/>
		                      </td>
		                    </tr>
		                    <tr>
		                      <td class="punteonargris"><span class="arial12">Los Beneficios
		                        anteriormente detallados, no son combinables ni acumulables
		                        con otras promociones vigentes. Si quer&eacute;s conocer
		                        m&aacute;s info acerca de cada uno de ellos, solicit&aacute;
		                        el nuevo cat&aacute;logo de beneficios en la sucursal
		                        m&aacute;s cercana a tu domicilio.</span></td>
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
</div>
</div>