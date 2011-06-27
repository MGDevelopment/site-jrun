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
 * Class DiaSemanaType.
 * 
 * @version $Revision$ $Date$
 */
public class DiaSemanaType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The 1 type
     */
    public static final int VALUE_0_TYPE = 0;

    /**
     * The instance of the 1 type
     */
    public static final DiaSemanaType VALUE_0 = new DiaSemanaType(VALUE_0_TYPE, "1");

    /**
     * The 2 type
     */
    public static final int VALUE_1_TYPE = 1;

    /**
     * The instance of the 2 type
     */
    public static final DiaSemanaType VALUE_1 = new DiaSemanaType(VALUE_1_TYPE, "2");

    /**
     * The 3 type
     */
    public static final int VALUE_2_TYPE = 2;

    /**
     * The instance of the 3 type
     */
    public static final DiaSemanaType VALUE_2 = new DiaSemanaType(VALUE_2_TYPE, "3");

    /**
     * The 4 type
     */
    public static final int VALUE_3_TYPE = 3;

    /**
     * The instance of the 4 type
     */
    public static final DiaSemanaType VALUE_3 = new DiaSemanaType(VALUE_3_TYPE, "4");

    /**
     * The 5 type
     */
    public static final int VALUE_4_TYPE = 4;

    /**
     * The instance of the 5 type
     */
    public static final DiaSemanaType VALUE_4 = new DiaSemanaType(VALUE_4_TYPE, "5");

    /**
     * The 6 type
     */
    public static final int VALUE_5_TYPE = 5;

    /**
     * The instance of the 6 type
     */
    public static final DiaSemanaType VALUE_5 = new DiaSemanaType(VALUE_5_TYPE, "6");

    /**
     * The 7 type
     */
    public static final int VALUE_6_TYPE = 6;

    /**
     * The instance of the 7 type
     */
    public static final DiaSemanaType VALUE_6 = new DiaSemanaType(VALUE_6_TYPE, "7");

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

    private DiaSemanaType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.server.types.DiaSemanaType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DiaSemanaType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this DiaSemanaType
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
        members.put("1", VALUE_0);
        members.put("2", VALUE_1);
        members.put("3", VALUE_2);
        members.put("4", VALUE_3);
        members.put("5", VALUE_4);
        members.put("6", VALUE_5);
        members.put("7", VALUE_6);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DiaSemanaType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new DiaSemanaType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.server.types.DiaSemanaType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DiaSemanaType";
            throw new IllegalArgumentException(err);
        }
        return (DiaSemanaType) obj;
    } //-- com.tmk.kernel.server.types.DiaSemanaType valueOf(java.lang.String) 

}
