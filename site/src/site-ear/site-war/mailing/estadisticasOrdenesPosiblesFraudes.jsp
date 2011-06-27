<%@ page import="com.tmk.orden.*,
                 java.util.*,
                 com.tmk.setup.*,
                 com.tmk.kernel.*,
                 com.tmk.service.orden.OrdenService"%>
<%
	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	Iterator ordenesFraudulentas = ordenLocalHome.findOrdenesFraudulentas().iterator();

	if (ordenesFraudulentas.hasNext()) {
%>
	<br><b>Posibles fraudes</b><br>
<%
		String color = "red";
		for (int index = 1; ordenesFraudulentas.hasNext(); index++) {
			OrdenLocal ordenLocal = (OrdenLocal)ordenesFraudulentas.next();
			try {
				OrdenDAO ordenDAO = OrdenService.cargarOrden(ordenLocal.getID_ORDEN().intValue());
				DomicilioDAO domicilioDAO = ordenDAO.getAlgunDomicilioEnvio();
				if (domicilioDAO == null) {
					domicilioDAO = ordenDAO.getDomicilioFacturacion();
				}
%>
			<%@include file="/mailing/detalleOrdenes.jsp"%>
			<% out.flush(); %>
		<%  } catch (Exception e) {%>
			<br><b>No se pudo cargar la Orden# <%=Convert.toString(ordenLocal.getID_ORDEN())%></b><br>
		<%  } %>
		<br>
<%      }%>
<%	} else {%>
		No se registraron ordenes con posibles fraudes.
<%	}%>