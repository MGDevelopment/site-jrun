<%@ page import="com.tmk.kernel.Convert,
	com.tmk.service.categoria.CategoriaService,
	com.tmk.bus.categoria.CategoriaPK,
	com.tmk.controllers.MainHelper"
%>
<%
Integer idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION),(Integer)null);
Integer idGrupo = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_GRUPO),(Integer)null);
Integer idFamilia = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_FAMILIA),(Integer)null);
Integer pk[] = null;

if (idSeccion != null && idGrupo != null && idFamilia != null) {
	pk = new Integer [] {idSeccion, idGrupo, idFamilia};
} else {
	if (idSeccion != null && idGrupo != null) {
		pk = new Integer [] {idSeccion, idGrupo};
	} else {
		if (idSeccion != null) {
	pk = new Integer [] {idSeccion};
		}
	}
}

if (pk != null) {
	out.println(CategoriaService.getArbolCategoria (new CategoriaPK(pk)));
}
%>
