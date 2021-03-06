package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpProveedores5Id generated by hbm2java
 */
public class SnpProveedores5Id  implements java.io.Serializable {


     private long idTipoContribuyente;
     private long idProveedor;
     private String nombre;
     private String razonSocial;
     private String direccion;
     private String codigoPostal;
     private String telefono;
     private String observacion;
     private int pagoIdFormaPago;
     private String fax;
     private Date fechaAlta;
     private String cuit;
     private BigDecimal descuento;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;
     private Long idUsrAlta;
     private Long idUsrModi;
     private int idProvincia;
     private int idLocalidad;
     private int idPais;
     private Date fechaUltimoPedido;
     private String formaComercial;
     private Date fechaUltimaLiq;
     private Date fechaBaja;
     private String generarPedidosAutom;
     private String diasPedidosAutom;
     private Short frecPedidosAutom;
     private Date fechaUltimoPedidoAutom;
     private Integer entCodigo;
     private String permiteNd;
     private Short plazoPago;
     private Date fechaCierreMensualLiquid;
     private String leyenda;
     private String auxvarchar1;
     private String auxvarchar2;
     private String auxvarchar3;
     private BigDecimal auxnumber1;
     private BigDecimal auxnumber2;
     private BigDecimal auxnumber3;
     private String auxflag1;
     private String auxflag2;
     private String auxflag3;
     private String mcaCtaYOrden;
     private Date fechaUltimaLiqAjustes;
     private Date auxdate1;
     private Date auxdate2;
     private Date auxdate3;

    public SnpProveedores5Id() {
    }

	
    public SnpProveedores5Id(long idTipoContribuyente, long idProveedor, String nombre, int pagoIdFormaPago, Date fechaAlta, String usrAlta, Date FAlta, int idProvincia, int idLocalidad, int idPais) {
        this.idTipoContribuyente = idTipoContribuyente;
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.pagoIdFormaPago = pagoIdFormaPago;
        this.fechaAlta = fechaAlta;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
        this.idProvincia = idProvincia;
        this.idLocalidad = idLocalidad;
        this.idPais = idPais;
    }
    public SnpProveedores5Id(long idTipoContribuyente, long idProveedor, String nombre, String razonSocial, String direccion, String codigoPostal, String telefono, String observacion, int pagoIdFormaPago, String fax, Date fechaAlta, String cuit, BigDecimal descuento, String usrAlta, Date FAlta, String usrModi, Date FModi, Long idUsrAlta, Long idUsrModi, int idProvincia, int idLocalidad, int idPais, Date fechaUltimoPedido, String formaComercial, Date fechaUltimaLiq, Date fechaBaja, String generarPedidosAutom, String diasPedidosAutom, Short frecPedidosAutom, Date fechaUltimoPedidoAutom, Integer entCodigo, String permiteNd, Short plazoPago, Date fechaCierreMensualLiquid, String leyenda, String auxvarchar1, String auxvarchar2, String auxvarchar3, BigDecimal auxnumber1, BigDecimal auxnumber2, BigDecimal auxnumber3, String auxflag1, String auxflag2, String auxflag3, String mcaCtaYOrden, Date fechaUltimaLiqAjustes, Date auxdate1, Date auxdate2, Date auxdate3) {
       this.idTipoContribuyente = idTipoContribuyente;
       this.idProveedor = idProveedor;
       this.nombre = nombre;
       this.razonSocial = razonSocial;
       this.direccion = direccion;
       this.codigoPostal = codigoPostal;
       this.telefono = telefono;
       this.observacion = observacion;
       this.pagoIdFormaPago = pagoIdFormaPago;
       this.fax = fax;
       this.fechaAlta = fechaAlta;
       this.cuit = cuit;
       this.descuento = descuento;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
       this.idUsrAlta = idUsrAlta;
       this.idUsrModi = idUsrModi;
       this.idProvincia = idProvincia;
       this.idLocalidad = idLocalidad;
       this.idPais = idPais;
       this.fechaUltimoPedido = fechaUltimoPedido;
       this.formaComercial = formaComercial;
       this.fechaUltimaLiq = fechaUltimaLiq;
       this.fechaBaja = fechaBaja;
       this.generarPedidosAutom = generarPedidosAutom;
       this.diasPedidosAutom = diasPedidosAutom;
       this.frecPedidosAutom = frecPedidosAutom;
       this.fechaUltimoPedidoAutom = fechaUltimoPedidoAutom;
       this.entCodigo = entCodigo;
       this.permiteNd = permiteNd;
       this.plazoPago = plazoPago;
       this.fechaCierreMensualLiquid = fechaCierreMensualLiquid;
       this.leyenda = leyenda;
       this.auxvarchar1 = auxvarchar1;
       this.auxvarchar2 = auxvarchar2;
       this.auxvarchar3 = auxvarchar3;
       this.auxnumber1 = auxnumber1;
       this.auxnumber2 = auxnumber2;
       this.auxnumber3 = auxnumber3;
       this.auxflag1 = auxflag1;
       this.auxflag2 = auxflag2;
       this.auxflag3 = auxflag3;
       this.mcaCtaYOrden = mcaCtaYOrden;
       this.fechaUltimaLiqAjustes = fechaUltimaLiqAjustes;
       this.auxdate1 = auxdate1;
       this.auxdate2 = auxdate2;
       this.auxdate3 = auxdate3;
    }
   
    public long getIdTipoContribuyente() {
        return this.idTipoContribuyente;
    }
    
    public void setIdTipoContribuyente(long idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }
    public long getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(long idProveedor) {
        this.idProveedor = idProveedor;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRazonSocial() {
        return this.razonSocial;
    }
    
    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getCodigoPostal() {
        return this.codigoPostal;
    }
    
    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
    public String getTelefono() {
        return this.telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getObservacion() {
        return this.observacion;
    }
    
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public int getPagoIdFormaPago() {
        return this.pagoIdFormaPago;
    }
    
    public void setPagoIdFormaPago(int pagoIdFormaPago) {
        this.pagoIdFormaPago = pagoIdFormaPago;
    }
    public String getFax() {
        return this.fax;
    }
    
    public void setFax(String fax) {
        this.fax = fax;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getCuit() {
        return this.cuit;
    }
    
    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    public BigDecimal getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
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
    public Long getIdUsrAlta() {
        return this.idUsrAlta;
    }
    
    public void setIdUsrAlta(Long idUsrAlta) {
        this.idUsrAlta = idUsrAlta;
    }
    public Long getIdUsrModi() {
        return this.idUsrModi;
    }
    
    public void setIdUsrModi(Long idUsrModi) {
        this.idUsrModi = idUsrModi;
    }
    public int getIdProvincia() {
        return this.idProvincia;
    }
    
    public void setIdProvincia(int idProvincia) {
        this.idProvincia = idProvincia;
    }
    public int getIdLocalidad() {
        return this.idLocalidad;
    }
    
    public void setIdLocalidad(int idLocalidad) {
        this.idLocalidad = idLocalidad;
    }
    public int getIdPais() {
        return this.idPais;
    }
    
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }
    public Date getFechaUltimoPedido() {
        return this.fechaUltimoPedido;
    }
    
    public void setFechaUltimoPedido(Date fechaUltimoPedido) {
        this.fechaUltimoPedido = fechaUltimoPedido;
    }
    public String getFormaComercial() {
        return this.formaComercial;
    }
    
    public void setFormaComercial(String formaComercial) {
        this.formaComercial = formaComercial;
    }
    public Date getFechaUltimaLiq() {
        return this.fechaUltimaLiq;
    }
    
    public void setFechaUltimaLiq(Date fechaUltimaLiq) {
        this.fechaUltimaLiq = fechaUltimaLiq;
    }
    public Date getFechaBaja() {
        return this.fechaBaja;
    }
    
    public void setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    public String getGenerarPedidosAutom() {
        return this.generarPedidosAutom;
    }
    
    public void setGenerarPedidosAutom(String generarPedidosAutom) {
        this.generarPedidosAutom = generarPedidosAutom;
    }
    public String getDiasPedidosAutom() {
        return this.diasPedidosAutom;
    }
    
    public void setDiasPedidosAutom(String diasPedidosAutom) {
        this.diasPedidosAutom = diasPedidosAutom;
    }
    public Short getFrecPedidosAutom() {
        return this.frecPedidosAutom;
    }
    
    public void setFrecPedidosAutom(Short frecPedidosAutom) {
        this.frecPedidosAutom = frecPedidosAutom;
    }
    public Date getFechaUltimoPedidoAutom() {
        return this.fechaUltimoPedidoAutom;
    }
    
    public void setFechaUltimoPedidoAutom(Date fechaUltimoPedidoAutom) {
        this.fechaUltimoPedidoAutom = fechaUltimoPedidoAutom;
    }
    public Integer getEntCodigo() {
        return this.entCodigo;
    }
    
    public void setEntCodigo(Integer entCodigo) {
        this.entCodigo = entCodigo;
    }
    public String getPermiteNd() {
        return this.permiteNd;
    }
    
    public void setPermiteNd(String permiteNd) {
        this.permiteNd = permiteNd;
    }
    public Short getPlazoPago() {
        return this.plazoPago;
    }
    
    public void setPlazoPago(Short plazoPago) {
        this.plazoPago = plazoPago;
    }
    public Date getFechaCierreMensualLiquid() {
        return this.fechaCierreMensualLiquid;
    }
    
    public void setFechaCierreMensualLiquid(Date fechaCierreMensualLiquid) {
        this.fechaCierreMensualLiquid = fechaCierreMensualLiquid;
    }
    public String getLeyenda() {
        return this.leyenda;
    }
    
    public void setLeyenda(String leyenda) {
        this.leyenda = leyenda;
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
    public String getMcaCtaYOrden() {
        return this.mcaCtaYOrden;
    }
    
    public void setMcaCtaYOrden(String mcaCtaYOrden) {
        this.mcaCtaYOrden = mcaCtaYOrden;
    }
    public Date getFechaUltimaLiqAjustes() {
        return this.fechaUltimaLiqAjustes;
    }
    
    public void setFechaUltimaLiqAjustes(Date fechaUltimaLiqAjustes) {
        this.fechaUltimaLiqAjustes = fechaUltimaLiqAjustes;
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


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpProveedores5Id) ) return false;
		 SnpProveedores5Id castOther = ( SnpProveedores5Id ) other; 
         
		 return (this.getIdTipoContribuyente()==castOther.getIdTipoContribuyente())
 && (this.getIdProveedor()==castOther.getIdProveedor())
 && ( (this.getNombre()==castOther.getNombre()) || ( this.getNombre()!=null && castOther.getNombre()!=null && this.getNombre().equals(castOther.getNombre()) ) )
 && ( (this.getRazonSocial()==castOther.getRazonSocial()) || ( this.getRazonSocial()!=null && castOther.getRazonSocial()!=null && this.getRazonSocial().equals(castOther.getRazonSocial()) ) )
 && ( (this.getDireccion()==castOther.getDireccion()) || ( this.getDireccion()!=null && castOther.getDireccion()!=null && this.getDireccion().equals(castOther.getDireccion()) ) )
 && ( (this.getCodigoPostal()==castOther.getCodigoPostal()) || ( this.getCodigoPostal()!=null && castOther.getCodigoPostal()!=null && this.getCodigoPostal().equals(castOther.getCodigoPostal()) ) )
 && ( (this.getTelefono()==castOther.getTelefono()) || ( this.getTelefono()!=null && castOther.getTelefono()!=null && this.getTelefono().equals(castOther.getTelefono()) ) )
 && ( (this.getObservacion()==castOther.getObservacion()) || ( this.getObservacion()!=null && castOther.getObservacion()!=null && this.getObservacion().equals(castOther.getObservacion()) ) )
 && (this.getPagoIdFormaPago()==castOther.getPagoIdFormaPago())
 && ( (this.getFax()==castOther.getFax()) || ( this.getFax()!=null && castOther.getFax()!=null && this.getFax().equals(castOther.getFax()) ) )
 && ( (this.getFechaAlta()==castOther.getFechaAlta()) || ( this.getFechaAlta()!=null && castOther.getFechaAlta()!=null && this.getFechaAlta().equals(castOther.getFechaAlta()) ) )
 && ( (this.getCuit()==castOther.getCuit()) || ( this.getCuit()!=null && castOther.getCuit()!=null && this.getCuit().equals(castOther.getCuit()) ) )
 && ( (this.getDescuento()==castOther.getDescuento()) || ( this.getDescuento()!=null && castOther.getDescuento()!=null && this.getDescuento().equals(castOther.getDescuento()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getIdUsrAlta()==castOther.getIdUsrAlta()) || ( this.getIdUsrAlta()!=null && castOther.getIdUsrAlta()!=null && this.getIdUsrAlta().equals(castOther.getIdUsrAlta()) ) )
 && ( (this.getIdUsrModi()==castOther.getIdUsrModi()) || ( this.getIdUsrModi()!=null && castOther.getIdUsrModi()!=null && this.getIdUsrModi().equals(castOther.getIdUsrModi()) ) )
 && (this.getIdProvincia()==castOther.getIdProvincia())
 && (this.getIdLocalidad()==castOther.getIdLocalidad())
 && (this.getIdPais()==castOther.getIdPais())
 && ( (this.getFechaUltimoPedido()==castOther.getFechaUltimoPedido()) || ( this.getFechaUltimoPedido()!=null && castOther.getFechaUltimoPedido()!=null && this.getFechaUltimoPedido().equals(castOther.getFechaUltimoPedido()) ) )
 && ( (this.getFormaComercial()==castOther.getFormaComercial()) || ( this.getFormaComercial()!=null && castOther.getFormaComercial()!=null && this.getFormaComercial().equals(castOther.getFormaComercial()) ) )
 && ( (this.getFechaUltimaLiq()==castOther.getFechaUltimaLiq()) || ( this.getFechaUltimaLiq()!=null && castOther.getFechaUltimaLiq()!=null && this.getFechaUltimaLiq().equals(castOther.getFechaUltimaLiq()) ) )
 && ( (this.getFechaBaja()==castOther.getFechaBaja()) || ( this.getFechaBaja()!=null && castOther.getFechaBaja()!=null && this.getFechaBaja().equals(castOther.getFechaBaja()) ) )
 && ( (this.getGenerarPedidosAutom()==castOther.getGenerarPedidosAutom()) || ( this.getGenerarPedidosAutom()!=null && castOther.getGenerarPedidosAutom()!=null && this.getGenerarPedidosAutom().equals(castOther.getGenerarPedidosAutom()) ) )
 && ( (this.getDiasPedidosAutom()==castOther.getDiasPedidosAutom()) || ( this.getDiasPedidosAutom()!=null && castOther.getDiasPedidosAutom()!=null && this.getDiasPedidosAutom().equals(castOther.getDiasPedidosAutom()) ) )
 && ( (this.getFrecPedidosAutom()==castOther.getFrecPedidosAutom()) || ( this.getFrecPedidosAutom()!=null && castOther.getFrecPedidosAutom()!=null && this.getFrecPedidosAutom().equals(castOther.getFrecPedidosAutom()) ) )
 && ( (this.getFechaUltimoPedidoAutom()==castOther.getFechaUltimoPedidoAutom()) || ( this.getFechaUltimoPedidoAutom()!=null && castOther.getFechaUltimoPedidoAutom()!=null && this.getFechaUltimoPedidoAutom().equals(castOther.getFechaUltimoPedidoAutom()) ) )
 && ( (this.getEntCodigo()==castOther.getEntCodigo()) || ( this.getEntCodigo()!=null && castOther.getEntCodigo()!=null && this.getEntCodigo().equals(castOther.getEntCodigo()) ) )
 && ( (this.getPermiteNd()==castOther.getPermiteNd()) || ( this.getPermiteNd()!=null && castOther.getPermiteNd()!=null && this.getPermiteNd().equals(castOther.getPermiteNd()) ) )
 && ( (this.getPlazoPago()==castOther.getPlazoPago()) || ( this.getPlazoPago()!=null && castOther.getPlazoPago()!=null && this.getPlazoPago().equals(castOther.getPlazoPago()) ) )
 && ( (this.getFechaCierreMensualLiquid()==castOther.getFechaCierreMensualLiquid()) || ( this.getFechaCierreMensualLiquid()!=null && castOther.getFechaCierreMensualLiquid()!=null && this.getFechaCierreMensualLiquid().equals(castOther.getFechaCierreMensualLiquid()) ) )
 && ( (this.getLeyenda()==castOther.getLeyenda()) || ( this.getLeyenda()!=null && castOther.getLeyenda()!=null && this.getLeyenda().equals(castOther.getLeyenda()) ) )
 && ( (this.getAuxvarchar1()==castOther.getAuxvarchar1()) || ( this.getAuxvarchar1()!=null && castOther.getAuxvarchar1()!=null && this.getAuxvarchar1().equals(castOther.getAuxvarchar1()) ) )
 && ( (this.getAuxvarchar2()==castOther.getAuxvarchar2()) || ( this.getAuxvarchar2()!=null && castOther.getAuxvarchar2()!=null && this.getAuxvarchar2().equals(castOther.getAuxvarchar2()) ) )
 && ( (this.getAuxvarchar3()==castOther.getAuxvarchar3()) || ( this.getAuxvarchar3()!=null && castOther.getAuxvarchar3()!=null && this.getAuxvarchar3().equals(castOther.getAuxvarchar3()) ) )
 && ( (this.getAuxnumber1()==castOther.getAuxnumber1()) || ( this.getAuxnumber1()!=null && castOther.getAuxnumber1()!=null && this.getAuxnumber1().equals(castOther.getAuxnumber1()) ) )
 && ( (this.getAuxnumber2()==castOther.getAuxnumber2()) || ( this.getAuxnumber2()!=null && castOther.getAuxnumber2()!=null && this.getAuxnumber2().equals(castOther.getAuxnumber2()) ) )
 && ( (this.getAuxnumber3()==castOther.getAuxnumber3()) || ( this.getAuxnumber3()!=null && castOther.getAuxnumber3()!=null && this.getAuxnumber3().equals(castOther.getAuxnumber3()) ) )
 && ( (this.getAuxflag1()==castOther.getAuxflag1()) || ( this.getAuxflag1()!=null && castOther.getAuxflag1()!=null && this.getAuxflag1().equals(castOther.getAuxflag1()) ) )
 && ( (this.getAuxflag2()==castOther.getAuxflag2()) || ( this.getAuxflag2()!=null && castOther.getAuxflag2()!=null && this.getAuxflag2().equals(castOther.getAuxflag2()) ) )
 && ( (this.getAuxflag3()==castOther.getAuxflag3()) || ( this.getAuxflag3()!=null && castOther.getAuxflag3()!=null && this.getAuxflag3().equals(castOther.getAuxflag3()) ) )
 && ( (this.getMcaCtaYOrden()==castOther.getMcaCtaYOrden()) || ( this.getMcaCtaYOrden()!=null && castOther.getMcaCtaYOrden()!=null && this.getMcaCtaYOrden().equals(castOther.getMcaCtaYOrden()) ) )
 && ( (this.getFechaUltimaLiqAjustes()==castOther.getFechaUltimaLiqAjustes()) || ( this.getFechaUltimaLiqAjustes()!=null && castOther.getFechaUltimaLiqAjustes()!=null && this.getFechaUltimaLiqAjustes().equals(castOther.getFechaUltimaLiqAjustes()) ) )
 && ( (this.getAuxdate1()==castOther.getAuxdate1()) || ( this.getAuxdate1()!=null && castOther.getAuxdate1()!=null && this.getAuxdate1().equals(castOther.getAuxdate1()) ) )
 && ( (this.getAuxdate2()==castOther.getAuxdate2()) || ( this.getAuxdate2()!=null && castOther.getAuxdate2()!=null && this.getAuxdate2().equals(castOther.getAuxdate2()) ) )
 && ( (this.getAuxdate3()==castOther.getAuxdate3()) || ( this.getAuxdate3()!=null && castOther.getAuxdate3()!=null && this.getAuxdate3().equals(castOther.getAuxdate3()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdTipoContribuyente();
         result = 37 * result + (int) this.getIdProveedor();
         result = 37 * result + ( getNombre() == null ? 0 : this.getNombre().hashCode() );
         result = 37 * result + ( getRazonSocial() == null ? 0 : this.getRazonSocial().hashCode() );
         result = 37 * result + ( getDireccion() == null ? 0 : this.getDireccion().hashCode() );
         result = 37 * result + ( getCodigoPostal() == null ? 0 : this.getCodigoPostal().hashCode() );
         result = 37 * result + ( getTelefono() == null ? 0 : this.getTelefono().hashCode() );
         result = 37 * result + ( getObservacion() == null ? 0 : this.getObservacion().hashCode() );
         result = 37 * result + this.getPagoIdFormaPago();
         result = 37 * result + ( getFax() == null ? 0 : this.getFax().hashCode() );
         result = 37 * result + ( getFechaAlta() == null ? 0 : this.getFechaAlta().hashCode() );
         result = 37 * result + ( getCuit() == null ? 0 : this.getCuit().hashCode() );
         result = 37 * result + ( getDescuento() == null ? 0 : this.getDescuento().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getIdUsrAlta() == null ? 0 : this.getIdUsrAlta().hashCode() );
         result = 37 * result + ( getIdUsrModi() == null ? 0 : this.getIdUsrModi().hashCode() );
         result = 37 * result + this.getIdProvincia();
         result = 37 * result + this.getIdLocalidad();
         result = 37 * result + this.getIdPais();
         result = 37 * result + ( getFechaUltimoPedido() == null ? 0 : this.getFechaUltimoPedido().hashCode() );
         result = 37 * result + ( getFormaComercial() == null ? 0 : this.getFormaComercial().hashCode() );
         result = 37 * result + ( getFechaUltimaLiq() == null ? 0 : this.getFechaUltimaLiq().hashCode() );
         result = 37 * result + ( getFechaBaja() == null ? 0 : this.getFechaBaja().hashCode() );
         result = 37 * result + ( getGenerarPedidosAutom() == null ? 0 : this.getGenerarPedidosAutom().hashCode() );
         result = 37 * result + ( getDiasPedidosAutom() == null ? 0 : this.getDiasPedidosAutom().hashCode() );
         result = 37 * result + ( getFrecPedidosAutom() == null ? 0 : this.getFrecPedidosAutom().hashCode() );
         result = 37 * result + ( getFechaUltimoPedidoAutom() == null ? 0 : this.getFechaUltimoPedidoAutom().hashCode() );
         result = 37 * result + ( getEntCodigo() == null ? 0 : this.getEntCodigo().hashCode() );
         result = 37 * result + ( getPermiteNd() == null ? 0 : this.getPermiteNd().hashCode() );
         result = 37 * result + ( getPlazoPago() == null ? 0 : this.getPlazoPago().hashCode() );
         result = 37 * result + ( getFechaCierreMensualLiquid() == null ? 0 : this.getFechaCierreMensualLiquid().hashCode() );
         result = 37 * result + ( getLeyenda() == null ? 0 : this.getLeyenda().hashCode() );
         result = 37 * result + ( getAuxvarchar1() == null ? 0 : this.getAuxvarchar1().hashCode() );
         result = 37 * result + ( getAuxvarchar2() == null ? 0 : this.getAuxvarchar2().hashCode() );
         result = 37 * result + ( getAuxvarchar3() == null ? 0 : this.getAuxvarchar3().hashCode() );
         result = 37 * result + ( getAuxnumber1() == null ? 0 : this.getAuxnumber1().hashCode() );
         result = 37 * result + ( getAuxnumber2() == null ? 0 : this.getAuxnumber2().hashCode() );
         result = 37 * result + ( getAuxnumber3() == null ? 0 : this.getAuxnumber3().hashCode() );
         result = 37 * result + ( getAuxflag1() == null ? 0 : this.getAuxflag1().hashCode() );
         result = 37 * result + ( getAuxflag2() == null ? 0 : this.getAuxflag2().hashCode() );
         result = 37 * result + ( getAuxflag3() == null ? 0 : this.getAuxflag3().hashCode() );
         result = 37 * result + ( getMcaCtaYOrden() == null ? 0 : this.getMcaCtaYOrden().hashCode() );
         result = 37 * result + ( getFechaUltimaLiqAjustes() == null ? 0 : this.getFechaUltimaLiqAjustes().hashCode() );
         result = 37 * result + ( getAuxdate1() == null ? 0 : this.getAuxdate1().hashCode() );
         result = 37 * result + ( getAuxdate2() == null ? 0 : this.getAuxdate2().hashCode() );
         result = 37 * result + ( getAuxdate3() == null ? 0 : this.getAuxdate3().hashCode() );
         return result;
   }   


}


