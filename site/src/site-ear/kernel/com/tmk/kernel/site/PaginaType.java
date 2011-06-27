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

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Class PaginaType.
 * 
 * @version $Revision$ $Date$
 */
public abstract class PaginaType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _id
     */
    private int _id;

    /**
     * keeps track of state for field: _id
     */
    private boolean _has_id;

    /**
     * Field _home
     */
    private com.tmk.kernel.site.Home _home;

    /**
     * Field _primerLista
     */
    private com.tmk.kernel.site.PrimerLista _primerLista;

    /**
     * Field _segundaLista
     */
    private com.tmk.kernel.site.SegundaLista _segundaLista;

    /**
     * Field _tercerLista
     */
    private com.tmk.kernel.site.TercerLista _tercerLista;

    /**
     * Field _promocionesVert
     */
    private com.tmk.kernel.site.PromocionesVert _promocionesVert;

    /**
     * Field _promocionesHorz
     */
    private com.tmk.kernel.site.PromocionesHorz _promocionesHorz;

    /**
     * Field _bannerSuperior
     */
    private com.tmk.kernel.site.BannerSuperior _bannerSuperior;

    /**
     * Field _bannersTop
     */
    private com.tmk.kernel.site.BannersTop _bannersTop;

    /**
     * Field _principal
     */
    private com.tmk.kernel.site.Principal _principal;

    /**
     * Field _destacados
     */
    private com.tmk.kernel.site.Destacados _destacados;

    /**
     * Field _favoritos
     */
    private com.tmk.kernel.site.Favoritos _favoritos;

    /**
     * Field _recorridos
     */
    private com.tmk.kernel.site.Recorridos _recorridos;

    /**
     * Field _linkBusqueda
     */
    private com.tmk.kernel.site.LinkBusqueda _linkBusqueda;

    /**
     * Field _mapas
     */
    private com.tmk.kernel.site.Mapas _mapas;

    /**
     * Field _bannerCatalogo
     */
    private com.tmk.kernel.site.BannerCatalogo _bannerCatalogo;


      //----------------/
     //- Constructors -/
    //----------------/

    public PaginaType() {
        super();
    } //-- com.tmk.kernel.site.PaginaType()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'bannerCatalogo'.
     * 
     * @return the value of field 'bannerCatalogo'.
     */
    public com.tmk.kernel.site.BannerCatalogo getBannerCatalogo()
    {
        return this._bannerCatalogo;
    } //-- com.tmk.kernel.site.BannerCatalogo getBannerCatalogo() 

    /**
     * Returns the value of field 'bannerSuperior'.
     * 
     * @return the value of field 'bannerSuperior'.
     */
    public com.tmk.kernel.site.BannerSuperior getBannerSuperior()
    {
        return this._bannerSuperior;
    } //-- com.tmk.kernel.site.BannerSuperior getBannerSuperior() 

    /**
     * Returns the value of field 'bannersTop'.
     * 
     * @return the value of field 'bannersTop'.
     */
    public com.tmk.kernel.site.BannersTop getBannersTop()
    {
        return this._bannersTop;
    } //-- com.tmk.kernel.site.BannersTop getBannersTop() 

    /**
     * Returns the value of field 'destacados'.
     * 
     * @return the value of field 'destacados'.
     */
    public com.tmk.kernel.site.Destacados getDestacados()
    {
        return this._destacados;
    } //-- com.tmk.kernel.site.Destacados getDestacados() 

    /**
     * Returns the value of field 'favoritos'.
     * 
     * @return the value of field 'favoritos'.
     */
    public com.tmk.kernel.site.Favoritos getFavoritos()
    {
        return this._favoritos;
    } //-- com.tmk.kernel.site.Favoritos getFavoritos() 

    /**
     * Returns the value of field 'home'.
     * 
     * @return the value of field 'home'.
     */
    public com.tmk.kernel.site.Home getHome()
    {
        return this._home;
    } //-- com.tmk.kernel.site.Home getHome() 

    /**
     * Returns the value of field 'id'.
     * 
     * @return the value of field 'id'.
     */
    public int getId()
    {
        return this._id;
    } //-- int getId() 

    /**
     * Returns the value of field 'linkBusqueda'.
     * 
     * @return the value of field 'linkBusqueda'.
     */
    public com.tmk.kernel.site.LinkBusqueda getLinkBusqueda()
    {
        return this._linkBusqueda;
    } //-- com.tmk.kernel.site.LinkBusqueda getLinkBusqueda() 

    /**
     * Returns the value of field 'mapas'.
     * 
     * @return the value of field 'mapas'.
     */
    public com.tmk.kernel.site.Mapas getMapas()
    {
        return this._mapas;
    } //-- com.tmk.kernel.site.Mapas getMapas() 

    /**
     * Returns the value of field 'primerLista'.
     * 
     * @return the value of field 'primerLista'.
     */
    public com.tmk.kernel.site.PrimerLista getPrimerLista()
    {
        return this._primerLista;
    } //-- com.tmk.kernel.site.PrimerLista getPrimerLista() 

    /**
     * Returns the value of field 'principal'.
     * 
     * @return the value of field 'principal'.
     */
    public com.tmk.kernel.site.Principal getPrincipal()
    {
        return this._principal;
    } //-- com.tmk.kernel.site.Principal getPrincipal() 

    /**
     * Returns the value of field 'promocionesHorz'.
     * 
     * @return the value of field 'promocionesHorz'.
     */
    public com.tmk.kernel.site.PromocionesHorz getPromocionesHorz()
    {
        return this._promocionesHorz;
    } //-- com.tmk.kernel.site.PromocionesHorz getPromocionesHorz() 

    /**
     * Returns the value of field 'promocionesVert'.
     * 
     * @return the value of field 'promocionesVert'.
     */
    public com.tmk.kernel.site.PromocionesVert getPromocionesVert()
    {
        return this._promocionesVert;
    } //-- com.tmk.kernel.site.PromocionesVert getPromocionesVert() 

    /**
     * Returns the value of field 'recorridos'.
     * 
     * @return the value of field 'recorridos'.
     */
    public com.tmk.kernel.site.Recorridos getRecorridos()
    {
        return this._recorridos;
    } //-- com.tmk.kernel.site.Recorridos getRecorridos() 

    /**
     * Returns the value of field 'segundaLista'.
     * 
     * @return the value of field 'segundaLista'.
     */
    public com.tmk.kernel.site.SegundaLista getSegundaLista()
    {
        return this._segundaLista;
    } //-- com.tmk.kernel.site.SegundaLista getSegundaLista() 

    /**
     * Returns the value of field 'tercerLista'.
     * 
     * @return the value of field 'tercerLista'.
     */
    public com.tmk.kernel.site.TercerLista getTercerLista()
    {
        return this._tercerLista;
    } //-- com.tmk.kernel.site.TercerLista getTercerLista() 

    /**
     * Method hasId
     */
    public boolean hasId()
    {
        return this._has_id;
    } //-- boolean hasId() 

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
     * Sets the value of field 'bannerCatalogo'.
     * 
     * @param bannerCatalogo the value of field 'bannerCatalogo'.
     */
    public void setBannerCatalogo(com.tmk.kernel.site.BannerCatalogo bannerCatalogo)
    {
        this._bannerCatalogo = bannerCatalogo;
    } //-- void setBannerCatalogo(com.tmk.kernel.site.BannerCatalogo) 

    /**
     * Sets the value of field 'bannerSuperior'.
     * 
     * @param bannerSuperior the value of field 'bannerSuperior'.
     */
    public void setBannerSuperior(com.tmk.kernel.site.BannerSuperior bannerSuperior)
    {
        this._bannerSuperior = bannerSuperior;
    } //-- void setBannerSuperior(com.tmk.kernel.site.BannerSuperior) 

    /**
     * Sets the value of field 'bannersTop'.
     * 
     * @param bannersTop the value of field 'bannersTop'.
     */
    public void setBannersTop(com.tmk.kernel.site.BannersTop bannersTop)
    {
        this._bannersTop = bannersTop;
    } //-- void setBannersTop(com.tmk.kernel.site.BannersTop) 

    /**
     * Sets the value of field 'destacados'.
     * 
     * @param destacados the value of field 'destacados'.
     */
    public void setDestacados(com.tmk.kernel.site.Destacados destacados)
    {
        this._destacados = destacados;
    } //-- void setDestacados(com.tmk.kernel.site.Destacados) 

    /**
     * Sets the value of field 'favoritos'.
     * 
     * @param favoritos the value of field 'favoritos'.
     */
    public void setFavoritos(com.tmk.kernel.site.Favoritos favoritos)
    {
        this._favoritos = favoritos;
    } //-- void setFavoritos(com.tmk.kernel.site.Favoritos) 

    /**
     * Sets the value of field 'home'.
     * 
     * @param home the value of field 'home'.
     */
    public void setHome(com.tmk.kernel.site.Home home)
    {
        this._home = home;
    } //-- void setHome(com.tmk.kernel.site.Home) 

    /**
     * Sets the value of field 'id'.
     * 
     * @param id the value of field 'id'.
     */
    public void setId(int id)
    {
        this._id = id;
        this._has_id = true;
    } //-- void setId(int) 

    /**
     * Sets the value of field 'linkBusqueda'.
     * 
     * @param linkBusqueda the value of field 'linkBusqueda'.
     */
    public void setLinkBusqueda(com.tmk.kernel.site.LinkBusqueda linkBusqueda)
    {
        this._linkBusqueda = linkBusqueda;
    } //-- void setLinkBusqueda(com.tmk.kernel.site.LinkBusqueda) 

    /**
     * Sets the value of field 'mapas'.
     * 
     * @param mapas the value of field 'mapas'.
     */
    public void setMapas(com.tmk.kernel.site.Mapas mapas)
    {
        this._mapas = mapas;
    } //-- void setMapas(com.tmk.kernel.site.Mapas) 

    /**
     * Sets the value of field 'primerLista'.
     * 
     * @param primerLista the value of field 'primerLista'.
     */
    public void setPrimerLista(com.tmk.kernel.site.PrimerLista primerLista)
    {
        this._primerLista = primerLista;
    } //-- void setPrimerLista(com.tmk.kernel.site.PrimerLista) 

    /**
     * Sets the value of field 'principal'.
     * 
     * @param principal the value of field 'principal'.
     */
    public void setPrincipal(com.tmk.kernel.site.Principal principal)
    {
        this._principal = principal;
    } //-- void setPrincipal(com.tmk.kernel.site.Principal) 

    /**
     * Sets the value of field 'promocionesHorz'.
     * 
     * @param promocionesHorz the value of field 'promocionesHorz'.
     */
    public void setPromocionesHorz(com.tmk.kernel.site.PromocionesHorz promocionesHorz)
    {
        this._promocionesHorz = promocionesHorz;
    } //-- void setPromocionesHorz(com.tmk.kernel.site.PromocionesHorz) 

    /**
     * Sets the value of field 'promocionesVert'.
     * 
     * @param promocionesVert the value of field 'promocionesVert'.
     */
    public void setPromocionesVert(com.tmk.kernel.site.PromocionesVert promocionesVert)
    {
        this._promocionesVert = promocionesVert;
    } //-- void setPromocionesVert(com.tmk.kernel.site.PromocionesVert) 

    /**
     * Sets the value of field 'recorridos'.
     * 
     * @param recorridos the value of field 'recorridos'.
     */
    public void setRecorridos(com.tmk.kernel.site.Recorridos recorridos)
    {
        this._recorridos = recorridos;
    } //-- void setRecorridos(com.tmk.kernel.site.Recorridos) 

    /**
     * Sets the value of field 'segundaLista'.
     * 
     * @param segundaLista the value of field 'segundaLista'.
     */
    public void setSegundaLista(com.tmk.kernel.site.SegundaLista segundaLista)
    {
        this._segundaLista = segundaLista;
    } //-- void setSegundaLista(com.tmk.kernel.site.SegundaLista) 

    /**
     * Sets the value of field 'tercerLista'.
     * 
     * @param tercerLista the value of field 'tercerLista'.
     */
    public void setTercerLista(com.tmk.kernel.site.TercerLista tercerLista)
    {
        this._tercerLista = tercerLista;
    } //-- void setTercerLista(com.tmk.kernel.site.TercerLista) 

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
