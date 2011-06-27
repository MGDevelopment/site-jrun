package com.tmk.soa.servicios.implementation;

import java.sql.Timestamp;
import java.util.Collection;
import com.tmk.bus.listas.ListasTmk;
import com.tmk.bus.listas.ListasTmkArticulos;
import com.tmk.bus.listas.ListasTmkCalificaciones;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.ListasTmkServices;

public class ListasTmkServiceImpl implements  ListasTmkServices {

	//GenericService
	public ListasTmk findByPk(Object idLista) throws DBOInexistenteException,Exception {		
		try {
			return (ListasTmk)DAOFactory.getListasTmkDAO().findByPk(idLista);
		}catch(DBOInexistenteException die) {
			TmkLogger.info(" No existe el DBO pk = " + idLista);
			throw die;
		}catch(Exception e) {
			TmkLogger.info(" Error (Exception) buscando lista pk = " + idLista + e);
			throw e;	
		}
	}
	//ListasTmkServices
	public Collection<?> findBySocio(Object socioPK) throws DBOInexistenteException, Exception {
		return DAOFactory.getListasTmkDAO().findBySocio(socioPK,false);
	}
	public Collection<?> findBySocio(Object socioPK,boolean socioTMK) throws DBOInexistenteException, Exception {
		return DAOFactory.getListasTmkDAO().findBySocio(socioPK,socioTMK);
	}
	public ListasTmk findByPk(Object idLista,boolean esSocioTMK) throws DBOInexistenteException,Exception {		
		try {
			return (ListasTmk)DAOFactory.getListasTmkDAO().findByPk(idLista,esSocioTMK);
		}catch(DBOInexistenteException die) {
			TmkLogger.info(" No existe el DBO pk = " + idLista);
			throw die;
		}catch(Exception e) {
			TmkLogger.info(" Error (Exception) buscando lista pk = " + idLista + e);
			throw e;	
		}
	}

	//ABMService
	public void delete(Object obj) throws Exception {
		ListasTmk lista = (ListasTmk)obj;
		try {
			DAOFactory.getDboDAO().delete(lista);
		}catch(Exception e) {
			TmkLogger.error("No se pudo eliminar la lista pk = " + ((ListasTmk)obj).getPK() + e);
			throw e;
		}		
	}

	public void insert(Object obj) throws Exception {
		try {
			DAOFactory.getListasTmkDAO().insert(obj);
		}catch (DuplicateException de) {
			TmkLogger.info(" Lista  duplicada pk = "+ ((ListasTmk)obj).getId_lista());
			throw de;
		}catch(Exception e) {
			TmkLogger.info(" Error insertando lista pk = " + ((ListasTmk)obj).getPK() + e);
			throw e;
		}		
	}

	public void update(Object obj) throws Exception {
		try {
			DAOFactory.getListasTmkDAO().update(obj);
		}catch(DBOInexistenteException die) {
			TmkLogger.error(" No existe la lista pk = " + ((ListasTmk)obj).getPK());
			throw die;
		}catch(Exception e) {
			TmkLogger.error(" Error buscando la lista pk = " + ((ListasTmk)obj).getPK());
			throw e;
		}
	}
	
	public void grabarArticulosEnLista(Integer pkLista,ListasTmkArticulos[] articulos) throws Exception{
		if(articulos !=null ){
			for(int i=0;i<articulos.length;i++) {
				try {
					DAOFactory.getDboDAO().insert(articulos[i]);
				} catch (DuplicateException e) {
					TmkLogger.error(" Articulo duplicado :No se puedo grabar el articulo id_articulo = " + articulos[i].getId_articulo() + " en la lista id_lista = "+ pkLista + e);
					throw e;
				} catch (Exception e) {
					TmkLogger.error(" No se puedo grabar el articulo id_articulo = " + articulos[i].getId_articulo() + " en la lista id_lista = "+ pkLista + e);
					throw e;
				}
			}
		}else {
			throw new Exception(" Intentando grabar lista de articulos en la lista "+ pkLista + "pero  La lista de articulos esta vacia");
		}
		
	}
	
	public void grabarArticulosEnLista(Integer pkLista,ListasTmkArticulos articulo) throws Exception{
		if(articulo != null ){
			try {
				articulo.setF_agregado(new Timestamp(System.currentTimeMillis()));
				DAOFactory.getDboDAO().insert(articulo);
			} catch (DuplicateException e) {
				TmkLogger.error(" Articulo duplicado :No se puedo grabar el articulo id_articulo = " + articulo.getId_articulo() + " en la lista id_lista = "+ pkLista + e);
				throw e;
			} catch (Exception e) {
				TmkLogger.error(" No se puedo grabar el articulo id_articulo = " + articulo.getId_articulo() + " en la lista id_lista = "+ pkLista + e);
				throw e;
			}
		}else {
			throw new Exception(" Intentando grabar lista de articulos en la lista "+ pkLista + "pero  La lista de articulos esta vacia");
		}
		
	}
	
	public void borrarArticuloEnLista(Integer pkLista,Integer idArticulo) throws Exception{
		ListasTmkArticulos articulo = new ListasTmkArticulos(pkLista);
		articulo.setId_articulo(idArticulo);
		try {
			DAOFactory.getDboDAO().delete(articulo);
		}catch (DBOInexistenteException die) {
			TmkLogger.error("No existe el articulo id_articulo = "+ idArticulo + "En la lista id_lista = " + pkLista);
			throw die;
		}
	}
	/**
	 * Determina cual es la calificacion que le corresponde a la lista, en base a todas las calificacione que tiene de los usuarios 
	 */
	public double getCalificacionDeLista(ListasTmkCalificaciones[] listaCalificaciones) {
		
		if(listaCalificaciones == null) {
			return 0;
		}
		
		int canTotal = 0;
		int i;
		for(i = 0;i <  listaCalificaciones.length; i++ ) {
			canTotal += listaCalificaciones[i].getCalificacion().intValue();
		}
		return (double)canTotal / i;
	}
	
}
