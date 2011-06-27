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
 * Class ModoType.
 * 
 * @version $Revision$ $Date$
 */
public class ModoType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The debug type
     */
    public static final int DEBUG_TYPE = 0;

    /**
     * The instance of the debug type
     */
    public static final ModoType DEBUG = new ModoType(DEBUG_TYPE, "debug");

    /**
     * The backup type
     */
    public static final int BACKUP_TYPE = 1;

    /**
     * The instance of the backup type
     */
    public static final ModoType BACKUP = new ModoType(BACKUP_TYPE, "backup");

    /**
     * The mantenimiento type
     */
    public static final int MANTENIMIENTO_TYPE = 2;

    /**
     * The instance of the mantenimiento type
     */
    public static final ModoType MANTENIMIENTO = new ModoType(MANTENIMIENTO_TYPE, "mantenimiento");

    /**
     * The reset type
     */
    public static final int RESET_TYPE = 3;

    /**
     * The instance of the reset type
     */
    public static final ModoType RESET = new ModoType(RESET_TYPE, "reset");

    /**
     * The release type
     */
    public static final int RELEASE_TYPE = 4;

    /**
     * The instance of the release type
     */
    public static final ModoType RELEASE = new ModoType(RELEASE_TYPE, "release");

    /**
     * The inicializacion type
     */
    public static final int INICIALIZACION_TYPE = 5;

    /**
     * The instance of the inicializacion type
     */
    public static final ModoType INICIALIZACION = new ModoType(INICIALIZACION_TYPE, "inicializacion");

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

    private ModoType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.server.types.ModoType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of ModoType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this ModoType
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
        members.put("debug", DEBUG);
        members.put("backup", BACKUP);
        members.put("mantenimiento", MANTENIMIENTO);
        members.put("reset", RESET);
        members.put("release", RELEASE);
        members.put("inicializacion", INICIALIZACION);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * ModoType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new ModoType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.server.types.ModoType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid ModoType";
            throw new IllegalArgumentException(err);
        }
        return (ModoType) obj;
    } //-- com.tmk.kernel.server.types.ModoType valueOf(java.lang.String) 

}
