package com.tmk.soa.servicios.implementation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import com.tmk.bus.articulo.Articulo;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.servicios.interfaces.ArticuloService;

public class ArticuloServiceImpl implements ArticuloService{
	
	/**
	 * Obtiene un lista de articulos
	 */
	public Collection getListaArticulos(Integer idArticulo) throws AplicationException {
		return DAOFactory.getArticuloDAO().getListaArticulos(idArticulo);
	}
	
	/**
	 * Obtiene un articulo dado por su ID
	 */
	public Articulo getArticuloById(Integer idArticulo) throws AplicationException {
		return DAOFactory.getArticuloDAO().getArticuloById(idArticulo);
	}
	
	/***
	 * Devule los ids de los articulos relacionados.
	 * @param idArticulo
	 * @return
	 */
	public List<Integer> getIdsArticulosRelacionados (Integer idArticulo, int cantidad){
		try {
			return DAOFactory.getArticuloDAO().getIdsArticulosRelacionados(idArticulo, cantidad);	
		} catch (SQLException e) {
			TmkLogger.error("ArticuloServiceImpl->getIdsArticulosRelacionados->SQLException]" + e);
		}catch (AplicationException e) {
			TmkLogger.error("ArticuloServiceImpl->getIdsArticulosRelacionados->AplicationException"+ e);
		}
		return new ArrayList<Integer>();
	}

	/**
	 * Devuelve los articulos relacionados al de detalle<br>
	 * Por defecto devuelve 3 articulos se puede parametrizar para
	 * que devuelva mas
	 */
	public Collection getArticulosRelacionados(Integer idArticulo) {		
		try {
			List<Integer> ids = this.getIdsArticulosRelacionados(idArticulo, 3);
			if(ids.size() > 0 ) {
				return DAOFactory.getArticuloDAO().getArticulosRelacionados(ids);
			}
		}catch (AplicationException e) {
			TmkLogger.error("ArticuloServiceImpl->getArticulosRelacionados ]" + e);
		}
		return null;
	}

	public Articulo getComentariosXArticulo(Integer idArticulo) {
		try {
			return DAOFactory.getArticuloDAO().getComentariosXArticulo(idArticulo);
		}catch (AplicationException e) {
			return null;
		}
	}
	
	public Articulo getBiografiaByIdArticulo(Integer idArticulo) {
		try{
			return DAOFactory.getArticuloDAO().getBiografiaByIdArticulo(idArticulo);
		}catch (AplicationException e) {
			return null;
		}
	}
	
	public Articulo getDatosPrincipal(Integer idArticulo) {
		return DAOFactory.getArticuloDAO().getDatosPrincipal(idArticulo);
	}
	
	public Articulo getArticuloParaCarrito(Integer idArticulo) {
		try {
			return DAOFactory.getArticuloDAO().getArticuloByIDParaCarrito(idArticulo);
		}catch(AplicationException ae) {
			TmkLogger.error(ae.getMessage());
			return null;
		}
	}
	
	/**
	 * Obtiene un articulo dado por su ID
	 */
	public Articulo getArticuloParaChequearDisponibilidad(Integer idArticulo){
		try{
			return DAOFactory.getArticuloDAO().getArticuloByIDParaChequearDisponibilidad(idArticulo);
		}catch(AplicationException ae){
			return null;
		}
	}
	
	public Collection getListaArticulosParaSEO(List<Integer> idArticulos) {
		return DAOFactory.getArticuloDAO().getListaArticulosParaSEO(idArticulos);
	}

	/*public Articulo getComentariosParaHome(Integer idArticulo) {
		try {
			return DAOFactory.getArticuloDAO().getComentarioParaHome(idArticulo, new ComparadorPorDefecto());
		} catch (AplicationException e) {
			return null;
		}
	}*/
}
