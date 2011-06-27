<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Hits,
				 com.tmk.kernel.BloqueoIP,
				 com.tmk.kernel.Convert,
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 java.util.Vector"%>
<%
	String isbn = request.getParameter("isbn");
	int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
	ArticuloClass articulo;
	if (isbn != null) {
		articulo = ArticuloManager.getArticuloParaDetalle(isbn);
		if (articulo == null)
		{
			response.sendRedirect("/");
		}
	} else {
		articulo = ArticuloManager.getArticuloParaDetalle(idArticulo);
		if (articulo == null) {
			//hit.enviarAlerta("Acceso a Artículo inexistente " + idArticulo);
			//articulo = ArticuloManager.getArticuloParaDetalle(Globals.ARTICULO_DEFAULT);
			response.sendRedirect("/");
		}
	}

//	 Levanta los ultimos visitados y quita el actual para agregarlo luego
    Vector articulosVisitados = ((Vector)(session.getAttribute("articulosVisitados")));
	articulosVisitados = (articulosVisitados == null)? new Vector(): articulosVisitados;
	articulosVisitados.remove(new Integer(articulo.getIdArticulo()));

	if(articulosVisitados.size()==10) {
		articulosVisitados.remove(0);
	}
    session.setAttribute("articulosVisitados", articulosVisitados);
%>

<%
	String tagPage ="";
	if (Globals.esModoRelease()) {
		tagPage = "/contenidosEstaticos/articulos/" + ((int)Math.floor(articulo.getIdArticulo()/1000) * 1000) + "/tagDetalle" + articulo.getIdArticulo() + ".html";
	} else {
		tagPage = "/articulo/componentes/tag.jsp?idArticulo=" + articulo.getIdArticulo();
	}
%>

<jsp:include page="<%=tagPage%>"/>
<%
String ajaxPage = "/articulo/componentes/funcionesAjax.jsp?idSeccion=" + articulo.getIdSeccion() + "&precio=" + articulo.getPrecio();
%>
<script src="/js/ajax.js" type="text/javascript"></script>
<jsp:include page="<%=ajaxPage%>"/>

<table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
          <tr>
            <td width="139" rowspan=2 class="Gbarraizquierda"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
              <tr>
                <td align="left">
                <!-- ARBOL -->
                </td>
                </tr>
              <tr>

             </tr>
            </table>
             </td>
            <!-- DETALLE GENERADO -->
            <%
	            String detallePage ="";
				if (Globals.esModoRelease()) {
						detallePage  = "/contenidosEstaticos/articulos/" + ((int)Math.floor(articulo.getIdArticulo()/1000) * 1000) + "/detalle" + articulo.getIdArticulo() + ".html";
				} else {
						detallePage  = "/tiles/elemento/detalle/detalle.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion();
				}
			%>
                <jsp:include page="<%=detallePage%>"/>
        </table>

<%articulosVisitados.add(new Integer(articulo.getIdArticulo()));%>

<script languaje="javascript">
	traerModuloExtra();
</script>