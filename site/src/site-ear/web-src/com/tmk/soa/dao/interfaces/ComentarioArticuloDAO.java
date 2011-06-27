package com.tmk.soa.dao.interfaces;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import com.tmk.bus.comentario.ComentarioArticulos;
import com.tmk.soa.exceptions.AplicationException;

public interface ComentarioArticuloDAO {

	/**
	 * Obtiene un ComentarioArticulo dado su idComentario
	 * @param idComentario
	 * @return
	 */
	public ComentarioArticulos findByPK(Integer idComentario,Integer idArticulo) throws AplicationException;
	
	/**
	 * Obtiene todos los comentarios de un articulo dado su idArticulo
	 * @param idArticulo
	 * @return
	 */
	public Collection findByIdArticulo(Integer idArticulo)throws AplicationException;
	
	/**
	 * Obtiene un comentario dado su id, a diferencia de findByPK, no usa el id de articulo
	 * @param idComentario
	 * @return
	 * @throws AplicationException
	 */
	public ComentarioArticulos getByIdComentario(Integer idComentario)throws AplicationException;
	
	/**
	 * Obtiene los ids de los comentarios mas recientes con evaluacion mayor a 2
	 * @return
	 * @throws Exception
	 */
	public Collection  getIdsDeComentarios(int cantidad)throws Exception;
	
	/**
	 * Obtiene los ids de los comentarios mas recientes con evaluacion mayor a 2, para una secicon determinada
	 * @return
	 * @throws Exception
	 */
	public Collection  getIdsDeComentarios(HashMap<String, Object> pk,Integer cantidad)throws Exception;
	
	/**
	 * Obtiene la coleccion de comentarios.
	 */
	public Collection  getComentariosByIds(List ids)throws Exception;

}
