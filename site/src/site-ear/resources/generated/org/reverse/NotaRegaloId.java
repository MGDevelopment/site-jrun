package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * NotaRegaloId generated by hbm2java
 */
public class NotaRegaloId  implements java.io.Serializable {


     private long idOrden;
     private long idArticulo;
     private long item;

    public NotaRegaloId() {
    }

    public NotaRegaloId(long idOrden, long idArticulo, long item) {
       this.idOrden = idOrden;
       this.idArticulo = idArticulo;
       this.item = item;
    }
   
    public long getIdOrden() {
        return this.idOrden;
    }
    
    public void setIdOrden(long idOrden) {
        this.idOrden = idOrden;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NotaRegaloId) ) return false;
		 NotaRegaloId castOther = ( NotaRegaloId ) other; 
         
		 return (this.getIdOrden()==castOther.getIdOrden())
 && (this.getIdArticulo()==castOther.getIdArticulo())
 && (this.getItem()==castOther.getItem());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdOrden();
         result = 37 * result + (int) this.getIdArticulo();
         result = 37 * result + (int) this.getItem();
         return result;
   }   


}


