<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idGrupo" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idSubFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="detalle" scope="page" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="requiereMesa" scope="page" ignore="true" classname="java.lang.String"/>

<%
	idGrupo = request.getParameter("idGrupo");
	idFamilia = request.getParameter("idFamilia");
	idSubFamilia = request.getParameter("idSubFamilia");
	Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/js.htm"));
	try {
		Template tmp  = new Template(path);

		if (idGrupo != null) {
			StringBuffer subSec = new StringBuffer();
			subSec.append("subSeccion=\"_");
			subSec.append(idGrupo);
			if (idFamilia != null) {
				subSec.append("_").append(idFamilia);
				if (idSubFamilia != null) {
					subSec.append("_").append(idSubFamilia);
				}
			}
			subSec.append("\";");
			tmp.setParam("subSeccion", subSec.toString());
		}
		tmp.setParam("mesa", requiereMesa);
		if (detalle != null) {
			tmp.setParam("seccionDetalle", detalle);
		}

		switch(idSeccion.intValue()){
			case Globals.SECCION_HOME:	{
				tmp.setParam("seccionHOME","true");
			} break;
			case Globals.SECCION_LIBRO:	{
				tmp.setParam("seccionLIBROS","true");
			} break;
			case Globals.SECCION_JUGUETES: {
				tmp.setParam("seccionPASATIEMPOS","true");
			} break;
			case Globals.SECCION_MUSICA: {
				tmp.setParam("seccionMUSICA","true");
			} break;
			case Globals.SECCION_PELICULA: {
				tmp.setParam("seccionPELICULAS","true");
			}  break;
			case Globals.SECCION_SUCURSALES: {
				tmp.setParam("seccionSUCURSALES","true");
			} break;
			case Globals.SECCION_QUID: {
				tmp.setParam("seccionQUID","true");
			} break;
			case Globals.SECCION_EXTRA: {
				tmp.setParam("seccionEXTRA","true");
			} break;
			case Globals.SECCION_MICUENTA: {
				tmp.setParam("seccionMICUENTA","true");
			} break;
			case Globals.SECCION_EMPLEO: {
				tmp.setParam("seccionEMPLEO","true");
			} break;

		}
		out.println(tmp.output());
	} catch(Exception e) {
//		TmkLogger.info(e);
	}
%>


