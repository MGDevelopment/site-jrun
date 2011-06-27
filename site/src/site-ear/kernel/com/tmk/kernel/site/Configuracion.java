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
 * Class Configuracion.
 * 
 * @version $Revision$ $Date$
 */
public class Configuracion implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _logo
     */
    private java.lang.String _logo;

    /**
     * Field _mensajeLogo
     */
    private java.lang.String _mensajeLogo;

    /**
     * Field _vigenciaDelCarritoEnDias
     */
    private int _vigenciaDelCarritoEnDias;

    /**
     * keeps track of state for field: _vigenciaDelCarritoEnDias
     */
    private boolean _has_vigenciaDelCarritoEnDias;

    /**
     * Field _generarTapasProtegidas
     */
    private boolean _generarTapasProtegidas;

    /**
     * keeps track of state for field: _generarTapasProtegidas
     */
    private boolean _has_generarTapasProtegidas;

    /**
     * Field _vigenciaTapasProtegidas
     */
    private int _vigenciaTapasProtegidas;

    /**
     * keeps track of state for field: _vigenciaTapasProtegidas
     */
    private boolean _has_vigenciaTapasProtegidas;

    /**
     * Field _diasConsideradosNovedad
     */
    private int _diasConsideradosNovedad;

    /**
     * keeps track of state for field: _diasConsideradosNovedad
     */
    private boolean _has_diasConsideradosNovedad;

    /**
     * Field _diasIgnoradosNovedad
     */
    private int _diasIgnoradosNovedad;

    /**
     * keeps track of state for field: _diasIgnoradosNovedad
     */
    private boolean _has_diasIgnoradosNovedad;

    /**
     * Field _solapasEnMultilinea
     */
    private boolean _solapasEnMultilinea;

    /**
     * keeps track of state for field: _solapasEnMultilinea
     */
    private boolean _has_solapasEnMultilinea;

    /**
     * Field _flash
     */
    private com.tmk.kernel.site.Flash _flash;

    /**
     * Field _formatos
     */
    private com.tmk.kernel.site.Formatos _formatos;

    /**
     * Field _administrador
     */
    private com.tmk.kernel.site.Administrador _administrador;

    /**
     * Field _callCenter
     */
    private com.tmk.kernel.site.CallCenter _callCenter;

    /**
     * Field _alianzas
     */
    private com.tmk.kernel.site.Alianzas _alianzas;

    /**
     * Field _ofertaDeTrabajo
     */
    private com.tmk.kernel.site.OfertaDeTrabajo _ofertaDeTrabajo;

    /**
     * Field _reporteDeContenido
     */
    private com.tmk.kernel.site.ReporteDeContenido _reporteDeContenido;

    /**
     * Field _reporteDePedidosEspeciales
     */
    private com.tmk.kernel.site.ReporteDePedidosEspeciales _reporteDePedidosEspeciales;

    /**
     * Field _reporteDeOrdenes
     */
    private com.tmk.kernel.site.ReporteDeOrdenes _reporteDeOrdenes;

    /**
     * Field _reporteDeEstadoDeOrden
     */
    private com.tmk.kernel.site.ReporteDeEstadoDeOrden _reporteDeEstadoDeOrden;

    /**
     * Field _reporteDeVisitas
     */
    private com.tmk.kernel.site.ReporteDeVisitas _reporteDeVisitas;

    /**
     * Field _reporteDeClientesInstitucionales
     */
    private com.tmk.kernel.site.ReporteDeClientesInstitucionales _reporteDeClientesInstitucionales;

    /**
     * Field _reporteDeSocios
     */
    private com.tmk.kernel.site.ReporteDeSocios _reporteDeSocios;

    /**
     * Field _tarjetasVerificadas
     */
    private com.tmk.kernel.site.TarjetasVerificadas _tarjetasVerificadas;

    /**
     * Field _alertaRegistracionConDocDuplicado
     */
    private com.tmk.kernel.site.AlertaRegistracionConDocDuplicado _alertaRegistracionConDocDuplicado;

    /**
     * Field _correcciones
     */
    private com.tmk.kernel.site.Correcciones _correcciones;

    /**
     * Field _encuestas
     */
    private com.tmk.kernel.site.Encuestas _encuestas;


      //----------------/
     //- Constructors -/
    //----------------/

    public Configuracion() {
        super();
    } //-- com.tmk.kernel.site.Configuracion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'administrador'.
     * 
     * @return the value of field 'administrador'.
     */
    public com.tmk.kernel.site.Administrador getAdministrador()
    {
        return this._administrador;
    } //-- com.tmk.kernel.site.Administrador getAdministrador() 

    /**
     * Returns the value of field
     * 'alertaRegistracionConDocDuplicado'.
     * 
     * @return the value of field
     * 'alertaRegistracionConDocDuplicado'.
     */
    public com.tmk.kernel.site.AlertaRegistracionConDocDuplicado getAlertaRegistracionConDocDuplicado()
    {
        return this._alertaRegistracionConDocDuplicado;
    } //-- com.tmk.kernel.site.AlertaRegistracionConDocDuplicado getAlertaRegistracionConDocDuplicado() 

    /**
     * Returns the value of field 'alianzas'.
     * 
     * @return the value of field 'alianzas'.
     */
    public com.tmk.kernel.site.Alianzas getAlianzas()
    {
        return this._alianzas;
    } //-- com.tmk.kernel.site.Alianzas getAlianzas() 

    /**
     * Returns the value of field 'callCenter'.
     * 
     * @return the value of field 'callCenter'.
     */
    public com.tmk.kernel.site.CallCenter getCallCenter()
    {
        return this._callCenter;
    } //-- com.tmk.kernel.site.CallCenter getCallCenter() 

    /**
     * Returns the value of field 'correcciones'.
     * 
     * @return the value of field 'correcciones'.
     */
    public com.tmk.kernel.site.Correcciones getCorrecciones()
    {
        return this._correcciones;
    } //-- com.tmk.kernel.site.Correcciones getCorrecciones() 

    /**
     * Returns the value of field 'diasConsideradosNovedad'.
     * 
     * @return the value of field 'diasConsideradosNovedad'.
     */
    public int getDiasConsideradosNovedad()
    {
        return this._diasConsideradosNovedad;
    } //-- int getDiasConsideradosNovedad() 

    /**
     * Returns the value of field 'diasIgnoradosNovedad'.
     * 
     * @return the value of field 'diasIgnoradosNovedad'.
     */
    public int getDiasIgnoradosNovedad()
    {
        return this._diasIgnoradosNovedad;
    } //-- int getDiasIgnoradosNovedad() 

    /**
     * Returns the value of field 'encuestas'.
     * 
     * @return the value of field 'encuestas'.
     */
    public com.tmk.kernel.site.Encuestas getEncuestas()
    {
        return this._encuestas;
    } //-- com.tmk.kernel.site.Encuestas getEncuestas() 

    /**
     * Returns the value of field 'flash'.
     * 
     * @return the value of field 'flash'.
     */
    public com.tmk.kernel.site.Flash getFlash()
    {
        return this._flash;
    } //-- com.tmk.kernel.site.Flash getFlash() 

    /**
     * Returns the value of field 'formatos'.
     * 
     * @return the value of field 'formatos'.
     */
    public com.tmk.kernel.site.Formatos getFormatos()
    {
        return this._formatos;
    } //-- com.tmk.kernel.site.Formatos getFormatos() 

    /**
     * Returns the value of field 'generarTapasProtegidas'.
     * 
     * @return the value of field 'generarTapasProtegidas'.
     */
    public boolean getGenerarTapasProtegidas()
    {
        return this._generarTapasProtegidas;
    } //-- boolean getGenerarTapasProtegidas() 

    /**
     * Returns the value of field 'logo'.
     * 
     * @return the value of field 'logo'.
     */
    public java.lang.String getLogo()
    {
        return this._logo;
    } //-- java.lang.String getLogo() 

    /**
     * Returns the value of field 'mensajeLogo'.
     * 
     * @return the value of field 'mensajeLogo'.
     */
    public java.lang.String getMensajeLogo()
    {
        return this._mensajeLogo;
    } //-- java.lang.String getMensajeLogo() 

    /**
     * Returns the value of field 'ofertaDeTrabajo'.
     * 
     * @return the value of field 'ofertaDeTrabajo'.
     */
    public com.tmk.kernel.site.OfertaDeTrabajo getOfertaDeTrabajo()
    {
        return this._ofertaDeTrabajo;
    } //-- com.tmk.kernel.site.OfertaDeTrabajo getOfertaDeTrabajo() 

    /**
     * Returns the value of field
     * 'reporteDeClientesInstitucionales'.
     * 
     * @return the value of field 'reporteDeClientesInstitucionales'
     */
    public com.tmk.kernel.site.ReporteDeClientesInstitucionales getReporteDeClientesInstitucionales()
    {
        return this._reporteDeClientesInstitucionales;
    } //-- com.tmk.kernel.site.ReporteDeClientesInstitucionales getReporteDeClientesInstitucionales() 

    /**
     * Returns the value of field 'reporteDeContenido'.
     * 
     * @return the value of field 'reporteDeContenido'.
     */
    public com.tmk.kernel.site.ReporteDeContenido getReporteDeContenido()
    {
        return this._reporteDeContenido;
    } //-- com.tmk.kernel.site.ReporteDeContenido getReporteDeContenido() 

    /**
     * Returns the value of field 'reporteDeEstadoDeOrden'.
     * 
     * @return the value of field 'reporteDeEstadoDeOrden'.
     */
    public com.tmk.kernel.site.ReporteDeEstadoDeOrden getReporteDeEstadoDeOrden()
    {
        return this._reporteDeEstadoDeOrden;
    } //-- com.tmk.kernel.site.ReporteDeEstadoDeOrden getReporteDeEstadoDeOrden() 

    /**
     * Returns the value of field 'reporteDeOrdenes'.
     * 
     * @return the value of field 'reporteDeOrdenes'.
     */
    public com.tmk.kernel.site.ReporteDeOrdenes getReporteDeOrdenes()
    {
        return this._reporteDeOrdenes;
    } //-- com.tmk.kernel.site.ReporteDeOrdenes getReporteDeOrdenes() 

    /**
     * Returns the value of field 'reporteDePedidosEspeciales'.
     * 
     * @return the value of field 'reporteDePedidosEspeciales'.
     */
    public com.tmk.kernel.site.ReporteDePedidosEspeciales getReporteDePedidosEspeciales()
    {
        return this._reporteDePedidosEspeciales;
    } //-- com.tmk.kernel.site.ReporteDePedidosEspeciales getReporteDePedidosEspeciales() 

    /**
     * Returns the value of field 'reporteDeSocios'.
     * 
     * @return the value of field 'reporteDeSocios'.
     */
    public com.tmk.kernel.site.ReporteDeSocios getReporteDeSocios()
    {
        return this._reporteDeSocios;
    } //-- com.tmk.kernel.site.ReporteDeSocios getReporteDeSocios() 

    /**
     * Returns the value of field 'reporteDeVisitas'.
     * 
     * @return the value of field 'reporteDeVisitas'.
     */
    public com.tmk.kernel.site.ReporteDeVisitas getReporteDeVisitas()
    {
        return this._reporteDeVisitas;
    } //-- com.tmk.kernel.site.ReporteDeVisitas getReporteDeVisitas() 

    /**
     * Returns the value of field 'solapasEnMultilinea'.
     * 
     * @return the value of field 'solapasEnMultilinea'.
     */
    public boolean getSolapasEnMultilinea()
    {
        return this._solapasEnMultilinea;
    } //-- boolean getSolapasEnMultilinea() 

    /**
     * Returns the value of field 'tarjetasVerificadas'.
     * 
     * @return the value of field 'tarjetasVerificadas'.
     */
    public com.tmk.kernel.site.TarjetasVerificadas getTarjetasVerificadas()
    {
        return this._tarjetasVerificadas;
    } //-- com.tmk.kernel.site.TarjetasVerificadas getTarjetasVerificadas() 

    /**
     * Returns the value of field 'vigenciaDelCarritoEnDias'.
     * 
     * @return the value of field 'vigenciaDelCarritoEnDias'.
     */
    public int getVigenciaDelCarritoEnDias()
    {
        return this._vigenciaDelCarritoEnDias;
    } //-- int getVigenciaDelCarritoEnDias() 

    /**
     * Returns the value of field 'vigenciaTapasProtegidas'.
     * 
     * @return the value of field 'vigenciaTapasProtegidas'.
     */
    public int getVigenciaTapasProtegidas()
    {
        return this._vigenciaTapasProtegidas;
    } //-- int getVigenciaTapasProtegidas() 

    /**
     * Method hasDiasConsideradosNovedad
     */
    public boolean hasDiasConsideradosNovedad()
    {
        return this._has_diasConsideradosNovedad;
    } //-- boolean hasDiasConsideradosNovedad() 

    /**
     * Method hasDiasIgnoradosNovedad
     */
    public boolean hasDiasIgnoradosNovedad()
    {
        return this._has_diasIgnoradosNovedad;
    } //-- boolean hasDiasIgnoradosNovedad() 

    /**
     * Method hasGenerarTapasProtegidas
     */
    public boolean hasGenerarTapasProtegidas()
    {
        return this._has_generarTapasProtegidas;
    } //-- boolean hasGenerarTapasProtegidas() 

    /**
     * Method hasSolapasEnMultilinea
     */
    public boolean hasSolapasEnMultilinea()
    {
        return this._has_solapasEnMultilinea;
    } //-- boolean hasSolapasEnMultilinea() 

    /**
     * Method hasVigenciaDelCarritoEnDias
     */
    public boolean hasVigenciaDelCarritoEnDias()
    {
        return this._has_vigenciaDelCarritoEnDias;
    } //-- boolean hasVigenciaDelCarritoEnDias() 

    /**
     * Method hasVigenciaTapasProtegidas
     */
    public boolean hasVigenciaTapasProtegidas()
    {
        return this._has_vigenciaTapasProtegidas;
    } //-- boolean hasVigenciaTapasProtegidas() 

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
     * Sets the value of field 'administrador'.
     * 
     * @param administrador the value of field 'administrador'.
     */
    public void setAdministrador(com.tmk.kernel.site.Administrador administrador)
    {
        this._administrador = administrador;
    } //-- void setAdministrador(com.tmk.kernel.site.Administrador) 

    /**
     * Sets the value of field 'alertaRegistracionConDocDuplicado'.
     * 
     * @param alertaRegistracionConDocDuplicado the value of field
     * 'alertaRegistracionConDocDuplicado'.
     */
    public void setAlertaRegistracionConDocDuplicado(com.tmk.kernel.site.AlertaRegistracionConDocDuplicado alertaRegistracionConDocDuplicado)
    {
        this._alertaRegistracionConDocDuplicado = alertaRegistracionConDocDuplicado;
    } //-- void setAlertaRegistracionConDocDuplicado(com.tmk.kernel.site.AlertaRegistracionConDocDuplicado) 

    /**
     * Sets the value of field 'alianzas'.
     * 
     * @param alianzas the value of field 'alianzas'.
     */
    public void setAlianzas(com.tmk.kernel.site.Alianzas alianzas)
    {
        this._alianzas = alianzas;
    } //-- void setAlianzas(com.tmk.kernel.site.Alianzas) 

    /**
     * Sets the value of field 'callCenter'.
     * 
     * @param callCenter the value of field 'callCenter'.
     */
    public void setCallCenter(com.tmk.kernel.site.CallCenter callCenter)
    {
        this._callCenter = callCenter;
    } //-- void setCallCenter(com.tmk.kernel.site.CallCenter) 

    /**
     * Sets the value of field 'correcciones'.
     * 
     * @param correcciones the value of field 'correcciones'.
     */
    public void setCorrecciones(com.tmk.kernel.site.Correcciones correcciones)
    {
        this._correcciones = correcciones;
    } //-- void setCorrecciones(com.tmk.kernel.site.Correcciones) 

    /**
     * Sets the value of field 'diasConsideradosNovedad'.
     * 
     * @param diasConsideradosNovedad the value of field
     * 'diasConsideradosNovedad'.
     */
    public void setDiasConsideradosNovedad(int diasConsideradosNovedad)
    {
        this._diasConsideradosNovedad = diasConsideradosNovedad;
        this._has_diasConsideradosNovedad = true;
    } //-- void setDiasConsideradosNovedad(int) 

    /**
     * Sets the value of field 'diasIgnoradosNovedad'.
     * 
     * @param diasIgnoradosNovedad the value of field
     * 'diasIgnoradosNovedad'.
     */
    public void setDiasIgnoradosNovedad(int diasIgnoradosNovedad)
    {
        this._diasIgnoradosNovedad = diasIgnoradosNovedad;
        this._has_diasIgnoradosNovedad = true;
    } //-- void setDiasIgnoradosNovedad(int) 

    /**
     * Sets the value of field 'encuestas'.
     * 
     * @param encuestas the value of field 'encuestas'.
     */
    public void setEncuestas(com.tmk.kernel.site.Encuestas encuestas)
    {
        this._encuestas = encuestas;
    } //-- void setEncuestas(com.tmk.kernel.site.Encuestas) 

    /**
     * Sets the value of field 'flash'.
     * 
     * @param flash the value of field 'flash'.
     */
    public void setFlash(com.tmk.kernel.site.Flash flash)
    {
        this._flash = flash;
    } //-- void setFlash(com.tmk.kernel.site.Flash) 

    /**
     * Sets the value of field 'formatos'.
     * 
     * @param formatos the value of field 'formatos'.
     */
    public void setFormatos(com.tmk.kernel.site.Formatos formatos)
    {
        this._formatos = formatos;
    } //-- void setFormatos(com.tmk.kernel.site.Formatos) 

    /**
     * Sets the value of field 'generarTapasProtegidas'.
     * 
     * @param generarTapasProtegidas the value of field
     * 'generarTapasProtegidas'.
     */
    public void setGenerarTapasProtegidas(boolean generarTapasProtegidas)
    {
        this._generarTapasProtegidas = generarTapasProtegidas;
        this._has_generarTapasProtegidas = true;
    } //-- void setGenerarTapasProtegidas(boolean) 

    /**
     * Sets the value of field 'logo'.
     * 
     * @param logo the value of field 'logo'.
     */
    public void setLogo(java.lang.String logo)
    {
        this._logo = logo;
    } //-- void setLogo(java.lang.String) 

    /**
     * Sets the value of field 'mensajeLogo'.
     * 
     * @param mensajeLogo the value of field 'mensajeLogo'.
     */
    public void setMensajeLogo(java.lang.String mensajeLogo)
    {
        this._mensajeLogo = mensajeLogo;
    } //-- void setMensajeLogo(java.lang.String) 

    /**
     * Sets the value of field 'ofertaDeTrabajo'.
     * 
     * @param ofertaDeTrabajo the value of field 'ofertaDeTrabajo'.
     */
    public void setOfertaDeTrabajo(com.tmk.kernel.site.OfertaDeTrabajo ofertaDeTrabajo)
    {
        this._ofertaDeTrabajo = ofertaDeTrabajo;
    } //-- void setOfertaDeTrabajo(com.tmk.kernel.site.OfertaDeTrabajo) 

    /**
     * Sets the value of field 'reporteDeClientesInstitucionales'.
     * 
     * @param reporteDeClientesInstitucionales the value of field
     * 'reporteDeClientesInstitucionales'.
     */
    public void setReporteDeClientesInstitucionales(com.tmk.kernel.site.ReporteDeClientesInstitucionales reporteDeClientesInstitucionales)
    {
        this._reporteDeClientesInstitucionales = reporteDeClientesInstitucionales;
    } //-- void setReporteDeClientesInstitucionales(com.tmk.kernel.site.ReporteDeClientesInstitucionales) 

    /**
     * Sets the value of field 'reporteDeContenido'.
     * 
     * @param reporteDeContenido the value of field
     * 'reporteDeContenido'.
     */
    public void setReporteDeContenido(com.tmk.kernel.site.ReporteDeContenido reporteDeContenido)
    {
        this._reporteDeContenido = reporteDeContenido;
    } //-- void setReporteDeContenido(com.tmk.kernel.site.ReporteDeContenido) 

    /**
     * Sets the value of field 'reporteDeEstadoDeOrden'.
     * 
     * @param reporteDeEstadoDeOrden the value of field
     * 'reporteDeEstadoDeOrden'.
     */
    public void setReporteDeEstadoDeOrden(com.tmk.kernel.site.ReporteDeEstadoDeOrden reporteDeEstadoDeOrden)
    {
        this._reporteDeEstadoDeOrden = reporteDeEstadoDeOrden;
    } //-- void setReporteDeEstadoDeOrden(com.tmk.kernel.site.ReporteDeEstadoDeOrden) 

    /**
     * Sets the value of field 'reporteDeOrdenes'.
     * 
     * @param reporteDeOrdenes the value of field 'reporteDeOrdenes'
     */
    public void setReporteDeOrdenes(com.tmk.kernel.site.ReporteDeOrdenes reporteDeOrdenes)
    {
        this._reporteDeOrdenes = reporteDeOrdenes;
    } //-- void setReporteDeOrdenes(com.tmk.kernel.site.ReporteDeOrdenes) 

    /**
     * Sets the value of field 'reporteDePedidosEspeciales'.
     * 
     * @param reporteDePedidosEspeciales the value of field
     * 'reporteDePedidosEspeciales'.
     */
    public void setReporteDePedidosEspeciales(com.tmk.kernel.site.ReporteDePedidosEspeciales reporteDePedidosEspeciales)
    {
        this._reporteDePedidosEspeciales = reporteDePedidosEspeciales;
    } //-- void setReporteDePedidosEspeciales(com.tmk.kernel.site.ReporteDePedidosEspeciales) 

    /**
     * Sets the value of field 'reporteDeSocios'.
     * 
     * @param reporteDeSocios the value of field 'reporteDeSocios'.
     */
    public void setReporteDeSocios(com.tmk.kernel.site.ReporteDeSocios reporteDeSocios)
    {
        this._reporteDeSocios = reporteDeSocios;
    } //-- void setReporteDeSocios(com.tmk.kernel.site.ReporteDeSocios) 

    /**
     * Sets the value of field 'reporteDeVisitas'.
     * 
     * @param reporteDeVisitas the value of field 'reporteDeVisitas'
     */
    public void setReporteDeVisitas(com.tmk.kernel.site.ReporteDeVisitas reporteDeVisitas)
    {
        this._reporteDeVisitas = reporteDeVisitas;
    } //-- void setReporteDeVisitas(com.tmk.kernel.site.ReporteDeVisitas) 

    /**
     * Sets the value of field 'solapasEnMultilinea'.
     * 
     * @param solapasEnMultilinea the value of field
     * 'solapasEnMultilinea'.
     */
    public void setSolapasEnMultilinea(boolean solapasEnMultilinea)
    {
        this._solapasEnMultilinea = solapasEnMultilinea;
        this._has_solapasEnMultilinea = true;
    } //-- void setSolapasEnMultilinea(boolean) 

    /**
     * Sets the value of field 'tarjetasVerificadas'.
     * 
     * @param tarjetasVerificadas the value of field
     * 'tarjetasVerificadas'.
     */
    public void setTarjetasVerificadas(com.tmk.kernel.site.TarjetasVerificadas tarjetasVerificadas)
    {
        this._tarjetasVerificadas = tarjetasVerificadas;
    } //-- void setTarjetasVerificadas(com.tmk.kernel.site.TarjetasVerificadas) 

    /**
     * Sets the value of field 'vigenciaDelCarritoEnDias'.
     * 
     * @param vigenciaDelCarritoEnDias the value of field
     * 'vigenciaDelCarritoEnDias'.
     */
    public void setVigenciaDelCarritoEnDias(int vigenciaDelCarritoEnDias)
    {
        this._vigenciaDelCarritoEnDias = vigenciaDelCarritoEnDias;
        this._has_vigenciaDelCarritoEnDias = true;
    } //-- void setVigenciaDelCarritoEnDias(int) 

    /**
     * Sets the value of field 'vigenciaTapasProtegidas'.
     * 
     * @param vigenciaTapasProtegidas the value of field
     * 'vigenciaTapasProtegidas'.
     */
    public void setVigenciaTapasProtegidas(int vigenciaTapasProtegidas)
    {
        this._vigenciaTapasProtegidas = vigenciaTapasProtegidas;
        this._has_vigenciaTapasProtegidas = true;
    } //-- void setVigenciaTapasProtegidas(int) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Configuracion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Configuracion) Unmarshaller.unmarshal(com.tmk.kernel.site.Configuracion.class, reader);
    } //-- com.tmk.kernel.site.Configuracion unmarshal(java.io.Reader) 

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
