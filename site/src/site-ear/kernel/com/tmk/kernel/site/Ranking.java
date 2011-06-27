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
 * Class Ranking.
 * 
 * @version $Revision$ $Date$
 */
public class Ranking implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _rankingSeccionList
     */
    private java.util.Vector _rankingSeccionList;


      //----------------/
     //- Constructors -/
    //----------------/

    public Ranking() {
        super();
        _rankingSeccionList = new Vector();
    } //-- com.tmk.kernel.site.Ranking()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRankingSeccion
     * 
     * @param vRankingSeccion
     */
    public void addRankingSeccion(com.tmk.kernel.site.RankingSeccion vRankingSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _rankingSeccionList.addElement(vRankingSeccion);
    } //-- void addRankingSeccion(com.tmk.kernel.site.RankingSeccion) 

    /**
     * Method addRankingSeccion
     * 
     * @param index
     * @param vRankingSeccion
     */
    public void addRankingSeccion(int index, com.tmk.kernel.site.RankingSeccion vRankingSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        _rankingSeccionList.insertElementAt(vRankingSeccion, index);
    } //-- void addRankingSeccion(int, com.tmk.kernel.site.RankingSeccion) 

    /**
     * Method enumerateRankingSeccion
     */
    public java.util.Enumeration enumerateRankingSeccion()
    {
        return _rankingSeccionList.elements();
    } //-- java.util.Enumeration enumerateRankingSeccion() 

    /**
     * Method getRankingSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.RankingSeccion getRankingSeccion(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rankingSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.RankingSeccion) _rankingSeccionList.elementAt(index);
    } //-- com.tmk.kernel.site.RankingSeccion getRankingSeccion(int) 

    /**
     * Method getRankingSeccion
     */
    public com.tmk.kernel.site.RankingSeccion[] getRankingSeccion()
    {
        int size = _rankingSeccionList.size();
        com.tmk.kernel.site.RankingSeccion[] mArray = new com.tmk.kernel.site.RankingSeccion[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.RankingSeccion) _rankingSeccionList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.RankingSeccion[] getRankingSeccion() 

    /**
     * Method getRankingSeccionCount
     */
    public int getRankingSeccionCount()
    {
        return _rankingSeccionList.size();
    } //-- int getRankingSeccionCount() 

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
     * Method removeAllRankingSeccion
     */
    public void removeAllRankingSeccion()
    {
        _rankingSeccionList.removeAllElements();
    } //-- void removeAllRankingSeccion() 

    /**
     * Method removeRankingSeccion
     * 
     * @param index
     */
    public com.tmk.kernel.site.RankingSeccion removeRankingSeccion(int index)
    {
        java.lang.Object obj = _rankingSeccionList.elementAt(index);
        _rankingSeccionList.removeElementAt(index);
        return (com.tmk.kernel.site.RankingSeccion) obj;
    } //-- com.tmk.kernel.site.RankingSeccion removeRankingSeccion(int) 

    /**
     * Method setRankingSeccion
     * 
     * @param index
     * @param vRankingSeccion
     */
    public void setRankingSeccion(int index, com.tmk.kernel.site.RankingSeccion vRankingSeccion)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rankingSeccionList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _rankingSeccionList.setElementAt(vRankingSeccion, index);
    } //-- void setRankingSeccion(int, com.tmk.kernel.site.RankingSeccion) 

    /**
     * Method setRankingSeccion
     * 
     * @param rankingSeccionArray
     */
    public void setRankingSeccion(com.tmk.kernel.site.RankingSeccion[] rankingSeccionArray)
    {
        //-- copy array
        _rankingSeccionList.removeAllElements();
        for (int i = 0; i < rankingSeccionArray.length; i++) {
            _rankingSeccionList.addElement(rankingSeccionArray[i]);
        }
    } //-- void setRankingSeccion(com.tmk.kernel.site.RankingSeccion) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.Ranking unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.Ranking) Unmarshaller.unmarshal(com.tmk.kernel.site.Ranking.class, reader);
    } //-- com.tmk.kernel.site.Ranking unmarshal(java.io.Reader) 

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
