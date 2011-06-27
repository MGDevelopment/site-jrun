package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;

/**
 * ArticulosMesaRecomendadosId generated by hbm2java
 */
public class ArticulosMesaRecomendadosId  implements java.io.Serializable {


     private BigDecimal idArticulo;
     private String agrupacion;
     private String enFiltro;
     private BigDecimal posicion;

    public ArticulosMesaRecomendadosId() {
    }

    public ArticulosMesaRecomendadosId(BigDecimal idArticulo, String agrupacion, String enFiltro, BigDecimal posicion) {
       this.idArticulo = idArticulo;
       this.agrupacion = agrupacion;
       this.enFiltro = enFiltro;
       this.posicion = posicion;
    }
   
    public BigDecimal getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(BigDecimal idArticulo) {
        this.idArticulo = idArticulo;
    }
    public String getAgrupacion() {
        return this.agrupacion;
    }
    
    public void setAgrupacion(String agrupacion) {
        this.agrupacion = agrupacion;
    }
    public String getEnFiltro() {
        return this.enFiltro;
    }
    
    public void setEnFiltro(String enFiltro) {
        this.enFiltro = enFiltro;
    }
    public BigDecimal getPosicion() {
        return this.posicion;
    }
    
    public void setPosicion(BigDecimal posicion) {
        this.posicion = posicion;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof ArticulosMesaRecomendadosId) ) return false;
		 ArticulosMesaRecomendadosId castOther = ( ArticulosMesaRecomendadosId ) other; 
         
		 return ( (this.getIdArticulo()==castOther.getIdArticulo()) || ( this.getIdArticulo()!=null && castOther.getIdArticulo()!=null && this.getIdArticulo().equals(castOther.getIdArticulo()) ) )
 && ( (this.getAgrupacion()==castOther.getAgrupacion()) || ( this.getAgrupacion()!=null && castOther.getAgrupacion()!=null && this.getAgrupacion().equals(castOther.getAgrupacion()) ) )
 && ( (this.getEnFiltro()==castOther.getEnFiltro()) || ( this.getEnFiltro()!=null && castOther.getEnFiltro()!=null && this.getEnFiltro().equals(castOther.getEnFiltro()) ) )
 && ( (this.getPosicion()==castOther.getPosicion()) || ( this.getPosicion()!=null && castOther.getPosicion()!=null && this.getPosicion().equals(castOther.getPosicion()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdArticulo() == null ? 0 : this.getIdArticulo().hashCode() );
         result = 37 * result + ( getAgrupacion() == null ? 0 : this.getAgrupacion().hashCode() );
         result = 37 * result + ( getEnFiltro() == null ? 0 : this.getEnFiltro().hashCode() );
         result = 37 * result + ( getPosicion() == null ? 0 : this.getPosicion().hashCode() );
         return result;
   }   


}


