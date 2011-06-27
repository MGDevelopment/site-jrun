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

import com.tmk.kernel.site.types.TipoUrlType;
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
 * Class Banner.
 * 
 * @version $Revision$ $Date$
 */
public class Banner implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _tipoUrl
     */
    private com.tmk.kernel.site.types.TipoUrlType _tipoUrl;

    /**
     * Field _url
     */
    private java.lang.String _url;


      //----------------/
     //- Constructors -/
    //----------------/

    public Banner() {
        super();
    } //-- com.tmk.kernel.site.Banner()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'tipoUrl'.
     * 
     * @return the value of field 'tipoUrl'.
     */
    public com.tmk.kernel.site.types.TipoUrlType getTipoUrl()
    {
        return this._tipoUrl;
    } //-- com.tmk.kernel.site.types.TipoUrlType getTipoUrl() 

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
     * Sets the value of field 'tipoUrl'.
     * 
     * @param tipoUrl the value of field 'tipoUrl'.
     */
    public void setTipoUrl(com.tmk.kernel.site.types.TipoUrlType tipoUrl)
    {
        this._tipoUrl = tipoUrl;
    } //-- void setTipoUrl(com.tmk.kernel.site.types.TipoUrlType) 

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
    public static com.tmk.kernel.site.Banner unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Banner) Unmarshaller.unmarshal(com.tmk.kernel.site.Banner.class, reader);
    } //-- com.tmk.kernel.site.Banner unmarshal(java.io.Reader) 

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
