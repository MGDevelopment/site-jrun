package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpCategoriasId generated by hbm2java
 */
public class SnpCategoriasId  implements java.io.Serializable {


     private String idCategoria;
     private String descripcion;
     private String observaciones;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private Long idUsrAlta;
     private Long idUsrModi;

    public SnpCategoriasId() {
    }

	
    public SnpCategoriasId(String idCategoria, String descripcion, String usrAlta, Date FAlta) {
        this.idCategoria = idCategoria;
        this.descripcion = descripcion;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpCategoriasId(String idCategoria, String descripcion, String observaciones, String usrAlta, Date FAlta, String usrModi, Date FModi, Long idUsrAlta, Long idUsrModi) {
       this.idCategoria = idCategoria;
       this.descripcion = descripcion;
       this.observaciones = observaciones;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idUsrAlta = idUsrAlta;
       this.idUsrModi = idUsrModi;
    }
   
    public String getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpCategoriasId) ) return false;
		 SnpCategoriasId castOther = ( SnpCategoriasId ) other; 
         
		 return ( (this.getIdCategoria()==castOther.getIdCategoria()) || ( this.getIdCategoria()!=null && castOther.getIdCategoria()!=null && this.getIdCategoria().equals(castOther.getIdCategoria()) ) )
 && ( (this.getDescripcion()==castOther.getDescripcion()) || ( this.getDescripcion()!=null && castOther.getDescripcion()!=null && this.getDescripcion().equals(castOther.getDescripcion()) ) )
 && ( (this.getObservaciones()==castOther.getObservaciones()) || ( this.getObservaciones()!=null && castOther.getObservaciones()!=null && this.getObservaciones().equals(castOther.getObservaciones()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getIdUsrAlta()==castOther.getIdUsrAlta()) || ( this.getIdUsrAlta()!=null && castOther.getIdUsrAlta()!=null && this.getIdUsrAlta().equals(castOther.getIdUsrAlta()) ) )
 && ( (this.getIdUsrModi()==castOther.getIdUsrModi()) || ( this.getIdUsrModi()!=null && castOther.getIdUsrModi()!=null && this.getIdUsrModi().equals(castOther.getIdUsrModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdCategoria() == null ? 0 : this.getIdCategoria().hashCode() );
         result = 37 * result + ( getDescripcion() == null ? 0 : this.getDescripcion().hashCode() );
         result = 37 * result + ( getObservaciones() == null ? 0 : this.getObservaciones().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getIdUsrAlta() == null ? 0 : this.getIdUsrAlta().hashCode() );
         result = 37 * result + ( getIdUsrModi() == null ? 0 : this.getIdUsrModi().hashCode() );
         return result;
   }   


}


