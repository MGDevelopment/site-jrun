package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * ListasTmkCalificacion generated by hbm2java
 */
public class ListasTmkCalificacion  implements java.io.Serializable {


     private ListasTmkCalificacionId id;
     private ListasTmk listasTmk;
     private boolean calificacion;
     private short idSucursalSocioCalif;
     private long idSocioCalif;
     private Date FCalificacion;

    public ListasTmkCalificacion() {
    }

    public ListasTmkCalificacion(ListasTmkCalificacionId id, ListasTmk listasTmk, boolean calificacion, short idSucursalSocioCalif, long idSocioCalif, Date FCalificacion) {
       this.id = id;
       this.listasTmk = listasTmk;
       this.calificacion = calificacion;
       this.idSucursalSocioCalif = idSucursalSocioCalif;
       this.idSocioCalif = idSocioCalif;
       this.FCalificacion = FCalificacion;
    }
   
    public ListasTmkCalificacionId getId() {
        return this.id;
    }
    
    public void setId(ListasTmkCalificacionId id) {
        this.id = id;
    }
    public ListasTmk getListasTmk() {
        return this.listasTmk;
    }
    
    public void setListasTmk(ListasTmk listasTmk) {
        this.listasTmk = listasTmk;
    }
    public boolean isCalificacion() {
        return this.calificacion;
    }
    
    public void setCalificacion(boolean calificacion) {
        this.calificacion = calificacion;
    }
    public short getIdSucursalSocioCalif() {
        return this.idSucursalSocioCalif;
    }
    
    public void setIdSucursalSocioCalif(short idSucursalSocioCalif) {
        this.idSucursalSocioCalif = idSucursalSocioCalif;
    }
    public long getIdSocioCalif() {
        return this.idSocioCalif;
    }
    
    public void setIdSocioCalif(long idSocioCalif) {
        this.idSocioCalif = idSocioCalif;
    }
    public Date getFCalificacion() {
        return this.FCalificacion;
    }
    
    public void setFCalificacion(Date FCalificacion) {
        this.FCalificacion = FCalificacion;
    }




}


