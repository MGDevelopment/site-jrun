package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import java.util.Collection;

public interface OrdenLocalHome extends EJBLocalHome {

	public OrdenLocal create(Integer ID_ORDEN, java.sql.Timestamp FECHA, Double NETO, String ESTADO, Integer ID_SUCURSAL_SOCIO,
	                         Integer ID_SOCIO, Double TOTAL, String TELEFONO, String HR_CONTACTO, String COMENTARIOS, Integer NIVEL_RIESGO,
	                         String MOTIVO_RIESGO, Integer ID_ALIANZA, Integer ID_SECCION, Integer ID_DOMINIO, Integer ID_ORDEN_MOTIVO_RIESGO,
	                         String NOMBRES_RECEPTOR, String APELLIDOS_RECEPTOR, String CUPON, String CPF_CNPJ,
	                         Integer NRO_DOC_RECEPTOR, String TIPO_DOC_RECEPTOR,
	                         String RANGO_HORARIO_RECEPTOR,  java.sql.Timestamp FAC_ELC_ENV) throws CreateException;

	public OrdenLocal findByPrimaryKey(Integer pk) throws FinderException;

	public Collection findAll() throws FinderException;

	public Collection findOrdenesEnProceso(java.lang.Integer param1, java.lang.Integer param2) throws FinderException;

	public Collection findOrdenesProcesadas(java.lang.Integer param1, java.lang.Integer param2) throws FinderException;

	public Collection findOrdenesEnEstado(Integer desdeOrden, String estado, Integer cantidad, String medioDeCobro) throws FinderException;

	public Collection findOrdenesDelDia() throws FinderException;

	public Collection findOrdenesParecidas() throws FinderException;

	public Collection findOrdenesFraudulentas() throws FinderException;

	public Collection findOrdenesRelacionadas(Integer idOrden) throws FinderException;

	public Collection findOrdenesPorSocio(Integer idSucursal, Integer idSocio) throws FinderException;

	public Collection findUltimasOrdenes() throws FinderException;

	public Collection findOrdenesRetrasadas() throws FinderException;

	public Collection findOrdenesEnEstadoParaEfectivo(Integer desdeOrden, String estado, Integer cantidad, String medioDeCobro) throws FinderException;
}
