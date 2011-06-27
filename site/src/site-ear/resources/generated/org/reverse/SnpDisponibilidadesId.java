package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpDisponibilidadesId generated by hbm2java
 */
public class SnpDisponibilidadesId  implements java.io.Serializable {


     private BigDecimal idDisponibilidad;
     private String descripcion;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private String colorHex;
     private String tipoUnidad;
     private short cantUnidad;
     private String pedidoEspecial;
     private String idEsquema;

    public SnpDisponibilidadesId() {
    }

	
    public SnpDisponibilidadesId(BigDecimal idDisponibilidad, String descripcion, String usrAlta, Date FAlta, String colorHex, String tipoUnidad, short cantUnidad, String idEsquema) {
        this.idDisponibilidad = idDisponibilidad;
        this.descripcion = descripcion;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.colorHex = colorHex;
        this.tipoUnidad = tipoUnidad;
        this.cantUnidad = cantUnidad;
        this.idEsquema = idEsquema;
    }
    public SnpDisponibilidadesId(BigDecimal idDisponibilidad, String descripcion, String usrAlta, Date FAlta, String usrModi, Date FModi, String colorHex, String tipoUnidad, short cantUnidad, String pedidoEspecial, String idEsquema) {
       this.idDisponibilidad = idDisponibilidad;
       this.descripcion = descripcion;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.colorHex = colorHex;
       this.tipoUnidad = tipoUnidad;
       this.cantUnidad = cantUnidad;
       this.pedidoEspecial = pedidoEspecial;
       this.idEsquema = idEsquema;
    }
   
    public BigDecimal getIdDisponibilidad() {
        return this.idDisponibilidad;
    }
    
    public void setIdDisponibilidad(BigDecimal idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public String getColorHex() {
        return this.colorHex;
    }
    
    public void setColorHex(String colorHex) {
        this.colorHex = colorHex;
    }
    public String getTipoUnidad() {
        return this.tipoUnidad;
    }
    
    public void setTipoUnidad(String tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }
    public short getCantUnidad() {
        return this.cantUnidad;
    }
    
    public void setCantUnidad(short cantUnidad) {
        this.cantUnidad = cantUnidad;
    }
    public String getPedidoEspecial() {
        return this.pedidoEspecial;
    }
    
    public void setPedidoEspecial(String pedidoEspecial) {
        this.pedidoEspecial = pedidoEspecial;
    }
    public String getIdEsquema() {
        return this.idEsquema;
    }
    
    public void setIdEsquema(String idEsquema) {
        this.idEsquema = idEsquema;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpDisponibilidadesId) ) return false;
		 SnpDisponibilidadesId castOther = ( SnpDisponibilidadesId ) other; 
         
		 return ( (this.getIdDisponibilidad()==castOther.getIdDisponibilidad()) || ( this.getIdDisponibilidad()!=null && castOther.getIdDisponibilidad()!=null && this.getIdDisponibilidad().equals(castOther.getIdDisponibilidad()) ) )
 && ( (this.getDescripcion()==castOther.getDescripcion()) || ( this.getDescripcion()!=null && castOther.getDescripcion()!=null && this.getDescripcion().equals(castOther.getDescripcion()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getColorHex()==castOther.getColorHex()) || ( this.getColorHex()!=null && castOther.getColorHex()!=null && this.getColorHex().equals(castOther.getColorHex()) ) )
 && ( (this.getTipoUnidad()==castOther.getTipoUnidad()) || ( this.getTipoUnidad()!=null && castOther.getTipoUnidad()!=null && this.getTipoUnidad().equals(castOther.getTipoUnidad()) ) )
 && (this.getCantUnidad()==castOther.getCantUnidad())
 && ( (this.getPedidoEspecial()==castOther.getPedidoEspecial()) || ( this.getPedidoEspecial()!=null && castOther.getPedidoEspecial()!=null && this.getPedidoEspecial().equals(castOther.getPedidoEspecial()) ) )
 && ( (this.getIdEsquema()==castOther.getIdEsquema()) || ( this.getIdEsquema()!=null && castOther.getIdEsquema()!=null && this.getIdEsquema().equals(castOther.getIdEsquema()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdDisponibilidad() == null ? 0 : this.getIdDisponibilidad().hashCode() );
         result = 37 * result + ( getDescripcion() == null ? 0 : this.getDescripcion().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getColorHex() == null ? 0 : this.getColorHex().hashCode() );
         result = 37 * result + ( getTipoUnidad() == null ? 0 : this.getTipoUnidad().hashCode() );
         result = 37 * result + this.getCantUnidad();
         result = 37 * result + ( getPedidoEspecial() == null ? 0 : this.getPedidoEspecial().hashCode() );
         result = 37 * result + ( getIdEsquema() == null ? 0 : this.getIdEsquema().hashCode() );
         return result;
   }   


}


