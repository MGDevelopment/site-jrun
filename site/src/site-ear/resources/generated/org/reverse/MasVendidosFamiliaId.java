package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * MasVendidosFamiliaId generated by hbm2java
 */
public class MasVendidosFamiliaId  implements java.io.Serializable {


     private byte categoriaSeccion;
     private byte categoriaGrupo;
     private byte categoriaFamilia;
     private long idArticulo;

    public MasVendidosFamiliaId() {
    }

    public MasVendidosFamiliaId(byte categoriaSeccion, byte categoriaGrupo, byte categoriaFamilia, long idArticulo) {
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.idArticulo = idArticulo;
    }
   
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public byte getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(byte categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public byte getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(byte categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof MasVendidosFamiliaId) ) return false;
		 MasVendidosFamiliaId castOther = ( MasVendidosFamiliaId ) other; 
         
		 return (this.getCategoriaSeccion()==castOther.getCategoriaSeccion())
 && (this.getCategoriaGrupo()==castOther.getCategoriaGrupo())
 && (this.getCategoriaFamilia()==castOther.getCategoriaFamilia())
 && (this.getIdArticulo()==castOther.getIdArticulo());
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCategoriaSeccion();
         result = 37 * result + this.getCategoriaGrupo();
         result = 37 * result + this.getCategoriaFamilia();
         result = 37 * result + (int) this.getIdArticulo();
         return result;
   }   


}


