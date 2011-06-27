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
 * Class RecorridoFamilias.
 * 
 * @version $Revision$ $Date$
 */
public class RecorridoFamilias implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _claves
     */
    private com.tmk.kernel.site.Claves _claves;

    /**
     * Field _recorridoFamiliaList
     */
    private java.util.Vector _recorridoFamiliaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RecorridoFamilias() {
        super();
        _recorridoFamiliaList = new Vector();
    } //-- com.tmk.kernel.site.RecorridoFamilias()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRecorridoFamilia
     * 
     * @param vRecorridoFamilia
     */
    public void addRecorridoFamilia(com.tmk.kernel.site.RecorridoFamilia vRecorridoFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoFamiliaList.addElement(vRecorridoFamilia);
    } //-- void addRecorridoFamilia(com.tmk.kernel.site.RecorridoFamilia) 

    /**
     * Method addRecorridoFamilia
     * 
     * @param index
     * @param vRecorridoFamilia
     */
    public void addRecorridoFamilia(int index, com.tmk.kernel.site.RecorridoFamilia vRecorridoFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoFamiliaList.insertElementAt(vRecorridoFamilia, index);
    } //-- void addRecorridoFamilia(int, com.tmk.kernel.site.RecorridoFamilia) 

    /**
     * Method enumerateRecorridoFamilia
     */
    public java.util.Enumeration enumerateRecorridoFamilia()
    {
        return _recorridoFamiliaList.elements();
    } //-- java.util.Enumeration enumerateRecorridoFamilia() 

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
     * Method getRecorridoFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoFamilia getRecorridoFamilia(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.RecorridoFamilia) _recorridoFamiliaList.elementAt(index);
    } //-- com.tmk.kernel.site.RecorridoFamilia getRecorridoFamilia(int) 

    /**
     * Method getRecorridoFamilia
     */
    public com.tmk.kernel.site.RecorridoFamilia[] getRecorridoFamilia()
    {
        int size = _recorridoFamiliaList.size();
        com.tmk.kernel.site.RecorridoFamilia[] mArray = new com.tmk.kernel.site.RecorridoFamilia[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.RecorridoFamilia) _recorridoFamiliaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.RecorridoFamilia[] getRecorridoFamilia() 

    /**
     * Method getRecorridoFamiliaCount
     */
    public int getRecorridoFamiliaCount()
    {
        return _recorridoFamiliaList.size();
    } //-- int getRecorridoFamiliaCount() 

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
     * Method removeAllRecorridoFamilia
     */
    public void removeAllRecorridoFamilia()
    {
        _recorridoFamiliaList.removeAllElements();
    } //-- void removeAllRecorridoFamilia() 

    /**
     * Method removeRecorridoFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoFamilia removeRecorridoFamilia(int index)
    {
        java.lang.Object obj = _recorridoFamiliaList.elementAt(index);
        _recorridoFamiliaList.removeElementAt(index);
        return (com.tmk.kernel.site.RecorridoFamilia) obj;
    } //-- com.tmk.kernel.site.RecorridoFamilia removeRecorridoFamilia(int) 

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
     * Method setRecorridoFamilia
     * 
     * @param index
     * @param vRecorridoFamilia
     */
    public void setRecorridoFamilia(int index, com.tmk.kernel.site.RecorridoFamilia vRecorridoFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _recorridoFamiliaList.setElementAt(vRecorridoFamilia, index);
    } //-- void setRecorridoFamilia(int, com.tmk.kernel.site.RecorridoFamilia) 

    /**
     * Method setRecorridoFamilia
     * 
     * @param recorridoFamiliaArray
     */
    public void setRecorridoFamilia(com.tmk.kernel.site.RecorridoFamilia[] recorridoFamiliaArray)
    {
        //-- copy array
        _recorridoFamiliaList.removeAllElements();
        for (int i = 0; i < recorridoFamiliaArray.length; i++) {
            _recorridoFamiliaList.addElement(recorridoFamiliaArray[i]);
        }
    } //-- void setRecorridoFamilia(com.tmk.kernel.site.RecorridoFamilia) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RecorridoFamilias unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RecorridoFamilias) Unmarshaller.unmarshal(com.tmk.kernel.site.RecorridoFamilias.class, reader);
    } //-- com.tmk.kernel.site.RecorridoFamilias unmarshal(java.io.Reader) 

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
