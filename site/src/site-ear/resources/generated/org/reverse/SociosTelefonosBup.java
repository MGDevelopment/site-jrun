package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SociosTelefonosBup generated by hbm2java
 */
public class SociosTelefonosBup  implements java.io.Serializable {


     private SociosTelefonosBupId id;
     private Socios2Bup socios2Bup;
     private String codArea;
     private String nroTel;
     private String extInt;
     private String comentarios;
     private Date FAlta;
     private String usrAlta;
     private Date FModi;
     private String usrModi;

    public SociosTelefonosBup() {
    }

	
    public SociosTelefonosBup(SociosTelefonosBupId id, Socios2Bup socios2Bup, String codArea, String nroTel, Date FAlta, String usrAlta) {
        this.id = id;
        this.socios2Bup = socios2Bup;
        this.codArea = codArea;
        this.nroTel = nroTel;
        this.FAlta = FAlta;
        this.usrAlta = usrAlta;
    }
    public SociosTelefonosBup(SociosTelefonosBupId id, Socios2Bup socios2Bup, String codArea, String nroTel, String extInt, String comentarios, Date FAlta, String usrAlta, Date FModi, String usrModi) {
       this.id = id;
       this.socios2Bup = socios2Bup;
       this.codArea = codArea;
       this.nroTel = nroTel;
       this.extInt = extInt;
       this.comentarios = comentarios;
       this.FAlta = FAlta;
       this.usrAlta = usrAlta;
       this.FModi = FModi;
       this.usrModi = usrModi;
    }
   
    public SociosTelefonosBupId getId() {
        return this.id;
    }
    
    public void setId(SociosTelefonosBupId id) {
        this.id = id;
    }
    public Socios2Bup getSocios2Bup() {
        return this.socios2Bup;
    }
    
    public void setSocios2Bup(Socios2Bup socios2Bup) {
        this.socios2Bup = socios2Bup;
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
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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




}


