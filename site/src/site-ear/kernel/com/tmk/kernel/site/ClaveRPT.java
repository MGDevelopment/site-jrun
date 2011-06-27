/*
 * This class was automatically generated with 
 * <a href="http://www.castor.org">Castor 0.9.4.3</a>, using an XML
 * Schema.
 * $Id$
 */

package com.tmk.kernel.site;

  //---------------------------------/
 //- Imported classes and packages -/
//---------------------------------/

import java.io.Reader;
import java.io.Serializable;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Vector;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * Class ClaveRPT.
 * 
 * @version $Revision$ $Date$
 */
public abstract class ClaveRPT implements java.io.Serializable {


      //--------------------------/
     //- Class/Member Variables -/
    //--------------------------/

    /**
     * Field _productoList
     */
    private java.util.Vector _productoList;

    /**
     * Field _editorialList
     */
    private java.util.Vector _editorialList;

    /**
     * Field _proveedorList
     */
    private java.util.Vector _proveedorList;


      //----------------/
     //- Constructors -/
    //----------------/

    public ClaveRPT() {
        super();
        _productoList = new Vector();
        _editorialList = new Vector();
        _proveedorList = new Vector();
    } //-- com.tmk.kernel.site.ClaveRPT()


      //-----------/
     //- Methods -/
    //-----------/

    /**
     * Method addEditorial
     * 
     * @param vEditorial
     */
    public void addEditorial(com.tmk.kernel.site.Editorial vEditorial)
        throws java.lang.IndexOutOfBoundsException
    {
        _editorialList.addElement(vEditorial);
    } //-- void addEditorial(com.tmk.kernel.site.Editorial) 

    /**
     * Method addEditorial
     * 
     * @param index
     * @param vEditorial
     */
    public void addEditorial(int index, com.tmk.kernel.site.Editorial vEditorial)
        throws java.lang.IndexOutOfBoundsException
    {
        _editorialList.insertElementAt(vEditorial, index);
    } //-- void addEditorial(int, com.tmk.kernel.site.Editorial) 

    /**
     * Method addProducto
     * 
     * @param vProducto
     */
    public void addProducto(com.tmk.kernel.site.Producto vProducto)
        throws java.lang.IndexOutOfBoundsException
    {
        _productoList.addElement(vProducto);
    } //-- void addProducto(com.tmk.kernel.site.Producto) 

    /**
     * Method addProducto
     * 
     * @param index
     * @param vProducto
     */
    public void addProducto(int index, com.tmk.kernel.site.Producto vProducto)
        throws java.lang.IndexOutOfBoundsException
    {
        _productoList.insertElementAt(vProducto, index);
    } //-- void addProducto(int, com.tmk.kernel.site.Producto) 

    /**
     * Method addProveedor
     * 
     * @param vProveedor
     */
    public void addProveedor(com.tmk.kernel.site.Proveedor vProveedor)
        throws java.lang.IndexOutOfBoundsException
    {
        _proveedorList.addElement(vProveedor);
    } //-- void addProveedor(com.tmk.kernel.site.Proveedor) 

    /**
     * Method addProveedor
     * 
     * @param index
     * @param vProveedor
     */
    public void addProveedor(int index, com.tmk.kernel.site.Proveedor vProveedor)
        throws java.lang.IndexOutOfBoundsException
    {
        _proveedorList.insertElementAt(vProveedor, index);
    } //-- void addProveedor(int, com.tmk.kernel.site.Proveedor) 

    /**
     * Method enumerateEditorial
     */
    public java.util.Enumeration enumerateEditorial()
    {
        return _editorialList.elements();
    } //-- java.util.Enumeration enumerateEditorial() 

    /**
     * Method enumerateProducto
     */
    public java.util.Enumeration enumerateProducto()
    {
        return _productoList.elements();
    } //-- java.util.Enumeration enumerateProducto() 

    /**
     * Method enumerateProveedor
     */
    public java.util.Enumeration enumerateProveedor()
    {
        return _proveedorList.elements();
    } //-- java.util.Enumeration enumerateProveedor() 

    /**
     * Method getEditorial
     * 
     * @param index
     */
    public com.tmk.kernel.site.Editorial getEditorial(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _editorialList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Editorial) _editorialList.elementAt(index);
    } //-- com.tmk.kernel.site.Editorial getEditorial(int) 

    /**
     * Method getEditorial
     */
    public com.tmk.kernel.site.Editorial[] getEditorial()
    {
        int size = _editorialList.size();
        com.tmk.kernel.site.Editorial[] mArray = new com.tmk.kernel.site.Editorial[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Editorial) _editorialList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Editorial[] getEditorial() 

    /**
     * Method getEditorialCount
     */
    public int getEditorialCount()
    {
        return _editorialList.size();
    } //-- int getEditorialCount() 

    /**
     * Method getProducto
     * 
     * @param index
     */
    public com.tmk.kernel.site.Producto getProducto(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _productoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Producto) _productoList.elementAt(index);
    } //-- com.tmk.kernel.site.Producto getProducto(int) 

    /**
     * Method getProducto
     */
    public com.tmk.kernel.site.Producto[] getProducto()
    {
        int size = _productoList.size();
        com.tmk.kernel.site.Producto[] mArray = new com.tmk.kernel.site.Producto[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Producto) _productoList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Producto[] getProducto() 

    /**
     * Method getProductoCount
     */
    public int getProductoCount()
    {
        return _productoList.size();
    } //-- int getProductoCount() 

    /**
     * Method getProveedor
     * 
     * @param index
     */
    public com.tmk.kernel.site.Proveedor getProveedor(int index)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _proveedorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        
        return (com.tmk.kernel.site.Proveedor) _proveedorList.elementAt(index);
    } //-- com.tmk.kernel.site.Proveedor getProveedor(int) 

    /**
     * Method getProveedor
     */
    public com.tmk.kernel.site.Proveedor[] getProveedor()
    {
        int size = _proveedorList.size();
        com.tmk.kernel.site.Proveedor[] mArray = new com.tmk.kernel.site.Proveedor[size];
        for (int index = 0; index < size; index++) {
            mArray[index] = (com.tmk.kernel.site.Proveedor) _proveedorList.elementAt(index);
        }
        return mArray;
    } //-- com.tmk.kernel.site.Proveedor[] getProveedor() 

    /**
     * Method getProveedorCount
     */
    public int getProveedorCount()
    {
        return _proveedorList.size();
    } //-- int getProveedorCount() 

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
     * Method removeAllEditorial
     */
    public void removeAllEditorial()
    {
        _editorialList.removeAllElements();
    } //-- void removeAllEditorial() 

    /**
     * Method removeAllProducto
     */
    public void removeAllProducto()
    {
        _productoList.removeAllElements();
    } //-- void removeAllProducto() 

    /**
     * Method removeAllProveedor
     */
    public void removeAllProveedor()
    {
        _proveedorList.removeAllElements();
    } //-- void removeAllProveedor() 

    /**
     * Method removeEditorial
     * 
     * @param index
     */
    public com.tmk.kernel.site.Editorial removeEditorial(int index)
    {
        java.lang.Object obj = _editorialList.elementAt(index);
        _editorialList.removeElementAt(index);
        return (com.tmk.kernel.site.Editorial) obj;
    } //-- com.tmk.kernel.site.Editorial removeEditorial(int) 

    /**
     * Method removeProducto
     * 
     * @param index
     */
    public com.tmk.kernel.site.Producto removeProducto(int index)
    {
        java.lang.Object obj = _productoList.elementAt(index);
        _productoList.removeElementAt(index);
        return (com.tmk.kernel.site.Producto) obj;
    } //-- com.tmk.kernel.site.Producto removeProducto(int) 

    /**
     * Method removeProveedor
     * 
     * @param index
     */
    public com.tmk.kernel.site.Proveedor removeProveedor(int index)
    {
        java.lang.Object obj = _proveedorList.elementAt(index);
        _proveedorList.removeElementAt(index);
        return (com.tmk.kernel.site.Proveedor) obj;
    } //-- com.tmk.kernel.site.Proveedor removeProveedor(int) 

    /**
     * Method setEditorial
     * 
     * @param index
     * @param vEditorial
     */
    public void setEditorial(int index, com.tmk.kernel.site.Editorial vEditorial)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _editorialList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _editorialList.setElementAt(vEditorial, index);
    } //-- void setEditorial(int, com.tmk.kernel.site.Editorial) 

    /**
     * Method setEditorial
     * 
     * @param editorialArray
     */
    public void setEditorial(com.tmk.kernel.site.Editorial[] editorialArray)
    {
        //-- copy array
        _editorialList.removeAllElements();
        for (int i = 0; i < editorialArray.length; i++) {
            _editorialList.addElement(editorialArray[i]);
        }
    } //-- void setEditorial(com.tmk.kernel.site.Editorial) 

    /**
     * Method setProducto
     * 
     * @param index
     * @param vProducto
     */
    public void setProducto(int index, com.tmk.kernel.site.Producto vProducto)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _productoList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _productoList.setElementAt(vProducto, index);
    } //-- void setProducto(int, com.tmk.kernel.site.Producto) 

    /**
     * Method setProducto
     * 
     * @param productoArray
     */
    public void setProducto(com.tmk.kernel.site.Producto[] productoArray)
    {
        //-- copy array
        _productoList.removeAllElements();
        for (int i = 0; i < productoArray.length; i++) {
            _productoList.addElement(productoArray[i]);
        }
    } //-- void setProducto(com.tmk.kernel.site.Producto) 

    /**
     * Method setProveedor
     * 
     * @param index
     * @param vProveedor
     */
    public void setProveedor(int index, com.tmk.kernel.site.Proveedor vProveedor)
        throws java.lang.IndexOutOfBoundsException
    {
        //-- check bounds for index
        if ((index < 0) || (index > _proveedorList.size())) {
            throw new IndexOutOfBoundsException();
        }
        _proveedorList.setElementAt(vProveedor, index);
    } //-- void setProveedor(int, com.tmk.kernel.site.Proveedor) 

    /**
     * Method setProveedor
     * 
     * @param proveedorArray
     */
    public void setProveedor(com.tmk.kernel.site.Proveedor[] proveedorArray)
    {
        //-- copy array
        _proveedorList.removeAllElements();
        for (int i = 0; i < proveedorArray.length; i++) {
            _proveedorList.addElement(proveedorArray[i]);
        }
    } //-- void setProveedor(com.tmk.kernel.site.Proveedor) 

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
