package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * ListasTmkCalificacionId generated by hbm2java
 */
public class ListasTmkCalificacionId  implements java.io.Serializable {


     private long idLista;
     private long idCalificacion;

    public ListasTmkCalificacionId() {
    }

    public ListasTmkCalificacionId(long idLista, long idCalificacion) {
       this.idLista = idLista;
       this.idCalificacion = idCalificacion;
    }
   
    public long getIdLista() {
        return this.idLista;
    }
    
    public void setIdLista(long idLista) {
        this.idLista = idLista;
    }
    public long getIdCalificacion() {
        return this.idCalificacion;
    }
    
    public void setIdCalificacion(long idCalificacion) {
        this.idCalificacion = idCalificacion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ListasTmkCalificacionId) ) return false;
		 ListasTmkCalificacionId castOther = ( ListasTmkCalificacionId ) other; 
         
		 return (this.getIdLista()==castOther.getIdLista())
 && (this.getIdCalificacion()==castOther.getIdCalificacion());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdLista();
         result = 37 * result + (int) this.getIdCalificacion();
         return result;
   }   


}


