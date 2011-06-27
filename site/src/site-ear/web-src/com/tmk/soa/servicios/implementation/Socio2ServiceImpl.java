package com.tmk.soa.servicios.implementation;

//import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.bus.socio.SociosIntegracion;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;
//import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.Socio2Service;
import com.tmk.src.socio.SocioPK;
//import com.tmk.bus.socio.Provincia;
//import com.tmk.bus.socio.Localidad;
import java.sql.Timestamp;
import java.util.Collection;
//import java.util.Iterator;
import java.util.TreeSet;

public class Socio2ServiceImpl implements Socio2Service {

	public void update(DBO dbo) throws DBOInexistenteException, Exception {
		DAOFactory.getDboDAO().update(dbo);
	}
	
	public String getLogin(SocioPK pk) {		
		return DAOFactory.getSocios2DAO().getLogin(pk);
	}

	public Socios2 findByPK(SocioPK pk){
		try{
			return DAOFactory.getSocios2DAO().findByPK(pk);
		}catch (AplicationException ae) {
			StringBuffer msj = new StringBuffer("Socio2ServiceImpl->findByPK->El socio (");
			msj.append("id_socio = ").append(pk.ID_SOCIO);
			msj.append("id_sucursal = ").append(pk.ID_SUCURSAL);
			msj.append(")");
			msj.append("No existe en la tabla ");
			msj.append(Socios2.getTabla());
			TmkLogger.debug(msj.toString());
			return null;
		}
	}
	
	/*public Collection getDomiciliosByPkSocio(SocioPK socioPk) {
		try{
			return DAOFactory.getSocios2DAO().getDomiciliosByPkSocio(socioPk);
		}catch (AplicationException ae) {
			TmkLogger.info("No tiene domicilio es socio = "+socioPk.ID_SOCIO +"-"+socioPk.ID_SUCURSAL);
			return new TreeSet();
		}
	}*/

	/*public String getDireccionFormateada(SocioDomicilios domicilio) {
		StringBuffer direccion = new StringBuffer();
		if(domicilio.getCalle()!=null){
			direccion.append(domicilio.getCalle()).append(" ");			
		}
		if(domicilio.getNumero()!=null){
			direccion.append(domicilio.getNumero()).append(" ");
		}		
		if(domicilio.getEdificio()!=null){
			direccion.append(domicilio.getEdificio()).append(" ");
		}
		if(domicilio.getPiso()!=null){
			direccion.append(domicilio.getPiso()).append(" ");
		}			
		return direccion.toString();
	}*/
	/*
	public Collection findByTipoEnvio(SocioPK socioPk) {		
		try {
			Collection c = DAOFactory.getSocios2DAO().findByTipoEnvio(socioPk);
			//me aseguro de mantener la misma funcionalidad que PaisDAO y ProvinciaDAO, cuando 
			//no hay localidad o provincia muestro Otra localidad u Otra provincia
			Iterator it = c.iterator();
			while(it.hasNext()) {
				SocioDomicilios s = (SocioDomicilios)it.next();
				if(s.getProvincia() == null) {
					Provincia p = new Provincia();
					p.setDescripcion("Otra Provincia");
					p.setId_provincia(Globals.CODIGO_OTRA_PROVINCIA);
					p.setId_pais(s.getPais().getIdPais());
					s.setProvincia(p);
					if(s.getLocalidad() == null) {
						Localidad l = new Localidad();
						l.setDescripcion("Otra Localidad");
						l.setId_localidad(Globals.CODIGO_OTRA_LOCALIDAD);
						l.setId_pais(s.getPais().getIdPais());
						l.setId_provincia(p.getIdPais());
						s.setLocalidad(l);
					}
				}else {
					if(s.getLocalidad() == null) {
						Localidad l = new Localidad();
						l.setDescripcion("Otra Localidad");
						l.setId_localidad(Globals.CODIGO_OTRA_LOCALIDAD);
						l.setId_pais(s.getPais().getIdPais());
						l.setId_provincia(Globals.CODIGO_OTRA_PROVINCIA);
						s.setLocalidad(l);
					}
				}
			}
			return c;
			
		} catch (AplicationException e) {			
			TmkLogger.error("Error buscando domicilio de envio de socio id_socio = " +socioPk.ID_SOCIO +" id_sucursal = "+socioPk.ID_SUCURSAL);
			return null;
		}
	}
	
	public Collection findByTipoFacturacion(SocioPK socioPk) {
		try {
			Collection c  = DAOFactory.getSocios2DAO().findByTipoFacturacion(socioPk);
			
			Iterator it = c.iterator();
			while(it.hasNext()) {
				SocioDomicilios s = (SocioDomicilios)it.next();
				if(s.getProvincia() == null) {
					Provincia p = new Provincia();
					p.setDescripcion("Otra Provincia");
					p.setId_provincia(Globals.CODIGO_OTRA_PROVINCIA);
					p.setId_pais(s.getPais().getIdPais());
					s.setProvincia(p);
					if(s.getLocalidad() == null) {
						Localidad l = new Localidad();
						l.setDescripcion("Otra Localidad");												
						l.setId_pais(s.getPais().getIdPais());
						l.setId_provincia(p.getId_provincia());
						l.setId_localidad(Globals.CODIGO_OTRA_LOCALIDAD);
						s.setLocalidad(l);
					}
				}else {
					if(s.getLocalidad() == null) {
						Localidad l = new Localidad();
						l.setDescripcion("Otra Localidad");
						l.setId_localidad(Globals.CODIGO_OTRA_LOCALIDAD);
						l.setId_pais(s.getPais().getIdPais());
						l.setId_provincia(Globals.CODIGO_OTRA_PROVINCIA);
						s.setLocalidad(l);
					}
				}
			}
			return c;
			
		} catch (AplicationException e) {			
			TmkLogger.error("Error buscando domicilio de facturacion de socio id_socio = " +socioPk.ID_SOCIO +"id_sucursal = "+socioPk.ID_SUCURSAL);
			//retorno un en tree set para que se pueda hacer un Iterator directamente donde se lo reciba
			return null;
		}	
	}
	
	public SocioDomicilios getByPKYTipoDomicilio(SocioPK socioPk,String tipoDomicilio) {
		try {
			return DAOFactory.getSocios2DAO().findByPKYTipoDomicilio(socioPk,tipoDomicilio);
		} catch (AplicationException e) {			
			StringBuffer msj = new StringBuffer("El socio (");
			msj.append("id_socio = ").append(socioPk.ID_SOCIO);
			msj.append("id_sucursal = ").append(socioPk.ID_SUCURSAL);
			msj.append(")");
			msj.append("no tiene domicilios cargados");
			TmkLogger.debug(msj.toString());
			//retorno un en tree set para que se pueda hacer un Iterator directamente donde se lo reciba
			return null;
		}
	}*/

	/**
	 * Reemplaza el metodo de ShortsCut.java
	 */
	public Socios2 findSocioByLoginPassword(String LOGIN, String PASSWORD) {
		try{
			return DAOFactory.getSocios2DAO().findSocioByLoginPassword(LOGIN,PASSWORD);
		}catch (AplicationException ae) {
			TmkLogger.debug(ae.getMessage());
			return null;
		}			
	}

	public Socios2 findSocioByLogin(String LOGIN) {
		try {
			return DAOFactory.getSocios2DAO().findSocioByLogin(LOGIN);
		} catch(AplicationException ae) {
			TmkLogger.debug(ae.getMessage());			
			return null;
		}
	}

	/**para mantener compatibilidad con el ejb*/
	public Socios2 findByPrimaryKey(SocioPK pk) throws DBOInexistenteException,Exception{
		
		return DAOFactory.getSocios2DAO().findByPrimaryKey(pk);		
	}
	
	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD)  {
		try {
			return DAOFactory.getSocios2DAO().findRepetidosAUnificar(SEXO, TIPO_DOC, NRO_DOC, NACIONALIDAD);
		}catch (AplicationException e) {
			StringBuffer msj = new StringBuffer(this.getClass().getName());			
			msj.append(SEXO).append("-");
			msj.append(TIPO_DOC).append("-");
			msj.append(NRO_DOC).append("-");
			msj.append(NACIONALIDAD).append("-");
			TmkLogger.error(msj.toString());
			return new TreeSet();
		}
	}

	public Collection findRepetidosDelSitio(String SEXO, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD) {
		try {
			return DAOFactory.getSocios2DAO().findRepetidosDelSitio(SEXO, TIPO_DOC, NRO_DOC, NACIONALIDAD);
		}catch (AplicationException e) {
			StringBuffer msj = new StringBuffer(this.getClass().getName());			
			msj.append(SEXO).append("-");
			msj.append(TIPO_DOC).append("-");
			msj.append(NRO_DOC).append("-");
			msj.append(NACIONALIDAD).append("-");		
			TmkLogger.error(msj.toString());
			return new TreeSet();
		}
	}

	public void create(Integer ID_SUCURSAL, Integer ID_SOCIO, Integer ID_CAAL,
			Integer ID_TIPO_CONTRIBUYENTE, String TIPO_PERSONA, byte[] LOGIN,
			String NOMBRES, String APELLIDOS, byte[] PASSWORD, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD, Timestamp FECHA_NACIMIENTO,
			String SEXO, String ESTADO_CIVIL, Integer HIJOS,
			Integer ID_PROFESION, String E_MAIL1, String INFO_EXTRA,
			String INFO_TERCEROS, String INTERNET_CASA, String PC_CASA,
			String AUXFLAG2) throws DuplicateException, Exception {
		
		DAOFactory.getSocios2DAO().create(ID_SUCURSAL, ID_SOCIO, ID_CAAL, ID_TIPO_CONTRIBUYENTE, TIPO_PERSONA, LOGIN, NOMBRES, APELLIDOS, PASSWORD, TIPO_DOC, NRO_DOC, NACIONALIDAD, FECHA_NACIMIENTO, SEXO, ESTADO_CIVIL, HIJOS, ID_PROFESION, E_MAIL1, INFO_EXTRA, INFO_TERCEROS, INTERNET_CASA, PC_CASA, AUXFLAG2);
		
	}
		
	public SociosIntegracion getSocioIntegracion(SocioPK socioPK, String dominio) {
		try {		
			return DAOFactory.getSocios2DAO().findSocioIntegracion(socioPK, dominio);
		}catch (Exception e) {
			TmkLogger.debug(e);
			return null;
		}
	}
}
