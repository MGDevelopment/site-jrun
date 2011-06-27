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
 * Class RankingSeccion.
 * 
 * @version $Revision$ $Date$
 */
public class RankingSeccion implements java.io.Serializable {


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
     * Field _rankingGrupoList
     */
    private java.util.Vector _rankingGrupoList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RankingSeccion() {
        super();
        _rankingGrupoList = new Vector();
    } //-- com.tmk.kernel.site.RankingSeccion()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addRankingGrupo
     * 
     * @param vRankingGrupo
     */
    public void addRankingGrupo(com.tmk.kernel.site.RankingGrupo vRankingGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _rankingGrupoList.addElement(vRankingGrupo);
    } //-- void addRankingGrupo(com.tmk.kernel.site.RankingGrupo) 

    /**
     * Method addRankingGrupo
     * 
     * @param index
     * @param vRankingGrupo
     */
    public void addRankingGrupo(int index, com.tmk.kernel.site.RankingGrupo vRankingGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        _rankingGrupoList.insertElementAt(vRankingGrupo, index);
    } //-- void addRankingGrupo(int, com.tmk.kernel.site.RankingGrupo) 

    /**
     * Method enumerateRankingGrupo
     */
    public java.util.Enumeration enumerateRankingGrupo()
    {
        return _rankingGrupoList.elements();
    } //-- java.util.Enumeration enumerateRankingGrupo() 

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
     * Method getRankingGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.RankingGrupo getRankingGrupo(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rankingGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.RankingGrupo) _rankingGrupoList.elementAt(index);
    } //-- com.tmk.kernel.site.RankingGrupo getRankingGrupo(int) 

    /**
     * Method getRankingGrupo
     */
    public com.tmk.kernel.site.RankingGrupo[] getRankingGrupo()
    {
        int size = _rankingGrupoList.size();
        com.tmk.kernel.site.RankingGrupo[] mArray = new com.tmk.kernel.site.RankingGrupo[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.RankingGrupo) _rankingGrupoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.RankingGrupo[] getRankingGrupo() 

    /**
     * Method getRankingGrupoCount
     */
    public int getRankingGrupoCount()
    {
        return _rankingGrupoList.size();
    } //-- int getRankingGrupoCount() 

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
     * Method removeAllRankingGrupo
     */
    public void removeAllRankingGrupo()
    {
        _rankingGrupoList.removeAllElements();
    } //-- void removeAllRankingGrupo() 

    /**
     * Method removeRankingGrupo
     * 
     * @param index
     */
    public com.tmk.kernel.site.RankingGrupo removeRankingGrupo(int index)
    {
        java.lang.Object obj = _rankingGrupoList.elementAt(index);
        _rankingGrupoList.removeElementAt(index);
        return (com.tmk.kernel.site.RankingGrupo) obj;
    } //-- com.tmk.kernel.site.RankingGrupo removeRankingGrupo(int) 

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
     * Method setRankingGrupo
     * 
     * @param index
     * @param vRankingGrupo
     */
    public void setRankingGrupo(int index, com.tmk.kernel.site.RankingGrupo vRankingGrupo)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _rankingGrupoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _rankingGrupoList.setElementAt(vRankingGrupo, index);
    } //-- void setRankingGrupo(int, com.tmk.kernel.site.RankingGrupo) 

    /**
     * Method setRankingGrupo
     * 
     * @param rankingGrupoArray
     */
    public void setRankingGrupo(com.tmk.kernel.site.RankingGrupo[] rankingGrupoArray)
    {
        //-- copy array
        _rankingGrupoList.removeAllElements();
        for (int i = 0; i < rankingGrupoArray.length; i++) {
            _rankingGrupoList.addElement(rankingGrupoArray[i]);
        }
    } //-- void setRankingGrupo(com.tmk.kernel.site.RankingGrupo) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RankingSeccion unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RankingSeccion) Unmarshaller.unmarshal(com.tmk.kernel.site.RankingSeccion.class, reader);
    } //-- com.tmk.kernel.site.RankingSeccion unmarshal(java.io.Reader) 

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
