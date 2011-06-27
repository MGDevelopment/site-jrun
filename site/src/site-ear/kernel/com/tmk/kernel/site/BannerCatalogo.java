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
 * Class BannerCatalogo.
 * 
 * @version $Revision$ $Date$
 */
public class BannerCatalogo implements java.io.Serializable {


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

    public BannerCatalogo() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.site.BannerCatalogo()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBannerCatalogoItem
     * 
     * @param vBannerCatalogoItem
     */
    public void addBannerCatalogoItem(com.tmk.kernel.site.BannerCatalogoItem vBannerCatalogoItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vBannerCatalogoItem);
    } //-- void addBannerCatalogoItem(com.tmk.kernel.site.BannerCatalogoItem) 

    /**
     * Method addBannerCatalogoItem
     * 
     * @param index
     * @param vBannerCatalogoItem
     */
    public void addBannerCatalogoItem(int index, com.tmk.kernel.site.BannerCatalogoItem vBannerCatalogoItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vBannerCatalogoItem, index);
    } //-- void addBannerCatalogoItem(int, com.tmk.kernel.site.BannerCatalogoItem) 

    /**
     * Method enumerateBannerCatalogoItem
     */
    public java.util.Enumeration enumerateBannerCatalogoItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateBannerCatalogoItem() 

    /**
     * Method getBannerCatalogoItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerCatalogoItem getBannerCatalogoItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.BannerCatalogoItem) _items.elementAt(index);
    } //-- com.tmk.kernel.site.BannerCatalogoItem getBannerCatalogoItem(int) 

    /**
     * Method getBannerCatalogoItem
     */
    public com.tmk.kernel.site.BannerCatalogoItem[] getBannerCatalogoItem()
    {
        int size = _items.size();
        com.tmk.kernel.site.BannerCatalogoItem[] mArray = new com.tmk.kernel.site.BannerCatalogoItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.BannerCatalogoItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.BannerCatalogoItem[] getBannerCatalogoItem() 

    /**
     * Method getBannerCatalogoItemCount
     */
    public int getBannerCatalogoItemCount()
    {
        return _items.size();
    } //-- int getBannerCatalogoItemCount() 

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
     * Method removeAllBannerCatalogoItem
     */
    public void removeAllBannerCatalogoItem()
    {
        _items.removeAllElements();
    } //-- void removeAllBannerCatalogoItem() 

    /**
     * Method removeBannerCatalogoItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerCatalogoItem removeBannerCatalogoItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.site.BannerCatalogoItem) obj;
    } //-- com.tmk.kernel.site.BannerCatalogoItem removeBannerCatalogoItem(int) 

    /**
     * Method setBannerCatalogoItem
     * 
     * @param index
     * @param vBannerCatalogoItem
     */
    public void setBannerCatalogoItem(int index, com.tmk.kernel.site.BannerCatalogoItem vBannerCatalogoItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vBannerCatalogoItem, index);
    } //-- void setBannerCatalogoItem(int, com.tmk.kernel.site.BannerCatalogoItem) 

    /**
     * Method setBannerCatalogoItem
     * 
     * @param bannerCatalogoItemArray
     */
    public void setBannerCatalogoItem(com.tmk.kernel.site.BannerCatalogoItem[] bannerCatalogoItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < bannerCatalogoItemArray.length; i++) {
            _items.addElement(bannerCatalogoItemArray[i]);
        }
    } //-- void setBannerCatalogoItem(com.tmk.kernel.site.BannerCatalogoItem) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.BannerCatalogo unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.BannerCatalogo) Unmarshaller.unmarshal(com.tmk.kernel.site.BannerCatalogo.class, reader);
    } //-- com.tmk.kernel.site.BannerCatalogo unmarshal(java.io.Reader) 

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
