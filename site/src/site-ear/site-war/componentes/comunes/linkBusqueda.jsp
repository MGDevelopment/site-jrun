<%@ page import="com.tmk.kernel.Globals, 
				 com.tmk.setup.Contenido,
				 com.tmk.kernel.site.Pagina,
				 com.tmk.controllers.buscador.BusquedaPorCategorias, 
				 com.tmk.kernel.Convert"%>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), Globals.SECCION_HOME); 				 
Pagina paginaXML = null;
for (int i=0; i<Contenido.getSite().getPaginas().getPaginaCount(); i++) {
	if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {
		paginaXML = Contenido.getSite().getPaginas().getPagina(i);	
	}	
}
%>		
<%
if (paginaXML != null) {
%>
<div align="left"><span class="fontsubcategorias">
<%
	for (int i=0; paginaXML.getLinkBusqueda()!=null && paginaXML.getLinkBusqueda().getCategoria()!=null &&
						i<paginaXML.getLinkBusqueda().getCategoriaCount(); i++) {
		BusquedaPorCategorias buscador = new BusquedaPorCategorias(paginaXML.getLinkBusqueda().getCategoria(i).getDescripcion()
				, new Integer(idSeccion), new Integer(paginaXML.getLinkBusqueda().getCategoria(i).getIdGrupo())
				, (paginaXML.getLinkBusqueda().getCategoria(i).getIdFamilia()!= -1)? 
						new Integer(paginaXML.getLinkBusqueda().getCategoria(i).getIdFamilia()):(Integer)null
						, (paginaXML.getLinkBusqueda().getCategoria(i).getIdSubFamilia()!= -1)? 
								new Integer(paginaXML.getLinkBusqueda().getCategoria(i).getIdSubFamilia()):(Integer)null
								, new Integer(0), new Integer(10), null, false);
%>						
	<a href="<%=buscador.salto()%>" class="linksubcategorias"><%=paginaXML.getLinkBusqueda().getCategoria(i).getDescripcion()%></a> |
<%	}
%>
</span><br />
</div>
<%
}
%>	