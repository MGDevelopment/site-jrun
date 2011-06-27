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
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class Paginas.
 * 
 * @version $Revision$ $Date$
 */
public class Paginas implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _textoParaBuscadores
     */
    private java.lang.String _textoParaBuscadores;

    /**
     * Field _paginaList
     */
    private java.util.Vector _paginaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Paginas() {
        super();
        _paginaList = new Vector();
    } //-- com.tmk.kernel.site.Paginas()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addPagina
     * 
     * @param vPagina
     */
    public void addPagina(com.tmk.kernel.site.Pagina vPagina)
        throws java.lang.IndexOutOfBoundsException
    {
        _paginaList.addElement(vPagina);
    } //-- void addPagina(com.tmk.kernel.site.Pagina) 

    /**
     * Method addPagina
     * 
     * @param index
     * @param vPagina
     */
    public void addPagina(int index, com.tmk.kernel.site.Pagina vPagina)
        throws java.lang.IndexOutOfBoundsException
    {
        _paginaList.insertElementAt(vPagina, index);
    } //-- void addPagina(int, com.tmk.kernel.site.Pagina) 

    /**
     * Method enumeratePagina
     */
    public java.util.Enumeration enumeratePagina()
    {
        return _paginaList.elements();
    } //-- java.util.Enumeration enumeratePagina() 

    /**
     * Method getPagina
     * 
     * @param index
     */
    public com.tmk.kernel.site.Pagina getPagina(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _paginaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Pagina) _paginaList.elementAt(index);
    } //-- com.tmk.kernel.site.Pagina getPagina(int) 

    /**
     * Method getPagina
     */
    public com.tmk.kernel.site.Pagina[] getPagina()
    {
        int size = _paginaList.size();
        com.tmk.kernel.site.Pagina[] mArray = new com.tmk.kernel.site.Pagina[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Pagina) _paginaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Pagina[] getPagina() 

    /**
     * Method getPaginaCount
     */
    public int getPaginaCount()
    {
        return _paginaList.size();
    } //-- int getPaginaCount() 

    /**
     * Returns the value of field 'textoParaBuscadores'.
     * 
     * @return the value of field 'textoParaBuscadores'.
     */
    public java.lang.String getTextoParaBuscadores()
    {
        return this._textoParaBuscadores;
    } //-- java.lang.String getTextoParaBuscadores() 

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
     * Method removeAllPagina
     */
    public void removeAllPagina()
    {
        _paginaList.removeAllElements();
    } //-- void removeAllPagina() 

    /**
     * Method removePagina
     * 
     * @param index
     */
    public com.tmk.kernel.site.Pagina removePagina(int index)
    {
        java.lang.Object obj = _paginaList.elementAt(index);
        _paginaList.removeElementAt(index);
        return (com.tmk.kernel.site.Pagina) obj;
    } //-- com.tmk.kernel.site.Pagina removePagina(int) 

    /**
     * Method setPagina
     * 
     * @param index
     * @param vPagina
     */
    public void setPagina(int index, com.tmk.kernel.site.Pagina vPagina)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _paginaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _paginaList.setElementAt(vPagina, index);
    } //-- void setPagina(int, com.tmk.kernel.site.Pagina) 

    /**
     * Method setPagina
     * 
     * @param paginaArray
     */
    public void setPagina(com.tmk.kernel.site.Pagina[] paginaArray)
    {
        //-- copy array
        _paginaList.removeAllElements();
        for (int i = 0; i < paginaArray.length; i++) {
            _paginaList.addElement(paginaArray[i]);
        }
    } //-- void setPagina(com.tmk.kernel.site.Pagina) 

    /**
     * Sets the value of field 'textoParaBuscadores'.
     * 
     * @param textoParaBuscadores the value of field
     * 'textoParaBuscadores'.
     */
    public void setTextoParaBuscadores(java.lang.String textoParaBuscadores)
    {
        this._textoParaBuscadores = textoParaBuscadores;
    } //-- void setTextoParaBuscadores(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Paginas unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Paginas) Unmarshaller.unmarshal(com.tmk.kernel.site.Paginas.class, reader);
    } //-- com.tmk.kernel.site.Paginas unmarshal(java.io.Reader) 

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
