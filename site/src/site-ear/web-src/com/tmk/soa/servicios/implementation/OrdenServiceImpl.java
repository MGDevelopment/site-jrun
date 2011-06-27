package com.tmk.soa.servicios.implementation;

import java.util.Collection;

import com.tmk.bus.orden.Orden;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.servicios.interfaces.OrdenService;

public class OrdenServiceImpl implements OrdenService {

	public Collection findAll() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Orden findByPrimaryKey(Integer pk) {
		try {
			Orden orden =  DAOFactory.getOrdenDAO().findByPrimaryKey(pk);			
			orden.asignarPapelesDeRegalo();
			orden.asignarGastosDeEnvio();
			return orden;
		} catch (AplicationException ae) {
			TmkLogger.info("DBO no encontrado-->OrdenServiceImpl-->findByPrimaryKey-->pk="+pk.toString());
			return null;
		}
	}

	public Collection findOrdenesDelDia() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnEstado(Integer desdeOrden, String estado,
			Integer cantidad, String medioDeCobro) throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnEstadoParaEfectivo(Integer desdeOrden,
			String estado, Integer cantidad, String medioDeCobro)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesEnProceso(Integer param1, Integer param2)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesFraudulentas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesParecidas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesPorSocio(Integer idSucursal, Integer idSocio)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesProcesadas(Integer param1, Integer param2)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesRelacionadas(Integer idOrden)
			throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findOrdenesRetrasadas() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	public Collection findUltimasOrdenes() throws AplicationException {
		// TODO Auto-generated method stub
		return null;
	}

	/*public Orden create(Integer IdOrden, Timestamp fecha, Double neto,
			String estado, Integer idSucursalSocio, Integer idSocio,
			Double total, String telefono, String hrContacto,
			String comentatios, Integer nivelRiesgo, String motivoRiego,
			Integer idAlianza, Integer idSeccion, Integer idDominio,
			Integer idOrdenMotivoRiesgo, String nombresReceptor,
			String apellidosReceptor, String cupon, String cpfCnpj,
			Integer nroDocReceptor, String tipoDocReceptor,
			String rangoHorarioReceptor, Timestamp facElcEnv)
			throws AplicationException {*/
	public Orden grabarOrden(Orden orden){
		try {
			DAOFactory.getOrdenDAO().create(orden);
			return orden;
		}catch(AplicationException ae) {
			TmkLogger.error(ae);
			return null;
		}		
	}

}
