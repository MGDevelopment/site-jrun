package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * MovimientosDatosExt generated by hbm2java
 */
public class MovimientosDatosExt  implements java.io.Serializable {


     private MovimientosDatosExtId id;
     private Movimientos movimientos;
     private Short idSucursalSocio;
     private Long idSocio;
     private Short idSucursalCuenta;
     private Long idCuenta;
     private String nroTarjeta;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private String codigoExterior;
     private BigDecimal auxnumber1;
     private BigDecimal auxnumber2;
     private BigDecimal auxnumber3;
     private String auxvarchar1;
     private String auxvarchar2;
     private String auxvarchar3;
     private String auxflag1;
     private String auxflag2;
     private String auxflag3;
     private BigDecimal auxnumber4;
     private BigDecimal auxnumber5;
     private BigDecimal auxnumber6;
     private String auxvarchar4;
     private String auxvarchar5;
     private String auxvarchar6;
     private String auxflag4;
     private String auxflag5;
     private String auxflag6;
     private BigDecimal auxnumber7;
     private BigDecimal auxnumber8;
     private String auxvarchar7;
     private String auxvarchar8;
     private String auxflag7;
     private String auxflag8;
     private Date auxdate1;
     private Date auxdate2;
     private Date auxdate3;
     private Date auxdate4;
     private Date auxdate5;
     private Date auxdate6;
     private Date auxdate7;

    public MovimientosDatosExt() {
    }

	
    public MovimientosDatosExt(Movimientos movimientos) {
        this.movimientos = movimientos;
    }
    public MovimientosDatosExt(Movimientos movimientos, Short idSucursalSocio, Long idSocio, Short idSucursalCuenta, Long idCuenta, String nroTarjeta, String usrAlta, Date FAlta, String usrModi, Date FModi, String codigoExterior, BigDecimal auxnumber1, BigDecimal auxnumber2, BigDecimal auxnumber3, String auxvarchar1, String auxvarchar2, String auxvarchar3, String auxflag1, String auxflag2, String auxflag3, BigDecimal auxnumber4, BigDecimal auxnumber5, BigDecimal auxnumber6, String auxvarchar4, String auxvarchar5, String auxvarchar6, String auxflag4, String auxflag5, String auxflag6, BigDecimal auxnumber7, BigDecimal auxnumber8, String auxvarchar7, String auxvarchar8, String auxflag7, String auxflag8, Date auxdate1, Date auxdate2, Date auxdate3, Date auxdate4, Date auxdate5, Date auxdate6, Date auxdate7) {
       this.movimientos = movimientos;
       this.idSucursalSocio = idSucursalSocio;
       this.idSocio = idSocio;
       this.idSucursalCuenta = idSucursalCuenta;
       this.idCuenta = idCuenta;
       this.nroTarjeta = nroTarjeta;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.codigoExterior = codigoExterior;
       this.auxnumber1 = auxnumber1;
       this.auxnumber2 = auxnumber2;
       this.auxnumber3 = auxnumber3;
       this.auxvarchar1 = auxvarchar1;
       this.auxvarchar2 = auxvarchar2;
       this.auxvarchar3 = auxvarchar3;
       this.auxflag1 = auxflag1;
       this.auxflag2 = auxflag2;
       this.auxflag3 = auxflag3;
       this.auxnumber4 = auxnumber4;
       this.auxnumber5 = auxnumber5;
       this.auxnumber6 = auxnumber6;
       this.auxvarchar4 = auxvarchar4;
       this.auxvarchar5 = auxvarchar5;
       this.auxvarchar6 = auxvarchar6;
       this.auxflag4 = auxflag4;
       this.auxflag5 = auxflag5;
       this.auxflag6 = auxflag6;
       this.auxnumber7 = auxnumber7;
       this.auxnumber8 = auxnumber8;
       this.auxvarchar7 = auxvarchar7;
       this.auxvarchar8 = auxvarchar8;
       this.auxflag7 = auxflag7;
       this.auxflag8 = auxflag8;
       this.auxdate1 = auxdate1;
       this.auxdate2 = auxdate2;
       this.auxdate3 = auxdate3;
       this.auxdate4 = auxdate4;
       this.auxdate5 = auxdate5;
       this.auxdate6 = auxdate6;
       this.auxdate7 = auxdate7;
    }
   
    public MovimientosDatosExtId getId() {
        return this.id;
    }
    
    public void setId(MovimientosDatosExtId id) {
        this.id = id;
    }
    public Movimientos getMovimientos() {
        return this.movimientos;
    }
    
    public void setMovimientos(Movimientos movimientos) {
        this.movimientos = movimientos;
    }
    public Short getIdSucursalSocio() {
        return this.idSucursalSocio;
    }
    
    public void setIdSucursalSocio(Short idSucursalSocio) {
        this.idSucursalSocio = idSucursalSocio;
    }
    public Long getIdSocio() {
        return this.idSocio;
    }
    
    public void setIdSocio(Long idSocio) {
        this.idSocio = idSocio;
    }
    public Short getIdSucursalCuenta() {
        return this.idSucursalCuenta;
    }
    
    public void setIdSucursalCuenta(Short idSucursalCuenta) {
        this.idSucursalCuenta = idSucursalCuenta;
    }
    public Long getIdCuenta() {
        return this.idCuenta;
    }
    
    public void setIdCuenta(Long idCuenta) {
        this.idCuenta = idCuenta;
    }
    public String getNroTarjeta() {
        return this.nroTarjeta;
    }
    
    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
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
    public String getCodigoExterior() {
        return this.codigoExterior;
    }
    
    public void setCodigoExterior(String codigoExterior) {
        this.codigoExterior = codigoExterior;
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
    public BigDecimal getAuxnumber4() {
        return this.auxnumber4;
    }
    
    public void setAuxnumber4(BigDecimal auxnumber4) {
        this.auxnumber4 = auxnumber4;
    }
    public BigDecimal getAuxnumber5() {
        return this.auxnumber5;
    }
    
    public void setAuxnumber5(BigDecimal auxnumber5) {
        this.auxnumber5 = auxnumber5;
    }
    public BigDecimal getAuxnumber6() {
        return this.auxnumber6;
    }
    
    public void setAuxnumber6(BigDecimal auxnumber6) {
        this.auxnumber6 = auxnumber6;
    }
    public String getAuxvarchar4() {
        return this.auxvarchar4;
    }
    
    public void setAuxvarchar4(String auxvarchar4) {
        this.auxvarchar4 = auxvarchar4;
    }
    public String getAuxvarchar5() {
        return this.auxvarchar5;
    }
    
    public void setAuxvarchar5(String auxvarchar5) {
        this.auxvarchar5 = auxvarchar5;
    }
    public String getAuxvarchar6() {
        return this.auxvarchar6;
    }
    
    public void setAuxvarchar6(String auxvarchar6) {
        this.auxvarchar6 = auxvarchar6;
    }
    public String getAuxflag4() {
        return this.auxflag4;
    }
    
    public void setAuxflag4(String auxflag4) {
        this.auxflag4 = auxflag4;
    }
    public String getAuxflag5() {
        return this.auxflag5;
    }
    
    public void setAuxflag5(String auxflag5) {
        this.auxflag5 = auxflag5;
    }
    public String getAuxflag6() {
        return this.auxflag6;
    }
    
    public void setAuxflag6(String auxflag6) {
        this.auxflag6 = auxflag6;
    }
    public BigDecimal getAuxnumber7() {
        return this.auxnumber7;
    }
    
    public void setAuxnumber7(BigDecimal auxnumber7) {
        this.auxnumber7 = auxnumber7;
    }
    public BigDecimal getAuxnumber8() {
        return this.auxnumber8;
    }
    
    public void setAuxnumber8(BigDecimal auxnumber8) {
        this.auxnumber8 = auxnumber8;
    }
    public String getAuxvarchar7() {
        return this.auxvarchar7;
    }
    
    public void setAuxvarchar7(String auxvarchar7) {
        this.auxvarchar7 = auxvarchar7;
    }
    public String getAuxvarchar8() {
        return this.auxvarchar8;
    }
    
    public void setAuxvarchar8(String auxvarchar8) {
        this.auxvarchar8 = auxvarchar8;
    }
    public String getAuxflag7() {
        return this.auxflag7;
    }
    
    public void setAuxflag7(String auxflag7) {
        this.auxflag7 = auxflag7;
    }
    public String getAuxflag8() {
        return this.auxflag8;
    }
    
    public void setAuxflag8(String auxflag8) {
        this.auxflag8 = auxflag8;
    }
    public Date getAuxdate1() {
        return this.auxdate1;
    }
    
    public void setAuxdate1(Date auxdate1) {
        this.auxdate1 = auxdate1;
    }
    public Date getAuxdate2() {
        return this.auxdate2;
    }
    
    public void setAuxdate2(Date auxdate2) {
        this.auxdate2 = auxdate2;
    }
    public Date getAuxdate3() {
        return this.auxdate3;
    }
    
    public void setAuxdate3(Date auxdate3) {
        this.auxdate3 = auxdate3;
    }
    public Date getAuxdate4() {
        return this.auxdate4;
    }
    
    public void setAuxdate4(Date auxdate4) {
        this.auxdate4 = auxdate4;
    }
    public Date getAuxdate5() {
        return this.auxdate5;
    }
    
    public void setAuxdate5(Date auxdate5) {
        this.auxdate5 = auxdate5;
    }
    public Date getAuxdate6() {
        return this.auxdate6;
    }
    
    public void setAuxdate6(Date auxdate6) {
        this.auxdate6 = auxdate6;
    }
    public Date getAuxdate7() {
        return this.auxdate7;
    }
    
    public void setAuxdate7(Date auxdate7) {
        this.auxdate7 = auxdate7;
    }




}


