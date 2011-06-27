package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * VisitaXAlianzaSeccionId generated by hbm2java
 */
public class VisitaXAlianzaSeccionId  implements java.io.Serializable {


     private Date fechaVisita;
     private Long idAlianza;
     private Long idSeccion;
     private int cantVisitas;
     private Date FAlta;
     private Date FModi;

    public VisitaXAlianzaSeccionId() {
    }

	
    public VisitaXAlianzaSeccionId(Date fechaVisita, int cantVisitas) {
        this.fechaVisita = fechaVisita;
        this.cantVisitas = cantVisitas;
    }
    public VisitaXAlianzaSeccionId(Date fechaVisita, Long idAlianza, Long idSeccion, int cantVisitas, Date FAlta, Date FModi) {
       this.fechaVisita = fechaVisita;
       this.idAlianza = idAlianza;
       this.idSeccion = idSeccion;
       this.cantVisitas = cantVisitas;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public Date getFechaVisita() {
        return this.fechaVisita;
    }
    
    public void setFechaVisita(Date fechaVisita) {
        this.fechaVisita = fechaVisita;
    }
    public Long getIdAlianza() {
        return this.idAlianza;
    }
    
    public void setIdAlianza(Long idAlianza) {
        this.idAlianza = idAlianza;
    }
    public Long getIdSeccion() {
        return this.idSeccion;
    }
    
    public void setIdSeccion(Long idSeccion) {
        this.idSeccion = idSeccion;
    }
    public int getCantVisitas() {
        return this.cantVisitas;
    }
    
    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof VisitaXAlianzaSeccionId) ) return false;
		 VisitaXAlianzaSeccionId castOther = ( VisitaXAlianzaSeccionId ) other; 
         
		 return ( (this.getFechaVisita()==castOther.getFechaVisita()) || ( this.getFechaVisita()!=null && castOther.getFechaVisita()!=null && this.getFechaVisita().equals(castOther.getFechaVisita()) ) )
 && ( (this.getIdAlianza()==castOther.getIdAlianza()) || ( this.getIdAlianza()!=null && castOther.getIdAlianza()!=null && this.getIdAlianza().equals(castOther.getIdAlianza()) ) )
 && ( (this.getIdSeccion()==castOther.getIdSeccion()) || ( this.getIdSeccion()!=null && castOther.getIdSeccion()!=null && this.getIdSeccion().equals(castOther.getIdSeccion()) ) )
 && (this.getCantVisitas()==castOther.getCantVisitas())
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getFechaVisita() == null ? 0 : this.getFechaVisita().hashCode() );
         result = 37 * result + ( getIdAlianza() == null ? 0 : this.getIdAlianza().hashCode() );
         result = 37 * result + ( getIdSeccion() == null ? 0 : this.getIdSeccion().hashCode() );
         result = 37 * result + this.getCantVisitas();
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


