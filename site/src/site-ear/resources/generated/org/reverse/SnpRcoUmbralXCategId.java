package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpRcoUmbralXCategId generated by hbm2java
 */
public class SnpRcoUmbralXCategId  implements java.io.Serializable {


     private byte categoriaSeccion;
     private Byte categoriaGrupo;
     private Byte categoriaFamilia;
     private Byte categoriaSubfamilia;
     private String novedad;
     private short cantUmbral;
     private Date FAlta;
     private String usrAlta;
     private Date FModi;
     private String usrModi;

    public SnpRcoUmbralXCategId() {
    }

	
    public SnpRcoUmbralXCategId(byte categoriaSeccion, String novedad, short cantUmbral, Date FAlta, String usrAlta) {
        this.categoriaSeccion = categoriaSeccion;
        this.novedad = novedad;
        this.cantUmbral = cantUmbral;
        this.FAlta = FAlta;
        this.usrAlta = usrAlta;
    }
    public SnpRcoUmbralXCategId(byte categoriaSeccion, Byte categoriaGrupo, Byte categoriaFamilia, Byte categoriaSubfamilia, String novedad, short cantUmbral, Date FAlta, String usrAlta, Date FModi, String usrModi) {
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.novedad = novedad;
       this.cantUmbral = cantUmbral;
       this.FAlta = FAlta;
       this.usrAlta = usrAlta;
       this.FModi = FModi;
       this.usrModi = usrModi;
    }
   
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public Byte getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(Byte categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public Byte getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(Byte categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public Byte getCategoriaSubfamilia() {
        return this.categoriaSubfamilia;
    }
    
    public void setCategoriaSubfamilia(Byte categoriaSubfamilia) {
        this.categoriaSubfamilia = categoriaSubfamilia;
    }
    public String getNovedad() {
        return this.novedad;
    }
    
    public void setNovedad(String novedad) {
        this.novedad = novedad;
    }
    public short getCantUmbral() {
        return this.cantUmbral;
    }
    
    public void setCantUmbral(short cantUmbral) {
        this.cantUmbral = cantUmbral;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpRcoUmbralXCategId) ) return false;
		 SnpRcoUmbralXCategId castOther = ( SnpRcoUmbralXCategId ) other; 
         
		 return (this.getCategoriaSeccion()==castOther.getCategoriaSeccion())
 && ( (this.getCategoriaGrupo()==castOther.getCategoriaGrupo()) || ( this.getCategoriaGrupo()!=null && castOther.getCategoriaGrupo()!=null && this.getCategoriaGrupo().equals(castOther.getCategoriaGrupo()) ) )
 && ( (this.getCategoriaFamilia()==castOther.getCategoriaFamilia()) || ( this.getCategoriaFamilia()!=null && castOther.getCategoriaFamilia()!=null && this.getCategoriaFamilia().equals(castOther.getCategoriaFamilia()) ) )
 && ( (this.getCategoriaSubfamilia()==castOther.getCategoriaSubfamilia()) || ( this.getCategoriaSubfamilia()!=null && castOther.getCategoriaSubfamilia()!=null && this.getCategoriaSubfamilia().equals(castOther.getCategoriaSubfamilia()) ) )
 && ( (this.getNovedad()==castOther.getNovedad()) || ( this.getNovedad()!=null && castOther.getNovedad()!=null && this.getNovedad().equals(castOther.getNovedad()) ) )
 && (this.getCantUmbral()==castOther.getCantUmbral())
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCategoriaSeccion();
         result = 37 * result + ( getCategoriaGrupo() == null ? 0 : this.getCategoriaGrupo().hashCode() );
         result = 37 * result + ( getCategoriaFamilia() == null ? 0 : this.getCategoriaFamilia().hashCode() );
         result = 37 * result + ( getCategoriaSubfamilia() == null ? 0 : this.getCategoriaSubfamilia().hashCode() );
         result = 37 * result + ( getNovedad() == null ? 0 : this.getNovedad().hashCode() );
         result = 37 * result + this.getCantUmbral();
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         return result;
   }   


}


