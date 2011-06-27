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
 * Class PromoChequeObsequio.
 * 
 * @version $Revision$ $Date$
 */
public class PromoChequeObsequio implements java.io.Serializable {


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
     * Field _codigoChequeObsequio
     */
    private java.lang.String _codigoChequeObsequio;


      //----------------/
     //- Constructors -/
    //----------------/

    public PromoChequeObsequio() {
        super();
    } //-- com.tmk.kernel.server.PromoChequeObsequio()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'codigoChequeObsequio'.
     * 
     * @return the value of field 'codigoChequeObsequio'.
     */
    public java.lang.String getCodigoChequeObsequio()
    {
        return this._codigoChequeObsequio;
    } //-- java.lang.String getCodigoChequeObsequio() 

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
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

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
     * Sets the value of field 'codigoChequeObsequio'.
     * 
     * @param codigoChequeObsequio the value of field
     * 'codigoChequeObsequio'.
     */
    public void setCodigoChequeObsequio(java.lang.String codigoChequeObsequio)
    {
        this._codigoChequeObsequio = codigoChequeObsequio;
    } //-- void setCodigoChequeObsequio(java.lang.String) 

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
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.PromoChequeObsequio unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.PromoChequeObsequio) Unmarshaller.unmarshal(com.tmk.kernel.server.PromoChequeObsequio.class, reader);
    } //-- com.tmk.kernel.server.PromoChequeObsequio unmarshal(java.io.Reader) 

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
