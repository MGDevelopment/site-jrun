<%@page import="com.tmk.kernel.Globals"%>
<table border="0">
	<tr>
		<td style="padding-top: 30px;">
			<jsp:include flush="true" page="/grupos/quid/quidActual.html"></jsp:include>
		</td>
		<td class="Gbarraderecha" width="155" valign="top">
               <% String urlInstitucionalRight = "/tiles/elemento/institucional/institucionalRight.jsp?idSeccion=" + Globals.SECCION_HOME;%>
			  <jsp:include page="<%=urlInstitucionalRight%>"/>
		</td>
	</tr>
</table>
