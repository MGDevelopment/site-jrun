/**
 *
 */
package com.tmk.bus.socio;


import com.tmk.dbo.DBO;

/**
 * ESTE ES EL QUE FUNCIONA BIEN
 * @author oClopez
 *
 */
public class SociosIntegracion extends DBO {
	private Integer id_socio;
	private	Integer id_sucursal;
	private	String identificador;
	private	String dominio;

	public SociosIntegracion()
	{

	}
	/*constructor */
	public SociosIntegracion(Integer id_socio, Integer id_sucursal,String identificador,String dominio )
	{
		this.id_socio = id_socio;
		this.id_sucursal = id_sucursal;
		this.identificador = identificador;
		this.dominio = dominio;
	}

	public static String getOrden() {

		return null;
	}

	public String getPK() {
		StringBuffer pk = new StringBuffer("");
		pk.append(getAlias()).append(".id_socio = ").append(id_socio);
		pk.append(" and ");
		pk.append(getAlias()).append(".id_sucursal=").append(id_sucursal);
		pk.append(" and ");
		pk.append(getAlias()).append(".dominio='").append(dominio).append("'");
		return pk.toString();
	}

	public boolean tieneDBO() {
		return false;
	}
	public static String getAlias() {
		return "USI";
	}

	public static String getTabla()
	{
		return "socios_integracion";
	}

	/*GET's && SETS's*/
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public Integer getId_socio() {
		return id_socio;
	}

	public void setId_socio(Integer id_socio) {
		this.id_socio = id_socio;
	}

	public Integer getId_sucursal() {
		return id_sucursal;
	}

	public void setId_sucursal(Integer id_sucursal) {
		this.id_sucursal = id_sucursal;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/*public String[] getCampoFK() {
		return new String[]{"id_socio", "id_sucursal"};
	}*/
}
