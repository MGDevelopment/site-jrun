package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * SucursalesPrueba generated by hbm2java
 */
public class SucursalesPrueba  implements java.io.Serializable {


     private short idSucursal;
     private String descripcion;
     private Date fechaApertura;
     private String abreviatura;
     private String deposito;
     private String direccion;
     private Integer idPais;
     private Integer idProvincia;
     private Integer idLocalidad;
     private String codigoPostal;
     private String telefono;
     private String fax;
     private String email;
     private String modem;
     private String contacto;
     private String observaciones;
     private String idEmpresa;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private Long idUsrAlta;
     private Long idUsrModi;
     private String mostrar;
     private String idRegion;
     private String codigoContable;
     private Date fechaUltTransmision;
     private Set snpFdnPuntosXSucursalsForIdSucursalCuenta = new HashSet(0);
     private Set bufferFdnCuentases = new HashSet(0);
     private Set fdnCuentases = new HashSet(0);
     private Set snpFdnPuntosXSucursalsForIdSucursal = new HashSet(0);

    public SucursalesPrueba() {
    }

	
    public SucursalesPrueba(short idSucursal, String descripcion, Date fechaApertura, String abreviatura, String deposito, String idEmpresa, String usrAlta, Date FAlta) {
        this.idSucursal = idSucursal;
        this.descripcion = descripcion;
        this.fechaApertura = fechaApertura;
        this.abreviatura = abreviatura;
        this.deposito = deposito;
        this.idEmpresa = idEmpresa;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SucursalesPrueba(short idSucursal, String descripcion, Date fechaApertura, String abreviatura, String deposito, String direccion, Integer idPais, Integer idProvincia, Integer idLocalidad, String codigoPostal, String telefono, String fax, String email, String modem, String contacto, String observaciones, String idEmpresa, String usrAlta, Date FAlta, String usrModi, Date FModi, Long idUsrAlta, Long idUsrModi, String mostrar, String idRegion, String codigoContable, Date fechaUltTransmision, Set snpFdnPuntosXSucursalsForIdSucursalCuenta, Set bufferFdnCuentases, Set fdnCuentases, Set snpFdnPuntosXSucursalsForIdSucursal) {
       this.idSucursal = idSucursal;
       this.descripcion = descripcion;
       this.fechaApertura = fechaApertura;
       this.abreviatura = abreviatura;
       this.deposito = deposito;
       this.direccion = direccion;
       this.idPais = idPais;
       this.idProvincia = idProvincia;
       this.idLocalidad = idLocalidad;
       this.codigoPostal = codigoPostal;
       this.telefono = telefono;
       this.fax = fax;
       this.email = email;
       this.modem = modem;
       this.contacto = contacto;
       this.observaciones = observaciones;
       this.idEmpresa = idEmpresa;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idUsrAlta = idUsrAlta;
       this.idUsrModi = idUsrModi;
       this.mostrar = mostrar;
       this.idRegion = idRegion;
       this.codigoContable = codigoContable;
       this.fechaUltTransmision = fechaUltTransmision;
       this.snpFdnPuntosXSucursalsForIdSucursalCuenta = snpFdnPuntosXSucursalsForIdSucursalCuenta;
       this.bufferFdnCuentases = bufferFdnCuentases;
       this.fdnCuentases = fdnCuentases;
       this.snpFdnPuntosXSucursalsForIdSucursal = snpFdnPuntosXSucursalsForIdSucursal;
    }
   
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public Date getFechaApertura() {
        return this.fechaApertura;
    }
    
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    public String getAbreviatura() {
        return this.abreviatura;
    }
    
    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }
    public String getDeposito() {
        return this.deposito;
    }
    
    public void setDeposito(String deposito) {
        this.deposito = deposito;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
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
    public String getModem() {
        return this.modem;
    }
    
    public void setModem(String modem) {
        this.modem = modem;
    }
    public String getContacto() {
        return this.contacto;
    }
    
    public void setContacto(String contacto) {
        this.contacto = contacto;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
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
    public String getMostrar() {
        return this.mostrar;
    }
    
    public void setMostrar(String mostrar) {
        this.mostrar = mostrar;
    }
    public String getIdRegion() {
        return this.idRegion;
    }
    
    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }
    public String getCodigoContable() {
        return this.codigoContable;
    }
    
    public void setCodigoContable(String codigoContable) {
        this.codigoContable = codigoContable;
    }
    public Date getFechaUltTransmision() {
        return this.fechaUltTransmision;
    }
    
    public void setFechaUltTransmision(Date fechaUltTransmision) {
        this.fechaUltTransmision = fechaUltTransmision;
    }
    public Set getSnpFdnPuntosXSucursalsForIdSucursalCuenta() {
        return this.snpFdnPuntosXSucursalsForIdSucursalCuenta;
    }
    
    public void setSnpFdnPuntosXSucursalsForIdSucursalCuenta(Set snpFdnPuntosXSucursalsForIdSucursalCuenta) {
        this.snpFdnPuntosXSucursalsForIdSucursalCuenta = snpFdnPuntosXSucursalsForIdSucursalCuenta;
    }
    public Set getBufferFdnCuentases() {
        return this.bufferFdnCuentases;
    }
    
    public void setBufferFdnCuentases(Set bufferFdnCuentases) {
        this.bufferFdnCuentases = bufferFdnCuentases;
    }
    public Set getFdnCuentases() {
        return this.fdnCuentases;
    }
    
    public void setFdnCuentases(Set fdnCuentases) {
        this.fdnCuentases = fdnCuentases;
    }
    public Set getSnpFdnPuntosXSucursalsForIdSucursal() {
        return this.snpFdnPuntosXSucursalsForIdSucursal;
    }
    
    public void setSnpFdnPuntosXSucursalsForIdSucursal(Set snpFdnPuntosXSucursalsForIdSucursal) {
        this.snpFdnPuntosXSucursalsForIdSucursal = snpFdnPuntosXSucursalsForIdSucursal;
    }




}


