package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * LogCambioArticulos generated by hbm2java
 */
public class LogCambioArticulos  implements java.io.Serializable {


     private long idArticulo;
     private Articulos articulos;
     private Date fecha;
     private String usuario;
     private String procesado;
     private String accion;

    public LogCambioArticulos() {
    }

    public LogCambioArticulos(Articulos articulos, Date fecha, String usuario, String procesado, String accion) {
       this.articulos = articulos;
       this.fecha = fecha;
       this.usuario = usuario;
       this.procesado = procesado;
       this.accion = accion;
    }
   
    public long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Articulos getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Articulos articulos) {
        this.articulos = articulos;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getProcesado() {
        return this.procesado;
    }
    
    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }
    public String getAccion() {
        return this.accion;
    }
    
    public void setAccion(String accion) {
        this.accion = accion;
    }




}


