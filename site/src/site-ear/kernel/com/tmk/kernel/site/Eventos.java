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
 * Class Eventos.
 * 
 * @version $Revision$ $Date$
 */
public class Eventos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _eventoList
     */
    private java.util.Vector _eventoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Eventos() {
        super();
        _eventoList = new Vector();
    } //-- com.tmk.kernel.site.Eventos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addEvento
     * 
     * @param vEvento
     */
    public void addEvento(com.tmk.kernel.site.Evento vEvento)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventoList.addElement(vEvento);
    } //-- void addEvento(com.tmk.kernel.site.Evento) 

    /**
     * Method addEvento
     * 
     * @param index
     * @param vEvento
     */
    public void addEvento(int index, com.tmk.kernel.site.Evento vEvento)
        throws java.lang.IndexOutOfBoundsException
    {
        _eventoList.insertElementAt(vEvento, index);
    } //-- void addEvento(int, com.tmk.kernel.site.Evento) 

    /**
     * Method enumerateEvento
     */
    public java.util.Enumeration enumerateEvento()
    {
        return _eventoList.elements();
    } //-- java.util.Enumeration enumerateEvento() 

    /**
     * Method getEvento
     * 
     * @param index
     */
    public com.tmk.kernel.site.Evento getEvento(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Evento) _eventoList.elementAt(index);
    } //-- com.tmk.kernel.site.Evento getEvento(int) 

    /**
     * Method getEvento
     */
    public com.tmk.kernel.site.Evento[] getEvento()
    {
        int size = _eventoList.size();
        com.tmk.kernel.site.Evento[] mArray = new com.tmk.kernel.site.Evento[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Evento) _eventoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Evento[] getEvento() 

    /**
     * Method getEventoCount
     */
    public int getEventoCount()
    {
        return _eventoList.size();
    } //-- int getEventoCount() 

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
     * Method removeAllEvento
     */
    public void removeAllEvento()
    {
        _eventoList.removeAllElements();
    } //-- void removeAllEvento() 

    /**
     * Method removeEvento
     * 
     * @param index
     */
    public com.tmk.kernel.site.Evento removeEvento(int index)
    {
        java.lang.Object obj = _eventoList.elementAt(index);
        _eventoList.removeElementAt(index);
        return (com.tmk.kernel.site.Evento) obj;
    } //-- com.tmk.kernel.site.Evento removeEvento(int) 

    /**
     * Method setEvento
     * 
     * @param index
     * @param vEvento
     */
    public void setEvento(int index, com.tmk.kernel.site.Evento vEvento)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _eventoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _eventoList.setElementAt(vEvento, index);
    } //-- void setEvento(int, com.tmk.kernel.site.Evento) 

    /**
     * Method setEvento
     * 
     * @param eventoArray
     */
    public void setEvento(com.tmk.kernel.site.Evento[] eventoArray)
    {
        //-- copy array
        _eventoList.removeAllElements();
        for (int i = 0; i < eventoArray.length; i++) {
            _eventoList.addElement(eventoArray[i]);
        }
    } //-- void setEvento(com.tmk.kernel.site.Evento) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Eventos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Eventos) Unmarshaller.unmarshal(com.tmk.kernel.site.Eventos.class, reader);
    } //-- com.tmk.kernel.site.Eventos unmarshal(java.io.Reader) 

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
