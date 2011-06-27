<%@ page import="com.tmk.kernel.Globals"%>
		<table width="540" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>

            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-vcorporativas.gif" alt="Ventas Corporativas" width="153" height="12" /></td>
                  </tr>

                  <tr>
                    <td class="moduloayuda" align="left"><span class="Ftextorojo">Su formulario ha sido   enviado. Pronto nos pondremos en contacto
                      con Ud.</span></td>
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
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
              </tr>
            </table></td>
          </tr>

        </table>
