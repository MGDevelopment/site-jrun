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
 * Class Mapas.
 * 
 * @version $Revision$ $Date$
 */
public class Mapas implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _mapaList
     */
    private java.util.Vector _mapaList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Mapas() {
        super();
        _mapaList = new Vector();
    } //-- com.tmk.kernel.site.Mapas()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addMapa
     * 
     * @param vMapa
     */
    public void addMapa(com.tmk.kernel.site.Mapa vMapa)
        throws java.lang.IndexOutOfBoundsException
    {
        _mapaList.addElement(vMapa);
    } //-- void addMapa(com.tmk.kernel.site.Mapa) 

    /**
     * Method addMapa
     * 
     * @param index
     * @param vMapa
     */
    public void addMapa(int index, com.tmk.kernel.site.Mapa vMapa)
        throws java.lang.IndexOutOfBoundsException
    {
        _mapaList.insertElementAt(vMapa, index);
    } //-- void addMapa(int, com.tmk.kernel.site.Mapa) 

    /**
     * Method enumerateMapa
     */
    public java.util.Enumeration enumerateMapa()
    {
        return _mapaList.elements();
    } //-- java.util.Enumeration enumerateMapa() 

    /**
     * Method getMapa
     * 
     * @param index
     */
    public com.tmk.kernel.site.Mapa getMapa(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mapaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Mapa) _mapaList.elementAt(index);
    } //-- com.tmk.kernel.site.Mapa getMapa(int) 

    /**
     * Method getMapa
     */
    public com.tmk.kernel.site.Mapa[] getMapa()
    {
        int size = _mapaList.size();
        com.tmk.kernel.site.Mapa[] mArray = new com.tmk.kernel.site.Mapa[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Mapa) _mapaList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Mapa[] getMapa() 

    /**
     * Method getMapaCount
     */
    public int getMapaCount()
    {
        return _mapaList.size();
    } //-- int getMapaCount() 

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
     * Method removeAllMapa
     */
    public void removeAllMapa()
    {
        _mapaList.removeAllElements();
    } //-- void removeAllMapa() 

    /**
     * Method removeMapa
     * 
     * @param index
     */
    public com.tmk.kernel.site.Mapa removeMapa(int index)
    {
        java.lang.Object obj = _mapaList.elementAt(index);
        _mapaList.removeElementAt(index);
        return (com.tmk.kernel.site.Mapa) obj;
    } //-- com.tmk.kernel.site.Mapa removeMapa(int) 

    /**
     * Method setMapa
     * 
     * @param index
     * @param vMapa
     */
    public void setMapa(int index, com.tmk.kernel.site.Mapa vMapa)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _mapaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _mapaList.setElementAt(vMapa, index);
    } //-- void setMapa(int, com.tmk.kernel.site.Mapa) 

    /**
     * Method setMapa
     * 
     * @param mapaArray
     */
    public void setMapa(com.tmk.kernel.site.Mapa[] mapaArray)
    {
        //-- copy array
        _mapaList.removeAllElements();
        for (int i = 0; i < mapaArray.length; i++) {
            _mapaList.addElement(mapaArray[i]);
        }
    } //-- void setMapa(com.tmk.kernel.site.Mapa) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Mapas unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Mapas) Unmarshaller.unmarshal(com.tmk.kernel.site.Mapas.class, reader);
    } //-- com.tmk.kernel.site.Mapas unmarshal(java.io.Reader) 

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
