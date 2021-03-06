package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpReglasPuntosId generated by hbm2java
 */
public class SnpReglasPuntosId  implements java.io.Serializable {


     private long idRegla;
     private short idRepu;
     private BigDecimal desde;
     private BigDecimal hasta;
     private BigDecimal importe;
     private Integer puntos;
     private Byte multiplicador;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpReglasPuntosId() {
    }

	
    public SnpReglasPuntosId(long idRegla, short idRepu, BigDecimal desde, String usrAlta, Date FAlta) {
        this.idRegla = idRegla;
        this.idRepu = idRepu;
        this.desde = desde;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpReglasPuntosId(long idRegla, short idRepu, BigDecimal desde, BigDecimal hasta, BigDecimal importe, Integer puntos, Byte multiplicador, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idRegla = idRegla;
       this.idRepu = idRepu;
       this.desde = desde;
       this.hasta = hasta;
       this.importe = importe;
       this.puntos = puntos;
       this.multiplicador = multiplicador;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public long getIdRegla() {
        return this.idRegla;
    }
    
    public void setIdRegla(long idRegla) {
        this.idRegla = idRegla;
    }
    public short getIdRepu() {
        return this.idRepu;
    }
    
    public void setIdRepu(short idRepu) {
        this.idRepu = idRepu;
    }
    public BigDecimal getDesde() {
        return this.desde;
    }
    
    public void setDesde(BigDecimal desde) {
        this.desde = desde;
    }
    public BigDecimal getHasta() {
        return this.hasta;
    }
    
    public void setHasta(BigDecimal hasta) {
        this.hasta = hasta;
    }
    public BigDecimal getImporte() {
        return this.importe;
    }
    
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public Integer getPuntos() {
        return this.puntos;
    }
    
    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }
    public Byte getMultiplicador() {
        return this.multiplicador;
    }
    
    public void setMultiplicador(Byte multiplicador) {
        this.multiplicador = multiplicador;
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
		 if ( !(other instanceof SnpReglasPuntosId) ) return false;
		 SnpReglasPuntosId castOther = ( SnpReglasPuntosId ) other; 
         
		 return (this.getIdRegla()==castOther.getIdRegla())
 && (this.getIdRepu()==castOther.getIdRepu())
 && ( (this.getDesde()==castOther.getDesde()) || ( this.getDesde()!=null && castOther.getDesde()!=null && this.getDesde().equals(castOther.getDesde()) ) )
 && ( (this.getHasta()==castOther.getHasta()) || ( this.getHasta()!=null && castOther.getHasta()!=null && this.getHasta().equals(castOther.getHasta()) ) )
 && ( (this.getImporte()==castOther.getImporte()) || ( this.getImporte()!=null && castOther.getImporte()!=null && this.getImporte().equals(castOther.getImporte()) ) )
 && ( (this.getPuntos()==castOther.getPuntos()) || ( this.getPuntos()!=null && castOther.getPuntos()!=null && this.getPuntos().equals(castOther.getPuntos()) ) )
 && ( (this.getMultiplicador()==castOther.getMultiplicador()) || ( this.getMultiplicador()!=null && castOther.getMultiplicador()!=null && this.getMultiplicador().equals(castOther.getMultiplicador()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdRegla();
         result = 37 * result + this.getIdRepu();
         result = 37 * result + ( getDesde() == null ? 0 : this.getDesde().hashCode() );
         result = 37 * result + ( getHasta() == null ? 0 : this.getHasta().hashCode() );
         result = 37 * result + ( getImporte() == null ? 0 : this.getImporte().hashCode() );
         result = 37 * result + ( getPuntos() == null ? 0 : this.getPuntos().hashCode() );
         result = 37 * result + ( getMultiplicador() == null ? 0 : this.getMultiplicador().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


