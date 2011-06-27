package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * SnpAtributosXFamiliaId generated by hbm2java
 */
public class SnpAtributosXFamiliaId  implements java.io.Serializable {


     private byte categoriaSeccion;
     private Byte categoriaGrupo;
     private Byte categoriaFamilia;
     private Byte categoriaSubfamilia;
     private String valorDefault;
     private String campoArticulos2;
     private String prompt;
     private String tipoDato;
     private String mascara;
     private String obligatorio;
     private String dominio;
     private String validar;
     private Short posicionX;
     private Short posicionY;
     private Short anchoItem;
     private Short altoItem;
     private Date FAlta;
     private String usrAlta;
     private Date FModi;
     private String usrModi;

    public SnpAtributosXFamiliaId() {
    }

	
    public SnpAtributosXFamiliaId(byte categoriaSeccion, String campoArticulos2, String prompt) {
        this.categoriaSeccion = categoriaSeccion;
        this.campoArticulos2 = campoArticulos2;
        this.prompt = prompt;
    }
    public SnpAtributosXFamiliaId(byte categoriaSeccion, Byte categoriaGrupo, Byte categoriaFamilia, Byte categoriaSubfamilia, String valorDefault, String campoArticulos2, String prompt, String tipoDato, String mascara, String obligatorio, String dominio, String validar, Short posicionX, Short posicionY, Short anchoItem, Short altoItem, Date FAlta, String usrAlta, Date FModi, String usrModi) {
       this.categoriaSeccion = categoriaSeccion;
       this.categoriaGrupo = categoriaGrupo;
       this.categoriaFamilia = categoriaFamilia;
       this.categoriaSubfamilia = categoriaSubfamilia;
       this.valorDefault = valorDefault;
       this.campoArticulos2 = campoArticulos2;
       this.prompt = prompt;
       this.tipoDato = tipoDato;
       this.mascara = mascara;
       this.obligatorio = obligatorio;
       this.dominio = dominio;
       this.validar = validar;
       this.posicionX = posicionX;
       this.posicionY = posicionY;
       this.anchoItem = anchoItem;
       this.altoItem = altoItem;
       this.FAlta = FAlta;
       this.usrAlta = usrAlta;
       this.FModi = FModi;
       this.usrModi = usrModi;
    }
   
    public byte getCategoriaSeccion() {
        return this.categoriaSeccion;
    }
    
    public void setCategoriaSeccion(byte categoriaSeccion) {
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
    public String getValorDefault() {
        return this.valorDefault;
    }
    
    public void setValorDefault(String valorDefault) {
        this.valorDefault = valorDefault;
    }
    public String getCampoArticulos2() {
        return this.campoArticulos2;
    }
    
    public void setCampoArticulos2(String campoArticulos2) {
        this.campoArticulos2 = campoArticulos2;
    }
    public String getPrompt() {
        return this.prompt;
    }
    
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }
    public String getTipoDato() {
        return this.tipoDato;
    }
    
    public void setTipoDato(String tipoDato) {
        this.tipoDato = tipoDato;
    }
    public String getMascara() {
        return this.mascara;
    }
    
    public void setMascara(String mascara) {
        this.mascara = mascara;
    }
    public String getObligatorio() {
        return this.obligatorio;
    }
    
    public void setObligatorio(String obligatorio) {
        this.obligatorio = obligatorio;
    }
    public String getDominio() {
        return this.dominio;
    }
    
    public void setDominio(String dominio) {
        this.dominio = dominio;
    }
    public String getValidar() {
        return this.validar;
    }
    
    public void setValidar(String validar) {
        this.validar = validar;
    }
    public Short getPosicionX() {
        return this.posicionX;
    }
    
    public void setPosicionX(Short posicionX) {
        this.posicionX = posicionX;
    }
    public Short getPosicionY() {
        return this.posicionY;
    }
    
    public void setPosicionY(Short posicionY) {
        this.posicionY = posicionY;
    }
    public Short getAnchoItem() {
        return this.anchoItem;
    }
    
    public void setAnchoItem(Short anchoItem) {
        this.anchoItem = anchoItem;
    }
    public Short getAltoItem() {
        return this.altoItem;
    }
    
    public void setAltoItem(Short altoItem) {
        this.altoItem = altoItem;
    }
    public Date getFAlta() {
        return this.FAlta;
    }
    
    public void setFAlta(Date FAlta) {
        this.FAlta = FAlta;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public Date getFModi() {
        return this.FModi;
    }
    
    public void setFModi(Date FModi) {
        this.FModi = FModi;
    }
    public String getUsrModi() {
        return this.usrModi;
    }
    
    public void setUsrModi(String usrModi) {
        this.usrModi = usrModi;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof SnpAtributosXFamiliaId) ) return false;
		 SnpAtributosXFamiliaId castOther = ( SnpAtributosXFamiliaId ) other; 
         
		 return (this.getCategoriaSeccion()==castOther.getCategoriaSeccion())
 && ( (this.getCategoriaGrupo()==castOther.getCategoriaGrupo()) || ( this.getCategoriaGrupo()!=null && castOther.getCategoriaGrupo()!=null && this.getCategoriaGrupo().equals(castOther.getCategoriaGrupo()) ) )
 && ( (this.getCategoriaFamilia()==castOther.getCategoriaFamilia()) || ( this.getCategoriaFamilia()!=null && castOther.getCategoriaFamilia()!=null && this.getCategoriaFamilia().equals(castOther.getCategoriaFamilia()) ) )
 && ( (this.getCategoriaSubfamilia()==castOther.getCategoriaSubfamilia()) || ( this.getCategoriaSubfamilia()!=null && castOther.getCategoriaSubfamilia()!=null && this.getCategoriaSubfamilia().equals(castOther.getCategoriaSubfamilia()) ) )
 && ( (this.getValorDefault()==castOther.getValorDefault()) || ( this.getValorDefault()!=null && castOther.getValorDefault()!=null && this.getValorDefault().equals(castOther.getValorDefault()) ) )
 && ( (this.getCampoArticulos2()==castOther.getCampoArticulos2()) || ( this.getCampoArticulos2()!=null && castOther.getCampoArticulos2()!=null && this.getCampoArticulos2().equals(castOther.getCampoArticulos2()) ) )
 && ( (this.getPrompt()==castOther.getPrompt()) || ( this.getPrompt()!=null && castOther.getPrompt()!=null && this.getPrompt().equals(castOther.getPrompt()) ) )
 && ( (this.getTipoDato()==castOther.getTipoDato()) || ( this.getTipoDato()!=null && castOther.getTipoDato()!=null && this.getTipoDato().equals(castOther.getTipoDato()) ) )
 && ( (this.getMascara()==castOther.getMascara()) || ( this.getMascara()!=null && castOther.getMascara()!=null && this.getMascara().equals(castOther.getMascara()) ) )
 && ( (this.getObligatorio()==castOther.getObligatorio()) || ( this.getObligatorio()!=null && castOther.getObligatorio()!=null && this.getObligatorio().equals(castOther.getObligatorio()) ) )
 && ( (this.getDominio()==castOther.getDominio()) || ( this.getDominio()!=null && castOther.getDominio()!=null && this.getDominio().equals(castOther.getDominio()) ) )
 && ( (this.getValidar()==castOther.getValidar()) || ( this.getValidar()!=null && castOther.getValidar()!=null && this.getValidar().equals(castOther.getValidar()) ) )
 && ( (this.getPosicionX()==castOther.getPosicionX()) || ( this.getPosicionX()!=null && castOther.getPosicionX()!=null && this.getPosicionX().equals(castOther.getPosicionX()) ) )
 && ( (this.getPosicionY()==castOther.getPosicionY()) || ( this.getPosicionY()!=null && castOther.getPosicionY()!=null && this.getPosicionY().equals(castOther.getPosicionY()) ) )
 && ( (this.getAnchoItem()==castOther.getAnchoItem()) || ( this.getAnchoItem()!=null && castOther.getAnchoItem()!=null && this.getAnchoItem().equals(castOther.getAnchoItem()) ) )
 && ( (this.getAltoItem()==castOther.getAltoItem()) || ( this.getAltoItem()!=null && castOther.getAltoItem()!=null && this.getAltoItem().equals(castOther.getAltoItem()) ) )
 && ( (this.getFAlta()==castOther.getFAlta()) || ( this.getFAlta()!=null && castOther.getFAlta()!=null && this.getFAlta().equals(castOther.getFAlta()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) )
 && ( (this.getUsrModi()==castOther.getUsrModi()) || ( this.getUsrModi()!=null && castOther.getUsrModi()!=null && this.getUsrModi().equals(castOther.getUsrModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getCategoriaSeccion();
         result = 37 * result + ( getCategoriaGrupo() == null ? 0 : this.getCategoriaGrupo().hashCode() );
         result = 37 * result + ( getCategoriaFamilia() == null ? 0 : this.getCategoriaFamilia().hashCode() );
         result = 37 * result + ( getCategoriaSubfamilia() == null ? 0 : this.getCategoriaSubfamilia().hashCode() );
         result = 37 * result + ( getValorDefault() == null ? 0 : this.getValorDefault().hashCode() );
         result = 37 * result + ( getCampoArticulos2() == null ? 0 : this.getCampoArticulos2().hashCode() );
         result = 37 * result + ( getPrompt() == null ? 0 : this.getPrompt().hashCode() );
         result = 37 * result + ( getTipoDato() == null ? 0 : this.getTipoDato().hashCode() );
         result = 37 * result + ( getMascara() == null ? 0 : this.getMascara().hashCode() );
         result = 37 * result + ( getObligatorio() == null ? 0 : this.getObligatorio().hashCode() );
         result = 37 * result + ( getDominio() == null ? 0 : this.getDominio().hashCode() );
         result = 37 * result + ( getValidar() == null ? 0 : this.getValidar().hashCode() );
         result = 37 * result + ( getPosicionX() == null ? 0 : this.getPosicionX().hashCode() );
         result = 37 * result + ( getPosicionY() == null ? 0 : this.getPosicionY().hashCode() );
         result = 37 * result + ( getAnchoItem() == null ? 0 : this.getAnchoItem().hashCode() );
         result = 37 * result + ( getAltoItem() == null ? 0 : this.getAltoItem().hashCode() );
         result = 37 * result + ( getFAlta() == null ? 0 : this.getFAlta().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         result = 37 * result + ( getUsrModi() == null ? 0 : this.getUsrModi().hashCode() );
         return result;
   }   


}


