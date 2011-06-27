package com.tmk.orden;

import javax.ejb.EJBObject;
import java.rmi.RemoteException;

public interface ItemOrden extends EJBObject {

	public Integer getID_ORDEN() throws RemoteException;

	public void setID_ORDEN(Integer ID_ORDEN) throws RemoteException;

	public Integer getID_ARTICULO() throws RemoteException;

	public void setID_ARTICULO(Integer ID_ARTICULO) throws RemoteException;

	public Integer getCANTIDAD() throws RemoteException;

	public void setCANTIDAD(Integer CANTIDAD) throws RemoteException;

	public Double getPRECIO_ORIGINAL() throws RemoteException;

	public void setPRECIO_ORIGINAL(Double PRECIO_ORIGINAL) throws RemoteException;

	public Integer getID_PAPEL_REGALO() throws RemoteException;

	public void setID_PAPEL_REGALO(Integer ID_PAPEL_REGALO) throws RemoteException;

	public Double getPRECIO_UNITARIO() throws RemoteException;

	public void setPRECIO_UNITARIO(Double PRECIO_UNITARIO) throws RemoteException;

	public Double getPRECIO_DESCUENTO() throws RemoteException;

	public void setPRECIO_DESCUENTO(Double PRECIO_DESCUENTO) throws RemoteException;

	public Double getPRECIO_PROMOCION() throws RemoteException;

	public void setPRECIO_PROMOCION(Double PRECIO_PROMOCION) throws RemoteException;

	public Integer getID_LISTA_PVP() throws RemoteException;

	public void setID_LISTA_PVP(Integer ID_LISTA_PVP) throws RemoteException;

	public String getESTADO() throws RemoteException;

	public void setESTADO(String ESTADO) throws RemoteException;

	public Integer getID_PROMOCION() throws RemoteException;

	public void setID_PROMOCION(Integer ID_PROMOCION) throws RemoteException;

	public Double getPRECIO_PROMOCION_SIN_IMPUESTOS() throws RemoteException;

	public void setPRECIO_PROMOCION_SIN_IMPUESTOS(Double PRECIO_PROMOCION_SIN_IMPUESTOS) throws RemoteException;

    public Integer getID_ARTICULO_MOL() throws RemoteException;

	public void setID_ARTICULO_MOL(Integer ID_ARTICULO_MOL) throws RemoteException;

	public Long getITEM() throws RemoteException;

	public void setITEM(Long ITEM) throws RemoteException;
	
	public Integer getID_PROMOCION2() throws RemoteException; 

	public void setID_PROMOCION2(Integer ID_PROMOCION2) throws RemoteException;
	
	public Integer getID_PROMOCION3() throws RemoteException;

	public void setID_PROMOCION3(Integer ID_PROMOCION3) throws RemoteException;
	
	public Integer getID_PROMOCION4() throws RemoteException;

	public void setID_PROMOCION4(Integer ID_PROMOCION4) throws RemoteException;
	
	public Integer getID_PROMOCION5() throws RemoteException;

	public void setID_PROMOCION5(Integer ID_PROMOCION5) throws RemoteException;
	
	public Integer getID_CAMPAIGN() throws RemoteException;

	public void setID_CAMPAIGN(Integer ID_CAMPAIGN) throws RemoteException;

}


