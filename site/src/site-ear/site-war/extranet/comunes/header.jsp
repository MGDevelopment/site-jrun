<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>

<table width="100%" align="center" cellpadding="0" cellspacing="0" border="0">
<tr bgcolor="#DEDBDE">
	<td>
		<%	if ((!Globals.sitioDisponible()) && Convert.toBoolean(request.getParameter("CONTROLAR_SERVER"),true)) {
		%>
				<jsp:forward page="/mantenimiento.jsp"/>
		<%	}
		%>

		<table cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td>
				<a href="/extranet/main.jsp">
					<img src="/imagenes/intranet/logoTematika.png" border="0" alt="<%=Globals.NOMBRE_DEL_SITIO%>">
				</a>
			</td>

			<%	Integer idAlianza = (Integer)session.getAttribute("Extranet.ID_ALIANZA");

				if(idAlianza == null) {
			%>
					<td width="450" align="right">
						<a href="/extranet">
							<font class="TextoNegro">
								CONECTARSE
							</font>
						</a>
					</td>
			<%	} else {
			%>
					<td width="450" align="right">
						<a href="/SalirExtranet">
							<font class="TextoNegro">
								SALIR
							</font>
						</a>
					</td>
			<%	}
			%>
		</tr>

		<%	if (Globals.MOSTRAR_MENSAJE) {
		%>
				<tr>
					<td>
						<b><%=Globals.MENSAJE_MODO%></b>
					</td>
				</tr>
		<%	}
		%>
		</table>
	</td>
</tr>
</table>