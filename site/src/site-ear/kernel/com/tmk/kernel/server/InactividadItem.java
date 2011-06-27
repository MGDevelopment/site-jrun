/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.server;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class InactividadItem.
 * 
 * @version $Revision$ $Date$
 */
public class InactividadItem implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _cronograma
     */
    private com.tmk.kernel.server.Cronograma _cronograma;


      //----------------/
     //- Constructors -/
    //----------------/

    public InactividadItem() {
        super();
    } //-- com.tmk.kernel.server.InactividadItem()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Returns the value of field 'cronograma'.
     * 
     * @return the value of field 'cronograma'.
     */
    public com.tmk.kernel.server.Cronograma getCronograma()
    {
        return this._cronograma;
    } //-- com.tmk.kernel.server.Cronograma getCronograma() 

    /**
     * Sets the value of field 'cronograma'.
     * 
     * @param cronograma the value of field 'cronograma'.
     */
    public void setCronograma(com.tmk.kernel.server.Cronograma cronograma)
    {
        this._cronograma = cronograma;
    } //-- void setCronograma(com.tmk.kernel.server.Cronograma) 

}
