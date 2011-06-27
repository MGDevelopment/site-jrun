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
 * Class ComponentesTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class ComponentesTypeItem implements java.io.Serializable {


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
     * Field _componentes
     */
    private com.tmk.kernel.site.Componentes _componentes;


      //----------------/
     //- Constructors -/
    //----------------/

    public ComponentesTypeItem() {
        super();
    } //-- com.tmk.kernel.site.ComponentesTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'componentes'.
     * 
     * @return the value of field 'componentes'.
     */
    public com.tmk.kernel.site.Componentes getComponentes()
    {
        return this._componentes;
    } //-- com.tmk.kernel.site.Componentes getComponentes() 

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
     * Sets the value of field 'componentes'.
     * 
     * @param componentes the value of field 'componentes'.
     */
    public void setComponentes(com.tmk.kernel.site.Componentes componentes)
    {
        this._componentes = componentes;
    } //-- void setComponentes(com.tmk.kernel.site.Componentes) 

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
