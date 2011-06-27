<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.kernel.ProfesionDAO"%>
<%@page import="com.tmk.kernel.EstadoCivilDAO"%>
<%@page import="com.tmk.kernel.PaisDAO"%>
<%@page import="com.tmk.kernel.TipoDeDocumentoDAO"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.util.HTML.Template"%>

<%

	Template template = (Template)ServiceLocator.getTemplateService().getTemplate("tmpRegistroSocioCadena");
	boolean esSocioTMK = false;
	//documentos
	Vector vecDocumentos = new Vector();	
	for (int i = 0; i < Globals.TIPOS_DOCUMENTO.length; i++) {
		TipoDeDocumentoDAO tipoDeDocumentoDAO = Globals.TIPOS_DOCUMENTO[i];
		Hashtable has = new Hashtable();
		has.put("tipoDocumentoId",tipoDeDocumentoDAO.getId());
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
		has.put("paisNombre",paisDAO.getNombre());
		vecPaises.add(has);
	}
	template.setParam("paises",vecPaises);
		
	//estado civil
	Vector vecEstadosCiviles = new Vector();
	for (int i = 0; i < Globals.ESTADOS_CIVILES.length; i++) {
		EstadoCivilDAO estadoCivilDAO = Globals.ESTADOS_CIVILES[i];
		Hashtable has = new Hashtable();
		has.put("estadoCivilId",estadoCivilDAO.getId());
		has.put("estadoCivilNombre",estadoCivilDAO.getNombre());
		vecEstadosCiviles.add(has);
	}
	template.setParam("estadosCivil",vecEstadosCiviles);
			
	Vector vecProfesiones = new Vector();
	for (int i = 0; i < Globals.PROFESIONES.length; i++) {
		ProfesionDAO profesionDAO  = Globals.PROFESIONES[i];
		Hashtable has = new Hashtable();
		has.put("profesionId",profesionDAO.getId());
		has.put("profesionNombre",profesionDAO.getNombre());
		vecProfesiones.add(has);
	}
	template.setParam("disabledSocioTMK","");
	template.setParam("profesiones",vecProfesiones);	
	
	if(Globals.esModoRelease()) {
		template.setParam("esModoRelease","true");
		if(request.getHeader("referer")!=null ){			
			template.setParam("parametroReferer",request.getHeader("Referer").indexOf("registroSocioTMK")>-1);
		}
	}
	out.print(template.output());
	
%>