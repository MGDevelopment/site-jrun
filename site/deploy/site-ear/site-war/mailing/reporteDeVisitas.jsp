<%@ page import="com.tmk.kernel.DBUtil,
                 com.tmk.kernel.Convert,
                 java.util.Date,
                 java.util.Vector"%>

<%// com.tmk.controllers.alianza.EstadisticaVisitas.flush(); %>

<html>
	<body>
		<b>Visitas de las últimas 24 horas</b><br>
		<table width="500" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td align="center"><i>Fecha</i></td>
				<td align="center"><i>Cantidad de Visitas</i></td>
			</tr>
			<tr>
				<td width="60%" align="center"><%=Convert.toStringLargo(new Date())%></td>
				<td align="right"><%=Convert.toString(DBUtil.cantidadDeVisitasDesdeUnDiaAtras())%></td>
			</tr>
		</table>
	</body>
</html>
