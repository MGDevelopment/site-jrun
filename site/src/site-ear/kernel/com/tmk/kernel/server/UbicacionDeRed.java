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
 * Class UbicacionDeRed.
 * 
 * @version $Revision$ $Date$
 */
public class UbicacionDeRed implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _ubicacionList
     */
    private java.util.Vector _ubicacionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public UbicacionDeRed() {
        super();
        _ubicacionList = new Vector();
    } //-- com.tmk.kernel.server.UbicacionDeRed()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addUbicacion
     * 
     * @param vUbicacion
     */
    public void addUbicacion(com.tmk.kernel.server.Ubicacion vUbicacion)
        throws java.lang.IndexOutOfBoundsException
    {
        _ubicacionList.addElement(vUbicacion);
    } //-- void addUbicacion(com.tmk.kernel.server.Ubicacion) 

    /**
     * Method addUbicacion
     * 
     * @param index
     * @param vUbicacion
     */
    public void addUbicacion(int index, com.tmk.kernel.server.Ubicacion vUbicacion)
        throws java.lang.IndexOutOfBoundsException
    {
        _ubicacionList.insertElementAt(vUbicacion, index);
    } //-- void addUbicacion(int, com.tmk.kernel.server.Ubicacion) 

    /**
     * Method enumerateUbicacion
     */
    public java.util.Enumeration enumerateUbicacion()
    {
        return _ubicacionList.elements();
    } //-- java.util.Enumeration enumerateUbicacion() 

    /**
     * Method getUbicacion
     * 
     * @param index
     */
    public com.tmk.kernel.server.Ubicacion getUbicacion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ubicacionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.server.Ubicacion) _ubicacionList.elementAt(index);
    } //-- com.tmk.kernel.server.Ubicacion getUbicacion(int) 

    /**
     * Method getUbicacion
     */
    public com.tmk.kernel.server.Ubicacion[] getUbicacion()
    {
        int size = _ubicacionList.size();
        com.tmk.kernel.server.Ubicacion[] mArray = new com.tmk.kernel.server.Ubicacion[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.server.Ubicacion) _ubicacionList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.server.Ubicacion[] getUbicacion() 

    /**
     * Method getUbicacionCount
     */
    public int getUbicacionCount()
    {
        return _ubicacionList.size();
    } //-- int getUbicacionCount() 

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
     * Method removeAllUbicacion
     */
    public void removeAllUbicacion()
    {
        _ubicacionList.removeAllElements();
    } //-- void removeAllUbicacion() 

    /**
     * Method removeUbicacion
     * 
     * @param index
     */
    public com.tmk.kernel.server.Ubicacion removeUbicacion(int index)
    {
        java.lang.Object obj = _ubicacionList.elementAt(index);
        _ubicacionList.removeElementAt(index);
        return (com.tmk.kernel.server.Ubicacion) obj;
    } //-- com.tmk.kernel.server.Ubicacion removeUbicacion(int) 

    /**
     * Method setUbicacion
     * 
     * @param index
     * @param vUbicacion
     */
    public void setUbicacion(int index, com.tmk.kernel.server.Ubicacion vUbicacion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _ubicacionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _ubicacionList.setElementAt(vUbicacion, index);
    } //-- void setUbicacion(int, com.tmk.kernel.server.Ubicacion) 

    /**
     * Method setUbicacion
     * 
     * @param ubicacionArray
     */
    public void setUbicacion(com.tmk.kernel.server.Ubicacion[] ubicacionArray)
    {
        //-- copy array
        _ubicacionList.removeAllElements();
        for (int i = 0; i < ubicacionArray.length; i++) {
            _ubicacionList.addElement(ubicacionArray[i]);
        }
    } //-- void setUbicacion(com.tmk.kernel.server.Ubicacion) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.UbicacionDeRed unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.UbicacionDeRed) Unmarshaller.unmarshal(com.tmk.kernel.server.UbicacionDeRed.class, reader);
    } //-- com.tmk.kernel.server.UbicacionDeRed unmarshal(java.io.Reader) 

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
