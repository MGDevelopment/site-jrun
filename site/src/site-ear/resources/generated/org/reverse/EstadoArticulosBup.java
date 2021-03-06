package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * EstadoArticulosBup generated by hbm2java
 */
public class EstadoArticulosBup  implements java.io.Serializable {


     private long secuencia;
     private String descripcion;
     private String estado;
     private Long idDisponibilidad;
     private Date fechaDesde;
     private Date fechaHasta;
     private Long idArticulo;
     private Long categoriaSeccion;
     private Long categoriaGrupo;
     private Long categoriaFamilia;
     private Long categoriaSubfamilia;
     private Long editorial;
     private Long proveedor;
     private BigDecimal importeMinimo;
     private BigDecimal importeMaximo;
     private Date FAlta;
     private Date FModi;

    public EstadoArticulosBup() {
    }

	
    public EstadoArticulosBup(long secuencia, String descripcion, String estado) {
        this.secuencia = secuencia;
        this.descripcion = descripcion;
        this.estado = estado;
    }
    public EstadoArticulosBup(long secuencia, String descripcion, String estado, Long idDisponibilidad, Date fechaDesde, Date fechaHasta, Long idArticulo, Long categoriaSeccion, Long categoriaGrupo, Long categoriaFamilia, Long categoriaSubfamilia, Long editorial, Long proveedor, BigDecimal importeMinimo, BigDecimal importeMaximo, Date FAlta, Date FModi) {
       this.secuencia = secuencia;
       this.descripcion = descripcion;
       this.estado = estado;
       this.idDisponibilidad = idDisponibilidad;
       this.fechaDesde = fechaDesde;
       this.fechaHasta = fechaHasta;
       this.idArticulo = idArticulo;
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.editorial = editorial;
       this.proveedor = proveedor;
       this.importeMinimo = importeMinimo;
       this.importeMaximo = importeMaximo;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public long getSecuencia() {
        return this.secuencia;
    }
    
    public void setSecuencia(long secuencia) {
        this.secuencia = secuencia;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public Long getIdDisponibilidad() {
        return this.idDisponibilidad;
    }
    
    public void setIdDisponibilidad(Long idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }
    public Date getFechaDesde() {
        return this.fechaDesde;
    }
    
    public void setFechaDesde(Date fechaDesde) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaHasta() {
        return this.fechaHasta;
    }
    
    public void setFechaHasta(Date fechaHasta) {
        this.fechaHasta = fechaHasta;
    }
    public Long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Long getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(Long categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public Long getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(Long categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public Long getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(Long categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public Long getCategoriaSubfamilia() {
        return this.categoriaSubfamilia;
    }
    
    public void setCategoriaSubfamilia(Long categoriaSubfamilia) {
        this.categoriaSubfamilia = categoriaSubfamilia;
    }
    public Long getEditorial() {
        return this.editorial;
    }
    
    public void setEditorial(Long editorial) {
        this.editorial = editorial;
    }
    public Long getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Long proveedor) {
        this.proveedor = proveedor;
    }
    public BigDecimal getImporteMinimo() {
        return this.importeMinimo;
    }
    
    public void setImporteMinimo(BigDecimal importeMinimo) {
        this.importeMinimo = importeMinimo;
    }
    public BigDecimal getImporteMaximo() {
        return this.importeMaximo;
    }
    
    public void setImporteMaximo(BigDecimal importeMaximo) {
        this.importeMaximo = importeMaximo;
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


