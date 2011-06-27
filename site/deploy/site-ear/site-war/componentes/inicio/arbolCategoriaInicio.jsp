<%@ page import="com.tmk.kernel.site.NuestrasCategorias,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.kernel.site.NuestraCategoriasSeccion,
                 com.tmk.kernel.site.NuestraCategoriasGrupo,
                 com.tmk.kernel.DBUtil,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.bus.categoria.Categoria,
                 com.tmk.bus.categoria.CategoriaPK" %>

<table width="130" cellspacing="0" cellpadding="0" border="0">
	<tr>
	    <td align="left" valign="top">
	    	<table width="130" border="0" cellspacing="0" cellpadding="0">
	      		<tr>
	        		<td>
<%
NuestrasCategorias nuestrasCategorias = Contenido.getSite().getNuestrasCategorias();

for(int i=0; i< nuestrasCategorias.getNuestraCategoriasSeccionCount(); i++) {

	NuestraCategoriasSeccion nuestraCategoriasSeccion = nuestrasCategorias.getNuestraCategoriasSeccion(i);
    int idSeccion = nuestraCategoriasSeccion.getId();
	CategoriaPK categoriaPK = new CategoriaPK (new Integer [] {new Integer(idSeccion)});
	Categoria categoria = CategoriaService.getCategoriaEspecifica (categoriaPK);
%>
	  <div class="GdivSubcatTit2">
	  	<h2 class="FTtit01">
	  	  	<%=categoria.getDescripcion()%>
	  	</h2>
	  </div>
<%

    for (int j=0; j< nuestraCategoriasSeccion.getNuestraCategoriasGrupoCount(); j++)  {
        NuestraCategoriasGrupo nuestraCategoriasGrupo = nuestraCategoriasSeccion.getNuestraCategoriasGrupo(j);
        int idGrupo = nuestraCategoriasGrupo.getId();
        categoriaPK = new CategoriaPK (new Integer [] {new Integer(idSeccion), new Integer(idGrupo)});
		categoria = com.tmk.service.categoria.CategoriaService.getCategoriaEspecifica(categoriaPK);
%>
 		<div id="GdivSubcatSub"><a href="/catalogo<%=CategoriaService.getURL(categoria)%>.htm" class="FSubCategoriasIzq">
 		<%=Convert.capitalizar(categoria.getSubCategoria()[0].getDescripcion(), false)%> (<%=CategoriaService.getCantidadArticulosXCategoria(categoria.getSubCategoria()[0].getCategoriaPK()) %>)</a></div>
<%
    }
%>
		<div id="GdivSubcatSub"><a href="/<%=categoria.getDescripcion().toLowerCase()%>/index.jsp" class="FSubCategoriasIzq">
		Ver mas... </a></div>
<%
}
%>
					</td>
				</tr>
			</table>
		</td>
	</tr>
</table>