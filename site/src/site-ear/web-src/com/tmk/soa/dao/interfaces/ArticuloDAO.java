package com.tmk.soa.dao.interfaces;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.TemaMusical;
import com.tmk.dbo.DBO;
import com.tmk.soa.exceptions.AplicationException;

public interface ArticuloDAO {
	/**
	 * Obtiene un articulo dado su ID
	 */
	public Articulo getArticuloById(Integer idArticulo) throws AplicationException;	
	/**
	 * sobre escribo el otro, pero son para recibir con Integer  despues llamo al que recibe el list y el comparator
	 * @param idArticulo
	 * @return
	 * @throws AplicationException
	 */
	public Collection getListaArticulos(Integer idArticulo) throws AplicationException;
	/**
	 * Obtiene los comentarios asocioado a un Articulo
	 * @param idArticulo
	 * @return
	 * @throws AplicationException
	 */
	public Articulo getComentariosXArticulo(Integer idArticulo) throws AplicationException;
	/**
	 * Obtengo los ids de los articulos ralionados
	 */ 
	public List<Integer> getIdsArticulosRelacionados (Integer idArticulo,int cantidad) throws SQLException,AplicationException;
	/**
	 * Obtengo Articulos ralacionados
	 */ 
	public Collection getArticulosRelacionados (List<Integer> idsArticulos) throws AplicationException;
	/**
	 * 
	 * @param idArticulo
	 * @return TemaMusica[]  
	 * @throws AplicationException
	 */
	public TemaMusical[] getTemasMusicalesByIdArticulo(Integer idArticulo) throws AplicationException ;
	
	/**
	 * Retorna la biogafia para un articulo determinado
	 * @param idArticulo
	 * @return
	 * @throws AplicationException
	 */
	public Articulo getBiografiaByIdArticulo(Integer idArticulo) throws AplicationException ;
	
	/**
	 * Obtiene los datos de un articulo sin tener en cuenta ningun DBO, osea tablas relacionadas.
	 * @param idArticulo
	 * @return Dbo de Articulo
	 */
	public Articulo getDatosPrincipal(Integer idArticulo);
	
	/**
	 * Obtiene un Articulo, para mostrar los datos en la pantalla de 
	 * carrito de compras
	 */
	public Articulo getArticuloByIDParaCarrito(Integer idArticulo) throws AplicationException;
	
	/**
	 * Obtiene un Articulo, para mostrar los datos en la pantalla de 
	 * carrito de compras
	 */
	public Articulo getArticuloByIDParaChequearDisponibilidad(Integer idArticulo) throws AplicationException;
	
	/**
	 * Metodo que usado para generar los links de seo de la mesa
	 *   
	 */
	public Collection getListaArticulosParaSEO(List<Integer> idArticulos) ;
	
	//public Articulo getComentarioParaHome(Integer idArticulo,Comparator<DBO> comparador)throws AplicationException;
}
