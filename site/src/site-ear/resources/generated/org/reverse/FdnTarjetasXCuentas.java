package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1



/**
 * FdnTarjetasXCuentas generated by hbm2java
 */
public class FdnTarjetasXCuentas  implements java.io.Serializable {


     private FdnTarjetasXCuentasId id;
     private FdnFormularios fdnFormularios;
     private FdnCuentas fdnCuentas;
     private FdnTarjetas fdnTarjetas;

    public FdnTarjetasXCuentas() {
    }

	
    public FdnTarjetasXCuentas(FdnTarjetasXCuentasId id, FdnCuentas fdnCuentas, FdnTarjetas fdnTarjetas) {
        this.id = id;
        this.fdnCuentas = fdnCuentas;
        this.fdnTarjetas = fdnTarjetas;
    }
    public FdnTarjetasXCuentas(FdnTarjetasXCuentasId id, FdnFormularios fdnFormularios, FdnCuentas fdnCuentas, FdnTarjetas fdnTarjetas) {
       this.id = id;
       this.fdnFormularios = fdnFormularios;
       this.fdnCuentas = fdnCuentas;
       this.fdnTarjetas = fdnTarjetas;
    }
   
    public FdnTarjetasXCuentasId getId() {
        return this.id;
    }
    
    public void setId(FdnTarjetasXCuentasId id) {
        this.id = id;
    }
    public FdnFormularios getFdnFormularios() {
        return this.fdnFormularios;
    }
    
    public void setFdnFormularios(FdnFormularios fdnFormularios) {
        this.fdnFormularios = fdnFormularios;
    }
    public FdnCuentas getFdnCuentas() {
        return this.fdnCuentas;
    }
    
    public void setFdnCuentas(FdnCuentas fdnCuentas) {
        this.fdnCuentas = fdnCuentas;
    }
    public FdnTarjetas getFdnTarjetas() {
        return this.fdnTarjetas;
    }
    
    public void setFdnTarjetas(FdnTarjetas fdnTarjetas) {
        this.fdnTarjetas = fdnTarjetas;
    }




}


