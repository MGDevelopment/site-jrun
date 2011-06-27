package com.tmk.action;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.tmk.controllers.MainHelper;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.service.articulo.ArticuloService;
import com.tmk.service.buscador.BuscadorHelper;
import com.tmk.service.buscador.BusquedaAvanzada;
import com.tmk.service.buscador.BusquedaDeNovedades;
import com.tmk.service.buscador.BusquedaGenerica;
import com.tmk.service.buscador.BusquedaInicio;
import com.tmk.service.buscador.BusquedaParaRecomendar;
import com.tmk.service.buscador.BusquedaPorAutor;
import com.tmk.service.buscador.BusquedaPorCategorias;
import com.tmk.service.buscador.BusquedaPorEditorial;
import com.tmk.service.buscador.BusquedaPorIDdeAutor;
import com.tmk.service.buscador.BusquedaPorIDdeEditorial;
import com.tmk.service.buscador.BusquedaPorIDdeMarca;
import com.tmk.service.buscador.BusquedaPorIDdeProveedor;
import com.tmk.service.buscador.BusquedaPorIDs;
import com.tmk.service.buscador.BusquedaPorISBN;
import com.tmk.service.buscador.BusquedaPorMarca;
import com.tmk.service.buscador.BusquedaPorPalabrasClaves;
import com.tmk.service.buscador.BusquedaPorProveedor;
import com.tmk.service.buscador.BusquedaPorTemaMusical;
import com.tmk.service.buscador.BusquedaPorTitulo;
import com.tmk.service.buscador.BusquedaVacia;
import com.tmk.service.buscador.CriterioDAO;
import com.tmk.service.buscador.FiltroValor;
import com.tmk.service.buscador.ItemFiltro;
import com.tmk.view.ArticuloView;
import com.tmk.view.model.ResultadoBusquedaForm;
import com.tmk.view.model.wrapper.ActionView;

public class ResultadoBusquedaAction extends Action {

	/*private final static String [] suprimir = {"LA", "DE", "DEL", "CON", "LO", "LOS", "EL", "EN", "ANTE", "POR", "ESTE", "ESTA",
		"ESTOS", "Y", "A", "BAJO", "CONTRA", "DESDE", "ENTRE", "HACIA", "HASTA",
		"PARA", "SEGUN", "SIN", "SOBRE", "TRAS", ",", ";", "O", "UN", "LAS", "I", "B", "C", "D", "E", "F",
		"G", "H", "I", "J", "K", "L", "N", "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)throws Exception {	
		//CHEQUEO DE MANTENIMIENTO DEL SITIO
		String frwRedireccion = MainHelper.controlDeModo(response,request);
		if(!"".equals(frwRedireccion)) {
			return mapping.findForward(frwRedireccion);
		}
		//FIN BLOQUE
		
		//MODELO DE LA VISTA
		ResultadoBusquedaForm resultadoBusquedaForm = (ResultadoBusquedaForm)form;
		String arrayIn[] = resultadoBusquedaForm.getArrayIn();
		String texto = request.getParameter(BuscadorHelper.TEXTO);		
		boolean esBusquedaAvanzada = Convert.toBoolean(request.getParameter(BuscadorHelper.ES_BUSQUEDA_AVANZADA), false);
		String claveDeBusqueda = Convert.toString(request.getParameter(BuscadorHelper.CLAVE_DE_BUSQUEDA), null);
		Integer idSeccion = null; 
		if(request.getParameter("seccion") != null) {
			idSeccion = new Integer(request.getParameter("seccion"));
		}else {
			idSeccion  = Convert.toNumber(request.getParameter("idSeccion"),new Integer(Globals.SECCION_HOME));
		}
		request.setAttribute("idSeccion", idSeccion);
		if (texto!= null) {
			texto = getTexto(texto);
			resultadoBusquedaForm.setTextoBuscado(texto);			
		}		
		resultadoBusquedaForm.setCantidadDeResultados(0);
		
		//pregunto si es mayor a 2 por que seria la cantidad inima de caractere para correr una busqueda
		if (esBusquedaAvanzada || texto.length() > 2) {
			//si no se selecciona un criterio de orden se toma el 2 por defecto que es : Criterio: Fecha de aparición:+ recientes primeros 
			String criterioDeOrden = Convert.toString(request.getParameter(BuscadorHelper.CRITERIO_ORDEN), BuscadorHelper.CRIT_MAS_VENDIDOS.getClave().toString());
			Integer resultadosPorPagina = Convert.toNumber(request.getParameter("resultadosPorPagina"), 10);
			boolean pedidoEspecial = Convert.toBoolean(request.getParameter(BuscadorHelper.PEDIDO_ESPECIAL), false);
			Integer idGrupo = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_GRUPO), (Integer)null);			
			Integer idFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_FAMILIA), (Integer)null);			
			Integer idSubFamilia = Convert.toNumber(request.getParameter(BuscadorHelper.CATEGORIA_SUBFAMILIA), (Integer)null);
			
			int paginaActual = 0;
			//Determino la pagina actual
			if(Convert.toNumber(request.getParameter("pagina"), -1) == -1) {
				if(Convert.toNumber(request.getParameter("registroInicial"), -1)==-1) {
					paginaActual = 1;
				} else {
					paginaActual = (new Integer(request.getParameter("registroInicial")).intValue() + 9) /10;
				}
			} else {
				paginaActual = Integer.parseInt(request.getParameter("pagina"));
			}
			//DETERMINO QUE TIPO DE BUSCADOR ES--------------------------------------------------------------
			BusquedaGenerica busqueda = null;
			if(esBusquedaAvanzada) {
				String titulo = Convert.toString(request.getParameter(BuscadorHelper.POR_TITULO), null);
				if (titulo != null) {
					titulo = (titulo != null)? titulo.replaceAll("\\'", " "): null;
					texto = titulo;
				}
				String autor = Convert.toString(request.getParameter(BuscadorHelper.POR_AUTOR), null);
				if (autor != null) {
					autor = (autor != null)? autor.replaceAll("\\'", " "): null;
					if(texto==null) 
						texto = autor;
				}
				String editorial = Convert.toString(request.getParameter(BuscadorHelper.POR_EDITORIAL), null);
				if (editorial != null) {
					editorial = (editorial != null)? editorial.replaceAll("\\'", " "): null;
					if(texto==null)
						texto = editorial;
				}
				String palabrasClaves = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES), null);
				if (palabrasClaves != null) {
					palabrasClaves =  palabrasClaves.replaceAll("\\'", " ");
					if(texto==null)
						texto = palabrasClaves;
				}
				String isbn = Convert.toString(request.getParameter(BuscadorHelper.POR_ISBN), null);
				if (isbn != null) {
					isbn = (isbn != null)? isbn.replaceAll("\\'", " "): null;
					if(texto==null)
						texto = isbn;
				}
				texto = getTexto(texto);
				resultadoBusquedaForm.setTextoBuscado(texto);
				String clasificacion = Convert.toString(request.getParameter(BuscadorHelper.POR_CLASIFICACION_TEMATIKA), null);
				String idioma = Convert.toString(request.getParameter(BuscadorHelper.POR_IDIOMA), null);
				Double precio = Convert.toNumber(request.getParameter(BuscadorHelper.POR_PRECIO), (Double)null);
				String formato = Convert.toString(request.getParameter(BuscadorHelper.POR_FORMATO), null);
				
				busqueda = new BusquedaAvanzada(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial,
														titulo, autor, editorial, palabrasClaves,
														isbn, clasificacion, idioma, precio, formato);		
			}//SI NO ES BUSQUEDA AVANZADA VEO CUAL ES
			else  if (claveDeBusqueda == null) {
				busqueda = new BusquedaInicio(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_TITULO.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorTitulo(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_AUTOR.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorAutor(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_PALABRAS_CLAVES.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorPalabrasClaves(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_ISBN.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorISBN(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_EDITORIAL.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorEditorial(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_PROVEEDOR.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorProveedor(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_TEMA_MUSICAL.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorTemaMusical(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_CATEGORIAS.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorCategorias(texto, idSeccion, idGrupo, idFamilia, idSubFamilia, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_IDS.equals(claveDeBusqueda)) {
				String idArticulos = request.getParameter(BuscadorHelper.IDS_ARTICULOS);
				busqueda = new BusquedaPorIDs(texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial, idArticulos);
			} else if (BuscadorHelper.PARA_RECOMENDAR.equals(claveDeBusqueda)) {
				Integer idSucursal = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SUCURSAL), (Integer)null);
				Integer idSocio = Convert.toNumber(request.getParameter(BuscadorHelper.ID_SOCIO), (Integer)null);
				busqueda = new BusquedaParaRecomendar(paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial, idSucursal, idSocio);
			} else if (BuscadorHelper.DE_NOVEDADES.equals(claveDeBusqueda)) {
				Integer diasConsideradosNovedad  = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_CONSIDERADOS_NOVEDAD), (Integer)null);
				Integer diasIgnoradosNovedad = Convert.toNumber(request.getParameter(BuscadorHelper.DIAS_IGNORADOS_NOVEDAD), (Integer)null);
				busqueda = new BusquedaDeNovedades(idSeccion, idGrupo, idFamilia, idSubFamilia, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial, diasConsideradosNovedad, diasIgnoradosNovedad);	
			} else if (BuscadorHelper.POR_IDdeEDITORIAL.equals(claveDeBusqueda)) { //Para EMPRO evita los operadores de catsearch
				Integer idEditor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_EDITOR), new Integer (0));
				busqueda = new BusquedaPorIDdeEditorial(texto, idEditor, idSeccion, paginaActual,	resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_IDdeAUTOR.equals(claveDeBusqueda)) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
				Object idAutor = request.getParameter(BuscadorHelper.ID_AUTOR);
				busqueda = new BusquedaPorIDdeAutor (texto, idAutor, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_IDdePROVEEDOR.equals(claveDeBusqueda)) { //Para EMPRO y ARTICULO REDUCIDO evita los operadores de catsearch, mejora la busqueda
				Integer idProveedor = Convert.toNumber(request.getParameter(BuscadorHelper.ID_PROVEEDOR), new Integer(0));
				busqueda = new BusquedaPorIDdeProveedor (texto, idProveedor, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_IDdeMARCA.equals(claveDeBusqueda)) {
				Integer idMarca = Convert.toNumber(request.getParameter(BuscadorHelper.ID_MARCA), new Integer(0));
				busqueda = new BusquedaPorIDdeMarca (texto, idMarca, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} else if (BuscadorHelper.POR_MARCA.equals(claveDeBusqueda)) {
				busqueda = new BusquedaPorMarca (texto, idSeccion, paginaActual, resultadosPorPagina, new CriterioDAO(new Integer(criterioDeOrden)), pedidoEspecial);
			} 				
			else {
				busqueda = new BusquedaVacia();
			}			
			/* 	Obtiene el filtro, si es que se selecciono alguno dentro de
				las grupaciones que estan dipobibles en base al valor de FILTRO
				ej:0 = Corresponde al Filtro por categorias
			*/
			FiltroValor filtroValor = null;			
			if (request.getParameter("FILTRO") != null) {
				filtroValor = new FiltroValor(request);
				busqueda.setFiltroValor(filtroValor);
			}
			
			if((filtroValor != null || request.getParameter("mantenerIds")!=null) && arrayIn!=null) {
				if(request.getParameter("mantenerIds")!=null)
					//si busqueda de inicio
					if(request.getParameter("idSeccionPropia").equals("0") && request.getParameter("idSeccion").equals("0"))
						busqueda.setSeccionBuscada("0");
					else
						busqueda.setSeccionBuscada(request.getParameter("idSeccion"));
				busqueda.run(arrayIn);
			}else {
				busqueda.run();
				StringBuffer sqlIn = null;
				if(busqueda.getItems().size() > 1000) {
					arrayIn = Comparador.listaToArrayIN(busqueda.getItems(),"a.id_articulo");
					resultadoBusquedaForm.setArrayIn(arrayIn);
				} else {
					sqlIn= new StringBuffer("a.id_articulo in");
					sqlIn.append(Comparador.listaToIN(busqueda.getItems()));
					arrayIn = new String[1];
					arrayIn[0] = sqlIn.toString();
					resultadoBusquedaForm.setArrayIn(arrayIn);
				}
			}
			
			resultadoBusquedaForm.setCantidadDeResultados(busqueda.getCantidadDeResultados());			
			//si hay datos
			if (busqueda.getCantidadDeResultados() > 0) {
				//seteo el link para elminar el filtro selecionado 
				resultadoBusquedaForm.setEliminarFiltro(request.getQueryString(),esBusquedaAvanzada,(filtroValor!=null),resultadoBusquedaForm.getEsBusquedaDeInicio());
				//traigo los id de articulos para el dbo, si es necesario
				if(busqueda.getItems().size()>10){
					int hasta = busqueda.getItems().size();
					//en base a la pagina tomo la porcion de list que necesito buscar
					busqueda.setItems(busqueda.getItems().subList(
							(paginaActual*resultadosPorPagina)-resultadosPorPagina,
								(hasta > (paginaActual*resultadosPorPagina))?
										(paginaActual*resultadosPorPagina):
											hasta ));
				}
				//seteo de la lista de articulos para la template
				resultadoBusquedaForm.setListaArticulo(ArticuloService.getListaArticulos(busqueda.getItems(), busqueda.getCriterio().getComparador()));
				busqueda.setItems(null);
				
				//CRITERIOS (se generaron en el contructor de resultadoBusquedaForm, por unica ves)
				//y si pagino no vuelvo a calcularlos
				if(request.getParameter("mantenerCriterios")==null) {
					Iterator<ActionView> criterios = resultadoBusquedaForm.getCriterios().iterator();				
					while (criterios.hasNext()) {
						ActionView criterio = criterios.next();
						criterio.setFuncion("buscar.do");
						TreeMap<String, String> params = (TreeMap<String, String>)getParametros(request);
						params.remove(BuscadorHelper.CRITERIO_ORDEN);
						params.put(BuscadorHelper.CRITERIO_ORDEN, criterio.getParametros().get(BuscadorHelper.CRITERIO_ORDEN));
						params.remove("pagina");
						criterio.setParametros(params);
						criterio.getParametros().put("mantenerIds","true");
						if (criterio.getParametros().get(BuscadorHelper.CRITERIO_ORDEN ).equals(criterioDeOrden)) {
							criterio.setEstaSeleccionado(true);
						}
					}
				}else {
					//seteo cual es el seleccionado nada mas
					for(Iterator<ActionView> it = resultadoBusquedaForm.getCriterios().iterator();;) {
						ActionView aux =it.next(); 
						if(aux.getParametros().get(BuscadorHelper.CRITERIO_ORDEN).equals(criterioDeOrden)) {
							aux.setEstaSeleccionado(true);
							break;
						}
					}
				}				
				
				//DETERMINO CUAL DE LOS DROPS DOWN ESTA SELECCIONADO,TENIENDO EN CUENTA QUE 
				//EL METODO RUN SE CARGARON LOS IDS DE LAS CATEGORIAS QUE  TIENE OCURRENCIAS				
				for(int i=0;i<resultadoBusquedaForm.getSecciones().size();i++) {
					Hashtable<String,String> seccionSeleccionada = resultadoBusquedaForm.getSecciones().get(i);										
					seccionSeleccionada.put("seMuestra", ""
						+ (busqueda.getCantPorSecciones()[0][Integer
								.parseInt(seccionSeleccionada
										.get("idSeccionPropia"))] > 0));
					
					if(seccionSeleccionada.get("optSeleccionada").equals(
							request.getParameter("seccionDeBusqueda"))) {
						seccionSeleccionada.put("esSeccionSeleccionada", "true");
					}					
					seccionSeleccionada.put("texto", resultadoBusquedaForm.getTextoBuscado());
				}
				
				//AGRUPACION Y FILTROS,SETEO DE LAS AGRUPACIONES Y SUS FILTROS 
				//(si el parametro pagina esta presente o tiene filtro,no recalculo las agrupaciones)
				TreeMap<String, List<ActionView>> agrupaciones = new TreeMap<String, List<ActionView>>();								
				//FILTROS, si es busqueda desde inicio con seccion "Todo el Sitio"
				//muestro las canidades en cada seccion y el link dispara a cada seccion
				if(resultadoBusquedaForm.getEsBusquedaDeInicio() && filtroValor==null) {
					List<ActionView> filtros = new LinkedList<ActionView>();
					//empiezo desde 1 por que no quiero incluir la seccion Todo el Sitio
					for(int i=1;i<=5;i++) {
						if(busqueda.getCantPorSecciones()[0][i] > 0) {
							String text = Convert.capitalizar(Globals.seccion(i).replaceAll("juguetes","pasatiempos"),true);
							ActionView filtro = new ActionView(text.toUpperCase() + " ("+busqueda.getCantPorSecciones()[0][i]+")");							
							filtro.setFuncion("buscador_setBusqueda2");
							//uso A;B;C;D para que se carguen en orden y no aplicar logica de mas, asi arma el javascript 
							//con los parametros en orden
							filtro.addParametros("AoptBusqueda", "En "+text);
							filtro.addParametros("Btexto", texto);
							filtro.addParametros("CidSeccion", ""+idSeccion);
							filtro.addParametros("DidSeccionPropia", ""+i);
							filtro.addParametros("EseccionDeBusqueda", "En "+text);
							filtros.add(filtro);
						}
					}
					agrupaciones.put("Resultados en", filtros);
				} else {
					for (int i=0;i<BuscadorHelper.filtros.length; i++) {
						List<ActionView> filtros = new LinkedList<ActionView>();
						if(filtroValor == null) {
							if (filtroValor == null || !filtroValor.getIdFiltro().equals(i)) {
								//obtengo la lista de filtro dependiendo el criterio que me indique el filtro[i]
								//List<ItemFiltro> itemsFiltro = busqueda.runFilter(BuscadorHelper.filtros[i],sqlIn.toString());
								//List<ItemFiltro> itemsFiltro = busqueda.runFilter(BuscadorHelper.filtros[i],inCondicion.toString());
								List<ItemFiltro> itemsFiltro = busqueda.runFilter(BuscadorHelper.filtros[i],arrayIn);
								//itero sobre ela lista
								Iterator<ItemFiltro> itFiltros = itemsFiltro.iterator();								
								while (itFiltros.hasNext()) {
									ItemFiltro itemFiltro = itFiltros.next();
									
									ActionView filtro = new ActionView(ArticuloView.suprimir(itemFiltro.getDescripcion(), "ESP-@\\[MUS\\]", "") + " (" + 
																		itemFiltro.getCantidad() + ")");
									filtro.setFuncion("buscar.do");
									TreeMap<String, String> params = (TreeMap<String, String>)getParametros(request);
									params.remove("pagina");
									filtro.setParametros(params);
									filtro.addParametros("FILTRO", new Integer(i).toString());
									filtro.addParametros(itemFiltro.getParam());
									filtro.addParametros("FILTRODES", itemFiltro.getDescripcion());
									if(!filtro.getParametros().containsKey("claveDeBusqueda") && idSeccion != 0 ) {					
										filtro.addParametros("claveDeBusqueda","");
									}
									filtros.add(filtro);
								} 									
							} else {
								ActionView filtro = new ActionView(ArticuloView.suprimir(request.getParameter("FILTRODES"),"ESP-@\\[MUS\\]", ""));
								//cargo todos los filtros para asociarlos luego con la agrupacion correspondiente
								filtros.add(filtro);
								resultadoBusquedaForm.setIdFiltro(BuscadorHelper.filtros[i].getNombre());
							}
						}else {
							if(filtroValor.getIdFiltro().equals(i)) {
								ActionView filtro = new ActionView(ArticuloView.suprimir(request.getParameter("FILTRODES"),"ESP-@\\[MUS\\]", ""));
								//cargo todos los filtros para asociarlos luego con la agrupacion correspondiente
								filtros.add(filtro);
								resultadoBusquedaForm.setIdFiltro(BuscadorHelper.filtros[i].getNombre());
								agrupaciones.put(BuscadorHelper.filtros[i].getNombre(), filtros);
								break;
							}
						}
						//Agrego a una agrupacion los filtros encontrados ej: Categoria:[autoayuda,arte arquitectura y diseño...]
						//Si no hay filtros para una agrupacion no la muestro en las agrupaciones
						if(filtros.size() > 0) {
							agrupaciones.put(BuscadorHelper.filtros[i].getNombre(), filtros);
						}
					}	
				}
				//guardo las agrupaciones
				resultadoBusquedaForm.setFiltrosDeBusqueda(agrupaciones);		
				
				//PAGINACION-DATOS PARA LA PAGINACION----------------------------------------------------------------------
				int cantPaginas =  Convert.redondearEnteroSuperior((double)busqueda.getCantidadDeResultados()/(double)busqueda.getResultadosPorPagina());			
				List<ActionView> paginas = null;

				if(cantPaginas > 0) {
					int desde = 0;
					int hasta = cantPaginas;
					if(cantPaginas > 10) {
						desde = (paginaActual-5 > 0) ? Math.abs(paginaActual-5):0;
						if(paginaActual > 5) {
							hasta = (paginaActual + 5) < cantPaginas ? cantPaginas : paginaActual+(cantPaginas-paginaActual);
						}
					}
					if (hasta-desde < 10) {
						desde = Math.max(0, cantPaginas-10);
					}					
					
					paginas = new LinkedList<ActionView>();
					int indice = 0;
					
					//Link anterior
					ActionView direccion = new ActionView("&laquo; Anterior");
					direccion.setFuncion("buscar.do");
					direccion.setParametros(getParametros(request));
					direccion.getParametros().put("mantenerIds","true");
					direccion.getParametros().put("mantenerCriterios","true");
					//direccion.getParametros().put("CANT_SIN_FILTRO", ""+resultadoBusquedaForm.getAuxCantidad());
					direccion.getParametros().put("pagina", ""+(paginaActual-1));
					
					if(cantPaginas > 10) {
						if(paginaActual>5 ) {
							direccion.setEstaActivo(true);
							direccion.getParametros().put("pagina", ""+(paginaActual-1));
						}else{
							direccion.setEstaActivo(false);
						}
					}				
					//la  posicion 0 es para el boton anterior
					paginas.add(indice,direccion);
					indice++;			
					//datos de la numeracion y link donde apuntan numero de cada pagina
					for(int i = (desde + 1) ;(i <= hasta) && (indice <=10);i++) {		
						ActionView pagina = new ActionView(""+i);
						pagina.setFuncion("buscar.do");
						pagina.setEstaActivo(true);
						pagina.setParametros(getParametros(request));
						pagina.getParametros().put("mantenerIds","true");
						pagina.getParametros().put("mantenerCriterios","true");
						pagina.addParametros("pagina", ""+i);
						//pagina.getParametros().put("CANT_SIN_FILTRO", ""+resultadoBusquedaForm.getAuxCantidad());
						paginas.add(indice,pagina);
						indice++;
					}		
					//recuadro la pagina , sabiendo en que pagina estoy parado
					paginas.get(Math.abs(paginaActual-desde)).setEstaSeleccionado(true);
					//como ya esta selecionado no se debe poder clickear
					paginas.get(Math.abs(paginaActual-desde)).setEstaActivo(false);
					
					//Link siguiente
					direccion = new ActionView("Siguiente &raquo;");
					direccion.setFuncion("buscar.do");
					//agrego los parametros
					direccion.setParametros(getParametros(request));
					direccion.getParametros().put("mantenerIds","true");
					direccion.getParametros().put("mantenerCriterios","true");
					//direccion.getParametros().put("CANT_SIN_FILTRO", ""+resultadoBusquedaForm.getAuxCantidad());
					direccion.getParametros().put("pagina", ""+(paginaActual+1));
					direccion.setEstaActivo( (cantPaginas > 10 && (cantPaginas-paginaActual > 5) ? true : false) );
					paginas.add(indice,direccion);	
					
					resultadoBusquedaForm.setPaginaActual(paginaActual);
					resultadoBusquedaForm.setTotalPaginas(paginas.size()-2);//indico solo la cantidad de paginas sin los links					
				}	
				resultadoBusquedaForm.setPaginas(paginas);		
				resultadoBusquedaForm.setEsPedidoEspecial(pedidoEspecial);
			}//cierro -->if(busqueda.getCantidadDeResultados()>0)
			else {
				resultadoBusquedaForm.setEliminarFiltro(request.getQueryString(),esBusquedaAvanzada,(filtroValor!=null),resultadoBusquedaForm.getEsBusquedaDeInicio());
			}
		}	
		//guardo los resultados para "resultadoDeBuqueda.jsp" y determino a que definicion de visto voy 
		request.setAttribute("resultadoDeBusquedaForm",resultadoBusquedaForm);
		if (idSeccion == Globals.SECCION_HOME) {
			return mapping.findForward("vistaBusquedaInicio");
		} else {
			return mapping.findForward("vistaBusquedaSeccion");
		}	
		
	}
		
	@SuppressWarnings("unchecked")
	private SortedMap<String, String> getParametros(HttpServletRequest request) {
		Enumeration<String> e = request.getParameterNames();
		SortedMap<String, String> params = new TreeMap<String, String>();
		String nombre;		
		while (e.hasMoreElements()) {
			nombre = e.nextElement().toString();
			params.put(nombre, request.getParameter(nombre));
		}
		return params;
	}
	/***
	 * suprime caracteres especiales y elimina espacios
	 * @param texto
	 * @return
	 */
	public static String getTexto(String texto) {
		String aux[] = texto.split(" ");
		/*for (int j=0; j<suprimir.length; j++) {
			for (int i=0; i<aux.length; i++) {
				if (aux[i].toUpperCase().equals(suprimir[j])) {
					aux[i] ="";
				}
			}
		}*/
		String auxTxt = "";
		for (int i=0; i<aux.length; i++) {
			auxTxt =auxTxt + ((!aux[i].equals(""))?aux[i] + " ":"");
		}
		if (auxTxt.length()>0) {
			auxTxt = auxTxt.substring(0, auxTxt.length()-1);
			auxTxt = auxTxt.replaceAll("[^0-9-a-zA-Zá-úÁ-Ú&&\\S]", "");
			auxTxt = auxTxt.replaceAll("\\s+", " ");
		}
		texto = auxTxt;
		return texto;
	}

}
