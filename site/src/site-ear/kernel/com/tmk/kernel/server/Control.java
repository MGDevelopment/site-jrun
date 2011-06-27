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
 * Class Control.
 * 
 * @version $Revision$ $Date$
 */
public class Control implements java.io.Serializable {


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
     * Field _iteraciones
     */
    private int _iteraciones;

    /**
     * keeps track of state for field: _iteraciones
     */
    private boolean _has_iteraciones;

    /**
     * Field _memoriaAlerta
     */
    private int _memoriaAlerta;

    /**
     * keeps track of state for field: _memoriaAlerta
     */
    private boolean _has_memoriaAlerta;

    /**
     * Field _memoriaMaxima
     */
    private int _memoriaMaxima;

    /**
     * keeps track of state for field: _memoriaMaxima
     */
    private boolean _has_memoriaMaxima;

    /**
     * Field _consola
     */
    private java.lang.String _consola;


      //----------------/
     //- Constructors -/
    //----------------/

    public Control() {
        super();
    } //-- com.tmk.kernel.server.Control()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'consola'.
     * 
     * @return the value of field 'consola'.
     */
    public java.lang.String getConsola()
    {
        return this._consola;
    } //-- java.lang.String getConsola() 

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
     * Returns the value of field 'iteraciones'.
     * 
     * @return the value of field 'iteraciones'.
     */
    public int getIteraciones()
    {
        return this._iteraciones;
    } //-- int getIteraciones() 

    /**
     * Returns the value of field 'memoriaAlerta'.
     * 
     * @return the value of field 'memoriaAlerta'.
     */
    public int getMemoriaAlerta()
    {
        return this._memoriaAlerta;
    } //-- int getMemoriaAlerta() 

    /**
     * Returns the value of field 'memoriaMaxima'.
     * 
     * @return the value of field 'memoriaMaxima'.
     */
    public int getMemoriaMaxima()
    {
        return this._memoriaMaxima;
    } //-- int getMemoriaMaxima() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasIteraciones
     */
    public boolean hasIteraciones()
    {
        return this._has_iteraciones;
    } //-- boolean hasIteraciones() 

    /**
     * Method hasMemoriaAlerta
     */
    public boolean hasMemoriaAlerta()
    {
        return this._has_memoriaAlerta;
    } //-- boolean hasMemoriaAlerta() 

    /**
     * Method hasMemoriaMaxima
     */
    public boolean hasMemoriaMaxima()
    {
        return this._has_memoriaMaxima;
    } //-- boolean hasMemoriaMaxima() 

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
     * Sets the value of field 'consola'.
     * 
     * @param consola the value of field 'consola'.
     */
    public void setConsola(java.lang.String consola)
    {
        this._consola = consola;
    } //-- void setConsola(java.lang.String) 

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
     * Sets the value of field 'iteraciones'.
     * 
     * @param iteraciones the value of field 'iteraciones'.
     */
    public void setIteraciones(int iteraciones)
    {
        this._iteraciones = iteraciones;
        this._has_iteraciones = true;
    } //-- void setIteraciones(int) 

    /**
     * Sets the value of field 'memoriaAlerta'.
     * 
     * @param memoriaAlerta the value of field 'memoriaAlerta'.
     */
    public void setMemoriaAlerta(int memoriaAlerta)
    {
        this._memoriaAlerta = memoriaAlerta;
        this._has_memoriaAlerta = true;
    } //-- void setMemoriaAlerta(int) 

    /**
     * Sets the value of field 'memoriaMaxima'.
     * 
     * @param memoriaMaxima the value of field 'memoriaMaxima'.
     */
    public void setMemoriaMaxima(int memoriaMaxima)
    {
        this._memoriaMaxima = memoriaMaxima;
        this._has_memoriaMaxima = true;
    } //-- void setMemoriaMaxima(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.Control unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.Control) Unmarshaller.unmarshal(com.tmk.kernel.server.Control.class, reader);
    } //-- com.tmk.kernel.server.Control unmarshal(java.io.Reader) 

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
