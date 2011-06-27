package com.tmk.soa.servicios.interfaces;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.tmk.bus.comentario.ComentarioArticulos;

public interface ComentarioService {
	
	/**
	 * Obtiene la calficacion que tiene un comentario
	 * @param comentarioArticulos
	 * @return
	 */
	public double getCalificacion(ComentarioArticulos[] comentarioArticulos); 

	/**
	 * Obtiene un ComentarioArticulo dado su pk
	 * @param idComentario
	 * @return
	 */
	public ComentarioArticulos getComentarioByPK(Integer idComentario,Integer idArticulo);
	
	/**
	 * Obtiene los ids de los comentarios, mas recientes para ser usados en la home de tmk 
	 * @param idArticulo
	 * @return
	 */
	public Collection<?> getIdsDeComentario(int cantidad);
	
	/**
	 * Obtiene los ids de los comentarios, mas recientes para ser usados en la home de tmk
	 * para una id_seccion particular 
	 * @param idArticulo
	 * @return
	 */
	public Collection<?> getIdsDeComentario(HashMap<String, Object> pk,Integer cantidad);
		
	/**
	 * Obtiene los ids de los ultimo comentarios con tapas... 
	 * @param idComentario
	 * @return
	 */
	public ComentarioArticulos getByIdComentario(Integer idComentario);
	
	/**
	 * Obtiene los ids de comentarios. <br>
	 * Solo trae comentarios para articulos que tiene tapa y que el comentario este aprobado
	 * @param ids
	 * @return
	 */
	public Collection<?>  getComentariosByIds(List ids);
	
	/**
	 * Devuelve un vector con las estrellas que le corresponde a esa calificacion, estrellas llenas, media estrellas y vacias.
	 * @param calificacion
	 * @return
	 */
	public Vector getEstrellasByCalificacion(double calificacion,HashMap<String, String> estrellas);
	
	
	
	
	
	
	
	
	
	/**
	 * Obtiene todos los comentarios de un articulo
	 * @param idArticulo
	 * @return
	 */
	//public Collection getComentariosByIdArticulo(Integer idArticulo);
	
	/**
	 * Obtiene el articulo de una seccion dada, mejor evalado
	 * @return Collection<?> 
	 * @author oCLopez
	 */
	//public Collection<?> getComentariosByEvaluacion(Integer evaluacion);
	
	/**
	 * Obtiene el articulos mejor evaluado para cada seccion
	 * @param evaluacion
	 * @return Collection<?> 
	 */
	//public Collection<?> getComentariosByEvaluacion();

	//public ComentarioArticulos getComentarioByIdArticulo(Integer idArticulo) ;
}
