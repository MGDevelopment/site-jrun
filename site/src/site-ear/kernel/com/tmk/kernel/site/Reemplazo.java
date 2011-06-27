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
 * Class Reemplazo.
 * 
 * @version $Revision$ $Date$
 */
public class Reemplazo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _origen
     */
    private java.lang.String _origen;

    /**
     * Field _destino
     */
    private java.lang.String _destino;


      //----------------/
     //- Constructors -/
    //----------------/

    public Reemplazo() {
        super();
    } //-- com.tmk.kernel.site.Reemplazo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'destino'.
     * 
     * @return the value of field 'destino'.
     */
    public java.lang.String getDestino()
    {
        return this._destino;
    } //-- java.lang.String getDestino() 

    /**
     * Returns the value of field 'origen'.
     * 
     * @return the value of field 'origen'.
     */
    public java.lang.String getOrigen()
    {
        return this._origen;
    } //-- java.lang.String getOrigen() 

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
     * Sets the value of field 'destino'.
     * 
     * @param destino the value of field 'destino'.
     */
    public void setDestino(java.lang.String destino)
    {
        this._destino = destino;
    } //-- void setDestino(java.lang.String) 

    /**
     * Sets the value of field 'origen'.
     * 
     * @param origen the value of field 'origen'.
     */
    public void setOrigen(java.lang.String origen)
    {
        this._origen = origen;
    } //-- void setOrigen(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Reemplazo unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Reemplazo) Unmarshaller.unmarshal(com.tmk.kernel.site.Reemplazo.class, reader);
    } //-- com.tmk.kernel.site.Reemplazo unmarshal(java.io.Reader) 

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
