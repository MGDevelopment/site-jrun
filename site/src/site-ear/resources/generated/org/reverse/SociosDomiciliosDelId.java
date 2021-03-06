package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SociosDomiciliosDelId generated by hbm2java
 */
public class SociosDomiciliosDelId  implements java.io.Serializable {


     private Short idSucursal;
     private Long idSocio;
     private String tipoDomicilio;
     private Date fechaBorrado;

    public SociosDomiciliosDelId() {
    }

    public SociosDomiciliosDelId(Short idSucursal, Long idSocio, String tipoDomicilio, Date fechaBorrado) {
       this.idSucursal = idSucursal;
       this.idSocio = idSocio;
       this.tipoDomicilio = tipoDomicilio;
       this.fechaBorrado = fechaBorrado;
    }
   
    public Short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(Short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
    public String getTipoDomicilio() {
        return this.tipoDomicilio;
    }
    
    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }
    public Date getFechaBorrado() {
        return this.fechaBorrado;
    }
    
    public void setFechaBorrado(Date fechaBorrado) {
        this.fechaBorrado = fechaBorrado;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SociosDomiciliosDelId) ) return false;
		 SociosDomiciliosDelId castOther = ( SociosDomiciliosDelId ) other; 
         
		 return ( (this.getIdSucursal()==castOther.getIdSucursal()) || ( this.getIdSucursal()!=null && castOther.getIdSucursal()!=null && this.getIdSucursal().equals(castOther.getIdSucursal()) ) )
 && ( (this.getIdSocio()==castOther.getIdSocio()) || ( this.getIdSocio()!=null && castOther.getIdSocio()!=null && this.getIdSocio().equals(castOther.getIdSocio()) ) )
 && ( (this.getTipoDomicilio()==castOther.getTipoDomicilio()) || ( this.getTipoDomicilio()!=null && castOther.getTipoDomicilio()!=null && this.getTipoDomicilio().equals(castOther.getTipoDomicilio()) ) )
 && ( (this.getFechaBorrado()==castOther.getFechaBorrado()) || ( this.getFechaBorrado()!=null && castOther.getFechaBorrado()!=null && this.getFechaBorrado().equals(castOther.getFechaBorrado()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdSucursal() == null ? 0 : this.getIdSucursal().hashCode() );
         result = 37 * result + ( getIdSocio() == null ? 0 : this.getIdSocio().hashCode() );
         result = 37 * result + ( getTipoDomicilio() == null ? 0 : this.getTipoDomicilio().hashCode() );
         result = 37 * result + ( getFechaBorrado() == null ? 0 : this.getFechaBorrado().hashCode() );
         return result;
   }   


}


