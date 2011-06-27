package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SociosDomicilios generated by hbm2java
 */
public class SociosDomicilios  implements java.io.Serializable {


     private SociosDomiciliosId id;
     private Socios2 socios2;
     private String calle;
     private Long numero;
     private String edificio;
     private Short piso;
     private String depto;
     private String cp;
     private int idLocalidad;
     private int idProvincia;
     private int idPais;
     private String comentarios;
     private Date FAlta;
     private String usrAlta;
     private Date FModi;
     private String usrModi;
     private String descripcionProvinciaInex;
     private String descripcionLocalidadInex;
     private Set direccionOrdens = new HashSet(0);
     private Set listaDeseoses = new HashSet(0);

    public SociosDomicilios() {
    }

	
    public SociosDomicilios(SociosDomiciliosId id, Socios2 socios2, String calle, int idLocalidad, int idProvincia, int idPais, Date FAlta, String usrAlta) {
        this.id = id;
        this.socios2 = socios2;
        this.calle = calle;
        this.idLocalidad = idLocalidad;
        this.idProvincia = idProvincia;
        this.idPais = idPais;
        this.FAlta = FAlta;
        this.usrAlta = usrAlta;
    }
    public SociosDomicilios(SociosDomiciliosId id, Socios2 socios2, String calle, Long numero, String edificio, Short piso, String depto, String cp, int idLocalidad, int idProvincia, int idPais, String comentarios, Date FAlta, String usrAlta, Date FModi, String usrModi, String descripcionProvinciaInex, String descripcionLocalidadInex, Set direccionOrdens, Set listaDeseoses) {
       this.id = id;
       this.socios2 = socios2;
       this.calle = calle;
       this.numero = numero;
       this.edificio = edificio;
       this.piso = piso;
       this.depto = depto;
       this.cp = cp;
       this.idLocalidad = idLocalidad;
       this.idProvincia = idProvincia;
       this.idPais = idPais;
       this.comentarios = comentarios;
       this.FAlta = FAlta;
       this.usrAlta = usrAlta;
       this.FModi = FModi;
       this.usrModi = usrModi;
       this.descripcionProvinciaInex = descripcionProvinciaInex;
       this.descripcionLocalidadInex = descripcionLocalidadInex;
       this.direccionOrdens = direccionOrdens;
       this.listaDeseoses = listaDeseoses;
    }
   
    public SociosDomiciliosId getId() {
        return this.id;
    }
    
    public void setId(SociosDomiciliosId id) {
        this.id = id;
    }
    public Socios2 getSocios2() {
        return this.socios2;
    }
    
    public void setSocios2(Socios2 socios2) {
        this.socios2 = socios2;
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
    public String getDescripcionProvinciaInex() {
        return this.descripcionProvinciaInex;
    }
    
    public void setDescripcionProvinciaInex(String descripcionProvinciaInex) {
        this.descripcionProvinciaInex = descripcionProvinciaInex;
    }
    public String getDescripcionLocalidadInex() {
        return this.descripcionLocalidadInex;
    }
    
    public void setDescripcionLocalidadInex(String descripcionLocalidadInex) {
        this.descripcionLocalidadInex = descripcionLocalidadInex;
    }
    public Set getDireccionOrdens() {
        return this.direccionOrdens;
    }
    
    public void setDireccionOrdens(Set direccionOrdens) {
        this.direccionOrdens = direccionOrdens;
    }
    public Set getListaDeseoses() {
        return this.listaDeseoses;
    }
    
    public void setListaDeseoses(Set listaDeseoses) {
        this.listaDeseoses = listaDeseoses;
    }




}


