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
 * Class ListaProductosTypeItem.
 * 
 * @version $Revision$ $Date$
 */
public class ListaProductosTypeItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _producto
     */
    private com.tmk.kernel.site.Producto _producto;


      //----------------/
     //- Constructors -/
    //----------------/

    public ListaProductosTypeItem() {
        super();
    } //-- com.tmk.kernel.site.ListaProductosTypeItem()


      //-----------/
     //- Methods -/
    //-----------/

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
     * Sets the value of field 'producto'.
     * 
     * @param producto the value of field 'producto'.
     */
    public void setProducto(com.tmk.kernel.site.Producto producto)
    {
        this._producto = producto;
    } //-- void setProducto(com.tmk.kernel.site.Producto) 

}
