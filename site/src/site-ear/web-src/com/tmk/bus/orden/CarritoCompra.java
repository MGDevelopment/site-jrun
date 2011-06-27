package com.tmk.bus.orden;

import java.sql.Timestamp;

import com.tmk.bus.fk.CarritoCompraFK;
import com.tmk.dbo.DBO;
import com.tmk.src.socio.CarritoCompraPK;

public class CarritoCompra extends DBO {
	private static final CarritoCompraFK cls_fk = CarritoCompraFK.getInstance();
	
	private Integer id_sucursal_socio;
	private Integer id_socio;
	private Integer id_articulo;
	private Integer cantidad;
	private Timestamp fecha;
		
	public CarritoCompra() {}
	
	public CarritoCompra(CarritoCompraPK carritoCompraPk) {
		this.id_sucursal_socio = carritoCompraPk.ID_SUCURSAL_SOCIO;
		this.id_socio = carritoCompraPk.ID_SOCIO;
		this.id_articulo = carritoCompraPk.ID_ARTICULO;
	}

	public String getPK() {
		StringBuffer pk= new StringBuffer("");
		pk.append(getAlias()).append(".id_sucursal_socio = ").append(id_sucursal_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "CARRITO_COMPRA";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "CARCOM";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_sucursal_socio",
				getAlias()+"__id_socio",
				getAlias()+"__id_articulo"};
	}	
	public static String[][] getFK(String fk) {
		return cls_fk.get(fk);
	}	
	//FIN ESTATICOS

	public Integer getId_sucursal_socio() {
		return id_sucursal_socio;
	}

	public Integer getId_socio() {
		return id_socio;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setId_sucursal_socio(Integer id_sucursal_socio) {
		this.id_sucursal_socio = id_sucursal_socio;
	}

	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	
}
