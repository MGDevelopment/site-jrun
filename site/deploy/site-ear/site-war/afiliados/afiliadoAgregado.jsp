<%@ page import="com.tmk.kernel.Globals"%>
 
			<td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-afiliados.gif" alt="Programa de afiliados" width="219" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="370" border="0" cellspacing="0" cellpadding="0">

                        <tr>
                          <td valign="bottom" class="Ftexto02"><table width="370" border="0" cellspacing="0" cellpadding="0">
                              <tr>
                                <td width="370" height="20" valign="top" class="Ftexto02"><span class="FTtit01">GRACIAS POR HABERNOS ELEGIDO!</span><br />
                                    <br />
                                      El afiliado <span class="Ftextorojo">&quot;<%=request.getParameter("RAZON_SOCIAL")%>&quot;</span> ha sido agregado! <br />

  Usted recibir&aacute; un mail que confirmar&aacute; su alta. </td>
                              </tr>

                          </table></td>
                        </tr>
                    </table></td>
                  </tr>

                </table></td>
			</tr>
			<tr>
                <!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/componentes/comunes/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
            
                
                