/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.server;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Server.
 * 
 * @version $Revision$ $Date$
 */
public class Server implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _url
     */
    private java.lang.String _url;

    /**
     * Field _modoAplicacionHabilitado
     */
    private boolean _modoAplicacionHabilitado;

    /**
     * keeps track of state for field: _modoAplicacionHabilitado
     */
    private boolean _has_modoAplicacionHabilitado;

    /**
     * Field _dominioSitio
     */
    private java.lang.String _dominioSitio;

    /**
     * Field _dominioIntranet
     */
    private java.lang.String _dominioIntranet;

    /**
     * Field _aplicacion
     */
    private java.lang.String _aplicacion;

    /**
     * Field _log
     */
    private java.lang.String _log;

    /**
     * Field _modo
     */
    private java.lang.String _modo;

    /**
     * Field _mailing
     */
    private com.tmk.kernel.server.Mailing _mailing;

    /**
     * Field _control
     */
    private com.tmk.kernel.server.Control _control;

    /**
     * Field _programaExtra
     */
    private com.tmk.kernel.server.ProgramaExtra _programaExtra;

    /**
     * Field _GPay
     */
    private com.tmk.kernel.server.GPay _GPay;

    /**
     * Field _inactividad
     */
    private com.tmk.kernel.server.Inactividad _inactividad;

    /**
     * Field _programaReferido
     */
    private com.tmk.kernel.server.ProgramaReferido _programaReferido;

    /**
     * Field _promoChequeObsequio
     */
    private com.tmk.kernel.server.PromoChequeObsequio _promoChequeObsequio;

    /**
     * Field _promoDiaDeLaMadre
     */
    private com.tmk.kernel.server.PromoDiaDeLaMadre _promoDiaDeLaMadre;

    /**
     * Field _bloqueoIP
     */
    private com.tmk.kernel.server.BloqueoIP _bloqueoIP;

    /**
     * Field _dominios
     */
    private com.tmk.kernel.server.Dominios _dominios;

    /**
     * Field _musicaOnLine
     */
    private com.tmk.kernel.server.MusicaOnLine _musicaOnLine;

    /**
     * Field _procesosBackground
     */
    private com.tmk.kernel.server.ProcesosBackground _procesosBackground;

    /**
     * Field _generacion
     */
    private com.tmk.kernel.server.Generacion _generacion;

    /**
     * Field _procesos
     */
    private com.tmk.kernel.server.Procesos _procesos;

    /**
     * Field _ubicacionDeRed
     */
    private com.tmk.kernel.server.UbicacionDeRed _ubicacionDeRed;


      //----------------/
     //- Constructors -/
    //----------------/

    public Server() {
        super();
    } //-- com.tmk.kernel.server.Server()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'aplicacion'.
     * 
     * @return the value of field 'aplicacion'.
     */
    public java.lang.String getAplicacion()
    {
        return this._aplicacion;
    } //-- java.lang.String getAplicacion() 

    /**
     * Returns the value of field 'bloqueoIP'.
     * 
     * @return the value of field 'bloqueoIP'.
     */
    public com.tmk.kernel.server.BloqueoIP getBloqueoIP()
    {
        return this._bloqueoIP;
    } //-- com.tmk.kernel.server.BloqueoIP getBloqueoIP() 

    /**
     * Returns the value of field 'control'.
     * 
     * @return the value of field 'control'.
     */
    public com.tmk.kernel.server.Control getControl()
    {
        return this._control;
    } //-- com.tmk.kernel.server.Control getControl() 

    /**
     * Returns the value of field 'dominioIntranet'.
     * 
     * @return the value of field 'dominioIntranet'.
     */
    public java.lang.String getDominioIntranet()
    {
        return this._dominioIntranet;
    } //-- java.lang.String getDominioIntranet() 

    /**
     * Returns the value of field 'dominioSitio'.
     * 
     * @return the value of field 'dominioSitio'.
     */
    public java.lang.String getDominioSitio()
    {
        return this._dominioSitio;
    } //-- java.lang.String getDominioSitio() 

    /**
     * Returns the value of field 'dominios'.
     * 
     * @return the value of field 'dominios'.
     */
    public com.tmk.kernel.server.Dominios getDominios()
    {
        return this._dominios;
    } //-- com.tmk.kernel.server.Dominios getDominios() 

    /**
     * Returns the value of field 'GPay'.
     * 
     * @return the value of field 'GPay'.
     */
    public com.tmk.kernel.server.GPay getGPay()
    {
        return this._GPay;
    } //-- com.tmk.kernel.server.GPay getGPay() 

    /**
     * Returns the value of field 'generacion'.
     * 
     * @return the value of field 'generacion'.
     */
    public com.tmk.kernel.server.Generacion getGeneracion()
    {
        return this._generacion;
    } //-- com.tmk.kernel.server.Generacion getGeneracion() 

    /**
     * Returns the value of field 'inactividad'.
     * 
     * @return the value of field 'inactividad'.
     */
    public com.tmk.kernel.server.Inactividad getInactividad()
    {
        return this._inactividad;
    } //-- com.tmk.kernel.server.Inactividad getInactividad() 

    /**
     * Returns the value of field 'log'.
     * 
     * @return the value of field 'log'.
     */
    public java.lang.String getLog()
    {
        return this._log;
    } //-- java.lang.String getLog() 

    /**
     * Returns the value of field 'mailing'.
     * 
     * @return the value of field 'mailing'.
     */
    public com.tmk.kernel.server.Mailing getMailing()
    {
        return this._mailing;
    } //-- com.tmk.kernel.server.Mailing getMailing() 

    /**
     * Returns the value of field 'modo'.
     * 
     * @return the value of field 'modo'.
     */
    public java.lang.String getModo()
    {
        return this._modo;
    } //-- java.lang.String getModo() 

    /**
     * Returns the value of field 'modoAplicacionHabilitado'.
     * 
     * @return the value of field 'modoAplicacionHabilitado'.
     */
    public boolean getModoAplicacionHabilitado()
    {
        return this._modoAplicacionHabilitado;
    } //-- boolean getModoAplicacionHabilitado() 

    /**
     * Returns the value of field 'musicaOnLine'.
     * 
     * @return the value of field 'musicaOnLine'.
     */
    public com.tmk.kernel.server.MusicaOnLine getMusicaOnLine()
    {
        return this._musicaOnLine;
    } //-- com.tmk.kernel.server.MusicaOnLine getMusicaOnLine() 

    /**
     * Returns the value of field 'procesos'.
     * 
     * @return the value of field 'procesos'.
     */
    public com.tmk.kernel.server.Procesos getProcesos()
    {
        return this._procesos;
    } //-- com.tmk.kernel.server.Procesos getProcesos() 

    /**
     * Returns the value of field 'procesosBackground'.
     * 
     * @return the value of field 'procesosBackground'.
     */
    public com.tmk.kernel.server.ProcesosBackground getProcesosBackground()
    {
        return this._procesosBackground;
    } //-- com.tmk.kernel.server.ProcesosBackground getProcesosBackground() 

    /**
     * Returns the value of field 'programaExtra'.
     * 
     * @return the value of field 'programaExtra'.
     */
    public com.tmk.kernel.server.ProgramaExtra getProgramaExtra()
    {
        return this._programaExtra;
    } //-- com.tmk.kernel.server.ProgramaExtra getProgramaExtra() 

    /**
     * Returns the value of field 'programaReferido'.
     * 
     * @return the value of field 'programaReferido'.
     */
    public com.tmk.kernel.server.ProgramaReferido getProgramaReferido()
    {
        return this._programaReferido;
    } //-- com.tmk.kernel.server.ProgramaReferido getProgramaReferido() 

    /**
     * Returns the value of field 'promoChequeObsequio'.
     * 
     * @return the value of field 'promoChequeObsequio'.
     */
    public com.tmk.kernel.server.PromoChequeObsequio getPromoChequeObsequio()
    {
        return this._promoChequeObsequio;
    } //-- com.tmk.kernel.server.PromoChequeObsequio getPromoChequeObsequio() 

    /**
     * Returns the value of field 'promoDiaDeLaMadre'.
     * 
     * @return the value of field 'promoDiaDeLaMadre'.
     */
    public com.tmk.kernel.server.PromoDiaDeLaMadre getPromoDiaDeLaMadre()
    {
        return this._promoDiaDeLaMadre;
    } //-- com.tmk.kernel.server.PromoDiaDeLaMadre getPromoDiaDeLaMadre() 

    /**
     * Returns the value of field 'ubicacionDeRed'.
     * 
     * @return the value of field 'ubicacionDeRed'.
     */
    public com.tmk.kernel.server.UbicacionDeRed getUbicacionDeRed()
    {
        return this._ubicacionDeRed;
    } //-- com.tmk.kernel.server.UbicacionDeRed getUbicacionDeRed() 

    /**
     * Returns the value of field 'url'.
     * 
     * @return the value of field 'url'.
     */
    public java.lang.String getUrl()
    {
        return this._url;
    } //-- java.lang.String getUrl() 

    /**
     * Method hasModoAplicacionHabilitado
     */
    public boolean hasModoAplicacionHabilitado()
    {
        return this._has_modoAplicacionHabilitado;
    } //-- boolean hasModoAplicacionHabilitado() 

    /**
     * Method isValid
     */
    public boolean isValid()
    {
        try {
            validate();
        }
        catch (org.exolab.castor.xml.ValidationException vex) {
            return false;
        }
        return true;
    } //-- boolean isValid() 

    /**
     * Method marshal
     * 
     * @param out
     */
    public void marshal(java.io.Writer out)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, out);
    } //-- void marshal(java.io.Writer) 

    /**
     * Method marshal
     * 
     * @param handler
     */
    public void marshal(org.xml.sax.ContentHandler handler)
        throws java.io.IOException, org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        
        Marshaller.marshal(this, handler);
    } //-- void marshal(org.xml.sax.ContentHandler) 

    /**
     * Sets the value of field 'aplicacion'.
     * 
     * @param aplicacion the value of field 'aplicacion'.
     */
    public void setAplicacion(java.lang.String aplicacion)
    {
        this._aplicacion = aplicacion;
    } //-- void setAplicacion(java.lang.String) 

    /**
     * Sets the value of field 'bloqueoIP'.
     * 
     * @param bloqueoIP the value of field 'bloqueoIP'.
     */
    public void setBloqueoIP(com.tmk.kernel.server.BloqueoIP bloqueoIP)
    {
        this._bloqueoIP = bloqueoIP;
    } //-- void setBloqueoIP(com.tmk.kernel.server.BloqueoIP) 

    /**
     * Sets the value of field 'control'.
     * 
     * @param control the value of field 'control'.
     */
    public void setControl(com.tmk.kernel.server.Control control)
    {
        this._control = control;
    } //-- void setControl(com.tmk.kernel.server.Control) 

    /**
     * Sets the value of field 'dominioIntranet'.
     * 
     * @param dominioIntranet the value of field 'dominioIntranet'.
     */
    public void setDominioIntranet(java.lang.String dominioIntranet)
    {
        this._dominioIntranet = dominioIntranet;
    } //-- void setDominioIntranet(java.lang.String) 

    /**
     * Sets the value of field 'dominioSitio'.
     * 
     * @param dominioSitio the value of field 'dominioSitio'.
     */
    public void setDominioSitio(java.lang.String dominioSitio)
    {
        this._dominioSitio = dominioSitio;
    } //-- void setDominioSitio(java.lang.String) 

    /**
     * Sets the value of field 'dominios'.
     * 
     * @param dominios the value of field 'dominios'.
     */
    public void setDominios(com.tmk.kernel.server.Dominios dominios)
    {
        this._dominios = dominios;
    } //-- void setDominios(com.tmk.kernel.server.Dominios) 

    /**
     * Sets the value of field 'GPay'.
     * 
     * @param GPay the value of field 'GPay'.
     */
    public void setGPay(com.tmk.kernel.server.GPay GPay)
    {
        this._GPay = GPay;
    } //-- void setGPay(com.tmk.kernel.server.GPay) 

    /**
     * Sets the value of field 'generacion'.
     * 
     * @param generacion the value of field 'generacion'.
     */
    public void setGeneracion(com.tmk.kernel.server.Generacion generacion)
    {
        this._generacion = generacion;
    } //-- void setGeneracion(com.tmk.kernel.server.Generacion) 

    /**
     * Sets the value of field 'inactividad'.
     * 
     * @param inactividad the value of field 'inactividad'.
     */
    public void setInactividad(com.tmk.kernel.server.Inactividad inactividad)
    {
        this._inactividad = inactividad;
    } //-- void setInactividad(com.tmk.kernel.server.Inactividad) 

    /**
     * Sets the value of field 'log'.
     * 
     * @param log the value of field 'log'.
     */
    public void setLog(java.lang.String log)
    {
        this._log = log;
    } //-- void setLog(java.lang.String) 

    /**
     * Sets the value of field 'mailing'.
     * 
     * @param mailing the value of field 'mailing'.
     */
    public void setMailing(com.tmk.kernel.server.Mailing mailing)
    {
        this._mailing = mailing;
    } //-- void setMailing(com.tmk.kernel.server.Mailing) 

    /**
     * Sets the value of field 'modo'.
     * 
     * @param modo the value of field 'modo'.
     */
    public void setModo(java.lang.String modo)
    {
        this._modo = modo;
    } //-- void setModo(java.lang.String) 

    /**
     * Sets the value of field 'modoAplicacionHabilitado'.
     * 
     * @param modoAplicacionHabilitado the value of field
     * 'modoAplicacionHabilitado'.
     */
    public void setModoAplicacionHabilitado(boolean modoAplicacionHabilitado)
    {
        this._modoAplicacionHabilitado = modoAplicacionHabilitado;
        this._has_modoAplicacionHabilitado = true;
    } //-- void setModoAplicacionHabilitado(boolean) 

    /**
     * Sets the value of field 'musicaOnLine'.
     * 
     * @param musicaOnLine the value of field 'musicaOnLine'.
     */
    public void setMusicaOnLine(com.tmk.kernel.server.MusicaOnLine musicaOnLine)
    {
        this._musicaOnLine = musicaOnLine;
    } //-- void setMusicaOnLine(com.tmk.kernel.server.MusicaOnLine) 

    /**
     * Sets the value of field 'procesos'.
     * 
     * @param procesos the value of field 'procesos'.
     */
    public void setProcesos(com.tmk.kernel.server.Procesos procesos)
    {
        this._procesos = procesos;
    } //-- void setProcesos(com.tmk.kernel.server.Procesos) 

    /**
     * Sets the value of field 'procesosBackground'.
     * 
     * @param procesosBackground the value of field
     * 'procesosBackground'.
     */
    public void setProcesosBackground(com.tmk.kernel.server.ProcesosBackground procesosBackground)
    {
        this._procesosBackground = procesosBackground;
    } //-- void setProcesosBackground(com.tmk.kernel.server.ProcesosBackground) 

    /**
     * Sets the value of field 'programaExtra'.
     * 
     * @param programaExtra the value of field 'programaExtra'.
     */
    public void setProgramaExtra(com.tmk.kernel.server.ProgramaExtra programaExtra)
    {
        this._programaExtra = programaExtra;
    } //-- void setProgramaExtra(com.tmk.kernel.server.ProgramaExtra) 

    /**
     * Sets the value of field 'programaReferido'.
     * 
     * @param programaReferido the value of field 'programaReferido'
     */
    public void setProgramaReferido(com.tmk.kernel.server.ProgramaReferido programaReferido)
    {
        this._programaReferido = programaReferido;
    } //-- void setProgramaReferido(com.tmk.kernel.server.ProgramaReferido) 

    /**
     * Sets the value of field 'promoChequeObsequio'.
     * 
     * @param promoChequeObsequio the value of field
     * 'promoChequeObsequio'.
     */
    public void setPromoChequeObsequio(com.tmk.kernel.server.PromoChequeObsequio promoChequeObsequio)
    {
        this._promoChequeObsequio = promoChequeObsequio;
    } //-- void setPromoChequeObsequio(com.tmk.kernel.server.PromoChequeObsequio) 

    /**
     * Sets the value of field 'promoDiaDeLaMadre'.
     * 
     * @param promoDiaDeLaMadre the value of field
     * 'promoDiaDeLaMadre'.
     */
    public void setPromoDiaDeLaMadre(com.tmk.kernel.server.PromoDiaDeLaMadre promoDiaDeLaMadre)
    {
        this._promoDiaDeLaMadre = promoDiaDeLaMadre;
    } //-- void setPromoDiaDeLaMadre(com.tmk.kernel.server.PromoDiaDeLaMadre) 

    /**
     * Sets the value of field 'ubicacionDeRed'.
     * 
     * @param ubicacionDeRed the value of field 'ubicacionDeRed'.
     */
    public void setUbicacionDeRed(com.tmk.kernel.server.UbicacionDeRed ubicacionDeRed)
    {
        this._ubicacionDeRed = ubicacionDeRed;
    } //-- void setUbicacionDeRed(com.tmk.kernel.server.UbicacionDeRed) 

    /**
     * Sets the value of field 'url'.
     * 
     * @param url the value of field 'url'.
     */
    public void setUrl(java.lang.String url)
    {
        this._url = url;
    } //-- void setUrl(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Server unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Server) Unmarshaller.unmarshal(com.tmk.kernel.server.Server.class, reader);
    } //-- com.tmk.kernel.server.Server unmarshal(java.io.Reader) 

    /**
     * Method validate
     */
    public void validate()
        throws org.exolab.castor.xml.ValidationException
    {
        org.exolab.castor.xml.Validator validator = new org.exolab.castor.xml.Validator();
        validator.validate(this);
    } //-- void validate() 

}
