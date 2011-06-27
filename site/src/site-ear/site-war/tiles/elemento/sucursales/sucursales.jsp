<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert"
%>
<br>
<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
          	<!-- menu de la izquierda de las sucursales -->
            <td  class="Gbarraizquierda"width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>

               <jsp:include page="/general/leftSucursalesRediseno.htm"/>

              </tr>
            </table></td>
            <td class="Gcentro" width="422"><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
           <tr>
             <%
              int idSucursal = Convert.toNumber(request.getParameter("sucursal"),205);
              String urlSucursal="/general/sucursales/" + idSucursal + "_sucursal.htm";
             %>
              <jsp:include page="<%=urlSucursal%>"/>
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
            </table>
            </td>
			<td class="Gbarraderecha" width="155" valign="top">
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME +"&esSucursal=true";%>
				<jsp:include page="<%=urlInstitucionalRight%>"/>
				<table>
					<tr>
						<td class="" width="162" align="left">
				            <!-- top -->
				            	<% String topPage = "/contenidosEstaticos/homes/top" + Globals.SECCION_HOME + ".html"; %>
				            	<jsp:include page="<%=topPage%>"/>
				            <!-- top -->
           				</td>
           			</tr>
           		</table>
			</td>						
         </tr>
	</table>