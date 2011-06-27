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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class NuestraCategoriasSeccion.
 * 
 * @version $Revision$ $Date$
 */
public class NuestraCategoriasSeccion implements java.io.Serializable {


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
     * Field _nuestraCategoriasGrupoList
     */
    private java.util.Vector _nuestraCategoriasGrupoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NuestraCategoriasSeccion() {
        super();
        _nuestraCategoriasGrupoList = new Vector();
    } //-- com.tmk.kernel.site.NuestraCategoriasSeccion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addNuestraCategoriasGrupo
     * 
     * @param vNuestraCategoriasGrupo
     */
    public void addNuestraCategoriasGrupo(com.tmk.kernel.site.NuestraCategoriasGrupo vNuestraCategoriasGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _nuestraCategoriasGrupoList.addElement(vNuestraCategoriasGrupo);
    } //-- void addNuestraCategoriasGrupo(com.tmk.kernel.site.NuestraCategoriasGrupo) 

    /**
     * Method addNuestraCategoriasGrupo
     * 
     * @param index
     * @param vNuestraCategoriasGrupo
     */
    public void addNuestraCategoriasGrupo(int index, com.tmk.kernel.site.NuestraCategoriasGrupo vNuestraCategoriasGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _nuestraCategoriasGrupoList.insertElementAt(vNuestraCategoriasGrupo, index);
    } //-- void addNuestraCategoriasGrupo(int, com.tmk.kernel.site.NuestraCategoriasGrupo) 

    /**
     * Method enumerateNuestraCategoriasGrupo
     */
    public java.util.Enumeration enumerateNuestraCategoriasGrupo()
    {
        return _nuestraCategoriasGrupoList.elements();
    } //-- java.util.Enumeration enumerateNuestraCategoriasGrupo() 

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
     * Method getNuestraCategoriasGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.NuestraCategoriasGrupo getNuestraCategoriasGrupo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _nuestraCategoriasGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.NuestraCategoriasGrupo) _nuestraCategoriasGrupoList.elementAt(index);
    } //-- com.tmk.kernel.site.NuestraCategoriasGrupo getNuestraCategoriasGrupo(int) 

    /**
     * Method getNuestraCategoriasGrupo
     */
    public com.tmk.kernel.site.NuestraCategoriasGrupo[] getNuestraCategoriasGrupo()
    {
        int size = _nuestraCategoriasGrupoList.size();
        com.tmk.kernel.site.NuestraCategoriasGrupo[] mArray = new com.tmk.kernel.site.NuestraCategoriasGrupo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.NuestraCategoriasGrupo) _nuestraCategoriasGrupoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.NuestraCategoriasGrupo[] getNuestraCategoriasGrupo() 

    /**
     * Method getNuestraCategoriasGrupoCount
     */
    public int getNuestraCategoriasGrupoCount()
    {
        return _nuestraCategoriasGrupoList.size();
    } //-- int getNuestraCategoriasGrupoCount() 

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
     * Method removeAllNuestraCategoriasGrupo
     */
    public void removeAllNuestraCategoriasGrupo()
    {
        _nuestraCategoriasGrupoList.removeAllElements();
    } //-- void removeAllNuestraCategoriasGrupo() 

    /**
     * Method removeNuestraCategoriasGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.NuestraCategoriasGrupo removeNuestraCategoriasGrupo(int index)
    {
        java.lang.Object obj = _nuestraCategoriasGrupoList.elementAt(index);
        _nuestraCategoriasGrupoList.removeElementAt(index);
        return (com.tmk.kernel.site.NuestraCategoriasGrupo) obj;
    } //-- com.tmk.kernel.site.NuestraCategoriasGrupo removeNuestraCategoriasGrupo(int) 

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
     * Method setNuestraCategoriasGrupo
     * 
     * @param index
     * @param vNuestraCategoriasGrupo
     */
    public void setNuestraCategoriasGrupo(int index, com.tmk.kernel.site.NuestraCategoriasGrupo vNuestraCategoriasGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _nuestraCategoriasGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _nuestraCategoriasGrupoList.setElementAt(vNuestraCategoriasGrupo, index);
    } //-- void setNuestraCategoriasGrupo(int, com.tmk.kernel.site.NuestraCategoriasGrupo) 

    /**
     * Method setNuestraCategoriasGrupo
     * 
     * @param nuestraCategoriasGrupoArray
     */
    public void setNuestraCategoriasGrupo(com.tmk.kernel.site.NuestraCategoriasGrupo[] nuestraCategoriasGrupoArray)
    {
        //-- copy array
        _nuestraCategoriasGrupoList.removeAllElements();
        for (int i = 0; i < nuestraCategoriasGrupoArray.length; i++) {
            _nuestraCategoriasGrupoList.addElement(nuestraCategoriasGrupoArray[i]);
        }
    } //-- void setNuestraCategoriasGrupo(com.tmk.kernel.site.NuestraCategoriasGrupo) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.NuestraCategoriasSeccion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.NuestraCategoriasSeccion) Unmarshaller.unmarshal(com.tmk.kernel.site.NuestraCategoriasSeccion.class, reader);
    } //-- com.tmk.kernel.site.NuestraCategoriasSeccion unmarshal(java.io.Reader) 

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
