<%@page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="url" scope="page" ignore="true" classname="java.lang.String"/>

<table  border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
          <!-- Left AYUDA -->
    		<jsp:include page="/general/leftAyudaRedi.htm"/>
          <!-- Left AYUDA -->

            <td class="Gcentro" width="422"><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
              <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-ayuda.gif" alt="Ayuda" width="118" height="12" /></td>
                  </tr>

                  <tr>
					<jsp:include page="<%=url%>"/>
                  </tr>

                </table></td>
              </tr>

            </table>
    </td>
     <td class="Gbarraderecha" width="155">
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
			</td>
</tr>
</table>