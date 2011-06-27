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
 * Class Categoria.
 * 
 * @version $Revision$ $Date$
 */
public class Categoria implements java.io.Serializable {


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
     * Field _idFamilia
     */
    private int _idFamilia = -1;

    /**
     * keeps track of state for field: _idFamilia
     */
    private boolean _has_idFamilia;

    /**
     * Field _idSubFamilia
     */
    private int _idSubFamilia = -1;

    /**
     * keeps track of state for field: _idSubFamilia
     */
    private boolean _has_idSubFamilia;

    /**
     * Field _descripcion
     */
    private java.lang.String _descripcion;


      //----------------/
     //- Constructors -/
    //----------------/

    public Categoria() {
        super();
    } //-- com.tmk.kernel.site.Categoria()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deleteIdFamilia
     */
    public void deleteIdFamilia()
    {
        this._has_idFamilia= false;
    } //-- void deleteIdFamilia() 

    /**
     * Method deleteIdSubFamilia
     */
    public void deleteIdSubFamilia()
    {
        this._has_idSubFamilia= false;
    } //-- void deleteIdSubFamilia() 

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
     * Returns the value of field 'idFamilia'.
     * 
     * @return the value of field 'idFamilia'.
     */
    public int getIdFamilia()
    {
        return this._idFamilia;
    } //-- int getIdFamilia() 

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
     * Returns the value of field 'idSubFamilia'.
     * 
     * @return the value of field 'idSubFamilia'.
     */
    public int getIdSubFamilia()
    {
        return this._idSubFamilia;
    } //-- int getIdSubFamilia() 

    /**
     * Method hasIdFamilia
     */
    public boolean hasIdFamilia()
    {
        return this._has_idFamilia;
    } //-- boolean hasIdFamilia() 

    /**
     * Method hasIdGrupo
     */
    public boolean hasIdGrupo()
    {
        return this._has_idGrupo;
    } //-- boolean hasIdGrupo() 

    /**
     * Method hasIdSubFamilia
     */
    public boolean hasIdSubFamilia()
    {
        return this._has_idSubFamilia;
    } //-- boolean hasIdSubFamilia() 

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
     * Sets the value of field 'idFamilia'.
     * 
     * @param idFamilia the value of field 'idFamilia'.
     */
    public void setIdFamilia(int idFamilia)
    {
        this._idFamilia = idFamilia;
        this._has_idFamilia = true;
    } //-- void setIdFamilia(int) 

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
     * Sets the value of field 'idSubFamilia'.
     * 
     * @param idSubFamilia the value of field 'idSubFamilia'.
     */
    public void setIdSubFamilia(int idSubFamilia)
    {
        this._idSubFamilia = idSubFamilia;
        this._has_idSubFamilia = true;
    } //-- void setIdSubFamilia(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Categoria unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Categoria) Unmarshaller.unmarshal(com.tmk.kernel.site.Categoria.class, reader);
    } //-- com.tmk.kernel.site.Categoria unmarshal(java.io.Reader) 

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
