package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.io.Serializable;
import java.util.Arrays;

/**
 * Dr.proveedorOtIdx.iId generated by hbm2java
 */
public class Dr.proveedorOtIdx.iId  implements java.io.Serializable {


     private String dr$token;
     private short dr$tokenType;
     private Serializable dr$rowid;
     private byte[] dr$tokenInfo;

    public Dr.proveedorOtIdx.iId() {
    }

    public Dr.proveedorOtIdx.iId(String dr$token, short dr$tokenType, Serializable dr$rowid, byte[] dr$tokenInfo) {
       this.dr$token = dr$token;
       this.dr$tokenType = dr$tokenType;
       this.dr$rowid = dr$rowid;
       this.dr$tokenInfo = dr$tokenInfo;
    }
   
    public String getDr$token() {
        return this.dr$token;
    }
    
    public void setDr$token(String dr$token) {
        this.dr$token = dr$token;
    }
    public short getDr$tokenType() {
        return this.dr$tokenType;
    }
    
    public void setDr$tokenType(short dr$tokenType) {
        this.dr$tokenType = dr$tokenType;
    }
    public Serializable getDr$rowid() {
        return this.dr$rowid;
    }
    
    public void setDr$rowid(Serializable dr$rowid) {
        this.dr$rowid = dr$rowid;
    }
    public byte[] getDr$tokenInfo() {
        return this.dr$tokenInfo;
    }
    
    public void setDr$tokenInfo(byte[] dr$tokenInfo) {
        this.dr$tokenInfo = dr$tokenInfo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof Dr.proveedorOtIdx.iId) ) return false;
		 Dr.proveedorOtIdx.iId castOther = ( Dr.proveedorOtIdx.iId ) other; 
         
		 return ( (this.getDr$token()==castOther.getDr$token()) || ( this.getDr$token()!=null && castOther.getDr$token()!=null && this.getDr$token().equals(castOther.getDr$token()) ) )
 && (this.getDr$tokenType()==castOther.getDr$tokenType())
 && ( (this.getDr$rowid()==castOther.getDr$rowid()) || ( this.getDr$rowid()!=null && castOther.getDr$rowid()!=null && this.getDr$rowid().equals(castOther.getDr$rowid()) ) )
 && ( (this.getDr$tokenInfo()==castOther.getDr$tokenInfo()) || ( this.getDr$tokenInfo()!=null && castOther.getDr$tokenInfo()!=null && Arrays.equals(this.getDr$tokenInfo(), castOther.getDr$tokenInfo()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getDr$token() == null ? 0 : this.getDr$token().hashCode() );
         result = 37 * result + this.getDr$tokenType();
         result = 37 * result + ( getDr$rowid() == null ? 0 : this.getDr$rowid().hashCode() );
         int dr$tokenInfoHashcode = 0;
         byte[] dr$tokenInfoProperty = this.getDr$tokenInfo();
         if(dr$tokenInfoProperty != null) {
             dr$tokenInfoHashcode = 1;
             for (int i=0; i<dr$tokenInfoProperty.length; i++) {
                 dr$tokenInfoHashcode = 37 * dr$tokenInfoHashcode + dr$tokenInfoProperty[i];
             }
         }

         result = 37 * result + dr$tokenInfoHashcode;

         return result;
   }   


}


