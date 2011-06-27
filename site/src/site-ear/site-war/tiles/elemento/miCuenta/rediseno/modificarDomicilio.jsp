<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="com.tmk.soa.servicios.interfaces.SocioDomiciliosService"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.bus.socio.SocioDomicilios"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Hashtable"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.util.Collection"%>
<%@page import="com.tmk.soa.servicios.interfaces.Socio2Service"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.src.socio.SocioPK"%>

<%
	SocioPK pk = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
	Template tmpDomicilios = (Template)ServiceLocator.getTemplateService().getTemplate("tmpModificarDomicilio");
	String tipoDomicilio = request.getParameter("idDomicilio");
	SocioDomiciliosService servicioSocio = ServiceLocator.getSocioDomiciliosService();
	SocioDomicilios domicilio = servicioSocio.getByPKYTipoDomicilio(pk, tipoDomicilio);
		
	if(domicilio != null) {			
		tmpDomicilios.setParam("PAISID",domicilio.getPais().getIdPais());
			if(domicilio.getProvincia()!=null) {
				tmpDomicilios.setParam("PROVINCIAID",domicilio.getProvincia().getId_provincia());
			}else{
				tmpDomicilios.setParam("PROVINCIAID","-1");
			}
			if(domicilio.getLocalidad()!=null){
				tmpDomicilios.setParam("LOCALIDADID",domicilio.getLocalidad().getId_localidad());
			}else{
				tmpDomicilios.setParam("LOCALIDADID","-1");				
			}
			tmpDomicilios.setParam("PROVINCIA_EXTERNA",Convert.toString(domicilio.getDescripcion_localidad_inex()));
			
			if(domicilio.getCalle()!=null){
				tmpDomicilios.setParam("CALLE",domicilio.getCalle());			
			}
			if(domicilio.getNumero()!=null){
				tmpDomicilios.setParam("NUMERO",domicilio.getNumero());
			}		
			if(domicilio.getEdificio()!=null){
				tmpDomicilios.setParam("EDIFICIO",domicilio.getEdificio());
			}
			if(domicilio.getPiso()!=null){
				tmpDomicilios.setParam("PISO",domicilio.getPiso());
			}				
			tmpDomicilios.setParam("CP",Convert.nombrePropio(domicilio.getCp(),false));
			if(domicilio.getDepto()!=null){
				tmpDomicilios.setParam("DEPTO",domicilio.getDepto());
			}
	}

	//seteo de datos para el la ventana modal cuando se va a agregar un nuevo domicilio
	tmpDomicilios.setParam("paisDefaultId", Globals.ARGENTINA.getId());
	tmpDomicilios.setParam("provinciaDefaultId","-1");	
	tmpDomicilios.setParam("localidadDefaultId", "-1");
	//se podira pasar el metodo que tiene dbUtil al SocioDomicilioService, asi dejar de usar DBUtil para acceder a ese metodo.
	//no hago ningun chequeo con el metodo el metodo, devuelve un Integer, pero como el <tmpl_if ...> pone interpreta true si hay distinto de vacio dejo el valor de retorno.
	Integer idOrden = DBUtil.ordenesEnProcesoPorDireccion(pk.ID_SOCIO,pk.ID_SUCURSAL,tipoDomicilio);
	if(idOrden != null){
		tmpDomicilios.setParam("tieneOrdenEnProgreso", "true");
		tmpDomicilios.setParam("idOrden", idOrden);	
	}
	
	//campos hidden, se setean par ser usados en la modificacion de los datos del domiclios cuando se envia el formulario
	tmpDomicilios.setParam("TIPO_DOMICILIO",domicilio.getTipo_domicilio());
	
	//le seteo el diapacher para que vuelva el mismo lugar desde donde modifico los datos del domicilio 
	//tmpDomicilios.setParam("_DISPACHER",request.getRequestURI()+"?idDomicilio="+tipoDomicilio);
	tmpDomicilios.setParam("_DISPACHER","/miCuenta/domicilios.jsp");
	
	out.print(tmpDomicilios.output());
	
%>