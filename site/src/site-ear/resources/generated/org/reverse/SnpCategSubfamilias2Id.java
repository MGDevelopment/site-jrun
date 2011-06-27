package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpCategSubfamilias2Id generated by hbm2java
 */
public class SnpCategSubfamilias2Id  implements java.io.Serializable {


     private byte categoriaSeccion;
     private byte categoriaGrupo;
     private byte categoriaFamilia;
     private byte categoriaSubfamilia;
     private String descripcion;
     private String observaciones;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpCategSubfamilias2Id() {
    }

	
    public SnpCategSubfamilias2Id(byte categoriaSeccion, byte categoriaGrupo, byte categoriaFamilia, byte categoriaSubfamilia, String descripcion, String usrAlta, Date FAlta) {
        this.categoriaSeccion = categoriaSeccion;
        this.categoriaGrupo = categoriaGrupo;
        this.categoriaFamilia = categoriaFamilia;
        this.categoriaSubfamilia = categoriaSubfamilia;
        this.descripcion = descripcion;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpCategSubfamilias2Id(byte categoriaSeccion, byte categoriaGrupo, byte categoriaFamilia, byte categoriaSubfamilia, String descripcion, String observaciones, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.descripcion = descripcion;
       this.observaciones = observaciones;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public byte getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(byte categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public byte getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(byte categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public byte getCategoriaSubfamilia() {
        return this.categoriaSubfamilia;
    }
    
    public void setCategoriaSubfamilia(byte categoriaSubfamilia) {
        this.categoriaSubfamilia = categoriaSubfamilia;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpCategSubfamilias2Id) ) return false;
		 SnpCategSubfamilias2Id castOther = ( SnpCategSubfamilias2Id ) other; 
         
		 return (this.getCategoriaSeccion()==castOther.getCategoriaSeccion())
 && (this.getCategoriaGrupo()==castOther.getCategoriaGrupo())
 && (this.getCategoriaFamilia()==castOther.getCategoriaFamilia())
 && (this.getCategoriaSubfamilia()==castOther.getCategoriaSubfamilia())
 && ( (this.getDescripcion()==castOther.getDescripcion()) || ( this.getDescripcion()!=null && castOther.getDescripcion()!=null && this.getDescripcion().equals(castOther.getDescripcion()) ) )
 && ( (this.getObservaciones()==castOther.getObservaciones()) || ( this.getObservaciones()!=null && castOther.getObservaciones()!=null && this.getObservaciones().equals(castOther.getObservaciones()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCategoriaSeccion();
         result = 37 * result + this.getCategoriaGrupo();
         result = 37 * result + this.getCategoriaFamilia();
         result = 37 * result + this.getCategoriaSubfamilia();
         result = 37 * result + ( getDescripcion() == null ? 0 : this.getDescripcion().hashCode() );
         result = 37 * result + ( getObservaciones() == null ? 0 : this.getObservaciones().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


