package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * BufferFdnCuentasXSociosbupId generated by hbm2java
 */
public class BufferFdnCuentasXSociosbupId  implements java.io.Serializable {


     private long idCuenta;
     private byte idCuso;
     private short idSucursal;

    public BufferFdnCuentasXSociosbupId() {
    }

    public BufferFdnCuentasXSociosbupId(long idCuenta, byte idCuso, short idSucursal) {
       this.idCuenta = idCuenta;
       this.idCuso = idCuso;
       this.idSucursal = idSucursal;
    }
   
    public long getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public byte getIdCuso() {
        return this.idCuso;
    }
    
    public void setIdCuso(byte idCuso) {
        this.idCuso = idCuso;
    }
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof BufferFdnCuentasXSociosbupId) ) return false;
		 BufferFdnCuentasXSociosbupId castOther = ( BufferFdnCuentasXSociosbupId ) other; 
         
		 return (this.getIdCuenta()==castOther.getIdCuenta())
 && (this.getIdCuso()==castOther.getIdCuso())
 && (this.getIdSucursal()==castOther.getIdSucursal());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdCuenta();
         result = 37 * result + this.getIdCuso();
         result = 37 * result + this.getIdSucursal();
         return result;
   }   


}


