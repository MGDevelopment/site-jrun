package com.tmk.soa.dao.interfaces;

import java.sql.Timestamp;
import java.util.Collection;
import com.tmk.bus.orden.CarritoCompra;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.CarritoCompraPK;

public interface CarritoCompraDAO {

	public CarritoCompra create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
			Integer ID_ARTICULO, Integer CANTIDAD, Timestamp fecha)
			throws DuplicateException, Exception;

	public CarritoCompra findByPrimaryKey(CarritoCompraPK pk)
			throws DBOInexistenteException, Exception;

	public Collection findAll() throws DBOInexistenteException, Exception;

	public Collection findByUser(Integer idSucursalSocio, Integer idSocio)
			throws DBOInexistenteException, Exception;
}
