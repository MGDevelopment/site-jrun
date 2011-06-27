<%@ page import="com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Globals " %>

<%
   	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
%>

<div style="margin-top: 10px;">	
	<div class="compraWrapper2">
	<table width="640" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td class="Gcentro" width="422"><table width="386" border="0" align="center" cellpadding="0" cellspacing="0">
			  <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/miCuenta/t-micuenta.gif" alt="Mi cuenta" width="139" height="12" /></td>
                  </tr>
                  <tr>
                    <td class="moduloayuda"><table width="366" border="0" cellspacing="0" cellpadding="0">
                      <tr>
                        <td valign="bottom" class="Ftexto02"><table width="366" border="0" cellpadding="0" cellspacing="0">

                          <tr>
                            <td height="20" valign="top"><div align="center">Gracias por participar del programa de Referidos de Tematika.com.</div></td>
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
            	String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + Globals.SECCION_HOME;
            	%>
            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
                </td>
                 <!-- ultimos visitados -->
              </tr>
            </table></td>
          </tr>
        </table>
	</div>
</div>        
<%=Globals.getGoogleAnalytics()%>