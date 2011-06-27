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
 * Class RecorridoPorTemas.
 * 
 * @version $Revision$ $Date$
 */
public class RecorridoPorTemas implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _recorridoSecciones
     */
    private com.tmk.kernel.site.RecorridoSecciones _recorridoSecciones;


      //----------------/
     //- Constructors -/
    //----------------/

    public RecorridoPorTemas() {
        super();
    } //-- com.tmk.kernel.site.RecorridoPorTemas()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'recorridoSecciones'.
     * 
     * @return the value of field 'recorridoSecciones'.
     */
    public com.tmk.kernel.site.RecorridoSecciones getRecorridoSecciones()
    {
        return this._recorridoSecciones;
    } //-- com.tmk.kernel.site.RecorridoSecciones getRecorridoSecciones() 

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
     * Sets the value of field 'recorridoSecciones'.
     * 
     * @param recorridoSecciones the value of field
     * 'recorridoSecciones'.
     */
    public void setRecorridoSecciones(com.tmk.kernel.site.RecorridoSecciones recorridoSecciones)
    {
        this._recorridoSecciones = recorridoSecciones;
    } //-- void setRecorridoSecciones(com.tmk.kernel.site.RecorridoSecciones) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.site.RecorridoPorTemas unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.site.RecorridoPorTemas) Unmarshaller.unmarshal(com.tmk.kernel.site.RecorridoPorTemas.class, reader);
    } //-- com.tmk.kernel.site.RecorridoPorTemas unmarshal(java.io.Reader) 

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
