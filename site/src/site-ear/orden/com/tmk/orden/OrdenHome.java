package com.tmk.orden;

import javax.ejb.CreateException;
import javax.ejb.EJBHome;
import javax.ejb.FinderException;
import java.rmi.RemoteException;
import java.util.Collection;

public interface OrdenHome extends EJBHome {

	public Orden create(Integer ID_ORDEN, java.sql.Timestamp FECHA, Double NETO, String ESTADO, Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO,
	                    Double TOTAL, String TELEFONO, String HR_CONTACTO, String COMENTARIOS, Integer NIVEL_RIESGO, String MOTIVO_RIESGO,
	                    Integer ID_ALIANZA, Integer ID_SECCION, Integer ID_DOMINIO, Integer ID_ORDEN_MOTIVO_RIESGO, String NOMBRES_RECEPTOR,
	                    String APELLIDOS_RECEPTOR, String CUPON, String CPF_CNPJ,
	                    Integer NRO_DOC_RECEPTOR, String TIPO_DOC_RECEPTOR,
	                    String RANGO_HORARIO_RECEPTOR, java.sql.Timestamp FAC_ELC_ENV) throws RemoteException, CreateException;

	public Orden findByPrimaryKey(Integer pk) throws RemoteException, FinderException;

	public Collection findAll() throws RemoteException, FinderException;

	public Collection findOrdenesEnProceso(java.lang.Integer param1, java.lang.Integer param2) throws RemoteException, FinderException;

	public Collection findOrdenesProcesadas(java.lang.Integer param1, java.lang.Integer param2) throws RemoteException, FinderException;

	public Collection findOrdenesEnEstado(Integer desdeOrden, String estado, Integer cantidad, String medioDeCobro) throws RemoteException, FinderException;

	public Collection findOrdenesDelDia() throws RemoteException, FinderException;

	public Collection findOrdenesParecidas() throws RemoteException, FinderException;

	public Collection findOrdenesFraudulentas() throws RemoteException, FinderException;

	public Collection findOrdenesRelacionadas(Integer idOrden) throws RemoteException, FinderException;

	public Collection findOrdenesPorSocio(Integer idSucursal, Integer idSocio) throws RemoteException, FinderException;

	public Collection findUltimasOrdenes() throws RemoteException, FinderException;

	public Collection findOrdenesRetrasadas() throws RemoteException, FinderException;

	public Collection findOrdenesEnEstadoParaEfectivo(Integer desdeOrden, String estado, Integer cantidad, String medioDeCobro) throws RemoteException, FinderException;

}
