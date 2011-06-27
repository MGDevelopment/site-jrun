<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.view.model.wrapper.ActionView"%> 
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.SortedMap"%>
<%@page import="com.tmk.view.model.ResultadoBusquedaForm"%>
<%@page import="com.tmk.view.ArticuloView"%>
<%@page import="java.util.Vector"%>
<%@page import="com.tmk.util.HTML.Template"%>
<%@page import="com.tmk.controllers.MainHelper"%>
<%@page import="java.util.Hashtable"%>
<%@page import="com.tmk.kernel.TmkLogger"%>
<%@page import="java.util.List"%>
<%@page import="com.tmk.kernel.DBUtil"%>
<%@page import="com.tmk.service.articulo.ArticuloService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>


<%
	//obtengo el modelo de esta vista, cargada el ResultadoBusquedaAction.java
	ResultadoBusquedaForm resultadoBusquedaForm = (ResultadoBusquedaForm) request.getAttribute("resultadoDeBusquedaForm");
	Vector vecDetalles = new Vector();//guarda todos los detalles
	Hashtable hasDetalles = null;
	Hashtable path = new Hashtable();//para el parth de la template

	path.put("filename", application.getRealPath(MainHelper.RES_TMPL_PATH
					+ "/templates/tmpResultadoDeBusqueda.htm"));
	//path para levantar la template de los detalles de articulo(tmpListaArticulo.htm) 	
	path.put("url", application.getRealPath(MainHelper.RES_TMPL_PATH
					+ "/templates/"));

	try {
		Template tmpResultadoDeBuqueda = new Template(path);
		//seteo de los atributos
		tmpResultadoDeBuqueda.setParam("textoBuscado",resultadoBusquedaForm.getTextoBuscado());
		tmpResultadoDeBuqueda.setParam("cantidadResultados",resultadoBusquedaForm.getCantidadDeResultados());
		
		if (resultadoBusquedaForm.getCantidadDeResultados() > 0) {
			Integer idSeccion = (Integer)request.getAttribute("idSeccion");
			if(idSeccion == null ) {
				idSeccion = new Integer(request.getParameter("seccion"));
			}
			//determino que seccion es para indicar el estilo del arbol  
			if(idSeccion == 3) {
				tmpResultadoDeBuqueda.setParam("seccionArbol","Pasatiempos");
			}else if(idSeccion == 0) {
				tmpResultadoDeBuqueda.setParam("seccionArbol","Libros");
			}else {
				tmpResultadoDeBuqueda.setParam("seccionArbol",Convert.capitalizar(Globals.seccion(idSeccion.intValue()),false));
			}
			tmpResultadoDeBuqueda.setParam("tieneResultados", true);
			tmpResultadoDeBuqueda.setParam("pedidoEspecial",!resultadoBusquedaForm.isEsPedidoEspecial());
			//detalle de resultado
			ArticuloView.setListaArticulo(resultadoBusquedaForm.getListaArticulo(), tmpResultadoDeBuqueda);

			//SETEO DE SELECCION DE LAS SECCICNES, Y MARCO CUAL ESTA SELECCIONADA, para no mostrarla
			Vector<Hashtable<String,String>> aux = new Vector<Hashtable<String,String>>();
			Hashtable<String,String> hashSeccion = null;			
			for (int i = 0; i < resultadoBusquedaForm.getSecciones().size(); i++) {
				hashSeccion = resultadoBusquedaForm.getSecciones().get(i);
				boolean seMuestra =  hashSeccion.get("seMuestra").equals("true");
				if(seMuestra) {					
					aux.add(resultadoBusquedaForm.getSecciones().get(i));
				}
			}
			for(int i=0;i<aux.size();i++){
				hashSeccion = aux.get(i);
				boolean estaSeleccioanda = hashSeccion.get("esSeccionSeleccionada").equals("true");
				if (estaSeleccioanda) {
					//seteo en la template cual esta seleccionado y lo elimino de vector para no mostrarlo, como uno de la lista
					tmpResultadoDeBuqueda.setParam("seccionSeleccionado",hashSeccion.get("resultadosEn"));
					aux.remove(i);
				}
			}
			tmpResultadoDeBuqueda.setParam("dropSecciones",aux);
			aux=null;
			//SETEO DE LAS AGRUPACIONES  Y SUS FILTROS------------------------------------------------------------
			SortedMap<String, List<ActionView>> agrupacionDeFiltros = resultadoBusquedaForm.getFiltrosDeBusqueda();
			//claves de los filtros (son las agrupaciones)
			Iterator itClaves = agrupacionDeFiltros.keySet().iterator();
			//vector de agrupaciones para la template, con tamaño definido
			Vector vecAgrupaciones = new Vector(agrupacionDeFiltros.keySet().size());
			//hash para cargar las agrupaciones
			Hashtable hashAgrupaciones = null;
			while (itClaves.hasNext()) {
				Hashtable hashFiltros = null;
				//una clave concreta dentro del iterador 
				String clave = (String) itClaves.next();
				//obtengo los filtro para la agrupacion dada por la clave "clave"
				List filtrosXClave = agrupacionDeFiltros.get(clave);
				//iterador para los filtros de una categoria
				Iterator<ActionView> itFiltros = filtrosXClave.iterator();
				//vector donde se agregan los Filtros para una Categoria especifica
				Vector<Hashtable<String, String>> vecFiltros = new Vector(filtrosXClave.size());
				hashAgrupaciones = new Hashtable<String, String>();
				//si no es el filtro que se selecciono
				if (!clave.equals(resultadoBusquedaForm.getIdFiltro())) {
					hashAgrupaciones.put("descripcion", ArticuloView.getDescripcionPorSeccion(clave,idSeccion));
					while (itFiltros.hasNext()) {
						hashFiltros = new Hashtable<String, String>();
						ActionView filtro = itFiltros.next();
						if(resultadoBusquedaForm.getEsBusquedaDeInicio()) {
							hashFiltros.put("linkFiltro", filtro.buildJsFuncion());
						}else {
							hashFiltros.put("linkFiltro", filtro.buildHref());
						}
						//hashFiltros.put("linkFiltro", (filtro.estaSeleccionado())?filtro.buildHref()+"&eliminarFiltro=true":filtro.buildHref());
						hashFiltros.put("textoFiltro",Convert.corregir(filtro.getDescripcion(), true));
						vecFiltros.add(hashFiltros);
						hashAgrupaciones.put("filtros", vecFiltros);
					}
					vecAgrupaciones.add(hashAgrupaciones);
					//si es el filtro que se selecciono
				} else {
					ActionView filtro = itFiltros.next();
					tmpResultadoDeBuqueda.setParam("textoFiltro",Convert.corregir(filtro.getDescripcion(),true));
					//tmpResultadoDeBuqueda.setParam("linkFiltroDel",resultadoBusquedaForm.getEliminarFiltro()+ "&CANT_SIN_FILTRO=" + resultadoBusquedaForm.getAuxCantidad());
					tmpResultadoDeBuqueda.setParam("linkFiltroDel",resultadoBusquedaForm.getEliminarFiltro());
					tmpResultadoDeBuqueda.setParam("estaSeleccionado","true");
				}
			}
			tmpResultadoDeBuqueda.setParam("agrupaciones",vecAgrupaciones);
			//vecAgrupaciones=null;
			//si no es busqueda de inicio muestro las agrupaciones, con sus filtros.
			tmpResultadoDeBuqueda.setParam("noEsInicio",!resultadoBusquedaForm.getEsBusquedaDeInicio());
			//RENDER DE CRITERIOS------------------------------------------------------------------
			List<ActionView> criterios = resultadoBusquedaForm.getCriterios();
			Vector<Hashtable<String, String>> vecCriterios = new Vector<Hashtable<String, String>>(criterios.size());
			Iterator<ActionView> itCriterios = criterios.iterator();
			while (itCriterios.hasNext()) {
				ActionView criterio = itCriterios.next();
				if (criterio.estaSeleccionado()) {
					tmpResultadoDeBuqueda.setParam("criterioSeleccionadoDescripcion", criterio.getDescripcionOpcional(criterio.getDescripcion(),criterio.getParametros()));
				} else {
					Hashtable<String, String> hashCriterio = new Hashtable<String, String>();
					hashCriterio.put("criterioDescripcion", criterio.getDescripcion().replaceAll(":",":<br/>"));
					hashCriterio.put("criterioFuncion", criterio.buildHref());
					vecCriterios.add(hashCriterio);
				}
			}
			tmpResultadoDeBuqueda.setParam("criterio", vecCriterios);
			//criterios = null;
			//RENDER DE LA PAGINACION---------------------------------------------------------------
			List<ActionView> paginas = resultadoBusquedaForm.getPaginas();
			Vector<Hashtable<String, String>> vecPaginas = new Vector();//es necesari instanciar la el vector.si no si esta vacio no anda la template

			//obtengo la cantidad de paginas que tiene(no incluye a los links anterior y siguiente
			if (resultadoBusquedaForm.getTotalPaginas() > 1) {
				vecPaginas = new Vector(resultadoBusquedaForm.getTotalPaginas() + 2);
				Hashtable hashPaginas = null;
				//seteo el link Anterior
				ActionView direccion = (ActionView) paginas.get(0);
				hashPaginas = new Hashtable(resultadoBusquedaForm.getTotalPaginas() + 2);
				hashPaginas.put("esLinkAnterior", "true");
				hashPaginas.put("estaActivo", direccion.isEstaActivo());
				hashPaginas.put("linkAnterior", direccion.buildHref());
				hashPaginas.put("textoAnterior", direccion.getDescripcion());
				vecPaginas.add(hashPaginas);

				//loopeo y cargo la numeracion de las paginas
				for (int i = 1; i <= resultadoBusquedaForm.getTotalPaginas()&& i <= 10; i++) {
					ActionView pagina = paginas.get(i);
					hashPaginas = new Hashtable();
					hashPaginas.put("esPagina", "true");
					hashPaginas.put("linkPagina", (pagina.estaSeleccionado()) ? "" : pagina.buildHref());
					hashPaginas.put("numPagina", pagina.getDescripcion());
					hashPaginas.put("estaSeleccionado", pagina.estaSeleccionado());
					vecPaginas.add(hashPaginas);
				}
				//seteo el link Siguiente			
				direccion = paginas.get(paginas.size() - 1);//saco de la ultima posicion de LinkedList el boton siguiente, asi se cargo en el Action			
				hashPaginas = new Hashtable();
				hashPaginas.put("esLinkSiguiente", "true");
				hashPaginas.put("estaActivo", direccion.isEstaActivo());
				hashPaginas.put("linkSiguiente", direccion.buildHref());
				hashPaginas.put("textoSiguiente", direccion.getDescripcion());
				vecPaginas.add(hashPaginas);
				tmpResultadoDeBuqueda.setParam("paginas", vecPaginas);
				tmpResultadoDeBuqueda.setParam("tienePaginas", true);
			}
			//con todo seteado seteo el tmpl_loop de las paginas
		} else {
			Integer idSeccion = (Integer)request.getAttribute("idSeccion");
			if(idSeccion.intValue() == 0) {
				tmpResultadoDeBuqueda.setParam("idSeccion", "" + 1);
			} else {
				tmpResultadoDeBuqueda.setParam("idSeccion", "" + idSeccion.intValue());
			}
			//tmpResultadoDeBuqueda.setParam("idSeccion", "" + 1);
			tmpResultadoDeBuqueda.setParam("clave",resultadoBusquedaForm.getTextoBuscado());
			if(resultadoBusquedaForm.isEsPedidoEspecial()) {
				tmpResultadoDeBuqueda.setParam("mostrarLinkSinDispobibilidad","");
			}else{
				tmpResultadoDeBuqueda.setParam("mostrarLinkSinDispobibilidad","true");
			}
		}		
		tmpResultadoDeBuqueda.setParam("sinStock",resultadoBusquedaForm.getEliminarFiltro().replaceAll("pedidoEspecial=false","pedidoEspecial=true"));
		out.println(tmpResultadoDeBuqueda.output());
	} catch (Exception e) {
		TmkLogger.error("Ocurrio un error en resultados...");
	}
%>
<script language="javascript">
	var texto = "<%=resultadoBusquedaForm.getTextoBuscado().trim()%>";	
	texto = texto.toLowerCase();
	if(texto!="" && texto.length > 0) {
		searchPrompt(texto,<%=resultadoBusquedaForm.getCantidadDeResultados()%>,false, 'green', 'pink');
	}
</script>