<%@ page import="com.tmk.kernel.MesDAO,
                 java.sql.Timestamp,
                 java.text.SimpleDateFormat,
                 com.tmk.kernel.Pair,
                 com.tmk.kernel.Convert,
                 java.util.Date,
                 com.tmk.kernel.DBUtil"%>
<table width="500" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
	<tr>
		<td align="center"><i>Fecha</i></td>
		<td align="center"><i>Cantidad de Visitas</i></td>
		<td align="center"><i>Ordenes Válidas</i></td>
	</tr>
<%
	for (int i = 0; i < resultados.size(); i++) {
		DBUtil.Visita visita = (DBUtil.Visita)resultados.get(i);
		String fechaStr = (mostrarEnMeses)
		        ? (MesDAO.getMes(visita.fecha.getMonth() + 1).getNombre() + " " + (1900 + visita.fecha.getYear()))
		        : Convert.toStringLargo(visita.fecha);
		Date esteMomento = new Date();
		boolean remarcar =
		        ((mostrarEnMeses) && (visita.fecha.getMonth() == esteMomento.getMonth())) ||
		        (!mostrarEnMeses) && (visita.fecha.getHours() == esteMomento.getHours());

%>
	<tr>
		<td width="60%" align="center"><%=(remarcar) ? "<b>" : ""%><%=fechaStr%><%=(remarcar) ? "</b>" : ""%></td>
		<td align="right"><%=Convert.toString(visita.cantidadDeVisitas)%></td>
		<td align="right"><%=Convert.toString(visita.cantidadDeOrdenes)%></td>
	</tr>
<%
	}
%>
</table>
<% out.flush(); %>
