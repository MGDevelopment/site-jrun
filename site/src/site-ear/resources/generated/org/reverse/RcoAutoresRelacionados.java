package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * RcoAutoresRelacionados generated by hbm2java
 */
public class RcoAutoresRelacionados  implements java.io.Serializable {


     private RcoAutoresRelacionadosId id;
     private Date fechaDesdeConteo;
     private Date fechaHastaConteo;
     private Date fechaExpiracion;
     private Date FAlta;
     private String usrAlta;
     private Date FModi;
     private String usrModi;
     private BigDecimal cantComprobantes;
     private BigDecimal idRelacion;
     private BigDecimal seqUpdnov1;

    public RcoAutoresRelacionados() {
    }

	
    public RcoAutoresRelacionados(RcoAutoresRelacionadosId id, Date FAlta, String usrAlta) {
        this.id = id;
        this.FAlta = FAlta;
        this.usrAlta = usrAlta;
    }
    public RcoAutoresRelacionados(RcoAutoresRelacionadosId id, Date fechaDesdeConteo, Date fechaHastaConteo, Date fechaExpiracion, Date FAlta, String usrAlta, Date FModi, String usrModi, BigDecimal cantComprobantes, BigDecimal idRelacion, BigDecimal seqUpdnov1) {
       this.id = id;
       this.fechaDesdeConteo = fechaDesdeConteo;
       this.fechaHastaConteo = fechaHastaConteo;
       this.fechaExpiracion = fechaExpiracion;
       this.FAlta = FAlta;
       this.usrAlta = usrAlta;
       this.FModi = FModi;
       this.usrModi = usrModi;
       this.cantComprobantes = cantComprobantes;
       this.idRelacion = idRelacion;
       this.seqUpdnov1 = seqUpdnov1;
    }
   
    public RcoAutoresRelacionadosId getId() {
        return this.id;
    }
    
    public void setId(RcoAutoresRelacionadosId id) {
        this.id = id;
    }
    public Date getFechaDesdeConteo() {
        return this.fechaDesdeConteo;
    }
    
    public void setFechaDesdeConteo(Date fechaDesdeConteo) {
        this.fechaDesdeConteo = fechaDesdeConteo;
    }
    public Date getFechaHastaConteo() {
        return this.fechaHastaConteo;
    }
    
    public void setFechaHastaConteo(Date fechaHastaConteo) {
        this.fechaHastaConteo = fechaHastaConteo;
    }
    public Date getFechaExpiracion() {
        return this.fechaExpiracion;
    }
    
    public void setFechaExpiracion(Date fechaExpiracion) {
        this.fechaExpiracion = fechaExpiracion;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }
    public BigDecimal getCantComprobantes() {
        return this.cantComprobantes;
    }
    
    public void setCantComprobantes(BigDecimal cantComprobantes) {
        this.cantComprobantes = cantComprobantes;
    }
    public BigDecimal getIdRelacion() {
        return this.idRelacion;
    }
    
    public void setIdRelacion(BigDecimal idRelacion) {
        this.idRelacion = idRelacion;
    }
    public BigDecimal getSeqUpdnov1() {
        return this.seqUpdnov1;
    }
    
    public void setSeqUpdnov1(BigDecimal seqUpdnov1) {
        this.seqUpdnov1 = seqUpdnov1;
    }




}


