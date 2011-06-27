package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * ParametrosBup generated by hbm2java
 */
public class ParametrosBup  implements java.io.Serializable {


     private String idParametro;
     private String descripcion;
     private String caracter;
     private BigDecimal numero;
     private Date fecha;
     private String observaciones;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public ParametrosBup() {
    }

	
    public ParametrosBup(String idParametro, String descripcion, String usrAlta, Date FAlta) {
        this.idParametro = idParametro;
        this.descripcion = descripcion;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public ParametrosBup(String idParametro, String descripcion, String caracter, BigDecimal numero, Date fecha, String observaciones, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idParametro = idParametro;
       this.descripcion = descripcion;
       this.caracter = caracter;
       this.numero = numero;
       this.fecha = fecha;
       this.observaciones = observaciones;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public String getIdParametro() {
        return this.idParametro;
    }
    
    public void setIdParametro(String idParametro) {
        this.idParametro = idParametro;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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


