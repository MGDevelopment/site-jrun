<%@ page import="com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 com.tmk.kernel.IdiomaDAO,
                 com.tmk.controllers.buscador.BuscadorHelper,
                 com.tmk.controllers.buscador.BusquedaGenerica,
                 com.tmk.controllers.buscador.CriterioDAO,
                 com.tmk.setup.ImageServer,
                 com.tmk.controllers.buscador.BusquedaPorCategorias,
                 com.tmk.controllers.buscador.BusquedaPorIDdeEditorial,
                 com.tmk.bus.articulo.ArticuloClass,
                 com.tmk.bus.articulo.ArticuloManager,
                 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
                 com.tmk.kernel.DisponibilidadDAO,
                 com.tmk.setup.Contenido,
                 java.util.Date,
   				 java.net.URLEncoder,
                 java.util.regex.Pattern,
                 java.util.Calendar,
                 com.tmk.service.categoria.CategoriaService,
                 com.tmk.bus.categoria.CategoriaPK,
                 com.tmk.bus.categoria.Categoria"%>
<%
int idSeccion = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SECCION),Globals.SECCION_LIBRO);

// Lo crea vacio al comienzo por si alguna clasificacion no esta terminada, o si el usuario quita algun parametro intencionalmente
BusquedaGenerica busquedaDAO;

String textoABuscar = request.getParameter(BuscadorHelper.TEXTO);
textoABuscar = (textoABuscar != null)? textoABuscar.replaceAll("\\'", " "): null;

int claveCriterio = Convert.toNumber(request.getParameter(BuscadorHelper.CRITERIO_ORDEN),BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());
CriterioDAO criterio = new CriterioDAO(new Integer(claveCriterio));

boolean pedidoEspecial = Convert.toBoolean(request.getParameter(BuscadorHelper.PEDIDO_ESPECIAL), false);

Integer registroInicial = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_INICIAL), new Integer(1));
Integer registroFinal = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_FINAL), new Integer(10));

/*out.println("inicial " + registroInicial);
out.println("final " + registroFinal);*/

Integer seccion = new Integer(idSeccion);
Integer grupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);
Integer familia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);
Integer subfamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SUBFAMILIA), (Integer)null);

StringBuffer paginaRecorrido = new StringBuffer();

CategoriaPK categoriaPK = new CategoriaPK(new Integer[]{seccion, grupo, familia, subfamilia});
Categoria categoria = CategoriaService.getCategoriaEspecifica(categoriaPK);


	paginaRecorrido.append("/catalogo" + CategoriaService.getURL(categoria));
	StringBuffer paginaRecorrido2 = new StringBuffer();
	paginaRecorrido2.append("/categorias/verFamilia.jsp?").append(BuscadorHelper.CATEGORIA_SECCION).append("=").append(seccion);
	paginaRecorrido2.append("&").append(BuscadorHelper.CATEGORIA_GRUPO).append("=").append(grupo);
	paginaRecorrido2.append("&").append(BuscadorHelper.CATEGORIA_FAMILIA).append("=").append(familia);
	paginaRecorrido2.append("&").append(BuscadorHelper.CATEGORIA_SUBFAMILIA).append("=").append(subfamilia);


//String[] descripcionesCategorias =  new String[3];
//descripcionesCategorias = DBUtil.getDescripcionCategoria(seccion, grupo, familia, subfamilia);

String descripcionCategoria = categoria.getSubCategoria()[0].getDescripcion();
if (categoria.getSubCategoria()[0].getSubCategoria() != null && categoria.getSubCategoria()[0].getSubCategoria().length>0) {
	descripcionCategoria = categoria.getSubCategoria()[0].getSubCategoria()[0].getDescripcion();
	if (categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria() != null && categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria().length>0) {
		descripcionCategoria = categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria()[0].getDescripcion();
	}
}
descripcionCategoria = Convert.capitalizar(descripcionCategoria, false);

busquedaDAO = new BusquedaPorCategorias(textoABuscar, seccion, grupo, familia, subfamilia, registroInicial, registroFinal, criterio, pedidoEspecial);

busquedaDAO.runQuerySubtotales();
%>

<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><%=descripcionCategoria%> - Venta de <%=Globals.textoSolapa(idSeccion)%> / <%=descripcionCategoria%></title>
<meta name="title" content="Tematika.com: <%=descripcionCategoria%> - Venta de <%=Globals.textoSolapa(idSeccion)%> / <%=descripcionCategoria%>" />
<meta http-equiv="title" content="Tematika.com: <%=descripcionCategoria%> - Venta de <%=Globals.textoSolapa(idSeccion)%> / <%=descripcionCategoria%>" />
<meta name="description" content="Tematika.com: Venta de <%=Globals.textoSolapa(idSeccion)%> online. <%=descripcionCategoria%>. Envíos a domicilio. Ofertas y promociones. Gran variedad y disponibilidad." />
<meta http-equiv="DC.Description" content="Tematika.com: Venta de <%=Globals.textoSolapa(idSeccion)%> online. <%=descripcionCategoria%>. Envíos a domicilio. Ofertas y promociones. Gran variedad y disponibilidad." />
<meta name="keywords" content="<%=Globals.textoSolapa(idSeccion)%>, <%=descripcionCategoria%>, venta, online, internet, comprar, compra, español, envios, domicilio, argentina, tematika" />
<meta http-equiv="DC.Keywords" content="<%=Globals.textoSolapa(idSeccion)%>, <%=descripcionCategoria%>, venta, online, internet, comprar, compra, español, envios, domicilio, argentina, tematika" />
<meta name="distribution" content="Global" />
<meta name="copyright" content="Tematika.com" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta name="AUTHOR" content="Tematika.com" />
<meta name="AuthorMetatags" content="NetOne" />
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<meta name="Resource-type" content="Document" />
<link href="http://<%=Globals.DOMINIO_SITIO%>/rss/<%=categoria.getDescripcionLarga()%>.xml" title="RSS" type="application/rss+xml" rel="alternate"/>
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
	  <% if (idSeccion != Globals.SECCION_HOME) { %>
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
      <%} %>

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
            		String arbolPage = "/contenidosEstaticos/familias/arbol_" + seccion + "_" + grupo + ((familia!=null)? "_" + familia:"") + ".html";
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
            <td class="Gcentro" width="422"><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
				<%
					StringBuffer idsArticulo = new StringBuffer("");
					int cantArticulosPorPagina = 6;
					int paginaActual = (int)Math.ceil((double)registroInicial.intValue()/cantArticulosPorPagina);
					if (paginaActual == 1) {
						if (Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones() !=null) {
							com.tmk.kernel.site.RecorridoSeccion reSeccion[] = Contenido.getSite().getRecorridoPorTemas().getRecorridoSecciones().getRecorridoSeccion();
							for (int i=0; i<reSeccion.length; i++) {
								if (reSeccion[i].getId() == seccion.intValue()) {
//									out.println("Seccion " + reSeccion[i].getId() + "<br>");
									if (grupo != null) {
										if (reSeccion[i].getRecorridoGrupos() != null) {
											com.tmk.kernel.site.RecorridoGrupo reGrupo[] = reSeccion[i].getRecorridoGrupos().getRecorridoGrupo();
											for (int j=0; j<reGrupo.length; j++) {
												if (reGrupo[j].getId() == grupo.intValue()) {
//													out.println("Grupo " + reGrupo[j].getId() + "<br>");
													if (familia != null) {
														if (reGrupo[j].getRecorridoFamilias() != null) {
															com.tmk.kernel.site.RecorridoFamilia reFamilia[] = reGrupo[j].getRecorridoFamilias().getRecorridoFamilia();
															for (int k=0; k<reFamilia.length; k++) {
																if (reFamilia[k].getId() == familia.intValue()) {
//																	out.println("Familia " + reFamilia[k].getId() + "<br>");
																	if (subfamilia != null) {
//																		out.println("Sub Familia" + "<br>");
																		// No llega hasta subfamilia
																	} else {
																		com.tmk.kernel.site.Producto productos[] = reFamilia[k].getClaves().getProducto();
																		for (int m=0; m<productos.length; m++) {
																			if (productos[m].getVencimiento() == null || productos[m].getVencimiento().after(new Date())) {
																				idsArticulo.append(productos[m].getId()).append(",");
																			}
//																			out.println("Prod fam " + productos[m].getId() + "<br>");
																		}
																	}
																}
															}
														}
													} else {
														if (reGrupo[j].getClaves() != null) {
															com.tmk.kernel.site.Producto productos[] = reGrupo[j].getClaves().getProducto();
															for (int l=0; l<productos.length; l++) {
																if (productos[l].getVencimiento() == null || productos[l].getVencimiento().after(new Date())) {
																	idsArticulo.append(productos[l].getId()).append(",");
																}
	//															out.println("Prod gru " + productos[l].getId() + "<br>");
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}

					}
					//out.println(idsArticulo.toString());
					//out.println ("cuenta " + busquedaDAO.getQuerySubtotales());
					for (int i = 0; i < busquedaDAO.subtotales().length; i++) {
						if ((busquedaDAO.subtotales()[i] > 0) && ((seccion == null) || (seccion.intValue() == i))) {
							//out.println ("datos " + busquedaDAO.getQuery());
							busquedaDAO.setSeccion(new Integer(i));
							busquedaDAO.run();
							StringBuffer ids = new StringBuffer();

							int agregados = (idsArticulo.toString().equals(""))?0:idsArticulo.toString().split(",").length;
							//out.println(agregados);

							for (int index = 0; index < Math.min(busquedaDAO.getItems().size(), cantArticulosPorPagina)-agregados; index++) {
								ids.append(((Integer)busquedaDAO.getItems().get(index)).intValue()).append(",");
							}
							ids = new StringBuffer(idsArticulo.toString() + ids.toString());

							ArticuloClass articulos[] = ArticuloManager.getArticulosParaCatalogo((ids.length()>0)? ids.substring(0, ids.length()-1): "" + Globals.ARTICULO_DEFAULT, busquedaDAO.getSeccion().intValue());

				%>

              <tr>
                <td><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
                    <tr>
                      <td><table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
                         <tr>
					    	<td width="10" rowspan="3" valign="top">
					    	<%
							String imgPage = "/componentes/comunes/imagenDetalle.jsp?idArticulo=" + articulos[0].getIdArticulo() + "&idSeccion=" + articulos[0].getIdSeccion() +
									"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[0].getIdSeccion()][5] + "&alto=" + Globals.tamImagen[articulos[0].getIdSeccion()][6] + "&esNovedad=" + articulos[0].esNovedad() +
									"&titulo=" + Convert.corregir(articulos[0].getTitulo(), true).toUpperCase();
							%>
						    	<a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>"><jsp:include page="<%=imgPage %>"/></a>
					    	</td>

					        <td width="390" valign="top"><div align="left"><a href="<%=CategoriaService.getURL(articulos[0].getCategoria())+ArticuloManager.getURL(articulos[0])%>"><h1 class="FProductosDetalle"><%=Convert.corregir(articulos[0].getTitulo(), true).toUpperCase()%></h1></a>
							<%
			          	  	 if (articulos[0].getAtributoPrincipal() != null) {
		           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
								articulos[0].getAtributoPrincipal(), articulos[0].getIdAtributoPrincipal(), new Integer(articulos[0].getIdSeccion()),
								new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible());%>
					        	<h2 class="fontautoresDetalle"><a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="fontautoresDetalle"><%=articulos[0].getAtributoPrincipal().toUpperCase() %></a></h2></div>
					       <%}%>
					        </td>
					    </tr>
					    <tr>

		               	  <%
		                  	 if (idSeccion == Globals.SECCION_LIBRO) {%>
			                  	  <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">ISBN: <%=articulos[0].getISBN()%><br />
						          <%if (articulos[0].getEditorial() != null && !"".equals(articulos[0].getEditorial())){ %>
						          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulos[0].getEditorial(), false), new Integer(articulos[0].getIdEditorial())
						        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible()); %>
						                  Editorial: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulos[0].getEditorial(), false)%></a><br />
						          <%} %>


							     <%if (articulos[0].getGrupo() != null && !"".equals(articulos[0].getGrupo())) { %>
							      		<%BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(articulos[0].getGrupo(), new Integer(idSeccion), new Integer(articulos[0].getIdGrupo()), (Integer)null, (Integer)null,
						      				new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible()); %>
								  		Clasificaci&oacute;n: <a href="<%=busquedaPorCategoria.salto()%>" class="FProductosDetalle2link"><%=Convert.corregir(articulos[0].getGrupo(), false)%></a><br />
							     <%} %>

							     <%if (articulos[0].getPagina() > 0) { %>
								       P&aacute;ginas: <%=articulos[0].getPagina()%> <br />
								 <%} %>
							    	   Publicaci&oacute;n: <%=Convert.toStringPublicacion(articulos[0].getFechaAlta())%> <%if(articulos[0].getIdioma()!=null){ %>|  Idioma: <%=IdiomaDAO.buscaIdioma(articulos[0].getIdioma()).getNombre()%><%} %><br />

			                     <%if (articulos[0].getFormato() != null && !"".equals(articulos[0].getFormato())) { %>
				                      Formato: <%=articulos[0].getFormato()%>
				                      <br />
			                     <%} %>
							      </div></td>
						 <%	} %>

						 <%
						 	if (idSeccion == Globals.SECCION_JUGUETES) {%>
							      <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">A&ntilde;o: <%=Convert.toStringPublicacion(articulos[0].getFechaAlta())%><br />
				                  </div></td>
						 <% } %>

						 <%
						 	if (idSeccion == Globals.SECCION_MUSICA) {%>
							      <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">
							      <%if (articulos[0].getEditorial() != null && !"".equals(articulos[0].getEditorial())){ %>
							          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulos[0].getEditorial(), false), new Integer(articulos[0].getIdEditorial())
							        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible()); %>
								      Sello discogr&aacute;fico: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulos[0].getEditorial(), false).toUpperCase()%></a><br />
							      <%} %>
				                    A&ntilde;o: <%=Convert.toStringPublicacion(articulos[0].getFechaAlta())%><br />
				                  <%if (articulos[0].getFormato() != null && !"".equals(articulos[0].getFormato())) { %>
			                      	Soporte: <%=Convert.nombrePropio(articulos[0].getFormato(), false)%>
				                  <%} %>
			            	      </div></td>
						 <%	} %>

 						 <%
 						 	if (idSeccion == Globals.SECCION_PELICULA) {%>
								  <td valign="top" class="celdaDetalle"><div class="FProductosDetalle2" align="left">
								  <%if (articulos[0].getEditorial() != null && !"".equals(articulos[0].getEditorial())){ %>
						          <%BusquedaPorIDdeEditorial busquedaPorIDEditorial = new BusquedaPorIDdeEditorial(Convert.nombrePropio(articulos[0].getEditorial(), false), new Integer(articulos[0].getIdEditorial())
						        		  , new Integer(idSeccion), new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible()); %>
								  Productora: <a href="<%=busquedaPorIDEditorial.salto()%>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulos[0].getProductora(), false)%></a><br />
								  <%} %>
			                      Estreno: <%=Convert.toStringPublicacion(articulos[0].getFechaAlta())%><br />
			                      <%if (articulos[0].getFormato() != null && !"".equals(articulos[0].getFormato())) { %>
			                      Formato: <%=articulos[0].getFormato()%>
			                      <br />
			                      <%} %>
		                          <%if (articulos[0].getGrupo() != null && !"".equals(articulos[0].getGrupo())) { %>
					      		  <%BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(articulos[0].getGrupo(), new Integer(idSeccion), new Integer(articulos[0].getIdGrupo()), (Integer)null, (Integer)null,
					      				new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible()); %>
						          		G&eacute;nero:  <a href="<%=busquedaPorCategoria.salto() %>" class="FProductosDetalle2link"><%=Convert.nombrePropio(articulos[0].getGrupo(), false)%></a><br />
			              		  <%} %>
			                      <%if(articulos[0].getPagina()>0) {%>Duración: <%=articulos[0].getPagina()%> min.<%}%>
			                      <br />
				                  </div></td>
  						 <%	} %>
					    </tr>
					    <tr>
						    <td class="celdaDetalle2"><div align="left"><span class="Ftexto01">*<%=DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).getNombre()%></span><br />
						    <%String pathImgGde = ImageServer.obtenerNombreDeTapa(articulos[0].getIdArticulo(), false, idSeccion, new Double (articulos[0].getPorcentajeDescuento()).intValue(), "", articulos[0].esNovedad()); %>
						    <% if (pathImgGde!= null && !"".equals(pathImgGde)) {%>
						    <a href="javascript:mostrarImagen('<%=pathImgGde%>');" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-ampliar imagen.gif" alt="Ampliar Imagen" border="0" class="bAmpliarImagen" /></a>
							<%} %>
					        </div></td>
					    </tr>
                      </table></td>
                    </tr>
                    <tr>
				      <td>
				      	<table width="390" border="0" cellpadding="0" cellspacing="0" class="areaCompra">
				        	<tr>
				          		<td width="275" class="Ftexto02">PRECIO <%=Contenido.precioToString(articulos[0].getPrecio())%> | <%=Contenido.precioDollarToString(articulos[0].getPrecio())%> | <%=Contenido.precioEuroToString(articulos[0].getPrecio())%></td>
						        <td width="100"><div align="right"><%if (DisponibilidadDAO.buscaDisponibilidad(articulos[0].getIdDisponibilidad()).estaDisponible() && articulos[0].getHabilitadoTematika().equals("S")) { %><a href="javascript:agregarProducto(<%=articulos[0].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar-detalle.gif" alt="Comprar"  border="0" /></a><%} else {%><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[0].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Pedir"  border="0" /></a><%} %></div></td>
				        	</tr>
					    </table>
					  </td>
				    </tr>
                </table></td>
              </tr>
              <tr>
                <td>
					<div style="margin-top:10px">
						<% String urlBanner = Contenido.getBannerCategoria(idSeccion,
								(grupo!=null)?grupo.intValue():-1, (familia!=null)?familia.intValue():-1
										,(subfamilia!=null)?subfamilia.intValue():-1);%>
					  	 <%if (urlBanner != null && !urlBanner.equals("")) { %>
					  	 	<%//out.println(urlBanner);%>
						  	 <jsp:include page="<%=urlBanner%>"/>
					  	 <%} %>

					</div>
				</td>
			 </tr>

				<%if(idSeccion != Globals.SECCION_LIBRO){%>
			  <tr>
                <td>&nbsp;</td>
              </tr>
				<%}%>



			  <tr>
                <td><div align="center">
                    <table width="390" border="0" cellspacing="0" cellpadding="0" class="modulobuscador">

		<%if(articulos.length > 1){ %>

                      <tr>
                        <td><table width="390" border="0" cellspacing="0" cellpadding="0" >
                           <tr class="modulosmedio">
                              <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="titulosceldastabla">

					<%if(idSeccion==Globals.SECCION_LIBRO){%>
								  <tr>
                                    <td class="titulosceldas">
                                    <table width="390" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
                                      <tr>
                                        <td><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-otrostitulos.gif" alt="Otros t&iacute;tulos" /></td>
                                      </tr>
                                    </table></td>
                                  </tr>
					<%}else{%>
                                <tr>
                                  <td class="titulosceldas">
                                  <img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-otrostitulos.gif" <%if(idSeccion==Globals.SECCION_JUGUETES){%>alt="Otros productos"<%}else if (idSeccion==Globals.SECCION_MUSICA){%>alt="Otros discos"<%}else{ %>alt="Otros films"<%}%> /></td>
                                </tr>
					<%}%>
                            </table></td>
                           </tr>
						  <%if (idSeccion == Globals.SECCION_PELICULA){%>
			                <tr>
                              <td><table width="390" border="0" align="center" cellpadding="0" cellspacing="0" class="numeroprodSubCat">
                                  <tr>
                                    <td><div align="center" class="Ftexto03"><h1 class="Ftexto06SinAlign">Actualmente hay <strong><%=(idSeccion == Globals.SECCION_HOME)? busquedaDAO.total(): busquedaDAO.subtotales()[idSeccion]%></strong> productos disponibles de la categor&iacute;a:<br />
										  <strong><%=Convert.corregir(categoria.getSubCategoria()[0].getDescripcion(),false)%> <%if(categoria.getSubCategoria()[0].getSubCategoria()!= null && categoria.getSubCategoria()[0].getSubCategoria().length>0){%> &gt; <%=Convert.corregir(categoria.getSubCategoria()[0].getSubCategoria()[0].getDescripcion(),false)%><%if(categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria()!= null && categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria().length>0){%>&gt;<%=Convert.corregir(categoria.getSubCategoria()[0].getSubCategoria()[0].getSubCategoria()[0].getDescripcion(),false)%><%}}%></strong></h1></div></td>
                                  </tr>
                              </table></td>
                            </tr>
                           <%}%>
                        </table></td>
                      </tr>
                      <%if(idSeccion != Globals.SECCION_LIBRO && idSeccion != Globals.SECCION_PELICULA){%>
					  <tr>
        		        <td>&nbsp;</td>
    	          	  </tr>
					  <%}%>


		                <%
		                	for (int y=1; y<articulos.length; y++) {
		                %>

						<tr>
                          <td><table width="390" border="0" cellspacing="0" cellpadding="0" class="moduleproductob">
                              <tr>
                                <td><table width="390" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                    <%	String img2Page = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulos[y].getIdArticulo() + "&idSeccion=" + articulos[y].getIdSeccion() +
											"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[y].getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulos[y].getIdSeccion()][4] + "&esNovedad=" + articulos[y].esNovedad() +
										    "&titulo=" + Convert.corregir(articulos[y].getTitulo(), true).toUpperCase();
									%>
                                        <td width="82" rowspan="5" class="celdafoto">
											<a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>"><jsp:include page="<%=img2Page %>"/></a>
										</td>
                                        <td colspan="3" valign="top" class="celdacontenido"><a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="FProductos"><%=Convert.corregir(articulos[y].getTitulo(),true).toUpperCase()%></a><br>

										  <%
										  String atributoPrincipal = "";
										  if (articulos[y].getAtributoPrincipal() != null && !"".equals(articulos[y].getAtributoPrincipal())) {
							           				BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
													articulos[y].getAtributoPrincipal(), articulos[y].getIdAtributoPrincipal(), new Integer(articulos[y].getIdSeccion()),
													new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
													atributoPrincipal = articulos[y].getAtributoPrincipal() + " - ";
										  %>
                                          <a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="Fautores"><%=Convert.corregir(articulos[y].getAtributoPrincipal(),true).toUpperCase()%></a><br>
                                          <%} %>

                                          <%
                                          	if (articulos[y].getGrupo()!= null) {
                                          		BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(Convert.corregir(articulos[y].getGrupo(), true),
                                          				new Integer(idSeccion), new Integer(articulos[y].getIdGrupo()), (Integer)null,
                                          				(Integer)null, new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS,
                                          				!DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
                                          %>
                                          <a href="<%=busquedaPorCategoria.salto()%>" class="Fautores">Subcategoria</a>&nbsp;<span class="Fprecio"><%=Convert.corregir(articulos[y].getGrupo(), true)%></span>
                                          <%
                                            }
                                          %>
                                          </td>
                                    </tr>
									<tr>
	                                  <td width="201" valign="bottom" class="celdapreciocomprar"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[y].getPrecio())%></span></div></td>
    	                              <td valign="bottom">
    	                              		<div align="right">
    	                              		<table width="2" border="0" cellspacing="0" cellpadding="0">
	                    				     	<tr>
	                                    		        	<td height="19" class="divInfo"><a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="FProductos"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>"  border="0" /></a></td>
								             			<%if (DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible() && articulos[y].getHabilitadoTematika().equals("S")) { %>
			             							<td class="divComprarPedir"><a href="javascript:agregarProducto(<%=articulos[y].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-comprar.gif" alt="Comprar"  border="0"/></a></td>
	      									     			<% } else {%>
			             							<td class="divComprarPedir"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[y].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>
	      												<% } %>
	      											</tr>
			           						</table>
			           						</div>
			           					</td>
            	                    </tr>
                                </table></td>
                              </tr>
                          </table></td>
                        </tr>
                       	<%
                			}
						%>
		    			<%
			                int totalProductos = busquedaDAO.subtotales()[busquedaDAO.getSeccion().intValue()];
		    	            int totalPaginas = (int)Math.ceil((double)totalProductos/cantArticulosPorPagina);

		                	if (totalPaginas>1) {
		                %>

                        <tr>
                          <td class="celdapaginas">
						<%

								if (paginaActual > 1) {

								StringBuffer  saltoNavegacion = new StringBuffer();
								saltoNavegacion.append(paginaRecorrido);
	    	          	        saltoNavegacion.append("--").append(((((paginaActual-1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
	    	          	        saltoNavegacion.append("--").append(((paginaActual-1)*cantArticulosPorPagina));
	    	          	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");;
    		            %>
                          	<a href="<%=saltoNavegacion%>" class="FAyuda">Anterior</a>
                          		<span class="Ftexto05">|</span>
						<%
								}
						%>
        		        <%
		    					for (int x=Math.max(paginaActual-5, 1);	x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {

		    						StringBuffer  saltoNavegacion = new StringBuffer();
		    						saltoNavegacion.append(paginaRecorrido);
	              	   		     	saltoNavegacion.append("--").append((((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
	   			        	  	    saltoNavegacion.append("--").append(x*cantArticulosPorPagina);
	   	        		  	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");;

	    							if (paginaActual == x) {
                		%>
                         	<a href="<%=saltoNavegacion%>" class="FAyuda"><b><%=x%></b></a>
			            <%
			    					} else {
		                %>
    	                    <a href="<%=saltoNavegacion%>" class="FAyuda"><%=x%></a>
        		        <%
			    					}
        		        		}
		                %>
        		        <%
	        	    	   		if ( paginaActual < totalPaginas) {

	        	    	   			StringBuffer  saltoNavegacion = new StringBuffer();
	        	    	   			saltoNavegacion.append(paginaRecorrido);
	              	   		     	saltoNavegacion.append("--").append(((((paginaActual+1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
	   			        	  	    saltoNavegacion.append("--").append(((paginaActual+1)*cantArticulosPorPagina));
	   	        		  	        saltoNavegacion.append("--").append(busquedaDAO.getCriterio().getClave().intValue()).append(".htm");
		                %>
			                 <span class="Ftexto05">| </span><a href="<%=saltoNavegacion%>" class="FAyuda">Siguiente</a>
				    	<%
	        	        		}
				    	%>
                          </td>
                        </tr>
		                <%
    		            	}
        	        %>

                <%}else{ %>
                <tr>
                <td>&nbsp;</td>
              </tr>
                <%} %>
                       </table>
                  </div></td>
                </tr>
					<%
					    }
				    }

					%>

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

            </table>
            </td>
            <td class="Gbarraderecha" width="162"><table width="155" border="0" cellspacing="0" cellpadding="0">
              <tr class="">
                <td><table width="155" border="0" cellspacing="0" cellpadding="0" class="moduloorden" style="margin-bottom:15px">
                    <tr>
                        <td><table  border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              <td><span class="Ftexto02">ORDENAR TITULOS POR:</span></td>
                            </tr>
                            <tr>
                              <td class="moduloordencelda">
                              <%if (criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)) { %>
	                              <span class="Ftexto02">- Los m&aacute;s vendidos</span>
                              <%} else {

                            	  busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS);

                            	  StringBuffer  saltoOrdenCriterio = new StringBuffer();

                            	  saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
                            	  saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());

 	                          %>
                            	  <span class="Ftexto02">- </span><a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">Los m&aacute;s vendidos</a>
                              <%
                                }
                              %>
                              </td>
                            </tr>
                            <tr>
                              <td class="moduloordencelda">
      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)) { %>
                              		<span class="Ftexto02">- Precio de venta<br />
                                    &nbsp;&nbsp;(+econ&oacute;micos primeros)</span></td>
                              <%} else {

                            	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC);

                            	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

                            	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_EC.getClave().intValue());
                              %>
                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+econ&oacute;micos primeros)</a></td>
                              <%
                                }
                              %>
                            </tr>

                            <tr>
                              <td class="moduloordencelda"><span class="Ftexto02">
                               <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_VN)) { %>
	                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
                                    &nbsp;&nbsp;(+antiguos primeros)</span></td>
	                           <%} else {

	                        	   busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN);

	                        	   StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                        	   saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                        	   saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
                            	   saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_VN.getClave().intValue());

                               %>

                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+antiguos primeros)</a></td>
                               <%
                                 }
                               %>
                               </td>
                            </tr>

                            <tr>
                              <td class="moduloordencelda">
                              <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_NV)) { %>
	                              <span class="Ftexto02">- Fecha de aparici&oacute;n<br />
                                    &nbsp; &nbsp;(+recientes primeros)</span></td>
	                           <%} else {

	                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV);
	                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	 saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_FECHA_NV.getClave().intValue());

                               %>
                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Fecha de aparici&oacute;n<br />
                                  <span class="Ftexto02">&nbsp;&nbsp;</span>(+recientes primeros)</a></td>
                               <%
                                 }
                               %>
							</td>
                            </tr>

                            <tr>
                              <td class="moduloordencelda">
      	                      <%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)) { %>
                              		<span class="Ftexto02">- Precio de venta<br />
                                    &nbsp;&nbsp;(+costosos primeros)</span></td>
                              <%} else {

                            	    busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE);

                            	    StringBuffer  saltoOrdenCriterio = new StringBuffer();

                            	    saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
                            	    saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
	                            	saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_PRECIO_CE.getClave().intValue());
                              %>
                            		<a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Precio de venta<br />
                                    <span class="Ftexto02">&nbsp;&nbsp;</span>(+costosos primeros)</a></td>
                              <%
                                }
                              %>
                            </tr>


                            <tr>
                              <td class="moduloordencelda">
                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)) { %>
	                              <span class="Ftexto02">- Alfab&eacute;ticamente (A-Z)</td>
	                           <%} else {

	                        	     busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ);

	                        	     StringBuffer  saltoOrdenCriterio = new StringBuffer();

	                        	     saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                        	     saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                             saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_AZ.getClave().intValue());
                               %>
                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (A-Z)<br/></a>
                               <%
                                 }
                               %>
                              </td>
                            </tr>

                            <tr>
                              <td class="moduloordencelda">
                              	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)) { %>
	                              <span class="Ftexto02">- Alfab&eacute;ticamente (Z-A)</td>
	                           <%} else {
	                        	   	busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA);
	                        	   	StringBuffer  saltoOrdenCriterio = new StringBuffer();
	                        	   	saltoOrdenCriterio.append(paginaRecorrido2).append("&").append(BuscadorHelper.REGISTRO_INICIAL).append("= 1");
	                        	   	saltoOrdenCriterio.append("&").append(BuscadorHelper.REGISTRO_FINAL).append("=10");
		                            saltoOrdenCriterio.append("&").append(BuscadorHelper.CRITERIO_ORDEN).append("=").append(BuscadorHelper.CRIT_ALFAB_ZA.getClave().intValue());
                               %>
                                  <a href="<%=saltoOrdenCriterio%>" class="Flink02" rel="nofollow">- Alfab&eacute;ticamente (Z-A)<br/></a>
                               <%
                                 }
                               %>
                              </td>
                            </tr>
                        </table></td>
                      </tr>
                </table></td>
              </tr>
              <tr>
              <!--TOP-->
                <%
                	String pageTop = "/contenidosEstaticos/familias/topFamilia_" + seccion + "_" + grupo + ((familia!=null)? "_" + familia:"") + ".html";
                %>
       			<jsp:include page="<%=pageTop%>"/>
       			</td>
              <!--TOP-->
              </tr>
            </table></td>
          </tr>
          <tr>
            <td colspan="3"><div align="center">
              <% String urlInstitucional = "/componentes/comunes/institucional.jsp?idSeccion=" + idSeccion;%>
				 <jsp:include page="<%=urlInstitucional%>"/>
				 </td>
            </div></td>
          </tr>
          <tr>
              <td height="25" colspan="3" align="center"><div class="Gfooter3"><h2 class="Ftextopie"><b><%=descripcionCategoria%> - Venta de <%=Globals.textoSolapa(idSeccion)%> / <%=descripcionCategoria%></b></h2></div></td>
          </tr>
		</table></td>
      </tr>
    </table></td>
  </tr>
</table>
<%=Globals.getGoogleAnalytics()%>
</body>
</html>

