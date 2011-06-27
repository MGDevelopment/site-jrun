/**
 * $Log: BuscadorHelper.java,v $
 * Revision 1.25  2009/03/20 18:24:11  msartori
 * - Meta Tags
 * - Detalle y paginas derivadas
 * - Buscador
 *
 * Revision 1.24  2009/03/11 20:01:52  oClopez
 * modificaciones y agregados
 *
 * Revision 1.23  2009/02/02 11:50:19  msartori
 * - Cambios Rediseño
 *
 * Revision 1.22  2007/12/18 20:11:50  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.21  2007/07/11 15:00:50  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.20  2007/02/13 13:18:09  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.19  2006/12/19 14:37:20  omsartori
 * - Rediseño: ajustes de estilo y estructura en las homes y paginas impactadas
 *
 * Revision 1.18  2005/12/29 17:45:26  omsartori
 * * Cambios Dromo
 *    Se quitaron los datos distribuidor, proveedor e isbn.
 *    Se agregaron los datos marca y fabricante.
 *    Se agregaron los buscadores por marca y fabricante, tanto por código como por palabra.
 *    Se modificó el orden de las tarjetas en el plan de pago del detalle artículo, ahora es VIS, AME, MAS, DIN.
 *    Se agregaron los campos:
 *    Tipo de documento.
 *    Nro de Documento.
 *    Rango horario de recepción del pedido.
 *    Estos campos son visibles en la orden del cliente y en el detalle de orden de la intranet de TMK. Y deben completarse obligatoriamente para órdenes que contengan artículos de Dromo.
 *
 * * Se filtró la localidad “ciudad autónoma de Buenos Aires” del listado de localidades válidas para tmk.
 *
 * * Doc Empro 10
 *
 * Revision 1.17  2005/09/15 19:19:22  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.16  2005/07/26 14:13:38  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 * Revision 1.15  2005/07/18 13:53:05  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.14  2005/01/25 15:52:40  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.13  2005/01/18 20:47:44  omsartori
 * no message
 *
 * Revision 1.12  2005/01/18 19:46:11  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.11  2005/01/12 15:29:38  oGPistoia
 * - Buscador de Atributos Dinamicos (solo falta la pagina)
 *
 * Revision 1.10  2005/01/11 15:14:01  oGPistoia
 * - Buscador de Novedades
 *
 * Revision 1.9  2004/11/18 16:10:58  oGPistoia
 * - Nuevo buscador por distintos ID de productos
 *
 * Revision 1.8  2004/10/06 13:53:31  omsartori
 * - cambio de constantes referentes a categorias de buscadorhelper.java de nuevo a minúscula
 * - cambio en productos.jsp para mantener el arbol de categorías.
 *
 * Revision 1.7  2004/10/04 14:29:47  omsartori
 * - cambio de constantes en el buscador para mantener el arbol de categorias hasta subfamilia
 * - validación de login repetido cuando el socio cambia sus datos personales
 *
 * Revision 1.6  2004/04/06 22:22:40  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.5  2004/03/25 18:19:50  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.4  2004/03/04 18:52:54  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.3  2004/02/16 20:24:19  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.2  2004/02/11 19:34:20  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.1  2004/01/08 20:30:20  GPistoia
 * - Retoques por release, antes del buscador
 *
 */
package com.tmk.service.buscador;

import java.util.Hashtable;
import java.util.Vector;

import com.tmk.dbo.comparador.ComparadorPorDefecto;
import com.tmk.dbo.comparador.ComparadorPorFecha;
import com.tmk.dbo.comparador.ComparadorPorFechaInverso;
import com.tmk.dbo.comparador.ComparadorPorMasVendidos;
import com.tmk.dbo.comparador.ComparadorPorPrecio;
import com.tmk.dbo.comparador.ComparadorPorPrecioInverso;
import com.tmk.dbo.comparador.ComparadorPorTitulo;
import com.tmk.dbo.comparador.ComparadorPorTituloInverso;
import com.tmk.kernel.Globals;

public final class BuscadorHelper {

	public static final String PAGINA_BUSCADOR = "/buscador/productos.jsp";
	public static final String PAGINA_BUSCADOR_RESULTADOS = "/buscador/productos.jsp";
//    public static final String PAGINA_ATRIBUTOS_DINAMICOS = "/BusquedaAvanzadaAtributosDinamicos";
	public static final String PAGINA_RETORNO = "/articulo/buscadorAvanzado.jsp";

	public static final String RESULTADO = "buscadorDAO";

	private static Vector [] OPCION_BUSQUEDA = {new Vector<Hashtable>(5),
		 new Vector<Hashtable>(5),
		 null,
		 new Vector<Hashtable>(5),
		 new Vector<Hashtable>(5),
		 new Vector<Hashtable>(4)};

	// Estos son los parametros que pueden venir

	public static final String TEXTO = "texto";
	public static final String CATEGORIA_SECCION = "seccion";
	public static final String CATEGORIA_GRUPO = "grupo";
	public static final String CATEGORIA_FAMILIA = "familia";
	public static final String CATEGORIA_SUBFAMILIA = "subfamilia";
	public static final String VALOR_INICIAL = "valorInicial";
	public static final String REGISTRO_INICIAL = "registroInicial";
	public static final String REGISTRO_FINAL = "registroFinal";
	public static final String CRITERIO_ORDEN = "criterioDeOrden";
	public static final String PEDIDO_ESPECIAL = "pedidoEspecial";
	public static final String CLAVE_DE_BUSQUEDA = "claveDeBusqueda";
	public static final String ID_SOCIO = "idSocio";
	public static final String ID_SUCURSAL = "idSucursal";
	public static final String ES_BUSQUEDA_AVANZADA = "esBusquedaAvanzada";
	public static final String IDS_ARTICULOS = "articulo";
	public static final String DIAS_CONSIDERADOS_NOVEDAD = "diaConsideradosNovedad";
	public static final String DIAS_IGNORADOS_NOVEDAD = "diasIgnoradosNovedad";
	public static final String NOMBRE_ATRIBUTO = "nombreAtributo";
	public static final String VALOR_ATRIBUTO = "valorAtributo";
	public static final String ID_EDITOR = "idEditor";
	public static final String ID_AUTOR = "idAutor";
	public static final String ID_PROVEEDOR = "idProveedor";
	public static final String ID_MARCA = "idMarca";


	// Estos son los tipos de búsqueda

	public static final String POR_TITULO = "porTitulo";
	public static final String POR_AUTOR = "porAutor";
	public static final String POR_PALABRAS_CLAVES = "porPalabrasClaves";
	public static final String POR_ISBN = "porISBN";
	public static final String POR_EDITORIAL = "porEditorial";
	public static final String POR_PROVEEDOR = "porProveedor";
	public static final String POR_TEMA_MUSICAL = "porTemaMusical";
	public static final String POR_CLASIFICACION_TEMATIKA = "porClasificacionTematika";
	public static final String POR_IDIOMA = "porIdioma";
	public static final String POR_PRECIO = "porPrecio";
	public static final String POR_FORMATO = "porFormato";
	public static final String POR_CATEGORIAS = "porCategorias";
	public static final String POR_IDS = "porIDs";
	public static final String PARA_RECOMENDAR = "paraRecomendar";
	public static final String DE_NOVEDADES = "deNovedades";
	public static final String POR_ATRIBUTOS_DINAMICOS = "porAtributosDinamicos";
	public static final String POR_IDdeEDITORIAL = "porIDdeEditorial";
	public static final String POR_IDdeAUTOR = "porIDdeAutor";
	public static final String POR_IDdePROVEEDOR = "porIDdeProveedor";
	public static final String POR_IDdeMARCA = "porIDdeMarca";
	public static final String POR_MARCA = "porMarca";


	// Criterios de ordenamiento de los resultados

	public static final CriterioDAO CRIT_MAS_VENDIDOS = new CriterioDAO(new Integer(6), "Los Más Vendidos", "orden", true, true, ",mvs.orden", ",mas_vendidos_seccion mvs", "AND a.id_articulo = mvs.id_articulo(+)", " LEFT JOIN mas_vendidos_seccion mvs ON a.id_articulo = mvs.id_articulo", new ComparadorPorMasVendidos());

	public static final CriterioDAO CRIT_FECHA_NV = new CriterioDAO(new Integer(2), "Fecha de aparición:+ recientes ", "fecha_alta", false, true, ",a.fecha_alta", "", "", "", new ComparadorPorFecha());
	public static final CriterioDAO CRIT_FECHA_VN = new CriterioDAO(new Integer(3), "Fecha de aparición:+ antiguos ", "fecha_alta", true, true, ",a.fecha_alta", "", "", "", new ComparadorPorFechaInverso());

	public static final CriterioDAO CRIT_PRECIO_EC = new CriterioDAO(new Integer(4), "Precio de venta:+ económicos ", "precio", true, true,
			" ,ROUND (precio_venta_vigente * ( 1" +
			"		+ NVL (  (SELECT   NVL (tasa_general, 0)" +
			"		+ NVL (tasa_adicional, 0)" +
			"		+ NVL (tasa_percep_video, 0)" +
			"		FROM tasas" +
			"		WHERE id_impuesto = a.id_impuesto" +
			"		AND id_tipo_contribuyente = " + Globals.ID_TIPO_CONTRIBUYENTE +
			"		AND fecha_vigencia =" +
			"				(SELECT MAX (fecha_vigencia)" +
			"		FROM tasas" +
			"		WHERE id_impuesto = a.id_impuesto" +
			"		AND id_tipo_contribuyente = " + Globals.ID_TIPO_CONTRIBUYENTE +
			"		AND fecha_vigencia <= SYSDATE))" +
			"		/ 100,0)),2) precio", "", "", "", new ComparadorPorPrecio());
	
	public static final CriterioDAO CRIT_PRECIO_CE = new CriterioDAO(new Integer(5), "Precio de venta:+ costosos ", "precio", false, true,
			" ,ROUND (precio_venta_vigente * ( 1" +
			"		+ NVL (  (SELECT   NVL (tasa_general, 0)" +
			"		+ NVL (tasa_adicional, 0)" +
			"		+ NVL (tasa_percep_video, 0)" +
			"		FROM tasas" +
			"		WHERE id_impuesto = a.id_impuesto" +
			"		AND id_tipo_contribuyente = " + Globals.ID_TIPO_CONTRIBUYENTE +
			"		AND fecha_vigencia =" +
			"				(SELECT MAX (fecha_vigencia)" +
			"		FROM tasas" +
			"		WHERE id_impuesto = a.id_impuesto" +
			"		AND id_tipo_contribuyente = " + Globals.ID_TIPO_CONTRIBUYENTE +
			"		AND fecha_vigencia <= SYSDATE))" +
			"		/ 100,0)),2) precio", "", "", "", new ComparadorPorPrecioInverso());
	
	public static final CriterioDAO CRIT_ALFAB_AZ = new CriterioDAO(new Integer(0), "Alfabéticamente (A-Z)", "titulo", true, false, ",a.titulo", "", "", "", new ComparadorPorTitulo());
	public static final CriterioDAO CRIT_ALFAB_ZA = new CriterioDAO(new Integer(1), "Alfabéticamente (Z-A)", "titulo", false, false, ",a.titulo", "", "", "", new ComparadorPorTituloInverso());

	public static final CriterioDAO criterios[] = {

		CRIT_MAS_VENDIDOS,

		CRIT_FECHA_NV,
		CRIT_FECHA_VN,
		
		CRIT_PRECIO_EC,
		CRIT_PRECIO_CE,
		
		CRIT_ALFAB_AZ,
		CRIT_ALFAB_ZA		
	};
	

	public static final Filtro FILTRO_CATEGORIA = new Filtro("0", 
			"Categoría", 
			", descripcion, categoria_seccion, categoria_grupo ",
			", categ_grupos cg", 
			" a.categoria_seccion = cg.categoria_seccion and a.categoria_grupo = cg.categoria_grupo ",
			" group by categoria_seccion, categoria_grupo, descripcion", 
			",cg.descripcion",
			", a.categoria_seccion, a.categoria_grupo", 
			" descripcion");

	public static final Filtro FILTRO_EDITORIAL = new Filtro("1", 
			"Editorial", 
			", nombre descripcion, id_editor",
			", editores e", 
			" a.id_editor = e.id_editor ",
			" group by id_editor, nombre", 
			",e.nombre",
			", a.id_editor",
			"  descripcion");

	public static final Filtro FILTRO_FORMATO = new Filtro("2", 
			"Formato", 
			", rv_meaning descripcion ,auxvarchar03 ",
			", cg_ref_codes cg", 
			" a.auxvarchar03= cg.rv_low_value and cg.rv_domain = 'ONIX:ProductForm' ",
			" group by  auxvarchar03, rv_meaning", 
			", cg.rv_meaning",
			", a.auxvarchar03", 
			" descripcion");
	
	public static final Filtro filtros[]  = {FILTRO_CATEGORIA, FILTRO_EDITORIAL, FILTRO_FORMATO};
	
	
	public static final CriterioDAO CRITERIO_DEFAULT = CRIT_FECHA_NV;
	//public static final CriterioDAO CRITERIO_DEFAULT = CRIT_MAS_VENDIDOS;


	@SuppressWarnings("unchecked")
	public static void cargarOpcionDeBusqueda() {
		//TmkLogger.debug("CARGA OPCIONES");
		Hashtable<String, String> opcion = new Hashtable<String, String>(3);
		//OPCIONES PARA INICIO

		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "En Tematika.com");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_HOME);
		OPCION_BUSQUEDA[Globals.SECCION_HOME].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "En Libros");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO);
		OPCION_BUSQUEDA[Globals.SECCION_HOME].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "En Musica");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA);
		OPCION_BUSQUEDA[Globals.SECCION_HOME].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus4");
		opcion.put("txtOpt", "En Peliculas");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA);
		OPCION_BUSQUEDA[Globals.SECCION_HOME].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "En Pasatiempos");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES);
		OPCION_BUSQUEDA[Globals.SECCION_HOME].add(opcion);

		//OPCIONES PARA LIBROS
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_TITULO);
		OPCION_BUSQUEDA[Globals.SECCION_LIBRO].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "Autor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_AUTOR);
		OPCION_BUSQUEDA[Globals.SECCION_LIBRO].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "Editorial");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_EDITORIAL);
		OPCION_BUSQUEDA[Globals.SECCION_LIBRO].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus4");
		opcion.put("txtOpt", "ISBN");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_ISBN);
		OPCION_BUSQUEDA[Globals.SECCION_LIBRO].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_LIBRO + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_PALABRAS_CLAVES);
		OPCION_BUSQUEDA[Globals.SECCION_LIBRO].add(opcion);

//		OPCIONES PARA PASATIEMPOS/JUGUETES
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_TITULO);
		OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "Autor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_AUTOR);
		OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "Editorial");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_EDITORIAL);
		OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus4");
		opcion.put("txtOpt", "ISBN");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_ISBN);
		OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_JUGUETES + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_PALABRAS_CLAVES);
		OPCION_BUSQUEDA[Globals.SECCION_JUGUETES].add(opcion);

//		OPCIONES PARA MUSICA
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_TITULO);
		OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "Grupo/Intérprete");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_AUTOR);
		OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "Sello Discográfico");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_EDITORIAL);
		OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus4");
		opcion.put("txtOpt", "Tema Musical");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_TEMA_MUSICAL);
		OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_MUSICA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_PALABRAS_CLAVES);
		OPCION_BUSQUEDA[Globals.SECCION_MUSICA].add(opcion);

//		OPCIONES PARA PELICULAS
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus1");
		opcion.put("txtOpt", "Título");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_TITULO);
		OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus2");
		opcion.put("txtOpt", "Director/Actor");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_AUTOR);
		OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus3");
		opcion.put("txtOpt", "Productora");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_EDITORIAL);
		OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
		opcion = new Hashtable<String, String>(3);
		opcion.put("idOpt", "optBus5");
		opcion.put("txtOpt", "Palabra Clave");
		opcion.put("urlBus", "/buscador/productos.jsp" + "?" + "idSeccion" + "="
				+ Globals.SECCION_PELICULA + "&" + CLAVE_DE_BUSQUEDA + "=" + POR_PALABRAS_CLAVES);
		OPCION_BUSQUEDA[Globals.SECCION_PELICULA].add(opcion);
	}

	public static Vector[] getOpcionBusqueda() {
		return OPCION_BUSQUEDA;
	}
}
