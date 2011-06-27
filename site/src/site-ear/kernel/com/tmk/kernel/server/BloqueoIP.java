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
 * Class BloqueoIP.
 * 
 * @version $Revision$ $Date$
 */
public class BloqueoIP implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _habilitado
     */
    private boolean _habilitado;

    /**
     * keeps track of state for field: _habilitado
     */
    private boolean _has_habilitado;

    /**
     * Field _hits
     */
    private int _hits;

    /**
     * keeps track of state for field: _hits
     */
    private boolean _has_hits;

    /**
     * Field _tiempoEntreHits
     */
    private int _tiempoEntreHits;

    /**
     * keeps track of state for field: _tiempoEntreHits
     */
    private boolean _has_tiempoEntreHits;


      //----------------/
     //- Constructors -/
    //----------------/

    public BloqueoIP() {
        super();
    } //-- com.tmk.kernel.server.BloqueoIP()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'habilitado'.
     * 
     * @return the value of field 'habilitado'.
     */
    public boolean getHabilitado()
    {
        return this._habilitado;
    } //-- boolean getHabilitado() 

    /**
     * Returns the value of field 'hits'.
     * 
     * @return the value of field 'hits'.
     */
    public int getHits()
    {
        return this._hits;
    } //-- int getHits() 

    /**
     * Returns the value of field 'tiempoEntreHits'.
     * 
     * @return the value of field 'tiempoEntreHits'.
     */
    public int getTiempoEntreHits()
    {
        return this._tiempoEntreHits;
    } //-- int getTiempoEntreHits() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasHits
     */
    public boolean hasHits()
    {
        return this._has_hits;
    } //-- boolean hasHits() 

    /**
     * Method hasTiempoEntreHits
     */
    public boolean hasTiempoEntreHits()
    {
        return this._has_tiempoEntreHits;
    } //-- boolean hasTiempoEntreHits() 

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
     * Sets the value of field 'habilitado'.
     * 
     * @param habilitado the value of field 'habilitado'.
     */
    public void setHabilitado(boolean habilitado)
    {
        this._habilitado = habilitado;
        this._has_habilitado = true;
    } //-- void setHabilitado(boolean) 

    /**
     * Sets the value of field 'hits'.
     * 
     * @param hits the value of field 'hits'.
     */
    public void setHits(int hits)
    {
        this._hits = hits;
        this._has_hits = true;
    } //-- void setHits(int) 

    /**
     * Sets the value of field 'tiempoEntreHits'.
     * 
     * @param tiempoEntreHits the value of field 'tiempoEntreHits'.
     */
    public void setTiempoEntreHits(int tiempoEntreHits)
    {
        this._tiempoEntreHits = tiempoEntreHits;
        this._has_tiempoEntreHits = true;
    } //-- void setTiempoEntreHits(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.BloqueoIP unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.BloqueoIP) Unmarshaller.unmarshal(com.tmk.kernel.server.BloqueoIP.class, reader);
    } //-- com.tmk.kernel.server.BloqueoIP unmarshal(java.io.Reader) 

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
