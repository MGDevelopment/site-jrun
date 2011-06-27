<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.controllers.buscador.BusquedaPorCategorias,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.setup.Contenido,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.kernel.DisponibilidadDAO,
                 java.util.Vector,
                 com.tmk.service.categoria.CategoriaService"%>

<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0);
Vector articulosVisitados = (session.getAttribute("articulosVisitados") == null)? new Vector(): (Vector)(session.getAttribute("articulosVisitados"));
String urlActual = request.getRequestURI();

if (articulosVisitados.size() > 0) {

ArticuloClass articulos[] = ArticuloManager.getArticulosParaUltimosVisitados(articulosVisitados.toString().replaceAll("\\[","").replaceAll("\\]", ""));
%>

<%
	if(idSeccion == Globals.SECCION_LIBRO){
%>

<table align="center" width="390" border="0" cellpadding="0" cellspacing="0" <%=(urlActual.equals("/articulo/ultimosVisitados.jsp"))? "class=\"moduloayudatop\"" : "class=\"modulosmedio\""%>>
                  <tr>
                    <td class="titulosceldas"><table width="390" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
                      <tr>
                        <td><img src="/imagenes/libros/t-ultimosvisitados.gif" alt="&Uacute;ltimos visitados" width="127" height="10" /></td>
                      </tr>
                    </table></td>
                  </tr>
<%
	}else{
%>
<table align="center"  width="390" border="0" cellpadding="0" cellspacing="0" <%=(urlActual.equals("/articulo/ultimosVisitados.jsp"))? "class=\"moduloayudatop\"" : "class=\"modulosmedio\""%>>
                  <tr>
                    <td class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-ultimosvisitados.gif" alt="&uuml;ltimos visitados"  /></td>
                  </tr>
<%
	}
%>

  <%
  	int cantidad = -1;
    	if (!urlActual.equals("/articulo/ultimosVisitados.jsp")){
    		cantidad = articulos.length-4;
    	}
    	for (int i=articulos.length-1; i>Math.max(-1, cantidad); i--) {
  %>
   <tr>
     <td><table align="center" width="386" border="0" cellpadding="0" cellspacing="0" class="Gultimosvitadosprod">
       <tr>
         <td colspan="3">
	         <div align="left"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><%=Convert.corregir(articulos[i].getTitulo(), true)%></a><%
	         	if (articulos[i].getAtributoPrincipal()!= null) { BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),new Integer (1), new Integer(10), BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
	         %><span class="FProductos"> | <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores0"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a></span><%
	         	}
	         %><%
	         	BusquedaPorCategorias busquedaPorCategorias = new BusquedaPorCategorias(articulos[i].getGrupo(), new Integer(articulos[i].getIdSeccion()),new Integer(articulos[i].getIdGrupo()),(Integer)null, (Integer)null, new Integer(1), new Integer(0),BuscadorHelper.CRIT_FECHA_NV, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
	         %><br><a href="<%=busquedaPorCategorias.salto()%>" class="FCategorias"><%=Convert.corregir(articulos[i].getGrupo(), true)%></a></div></td></tr>
	   	<tr>
         <td width="299" valign="bottom" class="Gultimosvitadosprodprecio"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[i].getPrecio())%></span></div></td>
         <td valign="bottom">
         	<div align="right">
	           <table width="2" border="0" cellspacing="0" cellpadding="0" class="divComprar">
	             <tr>
	               <td height="19" class="divInfo"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"  alt="<%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=(articulos[i].getAtributoPrincipal()!= null)?articulos[i].getAtributoPrincipal() + " - ":""%><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase()%>" title="<%=(articulos[i].getAtributoPrincipal()!= null)?articulos[i].getAtributoPrincipal() + " - ":""%><%=Convert.corregir(articulos[i].getTitulo(), true)%>" border="0" /></a></td>
	               <td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) { %><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0" /></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0"/></a><% } %></td>
	             </tr>
	           </table>
	         </div>
         </td>
       </tr>
     </table></td>
   </tr>
   <%} %>

 <%// if (!urlActual.equals("/articulo/ultimosVisitados.jsp")){%>
   <!-- tr>
     <td><div align="right"><a href="/articulo/ultimosVisitados.jsp?idSeccion=<%=idSeccion%>"><img src="/imagenes/inicio/b-vertodos.gif" alt="Ver todos"  border="0" class="Gvermasimage" /></a></div></td>
   </tr-->
 <%	//} %>
 </table>
<%} else { %>

	  <%if(idSeccion==Globals.SECCION_LIBRO){ %>
		<table align="center" width="389" border="0" cellpadding="0" cellspacing="0" class="modulosmedio">
    	  <tr>
	        <td class="titulosceldas"><table width="387" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
    	        <tr>
        	      <td><img src="/imagenes/libros/t-ultimosvisitados.gif" alt="&Uacute;ltimos visitados" width="127" height="10" /></td>
	            </tr>
    	    </table></td>
	      </tr>
	  <%}else{ %>
 	   <table align="center" width="390" border="0" cellpadding="0" cellspacing="0" class="modulosmedio">
		  <tr>
	    	<td class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-ultimosvisitados.gif" alt="Ultimos visitados" /></td>
	      </tr>
	  <% } %>

      <tr>
        <td><div class="GultvisitadosB" align="center">
            <div><img src="/imagenes/<%=(idSeccion==Globals.SECCION_LIBRO)?"libros/ultimosvisitados.gif" : "ultvisitados.gif" %>" height="30" style="margin-top:10px;"></div>
          <div class="Ftexto03" style="margin-top:10px">EN ESTE SECTOR SE CARGARAN AUTOM&Aacute;TICAMENTE TODOS LOS PRODUCTOS QUE VISITES EN NUESTRO SITIO. </div>
        </div></td>
      </tr>

    </table>
<% }%>