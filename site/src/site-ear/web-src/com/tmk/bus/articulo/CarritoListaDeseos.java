package com.tmk.bus.articulo;

import com.tmk.bus.fk.CarritoListaDeseosFK;
import com.tmk.dbo.DBO;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;

public class CarritoListaDeseos extends DBO {

	private static final CarritoListaDeseosFK cls_fk = CarritoListaDeseosFK.getInstance();
	
	private Integer id_articulo;
	private Integer id_sucursal_socio_comprador;
	private Integer id_socio_comprador;
	private Integer estado;
	private Integer id_sucursal_socio;
	private Integer id_socio;
	
	//DBO
	private ListaDeseos listaDeseos;
	private Articulo[] articulo;
	
	public CarritoListaDeseos() {
		
	}
	public CarritoListaDeseos(CarritoListaDeseosPK pk) {
		this.id_articulo = pk.ID_ARTICULO;
		this.id_sucursal_socio = pk.ID_SUCURSAL_SOCIO;
		this.id_socio = pk.ID_SOCIO;		
	}
	
	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_sucursal_socio = ").append(id_sucursal_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		return pk.toString();
	}
	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_articulo",
							getAlias()+"__id_sucursal_socio",
							getAlias()+"__id_socio"};
	}

	public static String getAlias() {
		return "C";
	}
	
	public static String getTabla() {
		return "CARRITO_LISTA_DESEOS";
	}

	public boolean tieneDBO() {
		return true;
	}
	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	
	public static String getOrden() {
		return null;
	}

	public static String getFiltro() {
		return null;
	}
	
	public Integer getId_sucursal_socio() {
		return id_sucursal_socio;
	}

	public Integer getId_socio() {
		return id_socio;
	}

	public void setId_sucursal_socio(Integer id_sucursal_socio) {
		this.id_sucursal_socio = id_sucursal_socio;
	}

	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Integer getId_sucursal_socio_comprador() {
		return id_sucursal_socio_comprador;
	}

	public Integer getId_socio_comprador() {
		return id_socio_comprador;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public void setId_sucursal_socio_comprador(Integer id_sucursal_socio_comprador) {
		this.id_sucursal_socio_comprador = id_sucursal_socio_comprador;
	}

	public void setId_socio_comprador(Integer id_socio_comprador) {
		this.id_socio_comprador = id_socio_comprador;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public ListaDeseos getListaDeseos() {
		return listaDeseos;
	}
	public void setListaDeseos(ListaDeseos listaDeseos) {
		this.listaDeseos = listaDeseos;
	}
	public Articulo[] getArticulo() {
		return articulo;
	}
	public void setArticulo(Articulo[] articulo) {
		this.articulo = articulo;
	}	
	
	
}
