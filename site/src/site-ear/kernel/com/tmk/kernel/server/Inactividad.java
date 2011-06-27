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
 * Class Inactividad.
 * 
 * @version $Revision$ $Date$
 */
public class Inactividad implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mensajeMantenimiento
     */
    private java.lang.String _mensajeMantenimiento;

    /**
     * Field _mensajePrevio
     */
    private java.lang.String _mensajePrevio;

    /**
     * Field _minutosDeAnticipacion
     */
    private int _minutosDeAnticipacion;

    /**
     * keeps track of state for field: _minutosDeAnticipacion
     */
    private boolean _has_minutosDeAnticipacion;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public Inactividad() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.server.Inactividad()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addInactividadItem
     * 
     * @param vInactividadItem
     */
    public void addInactividadItem(com.tmk.kernel.server.InactividadItem vInactividadItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vInactividadItem);
    } //-- void addInactividadItem(com.tmk.kernel.server.InactividadItem) 

    /**
     * Method addInactividadItem
     * 
     * @param index
     * @param vInactividadItem
     */
    public void addInactividadItem(int index, com.tmk.kernel.server.InactividadItem vInactividadItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vInactividadItem, index);
    } //-- void addInactividadItem(int, com.tmk.kernel.server.InactividadItem) 

    /**
     * Method enumerateInactividadItem
     */
    public java.util.Enumeration enumerateInactividadItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateInactividadItem() 

    /**
     * Method getInactividadItem
     * 
     * @param index
     */
    public com.tmk.kernel.server.InactividadItem getInactividadItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.server.InactividadItem) _items.elementAt(index);
    } //-- com.tmk.kernel.server.InactividadItem getInactividadItem(int) 

    /**
     * Method getInactividadItem
     */
    public com.tmk.kernel.server.InactividadItem[] getInactividadItem()
    {
        int size = _items.size();
        com.tmk.kernel.server.InactividadItem[] mArray = new com.tmk.kernel.server.InactividadItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.server.InactividadItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.server.InactividadItem[] getInactividadItem() 

    /**
     * Method getInactividadItemCount
     */
    public int getInactividadItemCount()
    {
        return _items.size();
    } //-- int getInactividadItemCount() 

    /**
     * Returns the value of field 'mensajeMantenimiento'.
     * 
     * @return the value of field 'mensajeMantenimiento'.
     */
    public java.lang.String getMensajeMantenimiento()
    {
        return this._mensajeMantenimiento;
    } //-- java.lang.String getMensajeMantenimiento() 

    /**
     * Returns the value of field 'mensajePrevio'.
     * 
     * @return the value of field 'mensajePrevio'.
     */
    public java.lang.String getMensajePrevio()
    {
        return this._mensajePrevio;
    } //-- java.lang.String getMensajePrevio() 

    /**
     * Returns the value of field 'minutosDeAnticipacion'.
     * 
     * @return the value of field 'minutosDeAnticipacion'.
     */
    public int getMinutosDeAnticipacion()
    {
        return this._minutosDeAnticipacion;
    } //-- int getMinutosDeAnticipacion() 

    /**
     * Method hasMinutosDeAnticipacion
     */
    public boolean hasMinutosDeAnticipacion()
    {
        return this._has_minutosDeAnticipacion;
    } //-- boolean hasMinutosDeAnticipacion() 

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
     * Method removeAllInactividadItem
     */
    public void removeAllInactividadItem()
    {
        _items.removeAllElements();
    } //-- void removeAllInactividadItem() 

    /**
     * Method removeInactividadItem
     * 
     * @param index
     */
    public com.tmk.kernel.server.InactividadItem removeInactividadItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.server.InactividadItem) obj;
    } //-- com.tmk.kernel.server.InactividadItem removeInactividadItem(int) 

    /**
     * Method setInactividadItem
     * 
     * @param index
     * @param vInactividadItem
     */
    public void setInactividadItem(int index, com.tmk.kernel.server.InactividadItem vInactividadItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vInactividadItem, index);
    } //-- void setInactividadItem(int, com.tmk.kernel.server.InactividadItem) 

    /**
     * Method setInactividadItem
     * 
     * @param inactividadItemArray
     */
    public void setInactividadItem(com.tmk.kernel.server.InactividadItem[] inactividadItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < inactividadItemArray.length; i++) {
            _items.addElement(inactividadItemArray[i]);
        }
    } //-- void setInactividadItem(com.tmk.kernel.server.InactividadItem) 

    /**
     * Sets the value of field 'mensajeMantenimiento'.
     * 
     * @param mensajeMantenimiento the value of field
     * 'mensajeMantenimiento'.
     */
    public void setMensajeMantenimiento(java.lang.String mensajeMantenimiento)
    {
        this._mensajeMantenimiento = mensajeMantenimiento;
    } //-- void setMensajeMantenimiento(java.lang.String) 

    /**
     * Sets the value of field 'mensajePrevio'.
     * 
     * @param mensajePrevio the value of field 'mensajePrevio'.
     */
    public void setMensajePrevio(java.lang.String mensajePrevio)
    {
        this._mensajePrevio = mensajePrevio;
    } //-- void setMensajePrevio(java.lang.String) 

    /**
     * Sets the value of field 'minutosDeAnticipacion'.
     * 
     * @param minutosDeAnticipacion the value of field
     * 'minutosDeAnticipacion'.
     */
    public void setMinutosDeAnticipacion(int minutosDeAnticipacion)
    {
        this._minutosDeAnticipacion = minutosDeAnticipacion;
        this._has_minutosDeAnticipacion = true;
    } //-- void setMinutosDeAnticipacion(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Inactividad unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Inactividad) Unmarshaller.unmarshal(com.tmk.kernel.server.Inactividad.class, reader);
    } //-- com.tmk.kernel.server.Inactividad unmarshal(java.io.Reader) 

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
