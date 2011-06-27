package com.tmk.view.model;

import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.service.buscador.BuscadorHelper;
import com.tmk.view.model.wrapper.ActionView;

/***
 * @see Modelo de la resultadoDeBusqueda.jsp   
 * @author oClopez
 *
 */
public class ResultadoBusquedaForm extends ActionForm {
	//private List<Articulo> listaArticulo;
	private Collection<Articulo> listaArticulo;
	private int paginaActual;
	private int totalPaginas;
	private SortedMap<String, List<ActionView>> filtrosDeBusqueda;
	private List<ActionView>paginas;
	private List<ActionView>criterios;
	private Vector<Hashtable<String, String>> secciones;
	private String textoBuscado;
	private int cantidadDeResultados;
	//private int auxCantidad;
	private String idFiltro;
	private String eliminarFiltro;
	private boolean esBusquedaInicio; 
	private boolean esPedidoEspecial;
	private List<Integer> items;
	private String[] arrayIn;
	
	public ResultadoBusquedaForm() {
		super();
		criterios = new LinkedList<ActionView>();
		for (int i=0; i<BuscadorHelper.criterios.length; i++) {
			ActionView criterio = new ActionView(BuscadorHelper.criterios[i].getDescripcion());
			criterio.addParametros(BuscadorHelper.CRITERIO_ORDEN, BuscadorHelper.criterios[i].getClave().toString());
			criterio.addParametros("mantenerBusqueda", "true");
			criterios.add(criterio);
		}
		
		this.secciones = new Vector<Hashtable<String, String>>(5);
		Hashtable<String,String> hasSeccionesDeBusqueda = new Hashtable<String,String>();		
		synchronized (hasSeccionesDeBusqueda) {
			hasSeccionesDeBusqueda.put("idSeccion",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("idSeccionPropia",""+Globals.SECCION_LIBRO);
			hasSeccionesDeBusqueda.put("optSeleccionada","En Libros");			
			hasSeccionesDeBusqueda.put("resultadosEn","En Libros");
			hasSeccionesDeBusqueda.put("seccionBusqueda","En Libros");
			hasSeccionesDeBusqueda.put("texto","");
			hasSeccionesDeBusqueda.put("esSeccionSeleccionada","false");
			hasSeccionesDeBusqueda.put("seMuestra","false");
			this.secciones.add(hasSeccionesDeBusqueda);
			//solo en musica
			hasSeccionesDeBusqueda = new Hashtable<String,String>();
			hasSeccionesDeBusqueda.put("idSeccion",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("idSeccionPropia",""+Globals.SECCION_MUSICA);
			hasSeccionesDeBusqueda.put("optSeleccionada","En Musica");
			hasSeccionesDeBusqueda.put("seccionBusqueda","En Musica");
			hasSeccionesDeBusqueda.put("resultadosEn","En Musica");
			hasSeccionesDeBusqueda.put("texto","");
			hasSeccionesDeBusqueda.put("esSeccionSeleccionada","false");
			hasSeccionesDeBusqueda.put("seMuestra","false");
			this.secciones.add(hasSeccionesDeBusqueda);
			//solo en peliculas
			hasSeccionesDeBusqueda = new Hashtable<String,String>();
			hasSeccionesDeBusqueda.put("idSeccion",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("idSeccionPropia",""+Globals.SECCION_PELICULA);
			hasSeccionesDeBusqueda.put("optSeleccionada","En Peliculas");			
			hasSeccionesDeBusqueda.put("resultadosEn","En Peliculas");
			hasSeccionesDeBusqueda.put("seccionBusqueda","En Peliculas");
			hasSeccionesDeBusqueda.put("texto","");
			hasSeccionesDeBusqueda.put("esSeccionSeleccionada","false");
			hasSeccionesDeBusqueda.put("seMuestra","false");
			this.secciones.add(hasSeccionesDeBusqueda);
			//solo en pasatiempos
			hasSeccionesDeBusqueda = new Hashtable<String,String>();
			hasSeccionesDeBusqueda.put("idSeccion",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("idSeccionPropia",""+Globals.SECCION_JUGUETES);
			hasSeccionesDeBusqueda.put("optSeleccionada","En Pasatiempos");			
			hasSeccionesDeBusqueda.put("resultadosEn","En Pasatiempos");
			hasSeccionesDeBusqueda.put("seccionBusqueda","En Pasatiempos");
			hasSeccionesDeBusqueda.put("texto","");	
			hasSeccionesDeBusqueda.put("esSeccionSeleccionada","false");
			hasSeccionesDeBusqueda.put("seMuestra","false");
			this.secciones.add(hasSeccionesDeBusqueda);
			//solo en Tematika.com
			hasSeccionesDeBusqueda = new Hashtable<String,String>();
			hasSeccionesDeBusqueda.put("idSeccion",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("idSeccionPropia",""+Globals.SECCION_HOME);
			hasSeccionesDeBusqueda.put("optSeleccionada","En Tematika.com");			
			hasSeccionesDeBusqueda.put("resultadosEn","Todo el Sitio");
			hasSeccionesDeBusqueda.put("seccionBusqueda","En Tematika.com");
			hasSeccionesDeBusqueda.put("texto","");		
			hasSeccionesDeBusqueda.put("esSeccionSeleccionada","false");
			hasSeccionesDeBusqueda.put("seMuestra","false");
			this.secciones.add(hasSeccionesDeBusqueda);
		}
	}
	
	public ActionErrors validate(ActionMapping mapping,HttpServletRequest request) {
			
		String texto = request.getParameter("texto");
		if(texto == null) {
			texto = getTexto(request);
		}		
		
		for(int i=0;i< this.secciones.size();i++) {
			this.secciones.get(i).put("texto", texto);
		}
				
		//si la busqueda viene desde inicio
		//if(request.getQueryString().indexOf("optSeleccionada")==0) {
		if(request.getParameter("idSeccionPropia").equals("0") && request.getParameter("idSeccion").equals("0") ||
				request.getParameter("idSeccion").equals("0") && request.getParameter("seccionDeBusqueda").equals("En Tematika.com")	) {
			this.esBusquedaInicio = true;
		}
		if("true".equals(request.getParameter("pedidoEspecial"))) {
			this.esPedidoEspecial = true;
		}
		ActionErrors errors = null;
		/*errors = new ActionErrors();
		ActionMessages actionMessages = new ActionMessages();
		actionMessages.add("error", new ActionMessage("errorBusqueda"));
		errors.add(actionMessages);*/
		/*validacion de campos */
		/*if(request.getParameter("texto").length() < 1 ) {
			errors = new ActionErrors(); 
			errors.add("textoVacio", new ActionError("errores.busqueda.textoVacio"));//sta es la clave del properties			
		}	*/	
		return errors;
		
	}
	/***
	 * es caso de que la busqueda venga desde una busqueda avanzada, determino que campo pongo en el resaltado	
	 * @param request
	 * @return
	 */
	private String getTexto(HttpServletRequest request) {
			String titulo = Convert.toString(request.getParameter(BuscadorHelper.POR_TITULO), null);
			if (titulo != null) {
				return titulo;
			}
			String autor = Convert.toString(request.getParameter(BuscadorHelper.POR_AUTOR), null);
			if (autor != null) {
				return autor;
			}
			String editorial = Convert.toString(request.getParameter(BuscadorHelper.POR_EDITORIAL), null);
			if (editorial != null) {
				return editorial;
			}
			String palabrasClaves = Convert.toString(request.getParameter(BuscadorHelper.POR_PALABRAS_CLAVES), null);
			if (palabrasClaves != null) {
				return  palabrasClaves;
			}
			String isbn = Convert.toString(request.getParameter(BuscadorHelper.POR_ISBN), null);
			if (isbn==null) {
				return isbn;
			}
		return "";
	}

	/**
	 * como tengo el scope del action form en "session",debo resetar las variables que me afectan
	 * a la template.
	 */
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
		//reseteo de los criterios
		for(int i= 0;i < this.criterios.size();i++){
			this.criterios.get(i).setEstaSeleccionado(false);
		}		
		//resteo de las secciones
		for(int i= 0;i < this.secciones.size();i++){
			this.secciones.get(i).put("esSeccionSeleccionada", "false");
			this.secciones.get(i).put("seMuestra", "false");
		}		
		
		this.textoBuscado = null;
		this.idFiltro = null;
		this.esBusquedaInicio = false;
		this.listaArticulo = null;
		this.totalPaginas = 0;
		this.esPedidoEspecial = false;
	}
	
	public Collection<Articulo> getListaArticulo() {
		return listaArticulo;
	}
	public void setListaArticulo(Collection<Articulo> listaArticulo) {
		this.listaArticulo = listaArticulo;
	}
	public int getPaginaActual() {
		return paginaActual;
	}
	public void setPaginaActual(int paginaActual) {
		this.paginaActual = paginaActual;
	}
	public int getTotalPaginas() {
		return totalPaginas;
	}
	public void setTotalPaginas(int totalPaginas) {
		this.totalPaginas = totalPaginas;
	}
	
	public String getTextoBuscado() {
		return textoBuscado;
	}
	public void setTextoBuscado(String textoBuscado) {
		this.textoBuscado = textoBuscado;
	}

	public int getCantidadDeResultados() {
		return cantidadDeResultados;
	}

	public void setCantidadDeResultados(int cantidadDeResultados) {
		this.cantidadDeResultados = cantidadDeResultados;
	}

	
	public SortedMap<String, List<ActionView>> getFiltrosDeBusqueda() {
		return filtrosDeBusqueda;
	}

	public void setFiltrosDeBusqueda(
			SortedMap<String, List<ActionView>> filtrosDeBusqueda) {
		this.filtrosDeBusqueda = filtrosDeBusqueda;
	}

	public List<ActionView> getPaginas() {
		return paginas;
	}

	public void setPaginas(List<ActionView> paginas) {
		this.paginas = paginas;
	}
	
	public List<ActionView> getCriterios() {
		return criterios;
	}

	public void setCriterios(List<ActionView> criterios) {
		this.criterios = criterios;
	}

	public String getIdFiltro() {
		return idFiltro;
	}

	public void setIdFiltro(String idFiltro) {
		this.idFiltro = idFiltro;
	}
	
	/***
	 * Elmina todos los parametros que corresponden a un filtro 
	*/	
	public void setEliminarFiltro(String eliminarFiltro,boolean esBusquedaAvanzada,boolean tieneFiltro, boolean esBusquedaDeInicio) {
		if(tieneFiltro) {
			if(esBusquedaDeInicio) {
				//int empezarDesde = eliminarFiltro.indexOf("optSeleccionada");
				int empezarDesde = eliminarFiltro.indexOf("idSeccion=0");
				StringBuffer auxEliminar = new StringBuffer("buscar.do?");
				auxEliminar.append(eliminarFiltro.substring(empezarDesde,eliminarFiltro.length()));
				this.eliminarFiltro = auxEliminar.toString(); 
			}else if(esBusquedaAvanzada) {
				int empezarDesde = eliminarFiltro.indexOf("claveDeBusqueda");
				this.eliminarFiltro = "buscar.do?" + eliminarFiltro.substring(empezarDesde+16,eliminarFiltro.length());				
			} else if(tieneFiltro){
				int empezarDesde = eliminarFiltro.indexOf("claveDeBusqueda");
				if(empezarDesde > 0) {
					this.eliminarFiltro = "buscar.do?"+eliminarFiltro.substring(empezarDesde,eliminarFiltro.length());
				}else
					empezarDesde = eliminarFiltro.indexOf("&idSeccion");
					this.eliminarFiltro = "buscar.do?"+eliminarFiltro.substring(empezarDesde,eliminarFiltro.length());
			} else {			
				int empezarDesde = eliminarFiltro.indexOf("&claveDeBusqueda");
				if(empezarDesde > 0) {
					this.eliminarFiltro = "buscar.do?"+eliminarFiltro.substring(empezarDesde,eliminarFiltro.length());
				}else{
					this.eliminarFiltro = "buscar.do?"+eliminarFiltro.substring(0,eliminarFiltro.length());
				}
			}
			this.eliminarFiltro = this.eliminarFiltro + "&mantenerIds=true";
		}else {
			this.eliminarFiltro = "buscar.do?" + eliminarFiltro;
		}
	}

	public String getEliminarFiltro() {
		return this.eliminarFiltro;
	}
	
	public Vector<Hashtable<String,String>> getSecciones() {
		return this.secciones;
	}
	
	public boolean getEsBusquedaDeInicio() {
		return this.esBusquedaInicio;
	}

	/*public int getAuxCantidad() {
		return auxCantidad;
	}

	public void setAuxCantidad(int auxCantidad) {
		this.auxCantidad = auxCantidad;
	}
	 */
	public boolean isEsPedidoEspecial() {
		return esPedidoEspecial;
	}

	public void setEsPedidoEspecial(boolean esPedidoEspecial) {
		this.esPedidoEspecial = esPedidoEspecial;
	}

	public List<Integer> getItems() {
		return items;
	}

	public void setItems(List<Integer> items) {
		this.items = items;
	}

	public String[] getArrayIn() {
		return arrayIn;
	}

	public void setArrayIn(String[] arrayIn) {
		this.arrayIn = arrayIn;
	}	
	
}
