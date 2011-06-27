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
 * Class PosicionesType.
 * 
 * @version $Revision$ $Date$
 */
public class PosicionesType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The ArribaIzquierda type
     */
    public static final int ARRIBAIZQUIERDA_TYPE = 0;

    /**
     * The instance of the ArribaIzquierda type
     */
    public static final PosicionesType ARRIBAIZQUIERDA = new PosicionesType(ARRIBAIZQUIERDA_TYPE, "ArribaIzquierda");

    /**
     * The ArribaCentrado type
     */
    public static final int ARRIBACENTRADO_TYPE = 1;

    /**
     * The instance of the ArribaCentrado type
     */
    public static final PosicionesType ARRIBACENTRADO = new PosicionesType(ARRIBACENTRADO_TYPE, "ArribaCentrado");

    /**
     * The ArribaDerecha type
     */
    public static final int ARRIBADERECHA_TYPE = 2;

    /**
     * The instance of the ArribaDerecha type
     */
    public static final PosicionesType ARRIBADERECHA = new PosicionesType(ARRIBADERECHA_TYPE, "ArribaDerecha");

    /**
     * The MedioIzquierda type
     */
    public static final int MEDIOIZQUIERDA_TYPE = 3;

    /**
     * The instance of the MedioIzquierda type
     */
    public static final PosicionesType MEDIOIZQUIERDA = new PosicionesType(MEDIOIZQUIERDA_TYPE, "MedioIzquierda");

    /**
     * The MedioCentrado type
     */
    public static final int MEDIOCENTRADO_TYPE = 4;

    /**
     * The instance of the MedioCentrado type
     */
    public static final PosicionesType MEDIOCENTRADO = new PosicionesType(MEDIOCENTRADO_TYPE, "MedioCentrado");

    /**
     * The MedioDerecha type
     */
    public static final int MEDIODERECHA_TYPE = 5;

    /**
     * The instance of the MedioDerecha type
     */
    public static final PosicionesType MEDIODERECHA = new PosicionesType(MEDIODERECHA_TYPE, "MedioDerecha");

    /**
     * The AbajoIzquierda type
     */
    public static final int ABAJOIZQUIERDA_TYPE = 6;

    /**
     * The instance of the AbajoIzquierda type
     */
    public static final PosicionesType ABAJOIZQUIERDA = new PosicionesType(ABAJOIZQUIERDA_TYPE, "AbajoIzquierda");

    /**
     * The AbajoCentrado type
     */
    public static final int ABAJOCENTRADO_TYPE = 7;

    /**
     * The instance of the AbajoCentrado type
     */
    public static final PosicionesType ABAJOCENTRADO = new PosicionesType(ABAJOCENTRADO_TYPE, "AbajoCentrado");

    /**
     * The AbajoDerecha type
     */
    public static final int ABAJODERECHA_TYPE = 8;

    /**
     * The instance of the AbajoDerecha type
     */
    public static final PosicionesType ABAJODERECHA = new PosicionesType(ABAJODERECHA_TYPE, "AbajoDerecha");

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

    private PosicionesType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.site.types.PosicionesType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of PosicionesType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this PosicionesType
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
        members.put("ArribaIzquierda", ARRIBAIZQUIERDA);
        members.put("ArribaCentrado", ARRIBACENTRADO);
        members.put("ArribaDerecha", ARRIBADERECHA);
        members.put("MedioIzquierda", MEDIOIZQUIERDA);
        members.put("MedioCentrado", MEDIOCENTRADO);
        members.put("MedioDerecha", MEDIODERECHA);
        members.put("AbajoIzquierda", ABAJOIZQUIERDA);
        members.put("AbajoCentrado", ABAJOCENTRADO);
        members.put("AbajoDerecha", ABAJODERECHA);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * PosicionesType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new PosicionesType based on the
     * given String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.site.types.PosicionesType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid PosicionesType";
            throw new IllegalArgumentException(err);
        }
        return (PosicionesType) obj;
    } //-- com.tmk.kernel.site.types.PosicionesType valueOf(java.lang.String) 

}
