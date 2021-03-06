package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticulosArticulosTextos generated by hbm2java
 */
public class ArticulosArticulosTextos  implements java.io.Serializable {


     private ArticulosArticulosTextosId id;
     private Articulos articulos;
     private String titulo;
     private Date fechaAlta;
     private BigDecimal precioVentaVigente;
     private byte categoriaSeccion;
     private Long orden;
     private String pedidoEspecial;
     private String texto;

    public ArticulosArticulosTextos() {
    }

	
    public ArticulosArticulosTextos(ArticulosArticulosTextosId id, Articulos articulos, String titulo, Date fechaAlta, byte categoriaSeccion, String pedidoEspecial, String texto) {
        this.id = id;
        this.articulos = articulos;
        this.titulo = titulo;
        this.fechaAlta = fechaAlta;
        this.categoriaSeccion = categoriaSeccion;
        this.pedidoEspecial = pedidoEspecial;
        this.texto = texto;
    }
    public ArticulosArticulosTextos(ArticulosArticulosTextosId id, Articulos articulos, String titulo, Date fechaAlta, BigDecimal precioVentaVigente, byte categoriaSeccion, Long orden, String pedidoEspecial, String texto) {
       this.id = id;
       this.articulos = articulos;
       this.titulo = titulo;
       this.fechaAlta = fechaAlta;
       this.precioVentaVigente = precioVentaVigente;
       this.categoriaSeccion = categoriaSeccion;
       this.orden = orden;
       this.pedidoEspecial = pedidoEspecial;
       this.texto = texto;
    }
   
    public ArticulosArticulosTextosId getId() {
        return this.id;
    }
    
    public void setId(ArticulosArticulosTextosId id) {
        this.id = id;
    }
    public Articulos getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public BigDecimal getPrecioVentaVigente() {
        return this.precioVentaVigente;
    }
    
    public void setPrecioVentaVigente(BigDecimal precioVentaVigente) {
        this.precioVentaVigente = precioVentaVigente;
    }
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public Long getOrden() {
        return this.orden;
    }
    
    public void setOrden(Long orden) {
        this.orden = orden;
    }
    public String getPedidoEspecial() {
        return this.pedidoEspecial;
    }
    
    public void setPedidoEspecial(String pedidoEspecial) {
        this.pedidoEspecial = pedidoEspecial;
    }
    public String getTexto() {
        return this.texto;
    }
    
    public void setTexto(String texto) {
        this.texto = texto;
    }




}


