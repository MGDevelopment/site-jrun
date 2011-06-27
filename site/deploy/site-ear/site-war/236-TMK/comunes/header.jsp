<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet"%>

<table width="100%" align="center" cellpadding="0" border=0 cellspacing="0">
	<tr bgcolor="#DEDBDE">
		<td>
			<%if (!Globals.sitioDisponible()) {%>
				<jsp:forward page="/mantenimiento.jsp"/>
			<%}%>

			<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
				if (usuarioDAO == null) {
			%>
					<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
			<%	}
			%>
			<table cellspacing="0" cellpadding="0" border="0">
                <tr>
                    <td>
                        <a href="/236-TMK/inicio.jsp">
                            <img src="/imagenes/intranet/logoTematika.png" border="0" alt="Hola">
                        </a>
                    </td>

					<td width="450" align="right">
						<a href="/236-TMK/salir.jsp" style="text-decoration: none;">
							<b>
								<p>SALIR</p>
							</b>
						</a>
					</td>
				</tr>

                <%if (Globals.MOSTRAR_MENSAJE) {%>
                    <tr>
                        <td>
                            <b><%=Globals.MENSAJE_MODO%></b>
                        </td>
                    </tr>
                <%}%>
			</table>
		</td>
	</tr>
	<tr>
		<td align="right"><jsp:include page="/236-TMK/comunes/solapas.jsp"/></td>
	</tr>
</table>