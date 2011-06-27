package com.tmk.bus.orden;

import com.tmk.bus.fk.PagoOrdenFK;
import com.tmk.dbo.DBO;

public class PagoOrden extends DBO {
	private static final PagoOrdenFK cls_fk = PagoOrdenFK.getInstance(); 
	
	private Integer id_orden;
	private String id_medio_cobro;
	private Double importe;
	private Integer cuotas;
	private Integer coeficiente;
	private Integer moneda;
	private Integer cambio ;
	private MediosDeCobros mediosDeCobro;
	private TarjetaOrden tarjeta_orden;
	
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_orden = ").append(id_orden);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_medio_cobro = ").append(id_medio_cobro);
		return pk.toString();
	}

	public boolean tieneDBO() {
		return true;
	}
	
	/**
	 * Metodos estaticos
	*/
	public static String getTabla() {
		return "PAGO_ORDEN";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "PORD";
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

	public Double getImporte() {
		return importe;
	}

	public Integer getCuotas() {
		return cuotas;
	}

	public Integer getCoeficiente() {
		return coeficiente;
	}

	public Integer getMoneda() {
		return moneda;
	}

	public Integer getCambio() {
		return cambio;
	}

	public void setId_orden(Integer id_orden) {
		this.id_orden = id_orden;
	}

	public void setId_medio_cobro(String id_medio_cobro) {
		this.id_medio_cobro = id_medio_cobro;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}

	public void setCoeficiente(Integer coeficiente) {
		this.coeficiente = coeficiente;
	}

	public void setMoneda(Integer moneda) {
		this.moneda = moneda;
	}

	public void setCambio(Integer cambio) {
		this.cambio = cambio;
	}

	public MediosDeCobros getMediosDeCobro() {
		return mediosDeCobro;
	}

	public void setMediosDeCobro(MediosDeCobros mediosDeCobro) {
		this.mediosDeCobro = mediosDeCobro;
	}

	public TarjetaOrden getTarjeta_orden() {
		return tarjeta_orden;
	}

	public void setTarjeta_orden(TarjetaOrden tarjeta_orden) {
		this.tarjeta_orden = tarjeta_orden;
	}
	
	
}
