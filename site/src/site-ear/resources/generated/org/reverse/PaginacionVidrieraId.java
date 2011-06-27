package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * PaginacionVidrieraId generated by hbm2java
 */
public class PaginacionVidrieraId  implements java.io.Serializable {


     private Boolean idseccion;
     private Date fecha;
     private Date fechaModi;
     private BigDecimal totalAcumulado;

    public PaginacionVidrieraId() {
    }

    public PaginacionVidrieraId(Boolean idseccion, Date fecha, Date fechaModi, BigDecimal totalAcumulado) {
       this.idseccion = idseccion;
       this.fecha = fecha;
       this.fechaModi = fechaModi;
       this.totalAcumulado = totalAcumulado;
    }
   
    public Boolean getIdseccion() {
        return this.idseccion;
    }
    
    public void setIdseccion(Boolean idseccion) {
        this.idseccion = idseccion;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getFechaModi() {
        return this.fechaModi;
    }
    
    public void setFechaModi(Date fechaModi) {
        this.fechaModi = fechaModi;
    }
    public BigDecimal getTotalAcumulado() {
        return this.totalAcumulado;
    }
    
    public void setTotalAcumulado(BigDecimal totalAcumulado) {
        this.totalAcumulado = totalAcumulado;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof PaginacionVidrieraId) ) return false;
		 PaginacionVidrieraId castOther = ( PaginacionVidrieraId ) other; 
         
		 return ( (this.getIdseccion()==castOther.getIdseccion()) || ( this.getIdseccion()!=null && castOther.getIdseccion()!=null && this.getIdseccion().equals(castOther.getIdseccion()) ) )
 && ( (this.getFecha()==castOther.getFecha()) || ( this.getFecha()!=null && castOther.getFecha()!=null && this.getFecha().equals(castOther.getFecha()) ) )
 && ( (this.getFechaModi()==castOther.getFechaModi()) || ( this.getFechaModi()!=null && castOther.getFechaModi()!=null && this.getFechaModi().equals(castOther.getFechaModi()) ) )
 && ( (this.getTotalAcumulado()==castOther.getTotalAcumulado()) || ( this.getTotalAcumulado()!=null && castOther.getTotalAcumulado()!=null && this.getTotalAcumulado().equals(castOther.getTotalAcumulado()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdseccion() == null ? 0 : this.getIdseccion().hashCode() );
         result = 37 * result + ( getFecha() == null ? 0 : this.getFecha().hashCode() );
         result = 37 * result + ( getFechaModi() == null ? 0 : this.getFechaModi().hashCode() );
         result = 37 * result + ( getTotalAcumulado() == null ? 0 : this.getTotalAcumulado().hashCode() );
         return result;
   }   


}


