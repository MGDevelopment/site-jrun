package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Consulta generated by hbm2java
 */
public class Consulta  implements java.io.Serializable {


     private short idConsulta;
     private String descripcion;
     private String alcance;
     private String estado;
     private Date FAlta;
     private Date FModi;
     private Set opinions = new HashSet(0);

    public Consulta() {
    }

	
    public Consulta(short idConsulta, String descripcion, String alcance, String estado, Date FAlta) {
        this.idConsulta = idConsulta;
        this.descripcion = descripcion;
        this.alcance = alcance;
        this.estado = estado;
        this.FAlta = FAlta;
    }
    public Consulta(short idConsulta, String descripcion, String alcance, String estado, Date FAlta, Date FModi, Set opinions) {
       this.idConsulta = idConsulta;
       this.descripcion = descripcion;
       this.alcance = alcance;
       this.estado = estado;
       this.FAlta = FAlta;
       this.FModi = FModi;
       this.opinions = opinions;
    }
   
    public short getIdConsulta() {
        return this.idConsulta;
    }
    
    public void setIdConsulta(short idConsulta) {
        this.idConsulta = idConsulta;
    }
    public String getDescripcion() {
        return this.descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getAlcance() {
        return this.alcance;
    }
    
    public void setAlcance(String alcance) {
        this.alcance = alcance;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
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
    public Set getOpinions() {
        return this.opinions;
    }
    
    public void setOpinions(Set opinions) {
        this.opinions = opinions;
    }




}


