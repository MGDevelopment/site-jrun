package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * ArticulosGenerados generated by hbm2java
 */
public class ArticulosGenerados  implements java.io.Serializable {


     private BigDecimal idArtGen;
     private int clave;
     private byte alcance;
     private Date fecha;
     private String procesado;
     private String extra;
     private Date FAlta;
     private Date FModi;

    public ArticulosGenerados() {
    }

	
    public ArticulosGenerados(BigDecimal idArtGen, int clave, byte alcance, Date fecha, String procesado) {
        this.idArtGen = idArtGen;
        this.clave = clave;
        this.alcance = alcance;
        this.fecha = fecha;
        this.procesado = procesado;
    }
    public ArticulosGenerados(BigDecimal idArtGen, int clave, byte alcance, Date fecha, String procesado, String extra, Date FAlta, Date FModi) {
       this.idArtGen = idArtGen;
       this.clave = clave;
       this.alcance = alcance;
       this.fecha = fecha;
       this.procesado = procesado;
       this.extra = extra;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public BigDecimal getIdArtGen() {
        return this.idArtGen;
    }
    
    public void setIdArtGen(BigDecimal idArtGen) {
        this.idArtGen = idArtGen;
    }
    public int getClave() {
        return this.clave;
    }
    
    public void setClave(int clave) {
        this.clave = clave;
    }
    public byte getAlcance() {
        return this.alcance;
    }
    
    public void setAlcance(byte alcance) {
        this.alcance = alcance;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getProcesado() {
        return this.procesado;
    }
    
    public void setProcesado(String procesado) {
        this.procesado = procesado;
    }
    public String getExtra() {
        return this.extra;
    }
    
    public void setExtra(String extra) {
        this.extra = extra;
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


