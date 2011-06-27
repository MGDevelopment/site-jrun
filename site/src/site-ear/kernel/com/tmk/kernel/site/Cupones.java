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
 * Class Cupones.
 * 
 * @version $Revision$ $Date$
 */
public class Cupones implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _registro
     */
    private com.tmk.kernel.site.Registro _registro;

    /**
     * Field _referido
     */
    private com.tmk.kernel.site.Referido _referido;

    /**
     * Field _referenteList
     */
    private java.util.Vector _referenteList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Cupones() {
        super();
        _referenteList = new Vector();
    } //-- com.tmk.kernel.site.Cupones()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addReferente
     * 
     * @param vReferente
     */
    public void addReferente(com.tmk.kernel.site.Referente vReferente)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenteList.addElement(vReferente);
    } //-- void addReferente(com.tmk.kernel.site.Referente) 

    /**
     * Method addReferente
     * 
     * @param index
     * @param vReferente
     */
    public void addReferente(int index, com.tmk.kernel.site.Referente vReferente)
        throws java.lang.IndexOutOfBoundsException
    {
        _referenteList.insertElementAt(vReferente, index);
    } //-- void addReferente(int, com.tmk.kernel.site.Referente) 

    /**
     * Method enumerateReferente
     */
    public java.util.Enumeration enumerateReferente()
    {
        return _referenteList.elements();
    } //-- java.util.Enumeration enumerateReferente() 

    /**
     * Method getReferente
     * 
     * @param index
     */
    public com.tmk.kernel.site.Referente getReferente(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _referenteList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Referente) _referenteList.elementAt(index);
    } //-- com.tmk.kernel.site.Referente getReferente(int) 

    /**
     * Method getReferente
     */
    public com.tmk.kernel.site.Referente[] getReferente()
    {
        int size = _referenteList.size();
        com.tmk.kernel.site.Referente[] mArray = new com.tmk.kernel.site.Referente[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Referente) _referenteList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Referente[] getReferente() 

    /**
     * Method getReferenteCount
     */
    public int getReferenteCount()
    {
        return _referenteList.size();
    } //-- int getReferenteCount() 

    /**
     * Returns the value of field 'referido'.
     * 
     * @return the value of field 'referido'.
     */
    public com.tmk.kernel.site.Referido getReferido()
    {
        return this._referido;
    } //-- com.tmk.kernel.site.Referido getReferido() 

    /**
     * Returns the value of field 'registro'.
     * 
     * @return the value of field 'registro'.
     */
    public com.tmk.kernel.site.Registro getRegistro()
    {
        return this._registro;
    } //-- com.tmk.kernel.site.Registro getRegistro() 

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
     * Method removeAllReferente
     */
    public void removeAllReferente()
    {
        _referenteList.removeAllElements();
    } //-- void removeAllReferente() 

    /**
     * Method removeReferente
     * 
     * @param index
     */
    public com.tmk.kernel.site.Referente removeReferente(int index)
    {
        java.lang.Object obj = _referenteList.elementAt(index);
        _referenteList.removeElementAt(index);
        return (com.tmk.kernel.site.Referente) obj;
    } //-- com.tmk.kernel.site.Referente removeReferente(int) 

    /**
     * Method setReferente
     * 
     * @param index
     * @param vReferente
     */
    public void setReferente(int index, com.tmk.kernel.site.Referente vReferente)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _referenteList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _referenteList.setElementAt(vReferente, index);
    } //-- void setReferente(int, com.tmk.kernel.site.Referente) 

    /**
     * Method setReferente
     * 
     * @param referenteArray
     */
    public void setReferente(com.tmk.kernel.site.Referente[] referenteArray)
    {
        //-- copy array
        _referenteList.removeAllElements();
        for (int i = 0; i < referenteArray.length; i++) {
            _referenteList.addElement(referenteArray[i]);
        }
    } //-- void setReferente(com.tmk.kernel.site.Referente) 

    /**
     * Sets the value of field 'referido'.
     * 
     * @param referido the value of field 'referido'.
     */
    public void setReferido(com.tmk.kernel.site.Referido referido)
    {
        this._referido = referido;
    } //-- void setReferido(com.tmk.kernel.site.Referido) 

    /**
     * Sets the value of field 'registro'.
     * 
     * @param registro the value of field 'registro'.
     */
    public void setRegistro(com.tmk.kernel.site.Registro registro)
    {
        this._registro = registro;
    } //-- void setRegistro(com.tmk.kernel.site.Registro) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Cupones unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Cupones) Unmarshaller.unmarshal(com.tmk.kernel.site.Cupones.class, reader);
    } //-- com.tmk.kernel.site.Cupones unmarshal(java.io.Reader) 

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
