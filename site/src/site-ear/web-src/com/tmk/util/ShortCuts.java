/**
 * @author Lizardo Santiago
 *
 * $Log: ShortCuts.java,v $
 * Revision 1.25  2007/09/03 13:42:24  msartori
 * no message
 *
 * Revision 1.24  2006/08/14 13:29:25  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.23  2004/12/13 18:52:37  omsartori
 * - reporte de ordenes discriminado por medio de pago
 * - js para validar mail de hotmail en registro del socio
 *
 * Revision 1.22  2004/12/01 12:20:20  omsartori
 * - corrección de socio.jsp (intranet), bug de socio sin login y/o pass
 *
 * Revision 1.21  2004/06/15 20:57:37  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.20  2003/12/22 22:28:02  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.19  2003/12/12 21:51:23  GPistoia
 * -Correccion en paginas de extranet
 * -Liberacion de memoria en el revitalizer e inicializa el contador
 *
 * Revision 1.18  2003/11/03 20:58:00  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 */
package com.tmk.util;

import com.tmk.bus.articulo.ListaDeseos;
import com.tmk.bus.socio.Socios2;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.src.socio.SocioPK;
import com.tmk.src.listadeseos.ListaDeseosPK;
import javax.naming.NamingException;
import java.sql.*;
import java.util.Iterator;
import java.util.Vector;

public final class ShortCuts
{

	public static Socios2 findSocioById(SocioPK socioPK)
	{
		if(socioPK == null) return null;
		Socios2 socio = null;
		try{		
			socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
		}
		catch(Exception fe) {
			TmkLogger.error(fe.toString());
		}
		return socio;
	}
	
	public static Socios2  findSocioByLogin(String LOGIN)
	{
		Socios2 socio = null;		
		try
		{
			byte[] login_encriptado = CryptUtil.encriptar(LOGIN.getBytes());
			byte[] login_encriptadoUP = CryptUtil.encriptar(LOGIN.toUpperCase().getBytes());
			byte[] login_encriptadoLOW = CryptUtil.encriptar(LOGIN.toLowerCase().getBytes());

			Connection connection = DBUtil.buildConnection();
			try
			{
				PreparedStatement ps = connection.prepareStatement("SELECT id_sucursal, id_socio FROM socios2 WHERE (login = ? OR login = ? OR login = ?)");
				try
				{
					int index = 0;
					ps.setBytes(++index, login_encriptado);
					ps.setBytes(++index, login_encriptadoUP);
					ps.setBytes(++index, login_encriptadoLOW);
					ResultSet resultSet = ps.executeQuery();
					try
					{
						if(resultSet.next())
						{
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
						}
					}
					finally
					{
						resultSet.close();
					}
				}
				finally
				{
					ps.close();
				}
			}
			finally
			{
				connection.close();
			}
		}
		catch(DBOInexistenteException ne)
		{
			TmkLogger.error(ne.toString());
		}
		catch(Exception se)
		{
			TmkLogger.error(se.toString());
		}

		return socio;
	}

	public static Socios2 findSocioByEMail1(String email)
	{
		Socios2 socio = null;

		try
		{
			Connection connection = DBUtil.buildConnection();
			try
			{
				PreparedStatement ps = connection.prepareStatement("SELECT * FROM socios2 WHERE UPPER(e_mail1) = ?");
				try
				{
					ps.setString(1, email.toUpperCase());
					ResultSet resultSet = ps.executeQuery();

					try
					{
						if(resultSet.next())
						{
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
						}
					}
					finally
					{
						resultSet.close();
					}
				}
				finally
				{
					ps.close();
				}
			}
			finally
			{
				connection.close();
			}
		}
		catch(DBOInexistenteException ne)
		{
			TmkLogger.error(ne.toString());
		}
		//catch(SQLException se)
		catch(Exception se)
		{
			TmkLogger.error(se.toString());
		}
		return socio;
	}

	/**
	 * NO USA EBJ, SOLO LEVANTA LAS PK DE LOS SOCIOS DADO EL STRING "LOGIN"
	 * @param LOGIN
	 * @return
	 */
	public static Iterator findSociosByLogin(String LOGIN)
	{
		Vector<SocioPK> socios = new Vector<SocioPK>();

		try
		{
			byte[] login_encriptado = CryptUtil.encriptar(LOGIN.getBytes());
			byte[] login_encriptadoUP = CryptUtil.encriptar(LOGIN.toUpperCase().getBytes());
			byte[] login_encriptadoLOW = CryptUtil.encriptar(LOGIN.toLowerCase().getBytes());

			Connection connection = DBUtil.buildConnection();
			try
			{
				PreparedStatement ps = connection.prepareStatement("SELECT id_sucursal, id_socio FROM socios2 WHERE (login = ? OR login = ? OR login = ?)");
				try
				{
					int index = 0;
					ps.setBytes(++index, login_encriptado);
					ps.setBytes(++index, login_encriptadoUP);
					ps.setBytes(++index, login_encriptadoLOW);
					ResultSet resultSet = ps.executeQuery();
					try
					{
						if(resultSet.next())
						{
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							socios.add(socioPK);
						}
					}
					finally
					{
						resultSet.close();
					}
				}
				finally
				{
					ps.close();
				}
			}
			finally
			{
				connection.close();
			}
		}
		catch(NamingException ne)
		{
			TmkLogger.error(ne.getMessage());
		}
		catch(SQLException se)
		{
			TmkLogger.error(se.getMessage());
		}

		return socios.iterator();
	}

	public static Socios2 findSocioByLoginPassword(String LOGIN, String PASSWORD)
	{
		Socios2 socio = null;

		try
		{
			byte[] login_encriptado = CryptUtil.encriptar(LOGIN.getBytes());
			byte[] login_encriptadoUP = CryptUtil.encriptar(LOGIN.toUpperCase().getBytes());
			byte[] login_encriptadoLOW = CryptUtil.encriptar(LOGIN.toLowerCase().getBytes());
			byte[] password_encriptada = CryptUtil.encriptar(PASSWORD.getBytes());

			Connection connection = DBUtil.buildConnection();
			try
			{
				PreparedStatement ps = connection.prepareStatement(
				        "SELECT id_sucursal, id_socio FROM socios2 WHERE (login = ? OR login = ? OR login = ?) AND password = ?");
				try
				{
					int index = 0;
					ps.setBytes(++index, login_encriptado);
					ps.setBytes(++index, login_encriptadoUP);
					ps.setBytes(++index, login_encriptadoLOW);
					ps.setBytes(++index, password_encriptada);
					ResultSet resultSet = ps.executeQuery();
					try
					{
						if(resultSet.next())
						{
							SocioPK socioPK = new SocioPK(new Integer(resultSet.getInt(1)), new Integer(resultSet.getInt(2)));
							//socio = ShortCuts.findSocioById(socioPK);
							socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
						}
					}
					finally
					{
						resultSet.close();
					}
				}
				finally
				{
					ps.close();
				}
			}
			finally
			{
				connection.close();
			}
		}
		catch(DBOInexistenteException ne)
		{
			TmkLogger.error(ne.getMessage());
		}

		catch(Exception se)		
		{
			TmkLogger.error(se.getMessage());
		}

		return socio;
	}

	/**
	 * Busca en lista_deseos si es que ya esta creado para el socio dado SocioPK
	 * si existe la retorna, si no la crea.
	 * @param com.tmk.src.SocioPK
	 * @return ListaDeseos
	 *  
	 */
	public static ListaDeseos findListaBySocio(com.tmk.src.socio.SocioPK socioPK)
	{
		ListaDeseos lista = null;
		try {
			ListaDeseosPK listaPK = new ListaDeseosPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);
			lista = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);			
		}
		catch(DBOInexistenteException dbe) {
			try{
				ServiceLocator.getListaDeDeseosService().create(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO, null, " ", " ", new Integer(0), new Integer(0), " ", new Integer(2));								
			}catch(DuplicateException de) 
			{
				TmkLogger.error(de.getMessage());
			}
			catch(Exception ce){
				TmkLogger.error(ce.getMessage());
			}
		}
		catch(Exception fe) {
			TmkLogger.error(fe.getMessage());
		}
		return lista;
	}
	
	
	public static boolean esSocioRegistradoSegunUnificacion(int idSucursal, int idCAAL,
			int idPais, String sexo, String tipoDoc, long nroDoc) {
		boolean retorno = false;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT id_socio");
				qry.append(" FROM socios2");
				qry.append(" WHERE id_sucursal= ?");
				qry.append(" 	and id_caal= ?");
				qry.append(" 	and nro_doc= ?");
				qry.append(" 	and tipo_doc= ?");
				qry.append(" 	and sexo= ?");
				qry.append(" 	and nacionalidad= ?");
				PreparedStatement ps = conn.prepareStatement(qry.toString());
				try {
					ps.setInt(1, idSucursal);
					ps.setInt(2, idCAAL);
					ps.setLong(3, nroDoc);
					ps.setString(4, tipoDoc);
					ps.setString(5, sexo);
					ps.setInt(6, idPais);
					ResultSet rs = ps.executeQuery();
					try {
						if (rs.next()) {
							retorno = true;
						}
					} catch (Exception e) {
						TmkLogger.error("ShortCuts] esSocioRegistradoSegunUnificacion(" + idSucursal + ", " +
								idCAAL + ", " + idPais + ", " + sexo + ", " + tipoDoc + ", " + nroDoc + ")" +
										" error en recorrido de rs - " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("ShortCuts] esSocioRegistradoSegunUnificacion(" + idSucursal + ", " +
							idCAAL + ", " + idPais + ", " + sexo + ", " + tipoDoc + ", " + nroDoc + ")" +
									" error en ejecucion de rs - " + e.toString());
				} finally {
					ps.close();
				}
			} catch (Exception e) {
				TmkLogger.error("ShortCuts] esSocioRegistradoSegunUnificacion(" + idSucursal + ", " +
						idCAAL + ", " + idPais + ", " + sexo + ", " + tipoDoc + ", " + nroDoc + ")" +
								" error en creacion de statement - " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("ShortCuts] esSocioRegistradoSegunUnificacion(" + idSucursal + ", " +
					idCAAL + ", " + idPais + ", " + sexo + ", " + tipoDoc + ", " + nroDoc + ")" +
							" error en conexion - " + e.toString());
		}
		return retorno;
	}
}
