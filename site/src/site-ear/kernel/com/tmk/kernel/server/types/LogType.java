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
 * Class LogType.
 * 
 * @version $Revision$ $Date$
 */
public class LogType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The alto type
     */
    public static final int ALTO_TYPE = 0;

    /**
     * The instance of the alto type
     */
    public static final LogType ALTO = new LogType(ALTO_TYPE, "alto");

    /**
     * The medio type
     */
    public static final int MEDIO_TYPE = 1;

    /**
     * The instance of the medio type
     */
    public static final LogType MEDIO = new LogType(MEDIO_TYPE, "medio");

    /**
     * The bajo type
     */
    public static final int BAJO_TYPE = 2;

    /**
     * The instance of the bajo type
     */
    public static final LogType BAJO = new LogType(BAJO_TYPE, "bajo");

    /**
     * The ninguno type
     */
    public static final int NINGUNO_TYPE = 3;

    /**
     * The instance of the ninguno type
     */
    public static final LogType NINGUNO = new LogType(NINGUNO_TYPE, "ninguno");

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

    private LogType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.server.types.LogType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of LogType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this LogType
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
        members.put("alto", ALTO);
        members.put("medio", MEDIO);
        members.put("bajo", BAJO);
        members.put("ninguno", NINGUNO);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * LogType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new LogType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.server.types.LogType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid LogType";
            throw new IllegalArgumentException(err);
        }
        return (LogType) obj;
    } //-- com.tmk.kernel.server.types.LogType valueOf(java.lang.String) 

}
