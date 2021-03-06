package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * FuncionXRolAplicacionId generated by hbm2java
 */
public class FuncionXRolAplicacionId  implements java.io.Serializable {


     private String rol;
     private String funcion;

    public FuncionXRolAplicacionId() {
    }

    public FuncionXRolAplicacionId(String rol, String funcion) {
       this.rol = rol;
       this.funcion = funcion;
    }
   
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public String getFuncion() {
        return this.funcion;
    }
    
    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof FuncionXRolAplicacionId) ) return false;
		 FuncionXRolAplicacionId castOther = ( FuncionXRolAplicacionId ) other; 
         
		 return ( (this.getRol()==castOther.getRol()) || ( this.getRol()!=null && castOther.getRol()!=null && this.getRol().equals(castOther.getRol()) ) )
 && ( (this.getFuncion()==castOther.getFuncion()) || ( this.getFuncion()!=null && castOther.getFuncion()!=null && this.getFuncion().equals(castOther.getFuncion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRol() == null ? 0 : this.getRol().hashCode() );
         result = 37 * result + ( getFuncion() == null ? 0 : this.getFuncion().hashCode() );
         return result;
   }   


}


