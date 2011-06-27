<%@ page import="java.util.Iterator,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.kernel.*,                 
                 com.tmk.admin.AlianzaLocalHome,
                 com.tmk.admin.AlianzaLocal,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet" %>
                 
<%--
				//com.tmk.socio.SocioLocalHome,
                //com.tmk.socio.SocioLocal, 
--%>
                 
<%	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !(usuarioDAO.tieneAlgunAcceso("ORDEN_APROBAR", "ORDEN_COMPLETAR") || usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR") ) && !usuarioDAO.tieneAlgunAcceso("ORDEN_BUSCAR")) {
%>
		<jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%	}
%>                 
                 
<%	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
    OrdenDAO ordenDAO = new OrdenDAO();
	boolean existeOrden = true;

	try {
		OrdenService.borrarOrdenDelCache(new Integer(idOrden));
		ordenDAO = OrdenService.cargarOrden(idOrden);
		//ordenDAO = OrdenService.cargarOrden2(idOrden);

	} catch (Exception e) {
		TmkLogger.debug(e.toString());
		

		existeOrden = false;
	}
%>
<%
	try {
%>

<html>
	<head>
		<%= Globals.estiloBasico() %>
	</head>

	<script type="text/javascript">
			function detalleSocio(email){
				window.open('/236-TMK/ordenes/socio.jsp?email=' + email,'',
				"toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=yes, resizable=yes, copyhistory=no, width=800, height=700");
			}
	</script>

<body  leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

		<table width="100%" align="center" cellpadding="0" cellspacing="0">
					<tr>
						<td>

						</td>
					</tr>
				</table>

		<br>
		<table width="752" border="0">
		<tr>

    <td>&nbsp; </td>
		</tr>

		<tr>
			<%	if (existeOrden) {
			%>
					<td>
						<br>
						<table width="650" align="center" border="0">
						<tr>
							<td>
								<font style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size:12">
									<b>Orden:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><%=Convert.toString(idOrden)%><br>
									<b>Fecha:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</b><%=Convert.toStringLargo(ordenDAO.getFechaDeCierre())%><br>
									<b>Estado:&nbsp;&nbsp;&nbsp;&nbsp;</b><%=ordenDAO.getEstado().getDescripcion()%><br><br>
									<a style="font-size: 12px;" href="javascript:detalleSocio('<%=ordenDAO.getMailSocio()%>')">
									<b>Cliente:&nbsp;&nbsp;&nbsp;</b><%=ordenDAO.getNombreSocio()%> - <%=ordenDAO.getMailSocio()%> (ver detalles)<br><br>
									</a>
									<% if (ordenDAO.getIdAlianza() != null) {
										AlianzaLocalHome alianzaLocalHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
										AlianzaLocal alianzaLocal = alianzaLocalHome.findByPrimaryKey(ordenDAO.getIdAlianza());
									%>
									<b>Alianza:&nbsp;&nbsp;</b><%=Convert.toString(alianzaLocal.getRAZON_SOCIAL())%> (Código <%=ordenDAO.getIdAlianza()%>)<br>
									<b>Sección:&nbsp;</b><%=Convert.toString(ordenDAO.getIdSeccion(), "No tiene")%>
									<%  } %>
								</font>
							</td>
						</tr>

						<tr>
							<td>
								<br>
								<%@ include file="/componentes/comunes/totalesCompra.jsp" %>
							</td>
						</tr>
						
						<%if (ordenDAO.getMedioDeCobro().esTarjeta()) {%>
							<tr>
								<td>
									<table style="border-collapse: collapse; border: 1px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="10">
										<tr align="center" style="font-weight: bold; background-color: #5AB5DE;">
											<td>Tipo Documento</td>
											<td>Numero</td>
											<td>Nombre Completo</td>
											<td>Direccion</td>
										</tr>
										<tr>
											<td style="border-right: 1px solid #5AB5DE;"><%=Convert.toString(ordenDAO.getTipoDocumento(), "&nbsp;")%></td>
                                            <td style="border-right: 1px solid #5AB5DE;"><%=Convert.toString(ordenDAO.getNumeroDocumento(), "&nbsp;")%></td>
                                            <td style="border-right: 1px solid #5AB5DE;"><%=Convert.toString(ordenDAO.getNombreCliente(), "&nbsp;")%></td>
                                            <td><%=Convert.toString(ordenDAO.getDomicilioResumen(), "&nbsp;")%></td>
										</tr>
									</table>
								</td>
							</tr>
						<%}%>

						<tr>
							<td>
								<br>
								<br>
								<b>
									<font style="font-size: 12px;">Detalle de su compra</font>
								</b>
							</td>
						</tr>

						<tr>
							<td>
								<br>
								<%@ include file="/componentes/comunes/articulos.jsp" %>
							</td>
						</tr>

						<%-- if (ordenDAO.tienenSubArticulos()) { %>
						<tr>
							<td>
								<br>
								<br>
								<b>
									<font style="font-size: 12px;">Papeles de Regalo</font>
								</b>
							</td>
						</tr>


						<tr>
							<td>
								<br>
								<table style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="3">
											<tr style="font-weight: bold; text-align: center; background-color: #5AB5DE;" align="center">
												<td>
													<b>Artículo</b>
												</td>
												<td>
													<b>Papel</b>
												</td>
											</tr>
								<%  for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
										ArticuloDAO articulo = ordenDAO.getArticulo(i);
										if (articulo.tieneSubArticulo()) {
											ArticuloDAO papel = articulo.getSubArticulo();
								%>
											<tr align="left">
												<td>
													<%= Convert.capitalizar(articulo.getTitulo(), true) %>
												</td>
												<td>
													<%= Convert.capitalizar(papel.getTitulo(), false) %>
												</td>
											</tr>
									<%  } %>
								<%  } %>
								</table>
							</td>
						</tr>
						<% } --%>

						</table>

						<br><br><br>

					</td>
			<%	} else {
			%>
					<td align="center">
						<br><br><br>
						<h2>
							NO EXISTE LA ORDEN BUSCADA
						</h2>
					</td>
			<%	}
			%>
		</tr>
		</table>

</body>
</html>
<% }
	catch (Exception e) {
		e.printStackTrace();
		out.println(e.toString() + e.getMessage());
	}

%>