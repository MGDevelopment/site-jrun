package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * FdnModelosVehiculos generated by hbm2java
 */
public class FdnModelosVehiculos  implements java.io.Serializable {


     private FdnModelosVehiculosId id;
     private FdnMarcasVehiculos fdnMarcasVehiculos;
     private String descripcion;
     private String usrAlta;
     private Date FAlta;
     private String usrModi;
     private Date FModi;

    public FdnModelosVehiculos() {
    }

	
    public FdnModelosVehiculos(FdnModelosVehiculosId id, FdnMarcasVehiculos fdnMarcasVehiculos, String descripcion, String usrAlta, Date FAlta) {
        this.id = id;
        this.fdnMarcasVehiculos = fdnMarcasVehiculos;
        this.descripcion = descripcion;
        this.usrAlta = usrAlta;
        this.FAlta = FAlta;
    }
    public FdnModelosVehiculos(FdnModelosVehiculosId id, FdnMarcasVehiculos fdnMarcasVehiculos, String descripcion, String usrAlta, Date FAlta, String usrModi, Date FModi) {
       this.id = id;
       this.fdnMarcasVehiculos = fdnMarcasVehiculos;
       this.descripcion = descripcion;
       this.usrAlta = usrAlta;
       this.FAlta = FAlta;
       this.usrModi = usrModi;
       this.FModi = FModi;
    }
   
    public FdnModelosVehiculosId getId() {
        return this.id;
    }
    
    public void setId(FdnModelosVehiculosId id) {
        this.id = id;
    }
    public FdnMarcasVehiculos getFdnMarcasVehiculos() {
        return this.fdnMarcasVehiculos;
    }
    
    public void setFdnMarcasVehiculos(FdnMarcasVehiculos fdnMarcasVehiculos) {
        this.fdnMarcasVehiculos = fdnMarcasVehiculos;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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


