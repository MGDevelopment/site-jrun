package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * TarjetaRangosOld generated by hbm2java
 */
public class TarjetaRangosOld  implements java.io.Serializable {


     private TarjetaRangosOldId id;
     private MediosDeCobros mediosDeCobros;

    public TarjetaRangosOld() {
    }

    public TarjetaRangosOld(TarjetaRangosOldId id, MediosDeCobros mediosDeCobros) {
       this.id = id;
       this.mediosDeCobros = mediosDeCobros;
    }
   
    public TarjetaRangosOldId getId() {
        return this.id;
    }
    
    public void setId(TarjetaRangosOldId id) {
        this.id = id;
    }
    public MediosDeCobros getMediosDeCobros() {
        return this.mediosDeCobros;
    }
    
    public void setMediosDeCobros(MediosDeCobros mediosDeCobros) {
        this.mediosDeCobros = mediosDeCobros;
    }




}


