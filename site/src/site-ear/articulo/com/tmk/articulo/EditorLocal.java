package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface EditorLocal extends EJBLocalObject {

	public Integer getID_EDITOR();

	public void setID_EDITOR(Integer ID_EDITOR);

	public String getNOMBRE();

	public void setNOMBRE(String NOMBRE);

	public String getRAZON_SOCIAL();

	public void setRAZON_SOCIAL(String RAZON_SOCIAL);

	public String getDIRECCION();

	public void setDIRECCION(String DIRECCION);

	public String getCODIGO_POSTAL();

	public void setCODIGO_POSTAL(String CODIGO_POSTAL);

	public String getTELEFONO();

	public void setTELEFONO(String TELEFONO);

	public String getFAX();

	public void setFAX(String FAX);

	public String getEMAIL();

	public void setEMAIL(String EMAIL);

	public String getCUIT();

	public void setCUIT(String CUIT);

	public String getOBSERVACIONES();

	public void setOBSERVACIONES(String OBSERVACIONES);

	public Integer getID_PAIS();

	public void setID_PAIS(Integer ID_PAIS);

	public Integer getID_PROVINCIA();

	public void setID_PROVINCIA(Integer ID_PROVINCIA);

	public Integer getID_LOCALIDAD();

	public void setID_LOCALIDAD(Integer ID_LOCALIDAD);

    public String getURL();

	public void setURL(String URL);

}


