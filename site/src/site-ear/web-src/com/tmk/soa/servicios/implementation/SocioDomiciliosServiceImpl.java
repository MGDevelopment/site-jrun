package com.tmk.soa.servicios.implementation;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

import com.tmk.bus.socio.Localidad;
import com.tmk.bus.socio.Provincia;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.servicios.interfaces.SocioDomiciliosService;
import com.tmk.src.socio.SocioPK;

public class SocioDomiciliosServiceImpl implements SocioDomiciliosService {
	
	public Collection getDomiciliosByPkSocio(SocioPK socioPk) {
		try{
			return DAOFactory.getSocios2DAO().getDomiciliosByPkSocio(socioPk);
		}catch (AplicationException ae) {
			TmkLogger.info("No tiene domicilio es socio = "+socioPk.ID_SOCIO +"-"+socioPk.ID_SUCURSAL);
			return new TreeSet();
		}
	}

	public String getDireccionFormateada(SocioDomicilios domicilio) {
		StringBuffer direccion = new StringBuffer();
		if(domicilio.getCalle()!=null){
			direccion.append(domicilio.getCalle()).append(" ");			
		}
		if(domicilio.getNumero()!=null){
			direccion.append(domicilio.getNumero()).append(" ");
		}		
		if(domicilio.getEdificio()!=null){
			direccion.append("Edificio ").append(domicilio.getEdificio()).append(" ");
		}
		if(domicilio.getPiso()!=null){
			direccion.append("Piso ").append(domicilio.getPiso()).append(" ");
		}
		if(domicilio.getDepto()!=null){
			direccion.append("Dpto ").append(domicilio.getDepto()).append(" ");
		}
		return direccion.toString();
	}
	
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
	}
}
