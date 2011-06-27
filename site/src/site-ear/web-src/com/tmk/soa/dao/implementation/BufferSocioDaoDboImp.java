package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.Timestamp;
import com.tmk.bus.socio.BufferSocios;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.dao.interfaces.BufferSocioDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.src.socio.BufferSocioPK;

public class BufferSocioDaoDboImp implements BufferSocioDAO {

	public void create(Integer id_sucursal, Integer id_socio,
			Integer id_caal, Integer id_tipo_contribuyente,
			String tipo_persona, byte[] login, String nombres,
			String apellidos, byte[] password, String tipo_doc, long nro_doc,
			Integer nacionalidad, Timestamp fecha_nacimiento, String sexo,
			String estado_civil, Integer hijos, Integer id_profesion,
			String procesado, String e_mail1, String info_extra,
			String info_terceros, String internet_casa, String pc_casa,
			String procesado_ecl, String auxflag2) throws DuplicateException,Exception{
		
		BufferSocios socio = new BufferSocios(id_sucursal,id_socio);
		socio.setId_caal(id_caal);
		socio.setApellidos(apellidos);
		socio.setNombres(nombres);
		socio.setAuxflag2(auxflag2);
		socio.setE_mail1(e_mail1);
		socio.setEstado_civil(estado_civil);
		socio.setProcesado("N");
		socio.setProcesado_ecl(procesado_ecl);
		socio.setFecha_nacimiento(fecha_nacimiento);
		socio.setHijos(hijos);		
		socio.setId_profesion(id_profesion);
		socio.setId_tipo_contribuyente(id_tipo_contribuyente);
		socio.setTipo_persona(tipo_persona);
		socio.setInfo_extra(info_extra);
		socio.setInfo_terceros(info_terceros);
		socio.setInternet_casa(internet_casa);
		socio.setLogin(login);
		socio.setNacionalidad(nacionalidad);
		socio.setNro_doc(nro_doc);
		socio.setTipo_doc(tipo_doc);
		socio.setSexo(sexo);
		socio.setPassword(password);
		
		DAOFactory.getDboDAO().insert(socio);
	}

	public BufferSocios findByPrimaryKey(BufferSocioPK pk)
			throws DBOInexistenteException, Exception {
		BufferSocios socio = null;
		try{
			Connection conn = ConnectionProvider.getConection();
			try {
				socio = new BufferSocios(pk);
				socio.select(conn);	
			}finally {
				conn.close();
			}		
		}catch (DBOInexistenteException de) {
			throw de;
		}catch (Exception e) {
			throw e;
		}
		return socio;
	}

}
