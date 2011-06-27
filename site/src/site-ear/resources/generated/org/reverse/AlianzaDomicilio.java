package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * AlianzaDomicilio generated by hbm2java
 */
public class AlianzaDomicilio  implements java.io.Serializable {


     private AlianzaDomicilioId id;
     private String calle;
     private Long numero;
     private String edificio;
     private Short piso;
     private String depto;
     private String cp;
     private int idLocalidad;
     private int idProvincia;
     private int idPais;
     private Date FAlta;
     private Date FModi;

    public AlianzaDomicilio() {
    }

	
    public AlianzaDomicilio(AlianzaDomicilioId id, String calle, int idLocalidad, int idProvincia, int idPais) {
        this.id = id;
        this.calle = calle;
        this.idLocalidad = idLocalidad;
        this.idProvincia = idProvincia;
        this.idPais = idPais;
    }
    public AlianzaDomicilio(AlianzaDomicilioId id, String calle, Long numero, String edificio, Short piso, String depto, String cp, int idLocalidad, int idProvincia, int idPais, Date FAlta, Date FModi) {
       this.id = id;
       this.calle = calle;
       this.numero = numero;
       this.edificio = edificio;
       this.piso = piso;
       this.depto = depto;
       this.cp = cp;
       this.idLocalidad = idLocalidad;
       this.idProvincia = idProvincia;
       this.idPais = idPais;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public AlianzaDomicilioId getId() {
        return this.id;
    }
    
    public void setId(AlianzaDomicilioId id) {
        this.id = id;
    }
    public String getCalle() {
        return this.calle;
    }
    
    public void setCalle(String calle) {
        this.calle = calle;
    }
    public Long getNumero() {
        return this.numero;
    }
    
    public void setNumero(Long numero) {
        this.numero = numero;
    }
    public String getEdificio() {
        return this.edificio;
    }
    
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
    public Short getPiso() {
        return this.piso;
    }
    
    public void setPiso(Short piso) {
        this.piso = piso;
    }
    public String getDepto() {
        return this.depto;
    }
    
    public void setDepto(String depto) {
        this.depto = depto;
    }
    public String getCp() {
        return this.cp;
    }
    
    public void setCp(String cp) {
        this.cp = cp;
    }
    public int getIdLocalidad() {
        return this.idLocalidad;
    }
    
    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    public int getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
    public int getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(int idPais) {
        this.idPais = idPais;
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


