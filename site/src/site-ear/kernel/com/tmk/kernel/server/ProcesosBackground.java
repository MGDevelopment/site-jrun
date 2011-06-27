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
 * Class ProcesosBackground.
 * 
 * @version $Revision$ $Date$
 */
public class ProcesosBackground implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _procesoList
     */
    private java.util.Vector _procesoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProcesosBackground() {
        super();
        _procesoList = new Vector();
    } //-- com.tmk.kernel.server.ProcesosBackground()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addProceso
     * 
     * @param vProceso
     */
    public void addProceso(com.tmk.kernel.server.Proceso vProceso)
        throws java.lang.IndexOutOfBoundsException
    {
        _procesoList.addElement(vProceso);
    } //-- void addProceso(com.tmk.kernel.server.Proceso) 

    /**
     * Method addProceso
     * 
     * @param index
     * @param vProceso
     */
    public void addProceso(int index, com.tmk.kernel.server.Proceso vProceso)
        throws java.lang.IndexOutOfBoundsException
    {
        _procesoList.insertElementAt(vProceso, index);
    } //-- void addProceso(int, com.tmk.kernel.server.Proceso) 

    /**
     * Method enumerateProceso
     */
    public java.util.Enumeration enumerateProceso()
    {
        return _procesoList.elements();
    } //-- java.util.Enumeration enumerateProceso() 

    /**
     * Method getProceso
     * 
     * @param index
     */
    public com.tmk.kernel.server.Proceso getProceso(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _procesoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.server.Proceso) _procesoList.elementAt(index);
    } //-- com.tmk.kernel.server.Proceso getProceso(int) 

    /**
     * Method getProceso
     */
    public com.tmk.kernel.server.Proceso[] getProceso()
    {
        int size = _procesoList.size();
        com.tmk.kernel.server.Proceso[] mArray = new com.tmk.kernel.server.Proceso[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.server.Proceso) _procesoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.server.Proceso[] getProceso() 

    /**
     * Method getProcesoCount
     */
    public int getProcesoCount()
    {
        return _procesoList.size();
    } //-- int getProcesoCount() 

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
     * Method removeAllProceso
     */
    public void removeAllProceso()
    {
        _procesoList.removeAllElements();
    } //-- void removeAllProceso() 

    /**
     * Method removeProceso
     * 
     * @param index
     */
    public com.tmk.kernel.server.Proceso removeProceso(int index)
    {
        java.lang.Object obj = _procesoList.elementAt(index);
        _procesoList.removeElementAt(index);
        return (com.tmk.kernel.server.Proceso) obj;
    } //-- com.tmk.kernel.server.Proceso removeProceso(int) 

    /**
     * Method setProceso
     * 
     * @param index
     * @param vProceso
     */
    public void setProceso(int index, com.tmk.kernel.server.Proceso vProceso)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _procesoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _procesoList.setElementAt(vProceso, index);
    } //-- void setProceso(int, com.tmk.kernel.server.Proceso) 

    /**
     * Method setProceso
     * 
     * @param procesoArray
     */
    public void setProceso(com.tmk.kernel.server.Proceso[] procesoArray)
    {
        //-- copy array
        _procesoList.removeAllElements();
        for (int i = 0; i < procesoArray.length; i++) {
            _procesoList.addElement(procesoArray[i]);
        }
    } //-- void setProceso(com.tmk.kernel.server.Proceso) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.ProcesosBackground unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.ProcesosBackground) Unmarshaller.unmarshal(com.tmk.kernel.server.ProcesosBackground.class, reader);
    } //-- com.tmk.kernel.server.ProcesosBackground unmarshal(java.io.Reader) 

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
