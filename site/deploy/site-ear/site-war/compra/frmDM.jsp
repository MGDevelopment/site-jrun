<%@ page import="com.tmk.kernel.Convert,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.bus.orden.CuponDePago,
				 com.tmk.service.orden.OrdenService,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.DBUtil,
                 java.sql.Connection,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.setup.Contenido,
                 java.util.Calendar,
                 java.util.Date"%>
 
<%  boolean puedeVerFrm = true;
	Integer idOrden = Convert.toNumber(request.getParameter("idOrden"), (Integer)null);
	SocioPK socioPK = (SocioPK) request.getSession().getAttribute("Registracion.socioPK");
	String mensaje =null;
	if (socioPK == null) {
		puedeVerFrm = false;
		mensaje ="Para realizar el pago debes iniciar sesión con tu usuario y contraseña.";
	}
	OrdenLocal orden = null;
	try {
		OrdenLocalHome ordenLH = (OrdenLocalHome)DBUtil.getHome("Orden");
		orden = ordenLH.findByPrimaryKey(idOrden);
		if (!orden.getID_SOCIO().equals(socioPK.ID_SOCIO) || !orden.getID_SUCURSAL_SOCIO().equals(socioPK.ID_SUCURSAL)) {
			puedeVerFrm = false;
			mensaje ="El cupón que intentas imprimir no corresponde al socio que ha iniciado sesión.";
		}
	} catch (Exception e) {
		puedeVerFrm = false;
		mensaje ="La orden no es válida.";
	}
	
	if (orden == null) {
		puedeVerFrm = false;
	}
	
	if (puedeVerFrm) {
		OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden.intValue());
 		if ((ordenDAO != null) && (ordenDAO.getMedioDeCobro().esDineroMail())) {
			
%>	
		<table border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="Ftexto02">
					Ingrese a <b>Dinero Mail</b> haciendo click en el <b>botón</b> para poder realizar su pago.<br>&nbsp;
				</td>
			</tr>
						
			<tr>
				<td align="center">
					<form action="https://www.dineromail.com/Shop/Shop_Ingreso.asp" method="post" target="_blank">
						<input type="hidden" name="NombreItem" value="Compra en Tematika.com">
						<input type="hidden" name="TipoMoneda" value="1"> 
						<input type="hidden" name="PrecioItem" value="<%=ordenDAO.totalSitioCompleto()%>">
					 	<input type="hidden" name="E_Comercio" value="687588">
						<input type="hidden" name="NroItem" value="<%=ordenDAO.getIdOrdenProcesada()%>"> 
						<input type="hidden" name="image_url" value="http://www.tematika.com/imagenes/Logo-Tematika.gif">
						<input type="hidden" name="DireccionExito" value="http://www.tematika.com/compra/pagoDMOK.jsp">
						<input type="hidden" name="DireccionFracaso" value="http://www.tematika.com/compra/pagoDMFail.jsp">
						<input type="hidden" name="DireccionEnvio" value="">
						<input type="hidden" name="Mensaje" value="">
						<input type='hidden' name="MediosPago" value="7">
						<input type='hidden' name="TRX_ID" value="<%=ordenDAO.getIdOrdenProcesada()%>">
						<input type="submit" value="Pagar con Dinero Mail"> 
					</form>
				</td>
			</tr>
		</table>			

<%
		} else {
			mensaje ="La orden no tiene asignado un pago a través de Dinero Mail.";
		}
	}
	
%>	