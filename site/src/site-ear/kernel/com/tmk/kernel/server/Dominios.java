/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.server;

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
 * Class Dominios.
 * 
 * @version $Revision$ $Date$
 */
public class Dominios implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _principal
     */
    private java.lang.String _principal;

    /**
     * Field _secundarioList
     */
    private java.util.Vector _secundarioList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Dominios() {
        super();
        _secundarioList = new Vector();
    } //-- com.tmk.kernel.server.Dominios()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addSecundario
     * 
     * @param vSecundario
     */
    public void addSecundario(java.lang.String vSecundario)
        throws java.lang.IndexOutOfBoundsException
    {
        _secundarioList.addElement(vSecundario);
    } //-- void addSecundario(java.lang.String) 

    /**
     * Method addSecundario
     * 
     * @param index
     * @param vSecundario
     */
    public void addSecundario(int index, java.lang.String vSecundario)
        throws java.lang.IndexOutOfBoundsException
    {
        _secundarioList.insertElementAt(vSecundario, index);
    } //-- void addSecundario(int, java.lang.String) 

    /**
     * Method enumerateSecundario
     */
    public java.util.Enumeration enumerateSecundario()
    {
        return _secundarioList.elements();
    } //-- java.util.Enumeration enumerateSecundario() 

    /**
     * Returns the value of field 'principal'.
     * 
     * @return the value of field 'principal'.
     */
    public java.lang.String getPrincipal()
    {
        return this._principal;
    } //-- java.lang.String getPrincipal() 

    /**
     * Method getSecundario
     * 
     * @param index
     */
    public java.lang.String getSecundario(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _secundarioList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_secundarioList.elementAt(index);
    } //-- java.lang.String getSecundario(int) 

    /**
     * Method getSecundario
     */
    public java.lang.String[] getSecundario()
    {
        int size = _secundarioList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_secundarioList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getSecundario() 

    /**
     * Method getSecundarioCount
     */
    public int getSecundarioCount()
    {
        return _secundarioList.size();
    } //-- int getSecundarioCount() 

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
     * Method removeAllSecundario
     */
    public void removeAllSecundario()
    {
        _secundarioList.removeAllElements();
    } //-- void removeAllSecundario() 

    /**
     * Method removeSecundario
     * 
     * @param index
     */
    public java.lang.String removeSecundario(int index)
    {
        java.lang.Object obj = _secundarioList.elementAt(index);
        _secundarioList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeSecundario(int) 

    /**
     * Sets the value of field 'principal'.
     * 
     * @param principal the value of field 'principal'.
     */
    public void setPrincipal(java.lang.String principal)
    {
        this._principal = principal;
    } //-- void setPrincipal(java.lang.String) 

    /**
     * Method setSecundario
     * 
     * @param index
     * @param vSecundario
     */
    public void setSecundario(int index, java.lang.String vSecundario)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _secundarioList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _secundarioList.setElementAt(vSecundario, index);
    } //-- void setSecundario(int, java.lang.String) 

    /**
     * Method setSecundario
     * 
     * @param secundarioArray
     */
    public void setSecundario(java.lang.String[] secundarioArray)
    {
        //-- copy array
        _secundarioList.removeAllElements();
        for (int i = 0; i < secundarioArray.length; i++) {
            _secundarioList.addElement(secundarioArray[i]);
        }
    } //-- void setSecundario(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Dominios unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Dominios) Unmarshaller.unmarshal(com.tmk.kernel.server.Dominios.class, reader);
    } //-- com.tmk.kernel.server.Dominios unmarshal(java.io.Reader) 

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
