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

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Class TextoType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class TextoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _textoList
     */
    private java.util.Vector _textoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public TextoType() {
        super();
        _textoList = new Vector();
    } //-- com.tmk.kernel.site.TextoType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addTexto
     * 
     * @param vTexto
     */
    public void addTexto(java.lang.String vTexto)
        throws java.lang.IndexOutOfBoundsException
    {
        _textoList.addElement(vTexto);
    } //-- void addTexto(java.lang.String) 

    /**
     * Method addTexto
     * 
     * @param index
     * @param vTexto
     */
    public void addTexto(int index, java.lang.String vTexto)
        throws java.lang.IndexOutOfBoundsException
    {
        _textoList.insertElementAt(vTexto, index);
    } //-- void addTexto(int, java.lang.String) 

    /**
     * Method enumerateTexto
     */
    public java.util.Enumeration enumerateTexto()
    {
        return _textoList.elements();
    } //-- java.util.Enumeration enumerateTexto() 

    /**
     * Method getTexto
     * 
     * @param index
     */
    public java.lang.String getTexto(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _textoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_textoList.elementAt(index);
    } //-- java.lang.String getTexto(int) 

    /**
     * Method getTexto
     */
    public java.lang.String[] getTexto()
    {
        int size = _textoList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_textoList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getTexto() 

    /**
     * Method getTextoCount
     */
    public int getTextoCount()
    {
        return _textoList.size();
    } //-- int getTextoCount() 

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
     * Method removeAllTexto
     */
    public void removeAllTexto()
    {
        _textoList.removeAllElements();
    } //-- void removeAllTexto() 

    /**
     * Method removeTexto
     * 
     * @param index
     */
    public java.lang.String removeTexto(int index)
    {
        java.lang.Object obj = _textoList.elementAt(index);
        _textoList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeTexto(int) 

    /**
     * Method setTexto
     * 
     * @param index
     * @param vTexto
     */
    public void setTexto(int index, java.lang.String vTexto)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _textoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _textoList.setElementAt(vTexto, index);
    } //-- void setTexto(int, java.lang.String) 

    /**
     * Method setTexto
     * 
     * @param textoArray
     */
    public void setTexto(java.lang.String[] textoArray)
    {
        //-- copy array
        _textoList.removeAllElements();
        for (int i = 0; i < textoArray.length; i++) {
            _textoList.addElement(textoArray[i]);
        }
    } //-- void setTexto(java.lang.String) 

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
