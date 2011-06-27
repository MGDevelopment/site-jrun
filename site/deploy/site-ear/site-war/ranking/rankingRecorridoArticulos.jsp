<%@ page import="com.tmk.kernel.Globals, 
				 com.tmk.bus.articulo.ArticuloClass,
				 com.tmk.bus.articulo.ArticuloManager,
				 com.tmk.kernel.Convert,
				 com.tmk.setup.Contenido,
				 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
				 com.tmk.kernel.DisponibilidadDAO,
				 com.tmk.controllers.buscador.BuscadorHelper,
				 com.tmk.service.categoria.CategoriaService"%>
				 
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_MUSICA);
int idGrupo = Convert.toNumber(request.getParameter("idGrupo"),Globals.SECCION_MUSICA);
%> 

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>		
		<%= Globals.title((idSeccion==4)?"Recorrido M&uacute;sica - Top 5 Discos":"Recorrido Pel&iacute;culas - Top 5 + Vendidos")%>

<script type="text/JavaScript">
<!--

function MM_preloadImages() { 
  var d=document; if(d.images){ if(!d.MM_p) d.MM_p=new Array();
    var i,j=d.MM_p.length,a=MM_preloadImages.arguments; for(i=0; i<a.length; i++)
    if (a[i].indexOf("#")!=0){ d.MM_p[j]=new Image; d.MM_p[j++].src=a[i];}}
}

//-->
</script>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_<%=Globals.seccion(idSeccion)%>.css" rel="stylesheet" type="text/css" />
<script src="/js/ajax.js" type="text/javascript"></script>
<script src="/js/popUp.js" type="text/javascript"></script>
<script src="/js/carrito.js" type="text/javascript"></script>

</head>

<body onload="MM_preloadImages('/imagenes/<%=Globals.seccion(idSeccion)%>/b-tmtk-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-musica-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-pasatiempos-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-peliculas-over.gif')">
<table width="760" border="0" align="center" cellpadding="0" cellspacing="0" class="Gtablaprincipal">
  <tr>
    <td><table width="740" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="183" valign="middle">        
		<!-- Logo -->
         <%@include file="/componentes/comunes/logo.jsp"%>
        <!-- Logo -->
        </td>
        <td width="557" valign="middle">
        <!-- Login -->
        <%
       	String loginPage = "/componentes/comunes/login.jsp?idSeccion=" + idSeccion;
       	%>
       	<jsp:include page="<%=loginPage%>"/>
        <!-- Login -->
        </td>        
      </tr>
      <% String urlMenuSecciones = "/componentes/" + Globals.seccion(idSeccion) + "/menuSecciones.jsp";%>
	  	 <jsp:include page="<%=urlMenuSecciones%>"/> 
	  <tr>
        <td colspan="2"><div align="center">
          <table width="720" border="0" cellpadding="0" cellspacing="0" class="subcategorias">
            <tr>
              <td>
               <!-- LINK BUSQUEDA -->
	          <% String linkBusqueda = "/componentes/comunes/linkBusqueda.jsp?idSeccion=" + idSeccion;%>
			  	 <jsp:include page="<%=linkBusqueda%>"/>   
              <!-- LINK BUSQUEDA -->
              </td>
            </tr>
          </table>
        </div></td>
      </tr>
	  	 
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="modulobuscadorcarrito">
          <tr>
            <td width="575">
            <%String pageBuscador = "/componentes/" + Globals.seccion(idSeccion) + "/buscador.jsp";%>
            <jsp:include page="<%=pageBuscador%>"/></td>
            <td width="165">
            <!-- Carrito -->
            <% String pageCarrito = "/componentes/comunes/carrito.jsp?idSeccion=" + idSeccion;%>
			<jsp:include page="<%=pageCarrito%>"/>	
          	<!-- Carrito -->
            </td>
          </tr>
        </table></td>
      </tr>
      <tr>
        <td colspan="2"><% String urlBannerTop = "/componentes/comunes/bannerTop.jsp?idSeccion="+idSeccion;%>
			<jsp:include page="<%=urlBannerTop%>"/>  </td>
      </tr>
      <tr>
        <td colspan="2"><table width="740" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido">
          <tr>
            <td  class="Gbarraizquierda"width="139"><table width="130" border="0" align="left" cellpadding="0" cellspacing="0">
             <tr>
                <td align="left" valign="top">
                <!-- ARBOL -->
            	<%
            	//String arbolPage = "/componentes/comunes/arbolCategorias.jsp?tipoArbol=" + idSeccion;
            	String arbolPage = "/contenidosEstaticos/homes/arbolCategorias" + idSeccion + ".html";
            	%>
            	<jsp:include page="<%=arbolPage%>"/>
                <!-- ARBOL --> 
                </td>
              </tr>
              <tr>
               <%
           		String urlInstitucionalLeft = "/componentes/comunes/institucionalLeft.jsp?idSeccion=" + idSeccion;
           	   %>                           
                <jsp:include page="<%=urlInstitucionalLeft%>"/>
              </tr>
            </table></td>
            
            <td class="Gcentro" width="422">
            
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0" >
 			<tr>
			  <td>
           	  <div class="rankingTitulo1">
				  <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-top5producto.gif" alt="Top 5 Discos" align="left" />
			  </div>
			 

<%			
			ArticuloClass articulos [] = ArticuloManager.getArticulosParaTopExtend(idSeccion, idGrupo, -1, 5);
			int puesto = 0;
			if (articulos != null && articulos.length>0) {
				for(int i = 0 ; i < 5 ;i++){			
					puesto++;				
%>          	
				<div class="rankingFicha" >				
					<div class="rankingFichaTit" ><div class="rankingFichaNum"><%for (int j=0; j<Convert.toString(puesto).length(); j++) {%><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/ranking-0<%=Convert.toString(puesto).substring(j,j+1)%>.gif"/><%}%></div>
					<div class="rankingFichaTitInt"><a href="<%=CategoriaService.getURL(articulos[i].getCategoria())+ArticuloManager.getURL(articulos[i])%>" class="FProductosRanking"><%=Convert.corregir(articulos[i].getTitulo(), true).toUpperCase() %></a><br/>
		<%					String atributoPrincipal = "";
			          	  	if (articulos[i].getAtributoPrincipal() != null) {
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
		<%	
				}
			} 
		%>
	           </td></tr>
              <tr>
                <!-- ULTIMOS VISITADOS -->
	                <td>
	                <%
	            	String ultimosVisitadosPage = "/componentes/comunes/ultimosVisitados.jsp?idSeccion=" + idSeccion;
	            	%>
	            	<jsp:include page="<%=ultimosVisitadosPage%>"/>
	                </td>
                 <!-- ULTIMOS VISITADOS -->                 
              </tr>
            </table></td>
             <td class="Gbarraderecha" width="162">
             <!-- top -->
            <%

        	String topPage = "/contenidosEstaticos/homes/top" + idSeccion + ".html";
           	%>
           	<jsp:include page="<%=topPage%>"/>
            <!-- top -->
            </td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
              <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion=" + idSeccion;%>
				 <jsp:include page="<%=urlInstitucional%>"/>
            </div></td>
          </tr>  
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalytics()%>
<%//=(h-Calendar.getInstance().getTimeInMillis()) %>
</body>
</html>