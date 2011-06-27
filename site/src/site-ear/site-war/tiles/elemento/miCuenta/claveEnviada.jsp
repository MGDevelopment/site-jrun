<%--
<%@page import="com.tmk.kernel.Globals"%>
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="140" border="0" align="left" cellpadding="0" cellspacing="0">
              <jsp:include page="/miCuenta/left.jsp"/>
            </table></td>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda"><div align="left"><span class="Ftextorojo">Su clave de acceso fue enviada a <%= request.getParameter("LOGIN") %></span></div></td>
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
        </table>
--%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.kernel.Convert"%>
<%String LOGIN = Convert.toString(request.getParameter("LOGIN"), ""); %>
<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
			<div class="cProcTit" style="margin-top: 0pt;"><span>CLAVE ENVIADA:</span></div>
	       <div class="cProcFor-wrapper2 cProcForms2" style="border-bottom: none">         		
         		<div style="margin-bottom: 0pt;width:560px;text-align:center">
         			<label class="error" id="divMensajeLogin">
						Su clave de acceso fue enviada a <%= request.getParameter("LOGIN") %>	
         			</label>	
     			</div>
     		</div>
	</div>	
</div>