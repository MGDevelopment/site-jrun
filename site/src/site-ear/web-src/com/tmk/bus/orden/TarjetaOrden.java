package com.tmk.bus.orden;

import com.tmk.bus.fk.TarjetaOrdenFK;
import com.tmk.dbo.DBO;
import com.tmk.util.ByteArrayWarpper;

public class TarjetaOrden extends DBO {

	private static final TarjetaOrdenFK cls_fk = TarjetaOrdenFK.getInstance();	
	
	private Integer id_orden;
	private String id_medio_cobro;
	private ByteArrayWarpper nro_tarjeta;
	private String nombre_cliente;
	private Integer codigo_respuesta;
	private Integer codigo_autorizacion;
	private String mensajes_gpay;
	private String tipo_doc;
	private Long nro_doc;
	private String direciccion_resumen;
	private ByteArrayWarpper p1;
	private ByteArrayWarpper p2;
	private ByteArrayWarpper p3;
	
	public TarjetaOrden() {	}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_medio_cobro = ").append(id_medio_cobro);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}

	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "TARJETA_ORDEN";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "TARORD";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden",getAlias()+"__id_medio_cobro"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	//FIN ESTATICOS

	public Integer getId_orden() {
		return id_orden;
	}

	public String getId_medio_cobro() {
		return id_medio_cobro;
	}

	public ByteArrayWarpper getNro_tarjeta() {
		return nro_tarjeta;
	}

	public String getNombre_cliente() {
		return nombre_cliente;
	}

	public Integer getCodigo_respuesta() {
		return codigo_respuesta;
	}

	public Integer getCodigo_autorizacion() {
		return codigo_autorizacion;
	}

	public String getMensajes_gpay() {
		return mensajes_gpay;
	}

	public String getTipo_doc() {
		return tipo_doc;
	}

	public Long getNro_doc() {
		return nro_doc;
	}

	public String getDireciccion_resumen() {
		return direciccion_resumen;
	}

	public ByteArrayWarpper getP1() {
		return p1;
	}

	public ByteArrayWarpper getP2() {
		return p2;
	}

	public ByteArrayWarpper getP3() {
		return p3;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public void setId_medio_cobro(String id_medio_cobro) {
		this.id_medio_cobro = id_medio_cobro;
	}

	public void setNro_tarjeta(ByteArrayWarpper nro_tarjeta) {
		this.nro_tarjeta = nro_tarjeta;
	}

	public void setNombre_cliente(String nombre_cliente) {
		this.nombre_cliente = nombre_cliente;
	}

	public void setCodigo_respuesta(Integer codigo_respuesta) {
		this.codigo_respuesta = codigo_respuesta;
	}

	public void setCodigo_autorizacion(Integer codigo_autorizacion) {
		this.codigo_autorizacion = codigo_autorizacion;
	}

	public void setMensajes_gpay(String mensajes_gpay) {
		this.mensajes_gpay = mensajes_gpay;
	}

	public void setTipo_doc(String tipo_doc) {
		this.tipo_doc = tipo_doc;
	}

	public void setNro_doc(Long nro_doc) {
		this.nro_doc = nro_doc;
	}

	public void setDireciccion_resumen(String direciccion_resumen) {
		this.direciccion_resumen = direciccion_resumen;
	}

	public void setP1(ByteArrayWarpper p1) {
		this.p1 = p1;
	}

	public void setP2(ByteArrayWarpper p2) {
		this.p2 = p2;
	}

	public void setP3(ByteArrayWarpper p3) {
		this.p3 = p3;
	}
	
	
}
