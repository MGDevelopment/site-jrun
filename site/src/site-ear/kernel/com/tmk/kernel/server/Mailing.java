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
 * Class Mailing.
 * 
 * @version $Revision$ $Date$
 */
public class Mailing implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _habilitado
     */
    private boolean _habilitado;

    /**
     * keeps track of state for field: _habilitado
     */
    private boolean _has_habilitado;

    /**
     * Field _mailer
     */
    private java.lang.String _mailer;

    /**
     * Field _smtpHost
     */
    private java.lang.String _smtpHost;

    /**
     * Field _webmasterMail
     */
    private java.lang.String _webmasterMail;

    /**
     * Field _serverMail
     */
    private java.lang.String _serverMail;

    /**
     * Field _mailLargos
     */
    private boolean _mailLargos;

    /**
     * keeps track of state for field: _mailLargos
     */
    private boolean _has_mailLargos;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mailing() {
        super();
    } //-- com.tmk.kernel.server.Mailing()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'habilitado'.
     * 
     * @return the value of field 'habilitado'.
     */
    public boolean getHabilitado()
    {
        return this._habilitado;
    } //-- boolean getHabilitado() 

    /**
     * Returns the value of field 'mailLargos'.
     * 
     * @return the value of field 'mailLargos'.
     */
    public boolean getMailLargos()
    {
        return this._mailLargos;
    } //-- boolean getMailLargos() 

    /**
     * Returns the value of field 'mailer'.
     * 
     * @return the value of field 'mailer'.
     */
    public java.lang.String getMailer()
    {
        return this._mailer;
    } //-- java.lang.String getMailer() 

    /**
     * Returns the value of field 'serverMail'.
     * 
     * @return the value of field 'serverMail'.
     */
    public java.lang.String getServerMail()
    {
        return this._serverMail;
    } //-- java.lang.String getServerMail() 

    /**
     * Returns the value of field 'smtpHost'.
     * 
     * @return the value of field 'smtpHost'.
     */
    public java.lang.String getSmtpHost()
    {
        return this._smtpHost;
    } //-- java.lang.String getSmtpHost() 

    /**
     * Returns the value of field 'webmasterMail'.
     * 
     * @return the value of field 'webmasterMail'.
     */
    public java.lang.String getWebmasterMail()
    {
        return this._webmasterMail;
    } //-- java.lang.String getWebmasterMail() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasMailLargos
     */
    public boolean hasMailLargos()
    {
        return this._has_mailLargos;
    } //-- boolean hasMailLargos() 

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
     * Sets the value of field 'habilitado'.
     * 
     * @param habilitado the value of field 'habilitado'.
     */
    public void setHabilitado(boolean habilitado)
    {
        this._habilitado = habilitado;
        this._has_habilitado = true;
    } //-- void setHabilitado(boolean) 

    /**
     * Sets the value of field 'mailLargos'.
     * 
     * @param mailLargos the value of field 'mailLargos'.
     */
    public void setMailLargos(boolean mailLargos)
    {
        this._mailLargos = mailLargos;
        this._has_mailLargos = true;
    } //-- void setMailLargos(boolean) 

    /**
     * Sets the value of field 'mailer'.
     * 
     * @param mailer the value of field 'mailer'.
     */
    public void setMailer(java.lang.String mailer)
    {
        this._mailer = mailer;
    } //-- void setMailer(java.lang.String) 

    /**
     * Sets the value of field 'serverMail'.
     * 
     * @param serverMail the value of field 'serverMail'.
     */
    public void setServerMail(java.lang.String serverMail)
    {
        this._serverMail = serverMail;
    } //-- void setServerMail(java.lang.String) 

    /**
     * Sets the value of field 'smtpHost'.
     * 
     * @param smtpHost the value of field 'smtpHost'.
     */
    public void setSmtpHost(java.lang.String smtpHost)
    {
        this._smtpHost = smtpHost;
    } //-- void setSmtpHost(java.lang.String) 

    /**
     * Sets the value of field 'webmasterMail'.
     * 
     * @param webmasterMail the value of field 'webmasterMail'.
     */
    public void setWebmasterMail(java.lang.String webmasterMail)
    {
        this._webmasterMail = webmasterMail;
    } //-- void setWebmasterMail(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Mailing unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Mailing) Unmarshaller.unmarshal(com.tmk.kernel.server.Mailing.class, reader);
    } //-- com.tmk.kernel.server.Mailing unmarshal(java.io.Reader) 

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
