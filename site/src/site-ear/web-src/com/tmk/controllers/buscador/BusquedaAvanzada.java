/**
 * $Log: BusquedaAvanzada.java,v $
 * Revision 1.9  2007/07/11 15:00:51  omsartori
 * - Busqueda Logger
 * - Cambio de estandar html
 * - PopUp registracion
 * - Rearmado de ajax de carrito de compras
 * - Pop Up carrito de compras
 *
 * Revision 1.8  2007/06/11 18:37:33  omsartori
 * - Log de busquedas
 *
 * Revision 1.7  2007/05/09 18:17:59  omsartori
 * * Busqueda de Inicio: Al aplicar un criterio de ordenamiento se mantiene la apertura de busquedas por sección, en la versión anterior la busqueda se acotaba a la última sección mostrada.
 * * Aprobación de Ordenes Intranet: Se agrego un chequeo para evitar la doble aprobación desde la intranet que genera movimientos duplicados en central.
 * * Validación de Formularios: Se agrego el foco de retorno en la validación de los siguientes formularios
 *                                             Carga de Comentarios
 *                                             Alta de Alianzas
 * * Orden de Autores: Se modificaron todas las consultas para mostrar en Tematika el mismo orden de autores que viene dado por comercial. (Se regenerarán los articulos involucrados luego de la implementación en productivo)
 * * Carrito de Compras: Se activo nuevamente el carrito de compras con tecnología ajax, que cambia de color cuando se agrega un artículo y evita la necesidad de recargar la página.
 * * Seguimiento de sesiones: Se corrigio la fecha de creación, ahora se toma la fecha dada por el servidor de aplicación para evitar diferencias con la fecha de base de datos.
 * * Directorio de acceso a intranet: Se modificó el directorio de acceso a intranet por requerimiento de seguridad junto con sus respectivos links, el directorio actual es /236-TMK
 *
 * Revision 1.6  2007/04/26 18:32:48  omsartori
 * no message
 *
 * Revision 1.5  2007/03/29 17:36:28  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.4  2007/03/19 14:22:17  omsartori
 * - Generador de arbol de categorias
 * - Atributo peso agregado para detalle de libros y derivados
 * - Buscador avanzado
 * 	* Las búsquedas se disparan presionando la tecla Enter en cualquier campo
 * 	* Se unificó el atributo soporte con el que se utiliza para el detalle en articulos de la seccion musica
 * - Paginas de institucionales
 * - Se agregó retorno de carro a los textos de reseña
 *
 * Revision 1.3  2006/09/28 14:58:14  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.2  2005/09/15 19:19:23  omsartori
 * - Criterio de orden Mas Vendidos en todos los buscadores
 * - EJB reducido en homes de tematika y en navegacion por categorias
 * - Reemplazo de links a busqueda de autor por id de autor
 * - Cambio de qry de planes para excluir planes viejos
 *
 * Revision 1.1  2005/01/25 15:52:40  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.4  2004/10/22 15:55:36  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.3  2004/05/04 18:11:00  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.2  2004/03/25 18:19:51  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.1  2004/02/11 19:34:27  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 */
package com.tmk.controllers.buscador;

import com.tmk.kernel.Globals;

public class BusquedaAvanzada extends BusquedaGenerica {

	protected String titulo;
	protected String autor;
	protected String editorial;
	protected String palabrasClaves;
	protected String isbn;
	protected String clasificacion;
	protected String idioma;
	protected Double precio;
	protected String formato;

    public BusquedaAvanzada(String texto, Integer seccion,
                       Integer registroInicial, Integer registroFinal,
                       CriterioDAO criterio,
                       boolean soloPedidoEspecial,
                       String titulo, String autor, String editorial, String palabrasClaves,
                       String isbn, String clasificacion, String idioma, Double precio,
                       String formato
                       ) {
	    super(texto, seccion, registroInicial, registroFinal, criterio, soloPedidoEspecial);
	    this.titulo = titulo;
	    this.autor = autor;
	    this.editorial = editorial;
	    this.palabrasClaves = palabrasClaves;
	    this.isbn = isbn;
	    this.clasificacion = clasificacion;
	    this.idioma = idioma;
	    this.precio = precio;
	    this.formato = formato;
    }

	public StringBuffer getQueryParcial() {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from (");
		if (isbn != null) sql.append(" INTERSECT ").append(getQueryISBN());
    	if (titulo != null) sql.append(" INTERSECT ").append(getQueryTitulo());
    	if (autor != null) sql.append(" INTERSECT ").append(getQueryAutor());
		if (editorial != null) sql.append(" INTERSECT ").append(getQueryEditorial());
		if (palabrasClaves != null) sql.append(" INTERSECT ").append(getQueryPalabrasClaves());
		sql.append(Globals.ENTER).append(" )");
		sql.append((criterio == null) ? "" : criterio.getTextoQuery());
		sql = new StringBuffer(sql.toString().replaceFirst("INTERSECT", ""));
		return sql;
	}

	public String getQuerySubtotales() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT count(*) cantidad, categoria_seccion seccion");
		sql.append(Globals.ENTER).append(" FROM ( ");
		if (isbn != null) sql.append(" INTERSECT ").append(getQueryISBNCount());
    	if (titulo != null) sql.append(" INTERSECT ").append(getQueryTituloCount());
    	if (autor != null) sql.append(" INTERSECT ").append(getQueryAutorCount());
		if (editorial != null) sql.append(" INTERSECT ").append(getQueryEditorialCount());
		if (palabrasClaves != null) sql.append(" INTERSECT ").append(getQueryPalabrasClavesCount());
		sql.append(Globals.ENTER).append(" )");
		sql.append(" GROUP BY categoria_seccion");
		sql = new StringBuffer(sql.toString().replaceFirst("INTERSECT", ""));
		return sql.toString();
	}

	
	public StringBuffer getQueryTitulo() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ INDEX(d DISP_IDX) INDEX(a ARTICULOS_OT_IDX_1)*/ a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo,");
		sql.append(Globals.ENTER).append("	  a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(criterio.getAddSelect());
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a");
		sql.append(Globals.ENTER).append(criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND catsearch (a.titulo, '").append(titulo).append("*', NULL) > 0");
	    sql.append(Globals.ENTER).append(criterio.getAddWhere());
		return sql;
	}
	
	public StringBuffer getQueryTituloCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ INDEX(d DISP_IDX) INDEX(a ARTICULOS_OT_IDX_1)*/");
		sql.append(Globals.ENTER).append(" a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a");
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND catsearch (a.titulo, '").append(titulo).append("*', NULL) > 0");
		return sql;
	}

	public StringBuffer getQueryAutor() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ INDEX(aa borrame) USE_NL(au aa) USE_NL (aa a) USE_NL (a d)*/ ");
		sql.append(Globals.ENTER).append(" a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo, a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(criterio.getAddSelect());
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, articulos_autores aa, autores au");
		sql.append(Globals.ENTER).append(criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("	  AND a.id_articulo = aa.id_articulo");
	    sql.append(Globals.ENTER).append("    AND aa.id_autor = au.id_autor");   							
	    sql.append(Globals.ENTER).append("	  AND catsearch (au.descripcion, '").append(autor).append("*', NULL) > 0");
	    sql.append(Globals.ENTER).append(criterio.getAddWhere());
		return sql;
	}

	public StringBuffer getQueryAutorCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ INDEX(aa borrame) USE_NL(au aa) USE_NL (aa a) USE_NL (a d)*/ ");
		sql.append(Globals.ENTER).append(" a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, articulos_autores aa, autores au");
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("	  AND a.id_articulo = aa.id_articulo");
	    sql.append(Globals.ENTER).append("    AND aa.id_autor = au.id_autor");   							
	    sql.append(Globals.ENTER).append("	  AND catsearch (au.descripcion, '").append(autor).append("*', NULL) > 0");
		return sql;
	}
	
	public StringBuffer getQueryEditorial() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL(e a) USE_NL (a d) INDEX(a ARTI2_EDIT_FK_I)*/  a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo,");
		sql.append(Globals.ENTER).append("	  a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(criterio.getAddSelect());
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, editores e");
		sql.append(Globals.ENTER).append(criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND a.id_editor            = e.id_editor");
	    sql.append(Globals.ENTER).append("	  AND catsearch(e.nombre, '").append(editorial).append("*', '') > 0");
	    sql.append(Globals.ENTER).append(criterio.getAddWhere());
		return sql;
	}
	
	public StringBuffer getQueryEditorialCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL(e a) USE_NL (a d) INDEX(a ARTI2_EDIT_FK_I)*/");
		sql.append(Globals.ENTER).append("	  a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, editores e");
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND a.id_editor            = e.id_editor");
	    sql.append(Globals.ENTER).append("	  AND catsearch(e.nombre, '").append(editorial).append("*', '') > 0");
		return sql;
	}

	public StringBuffer getQueryPalabrasClaves() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL (s a d)*/ a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo,");
		sql.append(Globals.ENTER).append("	  a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(criterio.getAddSelect());
		sql.append(Globals.ENTER).append(" FROM articulos a, articulos_textos s, disponibilidades d");
		sql.append(Globals.ENTER).append(criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND a.id_articulo = s.id_articulo");
	    sql.append(Globals.ENTER).append("	  AND catsearch(s.texto, '").append(palabrasClaves).append("*', ' tipo=''01''') > 0");
	    sql.append(Globals.ENTER).append(criterio.getAddWhere());
		return sql;
	}

	public StringBuffer getQueryPalabrasClavesCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL (s a d)*/");
		sql.append(Globals.ENTER).append("	  a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM articulos a, articulos_textos s, disponibilidades d");
		sql.append(Globals.ENTER).append(" WHERE ");
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
	    sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
	    sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
	    sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
	    if (idioma != null) sql.append(getQueryIdioma());
	    if (clasificacion != null) sql.append(getQueryClasificacion());
	    sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
	    if (formato != null) sql.append(getQueryFormato());
	    if (precio != null) sql.append(getQueryPrecio());
	    sql.append(Globals.ENTER).append("    AND a.id_articulo = s.id_articulo");
	    sql.append(Globals.ENTER).append("	  AND catsearch(s.texto, '").append(palabrasClaves).append("*', ' tipo=''01''') > 0");
		return sql;
	}

	
	public StringBuffer getQueryISBN() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL (s a)*/ a.id_articulo, a.categoria_seccion, a.fecha_alta, a.titulo,");
		sql.append(Globals.ENTER).append("	  a.precio_venta_vigente");
		sql.append(Globals.ENTER).append(criterio.getAddSelect());
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, articulos_isbn s");
		sql.append(Globals.ENTER).append(criterio.getAddFrom());
		sql.append(Globals.ENTER).append(" WHERE "); 
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
		sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
		if (idioma != null) sql.append(getQueryIdioma());
		if (clasificacion != null) sql.append(getQueryClasificacion());		
		sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		if (formato != null) sql.append(getQueryFormato());
		if (precio != null) sql.append(getQueryPrecio());
		sql.append(Globals.ENTER).append("    AND a.id_articulo = s.id_articulo");
	    sql.append(Globals.ENTER).append("	  AND s.isbn = UPPER(REPLACE(REPLACE('").append(isbn).append("', '-', ''), ' ', ''))");
	    sql.append(Globals.ENTER).append(criterio.getAddWhere());
		return sql;
	}

	public StringBuffer getQueryISBNCount() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" SELECT /*+ USE_NL (s a)*/");
		sql.append(Globals.ENTER).append("	  a.id_articulo, a.categoria_seccion");
		sql.append(Globals.ENTER).append(" FROM disponibilidades d, articulos a, articulos_isbn s");
		sql.append(Globals.ENTER).append(" WHERE "); 
		sql.append(Globals.ENTER).append("    d.id_esquema = 'PROD'");
		sql.append(Globals.ENTER).append("    AND d.pedido_especial   = '").append(pedidoEspecial()).append("'");
		sql.append(Globals.ENTER).append("    AND d.id_disponibilidad = a.id_disponibilidad");
		sql.append(Globals.ENTER).append("    AND a.habilitado_tematika = 'S'");
		if (idioma != null) sql.append(getQueryIdioma());
		if (clasificacion != null) sql.append(getQueryClasificacion());		
		sql.append(Globals.ENTER).append("    AND a.categoria_seccion ").append((tieneCategoriaSeccion() ? ("= " + getSeccion()) : "is not null"));
		if (formato != null) sql.append(getQueryFormato());
		if (precio != null) sql.append(getQueryPrecio());
		sql.append(Globals.ENTER).append("    AND a.id_articulo = s.id_articulo");
	    sql.append(Globals.ENTER).append("	  AND s.isbn = UPPER(REPLACE(REPLACE('").append(isbn).append("', '-', ''), ' ', ''))");
		return sql;
	}

	
	public StringBuffer getQueryClasificacion() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" AND a.categoria_grupo = ").append(clasificacion);
		return sql;
	}

	public StringBuffer getQueryIdioma() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("    AND a.idioma = ").append(" '").append(idioma).append("' ");
		return sql;
	}

	public StringBuffer getQueryPrecio() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append("	  AND a.precio_venta_vigente <= ").append(precio);
		return sql;
	}

	public StringBuffer getQueryFormato() {
		StringBuffer sql = new StringBuffer();
		sql.append(Globals.ENTER).append(" AND a.id_tipo_articulo =").append(formato);
		return sql;
	}

	public StringBuffer salto() {
		StringBuffer buffer = super.salto();
		parametro(buffer, BuscadorHelper.ES_BUSQUEDA_AVANZADA, new Boolean(true));
		parametro(buffer, BuscadorHelper.POR_TITULO, titulo);
		parametro(buffer, BuscadorHelper.POR_AUTOR, autor);
		parametro(buffer, BuscadorHelper.POR_EDITORIAL, editorial);
		parametro(buffer, BuscadorHelper.POR_PALABRAS_CLAVES, palabrasClaves);
		parametro(buffer, BuscadorHelper.POR_ISBN, isbn);
		parametro(buffer, BuscadorHelper.POR_CLASIFICACION_TEMATIKA, clasificacion);
		parametro(buffer, BuscadorHelper.POR_IDIOMA, idioma);
		parametro(buffer, BuscadorHelper.POR_PRECIO, precio);
		parametro(buffer, BuscadorHelper.POR_FORMATO, formato);
		return buffer;
	}

	public String getNombreDeBusqueda() {
		return "Avanzada";
	}

	public String toString() {
		StringBuffer result = new StringBuffer(super.toString());
		if (titulo != null) result.append(", Titulo: ").append(titulo);
		if (autor != null) result.append(", Autor: ").append(autor);
		if (editorial != null) result.append(", Editorial: ").append(editorial);
		if (palabrasClaves != null) result.append(", Palabras Claves: ").append(palabrasClaves);
		if (isbn != null) result.append(", ISBN: ").append(isbn);
		if (clasificacion != null) result.append(", Clasificacion: ").append(clasificacion);
		if (idioma != null) result.append(", Idioma: ").append(idioma);
		if (precio != null) result.append(", Precio: ").append(precio);
		if (formato != null) result.append(", Formato: ").append(formato);

		return result.toString();
	}

}
