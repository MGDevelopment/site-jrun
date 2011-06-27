package com.tmk.soa.dao.interfaces;

import java.util.Collection;
import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

public interface CarritoListaDeseosDAO {

	public CarritoListaDeseos create(Integer ID_SUCURSAL_SOCIO,
			Integer ID_SOCIO, Integer ID_ARTICULO,
			Integer ID_SUCURSAL_SOCIO_COMPRADOR, Integer ID_SOCIO_COMPRADOR,
			Integer ESTADO) throws DuplicateException,Exception;

	public CarritoListaDeseos findByPrimaryKey(CarritoListaDeseosPK carritoPK)
			throws DBOInexistenteException,Exception;

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO)
			throws DBOInexistenteException,Exception;
	
	//public boolean delete(CarritoListaDeseos carritoListaDeseo) throws DBOInexistenteException,Exception;
}
