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
 * Class NuestrasCategorias.
 * 
 * @version $Revision$ $Date$
 */
public class NuestrasCategorias implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nuestraCategoriasSeccionList
     */
    private java.util.Vector _nuestraCategoriasSeccionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public NuestrasCategorias() {
        super();
        _nuestraCategoriasSeccionList = new Vector();
    } //-- com.tmk.kernel.site.NuestrasCategorias()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addNuestraCategoriasSeccion
     * 
     * @param vNuestraCategoriasSeccion
     */
    public void addNuestraCategoriasSeccion(com.tmk.kernel.site.NuestraCategoriasSeccion vNuestraCategoriasSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _nuestraCategoriasSeccionList.addElement(vNuestraCategoriasSeccion);
    } //-- void addNuestraCategoriasSeccion(com.tmk.kernel.site.NuestraCategoriasSeccion) 

    /**
     * Method addNuestraCategoriasSeccion
     * 
     * @param index
     * @param vNuestraCategoriasSeccion
     */
    public void addNuestraCategoriasSeccion(int index, com.tmk.kernel.site.NuestraCategoriasSeccion vNuestraCategoriasSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _nuestraCategoriasSeccionList.insertElementAt(vNuestraCategoriasSeccion, index);
    } //-- void addNuestraCategoriasSeccion(int, com.tmk.kernel.site.NuestraCategoriasSeccion) 

    /**
     * Method enumerateNuestraCategoriasSeccion
     */
    public java.util.Enumeration enumerateNuestraCategoriasSeccion()
    {
        return _nuestraCategoriasSeccionList.elements();
    } //-- java.util.Enumeration enumerateNuestraCategoriasSeccion() 

    /**
     * Method getNuestraCategoriasSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.NuestraCategoriasSeccion getNuestraCategoriasSeccion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _nuestraCategoriasSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.NuestraCategoriasSeccion) _nuestraCategoriasSeccionList.elementAt(index);
    } //-- com.tmk.kernel.site.NuestraCategoriasSeccion getNuestraCategoriasSeccion(int) 

    /**
     * Method getNuestraCategoriasSeccion
     */
    public com.tmk.kernel.site.NuestraCategoriasSeccion[] getNuestraCategoriasSeccion()
    {
        int size = _nuestraCategoriasSeccionList.size();
        com.tmk.kernel.site.NuestraCategoriasSeccion[] mArray = new com.tmk.kernel.site.NuestraCategoriasSeccion[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.NuestraCategoriasSeccion) _nuestraCategoriasSeccionList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.NuestraCategoriasSeccion[] getNuestraCategoriasSeccion() 

    /**
     * Method getNuestraCategoriasSeccionCount
     */
    public int getNuestraCategoriasSeccionCount()
    {
        return _nuestraCategoriasSeccionList.size();
    } //-- int getNuestraCategoriasSeccionCount() 

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
     * Method removeAllNuestraCategoriasSeccion
     */
    public void removeAllNuestraCategoriasSeccion()
    {
        _nuestraCategoriasSeccionList.removeAllElements();
    } //-- void removeAllNuestraCategoriasSeccion() 

    /**
     * Method removeNuestraCategoriasSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.NuestraCategoriasSeccion removeNuestraCategoriasSeccion(int index)
    {
        java.lang.Object obj = _nuestraCategoriasSeccionList.elementAt(index);
        _nuestraCategoriasSeccionList.removeElementAt(index);
        return (com.tmk.kernel.site.NuestraCategoriasSeccion) obj;
    } //-- com.tmk.kernel.site.NuestraCategoriasSeccion removeNuestraCategoriasSeccion(int) 

    /**
     * Method setNuestraCategoriasSeccion
     * 
     * @param index
     * @param vNuestraCategoriasSeccion
     */
    public void setNuestraCategoriasSeccion(int index, com.tmk.kernel.site.NuestraCategoriasSeccion vNuestraCategoriasSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _nuestraCategoriasSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _nuestraCategoriasSeccionList.setElementAt(vNuestraCategoriasSeccion, index);
    } //-- void setNuestraCategoriasSeccion(int, com.tmk.kernel.site.NuestraCategoriasSeccion) 

    /**
     * Method setNuestraCategoriasSeccion
     * 
     * @param nuestraCategoriasSeccionArray
     */
    public void setNuestraCategoriasSeccion(com.tmk.kernel.site.NuestraCategoriasSeccion[] nuestraCategoriasSeccionArray)
    {
        //-- copy array
        _nuestraCategoriasSeccionList.removeAllElements();
        for (int i = 0; i < nuestraCategoriasSeccionArray.length; i++) {
            _nuestraCategoriasSeccionList.addElement(nuestraCategoriasSeccionArray[i]);
        }
    } //-- void setNuestraCategoriasSeccion(com.tmk.kernel.site.NuestraCategoriasSeccion) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.NuestrasCategorias unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.NuestrasCategorias) Unmarshaller.unmarshal(com.tmk.kernel.site.NuestrasCategorias.class, reader);
    } //-- com.tmk.kernel.site.NuestrasCategorias unmarshal(java.io.Reader) 

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
