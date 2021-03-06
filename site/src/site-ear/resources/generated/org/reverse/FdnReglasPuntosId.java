package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * FdnReglasPuntosId generated by hbm2java
 */
public class FdnReglasPuntosId  implements java.io.Serializable {


     private long idRegla;
     private short idRepu;

    public FdnReglasPuntosId() {
    }

    public FdnReglasPuntosId(long idRegla, short idRepu) {
       this.idRegla = idRegla;
       this.idRepu = idRepu;
    }
   
    public long getIdRegla() {
        return this.idRegla;
    }
    
    public void setIdRegla(long idRegla) {
        this.idRegla = idRegla;
    }
    public short getIdRepu() {
        return this.idRepu;
    }
    
    public void setIdRepu(short idRepu) {
        this.idRepu = idRepu;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FdnReglasPuntosId) ) return false;
		 FdnReglasPuntosId castOther = ( FdnReglasPuntosId ) other; 
         
		 return (this.getIdRegla()==castOther.getIdRegla())
 && (this.getIdRepu()==castOther.getIdRepu());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdRegla();
         result = 37 * result + this.getIdRepu();
         return result;
   }   


}


