package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SociosRefCodesBup generated by hbm2java
 */
public class SociosRefCodesBup  implements java.io.Serializable {


     private SociosRefCodesBupId id;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private String caracter;
     private BigDecimal numero;
     private Date fecha;

    public SociosRefCodesBup() {
    }

	
    public SociosRefCodesBup(SociosRefCodesBupId id, String usrAlta, Date FAlta) {
        this.id = id;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SociosRefCodesBup(SociosRefCodesBupId id, String usrAlta, Date FAlta, String usrModi, Date FModi, String caracter, BigDecimal numero, Date fecha) {
       this.id = id;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.caracter = caracter;
       this.numero = numero;
       this.fecha = fecha;
    }
   
    public SociosRefCodesBupId getId() {
        return this.id;
    }
    
    public void setId(SociosRefCodesBupId id) {
        this.id = id;
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
    public String getCaracter() {
        return this.caracter;
    }
    
    public void setCaracter(String caracter) {
        this.caracter = caracter;
    }
    public BigDecimal getNumero() {
        return this.numero;
    }
    
    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }




}


