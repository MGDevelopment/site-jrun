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
 * Class RecorridoGrupo.
 * 
 * @version $Revision$ $Date$
 */
public class RecorridoGrupo implements java.io.Serializable {


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
     * Field _claves
     */
    private com.tmk.kernel.site.Claves _claves;

    /**
     * Field _recorridoFamilias
     */
    private com.tmk.kernel.site.RecorridoFamilias _recorridoFamilias;


      //----------------/
     //- Constructors -/
    //----------------/

    public RecorridoGrupo() {
        super();
    } //-- com.tmk.kernel.site.RecorridoGrupo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'claves'.
     * 
     * @return the value of field 'claves'.
     */
    public com.tmk.kernel.site.Claves getClaves()
    {
        return this._claves;
    } //-- com.tmk.kernel.site.Claves getClaves() 

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
     * Returns the value of field 'recorridoFamilias'.
     * 
     * @return the value of field 'recorridoFamilias'.
     */
    public com.tmk.kernel.site.RecorridoFamilias getRecorridoFamilias()
    {
        return this._recorridoFamilias;
    } //-- com.tmk.kernel.site.RecorridoFamilias getRecorridoFamilias() 

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
     * Sets the value of field 'claves'.
     * 
     * @param claves the value of field 'claves'.
     */
    public void setClaves(com.tmk.kernel.site.Claves claves)
    {
        this._claves = claves;
    } //-- void setClaves(com.tmk.kernel.site.Claves) 

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
     * Sets the value of field 'recorridoFamilias'.
     * 
     * @param recorridoFamilias the value of field
     * 'recorridoFamilias'.
     */
    public void setRecorridoFamilias(com.tmk.kernel.site.RecorridoFamilias recorridoFamilias)
    {
        this._recorridoFamilias = recorridoFamilias;
    } //-- void setRecorridoFamilias(com.tmk.kernel.site.RecorridoFamilias) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RecorridoGrupo unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RecorridoGrupo) Unmarshaller.unmarshal(com.tmk.kernel.site.RecorridoGrupo.class, reader);
    } //-- com.tmk.kernel.site.RecorridoGrupo unmarshal(java.io.Reader) 

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
