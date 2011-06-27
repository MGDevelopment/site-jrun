<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.bus.categoria.CategoriaPK"%>
<%@page import="com.tmk.bus.categoria.Categoria"%>
<%@page import="com.tmk.service.categoria.CategoriaService"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="com.tmk.kernel.Convert"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idGrupo" scope="request" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idFamilia" scope="request" ignore="true" classname="java.lang.Integer"/>
<tiles:useAttribute name="idSubFamilia" scope="request" ignore="true" classname="java.lang.Integer"/>


<%
	idGrupo = Convert.toNumber(request.getParameter("idGrupo"), (Integer)null);
	idFamilia = Convert.toNumber(request.getParameter("idFamilia"), (Integer)null);
	idSubFamilia = Convert.toNumber(request.getParameter("idSubFamilia"), (Integer)null);

	Hashtable path =  new Hashtable();
	path.put("filename",application.getRealPath(MainHelper.RES_TMPL_PATH + "/templates/comunSeccion/tmpMetaTag.htm"));

	try {
		Template tmp  = new Template(path);
		if (idGrupo == null) {
			switch(idSeccion.intValue()){
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
				} break;
			}
		} else {
			CategoriaPK categoriaPK = new CategoriaPK(new Integer[]{idSeccion, idGrupo, idFamilia, idSubFamilia});
			Categoria categoria = CategoriaService.getCategoriaByPK(CategoriaService.categoria, categoriaPK, 0);
			Categoria categoriaGeneral = CategoriaService.getCategoriaEspecifica(categoriaPK);
			tmp.setParam("descripcionCategoria", Convert.capitalizar(categoria.getDescripcion(), false));
			tmp.setParam("descripcionCategoriaGeneral", Convert.capitalizar(categoriaGeneral.getDescripcion(), false));
			tmp.setParam("descripcionURL", categoriaGeneral.getDescripcionLarga());
			tmp.setParam("dominioSitio", Globals.DOMINIO_SITIO);
			tmp.setParam("subcategoria", "true");
		}


		out.println(tmp.output());
	} catch(Exception e) {
		TmkLogger.info(e);
	}
%>


