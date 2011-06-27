<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!-- **** SECCION TEMATIKA **** -->
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="page" scope="request" ignore="true" classname="java.lang.String"/>

<div id="seccionTematika2">		
	<div style="float:left;width:670px;margin-left:65px;">
		<%if(page!=null){ %>
			<table align="center" style="background-color: #F3F4F5;">
				<tr>
                	<td width="50" class="titulosceldas"><img height="12" width="124" alt="Prensa" src="/imagenes/inicio/t-prensa.gif"></td>
                </tr>
		<%} %>	
			<tiles:insert attribute="body"/>
		<%if(page!=null){ %>
			</table>
		<%} %>				
	</div>
</div>