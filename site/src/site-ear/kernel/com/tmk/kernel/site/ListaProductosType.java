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
 * Class ListaProductosType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ListaProductosType implements java.io.Serializable {


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

    public ListaProductosType() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.site.ListaProductosType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addListaProductosTypeItem
     * 
     * @param vListaProductosTypeItem
     */
    public void addListaProductosTypeItem(com.tmk.kernel.site.ListaProductosTypeItem vListaProductosTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vListaProductosTypeItem);
    } //-- void addListaProductosTypeItem(com.tmk.kernel.site.ListaProductosTypeItem) 

    /**
     * Method addListaProductosTypeItem
     * 
     * @param index
     * @param vListaProductosTypeItem
     */
    public void addListaProductosTypeItem(int index, com.tmk.kernel.site.ListaProductosTypeItem vListaProductosTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vListaProductosTypeItem, index);
    } //-- void addListaProductosTypeItem(int, com.tmk.kernel.site.ListaProductosTypeItem) 

    /**
     * Method enumerateListaProductosTypeItem
     */
    public java.util.Enumeration enumerateListaProductosTypeItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateListaProductosTypeItem() 

    /**
     * Method getListaProductosTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ListaProductosTypeItem getListaProductosTypeItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.ListaProductosTypeItem) _items.elementAt(index);
    } //-- com.tmk.kernel.site.ListaProductosTypeItem getListaProductosTypeItem(int) 

    /**
     * Method getListaProductosTypeItem
     */
    public com.tmk.kernel.site.ListaProductosTypeItem[] getListaProductosTypeItem()
    {
        int size = _items.size();
        com.tmk.kernel.site.ListaProductosTypeItem[] mArray = new com.tmk.kernel.site.ListaProductosTypeItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.ListaProductosTypeItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.ListaProductosTypeItem[] getListaProductosTypeItem() 

    /**
     * Method getListaProductosTypeItemCount
     */
    public int getListaProductosTypeItemCount()
    {
        return _items.size();
    } //-- int getListaProductosTypeItemCount() 

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
     * Method removeAllListaProductosTypeItem
     */
    public void removeAllListaProductosTypeItem()
    {
        _items.removeAllElements();
    } //-- void removeAllListaProductosTypeItem() 

    /**
     * Method removeListaProductosTypeItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.ListaProductosTypeItem removeListaProductosTypeItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.site.ListaProductosTypeItem) obj;
    } //-- com.tmk.kernel.site.ListaProductosTypeItem removeListaProductosTypeItem(int) 

    /**
     * Method setListaProductosTypeItem
     * 
     * @param index
     * @param vListaProductosTypeItem
     */
    public void setListaProductosTypeItem(int index, com.tmk.kernel.site.ListaProductosTypeItem vListaProductosTypeItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vListaProductosTypeItem, index);
    } //-- void setListaProductosTypeItem(int, com.tmk.kernel.site.ListaProductosTypeItem) 

    /**
     * Method setListaProductosTypeItem
     * 
     * @param listaProductosTypeItemArray
     */
    public void setListaProductosTypeItem(com.tmk.kernel.site.ListaProductosTypeItem[] listaProductosTypeItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < listaProductosTypeItemArray.length; i++) {
            _items.addElement(listaProductosTypeItemArray[i]);
        }
    } //-- void setListaProductosTypeItem(com.tmk.kernel.site.ListaProductosTypeItem) 

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
