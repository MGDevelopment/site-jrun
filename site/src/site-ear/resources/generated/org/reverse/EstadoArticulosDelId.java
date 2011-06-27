package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * EstadoArticulosDelId generated by hbm2java
 */
public class EstadoArticulosDelId  implements java.io.Serializable {


     private Long secuencia;
     private Date fechaBorrado;

    public EstadoArticulosDelId() {
    }

    public EstadoArticulosDelId(Long secuencia, Date fechaBorrado) {
       this.secuencia = secuencia;
       this.fechaBorrado = fechaBorrado;
    }
   
    public Long getSecuencia() {
        return this.secuencia;
    }
    
    public void setSecuencia(Long secuencia) {
        this.secuencia = secuencia;
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
		 if ( !(other instanceof EstadoArticulosDelId) ) return false;
		 EstadoArticulosDelId castOther = ( EstadoArticulosDelId ) other; 
         
		 return ( (this.getSecuencia()==castOther.getSecuencia()) || ( this.getSecuencia()!=null && castOther.getSecuencia()!=null && this.getSecuencia().equals(castOther.getSecuencia()) ) )
 && ( (this.getFechaBorrado()==castOther.getFechaBorrado()) || ( this.getFechaBorrado()!=null && castOther.getFechaBorrado()!=null && this.getFechaBorrado().equals(castOther.getFechaBorrado()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getSecuencia() == null ? 0 : this.getSecuencia().hashCode() );
         result = 37 * result + ( getFechaBorrado() == null ? 0 : this.getFechaBorrado().hashCode() );
         return result;
   }   


}


