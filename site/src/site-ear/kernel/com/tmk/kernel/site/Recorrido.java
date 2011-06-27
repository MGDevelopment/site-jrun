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
 * Class Recorrido.
 * 
 * @version $Revision$ $Date$
 */
public class Recorrido implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _idGrupo
     */
    private int _idGrupo;

    /**
     * keeps track of state for field: _idGrupo
     */
    private boolean _has_idGrupo;

    /**
     * Field _descripcion
     */
    private java.lang.String _descripcion;


      //----------------/
     //- Constructors -/
    //----------------/

    public Recorrido() {
        super();
    } //-- com.tmk.kernel.site.Recorrido()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Returns the value of field 'idGrupo'.
     * 
     * @return the value of field 'idGrupo'.
     */
    public int getIdGrupo()
    {
        return this._idGrupo;
    } //-- int getIdGrupo() 

    /**
     * Method hasIdGrupo
     */
    public boolean hasIdGrupo()
    {
        return this._has_idGrupo;
    } //-- boolean hasIdGrupo() 

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
     * Sets the value of field 'descripcion'.
     * 
     * @param descripcion the value of field 'descripcion'.
     */
    public void setDescripcion(java.lang.String descripcion)
    {
        this._descripcion = descripcion;
    } //-- void setDescripcion(java.lang.String) 

    /**
     * Sets the value of field 'idGrupo'.
     * 
     * @param idGrupo the value of field 'idGrupo'.
     */
    public void setIdGrupo(int idGrupo)
    {
        this._idGrupo = idGrupo;
        this._has_idGrupo = true;
    } //-- void setIdGrupo(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Recorrido unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Recorrido) Unmarshaller.unmarshal(com.tmk.kernel.site.Recorrido.class, reader);
    } //-- com.tmk.kernel.site.Recorrido unmarshal(java.io.Reader) 

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
