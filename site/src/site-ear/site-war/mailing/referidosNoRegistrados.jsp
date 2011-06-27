<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferidosNoRegistradosDaemon
                 "%>

<html>
	<body>
		<b>Reporte de Referidos No Registrados</b><br><br>
<%
	Vector referidosNoRegistrados = ReporteDeReferidosNoRegistradosDaemon.referidosNoRegistrados;
	//if (referidosNoRegistrados == null || referidosNoRegistrados.size()==0) {
    if(referidosNoRegistrados.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {

	%>
		<div Style="font-family:verdana; font-size:10">nota: Los datos de referidos que se muestran han sido indicados por socios referentes.</div><br>
		<table align="left" width="640" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td width="120">
					<b>Fecha</b>
				</td>
				<td width="220">
					<b>eMail</b>
				</td>
                <td width="150">
					<b>Apellido</b>
				</td>
				<td width="150">
					<b>Nombre</b>
				</td>
    	    </tr>

<%
		String fecha ="";
		for (int i = 0; i < referidosNoRegistrados.size(); i++) {
%>
            <tr>
				<td>
				<%  String fechaRep = Convert.toString(((Vector)referidosNoRegistrados.get(i)).get(0),"");
					if (!fecha.equals(fechaRep)) {
				%>
				<%= fechaRep%>
				<%
					}
					fecha = fechaRep;
				%>
				</td>
                <td>
				<%= Convert.toString(((Vector)referidosNoRegistrados.get(i)).get(1), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosNoRegistrados.get(i)).get(2), "") %>
				</td>
				<td>
				<%= Convert.toString(((Vector)referidosNoRegistrados.get(i)).get(3), "") %>
				</td>
    	    </tr>
<% 	    } %>
        </table>

<%
	referidosNoRegistrados.clear();
	referidosNoRegistrados = null;
	} %>




	</body>
</html>
