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
<%@page import="com.tmk.soa.servicios.implementation.ArticuloServiceUtil"%>
<%@page import="com.tmk.bus.categoria.CategoriaPK"%>
<%@page import="com.tmk.bus.categoria.Categoria"%>
<tiles:useAttribute name="idSeccion" scope="page" ignore="true" classname="java.lang.Integer"/>


<style>
div .arbol{
	margin-top: 0px;
}
</style>

<%//throw new ServletException("mensaje forzado");
	int seccionElegida = Convert.toNumber(idSeccion, Globals.SECCION_HOME);
	String textoABuscar = request.getParameter(BuscadorHelper.TEXTO);
%>
<%
	// Lo crea vacio al comienzo por si alguna clasificacion no esta terminada, o si el usuario quita algun parametro intencionalmente
	BusquedaGenerica busquedaDAO;
	textoABuscar = (textoABuscar != null)? textoABuscar.replaceAll("\\'", " "): "";
	Integer seccion = Convert.toNumber(seccionElegida + "", (Integer)null);
	if ((seccion != null) && (Globals.SECCION_HOME == seccion.intValue())) seccion = null; // para la home traer todos

	//bloque agregado por error en la generacion de detalles, una ves que se regeneren hay que quitarlo
	String strGrupo = (String)request.getParameter("grupo");
	if(strGrupo!=null) {
		int c = 0;
		for(c=0;c<strGrupo.length();c++) {
			try {
				int aux = Integer.parseInt(""+strGrupo.charAt(c));			
			}catch(NumberFormatException e ) {
				break;
			}
		}
		strGrupo = strGrupo.substring(0,c);
	}
	Integer grupo = Convert.toNumber(strGrupo, (Integer)null);
	//fin bloque

	//Integer grupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);
	Integer familia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);
	Integer subfamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SUBFAMILIA), (Integer)null);

	//CODIGO AGREGADO PARA MOSTRAT LA SUBCATEGORIA COMO LA MUERTRA EL DETALLE DE ARTICULO
	//Integer[] ipk = new Integer[]{seccionElegida,grupo,familia,subfamilia};
	//CategoriaPK pk = new CategoriaPK(ipk);
	//Categoria categoria = CategoriaService.getCategoriaEspecifica(pk);
	//System.out.println(pk);
	//System.out.println(categoria.getDescripcion());

	//int claveCriterio = Convert.toNumber(request.getParameter(BuscadorHelper.CRITERIO_ORDEN), BuscadorHelper.CRITERIO_DEFAULT.getClave().intValue());
	int claveCriterio = Convert.toNumber(request.getParameter(BuscadorHelper.CRITERIO_ORDEN), BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().intValue());
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
				if ((nombre != null) && (valor != null)) 
					atributos.add(new Pair(nombre, valor));
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

<div class="busqTit">
	<%	int total = (seccionElegida == Globals.SECCION_HOME)? busquedaDAO.total(): busquedaDAO.subtotales()[seccionElegida];
		if(total>0){
	%>
		Resutados de búsqueda de
		<span><%=textoABuscar%></span><br> 
	<% }else
		if (!pedidoEspecial && total==0) {
			busquedaDAO.setPedidoEspecial(true);
	%>
			No se encontraron resultados de búsqueda de
			<span><%=textoABuscar%></span><br>
			<a href="<%=busquedaDAO.salto()%>">ver resultados de b&uacute;squeda sobre productos sin disponibilidad</a>	
	<%		busquedaDAO.setPedidoEspecial(false);
		} 
	%>
</div>

<div class="busqMarco">		
	<%	if(total>0){ 
		int cantArticulosPorPagina = busquedaDAO.cantidadDeFilasAMostrar().intValue();
	%>
		<tiles:insert name="arbol" flush="true"/>
		<div class="busqContenido">	
			<div class="arbolShadow">
				<div class="busqOrden">			    	
			    	<h2><%=String.valueOf(total)%> Resultados |  Ordenar resultados según:</h2>
			    	<div class="busqFiltMenu" >
			            <ul class="dropdown">
			            <%	if(BuscadorHelper.criterios.length>0){
			            		busquedaDAO.setSeccion(seccion);
			            		String descripcionBusqueda="M&aacute;s vendidos";
			            		if(criterio.equals(BuscadorHelper.CRIT_MAS_VENDIDOS)){
			            			descripcionBusqueda="M&aacute;s vendidos";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_FECHA_NV)){
			            			descripcionBusqueda="M&aacute;s recientes";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_FECHA_VN)){
			            			descripcionBusqueda="M&aacute;s antiguos";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_PRECIO_EC)){
			            			descripcionBusqueda="M&aacute;s econ&oacute;micos";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_PRECIO_CE)){
			            			descripcionBusqueda="M&aacute;s costosos";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_ALFAB_AZ)){
			            			descripcionBusqueda="(A-Z)";
			            		}else if(criterio.equals(BuscadorHelper.CRIT_ALFAB_ZA)){
			            			descripcionBusqueda="(Z-A)";
			            		}
			            %>
			            	<li class="diri">
			            		<span id="mostrarOrden" onclick="javascript:desplegarOpciones('listaOrden');">
			            			<%=descripcionBusqueda %>
			            		</span>
			            		<ul onmouseout="ocultarOpcionesT('listaOrden');" onmouseover="clearTimeout(tempo);" id="listaOrden">
			 						<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_MAS_VENDIDOS); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">Los m&aacute;s vendidos</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_NV); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">M&aacute;s recientes primeros</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_FECHA_VN); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">M&aacute;s antiguos primeros</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_EC); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">M&aacute;s econ&oacute;micos primeros</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_PRECIO_CE); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">M&aacute;s costosos primeros</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_AZ); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">(A-Z)</a></li>
									<%	busquedaDAO.setCriterio(BuscadorHelper.CRIT_ALFAB_ZA); %>
			 					   	<li><a href="<%=busquedaDAO.salto()%>">(Z-A)</a></li>
			 					   	<%	busquedaDAO.setCriterio(criterio); %>
			                    </ul>
			                </li>
			            <%	} %>
			            </ul>
			        </div>
			    </div>
			</div>
			
			<%	for (int i = 0; i < busquedaDAO.subtotales().length; i++) {
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
							for (int index = 0; index < Math.min(busquedaDAO.getItems().size(), cantArticulosPorPagina); index++) {
								ids.append(((Integer)busquedaDAO.getItems().get(index)).intValue()).append(",");
							}
							ArticuloClass articulos[] = ArticuloManager.getArticulosParaResultadoDeBusqueda((ids.length()>0)? ids.substring(0, ids.length()-1): "" + Globals.ARTICULO_DEFAULT, busquedaDAO.getSeccion().intValue());
							Pattern [] palabraClave= Convert.palabraClaveAPatron((busquedaDAO.getTexto()!=null)?busquedaDAO.getTexto().replaceAll("-", " "):"");
							String resAtrPri =  "<span href=\"\" class=\"rAtrPri\">";
							String resAtrPriCie = "</span>";
							String resTxt = "<span class=\"rTxt\">";
							String resTxtCie = "</span>";
			%>

			
			<div id="resBusqueda">
			<% for (int y=0; y<articulos.length; y++) {
					ArticuloClass articulo=articulos[y];
					DisponibilidadDAO disponibilidad=DisponibilidadDAO.buscaDisponibilidad(articulo.getIdDisponibilidad());
			%>
				<div class="listadoMod">        
		            <div class="detalleImagen">
						<a href="<%=CategoriaService.getURL(articulo.getCategoria())+ArticuloManager.getURL(articulo)%>">
							<%	String imgPage = "/componentes/comunes/imagenBusqueda.jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + articulo.getIdSeccion() +
								"&porcentajeDescuento=" + "&ancho=" + Globals.tamImagen[articulo.getIdSeccion()][3] + "&alto=" + Globals.tamImagen[articulo.getIdSeccion()][4] + "&esNovedad=" + articulo.esNovedad() +
								"&titulo=" + Convert.corregir(articulo.getTitulo(), true).toUpperCase();
							%>
							<jsp:include page="<%=imgPage %>"/>
						</a>            
		            </div>
			        <div>
						<div class="listadoModInfo" id="resultado<%=String.valueOf(y)%>">
							<a href="<%=CategoriaService.getURL(articulo.getCategoria())+ArticuloManager.getURL(articulo)%>" class="dInfoTit">
								<% String upperTitle=Convert.corregir(articulo.getTitulo(), true).toUpperCase(); %>
								<% String foramtedTitle=Convert.resaltado(palabraClave, upperTitle, 0, resAtrPri, resAtrPriCie); %>
			               		<%=foramtedTitle %>
			               	</a>
			              	<%	String atributoPrincipal = "";
								if (articulo.getAtributoPrincipal() != null && !"".equals(articulo.getAtributoPrincipal())) {
									BusquedaPorAtributoPrincipal busquedaPorAtributoPrincipal = new BusquedaPorAtributoPrincipal(
										articulo.getAtributoPrincipal(), articulo.getIdAtributoPrincipal(), new Integer(articulo.getIdSeccion()),
										new Integer (1), new Integer(10), BuscadorHelper.CRIT_MAS_VENDIDOS, !disponibilidad.estaDisponible());
									atributoPrincipal = articulo.getAtributoPrincipal() + " - ";
							%>
								<div class="dInfoAutor">de
									<a href="<%=busquedaPorAtributoPrincipal.buscador.salto()%>" class="atrPplBus">
										<%=Convert.resaltado(palabraClave, articulo.getAtributoPrincipal().toUpperCase(), 0, resAtrPri, resAtrPriCie)%>
									</a>
									<br>
								</div>
							<%	} %>
			                
			                <%--	BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
									articulo.getCategoria().getSubCategoria()[0].getDescripcion(), 
									articulo.getCategoria().getCategoriaPK().getPK()[1],
									articulo.getCategoria().getSubCategoria()[0].getCategoriaPK().getPK()[1], 
									(Integer) null,
									(Integer) null, 
									new Integer(1),
									new Integer(10),
									BuscadorHelper.CRIT_MAS_VENDIDOS, 
									!disponibilidad.estaDisponible());
			                --%>
			                
			                <%	if(articulo.getCategoria()!=null){	
			                		Categoria clasificacion=articulo.getCategoria();
					                while (clasificacion.getSubCategoria().length>0) {
					                	clasificacion = clasificacion.getSubCategoria()[0];			
					        		}
			                		String genero=Convert.capitalizar(clasificacion.getDescripcion(), true);
			                		
			                		BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
			        						articulo.getCategoria().getSubCategoria()[0].getDescripcion(), 
			        						articulo.getCategoria().getCategoriaPK().getPK()[0],
			        						articulo.getCategoria().getSubCategoria()[0].getCategoriaPK().getPK()[1], 
			        						(Integer) null,
			        						(Integer) null, 
			        						new Integer(1),
			        						new Integer(10),
			        						BuscadorHelper.CRIT_MAS_VENDIDOS, 
			        						!disponibilidad.estaDisponible());		
			                		
			                		StringBuffer urlGenero=busquedaPorCategoria.salto();
			                		
			                %>
			                	<span>Clasificaci&oacute;n: <a href="<%=urlGenero%></a>"><%=genero%></a></span>
			                <%	} %>
			                
				
							<%	if((articulo.getSinopsis()!=null)&&(articulo.getSinopsis().length()>0)){
									String strSinopsis = articulo.getSinopsis();
									if(strSinopsis.length()>200){
										strSinopsis=strSinopsis.toString().substring(0, 200)+ "...";
									}
							%>	
								<span>Sinopsis:            
				                   	<%=strSinopsis.toString()%>
								</span>
							<%	} %>
			                
						</div>
					</div>
			        <div class="listadoModAcciones">
						<div>
							<span>Precio: 
								<p>	
									<%	String precio = Contenido.precioToString(articulo.getPrecio());	
										precio=precio.substring(0, precio.length() - 2);
									%>
									<%=	precio %>
								</p>
							</span>
							<%	if(disponibilidad.estaDisponible()){ %>
								<a href="javascript:carrito_AgregarArticulo(<%=String.valueOf(articulo.getIdArticulo()) %>);window.scrollTo(0,0);"></a>
							<%	}else{ %>
								<img onclick="javascript:if (confirm('Este producto no esta disponible actualmente. Desea hacer un pedido?'))document.location = '/PedidoEspecial?ID_ARTICULO=<%=String.valueOf(articulo.getIdArticulo()) %>';" src="/imagenes/rediseno/imagenes/seccion<%=seccion %>/b-pedir.png" alt="Pedir" style="cursor: pointer;" />
							<%	} %>
						
						</div>	                   
					</div>
				</div>
			<%	}
						}
					}
				}
			%>
			</div>
			
		<%
			int totalProductos = busquedaDAO.subtotales()[busquedaDAO.getSeccion().intValue()];
			int totalPaginas = (int)Math.ceil((double)totalProductos/cantArticulosPorPagina);
			if (totalPaginas>1) {
		%>
		<div class="arbolShadow listPaginado"><!-- paginado -->
			<div class="busqOrden">
			<%	int paginaActual = (int)Math.ceil((double)registroInicial.intValue()/cantArticulosPorPagina);
				if (paginaActual > 1) {
					StringBuffer saltoNavegacion = busquedaDAO.salto();
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer ((((paginaActual-1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer((paginaActual-1)*cantArticulosPorPagina));
			%>
				<h5><a href="<%=saltoNavegacion%>" >Anterior</a></h5>
				|<span>Página:</span>
			<%	}
				for (int x=Math.max(paginaActual-5, 1); x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {
					StringBuffer saltoNavegacion = busquedaDAO.salto();
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer (((x*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer(x*cantArticulosPorPagina));
					if (paginaActual == x) {
			%>
				<h4><%=x%></h4>
			<%		}else{%>
				<a href="<%=saltoNavegacion%>"><%=x%></a>
			<%		}
				}
				if ( paginaActual < totalPaginas) {
					StringBuffer saltoNavegacion = busquedaDAO.salto();
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.CRITERIO_ORDEN, busquedaDAO.getCriterio().getClave());
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_INICIAL, new Integer ((((paginaActual+1)*cantArticulosPorPagina)+1)-cantArticulosPorPagina));
					busquedaDAO.parametro(saltoNavegacion, BuscadorHelper.REGISTRO_FINAL, new Integer((paginaActual+1)*cantArticulosPorPagina));
			%>
				|<h5><a href="<%=saltoNavegacion%>">Siguiente</a></h5>
			<%	} %>
			 </div>
		</div>	
				
		<%	} %>
		    
		</div> 
	<%	}else{ %>
		<div class="busqMarco">
			<div class="busqNoResult">
				Podés ampliar tu búsqueda a través de la 
				<!-- 
				<a href="/articulo/buscadorAvanzado.jsp?idSeccion=<tmpl_var idSeccion>&seccion=<tmpl_var idSeccion>&porPalabrasClaves=<tmpl_var clave>">búsqueda avanzada</a>, o comunicarte con nuestro 
				<a href="/institucional/servicios.jsp#servicios">centro del servicio al cliente</a>.
				 -->
			</div>
		</div>   
	<%	} %>
	
</div>


<!-- *************************** -->


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
