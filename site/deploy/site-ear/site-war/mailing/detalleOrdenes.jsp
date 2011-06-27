<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.admin.AlianzaLocalHome,
                 com.tmk.admin.AlianzaLocal,
                 java.util.Vector,
                 java.util.Date,
                 com.tmk.kernel.*"%>
<STYLE TYPE="text/css">
<!--
TD {text-align:center;}
//-->
</STYLE> 
<table width="100%" border="0" cellspacing="0" cellpadding="2">
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td><b>Orden <%= Convert.toString(index) %></b></td>
					<td><b>Fecha</b></td>
					<%  if (ordenDAO.getFechaDeInicio() != null) { %>
					<td><b>Tiempo empleado</b></td>
					<%  } %>
					<td><b>Socio</b></td>
					<td><b>Pais</b></td>
					<td><b>Provincia</b></td>
					<%  if (ordenDAO.tieneAlianza()) { %>
					<td><b>Alianza</b></td>
					<%  } %>
					<%  if (ordenDAO.getCupon() != null) { %>
					<td><b>Cupon</b></td>
					<%  } %>
				</tr>
				<tr>
					<td align="right">
					<%=Convert.toString(ordenDAO.getIdOrdenProcesada())%>
					</td>
					<td><%=Convert.toStringLargo(ordenDAO.getFechaDeCierre())%></td>
					<%  if (ordenDAO.getFechaDeInicio() != null) {
						Date inicio = ordenDAO.getFechaDeInicio();
						Date fin = ordenDAO.getFechaDeCierre();
						Date dif = new Date(2000-1900, 0, 0,
						                    fin.getHours() - inicio.getHours(),
						                    fin.getMinutes() - inicio.getMinutes(),
						                    fin.getSeconds() - inicio.getSeconds());
					%><td><%=Convert.toStringHora(dif)%></td><%  } %>
					<td><%=Convert.toString(ordenDAO.getNombreSocio(), "&nbsp;")%></td>
					<td><%=domicilioDAO.getPais().getNombre()%></td>
					<td><%=(domicilioDAO.getProvinciaExterna() == null) ? domicilioDAO.getProvincia().getNombre() : (domicilioDAO.getProvinciaExterna() + " (Ext)")%></td>
					<%  if (ordenDAO.tieneAlianza()) {
						AlianzaLocalHome alianzaLocalHome = (AlianzaLocalHome)DBUtil.getHome("Alianza");
						AlianzaLocal alianzaLocal = alianzaLocalHome.findByPrimaryKey(ordenDAO.getIdAlianza());
					%>
					<td>(<%=Convert.toString(alianzaLocal.getID_ALIANZA(), "")%>) <%=Convert.toString(alianzaLocal.getRAZON_SOCIAL(), "-")%></td>
					<%  } %>
					<%  if (ordenDAO.getCupon() != null) { %>
					<td><%=Convert.toString(ordenDAO.getCupon(), "-")%></td>
					<%  } %>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td><b>Art&iacute;culo</b></td>
					<td width="40%"><b>Titulo</b></td>
					<td><b>Papel / Nota</b></td>
					<td><b>Promo</b></td>
					<td><b>Precio</b></td>
					<td><b>Cantidad</b></td>
					<td width="10%"><b>Subtotal</b></td>
				</tr>
				<%  for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
						ArticuloDAO articuloDAO = ordenDAO.getArticulo(i);
				%>
				<tr>
					<td align="right"><a href="<%=Globals.PAGINA_SITIO%>/articulo/detalleArticulo.jsp?idArticulo=<%=articuloDAO.getId()%>"><%=Convert.toString(articuloDAO.getId())%></a> </td>
					<td align="left">(<%=Convert.capitalizar(Globals.productoSeccion(articuloDAO.getCategoriaSeccion()), false)%>) <%=Convert.corregir(articuloDAO.getTitulo(), true)%></td>
					<td><%=Convert.toString(articuloDAO.tieneSubArticulo())%> / <%=Convert.toString(articuloDAO.tieneNota())%></td>
					
						<%
							String promos="";
							promos = (articuloDAO.getNombrePromo1()!= null)? articuloDAO.getNombrePromo1() + "<br>":"";
							promos += (articuloDAO.getNombrePromo2()!= null)? articuloDAO.getNombrePromo2() + "<br>":"";
							promos += (articuloDAO.getNombrePromo3()!= null)? articuloDAO.getNombrePromo3() + "<br>":"";
							promos += (articuloDAO.getNombrePromo4()!= null)? articuloDAO.getNombrePromo4() + "<br>":"";
							promos += (articuloDAO.getNombrePromo5()!= null)? articuloDAO.getNombrePromo5() + "<br>":"";
							promos += (articuloDAO.getNombreCampaign()!= null)? articuloDAO.getNombreCampaign() + "<br>":"";
							
						%>
					<td><%=Convert.toString(promos, "No")%></td>
					<td align="right"><%=Contenido.precioToString((articuloDAO.getPrecioPromocion()< articuloDAO.getPrecioConDescuento())? articuloDAO.getPrecioPromocion(): articuloDAO.getPrecioConDescuento())%></td>
					<td align="right"><%=Convert.toString(articuloDAO.getCantidad())%></td>
					<td align="right"><%=Contenido.precioToString((articuloDAO.getPrecioPromocion()< articuloDAO.getPrecioConDescuento())? articuloDAO.getPrecioPromocion() * articuloDAO.getCantidad(): articuloDAO.getPrecioConDescuento() * articuloDAO.getCantidad())%></td>
				</tr>
				<% 		if (articuloDAO.getGastoDeEvio() != null && 1==2) { 
							GastosEnvioDAO gasto = articuloDAO.getGastoDeEvio();
				%>
					<tr>
						<td align="right"></a> </td>
						<td align="left">(Gasto)<%=(gasto.esGastoBasico())?" Básico": " Adicional"%></td>
						<td></td>
						<%
							promos="";
							promos = (gasto.getNombrePromo1()!= null)? gasto.getNombrePromo1() + "<br>":"";
							promos += (gasto.getNombrePromo2()!= null)? gasto.getNombrePromo2() + "<br>":"";
							promos += (gasto.getNombrePromo3()!= null)? gasto.getNombrePromo3() + "<br>":"";
							promos += (gasto.getNombrePromo4()!= null)? gasto.getNombrePromo4() + "<br>":"";
							promos += (gasto.getNombrePromo5()!= null)? gasto.getNombrePromo5() + "<br>":"";
							promos += (gasto.getNombreCampaign()!= null)? gasto.getNombreCampaign() + "<br>":"";
							
						%>
						<td><%=Convert.toString(promos, "No")%></td>
						<td align="right"><%=Contenido.precioToString((gasto.getPrecioPromocion()< gasto.getPrecioConDescuento())? gasto.getPrecioPromocion() * gasto.getCantidad(): gasto.getPrecioConDescuento())%></td>
						<td align="right"><%=Convert.toString(gasto.getCantidad())%></td>
						<td align="right"><%=Contenido.precioToString((gasto.getPrecioPromocion()< gasto.getPrecioConDescuento())? gasto.getPrecioPromocion() * gasto.getCantidad(): gasto.getPrecioConDescuento() * gasto.getCantidad())%></td>
					</tr>
				<%		} %>
				
				<% 		if (articuloDAO.getPapelDeRegalo() != null && 1==2) { 
							ArticuloDAO papel = articuloDAO.getPapelDeRegalo();
				%>
					<tr>
						<td align="right"></a> </td>
						<td align="left">(Papel) <%=papel.getTitulo()%></td>
						<td></td>
						<%
							promos="";
							promos = (papel.getNombrePromo1()!= null)? papel.getNombrePromo1() + "<br>":"";
							promos += (papel.getNombrePromo2()!= null)? papel.getNombrePromo2() + "<br>":"";
							promos += (papel.getNombrePromo3()!= null)? papel.getNombrePromo3() + "<br>":"";
							promos += (papel.getNombrePromo4()!= null)? papel.getNombrePromo4() + "<br>":"";
							promos += (papel.getNombrePromo5()!= null)? papel.getNombrePromo5() + "<br>":"";
							promos += (papel.getNombreCampaign()!= null)? papel.getNombreCampaign() + "<br>":"";
							
						%>
						<td><%=Convert.toString(promos, "No")%></td>
						<td align="right"><%=Contenido.precioToString((papel.getPrecioPromocion()< papel.getPrecioConDescuento())? papel.getPrecioPromocion() * papel.getCantidad(): papel.getPrecioConDescuento())%></td>
						<td align="right"><%=Convert.toString(papel.getCantidad())%></td>
						<td align="right"><%=Contenido.precioToString((papel.getPrecioPromocion()< papel.getPrecioConDescuento())? papel.getPrecioPromocion() * papel.getCantidad(): papel.getPrecioConDescuento() * papel.getCantidad())%></td>
					</tr>
				<%		} %>
				<%}%>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<%  MedioDeCobroDAO medioTarjeta = null;

					if (ordenDAO.getMedioDeCobro().esTarjeta()) {
						medioTarjeta = ordenDAO.getMedioDeCobro();
					}

					
					double totalMedioDeCobro1 = 0.0;
									
					totalMedioDeCobro1 = ordenDAO.totalSitioCompleto();
				%>
				<tr>
					<td><b>Estado</b></td>
					<td><b>Pago</b></td>
					<%if (medioTarjeta != null) {%>
					<td><b>Codigo</b></td>
					<td><b>Mensaje</b></td>
					<td><b>Cuotas</b></td>
					<td><b>Interés</b></td>
					<%}%>
					<td><b>Gastos</b></td>
					<td width="10%"><b>Total</b></td>
				</tr>

				<tr>
					<td style="color: <%=color%>;"><b><%=ordenDAO.getEstado().getDescripcion()%></b></td>
					<td><%=ordenDAO.getMedioDeCobro().getNombre()%>
					

					</td>

					<%if (medioTarjeta != null) {%>
					<td><%=Convert.toString(ordenDAO.getGpayCodigoRespuesta(), "-")%></td>
					<td><%=Convert.toString(ordenDAO.getGpayMensajeRespuesta(), "-")%></td>
					<td><%=Convert.toString(ordenDAO.getTarjetaPlanDAO().getCuotas())%></td>
					<td><%=Contenido.precioToString(ordenDAO.interesesSobreTotal())%></td>
					<%}%>
					<td align="right"><%=Contenido.precioToString(ordenDAO.totalGastos())%></td>
					<td align="right"><%=Contenido.precioToString(ordenDAO.totalSitioCompleto())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td><b>Comentario</b></td>
					<td><b>Motivo de Riesgo</b></td>
					<%  if (ordenDAO.tieneOtroReceptor()) { %>
					<td><b>Destinatario del pedido</b></td>
					<%  } %>
				</tr>
				<tr>
					<td align="left"><%=Convert.toString(ordenDAO.getComentario(), "-")%></td>
					<td align="left"><%=Convert.toString(ordenDAO.getMotivoDeRiesgo(), "-")%></td>
					<%  if (ordenDAO.tieneOtroReceptor()) { %>
					<td><%=Convert.nombreCompleto(ordenDAO.getNombresReceptor(), ordenDAO.getApellidosReceptor())%></td>
					<%  } %>
				</tr>
			</table>
		</td>
	</tr>
	<% if (ordenDAO.getPuntajeWrapper() != null) { %>
	<tr>
		<td>
			<table width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td><b>Información sobre el programa eXtra</b></td>
				</tr>
				<tr>
					<td align="left"><%=Convert.toString(ordenDAO.getPuntajeWrapper().toString())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<% } %>
</table>