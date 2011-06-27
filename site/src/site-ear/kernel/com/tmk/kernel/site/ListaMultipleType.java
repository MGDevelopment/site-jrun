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
 * Class ListaMultipleType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ListaMultipleType implements java.io.Serializable {


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

    public ListaMultipleType() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.site.ListaMultipleType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addListaMultipleTypeItem
     * 
     * @param vListaMultipleTypeItem
     */
    public void addListaMultipleTypeItem(com.tmk.kernel.site.ListaMultipleTypeItem vListaMultipleTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vListaMultipleTypeItem);
    } //-- void addListaMultipleTypeItem(com.tmk.kernel.site.ListaMultipleTypeItem) 

    /**
     * Method addListaMultipleTypeItem
     * 
     * @param index
     * @param vListaMultipleTypeItem
     */
    public void addListaMultipleTypeItem(int index, com.tmk.kernel.site.ListaMultipleTypeItem vListaMultipleTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vListaMultipleTypeItem, index);
    } //-- void addListaMultipleTypeItem(int, com.tmk.kernel.site.ListaMultipleTypeItem) 

    /**
     * Method enumerateListaMultipleTypeItem
     */
    public java.util.Enumeration enumerateListaMultipleTypeItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateListaMultipleTypeItem() 

    /**
     * Method getListaMultipleTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ListaMultipleTypeItem getListaMultipleTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.ListaMultipleTypeItem) _items.elementAt(index);
    } //-- com.tmk.kernel.site.ListaMultipleTypeItem getListaMultipleTypeItem(int) 

    /**
     * Method getListaMultipleTypeItem
     */
    public com.tmk.kernel.site.ListaMultipleTypeItem[] getListaMultipleTypeItem()
    {
        int size = _items.size();
        com.tmk.kernel.site.ListaMultipleTypeItem[] mArray = new com.tmk.kernel.site.ListaMultipleTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.ListaMultipleTypeItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.ListaMultipleTypeItem[] getListaMultipleTypeItem() 

    /**
     * Method getListaMultipleTypeItemCount
     */
    public int getListaMultipleTypeItemCount()
    {
        return _items.size();
    } //-- int getListaMultipleTypeItemCount() 

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
     * Method removeAllListaMultipleTypeItem
     */
    public void removeAllListaMultipleTypeItem()
    {
        _items.removeAllElements();
    } //-- void removeAllListaMultipleTypeItem() 

    /**
     * Method removeListaMultipleTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ListaMultipleTypeItem removeListaMultipleTypeItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.site.ListaMultipleTypeItem) obj;
    } //-- com.tmk.kernel.site.ListaMultipleTypeItem removeListaMultipleTypeItem(int) 

    /**
     * Method setListaMultipleTypeItem
     * 
     * @param index
     * @param vListaMultipleTypeItem
     */
    public void setListaMultipleTypeItem(int index, com.tmk.kernel.site.ListaMultipleTypeItem vListaMultipleTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vListaMultipleTypeItem, index);
    } //-- void setListaMultipleTypeItem(int, com.tmk.kernel.site.ListaMultipleTypeItem) 

    /**
     * Method setListaMultipleTypeItem
     * 
     * @param listaMultipleTypeItemArray
     */
    public void setListaMultipleTypeItem(com.tmk.kernel.site.ListaMultipleTypeItem[] listaMultipleTypeItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < listaMultipleTypeItemArray.length; i++) {
            _items.addElement(listaMultipleTypeItemArray[i]);
        }
    } //-- void setListaMultipleTypeItem(com.tmk.kernel.site.ListaMultipleTypeItem) 

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
