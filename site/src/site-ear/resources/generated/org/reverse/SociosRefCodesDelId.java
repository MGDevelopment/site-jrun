package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SociosRefCodesDelId generated by hbm2java
 */
public class SociosRefCodesDelId  implements java.io.Serializable {


     private Long idSocio;
     private Short idSucursal;
     private String domain;
     private String lowValue;
     private Date fechaBorrado;

    public SociosRefCodesDelId() {
    }

    public SociosRefCodesDelId(Long idSocio, Short idSucursal, String domain, String lowValue, Date fechaBorrado) {
       this.idSocio = idSocio;
       this.idSucursal = idSucursal;
       this.domain = domain;
       this.lowValue = lowValue;
       this.fechaBorrado = fechaBorrado;
    }
   
    public Long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
    public Short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(Short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public String getDomain() {
        return this.domain;
    }
    
    public void setDomain(String domain) {
        this.domain = domain;
    }
    public String getLowValue() {
        return this.lowValue;
    }
    
    public void setLowValue(String lowValue) {
        this.lowValue = lowValue;
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
		 if ( !(other instanceof SociosRefCodesDelId) ) return false;
		 SociosRefCodesDelId castOther = ( SociosRefCodesDelId ) other; 
         
		 return ( (this.getIdSocio()==castOther.getIdSocio()) || ( this.getIdSocio()!=null && castOther.getIdSocio()!=null && this.getIdSocio().equals(castOther.getIdSocio()) ) )
 && ( (this.getIdSucursal()==castOther.getIdSucursal()) || ( this.getIdSucursal()!=null && castOther.getIdSucursal()!=null && this.getIdSucursal().equals(castOther.getIdSucursal()) ) )
 && ( (this.getDomain()==castOther.getDomain()) || ( this.getDomain()!=null && castOther.getDomain()!=null && this.getDomain().equals(castOther.getDomain()) ) )
 && ( (this.getLowValue()==castOther.getLowValue()) || ( this.getLowValue()!=null && castOther.getLowValue()!=null && this.getLowValue().equals(castOther.getLowValue()) ) )
 && ( (this.getFechaBorrado()==castOther.getFechaBorrado()) || ( this.getFechaBorrado()!=null && castOther.getFechaBorrado()!=null && this.getFechaBorrado().equals(castOther.getFechaBorrado()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdSocio() == null ? 0 : this.getIdSocio().hashCode() );
         result = 37 * result + ( getIdSucursal() == null ? 0 : this.getIdSucursal().hashCode() );
         result = 37 * result + ( getDomain() == null ? 0 : this.getDomain().hashCode() );
         result = 37 * result + ( getLowValue() == null ? 0 : this.getLowValue().hashCode() );
         result = 37 * result + ( getFechaBorrado() == null ? 0 : this.getFechaBorrado().hashCode() );
         return result;
   }   


}


