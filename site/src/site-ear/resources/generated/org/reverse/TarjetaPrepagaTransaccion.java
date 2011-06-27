package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * TarjetaPrepagaTransaccion generated by hbm2java
 */
public class TarjetaPrepagaTransaccion  implements java.io.Serializable {


     private TarjetaPrepagaTransaccionId id;
     private TarjetaPrepaga tarjetaPrepaga;
     private String tipo;
     private BigDecimal importe;
     private Date fecha;
     private Long idOrden;
     private Long idMovimiento;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public TarjetaPrepagaTransaccion() {
    }

	
    public TarjetaPrepagaTransaccion(TarjetaPrepagaTransaccionId id, TarjetaPrepaga tarjetaPrepaga, String tipo, BigDecimal importe, Date fecha, String usrAlta, Date FAlta) {
        this.id = id;
        this.tarjetaPrepaga = tarjetaPrepaga;
        this.tipo = tipo;
        this.importe = importe;
        this.fecha = fecha;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public TarjetaPrepagaTransaccion(TarjetaPrepagaTransaccionId id, TarjetaPrepaga tarjetaPrepaga, String tipo, BigDecimal importe, Date fecha, Long idOrden, Long idMovimiento, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.id = id;
       this.tarjetaPrepaga = tarjetaPrepaga;
       this.tipo = tipo;
       this.importe = importe;
       this.fecha = fecha;
       this.idOrden = idOrden;
       this.idMovimiento = idMovimiento;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public TarjetaPrepagaTransaccionId getId() {
        return this.id;
    }
    
    public void setId(TarjetaPrepagaTransaccionId id) {
        this.id = id;
    }
    public TarjetaPrepaga getTarjetaPrepaga() {
        return this.tarjetaPrepaga;
    }
    
    public void setTarjetaPrepaga(TarjetaPrepaga tarjetaPrepaga) {
        this.tarjetaPrepaga = tarjetaPrepaga;
    }
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public BigDecimal getImporte() {
        return this.importe;
    }
    
    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Long getIdOrden() {
        return this.idOrden;
    }
    
    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }
    public Long getIdMovimiento() {
        return this.idMovimiento;
    }
    
    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
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




}


