/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.server;

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
 * Class Generacion.
 * 
 * @version $Revision$ $Date$
 */
public class Generacion implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _sentenciaDeMapeo
     */
    private java.lang.String _sentenciaDeMapeo;

    /**
     * Field _directorioDeGeneracion
     */
    private java.lang.String _directorioDeGeneracion;

    /**
     * Field _directorioRaiz
     */
    private java.lang.String _directorioRaiz;

    /**
     * Field _sentenciaDeDesMapeo
     */
    private java.lang.String _sentenciaDeDesMapeo;

    /**
     * Field _url
     */
    private java.lang.String _url;


      //----------------/
     //- Constructors -/
    //----------------/

    public Generacion() {
        super();
    } //-- com.tmk.kernel.server.Generacion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'directorioDeGeneracion'.
     * 
     * @return the value of field 'directorioDeGeneracion'.
     */
    public java.lang.String getDirectorioDeGeneracion()
    {
        return this._directorioDeGeneracion;
    } //-- java.lang.String getDirectorioDeGeneracion() 

    /**
     * Returns the value of field 'directorioRaiz'.
     * 
     * @return the value of field 'directorioRaiz'.
     */
    public java.lang.String getDirectorioRaiz()
    {
        return this._directorioRaiz;
    } //-- java.lang.String getDirectorioRaiz() 

    /**
     * Returns the value of field 'sentenciaDeDesMapeo'.
     * 
     * @return the value of field 'sentenciaDeDesMapeo'.
     */
    public java.lang.String getSentenciaDeDesMapeo()
    {
        return this._sentenciaDeDesMapeo;
    } //-- java.lang.String getSentenciaDeDesMapeo() 

    /**
     * Returns the value of field 'sentenciaDeMapeo'.
     * 
     * @return the value of field 'sentenciaDeMapeo'.
     */
    public java.lang.String getSentenciaDeMapeo()
    {
        return this._sentenciaDeMapeo;
    } //-- java.lang.String getSentenciaDeMapeo() 

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
     * Sets the value of field 'directorioDeGeneracion'.
     * 
     * @param directorioDeGeneracion the value of field
     * 'directorioDeGeneracion'.
     */
    public void setDirectorioDeGeneracion(java.lang.String directorioDeGeneracion)
    {
        this._directorioDeGeneracion = directorioDeGeneracion;
    } //-- void setDirectorioDeGeneracion(java.lang.String) 

    /**
     * Sets the value of field 'directorioRaiz'.
     * 
     * @param directorioRaiz the value of field 'directorioRaiz'.
     */
    public void setDirectorioRaiz(java.lang.String directorioRaiz)
    {
        this._directorioRaiz = directorioRaiz;
    } //-- void setDirectorioRaiz(java.lang.String) 

    /**
     * Sets the value of field 'sentenciaDeDesMapeo'.
     * 
     * @param sentenciaDeDesMapeo the value of field
     * 'sentenciaDeDesMapeo'.
     */
    public void setSentenciaDeDesMapeo(java.lang.String sentenciaDeDesMapeo)
    {
        this._sentenciaDeDesMapeo = sentenciaDeDesMapeo;
    } //-- void setSentenciaDeDesMapeo(java.lang.String) 

    /**
     * Sets the value of field 'sentenciaDeMapeo'.
     * 
     * @param sentenciaDeMapeo the value of field 'sentenciaDeMapeo'
     */
    public void setSentenciaDeMapeo(java.lang.String sentenciaDeMapeo)
    {
        this._sentenciaDeMapeo = sentenciaDeMapeo;
    } //-- void setSentenciaDeMapeo(java.lang.String) 

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
    public static com.tmk.kernel.server.Generacion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Generacion) Unmarshaller.unmarshal(com.tmk.kernel.server.Generacion.class, reader);
    } //-- com.tmk.kernel.server.Generacion unmarshal(java.io.Reader) 

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
