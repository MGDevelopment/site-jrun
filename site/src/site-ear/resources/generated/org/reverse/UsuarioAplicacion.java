package org.reverse;
// Generated Oct 20, 2010 10:21:56 AM by Hibernate Tools 3.4.0.Beta1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * UsuarioAplicacion generated by hbm2java
 */
public class UsuarioAplicacion  implements java.io.Serializable {


     private long idUsuario;
     private byte[] login;
     private byte[] password;
     private String nombres;
     private String apellidos;
     private boolean estado;
     private Date fechaAlta;
     private String usuarioAlta;
     private Date fechaModif;
     private String usuarioModif;
     private Date FAlta;
     private Date FModi;
     private Set usuarioXRolAplicacions = new HashSet(0);

    public UsuarioAplicacion() {
    }

	
    public UsuarioAplicacion(long idUsuario, byte[] login, byte[] password, boolean estado) {
        this.idUsuario = idUsuario;
        this.login = login;
        this.password = password;
        this.estado = estado;
    }
    public UsuarioAplicacion(long idUsuario, byte[] login, byte[] password, String nombres, String apellidos, boolean estado, Date fechaAlta, String usuarioAlta, Date fechaModif, String usuarioModif, Date FAlta, Date FModi, Set usuarioXRolAplicacions) {
       this.idUsuario = idUsuario;
       this.login = login;
       this.password = password;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.estado = estado;
       this.fechaAlta = fechaAlta;
       this.usuarioAlta = usuarioAlta;
       this.fechaModif = fechaModif;
       this.usuarioModif = usuarioModif;
       this.FAlta = FAlta;
       this.FModi = FModi;
       this.usuarioXRolAplicacions = usuarioXRolAplicacions;
    }
   
    public long getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }
    public byte[] getLogin() {
        return this.login;
    }
    
    public void setLogin(byte[] login) {
        this.login = login;
    }
    public byte[] getPassword() {
        return this.password;
    }
    
    public void setPassword(byte[] password) {
        this.password = password;
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
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    public Date getFechaAlta() {
        return this.fechaAlta;
    }
    
    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public String getUsuarioAlta() {
        return this.usuarioAlta;
    }
    
    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }
    public Date getFechaModif() {
        return this.fechaModif;
    }
    
    public void setFechaModif(Date fechaModif) {
        this.fechaModif = fechaModif;
    }
    public String getUsuarioModif() {
        return this.usuarioModif;
    }
    
    public void setUsuarioModif(String usuarioModif) {
        this.usuarioModif = usuarioModif;
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
    public Set getUsuarioXRolAplicacions() {
        return this.usuarioXRolAplicacions;
    }
    
    public void setUsuarioXRolAplicacions(Set usuarioXRolAplicacions) {
        this.usuarioXRolAplicacions = usuarioXRolAplicacions;
    }




}


