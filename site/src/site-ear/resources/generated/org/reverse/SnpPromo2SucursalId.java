package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpPromo2SucursalId generated by hbm2java
 */
public class SnpPromo2SucursalId  implements java.io.Serializable {


     private long idPromocion;
     private int item;
     private String incluirExcluir;
     private Short idSucursal;
     private Long idCaal;
     private Short idGrupoProy;
     private String idEmpresa;
     private Short idUnidadNegocio;
     private String idRegion;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpPromo2SucursalId() {
    }

	
    public SnpPromo2SucursalId(long idPromocion, int item, String incluirExcluir, String usrAlta, Date FAlta) {
        this.idPromocion = idPromocion;
        this.item = item;
        this.incluirExcluir = incluirExcluir;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpPromo2SucursalId(long idPromocion, int item, String incluirExcluir, Short idSucursal, Long idCaal, Short idGrupoProy, String idEmpresa, Short idUnidadNegocio, String idRegion, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idPromocion = idPromocion;
       this.item = item;
       this.incluirExcluir = incluirExcluir;
       this.idSucursal = idSucursal;
       this.idCaal = idCaal;
       this.idGrupoProy = idGrupoProy;
       this.idEmpresa = idEmpresa;
       this.idUnidadNegocio = idUnidadNegocio;
       this.idRegion = idRegion;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public long getIdPromocion() {
        return this.idPromocion;
    }
    
    public void setIdPromocion(long idPromocion) {
        this.idPromocion = idPromocion;
    }
    public int getItem() {
        return this.item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }
    public String getIncluirExcluir() {
        return this.incluirExcluir;
    }
    
    public void setIncluirExcluir(String incluirExcluir) {
        this.incluirExcluir = incluirExcluir;
    }
    public Short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(Short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public Long getIdCaal() {
        return this.idCaal;
    }
    
    public void setIdCaal(Long idCaal) {
        this.idCaal = idCaal;
    }
    public Short getIdGrupoProy() {
        return this.idGrupoProy;
    }
    
    public void setIdGrupoProy(Short idGrupoProy) {
        this.idGrupoProy = idGrupoProy;
    }
    public String getIdEmpresa() {
        return this.idEmpresa;
    }
    
    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public Short getIdUnidadNegocio() {
        return this.idUnidadNegocio;
    }
    
    public void setIdUnidadNegocio(Short idUnidadNegocio) {
        this.idUnidadNegocio = idUnidadNegocio;
    }
    public String getIdRegion() {
        return this.idRegion;
    }
    
    public void setIdRegion(String idRegion) {
        this.idRegion = idRegion;
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
		 if ( !(other instanceof SnpPromo2SucursalId) ) return false;
		 SnpPromo2SucursalId castOther = ( SnpPromo2SucursalId ) other; 
         
		 return (this.getIdPromocion()==castOther.getIdPromocion())
 && (this.getItem()==castOther.getItem())
 && ( (this.getIncluirExcluir()==castOther.getIncluirExcluir()) || ( this.getIncluirExcluir()!=null && castOther.getIncluirExcluir()!=null && this.getIncluirExcluir().equals(castOther.getIncluirExcluir()) ) )
 && ( (this.getIdSucursal()==castOther.getIdSucursal()) || ( this.getIdSucursal()!=null && castOther.getIdSucursal()!=null && this.getIdSucursal().equals(castOther.getIdSucursal()) ) )
 && ( (this.getIdCaal()==castOther.getIdCaal()) || ( this.getIdCaal()!=null && castOther.getIdCaal()!=null && this.getIdCaal().equals(castOther.getIdCaal()) ) )
 && ( (this.getIdGrupoProy()==castOther.getIdGrupoProy()) || ( this.getIdGrupoProy()!=null && castOther.getIdGrupoProy()!=null && this.getIdGrupoProy().equals(castOther.getIdGrupoProy()) ) )
 && ( (this.getIdEmpresa()==castOther.getIdEmpresa()) || ( this.getIdEmpresa()!=null && castOther.getIdEmpresa()!=null && this.getIdEmpresa().equals(castOther.getIdEmpresa()) ) )
 && ( (this.getIdUnidadNegocio()==castOther.getIdUnidadNegocio()) || ( this.getIdUnidadNegocio()!=null && castOther.getIdUnidadNegocio()!=null && this.getIdUnidadNegocio().equals(castOther.getIdUnidadNegocio()) ) )
 && ( (this.getIdRegion()==castOther.getIdRegion()) || ( this.getIdRegion()!=null && castOther.getIdRegion()!=null && this.getIdRegion().equals(castOther.getIdRegion()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdPromocion();
         result = 37 * result + this.getItem();
         result = 37 * result + ( getIncluirExcluir() == null ? 0 : this.getIncluirExcluir().hashCode() );
         result = 37 * result + ( getIdSucursal() == null ? 0 : this.getIdSucursal().hashCode() );
         result = 37 * result + ( getIdCaal() == null ? 0 : this.getIdCaal().hashCode() );
         result = 37 * result + ( getIdGrupoProy() == null ? 0 : this.getIdGrupoProy().hashCode() );
         result = 37 * result + ( getIdEmpresa() == null ? 0 : this.getIdEmpresa().hashCode() );
         result = 37 * result + ( getIdUnidadNegocio() == null ? 0 : this.getIdUnidadNegocio().hashCode() );
         result = 37 * result + ( getIdRegion() == null ? 0 : this.getIdRegion().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


