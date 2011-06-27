package com.tmk.soa.dao.implementation;

import java.sql.Connection;
import java.sql.Timestamp;
import java.util.Collection;
//import java.util.Date;
import java.util.TreeSet;
import com.tmk.bus.orden.CarritoCompra;
//import com.tmk.bus.socio.BufferSocios;
//import com.tmk.controllers.MainHelper;
import com.tmk.dbo.DBO;
import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.sql.CamposABuscarDBO;
import com.tmk.dbo.sql.WhereDBO;
import com.tmk.dbo.sql.condicion.Comparador;
import com.tmk.dbo.sql.condicion.Condicion;
import com.tmk.dbo.sql.condicion.Operador;
import com.tmk.kernel.DBUtil;
import com.tmk.soa.dao.DAOFactory;
import com.tmk.soa.dao.interfaces.CarritoCompraDAO;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.persistencia.ConnectionProvider;
import com.tmk.src.socio.CarritoCompraPK;

public class CarritoCompraDaoDboImpl implements CarritoCompraDAO {

	public CarritoCompra create(Integer ID_SUCURSAL_SOCIO,
			Integer ID_SOCIO, Integer ID_ARTICULO, Integer CANTIDAD, Timestamp FECHA)
			throws DuplicateException,Exception {
		
		CarritoCompra carritoComra = new CarritoCompra();
		carritoComra.setId_sucursal_socio(ID_SUCURSAL_SOCIO);
		carritoComra.setId_socio(ID_SOCIO);
		carritoComra.setId_articulo(ID_ARTICULO);
		carritoComra.setCantidad(CANTIDAD);
		carritoComra.setFecha(FECHA);
		
		DAOFactory.getDboDAO().insert(carritoComra);
		return carritoComra;
		
	}

	public Collection findAll() throws DBOInexistenteException ,Exception{
		// TODO Auto-generated method stub
		return null;
	}

	public CarritoCompra findByPrimaryKey(CarritoCompraPK pk)
			throws DBOInexistenteException,Exception  {

		CarritoCompra dbo = new CarritoCompra(pk);
		try{
			Connection conn = ConnectionProvider.getConection();
			try {
				dbo = new CarritoCompra(pk);
				dbo.select(conn);	
			}finally {
				conn.close();
			}		
		}catch (DBOInexistenteException de) {
			throw de;
		}catch (Exception e) {
			throw e;
		}
		return dbo;
		
	}
	/* uso selec2 de dbo por ser una collection el resultado
	 * SELECT "ID_SUCURSAL_SOCIO", "ID_SOCIO", "ID_ARTICULO" 
	 * FROM CARRITO_COMPRA o 
	 * WHERE o.ID_SUCURSAL_SOCIO = ?1 AND 
	 * o.ID_SOCIO = ?2	 
	 */
	public Collection findByUser(Integer idSucursalSocio, Integer idSocio)
			throws DBOInexistenteException,Exception {

		ComparadorPorDefecto comparador = new ComparadorPorDefecto();		
		Collection<DBO> art  = null;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
				camposABuscar.agregarCampoABusqueda(CarritoCompra.getAlias() + ".id_sucursal_socio");
				camposABuscar.agregarCampoABusqueda(CarritoCompra.getAlias() + ".id_socio");
				camposABuscar.agregarCampoABusqueda(CarritoCompra.getAlias() + ".id_articulo");
				camposABuscar.agregarCampoABusqueda(CarritoCompra.getAlias() + ".cantidad");
				camposABuscar.agregarCampoABusqueda(CarritoCompra.getAlias() + ".fecha");
								
				Condicion cnd1 = new Condicion(CarritoCompra.getAlias()+".id_sucursal_socio",
						Comparador.IGUAL,idSucursalSocio.toString());													
				Condicion cnd2 = new Condicion(CarritoCompra.getAlias()+".id_socio",
						Comparador.IGUAL,idSocio.toString());
				
				WhereDBO where = new WhereDBO();
				where.add(cnd1);
				where.add(Operador.AND,cnd2);
																											
				art =  (TreeSet<DBO>)DBO.select2(CarritoCompra.class,conn,camposABuscar,null,where,null, comparador);				
			} finally {
				conn.close();
			}
		} catch (DBOInexistenteException e ) {
			throw e;
		} catch (Exception e) {			
			throw e;
		}	
		return art;
	
	}

}
