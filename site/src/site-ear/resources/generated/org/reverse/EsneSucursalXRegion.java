package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * EsneSucursalXRegion generated by hbm2java
 */
public class EsneSucursalXRegion  implements java.io.Serializable {


     private EsneSucursalXRegionId id;
     private String habilitado;
     private String cuentaMascara;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public EsneSucursalXRegion() {
    }

	
    public EsneSucursalXRegion(EsneSucursalXRegionId id, String habilitado, String usrAlta, Date FAlta) {
        this.id = id;
        this.habilitado = habilitado;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public EsneSucursalXRegion(EsneSucursalXRegionId id, String habilitado, String cuentaMascara, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.id = id;
       this.habilitado = habilitado;
       this.cuentaMascara = cuentaMascara;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public EsneSucursalXRegionId getId() {
        return this.id;
    }
    
    public void setId(EsneSucursalXRegionId id) {
        this.id = id;
    }
    public String getHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
    public String getCuentaMascara() {
        return this.cuentaMascara;
    }
    
    public void setCuentaMascara(String cuentaMascara) {
        this.cuentaMascara = cuentaMascara;
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


