package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * ItemsLiquidacionesId generated by hbm2java
 */
public class ItemsLiquidacionesId  implements java.io.Serializable {


     private short idSucursal;
     private long idMovimiento;
     private int item;

    public ItemsLiquidacionesId() {
    }

    public ItemsLiquidacionesId(short idSucursal, long idMovimiento, int item) {
       this.idSucursal = idSucursal;
       this.idMovimiento = idMovimiento;
       this.item = item;
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
    public int getItem() {
        return this.item;
    }
    
    public void setItem(int item) {
        this.item = item;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ItemsLiquidacionesId) ) return false;
		 ItemsLiquidacionesId castOther = ( ItemsLiquidacionesId ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && (this.getIdMovimiento()==castOther.getIdMovimiento())
 && (this.getItem()==castOther.getItem());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + (int) this.getIdMovimiento();
         result = 37 * result + this.getItem();
         return result;
   }   


}


