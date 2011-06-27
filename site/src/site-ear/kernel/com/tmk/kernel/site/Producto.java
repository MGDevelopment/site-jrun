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
 * Class Producto.
 * 
 * @version $Revision$ $Date$
 */
public class Producto implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _icono
     */
    private java.lang.String _icono;

    /**
     * Field _texto
     */
    private java.lang.String _texto;

    /**
     * Field _hint
     */
    private java.lang.String _hint;

    /**
     * Field _vencimiento
     */
    private java.util.Date _vencimiento;


      //----------------/
     //- Constructors -/
    //----------------/

    public Producto() {
        super();
    } //-- com.tmk.kernel.site.Producto()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'hint'.
     * 
     * @return the value of field 'hint'.
     */
    public java.lang.String getHint()
    {
        return this._hint;
    } //-- java.lang.String getHint() 

    /**
     * Returns the value of field 'icono'.
     * 
     * @return the value of field 'icono'.
     */
    public java.lang.String getIcono()
    {
        return this._icono;
    } //-- java.lang.String getIcono() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'id'.
     */
    public int getId()
    {
        return this._id;
    } //-- int getId() 

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
     * Returns the value of field 'vencimiento'.
     * 
     * @return the value of field 'vencimiento'.
     */
    public java.util.Date getVencimiento()
    {
        return this._vencimiento;
    } //-- java.util.Date getVencimiento() 

    /**
     * Method hasId
     */
    public boolean hasId()
    {
        return this._has_id;
    } //-- boolean hasId() 

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
     * Sets the value of field 'hint'.
     * 
     * @param hint the value of field 'hint'.
     */
    public void setHint(java.lang.String hint)
    {
        this._hint = hint;
    } //-- void setHint(java.lang.String) 

    /**
     * Sets the value of field 'icono'.
     * 
     * @param icono the value of field 'icono'.
     */
    public void setIcono(java.lang.String icono)
    {
        this._icono = icono;
    } //-- void setIcono(java.lang.String) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(int id)
    {
        this._id = id;
        this._has_id = true;
    } //-- void setId(int) 

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
     * Sets the value of field 'vencimiento'.
     * 
     * @param vencimiento the value of field 'vencimiento'.
     */
    public void setVencimiento(java.util.Date vencimiento)
    {
        this._vencimiento = vencimiento;
    } //-- void setVencimiento(java.util.Date) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Producto unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Producto) Unmarshaller.unmarshal(com.tmk.kernel.site.Producto.class, reader);
    } //-- com.tmk.kernel.site.Producto unmarshal(java.io.Reader) 

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
