package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.SQLException;
import oracle.sql.RAW;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.soa.dao.interfaces.SociosTMKDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.src.socio.SocioPK;

public class SociosTmkDaoJdbcImpl  implements SociosTMKDAO{

	public SocioTMK findSocioTmkByLogin(String login) throws DBOInexistenteException, Exception {
		SocioTMK buscarMail = new SocioTMK();
		//try {
			 Connection conn = ConnectionProvider.getConection();
		 	 try {		
		 		 buscarMail.select(conn, new String[] {"login ='" + login.toUpperCase() + "'"});		 		 
		 	 }
		 	 finally {
		 		 conn.close();
		 	 }
		/*}catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		 }*/
		return buscarMail;
	}
	
	public SocioTMK findSocioTmkByLoginPassword(String login, String password)
			throws DBOInexistenteException,Exception {
		SocioTMK socioTMK = new SocioTMK();
		try {
    		Connection conn = DBUtil.buildConnection();
    		try {
    			socioTMK.select(conn, new String[]{"login = '" + login.replaceAll("--", "") + "'", "password = '" + new RAW(CryptUtil.encriptar(password.getBytes())).stringValue() + "'"});
    		} finally {
    			conn.close();
    		}
		}catch (DBOInexistenteException e) {
    		throw e;
    	} catch (Exception e) {    	
    		throw e;
    	}
    	return socioTMK;
	}
	
	public SocioTMK findSocioTMKByPK(SocioPK pk)throws DBOInexistenteException, Exception {
		try {
			Connection conn = DBUtil.buildConnection();
			try {			
				SocioTMK socioTmk = new SocioTMK(pk.ID_SOCIO,pk.ID_SUCURSAL);
				socioTmk.select(conn);
				return socioTmk;
			}finally {
				conn.close();
			}
		}catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {			
			throw e;
		}	
	}

	public void create(Integer idSocio, Integer idSucursal, String login,
			byte[] password, String nombres, String apellidos)
			throws DuplicateException, Exception {
		SocioTMK socio = new SocioTMK(idSocio,idSucursal);
		socio.setApellidos(apellidos);
		socio.setNombres(nombres);
		socio.setLogin(login);
		socio.setPassword(password);
		try {
			Connection conn =  ConnectionProvider.getConection(); 
			try {
				socio.insert(conn);
			}catch (SQLException e) {
				if(e.getErrorCode() == 1) {
					throw new DuplicateException(e.getMessage());
				}
				throw e;			
			}finally {
				conn.close();
			}
		}catch (Exception e) {
			throw e;
		}
		
	}
}
