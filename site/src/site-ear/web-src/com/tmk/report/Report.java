package com.tmk.report;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DecimalFormat;
//import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
//import java.util.List;
import java.util.Vector;
//import oracle.security.o3logon.C1;
import org.apache.commons.beanutils.DynaBean;
import org.jfree.chart.JFreeChart;
import com.tmk.controllers.MainHelper;
import com.tmk.kernel.Convert;
import com.tmk.kernel.CryptUtil;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.util.ByteArrayWarpper;
import com.tmk.util.HTML.Template;

public class Report  {

	public static Vector getActualizacionMailExtraByEstado(boolean mesAnterior) throws Exception{
		StringBuffer qry = new StringBuffer();
		qry.append("	SELECT DECODE(estado, 1, 'En etapa inicial', 2, 'Finalizaron proceso', 3, ");
		qry.append("		'Segunda Actualización') row1, ");
		qry.append("		ROUND (COUNT(*)*100/( SELECT COUNT(*) ");
		qry.append("							  FROM actualizacion_mail_extra ");
		if (mesAnterior) {
			qry.append("	WHERE f_alta >= TRUNC(TRUNC(SYSDATE , 'MM')-1, 'MM')	");
			qry.append("		AND f_alta <= TRUNC(SYSDATE , 'MM')");
		}
		qry.append("							 ),2) row2, count(*) row3");
		qry.append("	FROM actualizacion_mail_extra ");
		if (mesAnterior) {
			qry.append("	WHERE f_alta >= TRUNC(TRUNC(SYSDATE , 'MM')-1, 'MM')	");
			qry.append("		AND f_alta <= TRUNC(SYSDATE , 'MM')");
		}
		qry.append("	GROUP BY estado ");
		return MainHelper.getVectorDB(qry.toString());
	}

	public static Vector getProductosPorSocios2() throws Exception {
		StringBuffer qry = new StringBuffer("");
		qry.append("SELECT DISTINCT soc.login, ord.fecha, a.titulo titulo_articulo,");
		qry.append("	a.id_articulo idarticulo, cs.descripcion seccion,");
		qry.append("	cg.descripcion grupo, cf.descripcion familia,");
		qry.append("	soc.nombres nombre_cliente, aut.id_autor,");
		qry.append("	aut.descripcion autor, sd1.calle calle_envi,");
		qry.append("	sd1.numero numero_envi, sd1.edificio edificio_envi,");
		qry.append("	sd1.piso piso_envi, sd1.depto depto_envi, sd1.cp cp_envi,");
		qry.append("	sd1.id_localidad id_loc_envi, sd1.id_provincia prov_envi,");
		qry.append("	sd1.id_pais pais_envi, sd2.calle calle_fact,");
		qry.append("	sd2.numero numero_facti, sd2.edificio edificio_fact,");
		qry.append("	sd2.piso piso_fact, sd2.depto depto_fact, sd2.cp cp_fact,");
		qry.append("	sd2.id_localidad id_loc_fact, sd2.id_provincia prov_fact,");
		qry.append("	sd2.id_pais pais_fact");
		qry.append(" FROM orden ord INNER JOIN socios2 soc ON ord.id_socio = soc.id_socio");
		qry.append("	AND ord.id_sucursal_socio = soc.id_sucursal");
		qry.append("	INNER JOIN item_orden ito ON ord.id_orden = ito.id_orden");
		qry.append("	INNER JOIN articulos a ON a.id_articulo = ito.id_articulo");
		qry.append("	INNER JOIN categ_secciones cs ON a.categoria_seccion = cs.categoria_seccion");
		qry.append("	INNER JOIN categ_grupos cg ON a.categoria_seccion = cg.categoria_seccion");
		qry.append("		AND a.categoria_grupo = cg.categoria_grupo");
		qry.append("	INNER JOIN categ_familias cf ON a.categoria_seccion = cf.categoria_seccion");
		qry.append("		AND a.categoria_grupo = cf.categoria_grupo");
		qry.append("		AND a.categoria_familia = cf.categoria_familia");
		qry.append("	INNER JOIN categ_subfamilias csf ON a.categoria_seccion = csf.categoria_seccion");
		qry.append("		AND a.categoria_grupo = csf.categoria_grupo");
		qry.append("		AND a.categoria_familia = csf.categoria_familia");
		qry.append("		AND a.categoria_subfamilia = csf.categoria_subfamilia");
		qry.append("	INNER JOIN direccion_orden dor1 ON ord.id_orden = dor1.id_orden");
		qry.append("	INNER JOIN socios_domicilios sd1 ON dor1.id_socio = sd1.id_socio");
		qry.append("		AND dor1.id_sucursal_socio = sd1.id_sucursal");
		qry.append("	AND dor1.tipo_domicilio = sd1.tipo_domicilio");
		qry.append(" 	AND dor1.tipo_domicilio LIKE 'EN%' ");
		qry.append(" 	INNER JOIN direccion_orden dor2 ON ord.id_orden = dor2.id_orden ");
		qry.append(" 	INNER JOIN socios_domicilios sd2 ON dor2.id_socio = sd2.id_socio");
		qry.append("  		AND dor2.id_sucursal_socio = sd2.id_sucursal");
		qry.append("  		AND dor2.tipo_domicilio = sd2.tipo_domicilio");		
		qry.append("  		AND dor2.tipo_domicilio LIKE 'TF%'");
		qry.append("  	INNER JOIN paises pa1 ON pa1.id_pais = sd1.id_pais");
		qry.append("  	INNER JOIN paises pa2 ON pa2.id_pais = sd2.id_pais");
		qry.append("  	LEFT JOIN alianza an ON ord.id_alianza = an.id_alianza");
		qry.append("  	LEFT JOIN proveedores p ON a.id_proveedor = p.id_proveedor");
		qry.append("  	LEFT JOIN articulos_autores artau ON a.id_articulo = artau.id_articulo ");
		qry.append("  	LEFT JOIN autores aut ON artau.id_autor = aut.id_autor");
		//qry.append(" WHERE ord.fecha > SYSDATE - 10");solo para desarrollo
		qry.append(" WHERE ");
		qry.append("	ord.fecha >=TRUNC(TRUNC(SYSDATE , 'MM')-1, 'MM')");
		qry.append(" 	AND ord.fecha <= TRUNC(SYSDATE , 'MM')");
		qry.append("  AND a.categoria_seccion != 99");
		qry.append(" 		AND ord.estado IN ('4', '20', '22', '23', '41', '24')");
		qry.append(" 		AND ito.estado IN ('A', 'D', 'F', 'N')");
		//qry.append("  and ord.id_orden = 202036");//solo para desarrollo
		qry.append(" ORDER BY        ord.fecha");

		return MainHelper.getVectorDB(qry.toString());
	}
	
	//AGREGADO FAMILIAS, AUTORES, Y PROVEEDORES
	public static Vector getProductosPorSocios() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT DISTINCT soc.login, ord.fecha, a.titulo, a.id_articulo idArticulo,");
		qry.append(" 	pro.nombre nombrePromo1, ito.id_promocion idPromo1,");
		qry.append(" 	pro2.nombre nombrePromo2, ito.id_promocion2 idPromo2,");
		qry.append(" 	pro3.nombre nombrePromo3, ito.id_promocion3 idPromo3,");
		qry.append(" 	pro4.nombre nombrePromo4, ito.id_promocion4 idPromo4,");
		qry.append(" 	pro5.nombre nombrePromo5 ,ito.id_promocion5 idPromo5,");
		qry.append(" 	cmp.descripcion campaña, cmp.id_campaign idCampaign, an.razon_social ALIANZA,");
		qry.append(" 	ord.id_alianza idAlianza, precio_promocion precio, pa.descripcion pais, ito.item,");
		qry.append(" 	cs.descripcion seccion, cg.descripcion grupo, cf.descripcion familia, ");
		//qry.append(" 	csf.descripcion subfamilia, aut.descripcion autor, p.nombre proveedor");
		qry.append(" 	csf.descripcion subfamilia, p.nombre proveedor");
		qry.append(" FROM");
		qry.append(" 	ORDEN ord");
		qry.append(" 	INNER JOIN SOCIOS2 soc");
		qry.append(" 		ON ord.id_socio = soc.id_socio");
		qry.append(" 		AND ord.id_sucursal_socio=soc.id_sucursal");
		qry.append(" 	INNER JOIN ITEM_ORDEN ito");
		qry.append(" 		ON ord.id_orden = ito.id_orden");
		qry.append("	 INNER JOIN ARTICULOS a");
		qry.append(" 		ON a.id_articulo = ito.id_articulo");
		qry.append(" 	INNER JOIN CATEG_SECCIONES cs");
		qry.append(" 		ON a.categoria_seccion  = cs.categoria_seccion	");
		qry.append(" 	INNER JOIN CATEG_GRUPOS cg");
		qry.append(" 		ON cs.categoria_seccion  = cg.categoria_seccion");
		qry.append("		 AND a.categoria_grupo = cg.categoria_grupo");
		qry.append("	INNER JOIN CATEG_FAMILIAS cf");
		qry.append(" 		ON cg.categoria_seccion  = cf.categoria_seccion");
		qry.append(" 		AND cg.categoria_grupo  = cf.categoria_grupo");
		qry.append(" 		AND a.categoria_familia  = cf.categoria_familia");
		qry.append(" 	INNER JOIN CATEG_SUBFAMILIAS csf");
		qry.append(" 		ON cf.categoria_seccion  = csf.categoria_seccion");
		qry.append(" 		AND cf.categoria_grupo  = csf.categoria_grupo	");
		qry.append(" 		AND cf.categoria_familia  = csf.categoria_familia");
		qry.append(" 		AND a.categoria_subfamilia  = csf.categoria_subfamilia");
		qry.append(" 	INNER JOIN DIRECCION_ORDEN dor");
		qry.append(" 		ON ord.id_orden = dor.id_orden");
		qry.append(" 	INNER JOIN SOCIOS_DOMICILIOS sd");
		qry.append(" 		ON dor.id_socio = sd.id_socio");
		qry.append(" 		AND dor.id_sucursal_socio = sd.id_sucursal");
		qry.append(" 		AND dor.tipo_domicilio =  sd.tipo_domicilio");
		qry.append(" 	INNER JOIN paises pa");
		qry.append(" 		ON pa.id_pais = sd.id_pais");
		qry.append(" 	LEFT JOIN ALIANZA an");
		qry.append(" 		ON ord.id_alianza = an.id_alianza");
		qry.append(" 	LEFT JOIN promo2_cabecera pro");
		qry.append(" 		ON ito.id_promocion = pro.id_promocion");
		qry.append(" 	LEFT JOIN promo2_cabecera pro2");
		qry.append(" 		ON ito.id_promocion2 = pro2.id_promocion");
		qry.append(" 	LEFT JOIN promo2_cabecera pro3");
		qry.append(" 		ON ito.id_promocion3 = pro3.id_promocion");
		qry.append(" 	LEFT JOIN promo2_cabecera pro4");
		qry.append("	 	ON ito.id_promocion4 = pro4.id_promocion");
		qry.append("	 LEFT JOIN promo2_cabecera pro5");
		qry.append("	 	ON ito.id_promocion5 = pro5.id_promocion");
		qry.append(" 	LEFT JOIN campaigns cmp");
		qry.append(" 		ON ito.id_campaign = cmp.id_campaign");
		/*qry.append(" 	LEFT JOIN articulos_autores aa ");
		qry.append(" 	    ON aa.id_articulo = a.id_articulo");
		qry.append("	 	 AND aa.ROLE = 'A01'");
		qry.append("	 LEFT JOIN autores aut");
		qry.append(" 		 ON aa.id_autor = aut.id_autor");*/
		qry.append("	 LEFT JOIN proveedores p ");
		qry.append(" 		ON a.id_proveedor = p.id_proveedor");
		qry.append(" 	 WHERE    ");
		qry.append(" 	 	ord.fecha >=TRUNC(TRUNC(SYSDATE , 'MM')-1, 'MM')");
		qry.append(" 		AND ord.fecha <= TRUNC(SYSDATE , 'MM')");
		//qry.append("	ord.fecha>= to_date ('01/01/2009', 'DD/MM/YYYY')");
		qry.append(" 		AND  a.categoria_seccion != 99");
		qry.append(" 		AND ord.estado IN ('4', '20', '22', '23', '41', '24')");
		qry.append(" 		AND ito.estado IN ('A', 'D', 'F', 'N')");
		qry.append(" 		AND sd.tipo_domicilio LIKE 'TF%'");
		qry.append(" 		AND (ito.id_promocion IS NOT NULL ");
		qry.append(" 		OR ito.id_promocion2 IS NOT NULL");
		qry.append(" 		OR ito.id_promocion3 IS NOT NULL");
		qry.append(" 		OR ito.id_promocion4 IS NOT NULL");
		qry.append("		 OR ito.id_promocion5 IS NOT NULL");
		qry.append("		 OR ito.id_campaign IS NOT NULL)");
		qry.append(" 	ORDER BY ord.fecha ");

		return MainHelper.getVectorDB(qry.toString());
	}
	
	/***
	 * @see Desarrollado para el workFlow  649
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static String getProductosPorSociosTMP2()  throws Exception {
		try {
			Hashtable args = new Hashtable();
			args.put("filename", Contenido.getServletContext().getRealPath(
						MainHelper.RES_TMPL_PATH + "/reporting/reporteDeProductosPorSocios2.htm"));
			Template t = new Template(args);
			Vector datos = getProductosPorSocios2();
			for (int i = 0; i < datos.size(); i++) {				
				Hashtable h = (Hashtable)datos.get(i);
				if(! ((String)h.get("CALLE_ENVI")).equals((String)h.get("CALLE_FAC")) ||
						! ((String)h.get("NUM_ENVI")).equals((String)h.get("NUM_FAC")) ||
						! ((String)h.get("EDIFICIO_ENVI")).equals((String)h.get("EDIFICIO_FACT")) ||
						! ((String)h.get("PISO_ENVI")).equals((String)h.get("PISO_FACT")) ||
						! ((String)h.get("DPTO_ENVI")).equals((String)h.get("DEPTO_FACT")) ||
						! ((String)h.get("CP_ENVI")).equals((String)h.get("CP_FACT")) ||
						! ((String)h.get("ID_LOC_ENVI")).equals((String)h.get("ID_LOC_FACT")) ||
						! ((String)h.get("PROV_ENVI")).equals((String)h.get("PROV_FACT")) ||
						! ((String)h.get("PAIS_ENVI")).equals((String)h.get("PAIS_FACT"))						
				) {
					h.put("esRegalo", "SI");
				}
									
				try {
					h.put("LOGIN", new String(CryptUtil.desEncriptar( ((ByteArrayWarpper)h.get("LOGIN")).getArray()) ));
				} catch (Exception e) {
					h.put("LOGIN", "");
				}
				//datos del workflof
				if (!h.get("NOMBRE_CLIENTE").equals("")) {
					h.put("nombreCliente", h.get("NOMBRE_CLIENTE"));
				}
				if (!h.get("TITULO_ARTICULO").equals("")) {
					h.put("titulo_articulo", h.get("TITULO_ARTICULO"));
				}
				if (!h.get("IDARTICULO").equals("")) {
					h.put("id_articulo", h.get("IDARTICULO"));
				}
				if (!h.get("AUTOR").equals("")) {
					h.put("autor", h.get("AUTOR"));
				}
				if (!h.get("GRUPO").equals("")) {
					h.put("grupo", h.get("GRUPO"));
				}
				if (!h.get("SECCION").equals("")) {
					h.put("seccion", h.get("GRUPO"));
				}	
				//fin datos workflow
											
			}
			t.setParam("repRow", datos);
			return t.output();
		} catch (Exception e) {
			TmkLogger.debug("Error] " + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}
	//Agregar manejo de excepcion
	@SuppressWarnings("unchecked")
	public static String getProductosPorSociosTMP() throws Exception {
		try {
			Hashtable args = new Hashtable();
			args.put("filename", Contenido.getServletContext().getRealPath(
						MainHelper.RES_TMPL_PATH + "/reporting/reporteDeProductosPorSocios.htm"));
			Template t = new Template(args);
			Vector datos = getProductosPorSocios();
			DecimalFormat precio = new DecimalFormat("#.00");
			for (int i=0; i<datos.size(); i++) {
				Hashtable h = (Hashtable)datos.get(i);
				try {
					h.put("LOGIN", new String(CryptUtil.desEncriptar( ((ByteArrayWarpper)h.get("LOGIN")).getArray()) ));
				} catch (Exception e) {
					h.put("LOGIN", "");
				}
				h.put("FECHA", Convert.toStringFromDDMMYYYY((Timestamp)h.get("FECHA")));
				h.put("TITULO", h.get("TITULO") + " (" + h.get("IDARTICULO") + ")");
				if (!h.get("NOMBREPROMO1").equals("") && !h.get("IDPROMO1").equals("")) {
					h.put("NOMBREPROMO1", h.get("NOMBREPROMO1") + " (" + h.get("IDPROMO1") + ")");
				}
				if (!h.get("NOMBREPROMO2").equals("") && !h.get("IDPROMO2").equals("")) {
					h.put("NOMBREPROMO2", h.get("NOMBREPROMO2") + " (" + h.get("IDPROMO2") + ")");
				}
				if (!h.get("NOMBREPROMO3").equals("") && !h.get("IDPROMO3").equals("")) {
					h.put("NOMBREPROMO3", h.get("NOMBREPROMO3") + " (" + h.get("IDPROMO3") + ")");
				}
				if (!h.get("NOMBREPROMO4").equals("") && !h.get("IDPROMO4").equals("")) {
					h.put("NOMBREPROMO4", h.get("NOMBREPROMO4") + " (" + h.get("IDPROMO4") + ")");
				}
				if (!h.get("NOMBREPROMO5").equals("") && !h.get("IDPROMO5").equals("")) {
					h.put("NOMBREPROMO5", h.get("NOMBREPROMO5") + " (" + h.get("IDPROMO5") + ")");
				}
				if (!h.get("NOMBREPROMO5").equals("") && !h.get("IDPROMO5").equals("")) {
					h.put("NOMBREPROMO5", h.get("NOMBREPROMO5") + " (" + h.get("IDPROMO5") + ")");
				}
				if (!h.get("CAMPAÑA").equals("") && !h.get("IDCAMPAIGN").equals("")) {
					h.put("CAMPAÑA", h.get("CAMPAÑA") + " (" + h.get("IDCAMPAIGN") + ")");
				}
				if (!h.get("ALIANZA").equals("") && !h.get("IDALIANZA").equals("")) {
					h.put("ALIANZA", h.get("ALIANZA") + " (" + h.get("IDALIANZA") + ")");
				}
				h.put("PRECIO", precio.format(new Double(h.get("PRECIO").toString())));
				if (!h.get("SECCION").equals("")) {
					h.put("SECCION", h.get("SECCION"));
				}
				if (!h.get("GRUPO").equals("")) {
					h.put("GRUPO", h.get("GRUPO"));
				}
				if (!h.get("FAMILIA").equals("")) {
					h.put("FAMILIA", h.get("FAMILIA"));
				}
				if (!h.get("SUBFAMILIA").equals("")) {
					h.put("SUBFAMILIA", h.get("SUBFAMILIA"));
				}
				/*if (!h.get("AUTOR").equals("")) {
					h.put("AUTOR", h.get("AUTOR"));
				}*/
				if (!h.get("PROVEEDOR").equals("")) {
					h.put("PROVEEDOR", h.get("PROVEEDOR"));
				}
			}
			t.setParam("repRow", datos);
			return t.output();
		} catch (Exception e) {
			TmkLogger.debug("Error] " + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}
	/*
	 * @operador puede ser > o = si se quiere obtener los que compraron
	 * 					   por primera vez o los repetitivos
	 */
	public static Integer getCantidadSociosXOrdenes(String operador) throws Exception {
		Integer retorno = null;
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT count(distinct ord.id_orden) cantidad");
		qry.append(" FROM orden ord");
		qry.append(" INNER JOIN");
		qry.append(" 	item_orden ito");
		qry.append(" 	on ord.id_orden = ito.id_orden");
		qry.append(" WHERE ord.fecha >= TRUNC(TRUNC(SYSDATE , 'MM')-1, 'MM')");
		qry.append(" 	AND ord.fecha < TRUNC(SYSDATE , 'MM')");
		qry.append(" 	AND ord.estado IN ('4', '20', '22', '23', '41', '24')");
		qry.append(" 	AND ito.estado IN ('A', 'D', 'F', 'N')");
		qry.append(" 	AND (ord.id_socio, ord.id_sucursal_socio)");
		qry.append(" 		IN (");
		qry.append(" 				SELECT id_socio, id_sucursal_socio from ");
		qry.append(" 					(");
		qry.append(" 						SELECT count(distinct o.id_orden), ");
		qry.append("							o.id_socio, o.id_sucursal_socio from");
		qry.append(" 							orden o inner join item_orden ito2");
		qry.append(" 							on o.id_orden = ito2.id_orden");
		qry.append(" 						WHERE ");
		qry.append(" 							o.estado IN ('4', '20', '22', '23', '41', '24')");
		qry.append(" 							AND ito2.estado IN ('A', 'D', 'F', 'N')");
		qry.append(" 							GROUP BY id_socio, id_sucursal_socio");
		qry.append(" 							HAVING count(distinct o.id_orden)").append(operador).append("1");
		qry.append("					)");
		qry.append(" 			)");

		Iterator it = MainHelper.getRs(qry.toString());
		while (it.hasNext()) {
			retorno = new Integer(((DynaBean)it.next()).get("cantidad").toString());
		}
		return retorno;
	}

	public static Vector getCarritoDeSociosRegistradosAyerSinCompras() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT s.nombres, s.apellidos, s.login, s.id_socio, s.id_sucursal, s.e_mail1,");
		qry.append(" 	cc.id_articulo, s.f_alta fecha, a.titulo,");
		qry.append(" 	DECODE(a.categoria_seccion, 1, 'Libro', 3, 'Pasatiempo', 4, 'Disco', 5, 'Film') tipo,");
		qry.append(" 	aut.descripcion autor,");
		qry.append(" ROUND (precio_venta_vigente * ( 1");
  	    qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
	    qry.append(" + NVL (tasa_adicional, 0)");
	    qry.append(" + NVL (tasa_percep_video, 0)");
	    qry.append(" FROM tasas");
	    qry.append(" WHERE id_impuesto = a.id_impuesto");
	    qry.append(" AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
	    qry.append(" AND fecha_vigencia =");
	    qry.append(" 		(SELECT MAX (fecha_vigencia)");
	    qry.append("	FROM tasas");
	    qry.append("	WHERE id_impuesto = a.id_impuesto");
	    qry.append("	AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
	    qry.append("	AND fecha_vigencia <= SYSDATE))");
	    qry.append("	/ 100,0)),2) pvp");
		qry.append(" FROM socios2 s ");
		qry.append(" 	INNER JOIN  carrito_compra cc ");
		qry.append(" 	ON s.id_socio = cc.id_socio");
		qry.append(" 	INNER JOIN articulos a ");
		qry.append(" 	ON a.id_articulo = cc.id_articulo ");
		qry.append(" 	AND s.id_sucursal = cc.id_sucursal_socio");
		qry.append(" 	LEFT JOIN articulos_autores aa ");
		qry.append(" 	ON aa.id_articulo = a.id_articulo");
		qry.append(" 	AND aa.ROLE IN ('A01', 'D02')");
		qry.append(" 	LEFT JOIN autores aut");
		qry.append(" 	ON aa.id_autor = aut.id_autor");
		qry.append(" WHERE s.f_alta > TO_DATE (TRUNC (SYSDATE - 1), 'DD/MM/RRRR')");
		qry.append(" 	AND s.f_alta < TO_DATE (TRUNC (SYSDATE), 'DD/MM/RRRR')");
		qry.append(" 	AND PASSWORD IS NOT NULL");
		qry.append(" 	AND (s.id_socio, s.id_sucursal) NOT IN (");
		qry.append(" SELECT id_socio, id_sucursal_socio");
		qry.append(" 	FROM orden");
		qry.append(" WHERE fecha > TO_DATE (TRUNC (SYSDATE - 1), 'DD/MM/RRRR')");
		qry.append(" 	AND fecha < TO_DATE (TRUNC (SYSDATE), 'DD/MM/RRRR'))");
		qry.append(" ORDER BY nombres, apellidos, e_mail1");
		return MainHelper.getVectorDB(qry.toString());
	}

	/*REPORTES*/
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static String reporteDeActualizacionMailExtra() throws Exception {
		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
					MainHelper.RES_TMPL_PATH + "/reporting/reporteDeActualizacionMailExtra.htm"));
		Template t = new Template(args);
		Vector datos = null;
		int total;
		/*Reporte Mensual*/
		datos = getActualizacionMailExtraByEstado(true);
		t.setParam("repRowMensual", datos);
		total = 0;
		for (int i=0; i<datos.size(); i++) {
			total += com.tmk.kernel.Convert.toNumber(((Hashtable)datos.get(i)).get("ROW3").toString(), (Integer)null).intValue();
		}
		t.setParam("totalMensual", new Integer(total));
		JFreeChart chart = Chart.getPieChart(null,
				true, true, false, false,
				Chart.getDefaultPieDataset(datos));
		String fileName = "amem" +
				(new Date().getYear()+1900) + "" +
				(new Date().getMonth()+1) + ".jpg";
		Chart.saveChart(fileName, chart, 250, 150);
		t.setParam("imgMensual","http://" + Globals.DOMINIO_SITIO + MainHelper.RES_REPORTING_IMG_PATH + "/" + fileName);
		/*Reporte Mensual*/
		/*Reporte total*/
		datos = getActualizacionMailExtraByEstado(false);
		t.setParam("repRowAcumulado", datos);
		total = 0;
		for (int i=0; i<datos.size(); i++) {
			total += Convert.toNumber(((Hashtable)datos.get(i)).get("ROW3").toString(), (Integer)null).intValue();
		}
		t.setParam("totalAcumulado", new Integer(total));
		chart = Chart.getPieChart(null,
						true, true, false, false,
						Chart.getDefaultPieDataset(datos));
		fileName = "amea" +
						(new Date().getYear()+1900) + "" +
						(new Date().getMonth()+1) + ".jpg";
		Chart.saveChart(fileName, chart, 250, 150);
		t.setParam("imgAcumulado","http://" + Globals.DOMINIO_SITIO + MainHelper.RES_REPORTING_IMG_PATH + "/" + fileName);
		/*Reporte total*/
		return t.output();
	}

	public static File reporteDeProductosPorSocios() throws Exception {
		File file = new File("reporte.xls");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getProductosPorSociosTMP().getBytes());
		fos.close();
		return file;
	}
	
	public static File reporteDeProductosPorSocios2() throws Exception {
		File file = new File("reporte2.xls");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getProductosPorSociosTMP2().getBytes());
		fos.close();
		return file;
	}

	@SuppressWarnings("unchecked")
	public static String reporteDeClientesNuevosYRepetitivos() throws Exception {
		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
					MainHelper.RES_TMPL_PATH + "/reporting/reporteDeClientesNuevosYRepetitivos.htm"));
		Template t = new Template(args);
		Vector datos = new Vector();
		Hashtable dat = new Hashtable();
		Integer nuevos = getCantidadSociosXOrdenes("=");
		dat.put("ROW1", "Nuevos");
		dat.put("ROW2", nuevos);
		datos.add(dat);
		Integer repetitivos = getCantidadSociosXOrdenes(">");
		dat = new Hashtable();
		dat.put("ROW1", "Repetitivos");
		dat.put("ROW2", repetitivos);
		datos.add(dat);
		JFreeChart chart = Chart.getPieChart(null,
				true, true, false, false,
				Chart.getDefaultPieDataset(datos));
		Calendar inst = Calendar.getInstance();
		inst.add(Calendar.MONTH, -1);

		String fileName = "cnr" +
				inst.get(Calendar.YEAR) + "" +
				(inst.get(Calendar.MONTH)+1) + ".jpg";
		Chart.saveChart(fileName, chart, 280, 150);
		dat = new Hashtable();
		dat.put("ROW1", "Total");
		dat.put("ROW2", new Integer((nuevos.intValue() + repetitivos.intValue())));
		datos.add(dat);
		t.setParam("repRow", datos);
		t.setParam("img","http://" + Globals.DOMINIO_SITIO + MainHelper.RES_REPORTING_IMG_PATH + "/" + fileName);
		t.setParam("fecha", (inst.get(Calendar.MONTH)+1) + "/" + inst.get(Calendar.YEAR));
		return t.output();
	}

	@SuppressWarnings("unchecked")
	public static String reporteDeCarritoDeSociosRegistradosAyerSinCompras() throws Exception {
		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
					MainHelper.RES_TMPL_PATH + "/reporting/reporteDeCarritoDeSociosRegistradosAyerSinCompras.htm"));
		Template t = new Template(args);
		Vector datos = new Vector();
		datos = getCarritoDeSociosRegistradosAyerSinCompras();
		DecimalFormat precio = new DecimalFormat("#.00");
		for (int i=0; i<datos.size(); i++) {
			Hashtable h = (Hashtable)datos.get(i);
			h.put("LOGIN", new String(CryptUtil.desEncriptar( ((ByteArrayWarpper)h.get("LOGIN")).getArray()) ));
			h.put("PVP", precio.format(new Double(h.get("PVP").toString())));
			h.put("FECHA", Convert.toStringFromDDMMYYYY((Timestamp)h.get("FECHA")));
			h.put("NOMBRES", Convert.corregir((String)h.get("NOMBRES"), true));
			h.put("APELLIDOS", Convert.corregir((String)h.get("APELLIDOS"), true));
			h.put("AUTOR", Convert.nombrePropio((String)h.get("AUTOR"), true));
			h.put("TITULO", Convert.corregir((String)h.get("TITULO"), true));
		}
		t.setParam("repRow", datos);
		return t.output();
	}

	@SuppressWarnings("unchecked")
	public static String reporteDeSociosRegistradosTotal() throws Exception {
		try {
			Vector reporte = new Vector();
			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.MONTH, -1);
			calendar.set(Calendar.DATE, 1);
			for (int i=0; i<calendar.getActualMaximum(Calendar.DATE);i++) {
				Hashtable aux = new Hashtable();
				aux.put("fecha", Convert.toString(new Date(calendar.getTimeInMillis())));
				aux.put("registrados", new BigDecimal(0));
				aux.put("sinCompras", new BigDecimal(0));
				aux.put("registracionCorta", new BigDecimal(0));
				reporte.add(aux);
				calendar.add(Calendar.DATE, 1);
			}

			StringBuffer qry = new StringBuffer("");
			qry.append(" SELECT COUNT (bf.id_socio) cantidad, TO_DATE (TRUNC (bf.f_alta), 'dd/mm/rrrr') fecha");
			qry.append(" FROM socios2 s, buffer_socios bf");
			qry.append(" WHERE s.nro_doc = bf.nro_doc");
			qry.append(" AND s.tipo_doc = bf.tipo_doc");
			qry.append(" AND s.nacionalidad = bf.nacionalidad");
			qry.append(" AND s.sexo = bf.sexo");
			qry.append(" AND bf.f_alta >  TO_DATE (TRUNC (TRUNC(SYSDATE, 'MM')-1, 'MM'))");
			qry.append(" AND bf.f_alta <  TO_DATE (TRUNC ((SYSDATE), 'MM' ))");
			qry.append(" GROUP BY TRUNC (bf.f_alta)");
			qry.append(" ORDER BY TRUNC (bf.f_alta)");

			Iterator itSociosReg = MainHelper.getRs(qry.toString());
			while (itSociosReg.hasNext()) {
				DynaBean dyn = (DynaBean) itSociosReg.next();
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(((Timestamp)dyn.get("fecha")).getTime());
				Hashtable aux = (Hashtable)reporte.get(cal.get(Calendar.DATE)-1);
				aux.put("registrados", ((BigDecimal)dyn.get("cantidad")));
			}

			qry = new StringBuffer("");
			qry.append(" SELECT COUNT (bf.id_socio) cantidad, TO_DATE (TRUNC (bf.f_alta), 'dd/mm/rrrr') fecha");
			qry.append(" FROM socios2 s, buffer_socios bf");
			qry.append(" WHERE s.nro_doc = bf.nro_doc");
			qry.append(" AND s.tipo_doc = bf.tipo_doc");
			qry.append(" AND s.nacionalidad = bf.nacionalidad");
			qry.append(" AND s.sexo = bf.sexo");
			qry.append(" AND bf.f_alta > TO_DATE (TRUNC (TRUNC(SYSDATE, 'MM')-1, 'MM'))");
			qry.append(" AND bf.f_alta < TO_DATE (TRUNC ((SYSDATE), 'MM' ))");
			qry.append(" AND (s.id_socio, s.id_sucursal) NOT IN (");
			qry.append(" 		SELECT id_socio, id_sucursal_socio");
			qry.append(" 		FROM orden");
			qry.append(" 		WHERE fecha > TO_DATE (TRUNC (TRUNC(SYSDATE, 'MM')-1, 'MM'))");
			qry.append(" 			AND fecha <  TO_DATE (TRUNC ((SYSDATE), 'MM' )))");
			qry.append(" GROUP BY TRUNC (bf.f_alta)");
			qry.append(" ORDER BY TRUNC (bf.f_alta)");

			Iterator itSociosRegSinCompras = MainHelper.getRs(qry.toString());
			while (itSociosRegSinCompras.hasNext()) {
				DynaBean dyn = (DynaBean) itSociosRegSinCompras.next();
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(((Timestamp)dyn.get("fecha")).getTime());
				Hashtable aux = (Hashtable)reporte.get(cal.get(Calendar.DATE)-1);
				aux.put("sinCompras", ((BigDecimal)dyn.get("cantidad")));
			}

			qry = new StringBuffer("");
			qry.append(" SELECT COUNT(bf.id_socio) cantidad, TO_DATE (TRUNC (bf.f_alta), 'dd/mm/rrrr') fecha ");
			qry.append(" FROM socios_tmk bf ");
			qry.append(" WHERE");
			qry.append(" 	bf. f_alta > TO_DATE (TRUNC (TRUNC(SYSDATE, 'MM')-1, 'MM'))");
			qry.append(" 	AND bf. f_alta < TO_DATE (TRUNC ((SYSDATE), 'MM' ))");
			qry.append(" GROUP BY TRUNC(bf.f_alta)");
			qry.append(" ORDER BY TRUNC(bf.f_alta)");

			Iterator itSociosRegCorta = MainHelper.getRs(qry.toString());
			while (itSociosRegCorta.hasNext()) {
				DynaBean dyn = (DynaBean) itSociosRegCorta.next();
				Calendar cal = Calendar.getInstance();
				cal.setTimeInMillis(((Timestamp)dyn.get("fecha")).getTime());
				Hashtable aux = (Hashtable)reporte.get(cal.get(Calendar.DATE)-1);
				aux.put("registracionCorta", ((BigDecimal)dyn.get("cantidad")));
				BigDecimal sinCompras = (BigDecimal)aux.get("sinCompras");
				aux.put("sinCompras", ((BigDecimal)dyn.get("cantidad")).add(sinCompras));
				BigDecimal registrados = (BigDecimal)aux.get("registrados");
				aux.put("registrados", ((BigDecimal)dyn.get("cantidad")).add(registrados));
			}

			Hashtable args = new Hashtable();
			args.put("filename", Contenido.getServletContext().getRealPath(
						MainHelper.RES_TMPL_PATH + "/reporting/reporteDeSociosRegistradosTotal.htm"));
			Template t = new Template(args);
			t.setParam("repRow", reporte);
			return t.output();

		} catch (Exception e) {
			TmkLogger.error("Report] reporteDeSociosRegistradosTotal) error=" + e.toString() + MainHelper.getMessage(e));
			throw e;
		}


	}

	@SuppressWarnings("unchecked")
	public static String reporteDeSociosRegistradosAyerSinCompras() throws Exception{
		try {
			Vector reporte = new Vector();
			StringBuffer qry = new StringBuffer("");
			qry.append(" select * from ");
			qry.append(" (select nombres, apellidos, e_mail1 login, f_alta from buffer_socios");
			qry.append(" where f_alta > to_date (trunc(sysdate-1) , 'DD/MM/RRRR')");
			qry.append(" and  f_alta < to_date (trunc(sysdate) , 'DD/MM/RRRR')");
			qry.append(" and password is not null");
			qry.append(" and (id_socio, id_sucursal) not in");
			qry.append(" (");
			qry.append(" select id_socio, id_sucursal_socio from orden");
			qry.append(" where fecha > to_date (trunc(sysdate-1) , 'DD/MM/RRRR')");
			qry.append(" and fecha < to_date (trunc(sysdate) , 'DD/MM/RRRR')");
			qry.append(" )");
			qry.append(" union ");
			qry.append(" select nombres, apellidos, login, f_alta from socios_tmk");
			qry.append(" where f_alta > to_date (trunc(sysdate-1) , 'DD/MM/RRRR')");
			qry.append(" and  f_alta < to_date (trunc(sysdate) , 'DD/MM/RRRR'))");
			qry.append(" order by nombres, apellidos, login");
			Iterator itSociosReg = MainHelper.getRs(qry.toString());
			while (itSociosReg.hasNext()) {
				DynaBean dyn = (DynaBean) itSociosReg.next();
				Hashtable aux = new Hashtable();
				aux.put("login", dyn.get("login"));
				aux.put("nombre", dyn.get("nombres"));
				aux.put("apellido", dyn.get("apellidos"));
				aux.put("fecha", Convert.toStringFromDDMMYYYY((Timestamp)dyn.get("f_alta")));
				reporte.add(aux);
			}
			Hashtable args = new Hashtable();
			args.put("filename", Contenido.getServletContext().getRealPath(
						MainHelper.RES_TMPL_PATH + "/reporting/reporteDeSociosRegistradosAyerSinCompras.htm"));
			Template t = new Template(args);
			t.setParam("repRow", reporte);
			return t.output();
		} catch (Exception e) {
			TmkLogger.error("Report] reporteDeSociosRegistradosAyerSinCompras) error=" + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
	}

	/***
	 * reporte que informa semanalmente los usuarios que se registraron en tematika-popego
	 */
	public static File reporteDeSociosRegitradosPopegoSemanal() throws Exception {
		File file = new File("reporteSemanalPopego.xls");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getSociosRegistadosXSemanal().getBytes());
		fos.close();
		return file;
	}
	/*REPORTES*/

	private static String getSociosRegistadosXSemanal() throws Exception{
			try {
				Hashtable<String, String> args = new Hashtable<String,String>();
				args.put("filename", Contenido.getServletContext().getRealPath(
							MainHelper.RES_TMPL_PATH + "/reporting/reporteDeSociosRegistradosXSemanaPopego.htm"));
				
				Template t = new Template(args);
				Hashtable<String, String> hashSocios = null;
				Vector<Hashtable<String, String>> vec = new Vector<Hashtable<String,String>>();
				Connection con = DBUtil.buildConnection();

				StringBuffer qry = new StringBuffer();
				qry.append(" select soc.nombres,soc.apellidos, ");
				qry.append(" soc.e_mail1,soc.login, ");
				qry.append( "si.dominio,si.f_alta");
				qry.append(" from socios2 soc, socios_integracion si ");
				qry.append(" where soc.id_socio = si.id_socio and ");
				qry.append(" soc.id_sucursal = si.id_sucursal and ");
				qry.append(" si.dominio = 'popego.com' and ");
				qry.append(" sysdate - 7 <= si.f_alta ");
				
				Statement stm = con.createStatement(); 
				ResultSet res =  stm.executeQuery(qry.toString());
				while(res.next()) {
					hashSocios = new Hashtable<String, String>();
					hashSocios.put("NOMBRES",res.getString("NOMBRES"));
					hashSocios.put("APELLIDOS", res.getString("APELLIDOS"));
					hashSocios.put("DOMINIO", res.getString("DOMINIO"));
					hashSocios.put("EMAIL", res.getString("E_MAIL1"));
					hashSocios.put("F_ALTA", res.getString("F_ALTA"));
					vec.add(hashSocios);
				}
				t.setParam("CANTIDAD", vec.size());				
				t.setParam("repRow", vec);
				return t.output();
			} catch (Exception e) {
				TmkLogger.debug("Error] " + e.toString() + MainHelper.getMessage(e));
				throw e;
			}

	}
	
	/**
	 * creado para enviar etadisticas sobre cantidad de veces que se "clickearon" sobre las vidrieras
	 * @return File
	 * @throws Exception
	 */
	public static File reporteDeVecesQueSeScroleoEnLaMesa() throws Exception {
		File file = new File("reporteScrolDeVidriera.xls");
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(getDatosSobreScrol().getBytes());
		fos.close();
		return file;
	}
	/**
	 * Proceo que arma el reporte de tiempos del proceso de compras
	 * @return
	 * @throws Exception
	 */
	//public static File reporteDeTiempoDeProcesoDeCompras() throws Exception {
	public static String reporteDeTiempoDeProcesoDeCompras() throws Exception {
		//File file = new File("reporteDeTiempoDeProcesoDeCompras.xls");
		//FileOutputStream fos = new FileOutputStream(file);
		//fos.write(getReporteDeTiempoDeProcesoDeCompras().getBytes());
		//fos.close();
		//return file;
		return getReporteDeTiempoDeProcesoDeCompras();
	}
	
	/**
	 * Obtiene los valores del array definido en Globals, 
	 * y levanta la template correspondiente  para armar el reporte de 
	 * paginciones por seccion
	 * @return
	 * @throws Exception
	 */
	private static String getDatosSobreScrol() throws Exception {
		try {
			Hashtable<String, String> args = new Hashtable<String,String>();
			args.put("filename", Contenido.getServletContext().getRealPath(
						MainHelper.RES_TMPL_PATH + "/reporting/reporteDiarioDePaginaciones.htm"));
			
			Template t = new Template(args);
			Hashtable<String, Object> hashSecciones = null;
			Vector<Hashtable<String, Object>> vec = new Vector<Hashtable<String,Object>>();
			Vector<Hashtable<String, Object>> vecFiltros = new Vector<Hashtable<String,Object>>();
			
			//has de paginaciones
			hashSecciones = new Hashtable<String, Object>();
			hashSecciones.put("SECCION", "Libros");
			hashSecciones.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXSeccion()[0]);
			vec.add(hashSecciones);
			hashSecciones = new Hashtable<String, Object>();
			hashSecciones.put("SECCION", "Musica");
			hashSecciones.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXSeccion()[3]);
			vec.add(hashSecciones);
			hashSecciones = new Hashtable<String, Object>();
			hashSecciones.put("SECCION", "Pasatiempos");
			hashSecciones.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXSeccion()[2]);
			vec.add(hashSecciones);
			hashSecciones = new Hashtable<String, Object>();
			hashSecciones.put("SECCION", "Peliculas");
			hashSecciones.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXSeccion()[4]);
			vec.add(hashSecciones);
			
			//cambios de filtros
			Hashtable<String, Object> hashFiltros = new Hashtable<String, Object>();
			hashFiltros.put("SECCION", "Libros");
			hashFiltros.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXFiltro()[0]);
			vecFiltros.add(hashFiltros);
			hashFiltros = new Hashtable<String, Object>();
			hashFiltros.put("SECCION", "Musica");
			hashFiltros.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXFiltro()[3]);
			vecFiltros.add(hashFiltros);
			hashFiltros = new Hashtable<String, Object>();
			hashFiltros.put("SECCION", "Pasatiempos");
			hashFiltros.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXFiltro()[2]);
			vecFiltros.add(hashFiltros);
			hashFiltros = new Hashtable<String, Object>();
			hashFiltros.put("SECCION", "Peliculas");
			hashFiltros.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXFiltro()[4]);
			vecFiltros.add(hashFiltros);
			hashFiltros = new Hashtable<String, Object>();
			hashFiltros.put("SECCION", "Inicio");
			hashFiltros.put("TOTAL_PAGINACIONES",""+Globals.getPaginacionesXFiltro()[1]);
			vecFiltros.add(hashFiltros);
						
			t.setParam("repRow", vec);
			t.setParam("repRowFiltros", vecFiltros);
			t.setParam("fechaDesde", Convert.toStringLargo(Globals.FECHA_INICIO));
			t.setParam("fecha", Convert.toStringLargo(new Date()));
			return t.output();
		} catch (Exception e) {
			TmkLogger.error("Creando template de vidriea "+ e);
		}
		return null;
	}
	
	/***
	 * inserta/actualiza los registos en paginacion_vidriera
	 */
	public static void actualizadorDeVecesQueSeScroleoEnLaMesa () {
		
		try {
			//Connection con = ConnectionProvider.getConection();
			
		}catch (Exception e) {
			
		}
	}
	
	public static String getReporteDeTiempoDeProcesoDeCompras() throws Exception {
		try {				
			Template t = (Template)ServiceLocator.getTemplateService().getTemplate("tmpTiemposDeCompra");
			Iterator listaDeDatos = ProcesoCompraUtilImp.getInstance().getListaDeTiempoEnProcesoDeCompras().iterator();
			Hashtable<String, Object> filas = null;
			Vector<Hashtable<String, Object>> tabla = new Vector<Hashtable<String,Object>>();
			
			while(listaDeDatos.hasNext()) {
				HashMap<String, Object> mapa = (HashMap<String, Object>)listaDeDatos.next();
				//claves del map
				Iterator<String> itClaves = mapa.keySet().iterator();
				filas = new Hashtable<String, Object>(5);
				while(itClaves.hasNext()) {					
					String clave = itClaves.next();					
					filas.put(clave, mapa.get(clave));
				}
				Long inicio = ((Date)mapa.get("fechaInicio")).getTime();
				Long fFinalizacion = ((Date)mapa.get("fechaFinalizacion")).getTime();
				
				Calendar cal1 = Calendar.getInstance(); 
				Calendar cal2 = Calendar.getInstance(); 
				// Set the date for both of the calendar instance        
				cal1.setTimeInMillis(inicio.longValue());         
				cal2.setTimeInMillis(fFinalizacion.longValue()); 
				filas.put("fechaInicio",cal1.getTime().toLocaleString());
				filas.put("fechaFinalizacion",cal2.getTime().toLocaleString());
				
				// Get the represented date in milliseconds         
				long milis1 = cal1.getTimeInMillis();         
				long milis2 = cal2.getTimeInMillis();          
				// Calculate difference in milliseconds 			    
				long diff = milis2 - milis1; 	
				// Calculate difference in seconds 			      
				long diffSeconds = diff / 1000; 			       
				// Calculate difference in minutes 		    
				long diffMinutes = diff / (60 * 1000); 			     
				// Calculate difference in hours 				        
				long diffHours = diff / (60 * 60 * 1000); 			     
				// Calculate difference in days 				        
				//long diffDays = diff / (24 * 60 * 60 * 1000); 				    
				/*
				System.out.println("In milliseconds: " + diff + " milliseconds."); 				 
				System.out.println("In seconds: " + diffSeconds + " seconds.");
				System.out.println("In minutes: " + diffMinutes + " minutes.");			  
				System.out.println("In hours: " + diffHours + " hours."); 			  
				System.out.println("In days: " + diffDays + " days.");
				*/
				//filas.put("tiempoTotal", diffHours + " Horas " + diffMinutes +" Minutos "+ diffSeconds+ " Segundos");
				filas.put("tiempoTotal", diffHours + ":" + diffMinutes +":"+ diffSeconds);
				tabla.add(filas);
			}
			if(tabla.size() > 0 ) {
				t.setParam("repRow", tabla);
			}
			
			return t.output();
		}catch (Exception e) {
			throw e;
		}		
	}
}

