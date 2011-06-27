<%@ page import="com.tmk.service.orden.OrdenService,
                 com.tmk.setup.Contenido,
                 java.util.Date,
                 java.util.Vector,
                 com.tmk.kernel.*"%>
<table width="500">
	<tr>
		<td>
			<b>Estadísticas calculadas</b><br>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Visitas (hoy)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeVisitasHoy())%></td>
				</tr>
				<tr>
					<td><i>Usuarios desde comercial (hoy)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeUsuariosRegistradosHoy())%></td>
				</tr>
				<tr>
					<td><i>Pedidos especiales (hoy)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDePedidosEspeciales())%></td>
				</tr>
				<tr>
					<td><i>Productos en carrito persistente (mantenidos por <%=Contenido.getSite().getConfiguracion().getVigenciaDelCarritoEnDias()%> días)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeProductosEnCarrito())%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Comentarios Nuevos</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeComentariosEnEstado("N"))%></td>
				</tr>
				<tr>
					<td width="70%"><i>Comentarios Aprobados</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeComentariosEnEstado("A"))%></td>
				</tr>
				<tr>
					<td width="70%"><i>Comentarios Rechazados</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeComentariosEnEstado("R"))%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<td width="70%"><i>Ordenes en CallCenter (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'2'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes en Control de Fraude (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'1'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes a Enviar a Comercial (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'10'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes Enviadas a Comercial (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'12'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes en Corrección Manual (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'60'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes con Fallas (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'0'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes en Proceso (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, DBUtil.ORDENES_VALIDAS, null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes No Autorizadas (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, "'52'", null))%></td>
				</tr>
				<tr>
					<td><i>Ordenes Rechazadas (mensual)</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadDeOrdenes(true, DBUtil.ORDENES_RECHAZADAS, null))%></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<%
				for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
					MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[i];
					int cantidad  = DBUtil.cantidadDeOrdenes(true, DBUtil.ORDENES_VALIDAS, ("'" + medioDeCobroDAO.getId() + "'"));
					if (cantidad > 0) {
			%>
						<tr>
							<td width="70%"><i>Ordenes Generadas con <%=medioDeCobroDAO.getNombre()%></i></td>
							<td align="right"><%=Convert.toString(cantidad)%></td>
						</tr>
			<%      }
				} %>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<%
				for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
					MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[i];
					int cantidad = DBUtil.cantidadDeOrdenes(true, "'52'", ("'" + medioDeCobroDAO.getId() + "'"));
					if (cantidad > 0) {
			%>
						<tr>
							<td width="70%"><i>Ordenes No autorizadas con <%=medioDeCobroDAO.getNombre()%></i></td>
							<td align="right"><%=Convert.toString(cantidad)%></td>
						</tr>
			<%      }
				} %>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<%
				for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
					MedioDeCobroDAO medioDeCobroDAO = Globals.MEDIOS_DE_COBRO[i];
					int cantidad = DBUtil.cantidadDeOrdenes(true, DBUtil.ORDENES_RECHAZADAS, ("'" + medioDeCobroDAO.getId() + "'"));
					if (cantidad > 0) {
			%>
						<tr>
							<td width="70%"><i>Ordenes Rechazadas con <%=medioDeCobroDAO.getNombre()%></i></td>
							<td align="right"><%=Convert.toString(cantidad)%></td>
						</tr>
			<%      }
				} %>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<tr>
					<%Pair totalesOrdenesHoy = DBUtil.totalesOrdenesHoy();%>
					<td width="70%"><i>Ordenes correctas (hoy)</i></td>
					<td align="right"><%=Convert.toString(totalesOrdenesHoy.getValue1().toString())%></td>
				</tr>
				<tr>
					<td><i>Items</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadItemsVendidosHoy())%></td>
				</tr>
				<tr>
					<td><i>Productos</i></td>
					<td align="right"><%=Convert.toString(DBUtil.cantidadProductosVendidosHoy())%></td>
				</tr>
				<tr>
					<td><i>Total</i></td>
					<td align="right"></i><%=Contenido.precioToString(((Number)totalesOrdenesHoy.getValue2()).doubleValue())%></i></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<table width="100%" align="left" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
				<%Pair totalesOrdenesMes = DBUtil.totalesOrdenesMes();%>
				<tr>
					<td width="70%"><i>Ordenes del mes en proceso</i></td>
					<td align="right"><%=Convert.toString(totalesOrdenesMes.getValue1().toString())%></td>
				</tr>
				<tr>
					<td><i>Importe máximo a confirmar</i></td>
					<td align="right"><%=Contenido.precioToString(((Number)totalesOrdenesMes.getValue2()).doubleValue())%></td>
				</tr>
			</table>
		</td>
	</tr>
</table>
<% out.flush(); %>
