package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * CarritoPromo2Id generated by hbm2java
 */
public class CarritoPromo2Id  implements java.io.Serializable {


     private long idArticulo;
     private long item;
     private long idSocio;
     private short idSucursalSocio;

    public CarritoPromo2Id() {
    }

    public CarritoPromo2Id(long idArticulo, long item, long idSocio, short idSucursalSocio) {
       this.idArticulo = idArticulo;
       this.item = item;
       this.idSocio = idSocio;
       this.idSucursalSocio = idSucursalSocio;
    }
   
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public long getItem() {
        return this.item;
    }
    
    public void setItem(long item) {
        this.item = item;
    }
    public long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(long idSocio) {
        this.idSocio = idSocio;
    }
    public short getIdSucursalSocio() {
        return this.idSucursalSocio;
    }
    
    public void setIdSucursalSocio(short idSucursalSocio) {
        this.idSucursalSocio = idSucursalSocio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof CarritoPromo2Id) ) return false;
		 CarritoPromo2Id castOther = ( CarritoPromo2Id ) other; 
         
		 return (this.getIdArticulo()==castOther.getIdArticulo())
 && (this.getItem()==castOther.getItem())
 && (this.getIdSocio()==castOther.getIdSocio())
 && (this.getIdSucursalSocio()==castOther.getIdSucursalSocio());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdArticulo();
         result = 37 * result + (int) this.getItem();
         result = 37 * result + (int) this.getIdSocio();
         result = 37 * result + this.getIdSucursalSocio();
         return result;
   }   


}


