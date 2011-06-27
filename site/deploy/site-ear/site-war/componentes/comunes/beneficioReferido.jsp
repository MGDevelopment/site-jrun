<%@ page import="com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.kernel.Pair"%>

<%--
                 //com.tmk.src.socio.SocioPK, 
--%>

<%
	String beneficio;
	beneficio = ReferidoManager.getBeneficioReferente(request);
	if (beneficio != null && !beneficio.equals("")) { %>
		<table>
		<tr>
	        <td style="font-size:11;padding=2">
               &nbsp;
	        </td>
			<td style="font-size:11;padding=2">
				<div id="benefReferente">
				<font color="FFFFFF"><b><%=beneficio%></b></font>
				</div>
			</td>
		</tr>
		</table>
<%	} else {	%>

<%
		beneficio = ReferidoManager.getBeneficioReferido(request);
		if (beneficio != null && !beneficio.equals("")) { %>
			<table>
			<tr>
	            <td style="font-size:11;padding=2">
                &nbsp;
	            </td>
	            <td style="font-size:11;padding=2">
					<div id="benefReferente">
					<font color="FFFFFF"><b><%=beneficio%></b></font>
					</div>
				</td>
			</tr>
			</table>
<%
		}
	}

%>
