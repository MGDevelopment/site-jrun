package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * FdnCtaCtePuntos generated by hbm2java
 */
public class FdnCtaCtePuntos  implements java.io.Serializable {


     private FdnCtaCtePuntosId id;
     private String cecoNiv01;
     private String cecoNiv02;
     private String cecoNiv03;
     private String cecoNiv04;
     private String cecoNiv05;
     private String msecNiv01;
     private String msecNiv02;
     private String msecNiv03;
     private String msecNiv04;
     private String msecNiv05;
     private Long idSocio;
     private Short idSucursalSocio;
     private long idCuenta;
     private short idSucursalCuenta;
     private String nroTarjeta;
     private short idConcepto;
     private Long idRegla;
     private Long idMovimiento;
     private Short idSucursalMovimiento;
     private Integer item;
     private int puntos;
     private BigDecimal importeAdicional;
     private Date fechaTransmision;
     private Long idCuentaRela;
     private Short idSucursalCuentaRela;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private Date fecha;
     private int saldoXAplicar;
     private boolean signoSaldo;

    public FdnCtaCtePuntos() {
    }

	
    public FdnCtaCtePuntos(FdnCtaCtePuntosId id, long idCuenta, short idSucursalCuenta, short idConcepto, int puntos, String usrAlta, Date FAlta, Date fecha, int saldoXAplicar, boolean signoSaldo) {
        this.id = id;
        this.idCuenta = idCuenta;
        this.idSucursalCuenta = idSucursalCuenta;
        this.idConcepto = idConcepto;
        this.puntos = puntos;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.fecha = fecha;
        this.saldoXAplicar = saldoXAplicar;
        this.signoSaldo = signoSaldo;
    }
    public FdnCtaCtePuntos(FdnCtaCtePuntosId id, String cecoNiv01, String cecoNiv02, String cecoNiv03, String cecoNiv04, String cecoNiv05, String msecNiv01, String msecNiv02, String msecNiv03, String msecNiv04, String msecNiv05, Long idSocio, Short idSucursalSocio, long idCuenta, short idSucursalCuenta, String nroTarjeta, short idConcepto, Long idRegla, Long idMovimiento, Short idSucursalMovimiento, Integer item, int puntos, BigDecimal importeAdicional, Date fechaTransmision, Long idCuentaRela, Short idSucursalCuentaRela, String usrAlta, Date FAlta, String usrModi, Date FModi, Date fecha, int saldoXAplicar, boolean signoSaldo) {
       this.id = id;
       this.cecoNiv01 = cecoNiv01;
       this.cecoNiv02 = cecoNiv02;
       this.cecoNiv03 = cecoNiv03;
       this.cecoNiv04 = cecoNiv04;
       this.cecoNiv05 = cecoNiv05;
       this.msecNiv01 = msecNiv01;
       this.msecNiv02 = msecNiv02;
       this.msecNiv03 = msecNiv03;
       this.msecNiv04 = msecNiv04;
       this.msecNiv05 = msecNiv05;
       this.idSocio = idSocio;
       this.idSucursalSocio = idSucursalSocio;
       this.idCuenta = idCuenta;
       this.idSucursalCuenta = idSucursalCuenta;
       this.nroTarjeta = nroTarjeta;
       this.idConcepto = idConcepto;
       this.idRegla = idRegla;
       this.idMovimiento = idMovimiento;
       this.idSucursalMovimiento = idSucursalMovimiento;
       this.item = item;
       this.puntos = puntos;
       this.importeAdicional = importeAdicional;
       this.fechaTransmision = fechaTransmision;
       this.idCuentaRela = idCuentaRela;
       this.idSucursalCuentaRela = idSucursalCuentaRela;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.fecha = fecha;
       this.saldoXAplicar = saldoXAplicar;
       this.signoSaldo = signoSaldo;
    }
   
    public FdnCtaCtePuntosId getId() {
        return this.id;
    }
    
    public void setId(FdnCtaCtePuntosId id) {
        this.id = id;
    }
    public String getCecoNiv01() {
        return this.cecoNiv01;
    }
    
    public void setCecoNiv01(String cecoNiv01) {
        this.cecoNiv01 = cecoNiv01;
    }
    public String getCecoNiv02() {
        return this.cecoNiv02;
    }
    
    public void setCecoNiv02(String cecoNiv02) {
        this.cecoNiv02 = cecoNiv02;
    }
    public String getCecoNiv03() {
        return this.cecoNiv03;
    }
    
    public void setCecoNiv03(String cecoNiv03) {
        this.cecoNiv03 = cecoNiv03;
    }
    public String getCecoNiv04() {
        return this.cecoNiv04;
    }
    
    public void setCecoNiv04(String cecoNiv04) {
        this.cecoNiv04 = cecoNiv04;
    }
    public String getCecoNiv05() {
        return this.cecoNiv05;
    }
    
    public void setCecoNiv05(String cecoNiv05) {
        this.cecoNiv05 = cecoNiv05;
    }
    public String getMsecNiv01() {
        return this.msecNiv01;
    }
    
    public void setMsecNiv01(String msecNiv01) {
        this.msecNiv01 = msecNiv01;
    }
    public String getMsecNiv02() {
        return this.msecNiv02;
    }
    
    public void setMsecNiv02(String msecNiv02) {
        this.msecNiv02 = msecNiv02;
    }
    public String getMsecNiv03() {
        return this.msecNiv03;
    }
    
    public void setMsecNiv03(String msecNiv03) {
        this.msecNiv03 = msecNiv03;
    }
    public String getMsecNiv04() {
        return this.msecNiv04;
    }
    
    public void setMsecNiv04(String msecNiv04) {
        this.msecNiv04 = msecNiv04;
    }
    public String getMsecNiv05() {
        return this.msecNiv05;
    }
    
    public void setMsecNiv05(String msecNiv05) {
        this.msecNiv05 = msecNiv05;
    }
    public Long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
    public Short getIdSucursalSocio() {
        return this.idSucursalSocio;
    }
    
    public void setIdSucursalSocio(Short idSucursalSocio) {
        this.idSucursalSocio = idSucursalSocio;
    }
    public long getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public short getIdSucursalCuenta() {
        return this.idSucursalCuenta;
    }
    
    public void setIdSucursalCuenta(short idSucursalCuenta) {
        this.idSucursalCuenta = idSucursalCuenta;
    }
    public String getNroTarjeta() {
        return this.nroTarjeta;
    }
    
    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }
    public short getIdConcepto() {
        return this.idConcepto;
    }
    
    public void setIdConcepto(short idConcepto) {
        this.idConcepto = idConcepto;
    }
    public Long getIdRegla() {
        return this.idRegla;
    }
    
    public void setIdRegla(Long idRegla) {
        this.idRegla = idRegla;
    }
    public Long getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Short getIdSucursalMovimiento() {
        return this.idSucursalMovimiento;
    }
    
    public void setIdSucursalMovimiento(Short idSucursalMovimiento) {
        this.idSucursalMovimiento = idSucursalMovimiento;
    }
    public Integer getItem() {
        return this.item;
    }
    
    public void setItem(Integer item) {
        this.item = item;
    }
    public int getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public BigDecimal getImporteAdicional() {
        return this.importeAdicional;
    }
    
    public void setImporteAdicional(BigDecimal importeAdicional) {
        this.importeAdicional = importeAdicional;
    }
    public Date getFechaTransmision() {
        return this.fechaTransmision;
    }
    
    public void setFechaTransmision(Date fechaTransmision) {
        this.fechaTransmision = fechaTransmision;
    }
    public Long getIdCuentaRela() {
        return this.idCuentaRela;
    }
    
    public void setIdCuentaRela(Long idCuentaRela) {
        this.idCuentaRela = idCuentaRela;
    }
    public Short getIdSucursalCuentaRela() {
        return this.idSucursalCuentaRela;
    }
    
    public void setIdSucursalCuentaRela(Short idSucursalCuentaRela) {
        this.idSucursalCuentaRela = idSucursalCuentaRela;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int getSaldoXAplicar() {
        return this.saldoXAplicar;
    }
    
    public void setSaldoXAplicar(int saldoXAplicar) {
        this.saldoXAplicar = saldoXAplicar;
    }
    public boolean isSignoSaldo() {
        return this.signoSaldo;
    }
    
    public void setSignoSaldo(boolean signoSaldo) {
        this.signoSaldo = signoSaldo;
    }




}


