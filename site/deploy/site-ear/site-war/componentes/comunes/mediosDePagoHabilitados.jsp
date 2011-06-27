<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.MedioDeCobroDAO,
                 com.tmk.kernel.Convert"%>
<table width="100%" border="0" style="border: solid 1px; border-collapse: collapse; border-color:lightgray">

	<tr>

		
		<%
			for (int mp = 0; mp < Globals.MEDIOS_DE_COBRO.length; mp++) {
			MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[mp];
			// Solo habilitados y NO fax porque realmente no es un medio de pago sino que lo es la tarjeta
			if (medioDeCobroDAO.estaHabilitado() && (!medioDeCobroDAO.esFax()) && (!medioDeCobroDAO.getId().equals("VNA")) && (!medioDeCobroDAO.getId().equals("MNA")) && (!medioDeCobroDAO.getId().equals("ARIO")) && (!medioDeCobroDAO.getId().equals("VRIO")) ) {
		%>

			<td align="center" width="15%">
			<img src="/imagenes/medioDeCobro<%=medioDeCobroDAO.getId()%>.gif" alt="<%= medioDeCobroDAO.getNombre() %>"><br>
			<font style="font-size: 9px;"><%= (medioDeCobroDAO.esHomeBanking())? "Rio Home Banking" :(medioDeCobroDAO.esNetBanking())? "Para<br>Empresas":medioDeCobroDAO.getNombre().replaceAll("/", "<br>") %></font>
			</td>
		<%
			}
		} %>
		<td align="center"  width="10%">
			<a href="/grupos/grupoEstandar.jsp?URL_GRUPO=/ayuda/enviosPlazos.jsp&COSTADO=SI#EnvArg">
				<img src="/imagenes/gastosDeEnvio.gif" alt="Consulta de Gastos de Envío" border=""><br>
			</a>
		</td>
	</tr>
</table>
