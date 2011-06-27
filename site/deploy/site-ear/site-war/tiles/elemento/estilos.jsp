<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="fondoSecciones" scope="page" ignore="true" classname="java.lang.String"/>

<%
Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/estilos.htm"));

	try {
		Template tmp  = new Template(path);
		switch(idSeccion.intValue()){
			case Globals.SECCION_HOME: {
				tmp.setParam("fondoSecciones", fondoSecciones);
				tmp.setParam("seccionHOME","true");
			} break;
			case Globals.SECCION_LIBRO:	tmp.setParam("seccionLIBROS","true"); break;
			case Globals.SECCION_JUGUETES: tmp.setParam("seccionPASATIEMPOS","true"); break;
			case Globals.SECCION_MUSICA: tmp.setParam("seccionMUSICA","true"); break;
			case Globals.SECCION_PELICULA:	tmp.setParam("seccionPELICULAS","true"); break;
			case Globals.SECCION_SUCURSALES: tmp.setParam("seccionSUCURSALES","true"); break;
			case Globals.SECCION_QUID: tmp.setParam("seccionQUID","true"); break;
			case Globals.SECCION_EXTRA: tmp.setParam("seccionEXTRA","true"); break;
			case Globals.SECCION_MICUENTA: tmp.setParam("seccionMICUENTA","true"); break;
			case Globals.SECCION_GENERAL: tmp.setParam("seccionGENERAL","true"); break;
			case Globals.SECCION_EMPLEO: tmp.setParam("seccionEMPLEO","true"); break;

		}
		out.println(tmp.output());
	} catch(Exception e) {
//		TmkLogger.info(e);
	}
%>


