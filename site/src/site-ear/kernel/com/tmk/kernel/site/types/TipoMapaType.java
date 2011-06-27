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
 * Class TipoMapaType.
 * 
 * @version $Revision$ $Date$
 */
public class TipoMapaType implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * The BIOGRAFIA type
     */
    public static final int BIOGRAFIA_TYPE = 0;

    /**
     * The instance of the BIOGRAFIA type
     */
    public static final TipoMapaType BIOGRAFIA = new TipoMapaType(BIOGRAFIA_TYPE, "BIOGRAFIA");

    /**
     * The ENTREVISTA type
     */
    public static final int ENTREVISTA_TYPE = 1;

    /**
     * The instance of the ENTREVISTA type
     */
    public static final TipoMapaType ENTREVISTA = new TipoMapaType(ENTREVISTA_TYPE, "ENTREVISTA");

    /**
     * The COMENTARIO type
     */
    public static final int COMENTARIO_TYPE = 2;

    /**
     * The instance of the COMENTARIO type
     */
    public static final TipoMapaType COMENTARIO = new TipoMapaType(COMENTARIO_TYPE, "COMENTARIO");

    /**
     * The INDICEDECONTENIDO type
     */
    public static final int INDICEDECONTENIDO_TYPE = 3;

    /**
     * The instance of the INDICEDECONTENIDO type
     */
    public static final TipoMapaType INDICEDECONTENIDO = new TipoMapaType(INDICEDECONTENIDO_TYPE, "INDICEDECONTENIDO");

    /**
     * The PRIMERCAPITULO type
     */
    public static final int PRIMERCAPITULO_TYPE = 4;

    /**
     * The instance of the PRIMERCAPITULO type
     */
    public static final TipoMapaType PRIMERCAPITULO = new TipoMapaType(PRIMERCAPITULO_TYPE, "PRIMERCAPITULO");

    /**
     * The EDITORIAL type
     */
    public static final int EDITORIAL_TYPE = 5;

    /**
     * The instance of the EDITORIAL type
     */
    public static final TipoMapaType EDITORIAL = new TipoMapaType(EDITORIAL_TYPE, "EDITORIAL");

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

    private TipoMapaType(int type, java.lang.String value) {
        super();
        this.type = type;
        this.stringValue = value;
    } //-- com.tmk.kernel.site.types.TipoMapaType(int, java.lang.String)


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method enumerateReturns an enumeration of all possible
     * instances of TipoMapaType
     */
    public static java.util.Enumeration enumerate()
    {
        return _memberTable.elements();
    } //-- java.util.Enumeration enumerate() 

    /**
     * Method getTypeReturns the type of this TipoMapaType
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
        members.put("BIOGRAFIA", BIOGRAFIA);
        members.put("ENTREVISTA", ENTREVISTA);
        members.put("COMENTARIO", COMENTARIO);
        members.put("INDICEDECONTENIDO", INDICEDECONTENIDO);
        members.put("PRIMERCAPITULO", PRIMERCAPITULO);
        members.put("EDITORIAL", EDITORIAL);
        return members;
    } //-- java.util.Hashtable init() 

    /**
     * Method toStringReturns the String representation of this
     * TipoMapaType
     */
    public java.lang.String toString()
    {
        return this.stringValue;
    } //-- java.lang.String toString() 

    /**
     * Method valueOfReturns a new TipoMapaType based on the given
     * String value.
     * 
     * @param string
     */
    public static com.tmk.kernel.site.types.TipoMapaType valueOf(java.lang.String string)
    {
        java.lang.Object obj = null;
        if (string != null) obj = _memberTable.get(string);
        if (obj == null) {
            String err = "'" + string + "' is not a valid TipoMapaType";
            throw new IllegalArgumentException(err);
        }
        return (TipoMapaType) obj;
    } //-- com.tmk.kernel.site.types.TipoMapaType valueOf(java.lang.String) 

}
