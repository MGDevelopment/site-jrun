package com.tmk.soa.servicios.implementation;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.TreeSet;
import com.tmk.bus.orden.CarritoCompra;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.CarritoCompraService;
import com.tmk.src.socio.CarritoCompraPK;

public class CarritoCompraServiceImpl implements CarritoCompraService {

	public CarritoCompra create(Integer ID_SUCURSAL_SOCIO,
			Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, Date FECHA)
			 throws DuplicateException,AplicationException{
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findAll() throws DBOInexistenteException,AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public CarritoCompra findByPrimaryKey(CarritoCompraPK pk) throws DBOInexistenteException, AplicationException {			 
		try {
			return DAOFactory.getCarritoCompraDAO().findByPrimaryKey(pk);
		}catch (DBOInexistenteException se) {
			TmkLogger.error(se.getMessage());
			throw se;
		}catch (Exception  e) {
			TmkLogger.error(e.getMessage());
			throw new AplicationException(e);
		}
	}

	public Collection findByUser(Integer idSucursalSocio, Integer idSocio) throws AplicationException{
		try {
			return DAOFactory.getCarritoCompraDAO().findByUser(idSucursalSocio, idSocio);
		}catch (DBOInexistenteException ae) {
			return new TreeSet();
		}catch (Exception ae) {
			TmkLogger.debug(ae.getMessage());
			throw new AplicationException(ae);
		}
	}

}
