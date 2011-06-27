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
 * Class Procesos.
 * 
 * @version $Revision$ $Date$
 */
public class Procesos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _runProList
     */
    private java.util.Vector _runProList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Procesos() {
        super();
        _runProList = new Vector();
    } //-- com.tmk.kernel.server.Procesos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRunPro
     * 
     * @param vRunPro
     */
    public void addRunPro(com.tmk.kernel.server.RunPro vRunPro)
        throws java.lang.IndexOutOfBoundsException
    {
        _runProList.addElement(vRunPro);
    } //-- void addRunPro(com.tmk.kernel.server.RunPro) 

    /**
     * Method addRunPro
     * 
     * @param index
     * @param vRunPro
     */
    public void addRunPro(int index, com.tmk.kernel.server.RunPro vRunPro)
        throws java.lang.IndexOutOfBoundsException
    {
        _runProList.insertElementAt(vRunPro, index);
    } //-- void addRunPro(int, com.tmk.kernel.server.RunPro) 

    /**
     * Method enumerateRunPro
     */
    public java.util.Enumeration enumerateRunPro()
    {
        return _runProList.elements();
    } //-- java.util.Enumeration enumerateRunPro() 

    /**
     * Method getRunPro
     * 
     * @param index
     */
    public com.tmk.kernel.server.RunPro getRunPro(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _runProList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.server.RunPro) _runProList.elementAt(index);
    } //-- com.tmk.kernel.server.RunPro getRunPro(int) 

    /**
     * Method getRunPro
     */
    public com.tmk.kernel.server.RunPro[] getRunPro()
    {
        int size = _runProList.size();
        com.tmk.kernel.server.RunPro[] mArray = new com.tmk.kernel.server.RunPro[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.server.RunPro) _runProList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.server.RunPro[] getRunPro() 

    /**
     * Method getRunProCount
     */
    public int getRunProCount()
    {
        return _runProList.size();
    } //-- int getRunProCount() 

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
     * Method removeAllRunPro
     */
    public void removeAllRunPro()
    {
        _runProList.removeAllElements();
    } //-- void removeAllRunPro() 

    /**
     * Method removeRunPro
     * 
     * @param index
     */
    public com.tmk.kernel.server.RunPro removeRunPro(int index)
    {
        java.lang.Object obj = _runProList.elementAt(index);
        _runProList.removeElementAt(index);
        return (com.tmk.kernel.server.RunPro) obj;
    } //-- com.tmk.kernel.server.RunPro removeRunPro(int) 

    /**
     * Method setRunPro
     * 
     * @param index
     * @param vRunPro
     */
    public void setRunPro(int index, com.tmk.kernel.server.RunPro vRunPro)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _runProList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _runProList.setElementAt(vRunPro, index);
    } //-- void setRunPro(int, com.tmk.kernel.server.RunPro) 

    /**
     * Method setRunPro
     * 
     * @param runProArray
     */
    public void setRunPro(com.tmk.kernel.server.RunPro[] runProArray)
    {
        //-- copy array
        _runProList.removeAllElements();
        for (int i = 0; i < runProArray.length; i++) {
            _runProList.addElement(runProArray[i]);
        }
    } //-- void setRunPro(com.tmk.kernel.server.RunPro) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Procesos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Procesos) Unmarshaller.unmarshal(com.tmk.kernel.server.Procesos.class, reader);
    } //-- com.tmk.kernel.server.Procesos unmarshal(java.io.Reader) 

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
