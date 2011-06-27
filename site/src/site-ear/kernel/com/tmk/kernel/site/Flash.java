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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Flash.
 * 
 * @version $Revision$ $Date$
 */
public class Flash implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _file
     */
    private java.lang.String _file;

    /**
     * Field _ancho
     */
    private int _ancho;

    /**
     * keeps track of state for field: _ancho
     */
    private boolean _has_ancho;

    /**
     * Field _alto
     */
    private int _alto;

    /**
     * keeps track of state for field: _alto
     */
    private boolean _has_alto;

    /**
     * Field _texto
     */
    private java.lang.String _texto;


      //----------------/
     //- Constructors -/
    //----------------/

    public Flash() {
        super();
    } //-- com.tmk.kernel.site.Flash()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'alto'.
     * 
     * @return the value of field 'alto'.
     */
    public int getAlto()
    {
        return this._alto;
    } //-- int getAlto() 

    /**
     * Returns the value of field 'ancho'.
     * 
     * @return the value of field 'ancho'.
     */
    public int getAncho()
    {
        return this._ancho;
    } //-- int getAncho() 

    /**
     * Returns the value of field 'file'.
     * 
     * @return the value of field 'file'.
     */
    public java.lang.String getFile()
    {
        return this._file;
    } //-- java.lang.String getFile() 

    /**
     * Returns the value of field 'texto'.
     * 
     * @return the value of field 'texto'.
     */
    public java.lang.String getTexto()
    {
        return this._texto;
    } //-- java.lang.String getTexto() 

    /**
     * Method hasAlto
     */
    public boolean hasAlto()
    {
        return this._has_alto;
    } //-- boolean hasAlto() 

    /**
     * Method hasAncho
     */
    public boolean hasAncho()
    {
        return this._has_ancho;
    } //-- boolean hasAncho() 

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
     * Sets the value of field 'alto'.
     * 
     * @param alto the value of field 'alto'.
     */
    public void setAlto(int alto)
    {
        this._alto = alto;
        this._has_alto = true;
    } //-- void setAlto(int) 

    /**
     * Sets the value of field 'ancho'.
     * 
     * @param ancho the value of field 'ancho'.
     */
    public void setAncho(int ancho)
    {
        this._ancho = ancho;
        this._has_ancho = true;
    } //-- void setAncho(int) 

    /**
     * Sets the value of field 'file'.
     * 
     * @param file the value of field 'file'.
     */
    public void setFile(java.lang.String file)
    {
        this._file = file;
    } //-- void setFile(java.lang.String) 

    /**
     * Sets the value of field 'texto'.
     * 
     * @param texto the value of field 'texto'.
     */
    public void setTexto(java.lang.String texto)
    {
        this._texto = texto;
    } //-- void setTexto(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Flash unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Flash) Unmarshaller.unmarshal(com.tmk.kernel.site.Flash.class, reader);
    } //-- com.tmk.kernel.site.Flash unmarshal(java.io.Reader) 

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
