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

import com.tmk.kernel.site.types.PosicionesType;
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
 * Class Pagina.
 * 
 * @version $Revision$ $Date$
 */
public class Pagina extends com.tmk.kernel.site.PaginaType 
implements java.io.Serializable
{


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _posicionMarcaChica
     */
    private com.tmk.kernel.site.types.PosicionesType _posicionMarcaChica;

    /**
     * Field _posicionMarcaGrande
     */
    private com.tmk.kernel.site.types.PosicionesType _posicionMarcaGrande;

    /**
     * Field _porcentajeAlphaMarca
     */
    private int _porcentajeAlphaMarca = 100;

    /**
     * keeps track of state for field: _porcentajeAlphaMarca
     */
    private boolean _has_porcentajeAlphaMarca;

    /**
     * Field _posicionDescuentoChico
     */
    private com.tmk.kernel.site.types.PosicionesType _posicionDescuentoChico;

    /**
     * Field _posicionDescuentoGrande
     */
    private com.tmk.kernel.site.types.PosicionesType _posicionDescuentoGrande;

    /**
     * Field _porcentajeAlphaDescuento
     */
    private int _porcentajeAlphaDescuento = 100;

    /**
     * keeps track of state for field: _porcentajeAlphaDescuento
     */
    private boolean _has_porcentajeAlphaDescuento;


      //----------------/
     //- Constructors -/
    //----------------/

    public Pagina() {
        super();
    } //-- com.tmk.kernel.site.Pagina()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method deletePorcentajeAlphaDescuento
     */
    public void deletePorcentajeAlphaDescuento()
    {
        this._has_porcentajeAlphaDescuento= false;
    } //-- void deletePorcentajeAlphaDescuento() 

    /**
     * Method deletePorcentajeAlphaMarca
     */
    public void deletePorcentajeAlphaMarca()
    {
        this._has_porcentajeAlphaMarca= false;
    } //-- void deletePorcentajeAlphaMarca() 

    /**
     * Returns the value of field 'porcentajeAlphaDescuento'.
     * 
     * @return the value of field 'porcentajeAlphaDescuento'.
     */
    public int getPorcentajeAlphaDescuento()
    {
        return this._porcentajeAlphaDescuento;
    } //-- int getPorcentajeAlphaDescuento() 

    /**
     * Returns the value of field 'porcentajeAlphaMarca'.
     * 
     * @return the value of field 'porcentajeAlphaMarca'.
     */
    public int getPorcentajeAlphaMarca()
    {
        return this._porcentajeAlphaMarca;
    } //-- int getPorcentajeAlphaMarca() 

    /**
     * Returns the value of field 'posicionDescuentoChico'.
     * 
     * @return the value of field 'posicionDescuentoChico'.
     */
    public com.tmk.kernel.site.types.PosicionesType getPosicionDescuentoChico()
    {
        return this._posicionDescuentoChico;
    } //-- com.tmk.kernel.site.types.PosicionesType getPosicionDescuentoChico() 

    /**
     * Returns the value of field 'posicionDescuentoGrande'.
     * 
     * @return the value of field 'posicionDescuentoGrande'.
     */
    public com.tmk.kernel.site.types.PosicionesType getPosicionDescuentoGrande()
    {
        return this._posicionDescuentoGrande;
    } //-- com.tmk.kernel.site.types.PosicionesType getPosicionDescuentoGrande() 

    /**
     * Returns the value of field 'posicionMarcaChica'.
     * 
     * @return the value of field 'posicionMarcaChica'.
     */
    public com.tmk.kernel.site.types.PosicionesType getPosicionMarcaChica()
    {
        return this._posicionMarcaChica;
    } //-- com.tmk.kernel.site.types.PosicionesType getPosicionMarcaChica() 

    /**
     * Returns the value of field 'posicionMarcaGrande'.
     * 
     * @return the value of field 'posicionMarcaGrande'.
     */
    public com.tmk.kernel.site.types.PosicionesType getPosicionMarcaGrande()
    {
        return this._posicionMarcaGrande;
    } //-- com.tmk.kernel.site.types.PosicionesType getPosicionMarcaGrande() 

    /**
     * Method hasPorcentajeAlphaDescuento
     */
    public boolean hasPorcentajeAlphaDescuento()
    {
        return this._has_porcentajeAlphaDescuento;
    } //-- boolean hasPorcentajeAlphaDescuento() 

    /**
     * Method hasPorcentajeAlphaMarca
     */
    public boolean hasPorcentajeAlphaMarca()
    {
        return this._has_porcentajeAlphaMarca;
    } //-- boolean hasPorcentajeAlphaMarca() 

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
     * Sets the value of field 'porcentajeAlphaDescuento'.
     * 
     * @param porcentajeAlphaDescuento the value of field
     * 'porcentajeAlphaDescuento'.
     */
    public void setPorcentajeAlphaDescuento(int porcentajeAlphaDescuento)
    {
        this._porcentajeAlphaDescuento = porcentajeAlphaDescuento;
        this._has_porcentajeAlphaDescuento = true;
    } //-- void setPorcentajeAlphaDescuento(int) 

    /**
     * Sets the value of field 'porcentajeAlphaMarca'.
     * 
     * @param porcentajeAlphaMarca the value of field
     * 'porcentajeAlphaMarca'.
     */
    public void setPorcentajeAlphaMarca(int porcentajeAlphaMarca)
    {
        this._porcentajeAlphaMarca = porcentajeAlphaMarca;
        this._has_porcentajeAlphaMarca = true;
    } //-- void setPorcentajeAlphaMarca(int) 

    /**
     * Sets the value of field 'posicionDescuentoChico'.
     * 
     * @param posicionDescuentoChico the value of field
     * 'posicionDescuentoChico'.
     */
    public void setPosicionDescuentoChico(com.tmk.kernel.site.types.PosicionesType posicionDescuentoChico)
    {
        this._posicionDescuentoChico = posicionDescuentoChico;
    } //-- void setPosicionDescuentoChico(com.tmk.kernel.site.types.PosicionesType) 

    /**
     * Sets the value of field 'posicionDescuentoGrande'.
     * 
     * @param posicionDescuentoGrande the value of field
     * 'posicionDescuentoGrande'.
     */
    public void setPosicionDescuentoGrande(com.tmk.kernel.site.types.PosicionesType posicionDescuentoGrande)
    {
        this._posicionDescuentoGrande = posicionDescuentoGrande;
    } //-- void setPosicionDescuentoGrande(com.tmk.kernel.site.types.PosicionesType) 

    /**
     * Sets the value of field 'posicionMarcaChica'.
     * 
     * @param posicionMarcaChica the value of field
     * 'posicionMarcaChica'.
     */
    public void setPosicionMarcaChica(com.tmk.kernel.site.types.PosicionesType posicionMarcaChica)
    {
        this._posicionMarcaChica = posicionMarcaChica;
    } //-- void setPosicionMarcaChica(com.tmk.kernel.site.types.PosicionesType) 

    /**
     * Sets the value of field 'posicionMarcaGrande'.
     * 
     * @param posicionMarcaGrande the value of field
     * 'posicionMarcaGrande'.
     */
    public void setPosicionMarcaGrande(com.tmk.kernel.site.types.PosicionesType posicionMarcaGrande)
    {
        this._posicionMarcaGrande = posicionMarcaGrande;
    } //-- void setPosicionMarcaGrande(com.tmk.kernel.site.types.PosicionesType) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Pagina unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Pagina) Unmarshaller.unmarshal(com.tmk.kernel.site.Pagina.class, reader);
    } //-- com.tmk.kernel.site.Pagina unmarshal(java.io.Reader) 

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
