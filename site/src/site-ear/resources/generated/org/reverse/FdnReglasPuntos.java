package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * FdnReglasPuntos generated by hbm2java
 */
public class FdnReglasPuntos  implements java.io.Serializable {


     private FdnReglasPuntosId id;
     private FdnReglas fdnReglas;
     private BigDecimal desde;
     private BigDecimal hasta;
     private BigDecimal importe;
     private Integer puntos;
     private Byte multiplicador;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public FdnReglasPuntos() {
    }

	
    public FdnReglasPuntos(FdnReglasPuntosId id, FdnReglas fdnReglas, BigDecimal desde, String usrAlta, Date FAlta) {
        this.id = id;
        this.fdnReglas = fdnReglas;
        this.desde = desde;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public FdnReglasPuntos(FdnReglasPuntosId id, FdnReglas fdnReglas, BigDecimal desde, BigDecimal hasta, BigDecimal importe, Integer puntos, Byte multiplicador, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.id = id;
       this.fdnReglas = fdnReglas;
       this.desde = desde;
       this.hasta = hasta;
       this.importe = importe;
       this.puntos = puntos;
       this.multiplicador = multiplicador;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public FdnReglasPuntosId getId() {
        return this.id;
    }
    
    public void setId(FdnReglasPuntosId id) {
        this.id = id;
    }
    public FdnReglas getFdnReglas() {
        return this.fdnReglas;
    }
    
    public void setFdnReglas(FdnReglas fdnReglas) {
        this.fdnReglas = fdnReglas;
    }
    public BigDecimal getDesde() {
        return this.desde;
    }
    
    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }
    public BigDecimal getHasta() {
        return this.hasta;
    }
    
    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }
    public BigDecimal getImporte() {
        return this.importe;
    }
    
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public Byte getMultiplicador() {
        return this.multiplicador;
    }
    
    public void setMultiplicador(Byte multiplicador) {
        this.multiplicador = multiplicador;
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




}


