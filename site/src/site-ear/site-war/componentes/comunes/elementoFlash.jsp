<%@ page import="com.tmk.kernel.Convert"%>

<table width="100%" cellspacing="0" cellpadding="2">
	<tr>
		<td align="center">
			<%@ include file="/componentes/comunes/flash.jsp" %>
		</td>
	</tr>
	<%if (flash.getTexto() != null) {%>
	<tr>
		<td  align="center">
		<b><%=Convert.toString(flash.getTexto())%></b><br>
		</td>
	</tr>
	<%}%>
</table>
