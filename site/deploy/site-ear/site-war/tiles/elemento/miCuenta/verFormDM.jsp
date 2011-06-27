<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.util.ShortCuts,
                 com.tmk.socio.TarjetaSocioLocalHome,
                 com.tmk.kernel.DBUtil,
                 java.util.Iterator,
                 com.tmk.socio.TarjetaSocioLocal,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Seguridad,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper" %>
<%--
                 //com.tmk.socio.SocioLocal,
--%>

<%	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/verFormDM.jsp?idOrden=" + idOrden);
		session.setAttribute("Registracion.feedback", "Para acceder los pagos con Dinero Mail debes inciar sesión con tu usuario y contraseña.");
%>
		<jsp:forward page="/miCuenta" />
<%	} 


%>
		

<%= Globals.title("Pagos con Dinero Mail") %>

<script src="/js/Validation.js" type="text/javascript"></script>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center"> 
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <%if (socioPK != null) { %>
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
                    <td class="moduloayuda"><table  class="Ftexto02" width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td>
                            <%
					       		String frmDM = "/compra/frmDM.jsp?idOrden=" + idOrden;
					       	%>
					       	<jsp:include page="<%=frmDM%>"/>
							</td>
                        </tr>
                    </table>                    
                    </td>
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
            <td class="Gbarraderecha" width="155"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
                  <tr>
                    <td><table border="0" align="center" cellpadding="0" cellspacing="0">
                        <tr>
                          <td><span class="Ftexto02">En esta pantalla podes imprimir los cupones de pago</span></td>
                        </tr>
                    </table></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table>
<%=Globals.getGoogleAnalyticsSSL()%>	