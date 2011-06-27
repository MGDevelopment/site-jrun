package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.util.Collection;
import java.util.TreeSet;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.CarritoListaDeseos;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.dbo.sql.OrderBYDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import com.tmk.soa.dao.interfaces.CarritoListaDeseosDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;

public class CarritoListaDeseosDboImpl implements CarritoListaDeseosDAO {

	public CarritoListaDeseos findByPrimaryKey(CarritoListaDeseosPK carritoPK)throws DBOInexistenteException,Exception {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_sucursal_socio_comprador");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_socio_comprador");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_socio");
				
				//campos dbo's
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
								
				CamposLeftJoinDBO camposLeftJoin = null;				
								
				Condicion condicion1 = new Condicion(CarritoListaDeseos.getAlias()+".id_socio",
						Comparador.IGUAL,""+carritoPK.ID_SOCIO);
				Condicion condicion2 = new Condicion(CarritoListaDeseos.getAlias()+".id_sucursal_socio",
						Comparador.IGUAL,""+carritoPK.ID_SUCURSAL_SOCIO);
				Condicion condicion3 = new Condicion(CarritoListaDeseos.getAlias()+".id_articulo",
						Comparador.IGUAL,""+carritoPK.ID_ARTICULO);
				WhereDBO where = new WhereDBO();
				where.add(condicion1);
				where.add(Operador.AND,condicion2);
				where.add(Operador.AND,condicion3);
												
				OrderBYDBO order = null;
								
				art =  (TreeSet<DBO>)DBO.select2(CarritoListaDeseos.class,conn,camposABuscar,camposLeftJoin,where,order, comparador);				
			} finally {
				conn.close();
			}
			return (CarritoListaDeseos)art.iterator().next();
		} catch (DBOInexistenteException e) {
			throw e;
		} catch (Exception e) {	
			throw e;
		}			
	}

	public Collection findBySocio(Integer ID_SUCURSAL_SOCIO, Integer ID_SOCIO)throws DBOInexistenteException,Exception {
		ComparadorPorDefecto comparador = new ComparadorPorDefecto();	
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_sucursal_socio_comprador");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_socio_comprador");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".estado");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".id_socio");
				
				//campos dbo's
				camposABuscar.agregarCampoABusqueda(CarritoListaDeseos.getAlias() + ".articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
				camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");
								
				Condicion condicion1 = new Condicion(CarritoListaDeseos.getAlias()+".id_socio",
						Comparador.IGUAL,""+ID_SOCIO);
				Condicion condicion2 = new Condicion(CarritoListaDeseos.getAlias()+".id_sucursal_socio",
						Comparador.IGUAL,""+ID_SUCURSAL_SOCIO);
				WhereDBO where = new WhereDBO();
				where.add(condicion1);
				where.add(Operador.AND,condicion2);

				return (TreeSet<DBO>)DBO.select2(CarritoListaDeseos.class,conn,camposABuscar,null,where,null, comparador);				
			} finally {
				conn.close();
				comparador = null;
			}
		} catch (DuplicateException de) {
			throw de;
		} catch (Exception e) {	
			throw e;
		}
	}

	public CarritoListaDeseos create(Integer ID_SUCURSAL_SOCIO,
			Integer ID_SOCIO, Integer ID_ARTICULO,
			Integer ID_SUCURSAL_SOCIO_COMPRADOR, Integer ID_SOCIO_COMPRADOR,
			Integer ESTADO) throws DuplicateException,Exception {
					
			CarritoListaDeseosPK pk = new CarritoListaDeseosPK(ID_SUCURSAL_SOCIO,ID_SOCIO, ID_ARTICULO);			
			CarritoListaDeseos carrito = new CarritoListaDeseos(pk);
			carrito.setId_socio_comprador(ID_SOCIO_COMPRADOR);
			carrito.setId_socio(ID_SOCIO);
			carrito.setEstado(ESTADO);
	
			try {
				Connection con = ConnectionProvider.getConection();
				try {
					carrito.insert(con);
					return carrito;				
				} finally {
					con.close();
				}
			} catch (DuplicateException de) {
				throw de;
			} catch (Exception e) {
				String msj = "No se pudo insertar en  "+CarritoListaDeseos.getTabla()+ "la pk =" +pk.toString();
				throw new Exception (msj + e.getMessage());
			}
	}
	
	/*public boolean delete(CarritoListaDeseos carritoListaDeseo)
			throws AplicationException {
		boolean borro  = false;
		try {
			Connection con = ConnectionProvider.getConection();
			con.setAutoCommit(false);
			try {
				carritoListaDeseo.delete(con);
				con.commit();
				TmkLogger.debug("commit de  CarritoListaDeses con pk= " + carritoListaDeseo.getPK());
				borro =  true;
			}catch(Exception e) {
				con.rollback();
				TmkLogger.error("En el delete de CarritoListaDeses con pk= " + carritoListaDeseo.getPK()+ "ha hecho rollbak");
				throw e;
			}
			finally {
				con.close();
			}
		}catch (Exception e) {
			AplicationException ae = new AplicationException(e);
			throw ae;
		} 		
		return borro;
	}*/
}
