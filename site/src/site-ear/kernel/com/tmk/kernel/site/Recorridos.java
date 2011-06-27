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
 * Class Recorridos.
 * 
 * @version $Revision$ $Date$
 */
public class Recorridos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _recorridoList
     */
    private java.util.Vector _recorridoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Recorridos() {
        super();
        _recorridoList = new Vector();
    } //-- com.tmk.kernel.site.Recorridos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRecorrido
     * 
     * @param vRecorrido
     */
    public void addRecorrido(com.tmk.kernel.site.Recorrido vRecorrido)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoList.addElement(vRecorrido);
    } //-- void addRecorrido(com.tmk.kernel.site.Recorrido) 

    /**
     * Method addRecorrido
     * 
     * @param index
     * @param vRecorrido
     */
    public void addRecorrido(int index, com.tmk.kernel.site.Recorrido vRecorrido)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoList.insertElementAt(vRecorrido, index);
    } //-- void addRecorrido(int, com.tmk.kernel.site.Recorrido) 

    /**
     * Method enumerateRecorrido
     */
    public java.util.Enumeration enumerateRecorrido()
    {
        return _recorridoList.elements();
    } //-- java.util.Enumeration enumerateRecorrido() 

    /**
     * Method getRecorrido
     * 
     * @param index
     */
    public com.tmk.kernel.site.Recorrido getRecorrido(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Recorrido) _recorridoList.elementAt(index);
    } //-- com.tmk.kernel.site.Recorrido getRecorrido(int) 

    /**
     * Method getRecorrido
     */
    public com.tmk.kernel.site.Recorrido[] getRecorrido()
    {
        int size = _recorridoList.size();
        com.tmk.kernel.site.Recorrido[] mArray = new com.tmk.kernel.site.Recorrido[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Recorrido) _recorridoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Recorrido[] getRecorrido() 

    /**
     * Method getRecorridoCount
     */
    public int getRecorridoCount()
    {
        return _recorridoList.size();
    } //-- int getRecorridoCount() 

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
     * Method removeAllRecorrido
     */
    public void removeAllRecorrido()
    {
        _recorridoList.removeAllElements();
    } //-- void removeAllRecorrido() 

    /**
     * Method removeRecorrido
     * 
     * @param index
     */
    public com.tmk.kernel.site.Recorrido removeRecorrido(int index)
    {
        java.lang.Object obj = _recorridoList.elementAt(index);
        _recorridoList.removeElementAt(index);
        return (com.tmk.kernel.site.Recorrido) obj;
    } //-- com.tmk.kernel.site.Recorrido removeRecorrido(int) 

    /**
     * Method setRecorrido
     * 
     * @param index
     * @param vRecorrido
     */
    public void setRecorrido(int index, com.tmk.kernel.site.Recorrido vRecorrido)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _recorridoList.setElementAt(vRecorrido, index);
    } //-- void setRecorrido(int, com.tmk.kernel.site.Recorrido) 

    /**
     * Method setRecorrido
     * 
     * @param recorridoArray
     */
    public void setRecorrido(com.tmk.kernel.site.Recorrido[] recorridoArray)
    {
        //-- copy array
        _recorridoList.removeAllElements();
        for (int i = 0; i < recorridoArray.length; i++) {
            _recorridoList.addElement(recorridoArray[i]);
        }
    } //-- void setRecorrido(com.tmk.kernel.site.Recorrido) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Recorridos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Recorridos) Unmarshaller.unmarshal(com.tmk.kernel.site.Recorridos.class, reader);
    } //-- com.tmk.kernel.site.Recorridos unmarshal(java.io.Reader) 

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
