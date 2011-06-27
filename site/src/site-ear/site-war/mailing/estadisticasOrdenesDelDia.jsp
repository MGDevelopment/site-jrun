<%@ page import="com.tmk.orden.*,
                 java.util.*,
                 com.tmk.setup.*,
                 com.tmk.kernel.*,
                 com.tmk.service.orden.OrdenService"%>
<%
	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	Iterator ordenesDelDia = ordenLocalHome.findOrdenesDelDia().iterator();
	if (ordenesDelDia.hasNext()) {
%>
	<br><b>Ordenes del día</b><br>
<%
		for (int index = 1; ordenesDelDia.hasNext(); index++) {
			OrdenLocal ordenLocal = (OrdenLocal)ordenesDelDia.next();
			try {
				OrdenDAO ordenDAO = OrdenService.cargarOrden(ordenLocal.getID_ORDEN().intValue());
				DomicilioDAO domicilioDAO = ordenDAO.getAlgunDomicilioEnvio();

				if (domicilioDAO == null) {
					domicilioDAO = ordenDAO.getDomicilioFacturacion();
				}

				String color = (ordenDAO.getEstado().esPagoTarjetaInvalido()) ? "gray" : "green";
%>
			<%@include file="/mailing/detalleOrdenes.jsp"%>
			<% out.flush(); %>
		<%  } catch (Exception e) {%>
			<br><b>No se pudo cargar la Orden# <%=Convert.toString(ordenLocal.getID_ORDEN())%></b><br>
		<%  } %>
		<br>
<%		}%>
<%	} else {%>
		No se registraron ordenes del día.
<%	}%>