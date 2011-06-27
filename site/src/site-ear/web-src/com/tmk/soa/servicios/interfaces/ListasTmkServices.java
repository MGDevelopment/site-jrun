package com.tmk.soa.servicios.interfaces;

import java.util.Collection;

import com.tmk.bus.listas.ListasTmk;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.bus.listas.ListasTmkCalificaciones;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ABMServices;
import com.tmk.soa.servicios.GenericService;

/**
 * Administra lo relativo a las listas en tematika a partir de este servicio
 * cominza a utilizarse la interfaz ServicioGenerico.java, para dar una gerarquia de servicios.
 * Implementa GenericService y ABMServices.
 * @author oCLopez
 *
 */
public interface ListasTmkServices extends GenericService,ABMServices {

	/**
	 * estos son los fields que se usan para los fomularios, cuando se referencia a la tabla LISTAS_TMK
	 */
	public final static String ID_LISTA = "id_lista";
	public final static String TITULO = "titulo";
	public final static String DESCRIPCION = "descripcion";
	public final static String CALIFICACION = "calificacion";
	public final static String PUBLICA = "publica";
	/**
	 * estos son los de LISTAS_TMK_ARTICULOS
	 */
	public final static String ID_ARTICULO = "id_articulo";
	public final static String COMENTARIO = "comentario";
	
	/**
	 * Ontiene todas las listas de un socio dadu su pk (id_socio, id_sucursal_socio)
	 * @param socioPK
	 * @return Collection (ListasTmk)
	 * @throws DBOInexistenteException
	 * @throws Exception
	 */
	public ListasTmk findByPk(Object pk) throws Exception;
	
	/**
	 * Obtiene una coleccion de listas de un socios dadu su PK (SocioPK)
	 * @param socioPK
	 * @return
	 * @throws DBOInexistenteException
	 * @throws Exception
	 */
	public Collection<?> findBySocio(Object socioPK) throws DBOInexistenteException,Exception;
	
	public Collection<?> findBySocio(Object pk,boolean socioTMK) throws Exception;
	
	/**
	 * Graba los articulos en una lista
	 */
	public void grabarArticulosEnLista(Integer pkLista,ListasTmkArticulos[] articulos) throws Exception;
	
	/**
	 * Graba un articulo en una lista
	 * */
	public void grabarArticulosEnLista(Integer pkLista,ListasTmkArticulos articulo) throws Exception;
	/**
	 * Elimina un articulo de la lista, dado la pk de la lista y el id de articulo.
	 * @param pkLista
	 * @param idArticulos
	 * @throws Exception
	 */
	public void borrarArticuloEnLista(Integer pkLista,Integer idArticulos) throws Exception;
	
	/**
	 * Retorna cual es el valor de la calificacion de los usuarios
	 * @param listaCalificaciones
	 * @return
	 */
	public double getCalificacionDeLista(ListasTmkCalificaciones[] listaCalificaciones);
	
	public ListasTmk findByPk(Object idLista,boolean esSocioTMK) throws DBOInexistenteException,Exception;
	
}
