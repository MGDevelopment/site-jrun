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
 * Class MusicaOnLine.
 * 
 * @version $Revision$ $Date$
 */
public class MusicaOnLine implements java.io.Serializable {


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
     * Field _seccion
     */
    private int _seccion;

    /**
     * keeps track of state for field: _seccion
     */
    private boolean _has_seccion;

    /**
     * Field _grupo
     */
    private int _grupo;

    /**
     * keeps track of state for field: _grupo
     */
    private boolean _has_grupo;

    /**
     * Field _familia
     */
    private int _familia;

    /**
     * keeps track of state for field: _familia
     */
    private boolean _has_familia;

    /**
     * Field _subfamilia
     */
    private int _subfamilia;

    /**
     * keeps track of state for field: _subfamilia
     */
    private boolean _has_subfamilia;

    /**
     * Field _disponibilidad
     */
    private int _disponibilidad;

    /**
     * keeps track of state for field: _disponibilidad
     */
    private boolean _has_disponibilidad;


      //----------------/
     //- Constructors -/
    //----------------/

    public MusicaOnLine() {
        super();
    } //-- com.tmk.kernel.server.MusicaOnLine()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'disponibilidad'.
     * 
     * @return the value of field 'disponibilidad'.
     */
    public int getDisponibilidad()
    {
        return this._disponibilidad;
    } //-- int getDisponibilidad() 

    /**
     * Returns the value of field 'familia'.
     * 
     * @return the value of field 'familia'.
     */
    public int getFamilia()
    {
        return this._familia;
    } //-- int getFamilia() 

    /**
     * Returns the value of field 'grupo'.
     * 
     * @return the value of field 'grupo'.
     */
    public int getGrupo()
    {
        return this._grupo;
    } //-- int getGrupo() 

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
     * Returns the value of field 'seccion'.
     * 
     * @return the value of field 'seccion'.
     */
    public int getSeccion()
    {
        return this._seccion;
    } //-- int getSeccion() 

    /**
     * Returns the value of field 'subfamilia'.
     * 
     * @return the value of field 'subfamilia'.
     */
    public int getSubfamilia()
    {
        return this._subfamilia;
    } //-- int getSubfamilia() 

    /**
     * Method hasDisponibilidad
     */
    public boolean hasDisponibilidad()
    {
        return this._has_disponibilidad;
    } //-- boolean hasDisponibilidad() 

    /**
     * Method hasFamilia
     */
    public boolean hasFamilia()
    {
        return this._has_familia;
    } //-- boolean hasFamilia() 

    /**
     * Method hasGrupo
     */
    public boolean hasGrupo()
    {
        return this._has_grupo;
    } //-- boolean hasGrupo() 

    /**
     * Method hasHabilitado
     */
    public boolean hasHabilitado()
    {
        return this._has_habilitado;
    } //-- boolean hasHabilitado() 

    /**
     * Method hasSeccion
     */
    public boolean hasSeccion()
    {
        return this._has_seccion;
    } //-- boolean hasSeccion() 

    /**
     * Method hasSubfamilia
     */
    public boolean hasSubfamilia()
    {
        return this._has_subfamilia;
    } //-- boolean hasSubfamilia() 

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
     * Sets the value of field 'disponibilidad'.
     * 
     * @param disponibilidad the value of field 'disponibilidad'.
     */
    public void setDisponibilidad(int disponibilidad)
    {
        this._disponibilidad = disponibilidad;
        this._has_disponibilidad = true;
    } //-- void setDisponibilidad(int) 

    /**
     * Sets the value of field 'familia'.
     * 
     * @param familia the value of field 'familia'.
     */
    public void setFamilia(int familia)
    {
        this._familia = familia;
        this._has_familia = true;
    } //-- void setFamilia(int) 

    /**
     * Sets the value of field 'grupo'.
     * 
     * @param grupo the value of field 'grupo'.
     */
    public void setGrupo(int grupo)
    {
        this._grupo = grupo;
        this._has_grupo = true;
    } //-- void setGrupo(int) 

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
     * Sets the value of field 'seccion'.
     * 
     * @param seccion the value of field 'seccion'.
     */
    public void setSeccion(int seccion)
    {
        this._seccion = seccion;
        this._has_seccion = true;
    } //-- void setSeccion(int) 

    /**
     * Sets the value of field 'subfamilia'.
     * 
     * @param subfamilia the value of field 'subfamilia'.
     */
    public void setSubfamilia(int subfamilia)
    {
        this._subfamilia = subfamilia;
        this._has_subfamilia = true;
    } //-- void setSubfamilia(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.MusicaOnLine unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.MusicaOnLine) Unmarshaller.unmarshal(com.tmk.kernel.server.MusicaOnLine.class, reader);
    } //-- com.tmk.kernel.server.MusicaOnLine unmarshal(java.io.Reader) 

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
