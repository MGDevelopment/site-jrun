package com.tmk.soa.servicios;

import com.tmk.soa.servicios.implementation.ArcashServiceImpl;
import com.tmk.soa.servicios.implementation.ArticuloServiceImpl;
import com.tmk.soa.servicios.implementation.BufferSocioServiceImpl;
import com.tmk.soa.servicios.implementation.BuscadorServiceImp;
import com.tmk.soa.servicios.implementation.CarritoCompraServiceImpl;
import com.tmk.soa.servicios.implementation.CarritoListaDeseosServiceImpl;
import com.tmk.soa.servicios.implementation.ComentarioServiceImp;
import com.tmk.soa.servicios.implementation.CuponServiceImpl;
import com.tmk.soa.servicios.implementation.DboServiceImpl;
import com.tmk.soa.servicios.implementation.DetalleServiceImp;
import com.tmk.soa.servicios.implementation.DineroMailServiceImpl;
import com.tmk.soa.servicios.implementation.ExtraServiceImpl;
import com.tmk.soa.servicios.implementation.ListaDeDeseosServiceImpl;
import com.tmk.soa.servicios.implementation.ListasTmkServiceImpl;
import com.tmk.soa.servicios.implementation.ModeloBuilderServiceImp;
import com.tmk.soa.servicios.implementation.OrdenServiceImpl;
import com.tmk.soa.servicios.implementation.Socio2ServiceImpl;
import com.tmk.soa.servicios.implementation.SocioDomiciliosServiceImpl;
import com.tmk.soa.servicios.implementation.SociosTmkServiceImpl;
import com.tmk.soa.servicios.implementation.TemplateServiceImpl;
import com.tmk.soa.servicios.interfaces.ArcashService;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.soa.servicios.interfaces.BufferSocioService;
import com.tmk.soa.servicios.interfaces.BuscadorService;
import com.tmk.soa.servicios.interfaces.CarritoCompraService;
import com.tmk.soa.servicios.interfaces.CarritoListaDeseosService;
import com.tmk.soa.servicios.interfaces.ComentarioService;
import com.tmk.soa.servicios.interfaces.CuponService;
import com.tmk.soa.servicios.interfaces.DboService;
import com.tmk.soa.servicios.interfaces.DetalleService;
import com.tmk.soa.servicios.interfaces.DineroMailService;
import com.tmk.soa.servicios.interfaces.ExtraService;
import com.tmk.soa.servicios.interfaces.ListaDeDeseosService;
import com.tmk.soa.servicios.interfaces.ListasTmkServices;
import com.tmk.soa.servicios.interfaces.ModeloBuilderServices;
import com.tmk.soa.servicios.interfaces.OrdenService;
import com.tmk.soa.servicios.interfaces.Socio2Service;
import com.tmk.soa.servicios.interfaces.SocioDomiciliosService;
import com.tmk.soa.servicios.interfaces.SociosTMKService;
import com.tmk.soa.servicios.interfaces.TemplateService;

public class ServiceLocator {
	
	private ServiceLocator(){
		
	}
	/**
	 * servicio que encapsula toda la funcionalidad requerida para arcash.
	 * @return
	 */
	public static ArcashService getArcashService() {
		return new ArcashServiceImpl();
	}
	/**
	 * administra todo lo relaciona a un socio
	 * @return
	 */
	public static Socio2Service getSocioService() {
		return new Socio2ServiceImpl();
	}
	
	/***
	 * Administra lo regerente  a detalle de articulos
	 * @return
	 */
	public static DetalleService getDetalleArticuloService() {
		return new DetalleServiceImp();
	}
	
	public static ArticuloService getArticuloService() {
		return new ArticuloServiceImpl();
	}
	
	/*public static ArticuloService getDatosPrincipal() {
		return new ArticuloServiceImpl();
	}*/
	
	public static TemplateService getTemplateService() {
		return new TemplateServiceImpl();
	}
	
	public static ComentarioService getComentarioService() {
		return new ComentarioServiceImp();
	}
	
	public static OrdenService getOrdenService() {
		return new OrdenServiceImpl();
	}
	/**
	 * servicio que encapsula toda la funcionalidad requerida para dm.
	 * @return
	 */
	public static DineroMailService getDineroMailService() {
		return new DineroMailServiceImpl();
	}
	
	/**
	 * Servicio relacionado a las listas de deseo
	 */
	public static ListaDeDeseosService getListaDeDeseosService() {
		return new ListaDeDeseosServiceImpl();
	}
	/**
	 * Servicio relacionado al carrito lista deseo(CarritoListaDeseosDAO)
	 */
	public static CarritoListaDeseosService getCarritoListaDeseosService() {
		return new CarritoListaDeseosServiceImpl();
	}
	
	/**
	 * Servicio para administrar las acciones sobre un dbo(insert,select,update,delete)
	 * @return
	 */
	public static DboService getDboService() {
		return new DboServiceImpl();
	}
	
	/**
	 * administra todo lo relaciona a un socio_tmk
	 * @return
	 */
	public static SociosTMKService getSociosTMKService() {
		return new SociosTmkServiceImpl();
	}
	
	/**
	 * administra todo lo relaciona a un buffer_socio
	 * @return
	 */
	public static BufferSocioService getBufferSocioService() {
		return new BufferSocioServiceImpl();
	}
	
	/**
	 * administra todo lo relaciona a un buffer_socio
	 * @return
	 */
	public static CarritoCompraService getCarritoCompraService() {
		return new CarritoCompraServiceImpl();
	}
	
	/**
	 * Servicio encargado de administrar los cupones y cheques virtuales.
	 * @return
	 */
	public static CuponService getCuponService() {
		return new CuponServiceImpl();
	}
	
	public static BuscadorService getBuscadorServices() {
		return new BuscadorServiceImp();
	}
	
	public static ExtraService getExtraService() {
		return new ExtraServiceImpl();
	}
	
	public static ListasTmkServices getListasTmkServices() {
		return new ListasTmkServiceImpl();
	}
	
	public static ModeloBuilderServices getModeloBuilderService(){
		return new ModeloBuilderServiceImp();
	}
	
	public static SocioDomiciliosService getSocioDomiciliosService() {
		return new SocioDomiciliosServiceImpl();
	}
}


