<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert"
%>

<%
String unidadNegocio = Convert.toString(request.getParameter("unegocio"), "ateneo");
String nombreNegocio = null;
String tipoNegocio = null;
String nombreCorto = null;

if(unidadNegocio.equals("ateneo")){
	 nombreNegocio = "Editorial El Ateneo";
	 tipoNegocio = "editorial";
	 nombreCorto = "el ateneo";
}else{
	 nombreNegocio = "Librería Yenny";
	 tipoNegocio = "librería";
	 nombreCorto = "yenny";}

%>
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
              int idSucursal = Convert.toNumber(request.getParameter("sucursal"),30);
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
            </table></td>
<td class="Gbarraderecha" width="155" valign="top">
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
			</td>
          </tr>

        </table>