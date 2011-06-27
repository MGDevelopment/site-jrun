package com.tmk.soa.servicios.interfaces;

import java.util.Collection;
import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;

public interface CarritoListaDeseosService {
	public CarritoListaDeseos create(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Integer ID_ARTICULO, Integer ID_SUCURSAL_SOCIO_COMPRADOR, Integer ID_SOCIO_COMPRADOR, Integer ESTADO) throws DuplicateException,Exception;

	public CarritoListaDeseos findByPrimaryKey(CarritoListaDeseosPK carritoPK)throws  DBOInexistenteException,Exception;

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO)throws DBOInexistenteException,Exception;
	
	/** permite hacer update analogo al dbo pero ecanapsulando el hecho de crear 
	  * la conexion y demas.
	  */
	public boolean update(CarritoListaDeseos carrito);
	
	/** permite hacer delete analogo al dbo pero ecanapsulando el hecho de crear 
	  * la conexion y demas.
	  */
	//public boolean delete(CarritoListaDeseos carrito);
}
