/**
 * $Log: DBUtil.java,v $
 * Revision 1.124  2009/01/15 12:35:21  msartori
 * no message
 *
 * Revision 1.123  2008/08/06 14:15:37  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.122  2008/07/07 18:58:56  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.121  2008/05/30 16:03:11  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.120  2008/04/09 20:19:06  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.119  2008/01/24 20:28:05  msartori
 * no message
 *
 * Revision 1.118  2007/12/18 20:10:30  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.117  2007/11/15 13:51:45  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.116  2007/05/09 18:17:35  omsartori
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
 * Revision 1.115  2007/04/26 18:32:12  omsartori
 * no message
 *
 * Revision 1.114  2007/03/06 19:37:44  olsuarez
 * Correcciones en recorridos de musica y películas
 * Correcciones en generacion de arbol de familias
 *
 * Revision 1.113  2007/03/06 15:14:57  omsartori
 * -correccion generacion de ranking
 * -correccion top de artistas
 * -correccion resaltado de busquedas
 *
 * Revision 1.112  2007/03/05 13:49:23  olsuarez
 * Modificaciones recorrido flias estaticos
 * Paginas de recorridos
 *
 * Revision 1.111  2007/02/13 13:17:28  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.110  2007/02/02 21:04:49  oLSuarez
 * - Mapa de entrevistas
 * - Mapa de notas de prensa
 * Se agrego linksMapa.jsp
 *
 * Revision 1.109  2007/01/25 18:09:50  omsartori
 * - Correcciones rediseño
 *
 * Revision 1.108  2007/01/22 17:43:07  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.107  2007/01/08 14:10:06  oLSuarez
 * Rediseño de enviosPlazos.jsp
 *          - Creacion de metodo DBUtil.getGastosDeEnvio()
 *          - Creacion de metodo DBUtil.getGastosDeEnvioRestoMundo()
 *
 * Revision 1.106  2007/01/05 18:46:34  oLSuarez
 * Rediseño de verFamilia.jsp
 *     - Creacion de topFamilia.jsp: para el ranking en las paginas de recorrido de flia.
 *     - Creacion del metodo DBUtil.getDescripcionCategoria() : devuelve array con
 * descripcion de grupo, familia y subfamilia.
 *
 * Revision 1.105  2006/12/29 13:27:13  oLSuarez
 * Detalle de Articulo:
 *    *linksDeContenido.jsp
 *
 * Modificaciones en ArticuloManager:
 * Nuevos metodos:
 *   * tieneBiografia()
 *   * tieneNotaDePrensa()
 *   * tienePrimerCaptitulo()
 *   * tieneEntrevista()
 *
 * Revision 1.104  2006/12/29 12:33:33  omsartori
 * -Detalle Articulo
 *    - Modulo Extra
 *    - Comentarios
 *
 * Revision 1.103  2006/12/26 18:45:16  oLSuarez
 * Componentes de recomendaciones para detalleDeArticulo.jsp:
 * * recomendacionPorArticulo.jsp
 * * recomendacionPorAutor.jsp
 *
 * Revision 1.102  2006/12/18 20:06:11  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.101  2006/12/13 17:15:07  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.100  2006/11/27 13:03:36  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.99  2006/11/08 15:40:55  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.98  2006/10/12 14:58:29  omsartori
 * no message
 *
 * Revision 1.97  2006/09/28 14:57:32  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.96  2006/09/14 18:24:38  omsartori
 * Promociones II
 *
 * Revision 1.95  2006/06/22 18:26:29  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.94  2006/06/05 12:39:54  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.93  2006/05/19 14:24:25  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.92  2006/03/22 15:00:54  omsartori
 * - Pantallas de primer capitulo, biografias, indice de contenidos -> rediseñadas
 * - Generador de imagenes nuevas
 * - Correcciones en la aplicacion para cambios en base por backup
 * - Correccion en generacion de directorio
 * Revision 1.91  2006/02/21 19:35:53  oDZurita
 * - generacion de detalles reducidos estáticos conjunto a los detalles estáticos.
 * - adaptación de los componentes que hacen uso de los componentes estáticos generados.
 * - utilización del monitoreo de mapeo de la unidad de red en todas las generaciones de componentes estaticos.
 *
 * Revision 1.90  2006/01/11 17:37:10  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.89  2005/12/29 17:45:11  omsartori
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
 * Revision 1.88  2005/12/29 17:24:47  oDZurita
 * - interfaz para la generación estática de los detalles de artículos.
 * - modificaciones en el método de búsqueda de detalle de artículos.
 * - uso del sleep en el daemon de generación de detalles de articulos.
 * - creación del daemon para la generación de los recorrido de familias.
 * - corrección en las consultas de los mas vendidos.
 * - creación del servlet para la generación estática de los recorridos de familias.
 * - interfaz para la generación estática de los recorridos de familias.
 *
 * Revision 1.87  2005/12/19 13:03:13  oDZurita
 * - Creación de un Daemon que genera los detalles de los articulos determinados por la tabla articulos_generados.
 * - Creación de la clase MultiField para que pueda almacenar hasta 3 objetos. La misma es utilizada en la generación de los detalles estáticos.
 * - Utilización de iframes en el detalle del Artículo para mantener actualizados el precio, la disponibilidad y las formas de pago del articulo sin tener que generar todo el detalle de nuevo.
 * - Creación de un nuevo método, utilizado para la generación de la disponibilidad y el precio del articulo.
 * - Modificación del taglib de cotización del artículo para que solo realice la impresión de la disponibilidad y el precio del articulo.
 *
 * Revision 1.86  2005/12/13 16:16:37  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.85  2005/11/24 15:28:07  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.84  2005/11/21 20:00:29  oDZurita
 * - DBUtil: se crearon 2 nuevos metodos: uno para obtener el id y el nombre del autor recomendado y otro para obtener el id y la descripcion de los articulos recomendados
 * - detalleTapa.jsp: procesa la imagen para redimensionar el pop-up con javascript
 * - imagen.jsp: se elimino la lectura de la imagen para obtener sus dimensiones.
 * - detalle.jsp: de c/u de las secciones se mejoraron las busquedas de las biografias, los articulos y autores recomendados, y se elimino el chequeo del arbol de categorias.
 *
 * Revision 1.83  2005/09/22 18:38:08  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.82  2005/08/24 13:13:29  omsartori
 * - Modifcacion en homes.
 * - Referidos> cambio de direccion de envio
 *                      reporte de referidos por dia
 *
 * Revision 1.81  2005/08/16 16:08:09  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.80  2005/07/26 14:13:28  omsartori
 * - Modificaciones en Articulo Reducido
 * - Tag de Precio para Articulo
 * - Buscador por id de autor
 * - Buscador generico por atributo principal (DROMO)
 * - Home> Articulo reemplazado por Articulo Reducido
 *
 * Revision 1.79  2005/05/26 14:43:42  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.78  2005/05/17 14:38:37  omsartori
 * - Posicionamiento tags en pags desde el home, tags por producto, nueva pagina de biografia
 * - Referido, interface de carga modificada a tres referidos independientes, guarda nombre ap y mail
 *
 * Revision 1.77  2005/03/17 15:57:08  omsartori
 * - se cambio el plazo para enviar los reportes de socios registrados y compras por socios de 2 a 5 dias
 * - el reporte de compras por socios tiene en cuenta todos los socios que hayan comprado, no solo los registrados en el mes anterior
 *
 * Revision 1.76  2005/02/17 12:13:28  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.75  2005/01/24 15:17:55  omsartori
 * - Cambio en archivo de contenido, en configuracion flag de solapasEnMultilinea, diasIgnoradosNovedad, y se renombró el flag diaConsideradoNovedad por diasConsideradosNovedad.
 * - Se modficó solapas.jsp para soportar multilinea
 *
 * Revision 1.73  2005/01/12 16:41:21  omsartori
 * - Reporte de encuestas en pedido especial, agregado al de comentarios
 *
 * Revision 1.72  2005/01/12 15:29:36  oGPistoia
 * - Buscador de Atributos Dinamicos (solo falta la pagina)
 *
 * Revision 1.71  2005/01/12 14:02:10  omsartori
 * - Reporte de socios registrados se modificó para que sean socios que no hayan comprado
 * - Reporte de medio de cobro pasó de mensual a diario con el mes actual, se mejoró la performance de los qrys
 * - Reporte de compras por socios se mejoró la performance del qry
 * - Reporte de alianzas se modificó el horario
 *
 * Revision 1.70  2005/01/07 17:46:14  oGFritz
 * - Corrección del buscador por un error de js
 * - Reporte de compras por alianzas agregado
 * - Agregado de combo para opinionar sobre el pedido especial
 * -
 *
 * Revision 1.69  2005/01/05 18:26:05  oGPistoia
 * - Correccion de los reportes de totales
 *
 * Revision 1.68  2005/01/04 15:29:18  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.67  2004/12/30 15:25:54  omsartori
 * - Reporte de Seguimiento de RIO HB con un demonio
 * - Reemplacé Date por Calendar en los reportes
 *
 * Revision 1.66  2004/12/27 15:41:45  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
 *
 * Revision 1.65  2004/12/13 13:57:09  oGPistoia
 * - Pago a través de Home Banking
 *
 * Revision 1.64  2004/11/30 22:19:16  oGPistoia
 * - Aplicacion de las reglas de estados de articulos
 * - Agregado de las novedades en el catalogo de eXtra
 *
 * Revision 1.63  2004/11/18 17:03:36  omsartori
 * - Componentes genéricos, en inicio, lista de deseos y resultado de busqueda.
 *
 * Revision 1.62  2004/11/10 14:56:22  oGPistoia
 * - Faltaba el orden en la recomendacion
 *
 * Revision 1.61  2004/11/09 14:46:22  oGPistoia
 * - Ajustes para el nuevo motor de recomendaciones
 *
 * Revision 1.60  2004/10/19 14:47:09  oGPistoia
 * - Atributos dinámicos
 *
 * Revision 1.59  2004/09/10 15:12:53  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.58  2004/08/03 15:47:00  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.57  2004/06/30 18:23:01  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.56  2004/06/15 20:56:12  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.55  2004/06/09 18:49:43  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.54  2004/05/04 18:09:32  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.53  2004/03/25 18:18:49  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.52  2004/03/04 18:51:41  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.51  2004/02/27 13:44:17  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.50  2004/02/11 19:32:51  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.49  2003/12/22 22:26:53  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.48  2003/12/11 20:52:04  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.47  2003/12/04 17:19:09  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.46  2003/11/27 01:57:40  GPistoia
 * -Gasto de envio no tenia impuestos
 *
 * Revision 1.45  2003/11/26 15:36:55  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.44  2003/11/19 18:55:25  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.43  2003/11/11 17:52:08  GPistoia
 * -No muestra biografias habilitado si no hay biografias
 * -Correccion de link erroneo del dreamweaver
 *
 * Revision 1.42  2003/11/07 21:54:45  GPistoia
 * -Borre EJBs que no se usaban por los DAOs
 * -Mejoras en los queries de DBUtil, ahora son preparedStatements
 * -Mejora en arbol de categoria, filtro S/D y elimine arboles de 1 item
 * -Mostrar importe de los papeles
 *
 * Revision 1.41  2003/11/07 15:32:56  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.40  2003/10/29 19:57:21  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.39  2003/10/28 01:39:24  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.38  2003/10/22 18:44:55  GPistoia
 * -Correccion de links de paginas
 *
 * Revision 1.37  2003/10/21 22:05:33  GPistoia
 * -Arreglo de Formato
 * -Arreglo de recomendar solo disponibles
 * -Arreglo de recorrido por temas de solo disponibles.
 * -Arreglo solo 5 autores recomendados.
 *
 * Revision 1.36  2003/10/17 14:15:16  GPistoia
 * -Disponibilidad nula ahora es pedido especial
 * -Recalculo de importes de articulos
 *
 * Revision 1.35  2003/10/14 06:08:12  GPistoia
 * -Login extranet
 * -Control de seguridad en paginas de extranet
 *
 * Revision 1.34  2003/10/13 21:43:27  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.33  2003/10/07 14:52:14  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.32  2003/10/03 16:29:02  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.31  2003/09/29 17:20:07  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.30  2003/09/24 21:23:30  SLizardo
 * no message
 *
 * Revision 1.29  2003/09/23 13:55:10  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.28  2003/09/19 19:48:58  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.27  2003/09/17 19:32:05  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.26  2003/09/15 22:30:52  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.25  2003/09/11 18:08:41  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.24  2003/09/08 22:01:16  SLizardo
 * no message
 *
 * Revision 1.23  2003/09/08 13:54:37  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.22  2003/09/05 19:56:24  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.21  2003/09/04 21:39:27  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.20  2003/09/02 19:08:28  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.19  2003/09/01 13:54:51  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.18  2003/08/29 17:54:20  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.17  2003/08/27 18:43:49  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.16  2003/08/26 16:18:55  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.15  2003/08/22 14:03:54  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.14  2003/08/21 21:29:46  SLizardo
 * no message
 *
 * Revision 1.13  2003/08/21 17:48:26  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.12  2003/08/19 19:27:13  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.11  2003/08/15 15:59:20  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.10  2003/08/12 16:25:24  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.9  2003/08/11 14:26:40  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.8  2003/08/06 21:28:19  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.7  2003/08/02 16:58:04  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.6  2003/07/30 15:18:00  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.5  2003/07/28 19:21:26  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.4  2003/07/26 19:06:05  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 * Revision 1.3  2003/07/24 19:06:21  GPistoia
 * -Consulta para cotizaciones
 * -Consulta de Socio por login
 * -Tests de kernel
 *
 * Revision 1.2  2003/07/22 19:48:59  GPistoia
 * -Disco V para migracion de paginas
 *
 * Revision 1.1  2003/07/21 15:07:30  GPistoia
 * -Articulo
 * -Common y conversion
 * -Funciones para consulta
 *
 */
package com.tmk.kernel;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Vector;

public final class DBUtil {

	// Estadisticas
	public static String ORDENES_VALIDAS = "'1', '2', '4', '10', '12', '20', '22', '23', '41'";

	// Estadisticas
	public static String ORDENES_APROBADAS = "'4', '20', '22', '23', '41'";

	// Estadisticas
	public static String ORDENES_RECHAZADAS = "'11', '21', '5', '51'";

	// Ordenes en proceso, que no admiten cambio de direccion
	public static String ORDENES_DIRECCIONNOEDITABLE = "'1', '2', '10'";

	// Cantidad de Recomendaciones a mostrar
	public static int CANTIDAD_DE_RECOMENDACIONES_MAXIMO = 5;


	private static final String DATASOURCE = "jdbc/site";
	private static final String LOOPUP_NAME = "local/";
	
	private static DataSource ds=null;

	public static Calendar ULTIMA_ALERTA_DB = Calendar.getInstance();

	// carga el EJB correspondiente. Ej: Articulo
	public static final Object getHome(String nombreEJB) throws NamingException {
		return getInitialContext().lookup(LOOPUP_NAME + nombreEJB);
	}



	// Ejecuta un sequence
	public final static String getDBFunction(String function, String parameter) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT " + function + "('" + parameter + "') valor FROM DUAL");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					return resultSet.getString("valor");
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Ejecuta un sequence
	//Se implemento el manejo de excepciones para tener mas info
	public final static Integer getSequenceValue(String sequenceName) throws SQLException, NamingException {
		TmkLogger.debug("Generando sequence " + sequenceName);
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
						"SELECT " + sequenceName + ".nextval valor FROM dual");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return new Integer(resultSet.getInt("valor"));
					} catch (SQLException e) {
						TmkLogger.error("Generando sequence " + e.getMessage());
						throw e;
					} finally {
						resultSet.close();
					}
				} catch (SQLException e) {
					TmkLogger.error("Generando sequence " + e.getMessage());
					throw e;
				} finally {
					statement.close();
				}
			} catch (SQLException e) {
				TmkLogger.error("Generando sequence " + e.getMessage());
				throw e;
			}
				finally {
				connection.close();
			}
		} catch (NamingException e) {
			TmkLogger.error("Generando sequence " + e.getMessage());
			throw e;
		}
	}

	// Ejecuta un sequence
	public final static Long getSequenceLong(String sequenceName) throws SQLException, NamingException {
		TmkLogger.debug("Generando sequence " + sequenceName);
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
						"SELECT " + sequenceName + ".nextval valor FROM dual");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return new Long(resultSet.getLong("valor"));
					} catch (SQLException e) {
						TmkLogger.error("Generando sequence " + e.getMessage());
						throw e;
					} finally {
						resultSet.close();
					}
				} catch (SQLException e) {
					TmkLogger.error("Generando sequence " + e.getMessage());
					throw e;
				} finally {
					statement.close();
				}
			} catch (SQLException e) {
				TmkLogger.error("Generando sequence " + e.getMessage());
				throw e;
			} finally {
				connection.close();
			}
		} catch (NamingException e) {
			TmkLogger.error("Generando sequence " + e.getMessage());
			throw e;
		}
	}

	// Consulta en la tabla generica de parametros
	public static final Vector cargarDatosGenericos(String tag, boolean ordenarPorNombre) throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT rv_low_value, rv_meaning FROM CG_REF_CODES WHERE rv_domain = ? order by " +
			        ((ordenarPorNombre) ? "rv_meaning" : "rv_low_value"));
			try {
				int index = 0;
				statement.setString(++index, tag);
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector result = new Vector();
					while (resultSet.next()) {
						String clave = resultSet.getString("rv_low_value");
						String nombre = resultSet.getString("rv_meaning");
						Pair peer = new Pair(clave, nombre);
						result.add(peer);
					}

					// No venir el vector vacio, si es asi, aborta
					if (result.isEmpty()) throw new Exception("No se encontraron registros para " + tag);

					return result;

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Consulta en la tabla generica de parametros
	public static final String cargarDatosGenerico(String tag, Object valor) throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT rv_meaning FROM CG_REF_CODES WHERE rv_domain = ? AND rv_low_value = ?");
			try {
				int index = 0;
				statement.setString(++index, tag);
				statement.setObject(++index, valor);
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						return resultSet.getString("rv_meaning");
					} else {
						throw new Exception("No se encontraron registros para " + tag);
					}

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Ejecuta una consulta para obtener un numero de parametro
	public static final String getParameterString(String paramName) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT caracter FROM parametros WHERE id_parametro = ?");
			try {
	 			int index = 0;
				statement.setString(++index, paramName);
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					String result = resultSet.getString("caracter");
					TmkLogger.info(paramName + " = " + result);
					return result;
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Ejecuta una consulta para obtener un numero de parametro
	public static final int getParameterInt(String paramName) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT numero FROM parametros WHERE id_parametro = ?");
			try {
				int index = 0;
				statement.setString(++index, paramName);
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					int result = resultSet.getInt("numero");
					TmkLogger.info(paramName + " = " + result);
					return result;
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Ejecuta una consulta para obtener un numero de parametro
	public static final double getParameterDouble(String paramName) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT numero FROM parametros WHERE id_parametro = ?");
			try {
				int index = 0;
				statement.setString(++index, paramName);
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					double result = resultSet.getDouble("numero");
					TmkLogger.info(paramName + " = " + result);
					return result;
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public static final Pair getConsulta(String alcance) throws SQLException, NamingException {

		Pair par = null;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT id_consulta, descripcion " +
			        "  FROM (" +
			        "          SELECT id_consulta, descripcion" +
			        "	         FROM consulta" +
			        "	        WHERE alcance = '" + alcance + "'" +
			        "	          AND estado = 'S'" +
			        "	     ORDER BY f_alta desc" +
			        "		)" +
			        "  WHERE ROWNUM < 2"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						par = new Pair(Convert.toNumber(resultSet.getString("id_consulta"), new Integer(0)), resultSet.getString("descripcion"));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return par;
	}


	public static final String getOpinion(Integer id_consulta, Integer id_opinion) throws SQLException, NamingException {
		String retorno = "";
		if (id_consulta == null || id_opinion == null) {
			return retorno;
		}
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "   SELECT descripcion " +
			        "     FROM opinion " +
			        "    WHERE id_consulta = " + id_consulta +
			        "      AND id_opinion = " + id_opinion +
			        " ORDER BY id_opinion"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						retorno = resultSet.getString("descripcion");
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return retorno;
	}

	public static final Vector getOpinion(Integer id_consulta) throws SQLException, NamingException {

		Vector vector = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "   SELECT id_opinion, descripcion " +
			        "     FROM opinion " +
			        "    WHERE id_consulta = " + id_consulta +
			        "      AND estado = 'S'" +
			        " ORDER BY id_opinion"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Pair par = new Pair(resultSet.getString("id_opinion"), resultSet.getString("descripcion"));
						vector.add(par);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return vector;
	}

	public static final Vector getOpinionesPorConsulta(Integer id_consulta)  throws SQLException, NamingException {
		Vector vector = new Vector();
		int total = 0;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			" SELECT count(p.id_opinion) cantidad, o.descripcion" +
			" FROM pedido_especial p, opinion o" +
			" WHERE p.id_opinion = o.id_opinion" +
			" AND p.id_consulta =" + id_consulta +
			" GROUP BY p.id_opinion, o.descripcion" +
			" ORDER BY cantidad desc");
			try {
				  ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Pair par = new Pair(resultSet.getString("cantidad"), resultSet.getString("descripcion"));
						vector.add(par);
						total += resultSet.getInt("cantidad");
					}
					if (total > 0) {
						vector.add(new Integer (total));
					}
				}
				finally {
					resultSet.close();
				}
			}
			finally {
				statement.close();
			}
		}
		finally {
			connection.close();
		}
		return vector;
}

	// Ejecuta una consulta para obtener un item de tarjeta de socio
	public static final Integer getNuevoItemTarjetaSocio(Integer sucursal, Integer socio) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT MAX(ID_ITEM) value FROM TARJETA_SOCIO WHERE ID_SUCURSAL_SOCIO = ? AND ID_SOCIO = ?");
			try {
				int index = 0;
				statement.setInt(++index, sucursal.intValue());
				statement.setInt(++index, socio.intValue());
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					return new Integer(resultSet.getInt("value") + 1/*El que sigue*/);
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public static final String getTipoDeArticulo(String idTipoArticulo) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT DESCRIPCION FROM TIPOS_ARTICULOS WHERE ID_TIPO_ARTICULO = ?");
			try {
				int index = 0;
				statement.setString(++index, idTipoArticulo);
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					return resultSet.getString("DESCRIPCION");
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public static final Vector getTemasMusicales(int idArticulo) {

		Vector temas = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "SELECT nombre FROM articulos_temas_musicales WHERE id_articulo = ?");
				try {
					int index = 0;
					statement.setInt(++index, idArticulo);
					ResultSet resultSet = statement.executeQuery();
					try {
						while (resultSet.next()) {
							temas.add(resultSet.getString("nombre"));
						}
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			// No hace nada, simplemente sale sin temas
		}

		return temas;
	}

	public final static String getGenero(Integer idArticulo) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "select y.descripcion" +
			        " from categ_subfamilias y, articulos x" +
			        " where y.categoria_seccion = x.categoria_seccion" +
			        "   and y.categoria_grupo = x.categoria_grupo" +
			        "   and y.categoria_familia    = x.categoria_familia" +
			        "   and y.categoria_subfamilia = x.categoria_subfamilia" +
			        "   and x.id_articulo = ?");
			try {
				int index = 0;
				statement.setInt(++index, idArticulo.intValue());
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					return resultSet.getString("descripcion");
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public final static String getAuditorio(Integer idArticulo) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "select auditorio from articulos_auditorio where id_articulo = ?");
			try {
				int index = 0;
				statement.setInt(++index, idArticulo.intValue());
				ResultSet resultSet = statement.executeQuery();
				try {
					return (resultSet.next()) ? resultSet.getString("auditorio") : null;

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public interface ResultSetObserver {

		public void onRow(ResultSet resultSet) throws SQLException;
	}

	public final static void getIdDescripcion(String query, ResultSetObserver resultSetObserver) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall(query);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						resultSetObserver.onRow(resultSet);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public final static Vector getOtrosProductosParaAutor(Integer idArticulo, Integer idAutor) {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select id_articulo from (" +
				        "  select a.id_articulo from articulos a, articulos_autores b" +
				        "  where a.habilitado_tematika = 'S'" +
				        "    and a.id_articulo     = b.id_articulo" +
				        "    and b.id_articulo + 0 <> ?" +
				        "    and b.id_autor        = ?" +
				        "    order by a.fecha_alta )" +
				        " where rownum <= 5");
				try {
					int index = 0;
					statement.setInt(++index, idArticulo.intValue());
					statement.setInt(++index, idAutor.intValue());
					ResultSet resultSet = statement.executeQuery();
					try {
						Vector result = new Vector();
						while (resultSet.next()) {
							result.add(new Integer(resultSet.getInt("id_articulo")));
						}

						return (result.isEmpty()) ? null : result;

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}

		} catch (Exception e) {
			TmkLogger.debug("No se encontro recomendacion por autor para " + idArticulo + ":" + idAutor + ". Error " + e.getMessage());
			return null;
		}
	}

	public final static Vector getOtrosProductosIgualCategorias(
	        Integer idArticulo, Integer seccion, Integer grupo, Integer familia, Integer subfamilia) {

		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select id_articulo from (" +
				        "    select /*+ index( a arti2_fecha_alta_desc_idx_1 ) */" +
				        "      a.id_articulo, a.fecha_alta" +
				        "    from articulos         a" +
				        "    where a.habilitado_tematika   = 'S'" +
				        "      and a.id_articulo          <> ?" +
				        "      and a.categoria_subfamilia  = nvl(?, a.categoria_subfamilia)" +
				        "      and a.categoria_familia     = nvl(?, a.categoria_familia)" +
				        "      and a.categoria_grupo       = ?" +
				        "      and a.categoria_seccion     = ?" +
				        "    order by a.fecha_alta desc)" +
				        " where rownum  <= 5");
				try {
					int index = 0;
					statement.setObject(++index, idArticulo, Types.INTEGER);
					statement.setObject(++index, subfamilia, Types.INTEGER);
					statement.setObject(++index, familia, Types.INTEGER);
					statement.setObject(++index, grupo, Types.INTEGER);
					statement.setObject(++index, seccion, Types.INTEGER);
					ResultSet resultSet = statement.executeQuery();
					try {
						Vector result = new Vector();
						while (resultSet.next()) {
							result.add(new Integer(resultSet.getInt("id_articulo")));
						}

						return (result.isEmpty()) ? null : result;

					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}

		} catch (Exception e) {
			TmkLogger.debug("No se encontro registros para " + idArticulo + ". Error " + e.getMessage());
			return null;
		}
	}

	public final static String buildAddress(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_DOMICILIO) throws NamingException, SQLException {
		int addressCount = 0;

		String PREFIX = TIPO_DOMICILIO.substring(0, 2);
		if (TIPO_DOMICILIO.equals("FACT")) {
			PREFIX = "TF";
		}
		Connection connection = buildConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery(
				        "SELECT COUNT(*) FROM socios_domicilios WHERE id_sucursal = " + ID_SUCURSAL + " AND id_socio = " + ID_SOCIO + " AND tipo_domicilio LIKE '" + PREFIX + "__'");
				try {
					if (resultSet.next()) {
						addressCount = resultSet.getInt(1);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}

		//TmkLogger.debug("PREFIJO " +  PREFIX);

		if (PREFIX.equals("EN")) {
			if (addressCount == 0) {
				return "ENVI";
			} else {
				return "EN" + (new DecimalFormat("00").format(addressCount + 1));
			}
		} else if (PREFIX.equals("TF")) {
			return "TF" + (new DecimalFormat("00").format(addressCount + 1));
		}

		return null;
	}


	public final static String buildPhone(Integer ID_SUCURSAL, Integer ID_SOCIO, String TIPO_TELEFONO) throws NamingException, SQLException {
		int addressCount = 0;

		String PREFIX = TIPO_TELEFONO.substring(0, 2);
		if (TIPO_TELEFONO.equals("FACT")) {
			PREFIX = "TF";
		}
		Connection connection = buildConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery(
				        "SELECT COUNT(*) FROM socios_telefonos WHERE id_sucursal = " + ID_SUCURSAL + " AND id_socio = " + ID_SOCIO + " AND tipo_telefono LIKE '" + PREFIX + "__'");
				try {
					if (resultSet.next()) {
						addressCount = resultSet.getInt(1);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}

		if (PREFIX.equals("EN")) {
			if (addressCount == 0) {
				return "ENVI";
			} else {
				return "EN" + (new DecimalFormat("00").format(addressCount + 1));
			}
		} else if (PREFIX.equals("TF") || TIPO_TELEFONO.equals("FACT")) {
			if (addressCount == 0) {
				return "FACT";
			} else {
				return "TF" + (new DecimalFormat("00").format(addressCount + 1));
			}

		} else if (PREFIX.equals("FA")) {
			if (addressCount == 0) {
				return "FAX";
			} else {
				return "FA" + (new DecimalFormat("00").format(addressCount + 1));
			}
		} else if (PREFIX.equals("LA"))	{
			if (addressCount == 0) {
				return "LABO";
			} else {
				return "LA" + (new DecimalFormat("00").format(addressCount + 1));
			}
		} else if (PREFIX.equals("MO")) {
			if (addressCount == 0) {
				return "MOVI";
			} else {
				return "MO" + (new DecimalFormat("00").format(addressCount + 1));
			}
		} else if (PREFIX.equals("PA")) {
			if (addressCount == 0) {
				return "PART";
			} else {
				return "PA" + (new DecimalFormat("00").format(addressCount + 1));
			}
		}

		return null;
	}

	// Consulta fuera del EJB
	public static final double cargarUltimaCotizacion(int idMoneda) throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT COMPRA FROM COTIZACIONES c WHERE c.ID_MONEDA = ?" +
			        " AND c.FECHA_VIGENCIA = " +
			        "  (SELECT MAX(d.FECHA_VIGENCIA) " +
			        "   FROM COTIZACIONES d " +
			        "   WHERE d.ID_MONEDA = c.ID_MONEDA AND d.FECHA_VIGENCIA <= SYSDATE)");
			try {
				int index = 0;
				statement.setInt(++index, idMoneda);
				ResultSet resultSet = statement.executeQuery();
				try {
					resultSet.next();
					return resultSet.getDouble("COMPRA");
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// Consulta en la tabla de profesiones (podrian haberlo hecho en cg_ref_codes, pero habria estado demasiado bien.
	public static final ProfesionDAO[] cargarProfesiones() throws Exception {
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall(
			        "SELECT id_profesion, descripcion FROM profesiones ORDER BY DESCRIPCION");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					while (resultSet.next()) {
						int clave = resultSet.getInt("id_profesion");
						String nombre = resultSet.getString("descripcion");
						ProfesionDAO profesionDAO = new ProfesionDAO(clave, nombre);
						temp.add(profesionDAO);
					}

					// No venir el vector vacio, si es asi, aborta
					if (temp.isEmpty()) throw new Exception("No se encontraron registros.");

					// devuelve el vector
					return (ProfesionDAO[]) temp.toArray(new ProfesionDAO[temp.size()]);

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Carga el gasto de envio correspondiente
	 */
	public static final Vector cargarDatosDeGastosDeEnvio(PaisDAO paisDAO, ProvinciaDAO provinciaDAO) throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT z.importe, z.adicional, z.descripcion FROM GASTOS_ENVI_ZONAS z, GASTOS_ENVI_ZONAS_PAISES zpp" +
			        "   WHERE (z.id_zona = zpp.id_zona)" +
			        "     AND (zpp.id_pais = ?)" +
			        "     AND (zpp.id_provincia = ? OR" +
			        "          zpp.id_provincia is null)" +
			        "  ORDER BY NVL(zpp.id_provincia, -1) desc");
			try {
				int index = 0;
				statement.setInt(++index, paisDAO.getId());
				statement.setInt(++index, provinciaDAO.getId());
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						Vector valores = new Vector();
						valores.add(new Double(resultSet.getDouble("importe")));
						valores.add(new Double(resultSet.getDouble("adicional")));
						valores.add(resultSet.getString("descripcion"));
						return valores;
					} else {
						throw new Exception("No se encontraron gastos para " + paisDAO + " y " + provinciaDAO);
					}

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Carga los posibles estados de la orden
	 */
	public static final EstadoOrdenDAO[] cargarEstadosDeOrden() throws Exception {
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall(
			        "SELECT estado, descripcion, descripcion_extendida FROM estado_orden");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					while (resultSet.next()) {
						String estado = resultSet.getString("estado");
						String nombre = resultSet.getString("descripcion");
						String descripcion = resultSet.getString("descripcion_extendida");
						EstadoOrdenDAO estadoOrdenDAO = new EstadoOrdenDAO(estado, nombre, descripcion);
						temp.add(estadoOrdenDAO);
					}

					// No venir el vector vacio, si es asi, aborta
					if (temp.isEmpty()) throw new Exception("No se encontraron registros.");

					return (EstadoOrdenDAO[]) temp.toArray(new EstadoOrdenDAO[temp.size()]);

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Carga los posibles estados del item de la orden
	 */
	public static final EstadoItemOrdenDAO[] cargarEstadosItemDeOrden() throws Exception {
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall(
			        "SELECT estado, descripcion FROM estado_item_orden");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					while (resultSet.next()) {
						String estado = resultSet.getString("estado");
						String nombre = resultSet.getString("descripcion");
						EstadoItemOrdenDAO estadoItemOrdenDAO = new EstadoItemOrdenDAO(estado, nombre);
						temp.add(estadoItemOrdenDAO);
					}

					// No venir el vector vacio, si es asi, aborta
					if (temp.isEmpty()) throw new Exception("No se encontraron registros.");

					return (EstadoItemOrdenDAO[]) temp.toArray(new EstadoItemOrdenDAO[temp.size()]);

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Carga los posibles niveles de riesgo de una orden
	 */
	public static final NivelDeRiesgoDAO[] cargarNivelesDeRiesgo() throws Exception {
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall(
			        "SELECT nivel_riesgo, descripcion FROM nivel_de_riesgo");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					while (resultSet.next()) {
						int clave = resultSet.getInt("nivel_riesgo");
						String descripcion = resultSet.getString("descripcion");
						NivelDeRiesgoDAO nivelDeRiesgoDAO = new NivelDeRiesgoDAO(clave, descripcion);
						temp.add(nivelDeRiesgoDAO);
					}

					return (NivelDeRiesgoDAO[]) temp.toArray(new NivelDeRiesgoDAO[temp.size()]);

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Calcula tasas
	 */
	public static final Pair calculaTasas(String idImpuesto) throws SQLException, NamingException {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT TASA_GENERAL, TASA_ADICIONAL, TASA_PERCEP_VIDEO FROM TASAS WHERE ID_IMPUESTO = ?" +
			        " AND ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE +
			        " AND FECHA_VIGENCIA = (SELECT MAX(FECHA_VIGENCIA)" +
			        " FROM TASAS WHERE ID_IMPUESTO = ?" +
			        " AND ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE +
			        " AND FECHA_VIGENCIA <= sysdate)");
			try {
				int index = 0;
				statement.setString(++index, idImpuesto);
				statement.setString(++index, idImpuesto);
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						Object objectTasaGeneral = resultSet.getObject("TASA_GENERAL");
						Object objectTasaAdicional = resultSet.getObject("TASA_ADICIONAL");
						Object objectPercepVideo = resultSet.getObject("TASA_PERCEP_VIDEO");
						double tasaGeneral = (objectTasaGeneral == null) ? 0.0 : ((Number) objectTasaGeneral).doubleValue();
						double tasaAdicional = (objectTasaAdicional == null) ? 0.0 : ((Number) objectTasaAdicional).doubleValue();
						double tasaPercepVideo = (objectPercepVideo == null) ? 0.0 : ((Number) objectPercepVideo).doubleValue();
						return new Pair(new Double(tasaGeneral + tasaAdicional), new Double(tasaPercepVideo));

					} else {
						return new Pair(new Double(0.0), new Double(0.0));
					}

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Calcula el porcentaje del pricing a aplicar
	 */
	public static final Pair calculaPricing(Integer idArticulo) throws Exception {
		int idLista = 0;
		double porcentaje = 0.0;
		Connection connection = buildConnection();
		try {
			CallableStatement statement = connection.prepareCall("{call Pricingpk.articulo_en_lista (?, ?, ?, ?)}");
			try {
				statement.setInt(1, idArticulo.intValue());
				statement.registerOutParameter(2, java.sql.Types.INTEGER);  // p_lista_aplicada
				statement.registerOutParameter(3, java.sql.Types.DOUBLE);   // p_precio_aplicado
				statement.registerOutParameter(4, java.sql.Types.DOUBLE);   /// p_porcentaje_aplicado
				statement.execute();
				idLista = statement.getInt(2);
				porcentaje = statement.getDouble(4);

			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return new Pair(new Integer(idLista), new Double(porcentaje));
	}

	/*Nueva recomendacion de articulos*/
	public static final Vector articulosRecomendados (int idArticulo, int cantidad) {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();

                qry.append(" SELECT titulo, id_articulo_relacionado ");
				qry.append(" FROM ");
				qry.append("    ( ");
				qry.append("    SELECT titulo, id_articulo_relacionado");
				qry.append("    FROM ");
				qry.append("        ( ");
				qry.append("        SELECT arr.titulo, rco.id_articulo_relacionado, rco.cant_comprobantes ");
				qry.append("        FROM articulos arr, articulos art, rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado ");
				qry.append("            AND art.id_articulo  = rco.id_articulo AND rco.cant_comprobantes>= ");
				qry.append("            GET_RECO_UMBRAL_CATEGORIA (art.categoria_seccion, art.categoria_grupo, art.categoria_familia, ");
				qry.append("            art.categoria_subfamilia, NULL, art.fecha_alta) AND rco.tipo_relacion = 'C' AND rco.id_articulo =").append(idArticulo);
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        UNION ");
				qry.append("        SELECT arr.titulo, rco.id_articulo_relacionado, rco.cant_comprobantes" );
				qry.append("        FROM articulos arr,rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado AND rco.tipo_relacion = 'M' ");
				qry.append("            AND rco.id_articulo =").append(idArticulo).append(" AND NVL(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE ");
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        ) ");
				qry.append("    ORDER BY cant_comprobantes desc");
				qry.append("    ) ");
				qry.append(" WHERE rownum <=").append(cantidad);

				//TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
                             retorno.add("" + rs.getInt("id_articulo_relacionado"));
							 retorno.add("" + rs.getString("titulo"));
						 }
					} catch (Exception e) {
                        TmkLogger.error("Recomendacion Articulos (falla asignacion)" + idArticulo + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("Recomendacion Articulos (falla ejecucion qry)" + idArticulo + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("Recomendacion Articulos (falla armado qry)" + idArticulo + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("Recomendacion Articulos (falla conexion)" + idArticulo + " " + e.toString());
		}
        return retorno;
	}
	/*Nueva recomendacion de articulos*/



	/**
	 * Devuelve los articulos recomendados segun idArticulo del parametro
	 * Devuelve tambien un campo con el titulo del idArticulo pasado por parametro
	 */
	public static final Vector articulosRecomendadosPorArticulo (int idArticulo, int cantidad) {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();

				qry.append(" SELECT s.titulo,id_articulo_relacionado,art.titulo titparametro ");
				qry.append(" FROM articulos art, ");
				qry.append(" (");
				qry.append(" SELECT titulo, id_articulo_relacionado, id_articulo");
				qry.append(" FROM ");
				qry.append("    ( ");
				qry.append("    SELECT titulo, id_articulo_relacionado, id_articulo");
				qry.append("    FROM ");
				qry.append("        ( ");
				qry.append("        SELECT arr.titulo, rco.id_articulo_relacionado, rco.cant_comprobantes, rco.id_articulo ");
				qry.append("        FROM articulos arr, articulos art, rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado ");
				qry.append("            AND art.id_articulo  = rco.id_articulo AND rco.cant_comprobantes>= ");
				qry.append("            GET_RECO_UMBRAL_CATEGORIA (art.categoria_seccion, art.categoria_grupo, art.categoria_familia, ");
				qry.append("            art.categoria_subfamilia, NULL, art.fecha_alta) AND rco.tipo_relacion = 'C' AND rco.id_articulo =").append(idArticulo);
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        UNION ");
				qry.append("        SELECT arr.titulo, rco.id_articulo_relacionado, rco.cant_comprobantes, rco.id_articulo" );
				qry.append("        FROM articulos arr,rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado AND rco.tipo_relacion = 'M' ");
				qry.append("            AND rco.id_articulo =").append(idArticulo).append(" AND NVL(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE ");
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        ) ");
				qry.append("    ORDER BY cant_comprobantes desc");
				qry.append("    ) ");
				qry.append(" WHERE rownum <=").append(cantidad);
				qry.append(" ) s where art.id_articulo = ").append(idArticulo);

				//TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
                             retorno.add("" + rs.getInt("id_articulo_relacionado"));
							 retorno.add("" + rs.getString("titulo"));
							 retorno.add("" + rs.getString("titparametro"));
						 }
					} catch (Exception e) {
                        TmkLogger.error("Recomendacion Articulos (falla asignacion)" + idArticulo + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("Recomendacion Articulos (falla ejecucion qry)" + idArticulo + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("Recomendacion Articulos (falla armado qry)" + idArticulo + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("Recomendacion Articulos (falla conexion)" + idArticulo + " " + e.toString());
		}
        return retorno;
	}


	/*Nueva recomendacion de articulos para COMPRA*/
	public static final Vector articulosRecomendadosCompra (com.tmk.socio.SocioPK socioPK, int cantidad) {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();

                qry.append(" SELECT id_articulo_relacionado ");
				qry.append(" FROM ");
				qry.append("    ( ");
				qry.append("    SELECT  id_articulo_relacionado");
				qry.append("    FROM ");
				qry.append("        ( ");
				qry.append("        SELECT  rco.id_articulo_relacionado, rco.cant_comprobantes ");
				qry.append("        FROM articulos arr, articulos art, rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado ");
				qry.append("            AND art.id_articulo  = rco.id_articulo AND rco.cant_comprobantes>= ");
				qry.append("            GET_RECO_UMBRAL_CATEGORIA (art.categoria_seccion, art.categoria_grupo, art.categoria_familia, ");
				qry.append("            art.categoria_subfamilia, NULL, art.fecha_alta) AND rco.tipo_relacion = 'C'");
				qry.append("			AND rco.id_articulo in (SELECT id_articulo");
				qry.append("									FROM (");
				qry.append("										 	SELECT id_articulo, f_alta");
				qry.append("											FROM(");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_compra");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("														AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_lista_deseos");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("											SELECT id_articulo, io.f_alta");
				qry.append("											FROM orden o, item_orden io");
				qry.append("											WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("													AND o.id_orden = io.id_orden");
				qry.append("												)");
				qry.append("									 ORDER BY f_alta desc");
				qry.append("											)");
				qry.append("									WHERE rownum <= 5");
				qry.append("									)");
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        UNION ");
				qry.append("        SELECT rco.id_articulo_relacionado, rco.cant_comprobantes" );
				qry.append("        FROM articulos arr,rco_articulos_relacionados rco ");
				qry.append("        WHERE arr.activo = 'SI' AND arr.id_articulo = rco.id_articulo_relacionado AND rco.tipo_relacion = 'M' ");
				qry.append("			AND rco.id_articulo in (SELECT id_articulo");
				qry.append("									FROM (");
				qry.append("										 	SELECT id_articulo, f_alta");
				qry.append("											FROM(");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_compra");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("														AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_lista_deseos");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("											SELECT id_articulo, io.f_alta");
				qry.append("											FROM orden o, item_orden io");
				qry.append("											WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("													AND o.id_orden = io.id_orden");
				qry.append("												)");
				qry.append("									 ORDER BY f_alta desc");
				qry.append("											)");
				qry.append("									WHERE rownum <= 5");
				qry.append("									)");
				qry.append(" 			AND NVL(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE ");
				qry.append("            AND arr.habilitado_tematika = 'S' ");
				qry.append("            AND arr.categoria_seccion in  (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append("        ) ");
				qry.append("    WHERE id_articulo_relacionado not in (SELECT id_articulo");
				qry.append("									FROM (");
				qry.append("										 	SELECT id_articulo, f_alta");
				qry.append("											FROM(");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_compra");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("														AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("													SELECT id_articulo, f_alta");
				qry.append("													FROM carrito_lista_deseos");
				qry.append("													WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("											UNION");
				qry.append("											SELECT id_articulo, io.f_alta");
				qry.append("											FROM orden o, item_orden io");
				qry.append("											WHERE id_sucursal_socio =").append(socioPK.ID_SUCURSAL);
				qry.append("													AND id_socio =").append(socioPK.ID_SOCIO);
				qry.append("													AND o.id_orden = io.id_orden");
				qry.append("												)");
				qry.append("									 ORDER BY f_alta desc");
				qry.append("											)");
				//qry.append("									WHERE rownum <= 5"); Habilitado me puede recomendar algo que ya compre!!
				qry.append("									)");
				qry.append("    ORDER BY cant_comprobantes desc");
				qry.append("    ) ");
				qry.append(" WHERE rownum <=").append(cantidad);
                //TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
                             retorno.add("" + rs.getInt("id_articulo_relacionado"));
						 }
					} catch (Exception e) {
                        TmkLogger.error("Recomendacion Articulos (falla asignacion) " + socioPK.toString() + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("Recomendacion Articulos (falla ejecucion qry) " +  socioPK.toString() + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("Recomendacion Articulos (falla armado qry) " + socioPK.toString() + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("Recomendacion Articulos (falla conexion) " + socioPK.toString() + " " + e.toString());
		}
        return retorno;
	}
	/*Nueva recomendacion de articulos para COMPRA*/



	/*Nueva recomendacion de autores*//*
	public static final Vector autoresRecomendados (int idAutor, int cantidad) {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT id_autor,  nombre_autor_relacionado");
				qry.append(" FROM ");
				qry.append("    ( ");
				qry.append("    SELECT id_autor, nombre_autor_relacionado");
				qry.append("    FROM ");
				qry.append("        ( ");
				qry.append("        SELECT aur.id_autor, aur.descripcion nombre_autor_relacionado, rco.cant_comprobantes ");
				qry.append("        FROM autores aur, autores aut, ");
				qry.append("            rco_autores_relacionados rco ");
				qry.append("        WHERE aur.id_autor = rco.id_autor_relacionado ");
				qry.append("            and aut.id_autor = rco.id_autor ");
				qry.append("            and rco.tipo_relacion  = 'C' ");
				qry.append("            and rco.id_autor = ").append(idAutor);
				qry.append("            and rco.cant_comprobantes >= parametro_numero('RECO_UMBRAL_PARA_AUTORES') ");
				qry.append("        UNION ");
				qry.append("        SELECT aur.id_autor, ");
				qry.append("            aur.descripcion nombre_autor_relacionado, rco.cant_comprobantes ");
				qry.append("        FROM autores aur, ");
				qry.append("            autores aut, ");
				qry.append("            rco_autores_relacionados rco ");
				qry.append("        WHERE aur.id_autor = rco.id_autor_relacionado ");
				qry.append("            and aut.id_autor = rco.id_autor ");
				qry.append("            and rco.tipo_relacion = 'M' ");
				qry.append("            and rco.id_autor = ").append(idAutor);
				qry.append("            and nvl(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE ");
				qry.append("        ) ");
				qry.append("    ORDER BY cant_comprobantes desc");
				qry.append("    ) ");
				qry.append(" WHERE rownum <=").append(cantidad);


				//TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
                             retorno.add("" + rs.getInt("id_autor"));
							 retorno.add("" + rs.getString("nombre_autor_relacionado"));
						 }
					} catch (Exception e) {
                        TmkLogger.error("Recomendacion Autor (falla asignacion)" + idAutor + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("Recomendacion Autor (falla ejecucion qry)" + idAutor + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("Recomendacion Autor (falla armado qry)" + idAutor + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("Recomendacion Autor (falla conexion)" + idAutor + " " + e.toString());
		}
		return retorno;
	}*/
	/*Nueva recomendacion de autores*/


	/**
	 * Recomendacion de autores por articulo ingresado
	 * */
	public static final Vector articulosRecomendadosPorAutor(int idArticulo, String role ,int cantidad) {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();
				qry.append(" SELECT id_articulo");
				qry.append(" FROM (");
				qry.append(" 	SELECT aa.id_articulo");
				qry.append(" 	FROM articulos_autores aa, articulos a ");
				qry.append(" 	WHERE");
				qry.append(" 		a.id_articulo = aa.id_articulo");
				qry.append(" 		and a.categoria_seccion in (").append(Globals.getSeccionesHabilitadasSQL()).append(")");
				qry.append(" 		and habilitado_tematika = 'S'");
				qry.append(" 		and aa.role IN(").append(role).append(")");
				qry.append(" 		and aa.id_autor");
				qry.append(" 		in( ");
				qry.append(" 		SELECT id_autor");
				qry.append(" 		FROM (");
				qry.append(" 			SELECT id_autor");
				qry.append(" 			FROM (");
				qry.append(" 				SELECT  rco.id_autor_relacionado id_autor, rco.cant_comprobantes ");
				qry.append(" 				FROM autores aa1, autores aa2,");
				qry.append(" 				rco_autores_relacionados rco");
				qry.append(" 				WHERE aa1.id_autor = rco.id_autor_relacionado ");
				qry.append(" 				and aa2.id_autor = rco.id_autor");
				qry.append(" 				and rco.tipo_relacion  = 'C'");
				qry.append(" 				and rco.id_autor in (");
				qry.append(" 					SELECT id_autor");
				qry.append(" 					FROM articulos_autores aa");
				qry.append(" 					WHERE id_articulo= ").append(idArticulo);
				qry.append(" 						AND aa.role in (").append(role).append("))");
				qry.append(" 						and rco.cant_comprobantes >= parametro_numero('RECO_UMBRAL_PARA_AUTORES')");
				qry.append(" 				UNION");
				qry.append(" 					SELECT  rco.id_autor_relacionado, rco.cant_comprobantes");
				qry.append(" 					FROM autores aa1, autores aa2,");
				qry.append(" 						rco_autores_relacionados rco");
				qry.append(" 					WHERE aa1.id_autor = rco.id_autor_relacionado");
				qry.append(" 						and aa2.id_autor = rco.id_autor");
				qry.append(" 						and rco.tipo_relacion  = 'C'");
				qry.append(" 						and rco.id_autor in (");
				qry.append(" 						SELECT id_autor");
				qry.append(" 						FROM articulos_autores aa");
				qry.append(" 						WHERE id_articulo= ").append(idArticulo);
				qry.append(" 							AND aa.role in (").append(role).append("))");
				qry.append(" 						and nvl(rco.fecha_expiracion, SYSDATE + 1) >= SYSDATE)");
				qry.append(" 						ORDER BY cant_comprobantes desc )");
				qry.append(" 						WHERE rownum <= ").append(cantidad);
				qry.append(" 						)order by id_articulo desc )");
				qry.append(" 					 WHERE rownum<= ").append(cantidad);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
                             retorno.add("" + rs.getInt("id_articulo"));
						 }
					} catch (Exception e) {
                        TmkLogger.error("Recomendacion Autor (falla asignacion)" + idArticulo + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("Recomendacion Autor (falla ejecucion qry)" + idArticulo + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("Recomendacion Autor (falla armado qry)" + idArticulo + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("Recomendacion Autor (falla conexion)" + idArticulo + " " + e.toString());
		}
		return retorno;
	}
	/**
	 * Fin Recomendacion de autores por articulo ingresado
	 * */







	/**
	 * Generar las recomendaciones para el articulo
	 */
	public static final Vector recomendarArticulo(int idArticulo) throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "  SELECT r.id_articulo_recomendado" +
			        "     FROM recomendacion_articulos r, articulos a, disponibilidades d" +
			        "    WHERE r.id_articulo = ?" +
			        "      AND r.id_articulo_recomendado = a.id_articulo" +
			        "      AND a.id_disponibilidad = d.id_disponibilidad" +
			        "      AND a.habilitado_tematika = 'S'" +
			        "      AND d.pedido_especial = 'N'" +
			        "      AND d.id_esquema = 'PROD'" +
			        " ORDER BY r.orden");

			try {
				int index = 0;
				statement.setInt(++index, idArticulo);
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					int count = 0;
					while (resultSet.next() && (count++ < CANTIDAD_DE_RECOMENDACIONES_MAXIMO)) {
						temp.add(new Integer(resultSet.getInt("id_articulo_recomendado")));
					}
					return temp;

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	/**
	 * Busca los autores de los articulos
	 */
	/*public static final Vector autoresPorArticulos(Vector articulos) throws Exception {
		Connection connection = buildConnection();
		try {
			StringBuffer query = new StringBuffer("SELECT DISTINCT id_autor FROM ARTICULOS_AUTORES WHERE");
			for (int i = 0; i < articulos.size(); i++) {
				if (i > 0) query.append(" OR");
				query.append(" id_articulo = ").append(articulos.get(i));
			}
			PreparedStatement statement = connection.prepareStatement(query.toString());
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					Vector temp = new Vector();
					int count = 0;
					while (resultSet.next() && (count++ < CANTIDAD_DE_RECOMENDACIONES_MAXIMO)) {
						temp.add(new Integer(resultSet.getInt("id_autor")));
					}
					return temp;

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}*/



	/**
	 * Busca los atributos dinamicos, especialmente pensado para Dromo
	 */
	public static final Vector getAtributosDinamicos(int idArticulo, Integer seccion, Integer grupo, Integer familia) throws Exception {

		Connection connection = DBUtil.buildConnection();
		try {
			Vector prompts = new Vector();
			StringBuffer attributes = new StringBuffer();

			CallableStatement statement = connection.prepareCall(
			        "select prompt, campo_articulos2 field from atributos_x_familia" +
			        "  where categoria_seccion " + (seccion == null ? " is not null " : " = " + seccion) +
			        "  and categoria_grupo " + (grupo == null ? " is not null " : " = " + grupo) +
			        "  and categoria_familia " + (familia == null ? " is not null " : " = " + familia) +
			        "  order by prompt");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						String prompt = resultSet.getString("prompt");
						String field = resultSet.getString("field");

						if (attributes.length() > 0) attributes.append(',');
						attributes.append(field);
						prompts.add(prompt);
					}

				} finally {
					resultSet.close();
				}

			} finally {
				statement.close();
			}

			if (prompts.isEmpty()) {

				// No tiene ningun campo adicional para mostrar
				return null;

			} else {
				StringBuffer dynamicQuery = new StringBuffer();
				dynamicQuery.append("SELECT ").append(attributes).append(" FROM ARTICULOS WHERE ID_ARTICULO = ").append(idArticulo);

				CallableStatement dynamicStatement = connection.prepareCall(dynamicQuery.toString());
				try {
					ResultSet resultSet = dynamicStatement.executeQuery();
					try {

						Vector pairs = new Vector();

						while (resultSet.next()) {
							for (int i = 0; i < prompts.size(); i++) {
								try {
									int index = i + 1;  // maldito resultset empieza de 1, como para no hacerlo compatible con java
									Object value = resultSet.getObject(index);
									if (value != null) {
										pairs.add(new Pair(prompts.get(i), value));
									}
								} catch (Exception e) {
									TmkLogger.debug("Fallo al recuperar al columna Nro " + i);
								}
							}
						}

						// Finalmente recien aca retorna el conjunto de valores
						return pairs;

					} finally {
						resultSet.close();
					}
				} finally {
					dynamicStatement.close();
				}
			}

		} finally {
			connection.close();
		}
	}

	/**
	 * Se fija cuantos usuarios hay conectados
	 */
	public static final Pair[] usuariosConectados() throws Exception {
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT OSUSER, COUNT(*) FROM V$SESSION GROUP BY OSUSER, USERNAME");
			try {

				ResultSet resultSet = statement.executeQuery();
				try {

					Vector temp = new Vector();
					while (resultSet.next()) {
						String usuario = resultSet.getString(1);
						int cantidad = resultSet.getInt(2);
						Pair pair = new Pair(usuario, new Integer(cantidad));
						temp.add(pair);
					}

					return (Pair[]) temp.toArray(new Pair[temp.size()]);

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}

	}

	// Eliminar los productos del carrito anteriores a una fecha data
	public static final void limpiarCarrito() throws Exception {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "delete from carrito_compra " +
				        "   where fecha < trunc(sysdate - " + Globals.VIGENCIA_DEL_CARRITO_EN_DIAS + ", 'DD')");
				try {
					//return statement.executeUpdate();
					TmkLogger.info("Se borraron " + statement.executeUpdate() + " productos del carrito");
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puedo limpiar el carrito. " + e.toString());
			throw e;
		}
	}

	// Estadisticas
	public static final int cantidadDeProductosEnCarrito() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement("select count(*) cantidad from carrito_compra");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular el total de productos vendidos hoy " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadDeVisitasHoy() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select sum(cant_visitas) visitas from VISITA_X_ALIANZA_SECCION" +
				        "   where fecha_visita >= trunc(sysdate)" +
				        "       and fecha_visita <= sysdate");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("visitas");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular la cantidad de visitas " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadDeVisitasDesdeUnDiaAtras() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select sum(cant_visitas) visitas from VISITA_X_ALIANZA_SECCION" +
				        "   where fecha_visita >= sysdate - 1" +
				        "       and fecha_visita <= sysdate");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("visitas");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular la cantidad de visitas " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final Pair totalesOrdenesHoy() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select count(*) cantidad, sum(total) total from orden o" +
				        "   where o.estado in (" + ORDENES_VALIDAS + ")" +
				        "   and fecha >= trunc(sysdate, 'DD')");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return new Pair(
						        new Integer(resultSet.getInt("cantidad")),
						        new Double(resultSet.getDouble("total")));
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular el total vendido hoy " + e.getMessage());
			return new Pair(new Integer(0), new Double(0.0));
		}
	}

	// Estadisticas
	public static final Pair totalesOrdenesMes() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select count(*) cantidad, sum(total) total from orden o" +
				        "   where o.estado in (" + ORDENES_APROBADAS + ")" +
				        "   and fecha >= trunc(sysdate, 'MM')");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return new Pair(
						        new Integer(resultSet.getInt("cantidad")),
						        new Double(resultSet.getDouble("total")));
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular el total vendido hoy " + e.getMessage());
			return new Pair(new Integer(0), new Double(0.0));
		}
	}

	// Estadisticas
	public static final int cantidadProductosVendidosHoy() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select sum(i.cantidad) cantidad from orden o, item_orden i, articulos a" +
				        "   where o.estado in (" + ORDENES_VALIDAS + ")" +
				        "   and fecha >= trunc(sysdate) and fecha < sysdate + 1" +
				        "   and o.id_orden = i.id_orden" +
				        "   and i.id_articulo = a.id_articulo" +
				        "   and categoria_seccion != " + Globals.GASTO_DE_ENVIO_CATEGORIA_SECCION);
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular el total de productos vendidos hoy " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadItemsVendidosHoy() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select sum(i.cantidad) cantidad from orden o, item_orden i" +
				        "   where o.estado in (" + ORDENES_VALIDAS + ")" +
				        "   and fecha >= trunc(sysdate) and fecha < sysdate + 1" +
				        "   and o.id_orden = i.id_orden");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular el total de productos vendidos hoy " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadDeUsuariosRegistradosHoy() {
		try {
			Connection connection = buildConnection();
			try {

				PreparedStatement statement = connection.prepareStatement(
						" select sum(cantidad) from  " +
						" (select count(*) cantidad from socios2" +
				        "   where f_alta >= trunc(sysdate)" +
				        "   and f_alta < sysdate + 1" +
				        "   and password is not null " +
				        " union " +
						" select count(*) cantidad from socios_tmk" +
				        "   where f_alta >= trunc(sysdate)" +
				        "   and f_alta < sysdate + 1)" );

				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular la cantidad de usuarios de hoy " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadDeOrdenes(boolean todoElMes, String estados, String idMediosDePago) {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        " SELECT count(*) cantidad" +
				        "   FROM orden o, pago_orden p" +
				        "  WHERE o.fecha >= trunc(sysdate, '" + ((todoElMes) ? "MM" : "DD") + "')" +
				        "    AND o.id_orden = p.id_orden" +
				        ((estados == null) ? "" : "    AND o.estado IN (" + estados + ")") +
				        ((idMediosDePago == null) ? "" : "    AND p.id_medio_cobro IN (" + idMediosDePago + ")"));

				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular las ordenes " + e.getMessage());
			return 0;
		}
	}

	// Estadisticas
	public static final int cantidadDePedidosEspeciales() {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "select count(*) cantidad from pedido_especial" +
				        "   where fecha >= trunc(sysdate) and fecha < sysdate + 1");
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular la cantidad de usuarios de hoy " + e.getMessage());
			return 0;
		}
	}

	// Objeto usado para el rango de visitas
	static public class Visita {

		public Timestamp fecha;
		public int cantidadDeVisitas;
		public int cantidadDeOrdenes;

		public Visita(Timestamp fecha, int cantidadDeVisitas, int cantidadDeOrdenes) {
			this.fecha = fecha;
			this.cantidadDeVisitas = cantidadDeVisitas;
			this.cantidadDeOrdenes = cantidadDeOrdenes;
		}
	}

	// Estadisticas
	public static final Vector calcularVisitas(boolean porHoraNoMesual, boolean ordenaPorFechaNoCantidad,
	                                           boolean ordenaAscendente, int cantidadDeDias, int cantidadRegistros) {
		Vector result = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				String POR_HORA_O_MES = (porHoraNoMesual) ? "'HH'" : "'MM'";
				String FECHA_O_CANTIDAD = (ordenaPorFechaNoCantidad) ? "fechaVisita" : "cantidadVisitas";
				String ASC_O_DESC = (ordenaAscendente) ? "ASC" : "DESC";
				String sql =
				        "SELECT * FROM (" +
				        "	SELECT   fechaVisita, NVL (cantidadVisitas, 0) cantidadVisitas, NVL (cantidadOrdenes, 0) cantidadOrdenes" +
				        "		FROM (SELECT   TRUNC (fecha_visita, " + POR_HORA_O_MES + ") fechaVisita," +
				        "					   SUM (cant_visitas) cantidadVisitas" +
				        "				  FROM visita_x_alianza_seccion vis" +
				        "			  GROUP BY TRUNC (fecha_visita, " + POR_HORA_O_MES + ")) vis," +
				        "			 (SELECT   TRUNC (fecha, " + POR_HORA_O_MES + ") fechaorden," +
				        "					   COUNT (id_orden) cantidadOrdenes" +
				        "				  FROM orden" +
				        "                WHERE orden.estado not in ('52', '0', 'M0', 'M1', 'ME')" +
				        "			  GROUP BY TRUNC (fecha, " + POR_HORA_O_MES + ")) ord" +
				        "	   WHERE vis.fechavisita = ord.fechaorden(+)" +
				        "        AND vis.fechavisita >= TRUNC( sysdate - " + cantidadDeDias + " )" +
				        "	ORDER BY " + FECHA_O_CANTIDAD + " " + ASC_O_DESC +
				        ") WHERE ROWNUM <= " + cantidadRegistros;

				PreparedStatement statement = connection.prepareStatement(sql);
				try {
					ResultSet resultSet = statement.executeQuery();
					try {
						while (resultSet.next()) {
							Timestamp fechaVisita = resultSet.getTimestamp("fechaVisita");
							int cantidadVisitas = resultSet.getInt("cantidadVisitas");
							int cantidadOrdenes = resultSet.getInt("cantidadOrdenes");
							result.add(new Visita(fechaVisita, cantidadVisitas, cantidadOrdenes));
						}
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se pueden calcular las visitas " + e.getMessage());
		}
		return result;
	}

	// Estadisticas
	public static final int cantidadDeComentariosEnEstado(String estado) {
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "SELECT COUNT (id_articulo) cantidad FROM comentario_articulos WHERE estado = ?");
				try {
					statement.setString(1, estado);
					ResultSet resultSet = statement.executeQuery();
					try {
						resultSet.next();
						return resultSet.getInt("cantidad");
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			TmkLogger.error("No se puede calcular la cantidad de usuarios de hoy " + e.getMessage());
			return 0;
		}
	}

	/* socios registrados en el mes anterior que no hayan comprado*/
	public static final Vector sociosRegistrados() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT * FROM (" +
				" SELECT DISTINCT e_mail1, nombres, apellidos, cs.nro_tarjeta," +
                " sd.descripcion pais, s.id_socio, s.id_sucursal" +
           " FROM (SELECT cs.*, tc.*" +
					"         FROM fdn_cuentas_x_socios cs," +
					" fdn_tarjetas_x_cuentas tc,"  +
					" fdn_tarjetas ta"  +
					" WHERE componente = 0" +
					" AND ta.estado = 'HA'"  +
					" AND cs.id_cuenta = tc.id_cuenta" +
					" AND cs.id_sucursal = tc.id_sucursal_cuenta" +
					" AND tc.nro_tarjeta = ta.nro_tarjeta) cs,"  +
					" (SELECT id_socio, id_sucursal, p.descripcion" +
					" FROM paises p, socios_domicilios sd"   +
					" WHERE"   +
					" sd.id_pais = p.id_pais" +
					" AND sd.f_alta >="  +
					" TRUNC (TRUNC (LAST_DAY (SYSDATE), 'MM') - 1," +
					"                 'MM')"  +
					" AND sd.f_alta < TRUNC (LAST_DAY (SYSDATE), 'MM')" +
					" AND sd.tipo_domicilio LIKE 'TF%'"  +
					" ) sd,"  +
					" (select * from socios2 where password is not null) s," +
					" (SELECT id_socio, id_sucursal_socio, id_orden"  +
					" FROM orden o"  +
					" WHERE o.fecha >=" +
					" TRUNC (TRUNC (LAST_DAY (SYSDATE), 'MM') - 1," +
					" 'MM')"  +
					" AND o.fecha < TRUNC (LAST_DAY (SYSDATE), 'MM')) o"  +
					" WHERE"  	 +
					" s.id_socio = cs.id_socio(+)" +
					" AND s.id_sucursal = cs.id_sucursal_socio(+)" +
					" AND o.id_socio IS NULL"  +
					" AND s.id_socio = sd.id_socio(+)" +
					" AND s.id_sucursal = sd.id_sucursal(+)" +
					" AND s.id_socio = o.id_socio(+)"  +
					" AND s.id_sucursal = o.id_sucursal_socio(+)" +
					" AND s.f_alta >= TRUNC (TRUNC (LAST_DAY (SYSDATE), 'MM') - 1, 'MM')" +
					" AND s.f_alta < TRUNC (LAST_DAY (SYSDATE), 'MM')"  +
					" UNION " +
					" SELECT login, nombres, apellidos, '' nro_tarjeta, '' pais, id_socio, id_sucursal " +
					" FROM socios_tmk " +
					" WHERE  f_alta >= TRUNC (TRUNC (LAST_DAY (SYSDATE), 'MM') - 1, 'MM') " +
					" AND  f_alta < TRUNC (LAST_DAY (SYSDATE), 'MM') )" +
					" ORDER BY apellidos " );
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(5);
						fila.add(resultSet.getString("e_mail1"));
						fila.add(Convert.nombrePropio(resultSet.getString("apellidos")));
						fila.add(Convert.nombrePropio(resultSet.getString("nombres")));
						fila.add(Convert.nombrePropio(resultSet.getString("nro_tarjeta")));
						fila.add(Convert.nombrePropio(resultSet.getString("pais")));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/* Compras por alianzas en el mes anterior*/
	public static final Vector comprasPorAlianzas() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(//--io.id_articulo articulo,
					"   SELECT o.id_orden orden, o.fecha, al.razon_social alianza, id_seccion seccion, " +
					"		   ar.titulo titulo,  " +
					"	 	   ar.cod_ext_visual, cantidad, precio_promocion precio, io.estado " +
					"	  FROM orden o, item_orden io, alianza al, articulos ar " +
					"	 WHERE o.id_alianza is not null " +
					"	   AND o.id_orden = io.id_orden " +
					"	   AND o.id_alianza = al.id_alianza " +
					"	   AND io.id_articulo = ar.id_articulo  " +
					" 	   AND ar.categoria_seccion != 99 " +
					"      AND fecha >= trunc(trunc(last_day(SYSDATE), 'MM')-1,'MM')" +
					"      AND fecha <= trunc(last_day(SYSDATE), 'MM')" +
					" ORDER BY o.id_alianza,  id_seccion, o.id_orden "
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector();
						fila.add(Convert.toString(resultSet.getInt("orden")));
						fila.add(resultSet.getTimestamp("fecha"));
						fila.add(resultSet.getString("alianza"));
						fila.add(Convert.toString(resultSet.getInt("seccion")));
						fila.add(resultSet.getString("titulo"));
						fila.add(Convert.toString(resultSet.getString("cod_ext_visual")));
						fila.add(Convert.toString(resultSet.getInt("cantidad")));
						fila.add(Convert.toString(resultSet.getDouble("precio")));
						fila.add(resultSet.getString("estado"));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}


	/* Compras por socios en el mes anterior*/
	public static final Vector comprasPorSocios() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			"SELECT  distinct login, nombres, apellidos, SUM (total) tot, p.descripcion pais, tc.nro_tarjeta, cs.id_cuenta, cs.id_cuso" +
			" FROM orden o, direccion_orden dor, socios_domicilios sd, paises p, socios2 s " +
			" LEFT JOIN (fdn_cuentas_x_socios cs" +
			" INNER JOIN fdn_tarjetas_x_cuentas tc" +
			" ON cs.id_cuenta = tc.id_cuenta" +
			" AND cs.id_sucursal = tc.id_sucursal_cuenta)" +
			" ON s.id_socio = cs.id_socio" +
			" AND s.id_sucursal = cs.id_sucursal_socio" +
			" WHERE login IS NOT NULL" +
			" AND o.id_socio = s.id_socio" +
			" AND o.fecha >= TRUNC (TRUNC (LAST_DAY (SYSDATE), 'MM') - 1, 'MM')" +
			" AND o.fecha <= TRUNC (LAST_DAY (SYSDATE), 'MM')" +
			" AND estado NOT IN ('0', '52', '5', '51')" +
			" AND o.id_sucursal_socio = s.id_sucursal" +
			" AND o.id_orden = dor.id_orden" +
			" AND s.id_socio = sd.id_socio" +
			" AND s.id_sucursal = sd.id_sucursal" +
			" AND dor.tipo_domicilio = sd.tipo_domicilio" +
			" AND sd.tipo_domicilio like 'TF%'" +
			" AND p.id_pais = sd.id_pais" +
			" GROUP BY login, nombres, apellidos, p.descripcion, tc.nro_tarjeta, cs.id_cuenta,  cs.id_cuso" +
			" ORDER BY tot DESC"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					String email="";
					while (resultSet.next()) {
						Vector fila = new Vector();

						if (email.equals(resultSet.getString("login"))) {
							fila = (Vector)temp.lastElement();
							if ( !(fila.get(4).equals(resultSet.getString("pais"))) ) {
								fila.set(4, fila.get(4) + ", " + Convert.toString(resultSet.getString("pais")));
							}
							if ( !(fila.get(5).equals(resultSet.getString("nro_tarjeta"))) ) {
								fila.set(5, fila.get(5) + ", " + Convert.toString(resultSet.getString("nro_tarjeta")));
							}
						} else {
                        	fila.add(new String (CryptUtil.desEncriptar(resultSet.getBytes("login"))) );
							fila.add(resultSet.getString("apellidos"));
							fila.add(resultSet.getString("nombres"));
							fila.add(Convert.toString(resultSet.getDouble("tot")));
							fila.add(Convert.toString(resultSet.getString("pais"), ""));
							fila.add(Convert.toString(resultSet.getString("nro_tarjeta"), ""));
							temp.add(fila);
						}
							email = Convert.toString(resultSet.getString("login"), "");
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/* se registraron y compraron con RIOHB.*/
	public static final Vector primerasComprasPorMedioDePago() throws SQLException, NamingException {
		Vector temp = new Vector(32);
		for (int i = 0; i< 32; i++) {
			temp.add("0");
		}
		int total = 0;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        " SELECT   COUNT (DISTINCT s.id_socio) socios, TO_CHAR (o.fecha, 'dd') dia" +
			        "     FROM orden o, socios2 s, pago_orden p" +
			        "    WHERE login IS NOT NULL" +
			        "      AND o.fecha >= TRUNC (SYSDATE, 'MM')" +
			        "      AND s.f_alta >= TRUNC (SYSDATE, 'MM')" +
			        "      AND o.id_sucursal_socio = s.id_sucursal" +
			        "      AND o.id_socio = s.id_socio" +
			        "      AND p.id_orden = o.id_orden" +
			        "      AND p.id_medio_cobro = '" + Globals.CLAVE_MEDIO_DE_COBRO_RIOHB + "'" +
			        " GROUP BY TO_CHAR (o.fecha, 'dd')");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						temp.set(resultSet.getInt("dia"), resultSet.getString("socios"));
						total += resultSet.getInt("socios");
					}
					temp.set(0, Convert.toString(total));
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/* los que compran con home banking más de una vez con RIOHB*/
	public static final Vector repeticionPorMedioDePago() throws SQLException, NamingException {
		Vector temp = new Vector(32);
		for (int i = 0; i< 32; i++) {
			temp.add("0");
		}
		int total = 0;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT socios, dia" +
				" FROM (" +
				" SELECT count(s.id_socio) socios, to_char(o.fecha, 'dd') dia" +
				" FROM orden o," +
				" socios2 s," +
				" pago_orden p" +
				" WHERE o.id_sucursal_socio = s.id_sucursal" +
				" AND o.id_socio = s.id_socio" +
				" AND o.fecha >= trunc(SYSDATE,'MM')" +
				" AND p.id_medio_cobro ='" + Globals.CLAVE_MEDIO_DE_COBRO_RIOHB + "'" +
				" AND p.id_orden = o.id_orden" +
				" AND login IS NOT NULL" +
				" GROUP BY  to_char(o.fecha, 'dd')" +
				" ) t" +
				" WHERE t.socios>1");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						temp.set(resultSet.getInt("dia"), resultSet.getString("socios"));
						total += resultSet.getInt("socios");
					}
					temp.set(0, Convert.toString(total));

				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/**
	 * Devuelve un vector con la provincia, el medio de envio, el gasto de envio y el cargo adicional
	 * para envios en Argentina
	 *
	 */
	public static final Vector getGastosDeEnvio() {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();

                qry.append(" SELECT   p.descripcion descripcion, gez.descripcion medio, importe, adicional");
				qry.append(" FROM gastos_envi_zonas gez, gastos_envi_zonas_paises gezp, provincias p");
				qry.append(" WHERE gez.id_zona IN (SELECT id_zona");
				qry.append(" 					   FROM gastos_envi_zonas_paises gezp");
				qry.append(" 					   WHERE id_pais = 300)");
				qry.append(" AND gezp.id_zona = gez.id_zona");
				qry.append(" AND gezp.id_provincia = p.id_provincia");
				qry.append(" AND habilitado_tematika = 'S'");
				qry.append(" ORDER BY descripcion");

				//TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
							 retorno.add(rs.getString("descripcion"));
							 retorno.add(rs.getString("medio"));
							 retorno.add(new Double(rs.getDouble("importe")));
							 retorno.add(new Double(rs.getDouble("adicional")));
						 }
					} catch (Exception e) {
                        TmkLogger.error("getGastosDeEnvio (falla asignacion)" + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("getGastosDeEnvio (falla ejecucion qry)"  + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("getGastosDeEnvio (falla armado qry)" + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("getGastosDeEnvio (falla conexion)" + " " + e.toString());
		}
        return retorno;
	}


	/**
	 * Devuelve un vector con el nombre del destino, importe de gasto de envio y el cargo adicional
	 * para envios fuera de Argentina
	 *
	 */
	public static final Vector getGastosDeEnvioRestoMundo() {
		Vector retorno = new Vector();
		try {
			Connection connection = buildConnection();
			try {
				StringBuffer qry = new StringBuffer();

                qry.append(" SELECT   nombre, importe, adicional");
				qry.append(" FROM gastos_envi_zonas gez");
				qry.append(" WHERE id_zona IN (SELECT id_zona");
				qry.append(" 				   FROM gastos_envi_zonas_paises gezp");
				qry.append(" 				   WHERE id_pais != 300)");
				qry.append(" ORDER BY id_zona");

				TmkLogger.debug(qry);

				PreparedStatement statement = connection.prepareStatement(qry.toString());
				try {
                    ResultSet rs = statement.executeQuery();
					try {
						 while (rs.next()) {
							 retorno.add(rs.getString("nombre"));
							 retorno.add(new Double(rs.getDouble("importe")));
							 retorno.add(new Double(rs.getDouble("adicional")));
						 }
					} catch (Exception e) {
                        TmkLogger.error("getGastosDeEnvioRestoMundo (falla asignacion)" + " " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
                	TmkLogger.error("getGastosDeEnvioRestoMundo (falla ejecucion qry)"  + " " + e.toString());
				} finally {
				    statement.close();
				}
			} catch (Exception e) {
                TmkLogger.error("getGastosDeEnvioRestoMundo (falla armado qry)" + " " + e.toString());
			} finally {
				connection.close();
			}
		} catch (Exception e) {
            TmkLogger.error("getGastosDeEnvioRestoMundo (falla conexion)" + " " + e.toString());
		}
        return retorno;
	}


	/* */
	public static final Vector referidosXDia() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT login, count(codigo_referido) referidos" +
				" FROM referido r inner join socios2 s " +
				" ON r.id_socio_referente = s.id_socio " +
				" AND r.id_sucursal_referente = s.id_sucursal" +
				" WHERE trunc(r.fecha) = trunc(sysdate)-1 " +
				" GROUP BY login" +
				" ORDER BY referidos desc"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector(2);
						fila.add(new String(CryptUtil.desEncriptar(resultSet.getBytes("login"))));
						fila.add(new Integer (resultSet.getInt("referidos")));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}


	/* Importe de las ordenes que estan en estado 20, 23, 41, 24, 4
	   Es la sumatoria de los totales de las ordenes aprobadas, sin tener en cuenta devoluciones*/
	public static final Vector totalPorMedioDePago() throws SQLException, NamingException {
		Vector temp = new Vector(32);
		for (int i = 0; i< 32; i++) {
			temp.add("0");
		}
		double total = 0;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "     SELECT sum(total) tot, to_char(fecha, 'dd') dia" +
			        "		FROM orden o" +
			        " INNER JOIN pago_orden p" +
			        "         ON o.id_orden = p.id_orden" +
			        "      WHERE id_medio_cobro = '" + Globals.CLAVE_MEDIO_DE_COBRO_RIOHB + "'" +
			        "        AND fecha >= trunc(SYSDATE,'MM')" +
			        "        AND estado IN ('20', '23', '41', '24', '4')" +
			        "   GROUP BY to_char(fecha, 'dd')"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						temp.set(resultSet.getInt("dia"), new Double(resultSet.getDouble("tot")));
						total += resultSet.getDouble("tot");
					}
					temp.set(0, new Double(total));
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/* Reglas aplicadas para los articulos */
	public static final Vector estadosDeArticulos() throws SQLException, NamingException {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT   e.secuencia secuencia, e.descripcion nombre, e.estado estado," +
			        " 		 d.descripcion disponibilidad, e.fecha_desde, e.fecha_hasta, a.id_articulo idArticulo, a.titulo titulo," +
			        " 		 s.descripcion seccion, g.descripcion grupo, f.descripcion familia," +
			        " 		 sf.descripcion subfamilia, ed.nombre editorial, p.nombre proveedor," +
			        " 		 e.importe_minimo importe_minimo, e.importe_maximo importe_maximo" +
			        " 	FROM estado_articulos e," +
			        " 		 articulos a," +
			        " 		 disponibilidades d," +
			        " 		 categ_secciones s," +
			        " 		 categ_grupos g," +
			        " 		 categ_familias f," +
			        " 		 categ_subfamilias sf," +
			        " 		 editores ed," +
			        " 		 proveedores p" +
			        "   WHERE e.id_disponibilidad = d.id_disponibilidad(+)" +
			        " 	 AND e.id_articulo = a.id_articulo(+)" +
			        " 	 AND e.categoria_seccion = s.categoria_seccion(+)" +
			        " 	 AND e.categoria_seccion = g.categoria_seccion(+)" +
			        " 	 AND e.categoria_grupo = g.categoria_grupo(+)" +
			        " 	 AND e.categoria_seccion = f.categoria_seccion(+)" +
			        " 	 AND e.categoria_grupo = f.categoria_grupo(+)" +
			        " 	 AND e.categoria_familia = f.categoria_familia(+)" +
			        " 	 AND e.categoria_seccion = sf.categoria_seccion(+)" +
			        " 	 AND e.categoria_grupo = sf.categoria_grupo(+)" +
			        " 	 AND e.categoria_familia = sf.categoria_familia(+)" +
			        " 	 AND e.categoria_subfamilia = sf.categoria_subfamilia(+)" +
			        " 	 AND e.editorial = ed.id_editor(+)" +
			        " 	 AND e.proveedor = p.id_proveedor(+)" +
			        " 	 AND d.id_esquema = 'PROD'" +
			        " ORDER BY e.secuencia"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						StringBuffer buffer = new StringBuffer();
						buffer.append("Regla ").append(Convert.toString(resultSet.getInt("secuencia")));
						buffer.append(": '<i>").append(Convert.toString(resultSet.getString("nombre"), "-")).append("</i>'");
						buffer.append("<br>");
						buffer.append("&nbsp;-").append(("S".equalsIgnoreCase(resultSet.getString("estado"))) ? "Mostrar" : "Ocultar");
						String disponibilidad = resultSet.getString("disponibilidad");
						if (disponibilidad != null) {
							buffer.append(" con disponibilidad '<i>").append(disponibilidad).append("</i>'");
						}

						String titulo = resultSet.getString("titulo");
						if (titulo == null) {

							buffer.append(" todos los productos");

							String seccion = resultSet.getString("seccion");
							if (seccion != null) {

								buffer.append(" de la seccion '<i>").append(Convert.corregir(seccion, true)).append("</i>'");
								String grupo = resultSet.getString("grupo");
								if (grupo != null) {

									buffer.append(", del grupo '<i>").append(Convert.corregir(grupo, true)).append("</i>'");
									String familia = resultSet.getString("familia");
									if (familia != null) {

										buffer.append(", de la familia '<i>").append(Convert.corregir(familia, true)).append("</i>'");
										String subfamilia = resultSet.getString("subfamilia");
										if (subfamilia != null) {

											buffer.append(", de la subfamilia '<i>").append(Convert.corregir(subfamilia, true)).append("</i>'");
										}
									}
								}
							}

							String editorial = resultSet.getString("editorial");
							if (editorial != null) {
								buffer.append(", para la editorial '<i>").append(Convert.corregir(editorial, true)).append("</i>'");
							}

							String proveedor = resultSet.getString("proveedor");
							if (proveedor != null) {
								buffer.append(", para el proveedor '<i>").append(Convert.corregir(proveedor, true)).append("</i>'");
							}

							String importeMinimo = resultSet.getString("importe_minimo");
							if (importeMinimo != null) {
								buffer.append(", si el precio de venta es mayor o igual a $ ").append(importeMinimo);
							}
							String importeMaximo = resultSet.getString("importe_maximo");
							if (importeMaximo != null) {
								buffer.append(", si el precio de venta es menor o igual a $ ").append(importeMaximo);
							}

						} else {
							int idArticulo = resultSet.getInt("idArticulo");
							buffer.append(" el artículo ").append(Convert.toString(idArticulo)).append(" '<u>" + Convert.corregir(titulo, true)).append("</u>'");
						}

						buffer.append("<br>");
						buffer.append("&nbsp;-");

						java.util.Date ahora = new java.util.Date();
						java.util.Date enBreve = new java.util.Date();
						enBreve.setDate(enBreve.getDate() + 5); // los que vencen en 5 días
						Timestamp desde = resultSet.getTimestamp("fecha_desde");
						Timestamp hasta = resultSet.getTimestamp("fecha_hasta");
						if ((desde == null) && (hasta == null)) {
							buffer.append("Regla siempre vigente");
						} else {
							if ((desde != null) && (enBreve.before(desde))) {
								buffer.append("<b>").append("REGLA AÚN NO VIGENTE").append("</b>");
							} else if ((desde != null) && (ahora.before(desde))) {
								buffer.append("<b>").append("REGLA PROXIMAMENTE VIGENTE").append("</b>");
							} else if ((hasta != null) && (ahora.after(hasta))) {
								buffer.append("<b>").append("REGLA EXPIRADA").append("</b>");
							} else if ((hasta != null) && (enBreve.after(hasta))) {
								buffer.append("<b>").append("REGLA PROXIMAMENTE A EXPIRAR").append("</b>");
							} else {
								buffer.append("Regla vigente");
							}
							buffer.append(" (");
							if (desde != null) {
								buffer.append(" desde el ").append(Convert.toStringLargo(desde));
							}
							if (hasta != null) {
								buffer.append(" hasta el ").append(Convert.toStringLargo(hasta));
							}
							buffer.append(" )");
						}

						int primerComa = buffer.indexOf(",");
						if (primerComa >= 0) {
							buffer.delete(primerComa, primerComa + 1);
							buffer.insert(primerComa, " ");
						}

						int ultimaComa = buffer.lastIndexOf(",");
						if (ultimaComa >= 0) {
							buffer.delete(ultimaComa, ultimaComa + 1);
							buffer.insert(ultimaComa, " y ");
						}

						// guarda el string resultado
						temp.add(buffer.toString());

					}

					// Finalmente tiene todos los strings
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	/*
	public static final String getAutoresDesc(int idArticulo) {
		String retorno ="";
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
			            "SELECT aut.descripcion" +
						" FROM articulos_autores aa" +
						" INNER JOIN autores aut" +
						" ON aa.id_autor = aut.id_autor" +
						" WHERE id_articulo = ?"
				);
				try {
						statement.setInt(1, idArticulo);
						ResultSet resultSet = statement.executeQuery();
					try {
						while (resultSet.next()) {
							retorno = retorno + " - " + Convert.nombrePropio(resultSet.getString("descripcion"));
						}
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
		}
		return retorno;
	}*/



	public static final Integer ordenesEnProcesoPorDireccion(Integer id_socio, Integer id_sucursal_socio, String tipo_domicilio) throws SQLException, NamingException {
		Integer retorno = null;
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "SELECT o.id_orden"
			        + " FROM direccion_orden do INNER JOIN orden o ON do.id_orden = o.id_orden"
			        + " WHERE o.estado in (" + ORDENES_DIRECCIONNOEDITABLE + ")"
			        + " AND o.id_socio = " + id_socio
			        + " AND o.id_sucursal_socio = " + id_sucursal_socio
			        + " AND do.tipo_domicilio = '" + tipo_domicilio + "'"
			        + " AND rownum <= 1"
			);
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						retorno = new Integer(resultSet.getInt("id_orden"));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return retorno;
	}



	public static final Vector atributosPorFamilia(Integer seccion, Integer grupo, Integer familia) throws SQLException, NamingException {

		// Tiene un conjunto de pairs. Cada par tiene la clave y un vector de las posibilidades
		Vector result = new Vector();

		Connection connection = DBUtil.buildConnection();
		try {
			PreparedStatement statementAtrib = connection.prepareStatement(
			        "select prompt, campo_articulos2 aux from atributos_x_familia" +
			        " where categoria_seccion " + ((seccion == null) ? " is not null" : "=" + seccion) +
			        "   and categoria_grupo " + ((grupo == null) ? " is not null" : "=" + grupo) +
			        "   and categoria_familia " + ((familia == null) ? " is not null" : "=" + familia)
			);
			try {
				ResultSet resultSetAtrib = statementAtrib.executeQuery();
				try {
					while (resultSetAtrib.next()) {
						String prompt = resultSetAtrib.getString("prompt");
						String aux = resultSetAtrib.getString("aux");

						// Contiene el titulo del campo y el nombre en la tabla
						AtributoDinamicoDAO atributoDinamico = new AtributoDinamicoDAO(prompt, aux);

						PreparedStatement statementAux = connection.prepareStatement(
						        "select distinct " + aux +
						        "  from articulos" +
						        " where categoria_seccion " + ((seccion == null) ? " is not null" : "=" + seccion) +
						        "   and categoria_grupo " + ((grupo == null) ? " is not null" : "=" + grupo) +
						        "   and categoria_familia " + ((familia == null) ? " is not null" : "=" + familia) +
						        "   and " + aux + " is not null"
						);
						try {
							ResultSet resultSetAux = statementAux.executeQuery();
							try {
								while (resultSetAux.next()) {
									// Valor encontrado para el campo
									// Si es string le agrega las comillas para más adelante
									Object objeto = resultSetAux.getObject(aux);
									// Si es string le agrega las comillas
									String valor = ((objeto.getClass() == String.class) || (objeto.getClass() == Character.class)) ? "'" + objeto.toString() + "'" : objeto.toString();
									// Guarda el valor posible
									atributoDinamico.agregarValor(valor);
								}

								// Solo muestra el atributo si vale la pena
								if (atributoDinamico.mostrarOpciones()) result.add(atributoDinamico);

							} finally {
								resultSetAux.close();
							}

						} finally {
							statementAux.close();
						}
					}

				} finally {
					resultSetAtrib.close();
				}

			} finally {
				statementAtrib.close();
			}

		} finally {
			connection.close();
		}

		return result;
	}

	/**
	 * Devuelve un array con las descripciones de grupo, familia y subfamilia en ese orden
	 *
	 */
	public static final String[] getDescripcionCategoria(Integer seccion, Integer grupo, Integer familia, Integer subfamilia) throws SQLException, NamingException {

		String[] descripciones = new String [3];
		try {
			Connection connection = buildConnection();
			try {
					StringBuffer qry = new StringBuffer();

					if(subfamilia != null){
						qry.append(" SELECT catg.descripcion grupo, catf.descripcion familia, catsf.descripcion subfamilia ");
					}else if(familia!=null){
						qry.append(" SELECT catg.descripcion grupo, catf.descripcion familia ");
					}else{
						qry.append(" SELECT catg.descripcion grupo");
					}
					qry.append(" FROM categ_grupos catg");

					if (subfamilia != null ){
						qry.append(", categ_familias catf, categ_subfamilias catsf");
						qry.append(" WHERE (catg.categoria_seccion =").append(seccion);
						qry.append("        and catg.categoria_grupo =").append(grupo);
						qry.append("        )");
						qry.append(" AND");
						qry.append("    (catf.categoria_seccion =").append(seccion);
						qry.append("     and catf.categoria_grupo =").append(grupo);
						qry.append("     and catf.categoria_familia =").append(familia);
						qry.append("     )");
						qry.append(" AND");
						qry.append("    (catsf.categoria_seccion =").append(seccion);
						qry.append("     and catsf.categoria_grupo =").append(grupo);
						qry.append("     and catsf.categoria_familia =").append(familia);
						qry.append("     and catsf.categoria_subfamilia =").append(subfamilia);
						qry.append("     )");

					}else if(familia!=null){
						qry.append(", categ_familias catf ");
						qry.append(" WHERE (catg.categoria_seccion =").append(seccion);
						qry.append("        and catg.categoria_grupo =").append(grupo);
						qry.append("        )");
						qry.append(" AND");
						qry.append("    (catf.categoria_seccion =").append(seccion);
						qry.append("     and catf.categoria_grupo =").append(grupo);
						qry.append("     and catf.categoria_familia =").append(familia);
						qry.append("     )");
					}else{
						qry.append(" WHERE (catg.categoria_seccion =").append(seccion);
						qry.append("        and catg.categoria_grupo =").append(grupo);
					    qry.append("        )");

					}


					//TmkLogger.debug("GETDESCRIPCIONCATEGORIA= " + qry);

					PreparedStatement statement = connection.prepareStatement(qry.toString());
					try {
	                    ResultSet rs = statement.executeQuery();
						try {

							while (rs.next()) {

							   descripciones[0]=rs.getString("grupo");

							   if(familia!=null){
								  descripciones[1]=rs.getString("familia");
							   }
							   if(subfamilia!=null){
							      descripciones[2]=rs.getString("subfamilia");
							   }
							}
						 }catch (Exception e) {
	                            TmkLogger.error("getDescripcionCategoria (falla asignacion)" + " " + e.toString());
						 }finally {
							rs.close();
						 }
					 } catch (Exception e) {
	                  	    TmkLogger.error("getDescripcionCategoria (falla ejecucion qry)" + " " + e.toString());
					 } finally {
					    statement.close();
					 }
				  } catch (Exception e) {
	                TmkLogger.error("getDescripcionCategoria (falla armado qry)" + " " + e.toString());
				  } finally {
					connection.close();
			   	  }
		   } catch (Exception e) {
	           TmkLogger.error("getDescripcionCategoria (falla conexion)" + " " + e.toString());
		   }
	return descripciones;
    }

	public static Vector categorizacionDeArticulo(Integer seccion, Integer grupo, Integer familia, Integer subFamilia) throws SQLException, NamingException {
		Vector result = new Vector();

		Connection connection = buildConnection();
		try {
			String qry = " SELECT cs.descripcion, cg.descripcion, cf.descripcion, csf.descripcion" +
		    " FROM categ_secciones cs " +
		    " INNER JOIN categ_grupos cg" +
		    " ON cs.categoria_seccion = cg.categoria_seccion" +
		    " INNER JOIN categ_familias cf" +
			" ON cs.categoria_seccion = cf.categoria_seccion" +
			" AND cg.categoria_grupo = cf.categoria_grupo" +
			" INNER JOIN categ_subfamilias csf" +
			" ON cs.categoria_seccion = csf.categoria_seccion" +
			" AND cg.categoria_grupo = csf.categoria_grupo" +
			" AND cf.categoria_familia = csf.categoria_familia" +
			" WHERE cs.categoria_seccion = '" + seccion + "'" +
			" AND cg.categoria_grupo = '" + grupo + "'" +
			" AND cf.categoria_familia = '" + familia + "'" +
			" AND csf.categoria_subfamilia = '" + subFamilia + "'";
			PreparedStatement statement = connection.prepareStatement(qry
			);
			//System.out.println(qry);
			try  {
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						result.add(resultSet.getString(1));
						result.add(resultSet.getString(2));
						result.add(resultSet.getString(3));
						result.add(resultSet.getString(4));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}

	return result;

	}

	public static String getProveedor(int idProveedor)  throws SQLException, NamingException {
		String result = "";
		Connection connection = buildConnection();
		try {
			String qry = " SELECT nombre" +
			" FROM proveedores " +
			" WHERE id_proveedor = " + idProveedor;
			PreparedStatement statement = connection.prepareStatement(qry);
			//System.out.println(qry);
			try  {
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						result = resultSet.getString(1);

					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return result;
	}



	/** Obtiene el contexto inicial */
	public static final InitialContext getInitialContext() throws NamingException {
		return new InitialContext();
	}

	/** Obtiene la conexion a la base */
	public static final Connection buildConnection() throws NamingException, SQLException {
		try {
			if(ds==null)
				ds = (DataSource) getInitialContext().lookup(DATASOURCE);
			return ds.getConnection();
		} catch (SQLException e) {
			Calendar ahora = Calendar.getInstance();
			ahora.add(Calendar.MINUTE, -1);
			if (ahora.after(ULTIMA_ALERTA_DB)) {
				MailUtil.sendMail(Globals.MAIL_MAILER, "clopez@ilhsa.com", "ERROR Tematika.com en conexion a DB", "Reiniciar Base de datos y verificar que el servicio de tematika inicie correctamente. ERROR: " + e.toString());
				ULTIMA_ALERTA_DB = Calendar.getInstance();
			}
			throw e;
		} catch (NamingException e) {
			throw e;
		}

	}

	/** Obtiene la conexion a la base */
	public static final Connection buildConnection(String dataSource) throws NamingException, SQLException {
		DataSource ds = (DataSource) getInitialContext().lookup(dataSource);
		return ds.getConnection();
	}

	public static int getPromocionPorCupon(String cupon){
		int retorno = 0;
		try {
			Connection connection = buildConnection();
			try {
				PreparedStatement statement = connection.prepareStatement(
				        "SELECT id_promocion" +
				        " FROM PROMO_CLIENTES pc" +
				        " INNER JOIN CATEGORIAS c" +
				        " ON pc.CATEGORIA_ALTA = c.ID_CATEGORIA" +
				        " WHERE c.DESCRIPCION = ?"
				);
				try {
					statement.setString(1, cupon);
					ResultSet resultSet = statement.executeQuery();
					try {
						while (resultSet.next()) {
							retorno = resultSet.getInt("id_promocion");
						}
					} finally {
						resultSet.close();
					}
				} finally {
					statement.close();
				}
			} finally {
				connection.close();
			}
		} catch (Exception e) {
		}
		return retorno;
		}

    /*detalle articulo*/
    /**
     * Generar las recomendaciones para el articulo
	 */
	public static final Vector recomendarArticulo(int idArticulo,int cantidadRecomendaciones) throws Exception {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			        "  SELECT r.id_articulo_recomendado,a.titulo" +
			        "     FROM recomendacion_articulos r, articulos a, disponibilidades d" +
			        "     WHERE r.id_articulo = ?" +
			        "     AND r.id_articulo_recomendado = a.id_articulo" +
			        "     AND a.id_disponibilidad = d.id_disponibilidad" +
			        "     AND a.habilitado_tematika = 'S'" +
			        "     AND d.pedido_especial = 'N'" +
			        " 	  AND d.id_esquema = 'PROD'" +
			        "     ORDER BY r.orden");

			try {
				int index = 0;
				statement.setInt(++index, idArticulo);
				ResultSet resultSet = statement.executeQuery();
				try {
					int count = 0;
					while (resultSet.next() && (count++ < cantidadRecomendaciones)) {
						temp.add(new Pair(new Integer(resultSet.getInt("id_articulo_recomendado")),new String (resultSet.getString("titulo"))));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	    return temp;
	}

    /**
	 * Busca los autores de los articulos
	 */
	/*public static final Vector autoresPorArticulos(Vector articulos,int cantidadRecomendaciones) throws Exception {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			StringBuffer query = new StringBuffer("SELECT DISTINCT a.id_autor,a.descripcion FROM ARTICULOS_AUTORES aa JOIN AUTORES a ON aa.id_autor=a.id_autor WHERE");
			for (int i = 0; i < articulos.size(); i++) {
				if (i > 0) query.append(" OR");
				query.append(" aa.id_articulo = ").append(((Pair)articulos.get(i)).getValue1());
			}
			PreparedStatement statement = connection.prepareStatement(query.toString());
			try {
				ResultSet resultSet = statement.executeQuery();
				try {

					int count = 0;
					while (resultSet.next() && (count++ < cantidadRecomendaciones)) {
						temp.add(new Pair(new Integer(resultSet.getInt("id_autor")),new String(resultSet.getString("descripcion"))));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	    return temp;
	}*/

  /*
    public static final MultiFields verCotizacion(Integer idArticulo){
            //boolean huboError = false;
            MultiFields atributosDelArticulo = null;
            DisponibilidadDAO disponibilidad = null;
            try{
            	Connection conn = DBUtil.buildConnection();
                try{
                	PreparedStatement statement = conn.prepareStatement("select a.id_articulo,a.habilitado_tematika,a.id_disponibilidad,a.id_impuesto,a.precio_venta_vigente,t.TASA_GENERAL, t.TASA_ADICIONAL, t.TASA_PERCEP_VIDEO" +
                            " from articulos a left join (" +
                            " SELECT id_impuesto,TASA_GENERAL, TASA_ADICIONAL, TASA_PERCEP_VIDEO FROM TASAS" +
                            " WHERE ID_IMPUESTO = (select id_impuesto from articulos where id_articulo=" + idArticulo.intValue() + ")" +
                            " AND ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE +
                            " AND FECHA_VIGENCIA = (SELECT MAX(FECHA_VIGENCIA)" +
                            " FROM TASAS WHERE ID_IMPUESTO = (select id_impuesto from articulos where id_articulo=" + idArticulo.intValue() + ")" +
                            " AND ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE +
                            " AND FECHA_VIGENCIA <= sysdate)" +
                            " ) t on a.id_impuesto=t.id_impuesto" +
                            " where id_articulo=" + idArticulo.intValue());
                    try{
                    	ResultSet resultSet = statement.executeQuery();
                        try {
	                    	if(resultSet.next()){
	                            disponibilidad = (resultSet.getInt("id_disponibilidad")==0) ? Globals.DISPONIBILIDAD_DESCONOCIDA : DisponibilidadDAO.buscaDisponibilidad(resultSet.getInt("id_disponibilidad"));

	                            double importe = Convert.round(Math.max((resultSet.getDouble("precio_venta_vigente") == 0) ? 0.0 : resultSet.getDouble("precio_venta_vigente"), Globals.IMPORTE_MINIMO_AFIP));
	                            double tasaImpGral = 0.0;
	                            double tasaImpVideo = 0.0;
	                            double porcentaje = 0.0;
	                            Pair pair = null;

	                            if(resultSet.getString("id_impuesto")!=null){
	                                tasaImpGral = Convert.round(resultSet.getDouble("tasa_general") + resultSet.getDouble("tasa_adicional"));
	                                tasaImpVideo = Convert.round(resultSet.getDouble("tasa_percep_video"));
	                            }

	                            try{
	                                pair = DBUtil.calculaPricing(new Integer(resultSet.getInt("id_articulo")));
	                                porcentaje = Convert.round(((Double) pair.getValue2()).doubleValue());
	                            } catch (Exception e) {
	                                TmkLogger.warn("No se pudo calcular pricing para articulo " + resultSet.getInt("id_articulo") + ". Error " + e.getMessage());
	                            }

	                            importe = Convert.round(Convert.aplicarPorcentaje(importe, tasaImpGral + tasaImpVideo));
	                            importe = Convert.round(Convert.aplicarPorcentaje(importe, porcentaje));
	                            atributosDelArticulo = new MultiFields(disponibilidad,resultSet.getString("habilitado_tematika"),new Double(importe));

	                        }
                        } catch (Exception e) {
                        	 TmkLogger.debug(e.toString());
                        } finally {
                        	resultSet.close();
                        }
                    }catch(Exception e){
                        TmkLogger.debug(e.toString());
                        //huboError = true;
                    }finally{
                        //resultSet.close();
                        statement.close();
                    }
                }catch(Exception e){
                    TmkLogger.debug(e.toString());
                    //huboError = true;
                }finally{
                    //statement.close();
                	conn.close();
                }
            } catch (Exception e) {
                TmkLogger.debug(e.toString());
                //huboError = true;
            }
        return atributosDelArticulo;
    }
*/
    public static final Vector articulosBuscados(String idArticulo,String ISBN, String titulo,int maxResult) throws NamingException, SQLException {
    	StringBuffer query = new StringBuffer();
        String conector = "";
        Vector articulosElegidos = new Vector();
        Vector articulo = new Vector();

        query.append(" SELECT rownum,o.* from (SELECT id_articulo,categoria_seccion,titulo,cod_ext_visual FROM articulos ");
        conector = " WHERE ";
        if( idArticulo != "" ){
            query.append(conector).append(" id_articulo = ").append(idArticulo);
            conector = " AND ";
        }else{
            if( ISBN != "" ){
                query.append(conector).append(" replace(cod_ext_visual,'-','') = replace('").append(ISBN).append("','-','') ");
                conector = " AND ";
            }else{
                if( titulo != "" ){
                    query.append(conector).append(" catsearch(titulo,'").append(titulo).append("*','')>0 ");
                    conector = " AND ";
                }
            }
        }
        query.append(" ) o where rownum<= ").append(maxResult + 1);

        	Connection connection = DBUtil.buildConnection();
            try {
            	PreparedStatement statement = connection.prepareStatement(query.toString());
                try {
                	ResultSet resultSet = statement.executeQuery();
                    try {
                        while(resultSet.next()){
                            articulo.add(new Integer(resultSet.getInt("id_articulo")));
                            articulo.add(new Integer(resultSet.getInt("categoria_seccion")));
                            articulo.add(resultSet.getString("cod_ext_visual"));
                            articulo.add(resultSet.getString("titulo"));
                            articulosElegidos.add(new Vector(articulo));
                            articulo.clear();
                        }
                    } catch (Exception e){
                        //TmkLogger.debug(e.toString());
                    } finally {
                    	resultSet.close();
                    }
                } catch (Exception e) {
                    //TmkLogger.debug(e.toString());
                } finally {
                   statement.close();
                }
            } catch (Exception e) {

            } finally {
            	connection.close();
            }
        return articulosElegidos;
    }

	public static final Vector getOrdenPorAlianza() throws Exception {
		Vector temp = new Vector();
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
			" SELECT COUNT (id_orden) cantidad, al.id_alianza, razon_social " +
			" FROM orden o LEFT JOIN " +
			" alianza al ON o.id_alianza = al.id_alianza" +
			" WHERE o.fecha>=TRUNC(TRUNC(LAST_DAY(SYSDATE), 'MM')-1,'MM')" +
			" AND fecha < TRUNC(LAST_DAY(SYSDATE), 'MM')-1" +
			" AND o.estado IN (" + ORDENES_APROBADAS + ")" +
			" GROUP BY al.id_alianza, razon_social" +
			" ORDER BY cantidad DESC");
			try {
				ResultSet resultSet = statement.executeQuery();
				try {
					while (resultSet.next()) {
						Vector fila = new Vector();
						fila.add(resultSet.getString("cantidad"));
						fila.add(resultSet.getString("id_alianza"));
						fila.add(resultSet.getString("razon_social"));
						temp.add(fila);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return temp;
	}

	public static final String getMarcaDeArticulo(Integer idArticulo) throws Exception {
		String retorno = "";
		Connection connection = buildConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(
				" SELECT c.rv_abbreviation" +
				" FROM articulos a, cg_ref_codes c" +
				" WHERE rv_domain = 'MARCA'" +
				" AND c.rv_low_value = a.auxnumber03" +
				" AND id_articulo =?");
			try {
				statement.setInt(1, idArticulo.intValue());
				ResultSet resultSet = statement.executeQuery();
				try {
					if (resultSet.next()) {
						retorno = Convert.nombrePropio(resultSet.getString("rv_abbreviation"));
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
		return retorno;
	}


    /**
	 * Retorna la cotizacion de la lista de articulos solicitada
	 */
	public static final MultiField cotizacionArticulo(String listaArticulos, int tamanio) throws Exception {

        MultiField articulos = new MultiField(tamanio);

                Connection conn = DBUtil.buildConnection();
                try{
                    PreparedStatement statement = conn.prepareStatement("	select ar.id_articulo,ar.habilitado_tematika,ar.id_disponibilidad,ar.id_impuesto,ar.precio_venta_vigente,tas.TASA_GENERAL, tas.TASA_ADICIONAL, tas.TASA_PERCEP_VIDEO	" +
					                    "	from articulos ar join (	" +
					                    "	select a.id_articulo,t.id_impuesto,max(t.fecha_vigencia) as fecha_vigencia from articulos a left join " +
                                        "   (select id_impuesto,fecha_vigencia from tasas where FECHA_VIGENCIA <= sysdate and ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE + ") t on a.id_impuesto=t.id_impuesto	" +
					                    "	where a.id_articulo in (" + listaArticulos + ")	" +
					                    "	group by a.id_articulo,t.id_impuesto	" +
					                    "	) aux on ar.id_articulo=aux.id_articulo	" +
					                    "	left join (	" +
					                    "	select * from tasas where ID_TIPO_CONTRIBUYENTE = " + Globals.ID_TIPO_CONTRIBUYENTE +
					                    "	) tas	" +
					                    "	on aux.id_impuesto=tas.id_impuesto and aux.FECHA_VIGENCIA = tas.FECHA_VIGENCIA	" +
                    "	where ar.id_articulo in (" + listaArticulos + ")	");
                    try{
                        ResultSet resultSet = statement.executeQuery();
                        int j = 0;
                        try {
                            while(resultSet.next()){

                                DisponibilidadDAO disponibilidad = (resultSet.getInt("id_disponibilidad")==0) ? Globals.DISPONIBILIDAD_DESCONOCIDA : DisponibilidadDAO.buscaDisponibilidad(resultSet.getInt("id_disponibilidad"));

                                double importe = Convert.round(Math.max((resultSet.getDouble("precio_venta_vigente") == 0) ? 0.0 : resultSet.getDouble("precio_venta_vigente"), Globals.IMPORTE_MINIMO_AFIP));
                                double precioConImpuesto = 0.0;
                                double precioSitio = 0.0;
                                double tasaImpGral = 0.0;
                                double tasaImpVideo = 0.0;
                                double porcentaje = 0.0;

                                /*Object objectTasaGeneral = resultSet.getObject("TASA_GENERAL");
                                Object objectTasaAdicional = resultSet.getObject("TASA_ADICIONAL");
                                Object objectPercepVideo = resultSet.getObject("TASA_PERCEP_VIDEO");
                                double tasaGeneral = (objectTasaGeneral == null) ? 0.0 : ((Number) objectTasaGeneral).doubleValue();
                                double tasaAdicional = (objectTasaAdicional == null) ? 0.0 : ((Number) objectTasaAdicional).doubleValue();
                                double tasaPercepVideo = (objectPercepVideo == null) ? 0.0 : ((Number) objectPercepVideo).doubleValue();*/

                                Pair pair = null;

                                if(resultSet.getString("id_impuesto")!=null){
                                    tasaImpGral = Convert.round(resultSet.getDouble("tasa_general") + resultSet.getDouble("tasa_adicional"));
                                    tasaImpVideo = Convert.round(resultSet.getDouble("tasa_percep_video"));
                                }

                                try{
                                    pair = DBUtil.calculaPricing(new Integer(resultSet.getInt("id_articulo")));
                                    porcentaje = Convert.round(((Double) pair.getValue2()).doubleValue());
                                } catch (Exception e) {
                                    TmkLogger.warn("No se pudo calcular pricing para articulo " + resultSet.getInt("id_articulo") + ". Error " + e.getMessage());
                                }

                                precioConImpuesto = Convert.round(Convert.aplicarPorcentaje(importe, tasaImpGral + tasaImpVideo));//precio_con_impuesto
                                precioSitio = Convert.round(Convert.aplicarPorcentaje(precioConImpuesto, porcentaje));//precio_sitio

                                String disponible = (disponibilidad.estaDisponible() && "S".equalsIgnoreCase(resultSet.getString("habilitado_tematika")))?"S":("S".equalsIgnoreCase(resultSet.getString("habilitado_tematika")))?"S":"N";

                                MultiField atributosDelArticulo = new MultiField(5);

                                atributosDelArticulo.addValor(0,new Integer(resultSet.getInt("id_articulo")));
                                atributosDelArticulo.addValor(1,new Double(precioConImpuesto));
                                atributosDelArticulo.addValor(2,new Double(precioSitio));
                                atributosDelArticulo.addValor(3,new Double(porcentaje));
                                atributosDelArticulo.addValor(4,disponible);

                                articulos.addValor(j++,atributosDelArticulo);

                            }
                        }finally{
                            resultSet.close();
                        }
                    }finally{
                        statement.close();
                    }
                }finally{
                    conn.close();
                }
        return articulos;
    }
    /*Busquedas*/



//
	/*public static Vector[] getSociosRegistradosAyerSinCompras () {
		//mails, nombre, apellido
		//nombre appellido mail
		Vector socios = new Vector();
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				StringBuffer qry = new StringBuffer();
				try {
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

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							Vector aux = new Vector(4);
							aux.add(rs.getString("nombres"));
							aux.add(rs.getString("apellidos"));
							aux.add(rs.getString("login"));
							aux.add(Convert.toStringFromDDMMYYYY(rs.getTimestamp("f_alta")));
							socios.add(aux);
						}
					} catch (Exception e) {
						TmkLogger.error("DBUtil: getSociosRegistradosAyerSinCompras(recorrido de rs), " +  e.toString());
						TmkLogger.error(qry.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("DBUtil: getSociosRegistradosAyerSinCompras(ejecucion de qry), " + e.toString());
					TmkLogger.error(qry.toString());
				}  finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("DBUtil: getSociosRegistradosAyerSinCompras(creacion de statement), "  + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("DBUtil: getSociosRegistradosAyerSinCompras(conexion), " + e.toString());
		}
		return (Vector [])socios.toArray(new Vector[socios.size()]);

	}
	*/

	public static String[][] getFavoritos (int idSeccion, String rol, String idAutor) {
		String ids [] = idAutor.split(",");
		String retorno [][] = new String[ids.length][3];
		String aux [][] = new String[ids.length][3];

		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" select aut.id_autor, aut.descripcion, count(aa.id_articulo) cantidad from");
					qry.append(" articulos_autores aa,");
					qry.append(" articulos a,");
					qry.append(" autores aut,");
					qry.append(" disponibilidades d");
					qry.append(" where ");
					qry.append(" a.id_articulo = aa.id_articulo");
					qry.append(" and aa.id_autor = aut.id_autor");
					qry.append(" and a.id_disponibilidad = d.id_disponibilidad");
					qry.append(" and d.id_esquema='PROD'");
					qry.append(" and a.habilitado_tematika ='S'");
					qry.append(" and a.activo = 'SI'");
					qry.append(" and a.categoria_seccion = ").append(idSeccion);
					qry.append(" and role in (").append(rol).append(")");
					qry.append(" and aa.id_autor in (").append(idAutor).append(")");
					qry.append(" group by aut.id_autor, aut.descripcion");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int i=0;
						while (rs.next()) {
							retorno[i][0] = rs.getString("id_autor");
							retorno[i][1] = rs.getString("descripcion");
							retorno[i][2] = rs.getString("cantidad");
							i++;
						}
					} catch (Exception e) {
						TmkLogger.error("DBUtil: getFavoritos, recorrido de rs " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("DBUtil: getFavoritos, ejecucion de qry " + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("DBUtil: getFavoritos, creacion de st " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("DBUtil: getFavoritos conexion, " + e.toString());
		}

		for (int i=0; i<ids.length; i++) {
			for (int j=0; j<retorno.length; j++) {
				if (retorno[j][0] != null) {
					if (ids[i].trim().equals(retorno[j][0].trim())) {
						aux[i] = retorno[j];
					}
				}
			}
		}

		return aux;
	}


	public static String getAutoresMasVendidos(String rol, int idSeccion, int idGrupo, int maximoARetornar) {
		String retorno ="";
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" select aa.id_autor, count(a.id_articulo) from");
					qry.append(" articulos a,");
					qry.append(" articulos_autores aa,");
					qry.append(" mas_vendidos_grupo mvs");
					qry.append(" where ");
					qry.append(" aa.id_articulo =a.id_articulo");
					qry.append(" and mvs.id_articulo = a.id_articulo");
					qry.append(" and aa.role in (").append(rol).append(")");
					qry.append(" and a.categoria_grupo = ").append(idGrupo);
					qry.append(" and a.categoria_seccion = ").append(idSeccion);
					qry.append(" group by id_autor");
					qry.append(" order by count(a.id_articulo) desc");

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						int i=0;
						while (rs.next() && i<maximoARetornar) {
							retorno = retorno + rs.getString("id_autor") + ",";
							i++;
						}
					} catch (Exception e) {
						TmkLogger.error("DBUtil: getAutoresMasVendidos, " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("DBUtil: getAutoresMasVendidos, " + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("DBUtil: getAutoresMasVendidos, " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("DBUtil: getAutoresMasVendidos, " + e.toString());
		}
		if (retorno.length()>1) {
			retorno = retorno.substring(0, retorno.length()-1);
		}
		return retorno;
	}


	public static double getMenorGastoDeEnvio() {
		double retorno = 0;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				Statement st = conn.createStatement();
				try {
					StringBuffer qry = new StringBuffer();
					qry.append(" SELECT");
					qry.append(" ROUND ((");
					qry.append(" SELECT min(z.importe) FROM GASTOS_ENVI_ZONAS z, GASTOS_ENVI_ZONAS_PAISES zpp");
					qry.append(" WHERE (z.id_zona = zpp.id_zona)");
					qry.append(" AND (zpp.id_pais = 300)");
					qry.append(" )");
					qry.append(" * (  1");
					qry.append(" + NVL (  (SELECT   NVL (tasa_general, 0)");
					qry.append(" + NVL (tasa_adicional, 0)");
					qry.append(" + NVL (tasa_percep_video, 0)");
					qry.append("            FROM tasas");
					qry.append("         WHERE id_impuesto = a.id_impuesto");
					qry.append(" AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append(" AND fecha_vigencia =");
					qry.append(" (SELECT MAX (fecha_vigencia)");
					qry.append("  FROM tasas");
					qry.append("  WHERE id_impuesto = a.id_impuesto");
					qry.append("  AND id_tipo_contribuyente = ").append(Globals.ID_TIPO_CONTRIBUYENTE);
					qry.append("  AND fecha_vigencia <= SYSDATE))");
					qry.append("   / 100,");
					qry.append("       0");
					qry.append("      )");
					qry.append(" ),");
					qry.append(" 2");
					qry.append(" ) precio from articulos a where id_articulo =").append(Globals.GASTO_ENVIO_BASICO_MERC_LOCAL);

					ResultSet rs = st.executeQuery(qry.toString());
					try {
						while (rs.next()) {
							retorno = rs.getDouble("precio");
						}
					} catch (Exception e) {
						TmkLogger.error("DBUtil: getMenorGastoDeEnvio, " + e.toString());
					} finally {
						rs.close();
					}
				} catch (Exception e) {
					TmkLogger.error("DBUtil: getMenorGastoDeEnvio, " + e.toString());
				} finally {
					st.close();
				}
			} catch (Exception e) {
				TmkLogger.error("DBUtil: getMenorGastoDeEnvio, " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("DBUtil: getMenorGastoDeEnvio, " + e.toString());
		}
		return retorno;
	}


	public static int getPuntos (double importe) {
		int puntos = 0;
		try {
			Connection conn = DBUtil.buildConnection();
			try {
				CallableStatement cs = conn.prepareCall("{? = call FDN_OPERACIONES.get_puntos_basicos(?)}");
				try {
					cs.registerOutParameter(1, Types.DOUBLE);
					cs.setDouble(2, importe);
					cs.execute();
					puntos = cs.getInt(1);
				} finally {
					cs.close();
				}
			} catch (Exception e) {
				TmkLogger.error("DBUtil: getPuntos, " + e.toString());
			} finally {
				conn.close();
			}
		} catch (Exception e) {
			TmkLogger.error("DBUtil: getPuntos, " + e.toString());
		}
		return puntos;
	}

	//elimina las sessiones del rol site y admin. salvo la que ejecuta
	//se ejecuta a traves del usuario admin
	public static void killSessions() throws Exception {
		Connection conn = buildConnection("jdbc/admin");
		try {
			CallableStatement cs = conn.prepareCall(" call SYSTEM.ADM_SESIONES.MATA_TMK2()");
			try {
				cs.execute();

			} finally {
				cs.close();
			}
		} finally {
			conn.close();
		}
	}


}

