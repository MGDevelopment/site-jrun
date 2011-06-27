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
 * Class Correcciones.
 * 
 * @version $Revision$ $Date$
 */
public class Correcciones implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mejorarTextos
     */
    private boolean _mejorarTextos;

    /**
     * keeps track of state for field: _mejorarTextos
     */
    private boolean _has_mejorarTextos;

    /**
     * Field _minusculizar
     */
    private com.tmk.kernel.site.Minusculizar _minusculizar;

    /**
     * Field _mayusculizar
     */
    private com.tmk.kernel.site.Mayusculizar _mayusculizar;

    /**
     * Field _puntuacion
     */
    private com.tmk.kernel.site.Puntuacion _puntuacion;

    /**
     * Field _articulacion
     */
    private com.tmk.kernel.site.Articulacion _articulacion;


      //----------------/
     //- Constructors -/
    //----------------/

    public Correcciones() {
        super();
    } //-- com.tmk.kernel.site.Correcciones()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'articulacion'.
     * 
     * @return the value of field 'articulacion'.
     */
    public com.tmk.kernel.site.Articulacion getArticulacion()
    {
        return this._articulacion;
    } //-- com.tmk.kernel.site.Articulacion getArticulacion() 

    /**
     * Returns the value of field 'mayusculizar'.
     * 
     * @return the value of field 'mayusculizar'.
     */
    public com.tmk.kernel.site.Mayusculizar getMayusculizar()
    {
        return this._mayusculizar;
    } //-- com.tmk.kernel.site.Mayusculizar getMayusculizar() 

    /**
     * Returns the value of field 'mejorarTextos'.
     * 
     * @return the value of field 'mejorarTextos'.
     */
    public boolean getMejorarTextos()
    {
        return this._mejorarTextos;
    } //-- boolean getMejorarTextos() 

    /**
     * Returns the value of field 'minusculizar'.
     * 
     * @return the value of field 'minusculizar'.
     */
    public com.tmk.kernel.site.Minusculizar getMinusculizar()
    {
        return this._minusculizar;
    } //-- com.tmk.kernel.site.Minusculizar getMinusculizar() 

    /**
     * Returns the value of field 'puntuacion'.
     * 
     * @return the value of field 'puntuacion'.
     */
    public com.tmk.kernel.site.Puntuacion getPuntuacion()
    {
        return this._puntuacion;
    } //-- com.tmk.kernel.site.Puntuacion getPuntuacion() 

    /**
     * Method hasMejorarTextos
     */
    public boolean hasMejorarTextos()
    {
        return this._has_mejorarTextos;
    } //-- boolean hasMejorarTextos() 

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
     * Sets the value of field 'articulacion'.
     * 
     * @param articulacion the value of field 'articulacion'.
     */
    public void setArticulacion(com.tmk.kernel.site.Articulacion articulacion)
    {
        this._articulacion = articulacion;
    } //-- void setArticulacion(com.tmk.kernel.site.Articulacion) 

    /**
     * Sets the value of field 'mayusculizar'.
     * 
     * @param mayusculizar the value of field 'mayusculizar'.
     */
    public void setMayusculizar(com.tmk.kernel.site.Mayusculizar mayusculizar)
    {
        this._mayusculizar = mayusculizar;
    } //-- void setMayusculizar(com.tmk.kernel.site.Mayusculizar) 

    /**
     * Sets the value of field 'mejorarTextos'.
     * 
     * @param mejorarTextos the value of field 'mejorarTextos'.
     */
    public void setMejorarTextos(boolean mejorarTextos)
    {
        this._mejorarTextos = mejorarTextos;
        this._has_mejorarTextos = true;
    } //-- void setMejorarTextos(boolean) 

    /**
     * Sets the value of field 'minusculizar'.
     * 
     * @param minusculizar the value of field 'minusculizar'.
     */
    public void setMinusculizar(com.tmk.kernel.site.Minusculizar minusculizar)
    {
        this._minusculizar = minusculizar;
    } //-- void setMinusculizar(com.tmk.kernel.site.Minusculizar) 

    /**
     * Sets the value of field 'puntuacion'.
     * 
     * @param puntuacion the value of field 'puntuacion'.
     */
    public void setPuntuacion(com.tmk.kernel.site.Puntuacion puntuacion)
    {
        this._puntuacion = puntuacion;
    } //-- void setPuntuacion(com.tmk.kernel.site.Puntuacion) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Correcciones unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Correcciones) Unmarshaller.unmarshal(com.tmk.kernel.site.Correcciones.class, reader);
    } //-- com.tmk.kernel.site.Correcciones unmarshal(java.io.Reader) 

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
