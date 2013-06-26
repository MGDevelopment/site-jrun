/**
 * $Log: Globals.java,v $
 * Revision 1.188  2009/04/15 16:06:54  oClopez
 * version estable de desarrollo
 *
 * Revision 1.187  2009/04/07 19:56:41  msartori
 * no message
 *
 * Revision 1.186  2009/03/10 15:17:37  msartori
 * Rediseno. secciones footer
 *
 * Revision 1.185  2009/03/04 12:54:52  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.184  2009/01/15 12:35:21  msartori
 * no message
 *
 * Revision 1.183  2008/12/03 12:40:41  msartori
 * - Mesa Interactiva
 * - Vencimiento cheque obsequio por parametro
 * - Version 1.3 de xstream
 *
 * Revision 1.182  2008/08/20 14:23:35  msartori
 * no message
 *
 * Revision 1.181  2008/08/06 14:15:38  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.180  2008/07/07 18:58:58  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.179  2008/05/30 16:03:13  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.178  2008/04/09 20:19:08  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.177  2008/01/24 20:28:06  msartori
 * no message
 *
 * Revision 1.176  2007/12/18 20:10:32  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.175  2007/11/15 13:51:46  msartori
 * Reescritura de URL para familias.
 * - Modificaciones en generacion de familias
 * - Modificaciones en site map
 * - Modificaciones en arbol
 *
 * Eliminacion EJB mas vendidos y categoria seccion.
 *
 * Revision 1.174  2007/10/18 20:05:15  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.173  2007/09/03 13:41:23  msartori
 * no message
 *
 * Revision 1.172  2007/07/25 20:07:17  omsartori
 * - Nuevo diseño de fidelizacion
 * - Actualizacion de Datos
 *      - Encripcion de codigos
 *
 * Revision 1.171  2007/05/28 19:19:18  omsartori
 * Buscador de inicio para todas las categorias deshabilitado
 * Estadísticas
 *      Se diferencias los resultados de busqueda de la siguiente forma
 *           Consultas correctas
 *           Consultas sin resultado
 *           Consultas timeout (fuera de tiempo)
 *           Consultas con error
 * Se discriminan los resultados de búsqueda por buscador
 * Circuito de prueba, se agregó la tarjeta nro 1234432112344321 como tarjeta de prueba para poder realizar el testeo de compra con tarjeta de crédito completo.
 * Aprobación de órdenes, se agregó un log para contabilizar la aprobación de cada item, para facilitar el seguimiento.
 * Se modificó el proceso de genereación de homes para sincronizar con la nueva versión de la tarea de subida de contenido de eclipse.
 *
 * Revision 1.170  2007/05/09 18:17:37  omsartori
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
 * Revision 1.169  2007/04/26 18:42:17  omsartori
 * no message
 *
 * Revision 1.168  2007/04/26 18:32:14  omsartori
 * no message
 *
 * Revision 1.167  2007/03/29 17:35:56  omsartori
 * - Medidas para productos
 * - Mejora de tiempos en busqueda de autor (modificacion de qry)
 *
 * Revision 1.166  2007/03/19 14:22:09  omsartori
 * - Generador de arbol de categorias
 * - Atributo peso agregado para detalle de libros y derivados
 * - Buscador avanzado
 * 	* Las búsquedas se disparan presionando la tecla Enter en cualquier campo
 * 	* Se unificó el atributo soporte con el que se utiliza para el detalle en articulos de la seccion musica
 * - Paginas de institucionales
 * - Se agregó retorno de carro a los textos de reseña
 *
 * Revision 1.165  2007/03/07 17:49:18  olsuarez
 * Correccion del catalogo de productos extra! para que
 * habilitara el link al detalle, solo a los productos disponibles en el sitio.
 *
 * Revision 1.164  2007/02/13 13:17:28  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.163  2007/01/25 18:09:51  omsartori
 * - Correcciones rediseño
 *
 * Revision 1.162  2007/01/22 17:43:07  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.161  2007/01/04 18:52:12  omsartori
 * - Detalle de articulo y paginas derivadas
 *
 * Revision 1.160  2006/12/29 12:33:33  omsartori
 * -Detalle Articulo
 *    - Modulo Extra
 *    - Comentarios
 *
 * Revision 1.159  2006/12/27 15:47:51  omsartori
 * -Rediseño: Atributos de articulo, metaTags.
 * -Correccion de planes de tarjetas para quedarme con el de vigencia mas nueva
 * -Site Map correccion de secciones
 *
 * Revision 1.158  2006/12/13 17:15:07  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.157  2006/11/30 18:22:49  oLSuarez
 * Quita de Globals.estiloBasico() en paginas rediseñadas
 *
 * Revision 1.156  2006/11/27 13:03:36  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.155  2006/11/08 15:40:55  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.154  2006/10/13 19:35:56  oLSuarez
 * Creacion bannerTop en Musica.
 * Creacion de institucional util para todas las home
 *
 * Revision 1.153  2006/10/12 14:58:29  omsartori
 * no message
 *
 * Revision 1.152  2006/10/09 13:05:36  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.151  2006/09/28 14:57:32  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.150  2006/09/14 18:24:39  omsartori
 * Promociones II
 *
 * Revision 1.149  2006/08/14 13:28:48  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.148  2006/07/17 14:07:45  omsartori
 * - Validacion de tarjetas de bco Rio
 * - Pop promo ABocelli
 * - Ultimos visitados resueltos con un qry
 * - Ejb de articulo eliminado de detalle de articulo
 * - Generacion de detalles -> correccion de commit de autores y editores
 *                                        -> Flag para evitar solapamiento de generaciones
 * - Indice de contenidos tomados de la base de datos. Se elimina el mantenimiento de archivos
 * - Pagina de indice de contenidos resuelta sin EJBs
 * - Webservice cliente para informe de compra de Musica On Line
 *
 * Revision 1.147  2006/06/05 12:40:00  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.146  2006/04/17 14:37:47  omsartori
 * * Corrección Busqueda "Recorra nuestras categorias apuntada a familia cuando corresponde grupo.
 * * Cambio de texto de promociones en carrito de compras.
 * * Leyenda de cuotas en la seleccion de medios de cobros.
 * * Alarma de indice que dan error al formatease.
 * * Doc EmPro 11-anexo y 12.
 * * recorrido por familia estatico.
 * * rediseño de extra.
 *
 * Revision 1.145  2006/03/30 14:42:40  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.144  2006/03/06 15:38:06  omsartori
 * - Medios de cobro VMA y MNA
 * - Indice de contenidos
 * - URL configurable para generacion
 *
 * Revision 1.143  2006/02/20 15:50:16  omsartori
 * - link a comentarios livra quitado
 *
 * Revision 1.142  2006/01/31 15:51:26  oDZurita
 * - se generaron nuevos taglibs: RecomendacionesTag y mejorPlanDePagoTag.
 * - se implementaron los tags en el detalle del artículo. Se eliminaron los iframe.
 * - Se extrajo la visualizacion del cuadro "ultimos visitados" del componente arbolCategorias para poder visualizarlo con el arbol estatico.
 * - se modificaron los ejb de alianza por la creacion del nuevo campo ID_SOCIO y la implementacion de la busqueda por los mismos.
 * - se modificaron los path de generacion de los directorios y del recorrido de las familias.
 * - se modificaron los path de los servlet de generacion del recorrido de las familias, de las homes y de los detalles de articulo.
 *
 * Revision 1.141  2006/01/13 15:45:49  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.140  2006/01/11 17:37:10  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.139  2005/12/29 17:45:11  omsartori
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
 * Revision 1.138  2005/12/29 17:24:48  oDZurita
 * - interfaz para la generación estática de los detalles de artículos.
 * - modificaciones en el método de búsqueda de detalle de artículos.
 * - uso del sleep en el daemon de generación de detalles de articulos.
 * - creación del daemon para la generación de los recorrido de familias.
 * - corrección en las consultas de los mas vendidos.
 * - creación del servlet para la generación estática de los recorridos de familias.
 * - interfaz para la generación estática de los recorridos de familias.
 *
 * Revision 1.137  2005/12/13 16:16:37  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.136  2005/11/09 12:19:01  omsartori
 * - Homes estaticas, deteccion de errores en la generacion de los componentes que permite continuar generando.
 *                                Aplicado al controlador de intranet y al proceso en back.
 *                                Mail de aviso detallado.
 *                                Inclusion de componentes generados en otros archivos.
 *
 * Revision 1.135  2005/11/04 15:29:07  oDZurita
 * - Desacoplamiento de algunos componentes en las home de cada categoría.
 * - Generador del componente que permite generar contenidos estáticos.
 * - Modificación en las búsquedas por palabra clave.
 * - Modificaciones especificadas en el documento de marketing nº9
 * - Permitir la generación de los componentes estáticas a través de la intranet.
 * - Implementación de una tercer lista en la home de inicio, solo aplicable cuando está habilitada alguna de las categorías de Dromo.
 * - Correccion de la paginación en el resultado de una búsqueda.
 * - Captura del error en el detalle del producto por inexistencia del producto.
 *
 * Revision 1.134  2005/11/04 12:55:35  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 *
 * Revision 1.132  2005/10/20 19:34:36  omsartori
 * - correccion en recomendados
 *
 * Revision 1.131  2005/10/06 12:57:23  omsartori
 * - Chequeo de marca y modelo correctos en Fidelizacion antes de grabar.
 * - Musica on line, parametros de seccion, grupo, familia y subfamilia configurables por xml
 *
 * Revision 1.130  2005/09/29 12:44:54  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.129  2005/09/22 18:38:08  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.128  2005/09/12 20:05:49  omsartori
 * - Promo Dia de la madre.
 *      - config por xml.
 *      - pantalla de carga.
 *      - validacion y grabacion.
 * - EJB reducido en homes de Categorias.
 *
 * Revision 1.127  2005/09/06 13:29:31  omsartori
 * - Reporte de Referidos
 * - Campos piso, depto, edificio en visualizacion de direcciones de envio/fact
 *
 * Revision 1.126  2005/08/29 12:29:55  omsartori
 * - Redireccionamiento de dominio configurable.
 * - Campo comentario agregado en mail de tarjetas verificadas.
 * - Correccion tamanio de imagenes en ranking.
 *
 * Revision 1.125  2005/08/24 13:13:30  omsartori
 * - Modifcacion en homes.
 * - Referidos> cambio de direccion de envio
 *                      reporte de referidos por dia
 *
 * Revision 1.124  2005/08/16 16:08:10  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.123  2005/07/18 13:52:50  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.122  2005/06/28 16:36:16  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.121  2005/06/15 16:48:33  omsartori
 * - Alerta de intrusion desde multiples hilos
 *
 * Revision 1.120  2005/05/26 14:43:43  omsartori
 * - Mail de tarjetas verificadas.
 * - Pais de facturacion y tarjeta extra para reporte de compras por socios.
 * - Se elimino el cambio de modo en el revitalizer
 * - Cambio de la leyenda de entrega y tel de contacto en la compra y ayuda
 * - Vigencia del referido
 * - Promocion no acumulable con referido
 *
 * Revision 1.119  2005/05/10 14:22:55  omsartori
 * - Posicionamiento: metas por secciones, sucursales. division de links a sucursales y a ranking,
 * link a detalle en resultado de busqueda, palabra de busqueda en resultado de busqueda
 *
 * Revision 1.118  2005/04/26 17:31:55  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.117  2005/03/24 15:25:03  omsartori
 * - Bug campo de gastos no grabado corregido
 * - Medio de cobro Rio Net Banking
 *
 * Revision 1.116  2005/03/15 12:28:00  omsartori
 * -Categoria (3,7,2,0 ) para Cheque obsequio
 * -Correccion del calculo del 5% para recargo EFCO
 * -Reemplazo de 7 x 10% en Afiliados libros
 * -Cambio en barra de titulos.
 * -Bug en lista de deseos.
 * -Eliminacion de jscript en combo convinado de localidades
 *
 * Revision 1.115  2005/02/17 12:13:29  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.114  2005/02/10 14:25:42  omsartori
 * - Habilitacion de referidos por xml
 * - Referidos: envio, reconocimiento y registro
 * - Cupones de referido y referente configurables por xml
 * - Cupon de registro configurable por xml
 *
 * Revision 1.113  2005/01/26 13:20:12  omsartori
 * - colores de Dromo
 *
 * Revision 1.112  2005/01/25 15:52:17  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.111  2005/01/24 15:17:58  omsartori
 * - Cambio en archivo de contenido, en configuracion flag de solapasEnMultilinea, diasIgnoradosNovedad, y se renombró el flag diaConsideradoNovedad por diasConsideradosNovedad.
 * - Se modficó solapas.jsp para soportar multilinea
 *
 * Revision 1.110  2005/01/20 20:47:59  oGPistoia
 * - Modificacion en buscador por proveedor
 * - Filtro extra para productos deshabilitados con atributos dinámicos
 *
 * Revision 1.109  2005/01/07 17:46:17  oGFritz
 * - Corrección del buscador por un error de js
 * - Reporte de compras por alianzas agregado
 * - Agregado de combo para opinionar sobre el pedido especial
 * -
 *
 * Revision 1.108  2005/01/04 15:29:19  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.107  2004/12/30 15:25:59  omsartori
 * - Reporte de Seguimiento de RIO HB con un demonio
 * - Reemplacé Date por Calendar en los reportes
 *
 * Revision 1.106  2004/12/27 15:41:48  omsartori
 * - chequeo de direcciones que no se deben modificar
 * - reporte de compras por socio con un demonio
 * - reporte de socios registrados con un demonio
 *
 * Revision 1.105  2004/12/13 13:57:09  oGPistoia
 * - Pago a través de Home Banking
 *
 * Revision 1.104  2004/12/06 16:45:54  omsartori
 * - Corrección de colores sección Juguetes (agendas)
 *
 * Revision 1.103  2004/12/02 22:40:11  oGPistoia
 * - Queda aprobada la matriz de estados
 *
 * Revision 1.102  2004/12/02 22:21:56  oGPistoia
 * - PreRelease Agendas.
 * - Eliminacion de productos via XML porque se reemplaza por estado_articulos
 *
 * Revision 1.101  2004/11/30 22:19:17  oGPistoia
 * - Aplicacion de las reglas de estados de articulos
 * - Agregado de las novedades en el catalogo de eXtra
 *
 * Revision 1.100  2004/11/25 21:11:21  omsartori
 * -Toma enter en el buscador rapido del input y del combo, se corrigió el bug que no validaba cuando hacias enter en el input, en vez de click al botón.
 * -Se agragaron todos los archivos para Juguetes.
 * - Se agrego la funcion en Globals textoSolapa, para poner el texto que se ven en la solapa.
 * - Pase prensa.jsp a html.
 *
 * Revision 1.99  2004/11/16 12:46:53  omsartori
 * *** empty log message ***
 *
 * Revision 1.98  2004/11/15 16:18:36  omsartori
 * - Unificación de detalleReducido.jsp
 * - Cambio en el array de secciones en Globals
 *
 * Revision 1.97  2004/11/11 17:01:59  oGPistoia
 * - Mejoras para AtributosDestacados que ahora soporta todos los casos
 *
 * Revision 1.96  2004/11/08 19:19:21  oGPistoia
 * - Agregue lo necesario para la solapa Accesorios
 *
 * Revision 1.95  2004/11/03 13:06:38  omsartori
 * - archivos iniciales para Dromo
 * - Eliminación de footer.jsp de los jsp de compra
 *
 * Revision 1.94  2004/11/01 16:31:43  oGPistoia
 * - Cambios para evitar bloqueos en comercial por la unificacion de socios duplicados que tienen nueva cuenta eXtra
 * - Cambios en el controler de Clientes Institucionales
 * - Generadores de clases de java para parser de xmls.
 *
 * Revision 1.93  2004/10/22 15:55:24  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.92  2004/10/08 22:55:16  oGPistoia
 * - Adaptaciones al diseño de eXtra III
 * - Bug en Nombre Receptor en componentes
 * - Interes de 0.01 por redondeo eliminado
 *
 * Revision 1.91  2004/10/05 21:27:57  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.90  2004/09/30 14:17:08  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.89  2004/09/23 18:44:44  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.88  2004/09/14 17:22:03  omsartori
 * Bug de imagenes con tam erroneos
 * Bug de direcciones (otra localidad, otra provincia)
 * Bug de inicio de sesion (link a pagina null)
 *
 * Revision 1.87  2004/09/10 15:12:54  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.86  2004/09/09 16:46:10  omsartori
 * Arreglado bug de redireccion en inicio de sesión
 * bug de tamaño de imagenes
 * imagen y color de seccion en ultimos visitados
 * ultimos visitados en compras
 *
 * Revision 1.85  2004/09/07 16:14:35  omsartori
 * - Reporte de Comentarios de articulos
 * - Javascript para generar combobox dependiente de otra combo (genérico)
 * - switchs de secciones reemplazados por funciones nuevas en Globals
 * - Pagina de error para javax.io.FileNotFoundException
 * - Listado de los detalles de articulos visitados
 *
 * Revision 1.84  2004/08/03 15:47:01  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.83  2004/07/12 19:52:02  oGPistoia
 * - Correccion del director en el detalle reducido del buscador
 * - Correccion del bug de AgregarProducto
 *
 * Revision 1.82  2004/07/08 20:18:53  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.81  2004/07/05 15:43:14  oGPistoia
 * - Release 1.80 (y cambios menores)
 *
 * Revision 1.80  2004/06/30 18:23:02  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.79  2004/06/15 20:56:14  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.78  2004/06/09 18:49:46  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.77  2004/05/14 19:16:46  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.76  2004/05/04 18:09:33  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.75  2004/04/12 20:19:02  oGPistoia
 * - Cambios en la registracion
 * - Mejoras para las alianzas
 *
 * Revision 1.74  2004/04/06 22:21:27  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.73  2004/03/25 20:42:18  oGPistoia
 * Incremento la version
 *
 * Revision 1.72  2004/03/04 18:51:42  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.71  2004/02/27 13:44:19  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.70  2004/02/16 20:22:54  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.69  2004/02/11 19:32:52  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.68  2004/01/06 15:28:31  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.67  2003/12/22 22:26:54  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.66  2003/12/15 22:07:54  GPistoia
 * -Envio de mails de pedidos especiales
 * -Metodo de pago en la aprobacion/rechazo de orden
 *
 * Revision 1.65  2003/12/11 20:52:06  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.64  2003/12/04 17:19:12  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.63  2003/11/27 02:02:37  GPistoia
 * -Gasto de envio no tenia impuestos
 *
 * Revision 1.62  2003/11/26 15:36:57  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.61  2003/11/19 18:55:27  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.60  2003/11/13 20:11:40  GPistoia
 * -Cambio de direccion para generacion de mail por temas de firewall
 * -Extensibilidad en detalles de articulos para agregar html del usuario
 * -Mejora en pantalla de estado de ordenes
 * -Sincronizacion de estadisticas
 *
 * Revision 1.59  2003/11/12 17:40:20  GPistoia
 * -Version del sistema
 *
 * Revision 1.58  2003/11/07 15:32:58  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.57  2003/11/03 20:57:52  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.56  2003/10/29 19:57:21  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.55  2003/10/28 01:39:25  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.54  2003/10/23 19:05:13  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.53  2003/10/17 14:15:17  GPistoia
 * -Disponibilidad nula ahora es pedido especial
 * -Recalculo de importes de articulos
 *
 * Revision 1.52  2003/10/13 21:43:28  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.51  2003/10/12 22:11:24  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.50  2003/10/10 16:05:54  JMembrives
 * no message
 *
 * Revision 1.49  2003/10/09 19:29:57  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.48  2003/10/07 14:52:17  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.47  2003/10/03 16:29:04  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.46  2003/09/29 17:20:08  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.45  2003/09/29 16:44:33  NRodriguez
 * - Logueo de memoria disponible
 *
 * Revision 1.44  2003/09/26 15:24:45  SLizardo
 * String => StringBuffer
 *
 * Revision 1.43  2003/09/25 19:17:12  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.42  2003/09/24 23:12:39  GPistoia
 * -Modificacion de descuento de articulo porque puede ser positivo.
 * -Modificacion de contenido con N paginas o solapas principales
 *
 * Revision 1.41  2003/09/24 21:23:31  SLizardo
 * no message
 *
 * Revision 1.40  2003/09/23 13:55:11  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.39  2003/09/17 19:32:06  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.38  2003/09/17 15:13:37  GPistoia
 * -Incidente de link en promociones.
 * -Importe minimo de 0.01 para cualquier producto.
 *
 * Revision 1.37  2003/09/16 19:30:57  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.36  2003/09/16 18:58:45  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.35  2003/09/15 22:30:54  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.34  2003/09/11 18:08:43  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.33  2003/09/09 13:28:31  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.32  2003/09/08 15:24:46  GPistoia
 * -Mejoras de pais-provincia-localidad terminadas
 *
 * Revision 1.31  2003/09/08 13:54:37  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.30  2003/09/05 19:56:27  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.29  2003/09/04 21:39:28  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.28  2003/09/02 19:08:29  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.27  2003/09/02 14:23:14  GPistoia
 * -Imagenes de productos grandes
 * -Campos en Articulo
 *
 * Revision 1.26  2003/09/01 13:54:52  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.25  2003/08/29 17:54:22  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.24  2003/08/27 21:17:49  GPistoia
 * -Ordenes pendientes con tarjeta y sin tarjeta
 *
 * Revision 1.23  2003/08/27 18:43:51  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.22  2003/08/26 16:18:55  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.21  2003/08/22 14:03:56  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.20  2003/08/21 17:48:27  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.19  2003/08/20 13:33:17  JMembrives
 * detalle articulo y busqueda avanzada
 *
 * Revision 1.18  2003/08/19 19:27:14  GPistoia
 * -Pedido especial terminado
 * -Logo configurable
 * -Configuracion del sitio
 *
 * Revision 1.17  2003/08/15 15:59:20  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.16  2003/08/14 14:39:59  SLizardo
 * Se actualizo el Logger (Globals. a TmkLogger.)
 *
 * Revision 1.15  2003/08/13 22:51:33  SLizardo
 * Se agrego el Log4J
 *
 * Revision 1.14  2003/08/12 22:06:05  GPistoia
 * -Se borraron las paginas viejas
 * -Se agregaron las paginas nuevas
 * -Se actualizo el proyecto y elimino el disco V
 *
 * Revision 1.13  2003/08/12 16:25:27  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.12  2003/08/08 20:13:42  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.11  2003/08/06 21:28:21  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.10  2003/08/04 22:17:51  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.9  2003/08/04 19:54:59  SLizardo
 * BugFixes and Migration
 *
 * Revision 1.8  2003/08/02 16:58:10  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.7  2003/07/30 15:18:01  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.6  2003/07/28 19:21:28  GPistoia
 * -Controlador de registracion
 *
 * Revision 1.5  2003/07/26 19:06:08  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 * Revision 1.4  2003/07/24 19:06:21  GPistoia
 * -Consulta para cotizaciones
 * -Consulta de Socio por login
 * -Tests de kernel
 *
 * Revision 1.3  2003/07/22 15:12:49  GPistoia
 * -Extension de logs
 *
 * Revision 1.2  2003/07/22 14:50:10  GPistoia
 * -Mensajes para log
 *
 * Revision 1.1  2003/07/21 15:07:31  GPistoia
 * -Articulo
 * -Common y conversion
 * -Funciones para consulta
 *
 */
package com.tmk.kernel;

import com.tmk.articulo.*;
import com.tmk.common.*;
import com.tmk.kernel.gpay.GPay;
import com.tmk.kernel.gpay.TerminalManager;
import com.tmk.kernel.server.*;
import com.tmk.kernel.server.types.*;
import com.tmk.kernel.site.Referente;
import com.tmk.kernel.site.Referido;
import com.tmk.fidelizacion.*;
import com.tmk.referido.*;




import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.util.Date;
import java.util.Vector;
import java.util.Hashtable;
import java.awt.*;


public final class Globals implements XMLLoader.Listener {
	public static int[]paginacionesXSeccion = new int[]{0,0,0,0,0};
	public static int[]paginacionesXFiltro = new int[]{0,0,0,0,0};
	// Nombre del Sitio generico
	public static final String NOMBRE_DEL_SITIO = "Tematika.com";

	// Nombre del Sitio generico
	public static final String NOMBRE_DEL_SITIO_ADMINISTRACION = "Administracion de " + NOMBRE_DEL_SITIO;

	// El caracter de nueva linea
	public static final String ENTER = System.getProperty("line.separator");

	/** Hora a la que arranco el server */
	public static final Date FECHA_INICIO = new Date();

	/** Identificacion de la version */
	public static final String VERSION = "$Revision: 1.188 $";

	// Nombre del Sitio generico
	public static String PAGINA_SITIO = "http://localhost:8005";

	// Nombre del Sitio generico
	public static String SERVER_MAIL = PAGINA_SITIO;

	// Texto de la cabecera de los HTMLs para que los buscadores lo encuentren
	public static String TEXTO_PARA_BUSCADORES = NOMBRE_DEL_SITIO;

	// Icono a mostrar en todas las paginas
	public static String ICONO = "/imagenes/tematika.ico";

	// Conversion entre monedas
	public static int MONEDA_PESO = 1;
	public static int MONEDA_DOLLAR = 0;
	public static int MONEDA_EURO = 0;

	public static double TASA_PESO = 1.0;
	public static double TASA_DOLLAR = 0.0;
	public static double TASA_EURO = 0.0;

	// No se puede grabar un producto menor a este importe
	public static double IMPORTE_MINIMO_AFIP = 0.01;

	// Cantidad de digitos permitidos
	public static int DIGITOS_TARJETA_MINIMO = 14;
	public static int DIGITOS_TARJETA_MAXIMO = 20;

	// limite de importes
	public static double REGLA_PRECIO_ARTICULO_MINIMO = IMPORTE_MINIMO_AFIP;
	public static double REGLA_PRECIO_ARTICULO_MAXIMO = Integer.MAX_VALUE;
	public static double REGLA_LIMITE_COMPRA_MINIMO = IMPORTE_MINIMO_AFIP;
	public static double REGLA_LIMITE_COMPRA_MAXIMO = Integer.MAX_VALUE;
	public static double CARGO_POR_ENVIO_CONTRAREEMBOLSO = 0.0;

	public static int VIGENCIA_DEL_CARRITO_EN_DIAS = 356;

	public static boolean ENVIA_MAILS_LARGOS = true;

	public static String TIPO_PERSONA_FISICA;
	public static String TIPO_PERSONA_JURIDICA;

	// Valores para envio de mail.
	public static boolean MAIL_HABILITADO;
	public static String  MAIL_MAILER;
	public static String  MAIL_SMTP_HOST;
	public static String  MAIL_WEBMASTER;
	public static String  MAIL_ADMINISTRADOR;
	public static String  MAIL_CALL_CENTER;
	public static String  MAIL_ALIANZAS;
	public static String  MAIL_REFERIDOS = "referidos@tematika.com";
	public static String[] MAIL_OFERTA_DE_TRABAJO;
	public static String[] MAIL_REPORTE_DE_CONTENIDO;
	public static String[] MAIL_REPORTE_DE_PEDIDOS_ESPECIALES;
	public static String[] MAIL_REPORTE_DE_ESTADISTICA_ORDENES;
	public static String[] MAIL_REPORTE_DE_ESTADO_DE_ORDEN;
	public static String[] MAIL_REPORTE_DE_VISITAS;
	public static String[] MAIL_REPORTE_DE_CLIENTES_INSTITUCIONALES;
	public static String[] MAIL_TARJETAS_VERIFICADAS;
	public static String[] MAIL_REPORTE_DE_SOCIOS;
	public static String[] MAIL_ALERTA_SOC_DUP;

	public static String HORARIO_CALL_CENTER;
	public static String TELEFONO_CALL_CENTER;
	public static String TELEFONO_EXTERIOR_CALL_CENTER;
	public static String FAX_CALL_CENTER;

	/** Articulo gasto de envio */
	public static int GASTO_DE_ENVIO_CATEGORIA_SECCION = 99;
	public static int GASTO_DE_ENVIO_CATEGORIA_GRUPO = 3;
	public static int GASTO_DE_ENVIO_CATEGORIA_FAMILIA = 1;

	public static int GASTO_ENVIO_ADICIONAL_MERC_EXTERIOR;
	public static int GASTO_ENVIO_ADICIONAL_MERC_LOCAL;
	public static int GASTO_ENVIO_BASICO_MERC_EXTERIOR;
	public static int GASTO_ENVIO_BASICO_MERC_LOCAL;
	//CREADO PARA SUSCRIPCION QUID
	public static int GASTO_ENVIO_BASICO_MERC_LOCAL_QUID;
	public static double MENOR_GASTO_ENVIO;

	/** Articulo de Interes */
	public static int ID_ARTICULO_INTERES_COBRADO = 131050;
	public static int INTERES_COBRADO_CATEGORIA_SECCION = 99;
	public static int INTERES_COBRADO_CATEGORIA_GRUPO = 2;
	public static int INTERES_COBRADO_CATEGORIA_FAMILIA = 0;

	/** articulo para caso de error */
	public static int ARTICULO_DEFAULT = 0;

	/** Codigo de sucursal de Tematika para comercial */
	public static int ID_SUCURSAL_TEMATIKA;
	/** Codigo de canal alternativo de Tematika para comercial*/
	public static int ID_CANAL_ALTERNATIVO;
	// tipo de contribuyente
	public static int ID_TIPO_CONTRIBUYENTE = 5;

	/** Tiempo que esta vigente el proyecto de fidelización */
	public static int FDN_AÑOS_VIGENCIA = 2;
	public static int FDN_REGLA_ADHESION_FIDELIZACION = 2;
	public static int FDN_REGLA_ADHESION_COMPLEMENTARIOS = 3;
	public static int FDN_REGLA_ACTUALIZACION = 61;

	public static int FDN_CONCEPTO_EVENTO = 5000;
	public static String FDN_FORMULARIO_IDIOMAS = ",IN,FR,IT,PT,NG,OT,";
	public static String FDN_FORMULARIO_TARJETAS = ",AME,VIS,MAS,CCR,DIN,OTROS,NING,";
	public static int FDN_ID_SUCURSAL_FIDELIZACION_SITIO = 220;

	/* Reglas por fidelizarse */
	public static ReglasDePuntosDAO REGLA_FDN_POR_ADHESION;
	public static ReglasDePuntosDAO REGLA_FDN_POR_DATOS_COMPLEMENTARIOS;

	/* Regla por actualizar datos*/
	public static ReglasDePuntosDAO REGLA_FDN_POR_ACTUALIZACION;


	// Determina si tiene que mostrar cualquier cosa relativa a Fidelizacion
	public static boolean FIDELIZACION_VIGENTE = false;
	public static String FIDELIZACION_TARJETA_HABILITADA = "HA";
	public static String FIDELIZACION_CUENTA_HABILITADA = "HA";

	// Determina si tiene que mostrar cualquier cosa relativa a Referido
	public static boolean REFERIDO_VIGENTE = false;
	public static Referido CUPON_REFERIDO = null;
	public static Referente [] CUPON_REFERENTE = null;

	public static int VIGENCIA_DE_REFERIDO = 0;
	public static int VIGENCIA_DE_REFERENTE = 0;


	//Redireccion de Dominios
	public static String DOMINIO_PRINCIPAL;
	public static String [] DOMINIO_SECUNDARIO;

	//tipo de articulo para promo de cheque obsequio
	public static boolean PROMO_CHEQUE_OBSEQUIO_VIGENTE = false;
	public static String CODIGO_CHEQUE_OBSEQUIO = null;

	//promo dia de la madre
	public static boolean PROMO_DIA_DE_LA_MADRE_VIGENTE = false;
	public static double PESOS_POR_CUPON = 0;

	//Musica On Line
	public static boolean MUSICA_ON_LINE_HABILITADO = false;
	public static int MUSICA_ON_LINE_SECCION =-1;
	public static int MUSICA_ON_LINE_GRUPO =-1;
	public static int MUSICA_ON_LINE_FAMILIA =-1;
	public static int MUSICA_ON_LINE_SUB_FAMILIA =-1;
	public static int MUSICA_ON_LINE_DISPONIBILIDAD =-1;

	//Bloqueo de ips
	public static int BLOQUEO_IP_HITS = 0;
	public static int BLOQUEO_IP_TIEMPO_ENTRE_HITS = 0;
	public static boolean BLOQUEO_IP_HABILITADO = false;

	public static String CUPON_REGISTRO = null;

	public static final int FORMATO_MUSICA_DVD = 0;
	public static final int FORMATO_MUSICA_VIDEO = 1;

	public static final int FORMATO_PELICULA_CD = 0;
	public static final int FORMATO_PELICULA_DVD = 1;
	public static final int FORMATO_PELICULA_CASSETTE = 2;

	public static final String TEXTO_ARTICULO_COMPRA = "comprar";
	public static final String TEXTO_ARTICULO_LISTADESEO = "comprar";
	public static final String TEXTO_ARTICULO_PEDIDO = "pedir"; // le puse pedir, me pidieron cambiarlo a comprar, y ahora volvemos a pedir... Nacho.. si nos dieras bola!!!

	public static boolean MEJORAR_TEXTOS = true;

	public static int DIAS_CONSIDERADOS_NOVEDAD = 30;
	public static int DIAS_IGNORADOS_NOVEDAD = 1;


	public static boolean SOLAPAS_EN_MULTILINEA = false;

	// Listado de secciones disponibles
	public static final int SECCION_HOME = 0;
	public static final int SECCION_LIBRO = 1;
	public static final int SECCION_REVISTAS = 2;
	public static final int SECCION_JUGUETES = 3;
	public static final int SECCION_MUSICA = 4;
	public static final int SECCION_PELICULA = 5;
	public static final int SECCION_INFORMATICA = 6;
	public static final int SECCION_ELECTRONICA = 7;
	public static final int SECCION_ACCESORIOS = 8;

	//secciones de rediseño*/
	public static final int SECCION_SUCURSALES = 200;
	public static final int SECCION_QUID = 300;
	public static final int SECCION_EXTRA = 400;
	//public static final int SECCION_LOGIN = 500;
	public static final int SECCION_MICUENTA = 500;
	public static final int SECCION_GENERAL = 600;
	public static final int SECCION_EMPLEO = 700;



    // indices donde estan los tamaños de imagen segun el tipo
    public static final int IMAGEN_CHICA = 5;
    public static final int IMAGEN_MEDIANA = 7;
    public static final int IMAGEN_GRANDE = 9;

	// Valores cacheados de los EJBs
	public static PaisDAO ARGENTINA = new PaisDAO(300, "Argentina");
	public static PaisDAO PAISES[] = null;

	public static int CODIGO_OTRA_PROVINCIA = 99999;
	public static int CODIGO_OTRA_LOCALIDAD = 99999;

	public static ProvinciaDAO BUENOS_AIRES = new ProvinciaDAO(ARGENTINA.getId(), 401, "Buenos Aires");
	public static ProvinciaDAO PROVINCIAS[] = null;

	public static LocalidadDAO AZUL = new LocalidadDAO(ARGENTINA.getId(), BUENOS_AIRES.getId(), 210, "Azul");
	public static LocalidadDAO LOCALIDADES[] = null;

	public static IdiomaDAO IDIOMA_ESPANOL = new IdiomaDAO("ES", "Espanol");
	public static IdiomaDAO IDIOMA_INGLES = new IdiomaDAO("IN", "Ingles");
	public static IdiomaDAO IDIOMAS[] = null;

	public static TipoDeDocumentoDAO TIPO_DOCUMENTO_DNI = new TipoDeDocumentoDAO("DNI", "Documento Nacional de Identidad");
	public static TipoDeDocumentoDAO TIPOS_DOCUMENTO[] = null;

	public static EstadoCivilDAO ESTADO_CIVIL_SOLTERO = new EstadoCivilDAO("S", "Soltero");
	public static EstadoCivilDAO ESTADOS_CIVILES[] = null;

	public static EstudioDAO ESTUDIO_PRIMARIO = new EstudioDAO("1", "Estudio Primario");
	public static EstudioDAO ESTUDIOS[] = null;

	public static ActividadLaboralDAO ACTIVIDAD_LABORAL_OTRA = new ActividadLaboralDAO("99", "Actividad no especificada");
	public static ActividadLaboralDAO ACTIVIDADES_LABORALES[] = null;

	public static ProfesionDAO PROFESION_EJEMPLO = new ProfesionDAO(8, "Otro");
	public static ProfesionDAO PROFESIONES[] = null;

	public static MarcaDeCombustibleDAO MARCAS_DE_COMBUSTIBLE_DEFECTO = new MarcaDeCombustibleDAO("99", "Otra marca de combustible");
	public static MarcaDeCombustibleDAO MARCAS_DE_COMBUSTIBLE[] = null;

	public static TipoDeCombustibleDAO TIPO_DE_COMBUSTIBLE_DEFECTO = new TipoDeCombustibleDAO("99", "Otro tipo de combustible");
	public static TipoDeCombustibleDAO TIPOS_DE_COMBUSTIBLE[] = null;

	public static MarcaDeVehiculoDAO MARCA_DE_VEHICULO_EJEMPLO = new MarcaDeVehiculoDAO("99", "Otra");
	public static MarcaDeVehiculoDAO MARCAS_DE_VEHICULOS[] = null;

	public static ModeloDeVehiculoDAO MODELO_DE_VEHICULO_EJEMPLO = new ModeloDeVehiculoDAO("99", "99", "Otro");
	public static ModeloDeVehiculoDAO MODELOS_DE_VEHICULOS[] = null;

	public static SistemaTVDAO SISTEMA_TV_NINGUNO = new SistemaTVDAO("99", "Otro sistema de TV");
	public static SistemaTVDAO SISTEMA_TV[] = null;

	public static EmpresaSimilarDAO EMPRESA_SIMILAR_OTRA = new EmpresaSimilarDAO("99", "Otra");
	public static EmpresaSimilarDAO EMPRESAS_SIMILARES[] = null;

	public static OcupacionDAO OCUPACION_OTRA = new OcupacionDAO("99", "Otra ocupación");
	public static OcupacionDAO OCUPACIONES[] = null;

	public static TarjetaDePuntajeDAO TARJETA_DE_PUNTAJE_OTRA = new TarjetaDePuntajeDAO("99", "Otra tarjeta");
	public static TarjetaDePuntajeDAO TARJETAS_DE_PUNTAJE[] = null;

	public static TelefonoCelularDAO TELEFONO_CELULAR_OTRO = new TelefonoCelularDAO("99", "Otra telefono");
	public static TelefonoCelularDAO TELEFONOS_CELULARES[] = null;

	public static String CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO = "EFCO";
	public static String CLAVE_MEDIO_DE_COBRO_FAX = "FAX";
	public static String CLAVE_MEDIO_DE_COBRO_RIOHB = "RIOHB";
	public static String CLAVE_MEDIO_DE_COBRO_RIONB = "RIONB";
	public static String TIPO_MEDIO_DE_COBRO_TARJETAS = "TA";
    public static String CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA = "TPP";
    public static String CLAVE_MEDIO_DE_COBRO_RAPI_PAGO = "RPAGO";
    public static String CLAVE_MEDIO_DE_COBRO_PAGO_FACIL = "PAGOF";
    public static String CLAVE_MEDIO_DE_COBRO_DINERO_MAIL = "DINMA";
    public static String CLAVE_MEDIO_DE_COBRO_ARCASH = "ARCAS";

	public static MedioDeCobroDAO MEDIO_DE_COBRO_DESCONOCIDO = new MedioDeCobroDAO("DESCONOCIDO", "Actualmente no permitido", "DESCONOCIDO", false);
	public static MedioDeCobroDAO MEDIOS_DE_COBRO[] = null;

	public static DisponibilidadDAO DISPONIBILIDAD_DESCONOCIDA = new DisponibilidadDAO(-1, "Disponibilidad a confirmar", false);
	public static DisponibilidadDAO DISPONIBILIDADES[] = null;

	public static TarjetaRangoDAO EJEMPLO_TARJETAS_RANGOS = new TarjetaRangoDAO("Solo para cargar la clase", 0, 0, 0, true, 0);
	public static TarjetaRangoDAO TARJETAS_RANGOS[] = null;

	public static TarjetaPlanDAO TARJETA_PLAN_DEFAULT = new TarjetaPlanDAO("AMEX", 1, "1 Cuota", 1, 32, 1, 0, 0.0);
	public static TarjetaPlanDAO TARJETAS_PLANES[] = null;
	public static Vector TARJETAS_DETALLE_ARTICULO = new Vector();

	public static EstadoOrdenDAO ESTADO_ORDEN_EN_GENERACION = new EstadoOrdenDAO("0", "Fuerza a cargar la clase.", "Fuerza a cargar la clase");
	public static EstadoOrdenDAO ESTADO_ORDEN_A_CONTROL_FRAUDE;
	public static EstadoOrdenDAO ESTADO_ORDEN_DATOS_A_COMPLETAR;
	public static EstadoOrdenDAO ESTADO_ORDEN_APROBADA;
	public static EstadoOrdenDAO ESTADO_ORDEN_RECHAZADA;
	public static EstadoOrdenDAO ESTADO_ORDEN_INICIA_LOGISTICA;
	public static EstadoOrdenDAO ESTADO_ORDEN_ENVIADA_LOGISTICA;
	public static EstadoOrdenDAO ESTADO_ORDEN_VALIDACION_PAGO;
	public static EstadoOrdenDAO ESTADO_ORDEN_APROBACION_DIRECTA;
	/*public static EstadoOrdenDAO ESTADO_ORDEN_CUPON_DE_PAGO;
	public static EstadoOrdenDAO ESTADO_ORDEN_DM;*/
	public static EstadoOrdenDAO ESTADOS_ORDENES[] = null;

	public static EstadoItemOrdenDAO ESTADOS_ITEM_ORDENES_APROBADO = new EstadoItemOrdenDAO("R", "Fuerza a cargar la clase");
	public static EstadoItemOrdenDAO ESTADOS_ITEM_ORDENES_RECHAZADO;
	public static EstadoItemOrdenDAO ESTADOS_ITEM_ORDENES[] = null;

	public static NivelDeRiesgoDAO NIVEL_DE_RIESGO_NO_DISPONIBLE = new NivelDeRiesgoDAO(-1, "Riesgo aún no calculado");
	public static NivelDeRiesgoDAO NIVELES_DE_RIESGO[] = null;

	public static CatalogoDAO SIN_CATALOGO = new CatalogoDAO(0, "Catalogo no disponible", "Sin categoria", new Date());
	//public static CatalogoDAO CATALOGOS[] = null;
	//Es siempre uno solo habilitado
	public static CatalogoDAO CATALOGOS = null;

	public static ItemDeCatalogoDAO ITEMS_CATALOGOS_DEFAULT = new ItemDeCatalogoDAO(0, ARTICULO_DEFAULT, 0, 0.0, false, new Date(), 0, "",false); // para forzar a cargar la clase
	public static ItemDeCatalogoDAO ITEMS_CATALOGOS[] = null;
	public static ItemDeCatalogoDAO ITEMS_CATALOGOS_DESCRIPCION[] = null;
	public static ItemDeCatalogoDAO ITEMS_CATALOGOS_PESOS[] = null;


	public static ReglasDePuntosDAO REGLAS_EJEMPLO = new ReglasDePuntosDAO(-1, "Fuerza a cargar la clase", 0);
	public static ReglasDePuntosDAO REGLAS_DE_PUNTOS[] = null;

	//public static boolean MesaInteractivaHomeLoaded = false;
	//tiene que estar aca para que lo vea ServerModeDaemon....
	public static boolean CATEGORIAS_LOADED = false;

	public static String [][] mapaAutoresBiografia;

	public static String PAGINA_ERROR = "/errorPage/errorPageFW.jsp";


	public static MesDAO MESES[] = new MesDAO[]{
			new MesDAO(1, "Enero"),
			new MesDAO(2, "Febrero"),
			new MesDAO(3, "Marzo"),
			new MesDAO(4, "Abril"),
			new MesDAO(5, "Mayo"),
			new MesDAO(6, "Junio"),
			new MesDAO(7, "Julio"),
			new MesDAO(8, "Agosto"),
			new MesDAO(9, "Septiembre"),
			new MesDAO(10, "Octubre"),
			new MesDAO(11, "Noviembre"),
			new MesDAO(12, "Diciembre")
		};

	public static final Object[][] SECCIONES = {
		{ new Integer(SECCION_HOME), new Boolean(true), "inicio", "producto", "inicio", new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Integer(0), new Color(0x00, 0x31, 0x5A), new Color(0x94, 0xB5, 0xF7), new Color(0xAD, 0xC6, 0xFF), new Color(0x00, 0x00, 0x00), new Color(0x00, 0x31, 0x5A), new Color(0x00, 0x00, 0x00)},
		{ new Integer(SECCION_LIBRO), new Boolean(false), "libros", "libro", "libros", new Integer(88), new Integer(59), new Integer(124), new Integer(80), new Integer(158), new Integer(105),  new Color(0x00, 0x59, 0x00), new Color(0x8C, 0xBD, 0x8C),  new Color(0xAD, 0xDE, 0xAD), new Color(0xB3, 0xE5, 0xB3), new Color(0x00, 0x59, 0x00), new Color(0xE6, 0xFF, 0xE6)},
		{ new Integer(SECCION_REVISTAS), new Boolean(false), "revistas", "revista", "revistas", new Integer(88), new Integer(59), new Integer(124), new Integer(80), new Integer(158), new Integer(105), new Color(0x78, 0x48, 0x6e), new Color(0x57, 0x2b, 0x4e), new Color(0xee, 0xe3, 0xe9), new Color(0x15, 0x20, 0x25),  new Color(0x30, 0xA0, 0xF0), new Color(0x50, 0x80, 0xA0)},
		{ new Integer(SECCION_JUGUETES), new Boolean(false), "juguetes", "producto de pasatiempos", "pasatiempos", new Integer(88), new Integer(59), new Integer(124), new Integer(80), new Integer(158), new Integer(105), new Color(0x78, 0x48, 0x6e), new Color(0xb2, 0x91, 0xab), new Color(0xc9, 0xa8, 0xc2), new Color(0x78, 0x48, 0x6e),  new Color(0x78, 0x48, 0x6e), new Color(0xD5, 0xBE, 0xCE)},
		{ new Integer(SECCION_MUSICA), new Boolean(false), "musica", "disco", "musica", new Integer(80), new Integer(80), new Integer(80), new Integer(80), new Integer(105), new Integer(105), new Color(0xE7, 0x9C, 0x01), new Color(0xDE, 0xDE, 0x73), new Color(0xFF, 0xFF, 0x9C), new Color(0xFF, 0xE6, 0x80), new Color(0xFF, 0xCC, 0x00), new Color(0xFF, 0xFB, 0xC7)},
		{ new Integer(SECCION_PELICULA), new Boolean(false), "peliculas", "film", "peliculas", new Integer(88), new Integer(59), new Integer(124), new Integer(80), new Integer(158), new Integer(105), new Color(0xD9, 0x40, 0x00), new Color(0xE7, 0xB5, 0x84), new Color(0xFF, 0xC6, 0x94), new Color(0xF0, 0x8A, 0x4A), new Color(0xD9, 0x40, 0x00), new Color(0xFE, 0xEB, 0xD0)},
		{ new Integer(SECCION_INFORMATICA), new Boolean(false), "informatica", "producto de informática", "informatica", new Integer(80), new Integer(80), new Integer(100), new Integer(100), new Integer(180), new Integer(180), new Color(0x8C, 0x51, 0x5A), new Color(0xC6, 0x96, 0x9C), new Color(0xE7, 0xC7, 0xCE), new Color(0xEF, 0xD7, 0xD6),  new Color(0x8C, 0x51, 0x5A), new Color(0xDE, 0xB6, 0xBD)},
		{ new Integer(SECCION_ELECTRONICA), new Boolean(false), "electronica", "producto de electrónica", "electronica", new Integer(80), new Integer(80), new Integer(100), new Integer(100), new Integer(180), new Integer(180), new Color(0x39, 0x61, 0x73), new Color(0x8C, 0xA6, 0xB5), new Color(0xAD, 0xC7, 0xCE), new Color(0xDE, 0xE7, 0xEF),  new Color(0x39, 0x61, 0x73), new Color(0xAD, 0xC7, 0xCE)},
		{ new Integer(SECCION_ACCESORIOS), new Boolean(false), "accesorios", "accesorio", "accesorios", new Integer(80), new Integer(80), new Integer(100), new Integer(100), new Integer(180), new Integer(180), new Color(0x31, 0x59, 0x4A), new Color(0x18, 0x86, 0x7B), new Color(0xA5, 0xD7, 0xCE), new Color(0xD6, 0xEF, 0xD7),  new Color(0x21, 0x71, 0x63), new Color(0xA5, 0xD7, 0xC7)},
	};

	public static final int[][] tamImagen = {
		{0,   0,   0,  0,  0,   0,   0},
		{1,  70, 105, 45, 68, 105, 158},
		{2,   0,   0,  0 , 0,   0,   0},
		{3,  90, 108, 45, 68, 108, 108},
		{4,  92,  92, 55, 55, 108, 108},
		{5,  72, 108, 50, 75, 106, 158},
		{6, 108, 108, 60, 60,   0,   0},
		{7, 108, 108, 60, 60, 	0,   0},
		{8, 108, 108, 60, 60,   0,   0}
	};

    /**
     * Estilo segun sección
     */
    public static final String estilo(int id) {
        return (id < SECCIONES.length) ? "<link href=/estilos/seccion_" + SECCIONES [id][2].toString() + ".css rel=stylesheet type=text/css>": estilo(SECCION_HOME);
    };

	/** Si la seccion esta habilitada */
	public static final boolean seccionHabilitada(int id) {
		return (id < SECCIONES.length) ? ((Boolean)SECCIONES[id][1]).booleanValue() : false;
	}

	/** Si la seccion esta habilitada */
	public static final void habilitarSeccion(int id, boolean habilitada) {
		if (id != SECCION_HOME && id < SECCIONES.length) {
			SECCIONES[id][1] = new Boolean(habilitada);
		}
	}

	/** Si la seccion esta habilitada */
	public static final void deshabilitarSecciones() {
		for (int i = 0; i < SECCIONES.length; i++) {
			habilitarSeccion(i, false);
		}
	}

	/** Nombre del Directorio donde se encuentran los archivos */
	public static final String seccion(int id) {
		return (id < SECCIONES.length) ? SECCIONES[id][2].toString() : seccion(SECCION_HOME);
	}

	/** Devuelve el nombre de la seccion */
	public static final String seccion(ArticuloLocal articuloLocal) {
		return seccion(articuloLocal.getCATEGORIA_SECCION().intValue());
	}

	/** Texto en plural a mostrar */
	public static final String productoSeccion(int id) {
		return (id < SECCIONES.length) ? SECCIONES[id][3].toString() : productoSeccion(SECCION_HOME);
	}

	/** Texto en plural a mostrar */
	public static final String textoSolapa(int id) {
		return (id < SECCIONES.length) ? SECCIONES[id][4].toString() : textoSolapa(SECCION_HOME);
	}

	public static final String getSeccionesHabilitadasSQL(){
		StringBuffer retorno = new StringBuffer();
		for (int i=1; i<SECCIONES.length; i++) {
			if (((Boolean)SECCIONES[i][1]).booleanValue()) {
				retorno.append(i).append(",");
			}
		}
		if (retorno.length()>1) {
			return retorno.substring(0, retorno.length()-1);
		}
		return "";
	}

    /**
    * texto segun sección
    */
    /*public static final String textoAutor (int id) {
        return (id < SECCIONES.length) ? SECCIONES [id][4].toString(): textoAutor(SECCION_HOME);
    };*/

    /**
    * texto segun sección
    */
    /*public static final String textoEditorial (int id) {
        return (id < SECCIONES.length) ? SECCIONES [id][5].toString(): textoAutor(SECCION_HOME);
    };*/

	/**
	 * Dice si esta en horario de trabajo o en horario especial en sabados y domingos
	 */
	public static boolean esHorarioDeReporte(int horaObligatoria, int minutoEsperado, boolean cadaHora) {
		Date fecha = new Date();
		boolean esHorarioObligatorio = (fecha.getHours() == horaObligatoria);
		boolean esHorarioSemanal = (fecha.getHours() >= 8 && fecha.getHours() < 18) && (fecha.getDay() >= 1 && fecha.getDay() <= 5);
		boolean esMinutoEsperado = (fecha.getMinutes() == minutoEsperado);
		return (esHorarioObligatorio || (esHorarioSemanal && cadaHora)) && esMinutoEsperado;
	}

	public static boolean esHorarioDeReporte(int horaObligatoria, int minutoEsperado) {
		Date fecha = new Date();
		boolean esHorarioObligatorio = (fecha.getHours() == horaObligatoria);
		boolean esMinutoEsperado = (fecha.getMinutes() == minutoEsperado);
		return esHorarioObligatorio  && esMinutoEsperado;
	}


	/**
	 * Retorna el titulo de la pagina
	 */
	public static final String title() {
		return new StringBuffer("<title>").append(NOMBRE_DEL_SITIO).append("</title>").toString();
	}

	/**
	 * Retorna el icono
	 */
	public static final String icon() {
		return new StringBuffer("<link href=\"").append(ICONO).append("\" rel=\"shortcut icon\" type=\"image/x-icon\">").toString();
	}

	/**
	 * Retorna el titulo de la pagina
	 */
	public static final String title(String subTitulo) {
		//return new StringBuffer("<title>").append(NOMBRE_DEL_SITIO).append(" - ").append(subTitulo).append("</title>").toString();
		return new StringBuffer("<title>").append(subTitulo).append("</title>").toString();
	}

	/**
	 * Retorna meta de titulo
	 */
	public static final String titleMeta(String textoExtra) {
		return new StringBuffer("<meta name=\"title\" content=\"").append(textoExtra).append("\">").toString();
    }

	/**
	 * Retorna meta de descripcion
	 */
	public static final String description(String textoExtra) {
		return new StringBuffer("<meta name=\"description\" content=\"").append(textoExtra).append("\">").toString();
	}

	/**
	 * Retorna meta de keywords
	 */
	public static final String keywords(String textoExtra) {
		return new StringBuffer("<meta name=\"keywords\" content=\"").append(textoExtra).append("\">").toString();
	}

	/**
	 * Texto para expirar las páginas automaticamente
	 */
	public static final String expires() {
		return "<meta http-equiv=\"expires\">";
	}

	/**
	 * Salta automáticamente a otra página
	 */
	public static final String refresh(int seconds, String url) {
		return new StringBuffer("<meta http-equiv='refresh' content='").append(seconds).append("; URL=").append(url).append("'>").toString();
	}

	/**
	 * Pone el set de caracteres
	 */
	public static final String copyright() {
		return "<meta name=\"author\" content=\"\">";
	}

	/**
	 * Pone el set de caracteres
	 */
	public static final String charset() {
		return "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">";
	}

	/**
	 * Rediseño, se cambia solamente para intranet
	 */
	public static final String estiloBasico() {
		return "<link rel=\"stylesheet\" href=\"/estilos/intranet.css\" type=\"text/css\">";
	}

    /**
    * tamaño de una imagen segun sección y tipo de imagen
    * devuelve un par con alto y ancho
    */
    public static final Pair tamañoImagen (int id, int tam) {
        int indice1 = (tam == IMAGEN_CHICA)? IMAGEN_CHICA: (tam == IMAGEN_MEDIANA)? IMAGEN_MEDIANA: IMAGEN_GRANDE;
        int indice2 = (tam == IMAGEN_CHICA)? IMAGEN_CHICA + 1: (tam == IMAGEN_MEDIANA)? IMAGEN_MEDIANA + 1: IMAGEN_GRANDE + 1;
	    return (id < SECCIONES.length) ? new Pair (SECCIONES [id][indice1], SECCIONES [id][indice2]): tamañoImagen(SECCION_HOME, tam);
    };

    /**
    * Color de titulo de articulos segun seccion
    */
    public static final String colorTitulo (int id) {
        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][11])): colorTitulo(SECCION_HOME);
    };

    /**
    * Color de promociones verticales segun seccion
    */
    public static final String colorIzquierda (int id) {
        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][12])): colorIzquierda(SECCION_HOME);
    };

    /**
    * Color de promociones verticales segun seccion
    */
    public static final String colorDerecha (int id) {
        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][13])): colorDerecha(SECCION_HOME);
    };

    /**
    * Color de fondo de titulos, barras segun seccion
    */
    public static final String colorFondo (int id) {
        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][14])): colorFondo(SECCION_HOME);
    };

    /**
    * Color de solapa segun sección
    */
    public static final String colorBase (int id) {
        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][15])): colorBase(SECCION_HOME);
    };

	public static final String colorDetalleReducido (int id) {
	        return (id < SECCIONES.length) ? (Convert.toStringHTML((Color)SECCIONES [id][16])): colorDetalleReducido(SECCION_HOME);
    };


    public static final String getGoogleAnalytics() {
    	StringBuffer retorno = new StringBuffer();
    	retorno.append("<script src=\"http://www.google-analytics.com/urchin.js\" type=\"text/javascript\">");
    	retorno.append(ENTER);
    	retorno.append("</script>");
    	retorno.append(ENTER);
    	retorno.append("<script type=\"text/javascript\">");
    	retorno.append(ENTER);
    	retorno.append("_uacct = \"UA-635166-1\";");
    	retorno.append(ENTER);
    	retorno.append("urchinTracker();");
    	retorno.append(ENTER);
    	retorno.append("</script>");

    	return retorno.toString();
    }

    public static final String getGoogleAnalyticsSSL() {

    	StringBuffer retorno = new StringBuffer("");
    	if (esModoRelease()) {
	    	retorno.append("<script src=\"https://ssl.google-analytics.com/urchin.js\" type=\"text/javascript\">");
	    	retorno.append(ENTER);
	    	retorno.append("</script>");
	    	retorno.append(ENTER);
	    	retorno.append("<script type=\"text/javascript\">");
	    	retorno.append(ENTER);
	    	retorno.append("_uacct = \"UA-635166-1\";");
	    	retorno.append(ENTER);
	    	retorno.append("urchinTracker();");
	    	retorno.append(ENTER);
	    	retorno.append("</script>");
    	}
    	return retorno.toString();
    }





	//Directorio
    //public static boolean DIRECTORIO_HABILITADO = false;
	//public static Date DIRECTORIO_PROX_GEN = null;
	//public static int DIRECTORIO_DIAS_GEN = 0;
	//Directorio

	//procesos background
	public static Hashtable procesosBackground = new Hashtable();
	//procesos background

	//Setup
	public static Server SERVER= null;
	//Setup

	//configuracion de la aplicacion
	public static AplicacionType MODO_APLICACION = AplicacionType.SITIO;
	public static boolean MODO_APLICACION_HABILITADO = false;
	public static String DOMINIO_SITIO = null;
	public static String DOMINIO_INTRANET = null;
	//configuracion de la aplicacion


	//generacion
	public static String GENERACION_SENTENCIA_DE_MAPEO= null;
	public static String GENERACION_SENTENCIA_DE_DESMAPEO= null;
	public static String GENERACION_DIRECTORIO= null;
	public static String GENERACION_DIRECTORIO_RAIZ= null;
	public static String GENERACION_URL= null;
	public static boolean GENERANDO_DETALLES = false;
	public static boolean GENERANDO_DETALLES_BIS = false;
	//generacion

	// Configuracion del servidor
	public static ModoType MODO_ACTUAL = ModoType.BACKUP;
	public static ModoType MODO_ELEGIDO = ModoType.BACKUP;
	public static boolean MOSTRAR_MENSAJE = false;
	public static boolean MODO_PRE_RESET = false;

	public static boolean CONTROL_SERVER_HABILITADO = false;
	public static String CONTROL_SERVER_CONSOLA = "kill jrun.exe";
	public static int CONTROL_SERVER_ITERACIONES = 10;
	public static int MEMORIA_ALERTA = 0;
	public static int MEMORIA_MAXIMA = Integer.MAX_VALUE;

	// Mensaje a mostrar
	public static String MENSAJE_MODO = "Espere un momento...";
	public static String MENSAJE_MANTENIMIENTO = MENSAJE_MODO;
	public static String MENSAJE_PREVIO = MENSAJE_MODO;
	public static int MINUTOS_DE_ANTICIPACION;

	// En que modo esta funcionando
	public static final boolean esModoDebug() {
		return (MODO_ACTUAL.getType() == ModoType.DEBUG_TYPE);
	}

	// En que modo esta funcionando
	public static final boolean esModoRelease() {
		return (MODO_ACTUAL.getType() == ModoType.RELEASE_TYPE);
	}

	// En que modo esta funcionando
	public static final boolean esModoReset() {
		return (MODO_ACTUAL.getType() == ModoType.RESET_TYPE);
	}

	// Si la base de datos esta levantada
	public static final boolean sitioDisponible() {
		return (MODO_ACTUAL.getType() == ModoType.DEBUG_TYPE) || (MODO_ACTUAL.getType() == ModoType.RELEASE_TYPE);
	}

	// Si la base de datos esta levantada
	public static final boolean baseDeDatosEnMantenimiento() {
		return (MODO_ACTUAL.getType() == ModoType.BACKUP_TYPE) || (MODO_ACTUAL.getType() == ModoType.RESET_TYPE);
	}

	// archivo de configuracion
	public static String DIRECTORIO_APLICACION = new File(System.getProperty("jrun.server.home")).getParent();

	// horarios donde el server no esta activo
	public static Inactividad INACTIVIDAD = new Inactividad();

	/** Listado de errores y sus notificaciones */
	public static Errores ERRORRES_GPAY = new Errores(); // por default sin elementos

	// Si permite o no aplicar cuotas
	public static boolean HABILITA_CUOTAS = false;

	// programa de referidos habilitados
	public static boolean referidoHabilitado() {
		return (REFERIDO_VIGENTE && (CUPON_REFERIDO != null) && (CUPON_REFERENTE != null));
	}

	//promo cheque obsequio habilitado
	public static boolean chequeObsequioVigente() {
		return (PROMO_CHEQUE_OBSEQUIO_VIGENTE && (CODIGO_CHEQUE_OBSEQUIO != null) && (CODIGO_CHEQUE_OBSEQUIO!=""));
	}

	//promo dia de la madre habilitado
	public static boolean promoDiaDeLaMadreVigente() {
		return (PROMO_DIA_DE_LA_MADRE_VIGENTE && PESOS_POR_CUPON > 0);
	}

	//Musica on line
	public static boolean musicaOnLineHabilitado() {
		return (MUSICA_ON_LINE_HABILITADO && MUSICA_ON_LINE_SECCION != -1 && MUSICA_ON_LINE_GRUPO != -1 && MUSICA_ON_LINE_FAMILIA != -1 && MUSICA_ON_LINE_SUB_FAMILIA != -1);
	}


	public static boolean bloqueoIPHabilitado() {
		return BLOQUEO_IP_HABILITADO;
	}


	/*public static boolean directorioHabilitado() {
		return (DIRECTORIO_HABILITADO && DIRECTORIO_PROX_GEN != null);
	}*/

	public static boolean esSitio () {
		return MODO_APLICACION.equals(AplicacionType.SITIO) && MODO_APLICACION_HABILITADO;
	}

	public static boolean esIntranet () {
		return MODO_APLICACION.equals(AplicacionType.INTRANET) && MODO_APLICACION_HABILITADO;
	}

	public static String getDominioSitio () {
		return DOMINIO_SITIO;
	}

	public static String getDominioIntranet () {
        return DOMINIO_INTRANET;
	}

	public void reloadSetup() {
		// Fuerza a recargar el archivo
		xmlLoader.reload();
	}

	// Singleton
	private static final Globals instance = new Globals();	// Llama al constructor

	/*DATOS PARA EL SERVICO DE ARCASH */
	public static final String PATCH_FORM_ARCASH_RELEASE = "https://www.arcash.com.ar/API/PinLoad.aspx";
	public static final String PATCH_FORM_ARCASH_DESARROLLO = "http://arcash.no-ip.biz/API/PinLoad.aspx";
	public static final String ID_MERCHANT_RELEASE = "50";
	public static final String ID_MERCHANT_DESARROLLO = "30";
	public static final String PSW_RELEASE = "tmk2Arcash06psw";
	public static final String PSW_DESARROLLO = "test1234";
	public static final String PATCH_LOGO_ARCASH_RELEASE = "https://www.arcash.com.ar/API/img/BuyIcons/Arcash_logo.png";
	public static final String PATCH_LOGO_ARCASH_DESARROLLO = "http://arcash.no-ip.biz/API/img/BuyIcons/logo.jpg";
	public static final String LINK_APROBAR_ORDEN_ARCASH_RELEASE = "https://www.arcash.com.ar/Arcashweb/Merchants/MerchantLogin.aspx";
	public static final String LINK_APROBAR_ORDEN_ARCASH_DEASRROLLO = "http://arcash.no-ip.biz/Arcashweb/Merchants/MerchantLogin.aspx";
	/*FIN-DATOS*/
	
	public static Globals getInstance() {
		return instance;
	}

	public static XMLLoader getXmlLoader() {
		return xmlLoader;
	};

	private static XMLLoader xmlLoader;

	// Clase estatica
	private Globals() {
		super();

		TmkLogger.info("Inicializando Globals...");

		try {
			// queda funcionando como hilo
			xmlLoader = new XMLLoader(Globals.DIRECTORIO_APLICACION  + "\\setup\\server.xml", this);

		} catch (Exception e) {
			// Modulo de LOG aun lo cargado
			TmkLogger.error("No se pudo inicializar el servicio de XML. Error " + e.getMessage());
			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Configuracion del Servidor",
					"Fallo al tratar de cargar el XML del servidor.");
		}

		// Carga los parametros basicos de la aplicacion
		new ParamsLoaderDaemon();

		// Control de modo del server
		new ServerModeDaemon();

		// Chequea que el server funcione
		new RevitalizerDaemon();

		/*if (((Boolean)Globals.procesosBackground.get("LimpiadorDeCarritoDaemon")).booleanValue()) {
		// Mantiene el carrito con no demasiados productos
			new LimpiadorDeCarritoDaemon();
			TmkLogger.info("LimpiadorDeCarritoDaemon inicializado");
		} else {
			TmkLogger.info("LimpiadorDeCarritoDaemon NO INICIALIZADO");
		}*/

		// lanza el demonio para mostrar la memoria
		new MemoriaDaemon();

		// Muestra informacion de conexiones actuales
		//if (Globals.esModoDebug()) new ConexionDaemon();

		// lanza demonio para mantener actualizado dollar, euro, etc.
		new CotizacionDaemon();

		// Manda mail con estadisticas
		if (((Boolean)Globals.procesosBackground.get("ReporteEstadisticasDaemon")).booleanValue()) {
			new ReporteEstadisticasDaemon();
			TmkLogger.info("ReporteEstadisticasDaemon inicializado");
		} else {
			TmkLogger.info("ReporteEstadisticasDaemon NO INICIALIZADO");
		}

		// Manda mail con estadisticas
		if (((Boolean)Globals.procesosBackground.get("ReporteEstadisticasTemporalesDaemon")).booleanValue()) {
			new ReporteEstadisticasTemporalesDaemon();
			TmkLogger.info("ReporteEstadisticasTemporalesDaemon inicializado");
		} else {
			TmkLogger.info("ReporteEstadisticasTemporalesDaemon NO INICIALIZADO");
		}


		// Lista los pedidos especiales
		if (((Boolean)Globals.procesosBackground.get("ReporteDePedidosEspecialesDaemon")).booleanValue()) {
			new ReporteDePedidosEspecialesDaemon();
			TmkLogger.info("ReporteDePedidosEspecialesDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDePedidosEspecialesDaemon NO INICIALIZADO");
		}

		// Reporte de visitas
		if (((Boolean)Globals.procesosBackground.get("ReporteVisitasDaemon")).booleanValue()) {
			new ReporteVisitasDaemon();
			TmkLogger.info("ReporteVisitasDaemon inicializado");
		} else {
			TmkLogger.info("ReporteVisitasDaemon NO INICIALIZADO");
		}


        // Reporte de Comentario
		if (((Boolean)Globals.procesosBackground.get("ReporteDeComentariosDaemon")).booleanValue()) {
            new ReporteDeComentariosDaemon();
			TmkLogger.info("ReporteDeComentariosDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeComentariosDaemon NO INICIALIZADO");
		}

		// Reporte de Socios Registrados
		if (((Boolean)Globals.procesosBackground.get("ReporteDeSociosRegistradosDaemon")).booleanValue()) {
			new ReporteDeSociosRegistradosDaemon();
			TmkLogger.info("ReporteDeSociosRegistradosDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeSociosRegistradosDaemon NO INICIALIZADO");
		}

		// Reporte de Compras por Socios
		if (((Boolean)Globals.procesosBackground.get("ReporteDeComprasPorSociosDaemon")).booleanValue()) {
			new ReporteDeComprasPorSociosDaemon();
			TmkLogger.info("ReporteDeComprasPorSociosDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeComprasPorSociosDaemon NO INICIALIZADO");
		}

		// Reporte de Compras por Alianzas
		if (((Boolean)Globals.procesosBackground.get("ReporteDeComprasPorAlianzasDaemon")).booleanValue()) {
			new ReporteDeComprasPorAlianzasDaemon();
			TmkLogger.info("ReporteDeComprasPorAlianzasDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeComprasPorAlianzasDaemon NO INICIALIZADO");
		}

        if (((Boolean)Globals.procesosBackground.get("ReporteDeMedioDeCobroDaemon")).booleanValue()) {
			// Reporte de seguimiento RIOHB
			new ReporteDeMedioDeCobroDaemon();
            TmkLogger.info("ReporteDeMedioDeCobroDaemon inicializado");
        } else {
			TmkLogger.info("ReporteDeMedioDeCobroDaemon NO INICIALIZADO");
		}

		// Reporte de Referidos x Dia
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferidosXDiaDaemon")).booleanValue()) {
			new ReporteDeReferidosXDiaDaemon();
			TmkLogger.info("ReporteDeReferidosXDiaDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeReferidosXDiaDaemon NO INICIALIZADO");
		}

		// Reporte de Referidos no Registrados (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferidosNoRegistradosDaemon")).booleanValue()) {
			new ReporteDeReferidosNoRegistradosDaemon();
			TmkLogger.info("ReporteDeReferidosNoRegistradosDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeReferidosNoRegistradosDaemon NO INICIALIZADO");
		}

		// Reporte de Referidos Registrados (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferidosRegistradosDaemon")).booleanValue()) {
			new ReporteDeReferidosRegistradosDaemon();
			TmkLogger.info("ReporteDeReferidosRegistradosDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeReferidosRegistradosDaemon NO INICIALIZADO");
		}

		// Reporte de Referidos con compra Aprobada (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferidosCompraAprobadaDaemon")).booleanValue()) {
			new ReporteDeReferidosCompraAprobadaDaemon();
			TmkLogger.info("ReporteDeReferidosCompraAprobadaDaemon inicializado");
        } else {
			TmkLogger.info("ReporteDeReferidosCompraAprobadaDaemon NO INICIALIZADO");
		}

		// Reporte de Beneficio x Referente (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferenteBeneficioDaemon")).booleanValue()) {
			new ReporteDeReferenteBeneficioDaemon();
			TmkLogger.info("ReporteDeReferenteBeneficioDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeReferenteBeneficioDaemon NO INICIALIZADO");
		}

		// Reporte de Compras x Referente (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeReferenteComprasDaemon")).booleanValue()) {
			new ReporteDeReferenteComprasDaemon();
			TmkLogger.info("ReporteDeReferenteComprasDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeReferenteComprasDaemon NO INICIALIZADO");
		}

		// Reporte de ordenes x Alianzas (mensual)
		if (((Boolean)Globals.procesosBackground.get("ReporteDeOrdenesPorAlianzaDaemon")).booleanValue()) {
			new ReporteDeOrdenesPorAlianzaDaemon();
			TmkLogger.info("ReporteDeOrdenesPorAlianzaDaemon inicializado");
		} else {
			TmkLogger.info("ReporteDeOrdenesPorAlianzaDaemon NO INICIALIZADO");
		}
/*
		if (((Boolean)Globals.procesosBackground.get("DirectorioDaemon")).booleanValue()) {
			new DirectorioDaemon();
			TmkLogger.info("DirectorioDaemon inicializado");
		} else {
			TmkLogger.info("DirectorioDaemon NO INICIALIZADO");
		}*/

	}

	public void onLoaded(FileReader fileReader) throws Exception {

		// Carga el objeto de configuracion
		Server server = Server.unmarshal(fileReader);

		SERVER = server;


		TmkLogger.info("Modo de funcionamiento: " + server.getModo());

		PAGINA_SITIO = server.getUrl();

		CONTROL_SERVER_HABILITADO = server.getControl().getHabilitado();
		CONTROL_SERVER_CONSOLA = server.getControl().getConsola();
		CONTROL_SERVER_ITERACIONES = server.getControl().getIteraciones();
		MEMORIA_ALERTA = server.getControl().getMemoriaAlerta();
		MEMORIA_MAXIMA = server.getControl().getMemoriaMaxima();
		MODO_PRE_RESET = false;    // por si entra en loop

		MODO_ELEGIDO = ModoType.valueOf(server.getModo());

		MENSAJE_MANTENIMIENTO = server.getInactividad().getMensajeMantenimiento();
		MENSAJE_PREVIO = server.getInactividad().getMensajePrevio();
		MINUTOS_DE_ANTICIPACION = server.getInactividad().getMinutosDeAnticipacion();

		MAIL_HABILITADO = server.getMailing().getHabilitado();
		MAIL_MAILER = server.getMailing().getMailer();
		MAIL_SMTP_HOST = server.getMailing().getSmtpHost();
		MAIL_WEBMASTER = server.getMailing().getWebmasterMail();
		SERVER_MAIL = server.getMailing().getServerMail();
		ENVIA_MAILS_LARGOS = server.getMailing().getMailLargos();

		INACTIVIDAD = server.getInactividad();

		ERRORRES_GPAY = server.getGPay().getErrores();

		FIDELIZACION_VIGENTE = server.getProgramaExtra().getHabilitado();

		HABILITA_CUOTAS = server.getGPay().getHabilitaCuotas();

		/* REFERIDO*/
		REFERIDO_VIGENTE = server.getProgramaReferido().getHabilitado();

        VIGENCIA_DE_REFERIDO =server.getProgramaReferido().getVigenciaReferido();

        VIGENCIA_DE_REFERENTE = server.getProgramaReferido().getVigenciaReferente();
        /* REFERIDO*/

		PROMO_CHEQUE_OBSEQUIO_VIGENTE = server.getPromoChequeObsequio().getHabilitado();

		CODIGO_CHEQUE_OBSEQUIO = server.getPromoChequeObsequio().getCodigoChequeObsequio();

		PROMO_DIA_DE_LA_MADRE_VIGENTE = server.getPromoDiaDeLaMadre().getHabilitado();

		PESOS_POR_CUPON = server.getPromoDiaDeLaMadre().getPesosPorCupon();

		/*musica on line*/
		MUSICA_ON_LINE_HABILITADO = server.getMusicaOnLine().getHabilitado();
		MUSICA_ON_LINE_SECCION = server.getMusicaOnLine().getSeccion();
		MUSICA_ON_LINE_GRUPO = server.getMusicaOnLine().getGrupo();
		MUSICA_ON_LINE_FAMILIA = server.getMusicaOnLine().getFamilia();
		MUSICA_ON_LINE_SUB_FAMILIA = server.getMusicaOnLine().getSubfamilia();
		MUSICA_ON_LINE_DISPONIBILIDAD = server.getMusicaOnLine().getDisponibilidad();
		/*musica on line  */


		BLOQUEO_IP_HABILITADO = server.getBloqueoIP().getHabilitado();

		BLOQUEO_IP_HITS = server.getBloqueoIP().getHits();

		BLOQUEO_IP_TIEMPO_ENTRE_HITS = server.getBloqueoIP().getTiempoEntreHits();

        /* Redireccion de Dominios */
		DOMINIO_PRINCIPAL = server.getDominios().getPrincipal();

		DOMINIO_SECUNDARIO = server.getDominios().getSecundario();
		/* Redireccion de Dominios */

		/*Directorio*/
		/*DIRECTORIO_HABILITADO = server.getDirectorio().getHabilitado();
		DIRECTORIO_PROX_GEN = server.getDirectorio().getProximaGeneracion();
		DIRECTORIO_DIAS_GEN = server.getDirectorio().getDiasParaGeneracion();*/
		/*Directorio*/

		//aplicacion
		MODO_APLICACION = AplicacionType.valueOf(server.getAplicacion());
        MODO_APLICACION_HABILITADO = server.getModoAplicacionHabilitado();
		DOMINIO_SITIO = server.getDominioSitio();
		DOMINIO_INTRANET = server.getDominioIntranet();
        //aplicacion

		//generacion
		GENERACION_SENTENCIA_DE_MAPEO = server.getGeneracion().getSentenciaDeMapeo();
		GENERACION_SENTENCIA_DE_DESMAPEO = server.getGeneracion().getSentenciaDeDesMapeo();
		GENERACION_DIRECTORIO = server.getGeneracion().getDirectorioDeGeneracion();
		GENERACION_DIRECTORIO_RAIZ = server.getGeneracion().getDirectorioRaiz();
		GENERACION_URL= server.getGeneracion().getUrl();

		//generacion


		for (int i=0; i<server.getProcesosBackground().getProcesoCount(); i++) {
			procesosBackground.put(server.getProcesosBackground().getProceso(i).getId(),
			                       new Boolean (server.getProcesosBackground().getProceso(i).getHabilitado()));
		}

		GPay.cambiarTerminalManager(
		        new TerminalManager(
		                server.getGPay().getHost(),
		                server.getGPay().getPort(),
		                server.getGPay().getComercio(),
		                server.getGPay().getMensaje(),
		                server.getGPay().getBaseTerminal(),
		                server.getGPay().getTiempoEsperaMaxima(),
		                server.getGPay().getCantidadDeTerminales()));

		TmkLogger.setNivelDeLog(LogType.valueOf(server.getLog()));

		// Manda un mail con la configuracion
		if (instance != null) {
			MailUtil.sendMail(
					Globals.MAIL_MAILER,
					Globals.MAIL_WEBMASTER,
					Globals.NOMBRE_DEL_SITIO + " - Configuracion del Servidor",
					"Se aplico la configuracion nueva.");
		}
	}

	public static String loadFileContent(String finDeLinea, String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			try {
				StringBuffer buffer = new StringBuffer();
				while (reader.ready()) {
					buffer.append(reader.readLine()).append(finDeLinea);
				}
				return buffer.toString();
			} finally {
				reader.close();
			}
		} catch (Exception e){
			return null;
		}
	}

	public static int[] getPaginacionesXSeccion() {
		return paginacionesXSeccion;
	}

	public static int[] getPaginacionesXFiltro() {
		return paginacionesXFiltro;
	}
		
}
