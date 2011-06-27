package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * SociosVehiculosBupId generated by hbm2java
 */
public class SociosVehiculosBupId  implements java.io.Serializable {


     private long idSocio;
     private byte idSovh;
     private short idSucursal;

    public SociosVehiculosBupId() {
    }

    public SociosVehiculosBupId(long idSocio, byte idSovh, short idSucursal) {
       this.idSocio = idSocio;
       this.idSovh = idSovh;
       this.idSucursal = idSucursal;
    }
   
    public long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(long idSocio) {
        this.idSocio = idSocio;
    }
    public byte getIdSovh() {
        return this.idSovh;
    }
    
    public void setIdSovh(byte idSovh) {
        this.idSovh = idSovh;
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
		 if ( !(other instanceof SociosVehiculosBupId) ) return false;
		 SociosVehiculosBupId castOther = ( SociosVehiculosBupId ) other; 
         
		 return (this.getIdSocio()==castOther.getIdSocio())
 && (this.getIdSovh()==castOther.getIdSovh())
 && (this.getIdSucursal()==castOther.getIdSucursal());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdSocio();
         result = 37 * result + this.getIdSovh();
         result = 37 * result + this.getIdSucursal();
         return result;
   }   


}


