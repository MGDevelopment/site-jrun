package com.tmk.admin;

import javax.ejb.EJBLocalObject;

public interface TarjetaVerificadaLocal extends EJBLocalObject {

	public Integer getID();

	public void setID(Integer ID);

	public byte[] getNRO_TARJETA();

	public void setNRO_TARJETA(byte[] NRO_TARJETA);

	public String getNOMBRES_SOCIO();

	public void setNOMBRES_SOCIO(String NOMBRES_SOCIO);

	public String getAPELLIDOS_SOCIO();

	public void setAPELLIDOS_SOCIO(String APELLIDOS_SOCIO);

	public String getE_MAIL();

	public void setE_MAIL(String E_MAIL);

	public String getCALLE_ENVIO();

	public void setCALLE_ENVIO(String CALLE_ENVIO);

	public Integer getNUMERO_ENVIO();

	public void setNUMERO_ENVIO(Integer NUMERO_ENVIO);

	public String getEDIFICIO_ENVIO();

	public void setEDIFICIO_ENVIO(String EDIFICIO_ENVIO);

	public Integer getPISO_ENVIO();

	public void setPISO_ENVIO(Integer PISO_ENVIO);

	public String getDEPTO_ENVIO();

	public void setDEPTO_ENVIO(String DEPTO_ENVIO);

	public String getCP_ENVIO();

	public void setCP_ENVIO(String CP_ENVIO);

	public Integer getID_PAIS_ENVIO();

	public void setID_PAIS_ENVIO(Integer ID_PAIS_ENVIO);

	public Integer getID_PROVINCIA_ENVIO();

	public void setID_PROVINCIA_ENVIO(Integer ID_PROVINCIA_ENVIO);

	public Integer getID_LOCALIDAD_ENVIO();

	public void setID_LOCALIDAD_ENVIO(Integer ID_LOCALIDAD_ENVIO);

	public String getCALLE_FACT();

	public void setCALLE_FACT(String CALLE_FACT);

	public Integer getNUMERO_FACT();

	public void setNUMERO_FACT(Integer NUMERO_FACT);

	public String getEDIFICIO_FACT();

	public void setEDIFICIO_FACT(String EDIFICIO_FACT);

	public Integer getPISO_FACT();

	public void setPISO_FACT(Integer PISO_FACT);

	public String getDEPTO_FACT();

	public void setDEPTO_FACT(String DEPTO_FACT);

	public String getCP_FACT();

	public void setCP_FACT(String CP_FACT);

	public Integer getID_PAIS_FACT();

	public void setID_PAIS_FACT(Integer ID_PAIS_FACT);

	public Integer getID_PROVINCIA_FACT();

	public void setID_PROVINCIA_FACT(Integer ID_PROVINCIA_FACT);

	public Integer getID_LOCALIDAD_FACT();

	public void setID_LOCALIDAD_FACT(Integer ID_LOCALIDAD_FACT);

	public Integer getNIVEL_RIESGO();

	public void setNIVEL_RIESGO(Integer NIVEL_RIESGO);

	public String getCOMENTARIOS();

	public void setCOMENTARIOS(String COMENTARIOS);

}


