<%@page import="com.tmk.kernel.MailUtil"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tmk.setup.SHA1"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<%@ page import="com.tmk.kernel.Convert,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.service.orden.OrdenService,
                 com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.DBUtil,
                 java.sql.Connection,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.setup.Contenido,
                 java.util.Calendar,
                 java.util.Date"%>

<%@page import="com.tmk.soa.servicios.implementation.ArcashServiceImpl"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="java.util.Map"%>
<%@page import="com.tmk.soa.servicios.interfaces.ArcashService"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
 
<%
 	boolean puedeVerFrm = true;
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
  		if ((ordenDAO != null) && (ordenDAO.getMedioDeCobro().esArcash())) {
 %>	
		


<table border="0" width="100%" cellpadding="0" cellspacing="0">
			<tr>
				<td class="Ftexto02">
					Ingrese a <b>Arcash</b> haciendo click en la <b>imagen</b> para poder realizar su pago.<br>&nbsp;
				</td>
			</tr>
						
			<tr>
				<td align="center">
					<%ArcashService service =  ServiceLocator.getArcashService();%>
					<%	StringBuffer pass = new StringBuffer("");
						pass.append(service.getIdMerchant());
						pass.append("|");
			 			pass.append(ordenDAO.totalSitioCompleto());
			 			pass.append("|");
			 			pass.append("1");
			 			pass.append("|");
			 			pass.append(service.getPasword()); 
		 			%>
					<form action="<%=service.getPathArash()%>" method="post" target="_blank">
						<input type="hidden" name="IDCurrency" value="1"> 
						<input type="hidden" name="Amount" value="<%=ordenDAO.totalSitioCompleto()%>">
						<%--<input type="hidden" name="Amount" value="48.50">--%>						
					 	<input type="hidden" name="IDMerchant" value="<%=service.getIdMerchant()%>">					 	
					 	<input type="hidden" name="Token" value="<%=ServiceLocator.getArcashService().getToken(ordenDAO,pass.toString())%>" > 
					 	<%-- <input type="hidden" name="Token" value="15F3FC19823C1F3DEEA1E3D90E0AC70A2FAD6AED"> --%>
						<input type="hidden" name="ExternalReference" value="<%=ordenDAO.getIdOrdenProcesada()%>">																
						<input type="hidden" name="Password" value="<%=service.getPasword()%>">
						<input type="hidden" name="Txt1" value="">
						<input type="hidden" name="Txt2" value="">
						<input type="hidden" name="Txt3" value="">
						<input type="image" width="200" height="100" src="<%=service.getLogoArcash()%>" name="submit" alt="Pagá con Arcash!"> 
					</form>					
				</td>
			</tr>
		</table>			

<%
		} else {
			mensaje ="La orden no tiene asignado un pago a través de Arcash.";
		}
	}
	
%>	
	
