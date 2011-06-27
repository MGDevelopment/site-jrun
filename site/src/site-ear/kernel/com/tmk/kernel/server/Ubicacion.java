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
 * Class Ubicacion.
 * 
 * @version $Revision$ $Date$
 */
public class Ubicacion implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private java.lang.String _id;

    /**
     * Field _user
     */
    private java.lang.String _user;

    /**
     * Field _password
     */
    private java.lang.String _password;

    /**
     * Field _host
     */
    private java.lang.String _host;

    /**
     * Field _ip
     */
    private java.lang.String _ip;

    /**
     * Field _defaultDir
     */
    private java.lang.String _defaultDir;


      //----------------/
     //- Constructors -/
    //----------------/

    public Ubicacion() {
        super();
    } //-- com.tmk.kernel.server.Ubicacion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'defaultDir'.
     * 
     * @return the value of field 'defaultDir'.
     */
    public java.lang.String getDefaultDir()
    {
        return this._defaultDir;
    } //-- java.lang.String getDefaultDir() 

    /**
     * Returns the value of field 'host'.
     * 
     * @return the value of field 'host'.
     */
    public java.lang.String getHost()
    {
        return this._host;
    } //-- java.lang.String getHost() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'id'.
     */
    public java.lang.String getId()
    {
        return this._id;
    } //-- java.lang.String getId() 

    /**
     * Returns the value of field 'ip'.
     * 
     * @return the value of field 'ip'.
     */
    public java.lang.String getIp()
    {
        return this._ip;
    } //-- java.lang.String getIp() 

    /**
     * Returns the value of field 'password'.
     * 
     * @return the value of field 'password'.
     */
    public java.lang.String getPassword()
    {
        return this._password;
    } //-- java.lang.String getPassword() 

    /**
     * Returns the value of field 'user'.
     * 
     * @return the value of field 'user'.
     */
    public java.lang.String getUser()
    {
        return this._user;
    } //-- java.lang.String getUser() 

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
     * Sets the value of field 'defaultDir'.
     * 
     * @param defaultDir the value of field 'defaultDir'.
     */
    public void setDefaultDir(java.lang.String defaultDir)
    {
        this._defaultDir = defaultDir;
    } //-- void setDefaultDir(java.lang.String) 

    /**
     * Sets the value of field 'host'.
     * 
     * @param host the value of field 'host'.
     */
    public void setHost(java.lang.String host)
    {
        this._host = host;
    } //-- void setHost(java.lang.String) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(java.lang.String id)
    {
        this._id = id;
    } //-- void setId(java.lang.String) 

    /**
     * Sets the value of field 'ip'.
     * 
     * @param ip the value of field 'ip'.
     */
    public void setIp(java.lang.String ip)
    {
        this._ip = ip;
    } //-- void setIp(java.lang.String) 

    /**
     * Sets the value of field 'password'.
     * 
     * @param password the value of field 'password'.
     */
    public void setPassword(java.lang.String password)
    {
        this._password = password;
    } //-- void setPassword(java.lang.String) 

    /**
     * Sets the value of field 'user'.
     * 
     * @param user the value of field 'user'.
     */
    public void setUser(java.lang.String user)
    {
        this._user = user;
    } //-- void setUser(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Ubicacion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Ubicacion) Unmarshaller.unmarshal(com.tmk.kernel.server.Ubicacion.class, reader);
    } //-- com.tmk.kernel.server.Ubicacion unmarshal(java.io.Reader) 

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
