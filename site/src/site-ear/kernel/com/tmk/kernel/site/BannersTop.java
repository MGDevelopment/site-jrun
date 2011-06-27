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
 * Class BannersTop.
 * 
 * @version $Revision$ $Date$
 */
public class BannersTop implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bannerList
     */
    private java.util.Vector _bannerList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannersTop() {
        super();
        _bannerList = new Vector();
    } //-- com.tmk.kernel.site.BannersTop()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBanner
     * 
     * @param vBanner
     */
    public void addBanner(com.tmk.kernel.site.Banner vBanner)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerList.addElement(vBanner);
    } //-- void addBanner(com.tmk.kernel.site.Banner) 

    /**
     * Method addBanner
     * 
     * @param index
     * @param vBanner
     */
    public void addBanner(int index, com.tmk.kernel.site.Banner vBanner)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerList.insertElementAt(vBanner, index);
    } //-- void addBanner(int, com.tmk.kernel.site.Banner) 

    /**
     * Method enumerateBanner
     */
    public java.util.Enumeration enumerateBanner()
    {
        return _bannerList.elements();
    } //-- java.util.Enumeration enumerateBanner() 

    /**
     * Method getBanner
     * 
     * @param index
     */
    public com.tmk.kernel.site.Banner getBanner(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Banner) _bannerList.elementAt(index);
    } //-- com.tmk.kernel.site.Banner getBanner(int) 

    /**
     * Method getBanner
     */
    public com.tmk.kernel.site.Banner[] getBanner()
    {
        int size = _bannerList.size();
        com.tmk.kernel.site.Banner[] mArray = new com.tmk.kernel.site.Banner[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Banner) _bannerList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Banner[] getBanner() 

    /**
     * Method getBannerCount
     */
    public int getBannerCount()
    {
        return _bannerList.size();
    } //-- int getBannerCount() 

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
     * Method removeAllBanner
     */
    public void removeAllBanner()
    {
        _bannerList.removeAllElements();
    } //-- void removeAllBanner() 

    /**
     * Method removeBanner
     * 
     * @param index
     */
    public com.tmk.kernel.site.Banner removeBanner(int index)
    {
        java.lang.Object obj = _bannerList.elementAt(index);
        _bannerList.removeElementAt(index);
        return (com.tmk.kernel.site.Banner) obj;
    } //-- com.tmk.kernel.site.Banner removeBanner(int) 

    /**
     * Method setBanner
     * 
     * @param index
     * @param vBanner
     */
    public void setBanner(int index, com.tmk.kernel.site.Banner vBanner)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bannerList.setElementAt(vBanner, index);
    } //-- void setBanner(int, com.tmk.kernel.site.Banner) 

    /**
     * Method setBanner
     * 
     * @param bannerArray
     */
    public void setBanner(com.tmk.kernel.site.Banner[] bannerArray)
    {
        //-- copy array
        _bannerList.removeAllElements();
        for (int i = 0; i < bannerArray.length; i++) {
            _bannerList.addElement(bannerArray[i]);
        }
    } //-- void setBanner(com.tmk.kernel.site.Banner) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.BannersTop unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.BannersTop) Unmarshaller.unmarshal(com.tmk.kernel.site.BannersTop.class, reader);
    } //-- com.tmk.kernel.site.BannersTop unmarshal(java.io.Reader) 

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
