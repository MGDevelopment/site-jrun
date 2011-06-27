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
 * Class PromoDiaDeLaMadre.
 * 
 * @version $Revision$ $Date$
 */
public class PromoDiaDeLaMadre implements java.io.Serializable {


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
     * Field _pesosPorCupon
     */
    private double _pesosPorCupon;

    /**
     * keeps track of state for field: _pesosPorCupon
     */
    private boolean _has_pesosPorCupon;


      //----------------/
     //- Constructors -/
    //----------------/

    public PromoDiaDeLaMadre() {
        super();
    } //-- com.tmk.kernel.server.PromoDiaDeLaMadre()


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
     * Returns the value of field 'pesosPorCupon'.
     * 
     * @return the value of field 'pesosPorCupon'.
     */
    public double getPesosPorCupon()
    {
        return this._pesosPorCupon;
    } //-- double getPesosPorCupon() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasPesosPorCupon
     */
    public boolean hasPesosPorCupon()
    {
        return this._has_pesosPorCupon;
    } //-- boolean hasPesosPorCupon() 

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
     * Sets the value of field 'pesosPorCupon'.
     * 
     * @param pesosPorCupon the value of field 'pesosPorCupon'.
     */
    public void setPesosPorCupon(double pesosPorCupon)
    {
        this._pesosPorCupon = pesosPorCupon;
        this._has_pesosPorCupon = true;
    } //-- void setPesosPorCupon(double) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.PromoDiaDeLaMadre unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.PromoDiaDeLaMadre) Unmarshaller.unmarshal(com.tmk.kernel.server.PromoDiaDeLaMadre.class, reader);
    } //-- com.tmk.kernel.server.PromoDiaDeLaMadre unmarshal(java.io.Reader) 

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
