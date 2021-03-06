package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpFdnItemsCatalogosId generated by hbm2java
 */
public class SnpFdnItemsCatalogosId  implements java.io.Serializable {


     private int idCatalogo;
     private long idArticulo;
     private int puntos;
     private BigDecimal importeAdicional;
     private Date fechaVigencia;
     private String habilitado;
     private Date habilitadoFecha;
     private String habilitadoUsr;
     private String hastaStkCero;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpFdnItemsCatalogosId() {
    }

	
    public SnpFdnItemsCatalogosId(int idCatalogo, long idArticulo, int puntos, BigDecimal importeAdicional, Date fechaVigencia, String habilitado, String hastaStkCero, String usrAlta, Date FAlta) {
        this.idCatalogo = idCatalogo;
        this.idArticulo = idArticulo;
        this.puntos = puntos;
        this.importeAdicional = importeAdicional;
        this.fechaVigencia = fechaVigencia;
        this.habilitado = habilitado;
        this.hastaStkCero = hastaStkCero;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpFdnItemsCatalogosId(int idCatalogo, long idArticulo, int puntos, BigDecimal importeAdicional, Date fechaVigencia, String habilitado, Date habilitadoFecha, String habilitadoUsr, String hastaStkCero, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idCatalogo = idCatalogo;
       this.idArticulo = idArticulo;
       this.puntos = puntos;
       this.importeAdicional = importeAdicional;
       this.fechaVigencia = fechaVigencia;
       this.habilitado = habilitado;
       this.habilitadoFecha = habilitadoFecha;
       this.habilitadoUsr = habilitadoUsr;
       this.hastaStkCero = hastaStkCero;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public int getIdCatalogo() {
        return this.idCatalogo;
    }
    
    public void setIdCatalogo(int idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public int getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    public BigDecimal getImporteAdicional() {
        return this.importeAdicional;
    }
    
    public void setImporteAdicional(BigDecimal importeAdicional) {
        this.importeAdicional = importeAdicional;
    }
    public Date getFechaVigencia() {
        return this.fechaVigencia;
    }
    
    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
    }
    public String getHabilitado() {
        return this.habilitado;
    }
    
    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }
    public Date getHabilitadoFecha() {
        return this.habilitadoFecha;
    }
    
    public void setHabilitadoFecha(Date habilitadoFecha) {
        this.habilitadoFecha = habilitadoFecha;
    }
    public String getHabilitadoUsr() {
        return this.habilitadoUsr;
    }
    
    public void setHabilitadoUsr(String habilitadoUsr) {
        this.habilitadoUsr = habilitadoUsr;
    }
    public String getHastaStkCero() {
        return this.hastaStkCero;
    }
    
    public void setHastaStkCero(String hastaStkCero) {
        this.hastaStkCero = hastaStkCero;
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
		 if ( !(other instanceof SnpFdnItemsCatalogosId) ) return false;
		 SnpFdnItemsCatalogosId castOther = ( SnpFdnItemsCatalogosId ) other; 
         
		 return (this.getIdCatalogo()==castOther.getIdCatalogo())
 && (this.getIdArticulo()==castOther.getIdArticulo())
 && (this.getPuntos()==castOther.getPuntos())
 && ( (this.getImporteAdicional()==castOther.getImporteAdicional()) || ( this.getImporteAdicional()!=null && castOther.getImporteAdicional()!=null && this.getImporteAdicional().equals(castOther.getImporteAdicional()) ) )
 && ( (this.getFechaVigencia()==castOther.getFechaVigencia()) || ( this.getFechaVigencia()!=null && castOther.getFechaVigencia()!=null && this.getFechaVigencia().equals(castOther.getFechaVigencia()) ) )
 && ( (this.getHabilitado()==castOther.getHabilitado()) || ( this.getHabilitado()!=null && castOther.getHabilitado()!=null && this.getHabilitado().equals(castOther.getHabilitado()) ) )
 && ( (this.getHabilitadoFecha()==castOther.getHabilitadoFecha()) || ( this.getHabilitadoFecha()!=null && castOther.getHabilitadoFecha()!=null && this.getHabilitadoFecha().equals(castOther.getHabilitadoFecha()) ) )
 && ( (this.getHabilitadoUsr()==castOther.getHabilitadoUsr()) || ( this.getHabilitadoUsr()!=null && castOther.getHabilitadoUsr()!=null && this.getHabilitadoUsr().equals(castOther.getHabilitadoUsr()) ) )
 && ( (this.getHastaStkCero()==castOther.getHastaStkCero()) || ( this.getHastaStkCero()!=null && castOther.getHastaStkCero()!=null && this.getHastaStkCero().equals(castOther.getHastaStkCero()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdCatalogo();
         result = 37 * result + (int) this.getIdArticulo();
         result = 37 * result + this.getPuntos();
         result = 37 * result + ( getImporteAdicional() == null ? 0 : this.getImporteAdicional().hashCode() );
         result = 37 * result + ( getFechaVigencia() == null ? 0 : this.getFechaVigencia().hashCode() );
         result = 37 * result + ( getHabilitado() == null ? 0 : this.getHabilitado().hashCode() );
         result = 37 * result + ( getHabilitadoFecha() == null ? 0 : this.getHabilitadoFecha().hashCode() );
         result = 37 * result + ( getHabilitadoUsr() == null ? 0 : this.getHabilitadoUsr().hashCode() );
         result = 37 * result + ( getHastaStkCero() == null ? 0 : this.getHastaStkCero().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


