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
 * Class Favoritos.
 * 
 * @version $Revision$ $Date$
 */
public class Favoritos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _autorList
     */
    private java.util.Vector _autorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Favoritos() {
        super();
        _autorList = new Vector();
    } //-- com.tmk.kernel.site.Favoritos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addAutor
     * 
     * @param vAutor
     */
    public void addAutor(com.tmk.kernel.site.Autor vAutor)
        throws java.lang.IndexOutOfBoundsException
    {
        _autorList.addElement(vAutor);
    } //-- void addAutor(com.tmk.kernel.site.Autor) 

    /**
     * Method addAutor
     * 
     * @param index
     * @param vAutor
     */
    public void addAutor(int index, com.tmk.kernel.site.Autor vAutor)
        throws java.lang.IndexOutOfBoundsException
    {
        _autorList.insertElementAt(vAutor, index);
    } //-- void addAutor(int, com.tmk.kernel.site.Autor) 

    /**
     * Method enumerateAutor
     */
    public java.util.Enumeration enumerateAutor()
    {
        return _autorList.elements();
    } //-- java.util.Enumeration enumerateAutor() 

    /**
     * Method getAutor
     * 
     * @param index
     */
    public com.tmk.kernel.site.Autor getAutor(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _autorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Autor) _autorList.elementAt(index);
    } //-- com.tmk.kernel.site.Autor getAutor(int) 

    /**
     * Method getAutor
     */
    public com.tmk.kernel.site.Autor[] getAutor()
    {
        int size = _autorList.size();
        com.tmk.kernel.site.Autor[] mArray = new com.tmk.kernel.site.Autor[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Autor) _autorList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Autor[] getAutor() 

    /**
     * Method getAutorCount
     */
    public int getAutorCount()
    {
        return _autorList.size();
    } //-- int getAutorCount() 

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
     * Method removeAllAutor
     */
    public void removeAllAutor()
    {
        _autorList.removeAllElements();
    } //-- void removeAllAutor() 

    /**
     * Method removeAutor
     * 
     * @param index
     */
    public com.tmk.kernel.site.Autor removeAutor(int index)
    {
        java.lang.Object obj = _autorList.elementAt(index);
        _autorList.removeElementAt(index);
        return (com.tmk.kernel.site.Autor) obj;
    } //-- com.tmk.kernel.site.Autor removeAutor(int) 

    /**
     * Method setAutor
     * 
     * @param index
     * @param vAutor
     */
    public void setAutor(int index, com.tmk.kernel.site.Autor vAutor)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _autorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _autorList.setElementAt(vAutor, index);
    } //-- void setAutor(int, com.tmk.kernel.site.Autor) 

    /**
     * Method setAutor
     * 
     * @param autorArray
     */
    public void setAutor(com.tmk.kernel.site.Autor[] autorArray)
    {
        //-- copy array
        _autorList.removeAllElements();
        for (int i = 0; i < autorArray.length; i++) {
            _autorList.addElement(autorArray[i]);
        }
    } //-- void setAutor(com.tmk.kernel.site.Autor) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Favoritos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Favoritos) Unmarshaller.unmarshal(com.tmk.kernel.site.Favoritos.class, reader);
    } //-- com.tmk.kernel.site.Favoritos unmarshal(java.io.Reader) 

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
