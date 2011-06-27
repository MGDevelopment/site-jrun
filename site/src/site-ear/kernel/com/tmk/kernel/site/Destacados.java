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
 * Class Destacados.
 * 
 * @version $Revision$ $Date$
 */
public class Destacados implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _articuloList
     */
    private java.util.Vector _articuloList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Destacados() {
        super();
        _articuloList = new Vector();
    } //-- com.tmk.kernel.site.Destacados()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addArticulo
     * 
     * @param vArticulo
     */
    public void addArticulo(com.tmk.kernel.site.Articulo vArticulo)
        throws java.lang.IndexOutOfBoundsException
    {
        _articuloList.addElement(vArticulo);
    } //-- void addArticulo(com.tmk.kernel.site.Articulo) 

    /**
     * Method addArticulo
     * 
     * @param index
     * @param vArticulo
     */
    public void addArticulo(int index, com.tmk.kernel.site.Articulo vArticulo)
        throws java.lang.IndexOutOfBoundsException
    {
        _articuloList.insertElementAt(vArticulo, index);
    } //-- void addArticulo(int, com.tmk.kernel.site.Articulo) 

    /**
     * Method enumerateArticulo
     */
    public java.util.Enumeration enumerateArticulo()
    {
        return _articuloList.elements();
    } //-- java.util.Enumeration enumerateArticulo() 

    /**
     * Method getArticulo
     * 
     * @param index
     */
    public com.tmk.kernel.site.Articulo getArticulo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _articuloList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Articulo) _articuloList.elementAt(index);
    } //-- com.tmk.kernel.site.Articulo getArticulo(int) 

    /**
     * Method getArticulo
     */
    public com.tmk.kernel.site.Articulo[] getArticulo()
    {
        int size = _articuloList.size();
        com.tmk.kernel.site.Articulo[] mArray = new com.tmk.kernel.site.Articulo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Articulo) _articuloList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Articulo[] getArticulo() 

    /**
     * Method getArticuloCount
     */
    public int getArticuloCount()
    {
        return _articuloList.size();
    } //-- int getArticuloCount() 

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
     * Method removeAllArticulo
     */
    public void removeAllArticulo()
    {
        _articuloList.removeAllElements();
    } //-- void removeAllArticulo() 

    /**
     * Method removeArticulo
     * 
     * @param index
     */
    public com.tmk.kernel.site.Articulo removeArticulo(int index)
    {
        java.lang.Object obj = _articuloList.elementAt(index);
        _articuloList.removeElementAt(index);
        return (com.tmk.kernel.site.Articulo) obj;
    } //-- com.tmk.kernel.site.Articulo removeArticulo(int) 

    /**
     * Method setArticulo
     * 
     * @param index
     * @param vArticulo
     */
    public void setArticulo(int index, com.tmk.kernel.site.Articulo vArticulo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _articuloList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _articuloList.setElementAt(vArticulo, index);
    } //-- void setArticulo(int, com.tmk.kernel.site.Articulo) 

    /**
     * Method setArticulo
     * 
     * @param articuloArray
     */
    public void setArticulo(com.tmk.kernel.site.Articulo[] articuloArray)
    {
        //-- copy array
        _articuloList.removeAllElements();
        for (int i = 0; i < articuloArray.length; i++) {
            _articuloList.addElement(articuloArray[i]);
        }
    } //-- void setArticulo(com.tmk.kernel.site.Articulo) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Destacados unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Destacados) Unmarshaller.unmarshal(com.tmk.kernel.site.Destacados.class, reader);
    } //-- com.tmk.kernel.site.Destacados unmarshal(java.io.Reader) 

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
