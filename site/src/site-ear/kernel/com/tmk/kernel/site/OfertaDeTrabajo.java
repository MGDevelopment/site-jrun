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
 * Class OfertaDeTrabajo.
 * 
 * @version $Revision$ $Date$
 */
public class OfertaDeTrabajo implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _emailList
     */
    private java.util.Vector _emailList;


      //----------------/
     //- Constructors -/
    //----------------/

    public OfertaDeTrabajo() {
        super();
        _emailList = new Vector();
    } //-- com.tmk.kernel.site.OfertaDeTrabajo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addEmail
     * 
     * @param vEmail
     */
    public void addEmail(java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        _emailList.addElement(vEmail);
    } //-- void addEmail(java.lang.String) 

    /**
     * Method addEmail
     * 
     * @param index
     * @param vEmail
     */
    public void addEmail(int index, java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        _emailList.insertElementAt(vEmail, index);
    } //-- void addEmail(int, java.lang.String) 

    /**
     * Method enumerateEmail
     */
    public java.util.Enumeration enumerateEmail()
    {
        return _emailList.elements();
    } //-- java.util.Enumeration enumerateEmail() 

    /**
     * Method getEmail
     * 
     * @param index
     */
    public java.lang.String getEmail(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _emailList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_emailList.elementAt(index);
    } //-- java.lang.String getEmail(int) 

    /**
     * Method getEmail
     */
    public java.lang.String[] getEmail()
    {
        int size = _emailList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_emailList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getEmail() 

    /**
     * Method getEmailCount
     */
    public int getEmailCount()
    {
        return _emailList.size();
    } //-- int getEmailCount() 

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
     * Method removeAllEmail
     */
    public void removeAllEmail()
    {
        _emailList.removeAllElements();
    } //-- void removeAllEmail() 

    /**
     * Method removeEmail
     * 
     * @param index
     */
    public java.lang.String removeEmail(int index)
    {
        java.lang.Object obj = _emailList.elementAt(index);
        _emailList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeEmail(int) 

    /**
     * Method setEmail
     * 
     * @param index
     * @param vEmail
     */
    public void setEmail(int index, java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _emailList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _emailList.setElementAt(vEmail, index);
    } //-- void setEmail(int, java.lang.String) 

    /**
     * Method setEmail
     * 
     * @param emailArray
     */
    public void setEmail(java.lang.String[] emailArray)
    {
        //-- copy array
        _emailList.removeAllElements();
        for (int i = 0; i < emailArray.length; i++) {
            _emailList.addElement(emailArray[i]);
        }
    } //-- void setEmail(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.OfertaDeTrabajo unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.OfertaDeTrabajo) Unmarshaller.unmarshal(com.tmk.kernel.site.OfertaDeTrabajo.class, reader);
    } //-- com.tmk.kernel.site.OfertaDeTrabajo unmarshal(java.io.Reader) 

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
