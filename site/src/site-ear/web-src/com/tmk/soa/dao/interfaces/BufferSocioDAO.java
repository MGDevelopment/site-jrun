package com.tmk.soa.dao.interfaces;

import com.tmk.bus.socio.BufferSocios;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.src.socio.BufferSocioPK;

public interface BufferSocioDAO {

		/**
		 * 
		 * @param id_sucursal
		 * @param id_socio
		 * @param id_caal
		 * @param id_tipo_contribuyente
		 * @param tipo_persona
		 * @param login
		 * @param nombres
		 * @param apellidos
		 * @param password
		 * @param tipo_doc
		 * @param nro_doc
		 * @param nacionalidad
		 * @param fecha_nacimiento
		 * @param sexo
		 * @param estado_civil
		 * @param hijos
		 * @param id_profesion
		 * @param procesado
		 * @param e_mail1
		 * @param info_extra
		 * @param info_terceros
		 * @param internet_casa
		 * @param pc_casa
		 * @param procesado_ecl
		 * @param auxflag2
		 * @throws DuplicateException
		 * @throws Exception
		 */
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
		/**
		 * 
		 * @param BufferSocioPK
		 * @return BufferSocios 
		 * @throws DBOInexistenteException
		 * @throws Exception
		 */
		public BufferSocios findByPrimaryKey(BufferSocioPK pk) throws DBOInexistenteException,Exception;
		
}
