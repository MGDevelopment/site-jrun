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
 * Class LinkBusqueda.
 * 
 * @version $Revision$ $Date$
 */
public class LinkBusqueda implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _categoriaList
     */
    private java.util.Vector _categoriaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public LinkBusqueda() {
        super();
        _categoriaList = new Vector();
    } //-- com.tmk.kernel.site.LinkBusqueda()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addCategoria
     * 
     * @param vCategoria
     */
    public void addCategoria(com.tmk.kernel.site.Categoria vCategoria)
        throws java.lang.IndexOutOfBoundsException
    {
        _categoriaList.addElement(vCategoria);
    } //-- void addCategoria(com.tmk.kernel.site.Categoria) 

    /**
     * Method addCategoria
     * 
     * @param index
     * @param vCategoria
     */
    public void addCategoria(int index, com.tmk.kernel.site.Categoria vCategoria)
        throws java.lang.IndexOutOfBoundsException
    {
        _categoriaList.insertElementAt(vCategoria, index);
    } //-- void addCategoria(int, com.tmk.kernel.site.Categoria) 

    /**
     * Method enumerateCategoria
     */
    public java.util.Enumeration enumerateCategoria()
    {
        return _categoriaList.elements();
    } //-- java.util.Enumeration enumerateCategoria() 

    /**
     * Method getCategoria
     * 
     * @param index
     */
    public com.tmk.kernel.site.Categoria getCategoria(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _categoriaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Categoria) _categoriaList.elementAt(index);
    } //-- com.tmk.kernel.site.Categoria getCategoria(int) 

    /**
     * Method getCategoria
     */
    public com.tmk.kernel.site.Categoria[] getCategoria()
    {
        int size = _categoriaList.size();
        com.tmk.kernel.site.Categoria[] mArray = new com.tmk.kernel.site.Categoria[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Categoria) _categoriaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Categoria[] getCategoria() 

    /**
     * Method getCategoriaCount
     */
    public int getCategoriaCount()
    {
        return _categoriaList.size();
    } //-- int getCategoriaCount() 

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
     * Method removeAllCategoria
     */
    public void removeAllCategoria()
    {
        _categoriaList.removeAllElements();
    } //-- void removeAllCategoria() 

    /**
     * Method removeCategoria
     * 
     * @param index
     */
    public com.tmk.kernel.site.Categoria removeCategoria(int index)
    {
        java.lang.Object obj = _categoriaList.elementAt(index);
        _categoriaList.removeElementAt(index);
        return (com.tmk.kernel.site.Categoria) obj;
    } //-- com.tmk.kernel.site.Categoria removeCategoria(int) 

    /**
     * Method setCategoria
     * 
     * @param index
     * @param vCategoria
     */
    public void setCategoria(int index, com.tmk.kernel.site.Categoria vCategoria)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _categoriaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _categoriaList.setElementAt(vCategoria, index);
    } //-- void setCategoria(int, com.tmk.kernel.site.Categoria) 

    /**
     * Method setCategoria
     * 
     * @param categoriaArray
     */
    public void setCategoria(com.tmk.kernel.site.Categoria[] categoriaArray)
    {
        //-- copy array
        _categoriaList.removeAllElements();
        for (int i = 0; i < categoriaArray.length; i++) {
            _categoriaList.addElement(categoriaArray[i]);
        }
    } //-- void setCategoria(com.tmk.kernel.site.Categoria) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.LinkBusqueda unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.LinkBusqueda) Unmarshaller.unmarshal(com.tmk.kernel.site.LinkBusqueda.class, reader);
    } //-- com.tmk.kernel.site.LinkBusqueda unmarshal(java.io.Reader) 

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
