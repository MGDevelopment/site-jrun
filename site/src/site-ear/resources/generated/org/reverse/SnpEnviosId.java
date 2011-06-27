package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpEnviosId generated by hbm2java
 */
public class SnpEnviosId  implements java.io.Serializable {


     private short idSucursal;
     private long idEnvio;
     private String nro;
     private Date fechaEnvio;
     private BigDecimal peso;
     private String enviado;
     private long idMovimiento;
     private Short idSucursalFact;
     private Long idMovimientoFact;
     private String emailEnviado;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private short idMetodoEnvio;
     private Date fechaTransmision;
     private BigDecimal nroRemito;
     private BigDecimal auxnumber1;
     private BigDecimal auxnumber2;
     private BigDecimal auxnumber3;
     private String auxvarchar1;
     private String auxvarchar2;
     private String auxvarchar3;
     private String auxflag1;
     private String auxflag2;
     private String auxflag3;

    public SnpEnviosId() {
    }

	
    public SnpEnviosId(short idSucursal, long idEnvio, String nro, String enviado, long idMovimiento, String usrAlta, Date FAlta, short idMetodoEnvio) {
        this.idSucursal = idSucursal;
        this.idEnvio = idEnvio;
        this.nro = nro;
        this.enviado = enviado;
        this.idMovimiento = idMovimiento;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.idMetodoEnvio = idMetodoEnvio;
    }
    public SnpEnviosId(short idSucursal, long idEnvio, String nro, Date fechaEnvio, BigDecimal peso, String enviado, long idMovimiento, Short idSucursalFact, Long idMovimientoFact, String emailEnviado, String usrAlta, Date FAlta, String usrModi, Date FModi, short idMetodoEnvio, Date fechaTransmision, BigDecimal nroRemito, BigDecimal auxnumber1, BigDecimal auxnumber2, BigDecimal auxnumber3, String auxvarchar1, String auxvarchar2, String auxvarchar3, String auxflag1, String auxflag2, String auxflag3) {
       this.idSucursal = idSucursal;
       this.idEnvio = idEnvio;
       this.nro = nro;
       this.fechaEnvio = fechaEnvio;
       this.peso = peso;
       this.enviado = enviado;
       this.idMovimiento = idMovimiento;
       this.idSucursalFact = idSucursalFact;
       this.idMovimientoFact = idMovimientoFact;
       this.emailEnviado = emailEnviado;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idMetodoEnvio = idMetodoEnvio;
       this.fechaTransmision = fechaTransmision;
       this.nroRemito = nroRemito;
       this.auxnumber1 = auxnumber1;
       this.auxnumber2 = auxnumber2;
       this.auxnumber3 = auxnumber3;
       this.auxvarchar1 = auxvarchar1;
       this.auxvarchar2 = auxvarchar2;
       this.auxvarchar3 = auxvarchar3;
       this.auxflag1 = auxflag1;
       this.auxflag2 = auxflag2;
       this.auxflag3 = auxflag3;
    }
   
    public short getIdSucursal() {
        return this.idSucursal;
    }
    
    public void setIdSucursal(short idSucursal) {
        this.idSucursal = idSucursal;
    }
    public long getIdEnvio() {
        return this.idEnvio;
    }
    
    public void setIdEnvio(long idEnvio) {
        this.idEnvio = idEnvio;
    }
    public String getNro() {
        return this.nro;
    }
    
    public void setNro(String nro) {
        this.nro = nro;
    }
    public Date getFechaEnvio() {
        return this.fechaEnvio;
    }
    
    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
    public BigDecimal getPeso() {
        return this.peso;
    }
    
    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }
    public String getEnviado() {
        return this.enviado;
    }
    
    public void setEnviado(String enviado) {
        this.enviado = enviado;
    }
    public long getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }
    public Short getIdSucursalFact() {
        return this.idSucursalFact;
    }
    
    public void setIdSucursalFact(Short idSucursalFact) {
        this.idSucursalFact = idSucursalFact;
    }
    public Long getIdMovimientoFact() {
        return this.idMovimientoFact;
    }
    
    public void setIdMovimientoFact(Long idMovimientoFact) {
        this.idMovimientoFact = idMovimientoFact;
    }
    public String getEmailEnviado() {
        return this.emailEnviado;
    }
    
    public void setEmailEnviado(String emailEnviado) {
        this.emailEnviado = emailEnviado;
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
    public short getIdMetodoEnvio() {
        return this.idMetodoEnvio;
    }
    
    public void setIdMetodoEnvio(short idMetodoEnvio) {
        this.idMetodoEnvio = idMetodoEnvio;
    }
    public Date getFechaTransmision() {
        return this.fechaTransmision;
    }
    
    public void setFechaTransmision(Date fechaTransmision) {
        this.fechaTransmision = fechaTransmision;
    }
    public BigDecimal getNroRemito() {
        return this.nroRemito;
    }
    
    public void setNroRemito(BigDecimal nroRemito) {
        this.nroRemito = nroRemito;
    }
    public BigDecimal getAuxnumber1() {
        return this.auxnumber1;
    }
    
    public void setAuxnumber1(BigDecimal auxnumber1) {
        this.auxnumber1 = auxnumber1;
    }
    public BigDecimal getAuxnumber2() {
        return this.auxnumber2;
    }
    
    public void setAuxnumber2(BigDecimal auxnumber2) {
        this.auxnumber2 = auxnumber2;
    }
    public BigDecimal getAuxnumber3() {
        return this.auxnumber3;
    }
    
    public void setAuxnumber3(BigDecimal auxnumber3) {
        this.auxnumber3 = auxnumber3;
    }
    public String getAuxvarchar1() {
        return this.auxvarchar1;
    }
    
    public void setAuxvarchar1(String auxvarchar1) {
        this.auxvarchar1 = auxvarchar1;
    }
    public String getAuxvarchar2() {
        return this.auxvarchar2;
    }
    
    public void setAuxvarchar2(String auxvarchar2) {
        this.auxvarchar2 = auxvarchar2;
    }
    public String getAuxvarchar3() {
        return this.auxvarchar3;
    }
    
    public void setAuxvarchar3(String auxvarchar3) {
        this.auxvarchar3 = auxvarchar3;
    }
    public String getAuxflag1() {
        return this.auxflag1;
    }
    
    public void setAuxflag1(String auxflag1) {
        this.auxflag1 = auxflag1;
    }
    public String getAuxflag2() {
        return this.auxflag2;
    }
    
    public void setAuxflag2(String auxflag2) {
        this.auxflag2 = auxflag2;
    }
    public String getAuxflag3() {
        return this.auxflag3;
    }
    
    public void setAuxflag3(String auxflag3) {
        this.auxflag3 = auxflag3;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpEnviosId) ) return false;
		 SnpEnviosId castOther = ( SnpEnviosId ) other; 
         
		 return (this.getIdSucursal()==castOther.getIdSucursal())
 && (this.getIdEnvio()==castOther.getIdEnvio())
 && ( (this.getNro()==castOther.getNro()) || ( this.getNro()!=null && castOther.getNro()!=null && this.getNro().equals(castOther.getNro()) ) )
 && ( (this.getFechaEnvio()==castOther.getFechaEnvio()) || ( this.getFechaEnvio()!=null && castOther.getFechaEnvio()!=null && this.getFechaEnvio().equals(castOther.getFechaEnvio()) ) )
 && ( (this.getPeso()==castOther.getPeso()) || ( this.getPeso()!=null && castOther.getPeso()!=null && this.getPeso().equals(castOther.getPeso()) ) )
 && ( (this.getEnviado()==castOther.getEnviado()) || ( this.getEnviado()!=null && castOther.getEnviado()!=null && this.getEnviado().equals(castOther.getEnviado()) ) )
 && (this.getIdMovimiento()==castOther.getIdMovimiento())
 && ( (this.getIdSucursalFact()==castOther.getIdSucursalFact()) || ( this.getIdSucursalFact()!=null && castOther.getIdSucursalFact()!=null && this.getIdSucursalFact().equals(castOther.getIdSucursalFact()) ) )
 && ( (this.getIdMovimientoFact()==castOther.getIdMovimientoFact()) || ( this.getIdMovimientoFact()!=null && castOther.getIdMovimientoFact()!=null && this.getIdMovimientoFact().equals(castOther.getIdMovimientoFact()) ) )
 && ( (this.getEmailEnviado()==castOther.getEmailEnviado()) || ( this.getEmailEnviado()!=null && castOther.getEmailEnviado()!=null && this.getEmailEnviado().equals(castOther.getEmailEnviado()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && (this.getIdMetodoEnvio()==castOther.getIdMetodoEnvio())
 && ( (this.getFechaTransmision()==castOther.getFechaTransmision()) || ( this.getFechaTransmision()!=null && castOther.getFechaTransmision()!=null && this.getFechaTransmision().equals(castOther.getFechaTransmision()) ) )
 && ( (this.getNroRemito()==castOther.getNroRemito()) || ( this.getNroRemito()!=null && castOther.getNroRemito()!=null && this.getNroRemito().equals(castOther.getNroRemito()) ) )
 && ( (this.getAuxnumber1()==castOther.getAuxnumber1()) || ( this.getAuxnumber1()!=null && castOther.getAuxnumber1()!=null && this.getAuxnumber1().equals(castOther.getAuxnumber1()) ) )
 && ( (this.getAuxnumber2()==castOther.getAuxnumber2()) || ( this.getAuxnumber2()!=null && castOther.getAuxnumber2()!=null && this.getAuxnumber2().equals(castOther.getAuxnumber2()) ) )
 && ( (this.getAuxnumber3()==castOther.getAuxnumber3()) || ( this.getAuxnumber3()!=null && castOther.getAuxnumber3()!=null && this.getAuxnumber3().equals(castOther.getAuxnumber3()) ) )
 && ( (this.getAuxvarchar1()==castOther.getAuxvarchar1()) || ( this.getAuxvarchar1()!=null && castOther.getAuxvarchar1()!=null && this.getAuxvarchar1().equals(castOther.getAuxvarchar1()) ) )
 && ( (this.getAuxvarchar2()==castOther.getAuxvarchar2()) || ( this.getAuxvarchar2()!=null && castOther.getAuxvarchar2()!=null && this.getAuxvarchar2().equals(castOther.getAuxvarchar2()) ) )
 && ( (this.getAuxvarchar3()==castOther.getAuxvarchar3()) || ( this.getAuxvarchar3()!=null && castOther.getAuxvarchar3()!=null && this.getAuxvarchar3().equals(castOther.getAuxvarchar3()) ) )
 && ( (this.getAuxflag1()==castOther.getAuxflag1()) || ( this.getAuxflag1()!=null && castOther.getAuxflag1()!=null && this.getAuxflag1().equals(castOther.getAuxflag1()) ) )
 && ( (this.getAuxflag2()==castOther.getAuxflag2()) || ( this.getAuxflag2()!=null && castOther.getAuxflag2()!=null && this.getAuxflag2().equals(castOther.getAuxflag2()) ) )
 && ( (this.getAuxflag3()==castOther.getAuxflag3()) || ( this.getAuxflag3()!=null && castOther.getAuxflag3()!=null && this.getAuxflag3().equals(castOther.getAuxflag3()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdSucursal();
         result = 37 * result + (int) this.getIdEnvio();
         result = 37 * result + ( getNro() == null ? 0 : this.getNro().hashCode() );
         result = 37 * result + ( getFechaEnvio() == null ? 0 : this.getFechaEnvio().hashCode() );
         result = 37 * result + ( getPeso() == null ? 0 : this.getPeso().hashCode() );
         result = 37 * result + ( getEnviado() == null ? 0 : this.getEnviado().hashCode() );
         result = 37 * result + (int) this.getIdMovimiento();
         result = 37 * result + ( getIdSucursalFact() == null ? 0 : this.getIdSucursalFact().hashCode() );
         result = 37 * result + ( getIdMovimientoFact() == null ? 0 : this.getIdMovimientoFact().hashCode() );
         result = 37 * result + ( getEmailEnviado() == null ? 0 : this.getEmailEnviado().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + this.getIdMetodoEnvio();
         result = 37 * result + ( getFechaTransmision() == null ? 0 : this.getFechaTransmision().hashCode() );
         result = 37 * result + ( getNroRemito() == null ? 0 : this.getNroRemito().hashCode() );
         result = 37 * result + ( getAuxnumber1() == null ? 0 : this.getAuxnumber1().hashCode() );
         result = 37 * result + ( getAuxnumber2() == null ? 0 : this.getAuxnumber2().hashCode() );
         result = 37 * result + ( getAuxnumber3() == null ? 0 : this.getAuxnumber3().hashCode() );
         result = 37 * result + ( getAuxvarchar1() == null ? 0 : this.getAuxvarchar1().hashCode() );
         result = 37 * result + ( getAuxvarchar2() == null ? 0 : this.getAuxvarchar2().hashCode() );
         result = 37 * result + ( getAuxvarchar3() == null ? 0 : this.getAuxvarchar3().hashCode() );
         result = 37 * result + ( getAuxflag1() == null ? 0 : this.getAuxflag1().hashCode() );
         result = 37 * result + ( getAuxflag2() == null ? 0 : this.getAuxflag2().hashCode() );
         result = 37 * result + ( getAuxflag3() == null ? 0 : this.getAuxflag3().hashCode() );
         return result;
   }   


}


