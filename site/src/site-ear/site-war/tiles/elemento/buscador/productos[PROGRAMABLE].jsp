<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<%@ page import="com.tmk.kernel.Convert,
								 com.tmk.kernel.Globals,
								 com.tmk.generacion.ContenidosEstaticos,
								 com.tmk.controllers.buscador.BuscadorHelper,
								 com.tmk.controllers.buscador.BusquedaGenerica,
								 com.tmk.controllers.buscador.CriterioDAO,
								 java.util.Vector,
								 com.tmk.controllers.buscador.BusquedaPorAtributosDinamicos,
								 com.tmk.controllers.buscador.BusquedaAvanzada,
								 com.tmk.controllers.buscador.BusquedaInicio,
								 com.tmk.controllers.buscador.BusquedaPorTitulo,
								 com.tmk.controllers.buscador.BusquedaPorAutor,
								 com.tmk.controllers.buscador.BusquedaPorPalabrasClaves,
								 com.tmk.controllers.buscador.BusquedaPorTemaMusical,
								 com.tmk.controllers.buscador.BusquedaPorISBN,
								 com.tmk.controllers.buscador.BusquedaPorEditorial,
								 com.tmk.controllers.buscador.BusquedaPorProveedor,
								 com.tmk.controllers.buscador.BusquedaPorCategorias,
								 com.tmk.controllers.buscador.BusquedaPorIDs,
								 com.tmk.controllers.buscador.BusquedaParaRecomendar,
								 com.tmk.controllers.buscador.BusquedaDeNovedades,
								 com.tmk.controllers.buscador.BusquedaPorIDdeEditorial,
								 com.tmk.controllers.buscador.BusquedaPorIDdeAutor,
								 com.tmk.controllers.buscador.BusquedaPorIDdeProveedor,
								 com.tmk.controllers.buscador.BusquedaPorIDdeMarca,
								 com.tmk.controllers.buscador.BusquedaPorMarca,
								 com.tmk.controllers.buscador.BusquedaVacia,
								 com.tmk.kernel.Pair,
								 com.tmk.kernel.TmkLogger,
								 com.tmk.bus.articulo.ArticuloClass,
								 com.tmk.bus.articulo.ArticuloManager,
								 com.tmk.controllers.buscador.BusquedaPorAtributoPrincipal,
								 com.tmk.kernel.DisponibilidadDAO,
								 com.tmk.setup.Contenido,
								 java.util.regex.Pattern,
								 com.tmk.service.categoria.CategoriaService"%>

<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>

<%
	int seccionElegida = Convert.toNumber(idSeccion, Globals.SECCION_HOME);
String textoABuscar = request.getParameter(BuscadorHelper.TEXTO);
%>
<%
	// Lo crea vacio al comienzo por si alguna clasificacion no esta terminada, o si el usuario quita algun parametro intencionalmente
BusquedaGenerica busquedaDAO;
textoABuscar = (textoABuscar != null)? textoABuscar.replaceAll("\\'", " "): "";
Integer seccion = Convert.toNumber(seccionElegida + "", (Integer)null);
if ((seccion != null) && (Globals.SECCION_HOME == seccion.intValue())) seccion = null; // para la home traer todos

Integer grupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);
Integer familia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);
Integer subfamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SUBFAMILIA), (Integer)null);

int claveCriterio = Convert.toNumber(request.getParameter(BuscadorHelper.CRITERIO_ORDEN), BuscadorHelper.CRITERIO_DEFAULT.getClave().intValue());
CriterioDAO criterio = new CriterioDAO(new Integer(claveCriterio));

boolean pedidoEspecial = Convert.toBoolean(request.getParameter(BuscadorHelper.PEDIDO_ESPECIAL), false);

Integer registroInicial = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_INICIAL), new Integer(1));
Integer registroFinal = Convert.toNumber(request.getParameter(BuscadorHelper.REGISTRO_FINAL), new Integer(10));

boolean esBusquedaAvanzada = Convert.toBoolean(request.getParameter(BuscadorHelper.ES_BUSQUEDA_AVANZADA), false);

String claveDeBusqueda = Convert.toString(request.getParameter(BuscadorHelper.CLAVE_DE_BUSQUEDA), null);

if (esBusquedaAvanzada) {
	if (BuscadorHelper.POR_ATRIBUTOS_DINAMICOS.equals(claveDeBusqueda)) {
		// Donde guarda los atributos
		Vector atributos = new Vector();
		// Asumo que hay hasta 15 atributos dinámicos (hoy hay solo 3 en el mejor caso)
		for (int i = 0; i < 15; i++) {
	String nombre = Convert.toString(request.getParameter(BuscadorHelper.NOMBRE_ATRIBUTO + i), null);
	String valor  = Convert.toString(request.getParameter(BuscadorHelper.VALOR_ATRIBUTO + i), null);
	if ((nombre != null) && (valor != null)) atributos.add(new Pair(nombre, valor));
		}
		busquedaDAO = new BusquedaPorAtributosDinamicos(seccion, grupo, familia, subfamilia, registroInicial, registroFinal, criterio, pedidoEspecial, atributos);
	} else {
		String titulo = Convert.toString(request.getParameter(BuscadorHelper.POR_TITULO), null);
		if (titulo != null) {
	titulo = (titulo != null)? titulo.replaceAll("\\'", " "): null;
	textoABuscar = titulo;
		}
		String autor = Convert.toString(request.getParameter(BuscadorHelper.POR_AUTOR), null);
		if (autor != null) {
	autor = (autor != null)? autor.replaceAll("\\'", " "): null;
	textoABuscar = autor;
		}
		String editorial = Convert.toString(request.getParameter(BuscadorHelper.POR_EDITORIAL), null);
		if (editorial != null) {
	editorial = (editorial != null)? editorial.replaceAll("\\'", " "): null;
	textoABuscar = editorial;
		}
		String palabrasClaves = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES), null);
		if (palabrasClaves != null) {
	palabrasClaves =  palabrasClaves.replaceAll("\\'", " ");
	textoABuscar = palabrasClaves;
		}
		String isbn = Convert.toString(request.getParameter(BuscadorHelper.POR_ISBN), null);
		if (isbn != null) {
	isbn = (isbn != null)? isbn.replaceAll("\\'", " "): null;
	textoABuscar = isbn;
		}
		String clasificacion = Convert.toString(request.getParameter(BuscadorHelper.POR_CLASIFICACION_TEMATIKA), null);
		String idioma = Convert.toString(request.getParameter(BuscadorHelper.POR_IDIOMA), null);
		Double precio = Convert.toNumber(request.getParameter(BuscadorHelper.POR_PRECIO), (Double)null);
		String formato = Convert.toString(request.getParameter(BuscadorHelper.POR_FORMATO), null);
		busquedaDAO = new BusquedaAvanzada(textoABuscar, seccion, registroInicial, registroFinal, criterio, pedidoEspecial,
										titulo, autor, editorial, palabrasClaves,
										isbn, clasificacion, idioma, precio, formato);
	}
} else {
	String [] suprimir = {"LA", "DE", "DEL", "CON", "LO", "LOS", "EL", "EN", "ANTE", "POR", "ESTE", "ESTA",
	"ESTOS", "Y", "A", "BAJO", "CONTRA", "DESDE", "DURANTE", "ENTRE", "HACIA", "HASTA", "MEDIANTE",
	"PARA", "SEGUN", "SIN", "SOBRE", "TRAS", ",", ";", "O", "UN", "LAS", "I", "B", "C", "D", "E", "F",
	"G", "H", "I", "J", "K", "L", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	String textoDeBusqueda = "";
	if (textoABuscar!= null) {
		String aux[] = textoABuscar.split(" ");
		for (int j=0; j<suprimir.length; j++) {
	for (int i=0; i<aux.length; i++) {
		if (aux[i].toUpperCase().equals(suprimir[j])) {
			aux[i] ="";
		}
	}
		}
		for (int i=0; i<aux.length; i++) {
	textoDeBusqueda =textoDeBusqueda + ((!aux[i].equals(""))?aux[i] + " ":"");
		}
		if (textoDeBusqueda.length()>0) {
	textoDeBusqueda = textoDeBusqueda.substring(0, textoDeBusqueda.length()-1);
	textoDeBusqueda = textoDeBusqueda.replaceAll("\\[^a-zA-Z]", "");
		}
	}
	if (claveDeBusqueda == null) {
		busquedaDAO = new BusquedaInicio(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_TITULO.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorTitulo(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_AUTOR.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorAutor(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_PALABRAS_CLAVES.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorPalabrasClaves(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_ISBN.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorISBN(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_EDITORIAL.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorEditorial(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_PROVEEDOR.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorProveedor(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_TEMA_MUSICAL.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorTemaMusical(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_CATEGORIAS.equals(claveDeBusqueda)) {
		busquedaDAO = new BusquedaPorCategorias(textoDeBusqueda, seccion, grupo, familia, subfamilia, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_IDS.equals(claveDeBusqueda)) {
		String idArticulos = request.getParameter(BuscadorHelper.IDS_ARTICULOS);
		busquedaDAO = new BusquedaPorIDs(textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial, idArticulos);
	} else if (BuscadorHelper.PARA_RECOMENDAR.equals(claveDeBusqueda)) {
		Integer idSucursal = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SUCURSAL), (Integer)null);
		Integer idSocio = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SOCIO), (Integer)null);
		busquedaDAO = new BusquedaParaRecomendar(registroInicial, registroFinal, criterio, pedidoEspecial, idSucursal, idSocio);
	} else if (BuscadorHelper.DE_NOVEDADES.equals(claveDeBusqueda)) {
		Integer diasConsideradosNovedad  = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_CONSIDERADOS_NOVEDAD), (Integer)null);
		Integer diasIgnoradosNovedad = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_IGNORADOS_NOVEDAD), (Integer)null);
		busquedaDAO = new BusquedaDeNovedades(seccion, grupo, familia, subfamilia, registroInicial, registroFinal, criterio, pedidoEspecial, diasConsideradosNovedad, diasIgnoradosNovedad);

	} else if (BuscadorHelper.POR_IDdeEDITORIAL.equals(claveDeBusqueda)) { //Para EMPRO evita los operadores de catsearch
	Integer idEditor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_EDITOR), new Integer (0));
	busquedaDAO = new BusquedaPorIDdeEditorial(textoDeBusqueda, idEditor, seccion, registroInicial,	registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_IDdeAUTOR.equals(claveDeBusqueda)) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
			Object idAutor = request.getParameter(BuscadorHelper.ID_AUTOR);
			if("true".equals(request.getParameter("verPedidoEspecial"))){
				busquedaDAO = new BusquedaPorIDdeAutor (textoDeBusqueda, idAutor, seccion, registroInicial, registroFinal, criterio);
			}else{
				busquedaDAO = new BusquedaPorIDdeAutor (textoDeBusqueda, idAutor, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
			}
	} else if (BuscadorHelper.POR_IDdePROVEEDOR.equals(claveDeBusqueda)) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
					Integer idProveedor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_PROVEEDOR), new Integer(0));
					busquedaDAO = new BusquedaPorIDdeProveedor (textoDeBusqueda, idProveedor, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_IDdeMARCA.equals(claveDeBusqueda)) {
							Integer idMarca = Convert.toNumber(request.getParameter(BuscadorHelper.ID_MARCA), new Integer(0));
							busquedaDAO = new BusquedaPorIDdeMarca (textoDeBusqueda, idMarca, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else if (BuscadorHelper.POR_MARCA.equals(claveDeBusqueda)) {
									busquedaDAO = new BusquedaPorMarca (textoDeBusqueda, seccion, registroInicial, registroFinal, criterio, pedidoEspecial);
	} else {
		busquedaDAO = new BusquedaVacia();
	}
}
	busquedaDAO.runQuerySubtotales();
%>
<table width="600" border="0" cellpadding="0" cellspacing="0" class="Gtablacontenido" align="center">
					<tr>
							<td class="Gcentro">
								<table width="390" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
											<td>
												<table width="390" border="0" align="center" cellpadding="0" cellspacing="0" >
														<tr>
															<td>
																<h1 class="resultadonum"><span class="Ftexto02">SE ENCONTRARON <strong><%=(seccionElegida == Globals.SECCION_HOME)? busquedaDAO.total(): busquedaDAO.subtotales()[seccionElegida]%></strong> RESULTADOS RELACIONADOS CON LA PALABRA: <br />
																		<b>&raquo; <%=textoABuscar%> &laquo;</b>
																		</span></h1>
																			<%
																				int total = (seccionElegida == Globals.SECCION_HOME)? busquedaDAO.total(): busquedaDAO.subtotales()[seccionElegida];
																																				if (!pedidoEspecial && total==0) {
																																				busquedaDAO.setPedidoEspecial(true);
																			%>
																			<SPAN ><STRONG><EM><a class=Ftexto02 href="<%=busquedaDAO.salto()%>">Ver productos sin disponibilidad</a></EM></STRONG></SPAN>
																			<br>&nbsp;
																			<%
																				busquedaDAO.setPedidoEspecial(false);
																																				}
																			%>

															</td>
													</tr>
								<%
									if (busquedaDAO.total() == 0) {
								%>
													 <tr>
													<td class="celdapaginas" align="center">
														<span  class="FAyuda">
															 <a href="/articulo/buscadorAvanzado.jsp?idSeccion=<%=Globals.SECCION_LIBRO%>&seccion=<%=Globals.SECCION_LIBRO%>&<%=BuscadorHelper.POR_PALABRAS_CLAVES%>=<%=busquedaDAO.getTexto()%>">
															 	Amplie su búsqueda a través de la Búsqueda Avanzada
															 </a>
														</span>
													</td>
												</tr>
												<%
													}
												%>
												</table>
										 </td>
									</tr>


								<%
									for (int i = 0; i < busquedaDAO.subtotales().length; i++) {

												if ((busquedaDAO.subtotales()[i] > 0) && ((seccion == null) || (seccion.intValue() == i))) {
													busquedaDAO.setSeccion(new Integer(i));
													busquedaDAO.run();
													StringBuffer logBusqueda = new StringBuffer();
													logBusqueda.append(busquedaDAO.toString());
													logBusqueda.append(". Items: ").append(busquedaDAO.getItems().size());
													logBusqueda.append(". Tiempo: ").append(busquedaDAO.tiempoUtilizado()).append(" seg.");
													TmkLogger.debug(logBusqueda);
													StringBuffer ids = new StringBuffer();

													if (!busquedaDAO.esConsultaExtensa() && !busquedaDAO.timeOut()) {


														int cantArticulosPorPagina = busquedaDAO.cantidadDeFilasAMostrar().intValue();

														for (int index = 0; index < Math.min(busquedaDAO.getItems().size(), cantArticulosPorPagina); index++) {
															ids.append(((Integer)busquedaDAO.getItems().get(index)).intValue()).append(",");
														}
														ArticuloClass articulos[] = ArticuloManager.getArticulosParaResultadoDeBusqueda((ids.length()>0)? ids.substring(0, ids.length()-1): "" + Globals.ARTICULO_DEFAULT, busquedaDAO.getSeccion().intValue());
								%>
						<tr>
											<td><div align="center">
														<table width="375" border="0" cellspacing="0" cellpadding="0" class="modulobuscador">
													 <%
													 	if (seccionElegida == Globals.SECCION_HOME) {
													 %>
															<tr>
																	<td><table width="375" border="0" cellspacing="0" cellpadding="0" class="titulostabla">
																				<tr>
																					<td><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/t-<%=Globals.seccion(busquedaDAO.getSeccion().intValue())%>b.gif" alt="Resultado de libros" /></td>
																				</tr>
																		</table>
															</td>
															</tr>
													 <%
													 	}
													 %>
																<tr>
														<td  align="center"><span  class="FAyuda">
															 <a href="/articulo/buscadorAvanzado.jsp?idSeccion=<%=busquedaDAO.getSeccion()%>&seccion=<%=busquedaDAO.getSeccion()%>&<%=BuscadorHelper.POR_PALABRAS_CLAVES%>=<%=busquedaDAO.getTexto()%>">Amplie su búsqueda a través de la Búsqueda Avanzada</a></span><br>&nbsp;
														</td>
													</tr>
										<%
											Pattern [] palabraClave= Convert.palabraClaveAPatron((busquedaDAO.getTexto()!=null)?busquedaDAO.getTexto().replaceAll("-", " "):"");
																				String resAtrPri = "<span href=\"\" class=\"rAtrPri\">";
																				String resAtrPriCie = "</span>";
																				String resTxt = "<span class=\"rTxt\">";
																				String resTxtCie ="</span>";

																					for (int y=0; y<articulos.length; y++) {
										%>
														<tr>
															<td><table width="390" border="0" cellspacing="0" cellpadding="0" class="moduloBus">

																	<tr>

																		<td><table width="390" border="0" cellspacing="0" cellpadding="0">
																				<tr>
																				<%
																					String imgPage = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulos[y].getIdArticulo() + "&idSeccion=" + articulos[y].getIdSeccion() +
																																"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulos[y].getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulos[y].getIdSeccion()][4] + "&esNovedad=" + articulos[y].esNovedad() +
																																"&titulo=" + Convert.corregir(articulos[y].getTitulo(), true).toUpperCase();
																				%>
																					<td width="82" rowspan="4" valign="top">
													<a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="FProductos">
													<jsp:include page="<%=imgPage %>"/>
													</a>
												</td>
																					<td colspan="3" valign="top" class="celdacontenido"><span class="FProductos">
																					<a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>" class="tituloBus">
																					<%=Convert.resaltado(palabraClave, Convert.corregir(articulos[y].getTitulo(), true).toUpperCase(), 0, resAtrPri, resAtrPriCie)%>
																					</a></span><br />
													<%
														String atributoPrincipal = "";
																																				if (articulos[y].getAtributoPrincipal() != null && !"".equals(articulos[y].getAtributoPrincipal())) {
																																								 BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
																																					articulos[y].getAtributoPrincipal(), articulos[y].getIdAtributoPrincipal(), new Integer(articulos[y].getIdSeccion()),
																																					new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
																																					atributoPrincipal = articulos[y].getAtributoPrincipal() + " - ";
													%>
																							<a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="atrPplBus"><%=Convert.resaltado(palabraClave, articulos[y].getAtributoPrincipal().toUpperCase(), 0, resAtrPri, resAtrPriCie)%></a><br>
																							<%
																								}
																							%>
																							<%
																								if (articulos[y].getGrupo()!= null) {
																																																																			BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(Convert.corregir(articulos[y].getGrupo(), true),
																																																																					new Integer(seccionElegida), new Integer(articulos[y].getIdGrupo()), (Integer)null,
																																																																					(Integer)null, new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS,
																																																																					!DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible());
																							%>
																							<span class="Fprecio">Subcategoria&nbsp;</span><a href="/catalogo<%=CategoriaService.getURL(articulos[y].getCategoria())%>.htm" class="Fautores"><span class="Fprecio"><%=Convert.resaltado(palabraClave, Convert.corregir(articulos[y].getGrupo(), true), 0, resTxt, resTxtCie)%></span></a></td>
																							<%
																								}
																							%>
																				</tr>
																				<tr>
																					<td colspan="3" class="celdacontenido"><span class="Ftextdestacados">
																					<%
																						String sinopsis = Convert.resaltado(palabraClave, articulos[y].getSinopsis(), 200, resTxt, resTxtCie);
																																																		if (sinopsis != null && sinopsis.indexOf(resTxt) > -1) {
																					%>

												<%="<br><span style='text-decoration:underline'>Descripción</span><br>" + sinopsis%>
												<%
													}
												%>
																					</span></td>
																				</tr>
																				<tr>
																					<td colspan="3" class="celdacontenido"><span class="Ftextdestacados">
																					<%
																						String indice = Convert.resaltado(palabraClave, articulos[y].getIndice().replaceAll("Indice de contenidos de este libro", ""), 200, resTxt, resTxtCie);
																																																		if (indice != null && indice.indexOf("<b style=") > -1) {
																																																			out.println("<p><a style='text-decoration:underline'style='text-decoration:underline' href=\"/articulo/indiceDeContenidos.jsp?idArticulo=" + articulos[y].getIdArticulo() + "\">Indice de contenidos</a><br>" + indice.replaceAll("\r", "<p>").replaceAll("<pre", "<span").replaceAll("pre>", "span>") + "");
																																																		}
																					%>
																					</span></td>
																				</tr>
																				<tr>
																				<td colspan="3">
																					<table cellpadding="0" cellspacing="0" border="0" width="308">
																						<tr>
																								<td width="100" class="celdapreciocomprar"><div align="left"><span class="Fprecio">PRECIO: <%=Contenido.precioToString(articulos[y].getPrecio())%></span></div></td>
																								<td valign="bottom">
																									<table width="2" border="0" cellspacing="0" cellpadding="0" align="left">
																										<tr><td height="19" class="divInfo" ><a href="<%=CategoriaService.getURL(articulos[y].getCategoria())+ArticuloManager.getURL(articulos[y])%>"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-info.gif" alt="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>" title="<%=atributoPrincipal + Convert.corregir(articulos[y].getTitulo(), true)%>"  border="0" /></a></td>
																					 <%if (DisponibilidadDAO.buscaDisponibilidad(articulos[y].getIdDisponibilidad()).estaDisponible() && articulos[y].getHabilitadoTematika().equals("S")) { %>
																					 						<td class="divComprarPedir"><a href="javascript:agregarProducto(<%=articulos[y].getIdArticulo()%>);window.scrollTo(0,0);" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-comprar.gif" alt="Comprar"  border="0"/></a></td>
																					 <% } else {%>
																				 							<td class="divComprarPedir"><a href="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=articulos[y].getIdArticulo()%>';" rel="nofollow"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-pedir.gif" alt="Comprar"  border="0"/></a></td>
																					<% } %>
																		</tr>
																		 </table>
																	 </td>
																						</tr>
																						</table>
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
									int paginaActual = (int)Math.ceil((double)registroInicial.intValue()/cantArticulosPorPagina);
									if (paginaActual > 1) {

										StringBuffer saltoNavegacion = busquedaDAO.salto();
													busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer ((((paginaActual-1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer((paginaActual-1)*cantArticulosPorPagina));
							%>
														<a href="<%=saltoNavegacion%>" class="FAyuda">Anterior</a>
															<span class="Ftexto05">|</span>
				<%
									}
				%>
								<%
										for (int x=Math.max(paginaActual-5, 1);
											x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {

											StringBuffer saltoNavegacion = busquedaDAO.salto();
												busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer (((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer(x*cantArticulosPorPagina));

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
														StringBuffer saltoNavegacion = busquedaDAO.salto();
													busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer ((((paginaActual+1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
										busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer((paginaActual+1)*cantArticulosPorPagina));
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
											</table>
									</div></td>
								</tr>

				<%
							} 

						}
					}
				%>
								<tr>

								<!-- ultimos visitados -->
									<td>
									<%
								String ultimosVisitadosPage = "/tiles/elemento/ultimosVisitados.jsp?idSeccion=" + seccionElegida;
								%>

								<jsp:include page="<%=ultimosVisitadosPage%>"/>
									</td>
								 <!-- Ultimos Visitados -->

								</tr>
						</table>
						</td>



						<td class="Gbarraderecha">
							<table width="155" border="0" cellpadding="0" cellspacing="0">
								<tr>
									<td>
										<table width="180" border="0" cellspacing="0" cellpadding="0" class="moduloorden">
											<tr>
												<td>
													 <table  border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td><span class="Ftexto02">ORDENAR RESULTADOS POR:</span></td>
														</tr>
														<%busquedaDAO.setSeccion(seccion);%>
														<tr>
															<td class="moduloordencelda">
															<%if (criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)) { %>
																<br><b>- Los m&aacute;s vendidos</b>
															<%} else {
																busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS);
															%>																
																<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow">
																	<span class="Ftexto02">- Los m&aacute;s vendidos</span>	
																</a>
															<%
																}
															%>
															</td>
														</tr>
													<!-- FERCHA DE APARICION -->
														<tr>
															<td class="moduloordencelda">
																<span class="Ftexto02">- Fecha de aparici&oacute;n
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_FECHA_NV)) { %>																		
																				<br><b>-m&aacute; recientes primeros</b>
																	 	<%} else {
																			 busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br/>
																					<span class="Ftexto02"> -m&aacute; recientes primeros</span>
																				</a>
																		 <%
																			 }
																		 %>									
																	</span>
																	<span style="padding:10px;">		
																		 <%if (criterio.equals(BuscadorHelper.CRIT_FECHA_VN)) { %>																		
																				<br><b>-m&aacute;s antiguos primeros</b>
																	 	 <%} else {
																				busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br/>
																					<SPAN class="Ftexto02">-m&aacute;s antiguos primeros</SPAN>
																				</a>
																		 <%
																			 }
																		 %>
																	 </span>
																</span>
															 </td>
														</tr>
													<!-- PRECIO DE VENTA -->
														<TR>
															<td class="moduloordencelda">
																<span class="Ftexto02">- Precio de venta
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)) { %>
																				<br><b>-m&aacute;s econ&oacute;micos primeros</b>
																		<%} else {
																			busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC);
																		%>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br />
																					 <SPAN class="Ftexto02">-m&aacute;s econ&oacute;micos primeros</SPAN>
																				</a>
																		<%
																			}
																		%>								
																	</span>
																	<span style="padding:10px;">		
																		<%if (criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)) { %>
																				<br><b>-m&aacute;s costosos primeros</b>
																	<%} else {
																		busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE);
																	%>
																				<a style="paddin:10px;" href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br />
																					<span class="Ftexto02">-m&aacute;s costosos primeros</span>
																				</a>
																	<%
																		}
																	%>
																	 </span>
																</span>
															 </td>
														<TR>
														
														<!-- ALFABETICO -->
														<TR>
															<td class="moduloordencelda">
																<span >- Alfab&eacute;ticamente
																	<span style="padding:10px;">
																		<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)) { %>
																				<br><b>-(A-Z)</b>
																	 	<%} else {
																			 busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ);
																		 %>
																				<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br>
																					<span class="Ftexto02">-(A-Z)</span>
																				</a>
																		 <%
																			 }
																		 %>							
																	</span>
																	<span style="padding:10px;">		
																	<%if (criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)) { %>
																			<br><b>-(Z-A)</b>
																 	<%}else {
																		 busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA);
																	 %>
																			<a href="<%=busquedaDAO.salto()%>" class="Flink02" rel="nofollow"><br>
																				<span class="Ftexto02">-(Z-A)</span>
																			</a>
																	 <%
																		 }
																	 %>
																	 </span>
																</span>
															 </td>
														<TR>
												</table></td>
											</tr>
									</table></td>
								</tr>
								<tr>
									<td class="Ftexto02"><table width="155" border="0" cellpadding="0" cellspacing="0" class="tablaaccesos">
											<tr>
												<td><table width="155" border="0" cellspacing="0" cellpadding="0">
														<tr>
															<td class="Ftexto02">Si no tuvo un resultado<br />
																satisfactorio, pruebe con:</td>
														</tr>
														<% if (seccionElegida != Globals.SECCION_HOME) { %>
														<tr>
															<td><div align="left"><a href="/articulo/buscadorAvanzado.jsp?idSeccion=<%=busquedaDAO.getSeccion()%>&seccion=<%=seccionElegida%>" rel="nofollow"><img style="padding-top:7px" src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-bavanzada.gif" alt="B&uacute;squeda avanzada" border="0" class="accesos02" /></a></div></td>
														</tr>
														<% } %>


														<%
														if (!pedidoEspecial) {

															busquedaDAO.setSeccion(new Integer(seccionElegida));
															busquedaDAO.setCriterio(criterio);
															busquedaDAO.setPedidoEspecial(true);
														%>
														<tr class="dwcopytype=&quot;CopyTableRow&quot;">
															<td><div align="left"><a href="<%=busquedaDAO.salto()%>"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-productossinstock.gif" alt="Productos sin stock"  border="0" class="accesos02" /></a></div></td>
														</tr>
														<%
														}
														%>
														<tr class="dwcopytype=&quot;CopyTableRow&quot;">
															<td><div align="left"><a href="/indice"><img src="/imagenes/<%=Globals.seccion(seccionElegida)%>/b-mapadeproductos.gif" alt="Mapa de productos"  border="0" class="accesos02" /></a></div></td>
														</tr>
												</table></td>
											</tr>
									</table></td>
								</tr>
						</table></td>
					</tr>
					<tr>
<!--               <td colspan="3"><div class="Gfooter3"><h3 class="Ftextopie"><b><%=textoABuscar%></b></h3></div></td>-->
					</tr>
				</table>

<%if (Globals.esModoRelease() && busquedaDAO instanceof BusquedaDeNovedades){ %>
<!-- Tag for Activity Group: Tematika website, Activity: Tematika  Novedades -->

<!-- Start of DoubleClick Spotlight Tag: Please do not remove-->
<!-- Activity Name for this tag is:Tematika  Novedades -->
<!-- Web site URL where tag should be placed: http://www.tematika.com/buscador/productos.jsp?diasIgnoradosNovedad=2&claveDeBusqueda=deNovedades&diaConsideradosNovedad=30 -->
<!-- Creation Date:12/29/2006 -->
<SCRIPT language="JavaScript">
var axel = Math.random()+"";
var a = axel * 10000000000000;
document.write('<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematn11;ord='+ a + '?" WIDTH=1 HEIGHT=1 BORDER=0>');
</SCRIPT>
<NOSCRIPT>
<IMG SRC="http://ad.ar.doubleclick.net/activity;src=1364770;type=tematsit;cat=tematn11;ord=1?" WIDTH=1 HEIGHT=1 BORDER=0>
</NOSCRIPT>
<!-- End of DoubleClick Spotlight Tag: Please do not remove-->
<%} %>
<%=Globals.getGoogleAnalytics()%>