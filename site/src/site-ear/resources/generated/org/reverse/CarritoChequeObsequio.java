package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;

/**
 * CarritoChequeObsequio generated by hbm2java
 */
public class CarritoChequeObsequio  implements java.io.Serializable {


     private CarritoChequeObsequioId id;
     private Articulos articulos;
     private BigDecimal precioUnitario;

    public CarritoChequeObsequio() {
    }

	
    public CarritoChequeObsequio(CarritoChequeObsequioId id, Articulos articulos) {
        this.id = id;
        this.articulos = articulos;
    }
    public CarritoChequeObsequio(CarritoChequeObsequioId id, Articulos articulos, BigDecimal precioUnitario) {
       this.id = id;
       this.articulos = articulos;
       this.precioUnitario = precioUnitario;
    }
   
    public CarritoChequeObsequioId getId() {
        return this.id;
    }
    
    public void setId(CarritoChequeObsequioId id) {
        this.id = id;
    }
    public Articulos getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    public BigDecimal getPrecioUnitario() {
        return this.precioUnitario;
    }
    
    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }




}


