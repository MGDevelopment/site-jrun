package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.math.BigDecimal;
import java.util.Date;

/**
 * SnpPromo2ObjetoId generated by hbm2java
 */
public class SnpPromo2ObjetoId  implements java.io.Serializable {


     private long idPromocion;
     private short item;
     private String incluirExcluir;
     private Byte categoriaSeccion;
     private Byte categoriaGrupo;
     private Byte categoriaFamilia;
     private Byte categoriaSubfamilia;
     private Long idProveedor;
     private Long idEditor;
     private Long idColeccion;
     private Long idArticulo;
     private Integer idCatalogo;
     private Long idAutor;
     private Short cantidad;
     private BigDecimal monto;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public SnpPromo2ObjetoId() {
    }

	
    public SnpPromo2ObjetoId(long idPromocion, short item, String incluirExcluir, String usrAlta, Date FAlta) {
        this.idPromocion = idPromocion;
        this.item = item;
        this.incluirExcluir = incluirExcluir;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public SnpPromo2ObjetoId(long idPromocion, short item, String incluirExcluir, Byte categoriaSeccion, Byte categoriaGrupo, Byte categoriaFamilia, Byte categoriaSubfamilia, Long idProveedor, Long idEditor, Long idColeccion, Long idArticulo, Integer idCatalogo, Long idAutor, Short cantidad, BigDecimal monto, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.idPromocion = idPromocion;
       this.item = item;
       this.incluirExcluir = incluirExcluir;
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.idProveedor = idProveedor;
       this.idEditor = idEditor;
       this.idColeccion = idColeccion;
       this.idArticulo = idArticulo;
       this.idCatalogo = idCatalogo;
       this.idAutor = idAutor;
       this.cantidad = cantidad;
       this.monto = monto;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public long getIdPromocion() {
        return this.idPromocion;
    }
    
    public void setIdPromocion(long idPromocion) {
        this.idPromocion = idPromocion;
    }
    public short getItem() {
        return this.item;
    }
    
    public void setItem(short item) {
        this.item = item;
    }
    public String getIncluirExcluir() {
        return this.incluirExcluir;
    }
    
    public void setIncluirExcluir(String incluirExcluir) {
        this.incluirExcluir = incluirExcluir;
    }
    public Byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(Byte categoriaSeccion) {
        this.categoriaSeccion = categoriaSeccion;
    }
    public Byte getCategoriaGrupo() {
        return this.categoriaGrupo;
    }
    
    public void setCategoriaGrupo(Byte categoriaGrupo) {
        this.categoriaGrupo = categoriaGrupo;
    }
    public Byte getCategoriaFamilia() {
        return this.categoriaFamilia;
    }
    
    public void setCategoriaFamilia(Byte categoriaFamilia) {
        this.categoriaFamilia = categoriaFamilia;
    }
    public Byte getCategoriaSubfamilia() {
        return this.categoriaSubfamilia;
    }
    
    public void setCategoriaSubfamilia(Byte categoriaSubfamilia) {
        this.categoriaSubfamilia = categoriaSubfamilia;
    }
    public Long getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(Long idProveedor) {
        this.idProveedor = idProveedor;
    }
    public Long getIdEditor() {
        return this.idEditor;
    }
    
    public void setIdEditor(Long idEditor) {
        this.idEditor = idEditor;
    }
    public Long getIdColeccion() {
        return this.idColeccion;
    }
    
    public void setIdColeccion(Long idColeccion) {
        this.idColeccion = idColeccion;
    }
    public Long getIdArticulo() {
        return this.idArticulo;
    }
    
    public void setIdArticulo(Long idArticulo) {
        this.idArticulo = idArticulo;
    }
    public Integer getIdCatalogo() {
        return this.idCatalogo;
    }
    
    public void setIdCatalogo(Integer idCatalogo) {
        this.idCatalogo = idCatalogo;
    }
    public Long getIdAutor() {
        return this.idAutor;
    }
    
    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }
    public Short getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }
    public BigDecimal getMonto() {
        return this.monto;
    }
    
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
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
		 if ( !(other instanceof SnpPromo2ObjetoId) ) return false;
		 SnpPromo2ObjetoId castOther = ( SnpPromo2ObjetoId ) other; 
         
		 return (this.getIdPromocion()==castOther.getIdPromocion())
 && (this.getItem()==castOther.getItem())
 && ( (this.getIncluirExcluir()==castOther.getIncluirExcluir()) || ( this.getIncluirExcluir()!=null && castOther.getIncluirExcluir()!=null && this.getIncluirExcluir().equals(castOther.getIncluirExcluir()) ) )
 && ( (this.getCategoriaSeccion()==castOther.getCategoriaSeccion()) || ( this.getCategoriaSeccion()!=null && castOther.getCategoriaSeccion()!=null && this.getCategoriaSeccion().equals(castOther.getCategoriaSeccion()) ) )
 && ( (this.getCategoriaGrupo()==castOther.getCategoriaGrupo()) || ( this.getCategoriaGrupo()!=null && castOther.getCategoriaGrupo()!=null && this.getCategoriaGrupo().equals(castOther.getCategoriaGrupo()) ) )
 && ( (this.getCategoriaFamilia()==castOther.getCategoriaFamilia()) || ( this.getCategoriaFamilia()!=null && castOther.getCategoriaFamilia()!=null && this.getCategoriaFamilia().equals(castOther.getCategoriaFamilia()) ) )
 && ( (this.getCategoriaSubfamilia()==castOther.getCategoriaSubfamilia()) || ( this.getCategoriaSubfamilia()!=null && castOther.getCategoriaSubfamilia()!=null && this.getCategoriaSubfamilia().equals(castOther.getCategoriaSubfamilia()) ) )
 && ( (this.getIdProveedor()==castOther.getIdProveedor()) || ( this.getIdProveedor()!=null && castOther.getIdProveedor()!=null && this.getIdProveedor().equals(castOther.getIdProveedor()) ) )
 && ( (this.getIdEditor()==castOther.getIdEditor()) || ( this.getIdEditor()!=null && castOther.getIdEditor()!=null && this.getIdEditor().equals(castOther.getIdEditor()) ) )
 && ( (this.getIdColeccion()==castOther.getIdColeccion()) || ( this.getIdColeccion()!=null && castOther.getIdColeccion()!=null && this.getIdColeccion().equals(castOther.getIdColeccion()) ) )
 && ( (this.getIdArticulo()==castOther.getIdArticulo()) || ( this.getIdArticulo()!=null && castOther.getIdArticulo()!=null && this.getIdArticulo().equals(castOther.getIdArticulo()) ) )
 && ( (this.getIdCatalogo()==castOther.getIdCatalogo()) || ( this.getIdCatalogo()!=null && castOther.getIdCatalogo()!=null && this.getIdCatalogo().equals(castOther.getIdCatalogo()) ) )
 && ( (this.getIdAutor()==castOther.getIdAutor()) || ( this.getIdAutor()!=null && castOther.getIdAutor()!=null && this.getIdAutor().equals(castOther.getIdAutor()) ) )
 && ( (this.getCantidad()==castOther.getCantidad()) || ( this.getCantidad()!=null && castOther.getCantidad()!=null && this.getCantidad().equals(castOther.getCantidad()) ) )
 && ( (this.getMonto()==castOther.getMonto()) || ( this.getMonto()!=null && castOther.getMonto()!=null && this.getMonto().equals(castOther.getMonto()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + (int) this.getIdPromocion();
         result = 37 * result + this.getItem();
         result = 37 * result + ( getIncluirExcluir() == null ? 0 : this.getIncluirExcluir().hashCode() );
         result = 37 * result + ( getCategoriaSeccion() == null ? 0 : this.getCategoriaSeccion().hashCode() );
         result = 37 * result + ( getCategoriaGrupo() == null ? 0 : this.getCategoriaGrupo().hashCode() );
         result = 37 * result + ( getCategoriaFamilia() == null ? 0 : this.getCategoriaFamilia().hashCode() );
         result = 37 * result + ( getCategoriaSubfamilia() == null ? 0 : this.getCategoriaSubfamilia().hashCode() );
         result = 37 * result + ( getIdProveedor() == null ? 0 : this.getIdProveedor().hashCode() );
         result = 37 * result + ( getIdEditor() == null ? 0 : this.getIdEditor().hashCode() );
         result = 37 * result + ( getIdColeccion() == null ? 0 : this.getIdColeccion().hashCode() );
         result = 37 * result + ( getIdArticulo() == null ? 0 : this.getIdArticulo().hashCode() );
         result = 37 * result + ( getIdCatalogo() == null ? 0 : this.getIdCatalogo().hashCode() );
         result = 37 * result + ( getIdAutor() == null ? 0 : this.getIdAutor().hashCode() );
         result = 37 * result + ( getCantidad() == null ? 0 : this.getCantidad().hashCode() );
         result = 37 * result + ( getMonto() == null ? 0 : this.getMonto().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


