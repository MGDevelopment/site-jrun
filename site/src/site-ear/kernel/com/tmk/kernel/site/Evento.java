/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.site;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Date;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Evento.
 * 
 * @version $Revision$ $Date$
 */
public class Evento implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _activo
     */
    private boolean _activo;

    /**
     * keeps track of state for field: _activo
     */
    private boolean _has_activo;

    /**
     * Field _descripcion
     */
    private java.lang.String _descripcion;

    /**
     * Field _sucursal
     */
    private int _sucursal;

    /**
     * keeps track of state for field: _sucursal
     */
    private boolean _has_sucursal;

    /**
     * Field _fecha
     */
    private java.util.Date _fecha;


      //----------------/
     //- Constructors -/
    //----------------/

    public Evento() {
        super();
    } //-- com.tmk.kernel.site.Evento()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'activo'.
     * 
     * @return the value of field 'activo'.
     */
    public boolean getActivo()
    {
        return this._activo;
    } //-- boolean getActivo() 

    /**
     * Returns the value of field 'descripcion'.
     * 
     * @return the value of field 'descripcion'.
     */
    public java.lang.String getDescripcion()
    {
        return this._descripcion;
    } //-- java.lang.String getDescripcion() 

    /**
     * Returns the value of field 'fecha'.
     * 
     * @return the value of field 'fecha'.
     */
    public java.util.Date getFecha()
    {
        return this._fecha;
    } //-- java.util.Date getFecha() 

    /**
     * Returns the value of field 'sucursal'.
     * 
     * @return the value of field 'sucursal'.
     */
    public int getSucursal()
    {
        return this._sucursal;
    } //-- int getSucursal() 

    /**
     * Method hasActivo
     */
    public boolean hasActivo()
    {
        return this._has_activo;
    } //-- boolean hasActivo() 

    /**
     * Method hasSucursal
     */
    public boolean hasSucursal()
    {
        return this._has_sucursal;
    } //-- boolean hasSucursal() 

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
     * Sets the value of field 'activo'.
     * 
     * @param activo the value of field 'activo'.
     */
    public void setActivo(boolean activo)
    {
        this._activo = activo;
        this._has_activo = true;
    } //-- void setActivo(boolean) 

    /**
     * Sets the value of field 'descripcion'.
     * 
     * @param descripcion the value of field 'descripcion'.
     */
    public void setDescripcion(java.lang.String descripcion)
    {
        this._descripcion = descripcion;
    } //-- void setDescripcion(java.lang.String) 

    /**
     * Sets the value of field 'fecha'.
     * 
     * @param fecha the value of field 'fecha'.
     */
    public void setFecha(java.util.Date fecha)
    {
        this._fecha = fecha;
    } //-- void setFecha(java.util.Date) 

    /**
     * Sets the value of field 'sucursal'.
     * 
     * @param sucursal the value of field 'sucursal'.
     */
    public void setSucursal(int sucursal)
    {
        this._sucursal = sucursal;
        this._has_sucursal = true;
    } //-- void setSucursal(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Evento unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Evento) Unmarshaller.unmarshal(com.tmk.kernel.site.Evento.class, reader);
    } //-- com.tmk.kernel.site.Evento unmarshal(java.io.Reader) 

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
