<%@ page import="com.tmk.kernel.Globals" %>
	<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
             <tr>
                <td align="left" valign="top"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
                  <tr>
                    <td align="left" valign="top">
                    <!-- ARBOL -->
                    </td>
                  </tr>
                  <tr>
                    <%--
            			String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + Globals.SECCION_HOME;
            	  	%>
                	<jsp:include page="<%=urlInstitucionalLeft%>"/--%>
                  </tr>
                </table></td>
              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-pedidoespecial.gif" alt="Pedido especial" width="173" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" ><span class="Ftextorojo">Se ha enviado un mensaje de confirmaci&oacute;n a su casilla de email.</span></td>
                      </tr>


                    </table></td>
                  </tr>

                </table></td>
              </tr>
               <tr>
				<!-- ultimos visitados -->
                <td>
                <%
            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>
            </table></td>
            <td class="Gbarraderecha" width="162"><table width="162" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table></td>
          </tr>
          <%-- tr>
            <td colspan="3"><div align="center">
              <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				 <jsp:include page="<%=urlInstitucional%>"/></td>
            </div></td>
          </tr--%>
        </table>

<%=Globals.getGoogleAnalyticsSSL()%>

