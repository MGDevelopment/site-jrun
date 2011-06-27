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
 * Class Principal.
 * 
 * @version $Revision$ $Date$
 */
public class Principal implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _articulos
     */
    private com.tmk.kernel.site.Articulos _articulos;

    /**
     * Field _banner
     */
    private com.tmk.kernel.site.Banner _banner;


      //----------------/
     //- Constructors -/
    //----------------/

    public Principal() {
        super();
    } //-- com.tmk.kernel.site.Principal()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'articulos'.
     * 
     * @return the value of field 'articulos'.
     */
    public com.tmk.kernel.site.Articulos getArticulos()
    {
        return this._articulos;
    } //-- com.tmk.kernel.site.Articulos getArticulos() 

    /**
     * Returns the value of field 'banner'.
     * 
     * @return the value of field 'banner'.
     */
    public com.tmk.kernel.site.Banner getBanner()
    {
        return this._banner;
    } //-- com.tmk.kernel.site.Banner getBanner() 

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
     * Sets the value of field 'articulos'.
     * 
     * @param articulos the value of field 'articulos'.
     */
    public void setArticulos(com.tmk.kernel.site.Articulos articulos)
    {
        this._articulos = articulos;
    } //-- void setArticulos(com.tmk.kernel.site.Articulos) 

    /**
     * Sets the value of field 'banner'.
     * 
     * @param banner the value of field 'banner'.
     */
    public void setBanner(com.tmk.kernel.site.Banner banner)
    {
        this._banner = banner;
    } //-- void setBanner(com.tmk.kernel.site.Banner) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Principal unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Principal) Unmarshaller.unmarshal(com.tmk.kernel.site.Principal.class, reader);
    } //-- com.tmk.kernel.site.Principal unmarshal(java.io.Reader) 

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
