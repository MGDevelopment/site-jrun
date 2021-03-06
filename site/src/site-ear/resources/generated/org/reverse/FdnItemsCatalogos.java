package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * FdnItemsCatalogos generated by hbm2java
 */
public class FdnItemsCatalogos  implements java.io.Serializable {


     private FdnItemsCatalogosId id;
     private FdnCatalogos fdnCatalogos;
     private int puntos;
     private BigDecimal importeAdicional;
     private Date fechaVigencia;
     private String habilitado;
     private Date habilitadoFecha;
     private String habilitadoUsr;
     private String hastaStkCero;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private String muestraTmk;

    public FdnItemsCatalogos() {
    }

	
    public FdnItemsCatalogos(FdnItemsCatalogosId id, FdnCatalogos fdnCatalogos, int puntos, BigDecimal importeAdicional, Date fechaVigencia, String habilitado, String hastaStkCero, String usrAlta, Date FAlta, String muestraTmk) {
        this.id = id;
        this.fdnCatalogos = fdnCatalogos;
        this.puntos = puntos;
        this.importeAdicional = importeAdicional;
        this.fechaVigencia = fechaVigencia;
        this.habilitado = habilitado;
        this.hastaStkCero = hastaStkCero;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.muestraTmk = muestraTmk;
    }
    public FdnItemsCatalogos(FdnItemsCatalogosId id, FdnCatalogos fdnCatalogos, int puntos, BigDecimal importeAdicional, Date fechaVigencia, String habilitado, Date habilitadoFecha, String habilitadoUsr, String hastaStkCero, String usrAlta, Date FAlta, String usrModi, Date FModi, String muestraTmk) {
       this.id = id;
       this.fdnCatalogos = fdnCatalogos;
       this.puntos = puntos;
       this.importeAdicional = importeAdicional;
       this.fechaVigencia = fechaVigencia;
       this.habilitado = habilitado;
       this.habilitadoFecha = habilitadoFecha;
       this.habilitadoUsr = habilitadoUsr;
       this.hastaStkCero = hastaStkCero;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.muestraTmk = muestraTmk;
    }
   
    public FdnItemsCatalogosId getId() {
        return this.id;
    }
    
    public void setId(FdnItemsCatalogosId id) {
        this.id = id;
    }
    public FdnCatalogos getFdnCatalogos() {
        return this.fdnCatalogos;
    }
    
    public void setFdnCatalogos(FdnCatalogos fdnCatalogos) {
        this.fdnCatalogos = fdnCatalogos;
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
    public Date getFechaVigencia() {
        return this.fechaVigencia;
    }
    
    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
    public String getHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
    public Date getHabilitadoFecha() {
        return this.habilitadoFecha;
    }
    
    public void setHabilitadoFecha(Date habilitadoFecha) {
        this.habilitadoFecha = habilitadoFecha;
    }
    public String getHabilitadoUsr() {
        return this.habilitadoUsr;
    }
    
    public void setHabilitadoUsr(String habilitadoUsr) {
        this.habilitadoUsr = habilitadoUsr;
    }
    public String getHastaStkCero() {
        return this.hastaStkCero;
    }
    
    public void setHastaStkCero(String hastaStkCero) {
        this.hastaStkCero = hastaStkCero;
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
    public String getMuestraTmk() {
        return this.muestraTmk;
    }
    
    public void setMuestraTmk(String muestraTmk) {
        this.muestraTmk = muestraTmk;
    }




}


