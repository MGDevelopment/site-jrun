package com.tmk.soa.servicios.implementation;

import java.sql.Connection;
import java.util.Collection;
import java.util.TreeSet;

import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import com.tmk.soa.dao.DAOFactory;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.soa.servicios.interfaces.CarritoListaDeseosService;

public class CarritoListaDeseosServiceImpl implements CarritoListaDeseosService {

	public CarritoListaDeseos findByPrimaryKey(CarritoListaDeseosPK carritoPK) throws DBOInexistenteException,Exception{	
		return DAOFactory.getCarritoListaDeseosDAO().findByPrimaryKey(carritoPK);		
	}

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO) throws DBOInexistenteException,Exception{
		try{
			return DAOFactory.getCarritoListaDeseosDAO().findBySocio(ID_SUCURSAL_SOCIO,ID_SOCIO) ;
		}catch (DBOInexistenteException di) {
			StringBuffer msj = new StringBuffer("");
			msj.append("No existe carrito_lista_deseo para el socio pk=").append(ID_SOCIO).append("=").append(ID_SUCURSAL_SOCIO);
			TmkLogger.debug(msj.toString());
			return new TreeSet();
		}catch (Exception ae) {
			return new TreeSet();
		}
	}

	public boolean update(CarritoListaDeseos carrito) {
		boolean inserto  = false;
		try {
			Connection con = ConnectionProvider.getConection();
			con.setAutoCommit(false);
			try {				
				carrito.update(con);
				con.commit();
				inserto =  true;
			}catch(Exception e) {			
				con.rollback();
				throw e;
			}
			finally {
				con.close();
			}
		}catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
		} 		
		return inserto;
	}
	
	/*public boolean delete(CarritoListaDeseos carritoListaDeseo) {
		boolean borro  = false;
		try{
			borro = DAOFactory.getCarritoListaDeseosDAO().delete(carritoListaDeseo);
		}catch (AplicationException ae) {
			TmkLogger.error(ae.getMessage());
		}
		return borro;
		
		/*try {
			Connection con = ConnectionProvider.getConection();
			con.setAutoCommit(false);
			try {				
				carrito.delete(con);
				con.commit();
				TmkLogger.debug("commit de  CarritoListaDeses con pk= " + carrito.getPK());
				borro =  true;
			}catch(Exception e) {			
				con.rollback();
				TmkLogger.error("En el delete de CarritoListaDeses con pk= " + carrito.getPK()+ "ha hecho rollbak");
				throw e;
			}
			finally {
				con.close();
			}
		}catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
		} 		
		return borro;*/
	//}
	public CarritoListaDeseos create(Integer ID_SUCURSAL_SOCIO,
			Integer ID_SOCIO, Integer ID_ARTICULO,
			Integer ID_SUCURSAL_SOCIO_COMPRADOR, Integer ID_SOCIO_COMPRADOR,
			Integer ESTADO)throws  DuplicateException,Exception{
			
		
		return DAOFactory.getCarritoListaDeseosDAO().create(ID_SUCURSAL_SOCIO, ID_SOCIO, ID_ARTICULO, ID_SUCURSAL_SOCIO_COMPRADOR, ID_SOCIO_COMPRADOR, ESTADO);					
	}
}
