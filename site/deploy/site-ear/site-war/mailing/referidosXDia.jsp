<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferidosXDiaDaemon"%>

<html>
	<body>
		<b>Reporte de Referidos</b><br><br>
<%
	Vector referidosXDia = ReporteDeReferidosXDiaDaemon.referidosXDia;
	//if (referidosXDia == null) {
    if(referidosXDia.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {
		Calendar fecha = Calendar.getInstance();
		fecha.roll(Calendar.DATE, -1);
	%>
		<div style="font-size:11px;font-family:verdana">Referidos enviados el día <%=Convert.toString(fecha.getTime())%>.<p></div>
		<table align="left" width="350" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="280">
					<B>Referente</B>
				</td>
                <td>
					<B>Cantidad</B>
				</td>

    	    </tr>
<%	for (int i = 0; i <  referidosXDia.size(); i++) {
%>
            <tr>
				<td>
				<%= Convert.toString(((Vector)referidosXDia.get(i)).get(0), "") %>
				</td>
                <td align="right">
				<%= Convert.toString(((Vector)referidosXDia.get(i)).get(1), "") %>
				</td>
    	    </tr>
<% 	} %>
        </table>

<%
	referidosXDia.clear();
	referidosXDia = null;
	} %>
	</body>
</html>
