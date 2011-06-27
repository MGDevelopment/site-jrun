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
 * Class GPay.
 * 
 * @version $Revision$ $Date$
 */
public class GPay implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _host
     */
    private java.lang.String _host;

    /**
     * Field _port
     */
    private int _port;

    /**
     * keeps track of state for field: _port
     */
    private boolean _has_port;

    /**
     * Field _comercio
     */
    private java.lang.String _comercio;

    /**
     * Field _mensaje
     */
    private java.lang.String _mensaje;

    /**
     * Field _baseTerminal
     */
    private java.lang.String _baseTerminal;

    /**
     * Field _tiempoEsperaMaxima
     */
    private int _tiempoEsperaMaxima;

    /**
     * keeps track of state for field: _tiempoEsperaMaxima
     */
    private boolean _has_tiempoEsperaMaxima;

    /**
     * Field _cantidadDeTerminales
     */
    private int _cantidadDeTerminales;

    /**
     * keeps track of state for field: _cantidadDeTerminales
     */
    private boolean _has_cantidadDeTerminales;

    /**
     * Field _habilitaCuotas
     */
    private boolean _habilitaCuotas;

    /**
     * keeps track of state for field: _habilitaCuotas
     */
    private boolean _has_habilitaCuotas;

    /**
     * Field _errores
     */
    private com.tmk.kernel.server.Errores _errores;


      //----------------/
     //- Constructors -/
    //----------------/

    public GPay() {
        super();
    } //-- com.tmk.kernel.server.GPay()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'baseTerminal'.
     * 
     * @return the value of field 'baseTerminal'.
     */
    public java.lang.String getBaseTerminal()
    {
        return this._baseTerminal;
    } //-- java.lang.String getBaseTerminal() 

    /**
     * Returns the value of field 'cantidadDeTerminales'.
     * 
     * @return the value of field 'cantidadDeTerminales'.
     */
    public int getCantidadDeTerminales()
    {
        return this._cantidadDeTerminales;
    } //-- int getCantidadDeTerminales() 

    /**
     * Returns the value of field 'comercio'.
     * 
     * @return the value of field 'comercio'.
     */
    public java.lang.String getComercio()
    {
        return this._comercio;
    } //-- java.lang.String getComercio() 

    /**
     * Returns the value of field 'errores'.
     * 
     * @return the value of field 'errores'.
     */
    public com.tmk.kernel.server.Errores getErrores()
    {
        return this._errores;
    } //-- com.tmk.kernel.server.Errores getErrores() 

    /**
     * Returns the value of field 'habilitaCuotas'.
     * 
     * @return the value of field 'habilitaCuotas'.
     */
    public boolean getHabilitaCuotas()
    {
        return this._habilitaCuotas;
    } //-- boolean getHabilitaCuotas() 

    /**
     * Returns the value of field 'host'.
     * 
     * @return the value of field 'host'.
     */
    public java.lang.String getHost()
    {
        return this._host;
    } //-- java.lang.String getHost() 

    /**
     * Returns the value of field 'mensaje'.
     * 
     * @return the value of field 'mensaje'.
     */
    public java.lang.String getMensaje()
    {
        return this._mensaje;
    } //-- java.lang.String getMensaje() 

    /**
     * Returns the value of field 'port'.
     * 
     * @return the value of field 'port'.
     */
    public int getPort()
    {
        return this._port;
    } //-- int getPort() 

    /**
     * Returns the value of field 'tiempoEsperaMaxima'.
     * 
     * @return the value of field 'tiempoEsperaMaxima'.
     */
    public int getTiempoEsperaMaxima()
    {
        return this._tiempoEsperaMaxima;
    } //-- int getTiempoEsperaMaxima() 

    /**
     * Method hasCantidadDeTerminales
     */
    public boolean hasCantidadDeTerminales()
    {
        return this._has_cantidadDeTerminales;
    } //-- boolean hasCantidadDeTerminales() 

    /**
     * Method hasHabilitaCuotas
     */
    public boolean hasHabilitaCuotas()
    {
        return this._has_habilitaCuotas;
    } //-- boolean hasHabilitaCuotas() 

    /**
     * Method hasPort
     */
    public boolean hasPort()
    {
        return this._has_port;
    } //-- boolean hasPort() 

    /**
     * Method hasTiempoEsperaMaxima
     */
    public boolean hasTiempoEsperaMaxima()
    {
        return this._has_tiempoEsperaMaxima;
    } //-- boolean hasTiempoEsperaMaxima() 

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
     * Sets the value of field 'baseTerminal'.
     * 
     * @param baseTerminal the value of field 'baseTerminal'.
     */
    public void setBaseTerminal(java.lang.String baseTerminal)
    {
        this._baseTerminal = baseTerminal;
    } //-- void setBaseTerminal(java.lang.String) 

    /**
     * Sets the value of field 'cantidadDeTerminales'.
     * 
     * @param cantidadDeTerminales the value of field
     * 'cantidadDeTerminales'.
     */
    public void setCantidadDeTerminales(int cantidadDeTerminales)
    {
        this._cantidadDeTerminales = cantidadDeTerminales;
        this._has_cantidadDeTerminales = true;
    } //-- void setCantidadDeTerminales(int) 

    /**
     * Sets the value of field 'comercio'.
     * 
     * @param comercio the value of field 'comercio'.
     */
    public void setComercio(java.lang.String comercio)
    {
        this._comercio = comercio;
    } //-- void setComercio(java.lang.String) 

    /**
     * Sets the value of field 'errores'.
     * 
     * @param errores the value of field 'errores'.
     */
    public void setErrores(com.tmk.kernel.server.Errores errores)
    {
        this._errores = errores;
    } //-- void setErrores(com.tmk.kernel.server.Errores) 

    /**
     * Sets the value of field 'habilitaCuotas'.
     * 
     * @param habilitaCuotas the value of field 'habilitaCuotas'.
     */
    public void setHabilitaCuotas(boolean habilitaCuotas)
    {
        this._habilitaCuotas = habilitaCuotas;
        this._has_habilitaCuotas = true;
    } //-- void setHabilitaCuotas(boolean) 

    /**
     * Sets the value of field 'host'.
     * 
     * @param host the value of field 'host'.
     */
    public void setHost(java.lang.String host)
    {
        this._host = host;
    } //-- void setHost(java.lang.String) 

    /**
     * Sets the value of field 'mensaje'.
     * 
     * @param mensaje the value of field 'mensaje'.
     */
    public void setMensaje(java.lang.String mensaje)
    {
        this._mensaje = mensaje;
    } //-- void setMensaje(java.lang.String) 

    /**
     * Sets the value of field 'port'.
     * 
     * @param port the value of field 'port'.
     */
    public void setPort(int port)
    {
        this._port = port;
        this._has_port = true;
    } //-- void setPort(int) 

    /**
     * Sets the value of field 'tiempoEsperaMaxima'.
     * 
     * @param tiempoEsperaMaxima the value of field
     * 'tiempoEsperaMaxima'.
     */
    public void setTiempoEsperaMaxima(int tiempoEsperaMaxima)
    {
        this._tiempoEsperaMaxima = tiempoEsperaMaxima;
        this._has_tiempoEsperaMaxima = true;
    } //-- void setTiempoEsperaMaxima(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.GPay unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.GPay) Unmarshaller.unmarshal(com.tmk.kernel.server.GPay.class, reader);
    } //-- com.tmk.kernel.server.GPay unmarshal(java.io.Reader) 

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
