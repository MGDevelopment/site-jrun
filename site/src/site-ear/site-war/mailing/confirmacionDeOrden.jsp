<%@page import="com.tmk.soa.servicios.interfaces.ArcashService"%>
<%@page import="com.tmk.orden.OrdenLocalHome"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>

<%@ page import="com.tmk.orden.OrdenDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.kernel.DomicilioDAO,
                 com.tmk.kernel.Globals,
                 com.tmk.setup.Contenido"%>
<%
	// si tengo la orden no la cargo
	int idOrden = Convert.toNumber(request.getParameter("idOrden"), 0);
	OrdenDAO ordenDAO = OrdenService.cargarOrden(idOrden);
	DomicilioDAO envio = ordenDAO.getAlgunDomicilioEnvio();
%>

<html>
<head>
<STYLE TYPE="text/css">
#aviso {
	float:left;
	border:dashed 1px #F9A13B;
	margin-left:6px;
	margin-bottom:5px;
	display:inline;
	text-align:justify;
	font-size:11px;
	padding:5px;
	background-color:#F0F2F4;
	font-family:arial;
}
</STYLE>
</head>
<body>
<b><font color="#004B85">Muchas gracias por su compra!</font></b> <br>
<br>
<b><font color="#004B85">Su número de orden es:</font> <i><%=ordenDAO.getIdOrdenProcesada()%></i></b><br>
<b><font color="#004B85">Fecha:</font> </b><%=Convert.toStringLargo(ordenDAO.getFechaDeCierre())%><br>
<b><font color="#004B85">Dirección de envío:</font> </b><%out.println(envio!=null?Convert.capitalizar(envio.getCalle(), true) + " " + Convert.toString(envio.getNumero()) + " " + Convert.toString(envio.getEdificio()) + " " + Convert.toString(envio.getPiso()) + " " + Convert.toString(envio.getDepto()):"-");%><br>
<%if(envio!=null){
    if (envio.getCodigoPostal() != null) {%>
<b><font color="#004B85">Código Postal: </font></b><%=envio.getCodigoPostal()%><br>
<%  }
}%>
<b><font color="#004B85">Localidad:</font> </b><%out.println(envio!=null?Convert.toString(envio.getLocalidadExterna(), (envio.getLocalidad() == null) ? "" : envio.getLocalidad().getNombre()):"-");%><br>
<b><font color="#004B85">Provincia:</font> </b><%out.println(envio!=null?Convert.toString(envio.getProvinciaExterna(), (envio.getProvincia() == null) ? "" : envio.getProvincia().getNombre()):"-");%><br>
<%if(envio!=null){
    if (envio.getPais() != null) {%>
<b><font color="#004B85">País:</font> </b><%=envio.getPais().getNombre()%><br>
<%  }
}%><br><br>
<%
	if (ordenDAO.getMedioDeCobro().esFax()) {
%>
<b> <font color="#004B85">Si usted aún no completó y envió el formulario por fax,
presione</font> <a href="<%=Globals.PAGINA_SITIO + "/compra/pagoPorFax.jsp"%>">aquí.</a>
<br>
<br>
</b>
<%
	}
%>
<%
	if (ordenDAO.getMedioDeCobro().esHomeBanking()) {
%>
<b> <font color="#004B85"><b>Aguardamos su pago a través de <a href="http://www.santanderrio.com.ar"><%= ordenDAO.getMedioDeCobro().getNombre() %></a>
con el código <%= idOrden %> por <%= Contenido.precioToString(ordenDAO.totalSitioCompleto()) %>
para enviarle su pedido.</b></font>
<br>
<br>
</b>
<%
	}
%>

<%--MEDIO ARCASH --%>
<%
	if (ordenDAO.getMedioDeCobro().esArcash()) {
		//SocioPK socioPK = (SocioPK) request.getSession.getAttribute("Registracion.socioPK"); 		
		ArcashService service =  ServiceLocator.getArcashService();		
		//armo el pass que despues lo usa el servicio para generar el token
		StringBuffer pass = new StringBuffer("");
		pass.append(service.getIdMerchant());
		pass.append("|");
			pass.append(ordenDAO.totalSitioCompleto());
			pass.append("|");
			pass.append("1");
			pass.append("|");
			pass.append(service.getPasword());
		//Map con todos los parametros	
		Map<String,String> frm = new HashMap<String,String>();
		frm.put("action",service.getPathArash());						
		frm.put("Amount","" + ordenDAO.totalSitioCompleto());
		//frm.put("Amount","48.50");
		//frm.put("Token","15F3FC19823C1F3DEEA1E3D90E0AC70A2FAD6AED");						
		frm.put("Token",ServiceLocator.getArcashService().getToken(ordenDAO,pass.toString()));
		frm.put("ExternalReference","" + ordenDAO.getIdOrdenProcesada());	
%>
	<b> <font color="#004B85"> <b>
	Aguardamos su pago a trav&eacute;s Arcash, para enviarle su pedido. <br>
	Para realizar el pago por favor haga clik en el siguiente bot&oacute;n. <br> 
	<%=service.getLinkDeFormulario(frm)%>	
	
	<%--<b> <font color="#004B85"><b>Aguardamos su pago a través Arcash,el link se encuentra en el segundo e-mail,para enviarle su pedido</b>
	<br>--%>
	<br>
	</b>
<%
	}
%>

<%  if (ordenDAO.getMedioDeCobro().requiereCuponDePago()) {
%>
<font color="#004B85"><b>Aguardamos su pago a través de <%= ordenDAO.getMedioDeCobro().getNombre() %>
<br>Si todavia no imprimió su cupón, por favor ingrese <a href="<%=Globals.PAGINA_SITIO + "/miCuenta/verCuponDePago.jsp?idOrden=" + idOrden%>">aquí</a> para hacerlo.
</font>
<br>
<br>
</b>
<%	
	}
%>

<%  if (ordenDAO.getMedioDeCobro().esDineroMail()) {
%>
<font color="#004B85"><b>Aguardamos su pago a través de <%= ordenDAO.getMedioDeCobro().getNombre() %>
<br>Si todavia no realizo su pago, por favor ingrese <a href="<%=Globals.PAGINA_SITIO + "/miCuenta/verFormDM.jsp?idOrden=" + idOrden%>">aquí</a> para hacerlo.
</font>
<br>
<br>
</b>
<%	
	}
%>
<font color="#004B85">Ante cualquier consulta contáctese con nuestro Departamento
de Servicios al Cliente a través de <a href="mailto:<%=Globals.MAIL_CALL_CENTER%>" style="text-decoration:underline"><%=Globals.MAIL_CALL_CENTER%></a> o por teléfono
al <%=Globals.TELEFONO_CALL_CENTER%> desde la Argentina o al <%=Globals.TELEFONO_EXTERIOR_CALL_CENTER%>
desde el exterior de <%=Globals.HORARIO_CALL_CENTER%>.</font><br>
<br>
<br>
<table border="0" align="center" cellpadding="0" cellspacing="0"  style="margin-top:20px">
    <tr>
    	<td>
    		<table border="0"  cellpadding="0" cellspacing="0">
                <tr>
                	<td>
                		<div id="aviso">            
  									Tenga en cuenta que los pedidos realizados a partir de las 17 hs 
  									(hora de Argentina) tendrán un día hábil adicional de demora respecto 
  									de lo que figura en el status de disponibilidad del producto en la 
  									salida desde el depósito. Para mayor información sobre los tiempos de 
  									despacho y entrega, puede ingresar a:<br> 
  												<a href="<%=Globals.PAGINA_SITIO%>/ayuda/ayudaEstandar.jsp?url=/ayuda/enviosPlazos.jsp" target="blank" class="FAyuda">Información sobre Gastos de Envío y Tiempos de Entrega</a><p>  
							<!-- b>Aviso importante:</b> Le informamos que debido a los tiempos de 
							disponibilidad y despacho de los productos no se garantiza la entrega antes 
							de Navidad para los pedidos realizados a partir del día 15 de diciembre.-->
  						</div>
                	</td>
                </tr>
            </table>
        </td>
    </tr>
</table>    
<br>
<br>
<%--	<img alt="Oblogo" src="http://www.tematika.com/imagenes/oblogo.jpg">
	<p >Junto con tu compra, recibirás un ejemplar gratuito de Oblogo, la revista que selecciona los mejores blogs de Internet</p>
--%>	
<br>
<br>
<a href="<%=Globals.PAGINA_SITIO%>"><strong>GRUPO ILHSA S.A.</strong></a><br>
</body>
</html>