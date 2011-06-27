<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.DomicilioDAO,
                 java.util.Vector,
                 com.tmk.orden.TarjetaPrepaga"%>
<% boolean usuarioIntranet = ((UsuarioDAO)session.getAttribute(LoginIntranet.USUARIO_EXTRANET) != null);%>
<table style="border-collapse: collapse; border: 1px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="10">
<tr align="center" style="font-weight: bold; background-color: #5AB5DE;">
	<td>Totales de la compra</td>
	<td>Forma de Pago</td>
	<td>Detalle del Envío</td>
</tr>

<tr valign="top">
	<td width="35%">
        <%
			double totalMedioDeCobro1 = 0.0;
	        totalMedioDeCobro1 = ordenDAO.totalSitioCompleto();
	    %>
		

		<table width="100%">
			<tr><td>Subtotal:</td><td align="right"><b><%=Contenido.precioToString(ordenDAO.subTotal())%></b></td></tr>
			<% if (ordenDAO.tienenSubArticulos()) { %>
			<tr><td>Papel de regalo:</td><td align="right"><b><%=Contenido.precioToString(ordenDAO.totalPapelDeRegalo())%></b></td></tr>
			<% } %>
			<tr><td>Gastos de envío:</td><td align="right"><b><%=Contenido.precioToString(ordenDAO.totalGastoDeEnvio())%></b></td></tr>

			<% if (ordenDAO.getInteresCobradoDAO() != null) { %>

			<tr><td>Interés:</td><td align="right" ><b><%=Contenido.precioToString(ordenDAO.getInteresCobradoDAO().getPrecioPromocion())%></b></td></tr>
            <%}%>
			<tr><td>Total:</td><td align="right" style="border-top: 1px solid #000000;"><b><%=Contenido.precioToString(ordenDAO.totalSitioCompleto())%></b></td></tr>
			<tr><td>&nbsp;</td></tr>
        	<% if (ordenDAO.getTarjetaPlanDAO() != null) { %>
			<tr><td>Pago en <b><%= Convert.pluralCompleto(ordenDAO.getTarjetaPlanDAO().getCuotas(), "cuota") %></b></td></tr>
			<tr><td>&nbsp;</td></tr>
			<% } %>
        
		<tr>
			<td colspan=2> 
			Promociones Aplicadas:<br>
			<%String promosAplicadas = ordenDAO.getPromocionesAplicadas("<br>&middot;"); %>
			<%=(promosAplicadas.equals(""))? "Ninguna ": promosAplicadas%>
			</td>
			
		</tr>	
        </table>
		<% // Mostrar la conversion en caso necesario
			if ((ordenDAO.isReadWrite()) && (ordenDAO.getDomicilioFacturacion() != null) && (!ordenDAO.getDomicilioFacturacion().getPais().esArgentina())) {%>
				<table width="100%">
					<tr><td>Son Dolares</td><td align="right"><%=Contenido.precioDollarToString(ordenDAO.totalSitioCompleto())%></td></tr>					
					<tr><td>Son Euros</td><td align="right"><%=Contenido.precioEuroToString(ordenDAO.totalSitioCompleto())%></td></tr>
				</table>
		<%}%>
		<table>
			<tr>
				<td>

				</td>
			</tr>
		</table>
	</td>

	<td width="35%" style="border-right: 1px solid #5AB5DE; border-left: 1px solid #5AB5DE;">
			<% if (ordenDAO.getMedioDeCobro().esTarjeta()) {%>
				Tarjeta <%=ordenDAO.getMedioDeCobro().getNombre()%>
				<br>
				<%=Convert.toString((usuarioIntranet) ? ordenDAO.get_NumeroTarjetaCompletoDesencriptado() : ordenDAO.numeroTarjetaAMostrar())%><br>
			<% } else { %>
			<%=ordenDAO.getMedioDeCobro().getNombre()%>
			<% } %>
	<!--Tarjeta prepaga-->

			<% if (ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
					double totalImporteParaOrden = 0.0;
					Vector tarjetas = ordenDAO.getTarjetasPrepagas();
					
%>	
	<table width= "97%" align="center" cellspacing=1 cellpadding=0 border=0>
		<tr><td Style="font-size:3">&nbsp;</td></tr>
<%                  boolean hayNoHabilitada = false;
					for (int i=0; i<tarjetas.size(); i++) {
						TarjetaPrepaga tarjeta = (TarjetaPrepaga)tarjetas.get(i);
%>
		<tr style="color:<%=(tarjeta.estaHabilitada())?"000000":"gray"%>"><td width="140">#<%=tarjeta.getNro()%>:&nbsp;</td>
			<td align="right"><%=Contenido.precioToString(tarjeta.getImporteParaOrden())%></td>
<%                      totalImporteParaOrden += tarjeta.getImporteParaOrden();
						if (tarjeta.estaHabilitada()) {
%>
			<td></td>
<%
						} else {
%>
			<td>(*)</td>
<%                          hayNoHabilitada = true;
                        }
					}
%>
		</tr>
		<tr><td>Total:</td>
			<td  style="border-top: 1px solid #000000;" align="right"><%=Contenido.precioToString(totalImporteParaOrden)%></td>
			<td></td>
		</tr>

<%
					if (hayNoHabilitada) {
%>
		<tr><td Style="font-size:3" colspan=3>&nbsp;</td></tr>
		<tr><td  style="color:gray" colspan=3>(*) No habilitada</td></tr>


<%
					}
%>
		<tr><td Style="font-size:3" colspan=3>&nbsp;</td></tr>
		<tr><td colspan=3>
        <%
            if (ordenDAO.getTotalMedioDeCobro() > totalImporteParaOrden) {
	    %>
	        <font color="red"><b>No cuenta con saldo suficiente para realizar esta compra.</b></font>
	    <%
            }
        %>
        </td></tr>
	</table>
<%
	}
%>

		<br><br><br>
		Teléfono: <%= Convert.toString(ordenDAO.getTelefonoContacto())%><br>
		Horario de contacto telefónico: <%= Convert.toString(ordenDAO.getHorarioContacto())%><br>
		Comentario: <%= Convert.toString(ordenDAO.getComentario(), "ninguno")%><br>
		<%
			if (ordenDAO.getCPF_CNPJ() != null) {
		%>
			<%=ordenDAO.getCPF_CNPJ()%>
		<%
			}
		%>
		<%if (ordenDAO.isReadWrite()) {%>
			<br><br><br>
			<a href="<%=CompraHelper.PAGINA_MEDIO_DE_COBRO%>">Cambiar forma de Pago <%=ordenDAO.getMedioDeCobro().getNombre()%></a>
		<%}%>
	</td>

	<td>
		Papel de regalo: <b><%=Convert.toString(ordenDAO.tienenSubArticulos())%></b><br>
		Dedicatoria    : <b><%=Convert.toString(ordenDAO.tienenNotas())%></b><br>
		<br>
		<b></b>
		<br>
		<%if (ordenDAO.getMetodoDeEnvio() != null) {%>
			<b>Metodo de envío : </b><%=Convert.toString(ordenDAO.getMetodoDeEnvio(), "No especificado")%>
		<%}%>
		<br>
		<br>
		<br>
		<%if (ordenDAO.isReadWrite()) {%>
			<a href="<%=CompraHelper.PAGINA_PAPEL_DE_REGALO%>">Cambiar papel de regalo o mensaje</a>
		<%}%>
	</td>
</tr>
</table>

<table style="border-collapse: collapse; border: 1px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="10">
<tr align="center" style="font-weight: bold; background-color: #5AB5DE;">
	<td width="50%">Domicilio de Envío</td>
	<td width="50%">Domicilio de Facturación</td>
</tr>

<tr>
	<% DomicilioDAO domicilio; %>
	<td style="border-right: 1px solid #5AB5DE;">
		<% domicilio = ordenDAO.getAlgunDomicilioEnvio(); %>
		<% if (domicilio == null) { %>
		<%} else {%>

			<%= Convert.capitalizar(Convert.toString(domicilio.getCalle()), false) %> <%= Convert.toString(domicilio.getNumero()) %>
			<%= Convert.toString(domicilio.getEdificio()) %> <%= Convert.toString(domicilio.getPiso()) %>
			<%= Convert.capitalizar(Convert.toString(domicilio.getDepto()), true) %><br>
			<%= Convert.toString(domicilio.getLocalidadExterna(), domicilio.getLocalidad().getNombre()) %> (<%= Convert.toString(domicilio.getCodigoPostal()) %>)<br>
			<%= Convert.toString(domicilio.getProvinciaExterna(), domicilio.getProvincia().getNombre()) %><br>
			<%= Convert.toString(domicilio.getPais().getNombre()) %><br>
			<br><br>
			<%if (ordenDAO.isReadWrite()) {%>
				<a href="<%=CompraHelper.PAGINA_DOMICILIO_%><%=domicilio.getTipoDomicilio()%>">Cambiar datos de domicilio</a>
			<%}%>
		<%}%>
	</td>

	<td>
		<% domicilio = ordenDAO.getDomicilioFacturacion(); %>
		<% if (domicilio == null) { %>

		<%} else {%>
			
			<%= Convert.capitalizar(Convert.toString(domicilio.getCalle()), false) %> <%= Convert.toString(domicilio.getNumero()) %>
			<%= Convert.toString(domicilio.getEdificio()) %> <%= Convert.toString(domicilio.getPiso()) %>
			<%= Convert.capitalizar(Convert.toString(domicilio.getDepto()), true) %><br>
			<%= Convert.toString(domicilio.getLocalidadExterna(), domicilio.getLocalidad().getNombre()) %> (<%= Convert.toString(domicilio.getCodigoPostal()) %>)<br>
			<%= Convert.toString(domicilio.getProvinciaExterna(), domicilio.getProvincia().getNombre()) %><br>
			<%= Convert.toString(domicilio.getPais().getNombre()) %><br>

			<br><br>
				<%if (ordenDAO.isReadWrite()) {%>
					<a href="<%=CompraHelper.PAGINA_DOMICILIO_%><%=domicilio.getTipoDomicilio()%>">Cambiar datos de domicilio</a>
				<%}%>

		<%}%>
	</td>
</tr>
</table>

<% if (ordenDAO.tieneOtroReceptor()) {%>
<table style="border-collapse: collapse; border: 1px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="10">
<tr style="font-weight: bold; background-color: #5AB5DE;">
	<td align="center" >Destinatario del pedido</td>
</tr>

<tr>
	<td align="center">
		Pedido a nombre de <%= Convert.nombreCompleto(ordenDAO.getNombresReceptor(), ordenDAO.getApellidosReceptor()) %>
		<br><br>
		<%if (ordenDAO.isReadWrite()) {%>
			<a href="<%=CompraHelper.PAGINA_MEDIO_DE_COBRO%>#datosReceptor">Cambiar destinatario</a>
		<%}%>
	</td>
</tr>
</table>
<%}%>

<% if (ordenDAO.getPuntajeWrapper() != null) {%>
<table style="border-collapse: collapse; border: 1px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="10">
<tr style="font-weight: bold; background-color: #5AB5DE;">
	<td align="center" >Datos del programa eXtra!</td>
</tr>

<tr>
	<td align="center">
		Acumular puntos eXtra! para <%= Convert.nombreCompleto(ordenDAO.getPuntajeWrapper().getNombreSocio(), ordenDAO.getPuntajeWrapper().getApellidoSocio()) %><br>
		(tarjeta número <%= Convert.toString(ordenDAO.getNumeroTarjetaExtra()) %>)<br>
		<%if (ordenDAO.isReadWrite()) {%>
			<br>
			<a href="<%=CompraHelper.PAGINA_MEDIO_DE_COBRO%>">Cambiar tarjeta</a>
		<%}%>
	</td>
</tr>
</table>
<%}%>
