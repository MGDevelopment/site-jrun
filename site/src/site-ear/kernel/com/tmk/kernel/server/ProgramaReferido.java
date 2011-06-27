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
 * Class ProgramaReferido.
 * 
 * @version $Revision$ $Date$
 */
public class ProgramaReferido implements java.io.Serializable {


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
     * Field _vigenciaReferente
     */
    private int _vigenciaReferente;

    /**
     * keeps track of state for field: _vigenciaReferente
     */
    private boolean _has_vigenciaReferente;

    /**
     * Field _vigenciaReferido
     */
    private int _vigenciaReferido;

    /**
     * keeps track of state for field: _vigenciaReferido
     */
    private boolean _has_vigenciaReferido;


      //----------------/
     //- Constructors -/
    //----------------/

    public ProgramaReferido() {
        super();
    } //-- com.tmk.kernel.server.ProgramaReferido()


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
     * Returns the value of field 'vigenciaReferente'.
     * 
     * @return the value of field 'vigenciaReferente'.
     */
    public int getVigenciaReferente()
    {
        return this._vigenciaReferente;
    } //-- int getVigenciaReferente() 

    /**
     * Returns the value of field 'vigenciaReferido'.
     * 
     * @return the value of field 'vigenciaReferido'.
     */
    public int getVigenciaReferido()
    {
        return this._vigenciaReferido;
    } //-- int getVigenciaReferido() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasVigenciaReferente
     */
    public boolean hasVigenciaReferente()
    {
        return this._has_vigenciaReferente;
    } //-- boolean hasVigenciaReferente() 

    /**
     * Method hasVigenciaReferido
     */
    public boolean hasVigenciaReferido()
    {
        return this._has_vigenciaReferido;
    } //-- boolean hasVigenciaReferido() 

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
     * Sets the value of field 'vigenciaReferente'.
     * 
     * @param vigenciaReferente the value of field
     * 'vigenciaReferente'.
     */
    public void setVigenciaReferente(int vigenciaReferente)
    {
        this._vigenciaReferente = vigenciaReferente;
        this._has_vigenciaReferente = true;
    } //-- void setVigenciaReferente(int) 

    /**
     * Sets the value of field 'vigenciaReferido'.
     * 
     * @param vigenciaReferido the value of field 'vigenciaReferido'
     */
    public void setVigenciaReferido(int vigenciaReferido)
    {
        this._vigenciaReferido = vigenciaReferido;
        this._has_vigenciaReferido = true;
    } //-- void setVigenciaReferido(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.ProgramaReferido unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.ProgramaReferido) Unmarshaller.unmarshal(com.tmk.kernel.server.ProgramaReferido.class, reader);
    } //-- com.tmk.kernel.server.ProgramaReferido unmarshal(java.io.Reader) 

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
