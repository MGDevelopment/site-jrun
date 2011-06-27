<%@ page import="java.util.Iterator,
				 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Convert,
                 com.tmk.orden.*,
                 com.tmk.kernel.TmkLogger,
                 com.tmk.kernel.DBUtil,
                 java.util.Vector,
                 com.tmk.kernel.Globals" %>



<%
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	boolean existeOrden = false;

	OrdenDAO ordenDAO = null;
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	try {
		OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
		Vector lasOrdenes = new Vector();
		if (socioPK != null) {
			lasOrdenes.addAll(ordenLocalHome.findOrdenesEnProceso(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
			lasOrdenes.addAll(ordenLocalHome.findOrdenesProcesadas(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
		}
		for (int i = 0; (i<lasOrdenes.size() && (!existeOrden)); i++) {
			OrdenLocal ordenLocal = (OrdenLocal)lasOrdenes.get(i);
			existeOrden = (ordenLocal.getID_ORDEN().intValue() == idOrden);
		}
	}
	catch (Exception e){
		TmkLogger.debug("ORDEN DETALLE]: No se encontro la orden:" + idOrden + " para el socio:" + socioPK.ID_SOCIO + e.toString());

	}

%>
<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html>
	<head>
		<%= Globals.estiloBasico() %>
	</head>

	<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >
		<table width="770" cellspacing="0" cellpadding="0" border="0">
			<tr>
				<td width="390">
					<%@include file="/componentes/comunes/logo.jsp"%>
				</td>
			</tr>
		</table>

		<br>

        <table width="752" cellspacing="0" cellpadding="0" border="0">
		<tr>
			<td bgcolor="#C60000" colspan="6" height="5">
			</td>
        </tr>

		<tr>
			<td bgcolor="#DEE3E7" colspan="6" height="30">
			</td>
        </tr>

		<tr>
			<td style="background: url('/imagenes/sombraSuperior.gif')" colspan="6" height="5">
			</td>
		</tr>
		</table>

		<br>
		<table width="752" border="0">
		<tr>
			<td>
				<table align="center">
					<td width="34" valign="top">
						<img src="/imagenes/miCuenta/bienIsq.gif" width="32" height="52">
					</td>

					<td width="" align="center" valign="middle">
						<div align="center" class="titulocarrito">
						</div>
						<img src="/imagenes/miCuenta/tituloEstadoOrden.gif" >
					</td>

					<td width="34" valign="top">
						<img src="/imagenes/miCuenta/bienDer.gif" width="34" height="52">
					</td>
				</tr>
				</table>
			</td>
		</tr>
<%
	if (existeOrden) {
		ordenDAO = OrdenService.cargarOrden(idOrden);
%>
		<tr>
			<td align="center">
				<table width="650">
				<tr>
					<td>
						<br><br>
						<b>
							<font size="+1">
								Orden: <%=Convert.toString(idOrden)%>
								<br>
							</font>
							<font style="font-size: 12px;">
								Fecha: <%=Convert.toStringLargo(ordenDAO.getFechaDeCierre())%>
							</font>
						</b>
					</td>
				</tr>

				<tr>
					<td>
						<br>
						<%@ include file="/componentes/comunes/totalesCompra.jsp" %>
					</td>
				</tr>

				<tr>
					<td>
						<br>
						<br>
						<b>
							<font size="+1">Detalle de su compra</font>
						</b>
					</td>
				</tr>

				<tr>
					<td>
						<br>
						<%@ include file="/componentes/comunes/articulos.jsp" %>
					</td>
				</tr>

				<%	if((session.getAttribute("Registracion.socioPK") != null)) {%>
				<tr>
					<td align="right">
						<br>
						<br>
						<a href="/compra/misOrdenes.jsp">
							<img src="/imagenes/botonVolver.gif" border="0">
						</a>
					</td>
				</tr>
				<% } %>
				</table>
			</td>
		</tr>
		<tr>
 <%	} else {
			%>
					<td align="center">
						<br><br><br>
						<h3><font color="red">
							UD. NO TIENE ACCESO A ESTA ORDEN O LA ORDEN NO EXISTE.
						</font>
						</h3>
					</td>
			<%	}
			%>
		</tr>
	 	<tr>
		 	<td>
			 	<br><br><br><br><br>

		
			</td>
		</tr>
		</table>
<%=Globals.getGoogleAnalyticsSSL()%>		
	</body>
</html>
