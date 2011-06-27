<%@ page import="java.util.Vector,
                 com.tmk.kernel.DBUtil"%>
<table width="100%">
	<tr>
		<td>
			<b>Reglas de Tematika</b><br>
			<table width="100%" align="left" cellspacing="0" cellpadding="5" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
<%              Vector estados = DBUtil.estadosDeArticulos();
				for (int i = 0; i < estados.size(); i++) { %>
				<tr>
					<td><%= estados.get(i).toString() %></td>
				</tr>
<%              } %>
			</table>
		</td>
	</tr>
</table>
