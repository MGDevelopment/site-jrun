package com.tmk.soa.dao;

import com.tmk.soa.dao.implementation.ArcashDaoImpl;
import com.tmk.soa.dao.implementation.ArticuloDaoJdbcImpl;
import com.tmk.soa.dao.implementation.BufferSocioDaoDboImp;
import com.tmk.soa.dao.implementation.CarritoCompraDaoDboImpl;
import com.tmk.soa.dao.implementation.CarritoListaDeseosDboImpl;
import com.tmk.soa.dao.implementation.ComentarioArticuloDaoJdbcImpl;
import com.tmk.soa.dao.implementation.DboDaoImpl;
import com.tmk.soa.dao.implementation.DetalleDaoJdbcImpl;
import com.tmk.soa.dao.implementation.ListaDeDeseoDboImpl;
import com.tmk.soa.dao.implementation.ListasTmkDaoDboImp;
import com.tmk.soa.dao.implementation.OrdenDaoDboImpl;
import com.tmk.soa.dao.implementation.PaginacionVidrieraDaoImpl;
import com.tmk.soa.dao.implementation.Socios2DaoJdbcImpl;
import com.tmk.soa.dao.implementation.SociosTmkDaoJdbcImpl;
import com.tmk.soa.dao.interfaces.ArcashDAO;
import com.tmk.soa.dao.interfaces.ArticuloDAO;
import com.tmk.soa.dao.interfaces.BufferSocioDAO;
import com.tmk.soa.dao.interfaces.CarritoCompraDAO;
import com.tmk.soa.dao.interfaces.CarritoListaDeseosDAO;
import com.tmk.soa.dao.interfaces.ComentarioArticuloDAO;
import com.tmk.soa.dao.interfaces.DboDAO;
import com.tmk.soa.dao.interfaces.DetalleDAO;
import com.tmk.soa.dao.interfaces.ListaDeDeseoDAO;
import com.tmk.soa.dao.interfaces.ListasTmkDAO;
import com.tmk.soa.dao.interfaces.OrdenDAO;
import com.tmk.soa.dao.interfaces.PaginacionVidrieraDAO;
import com.tmk.soa.dao.interfaces.Socios2DAO;
import com.tmk.soa.dao.interfaces.SociosTMKDAO;

public final class DAOFactory {

	
	public static ArcashDAO getArcashDAO() {
		return new ArcashDaoImpl();
	}
	
	public static PaginacionVidrieraDAO getPaginacionVidrieraDAO() {
		return new PaginacionVidrieraDaoImpl();
	}
	
	public static DetalleDAO getDetalleDAO() {
		return new DetalleDaoJdbcImpl();
	}
	
	public static ArticuloDAO getArticuloDAO() {
		return new ArticuloDaoJdbcImpl();
	}
	
	public static Socios2DAO getSocios2DAO() {
		return new Socios2DaoJdbcImpl();
	}
	
	public static ComentarioArticuloDAO getComentarioArticuloDAO() {
		return new ComentarioArticuloDaoJdbcImpl();
	}
	
	public static OrdenDAO getOrdenDAO() {
		return new OrdenDaoDboImpl();
	}
	
	public static ListaDeDeseoDAO getListaDeDeseoDAO() {
		return new ListaDeDeseoDboImpl();
	}
	
	public static CarritoListaDeseosDAO getCarritoListaDeseosDAO() {
		return new CarritoListaDeseosDboImpl();
	}
	
	public static DboDAO getDboDAO() {
		return new DboDaoImpl();
	}
	
	public static SociosTMKDAO getSocioTMK2DAO() {
		return new SociosTmkDaoJdbcImpl();
	}
	
	public static BufferSocioDAO getBufferSocioDAO() {
		return new BufferSocioDaoDboImp();
	}
	
	public static CarritoCompraDAO getCarritoCompraDAO() {
		return new CarritoCompraDaoDboImpl();
	}
	
	public static ListasTmkDAO getListasTmkDAO () {
		return new ListasTmkDaoDboImp();
	}
}
