package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * MovimientosId generated by hbm2java
 */
public class MovimientosId  implements java.io.Serializable {


     private short idSucursal;
     private long idMovimiento;

    public MovimientosId() {
    }

    public MovimientosId(short idSucursal, long idMovimiento) {
       this.idSucursal = idSucursal;
       this.idMovimiento = idMovimiento;
    }
   
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public long getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MovimientosId) ) return false;
		 MovimientosId castOther = ( MovimientosId ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && (this.getIdMovimiento()==castOther.getIdMovimiento());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + (int) this.getIdMovimiento();
         return result;
   }   


}


