package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpCuentasId generated by hbm2java
 */
public class SnpCuentasId  implements java.io.Serializable {


     private long idCuenta;
     private short idSucursal;
     private Date fechaApertura;
     private String estado;
     private Date estadoFecha;
     private String estadoUsr;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpCuentasId() {
    }

	
    public SnpCuentasId(long idCuenta, short idSucursal, Date fechaApertura, String estado, String usrAlta, Date FAlta) {
        this.idCuenta = idCuenta;
        this.idSucursal = idSucursal;
        this.fechaApertura = fechaApertura;
        this.estado = estado;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpCuentasId(long idCuenta, short idSucursal, Date fechaApertura, String estado, Date estadoFecha, String estadoUsr, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idCuenta = idCuenta;
       this.idSucursal = idSucursal;
       this.fechaApertura = fechaApertura;
       this.estado = estado;
       this.estadoFecha = estadoFecha;
       this.estadoUsr = estadoUsr;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public long getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Date getFechaApertura() {
        return this.fechaApertura;
    }
    
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Date getEstadoFecha() {
        return this.estadoFecha;
    }
    
    public void setEstadoFecha(Date estadoFecha) {
        this.estadoFecha = estadoFecha;
    }
    public String getEstadoUsr() {
        return this.estadoUsr;
    }
    
    public void setEstadoUsr(String estadoUsr) {
        this.estadoUsr = estadoUsr;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpCuentasId) ) return false;
		 SnpCuentasId castOther = ( SnpCuentasId ) other; 
         
		 return (this.getIdCuenta()==castOther.getIdCuenta())
 && (this.getIdSucursal()==castOther.getIdSucursal())
 && ( (this.getFechaApertura()==castOther.getFechaApertura()) || ( this.getFechaApertura()!=null && castOther.getFechaApertura()!=null && this.getFechaApertura().equals(castOther.getFechaApertura()) ) )
 && ( (this.getEstado()==castOther.getEstado()) || ( this.getEstado()!=null && castOther.getEstado()!=null && this.getEstado().equals(castOther.getEstado()) ) )
 && ( (this.getEstadoFecha()==castOther.getEstadoFecha()) || ( this.getEstadoFecha()!=null && castOther.getEstadoFecha()!=null && this.getEstadoFecha().equals(castOther.getEstadoFecha()) ) )
 && ( (this.getEstadoUsr()==castOther.getEstadoUsr()) || ( this.getEstadoUsr()!=null && castOther.getEstadoUsr()!=null && this.getEstadoUsr().equals(castOther.getEstadoUsr()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdCuenta();
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + ( getFechaApertura() == null ? 0 : this.getFechaApertura().hashCode() );
         result = 37 * result + ( getEstado() == null ? 0 : this.getEstado().hashCode() );
         result = 37 * result + ( getEstadoFecha() == null ? 0 : this.getEstadoFecha().hashCode() );
         result = 37 * result + ( getEstadoUsr() == null ? 0 : this.getEstadoUsr().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


