<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%@ page import="javax.naming.InitialContext,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.DBUtil,
                 com.tmk.orden.OrdenLocalHome,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.orden.OrdenLocal,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.EstadoOrdenDAO,
                 com.tmk.kernel.Globals,
                 java.util.*,
                 com.tmk.service.orden.OrdenService,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>

<%
	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/compra/misOrdenes.jsp");
		response.sendRedirect("/");
	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/compra/misOrdenes.jsp");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
}%>

<%	
	SocioPK socioPK = (SocioPK)session.getAttribute("Registracion.socioPK");
	OrdenLocalHome ordenLocalHome = (OrdenLocalHome)DBUtil.getHome("Orden");
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpMisOrdenes");
%>

<%
	//ORDENES EN PROCESO
    Iterator ordenesEnProceso = ordenLocalHome.findOrdenesEnProceso(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
	Vector vec = new Vector();
	if (ordenesEnProceso.hasNext()) {
		while (ordenesEnProceso.hasNext()) {
			OrdenLocal ordenLocal = (OrdenLocal)ordenesEnProceso.next();
			Hashtable has = new Hashtable();			
			has.put("fecha",Convert.toStringLargo(ordenLocal.getFECHA()));
			has.put("idOrden", ordenLocal.getID_ORDEN());//<a href="/compra/detalleOrden.jsp?idOrden=<%=ordenLocal.getID_ORDEN() %" class="Flink02"><%=Convert.toString(ordenLocal.getID_ORDEN())% </a>
			has.put("estado",EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getNombre());
			has.put("precio",Contenido.precioToString(ordenLocal.getTOTAL().doubleValue()));
			vec.add(has);
       	}
		template.setParam("ordenesEnProceso",vec);	
   	}					
	template.setParam("tieneOrdenesEnProceso",(vec.size()>0)); 

	//ORDENES PROCESADAS
	Iterator ordenesProcesadas = ordenLocalHome.findOrdenesProcesadas(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
	Vector vecProcesadas = new Vector();
	if (ordenesProcesadas.hasNext()) {
		while (ordenesProcesadas.hasNext()) {
			OrdenLocal ordenLocal = (OrdenLocal)ordenesProcesadas.next();
			Hashtable has = new Hashtable();			
			has.put("fecha",Convert.toStringLargo(ordenLocal.getFECHA()));
			has.put("idOrden", ordenLocal.getID_ORDEN());//<a href="/compra/detalleOrden.jsp?idOrden=<%=ordenLocal.getID_ORDEN() %" class="Flink02"><%=Convert.toString(ordenLocal.getID_ORDEN())% </a>
			has.put("estado",EstadoOrdenDAO.buscaEstadoOrden(ordenLocal.getESTADO()).getNombre());
			has.put("precio",Contenido.precioToString(ordenLocal.getTOTAL().doubleValue()));
			vecProcesadas.add(has);
        }
		template.setParam("ordenesProcesadas",vecProcesadas);	
   	}
  	template.setParam("tieneOrdenesProcesadas",(vecProcesadas.size()>0)); //NO HAY ORDENES EN PROCESO AL DIA DE HOY				    	             	

  	request.setAttribute("idSeccion",Globals.SECCION_HOME);
	request.setAttribute("template",template);
%>

<tiles:insert definition="tiles.micuenta.ordenes.promociones"> </tiles:insert>