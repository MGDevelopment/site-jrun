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
 * Class RecorridoSecciones.
 * 
 * @version $Revision$ $Date$
 */
public class RecorridoSecciones implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _claves
     */
    private com.tmk.kernel.site.Claves _claves;

    /**
     * Field _recorridoSeccionList
     */
    private java.util.Vector _recorridoSeccionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RecorridoSecciones() {
        super();
        _recorridoSeccionList = new Vector();
    } //-- com.tmk.kernel.site.RecorridoSecciones()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRecorridoSeccion
     * 
     * @param vRecorridoSeccion
     */
    public void addRecorridoSeccion(com.tmk.kernel.site.RecorridoSeccion vRecorridoSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoSeccionList.addElement(vRecorridoSeccion);
    } //-- void addRecorridoSeccion(com.tmk.kernel.site.RecorridoSeccion) 

    /**
     * Method addRecorridoSeccion
     * 
     * @param index
     * @param vRecorridoSeccion
     */
    public void addRecorridoSeccion(int index, com.tmk.kernel.site.RecorridoSeccion vRecorridoSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoSeccionList.insertElementAt(vRecorridoSeccion, index);
    } //-- void addRecorridoSeccion(int, com.tmk.kernel.site.RecorridoSeccion) 

    /**
     * Method enumerateRecorridoSeccion
     */
    public java.util.Enumeration enumerateRecorridoSeccion()
    {
        return _recorridoSeccionList.elements();
    } //-- java.util.Enumeration enumerateRecorridoSeccion() 

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
     * Method getRecorridoSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoSeccion getRecorridoSeccion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.RecorridoSeccion) _recorridoSeccionList.elementAt(index);
    } //-- com.tmk.kernel.site.RecorridoSeccion getRecorridoSeccion(int) 

    /**
     * Method getRecorridoSeccion
     */
    public com.tmk.kernel.site.RecorridoSeccion[] getRecorridoSeccion()
    {
        int size = _recorridoSeccionList.size();
        com.tmk.kernel.site.RecorridoSeccion[] mArray = new com.tmk.kernel.site.RecorridoSeccion[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.RecorridoSeccion) _recorridoSeccionList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.RecorridoSeccion[] getRecorridoSeccion() 

    /**
     * Method getRecorridoSeccionCount
     */
    public int getRecorridoSeccionCount()
    {
        return _recorridoSeccionList.size();
    } //-- int getRecorridoSeccionCount() 

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
     * Method removeAllRecorridoSeccion
     */
    public void removeAllRecorridoSeccion()
    {
        _recorridoSeccionList.removeAllElements();
    } //-- void removeAllRecorridoSeccion() 

    /**
     * Method removeRecorridoSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoSeccion removeRecorridoSeccion(int index)
    {
        java.lang.Object obj = _recorridoSeccionList.elementAt(index);
        _recorridoSeccionList.removeElementAt(index);
        return (com.tmk.kernel.site.RecorridoSeccion) obj;
    } //-- com.tmk.kernel.site.RecorridoSeccion removeRecorridoSeccion(int) 

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
     * Method setRecorridoSeccion
     * 
     * @param index
     * @param vRecorridoSeccion
     */
    public void setRecorridoSeccion(int index, com.tmk.kernel.site.RecorridoSeccion vRecorridoSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _recorridoSeccionList.setElementAt(vRecorridoSeccion, index);
    } //-- void setRecorridoSeccion(int, com.tmk.kernel.site.RecorridoSeccion) 

    /**
     * Method setRecorridoSeccion
     * 
     * @param recorridoSeccionArray
     */
    public void setRecorridoSeccion(com.tmk.kernel.site.RecorridoSeccion[] recorridoSeccionArray)
    {
        //-- copy array
        _recorridoSeccionList.removeAllElements();
        for (int i = 0; i < recorridoSeccionArray.length; i++) {
            _recorridoSeccionList.addElement(recorridoSeccionArray[i]);
        }
    } //-- void setRecorridoSeccion(com.tmk.kernel.site.RecorridoSeccion) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RecorridoSecciones unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RecorridoSecciones) Unmarshaller.unmarshal(com.tmk.kernel.site.RecorridoSecciones.class, reader);
    } //-- com.tmk.kernel.site.RecorridoSecciones unmarshal(java.io.Reader) 

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
