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
 * Class BannerFamilia.
 * 
 * @version $Revision$ $Date$
 */
public class BannerFamilia implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _url
     */
    private java.lang.String _url;

    /**
     * Field _items
     */
    private java.util.Vector _items;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannerFamilia() {
        super();
        _items = new Vector();
    } //-- com.tmk.kernel.site.BannerFamilia()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBannerFamiliaItem
     * 
     * @param vBannerFamiliaItem
     */
    public void addBannerFamiliaItem(com.tmk.kernel.site.BannerFamiliaItem vBannerFamiliaItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.addElement(vBannerFamiliaItem);
    } //-- void addBannerFamiliaItem(com.tmk.kernel.site.BannerFamiliaItem) 

    /**
     * Method addBannerFamiliaItem
     * 
     * @param index
     * @param vBannerFamiliaItem
     */
    public void addBannerFamiliaItem(int index, com.tmk.kernel.site.BannerFamiliaItem vBannerFamiliaItem)
        throws java.lang.IndexOutOfBoundsException
    {
        _items.insertElementAt(vBannerFamiliaItem, index);
    } //-- void addBannerFamiliaItem(int, com.tmk.kernel.site.BannerFamiliaItem) 

    /**
     * Method enumerateBannerFamiliaItem
     */
    public java.util.Enumeration enumerateBannerFamiliaItem()
    {
        return _items.elements();
    } //-- java.util.Enumeration enumerateBannerFamiliaItem() 

    /**
     * Method getBannerFamiliaItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerFamiliaItem getBannerFamiliaItem(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.BannerFamiliaItem) _items.elementAt(index);
    } //-- com.tmk.kernel.site.BannerFamiliaItem getBannerFamiliaItem(int) 

    /**
     * Method getBannerFamiliaItem
     */
    public com.tmk.kernel.site.BannerFamiliaItem[] getBannerFamiliaItem()
    {
        int size = _items.size();
        com.tmk.kernel.site.BannerFamiliaItem[] mArray = new com.tmk.kernel.site.BannerFamiliaItem[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.BannerFamiliaItem) _items.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.BannerFamiliaItem[] getBannerFamiliaItem() 

    /**
     * Method getBannerFamiliaItemCount
     */
    public int getBannerFamiliaItemCount()
    {
        return _items.size();
    } //-- int getBannerFamiliaItemCount() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'id'.
     */
    public int getId()
    {
        return this._id;
    } //-- int getId() 

    /**
     * Returns the value of field 'url'.
     * 
     * @return the value of field 'url'.
     */
    public java.lang.String getUrl()
    {
        return this._url;
    } //-- java.lang.String getUrl() 

    /**
     * Method hasId
     */
    public boolean hasId()
    {
        return this._has_id;
    } //-- boolean hasId() 

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
     * Method removeAllBannerFamiliaItem
     */
    public void removeAllBannerFamiliaItem()
    {
        _items.removeAllElements();
    } //-- void removeAllBannerFamiliaItem() 

    /**
     * Method removeBannerFamiliaItem
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerFamiliaItem removeBannerFamiliaItem(int index)
    {
        java.lang.Object obj = _items.elementAt(index);
        _items.removeElementAt(index);
        return (com.tmk.kernel.site.BannerFamiliaItem) obj;
    } //-- com.tmk.kernel.site.BannerFamiliaItem removeBannerFamiliaItem(int) 

    /**
     * Method setBannerFamiliaItem
     * 
     * @param index
     * @param vBannerFamiliaItem
     */
    public void setBannerFamiliaItem(int index, com.tmk.kernel.site.BannerFamiliaItem vBannerFamiliaItem)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _items.size())) {
            throw new IndexOutOfBoundsException();
        }
        _items.setElementAt(vBannerFamiliaItem, index);
    } //-- void setBannerFamiliaItem(int, com.tmk.kernel.site.BannerFamiliaItem) 

    /**
     * Method setBannerFamiliaItem
     * 
     * @param bannerFamiliaItemArray
     */
    public void setBannerFamiliaItem(com.tmk.kernel.site.BannerFamiliaItem[] bannerFamiliaItemArray)
    {
        //-- copy array
        _items.removeAllElements();
        for (int i = 0; i < bannerFamiliaItemArray.length; i++) {
            _items.addElement(bannerFamiliaItemArray[i]);
        }
    } //-- void setBannerFamiliaItem(com.tmk.kernel.site.BannerFamiliaItem) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(int id)
    {
        this._id = id;
        this._has_id = true;
    } //-- void setId(int) 

    /**
     * Sets the value of field 'url'.
     * 
     * @param url the value of field 'url'.
     */
    public void setUrl(java.lang.String url)
    {
        this._url = url;
    } //-- void setUrl(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.BannerFamilia unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.BannerFamilia) Unmarshaller.unmarshal(com.tmk.kernel.site.BannerFamilia.class, reader);
    } //-- com.tmk.kernel.site.BannerFamilia unmarshal(java.io.Reader) 

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
