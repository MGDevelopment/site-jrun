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
 * Class BannerCatalogoItem.
 * 
 * @version $Revision$ $Date$
 */
public class BannerCatalogoItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _bannerGrupoList
     */
    private java.util.Vector _bannerGrupoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannerCatalogoItem() {
        super();
        _bannerGrupoList = new Vector();
    } //-- com.tmk.kernel.site.BannerCatalogoItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addBannerGrupo
     * 
     * @param vBannerGrupo
     */
    public void addBannerGrupo(com.tmk.kernel.site.BannerGrupo vBannerGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerGrupoList.addElement(vBannerGrupo);
    } //-- void addBannerGrupo(com.tmk.kernel.site.BannerGrupo) 

    /**
     * Method addBannerGrupo
     * 
     * @param index
     * @param vBannerGrupo
     */
    public void addBannerGrupo(int index, com.tmk.kernel.site.BannerGrupo vBannerGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _bannerGrupoList.insertElementAt(vBannerGrupo, index);
    } //-- void addBannerGrupo(int, com.tmk.kernel.site.BannerGrupo) 

    /**
     * Method enumerateBannerGrupo
     */
    public java.util.Enumeration enumerateBannerGrupo()
    {
        return _bannerGrupoList.elements();
    } //-- java.util.Enumeration enumerateBannerGrupo() 

    /**
     * Method getBannerGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerGrupo getBannerGrupo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.BannerGrupo) _bannerGrupoList.elementAt(index);
    } //-- com.tmk.kernel.site.BannerGrupo getBannerGrupo(int) 

    /**
     * Method getBannerGrupo
     */
    public com.tmk.kernel.site.BannerGrupo[] getBannerGrupo()
    {
        int size = _bannerGrupoList.size();
        com.tmk.kernel.site.BannerGrupo[] mArray = new com.tmk.kernel.site.BannerGrupo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.BannerGrupo) _bannerGrupoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.BannerGrupo[] getBannerGrupo() 

    /**
     * Method getBannerGrupoCount
     */
    public int getBannerGrupoCount()
    {
        return _bannerGrupoList.size();
    } //-- int getBannerGrupoCount() 

    /**
     * Method removeAllBannerGrupo
     */
    public void removeAllBannerGrupo()
    {
        _bannerGrupoList.removeAllElements();
    } //-- void removeAllBannerGrupo() 

    /**
     * Method removeBannerGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.BannerGrupo removeBannerGrupo(int index)
    {
        java.lang.Object obj = _bannerGrupoList.elementAt(index);
        _bannerGrupoList.removeElementAt(index);
        return (com.tmk.kernel.site.BannerGrupo) obj;
    } //-- com.tmk.kernel.site.BannerGrupo removeBannerGrupo(int) 

    /**
     * Method setBannerGrupo
     * 
     * @param index
     * @param vBannerGrupo
     */
    public void setBannerGrupo(int index, com.tmk.kernel.site.BannerGrupo vBannerGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _bannerGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _bannerGrupoList.setElementAt(vBannerGrupo, index);
    } //-- void setBannerGrupo(int, com.tmk.kernel.site.BannerGrupo) 

    /**
     * Method setBannerGrupo
     * 
     * @param bannerGrupoArray
     */
    public void setBannerGrupo(com.tmk.kernel.site.BannerGrupo[] bannerGrupoArray)
    {
        //-- copy array
        _bannerGrupoList.removeAllElements();
        for (int i = 0; i < bannerGrupoArray.length; i++) {
            _bannerGrupoList.addElement(bannerGrupoArray[i]);
        }
    } //-- void setBannerGrupo(com.tmk.kernel.site.BannerGrupo) 

}
