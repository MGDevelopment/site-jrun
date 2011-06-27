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
 * Class BannerGrupoItem.
 * 
 * @version $Revision$ $Date$
 */
public class BannerGrupoItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bannerFamiliaList
     */
    private java.util.Vector _bannerFamiliaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannerGrupoItem() {
        super();
        _bannerFamiliaList = new Vector();
    } //-- com.tmk.kernel.site.BannerGrupoItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBannerFamilia
     * 
     * @param vBannerFamilia
     */
    public void addBannerFamilia(com.tmk.kernel.site.BannerFamilia vBannerFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerFamiliaList.addElement(vBannerFamilia);
    } //-- void addBannerFamilia(com.tmk.kernel.site.BannerFamilia) 

    /**
     * Method addBannerFamilia
     * 
     * @param index
     * @param vBannerFamilia
     */
    public void addBannerFamilia(int index, com.tmk.kernel.site.BannerFamilia vBannerFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerFamiliaList.insertElementAt(vBannerFamilia, index);
    } //-- void addBannerFamilia(int, com.tmk.kernel.site.BannerFamilia) 

    /**
     * Method enumerateBannerFamilia
     */
    public java.util.Enumeration enumerateBannerFamilia()
    {
        return _bannerFamiliaList.elements();
    } //-- java.util.Enumeration enumerateBannerFamilia() 

    /**
     * Method getBannerFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerFamilia getBannerFamilia(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.BannerFamilia) _bannerFamiliaList.elementAt(index);
    } //-- com.tmk.kernel.site.BannerFamilia getBannerFamilia(int) 

    /**
     * Method getBannerFamilia
     */
    public com.tmk.kernel.site.BannerFamilia[] getBannerFamilia()
    {
        int size = _bannerFamiliaList.size();
        com.tmk.kernel.site.BannerFamilia[] mArray = new com.tmk.kernel.site.BannerFamilia[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.BannerFamilia) _bannerFamiliaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.BannerFamilia[] getBannerFamilia() 

    /**
     * Method getBannerFamiliaCount
     */
    public int getBannerFamiliaCount()
    {
        return _bannerFamiliaList.size();
    } //-- int getBannerFamiliaCount() 

    /**
     * Method removeAllBannerFamilia
     */
    public void removeAllBannerFamilia()
    {
        _bannerFamiliaList.removeAllElements();
    } //-- void removeAllBannerFamilia() 

    /**
     * Method removeBannerFamilia
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerFamilia removeBannerFamilia(int index)
    {
        java.lang.Object obj = _bannerFamiliaList.elementAt(index);
        _bannerFamiliaList.removeElementAt(index);
        return (com.tmk.kernel.site.BannerFamilia) obj;
    } //-- com.tmk.kernel.site.BannerFamilia removeBannerFamilia(int) 

    /**
     * Method setBannerFamilia
     * 
     * @param index
     * @param vBannerFamilia
     */
    public void setBannerFamilia(int index, com.tmk.kernel.site.BannerFamilia vBannerFamilia)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerFamiliaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bannerFamiliaList.setElementAt(vBannerFamilia, index);
    } //-- void setBannerFamilia(int, com.tmk.kernel.site.BannerFamilia) 

    /**
     * Method setBannerFamilia
     * 
     * @param bannerFamiliaArray
     */
    public void setBannerFamilia(com.tmk.kernel.site.BannerFamilia[] bannerFamiliaArray)
    {
        //-- copy array
        _bannerFamiliaList.removeAllElements();
        for (int i = 0; i < bannerFamiliaArray.length; i++) {
            _bannerFamiliaList.addElement(bannerFamiliaArray[i]);
        }
    } //-- void setBannerFamilia(com.tmk.kernel.site.BannerFamilia) 

}
