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

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class BannerFamiliaItem.
 * 
 * @version $Revision$ $Date$
 */
public class BannerFamiliaItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bannerSubFamiliaList
     */
    private java.util.Vector _bannerSubFamiliaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannerFamiliaItem() {
        super();
        _bannerSubFamiliaList = new Vector();
    } //-- com.tmk.kernel.site.BannerFamiliaItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBannerSubFamilia
     * 
     * @param vBannerSubFamilia
     */
    public void addBannerSubFamilia(com.tmk.kernel.site.BannerSubFamilia vBannerSubFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerSubFamiliaList.addElement(vBannerSubFamilia);
    } //-- void addBannerSubFamilia(com.tmk.kernel.site.BannerSubFamilia) 

    /**
     * Method addBannerSubFamilia
     * 
     * @param index
     * @param vBannerSubFamilia
     */
    public void addBannerSubFamilia(int index, com.tmk.kernel.site.BannerSubFamilia vBannerSubFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerSubFamiliaList.insertElementAt(vBannerSubFamilia, index);
    } //-- void addBannerSubFamilia(int, com.tmk.kernel.site.BannerSubFamilia) 

    /**
     * Method enumerateBannerSubFamilia
     */
    public java.util.Enumeration enumerateBannerSubFamilia()
    {
        return _bannerSubFamiliaList.elements();
    } //-- java.util.Enumeration enumerateBannerSubFamilia() 

    /**
     * Method getBannerSubFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerSubFamilia getBannerSubFamilia(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerSubFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.BannerSubFamilia) _bannerSubFamiliaList.elementAt(index);
    } //-- com.tmk.kernel.site.BannerSubFamilia getBannerSubFamilia(int) 

    /**
     * Method getBannerSubFamilia
     */
    public com.tmk.kernel.site.BannerSubFamilia[] getBannerSubFamilia()
    {
        int size = _bannerSubFamiliaList.size();
        com.tmk.kernel.site.BannerSubFamilia[] mArray = new com.tmk.kernel.site.BannerSubFamilia[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.BannerSubFamilia) _bannerSubFamiliaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.BannerSubFamilia[] getBannerSubFamilia() 

    /**
     * Method getBannerSubFamiliaCount
     */
    public int getBannerSubFamiliaCount()
    {
        return _bannerSubFamiliaList.size();
    } //-- int getBannerSubFamiliaCount() 

    /**
     * Method removeAllBannerSubFamilia
     */
    public void removeAllBannerSubFamilia()
    {
        _bannerSubFamiliaList.removeAllElements();
    } //-- void removeAllBannerSubFamilia() 

    /**
     * Method removeBannerSubFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerSubFamilia removeBannerSubFamilia(int index)
    {
        java.lang.Object obj = _bannerSubFamiliaList.elementAt(index);
        _bannerSubFamiliaList.removeElementAt(index);
        return (com.tmk.kernel.site.BannerSubFamilia) obj;
    } //-- com.tmk.kernel.site.BannerSubFamilia removeBannerSubFamilia(int) 

    /**
     * Method setBannerSubFamilia
     * 
     * @param index
     * @param vBannerSubFamilia
     */
    public void setBannerSubFamilia(int index, com.tmk.kernel.site.BannerSubFamilia vBannerSubFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerSubFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bannerSubFamiliaList.setElementAt(vBannerSubFamilia, index);
    } //-- void setBannerSubFamilia(int, com.tmk.kernel.site.BannerSubFamilia) 

    /**
     * Method setBannerSubFamilia
     * 
     * @param bannerSubFamiliaArray
     */
    public void setBannerSubFamilia(com.tmk.kernel.site.BannerSubFamilia[] bannerSubFamiliaArray)
    {
        //-- copy array
        _bannerSubFamiliaList.removeAllElements();
        for (int i = 0; i < bannerSubFamiliaArray.length; i++) {
            _bannerSubFamiliaList.addElement(bannerSubFamiliaArray[i]);
        }
    } //-- void setBannerSubFamilia(com.tmk.kernel.site.BannerSubFamilia) 

}
