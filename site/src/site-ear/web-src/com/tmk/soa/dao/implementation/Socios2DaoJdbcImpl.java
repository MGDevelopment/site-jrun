package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.TreeSet;
import com.tmk.bus.socio.Localidad;
import com.tmk.bus.socio.Pais;
import com.tmk.bus.socio.Provincia;
import com.tmk.bus.socio.SocioDomicilios;
import com.tmk.bus.socio.SociosIntegracion;
import com.tmk.bus.socio.Socios2;
import com.tmk.bus.socio.Socios2DTO;
import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.dao.interfaces.Socios2DAO;
import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.src.socio.SocioPK;

public class Socios2DaoJdbcImpl  implements Socios2DAO{

	public Socios2 findByPK(SocioPK pk)throws AplicationException {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();
		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".e_mail1");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".f_alta");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".login");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nro_doc");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".tipo_doc");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".sexo");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".estado_civil");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_profesion");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".password");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".hijos");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".auxflag2");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".fecha_nacimiento");
				
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nacionalidad");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
				
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".nacionalidad");
				
				Condicion condicionIdSocio = new Condicion(Socios2.getAlias()+".id_socio",
						Comparador.IGUAL,""+pk.ID_SOCIO);													
				Condicion condicionIdSucursal = new Condicion(Socios2.getAlias()+".id_sucursal",
						Comparador.IGUAL,""+pk.ID_SUCURSAL);
				
				WhereDBO where = new WhereDBO();
				where.add(condicionIdSocio);
				where.add(Operador.AND,condicionIdSucursal);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Socios2.getAlias()+".id_socio");
								
				art =  (TreeSet<DBO>)DBO.select2(Socios2.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			//TmkLogger.debug(MainHelper.getMessage(e));
			AplicationException ae = new AplicationException(e.getMessage());
			ae.setError(e);
			throw ae;
		}	
		return (Socios2)art.iterator().next();
	}

	public String getLogin(SocioPK pk) {
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rst = null;
		String retorno = null;
		try {
			con = ConnectionProvider.getConection();
			pst = con.prepareStatement("select login,e_mail1 from socios2 where id_socio = ? and id_sucursal = ?");
			pst.setInt(1, pk.ID_SOCIO.intValue());
			pst.setInt(2, pk.ID_SUCURSAL.intValue());
			rst = pst.executeQuery() ;
			if(rst.next()) {
				if(rst.getString("login")!=null) {
					retorno =  new String(CryptUtil.desEncriptar(rst.getBytes("login"))); 
				}else {
					retorno =  rst.getString("e_mail1");
				}
			}
		}catch (Exception e) {
			TmkLogger.error("No se pudo obtener el mail de: " +pk.ID_SOCIO +"-"+ pk.ID_SUCURSAL + e);
		}finally {
			try {
				con.close();
				pst.close();
				rst.close();
			}catch (Exception e) {
				TmkLogger.error("Error cerrando conexiones "+ e);
				return null;
			}
		}
		return retorno;
	}

	public Collection getDomiciliosByPkSocio(SocioPK socioPk) throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();	
		/*camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".e_mail1");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".login");
			*/
		//camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioDomicilios");		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
				
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");//DBO PAIS		
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");//DBO PROVINCIA
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");		
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");//DBO LOCALIDAD
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
		
		/*camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioIntegracion");		
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".indentificador");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".dominio");*/
		
		CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
		//camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".socioDomicilios");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
	//	camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".socioIntegracion");
		
		/*Condicion condicionIdSocio = new Condicion(Socios2.getAlias()+".id_socio",
				Comparador.IGUAL,"85844");	
		Condicion condicionIdSucursal= new Condicion(Socios2.getAlias()+".id_sucursal",
				Comparador.IGUAL,"201");*/
		Condicion condicionIdSocio = new Condicion(SocioDomicilios.getAlias()+".id_socio",
		Comparador.IGUAL,socioPk.ID_SOCIO.toString());	
		Condicion condicionIdSucursal= new Condicion(SocioDomicilios.getAlias()+".id_sucursal",
		Comparador.IGUAL,socioPk.ID_SUCURSAL.toString());
		
		
		WhereDBO where = new WhereDBO();
		where.add(condicionIdSocio);
		where.add(Operador.AND,condicionIdSucursal);		
		//OrderBYDBO order = new OrderBYDBO();		
		
		Connection con = null;
		Collection<DBO> colDomicilio = null;
		try {
			con = DBUtil.buildConnection();
			//Collection<DBO> colSocio = null;
			//colSocio = (TreeSet<DBO>)DBO.select2(Socios2.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			//return DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			colDomicilio = (TreeSet<DBO>)DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			//Socios2 s = (Socios2)colSocio.iterator().next();
			//SocioDomicilios s = (SocioDomicilios)colSocio.iterator().next();				
		}catch(Exception e) {
			throw new AplicationException(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {				
				throw new AplicationException(e.getMessage());
			}
		}
		return colDomicilio;		
	}

	public Collection findByTipoEnvio(SocioPK socioPk) throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();	
		/*camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".e_mail1");
		camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".login");
			*/
		//camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioDomicilios");		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_provincia_inex");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_localidad_inex");
				
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");//DBO PAIS		
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");//DBO PROVINCIA
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");		
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");//DBO LOCALIDAD
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
		
		/*camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".socioIntegracion");		
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".indentificador");
		camposABuscar.agregarCampoABusqueda(SocioIntegracion.getAlias() + ".dominio");*/
		
		CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
		//camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".socioDomicilios");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
	//	camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".socioIntegracion");
		
		/*Condicion condicionIdSocio = new Condicion(Socios2.getAlias()+".id_socio",
				Comparador.IGUAL,"85844");	
		Condicion condicionIdSucursal= new Condicion(Socios2.getAlias()+".id_sucursal",
				Comparador.IGUAL,"201");*/
		Condicion condicionIdSocio = new Condicion(SocioDomicilios.getAlias()+".id_socio",
				Comparador.IGUAL,socioPk.ID_SOCIO.toString());	
		Condicion condicionIdSucursal= new Condicion(SocioDomicilios.getAlias()+".id_sucursal",
				Comparador.IGUAL,socioPk.ID_SUCURSAL.toString());
		Condicion condicionTipoEnvio= new Condicion(SocioDomicilios.getAlias()+".tipo_domicilio",
				Comparador.LIKE,"'EN%'");	
		
		WhereDBO where = new WhereDBO();
		where.add(condicionIdSocio);
		where.add(Operador.AND,condicionIdSucursal);
		where.add(Operador.AND,condicionTipoEnvio);
		//OrderBYDBO order = new OrderBYDBO();		
		
		Connection con = null;
		Collection<DBO> colDomicilio = null;
		try {
			con = DBUtil.buildConnection();
			//Collection<DBO> colSocio = null;
			//colSocio = (TreeSet<DBO>)DBO.select2(Socios2.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			//return DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			colDomicilio = (TreeSet<DBO>)DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());
			//Socios2 s = (Socios2)colSocio.iterator().next();
			//SocioDomicilios s = (SocioDomicilios)colSocio.iterator().next();				
		}catch(Exception e) {
			throw new AplicationException(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {				
				throw new AplicationException(e.getMessage());
			}
		}
		return colDomicilio;	
	}
	
	public Collection findByTipoFacturacion(SocioPK socioPk)throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();			
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
				
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");//DBO PAIS		
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");//DBO PROVINCIA
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");		
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");//DBO LOCALIDAD
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
		
		CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();		
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
				
		Condicion condicionIdSocio = new Condicion(SocioDomicilios.getAlias()+".id_socio",
				Comparador.IGUAL,socioPk.ID_SOCIO.toString());	
		Condicion condicionIdSucursal= new Condicion(SocioDomicilios.getAlias()+".id_sucursal",
				Comparador.IGUAL,socioPk.ID_SUCURSAL.toString());
		Condicion condicionTipoFacturacion= new Condicion(SocioDomicilios.getAlias()+".tipo_domicilio",
				Comparador.LIKE,"'TF%'");	
		
		WhereDBO where = new WhereDBO();
		where.add(condicionIdSocio);
		where.add(Operador.AND,condicionIdSucursal);
		where.add(Operador.AND,condicionTipoFacturacion);
		//OrderBYDBO order = new OrderBYDBO();		
		
		Connection con = null;
		Collection<DBO> colDomicilio = null;
		try {
			con = DBUtil.buildConnection();			
			colDomicilio = (TreeSet<DBO>)DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());				
		}catch(Exception e) {
			throw new AplicationException(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				throw new AplicationException(e.getMessage());
			}
		}
		return colDomicilio;			
	}

	public SocioDomicilios findByPKYTipoDomicilio(SocioPK socioPk,
			String tipoDomicilio) throws AplicationException {
		CamposABuscarDBO camposABuscar = new CamposABuscarDBO();	
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_socio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".id_sucursal");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".tipo_domicilio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".calle");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".cp");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".numero");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".edificio");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".piso");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".depto");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_provincia_inex");
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".descripcion_localidad_inex");
				
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".pais");//DBO PAIS		
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
		camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".habilitado_tematika");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".provincia");//DBO PROVINCIA
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".id_provincia");		
		camposABuscar.agregarCampoABusqueda(Provincia.getAlias() + ".descripcion");
		
		camposABuscar.agregarCampoABusqueda(SocioDomicilios.getAlias() + ".localidad");//DBO LOCALIDAD
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_pais");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_provincia");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".id_localidad");
		camposABuscar.agregarCampoABusqueda(Localidad.getAlias() + ".descripcion");
					
		CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".pais");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".provincia");
		camposLeftJoin.setCampoDBOLeftJoin(SocioDomicilios.getAlias()+".localidad");
	
		Condicion condicionIdSocio = new Condicion(SocioDomicilios.getAlias()+".id_socio",
		Comparador.IGUAL,socioPk.ID_SOCIO.toString());	
		Condicion condicionIdSucursal= new Condicion(SocioDomicilios.getAlias()+".id_sucursal",
		Comparador.IGUAL,socioPk.ID_SUCURSAL.toString());
		Condicion condicionTipoDomicilio= new Condicion(SocioDomicilios.getAlias()+".tipo_domicilio",
				Comparador.IGUAL,"'"+tipoDomicilio+"'");		
		
		WhereDBO where = new WhereDBO();
		where.add(condicionIdSocio);
		where.add(Operador.AND,condicionIdSucursal);
		where.add(Operador.AND,condicionTipoDomicilio);
		//OrderBYDBO order = new OrderBYDBO();		
		
		Connection con = null;
		Collection<DBO> colDomicilio = null;
		try {
			con = DBUtil.buildConnection();
			colDomicilio = (TreeSet<DBO>)DBO.select2(SocioDomicilios.class,con,camposABuscar,camposLeftJoin,where,null, new ComparadorPorDefecto());				
		}catch(Exception e) {
			throw new AplicationException(e.getMessage());
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {				
				throw new AplicationException(e.getMessage());
			}
		}
		return (SocioDomicilios)colDomicilio.iterator().next();
	}

	/**
	 * Se reemplaza de ShortsCut
	 * @param LOGIN
	 * @return
	 * @throws AplicationException
	 */
	public Socios2 findSocioByLoginPassword(String login, String password)throws AplicationException {
		Socios2 socio = null;
		try {
			byte[] login_encriptado = CryptUtil.encriptar(login.getBytes());
			byte[] login_encriptadoUP = CryptUtil.encriptar(login.toUpperCase().getBytes());
			byte[] login_encriptadoLOW = CryptUtil.encriptar(login.toLowerCase().getBytes());
			byte[] password_encriptada = CryptUtil.encriptar(password.getBytes());
			
		Connection connection = DBUtil.buildConnection();
			try {
				PreparedStatement ps = connection.prepareStatement(
				        "SELECT id_sucursal, id_socio FROM socios2 WHERE (login = ? OR login = ? OR login = ?) AND password = ?");
				try {
					int index = 0;
					ps.setBytes(++index, login_encriptado);
					ps.setBytes(++index, login_encriptadoUP);
					ps.setBytes(++index, login_encriptadoLOW);
					ps.setBytes(++index, password_encriptada);
					ResultSet resultSet = ps.executeQuery();
					try {
						if(resultSet.next()) {
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));							
							socio = findByPK(socioPK);
						}
					}
					finally {
						resultSet.close();
					}
				} finally {
					ps.close();
				}
			}
			finally{
				connection.close();
			}
		} catch(Exception se) {
			TmkLogger.error(se.getMessage());
		}

		return socio;
	}
	
	/**
	 * Se reemplaza de ShortsCut
	 * @param LOGIN
	 * @return Socio2
	 * @throws AplicationException
	 */
	public Socios2 findSocioByLogin(String LOGIN)throws AplicationException	{
		Socios2 socio = null;

		try	{
			byte[] login_encriptado = CryptUtil.encriptar(LOGIN.getBytes());
			byte[] login_encriptadoUP = CryptUtil.encriptar(LOGIN.toUpperCase().getBytes());
			byte[] login_encriptadoLOW = CryptUtil.encriptar(LOGIN.toLowerCase().getBytes());

			Connection connection = DBUtil.buildConnection();
			try	{
				PreparedStatement ps = connection.prepareStatement("SELECT id_sucursal, id_socio FROM socios2 WHERE (login = ? OR login = ? OR login = ?)");
				try	{
					int index = 0;
					ps.setBytes(++index, login_encriptado);
					ps.setBytes(++index, login_encriptadoUP);
					ps.setBytes(++index, login_encriptadoLOW);
					ResultSet resultSet = ps.executeQuery();
					try	{
						if(resultSet.next()){
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							socio = findByPK(socioPK);
						}
					}finally	{
						resultSet.close();
					}
				}finally{
					ps.close();
				}
			}finally{
				connection.close();
			}
		}
		
		catch(Exception se){
			TmkLogger.error(se.toString());
		}

		return socio;
	}

	/**
	 * Ordena por fecha de alta, y por las dudas por rowid, por si las fechas son iguales (si... pasa...)
	 */
	public Collection findRepetidosAUnificar(String SEXO, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD) throws AplicationException {
		/*
		 * 					SELECT   "ID_SUCURSAL", "ID_SOCIO"
								FROM SOCIOS2
							   WHERE SEXO = ?1
								 AND TIPO_DOC = ?2
								 AND NRO_DOC = ?3
								 AND NVL(NACIONALIDAD, ?4) = ?4
							ORDER BY F_ALTA, ROWID
		 */

		ComparadorPorDefecto comparador = new ComparadorPorDefecto();		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				
				/*camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nacionalidad");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
				
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".nacionalidad");*/
				
				Condicion cndSexo = new Condicion(Socios2.getAlias()+".sexo",
						Comparador.IGUAL,"'"+SEXO.toUpperCase()+"'");													
				Condicion cndTipoDoc = new Condicion(Socios2.getAlias()+".tipo_doc",
						Comparador.IGUAL,"'"+TIPO_DOC.toUpperCase()+"'");
				Condicion cndNroDoc = new Condicion(Socios2.getAlias()+".nro_doc",
						Comparador.IGUAL,NRO_DOC.toString());
				StringBuffer cond = new StringBuffer();
				cond.append("NVL(").append(Socios2.getAlias()).append(".nacionalidad,").append(NACIONALIDAD).append(")");
				Condicion cndNAcionalidad = new Condicion(cond.toString(),
						Comparador.IGUAL,NACIONALIDAD.toString());
				
				WhereDBO where = new WhereDBO();
				where.add(cndSexo);
				where.add(Operador.AND,cndTipoDoc);
				where.add(Operador.AND,cndNroDoc);
				where.add(Operador.AND,cndNAcionalidad);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Socios2.getAlias()+".f_alta");
				order.agregarCampoAOrden("ROWID");
								
				art =  (TreeSet<DBO>)DBO.select2(Socios2.class,conn,camposABuscar,null,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			//TmkLogger.error(MainHelper.getMessage(e));
			AplicationException ae = new AplicationException(e.getMessage());
			ae.setError(e);
			throw ae;
		}	
		return art;
	}
	/*
	 * (non-Javadoc)
	 * @see com.tmk.soa.dao.interfaces.Socios2DAO#findRepetidosDelSitio(java.lang.String, java.lang.String, java.lang.Long, java.lang.Integer)
	 * 						SELECT   "ID_SUCURSAL", "ID_SOCIO"
								FROM SOCIOS2
							   WHERE SEXO = ?1
								 AND TIPO_DOC = ?2
								 AND NRO_DOC = ?3
								 AND NVL(NACIONALIDAD, ?4) = ?4
								 AND LOGIN is not null
								 AND PASSWORD is not null
							ORDER BY F_ALTA, ROWID
	 */
	public Collection findRepetidosDelSitio(String SEXO, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD) throws AplicationException {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");								
				
				Condicion cndSexo = new Condicion(Socios2.getAlias()+".sexo",
						Comparador.IGUAL,"'"+SEXO.toUpperCase()+"'");													
				Condicion cndTipoDoc = new Condicion(Socios2.getAlias()+".tipo_doc",
						Comparador.IGUAL,"'"+TIPO_DOC.toUpperCase()+"'");
				Condicion cndNroDoc = new Condicion(Socios2.getAlias()+".nro_doc",
						Comparador.IGUAL,NRO_DOC.toString());
				StringBuffer cond = new StringBuffer();
				cond.append("NVL(").append(Socios2.getAlias()).append(".nacionalidad,").append(NACIONALIDAD).append(")");
				Condicion cndNAcionalidad = new Condicion(cond.toString(),
						Comparador.IGUAL,NACIONALIDAD.toString());
				Condicion cndLogin = new Condicion(Socios2.getAlias()+".login",
						Comparador.IS_NOT_NULL,"");
				Condicion cndPassword = new Condicion(Socios2.getAlias()+".password",
						Comparador.IS_NOT_NULL,"");
				
				WhereDBO where = new WhereDBO();
				where.add(cndSexo);
				where.add(Operador.AND,cndTipoDoc);
				where.add(Operador.AND,cndNroDoc);
				where.add(Operador.AND,cndNAcionalidad);
				where.add(Operador.AND,cndLogin);
				where.add(Operador.AND,cndPassword);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Socios2.getAlias()+".f_alta");
				order.agregarCampoAOrden("ROWID");
								
				art =  (TreeSet<DBO>)DBO.select2(Socios2.class,conn,camposABuscar,null,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error(MainHelper.getMessage(e));
			AplicationException ae = new AplicationException(e.getMessage());
			ae.setError(e);
			throw ae;
		}	
		return art;
	}

	public void create(Integer ID_SUCURSAL, Integer ID_SOCIO, Integer ID_CAAL,
			Integer ID_TIPO_CONTRIBUYENTE, String TIPO_PERSONA, byte[] LOGIN,
			String NOMBRES, String APELLIDOS, byte[] PASSWORD, String TIPO_DOC,
			Long NRO_DOC, Integer NACIONALIDAD, Timestamp FECHA_NACIMIENTO,
			String SEXO, String ESTADO_CIVIL, Integer HIJOS,
			Integer ID_PROFESION, String E_MAIL1, String INFO_EXTRA,
			String INFO_TERCEROS, String INTERNET_CASA, String PC_CASA,
			String AUXFLAG2) throws DuplicateException, Exception {

		Socios2DTO socio = new Socios2DTO(ID_SUCURSAL,ID_SOCIO);
		socio.setId_caal(ID_CAAL);
		socio.setId_Tipo_contribuyente(ID_TIPO_CONTRIBUYENTE);
		socio.setTipo_persona(TIPO_PERSONA);
		socio.setLogin(LOGIN);
		socio.setNombres(NOMBRES);
		socio.setApellidos(APELLIDOS);		
		socio.setPassword(PASSWORD);
		socio.setTipo_doc(TIPO_DOC);
		//socio.setNro_doc(new Integer(NRO_DOC.intValue()));
		socio.setNro_doc(NRO_DOC);
		socio.setFecha_nacimiento(FECHA_NACIMIENTO);
		socio.setNacionalidad(NACIONALIDAD);
		socio.setSexo(SEXO);
		socio.setEstado_civil(ESTADO_CIVIL);
		socio.setHijos(HIJOS);	
		socio.setId_profesion(ID_PROFESION);
		socio.setE_mail1(E_MAIL1);
		socio.setInfo_extra(INFO_EXTRA);
		socio.setInfo_terceros(INFO_TERCEROS);
		socio.setInternet_casa(INTERNET_CASA);					
		socio.setAuxflag2(AUXFLAG2);	
				
		
		DAOFactory.getDboDAO().insert(socio);
	}

	public Socios2 findByPrimaryKey (SocioPK pk)throws DBOInexistenteException,Exception {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();
		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_sucursal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_caal");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nombres");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".apellidos");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".e_mail1");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".f_alta");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".login");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nro_doc");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".tipo_doc");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".sexo");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".estado_civil");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".id_profesion");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".password");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".hijos");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".auxflag2");
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".fecha_nacimiento");
				
				camposABuscar.agregarCampoABusqueda(Socios2.getAlias() + ".nacionalidad");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".id_pais");
				camposABuscar.agregarCampoABusqueda(Pais.getAlias() + ".descripcion");
				
				CamposLeftJoinDBO camposLeftJoin = new CamposLeftJoinDBO();
				camposLeftJoin.setCampoDBOLeftJoin(Socios2.getAlias()+".nacionalidad");
				
				Condicion condicionIdSocio = new Condicion(Socios2.getAlias()+".id_socio",
						Comparador.IGUAL,""+pk.ID_SOCIO);													
				Condicion condicionIdSucursal = new Condicion(Socios2.getAlias()+".id_sucursal",
						Comparador.IGUAL,""+pk.ID_SUCURSAL);
				
				WhereDBO where = new WhereDBO();
				where.add(condicionIdSocio);
				where.add(Operador.AND,condicionIdSucursal);
												
				OrderBYDBO order = new OrderBYDBO();
				order.agregarCampoAOrden(Socios2.getAlias()+".id_socio");
								
				art =  (TreeSet<DBO>)DBO.select2(Socios2.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}	
		return (Socios2)art.iterator().next();
	}

	/**
	 * Determina si un socio esa integrado con popego
	 */
	public SociosIntegracion findSocioIntegracion(SocioPK socioPK, String dominio) throws Exception{
		SociosIntegracion socio = null;
		try {	
			Connection conn = DBUtil.buildConnection();			
			  try{
				  socio = new SociosIntegracion(socioPK.ID_SOCIO,socioPK.ID_SUCURSAL,null,new String("popego.com"));
				  socio.select(conn);
				  return socio;
			   }finally{
			   	 conn.close();
			   }
		}catch (Exception e) {
			throw e;
		}			   
	}
}
