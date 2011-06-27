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
				 com.tmk.controllers.buscador.BuscadorHelper"%>

<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_MUSICA);
int idGrupo = Convert.toNumber(request.getParameter("idGrupo"),Globals.SECCION_MUSICA);
%> 

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\"> 
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
		<%= Globals.icon() %>
		<%= Globals.charset() %>
		<%= Globals.title((idSeccion==4)?"Recorrido M&uacute;sica - Top 5 Artistas":"Recorrido Pel&iacute;culas - Top 5 Directores")%>

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

<body onload="MM_preloadImages('/imagenes/<%=Globals.seccion(idSeccion)%>/b-tmtk-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-pasatiempos-over.gif','/imagenes/<%=Globals.seccion(idSeccion)%>/b-peliculas-over.gif')">
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
            
            <table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
				<tr><td>
				 <div class="rankingTitulo1">
					  <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-top5autor.gif" alt="Top 5 Artistas" align="left"/>
				 </div>
				 
				 <%	      
			//tomo como autor mas vendido el que tiene mas articulos en el ranking de mas_vendidos para ese grupo
			String [][] autorMasVendido = null;
			String [] idAutores = DBUtil.getAutoresMasVendidos(
					(idSeccion==Globals.SECCION_PELICULA)?"'D02', 'E01'":"'A01'", idSeccion, idGrupo, 5).split(",");
			String idsAutores = "";
			for (int i=0; i<idAutores.length; i++) {
 				idsAutores = idsAutores + idAutores[i] + ",";
			}	                  
			if (idsAutores.length()>0) {
				idsAutores = idsAutores.substring(0, idsAutores.length()-1);
			}
			if (idAutores != null){

				int puesto = 0;
				autorMasVendido = DBUtil.getFavoritos(idSeccion, (idSeccion==Globals.SECCION_PELICULA)?"'D02', 'E01'":"'A01'", idsAutores);				
								
		    	for(int i = 0 ; i < Math.min(autorMasVendido.length,5*3) ;i++){		    		
		    		
				 	if(!"".equals(idAutores[i])){

				    puesto++;
				      
  				    	if (autorMasVendido[i][0]!= null) {

						BusquedaGenerica buscador = new BusquedaPorIDdeAutor((idSeccion == Globals.SECCION_MUSICA)?autorMasVendido[i][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(autorMasVendido[i][1]).toUpperCase()
								, new Integer(autorMasVendido[i][0]), new Integer(idSeccion), new Integer (0)
								, new Integer (10), BuscadorHelper.CRIT_MAS_VENDIDOS, false);
		%>         
	          <div class="rankingFicha" >				
					<div class="rankingFichaTit" >
						<div class="rankingFichaNum"><%for (int j=0; j<Convert.toString(puesto).length(); j++) {%><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/ranking/ranking-0<%=Convert.toString(puesto).substring(j,j+1)%>.gif"/><%}%></div>
						<div class="rankingFichaTitInt"><a href="<%=buscador.salto()%>" class="Fautores<%=idSeccion %>"><%=(idSeccion == Globals.SECCION_MUSICA)?autorMasVendido[i][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(autorMasVendido[i][1]).toUpperCase() %></a><br>
						<a href="<%=buscador.salto()%>" class="Fautores"><%=autorMasVendido[i][2]%> <%=Convert.plural(new Integer (autorMasVendido[i][2]).intValue(), Globals.productoSeccion(idSeccion))%></a></div>
	  			   </div>
			  </div> 	
			        
       	<%				}	 %>
       	<%			}	 %>
	    <%	  }	%>
	    <% } 	%>  
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