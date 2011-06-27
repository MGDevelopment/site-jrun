/**
 * 
 */
package com.tmk.soa.servicios.interfaces;

import java.util.Collection;
import com.tmk.bus.orden.Orden;
import com.tmk.soa.exceptions.AplicationException;

/**
 * @author oclopez Reemplaza a OrdenLocalHome.java
 */
public interface OrdenService {

	public Orden grabarOrden(Orden orden)throws AplicationException;

	//public OrdenLocal findByPrimaryKey(Integer pk) throws AplicationException;
	public Orden findByPrimaryKey(Integer pk);

	public Collection findAll() throws AplicationException;

	public Collection findOrdenesEnProceso(Integer param1, Integer param2)
			throws AplicationException;

	public Collection findOrdenesProcesadas(Integer param1, Integer param2)
			throws AplicationException;

	public Collection findOrdenesEnEstado(Integer desdeOrden, String estado,
			Integer cantidad, String medioDeCobro) throws AplicationException;

	public Collection findOrdenesDelDia() throws AplicationException;

	public Collection findOrdenesParecidas() throws AplicationException;

	public Collection findOrdenesFraudulentas() throws AplicationException;

	public Collection findOrdenesRelacionadas(Integer idOrden)
			throws AplicationException;

	public Collection findOrdenesPorSocio(Integer idSucursal, Integer idSocio)
			throws AplicationException;

	public Collection findUltimasOrdenes() throws AplicationException;

	public Collection findOrdenesRetrasadas() throws AplicationException;

	public Collection findOrdenesEnEstadoParaEfectivo(Integer desdeOrden,
			String estado, Integer cantidad, String medioDeCobro)
			throws AplicationException;
}
