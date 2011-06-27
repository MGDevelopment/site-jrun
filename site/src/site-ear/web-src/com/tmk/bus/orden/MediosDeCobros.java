package com.tmk.bus.orden;

import com.tmk.bus.fk.MediosDeCobroFK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.Globals;

public class MediosDeCobros extends DBO {

	private final static MediosDeCobroFK cls_fk = MediosDeCobroFK.getInstance();
	
	private String id_medio_cobro;
	private String descripcion;
	private String cuenta_mascara;
	private String tipo;
	private Integer id_concepto_diferencia;
	private String habilita;
	private String cierre;
	private String id_moneda;
	private String id_medio_externo;
	private String tipo_devolucion;
	private String auxvarchar01;
	private String auxvarchar02;
	private Integer auxnumber01;
	private Integer auxnumber02;
	private String  habilitado_tematika;
	
	public String getPK() {
		StringBuffer pk = new StringBuffer("");
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
		return "MEDIOS_DE_COBROS";
	}
	public static String getFiltro() {
		return null;
	}
	public static String getAlias() {
		return "MECO";
	}
	public static String getOrden() {
		return null;
	}
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__id_medio_cobro"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
	//FIN ESTATICOS

	public String getId_medio_cobro() {
		return id_medio_cobro;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getCuenta_mascara() {
		return cuenta_mascara;
	}

	public String getTipo() {
		return tipo;
	}

	public Integer getId_concepto_diferencia() {
		return id_concepto_diferencia;
	}

	public String getHabilita() {
		return habilita;
	}

	public String getCierre() {
		return cierre;
	}

	public String getId_moneda() {
		return id_moneda;
	}

	public String getId_medio_externo() {
		return id_medio_externo;
	}

	public String getTipo_devolucion() {
		return tipo_devolucion;
	}

	public String getAuxvarchar01() {
		return auxvarchar01;
	}

	public String getAuxvarchar02() {
		return auxvarchar02;
	}

	public Integer getAuxnumber01() {
		return auxnumber01;
	}

	public Integer getAuxnumber02() {
		return auxnumber02;
	}

	public String getHabilitado_tematika() {
		return habilitado_tematika;
	}

	public void setId_medio_cobro(String id_medio_cobro) {
		this.id_medio_cobro = id_medio_cobro;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setCuenta_mascara(String cuenta_mascara) {
		this.cuenta_mascara = cuenta_mascara;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setId_concepto_diferencia(Integer id_concepto_diferencia) {
		this.id_concepto_diferencia = id_concepto_diferencia;
	}

	public void setHabilita(String habilita) {
		this.habilita = habilita;
	}

	public void setCierre(String cierre) {
		this.cierre = cierre;
	}

	public void setId_moneda(String id_moneda) {
		this.id_moneda = id_moneda;
	}

	public void setId_medio_externo(String id_medio_externo) {
		this.id_medio_externo = id_medio_externo;
	}

	public void setTipo_devolucion(String tipo_devolucion) {
		this.tipo_devolucion = tipo_devolucion;
	}

	public void setAuxvarchar01(String auxvarchar01) {
		this.auxvarchar01 = auxvarchar01;
	}

	public void setAuxvarchar02(String auxvarchar02) {
		this.auxvarchar02 = auxvarchar02;
	}

	public void setAuxnumber01(Integer auxnumber01) {
		this.auxnumber01 = auxnumber01;
	}

	public void setAuxnumber02(Integer auxnumber02) {
		this.auxnumber02 = auxnumber02;
	}

	public void setHabilitado_tematika(String habilitado_tematika) {
		this.habilitado_tematika = habilitado_tematika;
	}
	
	public boolean esTarjeta(){
		return Globals.TIPO_MEDIO_DE_COBRO_TARJETAS.equalsIgnoreCase(id_medio_cobro);
	}
		
	public boolean esReembolso() {
		return Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO.equalsIgnoreCase(id_medio_cobro);
	}

	public boolean esFax() {
		return Globals.CLAVE_MEDIO_DE_COBRO_FAX.equalsIgnoreCase(id_medio_cobro);
	}

	public boolean esHomeBanking() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RIOHB.equalsIgnoreCase(id_medio_cobro);
	}

	public boolean esNetBanking() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RIONB.equalsIgnoreCase(id_medio_cobro);
	}

	
	public boolean esTarjetaPrePaga() {
		return Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA.equalsIgnoreCase(id_medio_cobro);
	}
	public boolean esValidableOnLine() {
		return esTarjeta() || esTarjetaPrePaga();
	}
	
	
	public boolean esRapiPago() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO.equalsIgnoreCase(id_medio_cobro);
	}

	public boolean esPagoFacil() {
		return Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL.equalsIgnoreCase(id_medio_cobro);
	}
	
	public boolean esDineroMail() {
		return Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL.equalsIgnoreCase(id_medio_cobro);
	}
	
	public boolean esArcash() {
		return Globals.CLAVE_MEDIO_DE_COBRO_ARCASH.equalsIgnoreCase(id_medio_cobro);
	}
	
	public boolean requiereCuponDePago() {
		return esRapiPago() || esPagoFacil();
	}
}
