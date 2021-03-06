package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpTarjetaRangos2Id generated by hbm2java
 */
public class SnpTarjetaRangos2Id  implements java.io.Serializable {


     private String idMedioCobro;
     private String nroDesde;
     private String nroHasta;
     private String permiteOffline;
     private String permiteCuotas;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private BigDecimal longitud;
     private String validaDigVerific;
     private Long idBanco;
     private Integer idPais;
     private String categTarjeta;

    public SnpTarjetaRangos2Id() {
    }

	
    public SnpTarjetaRangos2Id(String idMedioCobro, String nroDesde, String permiteOffline, String permiteCuotas, String usrAlta, Date FAlta) {
        this.idMedioCobro = idMedioCobro;
        this.nroDesde = nroDesde;
        this.permiteOffline = permiteOffline;
        this.permiteCuotas = permiteCuotas;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpTarjetaRangos2Id(String idMedioCobro, String nroDesde, String nroHasta, String permiteOffline, String permiteCuotas, String usrAlta, Date FAlta, String usrModi, Date FModi, BigDecimal longitud, String validaDigVerific, Long idBanco, Integer idPais, String categTarjeta) {
       this.idMedioCobro = idMedioCobro;
       this.nroDesde = nroDesde;
       this.nroHasta = nroHasta;
       this.permiteOffline = permiteOffline;
       this.permiteCuotas = permiteCuotas;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.longitud = longitud;
       this.validaDigVerific = validaDigVerific;
       this.idBanco = idBanco;
       this.idPais = idPais;
       this.categTarjeta = categTarjeta;
    }
   
    public String getIdMedioCobro() {
        return this.idMedioCobro;
    }
    
    public void setIdMedioCobro(String idMedioCobro) {
        this.idMedioCobro = idMedioCobro;
    }
    public String getNroDesde() {
        return this.nroDesde;
    }
    
    public void setNroDesde(String nroDesde) {
        this.nroDesde = nroDesde;
    }
    public String getNroHasta() {
        return this.nroHasta;
    }
    
    public void setNroHasta(String nroHasta) {
        this.nroHasta = nroHasta;
    }
    public String getPermiteOffline() {
        return this.permiteOffline;
    }
    
    public void setPermiteOffline(String permiteOffline) {
        this.permiteOffline = permiteOffline;
    }
    public String getPermiteCuotas() {
        return this.permiteCuotas;
    }
    
    public void setPermiteCuotas(String permiteCuotas) {
        this.permiteCuotas = permiteCuotas;
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
    public BigDecimal getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(BigDecimal longitud) {
        this.longitud = longitud;
    }
    public String getValidaDigVerific() {
        return this.validaDigVerific;
    }
    
    public void setValidaDigVerific(String validaDigVerific) {
        this.validaDigVerific = validaDigVerific;
    }
    public Long getIdBanco() {
        return this.idBanco;
    }
    
    public void setIdBanco(Long idBanco) {
        this.idBanco = idBanco;
    }
    public Integer getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(Integer idPais) {
        this.idPais = idPais;
    }
    public String getCategTarjeta() {
        return this.categTarjeta;
    }
    
    public void setCategTarjeta(String categTarjeta) {
        this.categTarjeta = categTarjeta;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpTarjetaRangos2Id) ) return false;
		 SnpTarjetaRangos2Id castOther = ( SnpTarjetaRangos2Id ) other; 
         
		 return ( (this.getIdMedioCobro()==castOther.getIdMedioCobro()) || ( this.getIdMedioCobro()!=null && castOther.getIdMedioCobro()!=null && this.getIdMedioCobro().equals(castOther.getIdMedioCobro()) ) )
 && ( (this.getNroDesde()==castOther.getNroDesde()) || ( this.getNroDesde()!=null && castOther.getNroDesde()!=null && this.getNroDesde().equals(castOther.getNroDesde()) ) )
 && ( (this.getNroHasta()==castOther.getNroHasta()) || ( this.getNroHasta()!=null && castOther.getNroHasta()!=null && this.getNroHasta().equals(castOther.getNroHasta()) ) )
 && ( (this.getPermiteOffline()==castOther.getPermiteOffline()) || ( this.getPermiteOffline()!=null && castOther.getPermiteOffline()!=null && this.getPermiteOffline().equals(castOther.getPermiteOffline()) ) )
 && ( (this.getPermiteCuotas()==castOther.getPermiteCuotas()) || ( this.getPermiteCuotas()!=null && castOther.getPermiteCuotas()!=null && this.getPermiteCuotas().equals(castOther.getPermiteCuotas()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getLongitud()==castOther.getLongitud()) || ( this.getLongitud()!=null && castOther.getLongitud()!=null && this.getLongitud().equals(castOther.getLongitud()) ) )
 && ( (this.getValidaDigVerific()==castOther.getValidaDigVerific()) || ( this.getValidaDigVerific()!=null && castOther.getValidaDigVerific()!=null && this.getValidaDigVerific().equals(castOther.getValidaDigVerific()) ) )
 && ( (this.getIdBanco()==castOther.getIdBanco()) || ( this.getIdBanco()!=null && castOther.getIdBanco()!=null && this.getIdBanco().equals(castOther.getIdBanco()) ) )
 && ( (this.getIdPais()==castOther.getIdPais()) || ( this.getIdPais()!=null && castOther.getIdPais()!=null && this.getIdPais().equals(castOther.getIdPais()) ) )
 && ( (this.getCategTarjeta()==castOther.getCategTarjeta()) || ( this.getCategTarjeta()!=null && castOther.getCategTarjeta()!=null && this.getCategTarjeta().equals(castOther.getCategTarjeta()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + ( getIdMedioCobro() == null ? 0 : this.getIdMedioCobro().hashCode() );
         result = 37 * result + ( getNroDesde() == null ? 0 : this.getNroDesde().hashCode() );
         result = 37 * result + ( getNroHasta() == null ? 0 : this.getNroHasta().hashCode() );
         result = 37 * result + ( getPermiteOffline() == null ? 0 : this.getPermiteOffline().hashCode() );
         result = 37 * result + ( getPermiteCuotas() == null ? 0 : this.getPermiteCuotas().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getLongitud() == null ? 0 : this.getLongitud().hashCode() );
         result = 37 * result + ( getValidaDigVerific() == null ? 0 : this.getValidaDigVerific().hashCode() );
         result = 37 * result + ( getIdBanco() == null ? 0 : this.getIdBanco().hashCode() );
         result = 37 * result + ( getIdPais() == null ? 0 : this.getIdPais().hashCode() );
         result = 37 * result + ( getCategTarjeta() == null ? 0 : this.getCategTarjeta().hashCode() );
         return result;
   }   


}


