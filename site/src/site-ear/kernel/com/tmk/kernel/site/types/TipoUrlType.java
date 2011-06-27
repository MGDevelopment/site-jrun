/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.site.types;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;

/**
 * Class TipoUrlType.
 * 
 * @version $Revision$ $Date$
 */
public class TipoUrlType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The HTML type
     */
    public static final int HTML_TYPE = 0;

    /**
     * The instance of the HTML type
     */
    public static final TipoUrlType HTML = new TipoUrlType(HTML_TYPE, "HTML");

    /**
     * The JPG type
     */
    public static final int JPG_TYPE = 1;

    /**
     * The instance of the JPG type
     */
    public static final TipoUrlType JPG = new TipoUrlType(JPG_TYPE, "JPG");

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

    private TipoUrlType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.site.types.TipoUrlType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of TipoUrlType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this TipoUrlType
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
        members.put("HTML", HTML);
        members.put("JPG", JPG);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * TipoUrlType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new TipoUrlType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.site.types.TipoUrlType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid TipoUrlType";
            throw new IllegalArgumentException(err);
        }
        return (TipoUrlType) obj;
    } //-- com.tmk.kernel.site.types.TipoUrlType valueOf(java.lang.String) 

}
