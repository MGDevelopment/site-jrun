
<%@page import="com.tmk.kernel.Convert"%><%@page import="com.tmk.kernel.ProfesionDAO"%>
<%@page import="com.tmk.kernel.EstadoCivilDAO"%>
<%@page import="com.tmk.kernel.PaisDAO"%>
<%@page import="com.tmk.kernel.TipoDeDocumentoDAO"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.src.socio.SocioPK"%>
<%@page import="com.tmk.dbo.DBO"%>
<%@page import="com.tmk.bus.socio.SocioTMK"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.dbo.sql.CamposABuscarDBO"%>
<%
	//campos que necesito para mostrar en el formulario
	CamposABuscarDBO campos = new CamposABuscarDBO();
	campos.agregarCampoABusqueda("nombres");
	campos.agregarCampoABusqueda("apellidos");
	campos.agregarCampoABusqueda("nombres");
	campos.agregarCampoABusqueda("login");
	campos.agregarCampoABusqueda("password");		
	campos.agregarCampoABusqueda("nombres");
%>
<%	
	SocioPK socioPk = (SocioPK)session.getAttribute("Registracion.socioPK");	
	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpModificarSocio");	
	Socios2 socioLocal = null;
	//boolean esSocioTMK = false;
	boolean esSocioTMK = Convert.toBoolean((Boolean)session.getAttribute("socioTMK"), false);
	//datos del socios
	if(esSocioTMK){
		SocioTMK socio = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPk);
		template.setParam("esSocioTMK","true");		
		ServiceLocator.getTemplateService().setSemplate(campos,SocioTMK.class,socio,template);
		esSocioTMK =  true;
	}else {
		socioLocal = ServiceLocator.getSocioService().findByPK(socioPk);		
		ServiceLocator.getTemplateService().setSemplate(campos,Socios2.class,socioLocal,template);
	}
		
	
	//documentos
	Vector vecDocumentos = new Vector();	
	for (int i = 0; i < Globals.TIPOS_DOCUMENTO.length; i++) {
		TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[i];
		Hashtable has = new Hashtable();
		has.put("tipoDocumentoId",tipoDeDocumentoDAO.getId());
		has.put("selected",!esSocioTMK ? (tipoDeDocumentoDAO.getId().equals(socioLocal.getTipo_doc())?"selected":""):"");
		has.put("tipoDeDocumentoNombre",tipoDeDocumentoDAO.getNombre());
		vecDocumentos.add(has);
	}
	template.setParam("tiposDeDocumento",vecDocumentos);
	
	
	

	//pasises
	Vector vecPaises = new Vector();
	for (int i = 0; i < Globals.PAISES.length; i++) {
		PaisDAO paisDAO = Globals.PAISES[i];
		Hashtable has = new Hashtable();
		has.put("paisId",paisDAO.getId());
		has.put("selected",!esSocioTMK?((paisDAO.getId()==socioLocal.getNacionalidad().getIdPais())?"selected":""):"");
		has.put("paisNombre",paisDAO.getNombre());
		vecPaises.add(has);
	}
	template.setParam("paises",vecPaises);
	
	
	
	//sexo	
	if(!esSocioTMK) {
		String sexo = socioLocal.getSexo();		
		if(sexo.equals("M")) {
			template.setParam("checkedSexo"+sexo,"checked");;
		}else {
			template.setParam("checkedSexo"+sexo,"checked");
		}
	}
	
	if(!esSocioTMK){
		template.setParam("tiposDeDocumentoSelected",socioLocal.getTipo_doc());
		template.setParam("nroDoc",socioLocal.getNro_doc()+"");
		template.setParam("paisIdSelected",socioLocal.getNacionalidad().getIdPais()+"");
		template.setParam("checkedSexo",socioLocal.getSexo());
	}
	
	//fecha nacimiento
	String fechaNacDD = "dd";
	String fechaNacMM = "mm";
	String fechaNacAAAA = "aaaa";
	if (!esSocioTMK && socioLocal.getFecha_nacimiento() != null) {
		String fechaNac = socioLocal.getFecha_nacimiento().toString();
		fechaNacAAAA = fechaNac.substring(0, 4);
		fechaNacMM = fechaNac.substring(5, 7);
		fechaNacDD = fechaNac.substring(8, 10);
	}
	template.setParam("fechaNacDD",fechaNacDD);
	template.setParam("fechaNacMM",fechaNacMM);
	template.setParam("fechaNacAAAA",fechaNacAAAA);
		
	//estado civil
	Vector vecEstadosCiviles = new Vector();
	for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
		EstadoCivilDAO estadoCivilDAO = Globals.ESTADOS_CIVILES[i];
		Hashtable has = new Hashtable();
		has.put("estadoCivilId",estadoCivilDAO.getId());
		has.put("selected",(!esSocioTMK)?((estadoCivilDAO.getId().equals(socioLocal.getEstado_civil()))?"selected":""):"");
		has.put("estadoCivilNombre",estadoCivilDAO.getNombre());
		vecEstadosCiviles.add(has);
	}
	template.setParam("estadosCivil",vecEstadosCiviles);
	
	//hijos
	String hijos="";
    if (!esSocioTMK && socioLocal.getHijos()!= null) {
   		hijos = socioLocal.getHijos().toString();
   	}
	template.setParam("hijos",hijos);
	
	//profesion
	int idProfesion = 0;
	if (!esSocioTMK && socioLocal.getId_profesion()!= null) {
   		idProfesion = socioLocal.getId_profesion().intValue();
   	}
	Vector vecProfesiones = new Vector();
	for (int i = 0; i < Globals.PROFESIONES.length; i++) {
		ProfesionDAO profesionDAO  = Globals.PROFESIONES[i];
		Hashtable has = new Hashtable();
		has.put("profesionId",profesionDAO.getId());
		has.put("selected",(!esSocioTMK)?((idProfesion==profesionDAO.getId())?"selected":""):"");
		has.put("profesionNombre",profesionDAO.getNombre());
		vecProfesiones.add(has);
	}
	template.setParam("disabledSocioTMK",(esSocioTMK)?"disabled":"");
	template.setParam("profesiones",vecProfesiones); 
	
	
	response.getWriter().print(template.output());
%>