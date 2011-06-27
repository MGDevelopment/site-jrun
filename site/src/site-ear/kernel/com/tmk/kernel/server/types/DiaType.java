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
 * Class DiaType.
 * 
 * @version $Revision$ $Date$
 */
public class DiaType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The lunes type
     */
    public static final int LUNES_TYPE = 0;

    /**
     * The instance of the lunes type
     */
    public static final DiaType LUNES = new DiaType(LUNES_TYPE, "lunes");

    /**
     * The martes type
     */
    public static final int MARTES_TYPE = 1;

    /**
     * The instance of the martes type
     */
    public static final DiaType MARTES = new DiaType(MARTES_TYPE, "martes");

    /**
     * The miercoles type
     */
    public static final int MIERCOLES_TYPE = 2;

    /**
     * The instance of the miercoles type
     */
    public static final DiaType MIERCOLES = new DiaType(MIERCOLES_TYPE, "miercoles");

    /**
     * The jueves type
     */
    public static final int JUEVES_TYPE = 3;

    /**
     * The instance of the jueves type
     */
    public static final DiaType JUEVES = new DiaType(JUEVES_TYPE, "jueves");

    /**
     * The viernes type
     */
    public static final int VIERNES_TYPE = 4;

    /**
     * The instance of the viernes type
     */
    public static final DiaType VIERNES = new DiaType(VIERNES_TYPE, "viernes");

    /**
     * The sabado type
     */
    public static final int SABADO_TYPE = 5;

    /**
     * The instance of the sabado type
     */
    public static final DiaType SABADO = new DiaType(SABADO_TYPE, "sabado");

    /**
     * The domingo type
     */
    public static final int DOMINGO_TYPE = 6;

    /**
     * The instance of the domingo type
     */
    public static final DiaType DOMINGO = new DiaType(DOMINGO_TYPE, "domingo");

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

    private DiaType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.server.types.DiaType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of DiaType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this DiaType
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
        members.put("lunes", LUNES);
        members.put("martes", MARTES);
        members.put("miercoles", MIERCOLES);
        members.put("jueves", JUEVES);
        members.put("viernes", VIERNES);
        members.put("sabado", SABADO);
        members.put("domingo", DOMINGO);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * DiaType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new DiaType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.server.types.DiaType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid DiaType";
            throw new IllegalArgumentException(err);
        }
        return (DiaType) obj;
    } //-- com.tmk.kernel.server.types.DiaType valueOf(java.lang.String) 

}
