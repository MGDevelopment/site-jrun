package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * AlianzaTelefono generated by hbm2java
 */
public class AlianzaTelefono  implements java.io.Serializable {


     private AlianzaTelefonoId id;
     private String codArea;
     private String nroTel;
     private String extInt;
     private Date FAlta;
     private Date FModi;

    public AlianzaTelefono() {
    }

	
    public AlianzaTelefono(AlianzaTelefonoId id, String nroTel) {
        this.id = id;
        this.nroTel = nroTel;
    }
    public AlianzaTelefono(AlianzaTelefonoId id, String codArea, String nroTel, String extInt, Date FAlta, Date FModi) {
       this.id = id;
       this.codArea = codArea;
       this.nroTel = nroTel;
       this.extInt = extInt;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public AlianzaTelefonoId getId() {
        return this.id;
    }
    
    public void setId(AlianzaTelefonoId id) {
        this.id = id;
    }
    public String getCodArea() {
        return this.codArea;
    }
    
    public void setCodArea(String codArea) {
        this.codArea = codArea;
    }
    public String getNroTel() {
        return this.nroTel;
    }
    
    public void setNroTel(String nroTel) {
        this.nroTel = nroTel;
    }
    public String getExtInt() {
        return this.extInt;
    }
    
    public void setExtInt(String extInt) {
        this.extInt = extInt;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }




}


