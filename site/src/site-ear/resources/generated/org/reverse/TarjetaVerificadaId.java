package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Arrays;
import java.util.Date;

/**
 * TarjetaVerificadaId generated by hbm2java
 */
public class TarjetaVerificadaId  implements java.io.Serializable {


     private byte[] nroTarjeta;
     private String nombresSocio;
     private String apellidosSocio;
     private String EMail;
     private String calleEnvio;
     private Long numeroEnvio;
     private String edificioEnvio;
     private Short pisoEnvio;
     private String deptoEnvio;
     private String cpEnvio;
     private Integer idPaisEnvio;
     private Integer idProvinciaEnvio;
     private Integer idLocalidadEnvio;
     private String calleFact;
     private Long numeroFact;
     private String edificioFact;
     private Short pisoFact;
     private String deptoFact;
     private String cpFact;
     private Integer idPaisFact;
     private Integer idProvinciaFact;
     private Integer idLocalidadFact;
     private boolean nivelRiesgo;
     private String comentarios;
     private Date fechaAlta;
     private String usrAlta;
     private String auxDireccionEnvio;
     private String auxDireccionFact;
     private String auxNombresApellidos;
     private Long id;
     private Date FModi;

    public TarjetaVerificadaId() {
    }

	
    public TarjetaVerificadaId(byte[] nroTarjeta, boolean nivelRiesgo, Date fechaAlta, String usrAlta) {
        this.nroTarjeta = nroTarjeta;
        this.nivelRiesgo = nivelRiesgo;
        this.fechaAlta = fechaAlta;
        this.usrAlta = usrAlta;
    }
    public TarjetaVerificadaId(byte[] nroTarjeta, String nombresSocio, String apellidosSocio, String EMail, String calleEnvio, Long numeroEnvio, String edificioEnvio, Short pisoEnvio, String deptoEnvio, String cpEnvio, Integer idPaisEnvio, Integer idProvinciaEnvio, Integer idLocalidadEnvio, String calleFact, Long numeroFact, String edificioFact, Short pisoFact, String deptoFact, String cpFact, Integer idPaisFact, Integer idProvinciaFact, Integer idLocalidadFact, boolean nivelRiesgo, String comentarios, Date fechaAlta, String usrAlta, String auxDireccionEnvio, String auxDireccionFact, String auxNombresApellidos, Long id, Date FModi) {
       this.nroTarjeta = nroTarjeta;
       this.nombresSocio = nombresSocio;
       this.apellidosSocio = apellidosSocio;
       this.EMail = EMail;
       this.calleEnvio = calleEnvio;
       this.numeroEnvio = numeroEnvio;
       this.edificioEnvio = edificioEnvio;
       this.pisoEnvio = pisoEnvio;
       this.deptoEnvio = deptoEnvio;
       this.cpEnvio = cpEnvio;
       this.idPaisEnvio = idPaisEnvio;
       this.idProvinciaEnvio = idProvinciaEnvio;
       this.idLocalidadEnvio = idLocalidadEnvio;
       this.calleFact = calleFact;
       this.numeroFact = numeroFact;
       this.edificioFact = edificioFact;
       this.pisoFact = pisoFact;
       this.deptoFact = deptoFact;
       this.cpFact = cpFact;
       this.idPaisFact = idPaisFact;
       this.idProvinciaFact = idProvinciaFact;
       this.idLocalidadFact = idLocalidadFact;
       this.nivelRiesgo = nivelRiesgo;
       this.comentarios = comentarios;
       this.fechaAlta = fechaAlta;
       this.usrAlta = usrAlta;
       this.auxDireccionEnvio = auxDireccionEnvio;
       this.auxDireccionFact = auxDireccionFact;
       this.auxNombresApellidos = auxNombresApellidos;
       this.id = id;
       this.FModi = FModi;
    }
   
    public byte[] getNroTarjeta() {
        return this.nroTarjeta;
    }
    
    public void setNroTarjeta(byte[] nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }
    public String getNombresSocio() {
        return this.nombresSocio;
    }
    
    public void setNombresSocio(String nombresSocio) {
        this.nombresSocio = nombresSocio;
    }
    public String getApellidosSocio() {
        return this.apellidosSocio;
    }
    
    public void setApellidosSocio(String apellidosSocio) {
        this.apellidosSocio = apellidosSocio;
    }
    public String getEMail() {
        return this.EMail;
    }
    
    public void setEMail(String EMail) {
        this.EMail = EMail;
    }
    public String getCalleEnvio() {
        return this.calleEnvio;
    }
    
    public void setCalleEnvio(String calleEnvio) {
        this.calleEnvio = calleEnvio;
    }
    public Long getNumeroEnvio() {
        return this.numeroEnvio;
    }
    
    public void setNumeroEnvio(Long numeroEnvio) {
        this.numeroEnvio = numeroEnvio;
    }
    public String getEdificioEnvio() {
        return this.edificioEnvio;
    }
    
    public void setEdificioEnvio(String edificioEnvio) {
        this.edificioEnvio = edificioEnvio;
    }
    public Short getPisoEnvio() {
        return this.pisoEnvio;
    }
    
    public void setPisoEnvio(Short pisoEnvio) {
        this.pisoEnvio = pisoEnvio;
    }
    public String getDeptoEnvio() {
        return this.deptoEnvio;
    }
    
    public void setDeptoEnvio(String deptoEnvio) {
        this.deptoEnvio = deptoEnvio;
    }
    public String getCpEnvio() {
        return this.cpEnvio;
    }
    
    public void setCpEnvio(String cpEnvio) {
        this.cpEnvio = cpEnvio;
    }
    public Integer getIdPaisEnvio() {
        return this.idPaisEnvio;
    }
    
    public void setIdPaisEnvio(Integer idPaisEnvio) {
        this.idPaisEnvio = idPaisEnvio;
    }
    public Integer getIdProvinciaEnvio() {
        return this.idProvinciaEnvio;
    }
    
    public void setIdProvinciaEnvio(Integer idProvinciaEnvio) {
        this.idProvinciaEnvio = idProvinciaEnvio;
    }
    public Integer getIdLocalidadEnvio() {
        return this.idLocalidadEnvio;
    }
    
    public void setIdLocalidadEnvio(Integer idLocalidadEnvio) {
        this.idLocalidadEnvio = idLocalidadEnvio;
    }
    public String getCalleFact() {
        return this.calleFact;
    }
    
    public void setCalleFact(String calleFact) {
        this.calleFact = calleFact;
    }
    public Long getNumeroFact() {
        return this.numeroFact;
    }
    
    public void setNumeroFact(Long numeroFact) {
        this.numeroFact = numeroFact;
    }
    public String getEdificioFact() {
        return this.edificioFact;
    }
    
    public void setEdificioFact(String edificioFact) {
        this.edificioFact = edificioFact;
    }
    public Short getPisoFact() {
        return this.pisoFact;
    }
    
    public void setPisoFact(Short pisoFact) {
        this.pisoFact = pisoFact;
    }
    public String getDeptoFact() {
        return this.deptoFact;
    }
    
    public void setDeptoFact(String deptoFact) {
        this.deptoFact = deptoFact;
    }
    public String getCpFact() {
        return this.cpFact;
    }
    
    public void setCpFact(String cpFact) {
        this.cpFact = cpFact;
    }
    public Integer getIdPaisFact() {
        return this.idPaisFact;
    }
    
    public void setIdPaisFact(Integer idPaisFact) {
        this.idPaisFact = idPaisFact;
    }
    public Integer getIdProvinciaFact() {
        return this.idProvinciaFact;
    }
    
    public void setIdProvinciaFact(Integer idProvinciaFact) {
        this.idProvinciaFact = idProvinciaFact;
    }
    public Integer getIdLocalidadFact() {
        return this.idLocalidadFact;
    }
    
    public void setIdLocalidadFact(Integer idLocalidadFact) {
        this.idLocalidadFact = idLocalidadFact;
    }
    public boolean isNivelRiesgo() {
        return this.nivelRiesgo;
    }
    
    public void setNivelRiesgo(boolean nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }
    public String getComentarios() {
        return this.comentarios;
    }
    
    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getUsrAlta() {
        return this.usrAlta;
    }
    
    public void setUsrAlta(String usrAlta) {
        this.usrAlta = usrAlta;
    }
    public String getAuxDireccionEnvio() {
        return this.auxDireccionEnvio;
    }
    
    public void setAuxDireccionEnvio(String auxDireccionEnvio) {
        this.auxDireccionEnvio = auxDireccionEnvio;
    }
    public String getAuxDireccionFact() {
        return this.auxDireccionFact;
    }
    
    public void setAuxDireccionFact(String auxDireccionFact) {
        this.auxDireccionFact = auxDireccionFact;
    }
    public String getAuxNombresApellidos() {
        return this.auxNombresApellidos;
    }
    
    public void setAuxNombresApellidos(String auxNombresApellidos) {
        this.auxNombresApellidos = auxNombresApellidos;
    }
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
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
		 if ( !(other instanceof TarjetaVerificadaId) ) return false;
		 TarjetaVerificadaId castOther = ( TarjetaVerificadaId ) other; 
         
		 return ( (this.getNroTarjeta()==castOther.getNroTarjeta()) || ( this.getNroTarjeta()!=null && castOther.getNroTarjeta()!=null && Arrays.equals(this.getNroTarjeta(), castOther.getNroTarjeta()) ) )
 && ( (this.getNombresSocio()==castOther.getNombresSocio()) || ( this.getNombresSocio()!=null && castOther.getNombresSocio()!=null && this.getNombresSocio().equals(castOther.getNombresSocio()) ) )
 && ( (this.getApellidosSocio()==castOther.getApellidosSocio()) || ( this.getApellidosSocio()!=null && castOther.getApellidosSocio()!=null && this.getApellidosSocio().equals(castOther.getApellidosSocio()) ) )
 && ( (this.getEMail()==castOther.getEMail()) || ( this.getEMail()!=null && castOther.getEMail()!=null && this.getEMail().equals(castOther.getEMail()) ) )
 && ( (this.getCalleEnvio()==castOther.getCalleEnvio()) || ( this.getCalleEnvio()!=null && castOther.getCalleEnvio()!=null && this.getCalleEnvio().equals(castOther.getCalleEnvio()) ) )
 && ( (this.getNumeroEnvio()==castOther.getNumeroEnvio()) || ( this.getNumeroEnvio()!=null && castOther.getNumeroEnvio()!=null && this.getNumeroEnvio().equals(castOther.getNumeroEnvio()) ) )
 && ( (this.getEdificioEnvio()==castOther.getEdificioEnvio()) || ( this.getEdificioEnvio()!=null && castOther.getEdificioEnvio()!=null && this.getEdificioEnvio().equals(castOther.getEdificioEnvio()) ) )
 && ( (this.getPisoEnvio()==castOther.getPisoEnvio()) || ( this.getPisoEnvio()!=null && castOther.getPisoEnvio()!=null && this.getPisoEnvio().equals(castOther.getPisoEnvio()) ) )
 && ( (this.getDeptoEnvio()==castOther.getDeptoEnvio()) || ( this.getDeptoEnvio()!=null && castOther.getDeptoEnvio()!=null && this.getDeptoEnvio().equals(castOther.getDeptoEnvio()) ) )
 && ( (this.getCpEnvio()==castOther.getCpEnvio()) || ( this.getCpEnvio()!=null && castOther.getCpEnvio()!=null && this.getCpEnvio().equals(castOther.getCpEnvio()) ) )
 && ( (this.getIdPaisEnvio()==castOther.getIdPaisEnvio()) || ( this.getIdPaisEnvio()!=null && castOther.getIdPaisEnvio()!=null && this.getIdPaisEnvio().equals(castOther.getIdPaisEnvio()) ) )
 && ( (this.getIdProvinciaEnvio()==castOther.getIdProvinciaEnvio()) || ( this.getIdProvinciaEnvio()!=null && castOther.getIdProvinciaEnvio()!=null && this.getIdProvinciaEnvio().equals(castOther.getIdProvinciaEnvio()) ) )
 && ( (this.getIdLocalidadEnvio()==castOther.getIdLocalidadEnvio()) || ( this.getIdLocalidadEnvio()!=null && castOther.getIdLocalidadEnvio()!=null && this.getIdLocalidadEnvio().equals(castOther.getIdLocalidadEnvio()) ) )
 && ( (this.getCalleFact()==castOther.getCalleFact()) || ( this.getCalleFact()!=null && castOther.getCalleFact()!=null && this.getCalleFact().equals(castOther.getCalleFact()) ) )
 && ( (this.getNumeroFact()==castOther.getNumeroFact()) || ( this.getNumeroFact()!=null && castOther.getNumeroFact()!=null && this.getNumeroFact().equals(castOther.getNumeroFact()) ) )
 && ( (this.getEdificioFact()==castOther.getEdificioFact()) || ( this.getEdificioFact()!=null && castOther.getEdificioFact()!=null && this.getEdificioFact().equals(castOther.getEdificioFact()) ) )
 && ( (this.getPisoFact()==castOther.getPisoFact()) || ( this.getPisoFact()!=null && castOther.getPisoFact()!=null && this.getPisoFact().equals(castOther.getPisoFact()) ) )
 && ( (this.getDeptoFact()==castOther.getDeptoFact()) || ( this.getDeptoFact()!=null && castOther.getDeptoFact()!=null && this.getDeptoFact().equals(castOther.getDeptoFact()) ) )
 && ( (this.getCpFact()==castOther.getCpFact()) || ( this.getCpFact()!=null && castOther.getCpFact()!=null && this.getCpFact().equals(castOther.getCpFact()) ) )
 && ( (this.getIdPaisFact()==castOther.getIdPaisFact()) || ( this.getIdPaisFact()!=null && castOther.getIdPaisFact()!=null && this.getIdPaisFact().equals(castOther.getIdPaisFact()) ) )
 && ( (this.getIdProvinciaFact()==castOther.getIdProvinciaFact()) || ( this.getIdProvinciaFact()!=null && castOther.getIdProvinciaFact()!=null && this.getIdProvinciaFact().equals(castOther.getIdProvinciaFact()) ) )
 && ( (this.getIdLocalidadFact()==castOther.getIdLocalidadFact()) || ( this.getIdLocalidadFact()!=null && castOther.getIdLocalidadFact()!=null && this.getIdLocalidadFact().equals(castOther.getIdLocalidadFact()) ) )
 && (this.isNivelRiesgo()==castOther.isNivelRiesgo())
 && ( (this.getComentarios()==castOther.getComentarios()) || ( this.getComentarios()!=null && castOther.getComentarios()!=null && this.getComentarios().equals(castOther.getComentarios()) ) )
 && ( (this.getFechaAlta()==castOther.getFechaAlta()) || ( this.getFechaAlta()!=null && castOther.getFechaAlta()!=null && this.getFechaAlta().equals(castOther.getFechaAlta()) ) )
 && ( (this.getUsrAlta()==castOther.getUsrAlta()) || ( this.getUsrAlta()!=null && castOther.getUsrAlta()!=null && this.getUsrAlta().equals(castOther.getUsrAlta()) ) )
 && ( (this.getAuxDireccionEnvio()==castOther.getAuxDireccionEnvio()) || ( this.getAuxDireccionEnvio()!=null && castOther.getAuxDireccionEnvio()!=null && this.getAuxDireccionEnvio().equals(castOther.getAuxDireccionEnvio()) ) )
 && ( (this.getAuxDireccionFact()==castOther.getAuxDireccionFact()) || ( this.getAuxDireccionFact()!=null && castOther.getAuxDireccionFact()!=null && this.getAuxDireccionFact().equals(castOther.getAuxDireccionFact()) ) )
 && ( (this.getAuxNombresApellidos()==castOther.getAuxNombresApellidos()) || ( this.getAuxNombresApellidos()!=null && castOther.getAuxNombresApellidos()!=null && this.getAuxNombresApellidos().equals(castOther.getAuxNombresApellidos()) ) )
 && ( (this.getId()==castOther.getId()) || ( this.getId()!=null && castOther.getId()!=null && this.getId().equals(castOther.getId()) ) )
 && ( (this.getFModi()==castOther.getFModi()) || ( this.getFModi()!=null && castOther.getFModi()!=null && this.getFModi().equals(castOther.getFModi()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         int nroTarjetaHashcode = 0;
         byte[] nroTarjetaProperty = this.getNroTarjeta();
         if(nroTarjetaProperty != null) {
             nroTarjetaHashcode = 1;
             for (int i=0; i<nroTarjetaProperty.length; i++) {
                 nroTarjetaHashcode = 37 * nroTarjetaHashcode + nroTarjetaProperty[i];
             }
         }

         result = 37 * result + nroTarjetaHashcode;

         result = 37 * result + ( getNombresSocio() == null ? 0 : this.getNombresSocio().hashCode() );
         result = 37 * result + ( getApellidosSocio() == null ? 0 : this.getApellidosSocio().hashCode() );
         result = 37 * result + ( getEMail() == null ? 0 : this.getEMail().hashCode() );
         result = 37 * result + ( getCalleEnvio() == null ? 0 : this.getCalleEnvio().hashCode() );
         result = 37 * result + ( getNumeroEnvio() == null ? 0 : this.getNumeroEnvio().hashCode() );
         result = 37 * result + ( getEdificioEnvio() == null ? 0 : this.getEdificioEnvio().hashCode() );
         result = 37 * result + ( getPisoEnvio() == null ? 0 : this.getPisoEnvio().hashCode() );
         result = 37 * result + ( getDeptoEnvio() == null ? 0 : this.getDeptoEnvio().hashCode() );
         result = 37 * result + ( getCpEnvio() == null ? 0 : this.getCpEnvio().hashCode() );
         result = 37 * result + ( getIdPaisEnvio() == null ? 0 : this.getIdPaisEnvio().hashCode() );
         result = 37 * result + ( getIdProvinciaEnvio() == null ? 0 : this.getIdProvinciaEnvio().hashCode() );
         result = 37 * result + ( getIdLocalidadEnvio() == null ? 0 : this.getIdLocalidadEnvio().hashCode() );
         result = 37 * result + ( getCalleFact() == null ? 0 : this.getCalleFact().hashCode() );
         result = 37 * result + ( getNumeroFact() == null ? 0 : this.getNumeroFact().hashCode() );
         result = 37 * result + ( getEdificioFact() == null ? 0 : this.getEdificioFact().hashCode() );
         result = 37 * result + ( getPisoFact() == null ? 0 : this.getPisoFact().hashCode() );
         result = 37 * result + ( getDeptoFact() == null ? 0 : this.getDeptoFact().hashCode() );
         result = 37 * result + ( getCpFact() == null ? 0 : this.getCpFact().hashCode() );
         result = 37 * result + ( getIdPaisFact() == null ? 0 : this.getIdPaisFact().hashCode() );
         result = 37 * result + ( getIdProvinciaFact() == null ? 0 : this.getIdProvinciaFact().hashCode() );
         result = 37 * result + ( getIdLocalidadFact() == null ? 0 : this.getIdLocalidadFact().hashCode() );
         result = 37 * result + (this.isNivelRiesgo()?1:0);
         result = 37 * result + ( getComentarios() == null ? 0 : this.getComentarios().hashCode() );
         result = 37 * result + ( getFechaAlta() == null ? 0 : this.getFechaAlta().hashCode() );
         result = 37 * result + ( getUsrAlta() == null ? 0 : this.getUsrAlta().hashCode() );
         result = 37 * result + ( getAuxDireccionEnvio() == null ? 0 : this.getAuxDireccionEnvio().hashCode() );
         result = 37 * result + ( getAuxDireccionFact() == null ? 0 : this.getAuxDireccionFact().hashCode() );
         result = 37 * result + ( getAuxNombresApellidos() == null ? 0 : this.getAuxNombresApellidos().hashCode() );
         result = 37 * result + ( getId() == null ? 0 : this.getId().hashCode() );
         result = 37 * result + ( getFModi() == null ? 0 : this.getFModi().hashCode() );
         return result;
   }   


}


