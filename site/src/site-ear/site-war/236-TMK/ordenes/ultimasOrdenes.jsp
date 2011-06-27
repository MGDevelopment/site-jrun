<%@ page import="java.util.Iterator,
                 com.tmk.orden.*,
                 java.sql.Timestamp,
                 java.util.Date,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.*"%>
<%
	UsuarioDAO usuarioDAO = (UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET);
	if (usuarioDAO == null || !usuarioDAO.tieneAlgunAcceso("ORDEN_LISTAR")) {%><jsp:forward page="<%=LoginIntranet.PAGINA_PRINCIPAL%>"/>
<%}%>
<%
	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	Iterator ordenes = ordenLocalHome.findUltimasOrdenes().iterator();
	PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
	TarjetaOrdenLocalHome tarjetaOrdenLocalHome = (TarjetaOrdenLocalHome) DBUtil.getHome("TarjetaOrden");
%>
<html>
	<body background="/imagenes/intranet/fondo.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
	<table cellpadding="0" cellspacing="0" bgcolor="#FFFFFF" align="center" width="770" height="100%">
		<tr>
			<td valign="top">
				<table cellpadding="0" cellspacing="0" >
					<tr>
						<td width="1005">
							<table width="100%" cellspacing="0" cellpadding="0" border="0">
								<tr>
									<td colspan="5">
										<table width="100%" align="center" cellpadding="0" cellspacing="0">
											<tr>
												<td>
													<jsp:include page="/236-TMK/comunes/header.jsp"/>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
				<table width="100%" border="1" cellspacing="0" cellpadding="2" style="font-family: Verdana, Arial, Helvetica, sans-serif; font-size: 10px;">
					<tr>
						<td align="center"><b>#</b></td>
						<td align="center"><b>Orden</b></td>
						<td align="center"><b>Fecha</b></td>
						<td align="center"><b>Estado</b></td>
						<td align="center"><b>Medio de Cobro</b></td>
						<td align="center"><b>Importe</b></td>
						<td align="center"><b>Codigo de Respuesta</b></td>
						<td align="center"><b>Codigo de Autorizacion</b></td>
						<td align="center"><b>Mensaje de GPay</b></td>
					</tr>
				<%
					int i = 0;
					while (i++ < 30 && ordenes.hasNext()) {
						OrdenLocal ordenLocal = (OrdenLocal)ordenes.next();

						//PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN());
						Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(ordenLocal.getID_ORDEN()).iterator();
						PagoOrdenLocal pagoOrden = (PagoOrdenLocal) pagosOrden.next();

						String importeMedio1 = Contenido.precioToString(pagoOrden.getIMPORTE().doubleValue());
                        MedioDeCobroDAO medioDeCobroDAO1 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrden.getID_MEDIO_COBRO());

						String importeMedio2 = "";
						MedioDeCobroDAO medioDeCobroDAO2 = null;

						if (pagosOrden.hasNext()) {
							pagoOrden = (PagoOrdenLocal) pagosOrden.next();
							medioDeCobroDAO2 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrden.getID_MEDIO_COBRO());
							importeMedio2 = Contenido.precioToString(pagoOrden.getIMPORTE().doubleValue());
						}

						MedioDeCobroDAO medioTarjeta = (medioDeCobroDAO1.esTarjeta())? medioDeCobroDAO1: (medioDeCobroDAO2 != null) ? (medioDeCobroDAO2.esTarjeta())?
								            medioDeCobroDAO2: null:null;

						TarjetaOrdenLocal tarjetaOrdenLocal = null;

						if (medioTarjeta != null) {
							TarjetaOrdenPK tarjetaOrdenPK = new TarjetaOrdenPK();
							tarjetaOrdenPK.ID_ORDEN = ordenLocal.getID_ORDEN();
							tarjetaOrdenPK.ID_MEDIO_COBRO = medioTarjeta.getId();
							tarjetaOrdenLocal = tarjetaOrdenLocalHome.findByPrimaryKey(tarjetaOrdenPK);
						}
				%>
					<tr>
						<td align="right"><%=i%></td>
						<td align="right"><%=Convert.toString(ordenLocal.getID_ORDEN())%></td>
						<td align="center"><%=Convert.toStringLargo(ordenLocal.getFECHA())%></td>
						<td align="left"><%=EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getDescripcion()%></td>
						<td align="left">
                        <%=medioDeCobroDAO1.getNombre()%>
                        <% if (medioDeCobroDAO2 != null) { %>
	                        &nbsp; (<%=importeMedio1%>)
	                        <br> <%=medioDeCobroDAO2.getNombre()%>
	                        &nbsp; (<%=importeMedio2%>)
                        <%}
						%>
						</td>
						<td align="right"><%=Contenido.precioToString(ordenLocal.getTOTAL().doubleValue())%></td>
						<td align="right"><%=(tarjetaOrdenLocal == null) ? "&nbsp;" : Convert.toString(tarjetaOrdenLocal.getCODIGO_RESPUESTA(), "&nbsp;")%></td>
						<td align="right"><%=(tarjetaOrdenLocal == null) ? "&nbsp;" : Convert.toString(tarjetaOrdenLocal.getCODIGO_AUTORIZACION(), "&nbsp;")%></td>
						<td align="left"><%=(tarjetaOrdenLocal == null) ? "&nbsp;" : Convert.toString(tarjetaOrdenLocal.getMENSAJE_GPAY(), "&nbsp;")%></td>
					</tr>
				<%
						out.flush();
					}
				%>
				</table>
				<br><br>
			</tr>
		</table>
	</body>
</html>
