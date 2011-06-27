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
 * Class BannerSuperior.
 * 
 * @version $Revision$ $Date$
 */
public class BannerSuperior implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _paginaFuente
     */
    private java.lang.String _paginaFuente;


      //----------------/
     //- Constructors -/
    //----------------/

    public BannerSuperior() {
        super();
    } //-- com.tmk.kernel.site.BannerSuperior()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'paginaFuente'.
     * 
     * @return the value of field 'paginaFuente'.
     */
    public java.lang.String getPaginaFuente()
    {
        return this._paginaFuente;
    } //-- java.lang.String getPaginaFuente() 

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
     * Sets the value of field 'paginaFuente'.
     * 
     * @param paginaFuente the value of field 'paginaFuente'.
     */
    public void setPaginaFuente(java.lang.String paginaFuente)
    {
        this._paginaFuente = paginaFuente;
    } //-- void setPaginaFuente(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.BannerSuperior unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.BannerSuperior) Unmarshaller.unmarshal(com.tmk.kernel.site.BannerSuperior.class, reader);
    } //-- com.tmk.kernel.site.BannerSuperior unmarshal(java.io.Reader) 

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
