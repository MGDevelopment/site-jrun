<%@ page import="com.tmk.kernel.Convert,
                 java.util.*,
                 com.tmk.referido.ReporteDeReferenteBeneficioDaemon,
                 com.tmk.referido.ReporteReferido"%>

<html>
	<body>
		<b>Reporte de Beneficio de Referentes</b><br><br>
<%
	Vector referenteBeneficio = ReporteDeReferenteBeneficioDaemon.referenteBeneficio;
	//Vector referenteBeneficio = ReporteReferido.referenteBeneficio();

	if (referenteBeneficio == null || referenteBeneficio.size()==0) {
    //if(referenteBeneficio.isEmpty()){
%>
				<p>&nbsp;No se encontraron resultados.
<%  } else {

	%>
		<div Style="font-family:verdana; font-size:10">Beneficio x referente y sus referidos asociados.</div><br>
		<table align="left" width="760" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
		<tr bgcolor = "#E1E1E3">
			<td width="180">
				<b>eMail Referente</b>
			</td>
			<td width="120">
				<b>Apellido</b>
			</td>
			<td width="120">
				<b>Nombre</b>
			</td>
			<td width="160">
				<b>Beneficio</b>
			</td>
			<td width="180">
				<b>eMail Referido</b>
			</td>
		</tr>

<%
		for (int i = 0; i < referenteBeneficio.size(); i++) {

			Vector fila = (Vector)referenteBeneficio.get(i);
%>
			<tr>
<%

			for (int j = 0; j <fila.size(); j++) {
%>
				<td>
			<%= (fila.get(j)==null)?"":fila.get(j)%>
				</td>

<% 	    } %>
    </tr>
<%
		}
		referenteBeneficio.clear();
			referenteBeneficio = null;

%>
		</table>
<%
	}
%>
	</body>
</html>
