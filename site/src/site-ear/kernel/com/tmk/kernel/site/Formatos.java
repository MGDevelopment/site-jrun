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
 * Class Formatos.
 * 
 * @version $Revision$ $Date$
 */
public class Formatos implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _fechaCorto
     */
    private java.lang.String _fechaCorto;

    /**
     * Field _fechaLargo
     */
    private java.lang.String _fechaLargo;

    /**
     * Field _fechaPublicacion
     */
    private java.lang.String _fechaPublicacion;

    /**
     * Field _porcentaje
     */
    private java.lang.String _porcentaje;

    /**
     * Field _monedaPeso
     */
    private java.lang.String _monedaPeso;

    /**
     * Field _monedaDollar
     */
    private java.lang.String _monedaDollar;

    /**
     * Field _monedaEuro
     */
    private java.lang.String _monedaEuro;


      //----------------/
     //- Constructors -/
    //----------------/

    public Formatos() {
        super();
    } //-- com.tmk.kernel.site.Formatos()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'fechaCorto'.
     * 
     * @return the value of field 'fechaCorto'.
     */
    public java.lang.String getFechaCorto()
    {
        return this._fechaCorto;
    } //-- java.lang.String getFechaCorto() 

    /**
     * Returns the value of field 'fechaLargo'.
     * 
     * @return the value of field 'fechaLargo'.
     */
    public java.lang.String getFechaLargo()
    {
        return this._fechaLargo;
    } //-- java.lang.String getFechaLargo() 

    /**
     * Returns the value of field 'fechaPublicacion'.
     * 
     * @return the value of field 'fechaPublicacion'.
     */
    public java.lang.String getFechaPublicacion()
    {
        return this._fechaPublicacion;
    } //-- java.lang.String getFechaPublicacion() 

    /**
     * Returns the value of field 'monedaDollar'.
     * 
     * @return the value of field 'monedaDollar'.
     */
    public java.lang.String getMonedaDollar()
    {
        return this._monedaDollar;
    } //-- java.lang.String getMonedaDollar() 

    /**
     * Returns the value of field 'monedaEuro'.
     * 
     * @return the value of field 'monedaEuro'.
     */
    public java.lang.String getMonedaEuro()
    {
        return this._monedaEuro;
    } //-- java.lang.String getMonedaEuro() 

    /**
     * Returns the value of field 'monedaPeso'.
     * 
     * @return the value of field 'monedaPeso'.
     */
    public java.lang.String getMonedaPeso()
    {
        return this._monedaPeso;
    } //-- java.lang.String getMonedaPeso() 

    /**
     * Returns the value of field 'porcentaje'.
     * 
     * @return the value of field 'porcentaje'.
     */
    public java.lang.String getPorcentaje()
    {
        return this._porcentaje;
    } //-- java.lang.String getPorcentaje() 

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
     * Sets the value of field 'fechaCorto'.
     * 
     * @param fechaCorto the value of field 'fechaCorto'.
     */
    public void setFechaCorto(java.lang.String fechaCorto)
    {
        this._fechaCorto = fechaCorto;
    } //-- void setFechaCorto(java.lang.String) 

    /**
     * Sets the value of field 'fechaLargo'.
     * 
     * @param fechaLargo the value of field 'fechaLargo'.
     */
    public void setFechaLargo(java.lang.String fechaLargo)
    {
        this._fechaLargo = fechaLargo;
    } //-- void setFechaLargo(java.lang.String) 

    /**
     * Sets the value of field 'fechaPublicacion'.
     * 
     * @param fechaPublicacion the value of field 'fechaPublicacion'
     */
    public void setFechaPublicacion(java.lang.String fechaPublicacion)
    {
        this._fechaPublicacion = fechaPublicacion;
    } //-- void setFechaPublicacion(java.lang.String) 

    /**
     * Sets the value of field 'monedaDollar'.
     * 
     * @param monedaDollar the value of field 'monedaDollar'.
     */
    public void setMonedaDollar(java.lang.String monedaDollar)
    {
        this._monedaDollar = monedaDollar;
    } //-- void setMonedaDollar(java.lang.String) 

    /**
     * Sets the value of field 'monedaEuro'.
     * 
     * @param monedaEuro the value of field 'monedaEuro'.
     */
    public void setMonedaEuro(java.lang.String monedaEuro)
    {
        this._monedaEuro = monedaEuro;
    } //-- void setMonedaEuro(java.lang.String) 

    /**
     * Sets the value of field 'monedaPeso'.
     * 
     * @param monedaPeso the value of field 'monedaPeso'.
     */
    public void setMonedaPeso(java.lang.String monedaPeso)
    {
        this._monedaPeso = monedaPeso;
    } //-- void setMonedaPeso(java.lang.String) 

    /**
     * Sets the value of field 'porcentaje'.
     * 
     * @param porcentaje the value of field 'porcentaje'.
     */
    public void setPorcentaje(java.lang.String porcentaje)
    {
        this._porcentaje = porcentaje;
    } //-- void setPorcentaje(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Formatos unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Formatos) Unmarshaller.unmarshal(com.tmk.kernel.site.Formatos.class, reader);
    } //-- com.tmk.kernel.site.Formatos unmarshal(java.io.Reader) 

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
