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
 * Class Articulo.
 * 
 * @version $Revision$ $Date$
 */
public class Articulo implements java.io.Serializable {


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
     * Field _idSeccion
     */
    private int _idSeccion;

    /**
     * keeps track of state for field: _idSeccion
     */
    private boolean _has_idSeccion;

    /**
     * Field _texto
     */
    private java.lang.String _texto;


      //----------------/
     //- Constructors -/
    //----------------/

    public Articulo() {
        super();
    } //-- com.tmk.kernel.site.Articulo()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'idSeccion'.
     * 
     * @return the value of field 'idSeccion'.
     */
    public int getIdSeccion()
    {
        return this._idSeccion;
    } //-- int getIdSeccion() 

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
     * Method hasId
     */
    public boolean hasId()
    {
        return this._has_id;
    } //-- boolean hasId() 

    /**
     * Method hasIdSeccion
     */
    public boolean hasIdSeccion()
    {
        return this._has_idSeccion;
    } //-- boolean hasIdSeccion() 

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
     * Sets the value of field 'idSeccion'.
     * 
     * @param idSeccion the value of field 'idSeccion'.
     */
    public void setIdSeccion(int idSeccion)
    {
        this._idSeccion = idSeccion;
        this._has_idSeccion = true;
    } //-- void setIdSeccion(int) 

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
    public static com.tmk.kernel.site.Articulo unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Articulo) Unmarshaller.unmarshal(com.tmk.kernel.site.Articulo.class, reader);
    } //-- com.tmk.kernel.site.Articulo unmarshal(java.io.Reader) 

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
