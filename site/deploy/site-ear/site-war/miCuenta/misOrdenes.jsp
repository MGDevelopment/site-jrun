<%@ page import="javax.naming.InitialContext,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.DBUtil,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.EstadoOrdenDAO,
                 com.tmk.kernel.Globals,
                 java.util.*,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>


<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");

	//if(session.getAttribute("Registracion.socioPK") == null) {
		//session.setAttribute("URL_REDIRECT", "/miCuenta/?seccionMiCuenta=14");
%>
		<!--  jsp:forward page="/miCuenta" /-->
<%	//} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		//session.setAttribute(MainHelper.URL_REDIRECT,  "/miCuenta/?seccionMiCuenta=14");
%>
		<%--  jsp:forward page="<%=MainHelper.PAGE_REGISTRO_SOCIO_CADENA%>" / --%>
<%	//}


	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");

%>


<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">

             <%	if (socioPK != null) { %>
				<tr>
					<td valign="top"><table width="140" border="0" cellpadding="0" cellspacing="0" class="preguntastabla">
            			<tr>
							  <td align="left" class="preguntasceldas"><a href="/TerminarSesion" class="FAyuda">DESCONECTARSE</a></td>
		                </tr>
    		        </table></td>
	    	   	</tr>
    	   		<%}%>
            	<jsp:include page="/miCuenta/left.jsp"/>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                 <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                          <tr>
                            <td height="20" valign="top"><div class="FTtit01">ORDENES EN PROCESO :</div>                              </td>
                          </tr>

<!-- ORDENES EN PROCESO -->
                <%  Iterator ordenesEnProceso = ordenLocalHome.findOrdenesEnProceso(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();%>
				<%  if (ordenesEnProceso.hasNext()) {
						while (ordenesEnProceso.hasNext()) {
						OrdenLocal ordenLocal = (OrdenLocal)ordenesEnProceso.next();
				%>
					  	 <tr>
							<td valign="bottom" class="Ftexto02" style="padding-top:10px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
	  		 			     <tr>
								<td class="celdamodulodomicilio2"><table class="Ftexto02" width="356" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="39" valign="middle"><span class="FTtit01">Fecha: </span><%= Convert.toStringLargo(ordenLocal.getFECHA()) %><br />
											<span class="FTtit01">N&uacute;mero de Orden:</span> <a href="/compra/detalleOrden.jsp?idOrden=<%=ordenLocal.getID_ORDEN()%>" class="Flink02"><%=Convert.toString(ordenLocal.getID_ORDEN())%></a><br />
											<span class="FTtit01">Estado: </span><span class="Ftextorojo"><%= EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getNombre() %></span>

										</td>


									</tr>
									<tr>
										<td valign="middle" style="padding-top:5px"><p><span class="foncarrito02">PRECIO: <%= Contenido.precioToString(ordenLocal.getTOTAL().doubleValue()) %></span></p></td>
									</tr>
								</table></td>
							  </tr>
						    </table></td>
					     </tr>

		         <%
		          	    }
				   } else {
			 	 %>
				  	          <tr>
		                	      <td><table width="366" border="0" cellspacing="0" cellpadding="0">
		                    		 	 <tr>
				                           <td valign="bottom" class="Ftexto02">NO HAY ORDENES EN PROCESO AL DIA DE HOY</td>
				                         </tr>
		        		          </table></td>
		          		      </tr>
	             <%
	             	}
				 %>
<!-- ORDENES EN PROCESO -->
                          <tr>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0" class="tabladomicilios">
                          <tr>
                            <td height="20" valign="top"><div class="FTtit01">ORDENES PROCESADAS :</div></td>
                          </tr>

<!-- ORDENES PROCESADAS -->
                <% Iterator ordenesProcesadas = ordenLocalHome.findOrdenesProcesadas(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator(); %>
				<% if (ordenesProcesadas.hasNext()) {
					    while (ordenesProcesadas.hasNext()) {
							OrdenLocal ordenLocal = (OrdenLocal)ordenesProcesadas.next();
				%>
 					  <tr>
						<td valign="bottom" class="Ftexto02" style="padding-top:10px"><table width="366" border="0" align="left" cellpadding="0" cellspacing="0">
				 			<tr>
								<td class="celdamodulodomicilio2"><table class="Ftexto02" width="356" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="39" valign="middle"><span class="FTtit01">Fecha: </span><%=Convert.toStringLargo(ordenLocal.getFECHA()) %><br />
											<span class="FTtit01">N&uacute;mero de Orden:</span> <a href="/compra/detalleOrden.jsp?idOrden=<%=ordenLocal.getID_ORDEN()%>" class="Flink02"><%=Convert.toString(ordenLocal.getID_ORDEN())%></a><br />
											<span class="FTtit01">Estado: </span><span class="Ftextorojo"><%= EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getNombre() %></span>
									

										</td>
					</tr>
									<tr>
										<td valign="middle" style="padding-top:5px"><p><span class="foncarrito02">PRECIO: <%= Contenido.precioToString(ordenLocal.getTOTAL().doubleValue()) %></span></p></td>
									</tr>
								</table></td>

							</tr>
						</table></td>
					  </tr>
  	            <%
					  }
				  } else {
				%>
		          	      <tr>
                             <td><table width="366" border="0" cellspacing="0" cellpadding="0">
                               <tr>
                                 <td valign="bottom" class="Ftexto02">NO HAY ORDENES PROCESADAS AL DIA DE HOY.</td>
                               </tr>
                             </table></td>
                          </tr>

                <%
                  }
				%>
<!-- ORDENES PROCESADAS -->
						  <tr>
                            <td>&nbsp;</td>
                          </tr>
                        </table></td>
                      </tr>
                    </table>
                    </td>
                  </tr>

                </table></td>
              </tr>
              <tr>
                <td>&nbsp;</td>
              </tr>
            </table></td>

            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td class="Ftexto06">USTED PUEDE VER AQU&Iacute; TODAS SUS &Oacute;RDENES SEPARADAS SEG&Uacute;N HAYAN SIDO O NO ENTREGADAS. <br />
                            TAMBI&Eacute;N FIGURAN AQUELLAS QUE FUERON ANULADAS POR CUALQUIER MOTIVO.</td>
                        </tr>

                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>