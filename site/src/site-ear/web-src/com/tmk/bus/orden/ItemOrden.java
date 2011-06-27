package com.tmk.bus.orden;

import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.fk.ItemOrdenFK;
import com.tmk.dbo.DBO;

public class ItemOrden extends DBO {

	private static final ItemOrdenFK cls_fk = ItemOrdenFK.getInstance(); 
	private Integer id_orden;
	private Integer id_articulo;
	private Integer item;
	private Integer cantidad;
	private Double precio_original;
	private Integer id_papel_regalo;
	private Double precio_descuento;
	private Double precio_promocion;
	private Double id_lista_pvp;	
	private Integer id_promocion; 
	//cuando arma la consulta da error si se usa el primer campo, agregue el segundo y es al que se accede con gets y set.
	private Double precio_promocion_sin_impuestos;
	private Double precio_promocion_sin_impue;
	private Double precio_unitario;
	//private Integer id_articulo_mol;//? 
	private Integer id_promocion2; 
	private Integer id_promocion3; 
	private Integer id_promocion4; 
	private Integer id_promocion5; 
	private Integer id_campaign;
	
	//DBO
	private EstadoItemOrden estado_item_orden;
	private ItemOrdenImpuesto item_orden_impuesto;
	private Orden orden;
	private Articulo articulo;
	private ItemOrden cls_papelDeRegalo;
	private ItemOrden cls_gastoDeEnvio;
	private NotaRegalo nota_regalo;
	
	public ItemOrden() { }
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_articulo = ").append(id_articulo);
		pk.append(" and ");
		pk.append(getAlias()).append(".item = ").append(item);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return true;
	}

	/**
	 * Metodos estaticos
	 */
	public static String getTabla() {
		return "ITEM_ORDEN";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "IE";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden",getAlias()+"__id_articulo",getAlias()+"__item"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}

	public Integer getId_orden() {
		return id_orden;
	}

	public Integer getId_articulo() {
		return id_articulo;
	}

	public Integer getItem() {
		return item;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecio_original() {
		return precio_original;
	}

	public Integer getId_papel_regalo() {
		return id_papel_regalo;
	}

	public Double getPrecio_descuento() {
		return precio_descuento;
	}

	public Double getPrecio_promocion() {
		return precio_promocion;
	}

	public Double getId_lista_pvp() {
		return id_lista_pvp;
	}

	public EstadoItemOrden getEstadoItemOrden() {
		return estado_item_orden;
	}

	public Integer getId_promocion() {
		return id_promocion;
	}

	public Double getPrecio_promocion_sin_impuestos() {
		return precio_promocion_sin_impue;
	}

	public Integer getId_promocion2() {
		return id_promocion2;
	}

	public Integer getId_promocion3() {
		return id_promocion3;
	}

	public Integer getId_promocion4() {
		return id_promocion4;
	}

	public Integer getId_promocion5() {
		return id_promocion5;
	}

	public Integer getId_campaign() {
		return id_campaign;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public void setId_articulo(Integer id_articulo) {
		this.id_articulo = id_articulo;
	}

	public void setItem(Integer item) {
		this.item = item;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public void setPrecio_original(Double precio_original) {
		this.precio_original = precio_original;
	}

	public void setId_papel_regalo(Integer id_papel_regalo) {
		this.id_papel_regalo = id_papel_regalo;
	}

	public void setPrecio_descuento(Double precio_descuento) {
		this.precio_descuento = precio_descuento;
	}

	public void setPrecio_promocion(Double precio_promocion) {
		this.precio_promocion = precio_promocion;
	}

	public void setId_lista_pvp(Double id_lista_pvp) {
		this.id_lista_pvp = id_lista_pvp;
	}

	public void setEstadoItemOrden(EstadoItemOrden estadoItemOrden) {
		this.estado_item_orden = estadoItemOrden;
	}

	public void setId_promocion(Integer id_promocion) {
		this.id_promocion = id_promocion;
	}

	public void setPrecio_promocion_sin_impuestos(
			Double precio_promocion_sin_impuestos) {
		this.precio_promocion_sin_impue = precio_promocion_sin_impuestos;
	}

	public void setId_promocion2(Integer id_promocion2) {
		this.id_promocion2 = id_promocion2;
	}

	public void setId_promocion3(Integer id_promocion3) {
		this.id_promocion3 = id_promocion3;
	}

	public void setId_promocion4(Integer id_promocion4) {
		this.id_promocion4 = id_promocion4;
	}

	public void setId_promocion5(Integer id_promocion5) {
		this.id_promocion5 = id_promocion5;
	}

	public void setId_campaign(Integer id_campaign) {
		this.id_campaign = id_campaign;
	}

	public EstadoItemOrden getEstado_item_orden() {
		return estado_item_orden;
	}

	public Articulo getArticulo() {
		return articulo;
	}

	public void setEstado_item_orden(EstadoItemOrden estado_item_orden) {
		this.estado_item_orden = estado_item_orden;
	}

	public void setOrden(Orden orden) {
		this.orden = orden;
	}

	public Orden getOrdenItem() {
		return this.orden;
	}
	
	public void setArticulo(Articulo articulo) {
		this.articulo = articulo;
	}
	/**
	 * En la vieja OrdenDAO es el precioConImpuesto
	 * @return
	 */
	public Double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(Double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public ItemOrdenImpuesto getItem_orden_impuesto() {
		return item_orden_impuesto;
	}

	public void setItem_orden_impuesto(ItemOrdenImpuesto item_orden_impuesto) {
		this.item_orden_impuesto = item_orden_impuesto;
	}

	public NotaRegalo getNota_regalo() {
		return nota_regalo;
	}

	public void setNota_regalo(NotaRegalo nota_regalo) {
		this.nota_regalo = nota_regalo;
	}

	public ItemOrden getPapelDeRegalo() {
		return cls_papelDeRegalo;
	}

	public void setPapelDeRegalo(ItemOrden papelDeRegalo) {
		this.cls_papelDeRegalo = papelDeRegalo;
	}

	public ItemOrden getGastoDeEnvio() {
		return cls_gastoDeEnvio;
	}

	public void setGastoDeEnvio(ItemOrden gastoDeEnvio) {
		this.cls_gastoDeEnvio = gastoDeEnvio;
	}
	
}
