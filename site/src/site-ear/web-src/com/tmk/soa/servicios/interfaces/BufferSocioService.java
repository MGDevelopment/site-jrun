package com.tmk.soa.servicios.interfaces;

import com.tmk.bus.socio.BufferSocios;
//import com.tmk.dbo.DBO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.BufferSocioPK;

public interface BufferSocioService {

		//public void update(DBO bufferSocio) throws DBOInexistenteException,Exception;
	
		public void create(
		        Integer id_sucursal,
		        Integer id_socio,
		        Integer id_caal,
		        Integer id_tipo_contribuyente,
		        String tipo_persona,
		        byte[] login,
		        String nombres,
		        String apellidos,
		        byte[] password,
		        String tipo_doc,
		        long nro_doc,
		        Integer nacionalidad,
		        java.sql.Timestamp fecha_nacimiento,
		        String sexo,
		        String estado_civil,
		        Integer hijos,
		        Integer id_profesion,
		        String procesado,
		        String e_mail1,
		        String info_extra,
		        String info_terceros,
		        String internet_casa,
		        String pc_casa,
		        String procesado_ecl,
		        String auxflag2
		        ) throws DuplicateException,Exception;

		public BufferSocios findByPrimaryKey(BufferSocioPK pk) throws DBOInexistenteException,Exception;
		
}
