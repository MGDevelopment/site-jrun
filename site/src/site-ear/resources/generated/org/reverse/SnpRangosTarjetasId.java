package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpRangosTarjetasId generated by hbm2java
 */
public class SnpRangosTarjetasId  implements java.io.Serializable {


     private short idSucursal;
     private String nroTarjetaDesde;
     private String nroTarjetaHasta;
     private Date fechaVigencia;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpRangosTarjetasId() {
    }

	
    public SnpRangosTarjetasId(short idSucursal, String nroTarjetaDesde, String nroTarjetaHasta, Date fechaVigencia, String usrAlta, Date FAlta) {
        this.idSucursal = idSucursal;
        this.nroTarjetaDesde = nroTarjetaDesde;
        this.nroTarjetaHasta = nroTarjetaHasta;
        this.fechaVigencia = fechaVigencia;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpRangosTarjetasId(short idSucursal, String nroTarjetaDesde, String nroTarjetaHasta, Date fechaVigencia, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idSucursal = idSucursal;
       this.nroTarjetaDesde = nroTarjetaDesde;
       this.nroTarjetaHasta = nroTarjetaHasta;
       this.fechaVigencia = fechaVigencia;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public String getNroTarjetaDesde() {
        return this.nroTarjetaDesde;
    }
    
    public void setNroTarjetaDesde(String nroTarjetaDesde) {
        this.nroTarjetaDesde = nroTarjetaDesde;
    }
    public String getNroTarjetaHasta() {
        return this.nroTarjetaHasta;
    }
    
    public void setNroTarjetaHasta(String nroTarjetaHasta) {
        this.nroTarjetaHasta = nroTarjetaHasta;
    }
    public Date getFechaVigencia() {
        return this.fechaVigencia;
    }
    
    public void setFechaVigencia(Date fechaVigencia) {
        this.fechaVigencia = fechaVigencia;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpRangosTarjetasId) ) return false;
		 SnpRangosTarjetasId castOther = ( SnpRangosTarjetasId ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && ( (this.getNroTarjetaDesde()==castOther.getNroTarjetaDesde()) || ( this.getNroTarjetaDesde()!=null && castOther.getNroTarjetaDesde()!=null && this.getNroTarjetaDesde().equals(castOther.getNroTarjetaDesde()) ) )
 && ( (this.getNroTarjetaHasta()==castOther.getNroTarjetaHasta()) || ( this.getNroTarjetaHasta()!=null && castOther.getNroTarjetaHasta()!=null && this.getNroTarjetaHasta().equals(castOther.getNroTarjetaHasta()) ) )
 && ( (this.getFechaVigencia()==castOther.getFechaVigencia()) || ( this.getFechaVigencia()!=null && castOther.getFechaVigencia()!=null && this.getFechaVigencia().equals(castOther.getFechaVigencia()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + ( getNroTarjetaDesde() == null ? 0 : this.getNroTarjetaDesde().hashCode() );
         result = 37 * result + ( getNroTarjetaHasta() == null ? 0 : this.getNroTarjetaHasta().hashCode() );
         result = 37 * result + ( getFechaVigencia() == null ? 0 : this.getFechaVigencia().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


