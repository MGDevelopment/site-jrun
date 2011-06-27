<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
				 com.tmk.controllers.buscador.BuscadorHelper,
				 com.tmk.kernel.DisponibilidadDAO,
         		 java.net.URLEncoder,
				 com.tmk.setup.Contenido, 
				 com.tmk.service.categoria.CategoriaService" %>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
String nombreGrupo =Convert.toString(request.getParameter("nombreGrupo"));

int cantArticulosPorPagina = 10;
int cantidadDeArticulos = 20;

String idArticulos = "";
ArticuloClass articulos[] = null;

if(idSeccion == Globals.SECCION_LIBRO && !"".equals(nombreGrupo)){
	for (int x=0; x<Contenido.getSite().getRanking().getRankingSeccion().length; x++) {
		if (Contenido.getSite().getRanking().getRankingSeccion(x).getId() == Globals.SECCION_LIBRO) {
			for (int i=0; i<Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo().length; i++) {
				if (Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getNombre().equals(nombreGrupo)) {
					for (int j=0; j<Math.min(Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem().length, 10); j++) {
						idArticulos = idArticulos +  Contenido.getSite().getRanking().getRankingSeccion(x).getRankingGrupo(i).getListaProductosTypeItem(j).getProducto().getId() + ",";
					}
					break;
				}
			}
		}
		break;
	}	
	
	if (idArticulos.length() > 1) {
		idArticulos = idArticulos.substring(0, idArticulos.length()-1);
		articulos = ArticuloManager.getArticulosParaTopDeLibrosExtend(idArticulos);		
	}

}else{	
	if(idSeccion ==  Globals.SECCION_LIBRO){
		cantidadDeArticulos = 100;
	}
	articulos = ArticuloManager.getArticulosParaTopExtend (idSeccion, -1, -1, cantidadDeArticulos);

}

int registroInicial= Convert.toNumber(request.getParameter("registroInicial"),1);
int registroFinal= Convert.toNumber(request.getParameter("registroFinal"),10);

%> 


<% if(articulos != null  && articulos.length>0){ %>		
              <tr>
                <td>                
<!-- IMAGEN DE TITULO PARA LIBRO -->
				<%if(idSeccion == Globals.SECCION_LIBRO){ %>	
					<div class="rankingTitulo1">
						<%if(nombreGrupo.equals("Ficcion")){%>						
						<div class="rankingTitulo2"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-rankingficcion.gif" alt="Ranking Ficci&oacute;n"   /></div>				
							<%  }else if (nombreGrupo.equals("No Ficcion")){%>
						<div class="rankingTitulo2"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-ranking-noficcion.gif" alt="Ranking No Ficci&oacute;n"  /></div>
							<%  }else if (nombreGrupo.equals("Juveniles")){%>
						<div class="rankingTitulo2"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-ranking-juveniles.gif" alt="Ranking Juveniles"  /></div>
							<%  }else if (nombreGrupo.equals("Infantiles")){%>
						<div class="rankingTitulo2"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-ranking-infantiles.gif" alt="Ranking Infantiles" /></div>
							<%  }else if ("".equals(nombreGrupo)){%>
						<div class="rankingTitulo2" height="10"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-rankinglibros.gif" alt="Ranking Libros" /></div>							
						<!-- div class="rankingTitulo2"><img src="/imagenes/<%//=Globals.seccion(idSeccion)%>/ranking/t-ranking-infantiles.gif" alt="Ranking Infantiles" height="10"/></div-->							
							<%} %>
					</div>
				<%}else{ %>	
<!-- IMAGEN DE TITULO PARA EL RESTO -->
 				 <div class="rankingTitulo1">
				  <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/t-ranking.gif" alt="<%=Convert.corregir(Globals.seccion(idSeccion),false)%>"  /></div>
				<%} %>

		<%
			//for (int i=0; i<articulos.length; i++) {
			for (int i=registroInicial-1; i<Math.min(registroFinal, articulos.length); i++) {
			String puesto = Convert.toString(i+1);	
		%>
				<div class="rankingFicha" >				
					<div class="rankingFichaTit" ><div class="rankingFichaNum"><%for (int j=0; j<puesto.length(); j++) {%><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/ranking-0<%=puesto.substring(j,j+1)%>.gif"/><%}%></div>
					<div class="rankingFichaTitInt">
					<a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductosRanking"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a><br/>
		<%					String atributoPrincipal = "";
			          	  	if (articulos[i].getAtributoPrincipal() != null && !"".equals(articulos[i].getAtributoPrincipal())) {
	            				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[i].getAtributoPrincipal(), articulos[i].getIdAtributoPrincipal(), new Integer(articulos[i].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible());
								atributoPrincipal = articulos[i].getAtributoPrincipal() + " - ";
		  	          	    %>
						    <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=articulos[i].getAtributoPrincipal().toUpperCase()%></a></div>
						    <%}else{ %>
						    </div>
						    <%} %>
					</div>				
					<div class="rankingFichaContent">
						<div class="rankingFichaTapa">						
						<%	String imgPage = "/componentes/comunes/imagenHomes.jsp?idArticulo=" + articulos[i].getIdArticulo() + "&idSeccion=" + articulos[i].getIdSeccion() +
										  "&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[i].getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulos[i].getIdSeccion()][4] + "&esNovedad=" + articulos[i].esNovedad() + 
									      "&titulo=" + Convert.corregir(articulos[i].getTitulo(), true).toUpperCase();
									%>
							<jsp:include page="<%=imgPage %>"/>					 	
					 	</div>
<!-- SINOPSIS DE LIBRO, PELICULAS, PASATIEMPOS -->
						<% 
							if (idSeccion != Globals.SECCION_MUSICA) {								  	
								String sinopsis = articulos[i].getSinopsis();															
				         %>
				          <% 	if (sinopsis!=null && !"".equals(sinopsis)) { %>     
            						<div class="rankingFichaTexto">
									   <span class="Ftexto02"><%=sinopsis.substring(0,Math.min(sinopsis.length(),220)) + "... "%><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="Flink02">(Seguir leyendo)</a></span></div>
						<%		}
				          	}else{%>
<!-- SINOPSIS DE MUSICA, MUESTRA LISTA DE TEMAS (solo 5)-->			          		
						<% 
							String temas[] = articulos[i].getTemaMusical(true);  							
								if (temas[0]!= null && temas.length>0) {
						%>
									<div class="rankingFichaTexto">		
						<%
									for(int j=0;j<Math.min(temas.length,5) && temas[j]!= null ;j++){
						%>						
	  					    		<span class="Ftexto02"><%=(j+1)%> - <%=Convert.corregir(temas[j],true)%></span><br>
						<%		
									}
						%>
						<a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="Flink02">...(Seguir leyendo)</a></div>
						<%		}
			       			}
						%>			  					
						<div class="rankingPrecioMod">
							<div id="rankingPrecio" class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[i].getPrecio())%></div>
							<div id="rankingInfoComprar">
							  <table width="2" border="0" cellspacing="0" cellpadding="0" style="margin-top:2px;">
			                    <tr>	
            			          <td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %>" title="<%=atributoPrincipal + Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %>"  border="0" /></a></td>
                      			  <td class="divComprarPedir"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[i].getIdDisponibilidad()).estaDisponible() && articulos[i].getHabilitadoTematika().equals("S")) {%><a href="javascript:agregarProducto(<%=articulos[i].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a><%}else{%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[i].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0" /></a><%}%></td>
			                    </tr>
			                  </table>
							</div>
						</div>
					</div>
				</div>
             <% } %>  
				</td>
		      </tr>

<!--PAGINADOR-->
            <%
                int totalProductos = articulos.length;    
                int totalPaginas = (int)Math.ceil((double)totalProductos/cantArticulosPorPagina);

                	if (totalPaginas>1) {
                %>  
                  
               		<tr class="modulobuscador">
		                <td class="celdapaginas">
				<%
                	int paginaActual = (int)Math.ceil((double)registroInicial/cantArticulosPorPagina);
					if (paginaActual > 1) {						
                %>        
                          	<a href="/ranking/index.jsp?idSeccion=<%=idSeccion%>&nombreGrupo=<%=nombreGrupo%>&registroInicial=<%=((((paginaActual-1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina)%>&registroFinal=<%=((paginaActual-1)*cantArticulosPorPagina)%>" class="FAyuda">Anterior</a> 
                          		<span class="Ftexto05">|</span> 
				<%
					}
				%>
                <%
	    			for (int x=Math.max(paginaActual-5, 1); 
	    					x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {
	    				
	    				if (paginaActual == x) {
                %>          		
                         	<a href="/ranking/index.jsp?idSeccion=<%=idSeccion%>&nombreGrupo=<%=nombreGrupo%>&registroInicial=<%=(((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina)%>&registroFinal=<%=(x*cantArticulosPorPagina)%>" class="FAyuda"><b><%=x%></b></a> 
                         	
                <%
	    				} else {
                %>         	
    	                    <a href="/ranking/index.jsp?idSeccion=<%=idSeccion%>&nombreGrupo=<%=nombreGrupo%>&registroInicial=<%=(((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina)%>&registroFinal=<%=(x*cantArticulosPorPagina)%>" class="FAyuda"><%=x%></a> 
                <%
	    				}
                	}
                %>     
                <%
	                if ( paginaActual < totalPaginas) {

                %>
                     		
			                 <span class="Ftexto05">| </span><a href="/ranking/index.jsp?idSeccion=<%=idSeccion%>&nombreGrupo=<%=nombreGrupo%>&registroInicial=<%=((((paginaActual+1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina)%>&registroFinal=<%=((paginaActual+1)*cantArticulosPorPagina)%>" class="FAyuda">Siguiente</a>
			    <%
	                }
			    %>             
                          </td>
                        </tr>
                <%
                	}
                %>
<!--PAGINADOR-->
	<%} %>              