<%@page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.referido.ReferidoLocalHome,
                 com.tmk.kernel.DBUtil,
                 com.tmk.referido.ReferidoLocal,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.setup.Contenido,
                 com.tmk.bus.socio.Socios2,
                 com.tmk.soa.servicios.ServiceLocator,
                 com.tmk.controllers.referido.ReferidoManager"%>
<%--
                 //com.tmk.socio.SocioLocalHome,
				 //com.tmk.socio.SocioLocal,
--%>               
<%
	Long codigoReferido = Convert.toNumber(request.getParameter(ReferidoManager.CAMPO_CODIGO_REFERIDO), new Long (0));
	ReferidoLocalHome referidoLH = (ReferidoLocalHome) DBUtil.getHome("Referido");
	ReferidoLocal referido = referidoLH.findByPrimaryKey(codigoReferido);
	//SocioLocalHome socioLH = (SocioLocalHome) DBUtil.getHome("Socio");
	//SocioLocal socioReferente = socioLH.findByPrimaryKey(new SocioPK(referido.getID_SUCURSAL_REFERENTE(), referido.getID_SOCIO_REFERENTE()));
	Socios2 socioReferente = ServiceLocator.getSociosService().findByPrimaryKey(new SocioPK(referido.getID_SUCURSAL_REFERENTE(), referido.getID_SOCIO_REFERENTE()));
	//SocioLocal socioReferido = socioLH.findByPrimaryKey(new SocioPK(referido.getID_SUCURSAL_REFERIDO(), referido.getID_SOCIO_REFERIDO()));
	Socios2 socioReferido = ServiceLocator.getSociosService().findByPrimaryKey(new SocioPK(referido.getID_SUCURSAL_REFERIDO(), referido.getID_SOCIO_REFERIDO()));
%>
<% try{ %>
<html>
	<body>
		<table  style="font-family: Arial; font-size: 12px;" border=0>
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
					<%--Estimado/a  <%=Convert.nombreCompleto(socioReferente.getNOMBRES(), socioReferente.getAPELLIDOS())%>--%>
					Estimado/a  <%=Convert.nombreCompleto(socioReferente.getNombres(), socioReferente.getApellidos())%>
					<p>
					Gracias por participar de nuestro Programa.<br>
					<%--Por la compra realizada por <%=Convert.nombreCompleto(socioReferido.getNOMBRES(), socioReferido.getAPELLIDOS())%> te otorgamos un <%=referido.getBENEF_REFERENTE()%> en tus próximas compras hasta el <%=Convert.toString(referido.getFECHA_VENC_REFERENTE())%>.<br>--%>
					Por la compra realizada por <%=Convert.nombreCompleto(socioReferido.getNombres(), socioReferido.getApellidos())%> te otorgamos un <%=referido.getBENEF_REFERENTE()%> en tus próximas compras hasta el <%=Convert.toString(referido.getFECHA_VENC_REFERENTE())%>.<br>
					<p>
					Para disfrutar de tu beneficio hacé click <a href="<%=Globals.PAGINA_SITIO%>">aquí</a>
					<p>&nbsp;
					<p>
					Ante cualquier duda escribanos a: <a href="mailto:<%=Globals.MAIL_REFERIDOS%>"><%=Globals.MAIL_REFERIDOS%></a>
					Si querés conocer más acerca del Programa de Referidos, hacé click <a href="<%=Globals.PAGINA_SITIO + "/referido"%>">aquí</a>
					<br>
					<a href="<%=Globals.PAGINA_SITIO + "/referido"%>"><%=Globals.PAGINA_SITIO + "/referido"%></a>.
				</td>
			</tr>
		</table>
	</body>
</html>
<%  } catch (Exception e) {

	}
%>