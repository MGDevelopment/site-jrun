<%@ page import="javax.naming.InitialContext,
				 java.util.Vector,
				 java.util.Iterator,
				 com.tmk.kernel.Convert,
				 com.tmk.orden.Promocion2,
				 com.tmk.src.socio.SocioPK,
				 com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
                 com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="java.util.Hashtable"%>
                 
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>

<%	SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");

	if(session.getAttribute("Registracion.socioPK") == null) {
		session.setAttribute("URL_REDIRECT", "/miCuenta/promocionesHistoricas.jsp");
		response.sendRedirect("/miCuenta/index.jsp");
		return;
	} else if (Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false)) {
		session.setAttribute(MainHelper.URL_REDIRECT,  "/miCuenta/promocionesHistoricas.jsp");
		response.sendRedirect("/miCuenta/registroSocioCadena.jsp");
		return;
	}
%>

<%		
	Vector promociones = Promocion2.consultarPromocionesHistoricas(socioPK.ID_SOCIO.intValue(), socioPK.ID_SUCURSAL.intValue());
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpPromocionesHistoricas");
	Vector vec = new Vector(); 
	if (!promociones.isEmpty()) {		
         for (int i = 0; (promociones != null) && (i < promociones.size()); i++) {
			Promocion2 promocion = (Promocion2)(promociones.get(i));
			Hashtable has =  new Hashtable();
			has.put("nombrePromocion",Convert.toString(promocion.getNombre()));
			has.put("descripcion",Convert.toString(promocion.getComentarios()));
			has.put("fechaDeInicio",Convert.toString(promocion.getFInicio()));
			has.put("fechaDeFinalizacion",Convert.toString(promocion.getFFin()));
			vec.add(has);
         }
         template.setParam("promociones",vec);
	}
    template.setParam("hayPromociones",vec.size() > 0);
    request.setAttribute("StringTemplate",template.output());    
    request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
%>

<tiles:insert definition="tiles.micuenta.ordenes.promociones"/>