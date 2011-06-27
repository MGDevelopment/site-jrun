package com.tmk.soa.dao.interfaces;

import java.util.Collection;

import com.tmk.bus.orden.Orden;
import com.tmk.soa.exceptions.AplicationException;

public interface OrdenDAO {

	/*
	 * public OrdenLocal create(Integer ID_ORDEN, Timestamp FECHA, Double NETO,
	 * String ESTADO, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO, Double TOTAL,
	 * String TELEFONO, String HR_CONTACTO, String COMENTARIOS, Integer
	 * NIVEL_RIESGO, String MOTIVO_RIESGO, Integer ID_ALIANZA, Integer
	 * ID_SECCION, Integer ID_DOMINIO, Integer ID_ORDEN_MOTIVO_RIESGO, String
	 * NOMBRES_RECEPTOR, String APELLIDOS_RECEPTOR, String CUPON, String
	 * CPF_CNPJ, Integer NRO_DOC_RECEPTOR, String TIPO_DOC_RECEPTOR, String
	 * RANGO_HORARIO_RECEPTOR, Timestamp FAC_ELC_ENV) throws
	 * AplicationException;
	 */

	public void create(Orden orden) throws AplicationException;
	
	// public OrdenLocal findByPrimaryKey(Integer pk) throws
	// AplicationException;
	public Orden findByPrimaryKey(Integer pk) throws AplicationException;

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
