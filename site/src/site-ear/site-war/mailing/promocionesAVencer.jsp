<%@ page import="java.util.Vector,
                 com.tmk.orden.Promocion2,
                 com.tmk.kernel.Convert"%>
<%  Vector promocionesAVencer = Promocion2.consultarPromocionesAVencer(5);
	if ((promocionesAVencer != null) && (!promocionesAVencer.isEmpty())) { %>
<table width="500">
	<tr>
		<td>
			<b>Promociones que vencen:</b><br>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<%  for (int i = 0; i < promocionesAVencer.size(); i++) {
						Promocion2 promocion = (Promocion2) promocionesAVencer.get(i);%>
				<tr>
					<td><%=Convert.toString(promocion.getNombre())%>
					(del <%=Convert.toString(promocion.getFInicio())%> al <%=Convert.toString(promocion.getFFin())%>)
					</td>
				</tr>
				<%  } %>
			</table>
		</td>
	</tr>
</table>
<%  } %>
