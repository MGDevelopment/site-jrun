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
 * Class CallCenter.
 * 
 * @version $Revision$ $Date$
 */
public class CallCenter implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _email
     */
    private java.lang.String _email;

    /**
     * Field _horario
     */
    private java.lang.String _horario;

    /**
     * Field _telefono
     */
    private java.lang.String _telefono;

    /**
     * Field _telefonoExterior
     */
    private java.lang.String _telefonoExterior;

    /**
     * Field _FAX
     */
    private java.lang.String _FAX;


      //----------------/
     //- Constructors -/
    //----------------/

    public CallCenter() {
        super();
    } //-- com.tmk.kernel.site.CallCenter()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'email'.
     * 
     * @return the value of field 'email'.
     */
    public java.lang.String getEmail()
    {
        return this._email;
    } //-- java.lang.String getEmail() 

    /**
     * Returns the value of field 'FAX'.
     * 
     * @return the value of field 'FAX'.
     */
    public java.lang.String getFAX()
    {
        return this._FAX;
    } //-- java.lang.String getFAX() 

    /**
     * Returns the value of field 'horario'.
     * 
     * @return the value of field 'horario'.
     */
    public java.lang.String getHorario()
    {
        return this._horario;
    } //-- java.lang.String getHorario() 

    /**
     * Returns the value of field 'telefono'.
     * 
     * @return the value of field 'telefono'.
     */
    public java.lang.String getTelefono()
    {
        return this._telefono;
    } //-- java.lang.String getTelefono() 

    /**
     * Returns the value of field 'telefonoExterior'.
     * 
     * @return the value of field 'telefonoExterior'.
     */
    public java.lang.String getTelefonoExterior()
    {
        return this._telefonoExterior;
    } //-- java.lang.String getTelefonoExterior() 

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
     * Sets the value of field 'email'.
     * 
     * @param email the value of field 'email'.
     */
    public void setEmail(java.lang.String email)
    {
        this._email = email;
    } //-- void setEmail(java.lang.String) 

    /**
     * Sets the value of field 'FAX'.
     * 
     * @param FAX the value of field 'FAX'.
     */
    public void setFAX(java.lang.String FAX)
    {
        this._FAX = FAX;
    } //-- void setFAX(java.lang.String) 

    /**
     * Sets the value of field 'horario'.
     * 
     * @param horario the value of field 'horario'.
     */
    public void setHorario(java.lang.String horario)
    {
        this._horario = horario;
    } //-- void setHorario(java.lang.String) 

    /**
     * Sets the value of field 'telefono'.
     * 
     * @param telefono the value of field 'telefono'.
     */
    public void setTelefono(java.lang.String telefono)
    {
        this._telefono = telefono;
    } //-- void setTelefono(java.lang.String) 

    /**
     * Sets the value of field 'telefonoExterior'.
     * 
     * @param telefonoExterior the value of field 'telefonoExterior'
     */
    public void setTelefonoExterior(java.lang.String telefonoExterior)
    {
        this._telefonoExterior = telefonoExterior;
    } //-- void setTelefonoExterior(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.CallCenter unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.CallCenter) Unmarshaller.unmarshal(com.tmk.kernel.site.CallCenter.class, reader);
    } //-- com.tmk.kernel.site.CallCenter unmarshal(java.io.Reader) 

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
