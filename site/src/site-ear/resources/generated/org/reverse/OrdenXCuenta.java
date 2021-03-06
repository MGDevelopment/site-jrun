package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * OrdenXCuenta generated by hbm2java
 */
public class OrdenXCuenta  implements java.io.Serializable {


     private long idOrden;
     private short idSucursalSocio;
     private long idSocio;
     private short idSucursalCuenta;
     private long idCuenta;
     private String nroTarjeta;
     private Date FAlta;
     private Date FModi;

    public OrdenXCuenta() {
    }

	
    public OrdenXCuenta(long idOrden, short idSucursalSocio, long idSocio, short idSucursalCuenta, long idCuenta, String nroTarjeta) {
        this.idOrden = idOrden;
        this.idSucursalSocio = idSucursalSocio;
        this.idSocio = idSocio;
        this.idSucursalCuenta = idSucursalCuenta;
        this.idCuenta = idCuenta;
        this.nroTarjeta = nroTarjeta;
    }
    public OrdenXCuenta(long idOrden, short idSucursalSocio, long idSocio, short idSucursalCuenta, long idCuenta, String nroTarjeta, Date FAlta, Date FModi) {
       this.idOrden = idOrden;
       this.idSucursalSocio = idSucursalSocio;
       this.idSocio = idSocio;
       this.idSucursalCuenta = idSucursalCuenta;
       this.idCuenta = idCuenta;
       this.nroTarjeta = nroTarjeta;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public long getIdOrden() {
        return this.idOrden;
    }
    
    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
    }
    public short getIdSucursalSocio() {
        return this.idSucursalSocio;
    }
    
    public void setIdSucursalSocio(short idSucursalSocio) {
        this.idSucursalSocio = idSucursalSocio;
    }
    public long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(long idSocio) {
        this.idSocio = idSocio;
    }
    public short getIdSucursalCuenta() {
        return this.idSucursalCuenta;
    }
    
    public void setIdSucursalCuenta(short idSucursalCuenta) {
        this.idSucursalCuenta = idSucursalCuenta;
    }
    public long getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String getNroTarjeta() {
        return this.nroTarjeta;
    }
    
    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
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


