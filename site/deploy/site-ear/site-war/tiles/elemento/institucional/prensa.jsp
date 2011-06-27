<%@ page import="com.tmk.kernel.Globals"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="page" scope="page" ignore="true" classname="java.lang.String"/>
<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
            	<tr>
                	<td width="50" class="titulosceldas"><img src="/imagenes/inicio/t-prensa.gif" alt="Prensa" width="124" height="12" /></td>
                </tr>
                <tr>
                	<td class="moduloayuda">
                		<table width="366" border="0" cellspacing="0" cellpadding="0">
		                  <jsp:include page="<%=page%>"/>
        	           </table>
        	        </td>
				</tr>
			</table>
        </td>
        <td class="Gbarraderecha" width="155">
                <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
				  <jsp:include page="<%=urlInstitucionalRight%>"/>
			</td>
	</tr>
</table>