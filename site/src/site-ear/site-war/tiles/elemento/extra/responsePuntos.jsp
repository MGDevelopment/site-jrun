<%@ page import="com.tmk.kernel.Globals,
				com.tmk.src.fidelizacion.PuntajeWrapper,
                 com.tmk.kernel.Convert,
                 com.tmk.src.fidelizacion.VencimientoPuntos,
                 com.tmk.controllers.fidelizacion.ConsultaDePuntos"%>
<%
	PuntajeWrapper puntajeWrapper = (PuntajeWrapper)session.getAttribute(ConsultaDePuntos.CONSULTA_PUNTOS_WRAPPER);
	String mensajeExtra = Convert.toString(session.getAttribute(ConsultaDePuntos.MENSAJE_USUARIO), null);
%>
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
	 	   <% String pageMenu = "/tiles/elemento/extra/menu.jsp?mnuActivo=5";%>
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
            			    	<%  if (mensajeExtra != null) { %>
										<table align="center" cellpading="0" cellspacing="0">
											<tr>
												<td width="35"><img src="/imagenes/miCuenta/baliza.gif"></td>
												<td><div class="FTtit01"><%=mensajeExtra%></div></td>
											</tr>
										</table>
									<%
											session.setAttribute(ConsultaDePuntos.MENSAJE_USUARIO, null);
									} %>
									<%

									if (puntajeWrapper != null) { %>
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
					                    <tr>
					                      <td><%if(puntajeWrapper.esGold()){%><img src="/imagenes/fidelizacion/clienteGold.jpg" ><%}else{%><img src="/imagenes/fidelizacion/titulo_04.gif" width="222" height="27"><%}%><br>&nbsp;</td>
					                    </tr>
					                    <tr>
					                      <td class="punteonargris">
					                      	<table width="100%" align="center" cellspacing="0" cellpadding="3" border="0">
												<%if(!puntajeWrapper.esGold()){%>
												<tr>
													<td  class="celeste" ><span class="arial12"><b>PUNTOS ACUMULADOS</b></span></td>
												</tr>
												<%}%>
												<tr>
													<td style="font-size: 12px;">
														Actualice su correo electrónico haciendo <a href="/fidelizacion/panel/actualizacionEMail.jsp" class="celestelink"><strong <%=(puntajeWrapper.esGold())?"style='color:#DD920E'":""%>>click aqu&iacute;</strong></a>
													</td>
												</tr>
												<tr>
													<td >

														<table align="center" cellspacing="0" cellpadding="3" border="0" class="celdacatalogo">
															<% if (puntajeWrapper.getNombreSocio() != null || puntajeWrapper.getApellidoSocio() != null) { %>
															<tr>
																<td width="20">&nbsp;</td>
																<td style="font-size: 12px;">Nombre del Socio:</td>
																<td width="10">&nbsp;</td>
																<td style="font-size: 12px; font-weight: bold;"><%=Convert.nombreCompleto(puntajeWrapper.getNombreSocio(), puntajeWrapper.getApellidoSocio())%></td>
															</tr>
															<% } %>
															<tr>
																<td>
																</td>
																<td style="font-size: 12px;">
																	Correo electronico:
																</td>
																<td>
																</td>
																<td style="font-size: 12px;">
																	 <%=(puntajeWrapper.getEMail()!= null)?
																	 puntajeWrapper.getEMail().toLowerCase():"No tenemos registrado su correo electrónico."
																	 %>
																</td>
															</tr>

															<tr>
																<td>&nbsp;</td>
																<td style="font-size: 12px;">Puntaje:</td>
																<td>&nbsp;</td>
																<td style="font-size: 15px; font-weight: bold;"><%=Convert.pluralCompleto(puntajeWrapper.getPuntos(), "punto")%></td>
															</tr>
															<% if (puntajeWrapper.getNumeroDeTarjeta() != null) { %>
															<tr>
																<td>&nbsp;</td>
																<td style="font-size: 12px;">Tarjeta:</td>
																<td>&nbsp;</td>
																<td style="font-size: 12px;"><%=Convert.toString(puntajeWrapper.getNumeroDeTarjeta())%></td>
															</tr>
															<% } %>
															<tr>
																<td>&nbsp;</td>
																<td style="font-size: 12px;">Es titular:</td>
																<td>&nbsp;</td>
																<td style="font-size: 12px;"><%=Convert.toString(puntajeWrapper.getEsTitular())%></td>
															</tr>
															<%  VencimientoPuntos vencimientoPuntos[] = puntajeWrapper.getVencimientosPuntos();
															if (vencimientoPuntos != null) {
																for (int i = 0; i < vencimientoPuntos.length; i++) {
																	VencimientoPuntos item = vencimientoPuntos[i];
															%>
															<tr>
																<td>&nbsp;</td>
																<td style="font-size: 12px;">Vencen el <%= Convert.toString(item.fecha) %>:</td>
																<td>&nbsp;</td>
																<td style="font-size: 12px;"><%=Convert.pluralCompleto(item.puntos, "punto")%></td>
															</tr>
															<%      }
																session.setAttribute(ConsultaDePuntos.CONSULTA_PUNTOS_WRAPPER, null);
															} %>

														</table>


													</td>
												</tr>
												<tr>
													<td align="right">
														<a  href="/fidelizacion/panel/puntos.jsp" style="text-decoration:none;"><b class="arial12celeste" <%=(puntajeWrapper.esGold())?"style='color:#DD920E;font-weight:800;text-decoration:none;'":""%>>VOLVER</b></a>
													</td>
												</tr>
										</table>
				                      </td>
				                    </tr>
				                  </table>
				                  <%  } %>
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