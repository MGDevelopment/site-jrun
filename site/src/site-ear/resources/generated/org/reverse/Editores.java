package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Editores generated by hbm2java
 */
public class Editores  implements java.io.Serializable {


     private long idEditor;
     private String nombre;
     private String razonSocial;
     private Date fechaAlta;
     private String direccion;
     private String codigoPostal;
     private String telefono;
     private String fax;
     private String email;
     private String cuit;
     private String observaciones;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private Long idUsrAlta;
     private Long idUsrModi;
     private Integer idPais;
     private Integer idProvincia;
     private Integer idLocalidad;
     private String url;
     private Set articulosesForIdCoeditor = new HashSet(0);
     private Set articulosesForIdEditor = new HashSet(0);

    public Editores() {
    }

	
    public Editores(long idEditor, String nombre, String razonSocial, Date fechaAlta, String usrAlta, Date FAlta) {
        this.idEditor = idEditor;
        this.nombre = nombre;
        this.razonSocial = razonSocial;
        this.fechaAlta = fechaAlta;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public Editores(long idEditor, String nombre, String razonSocial, Date fechaAlta, String direccion, String codigoPostal, String telefono, String fax, String email, String cuit, String observaciones, String usrAlta, Date FAlta, String usrModi, Date FModi, Long idUsrAlta, Long idUsrModi, Integer idPais, Integer idProvincia, Integer idLocalidad, String url, Set articulosesForIdCoeditor, Set articulosesForIdEditor) {
       this.idEditor = idEditor;
       this.nombre = nombre;
       this.razonSocial = razonSocial;
       this.fechaAlta = fechaAlta;
       this.direccion = direccion;
       this.codigoPostal = codigoPostal;
       this.telefono = telefono;
       this.fax = fax;
       this.email = email;
       this.cuit = cuit;
       this.observaciones = observaciones;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idUsrAlta = idUsrAlta;
       this.idUsrModi = idUsrModi;
       this.idPais = idPais;
       this.idProvincia = idProvincia;
       this.idLocalidad = idLocalidad;
       this.url = url;
       this.articulosesForIdCoeditor = articulosesForIdCoeditor;
       this.articulosesForIdEditor = articulosesForIdEditor;
    }
   
    public long getIdEditor() {
        return this.idEditor;
    }
    
    public void setIdEditor(long idEditor) {
        this.idEditor = idEditor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
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
    public Long getIdUsrAlta() {
        return this.idUsrAlta;
    }
    
    public void setIdUsrAlta(Long idUsrAlta) {
        this.idUsrAlta = idUsrAlta;
    }
    public Long getIdUsrModi() {
        return this.idUsrModi;
    }
    
    public void setIdUsrModi(Long idUsrModi) {
        this.idUsrModi = idUsrModi;
    }
    public Integer getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }
    public Integer getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(Integer idProvincia) {
        this.idProvincia = idProvincia;
    }
    public Integer getIdLocalidad() {
        return this.idLocalidad;
    }
    
    public void setIdLocalidad(Integer idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Set getArticulosesForIdCoeditor() {
        return this.articulosesForIdCoeditor;
    }
    
    public void setArticulosesForIdCoeditor(Set articulosesForIdCoeditor) {
        this.articulosesForIdCoeditor = articulosesForIdCoeditor;
    }
    public Set getArticulosesForIdEditor() {
        return this.articulosesForIdEditor;
    }
    
    public void setArticulosesForIdEditor(Set articulosesForIdEditor) {
        this.articulosesForIdEditor = articulosesForIdEditor;
    }




}


