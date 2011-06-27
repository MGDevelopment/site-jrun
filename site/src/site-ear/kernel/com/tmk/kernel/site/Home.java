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
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Home.
 * 
 * @version $Revision$ $Date$
 */
public class Home implements java.io.Serializable {


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

    /**
     * Field _html
     */
    private com.tmk.kernel.site.Html _html;


      //----------------/
     //- Constructors -/
    //----------------/

    public Home() {
        super();
    } //-- com.tmk.kernel.site.Home()


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
     * Returns the value of field 'html'.
     * 
     * @return the value of field 'html'.
     */
    public com.tmk.kernel.site.Html getHtml()
    {
        return this._html;
    } //-- com.tmk.kernel.site.Html getHtml() 

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
     * Sets the value of field 'flash'.
     * 
     * @param flash the value of field 'flash'.
     */
    public void setFlash(com.tmk.kernel.site.Flash flash)
    {
        this._flash = flash;
    } //-- void setFlash(com.tmk.kernel.site.Flash) 

    /**
     * Sets the value of field 'html'.
     * 
     * @param html the value of field 'html'.
     */
    public void setHtml(com.tmk.kernel.site.Html html)
    {
        this._html = html;
    } //-- void setHtml(com.tmk.kernel.site.Html) 

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

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Home unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Home) Unmarshaller.unmarshal(com.tmk.kernel.site.Home.class, reader);
    } //-- com.tmk.kernel.site.Home unmarshal(java.io.Reader) 

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
