<%@ page import="com.tmk.orden.*,
                 java.util.*,
                 com.tmk.setup.*,
                 com.tmk.kernel.*"%>

<%
/*	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	Iterator ordenesFraudulentas = ordenLocalHome.findOrdenesFraudulentas().iterator();
	Iterator ordenesRetrasadas = ordenLocalHome.findOrdenesRetrasadas().iterator();
	Iterator ordenesDelDia = ordenLocalHome.findOrdenesDelDia().iterator();
	Iterator ordenesParecidas = ordenLocalHome.findOrdenesParecidas().iterator();*/
%>

<%  // Que no muestre esto siempre sino en contadas veces
	Date ahora = new Date();
	if (ahora.getHours() >= 21) { %>

	<b>Promoción vigente:</b><br>
	<%@include file="/leyendas/promociones.htm"%><br><br>

	<!--%@include file="/mailing/reglas.jsp"%><br-->

	<%@include file="/mailing/visitas.jsp"%><br>

<%  } %>

<%@include file="/mailing/promocionesAVencer.jsp"%><br>
<% out.flush(); %>


<%//@include file="/mailing/estadisticas.jsp"%><br>
<%// out.flush(); %>


<%@include file="/mailing/estadisticasDiarias.jsp"%><br>
<% out.flush(); %>

<br>


<table width="500">
	<tr>
		<td>
			<b>Tapas Falladas</b><br>
			<%  java.util.Vector tapasFalladas = ImageServer.getTapasFalladas();
				if (tapasFalladas.isEmpty()) { %>
				No se registraron tapas con problemas
			<%  } else {
			%>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<%
					for (int tf = 0; tf < tapasFalladas.size(); tf++) {
						String nombreTapa = tapasFalladas.get(tf).toString();
			%>

				<tr>
					<td width="70%">&nbsp;<%= nombreTapa %></td>
				</tr>
			<%
					}
			%>
			</table>
			<%
				}
			%>
		</td>
	</tr>
</table>
