package com.tmk.service.categoria;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;
import org.apache.commons.beanutils.DynaBean;
import com.tmk.bus.categoria.Categoria;
import com.tmk.bus.categoria.CategoriaPK;
import com.tmk.controllers.MainHelper;
import com.tmk.generacion.ContenidosEstaticos;
import com.tmk.kernel.Convert;
import com.tmk.kernel.DBUtil;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.setup.Contenido;
import com.tmk.util.HTML.Template;


public class CategoriaService {

	public static Categoria categoria[];

	public static boolean CATEGORIAS_CARGADAS = false;

	public static void cargarCategorias() {
		CATEGORIAS_CARGADAS = false;
		Globals.CATEGORIAS_LOADED = CATEGORIAS_CARGADAS;
		try {
			Categoria catAux[];
			Categoria [][] listas =  new Categoria[3][];
			catAux = getSecciones();
			listas[0] = getGrupos();
			listas[1] = getFamilias();
			listas[2] = getSubFamilias();
			for (int i=0; i<catAux.length; i++) {
				set(catAux[i], listas, 0);
			}
			categoria = catAux;
			CATEGORIAS_CARGADAS = true;
			Globals.CATEGORIAS_LOADED = CATEGORIAS_CARGADAS;
		} catch (Exception e) {
			TmkLogger.error("Error cargando categorias " + e.toString() + MainHelper.getMessage(e));
		}
	}


	private static void set(Categoria cat, Categoria[][] lista, int nivel) {
		for (int i=0; i<lista[nivel].length; i++) {
			if (lista[nivel][i].esSubcategoriaDe(cat)) {
				cat.setSubCategoria(lista[nivel][i]);
				if (nivel<lista.length-1) {
					set(lista[nivel][i], lista, (nivel+1));
				}
			}
		}
	}

	public static Categoria getCategoriaByPK(Categoria[] categoria, CategoriaPK categoriaPK, int nivel){
			Categoria cat = null;
			for (int j=0; j<categoria.length; j++) {
				if (categoria[j].getCategoriaPK().getPK()[nivel].equals(categoriaPK.getPK()[nivel])) {
					if (nivel == categoriaPK.getPK().length-1) {
						cat = categoria[j];
					} else {
						cat = getCategoriaByPK(categoria[j].getSubCategoria(), categoriaPK, (nivel+1));
					}
				}
			}
			return cat;
	}


	private static Categoria[] getSecciones() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT DISTINCT c.categoria_seccion, DECODE(c.categoria_seccion, 3, 'PASATIEMPOS',c.descripcion) descripcion");
		qry.append(" FROM categ_secciones c, estado_articulos ea");
		qry.append(" WHERE c.categoria_seccion = ea.categoria_seccion");
		qry.append(" 	AND ea.estado = 'S'");
		qry.append(" 	AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 	AND NVL (fecha_hasta, SYSDATE) >= SYSDATE");
		qry.append(" ORDER BY descripcion");
		Iterator it = MainHelper.getRs(qry.toString());
		Vector<Categoria> aux = new Vector<Categoria>();
		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			aux.add(new Categoria(new CategoriaPK(new Integer[]{ new Integer(dyn.get("categoria_seccion").toString()) }), dyn.get("descripcion").toString()));
		}
		return (Categoria[])aux.toArray( new Categoria[aux.size()]);
	}

	private static Categoria[] getGrupos() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT distinct c.categoria_seccion , c.categoria_grupo, c.descripcion");
		qry.append(" FROM categ_grupos c, estado_articulos ea");
		qry.append(" WHERE c.categoria_seccion = ea.categoria_seccion");
		qry.append(" 	AND NVL(ea.categoria_grupo, c.categoria_grupo) = c.categoria_grupo");
		qry.append(" 	AND ea.categoria_familia IS NULL");
		qry.append(" 	AND ea.categoria_subfamilia IS NULL");
		qry.append(" 	AND ea.estado = 'S'");
		qry.append(" 	AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 	AND NVL (fecha_hasta, SYSDATE) >= SYSDATE");
		qry.append(" 	AND (c.categoria_seccion, c.categoria_grupo) NOT IN (");
		qry.append(" 		SELECT ctemp.categoria_seccion, ctemp.categoria_grupo");
		qry.append(" 		FROM categ_grupos ctemp, estado_articulos ea");
		qry.append(" 		WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append(" 			AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append(" 			AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append(" 			AND ea.categoria_familia IS NULL");
		qry.append(" 			AND ea.categoria_subfamilia IS NULL");
		qry.append(" 			AND ea.estado != 'S'");
		qry.append(" 			AND ea.editorial IS NULL");
		qry.append(" 			AND ea.proveedor IS NULL");
		qry.append(" 			AND ea.importe_minimo IS NULL");
		qry.append(" 			AND ea.importe_maximo IS NULL");
		qry.append(" 			AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 			AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append(" ORDER BY c.descripcion");
		Iterator it = MainHelper.getRs(qry.toString());
		Vector<Categoria> aux = new Vector<Categoria>();
		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			aux.add(new Categoria(new CategoriaPK(new Integer[]{ new Integer(dyn.get("categoria_seccion").toString()), new Integer(dyn.get("categoria_grupo").toString())}),(String)dyn.get("descripcion")));
		}
		return (Categoria[])aux.toArray( new Categoria[aux.size()]);
	}


	private static Categoria[] getFamilias() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT distinct c.categoria_seccion , c.categoria_grupo, c.categoria_familia, c.descripcion");
		qry.append(" FROM categ_familias c, estado_articulos ea");
		qry.append(" WHERE");
		qry.append(" 	c.descripcion not in ('S/D', 'S/D.') AND c.categoria_seccion = ea.categoria_seccion");
		qry.append(" 	AND NVL(ea.categoria_grupo, c.categoria_grupo) = c.categoria_grupo");
		qry.append(" 	AND NVL(ea.categoria_familia, c.categoria_familia) = c.categoria_familia");
		qry.append(" 	AND ea.categoria_subfamilia IS NULL");
		qry.append(" 	AND ea.estado = 'S'");
		qry.append(" 	AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 	AND NVL (fecha_hasta, SYSDATE) >= SYSDATE");
		qry.append(" 	AND (c.categoria_seccion, c.categoria_grupo) NOT IN (");
		qry.append(" 		SELECT ctemp.categoria_seccion, ctemp.categoria_grupo");
		qry.append("		FROM categ_grupos ctemp, estado_articulos ea");
		qry.append("		WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append("			AND ctemp.categoria_grupo = c.categoria_grupo");
		qry.append("			AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append("			AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append("			AND ea.categoria_familia IS NULL");
		qry.append("			AND ea.categoria_subfamilia IS NULL");
		qry.append("				AND ea.estado != 'S'");
		qry.append("			AND ea.editorial IS NULL");
		qry.append("			AND ea.proveedor IS NULL");
		qry.append("			AND ea.importe_minimo IS NULL");
		qry.append("			AND ea.importe_maximo IS NULL");
		qry.append("			AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append("			AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append("			AND (c.categoria_seccion, c.categoria_grupo, c.categoria_familia) NOT IN (");
		qry.append("				SELECT ctemp.categoria_seccion, ctemp.categoria_grupo, ctemp.categoria_familia");
		qry.append("				FROM categ_familias ctemp, estado_articulos ea");
		qry.append("				WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append("					AND ctemp.categoria_grupo = c.categoria_grupo");
		qry.append("					AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append("					AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append("					AND ctemp.categoria_familia = ea.categoria_familia");
		qry.append("					AND ea.categoria_subfamilia IS NULL");
		qry.append("					AND ea.estado != 'S'");
		qry.append("					AND ea.editorial IS NULL");
		qry.append("					AND ea.proveedor IS NULL");
		qry.append("					AND ea.importe_minimo IS NULL");
		qry.append("					AND ea.importe_maximo IS NULL");
		qry.append("					AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append("					AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append(" ORDER BY c.descripcion");
		Iterator it = MainHelper.getRs(qry.toString());
		Vector<Categoria> aux = new Vector<Categoria>();
		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			aux.add(new Categoria(new CategoriaPK(new Integer[]{ new Integer(dyn.get("categoria_seccion").toString()), new Integer(dyn.get("categoria_grupo").toString()), new Integer(dyn.get("categoria_familia").toString())}),(String)dyn.get("descripcion")));
		}
		return (Categoria[])aux.toArray( new Categoria[aux.size()]);
	}

	private static Categoria[] getSubFamilias() throws Exception {
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT distinct c.categoria_seccion , c.categoria_grupo, c.categoria_familia, c.categoria_subfamilia, c.descripcion");
		qry.append(" FROM categ_subfamilias c, estado_articulos ea");
		qry.append(" WHERE");
		qry.append(" 	c.descripcion not in ('S/D', 'S/D.') AND c.categoria_seccion = ea.categoria_seccion");
		qry.append(" 	AND NVL(ea.categoria_grupo, c.categoria_grupo) = c.categoria_grupo");
		qry.append(" 	AND NVL(ea.categoria_familia, c.categoria_familia) = c.categoria_familia");
		qry.append(" 	AND NVL(ea.categoria_subfamilia, c.categoria_subfamilia) = c.categoria_subfamilia");
		qry.append(" 	AND ea.estado = 'S'");
		qry.append(" 	AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 	AND NVL (fecha_hasta, SYSDATE) >= SYSDATE");
		qry.append(" 	AND (c.categoria_seccion, c.categoria_grupo) NOT IN (");
		qry.append(" 		SELECT ctemp.categoria_seccion, ctemp.categoria_grupo");
		qry.append(" 		FROM categ_grupos ctemp, estado_articulos ea");
		qry.append(" 		WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append(" 			AND ctemp.categoria_grupo = c.categoria_grupo");
		qry.append(" 			AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append(" 			AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append(" 			AND ea.categoria_familia IS NULL");
		qry.append(" 			AND ea.categoria_subfamilia IS NULL");
		qry.append(" 			AND ea.estado != 'S'");
		qry.append(" 			AND ea.editorial IS NULL");
		qry.append(" 			AND ea.proveedor IS NULL");
		qry.append(" 			AND ea.importe_minimo IS NULL");
		qry.append(" 			AND ea.importe_maximo IS NULL");
		qry.append(" 			AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 			AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append(" 			AND (c.categoria_seccion, c.categoria_grupo, c.categoria_familia) NOT IN (");
		qry.append(" 				SELECT ctemp.categoria_seccion, ctemp.categoria_grupo, ctemp.categoria_familia");
		qry.append(" 				FROM categ_familias ctemp, estado_articulos ea");
		qry.append(" 				WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append(" 					AND ctemp.categoria_grupo = c.categoria_grupo");
		qry.append(" 					AND ctemp.categoria_familia = c.categoria_familia");
		qry.append(" 					AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append(" 					AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append(" 					AND ctemp.categoria_familia = ea.categoria_familia");
		qry.append(" 					AND ea.categoria_subfamilia IS NULL");
		qry.append(" 					AND ea.estado != 'S'");
		qry.append(" 					AND ea.editorial IS NULL");
		qry.append(" 					AND ea.proveedor IS NULL");
		qry.append(" 					AND ea.importe_minimo IS NULL");
		qry.append(" 					AND ea.importe_maximo IS NULL");
		qry.append(" 					AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 					AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append(" 					AND (c.categoria_seccion, c.categoria_grupo, c.categoria_familia, c.categoria_subfamilia) NOT IN (");
		qry.append(" 						SELECT ctemp.categoria_seccion, ctemp.categoria_grupo, ctemp.categoria_familia, ctemp.categoria_subfamilia");
		qry.append(" 						FROM categ_subfamilias ctemp, estado_articulos ea");
		qry.append(" 						WHERE ctemp.categoria_seccion = c.categoria_seccion");
		qry.append(" 							AND ctemp.categoria_grupo = c.categoria_grupo");
		qry.append(" 							AND ctemp.categoria_familia = c.categoria_familia");
		qry.append(" 							AND ctemp.categoria_seccion = ea.categoria_seccion");
		qry.append(" 							AND ctemp.categoria_grupo = ea.categoria_grupo");
		qry.append(" 							AND ctemp.categoria_familia = ea.categoria_familia");
		qry.append(" 							AND ctemp.categoria_subfamilia = ea.categoria_subfamilia");
		qry.append(" 							AND ea.estado != 'S'");
		qry.append(" 							AND ea.editorial IS NULL");
		qry.append(" 							AND ea.proveedor IS NULL");
		qry.append(" 							AND ea.importe_minimo IS NULL");
		qry.append(" 							AND ea.importe_maximo IS NULL");
		qry.append(" 							AND NVL (fecha_desde, SYSDATE) <= SYSDATE");
		qry.append(" 							AND NVL (fecha_hasta, SYSDATE) >= SYSDATE)");
		qry.append(" ORDER BY c.descripcion");
		Iterator it = MainHelper.getRs(qry.toString());
		Vector<Categoria> aux = new Vector<Categoria>();
		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			aux.add(new Categoria(new CategoriaPK(new Integer[]{ new Integer(dyn.get("categoria_seccion").toString()), new Integer(dyn.get("categoria_grupo").toString()), new Integer(dyn.get("categoria_familia").toString()), new Integer(dyn.get("categoria_subfamilia").toString())}),(String)dyn.get("descripcion")));
		}
		return (Categoria[])aux.toArray( new Categoria[aux.size()]);
	}

	public static String getURL(Categoria categoria) {
		StringBuffer url = new StringBuffer();
		url.append("/");
		if (categoria.getCategoriaPK().getPK()[0].intValue() == 4) {
			url.append("cds");
		} else if (categoria.getCategoriaPK().getPK()[0].intValue() == 5) {
			url.append("dvds");
		} else {
			url.append(Convert.sinTildesNiEnie(categoria.getDescripcion().toLowerCase()));
		}
		while (categoria.getSubCategoria().length>0) {
			categoria = categoria.getSubCategoria()[0];
			url.append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(categoria.getDescripcion(), true)).toLowerCase()));
			url.append("--").append(categoria.getCategoriaPK().getPK()
					[categoria.getCategoriaPK().getPK().length-1]);
		}
		return url.toString();
	}


	public static Categoria getCategoriaEspecifica(CategoriaPK id) {
		Categoria categoria = null;
		for (int i=id.getPK().length; i>0; i--) {
			Integer pk [] = new Integer[i];
			for (int j=0; j<pk.length; j++) {
				pk[j] = id.getPK()[j];
			}
			CategoriaPK catPK = new CategoriaPK(pk);
			Categoria res = getCategoriaByPK(CategoriaService.categoria, catPK, 0);
			if (res!= null) {
				Categoria aux = new Categoria(catPK, res.getDescripcion());
				if (categoria == null) {
					categoria = aux;
				} else {
					aux.setSubCategoria(categoria);
					categoria = aux;
				}
			}
		}

		return categoria;
	}


	public static String getArbolCategoria (CategoriaPK categoriaPK) {
		return getArbolCategoria (categoriaPK, "/categoria/arbol.htm");
	}

	@SuppressWarnings("unchecked")
	public static String getArbolCategoria (CategoriaPK categoriaPK, String urlTMP) {

		String retorno = "";
		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(
					MainHelper.RES_TMPL_PATH + urlTMP));
		try {
			Template t = new Template (args);
			Categoria categoria =
				CategoriaService.getCategoriaByPK(
						CategoriaService.categoria, new CategoriaPK(new Integer[] {categoriaPK.getPK()[0]}), 0);
			t.setParam("desSeccion", categoria.getDescripcion().toUpperCase());
			/*GRUPOS*/
			Vector grupos = new Vector();
			for (int i=0; i<categoria.getSubCategoria().length; i++) {

				Hashtable hGrupo = new Hashtable();
				hGrupo.put("desGrupo", Convert.capitalizar(categoria.getSubCategoria()[i].getDescripcion(), false));
				hGrupo.put("hrefGrupo", "/catalogo" + getURL(getCategoriaEspecifica(categoria.getSubCategoria()[i].getCategoriaPK())) + ".htm");
				if (categoria.getSubCategoria()[i].getCantidadArticulosDisponibles() == -1) {
					categoria.getSubCategoria()[i].setCantidadArticulosDisponibles(
							getCantidadArticulosXCategoria(categoria.getSubCategoria()[i].getCategoriaPK()));
				}
				hGrupo.put("cantGrupo", categoria.getSubCategoria()[i].getCantidadArticulosDisponibles() + "");


				/*FAMILIA*/

				Vector familias = new Vector();
				if (categoriaPK.getPK().length>1 &&
						categoria.getSubCategoria()[i].getSubCategoria() != null &&
						categoria.getSubCategoria()[i].getCategoriaPK().getPK()[1].equals(categoriaPK.getPK()[1])) {
					for (int j=0; j<categoria.getSubCategoria()[i].getSubCategoria().length; j++) {
						Hashtable hFamilia = new Hashtable();
						hFamilia.put("desFamilia", Convert.capitalizar(categoria.getSubCategoria()[i].getSubCategoria()[j].getDescripcion(), false));
						hFamilia.put("hrefFamilia", "/catalogo" + getURL(getCategoriaEspecifica(categoria.getSubCategoria()[i].getSubCategoria()[j].getCategoriaPK())) + ".htm");
						if (categoria.getSubCategoria()[i].getSubCategoria()[j].getCantidadArticulosDisponibles() == -1) {
							categoria.getSubCategoria()[i].getSubCategoria()[j].setCantidadArticulosDisponibles(
									getCantidadArticulosXCategoria(categoria.getSubCategoria()[i].getSubCategoria()[j].getCategoriaPK()));
						}
						hFamilia.put("cantFamilia", categoria.getSubCategoria()[i].getSubCategoria()[j].getCantidadArticulosDisponibles() + "");


						/*SUBFAMILIA*/
						Vector subFamilias = new Vector();
						if (categoriaPK.getPK().length>2 &&
							categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria() != null &&
							categoria.getSubCategoria()[i].getSubCategoria()[j].getCategoriaPK().getPK()[2].equals(categoriaPK.getPK()[2])) {
							for (int k=0; k<categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria().length; k++) {
								Hashtable hSubFamilia = new Hashtable();
								hSubFamilia.put("desSubFamilia", Convert.capitalizar(categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].getDescripcion(), false));
								hSubFamilia.put("hrefSubFamilia",  "/catalogo" + getURL(getCategoriaEspecifica(categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].getCategoriaPK())) + ".htm");
								if (categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].getCantidadArticulosDisponibles() == -1) {
									categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].setCantidadArticulosDisponibles(
											getCantidadArticulosXCategoria(categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].getCategoriaPK()));
								}
								hSubFamilia.put("cantSubFamilia", categoria.getSubCategoria()[i].getSubCategoria()[j].getSubCategoria()[k].getCantidadArticulosDisponibles() + "");
								subFamilias.add(hSubFamilia);
							}
							hFamilia.put("subFamilia", subFamilias);
						}
						/*SUBFAMILIA*/
						familias.add(hFamilia);
					/*FAMILIA*/
					}
					hGrupo.put("familia", familias);
				}
				grupos.add(hGrupo);
				t.setParam("grupo", grupos);
			}
			/*GRUPOS*/
			retorno = t.output();
		} catch (Exception e) {
			TmkLogger.error(e.toString() + MainHelper.getMessage(e));
		}
		return retorno;
	}

	/***
	 * @param categoriaPK
	 * @param urlTMP
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getCategoriaRediseno (CategoriaPK categoriaPK, String urlTMP,int cantParaMostrar,Integer mostrarTodos) {
		//en este metodo solo levanto la template y se la paso a la funcion jutno con el  nivel
		//String retorno = "";
		Hashtable args = new Hashtable();
		args.put("filename", Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH + urlTMP));
		Template t = null;
		try {
			t = new Template (args);
			Categoria categoria = CategoriaService.getCategoriaByPK(
						CategoriaService.categoria, new CategoriaPK(new Integer[] {categoriaPK.getPK()[0]}), 0);
			//llamo a la funcion recursiva que arma el arbol de las categorias
			Vector vec = getArbolCategoriaRediseno(categoriaPK,categoria.getSubCategoria(), 0,cantParaMostrar,mostrarTodos);
			t.setParam("nivel0", vec);

			Vector vecSec = new Vector();
			Hashtable hasSec = new Hashtable();
			hasSec.put("seccion", getIdSeccionArbol(categoriaPK.getPK()));
			//si hay mas de 5 familias por categoria
			if(vec.size() > 5){
				hasSec.put("masSeccion"+categoriaPK.getPK()[0],"true" );
			}
			vecSec.add(hasSec);
			t.setParam("idsSecciones", vecSec);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return t.output();
	}
	@SuppressWarnings("unchecked")
	public static Vector getArbolCategoriaRediseno (CategoriaPK categoriaPK,Categoria[] categoria, int nivel, int cantParaMostrar,Integer mostrarTodos) throws Exception {
		Vector vecNivel = new Vector();
		for ( int i = 0; i < categoria.length; i++) {
			Hashtable hasNivel = new Hashtable();
			hasNivel.put("desNivel" +nivel, Convert.capitalizar(categoria[i].getDescripcion(), false));
			hasNivel.put("hrefNivel"+nivel, "/catalogo" + getURL(getCategoriaEspecifica(categoria[i].getCategoriaPK())) + ".htm");
			hasNivel.put("dispNvl0",new String("block"));

			/*hay que descomentar para mostrar la cantidad de articulos por seccion-grupo*/
			if (categoria[i].getCantidadArticulosDisponibles() == -1) {
					categoria[i].setCantidadArticulosDisponibles(
							getCantidadArticulosXCategoria(categoria[i].getCategoriaPK()));
			}
			hasNivel.put("cantNivel"+nivel, categoria[i].getCantidadArticulosDisponibles() + "");

			StringBuffer idNivel = new StringBuffer("nivel");
			for(int j = 0;j < categoria[i].getCategoriaPK().getPK().length; j++) {
				idNivel.append("-").append(categoria[i].getCategoriaPK().getPK()[j]);
			}
			hasNivel.put("idNivel"+(nivel), idNivel);

		//	if (categoriaPK.getPK().length > ) {

				if (categoria[i].getSubCategoria().length > 0 ) {
					//veo si tiene mas-subniveles
					if(categoria[i].getSubCategoria().length > 0 ) {
						hasNivel.put("dispNvl"+(nivel+1), "none");
						if(nivel <= 1){
							hasNivel.put("lnkClassNvl"+nivel, "arbolItemMas");
							if (mostrarTodos.intValue() == 0 || (categoriaPK.getPK().length > nivel+1)) {
								hasNivel.put("abroSubNivel"+nivel, "true");
							} else {
								hasNivel.put("abroSubNivel"+nivel, "");
							}
							
						}else{
							hasNivel.put("lnkClassNvl"+nivel,"arbolItemB");
						}
					}else{
						hasNivel.put("dispNvl"+(nivel+1), "");
						if(nivel <=1){
							hasNivel.put("dispNvl"+nivel, "arbolItem");
							hasNivel.put("lnkClassNvl"+nivel, "arbolItem");
						}
						else{
							hasNivel.put("lnkClassNvl"+nivel, "arbolItemB");
						}
					}
					hasNivel.put("title", "Desplegar subcategorías");
				}else{
					hasNivel.put("dispNvl0",new String(""));
					hasNivel.put("lnkClassNvl"+nivel, "arbolItemF");
					hasNivel.put("title", "");
				}
		//	}
			if(esParteDe(categoria[i].getCategoriaPK(), categoriaPK)&& mostrarTodos.intValue() == 1 ) {
				setDisplayDeNiveles(nivel, hasNivel, categoria[i].getCategoriaPK().getPK(),categoria[i].getSubCategoria().length > 0);
				ponerNegrita(hasNivel, categoriaPK.getPK());
			}
			/*determino el maximo de elementos que se muestran en la mesa principal */
			if(i > cantParaMostrar && mostrarTodos.intValue() == 0)	{
				break;
				//hasNivel.put("dispNvl0",new String("none"));
			}
			if (mostrarTodos.intValue() == 0 || (categoriaPK.getPK().length > nivel+1)) { 
				hasNivel.put("nivel" + (nivel+1),getArbolCategoriaRediseno(categoriaPK,categoria[i].getSubCategoria(), (nivel+1),cantParaMostrar,mostrarTodos));
			}	
			vecNivel.add(hasNivel);
		}
		return vecNivel;
	}

	/**
	 * @see genera los menues estaticos si recibe
	 */


	public static String generarArbolXCategoria(CategoriaPK categoriaPK) {
		String paginaDinamica;
		String paginaGenerada;
		//boolean resultado;

		String strPk = categoriaPK.toCode();
		paginaDinamica = "/tiles/generacion/arbolGeneracion.jsp?categoriapk="+strPk;
		paginaGenerada = "/familias/arbol" + strPk+".html";

    	return (!ContenidosEstaticos.crearContenidoEstatico(
    			paginaDinamica, paginaGenerada, "contenidosEstaticos"))?categoriaPK.toCode():"";
	}

	public static void generarArbolEstatico() throws Exception {
		String error = generarArbolXCategoria(new CategoriaPK(new Integer[]{0}));
		error = error + generarArbolEstatico(categoria);

		if (error.length()>0) {
			throw new Exception ("Error en generacion del arbol " + error);
		}
	}

	public static String generarArbolEstatico(Categoria[] categoria) {
		StringBuffer catError =  new StringBuffer();
		for(int i = 0; i < categoria.length; i++) {
			catError.append(generarArbolXCategoria(categoria[i].getCategoriaPK()));
			if(categoria[i].getSubCategoria().length > 0) {
				generarArbolEstatico(categoria[i].getSubCategoria());
			}
		}
		return catError.toString();
	}

	@SuppressWarnings("unchecked")
	private static void ponerNegrita(Hashtable hasNivles, Integer[] pkAtual) {//,Integer[] pkOriginal){
		int negrita = pkAtual.length -1;
		negrita --;
		hasNivles.put("negrita"+negrita, "<b>");
		hasNivles.put("_negrita"+negrita, "</b>");

		/*esto pone el negrito todo el recorrido
		for(int i= 0;i < pkAtual.length;i++ ){
			hasNivles.put("negrita"+i, "<b>");
			hasNivles.put("_negrita"+i, "</b>");
		}*/
	}


	private static boolean esParteDe(CategoriaPK categoriaPKActual, CategoriaPK categoriaPK) {
		boolean pertenece = false;
		if (categoriaPKActual.getPK().length<=categoriaPK.getPK().length) {
			for (int i=0; i<categoriaPKActual.getPK().length; i++) {
				if (categoriaPKActual.getPK()[i].equals(categoriaPK.getPK()[i])) {
					pertenece = true;
				} else {
					pertenece = false;
					break;
				}
			}
		}
		return pertenece;
	}

	/**
	 * @see toma la longitud de la pk (que indica cuantos niveles se avanzo)
	 * @see y en base a eso pone los display de cade div en block
	 * @param hasNivel
	 * @param pk
	 */
	@SuppressWarnings("unchecked")
	private static void setDisplayDeNiveles(int nivel,Hashtable hasNivel, Integer[] pk,boolean hayMas) {
		for(int i=0;i < pk.length; i++){
			hasNivel.put("dispNvl"+i,new String("block"));
			if(hayMas)
				hasNivel.put("lnkClassNvl"+i,"arbolItemMin");
			else
				hasNivel.put("lnkClassNvl"+i,"arbolItemF");
		}
	}
	/***
	 * @see devuelve la descripcion de la categoria ej: 1 =libros
	 * @param Integer [] pk
	 * @return string (descripcion de la pk)
	 */
	private static Object getIdSeccionArbol(Integer[] pk) {
		String seccion = "";
		switch (pk[0].intValue()) {
			case 1:seccion = "Libros";break;
			case 3:seccion = "Pasatiempos";break;
			case 4:seccion = "Musica";break;
			case 5:seccion = "Peliculas";break;
		}
		return seccion;
	}


	/**
	 * Devuelve la cantidad de articulos disponibles para la seccion, grupo, familia del parametro
	 *
	 */
	public static final int getCantidadArticulosXCategoria(CategoriaPK categoriaPK) throws Exception {
		int cantidad = 0;
		StringBuffer qry = new StringBuffer();
		qry.append(" SELECT count(*) cantidad");
		qry.append(" FROM articulos a, disponibilidades d");
		qry.append(" WHERE a.id_disponibilidad = d.id_disponibilidad");
		qry.append(" and a.categoria_seccion = ").append(categoriaPK.getPK()[0]);
		if(categoriaPK.getPK().length>1){
			qry.append(" and a.categoria_grupo = ").append(categoriaPK.getPK()[1]);
		}
		if(categoriaPK.getPK().length>2){
			qry.append(" and a.categoria_familia = ").append(categoriaPK.getPK()[2]);
		}
		if(categoriaPK.getPK().length>3){
			qry.append(" and a.categoria_subfamilia = ").append(categoriaPK.getPK()[3]);
		}
		qry.append(" and d.id_esquema = 'PROD'");
		qry.append(" and d.pedido_especial = 'N'");
		qry.append(" and a.habilitado_tematika = 'S'");
		qry.append(" AND a.activo = 'SI' ");

		Iterator it = MainHelper.getRs(qry.toString());


		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			cantidad = new Integer(dyn.get("cantidad").toString()).intValue();
		}

		return cantidad;
    }


	public static void generarCatalogo() throws Exception {
		crearArbolDeCatalogoXNivel(CategoriaService.categoria, "/");
	}


	private static void crearArbolDeCatalogoXNivel(Categoria[] categoria, String directorioPadre) throws Exception {
		for (int i=0; i<categoria.length; i++) {
			StringBuffer directorio = new StringBuffer(directorioPadre);
			directorio.append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(categoria[i].getDescripcion())).toLowerCase()).append("/");
			//creo directorio
			MainHelper.delDirNet(directorio.toString(), "contenidosEstaticos");
			MainHelper.makeDirNet(directorio.toString(), "contenidosEstaticos");

			StringBuffer fileName = new StringBuffer(directorio.toString()).append("index");
			if (categoria[i].getSubCategoria().length == 0) {
				int cantXPag = 70;
				int indice = 0;
				String anclaSig = "";
				String anclaAnt = "";
				String nivelSup = "";
				try {
					categoria[i].setCantidadArticulosDisponibles(getCantidadArticulosXCategoria(categoria[i].getCategoriaPK()));
				} catch (Exception e) {
					TmkLogger.error(e.toString() + MainHelper.getMessage(e));
				}
				for (int j=0; j<categoria[i].getCantidadArticulosDisponibles(); j=j+cantXPag) {
					indice++;
					String contenido = "";
					if (categoria[i].getCantidadArticulosDisponibles() > j + cantXPag) {
						anclaSig = "<br><a href=\"index" + (indice) + ".html\">Siguiente</a>";
					} else {
						anclaSig = "";
					}
					if (j>= cantXPag) {
						anclaAnt = "<br><a href=\"index" + ((indice-2==0)?"":""+(indice-2)) + ".html\">Anterior</a>";
					} else {
						anclaAnt = "";
					}
					if (!directorioPadre.equals("/")) {
						nivelSup = "<br><a href=\"..\\\">Nivel Superior</a>";
					} else {
						nivelSup = "";
					}

					try {
						contenido = crearContenidoDeArticulo(categoria[i], j, j+cantXPag);
						contenido = contenido + anclaSig + anclaAnt + nivelSup;
					} catch (Exception e) {
						TmkLogger.error(e.toString() + MainHelper.getMessage(e));
					}
					MainHelper.saveFileNet(fileName.toString() + ((j>0)?""+(indice-1):"") + ".html", contenido, "contenidosEstaticos");
				}

				//CONTENIDO
				//crearContenidoDeArticulo(

				//creo archivo con articulos
			} else {
				//int aux = 0;
				int cantXPag = 70;
				int indice = 0;
				String anclaSig = "";
				String anclaAnt = "";
				String nivelSup = "";
				for (int j=0; j<categoria[i].getSubCategoria().length; j=j+cantXPag) {
					indice++;
					if (categoria[i].getSubCategoria().length > j + cantXPag) {
						anclaSig = "<br><a href=\"index" + (indice) + ".html\">Siguiente</a>";
					} else {
						anclaSig = "";
					}
					if (j>= cantXPag) {
						anclaAnt = "<br><a href=\"index" + ((indice-2==0)?"":""+(indice-2)) + ".html\">Anterior</a>";
					} else {
						anclaAnt = "";
					}
					if (!directorioPadre.equals("/")) {
						nivelSup = "<br><a href=\"..\\\">Nivel Superior</a>";
					} else {
						nivelSup = "";
					}
					String contenido = crearContenidoDeCategoria(categoria[i].getSubCategoria(), j, j+cantXPag);
					contenido = contenido + anclaSig + anclaAnt + nivelSup;
					MainHelper.saveFileNet(fileName.toString() + ((j>0)?""+(indice-1):"") + ".html", contenido, "contenidosEstaticos");
					//aux = aux + cantXPag;
				}
				//creo archivo con subcategorias

				crearArbolDeCatalogoXNivel(categoria[i].getSubCategoria(), directorio.toString());
			}

		}
	}

	private static String crearContenidoDeCategoria(Categoria[] subCat, int inicio, int fin) {
		StringBuffer contenido = new StringBuffer("");
		for (int i=inicio; i<subCat.length && i< fin; i++) {
			contenido.append("<br><a href=\"").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(subCat[i].getDescripcion())).toLowerCase()).append("\">");
			contenido.append(subCat[i].getDescripcion()).append("</a>");
		}
		return contenido.toString();

	}


	private static String crearContenidoDeArticulo(Categoria cat, int inicio, int fin) throws Exception {
		StringBuffer contenido = new StringBuffer("");
		StringBuffer qry = new StringBuffer("");
		qry.append(" SELECT t.id_articulo, t.titulo, t.categoria_seccion, t.categoria_grupo, t.categoria_subfamilia, t.categoria_familia, t.col from (");
		qry.append(" 	SELECT a.id_articulo, a.titulo, a.categoria_seccion, a.categoria_grupo, a.categoria_subfamilia, a.categoria_familia, rownum col");
		qry.append(" 	FROM articulos a, ");
		qry.append(" 		 disponibilidades d");
		qry.append(" 	WHERE ");
		qry.append(" 	  	a.id_disponibilidad = d.id_disponibilidad");
		qry.append(" 		AND d.id_esquema = 'PROD'");
		qry.append(" 		AND a.activo = 'SI'");
		qry.append(" 		AND a.habilitado_tematika = 'S'");
		qry.append(" 		AND d.pedido_especial = 'N'");
		qry.append(" 	 	AND a.categoria_seccion = ?");
		if (cat.getCategoriaPK().getPK().length >1) {
			qry.append("	 AND a.categoria_grupo = ?");
		}
		if (cat.getCategoriaPK().getPK().length >2) {
			qry.append("	 AND a.categoria_familia = ?");
		}
		if (cat.getCategoriaPK().getPK().length >3) {
			qry.append("	 AND a.categoria_subfamilia = ?");
		}
		qry.append(" ORDER BY a.titulo ");
		qry.append(" ) t");
		qry.append(" WHERE col >").append(inicio).append(" and col <=").append(fin);

		Connection conn = DBUtil.buildConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(qry.toString());
			try {
				ps.setInt(1, cat.getCategoriaPK().getPK()[0].intValue());
				if (cat.getCategoriaPK().getPK().length >1) {
					ps.setInt(2, cat.getCategoriaPK().getPK()[1].intValue());
				}
				if (cat.getCategoriaPK().getPK().length >2) {
					ps.setInt(3, cat.getCategoriaPK().getPK()[2].intValue());
				}
				if (cat.getCategoriaPK().getPK().length >3) {
					ps.setInt(4, cat.getCategoriaPK().getPK()[3].intValue());
				}
				ResultSet rs = ps.executeQuery();
				try {

					//http://" + Globals.DOMINIO_SITIO + CategoriaService.getURL(articulo.getCategoria()) + ArticuloManager.getURL(articulo)


					while (rs.next()) {
						CategoriaPK catPK = new CategoriaPK (new Integer[]{new Integer(rs.getInt("categoria_seccion")), new Integer(rs.getInt("categoria_grupo")), new Integer(rs.getInt("categoria_familia")), new Integer(rs.getInt("categoria_subfamilia"))});
						contenido.append("<br><a href=\"http://").append(Globals.DOMINIO_SITIO).append(CategoriaService.getURL(getCategoriaEspecifica(catPK))).append("/").append(Convert.soloLetrasYNros(Convert.sinTildesNiEnie(Convert.corregir(rs.getString("titulo"), true)).toLowerCase())).append("--").append(rs.getInt("id_articulo")).append(".htm").append("\">").append(rs.getString("titulo")).append("</a>");
					}
				} finally {
					rs.close();
				}
			} finally {
				ps.close();
			}
		} finally {
			conn.close();
		}
		return contenido.toString();
	}
	
	public static void generarTopFamilia() {
		StringBuffer error = new StringBuffer("");
		try {
            boolean retorno = false;
            Categoria[] seccion = CategoriaService.categoria;
            for (int i=0; i< seccion.length; i++) {
            	Categoria[] grupo =  seccion[i].getSubCategoria();
            	for (int j=0; j<grupo.length; j++) {
            		Categoria[] familia = grupo[j].getSubCategoria();
            		for (int k=0; k<familia.length; k++) {
            			try {
            				retorno = ContenidosEstaticos.generarFamiliaEstatica(familia[k].getCategoriaPK());
            				if (!retorno) {
            					error.append(familia[k].getCategoriaPK());
            				}
            			} catch (Exception e) {
            				error.append(familia[k].getCategoriaPK() + e.toString() + e.getMessage());
            			}
            		}
            		try {
            			retorno = ContenidosEstaticos.generarFamiliaEstatica(grupo[j].getCategoriaPK());
            			if (!retorno) {
            				error.append(grupo[j].getCategoriaPK());
        				}
	            	} catch (Exception e) {
	    				error.append(grupo[j].getCategoriaPK() + e.toString() + e.getMessage());
	    			}
            	}
	       }
	       if (error.length()>0) {
	          	throw new Exception ("Fallo en generacion de familias ");
	       }
		} catch (Exception e) {
        	error.append(e.toString() + MainHelper.getMessage(e));
        	MainHelper.enviarMailDeError(error.toString());
        	TmkLogger.error(error);
        }
	}



}
