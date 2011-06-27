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

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Class ReemplazoType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ReemplazoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _reemplazoList
     */
    private java.util.Vector _reemplazoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ReemplazoType() {
        super();
        _reemplazoList = new Vector();
    } //-- com.tmk.kernel.site.ReemplazoType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addReemplazo
     * 
     * @param vReemplazo
     */
    public void addReemplazo(com.tmk.kernel.site.Reemplazo vReemplazo)
        throws java.lang.IndexOutOfBoundsException
    {
        _reemplazoList.addElement(vReemplazo);
    } //-- void addReemplazo(com.tmk.kernel.site.Reemplazo) 

    /**
     * Method addReemplazo
     * 
     * @param index
     * @param vReemplazo
     */
    public void addReemplazo(int index, com.tmk.kernel.site.Reemplazo vReemplazo)
        throws java.lang.IndexOutOfBoundsException
    {
        _reemplazoList.insertElementAt(vReemplazo, index);
    } //-- void addReemplazo(int, com.tmk.kernel.site.Reemplazo) 

    /**
     * Method enumerateReemplazo
     */
    public java.util.Enumeration enumerateReemplazo()
    {
        return _reemplazoList.elements();
    } //-- java.util.Enumeration enumerateReemplazo() 

    /**
     * Method getReemplazo
     * 
     * @param index
     */
    public com.tmk.kernel.site.Reemplazo getReemplazo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _reemplazoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Reemplazo) _reemplazoList.elementAt(index);
    } //-- com.tmk.kernel.site.Reemplazo getReemplazo(int) 

    /**
     * Method getReemplazo
     */
    public com.tmk.kernel.site.Reemplazo[] getReemplazo()
    {
        int size = _reemplazoList.size();
        com.tmk.kernel.site.Reemplazo[] mArray = new com.tmk.kernel.site.Reemplazo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Reemplazo) _reemplazoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Reemplazo[] getReemplazo() 

    /**
     * Method getReemplazoCount
     */
    public int getReemplazoCount()
    {
        return _reemplazoList.size();
    } //-- int getReemplazoCount() 

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
     * Method removeAllReemplazo
     */
    public void removeAllReemplazo()
    {
        _reemplazoList.removeAllElements();
    } //-- void removeAllReemplazo() 

    /**
     * Method removeReemplazo
     * 
     * @param index
     */
    public com.tmk.kernel.site.Reemplazo removeReemplazo(int index)
    {
        java.lang.Object obj = _reemplazoList.elementAt(index);
        _reemplazoList.removeElementAt(index);
        return (com.tmk.kernel.site.Reemplazo) obj;
    } //-- com.tmk.kernel.site.Reemplazo removeReemplazo(int) 

    /**
     * Method setReemplazo
     * 
     * @param index
     * @param vReemplazo
     */
    public void setReemplazo(int index, com.tmk.kernel.site.Reemplazo vReemplazo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _reemplazoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _reemplazoList.setElementAt(vReemplazo, index);
    } //-- void setReemplazo(int, com.tmk.kernel.site.Reemplazo) 

    /**
     * Method setReemplazo
     * 
     * @param reemplazoArray
     */
    public void setReemplazo(com.tmk.kernel.site.Reemplazo[] reemplazoArray)
    {
        //-- copy array
        _reemplazoList.removeAllElements();
        for (int i = 0; i < reemplazoArray.length; i++) {
            _reemplazoList.addElement(reemplazoArray[i]);
        }
    } //-- void setReemplazo(com.tmk.kernel.site.Reemplazo) 

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
