package com.tmk.bus.orden;

import java.lang.reflect.Field;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import com.tmk.bus.fk.OrdenFK;
import com.tmk.bus.socio.Socios2;
import com.tmk.dbo.DBO;
import com.tmk.dbo.sql.RelacionCamposInsertDBO;
import com.tmk.kernel.Convert;


public class Orden extends DBO {
	private static final OrdenFK cls_fk = OrdenFK.getInstance(); 
	private	Integer id_orden; 
	private	Timestamp fecha; 
	private Double neto;
	private Double total;
	private String telefono;
	private String hr_contacto;
	private String comentarios;
	private String motivo_riesgo;    
	/*private Integer ID_ALIANZA;
	private Integer ID_SECCION;*/
	//private Integer ID_DOMINIO; 
	private Integer id_orden_motivo_riesgo;
	private String nombres_receptor;    
	private String apellidos_receptor;
	private String cupon;
	private String cpf_cnpj;
	private Integer nro_doc_receptort;
	private String tipo_doc_receptort;
	private String rango_horario_receptor;
	private Timestamp fac_elc_env;
	
	//DBO
	private AlianzaSeccion alianza_seccion;
	private DominioSite dominio_site;
	private EstadoOrden estado;
	private Socios2 socio;
	private CuponDePago cupon_pago;
	private NivelDeRiesgo nivel_riesgo;
	private ItemOrden[] item_orden;
	private DireccionOrden[] direccion_orden;
	//private PagoOrden[] pago_orden;
	private PagoOrden pago_orden;
	
	public Orden() {}
	
	public Orden(Integer idOrden) {
		this.id_orden = idOrden;
	}
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return true;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "ORDEN";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "ORD";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_orden"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	//FIN ESTATICOS
	
	public Integer getId_orden() {
		return id_orden;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public Double getNeto() {
		return neto;
	}

	public Double getTotal() {
		return total;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getHr_contacto() {
		return hr_contacto;
	}

	public String getComentarios() {
		return comentarios;
	}

	public String getMotivo_riesgo() {
		return motivo_riesgo;
	}

	public Integer getId_orden_motivo_riesgo() {
		return id_orden_motivo_riesgo;
	}

	public String getNombres_receptor() {
		return nombres_receptor;
	}

	public String getApellidos_receptor() {
		return apellidos_receptor;
	}

	public String getCupon() {
		return cupon;
	}

	public String getCpf_cnpj() {
		return cpf_cnpj;
	}

	public Integer getNro_doc_receptort() {
		return nro_doc_receptort;
	}

	public String getTipo_doc_receptort() {
		return tipo_doc_receptort;
	}

	public String getRango_horario_receptor() {
		return rango_horario_receptor;
	}

	public Timestamp getFac_elc_env() {
		return fac_elc_env;
	}

	public EstadoOrden getEstado() {
		return estado;
	}

	public Socios2 getSocio() {
		return socio;
	}

	public NivelDeRiesgo getNivel_riesgo() {
		return nivel_riesgo;
	}

	public ItemOrden[] getItem_orden() {
		return item_orden;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public void setNeto(Double neto) {
		this.neto = neto;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setHr_contacto(String hr_contacto) {
		this.hr_contacto = hr_contacto;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public void setMotivo_riesgo(String motivo_riesgo) {
		this.motivo_riesgo = motivo_riesgo;
	}

	public void setId_orden_motivo_riesgo(Integer id_orden_motivo_riesgo) {
		this.id_orden_motivo_riesgo = id_orden_motivo_riesgo;
	}

	public void setNombres_receptor(String nombres_receptor) {
		this.nombres_receptor = nombres_receptor;
	}

	public void setApellidos_receptor(String apellidos_receptor) {
		this.apellidos_receptor = apellidos_receptor;
	}

	public void setCupon(String cupon) {
		this.cupon = cupon;
	}

	public void setCpf_cnpj(String cpf_cnpj) {
		this.cpf_cnpj = cpf_cnpj;
	}

	public void setNro_doc_receptort(Integer nro_doc_receptort) {
		this.nro_doc_receptort = nro_doc_receptort;
	}

	public void setTipo_doc_receptort(String tipo_doc_receptort) {
		this.tipo_doc_receptort = tipo_doc_receptort;
	}

	public void setRango_horario_receptor(String rango_horario_receptor) {
		this.rango_horario_receptor = rango_horario_receptor;
	}

	public void setFac_elc_env(Timestamp fac_elc_env) {
		this.fac_elc_env = fac_elc_env;
	}

	public void setEstado(EstadoOrden estado) {
		this.estado = estado;
	}

	public void setSocio(Socios2 socio) {
		this.socio = socio;
	}

	public void setNivel_riesgo(NivelDeRiesgo nivel_riesgo) {
		this.nivel_riesgo = nivel_riesgo;
	}

	public void setItem_orden(ItemOrden[] item_orden) {
		this.item_orden = item_orden;
	}

	public DireccionOrden[] getDireccion_orden() {
		return direccion_orden;
	}

	public void setDireccion_orden(DireccionOrden[] direccion_orden) {
		this.direccion_orden = direccion_orden;
	}

	public CuponDePago getCupon_pago() {
		return cupon_pago;
	}

	public void setCupon_pago(CuponDePago cupon_pago) {
		this.cupon_pago = cupon_pago;
	}

	public PagoOrden getPago_orden() {
		return pago_orden;
	}

	public void setPago_orden(PagoOrden pago_orden) {
		this.pago_orden = pago_orden;
	}

	public AlianzaSeccion getAlianza_seccion() {
		return alianza_seccion;
	}

	public void setAlianza_seccion(AlianzaSeccion alianza_seccion) {
		this.alianza_seccion = alianza_seccion;
	}

	public DominioSite getDominio_site() {
		return dominio_site;
	}

	public void setDominio_site(DominioSite dominio_site) {
		this.dominio_site = dominio_site;
	}	
	
	/**
	 * Asigna a cada articulo el papel de regalo
	 */
	public void asignarPapelesDeRegalo(){
		for(int i=0;i<this.item_orden.length;i++) {
			if(this.item_orden[i].getId_papel_regalo()!=null) {//es un articulo comun
				for(int j=0;j<this.item_orden.length;j++ ){
					if(this.item_orden[i].getId_papel_regalo().equals(this.item_orden[j].getId_articulo()) &&
							this.item_orden[i].getCantidad().equals(this.item_orden[j].getCantidad())) {
						this.item_orden[i].setPapelDeRegalo(this.item_orden[j]);
						break;
					}
				}
			}
		}
	}
	/**
	 * Asigna a cada articulo el gasto de envio que le corresponde
	 */
	public void asignarGastosDeEnvio(){
		boolean[] seAsocio = new boolean [this.item_orden.length];
		
		for(int i=0;i<item_orden.length;i++) {
			if(item_orden[i].getArticulo().esGastoDeEnvio()) {//gastos
				for(int j=0;j<item_orden.length;j++ ){//productos
					if(item_orden[j].getCantidad().equals(item_orden[i].getCantidad()) && 
							!item_orden[j].getArticulo().esGastoDeEnvio() &&
							!item_orden[j].getArticulo().esPapelDeRegalo() &&
							!seAsocio[i] && !seAsocio[j])  {
						item_orden[j].setGastoDeEnvio(item_orden[i]);
						seAsocio[i]=true;
						seAsocio[j]=true;
						break;
					}
				}
			}
		}
	}
	
	/**
	 * Metodo trasladado del OrdenDAO.java.
	 * Caluclo el total dee gasto de envio. 
	 * @return
	 */
	public double totalGastoDeEnvio() {
		double total = 0.0;
		for (int i=0; i<this.item_orden.length; i++) {
			if (item_orden[i].getGastoDeEnvio() != null) {
				total = total + item_orden[i].getGastoDeEnvio().getPrecio_promocion() 
				* item_orden[i].getGastoDeEnvio().getCantidad();
			}
		}
		return Convert.round(total);
	}
	/**
	 * Obtiene la direccion de facturacion de las dos que puede ternes una orden.
	 * Solo busca en el array de direccion_orden y se fija cual es la asignada como facturacion
	 * @return
	 */
	public DireccionOrden getDomicilioFacturacion () {
		for(int i=0;i<this.direccion_orden.length;i++) {
			if(this.direccion_orden[i].getTipo_domicilio().indexOf("TF")>=0){
				return this.direccion_orden[i];
			}
		}
		return null;
	}
		
}
