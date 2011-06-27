<%@ page import="com.tmk.kernel.Globals, com.tmk.controllers.MainHelper, com.tmk.kernel.TmkLogger"%>
<%String page = request.getParameter("page");%>
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
   	   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=6";%>
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
                      <td height="40" class="punteonargris"><img src="/imagenes/fidelizacion/titulo_06.gif" width="245" height="26"></td>
                    </tr>
                    <tr>
                      <td class="punteonargris"><p><span class="extranaranja">&iquest;Tiene
                          un costo participar en el programa?</span><br>
                          <span class="arial12">No, el programa eXtra! no tiene
                          ning&uacute;n cargo, la participaci&oacute;n es totalmente
                          gratuita. <br>
                          Si la compra es de $26,40, &iquest;cu&aacute;ntos puntos
                          suma en mi cuenta? <br>
                          Los decimales no suman puntos sino que se redondean
                          al entero mas cercano. Ejemplos:<br>
                          $26,40=$26= 78 puntos <br>
                          $26,50=$27= 81 puntos <br>
                          $26,60=$27= 81 puntos</span></p>
                        <p class="arial12"><span class="extranaranja">&iquest;C&oacute;mo
                          me mantengo al tanto de todas las novedades?</span><br>
                          Actualizando peri&oacute;dicamente los datos en la <a href="/fidelizacion/panel/actualizacionEMail.jsp" class="arial12celeste">secci&oacute;n
                          habilitada</a>.</p>
                        <p class="arial12"><span class="extranaranja">&iquest;C&oacute;mo
                          puedo saber cu&aacute;nto puntos tengo?</span><br>
                          Las <a href="/extra/index.jsp?seccionEXtra=5" class="arial12celeste">consultas de puntos</a> se
                          pueden realizar en todas las sucursales de Yenny/El
                          Ateneo o llamando al 0810-33-EXTRA. </p>
                        <p class="arial12"><span class="extranaranja">&iquest;Las
                          tarjetas adicionales acumulan puntos?</span> <br>
                          Si, todas las tarjetas adicionales suman puntos para
                          los titulares de la cuenta. </p>
                        <p class="arial12"><span class="extranaranja">&iquest;Cu&aacute;ndo
                          vencen los puntos?</span><br>
                          Los puntos tienen validez durante el a&ntilde;o calendario
                          en que fueron acumulados m&aacute;s un a&ntilde;o calendario
                          completo. </p>
                        <p class="arial12"><span class="extranaranja">&iquest;C&oacute;mo
                          debo hacer para cambiar mis puntos por regalos? </span><br>
                          Debe presentar su DNI en cualquier sucursal y elegir
                          el <a href="/extra/index.jsp?seccionEXtra=3" class="arial12celeste">premio</a>, que es entregado
                          en el momento. </p>
                        <p class="arial12"><span class="extranaranja">&iquest;Cu&aacute;ntas
                          veces puedo canjear el mismo regalo? </span><br>
                          Todas las veces que desee, siempre y cuando tenga los
                          <a href="/extra/index.jsp?seccionEXtra=5" class="arial12celeste">puntos necesarios</a> para hacerlo.
                        </p>
                        <p class="arial12"><span class="extranaranja">&iquest;Qu&eacute;
                          sucede si el regalo no est&aacute; disponible en la
                          sucursal? </span><br>
                          Si no hay stock del <a href="/extra/index.jsp?seccionEXtra=3" class="arial12celeste">regalo buscado</a>,
                          puede ir a otra sucursal que tenga stock de ese producto
                          o esperar hasta que haya stock en la sucursal que habitualmente
                          concurre.</p></td>
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
					          <td>
					          <table width="100%" border="0" cellspacing="0" cellpadding="0">
					              <tr>
					                <td width="144" bgcolor="#00708B">&nbsp;</td>
					                <td bgcolor="#9C928D" align="left"><a href="#top"><img src="/imagenes/fidelizacion/marco_16.gif" width="101" height="22" border="0"></a></td>
					              </tr>
					            </table>
					          </td>
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