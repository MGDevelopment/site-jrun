package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * TarjetaVerificada generated by hbm2java
 */
public class TarjetaVerificada  implements java.io.Serializable {


     private TarjetaVerificadaId id;
     private NivelDeRiesgo nivelDeRiesgo;

    public TarjetaVerificada() {
    }

    public TarjetaVerificada(TarjetaVerificadaId id, NivelDeRiesgo nivelDeRiesgo) {
       this.id = id;
       this.nivelDeRiesgo = nivelDeRiesgo;
    }
   
    public TarjetaVerificadaId getId() {
        return this.id;
    }
    
    public void setId(TarjetaVerificadaId id) {
        this.id = id;
    }
    public NivelDeRiesgo getNivelDeRiesgo() {
        return this.nivelDeRiesgo;
    }
    
    public void setNivelDeRiesgo(NivelDeRiesgo nivelDeRiesgo) {
        this.nivelDeRiesgo = nivelDeRiesgo;
    }




}


