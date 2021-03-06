package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;

/**
 * ListaDeseosBup generated by hbm2java
 */
public class ListaDeseosBup  implements java.io.Serializable {


     private ListaDeseosBupId id;
     private String tipoDomicilio;
     private String nombres;
     private String apellidos;
     private byte cumplDia;
     private byte cumplMes;
     private String palabrasClaves;
     private boolean publica;
     private Date FAlta;
     private Date FModi;

    public ListaDeseosBup() {
    }

	
    public ListaDeseosBup(ListaDeseosBupId id, String nombres, String apellidos, byte cumplDia, byte cumplMes, String palabrasClaves, boolean publica) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.cumplDia = cumplDia;
        this.cumplMes = cumplMes;
        this.palabrasClaves = palabrasClaves;
        this.publica = publica;
    }
    public ListaDeseosBup(ListaDeseosBupId id, String tipoDomicilio, String nombres, String apellidos, byte cumplDia, byte cumplMes, String palabrasClaves, boolean publica, Date FAlta, Date FModi) {
       this.id = id;
       this.tipoDomicilio = tipoDomicilio;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.cumplDia = cumplDia;
       this.cumplMes = cumplMes;
       this.palabrasClaves = palabrasClaves;
       this.publica = publica;
       this.FAlta = FAlta;
       this.FModi = FModi;
    }
   
    public ListaDeseosBupId getId() {
        return this.id;
    }
    
    public void setId(ListaDeseosBupId id) {
        this.id = id;
    }
    public String getTipoDomicilio() {
        return this.tipoDomicilio;
    }
    
    public void setTipoDomicilio(String tipoDomicilio) {
        this.tipoDomicilio = tipoDomicilio;
    }
    public String getNombres() {
        return this.nombres;
    }
    
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getApellidos() {
        return this.apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public byte getCumplDia() {
        return this.cumplDia;
    }
    
    public void setCumplDia(byte cumplDia) {
        this.cumplDia = cumplDia;
    }
    public byte getCumplMes() {
        return this.cumplMes;
    }
    
    public void setCumplMes(byte cumplMes) {
        this.cumplMes = cumplMes;
    }
    public String getPalabrasClaves() {
        return this.palabrasClaves;
    }
    
    public void setPalabrasClaves(String palabrasClaves) {
        this.palabrasClaves = palabrasClaves;
    }
    public boolean isPublica() {
        return this.publica;
    }
    
    public void setPublica(boolean publica) {
        this.publica = publica;
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


