/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.server.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class AplicacionType.
 * 
 * @version $Revision$ $Date$
 */
public class AplicacionType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The intranet type
     */
    public static final int INTRANET_TYPE = 0;

    /**
     * The instance of the intranet type
     */
    public static final AplicacionType INTRANET = new AplicacionType(INTRANET_TYPE, "intranet");

    /**
     * The sitio type
     */
    public static final int SITIO_TYPE = 1;

    /**
     * The instance of the sitio type
     */
    public static final AplicacionType SITIO = new AplicacionType(SITIO_TYPE, "sitio");

    /**
     * Field _memberTable
     */
    private static java.util.Hashtable _memberTable = init();

    /**
     * Field type
     */
    private int type = -1;

    /**
     * Field stringValue
     */
    private java.lang.String stringValue = null;


      //----------------/
     //- Constructors -/
    //----------------/

    private AplicacionType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.server.types.AplicacionType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of AplicacionType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this AplicacionType
     */
    public int getType()
    {
        return this.type;
    } //-- int getType() 

    /**
     * Method init
     */
    private static java.util.Hashtable init()
    {
        Hashtable members = new Hashtable();
        members.put("intranet", INTRANET);
        members.put("sitio", SITIO);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * AplicacionType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new AplicacionType based on the
     * given String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.server.types.AplicacionType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid AplicacionType";
            throw new IllegalArgumentException(err);
        }
        return (AplicacionType) obj;
    } //-- com.tmk.kernel.server.types.AplicacionType valueOf(java.lang.String) 

}
