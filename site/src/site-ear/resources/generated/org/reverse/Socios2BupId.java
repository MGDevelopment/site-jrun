package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * Socios2BupId generated by hbm2java
 */
public class Socios2BupId  implements java.io.Serializable {


     private short idSucursal;
     private long idSocio;

    public Socios2BupId() {
    }

    public Socios2BupId(short idSucursal, long idSocio) {
       this.idSucursal = idSucursal;
       this.idSocio = idSocio;
    }
   
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(long idSocio) {
        this.idSocio = idSocio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Socios2BupId) ) return false;
		 Socios2BupId castOther = ( Socios2BupId ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && (this.getIdSocio()==castOther.getIdSocio());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + (int) this.getIdSocio();
         return result;
   }   


}


