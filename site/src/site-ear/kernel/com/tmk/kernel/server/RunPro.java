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

import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.ContentHandler;

/**
 * Class RunPro.
 * 
 * @version $Revision$ $Date$
 */
public class RunPro implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _nombre
     */
    private java.lang.String _nombre;

    /**
     * Field _clase
     */
    private java.lang.String _clase;

    /**
     * Field _metodo
     */
    private java.lang.String _metodo;

    /**
     * Field _comienzo
     */
    private java.lang.String _comienzo;

    /**
     * Field _espera
     */
    private java.lang.String _espera;

    /**
     * Field _dia
     */
    private java.lang.String _dia;

    /**
     * Field _hora
     */
    private java.lang.String _hora;

    /**
     * Field _minuto
     */
    private java.lang.String _minuto;

    /**
     * Field _rangoRepMen
     */
    private java.lang.String _rangoRepMen;

    /**
     * Field _rangoRepMay
     */
    private java.lang.String _rangoRepMay;

    /**
     * Field _diaSemanaList
     */
    private java.util.Vector _diaSemanaList;

    /**
     * Field _emailList
     */
    private java.util.Vector _emailList;


      //----------------/
     //- Constructors -/
    //----------------/

    public RunPro() {
        super();
        _diaSemanaList = new Vector();
        _emailList = new Vector();
    } //-- com.tmk.kernel.server.RunPro()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addDiaSemana
     * 
     * @param vDiaSemana
     */
    public void addDiaSemana(int vDiaSemana)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_diaSemanaList.size() < 7)) {
            throw new IndexOutOfBoundsException();
        }
        _diaSemanaList.addElement(new Integer(vDiaSemana));
    } //-- void addDiaSemana(int) 

    /**
     * Method addDiaSemana
     * 
     * @param index
     * @param vDiaSemana
     */
    public void addDiaSemana(int index, int vDiaSemana)
        throws java.lang.IndexOutOfBoundsException
    {
        if (!(_diaSemanaList.size() < 7)) {
            throw new IndexOutOfBoundsException();
        }
        _diaSemanaList.insertElementAt(new Integer(vDiaSemana), index);
    } //-- void addDiaSemana(int, int) 

    /**
     * Method addEmail
     * 
     * @param vEmail
     */
    public void addEmail(java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        _emailList.addElement(vEmail);
    } //-- void addEmail(java.lang.String) 

    /**
     * Method addEmail
     * 
     * @param index
     * @param vEmail
     */
    public void addEmail(int index, java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        _emailList.insertElementAt(vEmail, index);
    } //-- void addEmail(int, java.lang.String) 

    /**
     * Method enumerateDiaSemana
     */
    public java.util.Enumeration enumerateDiaSemana()
    {
        return _diaSemanaList.elements();
    } //-- java.util.Enumeration enumerateDiaSemana() 

    /**
     * Method enumerateEmail
     */
    public java.util.Enumeration enumerateEmail()
    {
        return _emailList.elements();
    } //-- java.util.Enumeration enumerateEmail() 

    /**
     * Returns the value of field 'clase'.
     * 
     * @return the value of field 'clase'.
     */
    public java.lang.String getClase()
    {
        return this._clase;
    } //-- java.lang.String getClase() 

    /**
     * Returns the value of field 'comienzo'.
     * 
     * @return the value of field 'comienzo'.
     */
    public java.lang.String getComienzo()
    {
        return this._comienzo;
    } //-- java.lang.String getComienzo() 

    /**
     * Returns the value of field 'dia'.
     * 
     * @return the value of field 'dia'.
     */
    public java.lang.String getDia()
    {
        return this._dia;
    } //-- java.lang.String getDia() 

    /**
     * Method getDiaSemana
     * 
     * @param index
     */
    public int getDiaSemana(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _diaSemanaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return ((Integer)_diaSemanaList.elementAt(index)).intValue();
    } //-- int getDiaSemana(int) 

    /**
     * Method getDiaSemana
     */
    public int[] getDiaSemana()
    {
        int size = _diaSemanaList.size();
        int[] mArray = new int[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = ((Integer)_diaSemanaList.elementAt(index)).intValue();
        }
        return mArray;
    } //-- int[] getDiaSemana() 

    /**
     * Method getDiaSemanaCount
     */
    public int getDiaSemanaCount()
    {
        return _diaSemanaList.size();
    } //-- int getDiaSemanaCount() 

    /**
     * Method getEmail
     * 
     * @param index
     */
    public java.lang.String getEmail(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _emailList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (String)_emailList.elementAt(index);
    } //-- java.lang.String getEmail(int) 

    /**
     * Method getEmail
     */
    public java.lang.String[] getEmail()
    {
        int size = _emailList.size();
        java.lang.String[] mArray = new java.lang.String[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (String)_emailList.elementAt(index);
        }
        return mArray;
    } //-- java.lang.String[] getEmail() 

    /**
     * Method getEmailCount
     */
    public int getEmailCount()
    {
        return _emailList.size();
    } //-- int getEmailCount() 

    /**
     * Returns the value of field 'espera'.
     * 
     * @return the value of field 'espera'.
     */
    public java.lang.String getEspera()
    {
        return this._espera;
    } //-- java.lang.String getEspera() 

    /**
     * Returns the value of field 'hora'.
     * 
     * @return the value of field 'hora'.
     */
    public java.lang.String getHora()
    {
        return this._hora;
    } //-- java.lang.String getHora() 

    /**
     * Returns the value of field 'metodo'.
     * 
     * @return the value of field 'metodo'.
     */
    public java.lang.String getMetodo()
    {
        return this._metodo;
    } //-- java.lang.String getMetodo() 

    /**
     * Returns the value of field 'minuto'.
     * 
     * @return the value of field 'minuto'.
     */
    public java.lang.String getMinuto()
    {
        return this._minuto;
    } //-- java.lang.String getMinuto() 

    /**
     * Returns the value of field 'nombre'.
     * 
     * @return the value of field 'nombre'.
     */
    public java.lang.String getNombre()
    {
        return this._nombre;
    } //-- java.lang.String getNombre() 

    /**
     * Returns the value of field 'rangoRepMay'.
     * 
     * @return the value of field 'rangoRepMay'.
     */
    public java.lang.String getRangoRepMay()
    {
        return this._rangoRepMay;
    } //-- java.lang.String getRangoRepMay() 

    /**
     * Returns the value of field 'rangoRepMen'.
     * 
     * @return the value of field 'rangoRepMen'.
     */
    public java.lang.String getRangoRepMen()
    {
        return this._rangoRepMen;
    } //-- java.lang.String getRangoRepMen() 

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
     * Method removeAllDiaSemana
     */
    public void removeAllDiaSemana()
    {
        _diaSemanaList.removeAllElements();
    } //-- void removeAllDiaSemana() 

    /**
     * Method removeAllEmail
     */
    public void removeAllEmail()
    {
        _emailList.removeAllElements();
    } //-- void removeAllEmail() 

    /**
     * Method removeDiaSemana
     * 
     * @param index
     */
    public int removeDiaSemana(int index)
    {
        java.lang.Object obj = _diaSemanaList.elementAt(index);
        _diaSemanaList.removeElementAt(index);
        return ((Integer)obj).intValue();
    } //-- int removeDiaSemana(int) 

    /**
     * Method removeEmail
     * 
     * @param index
     */
    public java.lang.String removeEmail(int index)
    {
        java.lang.Object obj = _emailList.elementAt(index);
        _emailList.removeElementAt(index);
        return (String)obj;
    } //-- java.lang.String removeEmail(int) 

    /**
     * Sets the value of field 'clase'.
     * 
     * @param clase the value of field 'clase'.
     */
    public void setClase(java.lang.String clase)
    {
        this._clase = clase;
    } //-- void setClase(java.lang.String) 

    /**
     * Sets the value of field 'comienzo'.
     * 
     * @param comienzo the value of field 'comienzo'.
     */
    public void setComienzo(java.lang.String comienzo)
    {
        this._comienzo = comienzo;
    } //-- void setComienzo(java.lang.String) 

    /**
     * Sets the value of field 'dia'.
     * 
     * @param dia the value of field 'dia'.
     */
    public void setDia(java.lang.String dia)
    {
        this._dia = dia;
    } //-- void setDia(java.lang.String) 

    /**
     * Method setDiaSemana
     * 
     * @param index
     * @param vDiaSemana
     */
    public void setDiaSemana(int index, int vDiaSemana)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _diaSemanaList.size())) {
            throw new IndexOutOfBoundsException();
        }
        if (!(index < 7)) {
            throw new IndexOutOfBoundsException();
        }
        _diaSemanaList.setElementAt(new Integer(vDiaSemana), index);
    } //-- void setDiaSemana(int, int) 

    /**
     * Method setDiaSemana
     * 
     * @param diaSemanaArray
     */
    public void setDiaSemana(int[] diaSemanaArray)
    {
        //-- copy array
        _diaSemanaList.removeAllElements();
        for (int i = 0; i < diaSemanaArray.length; i++) {
            _diaSemanaList.addElement(new Integer(diaSemanaArray[i]));
        }
    } //-- void setDiaSemana(int) 

    /**
     * Method setEmail
     * 
     * @param index
     * @param vEmail
     */
    public void setEmail(int index, java.lang.String vEmail)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _emailList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _emailList.setElementAt(vEmail, index);
    } //-- void setEmail(int, java.lang.String) 

    /**
     * Method setEmail
     * 
     * @param emailArray
     */
    public void setEmail(java.lang.String[] emailArray)
    {
        //-- copy array
        _emailList.removeAllElements();
        for (int i = 0; i < emailArray.length; i++) {
            _emailList.addElement(emailArray[i]);
        }
    } //-- void setEmail(java.lang.String) 

    /**
     * Sets the value of field 'espera'.
     * 
     * @param espera the value of field 'espera'.
     */
    public void setEspera(java.lang.String espera)
    {
        this._espera = espera;
    } //-- void setEspera(java.lang.String) 

    /**
     * Sets the value of field 'hora'.
     * 
     * @param hora the value of field 'hora'.
     */
    public void setHora(java.lang.String hora)
    {
        this._hora = hora;
    } //-- void setHora(java.lang.String) 

    /**
     * Sets the value of field 'metodo'.
     * 
     * @param metodo the value of field 'metodo'.
     */
    public void setMetodo(java.lang.String metodo)
    {
        this._metodo = metodo;
    } //-- void setMetodo(java.lang.String) 

    /**
     * Sets the value of field 'minuto'.
     * 
     * @param minuto the value of field 'minuto'.
     */
    public void setMinuto(java.lang.String minuto)
    {
        this._minuto = minuto;
    } //-- void setMinuto(java.lang.String) 

    /**
     * Sets the value of field 'nombre'.
     * 
     * @param nombre the value of field 'nombre'.
     */
    public void setNombre(java.lang.String nombre)
    {
        this._nombre = nombre;
    } //-- void setNombre(java.lang.String) 

    /**
     * Sets the value of field 'rangoRepMay'.
     * 
     * @param rangoRepMay the value of field 'rangoRepMay'.
     */
    public void setRangoRepMay(java.lang.String rangoRepMay)
    {
        this._rangoRepMay = rangoRepMay;
    } //-- void setRangoRepMay(java.lang.String) 

    /**
     * Sets the value of field 'rangoRepMen'.
     * 
     * @param rangoRepMen the value of field 'rangoRepMen'.
     */
    public void setRangoRepMen(java.lang.String rangoRepMen)
    {
        this._rangoRepMen = rangoRepMen;
    } //-- void setRangoRepMen(java.lang.String) 

    /**
     * Method unmarshal
     * 
     * @param reader
     */
    public static com.tmk.kernel.server.RunPro unmarshal(java.io.Reader reader)
        throws org.exolab.castor.xml.MarshalException, org.exolab.castor.xml.ValidationException
    {
        return (com.tmk.kernel.server.RunPro) Unmarshaller.unmarshal(com.tmk.kernel.server.RunPro.class, reader);
    } //-- com.tmk.kernel.server.RunPro unmarshal(java.io.Reader) 

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
