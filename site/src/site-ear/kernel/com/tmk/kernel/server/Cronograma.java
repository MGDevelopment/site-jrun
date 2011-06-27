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

import com.tmk.kernel.server.types.DiaType;
import com.tmk.kernel.server.types.ModoType;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.types.Time;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Cronograma.
 * 
 * @version $Revision$ $Date$
 */
public class Cronograma implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _modo
     */
    private com.tmk.kernel.server.types.ModoType _modo;

    /**
     * Field _dia
     */
    private com.tmk.kernel.server.types.DiaType _dia;

    /**
     * Field _comienzo
     */
    private org.exolab.castor.types.Time _comienzo;

    /**
     * Field _fin
     */
    private org.exolab.castor.types.Time _fin;


      //----------------/
     //- Constructors -/
    //----------------/

    public Cronograma() {
        super();
    } //-- com.tmk.kernel.server.Cronograma()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'comienzo'.
     * 
     * @return the value of field 'comienzo'.
     */
    public org.exolab.castor.types.Time getComienzo()
    {
        return this._comienzo;
    } //-- org.exolab.castor.types.Time getComienzo() 

    /**
     * Returns the value of field 'dia'.
     * 
     * @return the value of field 'dia'.
     */
    public com.tmk.kernel.server.types.DiaType getDia()
    {
        return this._dia;
    } //-- com.tmk.kernel.server.types.DiaType getDia() 

    /**
     * Returns the value of field 'fin'.
     * 
     * @return the value of field 'fin'.
     */
    public org.exolab.castor.types.Time getFin()
    {
        return this._fin;
    } //-- org.exolab.castor.types.Time getFin() 

    /**
     * Returns the value of field 'modo'.
     * 
     * @return the value of field 'modo'.
     */
    public com.tmk.kernel.server.types.ModoType getModo()
    {
        return this._modo;
    } //-- com.tmk.kernel.server.types.ModoType getModo() 

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
     * Sets the value of field 'comienzo'.
     * 
     * @param comienzo the value of field 'comienzo'.
     */
    public void setComienzo(org.exolab.castor.types.Time comienzo)
    {
        this._comienzo = comienzo;
    } //-- void setComienzo(org.exolab.castor.types.Time) 

    /**
     * Sets the value of field 'dia'.
     * 
     * @param dia the value of field 'dia'.
     */
    public void setDia(com.tmk.kernel.server.types.DiaType dia)
    {
        this._dia = dia;
    } //-- void setDia(com.tmk.kernel.server.types.DiaType) 

    /**
     * Sets the value of field 'fin'.
     * 
     * @param fin the value of field 'fin'.
     */
    public void setFin(org.exolab.castor.types.Time fin)
    {
        this._fin = fin;
    } //-- void setFin(org.exolab.castor.types.Time) 

    /**
     * Sets the value of field 'modo'.
     * 
     * @param modo the value of field 'modo'.
     */
    public void setModo(com.tmk.kernel.server.types.ModoType modo)
    {
        this._modo = modo;
    } //-- void setModo(com.tmk.kernel.server.types.ModoType) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Cronograma unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Cronograma) Unmarshaller.unmarshal(com.tmk.kernel.server.Cronograma.class, reader);
    } //-- com.tmk.kernel.server.Cronograma unmarshal(java.io.Reader) 

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
