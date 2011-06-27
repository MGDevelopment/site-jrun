package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * UsuarioXRolAplicacionId generated by hbm2java
 */
public class UsuarioXRolAplicacionId  implements java.io.Serializable {


     private String rol;
     private long idUsuario;

    public UsuarioXRolAplicacionId() {
    }

    public UsuarioXRolAplicacionId(String rol, long idUsuario) {
       this.rol = rol;
       this.idUsuario = idUsuario;
    }
   
    public String getRol() {
        return this.rol;
    }
    
    public void setRol(String rol) {
        this.rol = rol;
    }
    public long getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof UsuarioXRolAplicacionId) ) return false;
		 UsuarioXRolAplicacionId castOther = ( UsuarioXRolAplicacionId ) other; 
         
		 return ( (this.getRol()==castOther.getRol()) || ( this.getRol()!=null && castOther.getRol()!=null && this.getRol().equals(castOther.getRol()) ) )
 && (this.getIdUsuario()==castOther.getIdUsuario());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getRol() == null ? 0 : this.getRol().hashCode() );
         result = 37 * result + (int) this.getIdUsuario();
         return result;
   }   


}


