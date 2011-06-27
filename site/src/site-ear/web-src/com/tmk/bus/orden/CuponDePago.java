/**
 *
 */
package com.tmk.bus.orden;

import java.sql.Connection;
import java.sql.Statement;

import com.tmk.bus.fk.CuponDePagoFK;
import com.tmk.dbo.DBO;
import com.tmk.kernel.TmkLogger;

/**
 * @author msartori
 *
 */
public class CuponDePago extends DBO {

	public final static CuponDePagoFK cls_fk = CuponDePagoFK.getInstance();
	
	/*Datos miembro*/
	private String codigo;
	private Integer id_orden;
	/*Datos miembro*/

	/*Constructores*/
	public CuponDePago(String codigo) {
		this.codigo = codigo;
	}

	public CuponDePago() {

	}
	/*Constructores*/

	/*SET*/
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setIdOrden(Integer idOrden) {
		this.id_orden = idOrden;
	}
	/*SET*/

	/*GET*/
	public String getCodigo() {
		return this.codigo;
	}

	public Integer getIdOrden() {
		return this.id_orden;
	}
	/*GET*/

	/*Metodos heredados*/
	public String getPK() {
		StringBuffer str = new StringBuffer("");
		str.append(getAlias()).append(".codigo = '").append(codigo).append("'");

		return str.toString();
	}

	public static String getTabla() {
		return "cupon_de_pago";
	}
	/*Metodos heredados*/

	/*
	 * codifico estos metodos para que no utilice los heredados ya que la aplicacion no debe
		insertar ni borrar datos de la tabla
	*/
	/*SOBRECARGADOS*/
	public void insert(Connection conn) {
		TmkLogger.debug("insert sobrecargado");
		//nada
	}

	public void delete(Connection conn) {
		TmkLogger.debug("delete sobrecargado");
		//nada
	}

	//HACE UPDATE EN LA TABLA DE CUPONES AL PRIMER CUPON SIN ASIGNAR
	public void update(Connection conn) throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" UPDATE cupon_de_pago SET id_orden = ");
		qry.append(this.id_orden);
		qry.append(" WHERE codigo = ");
		qry.append(" (SELECT min(codigo) FROM cupon_de_pago ");
		qry.append("  WHERE id_orden is null) ");
		Statement st  = conn.createStatement();
		try {
			st.execute(qry.toString());
		} catch (Exception e) {
			throw e;
		} finally {
			st.close();
		}
	}
	/*SOBRECARGADOS*/

	public static String getFiltro() {
		return null;
	}

	public static String getAlias() {
		return "CUPPAG";
	}

	public static String getOrden() {
		return null;
	}

	public boolean tieneDBO() {
		return false;
	}
	
	/**
	 * Metodos estaticos
	*/	
	public static String[] getCamposPK(){
		return new String[]{getAlias()+"__codigo"};
	}	
	public static String[][] getFK(String fk) {
		return (String[][])cls_fk.get(fk);
	}
}
