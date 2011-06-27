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
 * Class Errores.
 * 
 * @version $Revision$ $Date$
 */
public class Errores implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mensajePorDefecto
     */
    private java.lang.String _mensajePorDefecto;

    /**
     * Field _errorList
     */
    private java.util.Vector _errorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Errores() {
        super();
        _errorList = new Vector();
    } //-- com.tmk.kernel.server.Errores()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addError
     * 
     * @param vError
     */
    public void addError(com.tmk.kernel.server.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        _errorList.addElement(vError);
    } //-- void addError(com.tmk.kernel.server.Error) 

    /**
     * Method addError
     * 
     * @param index
     * @param vError
     */
    public void addError(int index, com.tmk.kernel.server.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        _errorList.insertElementAt(vError, index);
    } //-- void addError(int, com.tmk.kernel.server.Error) 

    /**
     * Method enumerateError
     */
    public java.util.Enumeration enumerateError()
    {
        return _errorList.elements();
    } //-- java.util.Enumeration enumerateError() 

    /**
     * Method getError
     * 
     * @param index
     */
    public com.tmk.kernel.server.Error getError(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _errorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.server.Error) _errorList.elementAt(index);
    } //-- com.tmk.kernel.server.Error getError(int) 

    /**
     * Method getError
     */
    public com.tmk.kernel.server.Error[] getError()
    {
        int size = _errorList.size();
        com.tmk.kernel.server.Error[] mArray = new com.tmk.kernel.server.Error[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.server.Error) _errorList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.server.Error[] getError() 

    /**
     * Method getErrorCount
     */
    public int getErrorCount()
    {
        return _errorList.size();
    } //-- int getErrorCount() 

    /**
     * Returns the value of field 'mensajePorDefecto'.
     * 
     * @return the value of field 'mensajePorDefecto'.
     */
    public java.lang.String getMensajePorDefecto()
    {
        return this._mensajePorDefecto;
    } //-- java.lang.String getMensajePorDefecto() 

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
     * Method removeAllError
     */
    public void removeAllError()
    {
        _errorList.removeAllElements();
    } //-- void removeAllError() 

    /**
     * Method removeError
     * 
     * @param index
     */
    public com.tmk.kernel.server.Error removeError(int index)
    {
        java.lang.Object obj = _errorList.elementAt(index);
        _errorList.removeElementAt(index);
        return (com.tmk.kernel.server.Error) obj;
    } //-- com.tmk.kernel.server.Error removeError(int) 

    /**
     * Method setError
     * 
     * @param index
     * @param vError
     */
    public void setError(int index, com.tmk.kernel.server.Error vError)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _errorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _errorList.setElementAt(vError, index);
    } //-- void setError(int, com.tmk.kernel.server.Error) 

    /**
     * Method setError
     * 
     * @param errorArray
     */
    public void setError(com.tmk.kernel.server.Error[] errorArray)
    {
        //-- copy array
        _errorList.removeAllElements();
        for (int i = 0; i < errorArray.length; i++) {
            _errorList.addElement(errorArray[i]);
        }
    } //-- void setError(com.tmk.kernel.server.Error) 

    /**
     * Sets the value of field 'mensajePorDefecto'.
     * 
     * @param mensajePorDefecto the value of field
     * 'mensajePorDefecto'.
     */
    public void setMensajePorDefecto(java.lang.String mensajePorDefecto)
    {
        this._mensajePorDefecto = mensajePorDefecto;
    } //-- void setMensajePorDefecto(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Errores unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Errores) Unmarshaller.unmarshal(com.tmk.kernel.server.Errores.class, reader);
    } //-- com.tmk.kernel.server.Errores unmarshal(java.io.Reader) 

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
