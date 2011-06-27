<%@ page import="com.tmk.kernel.Globals, 
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.kernel.DBUtil, 
				 com.tmk.kernel.Convert,
				 com.tmk.setup.Contenido,
				 com.tmk.kernel.site.Pagina,
				 com.tmk.controllers.buscador.BusquedaGenerica,
				 com.tmk.controllers.buscador.BusquedaPorIDdeAutor,
				 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
				 com.tmk.kernel.DisponibilidadDAO,
				 com.tmk.controllers.buscador.BusquedaPorCategorias,
				 com.tmk.controllers.buscador.BuscadorHelper,
				 com.tmcom.tmk.service.categoria.CategoriaService,
				 com.tmk.controllers.MainHelper"%>
				 
<%
int idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), 0);  

int recorridoInicial = Convert.toNumber(request.getParameter("recorridoInicial"), 1); 
int recorridoFinal = Convert.toNumber(request.getParameter("recorridoFinal"), 5); 
boolean paginado = Convert.toBoolean(request.getParameter("paginado"),false);


Pagina paginaXML = null;
for (int i=0; i<Contenido.getSite().getPaginas().getPaginaCount(); i++) {
	if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {
		paginaXML = Contenido.getSite().getPaginas().getPagina(i);	
	}	
}

if (paginaXML != null) {
%>
<table width="390" border="0" cellpadding="0" cellspacing="0" <%=(paginado)?"class=\"modulosmedio\"":""%>>
  <tr>
    <td width="50" class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-recorridos.gif" alt="Recorridos" width="90" height="12"/></td>
  </tr>
<%
	int cantidadRecorridos =paginaXML.getRecorridos().getRecorridoCount();
int recorridosPorPagina = 5;

	for (int i=recorridoInicial-1; paginaXML.getRecorridos()!=null && i<Math.min(recorridoFinal, cantidadRecorridos); i++) {
		   int idGrupo = paginaXML.getRecorridos().getRecorrido(i).getIdGrupo();
		   String descGrupo =paginaXML.getRecorridos().getRecorrido(i).getDescripcion();
		   
		   BusquedaGenerica buscadorPorCategoria = new BusquedaPorCategorias(descGrupo, new Integer(idSeccion)
		   , new Integer(idGrupo), (Integer)null, (Integer)null, new Integer (1)
			, new Integer (10), BuscadorHelper.CRIT_MAS_VENDIDOS,  false);
%>  
	<tr>
	    <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="paseostabla01">
	      <tr>
	        <td width="135" valign="top"><div align="left"><a href="<%=buscadorPorCategoria.salto()%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/p-sec<%=idSeccion%>-<%=idGrupo%>.gif" alt="<%=descGrupo%>"  class="pasesoimagen" border="0"/></a>
			</div></td>
	        <td width="251" valign="top">
	        
<%
	        	//tomo como autor mas vendido el que tiene mas articulos en el ranking de mas_vendidos para ese grupo
	        	String [][] autorMasVendido = null;
	        	String idAutor = DBUtil.getAutoresMasVendidos(
	        			(idSeccion==Globals.SECCION_PELICULA)?"'D02', 'E01'":"'A01'", idSeccion, idGrupo, 1);

	        		
	        	if (idAutor != null && !"".equals(idAutor)) {
	        		autorMasVendido = DBUtil.getFavoritos(idSeccion, (idSeccion==Globals.SECCION_PELICULA)?"'D02', 'E01'":"'A01'", idAutor);
	        	}
	        %>	        
	  <table width="251" border="0" cellspacing="0" cellpadding="0">
      
<%
      	if (autorMasVendido!= null && autorMasVendido[0][0]!= null) {

      		BusquedaGenerica buscador = new BusquedaPorIDdeAutor((idSeccion == Globals.SECCION_MUSICA)?autorMasVendido[0][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(autorMasVendido[0][1]).toUpperCase()
      				, new Integer(autorMasVendido[0][0]), new Integer(idSeccion), new Integer (0)
      				, new Integer (10), BuscadorHelper.CRIT_MAS_VENDIDOS, false);
      %>         
          <tr>
            <td class="paseosceldatit"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-top5autor.gif" alt="" align="left"/></td>
          </tr>

          <tr>
            <td class="paseoscontent">
            	<table width="241" border="0" cellpadding="0" cellspacing="0">
              		<tr>
		                <td width="20" rowspan="3" class="topnumeros"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/top-1.gif" alt="Puesto 1" width="15" height="17" /></td>
		                <td width="221" class="paseosceldanombre"><div align="left"><span class="FProductos"><a href="<%=buscador.salto()%>" class="Fautores<%=idSeccion%>"><%=(idSeccion == Globals.SECCION_MUSICA)?autorMasVendido[0][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(autorMasVendido[0][1]).toUpperCase()%></a></span><br />
	                        <a href="<%=buscador.salto()%>" class="Fautores"><%=autorMasVendido[0][2]%> <%=Convert.plural(new Integer (autorMasVendido[0][2]).intValue(), Globals.productoSeccion(idSeccion))%></a><a href="#" class="FCategorias"><br /></a></div>
	                    </td>
              		</tr>
		            <tr>
	        	        <td valign="bottom" class="paseosceldanombre"></td>
	                </tr>

		<!-- ETAPA II -->              		
              		<tr>
		                <td class="paseosceldave" valign="bottom"><a href="/ranking/rankingRecorridoArtistas.jsp?idSeccion=<%=idSeccion%>&idGrupo=<%=idGrupo%>"><img src="/imagenes/musica/b-ranking.gif" alt="Ver ranking completo" width="148" height="10" border="0" /></a></td>
        	        </tr>
		<!-- ETAPA II -->

            	</table>
           	</td>
          </tr>
<%
	}
	ArticuloClass articulos [] = ArticuloManager.getArticulosParaTop(idSeccion, idGrupo, -1, 1);
	if (articulos != null && articulos.length>0) {
		
		BusquedaPorAtributoPrincipal buscador = new BusquedaPorAtributoPrincipal(articulos[0].getAtributoPrincipal().toUpperCase()
				, articulos[0].getIdAtributoPrincipal(), new Integer(idSeccion), new Integer (0)
				, new Integer (10), BuscadorHelper.CRIT_MAS_VENDIDOS, false);
%>          
          <tr>
            <td class="paseosceldatit2" align="right"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-top5producto.gif" alt="" align="left" /></td>
          </tr>
          <tr>
            <td class="paseoscontent"><table width="241" border="0" cellpadding="0" cellspacing="0">
                <tr>
                  <td width="20" rowspan="3" class="topnumeros"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/top-1.gif" alt="Puesto 1" width="15" height="17" /></td>
                  <td class="paseosceldanombre" colspan="3"><div align="left"><span class="FProductos"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>"><%=articulos[0].getTitulo()%></a></span>
                  		<%
                  			String atributoPrincipal = "";
                  		                  			if (articulos[0].getAtributoPrincipal() != null && !"".equals(articulos[0].getAtributoPrincipal())) {
                  		                  				atributoPrincipal = articulos[0].getAtributoPrincipal() + " - ";
                  		%>
                  			<br />
                          <a href="<%=buscador.buscador.salto()%>" class="Fautores"><%=articulos[0].getAtributoPrincipal().toUpperCase()%></a><br />
                        <%
                        	}
                        %>
                      </div>
                  </td>
                </tr>
               <tr>
                  <td class="paseosceldanombre" width="129" valign="bottom"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[0].getPrecio())%></span></div></td>
                  <td class="paseosceldanombre" colspan="2">
                   <div align="left">
	              		<table width="2" border="0" cellspacing="0" cellpadding="0">
	      	            	<tr>
	      	                	<td height="19" class="divInfo"><a class="FProductos" href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[0].getTitulo(), true).toUpperCase() %>" border="0"/></a></td>
	      	                  	<td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible() && articulos[0].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[0].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[0].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0" class="espacioizquierda"/></a><%}%></td>
	                        </tr>
	                    </table>
	            	</div>
                  </td>
                </tr>
                <tr>
                  <td class="paseosceldave"colspan="3" valign="bottom"><a href="/ranking/rankingRecorridoArticulos.jsp?idSeccion=<%=idSeccion%>&idGrupo=<%=idGrupo%>"><img src="/imagenes/musica/b-ranking.gif" alt="Ver ranking completo" width="148" height="10" border="0" /></a></td>
                </tr>
            </table></td>
          </tr>
<%
			}
%>          
          <tr>
            <td>&nbsp;</td>
          </tr>
        </table>
    		</td>
      		</tr>
	    </table></td>
  	</tr>
<%
	}		
%>

<%if(paginado){%>

  <%
      int totalPaginas = (int)Math.ceil((double)cantidadRecorridos/recorridosPorPagina);
      if (totalPaginas>1) { 
  %>  
                 
	 <tr class="modulobuscador">
	 <td class="celdapaginas">
  <%
         	int paginaActual = (int)Math.ceil((double)recorridoInicial/recorridosPorPagina);
			if (paginaActual > 1) {						
  %>        
                          	<a href="/ranking/recorridosDisponibles.jsp?idSeccion=<%=idSeccion%>&recorridoInicial=<%=((((paginaActual-1)*recorridosPorPagina)+1)-recorridosPorPagina)%>&recorridoFinal=<%=((paginaActual-1)*recorridosPorPagina)%>" class="FAyuda">Anterior</a> 
                          		<span class="Ftexto05">|</span> 
				<%
					}
				%>
                <%
	    			for (int x=Math.max(paginaActual-5, 1); 
	    					x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {
	    				
	    				if (paginaActual == x) {
                %>          		
                         	<a href="/ranking/recorridosDisponibles.jsp?idSeccion=<%=idSeccion%>&recorridoInicial=<%=(((x*recorridosPorPagina)+1)-recorridosPorPagina)%>&recorridoFinal=<%=Math.min((x*recorridosPorPagina),cantidadRecorridos)%>" class="FAyuda"><b><%=x%></b></a> 
                         	
                <%
	    				} else {
                %>         	
    	                    <a href="/ranking/recorridosDisponibles.jsp?idSeccion=<%=idSeccion%>&recorridoInicial=<%=(((x*recorridosPorPagina)+1)-recorridosPorPagina)%>&recorridoFinal=<%=Math.min((x*recorridosPorPagina),cantidadRecorridos)%>" class="FAyuda"><%=x%></a> 
                <%
	    				}
                	}
                %>     
                <%
	                if ( paginaActual < totalPaginas) {

                %>
                     		
			                 <span class="Ftexto05">| </span><a href="/ranking/recorridosDisponibles.jsp?idSeccion=<%=idSeccion%>&recorridoInicial=<%=((((paginaActual+1)*recorridosPorPagina)+1)-recorridosPorPagina)%>&recorridoFinal=<%=Math.min(((paginaActual+1)*recorridosPorPagina),cantidadRecorridos)%>" class="FAyuda">Siguiente</a>
			    <%
	                }
			    %>             
                          </td>
                        </tr>
                <%
                	}
                %>  	      	

<%}else{%>	

  <tr>
    <td><div align="right"><a href="/ranking/recorridosDisponibles.jsp?idSeccion=<%=idSeccion%>&recorridoInicial=1&recorridoFinal=<%=Math.min(5,cantidadRecorridos)%>"><img src="/imagenes/musica/b-recorridos.gif" alt="Ver mas recorridos" width="131" height="10" border="0" class="Gvermasimage" /></a></div></td>
  </tr>

<%} %>
	
</table>  

<%
}
%>
      
        
