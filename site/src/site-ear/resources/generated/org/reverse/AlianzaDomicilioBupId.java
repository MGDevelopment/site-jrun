package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * AlianzaDomicilioBupId generated by hbm2java
 */
public class AlianzaDomicilioBupId  implements java.io.Serializable {


     private long idAlianza;
     private String tipoDomicilio;

    public AlianzaDomicilioBupId() {
    }

    public AlianzaDomicilioBupId(long idAlianza, String tipoDomicilio) {
       this.idAlianza = idAlianza;
       this.tipoDomicilio = tipoDomicilio;
    }
   
    public long getIdAlianza() {
        return this.idAlianza;
    }
    
    public void setIdAlianza(long idAlianza) {
        this.idAlianza = idAlianza;
    }
    public String getTipoDomicilio() {
        return this.tipoDomicilio;
    }
    
    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof AlianzaDomicilioBupId) ) return false;
		 AlianzaDomicilioBupId castOther = ( AlianzaDomicilioBupId ) other; 
         
		 return (this.getIdAlianza()==castOther.getIdAlianza())
 && ( (this.getTipoDomicilio()==castOther.getTipoDomicilio()) || ( this.getTipoDomicilio()!=null && castOther.getTipoDomicilio()!=null && this.getTipoDomicilio().equals(castOther.getTipoDomicilio()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdAlianza();
         result = 37 * result + ( getTipoDomicilio() == null ? 0 : this.getTipoDomicilio().hashCode() );
         return result;
   }   


}


