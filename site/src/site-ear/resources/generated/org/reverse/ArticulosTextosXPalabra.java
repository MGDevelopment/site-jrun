package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * ArticulosTextosXPalabra generated by hbm2java
 */
public class ArticulosTextosXPalabra  implements java.io.Serializable {


     private ArticulosTextosXPalabraId id;
     private Articulos articulos;
     private Date FAlta;
     private Date FModi;

    public ArticulosTextosXPalabra() {
    }

	
    public ArticulosTextosXPalabra(ArticulosTextosXPalabraId id, Articulos articulos, Date FAlta) {
        this.id = id;
        this.articulos = articulos;
        this.FAlta = FAlta;
    }
    public ArticulosTextosXPalabra(ArticulosTextosXPalabraId id, Articulos articulos, Date FAlta, Date FModi) {
       this.id = id;
       this.articulos = articulos;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public ArticulosTextosXPalabraId getId() {
        return this.id;
    }
    
    public void setId(ArticulosTextosXPalabraId id) {
        this.id = id;
    }
    public Articulos getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }




}


