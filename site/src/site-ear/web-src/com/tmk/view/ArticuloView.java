package com.tmk.view;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

import com.tmk.bus.articulo.Articulo;
import com.tmk.controllers.buscador.BuscadorHelper;
import com.tmk.controllers.buscador.BusquedaPorCategorias;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DisponibilidadDAO;
import com.tmk.service.comentario.ComentarioService;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ConstantesService;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.util.HTML.Template;

/**
 * @see Recibe El objeto Tempalte abierta en resultadoDeBusqueda.jsp y la lista de Articulo(dbo)
 * @see recorre los articulos y llena la template
 * permite rederear la lista de los articulos 
 * @author oClopez
 *
 */
public final class ArticuloView {
	
	@SuppressWarnings("unchecked")
	public static void setListaArticulo(Collection<Articulo> listaArticulo,
			Template tmpListaArticulo) {
		try {
			Vector vecDetalles = new Vector(listaArticulo.size());//guarda todos los detalles
			Hashtable hasDetalles = null;		
			//Vector vecAutores = null;
			Vector vecCalificacion = null;
			int i=0;
			Iterator<Articulo> itArticulo = listaArticulo.iterator();
			while(itArticulo.hasNext()){
				hasDetalles = new Hashtable(listaArticulo.size());
				Articulo articulo = itArticulo.next();  
				articulo.setUrlDetalle();
				hasDetalles.put("indice", i++);//ESTO SE USA PARA SER USADO EL RESALTADO (indica que sector del del html es tenido en cuenta por el script de resaltado)
				hasDetalles.put("urlDetalle", articulo.getUrlDetalle());
				hasDetalles.put("urlImagen", articulo.getImagen());
				hasDetalles.put("altImagen", articulo.getCls_altImagen());
				hasDetalles.put("titulo", Convert.corregir(articulo.getTitulo(), true));
				hasDetalles.put("idArticulo", articulo.getId_articulo());
				
				// cargo la/s sinopsis si la tiene
				if (articulo.getDescripcionPrincipal() != null) {
					StringBuffer strSinopsis = new StringBuffer("");
					hasDetalles.put("tieneSinopsis", "true");
					for (int j = 0; j < articulo.getDescripcionPrincipal().length; j++) {
						if (articulo.getDescripcionPrincipal()[j].getTexto() != null) {
							strSinopsis.append(articulo.getDescripcionPrincipal()[j].getTexto());
						}
					}
					hasDetalles.put("sinopsis",
								(strSinopsis.length() > 200) ? strSinopsis
										.toString().substring(0, 200)
										+ "..." : strSinopsis.toString());
				}
				String precio = Contenido.precioToString(articulo.getPrecio());
				hasDetalles.put("precio", precio.substring(0, precio.length() - 2)+"|");
				precio = Contenido.precioDollarToString(articulo.getPrecio());
				hasDetalles.put("totalDolar", precio.substring(0, precio.length() - 2)+"|");
				precio  = Contenido.precioEuroToString(articulo.getPrecio());
				hasDetalles.put("totalEuro", precio.substring(0, precio.length() - 2));			
				hasDetalles.put("genero", Convert.capitalizar(articulo.getGenero().getDescripcion(), true));
	
				BusquedaPorCategorias busquedaPorCategoria = new BusquedaPorCategorias(
						articulo.getCategoria().getSubCategoria()[0].getDescripcion(), 
						articulo.getCategoria_seccion(),
						articulo.getCategoria().getSubCategoria()[0].getCategoriaPK().getPK()[1], 
						(Integer) null,
						(Integer) null, 
						new Integer(1),
						new Integer(10),
						BuscadorHelper.CRIT_MAS_VENDIDOS, 
						!DisponibilidadDAO.buscaDisponibilidad(
										articulo.getDisponibilidad().getIdDisponibilidad()).estaDisponible());
	
				boolean esPedidoEspecial = articulo.getDisponibilidad().getPedido_especial().equals("S"); 
				if(esPedidoEspecial){
					hasDetalles.put("estaDisponible","");
					hasDetalles.put("idArticulo",articulo.getId_articulo().intValue());
					if(articulo.getCategoria_seccion() == 3) {
						hasDetalles.put("enSeccion", "Pasatiempos");
					}else {
						hasDetalles.put("enSeccion", Convert.capitalizar(com.tmk.kernel.Globals.seccion(articulo.getCategoria_seccion()),false));
					}
				}else {
					hasDetalles.put("estaDisponible","true");								
				}
				hasDetalles.put("urlGenero", busquedaPorCategoria.salto());
	
				// estrellas llenas,vacias y media estrella
				vecCalificacion = new Vector();
				double calificacion = 0;// PUEDE SER DE 0 a 5
				// determino la evaluacion
				if (articulo.getComentarioArticulo() != null) {
					calificacion = Convert.redondearAMedio(ComentarioService
							.getCalificacion(articulo.getComentarioArticulo()));
					//Seteo de la cantidad de comentarios
					hasDetalles.put("tieneEvaluacion", "true");
					hasDetalles.put("comentarioEvaluacion", ""+articulo.getComentarioArticulo().length);
					hasDetalles.put("textoComentario", ((articulo.getComentarioArticulo().length > 1) ? "comentarios" : "comentario"));
				}
	
				vecCalificacion = ServiceLocator.getComentarioService().getEstrellasByCalificacion(calificacion, ConstantesService.getInstance().getEstrellas(ConstantesService.ESTRELLAS_CHICAS));
				hasDetalles.put("calificaciones", vecCalificacion);
				hasDetalles.put("esCalificado", vecCalificacion.size() > 0);
				
				// agrego el/los autores
				if (articulo.getArticuloAutor() != null) {
					/*vecAutores = new Vector(articulo.getArticuloAutor().length);
					articulo.setUrlBusquedaAutor();// seteo la url como en
													// GetArticuloByIDnvl1
					for (int j = 0; j < articulo.getArticuloAutor().length; j++) {
						Hashtable hashAutores = new Hashtable();
		
						hashAutores.put("autor", Convert.nombrePropio(articulo
								.getArticuloAutor()[j].getAutor().getNombre(
								articulo.getCategoria_seccion()), false));
						hashAutores.put("urlAutor", articulo.getArticuloAutor()[j]
								.getAutor().getCls_urlBusqueda());
		
						vecAutores.add(hashAutores);
					}
					hasDetalles.put("autores", vecAutores);*/
					Vector vecAutores = null;
					vecAutores = ServiceLocator.getDetalleArticuloService().getAutores(articulo);
					hasDetalles.put("autores", vecAutores);
					hasDetalles.put("tieneAutor",vecAutores.size() > 0 ? "true" : "");
				}	
				vecDetalles.add(hasDetalles);
			}
			tmpListaArticulo.setParam("detalles", vecDetalles);
			// out.println(tmpListaDetalle.output());
		}catch (Exception e) {
			System.out.print(e.toString());
			 e.printStackTrace();
		}
	}

	/**
	 * Devuelve en base a la seccion Si corresponde poner categoria, discorafica o productora"
	 * @param descripcion
	 * @param idSeccion
	 * @return
	 */	
	public static String getDescripcionPorSeccion(String descripcion , Integer idSeccion) {
		if(descripcion.toLowerCase().equals("editorial")) {
			switch (idSeccion.intValue()) {
				case 4:	return "Discografica";
				case 5 :return "Productora";
				default: return descripcion; 
			}
		}
		return descripcion;		
	} 
	/**
	 * Devuelve en base a la seccion Si corresponde poner categoria, discorafica o productora"
	 * @param descripcion
	 * @param idSeccion
	 * @return
	 */	
	public static String suprimir(String origen , String cadAEliminar,String remplazarPor) {
		String eliStrings[] = cadAEliminar.split("@");
		for(int i=0;i<eliStrings.length;i++)
			origen = origen.replaceAll(eliStrings[i], remplazarPor);
		return origen;
	} 
	
	/**
	 * SE COMENTA ESTE METODO POR QUE ERA PARA DEBUGAR LA CARGA DE LAS AGRUPACIONES EN LA resultadoDebusqueda.jsp*
	@SuppressWarnings("unchecked")
	public static void setAgrupaciones(Template tmpResultadoDeBuqueda, SortedMap<String, List<ActionView>> agrupacionDeFiltros) {
		//claves de los filtros (son las agrupaciones 
		Iterator itClaves = agrupacionDeFiltros.keySet().iterator();		
		
		//vector de agrupaciones para la template, con tamaño definido
		Vector vecAgrupaciones = new Vector(agrupacionDeFiltros.keySet().size());		
		Hashtable hashAgrupaciones = null;		
	
		
		while(itClaves.hasNext()) {
			Hashtable hashFiltros = null;
			//iterador para la clave
			String clave = (String)itClaves.next();
			List filtrosXClave = agrupacionDeFiltros.get(clave);
			Iterator<ActionView> itFiltros = filtrosXClave.iterator();
			
			Vector<Hashtable<String, String>> vecFiltros = new Vector(filtrosXClave.size());
			hashAgrupaciones = new Hashtable<String, String>();
			hashAgrupaciones.put("descripcion", clave);
			
			while(itFiltros.hasNext()) {
				hashFiltros = new Hashtable<String, String>();
				ActionView filtro = itFiltros.next();
				hashFiltros.put("linkFiltro", filtro.buildHref());
				hashFiltros.put("textoFiltro", filtro.getDescripcion());
				vecFiltros.add(hashFiltros);			
			}
			hashAgrupaciones.put("filtros", vecFiltros);
			vecAgrupaciones.add(hashAgrupaciones);			
		}
		
		tmpResultadoDeBuqueda.setParam("agrupaciones", vecAgrupaciones);		
	}
	*/
}
