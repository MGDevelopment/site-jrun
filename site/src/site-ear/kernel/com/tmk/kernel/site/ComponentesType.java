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
 * Class ComponentesType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ComponentesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComponentesType() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.site.ComponentesType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addComponentesTypeItem
     * 
     * @param vComponentesTypeItem
     */
    public void addComponentesTypeItem(com.tmk.kernel.site.ComponentesTypeItem vComponentesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vComponentesTypeItem);
    } //-- void addComponentesTypeItem(com.tmk.kernel.site.ComponentesTypeItem) 

    /**
     * Method addComponentesTypeItem
     * 
     * @param index
     * @param vComponentesTypeItem
     */
    public void addComponentesTypeItem(int index, com.tmk.kernel.site.ComponentesTypeItem vComponentesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vComponentesTypeItem, index);
    } //-- void addComponentesTypeItem(int, com.tmk.kernel.site.ComponentesTypeItem) 

    /**
     * Method enumerateComponentesTypeItem
     */
    public java.util.Enumeration enumerateComponentesTypeItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateComponentesTypeItem() 

    /**
     * Method getComponentesTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ComponentesTypeItem getComponentesTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.ComponentesTypeItem) _items.elementAt(index);
    } //-- com.tmk.kernel.site.ComponentesTypeItem getComponentesTypeItem(int) 

    /**
     * Method getComponentesTypeItem
     */
    public com.tmk.kernel.site.ComponentesTypeItem[] getComponentesTypeItem()
    {
        int size = _items.size();
        com.tmk.kernel.site.ComponentesTypeItem[] mArray = new com.tmk.kernel.site.ComponentesTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.ComponentesTypeItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.ComponentesTypeItem[] getComponentesTypeItem() 

    /**
     * Method getComponentesTypeItemCount
     */
    public int getComponentesTypeItemCount()
    {
        return _items.size();
    } //-- int getComponentesTypeItemCount() 

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
     * Method removeAllComponentesTypeItem
     */
    public void removeAllComponentesTypeItem()
    {
        _items.removeAllElements();
    } //-- void removeAllComponentesTypeItem() 

    /**
     * Method removeComponentesTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ComponentesTypeItem removeComponentesTypeItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.site.ComponentesTypeItem) obj;
    } //-- com.tmk.kernel.site.ComponentesTypeItem removeComponentesTypeItem(int) 

    /**
     * Method setComponentesTypeItem
     * 
     * @param index
     * @param vComponentesTypeItem
     */
    public void setComponentesTypeItem(int index, com.tmk.kernel.site.ComponentesTypeItem vComponentesTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vComponentesTypeItem, index);
    } //-- void setComponentesTypeItem(int, com.tmk.kernel.site.ComponentesTypeItem) 

    /**
     * Method setComponentesTypeItem
     * 
     * @param componentesTypeItemArray
     */
    public void setComponentesTypeItem(com.tmk.kernel.site.ComponentesTypeItem[] componentesTypeItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < componentesTypeItemArray.length; i++) {
            _items.addElement(componentesTypeItemArray[i]);
        }
    } //-- void setComponentesTypeItem(com.tmk.kernel.site.ComponentesTypeItem) 

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
