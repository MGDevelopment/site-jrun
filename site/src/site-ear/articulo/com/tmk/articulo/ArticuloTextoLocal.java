package com.tmk.articulo;

import javax.ejb.EJBLocalObject;

public interface ArticuloTextoLocal extends EJBLocalObject {

	public Integer getID_ARTICULO();

	public void setID_ARTICULO(Integer ID_ARTICULO);

	public String getTIPO();

	public void setTIPO(String TIPO);

	public Integer getPARTE();

	public void setPARTE(Integer PARTE);

	public String getTIPO_TEXTO();

	public void setTIPO_TEXTO(String TIPO_TEXTO);

	public String getTEXTO();

	public void setTEXTO(String TEXTO);

	public Integer getID_AUTOR();

	public void setID_AUTOR(Integer ID_AUTOR);

	public String getROLE();

	public void setROLE(String ROLE);

	public String getIDIOMA();

	public void setIDIOMA(String IDIOMA);

}


