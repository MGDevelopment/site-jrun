package com.tmk.soa.servicios.implementation;

import java.sql.Timestamp;

import com.tmk.bus.socio.BufferSocios;
//import com.tmk.dbo.DBO;
import com.tmk.soa.dao.DAOFactory;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.BufferSocioService;
import com.tmk.src.socio.BufferSocioPK;

public class BufferSocioServiceImpl implements BufferSocioService {

	public void create(Integer id_sucursal, Integer id_socio,
			Integer id_caal, Integer id_tipo_contribuyente,
			String tipo_persona, byte[] login, String nombres,
			String apellidos, byte[] password, String tipo_doc, long nro_doc,
			Integer nacionalidad, Timestamp fecha_nacimiento, String sexo,
			String estado_civil, Integer hijos, Integer id_profesion,
			String procesado, String e_mail1, String info_extra,
			String info_terceros, String internet_casa, String pc_casa,
			String procesado_ecl, String auxflag2) throws DuplicateException,Exception {
				
	
			DAOFactory.getBufferSocioDAO().create(id_sucursal, id_socio, id_caal, id_tipo_contribuyente, tipo_persona, login, nombres, apellidos, password, tipo_doc, nro_doc, nacionalidad, fecha_nacimiento, sexo, estado_civil, hijos, id_profesion, procesado, e_mail1, info_extra, info_terceros, internet_casa, pc_casa, procesado_ecl, auxflag2);
	
	}

	public BufferSocios findByPrimaryKey(BufferSocioPK pk)
			throws DBOInexistenteException,Exception {
		
		return DAOFactory.getBufferSocioDAO().findByPrimaryKey(pk);
		
	}
	/*public void update(DBO bufferSocio) throws DBOInexistenteException,
			Exception {
		DAOFactory.getDboDAO().update(bufferSocio);
	}*/
}
