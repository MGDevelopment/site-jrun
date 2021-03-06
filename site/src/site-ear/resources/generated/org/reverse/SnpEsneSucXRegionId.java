package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpEsneSucXRegionId generated by hbm2java
 */
public class SnpEsneSucXRegionId  implements java.io.Serializable {


     private String idEmpresa;
     private short idUnidadNegocio;
     private String idRegion;
     private short idSucursal;
     private String habilitado;
     private String cuentaMascara;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpEsneSucXRegionId() {
    }

	
    public SnpEsneSucXRegionId(String idEmpresa, short idUnidadNegocio, String idRegion, short idSucursal, String habilitado, String usrAlta, Date FAlta) {
        this.idEmpresa = idEmpresa;
        this.idUnidadNegocio = idUnidadNegocio;
        this.idRegion = idRegion;
        this.idSucursal = idSucursal;
        this.habilitado = habilitado;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpEsneSucXRegionId(String idEmpresa, short idUnidadNegocio, String idRegion, short idSucursal, String habilitado, String cuentaMascara, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idEmpresa = idEmpresa;
       this.idUnidadNegocio = idUnidadNegocio;
       this.idRegion = idRegion;
       this.idSucursal = idSucursal;
       this.habilitado = habilitado;
       this.cuentaMascara = cuentaMascara;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public String getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public short getIdUnidadNegocio() {
        return this.idUnidadNegocio;
    }
    
    public void setIdUnidadNegocio(short idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }
    public String getIdRegion() {
        return this.idRegion;
    }
    
    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
    }
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public String getHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
    public String getCuentaMascara() {
        return this.cuentaMascara;
    }
    
    public void setCuentaMascara(String cuentaMascara) {
        this.cuentaMascara = cuentaMascara;
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
		 if ( !(other instanceof SnpEsneSucXRegionId) ) return false;
		 SnpEsneSucXRegionId castOther = ( SnpEsneSucXRegionId ) other; 
         
		 return ( (this.getIdEmpresa()==castOther.getIdEmpresa()) || ( this.getIdEmpresa()!=null && castOther.getIdEmpresa()!=null && this.getIdEmpresa().equals(castOther.getIdEmpresa()) ) )
 && (this.getIdUnidadNegocio()==castOther.getIdUnidadNegocio())
 && ( (this.getIdRegion()==castOther.getIdRegion()) || ( this.getIdRegion()!=null && castOther.getIdRegion()!=null && this.getIdRegion().equals(castOther.getIdRegion()) ) )
 && (this.getIdSucursal()==castOther.getIdSucursal())
 && ( (this.getHabilitado()==castOther.getHabilitado()) || ( this.getHabilitado()!=null && castOther.getHabilitado()!=null && this.getHabilitado().equals(castOther.getHabilitado()) ) )
 && ( (this.getCuentaMascara()==castOther.getCuentaMascara()) || ( this.getCuentaMascara()!=null && castOther.getCuentaMascara()!=null && this.getCuentaMascara().equals(castOther.getCuentaMascara()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdEmpresa() == null ? 0 : this.getIdEmpresa().hashCode() );
         result = 37 * result + this.getIdUnidadNegocio();
         result = 37 * result + ( getIdRegion() == null ? 0 : this.getIdRegion().hashCode() );
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + ( getHabilitado() == null ? 0 : this.getHabilitado().hashCode() );
         result = 37 * result + ( getCuentaMascara() == null ? 0 : this.getCuentaMascara().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


