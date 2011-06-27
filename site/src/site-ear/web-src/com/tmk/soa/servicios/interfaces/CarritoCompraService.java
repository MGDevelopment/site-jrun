package com.tmk.soa.servicios.interfaces;

import com.tmk.bus.orden.CarritoCompra;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.CarritoCompraPK;
import java.util.Collection;
import java.util.Date;

public interface CarritoCompraService {

	public CarritoCompra create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
			Integer ID_ARTICULO, Integer CANTIDAD, Date FECHA)
			throws DuplicateException, AplicationException;

	public CarritoCompra findByPrimaryKey(CarritoCompraPK pk)
			throws DBOInexistenteException,AplicationException;

	public Collection findAll() throws DBOInexistenteException,AplicationException;

	public Collection findByUser(Integer idSucursalSocio, Integer idSocio)
			throws  DBOInexistenteException, AplicationException;

}
