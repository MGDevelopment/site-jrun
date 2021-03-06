package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpSucursales5Id generated by hbm2java
 */
public class SnpSucursales5Id  implements java.io.Serializable {


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
     private String comisiona;
     private String garantiaExtendida;
     private String categoriaSucursal;
     private Byte idMarca;
     private BigDecimal superficie;
     private Date fechaBaja;
     private String foto;
     private String horarios;
     private String productos;
     private String grupoBenchmark;
     private String tieneBar;
     private String celular;
     private String tieneWifi;
     private String auxvarchar1;
     private String auxvarchar2;
     private String auxvarchar3;
     private BigDecimal auxnumber1;
     private BigDecimal auxnumber2;
     private BigDecimal auxnumber3;
     private String auxflag1;
     private String auxflag2;
     private String auxflag3;

    public SnpSucursales5Id() {
    }

	
    public SnpSucursales5Id(short idSucursal, String descripcion, Date fechaApertura, String abreviatura, String deposito, String idEmpresa, String usrAlta, Date FAlta, String idRegion) {
        this.idSucursal = idSucursal;
        this.descripcion = descripcion;
        this.fechaApertura = fechaApertura;
        this.abreviatura = abreviatura;
        this.deposito = deposito;
        this.idEmpresa = idEmpresa;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.idRegion = idRegion;
    }
    public SnpSucursales5Id(short idSucursal, String descripcion, Date fechaApertura, String abreviatura, String deposito, String direccion, Integer idPais, Integer idProvincia, Integer idLocalidad, String codigoPostal, String telefono, String fax, String email, String modem, String contacto, String observaciones, String idEmpresa, String usrAlta, Date FAlta, String usrModi, Date FModi, Long idUsrAlta, Long idUsrModi, String mostrar, String idRegion, String codigoContable, Date fechaUltTransmision, String comisiona, String garantiaExtendida, String categoriaSucursal, Byte idMarca, BigDecimal superficie, Date fechaBaja, String foto, String horarios, String productos, String grupoBenchmark, String tieneBar, String celular, String tieneWifi, String auxvarchar1, String auxvarchar2, String auxvarchar3, BigDecimal auxnumber1, BigDecimal auxnumber2, BigDecimal auxnumber3, String auxflag1, String auxflag2, String auxflag3) {
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
       this.comisiona = comisiona;
       this.garantiaExtendida = garantiaExtendida;
       this.categoriaSucursal = categoriaSucursal;
       this.idMarca = idMarca;
       this.superficie = superficie;
       this.fechaBaja = fechaBaja;
       this.foto = foto;
       this.horarios = horarios;
       this.productos = productos;
       this.grupoBenchmark = grupoBenchmark;
       this.tieneBar = tieneBar;
       this.celular = celular;
       this.tieneWifi = tieneWifi;
       this.auxvarchar1 = auxvarchar1;
       this.auxvarchar2 = auxvarchar2;
       this.auxvarchar3 = auxvarchar3;
       this.auxnumber1 = auxnumber1;
       this.auxnumber2 = auxnumber2;
       this.auxnumber3 = auxnumber3;
       this.auxflag1 = auxflag1;
       this.auxflag2 = auxflag2;
       this.auxflag3 = auxflag3;
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
    public String getComisiona() {
        return this.comisiona;
    }
    
    public void setComisiona(String comisiona) {
        this.comisiona = comisiona;
    }
    public String getGarantiaExtendida() {
        return this.garantiaExtendida;
    }
    
    public void setGarantiaExtendida(String garantiaExtendida) {
        this.garantiaExtendida = garantiaExtendida;
    }
    public String getCategoriaSucursal() {
        return this.categoriaSucursal;
    }
    
    public void setCategoriaSucursal(String categoriaSucursal) {
        this.categoriaSucursal = categoriaSucursal;
    }
    public Byte getIdMarca() {
        return this.idMarca;
    }
    
    public void setIdMarca(Byte idMarca) {
        this.idMarca = idMarca;
    }
    public BigDecimal getSuperficie() {
        return this.superficie;
    }
    
    public void setSuperficie(BigDecimal superficie) {
        this.superficie = superficie;
    }
    public Date getFechaBaja() {
        return this.fechaBaja;
    }
    
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public String getFoto() {
        return this.foto;
    }
    
    public void setFoto(String foto) {
        this.foto = foto;
    }
    public String getHorarios() {
        return this.horarios;
    }
    
    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }
    public String getProductos() {
        return this.productos;
    }
    
    public void setProductos(String productos) {
        this.productos = productos;
    }
    public String getGrupoBenchmark() {
        return this.grupoBenchmark;
    }
    
    public void setGrupoBenchmark(String grupoBenchmark) {
        this.grupoBenchmark = grupoBenchmark;
    }
    public String getTieneBar() {
        return this.tieneBar;
    }
    
    public void setTieneBar(String tieneBar) {
        this.tieneBar = tieneBar;
    }
    public String getCelular() {
        return this.celular;
    }
    
    public void setCelular(String celular) {
        this.celular = celular;
    }
    public String getTieneWifi() {
        return this.tieneWifi;
    }
    
    public void setTieneWifi(String tieneWifi) {
        this.tieneWifi = tieneWifi;
    }
    public String getAuxvarchar1() {
        return this.auxvarchar1;
    }
    
    public void setAuxvarchar1(String auxvarchar1) {
        this.auxvarchar1 = auxvarchar1;
    }
    public String getAuxvarchar2() {
        return this.auxvarchar2;
    }
    
    public void setAuxvarchar2(String auxvarchar2) {
        this.auxvarchar2 = auxvarchar2;
    }
    public String getAuxvarchar3() {
        return this.auxvarchar3;
    }
    
    public void setAuxvarchar3(String auxvarchar3) {
        this.auxvarchar3 = auxvarchar3;
    }
    public BigDecimal getAuxnumber1() {
        return this.auxnumber1;
    }
    
    public void setAuxnumber1(BigDecimal auxnumber1) {
        this.auxnumber1 = auxnumber1;
    }
    public BigDecimal getAuxnumber2() {
        return this.auxnumber2;
    }
    
    public void setAuxnumber2(BigDecimal auxnumber2) {
        this.auxnumber2 = auxnumber2;
    }
    public BigDecimal getAuxnumber3() {
        return this.auxnumber3;
    }
    
    public void setAuxnumber3(BigDecimal auxnumber3) {
        this.auxnumber3 = auxnumber3;
    }
    public String getAuxflag1() {
        return this.auxflag1;
    }
    
    public void setAuxflag1(String auxflag1) {
        this.auxflag1 = auxflag1;
    }
    public String getAuxflag2() {
        return this.auxflag2;
    }
    
    public void setAuxflag2(String auxflag2) {
        this.auxflag2 = auxflag2;
    }
    public String getAuxflag3() {
        return this.auxflag3;
    }
    
    public void setAuxflag3(String auxflag3) {
        this.auxflag3 = auxflag3;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpSucursales5Id) ) return false;
		 SnpSucursales5Id castOther = ( SnpSucursales5Id ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && ( (this.getDescripcion()==castOther.getDescripcion()) || ( this.getDescripcion()!=null && castOther.getDescripcion()!=null && this.getDescripcion().equals(castOther.getDescripcion()) ) )
 && ( (this.getFechaApertura()==castOther.getFechaApertura()) || ( this.getFechaApertura()!=null && castOther.getFechaApertura()!=null && this.getFechaApertura().equals(castOther.getFechaApertura()) ) )
 && ( (this.getAbreviatura()==castOther.getAbreviatura()) || ( this.getAbreviatura()!=null && castOther.getAbreviatura()!=null && this.getAbreviatura().equals(castOther.getAbreviatura()) ) )
 && ( (this.getDeposito()==castOther.getDeposito()) || ( this.getDeposito()!=null && castOther.getDeposito()!=null && this.getDeposito().equals(castOther.getDeposito()) ) )
 && ( (this.getDireccion()==castOther.getDireccion()) || ( this.getDireccion()!=null && castOther.getDireccion()!=null && this.getDireccion().equals(castOther.getDireccion()) ) )
 && ( (this.getIdPais()==castOther.getIdPais()) || ( this.getIdPais()!=null && castOther.getIdPais()!=null && this.getIdPais().equals(castOther.getIdPais()) ) )
 && ( (this.getIdProvincia()==castOther.getIdProvincia()) || ( this.getIdProvincia()!=null && castOther.getIdProvincia()!=null && this.getIdProvincia().equals(castOther.getIdProvincia()) ) )
 && ( (this.getIdLocalidad()==castOther.getIdLocalidad()) || ( this.getIdLocalidad()!=null && castOther.getIdLocalidad()!=null && this.getIdLocalidad().equals(castOther.getIdLocalidad()) ) )
 && ( (this.getCodigoPostal()==castOther.getCodigoPostal()) || ( this.getCodigoPostal()!=null && castOther.getCodigoPostal()!=null && this.getCodigoPostal().equals(castOther.getCodigoPostal()) ) )
 && ( (this.getTelefono()==castOther.getTelefono()) || ( this.getTelefono()!=null && castOther.getTelefono()!=null && this.getTelefono().equals(castOther.getTelefono()) ) )
 && ( (this.getFax()==castOther.getFax()) || ( this.getFax()!=null && castOther.getFax()!=null && this.getFax().equals(castOther.getFax()) ) )
 && ( (this.getEmail()==castOther.getEmail()) || ( this.getEmail()!=null && castOther.getEmail()!=null && this.getEmail().equals(castOther.getEmail()) ) )
 && ( (this.getModem()==castOther.getModem()) || ( this.getModem()!=null && castOther.getModem()!=null && this.getModem().equals(castOther.getModem()) ) )
 && ( (this.getContacto()==castOther.getContacto()) || ( this.getContacto()!=null && castOther.getContacto()!=null && this.getContacto().equals(castOther.getContacto()) ) )
 && ( (this.getObservaciones()==castOther.getObservaciones()) || ( this.getObservaciones()!=null && castOther.getObservaciones()!=null && this.getObservaciones().equals(castOther.getObservaciones()) ) )
 && ( (this.getIdEmpresa()==castOther.getIdEmpresa()) || ( this.getIdEmpresa()!=null && castOther.getIdEmpresa()!=null && this.getIdEmpresa().equals(castOther.getIdEmpresa()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getIdUsrAlta()==castOther.getIdUsrAlta()) || ( this.getIdUsrAlta()!=null && castOther.getIdUsrAlta()!=null && this.getIdUsrAlta().equals(castOther.getIdUsrAlta()) ) )
 && ( (this.getIdUsrModi()==castOther.getIdUsrModi()) || ( this.getIdUsrModi()!=null && castOther.getIdUsrModi()!=null && this.getIdUsrModi().equals(castOther.getIdUsrModi()) ) )
 && ( (this.getMostrar()==castOther.getMostrar()) || ( this.getMostrar()!=null && castOther.getMostrar()!=null && this.getMostrar().equals(castOther.getMostrar()) ) )
 && ( (this.getIdRegion()==castOther.getIdRegion()) || ( this.getIdRegion()!=null && castOther.getIdRegion()!=null && this.getIdRegion().equals(castOther.getIdRegion()) ) )
 && ( (this.getCodigoContable()==castOther.getCodigoContable()) || ( this.getCodigoContable()!=null && castOther.getCodigoContable()!=null && this.getCodigoContable().equals(castOther.getCodigoContable()) ) )
 && ( (this.getFechaUltTransmision()==castOther.getFechaUltTransmision()) || ( this.getFechaUltTransmision()!=null && castOther.getFechaUltTransmision()!=null && this.getFechaUltTransmision().equals(castOther.getFechaUltTransmision()) ) )
 && ( (this.getComisiona()==castOther.getComisiona()) || ( this.getComisiona()!=null && castOther.getComisiona()!=null && this.getComisiona().equals(castOther.getComisiona()) ) )
 && ( (this.getGarantiaExtendida()==castOther.getGarantiaExtendida()) || ( this.getGarantiaExtendida()!=null && castOther.getGarantiaExtendida()!=null && this.getGarantiaExtendida().equals(castOther.getGarantiaExtendida()) ) )
 && ( (this.getCategoriaSucursal()==castOther.getCategoriaSucursal()) || ( this.getCategoriaSucursal()!=null && castOther.getCategoriaSucursal()!=null && this.getCategoriaSucursal().equals(castOther.getCategoriaSucursal()) ) )
 && ( (this.getIdMarca()==castOther.getIdMarca()) || ( this.getIdMarca()!=null && castOther.getIdMarca()!=null && this.getIdMarca().equals(castOther.getIdMarca()) ) )
 && ( (this.getSuperficie()==castOther.getSuperficie()) || ( this.getSuperficie()!=null && castOther.getSuperficie()!=null && this.getSuperficie().equals(castOther.getSuperficie()) ) )
 && ( (this.getFechaBaja()==castOther.getFechaBaja()) || ( this.getFechaBaja()!=null && castOther.getFechaBaja()!=null && this.getFechaBaja().equals(castOther.getFechaBaja()) ) )
 && ( (this.getFoto()==castOther.getFoto()) || ( this.getFoto()!=null && castOther.getFoto()!=null && this.getFoto().equals(castOther.getFoto()) ) )
 && ( (this.getHorarios()==castOther.getHorarios()) || ( this.getHorarios()!=null && castOther.getHorarios()!=null && this.getHorarios().equals(castOther.getHorarios()) ) )
 && ( (this.getProductos()==castOther.getProductos()) || ( this.getProductos()!=null && castOther.getProductos()!=null && this.getProductos().equals(castOther.getProductos()) ) )
 && ( (this.getGrupoBenchmark()==castOther.getGrupoBenchmark()) || ( this.getGrupoBenchmark()!=null && castOther.getGrupoBenchmark()!=null && this.getGrupoBenchmark().equals(castOther.getGrupoBenchmark()) ) )
 && ( (this.getTieneBar()==castOther.getTieneBar()) || ( this.getTieneBar()!=null && castOther.getTieneBar()!=null && this.getTieneBar().equals(castOther.getTieneBar()) ) )
 && ( (this.getCelular()==castOther.getCelular()) || ( this.getCelular()!=null && castOther.getCelular()!=null && this.getCelular().equals(castOther.getCelular()) ) )
 && ( (this.getTieneWifi()==castOther.getTieneWifi()) || ( this.getTieneWifi()!=null && castOther.getTieneWifi()!=null && this.getTieneWifi().equals(castOther.getTieneWifi()) ) )
 && ( (this.getAuxvarchar1()==castOther.getAuxvarchar1()) || ( this.getAuxvarchar1()!=null && castOther.getAuxvarchar1()!=null && this.getAuxvarchar1().equals(castOther.getAuxvarchar1()) ) )
 && ( (this.getAuxvarchar2()==castOther.getAuxvarchar2()) || ( this.getAuxvarchar2()!=null && castOther.getAuxvarchar2()!=null && this.getAuxvarchar2().equals(castOther.getAuxvarchar2()) ) )
 && ( (this.getAuxvarchar3()==castOther.getAuxvarchar3()) || ( this.getAuxvarchar3()!=null && castOther.getAuxvarchar3()!=null && this.getAuxvarchar3().equals(castOther.getAuxvarchar3()) ) )
 && ( (this.getAuxnumber1()==castOther.getAuxnumber1()) || ( this.getAuxnumber1()!=null && castOther.getAuxnumber1()!=null && this.getAuxnumber1().equals(castOther.getAuxnumber1()) ) )
 && ( (this.getAuxnumber2()==castOther.getAuxnumber2()) || ( this.getAuxnumber2()!=null && castOther.getAuxnumber2()!=null && this.getAuxnumber2().equals(castOther.getAuxnumber2()) ) )
 && ( (this.getAuxnumber3()==castOther.getAuxnumber3()) || ( this.getAuxnumber3()!=null && castOther.getAuxnumber3()!=null && this.getAuxnumber3().equals(castOther.getAuxnumber3()) ) )
 && ( (this.getAuxflag1()==castOther.getAuxflag1()) || ( this.getAuxflag1()!=null && castOther.getAuxflag1()!=null && this.getAuxflag1().equals(castOther.getAuxflag1()) ) )
 && ( (this.getAuxflag2()==castOther.getAuxflag2()) || ( this.getAuxflag2()!=null && castOther.getAuxflag2()!=null && this.getAuxflag2().equals(castOther.getAuxflag2()) ) )
 && ( (this.getAuxflag3()==castOther.getAuxflag3()) || ( this.getAuxflag3()!=null && castOther.getAuxflag3()!=null && this.getAuxflag3().equals(castOther.getAuxflag3()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + ( getDescripcion() == null ? 0 : this.getDescripcion().hashCode() );
         result = 37 * result + ( getFechaApertura() == null ? 0 : this.getFechaApertura().hashCode() );
         result = 37 * result + ( getAbreviatura() == null ? 0 : this.getAbreviatura().hashCode() );
         result = 37 * result + ( getDeposito() == null ? 0 : this.getDeposito().hashCode() );
         result = 37 * result + ( getDireccion() == null ? 0 : this.getDireccion().hashCode() );
         result = 37 * result + ( getIdPais() == null ? 0 : this.getIdPais().hashCode() );
         result = 37 * result + ( getIdProvincia() == null ? 0 : this.getIdProvincia().hashCode() );
         result = 37 * result + ( getIdLocalidad() == null ? 0 : this.getIdLocalidad().hashCode() );
         result = 37 * result + ( getCodigoPostal() == null ? 0 : this.getCodigoPostal().hashCode() );
         result = 37 * result + ( getTelefono() == null ? 0 : this.getTelefono().hashCode() );
         result = 37 * result + ( getFax() == null ? 0 : this.getFax().hashCode() );
         result = 37 * result + ( getEmail() == null ? 0 : this.getEmail().hashCode() );
         result = 37 * result + ( getModem() == null ? 0 : this.getModem().hashCode() );
         result = 37 * result + ( getContacto() == null ? 0 : this.getContacto().hashCode() );
         result = 37 * result + ( getObservaciones() == null ? 0 : this.getObservaciones().hashCode() );
         result = 37 * result + ( getIdEmpresa() == null ? 0 : this.getIdEmpresa().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getIdUsrAlta() == null ? 0 : this.getIdUsrAlta().hashCode() );
         result = 37 * result + ( getIdUsrModi() == null ? 0 : this.getIdUsrModi().hashCode() );
         result = 37 * result + ( getMostrar() == null ? 0 : this.getMostrar().hashCode() );
         result = 37 * result + ( getIdRegion() == null ? 0 : this.getIdRegion().hashCode() );
         result = 37 * result + ( getCodigoContable() == null ? 0 : this.getCodigoContable().hashCode() );
         result = 37 * result + ( getFechaUltTransmision() == null ? 0 : this.getFechaUltTransmision().hashCode() );
         result = 37 * result + ( getComisiona() == null ? 0 : this.getComisiona().hashCode() );
         result = 37 * result + ( getGarantiaExtendida() == null ? 0 : this.getGarantiaExtendida().hashCode() );
         result = 37 * result + ( getCategoriaSucursal() == null ? 0 : this.getCategoriaSucursal().hashCode() );
         result = 37 * result + ( getIdMarca() == null ? 0 : this.getIdMarca().hashCode() );
         result = 37 * result + ( getSuperficie() == null ? 0 : this.getSuperficie().hashCode() );
         result = 37 * result + ( getFechaBaja() == null ? 0 : this.getFechaBaja().hashCode() );
         result = 37 * result + ( getFoto() == null ? 0 : this.getFoto().hashCode() );
         result = 37 * result + ( getHorarios() == null ? 0 : this.getHorarios().hashCode() );
         result = 37 * result + ( getProductos() == null ? 0 : this.getProductos().hashCode() );
         result = 37 * result + ( getGrupoBenchmark() == null ? 0 : this.getGrupoBenchmark().hashCode() );
         result = 37 * result + ( getTieneBar() == null ? 0 : this.getTieneBar().hashCode() );
         result = 37 * result + ( getCelular() == null ? 0 : this.getCelular().hashCode() );
         result = 37 * result + ( getTieneWifi() == null ? 0 : this.getTieneWifi().hashCode() );
         result = 37 * result + ( getAuxvarchar1() == null ? 0 : this.getAuxvarchar1().hashCode() );
         result = 37 * result + ( getAuxvarchar2() == null ? 0 : this.getAuxvarchar2().hashCode() );
         result = 37 * result + ( getAuxvarchar3() == null ? 0 : this.getAuxvarchar3().hashCode() );
         result = 37 * result + ( getAuxnumber1() == null ? 0 : this.getAuxnumber1().hashCode() );
         result = 37 * result + ( getAuxnumber2() == null ? 0 : this.getAuxnumber2().hashCode() );
         result = 37 * result + ( getAuxnumber3() == null ? 0 : this.getAuxnumber3().hashCode() );
         result = 37 * result + ( getAuxflag1() == null ? 0 : this.getAuxflag1().hashCode() );
         result = 37 * result + ( getAuxflag2() == null ? 0 : this.getAuxflag2().hashCode() );
         result = 37 * result + ( getAuxflag3() == null ? 0 : this.getAuxflag3().hashCode() );
         return result;
   }   


}


