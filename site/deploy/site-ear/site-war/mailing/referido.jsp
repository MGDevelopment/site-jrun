<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.controllers.referido.ReferidoManager,
                 com.tmk.referido.ReferidoLocal,
                 com.tmk.kernel.DBUtil,
                 com.tmk.referido.ReferidoLocalHome,
                 com.tmk.setup.Contenido"%>
<%
	String codigoReferido =Convert.toString(request.getParameter(ReferidoManager.CAMPO_CODIGO_REFERIDO), "");
	String comentario = Convert.toString(request.getParameter(ReferidoManager.CAMPO_COMENTARIO_REFERIDO1));
	String nombreRef = Convert.toString(request.getParameter(ReferidoManager.NOMBRE_REFERENTE));
	String apellidoRef = Convert.toString(request.getParameter(ReferidoManager.APELLIDO_REFERENTE));

	try {
		ReferidoLocalHome referidoLH = (ReferidoLocalHome)DBUtil.getHome("Referido");
		ReferidoLocal referido = referidoLH.findByPrimaryKey(new Long (codigoReferido));

%>
<html>
	<body>
	<table  style="font-family:Arial; font-size: 12px;" border=0>
		<tr>
			<td colspan=2>
				<img src="<%=Globals.PAGINA_SITIO%>/imagenes/<%=Contenido.getLogo()%>" border="0" alt="<%= Contenido.getMensajeLogo()%>">
			</td>
		</tr>
		<tr>
			<td width=35>
				&nbsp;
			</td>
			<td width=450>
				<p>
				Estimado/a <%=Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%>
				<p>
				<%= Convert.nombreCompleto(nombreRef, apellidoRef)%> te invita a participar de nuestro Programa de Referidos y <b><%=Globals.NOMBRE_DEL_SITIO%></b>
				te ofrece un <%=Globals.CUPON_REFERIDO.getBeneficio()%> en tu próxima compra hasta el <%=Convert.toString(referido.getFECHA_VENC_REFERIDO()) %>.<br>
				Para disfrutar de tu beneficio hacé click <a href="<%=Globals.PAGINA_SITIO + "/index.jsp?" + ReferidoManager.SESSION_CODIGO_REFERIDO + "=" + codigoReferido%>">aquí</a>
				<br><a href="<%=Globals.PAGINA_SITIO + "/index.jsp?" + ReferidoManager.SESSION_CODIGO_REFERIDO + "=" + codigoReferido%>">
				<%=Globals.PAGINA_SITIO + "/index.jsp?" + ReferidoManager.SESSION_CODIGO_REFERIDO + "=" + codigoReferido%>
				</a>
				<%
				if (comentario != null) {
				%>
				<p>&nbsp;
				<br>
				<%=Convert.nombreCompleto(referido.getNOMBRE_REFERIDO(), referido.getAPELLIDO_REFERIDO())%> escribió:<br>
				<%=comentario%>
				<%
				}
				%>
				<p>&nbsp;
				<p>

				Ante cualquier duda escribanos a: <a href="<%=Globals.MAIL_REFERIDOS%>"><%=Globals.MAIL_REFERIDOS%></a>
				<br>
				Si querés conocer más acerca del Programa de Referidos, hacé click <a href="<%=Globals.PAGINA_SITIO + "/referido"%>">aquí</a>
                <br>
                <a href="<%=Globals.PAGINA_SITIO + "/referido"%>"><%=Globals.PAGINA_SITIO + "/referido"%></a>.
				</div>

			</td>
		</tr>
	</table>
	<body>
</html>
  <%
		} catch (Exception e) {

		}
	%>
