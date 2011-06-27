+<%@ page import="com.tmk.controllers.buscador.BusquedaPorCategorias,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>

<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), Globals.SECCION_LIBRO);
	String idArticulo = Convert.toString(request.getParameter("idArticulo"));

	ArticuloClass articulo = ArticuloManager.getArticulosParaUltimosVisitados(idArticulo)[0];
	if (articulo.getIdArticulo() != -1) {
		BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(articulo.getGrupo(), new Integer(idSeccion), new Integer(articulo.getIdGrupo()), (Integer)null, (Integer)null,
		new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad()).estaDisponible());
%>
<tr>
   <td class="modulovermascategorias"><span class="Ftexto02">Ver mas productos de:</span><br />
    <a href="<%=busquedaPorCategoria.salto()%>" class="FCategorias"><%=Convert.nombrePropio(articulo.getGrupo(), false)%></a></td>
</tr>
<%  } %>
