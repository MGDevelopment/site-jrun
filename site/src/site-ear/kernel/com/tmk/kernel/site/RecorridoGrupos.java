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
 * Class RecorridoGrupos.
 * 
 * @version $Revision$ $Date$
 */
public class RecorridoGrupos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _claves
     */
    private com.tmk.kernel.site.Claves _claves;

    /**
     * Field _recorridoGrupoList
     */
    private java.util.Vector _recorridoGrupoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RecorridoGrupos() {
        super();
        _recorridoGrupoList = new Vector();
    } //-- com.tmk.kernel.site.RecorridoGrupos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRecorridoGrupo
     * 
     * @param vRecorridoGrupo
     */
    public void addRecorridoGrupo(com.tmk.kernel.site.RecorridoGrupo vRecorridoGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoGrupoList.addElement(vRecorridoGrupo);
    } //-- void addRecorridoGrupo(com.tmk.kernel.site.RecorridoGrupo) 

    /**
     * Method addRecorridoGrupo
     * 
     * @param index
     * @param vRecorridoGrupo
     */
    public void addRecorridoGrupo(int index, com.tmk.kernel.site.RecorridoGrupo vRecorridoGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _recorridoGrupoList.insertElementAt(vRecorridoGrupo, index);
    } //-- void addRecorridoGrupo(int, com.tmk.kernel.site.RecorridoGrupo) 

    /**
     * Method enumerateRecorridoGrupo
     */
    public java.util.Enumeration enumerateRecorridoGrupo()
    {
        return _recorridoGrupoList.elements();
    } //-- java.util.Enumeration enumerateRecorridoGrupo() 

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
     * Method getRecorridoGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoGrupo getRecorridoGrupo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.RecorridoGrupo) _recorridoGrupoList.elementAt(index);
    } //-- com.tmk.kernel.site.RecorridoGrupo getRecorridoGrupo(int) 

    /**
     * Method getRecorridoGrupo
     */
    public com.tmk.kernel.site.RecorridoGrupo[] getRecorridoGrupo()
    {
        int size = _recorridoGrupoList.size();
        com.tmk.kernel.site.RecorridoGrupo[] mArray = new com.tmk.kernel.site.RecorridoGrupo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.RecorridoGrupo) _recorridoGrupoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.RecorridoGrupo[] getRecorridoGrupo() 

    /**
     * Method getRecorridoGrupoCount
     */
    public int getRecorridoGrupoCount()
    {
        return _recorridoGrupoList.size();
    } //-- int getRecorridoGrupoCount() 

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
     * Method removeAllRecorridoGrupo
     */
    public void removeAllRecorridoGrupo()
    {
        _recorridoGrupoList.removeAllElements();
    } //-- void removeAllRecorridoGrupo() 

    /**
     * Method removeRecorridoGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.RecorridoGrupo removeRecorridoGrupo(int index)
    {
        java.lang.Object obj = _recorridoGrupoList.elementAt(index);
        _recorridoGrupoList.removeElementAt(index);
        return (com.tmk.kernel.site.RecorridoGrupo) obj;
    } //-- com.tmk.kernel.site.RecorridoGrupo removeRecorridoGrupo(int) 

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
     * Method setRecorridoGrupo
     * 
     * @param index
     * @param vRecorridoGrupo
     */
    public void setRecorridoGrupo(int index, com.tmk.kernel.site.RecorridoGrupo vRecorridoGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _recorridoGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _recorridoGrupoList.setElementAt(vRecorridoGrupo, index);
    } //-- void setRecorridoGrupo(int, com.tmk.kernel.site.RecorridoGrupo) 

    /**
     * Method setRecorridoGrupo
     * 
     * @param recorridoGrupoArray
     */
    public void setRecorridoGrupo(com.tmk.kernel.site.RecorridoGrupo[] recorridoGrupoArray)
    {
        //-- copy array
        _recorridoGrupoList.removeAllElements();
        for (int i = 0; i < recorridoGrupoArray.length; i++) {
            _recorridoGrupoList.addElement(recorridoGrupoArray[i]);
        }
    } //-- void setRecorridoGrupo(com.tmk.kernel.site.RecorridoGrupo) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RecorridoGrupos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RecorridoGrupos) Unmarshaller.unmarshal(com.tmk.kernel.site.RecorridoGrupos.class, reader);
    } //-- com.tmk.kernel.site.RecorridoGrupos unmarshal(java.io.Reader) 

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
