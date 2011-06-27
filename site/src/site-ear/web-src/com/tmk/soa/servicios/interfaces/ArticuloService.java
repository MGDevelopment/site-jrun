package com.tmk.soa.servicios.interfaces;

import java.util.Collection;
import java.util.List;

import com.tmk.bus.articulo.Articulo;
import com.tmk.soa.exceptions.AplicationException;

/**
 * Me provee de todos los metodos necesarios a un articulo<br>
 * detalle,autores relacionados, obras relacionadas, comentarios<br>
 * usuarios relacionados 
 * @author oClopez
 *
 */
public interface ArticuloService {
	
	/**
	 * Devuelve un objeto que representa un Articulos<br>
	 * @param Integer idArticulos 
	 * @return Collection de los articulos
	 * @throws Throwable
	 */	
	public Collection getListaArticulos(Integer idArticulos) throws AplicationException;

	/**
	 * Obtiene un Articulo
	 * @param idArticulo
	 * @return
	 * @throws AplicationException
	 */
	public Articulo getArticuloById(Integer idArticulo) throws AplicationException;
	/**
	 * Obtengo los ids de los articulos ralacionados
	 */ 
	public List<Integer> getIdsArticulosRelacionados (Integer idArticulo,int cantidad);
	
	/**
	 * Obtengo los Articulos ralacionados
	 */ 
	public Collection getArticulosRelacionados (Integer idArticulo);

	/**
	 * Obtiene un articulo con los comentarios que le corresponden
	 * @param idArticulo
	 * @see ArticuloServiceImp.java
	 * @return
	 */
	public Articulo getComentariosXArticulo(Integer idArticulo);

	public Articulo getBiografiaByIdArticulo(Integer idArticulo);
	
	/**
	*Obtiene solo los datos necesarios minimos de un articulo, sin dbo asociados
	*/
	public Articulo getDatosPrincipal(Integer idArticulo);
	
	/**
	 * Obtiene un articulo para mostrar los datos en la pantalla de carrito de comptas
	*/
	public Articulo getArticuloParaCarrito(Integer idArticulo);
	
	/**
	 * Obtiene un articulo con disponibilidad y tasa para chequear la disponibilidad
	 * 
	 */
	public Articulo getArticuloParaChequearDisponibilidad(Integer idArticulo);
	
	/**
	 * Obtiene una lista de dbo para llenar la template de los links para la mesa
	 */
	public Collection getListaArticulosParaSEO(List<Integer> idArticulos);
	
	/**
	 * Obtiene los articulos que aparecen en la home de tematika 
	 * @param idArticulo
	 * @return
	 */
	//public Articulo getComentariosParaHome(Integer idArticulo);
}
