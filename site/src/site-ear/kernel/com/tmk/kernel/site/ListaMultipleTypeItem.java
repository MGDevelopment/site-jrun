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
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class ListaMultipleTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class ListaMultipleTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _producto
     */
    private com.tmk.kernel.site.Producto _producto;

    /**
     * Field _link
     */
    private com.tmk.kernel.site.Link _link;

    /**
     * Field _flash
     */
    private com.tmk.kernel.site.Flash _flash;


      //----------------/
     //- Constructors -/
    //----------------/

    public ListaMultipleTypeItem() {
        super();
    } //-- com.tmk.kernel.site.ListaMultipleTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'flash'.
     * 
     * @return the value of field 'flash'.
     */
    public com.tmk.kernel.site.Flash getFlash()
    {
        return this._flash;
    } //-- com.tmk.kernel.site.Flash getFlash() 

    /**
     * Returns the value of field 'link'.
     * 
     * @return the value of field 'link'.
     */
    public com.tmk.kernel.site.Link getLink()
    {
        return this._link;
    } //-- com.tmk.kernel.site.Link getLink() 

    /**
     * Returns the value of field 'producto'.
     * 
     * @return the value of field 'producto'.
     */
    public com.tmk.kernel.site.Producto getProducto()
    {
        return this._producto;
    } //-- com.tmk.kernel.site.Producto getProducto() 

    /**
     * Sets the value of field 'flash'.
     * 
     * @param flash the value of field 'flash'.
     */
    public void setFlash(com.tmk.kernel.site.Flash flash)
    {
        this._flash = flash;
    } //-- void setFlash(com.tmk.kernel.site.Flash) 

    /**
     * Sets the value of field 'link'.
     * 
     * @param link the value of field 'link'.
     */
    public void setLink(com.tmk.kernel.site.Link link)
    {
        this._link = link;
    } //-- void setLink(com.tmk.kernel.site.Link) 

    /**
     * Sets the value of field 'producto'.
     * 
     * @param producto the value of field 'producto'.
     */
    public void setProducto(com.tmk.kernel.site.Producto producto)
    {
        this._producto = producto;
    } //-- void setProducto(com.tmk.kernel.site.Producto) 

}
