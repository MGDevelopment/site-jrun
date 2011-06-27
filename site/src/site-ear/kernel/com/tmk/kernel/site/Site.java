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
 * Class Site.
 * 
 * @version $Revision$ $Date$
 */
public class Site implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _configuracion
     */
    private com.tmk.kernel.site.Configuracion _configuracion;

    /**
     * Field _paginas
     */
    private com.tmk.kernel.site.Paginas _paginas;

    /**
     * Field _papelesDeRegalo
     */
    private com.tmk.kernel.site.PapelesDeRegalo _papelesDeRegalo;

    /**
     * Field _listaDeDeseos
     */
    private com.tmk.kernel.site.ListaDeDeseos _listaDeDeseos;

    /**
     * Field _ranking
     */
    private com.tmk.kernel.site.Ranking _ranking;

    /**
     * Field _recorridoPorTemas
     */
    private com.tmk.kernel.site.RecorridoPorTemas _recorridoPorTemas;

    /**
     * Field _nuestrasCategorias
     */
    private com.tmk.kernel.site.NuestrasCategorias _nuestrasCategorias;

    /**
     * Field _eventos
     */
    private com.tmk.kernel.site.Eventos _eventos;

    /**
     * Field _cupones
     */
    private com.tmk.kernel.site.Cupones _cupones;


      //----------------/
     //- Constructors -/
    //----------------/

    public Site() {
        super();
    } //-- com.tmk.kernel.site.Site()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'configuracion'.
     * 
     * @return the value of field 'configuracion'.
     */
    public com.tmk.kernel.site.Configuracion getConfiguracion()
    {
        return this._configuracion;
    } //-- com.tmk.kernel.site.Configuracion getConfiguracion() 

    /**
     * Returns the value of field 'cupones'.
     * 
     * @return the value of field 'cupones'.
     */
    public com.tmk.kernel.site.Cupones getCupones()
    {
        return this._cupones;
    } //-- com.tmk.kernel.site.Cupones getCupones() 

    /**
     * Returns the value of field 'eventos'.
     * 
     * @return the value of field 'eventos'.
     */
    public com.tmk.kernel.site.Eventos getEventos()
    {
        return this._eventos;
    } //-- com.tmk.kernel.site.Eventos getEventos() 

    /**
     * Returns the value of field 'listaDeDeseos'.
     * 
     * @return the value of field 'listaDeDeseos'.
     */
    public com.tmk.kernel.site.ListaDeDeseos getListaDeDeseos()
    {
        return this._listaDeDeseos;
    } //-- com.tmk.kernel.site.ListaDeDeseos getListaDeDeseos() 

    /**
     * Returns the value of field 'nuestrasCategorias'.
     * 
     * @return the value of field 'nuestrasCategorias'.
     */
    public com.tmk.kernel.site.NuestrasCategorias getNuestrasCategorias()
    {
        return this._nuestrasCategorias;
    } //-- com.tmk.kernel.site.NuestrasCategorias getNuestrasCategorias() 

    /**
     * Returns the value of field 'paginas'.
     * 
     * @return the value of field 'paginas'.
     */
    public com.tmk.kernel.site.Paginas getPaginas()
    {
        return this._paginas;
    } //-- com.tmk.kernel.site.Paginas getPaginas() 

    /**
     * Returns the value of field 'papelesDeRegalo'.
     * 
     * @return the value of field 'papelesDeRegalo'.
     */
    public com.tmk.kernel.site.PapelesDeRegalo getPapelesDeRegalo()
    {
        return this._papelesDeRegalo;
    } //-- com.tmk.kernel.site.PapelesDeRegalo getPapelesDeRegalo() 

    /**
     * Returns the value of field 'ranking'.
     * 
     * @return the value of field 'ranking'.
     */
    public com.tmk.kernel.site.Ranking getRanking()
    {
        return this._ranking;
    } //-- com.tmk.kernel.site.Ranking getRanking() 

    /**
     * Returns the value of field 'recorridoPorTemas'.
     * 
     * @return the value of field 'recorridoPorTemas'.
     */
    public com.tmk.kernel.site.RecorridoPorTemas getRecorridoPorTemas()
    {
        return this._recorridoPorTemas;
    } //-- com.tmk.kernel.site.RecorridoPorTemas getRecorridoPorTemas() 

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
     * Sets the value of field 'configuracion'.
     * 
     * @param configuracion the value of field 'configuracion'.
     */
    public void setConfiguracion(com.tmk.kernel.site.Configuracion configuracion)
    {
        this._configuracion = configuracion;
    } //-- void setConfiguracion(com.tmk.kernel.site.Configuracion) 

    /**
     * Sets the value of field 'cupones'.
     * 
     * @param cupones the value of field 'cupones'.
     */
    public void setCupones(com.tmk.kernel.site.Cupones cupones)
    {
        this._cupones = cupones;
    } //-- void setCupones(com.tmk.kernel.site.Cupones) 

    /**
     * Sets the value of field 'eventos'.
     * 
     * @param eventos the value of field 'eventos'.
     */
    public void setEventos(com.tmk.kernel.site.Eventos eventos)
    {
        this._eventos = eventos;
    } //-- void setEventos(com.tmk.kernel.site.Eventos) 

    /**
     * Sets the value of field 'listaDeDeseos'.
     * 
     * @param listaDeDeseos the value of field 'listaDeDeseos'.
     */
    public void setListaDeDeseos(com.tmk.kernel.site.ListaDeDeseos listaDeDeseos)
    {
        this._listaDeDeseos = listaDeDeseos;
    } //-- void setListaDeDeseos(com.tmk.kernel.site.ListaDeDeseos) 

    /**
     * Sets the value of field 'nuestrasCategorias'.
     * 
     * @param nuestrasCategorias the value of field
     * 'nuestrasCategorias'.
     */
    public void setNuestrasCategorias(com.tmk.kernel.site.NuestrasCategorias nuestrasCategorias)
    {
        this._nuestrasCategorias = nuestrasCategorias;
    } //-- void setNuestrasCategorias(com.tmk.kernel.site.NuestrasCategorias) 

    /**
     * Sets the value of field 'paginas'.
     * 
     * @param paginas the value of field 'paginas'.
     */
    public void setPaginas(com.tmk.kernel.site.Paginas paginas)
    {
        this._paginas = paginas;
    } //-- void setPaginas(com.tmk.kernel.site.Paginas) 

    /**
     * Sets the value of field 'papelesDeRegalo'.
     * 
     * @param papelesDeRegalo the value of field 'papelesDeRegalo'.
     */
    public void setPapelesDeRegalo(com.tmk.kernel.site.PapelesDeRegalo papelesDeRegalo)
    {
        this._papelesDeRegalo = papelesDeRegalo;
    } //-- void setPapelesDeRegalo(com.tmk.kernel.site.PapelesDeRegalo) 

    /**
     * Sets the value of field 'ranking'.
     * 
     * @param ranking the value of field 'ranking'.
     */
    public void setRanking(com.tmk.kernel.site.Ranking ranking)
    {
        this._ranking = ranking;
    } //-- void setRanking(com.tmk.kernel.site.Ranking) 

    /**
     * Sets the value of field 'recorridoPorTemas'.
     * 
     * @param recorridoPorTemas the value of field
     * 'recorridoPorTemas'.
     */
    public void setRecorridoPorTemas(com.tmk.kernel.site.RecorridoPorTemas recorridoPorTemas)
    {
        this._recorridoPorTemas = recorridoPorTemas;
    } //-- void setRecorridoPorTemas(com.tmk.kernel.site.RecorridoPorTemas) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Site unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Site) Unmarshaller.unmarshal(com.tmk.kernel.site.Site.class, reader);
    } //-- com.tmk.kernel.site.Site unmarshal(java.io.Reader) 

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
