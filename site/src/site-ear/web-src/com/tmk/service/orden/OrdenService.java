/**
 * $Log: OrdenService.java,v $
 * Revision 1.4  2008/09/02 19:42:19  msartori
 * - DBO select soportando campos hijos DBO y campos hijos array de DBO
 *
 * Revision 1.3  2008/08/20 14:23:40  msartori
 * no message
 *
 * Revision 1.2  2008/08/06 14:15:57  msartori
 * Cambio manual de uso extranet
 * Comentarios visibles en articulo con ajax
 * Carga de comentarios fuera de https
 * Correcciones en generadores de feed de wishlist y comentarios
 * Metodos getALL y getALL con params en DBO
 *
 * Revision 1.1  2008/05/30 16:05:40  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.96  2007/09/03 13:41:26  msartori
 * no message
 *
 * Revision 1.95  2007/05/28 19:19:50  omsartori
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
 * Revision 1.94  2007/05/09 18:17:39  omsartori
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
 * Revision 1.93  2007/01/09 15:29:42  omsartori
 * - Correcciones en articulo. Componentes Ajax. Generador de articulos
 *
 * Revision 1.92  2006/12/19 14:36:59  omsartori
 * - Rediseño: ajustes de estilo y estructura en las homes y paginas impactadas
 *
 * Revision 1.91  2006/11/27 13:04:00  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.90  2006/11/08 15:40:57  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.89  2006/10/12 14:59:04  omsartori
 * no message
 *
 * Revision 1.88  2006/09/28 14:57:47  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.87  2006/09/14 18:24:47  omsartori
 * Promociones II
 *
 * Revision 1.86  2006/08/14 13:29:16  omsartori
 * -Emarketing doc 13
 * -Bloqueo de registro por nro de doc duplicado
 *
 * Revision 1.85  2006/05/19 14:24:27  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.84  2006/02/28 19:45:45  omsartori
 * - Fin de ReGeneracion de imagen
 * - Fin de comentarios livra
 * - Modificacion de datos para usuarios de migracion, que no pasan a central
 *
 * Revision 1.83  2005/12/29 17:45:19  omsartori
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
 * Revision 1.82  2005/12/13 16:16:38  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.81  2005/11/24 15:28:08  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.80  2005/11/14 13:47:51  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.79  2005/11/09 12:19:01  omsartori
 * - Homes estaticas, deteccion de errores en la generacion de los componentes que permite continuar generando.
 *                                Aplicado al controlador de intranet y al proceso en back.
 *                                Mail de aviso detallado.
 *                                Inclusion de componentes generados en otros archivos.
 *
 *
 * Revision 1.76  2005/10/21 21:02:58  omsartori
 * - Se agrego un sequense a ItemOrden para grabar mas de un articulo con el mismo id para una misma orden. Se modifico el EJB y la grabacion de la orden.
 *
 * Revision 1.75  2005/10/14 16:05:26  omsartori
 * - Correccion en grabacion de orden de referente
 *
 * Revision 1.73  2005/10/11 16:04:39  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.72  2005/09/22 18:38:27  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.71  2005/02/17 12:14:06  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.70  2005/01/25 15:52:20  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.69  2005/01/04 15:30:41  oGPistoia
 * - Cambio de la orden de FAX a TARJETA (visa, mast, etc) en la intranet
 * - Generación de la tapa protegida vencida en background
 * - Reporte de HBRio, Compras y socios
 *
 * Revision 1.68  2004/10/22 15:55:27  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.67  2004/10/13 20:57:14  oGPistoia
 * - Agrego puntos en el reporte de ordenes
 *
 * Revision 1.66  2004/10/08 22:50:07  oGPistoia
 * - Adaptaciones al diseño de eXtra III
 * - Bug en Nombre Receptor en componentes
 * - Interes de 0.01 por redondeo eliminado
 *
 * Revision 1.65  2004/10/05 21:29:25  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.64  2004/09/30 14:17:13  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.63  2004/09/24 18:19:15  oGPistoia
 * - Nombres y Apellidos del receptor del pedido terminado.
 *
 * Revision 1.62  2004/09/10 15:12:57  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.61  2004/08/03 15:48:26  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.60  2004/07/08 20:18:58  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.59  2004/06/30 18:23:09  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.58  2004/06/15 20:57:16  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.57  2004/05/14 19:17:47  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.56  2004/04/06 22:22:16  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.55  2004/03/25 18:18:54  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.54  2004/03/04 18:52:37  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.53  2004/02/27 13:44:35  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.52  2004/02/16 20:24:05  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.51  2004/02/11 19:33:48  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.50  2004/01/08 20:30:05  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.49  2004/01/06 15:29:37  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.48  2003/12/22 22:27:43  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.47  2003/12/15 22:07:56  GPistoia
 * -Envio de mails de pedidos especiales
 * -Metodo de pago en la aprobacion/rechazo de orden
 *
 * Revision 1.46  2003/12/11 20:53:12  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.45  2003/12/04 17:20:18  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.44  2003/11/26 15:37:55  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.43  2003/11/19 18:55:36  GPistoia
 * -Eliminacion de espacios de tarjetas
 * -Bug de no grabacion de localidad y provincia externa del socio
 * -Pantalla SSL mas pequeña
 * -Estadisticas
 * -Eventos
 *
 * Revision 1.42  2003/11/07 15:33:02  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.40  2003/10/29 19:57:24  GPistoia
 * -Correccion de queries con *
 * -Envio de mail a callcenter
 * -Correccion en promocion, nuevo campo
 * -Numero de tarjeta completo en detalle de orden
 *
 * Revision 1.39  2003/10/23 19:05:52  GPistoia
 * -Correccion de Mas vendidos
 * -Site.xml generado en español
 * -Agregado de direccion de mail para estadisticas
 *
 * Revision 1.38  2003/10/13 21:43:32  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.37  2003/10/12 22:12:18  GPistoia
 * -Funcion, Rol y Usuario
 * -EJB para Tarjeta Verificada
 * -Mejora en la ejecucion de demonios
 * -Modo Inicializacion
 * -Mails configurables.
 *
 * Revision 1.36  2003/10/09 19:30:02  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.35  2003/10/07 14:53:16  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.34  2003/10/06 14:05:39  SLizardo
 * Update Socios
 *
 * Revision 1.33  2003/10/03 16:29:50  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.32  2003/09/29 17:20:47  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.31  2003/09/24 23:13:24  GPistoia
 * -Modificacion de descuento de articulo porque puede ser positivo.
 * -Modificacion de contenido con N paginas o solapas principales
 *
 * Revision 1.30  2003/09/23 13:56:00  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.29  2003/09/19 19:49:01  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.28  2003/09/17 19:32:13  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.27  2003/09/16 19:31:06  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.26  2003/09/15 22:31:30  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.25  2003/09/11 18:09:31  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.24  2003/09/09 17:49:52  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.23  2003/09/09 13:28:34  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.22  2003/09/08 13:54:40  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.21  2003/09/05 19:57:06  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.20  2003/09/04 21:39:58  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.19  2003/09/02 19:08:32  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.18  2003/09/02 14:23:16  GPistoia
 * -Imagenes de productos grandes
 * -Campos en Articulo
 *
 * Revision 1.17  2003/08/29 17:55:02  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.16  2003/08/27 21:17:52  GPistoia
 * -Ordenes pendientes con tarjeta y sin tarjeta
 *
 * Revision 1.15  2003/08/27 18:43:56  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.14  2003/08/26 16:19:28  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.13  2003/08/22 18:11:45  GPistoia
 * -Release
 *
 * Revision 1.12  2003/08/22 14:03:58  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.11  2003/08/21 17:48:31  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.10  2003/08/15 15:59:59  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.9  2003/08/14 14:40:04  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.8  2003/08/13 18:51:54  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.7  2003/08/12 16:25:33  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.6  2003/08/08 20:13:45  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.5  2003/08/07 18:10:21  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.1  2003/08/06 21:29:28  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.3  2003/08/04 22:17:54  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.2  2003/08/02 16:58:23  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.1  2003/07/30 15:18:07  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 */
package com.tmk.service.orden;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.tmk.kernel.*;
import com.tmk.orden.*;
import com.tmk.kernel.gpay.*;
//import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.socio.SocioLocal;
//import com.tmk.socio.SocioLocalHome;
import com.tmk.src.socio.SocioPK;
import com.tmk.socio.TarjetaSocioLocalHome;
import com.tmk.xml.dm.cupon.Report;
import com.tmk.xml.orden.OrdenWrapper;
import com.tmk.bus.orden.CuponDePago;
//import com.tmk.bus.orden.NivelDeRiesgo;
//import com.tmk.bus.orden.Orden;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.fidelizacion.OrdenPorCuentaLocalHome;
import com.tmk.fidelizacion.OrdenPorCuentaLocal;
import com.tmk.src.fidelizacion.PuntajeWrapper;
import com.tmk.src.fidelizacion.FidelizacionHelper;
import com.tmk.http.ClientSocket;
import com.tmk.http.Request;

import java.sql.Connection;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.commons.beanutils.DynaBean;

public class OrdenService {
	/*ESTADOS DE ORDEN CON CUPON*/
	public static String ESTADO_APROBADO = "Aprobada";
	public static String ESTADO_SIN_INFORMACION = "Sin informacion";
	public static String ESTADO_CARGO_DIFERENTE = "Cargo Diferente";
	public static String ESTADO_PENDIENTE_DE_PAGO = "Pendiente de pago";
	public static String ESTADO_CANCELADA = "Cancelada";
	public static String ESTADO_VENCIDA = "Vencida";
	/*ESTADOS DE ORDEN CON CUPON*/

	// cache para los mas vendidos
	private static Hashtable ordenesCargadas = new Hashtable();

	/** Como el estado de la orden del dia se recarga cada vez, toda la orden se guarda
	 * en el cache durante ese dia para evitar recargarla
 	 */
	public static void borrarCacheDeOrdenes() {
		Date fecha = new Date();
		fecha.setDate(fecha.getDate() - 1);
		Enumeration keys = ordenesCargadas.keys();
		while (keys.hasMoreElements()) {
			Integer key = (Integer)keys.nextElement();
			OrdenDAO temp = (OrdenDAO)ordenesCargadas.get(key);
			if (temp != null) {
				// Si se genero hace menos de un dia la deja
				if (!fecha.before(temp.getFechaDeCierre())) {
					borrarOrdenDelCache(key);
				}
			}
		}
	}

	public static void borrarOrdenDelCache(Integer idOrden) {
		ordenesCargadas.remove(idOrden);
		TmkLogger.debug("Orden #" + idOrden + " removida del cache.");
	}

	public static void agregarOrdenAlCache(Integer idOrden, OrdenDAO ordenDAO) {
		ordenesCargadas.put(idOrden, ordenDAO);
		TmkLogger.debug("Orden #" + idOrden + " agregada al cache.");
	}

	/***
	 * CAMBIA EL ESTAO DE UNA ORDEN Y ENVIA EL MAIL AL ADMINISTRADOR
	 * @param idOrden
	 * @param nuevoEstadoOrden
	 * @param nuevoEstadoItemOrden
	 * @param usuario
	 * @throws Exception
	 */
	public static synchronized void cambiarEstadoDeOrden(
	        int idOrden,
	        EstadoOrdenDAO nuevoEstadoOrden,
	        EstadoItemOrdenDAO nuevoEstadoItemOrden, String usuario) throws Exception {

		Integer orden = new Integer(idOrden);
		boolean esSuscripcion = false;
		// saca la orden del cache para que no quede con estado viejo
		borrarOrdenDelCache(orden);

		OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
		ItemOrdenLocalHome itemOrdenLocalHome = (ItemOrdenLocalHome) DBUtil.getHome("ItemOrden");
		PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");

		OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(orden);

		if (nuevoEstadoOrden.getId().equals(Globals.ESTADO_ORDEN_INICIA_LOGISTICA.getId())
				&& (!ordenLocal.getESTADO().equals(Globals.ESTADO_ORDEN_A_CONTROL_FRAUDE.getId()) && (!ordenLocal.getESTADO().equals(Globals.ESTADO_ORDEN_DATOS_A_COMPLETAR.getId()))) ){
				TmkLogger.debug("Orden " + idOrden + " no se puede modificar de estado " + ordenLocal.getESTADO()
						+ " a estado " + Globals.ESTADO_ORDEN_INICIA_LOGISTICA);
		} else {
			// Los items quedan como estan si es nulo
			if (nuevoEstadoItemOrden != null) {
				TmkLogger.info("Orden " + idOrden + ", preparando para cambiar a " + nuevoEstadoItemOrden + "...");
				Iterator items = itemOrdenLocalHome.findArticulos(orden).iterator();
				while (items.hasNext()) {
					ItemOrdenLocal itemOrdenLocal = (ItemOrdenLocal) items.next();
					TmkLogger.info("Actualizando item " + itemOrdenLocal.getID_ORDEN() + " " + itemOrdenLocal.getITEM() + " "  + itemOrdenLocal.getID_ARTICULO());
					itemOrdenLocal.setESTADO(nuevoEstadoItemOrden.getId());
					TmkLogger.info("Item " + itemOrdenLocal.getID_ORDEN() + " " + itemOrdenLocal.getITEM() + " "  + itemOrdenLocal.getID_ARTICULO() + " nuevo estado:" + itemOrdenLocal.getESTADO());
					//Si esta en false el flag de suscriocion
					if(!esSuscripcion){
						esSuscripcion = CarritoUtil.getAriculosExcluidos().get(0).equals(itemOrdenLocal.getID_ARTICULO()); 
					}
					//fin del bloque
				}
				TmkLogger.info("Orden " + idOrden + ", items actualizados.");
			}

			// Los items quedan como estan si es nulo
			if (nuevoEstadoOrden != null) {
				TmkLogger.info("Orden " + idOrden + ", preparando para cambiar a " + nuevoEstadoOrden + "...");
				ordenLocal.setESTADO(nuevoEstadoOrden.getId());
				TmkLogger.info("Orden " + idOrden + " actualizada.");
			}

			if (nuevoEstadoOrden.esEstadoFinal()) {
				// Metodo de pago
				//Utilizado en dos medios de cobro.
				Iterator pagosOrden =  pagoOrdenLocalHome.findByIdOrden(orden).iterator();
				//Utilizado en dos medios de cobro.
				// manda mail
				String pagoOrden = "";
				while (pagosOrden.hasNext()) {
					PagoOrdenLocal pagoOrdenLocal = (PagoOrdenLocal) pagosOrden.next();
					pagoOrden = pagoOrden + "/" + MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO()).getNombre();
				}

				MailUtil.sendMail(
				        Globals.MAIL_ADMINISTRADOR,
				        Globals.MAIL_REPORTE_DE_ESTADO_DE_ORDEN,
				        Globals.NOMBRE_DEL_SITIO_ADMINISTRACION,
				        "Orden N: " + idOrden + ". " +
				        pagoOrden + ". " +
				        nuevoEstadoOrden.getNombre() + " modificada por: " + usuario);
				//BLOQUE PARA ENVIO DE MAILS CUANDO ES ORDEN DE SUSCRIPCION
				if(esSuscripcion){
					String[] destinatarios = CarritoUtil.getEmailParaAvisoDeSuscripcion();
					MailUtil.sendMail(
					        Globals.MAIL_ADMINISTRADOR,
					        destinatarios,
					        "Suscripción QUID - "+idOrden,
					        "Suscripción QUID - "+idOrden        
					);
				}
				//FIN BLOQUE
			}
		}
	}

	public static void grabarOrden(OrdenDAO ordenDAO, SocioPK socioPK) throws Exception, TarjetaPrepagaException {

			try {
				// Informativo de la cantidad de compras
				cambiarCantidadEnProcesoDeConfirmacion(+1);

				TmkLogger.debug("Cargando EJBs para grabar orden...");
				//SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
				OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
				ItemOrdenLocalHome itemOrdenLocalHome = (ItemOrdenLocalHome) DBUtil.getHome("ItemOrden");
				ItemOrdenImpuestoLocalHome itemOrdenImpuestoLocalHome = (ItemOrdenImpuestoLocalHome) DBUtil.getHome("ItemOrdenImpuesto");
				NotaRegaloLocalHome notaRegaloLocalHome = (NotaRegaloLocalHome) DBUtil.getHome("NotaRegalo");
				PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
				TarjetaOrdenLocalHome tarjetaOrdenLocalHome = (TarjetaOrdenLocalHome) DBUtil.getHome("TarjetaOrden");
				DireccionOrdenLocalHome direccionOrdenLocalHome = (DireccionOrdenLocalHome) DBUtil.getHome("DireccionOrden");

				// Numero de secuencia de la orden
				Integer idOrden = DBUtil.getSequenceValue("orden_seq");

				// COMIENZA LA CREACION DE LA ORDEN
				TmkLogger.info("Orden #" + idOrden + ": tomando datos del socio...");
				//DATOS DEL SOCIOS usando SocioLocal
				//SocioLocal socio = socioLocalHome.findByPrimaryKey(socioPK);
				//SocioPK pk = SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO);
				Socios2 socio = ServiceLocator.getSocioService().findByPK(socioPK);
				//String nombreSocio = socio.getNOMBRES();
				String nombreSocio = socio.getNombres();
				//String apellidoSocio = socio.getAPELLIDOS();
				String apellidoSocio = socio.getApellidos();
				//String email = socio.getEMAIL();
				String email = socio.getlogin();
				//Integer idSucursal = socio.getID_SUCURSAL();
				Integer idSucursal = socio.getId_sucursal();
				//Integer idSocio = socio.getID_SOCIO();
				Integer idSocio = socio.getId_socio();
				TmkLogger.info("Orden #" + idOrden + ": Socio '" + apellidoSocio + "', email '" + email + "', sucursal " + idSucursal + ", socio " + idSocio);

				TmkLogger.info("Orden #" + idOrden + ": grabando orden...");
				//creo el regristro en la tabla orden: OrdenLocal 
				
				//TODO: aplicar correccion en frontend en el refactor
				if((ordenDAO.getCupon()!=null)&&(ordenDAO.getCupon().length()>20))
					ordenDAO.setCupon(ordenDAO.getCupon().substring(0, 20));				
				
				OrdenLocal ordenLocal=null;
				try{
					ordenLocal = ordenLocalHome.create(
					        idOrden,
					        new Timestamp(new Date().getTime()),
					        new Double(Convert.round(ordenDAO.totalOriginalCompleto())),
					        Globals.ESTADO_ORDEN_EN_GENERACION.getId(), // momentaneamente queda en este estado por si falla algo.
					        idSucursal,
					        idSocio,
					        new Double(Convert.round(ordenDAO.totalSitioCompleto())),
					        ordenDAO.getTelefonoContacto(),
					        ordenDAO.getHorarioContacto(),
					        ordenDAO.getComentario(),
					        null,
					        null,
					        ordenDAO.getIdAlianza(),
					        ordenDAO.getIdSeccion(),
					        ordenDAO.getIdDominio(),
					        null,
					        ordenDAO.getNombresReceptor(),
					        ordenDAO.getApellidosReceptor(),
					        ordenDAO.getCupon(),
					        ordenDAO.getCPF_CNPJ(),
					        ordenDAO.getNRO_DOC_RECEPTOR(),
					        ordenDAO.getTIPO_DOC_RECEPTOR(),
					        ordenDAO.getRANGO_HORARIO_RECEPTOR(),
					        null
					);
				}catch(Exception e){
					String error="";
					if(idOrden!=null)
						error+=" [idOrden: "+idOrden.toString()+"] ";
					error+=" [totalOriginalCompleto: "+new Double(Convert.round(ordenDAO.totalOriginalCompleto())).toString()+"] ";
					if(idSucursal!=null)
						error+=" [idSucursal: "+idSucursal.toString()+"] ";
					if(idSocio!=null)
						error+=" [idSocio: "+idSocio.toString()+"] ";
					error+=" [totalSitioCompleto: "+new Double(Convert.round(ordenDAO.totalSitioCompleto()))+"] ";
					if(ordenDAO.getTelefonoContacto()!=null)
						error+=" [TelefonoContacto(): "+ordenDAO.getTelefonoContacto()+"] ";
					if(ordenDAO.getHorarioContacto()!=null)
						error+=" [HorarioContacto: "+ordenDAO.getHorarioContacto()+"] ";
					if(ordenDAO.getComentario()!=null)
						error+=" [Comentario: "+ordenDAO.getComentario()+"] ";
					if(ordenDAO.getIdAlianza()!=null)
						error+=" [alianza: "+ordenDAO.getIdAlianza().toString()+"] ";
					if( ordenDAO.getIdSeccion()!=null)
						error+=" [seccion: "+ ordenDAO.getIdSeccion().toString()+"] ";
					if(ordenDAO.getIdDominio()!=null)
						error+=" [dominio: "+ordenDAO.getIdDominio().toString()+"] ";
					if(ordenDAO.getNombresReceptor()!=null)
						error+=" [nomReceptor: "+ordenDAO.getNombresReceptor()+"] ";
					if(ordenDAO.getApellidosReceptor()!=null)
						error+=" [apellReceptor: "+ordenDAO.getApellidosReceptor()+"] ";
					if(ordenDAO.getCupon()!=null)
						error+=" [cupon: "+ordenDAO.getCupon()+"] ";
					if(ordenDAO.getCPF_CNPJ()!=null)
						error+=" [cpf_cnpj: "+ordenDAO.getCPF_CNPJ()+"] ";
					if(ordenDAO.getNRO_DOC_RECEPTOR()!=null)
						error+=" [docReceptor: "+ordenDAO.getNRO_DOC_RECEPTOR()+"] ";
					if(ordenDAO.getTIPO_DOC_RECEPTOR()!=null)
						error+=" [tipoDocReceptor: "+ordenDAO.getTIPO_DOC_RECEPTOR()+"] ";
					if(ordenDAO.getRANGO_HORARIO_RECEPTOR()!=null)
						error+=" [rangHorReceptor: "+ordenDAO.getRANGO_HORARIO_RECEPTOR()+"] ";
					TmkLogger.error("Error almacenando orden : "+error);
					throw e;
				}

				TmkLogger.info("Orden #" + idOrden + ": estado " + ordenDAO.getEstado().getNombre());

				// Pone los productos como los necesita comercial
				TmkLogger.info("Orden #" + idOrden + ": construyendo lista de articulos...");
				Collection<ArticuloDAO> todosLosProductosAGrabar = new Vector<ArticuloDAO>();
				//recorro la coleccion de articulos en la orden
				for (int i=0; i<ordenDAO.getArticulos().size(); i++) {
					ArticuloDAO articulo = (ArticuloDAO)ordenDAO.getArticulos().get(i);
					todosLosProductosAGrabar.add(articulo);
					//si el articulo tiene gasto de envio
					if (articulo.getGastoDeEvio() != null) {
						//lo agrego como un articulo mas a todosLosProductosAGrabar 
						todosLosProductosAGrabar.add(articulo.getGastoDeEvio());
					}
					//el papel de regalo es un articulo mas y si tiene  tambien lo agrego
					if (articulo.getPapelDeRegalo() != null) {
						todosLosProductosAGrabar.add(articulo.getPapelDeRegalo());
					}
				}
				if (ordenDAO.getInteresCobradoDAO() != null) todosLosProductosAGrabar.add(ordenDAO.getInteresCobradoDAO());

				// GRABA LOS ITEMS DE LA ORDEN, item, gasto de envio, impuesto etc..
				Iterator todosLosProductos = todosLosProductosAGrabar.iterator();
				while (todosLosProductos.hasNext()) {
					// item a grabar
					ArticuloDAO articulo = (ArticuloDAO) todosLosProductos.next();
					// articulo actual
					Integer idArticulo = new Integer(articulo.getId());
					// crea un item de orden
					TmkLogger.info("Orden #" + idOrden + ": grabando item orden " + idArticulo + "...");
					//obtiene la secuencia que le corresponde a cada item.
					Long itemOrden = DBUtil.getSequenceLong("TEMATIKA.ITEM_ORDEN_SEQ");
					itemOrdenLocalHome.create(
					        idOrden,
					        idArticulo,
					        new Integer(articulo.getCantidad()),
					        new Double(Convert.round(articulo.getPrecioOriginal())),
					        (articulo.tieneSubArticulo()) ? new Integer(articulo.getSubArticulo().getId()) : null,
					        new Double(Convert.round(articulo.getPrecioConImpuesto())),
					        new Double(Convert.round(articulo.getPrecioConDescuento())),
					        new Double(Convert.round(articulo.getPrecioPromocion())),
					        (articulo.tieneListaPVP()) ? new Integer(articulo.getListaPVP()) : null,
					        null,
					        (articulo.getIdPromo1()==0)?(Integer)null:new Integer (articulo.getIdPromo1()),
					        new Double(Convert.round(articulo.getPrecioPromocionSinImpuestos())),
							null,
					        itemOrden,
					        (articulo.getIdPromo2()==0)?(Integer)null:new Integer (articulo.getIdPromo2()),
					        (articulo.getIdPromo3()==0)?(Integer)null:new Integer (articulo.getIdPromo3()),
					        (articulo.getIdPromo4()==0)?(Integer)null:new Integer (articulo.getIdPromo4()),
					        (articulo.getIdPromo5()==0)?(Integer)null:new Integer (articulo.getIdPromo5()),
					        (articulo.getIdCampaign()==0)?(Integer)null:new Integer (articulo.getIdCampaign())

					);
					// graba los impuestos en la tabla
					TmkLogger.info("Orden #" + idOrden + ": grabando impuesto al articulo...");
					//creo(inserto) el item.
					itemOrdenImpuestoLocalHome.create(
					        idOrden,
					        idArticulo,
					        new Double(Convert.round(articulo.getTasaImpuestoGeneral())),
					        new Double(Convert.round(articulo.getValorImpuestoGeneral())),
					        new Double(Convert.round(articulo.getTasaImpuestoVideo())),
					        new Double(Convert.round(articulo.getValorImpuestoVideo())),
					        itemOrden
					);
					//Tiene Nota de regalo, inserto en "nota_regalo"
					if (articulo.tieneNota()) {
						TmkLogger.info("Orden #" + idOrden + ": grabando nota para articulo " + idArticulo + ": " + Convert.toString(articulo.getNota(), 10));
						notaRegaloLocalHome.create(
						        idOrden,
						        idArticulo,
						        articulo.getNota(),
						        itemOrden);
					}					
				}
				
				if (ordenDAO.getImporteReembolso() > 0) {
					// fix mg20130425: agrego a los items el concepto de reembolso
					// articulo concepto reembolso
					Integer idArticulo = new Integer(562477);
					//Integer idArticulo = new Integer(666);
					// crea un item de orden
					TmkLogger.info("Orden #" + idOrden + ": grabando item orden " + idArticulo + "...");
					//obtiene la secuencia que le corresponde a cada item.
					Long itemOrden = DBUtil.getSequenceLong("TEMATIKA.ITEM_ORDEN_SEQ");
					itemOrdenLocalHome.create(
					        idOrden,
					        idArticulo,
					        1,
					        new Double(Convert.round(ordenDAO.getImporteReembolso())),
					        null,
					        new Double(Convert.round(ordenDAO.getImporteReembolso())),
					        new Double(Convert.round(ordenDAO.getImporteReembolso())),
					        new Double(Convert.round(ordenDAO.getImporteReembolso())),
					        null,
					        null,
					        null,
					        new Double(Convert.round(ordenDAO.getImporteReembolso())),
							null,
					        itemOrden,
					        null,
					        null,
					        null,
					        null,
					        null
					);
				}
				//FIN GRABADO ITEM DE ORDEN
				
				// Si tiene un cupon que quede en el log
				TmkLogger.info("Orden #" + idOrden + ": el cupon usado fue [" + Convert.toString(ordenDAO.getCupon(), "Ninguno") + "]...");

				// PAGO ORDEN
				TmkLogger.info("Orden #" + idOrden + ": grabando " + ordenDAO.getMedioDeCobro() + "...");
				// Creo un pago en una sola
				TarjetaPlanDAO tarjetaPlanDAO = (ordenDAO.getTarjetaPlanDAO() == null) ? new TarjetaPlanDAO(ordenDAO.getMedioDeCobro().getId()) : ordenDAO.getTarjetaPlanDAO();

				MedioDeCobroDAO medioTarjeta = null;
				//guardo el medio de pago para esta orden
				pagoOrdenLocalHome.create(
					idOrden,
					ordenDAO.getMedioDeCobro().getId(),
					new Double(Convert.round(ordenDAO.totalSitioCompleto())),
					new Integer(tarjetaPlanDAO.getCuotas()),
					new Double(tarjetaPlanDAO.getCoeficiente()),
					new Integer(tarjetaPlanDAO.getMonedaComercial()),
					new Double(tarjetaPlanDAO.getCambio())
				);

				if (ordenDAO.getMedioDeCobro().esTarjeta()) {
					medioTarjeta = ordenDAO.getMedioDeCobro();
				}

				// si tiene direccion de envio la toma, sino graba el domicilio de la lista
				DomicilioDAO envio = ordenDAO.getAlgunDomicilioEnvio();
				TmkLogger.info("Orden #" + idOrden + ": grabando " + envio + "...");

				if (Globals.musicaOnLineHabilitado()) {
					if (envio != null) {
						direccionOrdenLocalHome.create(idOrden, envio.getSucursal(), envio.getSocio(), envio.getTipoDomicilio());
					}
				} else {
					direccionOrdenLocalHome.create(idOrden, envio.getSucursal(), envio.getSocio(), envio.getTipoDomicilio());
				}

				// graba la direccion correspondiente
				DomicilioDAO factura = ordenDAO.getDomicilioFacturacion();
				TmkLogger.info("Orden #" + idOrden + ": grabando " + factura + "...");
				direccionOrdenLocalHome.create(idOrden, factura.getSucursal(), factura.getSocio(), factura.getTipoDomicilio());

				// Graba los puntos de fidelizacion
				grabarCuentaFidelizacion(idOrden, ordenDAO);

				//Tarjeta Prepaga
				MedioDeCobroDAO medioTarjetaPrepaga = null;
				double totalConTarjetaPrepaga = 0.0;
				if (ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
					medioTarjetaPrepaga = ordenDAO.getMedioDeCobro();
					totalConTarjetaPrepaga = ordenDAO.getTotalMedioDeCobro();
				}

				if (medioTarjetaPrepaga != null) {
                    if (totalConTarjetaPrepaga > ordenDAO.getSaldoDisponible()) {
                        throw new TarjetaPrepagaException("La orden no pudo ser procesada. La tarjeta prepaga utilizadas no tiene saldo suficiente para realizar esta compra.");
                    } else {
	                    if (!ordenDAO.grabarTransaccionDeTarjetasPrepagas(idOrden.intValue())) {
                        	TmkLogger.error("TARJETA PREPAGA] Error en grabacion de transaccion. Orden " + idOrden + " " + ordenDAO.tarjetasPrepagasHabilitadasToString());
		                    throw new Exception("TARJETA PREPAGA] No se grabaron las transacciones para la orden " + idOrden);
	                    } else {
	                    	//Tengo que estar seguro de que el unico medio es tarjeta prepaga
	                    	if (ordenDAO.getMedioDeCobro() == medioTarjetaPrepaga) {
	                    	//Grabo la transaccion con prepaga, procedo a modificar el estado de la orden y los items
	                    	//para que pase directamente sin aprobacion por la intranet
	                    		Iterator items =  itemOrdenLocalHome.findArticulos(idOrden).iterator();
	                    		while (items.hasNext()) {
	                    			ItemOrdenLocal item = (ItemOrdenLocal) items.next();
	                    			item.setESTADO(Globals.ESTADOS_ITEM_ORDENES_APROBADO.getId());
	                    		}
	                    		ordenLocal.setESTADO(Globals.ESTADO_ORDEN_APROBACION_DIRECTA.getId());
	                    	}
	                    }
                    }
				}


			
				//toda la parte de GPay modificada por el doble medio de cobro
				if (medioTarjeta != null) {
					// Va a validar la tarjeta, asi que le pone el estado para marcarla
					ordenLocal.setESTADO(Globals.ESTADO_ORDEN_VALIDACION_PAGO.getId());
					//TmkLogger.debug("ESTADO " + Globals.ESTADO_ORDEN_VALIDACION_PAGO.getId());
					TmkLogger.info("Orden #" + idOrden + ": grabando Datos de TarjetaOrden..." + medioTarjeta.getId());

					TarjetaOrdenLocal tarjetaOrdenLocal = tarjetaOrdenLocalHome.create(
					        idOrden,
					        medioTarjeta.getId(),
					        ordenDAO.numeroTarjetaAGrabar(),
					        ordenDAO.getNombreCliente(),
					        null,
					        null,
					        "En proceso de validacion",
					        ordenDAO.getTipoDocumento(),
					        ordenDAO.getNumeroDocumento(),
					        ordenDAO.getDomicilioResumen(),
					        ordenDAO.getP1(),
					        ordenDAO.getP2(),
					        ordenDAO.getP3());

						// llama a la rutina de validacion de GPAY
					if (Seguridad.desencriptarTarjeta(ordenDAO.numeroTarjetaAGrabar()).equals("1234432112344321")) {
						TmkLogger.debug("TARJETA DE PRUEBA RECIBIDA");
					} else {
						TmkLogger.info("Orden #" + idOrden + ": validando tarjeta con GPAY...");
						GPay gpay = new GPay(
						        idOrden.intValue(),
						        ordenDAO.get_NumeroTarjetaCompletoDesencriptado(),
						        ordenDAO.get_CodigoSeguridad(), ordenDAO.get_MesVencimiento(), ordenDAO.get_AnoVencimiento(),
						        ordenDAO.totalSitioCompleto(),
						        tarjetaPlanDAO);
						try {
	// ESTE BLOQUE TIENE QUE SER LO MAS CERRADO POSIBLE
							// controla que gpay lo apruebe
							validarGPay(gpay);

							// Si logró comprar cambia el estado porque la orden es válida
							ordenLocal.setESTADO(ordenDAO.getEstado().getId());
	// ESTE BLOQUE TIENE QUE SER LO MAS CORTO POSIBLE

						} finally {
							TmkLogger.info("Orden #" + idOrden + ": grabando Codigos de GPAY...");

							Integer respuesta  = new Integer(gpay.getCodigoRespuesta());
							Integer autorizacion = new Integer(gpay.getCodigoAutorizacion());
							String mensajeRespuesta = gpay.getMensajeRespuesta();

							tarjetaOrdenLocal.setCODIGO_RESPUESTA(respuesta);
							tarjetaOrdenLocal.setCODIGO_AUTORIZACION(autorizacion);
							tarjetaOrdenLocal.setMENSAJE_GPAY(mensajeRespuesta);

							ordenDAO.setGpayInfo(respuesta, autorizacion, mensajeRespuesta);
						}
					}
				} else if (ordenDAO.getMedioDeCobro().requiereCuponDePago()) {
					//ORDENES DM Cupon de pago
					Connection conn = DBUtil.buildConnection();
					try {
						CuponDePago cupon = new CuponDePago();
						cupon.setIdOrden(idOrden);
						cupon.update(conn);
//						cambio estado para ordenes que No son con Tarjeta de credito
						ordenLocal.setESTADO(ordenDAO.getEstado().getId());
					} catch (Exception e) {
						throw new Exception ("Error asignando cupon de pago " + e.toString() + MainHelper.getMessage(e));
					} finally {
						conn.close();
					}
				} else {
					//cambio estado para ordenes que No son con Tarjeta de credito
					ordenLocal.setESTADO(ordenDAO.getEstado().getId());
				}



			    TmkLogger.info("Orden #" + idOrden + ": cerrando orden...");
				//TmkLogger.debug("ESTADO " + ordenDAO.getEstado().getId());
				TmkLogger.info("Orden #" + idOrden + " procesada.");

				// No permito grabar la orden de nuevo
				ordenDAO.cerrarDatosDeCompra(idOrden.intValue(), new Date(), Convert.nombreCompleto(nombreSocio, apellidoSocio), email);

				// La guarda en el cache asi no la recarga para el mail
				//agregarOrdenAlCache(idOrden, ordenDAO);

				// Manda un mail, con texto por default en caso de error
				MailUtil.sendMail(
				        Globals.MAIL_CALL_CENTER,
				        email,
				        " Compra en " + Globals.NOMBRE_DEL_SITIO,
				        "Su compra ha sido recibida y comenzará a ser procesada a la brevedad. Muchas Gracias.",
				        "/mailing/confirmacionDeOrden.jsp?idOrden=" + idOrden);


				// borra lo que compre del carrito para que no aparezca otra vez
				borrarProductosComprados(ordenDAO, socioPK);

				// guarda las tarjetas que se usaron en la compra
				if (medioTarjeta != null) {
					grabarTarjetaUsada(ordenDAO, socioPK, medioTarjeta);
				}

				// Ordenes grabadas correctamente
				cambiarCantidadOrdenesGeneradas();
			}

			 catch (TarjetaPrepagaException e) {
                cambiarCantidadOrdenesDesaprobadas();
				throw e;
			}
			 catch (GPayException e) {
				// Ordenes con problemas de grabacion
				cambiarCantidadOrdenesDesaprobadas();
				throw e;
			}
			 catch (Exception e) {
				// Ordenes con problemas de grabacion
				cambiarCantidadOrdenesAbortadas();

				TmkLogger.error("Orden Error " + e.toString() + e.getMessage());

				MailUtil.sendMail(
				        Globals.MAIL_MAILER,
				        Globals.MAIL_WEBMASTER,
				        "Error al grabar la orden",
				        e.toString() + MainHelper.getMessage(e));

				throw new Exception("La orden no pudo ser procesada. Intente más tarde.");
			} finally {
				// Informativo de la cantidad de compras
				cambiarCantidadEnProcesoDeConfirmacion(-1);
			}

		}

	/**
	 * No pueden entrar a validar la misma orden
	 */
	public static synchronized void cerrarOrdenConTarjeta(OrdenDAO ordenDAO, MedioDeCobroDAO nuevoMedioDeCobro, String usuario) throws GPayException, Exception {

		Integer orden = new Integer(ordenDAO.getIdOrdenProcesada());

		// Limpia el cache para que sean recargadas a la fuerza
		borrarOrdenDelCache(orden);

		TmkLogger.info("[Manual] Carga datos de Orden...");
		OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
		OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(orden);
		PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
		String idMedioCobro = ordenDAO.getMedioDeCobro().getId();
		
		TmkLogger.info("[Manual] Medio de Pago actual: " + idMedioCobro);
		TmkLogger.info("[Manual] Medio de Pago nuevo: " + nuevoMedioDeCobro);

		PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByPrimaryKey(new PagoOrdenPK(orden, idMedioCobro));

		TarjetaOrdenLocalHome tarjetaOrdenLocalHome = (TarjetaOrdenLocalHome) DBUtil.getHome("TarjetaOrden");

		EstadoOrdenDAO nuevoEstadoOrden = Globals.ESTADO_ORDEN_A_CONTROL_FRAUDE;
		EstadoItemOrdenDAO nuevoEstadoItemOrden = nuevoEstadoOrden.estadoItemsRelacionado();

		// Controla que la orden no haya sido autorizada para evitar doble cargo al usuario
		if (nuevoEstadoOrden.getId().equalsIgnoreCase(ordenLocal.getESTADO())) throw new Exception("Orden ya autorizada.");

		TmkLogger.info("[Manual] El proximo estado de orden es " + nuevoEstadoOrden + "...");
		TmkLogger.info("[Manual] El proximo estado de items de orden es " + nuevoEstadoItemOrden + "...");

		// Crea el plan de pago estandar
		TarjetaPlanDAO tarjetaPlanDAO = new TarjetaPlanDAO(ordenDAO.getMedioDeCobro().getId());

		TmkLogger.info("[Manual] Validando tarjeta con GPAY...");

		GPay gpay = new GPay(
		        ordenDAO.getIdOrdenProcesada(),
		        ordenDAO.get_NumeroTarjetaCompletoDesencriptado(),
		        ordenDAO.get_CodigoSeguridad(),
		        ordenDAO.get_MesVencimiento(),
		        ordenDAO.get_AnoVencimiento(),
		        ordenLocal.getTOTAL().doubleValue(),
		        // Agregado para cuotas. Por ahora solo 1 porque no se esta usando esta pantalla.
		        tarjetaPlanDAO);

/* ESTE BLOQUE TIENE QUE SER LO MAS CORTO POSIBLE */
		// realiza la validacion real
		validarGPay(gpay);

		// La elimina de los reportes por si hubo algun problema
		ordenLocal.setESTADO(Globals.ESTADO_ORDEN_EN_GENERACION.getId());

/* ESTE BLOQUE TIENE QUE SER LO MAS CORTO POSIBLE */

		// Cambio el medio de pago antes que poner la tarjeta
		TmkLogger.info("[Manual] Cambia el modo de pago para que pueda facturarse en comercial...");
		// Crea el medio de pago
		PagoOrdenLocal pagoOrdenLocalNuevo = pagoOrdenLocalHome.create(
		        pagoOrdenLocal.getID_ORDEN(),
		        nuevoMedioDeCobro.getId(),
		        pagoOrdenLocal.getIMPORTE(),
		        pagoOrdenLocal.getCUOTAS(),
		        pagoOrdenLocal.getCOEFICIENTE(),
		        pagoOrdenLocal.getMONEDA(),
		        pagoOrdenLocal.getCAMBIO());

		TmkLogger.info("[Manual] Grabando Codigos de GPAY...");
		tarjetaOrdenLocalHome.create(
		        orden,
		        nuevoMedioDeCobro.getId(),
		        ordenDAO.numeroTarjetaAGrabar(),
		        ordenDAO.getNombreCliente(),
		        new Integer(gpay.getCodigoRespuesta()),
		        new Integer(gpay.getCodigoAutorizacion()),
		        gpay.getMensajeRespuesta(),
		        ordenDAO.getTipoDocumento(),
		        ordenDAO.getNumeroDocumento(),
		        ordenDAO.getDomicilioResumen(),
		        ordenDAO.getP1(),
		        ordenDAO.getP2(),
		        ordenDAO.getP3());

		// Borra el viejo
		pagoOrdenLocal.remove();

		// le cambia el estado a la orden y a sus items una vez autorizada
		TmkLogger.info("[Manual] Cambia el estado de la orden e items...");
		cambiarEstadoDeOrden(ordenDAO.getIdOrdenProcesada(), nuevoEstadoOrden, nuevoEstadoItemOrden, usuario);

	}

	private static void validarGPay(GPay gpay) throws GPayException {

		String titulo = null;

		try {
			// Lleva un track de los que estan comprando
			cambiarCantidadEnProcesoDeAutorizacion(+1);

			// sale por excepcion si no fue aprobada
			gpay.autorizar();

			titulo = "Tarjeta Autorizada.";

		} catch (GPayException e) {

			titulo = "Tarjeta NO aprobada.";

			// Pone el mensaje por default
			e.setMensajeAMostrar(Globals.ERRORRES_GPAY.getMensajePorDefecto());

			// Comprueba si ocurrio algun error
			for (int i = 0; i < Globals.ERRORRES_GPAY.getErrorCount(); i++) {
				com.tmk.kernel.server.Error errorGPAY = Globals.ERRORRES_GPAY.getError(i);
				if (errorGPAY.getCodigo() == gpay.getCodigoRespuesta()) {
					// Toma el mensaje nuevo si tiene
					if (errorGPAY.getMensajeAMostrar() != null) {
						e.setMensajeAMostrar(errorGPAY.getMensajeAMostrar());
					}
					// Toma la lista de mensajes a enviar
					if (errorGPAY.getEmailCount() > 0) {
						String emails[] = new String[errorGPAY.getEmailCount()];
						for (int j = 0; j < errorGPAY.getEmailCount(); j++) {
							emails[j] = errorGPAY.getEmail(j);
						}
						// Log
						TmkLogger.info("Se envia mail por error " + gpay.mensajeProceso());
						// manda mail
						MailUtil.sendMail(Globals.MAIL_MAILER, emails, titulo, gpay.mensajeProceso() + " (" + e.getMensajeAMostrar() + "");
					}
					// no necesita seguir iterando porque ya mando mail
					break;
				}
			}

			// relanza la exception y aborta el proceso de compra
			throw e;

		} finally {
			// Lleva un track de los que estan comprando
			cambiarCantidadEnProcesoDeAutorizacion(-1);
			// Loguea el error
			TmkLogger.info(gpay.mensajeProceso());
			// manda siempre mail por cada proceso
			MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, titulo, gpay.mensajeProceso());
		}
	}

	private static int enProcesoDeConfirmacion = 0;

	private static synchronized void cambiarCantidadEnProcesoDeConfirmacion(int delta) {
		enProcesoDeConfirmacion = enProcesoDeConfirmacion + delta;
	}

	private static int enProcesoDeAutorizacion = 0;

	private static synchronized void cambiarCantidadEnProcesoDeAutorizacion(int delta) {
		enProcesoDeAutorizacion = enProcesoDeAutorizacion + delta;
	}

	private static int ordenesGeneradas = 0;

	private static synchronized void cambiarCantidadOrdenesGeneradas() {
		ordenesGeneradas = ordenesGeneradas + 1;
	}

	private static int ordenesAbortadas = 0;

	private static synchronized void cambiarCantidadOrdenesAbortadas() {
		ordenesAbortadas = ordenesAbortadas + 1;
	}

	private static int ordenesDesaprobadas = 0;

	private static synchronized void cambiarCantidadOrdenesDesaprobadas() {
		ordenesDesaprobadas = ordenesDesaprobadas + 1;
	}

	public static int cantidadEnProcesoDeConfirmacion() {
		return enProcesoDeConfirmacion;
	}

	public static int cantidadEnProcesoDeAutorizacion() {
		return enProcesoDeAutorizacion;
	}

	public static int cantidadOrdenesGeneradas() {
		return ordenesGeneradas;
	}

	public static int cantidadOrdenesAbortadas() {
		return ordenesAbortadas;
	}

	public static int cantidadOrdenesDesaprobadas() {
		return ordenesDesaprobadas;
	}

	public static OrdenDAO cargarOrdenANTERIOR(int numeroOrden) throws Exception {

		Integer idOrden = new Integer(numeroOrden);

		// Como es un poco lento prefiero cargarlo del cache
		OrdenDAO ordenDAO = (OrdenDAO)ordenesCargadas.get(idOrden);
		if (ordenDAO != null) {
			TmkLogger.debug("Orden #" + idOrden + " recuperada del cache.");

			// Refresca el estado para que no quede mal
			OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
			OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(idOrden);
			ordenDAO.setIdEstado(ordenLocal.getESTADO());
			return ordenDAO;
		}

		// Se prepara a cargar la orden
		ordenDAO = new OrdenDAO(numeroOrden);

		TmkLogger.debug("Orden #" + idOrden + ". Cargando EJBs para cargar orden...");

		OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
		ItemOrdenLocalHome itemOrdenLocalHome = (ItemOrdenLocalHome) DBUtil.getHome("ItemOrden");
		//SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
		NotaRegaloLocalHome notaRegaloLocalHome = (NotaRegaloLocalHome) DBUtil.getHome("NotaRegalo");
		PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
		TarjetaOrdenLocalHome tarjetaOrdenLocalHome = (TarjetaOrdenLocalHome) DBUtil.getHome("TarjetaOrden");
		DireccionOrdenLocalHome direccionOrdenLocalHome = (DireccionOrdenLocalHome) DBUtil.getHome("DireccionOrden");

		TmkLogger.info("Orden #" + idOrden + ". Cargando orden historica...");
		OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(idOrden);
		Integer idSucursal = ordenLocal.getID_SUCURSAL_SOCIO();
		Integer idSocio = ordenLocal.getID_SOCIO();
		ordenDAO.setAlianza(ordenLocal.getID_ALIANZA(), ordenLocal.getID_SECCION());
		ordenDAO.setIdDominio(ordenLocal.getID_DOMINIO());
		ordenDAO.setNivelDeRiesgo(NivelDeRiesgoDAO.buscaNivelDeRiesgo(ordenLocal.getNIVEL_RIESGO()));
		ordenDAO.setMotivoDeRiesgo(ordenLocal.getMOTIVO_RIESGO());
		ordenDAO.setNombresReceptor(ordenLocal.getNOMBRES_RECEPTOR());
		ordenDAO.setApellidosReceptor(ordenLocal.getAPELLIDOS_RECEPTOR());
        ordenDAO.setCupon(ordenLocal.getCUPON());
		ordenDAO.setCPF_CNPJ(ordenLocal.getCPF_CNPJ());
		ordenDAO.setTIPO_DOC_RECEPTOR(ordenLocal.getTIPO_DOC_RECEPTOR());
		ordenDAO.setNRO_DOC_RECEPTOR(ordenLocal.getNRO_DOC_RECEPTOR());
		ordenDAO.setRANGO_HORARIO_RECEPTOR(ordenLocal.getRANGO_HORARIO_RECEPTOR());

		if (ordenDAO.tieneOtroReceptor()) {
			TmkLogger.debug("Orden #" + idOrden + ". Destinatario: " + Convert.nombreCompleto(ordenDAO.getNombresReceptor(), ordenDAO.getApellidosReceptor()));
		}

		//PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByIdOrden(idOrden);
		//Lo tengo que hacer antes del bloque de medio de cobro porque ahora son dos
		//y la asignacion la resuelvo abajo.
		ordenDAO.completarDatosMedioDeCobro(
		        ordenLocal.getTELEFONO(), ordenLocal.getHR_CONTACTO(), ordenLocal.getCOMENTARIOS(),
		        null,
		        ordenLocal.getESTADO());

		///Utilizado en dos medios de cobro.
		Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(idOrden).iterator();

		PagoOrdenLocal pagoOrdenLocal = (PagoOrdenLocal) pagosOrden.next();
		PagoOrdenLocal pagoTarjeta = null;
		MedioDeCobroDAO medioDeCobroDAO1 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());
		if (medioDeCobroDAO1.esTarjeta()) {
			pagoTarjeta = pagoOrdenLocal;
		}
		//MedioDeCobroDAO medioDeCobroDAO2 = null;
        MedioDeCobroDAO medioTarjeta = null;

		/*if (pagosOrden.hasNext()) {
			pagoOrdenLocal = (PagoOrdenLocal) pagosOrden.next();
            medioDeCobroDAO2 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());
			if (medioDeCobroDAO2.esTarjeta()) {
				pagoTarjeta = pagoOrdenLocal;
			}
		}*/

		/*medioTarjeta = (medioDeCobroDAO1.esTarjeta())? medioDeCobroDAO1: (medioDeCobroDAO2 != null) ? (medioDeCobroDAO2.esTarjeta())?
		            medioDeCobroDAO2: null:null;*/
		
		medioTarjeta = (medioDeCobroDAO1.esTarjeta())? medioDeCobroDAO1: null;

		if (medioTarjeta != null) {
			TmkLogger.debug("Orden #" + idOrden + ". Cargando tarjeta...");
			TarjetaOrdenPK tarjetaOrdenPK = new TarjetaOrdenPK();
			tarjetaOrdenPK.ID_ORDEN = idOrden;
			tarjetaOrdenPK.ID_MEDIO_COBRO = medioTarjeta.getId();
			TarjetaOrdenLocal tarjetaOrdenLocal = tarjetaOrdenLocalHome.findByPrimaryKey(tarjetaOrdenPK);

			ordenDAO.completarDatosTarjeta(
			        Seguridad.desencriptarTarjeta(tarjetaOrdenLocal.getNRO_TARJETA()),
			        null, 01, 2000,
			        tarjetaOrdenLocal.getNOMBRE_CLIENTE(),
			        (tarjetaOrdenLocal.getTIPO_DOC() == null) ? Globals.TIPO_DOCUMENTO_DNI.getId() : tarjetaOrdenLocal.getTIPO_DOC(),
			        (tarjetaOrdenLocal.getNRO_DOC() == null) ? 0 : tarjetaOrdenLocal.getNRO_DOC().longValue(),
			        tarjetaOrdenLocal.getDIRECCION_RESUMEN(),
			        medioTarjeta,
			        ordenLocal.getESTADO());

			ordenDAO.setGpayInfo(
			        tarjetaOrdenLocal.getCODIGO_RESPUESTA(),
			        tarjetaOrdenLocal.getCODIGO_AUTORIZACION(),
			        tarjetaOrdenLocal.getMENSAJE_GPAY());


			ordenDAO.setTarjetaPlanDAO(
			        new TarjetaPlanDAO(
			                medioTarjeta.getId(),
			                pagoTarjeta.getCUOTAS().intValue(),
			                pagoTarjeta.getMONEDA().intValue(),
			                pagoTarjeta.getCOEFICIENTE().doubleValue()
			                ));
		}

		ordenDAO.setMedioDeCobro(medioDeCobroDAO1);

		//Tarjeta Prepaga
        if (ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
	        ordenDAO.setTarjetasPrepagasDeLaOrden(ordenDAO.getIdOrdenProcesada());
        }
		//Tarjeta Prepaga

		TmkLogger.debug("Orden #" + idOrden + ". Cargando items...");
		Vector<ArticuloDAO> sinPapeles = new Vector<ArticuloDAO>();
		Vector<Pair> conPapeles = new Vector<Pair>();
		Vector<Integer> papeles = new Vector<Integer>();
		Vector<ArticuloDAO> todos = new Vector<ArticuloDAO>();
		Iterator items = itemOrdenLocalHome.findArticulos(idOrden).iterator();

		GastosEnvioDAO gastoDeEnvioBasico = null;
		GastosEnvioDAO gastoDeEnvioAdicional = null;

		//Vector articulos = new Vector();
		//Vector gastos = new Vector();
		//Vector papeles = new Vector();


		while (items.hasNext()) {
			ItemOrdenLocal itemOrdenLocal = (ItemOrdenLocal) items.next();

			ArticuloDAO articuloDAO = new ArticuloDAO(
			        itemOrdenLocal.getID_ARTICULO().intValue(),
			        itemOrdenLocal.getCANTIDAD().intValue());
			// En algunas ordenes migradas dio error, prefiero continuar con precio actual
			try {
				articuloDAO.cargar(
				        articuloDAO.getId(),
				        articuloDAO.getTitulo(),
				        articuloDAO.getCategoriaSeccion(),
				        articuloDAO.getCategoriaGrupo(),
				        articuloDAO.getCategoriaFamilia(),
				        articuloDAO.getCategoriaSubFamilia(),
				        itemOrdenLocal.getPRECIO_ORIGINAL().doubleValue(),
				        itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(),
				        itemOrdenLocal.getPRECIO_UNITARIO().doubleValue(),
				        itemOrdenLocal.getPRECIO_PROMOCION().doubleValue(),
				        0,
				        Convert.porcentajeAplicado(itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(), itemOrdenLocal.getPRECIO_UNITARIO().doubleValue()),
				        itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue() < itemOrdenLocal.getPRECIO_UNITARIO().doubleValue(),
				        itemOrdenLocal.getPRECIO_UNITARIO().doubleValue() - itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(),
				        Convert.porcentajeAplicado(itemOrdenLocal.getPRECIO_ORIGINAL().doubleValue(), itemOrdenLocal.getPRECIO_UNITARIO().doubleValue()),
				        0.0,
				        articuloDAO.getCodExtVisual(),
				        articuloDAO.getIdDisponibilidad(),
				        true);

				// En que estado esta el articulo
				articuloDAO.setIdEstadoItem(itemOrdenLocal.getESTADO());

				if ((itemOrdenLocal.getID_PROMOCION() != null) && (itemOrdenLocal.getPRECIO_PROMOCION() != null)) {
					//COMENTADO PROMO II
					/*articuloDAO.setPrecioPromocionFinal(
					        itemOrdenLocal.getPRECIO_PROMOCION().doubleValue(),
					        itemOrdenLocal.getID_PROMOCION().intValue(),
					        Promocion.consultaNombreDePromocion(itemOrdenLocal.getID_PROMOCION().intValue()));*/
					//REEMPLAZO PROMO II
					articuloDAO.setPrecioPromocionSinImpuestos(itemOrdenLocal.getPRECIO_PROMOCION_SIN_IMPUESTOS().doubleValue());
				}


			} catch (Exception e) {
				TmkLogger.error("Orden #" + idOrden + ". No se pudo cargar un articulo historico " + itemOrdenLocal.getID_ARTICULO());
			}

			if (articuloDAO.esGastoDeEnvio()) {
				// crea el objeto para el gasto
				GastosEnvioDAO gastosDeEnvioDAO = new GastosEnvioDAO(articuloDAO.getId(), itemOrdenLocal.getCANTIDAD().intValue());

				// genera un articulo gasto de envio generico
				//COMENTADO PROMO II
				/*gastosDeEnvioDAO.setPrecioPromocionFinal(
				        (itemOrdenLocal.getPRECIO_PROMOCION() == null) ? 0 : itemOrdenLocal.getPRECIO_PROMOCION().doubleValue(),
				        (itemOrdenLocal.getID_PROMOCION() == null) ? 0 : itemOrdenLocal.getID_PROMOCION().intValue(),
				        (itemOrdenLocal.getID_PROMOCION() == null) ? null : Promocion.consultaNombreDePromocion(itemOrdenLocal.getID_PROMOCION().intValue()));
	        	*/
				//REEMPLAZO PROMO II
				gastosDeEnvioDAO.setPrecioPromocionSinImpuestos(itemOrdenLocal.getPRECIO_PROMOCION_SIN_IMPUESTOS().doubleValue());
				// Le setea el precio tal como lo hace la promocion, para evitar diferencias
				gastosDeEnvioDAO.setPrecio((itemOrdenLocal.getPRECIO_PROMOCION() == null) ? 0 : itemOrdenLocal.getPRECIO_PROMOCION().doubleValue());

				// Si ya tiene gasto de envio basico, entonces es el adicional
				if ((gastoDeEnvioBasico == null)) {
					gastoDeEnvioBasico = gastosDeEnvioDAO;
					//ordenDAO.setGastoDeEnvioBasico(gastosDeEnvioDAO);
				} else {
					//ordenDAO.setGastoDeEnvioAdicional(gastosDeEnvioDAO);
					gastoDeEnvioAdicional = gastosDeEnvioDAO;
				}

			} else if (articuloDAO.esInteresCobrado()) {
				// crea el objeto para representar el interes
				InteresCobradoDAO interesCobradoDAO = new InteresCobradoDAO(articuloDAO.getId());
				// Le pone el precio como dice
				interesCobradoDAO.setPrecio((itemOrdenLocal.getPRECIO_PROMOCION() == null) ? 0 : itemOrdenLocal.getPRECIO_PROMOCION().doubleValue());
				// Guardar el producto
				ordenDAO.setInteresCobradoDAO(interesCobradoDAO);

			} else {

				// Guardar el articulo
				todos.add(articuloDAO);

				if (itemOrdenLocal.getID_PAPEL_REGALO() == null) {
					// En lista de los que no tienen papel
					sinPapeles.add(articuloDAO);

				} else {
					// cuales tienen papel
					conPapeles.add(new Pair(articuloDAO, itemOrdenLocal.getID_PAPEL_REGALO()));
					// el papel en si
					papeles.add(itemOrdenLocal.getID_PAPEL_REGALO());
				}
			}
		}



		TmkLogger.debug("Orden #" + idOrden + ". Cargando " + todos.size() + " articulos en la orden");

		for (int i = 0; i < todos.size(); i++) {
			ArticuloDAO articuloDAO = (ArticuloDAO) todos.get(i);
			if (!papeles.contains(new Integer(articuloDAO.getId()))) {
				ordenDAO.addArticulo(articuloDAO, null);
			}
		}

		ordenDAO.setGastoDeEnvioBasico(gastoDeEnvioBasico);

		ordenDAO.setGastoDeEnvioAdicional(gastoDeEnvioAdicional);


		for (int i = 0; i < conPapeles.size(); i++) {
			Pair pair = (Pair) conPapeles.get(i);
			ArticuloDAO articuloDAO = (ArticuloDAO) pair.getValue1();
			Integer idPapel = (Integer) pair.getValue2();
			for (int j = 0; j < todos.size(); j++) {
				ArticuloDAO currentDAO = (ArticuloDAO) todos.get(j);
				if (currentDAO.getId() == idPapel.intValue()) {
					articuloDAO.setSubArticulo(currentDAO);
					TmkLogger.debug("Orden #" + idOrden + ". Cargando papel " + articuloDAO);
					break;
				}
			}
		}

		Iterator direcciones = direccionOrdenLocalHome.findByOrden(idOrden).iterator();
		while (direcciones.hasNext()) {
			DireccionOrdenLocal direccionOrdenLocal = (DireccionOrdenLocal) direcciones.next();
			DomicilioDAO domicilioDAO = DomicilioDAO.load(idSucursal, idSocio, direccionOrdenLocal.getTIPO_DOMICILIO());
			TmkLogger.debug("Orden #" + idOrden + ". Cargando " + domicilioDAO);
			if (domicilioDAO.esEnvio()) {
				ordenDAO.setDomicilioEnvio(domicilioDAO);
			}
			if (domicilioDAO.esFacturacion()) {
				ordenDAO.setDomicilioFacturacion(domicilioDAO);
			}
		}

		Iterator notas = notaRegaloLocalHome.findAllByOrden(idOrden).iterator();
		while (notas.hasNext()) {
			NotaRegaloLocal notaRegaloLocal = (NotaRegaloLocal) notas.next();
			for (int i = 0; i < todos.size(); i++) {
				ArticuloDAO articuloDAO = (ArticuloDAO) todos.get(i);
				if (articuloDAO.getId() == notaRegaloLocal.getID_ARTICULO().intValue()) {
					articuloDAO.setNota(notaRegaloLocal.getNOTA_REGALO());
					TmkLogger.debug("Orden #" + idOrden + ". Cargando nota " + Convert.toString(articuloDAO.getNota(), 15));
					break;
				}
			}
		}

		// carga datos del socio
		SocioPK socioPK = new SocioPK(ordenLocal.getID_SUCURSAL_SOCIO(), ordenLocal.getID_SOCIO());
		//SocioLocal socioLocal = socioLocalHome.findByPrimaryKey(socioPK);
		Socios2 socioLocal = ServiceLocator.getSocioService().findByPrimaryKey(new com.tmk.src.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));

		// No permito grabar la orden de nuevo
		ordenDAO.cerrarDatosDeCompra(
		        idOrden.intValue(), ordenLocal.getFECHA(),
		        //Convert.nombreCompleto(socioLocal.getNOMBRES(), socioLocal.getAPELLIDOS()),
		        Convert.nombreCompleto(socioLocal.getNombres(), socioLocal.getApellidos()),
		        //socioLocal.getEMAIL());
		        socioLocal.getlogin());

		// Para la parte de puntos
		cargarCuentaFidelizacion(ordenDAO);

		TmkLogger.debug("Orden #" + idOrden + ". Fecha de cierre: " + ordenDAO.getFechaDeCierre());

		// Guarda la orden en el cache para no recargarla
		agregarOrdenAlCache(idOrden, ordenDAO);

		return ordenDAO;
	}

	public static Enumeration ordenarListadoDeOrdenes(Collection collection) {

		class Ordenador implements Comparator {

			public int compare(Object o1, Object o2) {
				// va al reves
				return ((OrdenLocal) o2).getID_ORDEN().intValue() - ((OrdenLocal) o1).getID_ORDEN().intValue();
			}

			public boolean equals(Object obj) {
				return false;
			}
		}

		Vector<OrdenLocal> temp = new Vector<OrdenLocal>();
		Iterator iterator = collection.iterator();
		while (iterator.hasNext()) {
			OrdenLocal ordenLocal = (OrdenLocal) iterator.next();
			temp.add(ordenLocal);
		}

		Collections.sort(temp, new Ordenador());

		return temp.elements();
	}

	private static void borrarProductosComprados(OrdenDAO ordenDAO, SocioPK socioPK) {
		try {
			CarritoCompraLocalHome carritoCompraLocalHome = (CarritoCompraLocalHome) DBUtil.getHome("CarritoCompra");

			// borra el carrito persistente, si da error lo ignora
			for (int i = 0; i < ordenDAO.getArticulos().size(); i++) {
				// carga el producto
				CarritoCompraPK carritoCompraPK = new CarritoCompraPK();
				carritoCompraPK.ID_SUCURSAL_SOCIO = socioPK.ID_SUCURSAL;
				carritoCompraPK.ID_SOCIO = socioPK.ID_SOCIO;
				carritoCompraPK.ID_ARTICULO = new Integer(ordenDAO.getArticulo(i).getId());

				CarritoCompraLocal carritoCompraLocal = carritoCompraLocalHome.findByPrimaryKey(carritoCompraPK);

				carritoCompraLocal.remove();
			}

		} catch (Exception e) {
			// ignora el error
			TmkLogger.error("No se pudo borrar el articulo comprado en la orden " + ordenDAO.getIdOrdenProcesada());
		}
	}

	private static void grabarTarjetaUsada(OrdenDAO ordenDAO, SocioPK socioPK, MedioDeCobroDAO medioDeCobro) {
		try {
			// no grabar tarjetas ya grabadas
			if (ordenDAO.esTarjetaNueva()) {

				TarjetaSocioLocalHome tarjetaSocioLocalHome = (TarjetaSocioLocalHome) DBUtil.getHome("TarjetaSocio");

				// necesita un sequence por tarjeta
				Integer itemTarjetaSocio = DBUtil.getNuevoItemTarjetaSocio(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO);

				TmkLogger.debug("Grabando Datos de TarjetaSocio para Item " + itemTarjetaSocio + "...");
				tarjetaSocioLocalHome.create(
				        socioPK.ID_SUCURSAL,
				        socioPK.ID_SOCIO,
				        itemTarjetaSocio,
				        //ordenDAO.getMedioDeCobro().getId(),
				        medioDeCobro.getId(),
				        ordenDAO.numeroTarjetaAGrabar(),
				        ordenDAO.getNombreCliente(),
				        ordenDAO.getTipoDocumento(),
				        ordenDAO.getNumeroDocumento(),
				        ordenDAO.getDomicilioResumen());
			}
		} catch (Exception e) {
			// ignora el error
			TmkLogger.error("No se pudo grabar la tarjeta usada en la orden " + ordenDAO.getIdOrdenProcesada());
		}
	}

	private static void grabarCuentaFidelizacion(Integer idOrden, OrdenDAO ordenDAO) {
		if (Globals.FIDELIZACION_VIGENTE) {
			com.tmk.fidelizacion.PuntajeWrapper puntajeWrapper = ordenDAO.getPuntajeWrapper();
			if (puntajeWrapper == null) {
				TmkLogger.debug("La orden no tiene tarjeta eXtra");

			} else {
				try {
					OrdenPorCuentaLocalHome ordenPorCuentaLocalHome = (OrdenPorCuentaLocalHome) DBUtil.getHome("OrdenPorCuenta");
					ordenPorCuentaLocalHome.create(
							idOrden,
							new Integer(puntajeWrapper.getIdSucursalSocio()),
							new Integer(puntajeWrapper.getIdSocio()),
							new Integer(puntajeWrapper.getIdSucursalCuenta()),
							new Integer(puntajeWrapper.getIdCuenta()),
							puntajeWrapper.getNumeroDeTarjeta());

					TmkLogger.debug("Grabando datos para puntos de " + puntajeWrapper + "...");

				} catch (Exception e) {
					// continua
					TmkLogger.error("No se pudo grabar puntos de orden para la tarjeta " + ordenDAO.getPuntajeWrapper());
				}
			}
		}
	}

	private static void cargarCuentaFidelizacion(OrdenDAO ordenDAO) {
		try {
			if (Globals.FIDELIZACION_VIGENTE) {

				OrdenPorCuentaLocalHome ordenPorCuentaLocalHome = (OrdenPorCuentaLocalHome) DBUtil.getHome("OrdenPorCuenta");

				// busca si la orden tuvo puntos
				OrdenPorCuentaLocal ordenPorCuentaLocal = ordenPorCuentaLocalHome.findByPrimaryKey(new Integer(ordenDAO.getIdOrdenProcesada()));

				try {
					// carga los puntos
					PuntajeWrapper puntajeWrapper = FidelizacionHelper.consultarPuntos(ordenPorCuentaLocal.getID_SUCURSAL_SOCIO(), ordenPorCuentaLocal.getID_SOCIO());

					// carga los puntos a la orden
					com.tmk.fidelizacion.PuntajeWrapper puntajeEjb = new com.tmk.fidelizacion.PuntajeWrapper(puntajeWrapper.getNumeroDeTarjeta());
					
					puntajeEjb.setApellidoSocio(puntajeWrapper.getApellidoSocio());
					puntajeEjb.setComponente(puntajeWrapper.getComponente());
					puntajeEjb.setEMail(puntajeWrapper.getEMail());
					puntajeEjb.setEsGold(puntajeWrapper.isEsGold());
					puntajeEjb.setIdCuenta(puntajeWrapper.getIdCuenta());
					puntajeEjb.setIdCuso(puntajeWrapper.getIdCuso());
					puntajeEjb.setIdSucursalSocio(puntajeWrapper.getIdSucursalSocio());
					puntajeEjb.setIdSocio(puntajeWrapper.getIdSocio());
					puntajeEjb.setIdSucursalCuenta(puntajeWrapper.getIdSucursalCuenta());
					puntajeEjb.setNacionalidad(puntajeWrapper.getNacionalidad());
					puntajeEjb.setNombreSocio(puntajeWrapper.getNombreSocio());
					puntajeEjb.setNumeroDeDocumento(puntajeWrapper.getNumeroDeDocumento());
					puntajeEjb.setPuntos(puntajeWrapper.getPuntos());
					puntajeEjb.setSexo(puntajeWrapper.getSexo());
					puntajeEjb.setTipoDeDocumento(puntajeWrapper.getTipoDeDocumento());
					
					com.tmk.fidelizacion.VencimientoPuntos[] vencimientosEjb = new com.tmk.fidelizacion.VencimientoPuntos[puntajeWrapper.getVencimientosPuntos().length]; 
					for(int i=0;i<puntajeWrapper.getVencimientosPuntos().length;i++) {
						vencimientosEjb[i] = new com.tmk.fidelizacion.VencimientoPuntos(puntajeWrapper.getVencimientosPuntos()[i].getFecha(),puntajeWrapper.getVencimientosPuntos()[i].getPuntos()); 
					}
					puntajeEjb.setVencimientoPuntos(vencimientosEjb);
					ordenDAO.setPuntajeWrapper(puntajeEjb);
					//ordenDAO.setPuntajeWrapper(puntajeWrapper);
					
					// carga los puntos a la orden
					ordenDAO.setNumeroTarjetaExtra(ordenPorCuentaLocal.getNRO_TARJETA());

					// Muestra puntaje
					TmkLogger.debug("La orden tiene puntos eXtra: " + puntajeWrapper + "...");

				} catch (Exception e) {
					TmkLogger.error("No se pudo calcular a que cuenta van los puntos.");
				}

			}

		} catch (Exception e) {
			// continua
			TmkLogger.debug("La orden no dispone de puntos eXtra.");
		}
	}

	@SuppressWarnings("deprecation")
	public static boolean cargarCarritoCompra(OrdenDAO ordenDAO, SocioPK socioPK) {
		boolean teniaArticulosEnElCarrito = false;
		if (ordenDAO.isReadOnly() || socioPK == null) {
			return teniaArticulosEnElCarrito;
		}
		//if (socioPK == null) return false;

		try {
			//CarritoCompraLocalHome carritoCompraLocalHome = (CarritoCompraLocalHome) DBUtil.getHome("CarritoCompra");

			// fecha actual
			Date fechaLimite = new Date();
			fechaLimite.setDate(fechaLimite.getDate() - Globals.VIGENCIA_DEL_CARRITO_EN_DIAS);

			// borra los articulos del carrito persistente
			//Iterator carritoCompras = carritoCompraLocalHome.findByUser(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
			Iterator carritoCompras = ServiceLocator.getCarritoCompraService().findByUser(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
			teniaArticulosEnElCarrito = carritoCompras.hasNext();
			while (carritoCompras.hasNext()) {
				//CarritoCompraLocal carritoCompraLocal = (CarritoCompraLocal) carritoCompras.next();
				com.tmk.bus.orden.CarritoCompra carritoCompraLocal = (com.tmk.bus.orden.CarritoCompra) carritoCompras.next();
				// articulo
				ArticuloDAO articuloDAO = new ArticuloDAO(
				        //carritoCompraLocal.getID_ARTICULO().intValue(),
						carritoCompraLocal.getId_articulo().intValue(),
				        //carritoCompraLocal.getCANTIDAD().intValue()
						carritoCompraLocal.getCantidad().intValue()
				);
				// Si el articulo ahora es todavia vendible
				if (articuloDAO.estaHabilitado() && articuloDAO.getDisponibilidad().estaDisponible()) {
					// se guarda el articulo que tenia
					//if (carritoCompraLocal.getFECHA().after(fechaLimite)) {
					if (carritoCompraLocal.getFecha().after(fechaLimite)) {
						// Si el articulo lo tiene, entonces no lo repite
						if (ordenDAO.getArticuloById(articuloDAO.getId()) == null) {
							// lo agrega
							//ordenDAO.addArticuloDesdeCarrito(articuloDAO, carritoCompraLocal.getFECHA());
							ordenDAO.addArticuloDesdeCarrito(articuloDAO, carritoCompraLocal.getFecha());
						}
					} else {
						// log
						TmkLogger.debug(" CarritoCompra: fecha excedida para " + articuloDAO);
					}
				} else {
					// log
					TmkLogger.debug("CarritoCompra: articulo no permitido " + articuloDAO);
				}
			}

			// graba el carrito recien generado
			ordenDAO.grabarCarritoCompra(new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
			return teniaArticulosEnElCarrito;
		} catch (Throwable e) {
			TmkLogger.warn(" No se pudo sincronizar el carrito de compra " + e.getMessage());
			//fuerzo a la devulucion de false.
			return false;
		}

	}

	//SOBRE CARGA DEL METODO PARA PODER IR SACANDO LOS EJB
	//public static OrdenDAO cargarOrden2(int numeroOrden) throws Exception {}
	
	public static OrdenDAO cargarOrden(int numeroOrden) throws Exception {

		Integer idOrden = new Integer(numeroOrden);
		// Como es un poco lento prefiero cargarlo del cache
		OrdenDAO ordenDAO = (OrdenDAO)ordenesCargadas.get(idOrden);
		//LOGICA PARA USAR LOS DBO		
		if (ordenDAO != null) {
			TmkLogger.debug("Orden #" + idOrden + " recuperada del cache.");

			// Refresca el estado para que no quede mal
			OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
			OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(idOrden);
			ordenDAO.setIdEstado(ordenLocal.getESTADO());
			return ordenDAO;
		}

		// Se prepara a cargar la orden
		ordenDAO = new OrdenDAO(numeroOrden);

		TmkLogger.debug("Orden #" + idOrden + ". Cargando EJBs para cargar orden...");

		OrdenLocalHome ordenLocalHome = (OrdenLocalHome) DBUtil.getHome("Orden");
		ItemOrdenLocalHome itemOrdenLocalHome = (ItemOrdenLocalHome) DBUtil.getHome("ItemOrden");
		//SocioLocalHome socioLocalHome = (SocioLocalHome) DBUtil.getHome("Socio");
		NotaRegaloLocalHome notaRegaloLocalHome = (NotaRegaloLocalHome) DBUtil.getHome("NotaRegalo");
		PagoOrdenLocalHome pagoOrdenLocalHome = (PagoOrdenLocalHome) DBUtil.getHome("PagoOrden");
		TarjetaOrdenLocalHome tarjetaOrdenLocalHome = (TarjetaOrdenLocalHome) DBUtil.getHome("TarjetaOrden");
		DireccionOrdenLocalHome direccionOrdenLocalHome = (DireccionOrdenLocalHome) DBUtil.getHome("DireccionOrden");

		TmkLogger.info("Orden #" + idOrden + ". Cargando orden historica...");
		OrdenLocal ordenLocal = ordenLocalHome.findByPrimaryKey(idOrden);
		Integer idSucursal = ordenLocal.getID_SUCURSAL_SOCIO();
		Integer idSocio = ordenLocal.getID_SOCIO();
		ordenDAO.setAlianza(ordenLocal.getID_ALIANZA(), ordenLocal.getID_SECCION());
		ordenDAO.setIdDominio(ordenLocal.getID_DOMINIO());
		ordenDAO.setNivelDeRiesgo(NivelDeRiesgoDAO.buscaNivelDeRiesgo(ordenLocal.getNIVEL_RIESGO()));
		ordenDAO.setMotivoDeRiesgo(ordenLocal.getMOTIVO_RIESGO());
		ordenDAO.setNombresReceptor(ordenLocal.getNOMBRES_RECEPTOR());
		ordenDAO.setApellidosReceptor(ordenLocal.getAPELLIDOS_RECEPTOR());
        ordenDAO.setCupon(ordenLocal.getCUPON());
		ordenDAO.setCPF_CNPJ(ordenLocal.getCPF_CNPJ());
		ordenDAO.setTIPO_DOC_RECEPTOR(ordenLocal.getTIPO_DOC_RECEPTOR());
		ordenDAO.setNRO_DOC_RECEPTOR(ordenLocal.getNRO_DOC_RECEPTOR());
		ordenDAO.setRANGO_HORARIO_RECEPTOR(ordenLocal.getRANGO_HORARIO_RECEPTOR());

		if (ordenDAO.tieneOtroReceptor()) {
			TmkLogger.debug("Orden #" + idOrden + ". Destinatario: " + Convert.nombreCompleto(ordenDAO.getNombresReceptor(), ordenDAO.getApellidosReceptor()));
		}

		//PagoOrdenLocal pagoOrdenLocal = pagoOrdenLocalHome.findByIdOrden(idOrden);
		//Lo tengo que hacer antes del bloque de medio de cobro porque ahora son dos
		//y la asignacion la resuelvo abajo.
		ordenDAO.completarDatosMedioDeCobro(
		        ordenLocal.getTELEFONO(), ordenLocal.getHR_CONTACTO(), ordenLocal.getCOMENTARIOS(),
		        null,
		        ordenLocal.getESTADO());

		///Utilizado en dos medios de cobro.
		Iterator pagosOrden = pagoOrdenLocalHome.findByIdOrden(idOrden).iterator();

		PagoOrdenLocal pagoOrdenLocal = (PagoOrdenLocal) pagosOrden.next();
		PagoOrdenLocal pagoTarjeta = null;
		MedioDeCobroDAO medioDeCobroDAO1 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());
		if (medioDeCobroDAO1.esTarjeta()) {
			pagoTarjeta = pagoOrdenLocal;
		}
		//MedioDeCobroDAO medioDeCobroDAO2 = null;
        MedioDeCobroDAO medioTarjeta = null;

		/*if (pagosOrden.hasNext()) {
			pagoOrdenLocal = (PagoOrdenLocal) pagosOrden.next();
            medioDeCobroDAO2 = MedioDeCobroDAO.buscaMedioDeCobro(pagoOrdenLocal.getID_MEDIO_COBRO());
			if (medioDeCobroDAO2.esTarjeta()) {
				pagoTarjeta = pagoOrdenLocal;
			}
		}*/

		/*medioTarjeta = (medioDeCobroDAO1.esTarjeta())? medioDeCobroDAO1: (medioDeCobroDAO2 != null) ? (medioDeCobroDAO2.esTarjeta())?
		            medioDeCobroDAO2: null:null;*/
		
		medioTarjeta = (medioDeCobroDAO1.esTarjeta())? medioDeCobroDAO1: null;

		if (medioTarjeta != null) {
			TmkLogger.debug("Orden #" + idOrden + ". Cargando tarjeta...");
			TarjetaOrdenPK tarjetaOrdenPK = new TarjetaOrdenPK();
			tarjetaOrdenPK.ID_ORDEN = idOrden;
			tarjetaOrdenPK.ID_MEDIO_COBRO = medioTarjeta.getId();
			TarjetaOrdenLocal tarjetaOrdenLocal = tarjetaOrdenLocalHome.findByPrimaryKey(tarjetaOrdenPK);

			ordenDAO.completarDatosTarjeta(
			        Seguridad.desencriptarTarjeta(tarjetaOrdenLocal.getNRO_TARJETA()),
			        null, 01, 2000,
			        tarjetaOrdenLocal.getNOMBRE_CLIENTE(),
			        (tarjetaOrdenLocal.getTIPO_DOC() == null) ? Globals.TIPO_DOCUMENTO_DNI.getId() : tarjetaOrdenLocal.getTIPO_DOC(),
			        (tarjetaOrdenLocal.getNRO_DOC() == null) ? 0 : tarjetaOrdenLocal.getNRO_DOC().longValue(),
			        tarjetaOrdenLocal.getDIRECCION_RESUMEN(),
			        medioTarjeta,
			        ordenLocal.getESTADO());

			ordenDAO.setGpayInfo(
			        tarjetaOrdenLocal.getCODIGO_RESPUESTA(),
			        tarjetaOrdenLocal.getCODIGO_AUTORIZACION(),
			        tarjetaOrdenLocal.getMENSAJE_GPAY());


			ordenDAO.setTarjetaPlanDAO(
			        new TarjetaPlanDAO(
			                medioTarjeta.getId(),
			                pagoTarjeta.getCUOTAS().intValue(),
			                pagoTarjeta.getMONEDA().intValue(),
			                pagoTarjeta.getCOEFICIENTE().doubleValue()
			                ));
		}

		ordenDAO.setMedioDeCobro(medioDeCobroDAO1);

		//Tarjeta Prepaga
        if (ordenDAO.getMedioDeCobro().esTarjetaPrePaga()) {
	        ordenDAO.setTarjetasPrepagasDeLaOrden(ordenDAO.getIdOrdenProcesada());
        }
		
		//Tarjeta Prepaga

		TmkLogger.debug("Orden #" + idOrden + ". Cargando items...");

		Iterator items = itemOrdenLocalHome.findArticulos(idOrden).iterator();

		Vector<ArticuloDAO> articulos = new Vector<ArticuloDAO>();
		Vector<GastosEnvioDAO> gastos = new Vector<GastosEnvioDAO>();
		Vector faltaPapel = new Vector();

		while (items.hasNext()) {
			ItemOrdenLocal itemOrdenLocal = (ItemOrdenLocal) items.next();
			ArticuloDAO articuloDAO = new ArticuloDAO(
			        itemOrdenLocal.getID_ARTICULO().intValue(),
			        itemOrdenLocal.getCANTIDAD().intValue());

			// En algunas ordenes migradas dio error, prefiero continuar con precio actual
			try {
				articuloDAO.cargar(
				        articuloDAO.getId(),
				        articuloDAO.getTitulo(),
				        articuloDAO.getCategoriaSeccion(),
				        articuloDAO.getCategoriaGrupo(),
				        articuloDAO.getCategoriaFamilia(),
				        articuloDAO.getCategoriaSubFamilia(),
				        itemOrdenLocal.getPRECIO_ORIGINAL().doubleValue(),
				        itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(),
				        itemOrdenLocal.getPRECIO_UNITARIO().doubleValue(),
				        itemOrdenLocal.getPRECIO_PROMOCION().doubleValue(),
				        0,
				        Convert.porcentajeAplicado(itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(), itemOrdenLocal.getPRECIO_UNITARIO().doubleValue()),
				        itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue() < itemOrdenLocal.getPRECIO_UNITARIO().doubleValue(),
				        itemOrdenLocal.getPRECIO_UNITARIO().doubleValue() - itemOrdenLocal.getPRECIO_DESCUENTO().doubleValue(),
				        Convert.porcentajeAplicado(itemOrdenLocal.getPRECIO_ORIGINAL().doubleValue(), itemOrdenLocal.getPRECIO_UNITARIO().doubleValue()),
				        0.0,
				        articuloDAO.getCodExtVisual(),
				        articuloDAO.getIdDisponibilidad(),
				        true);

				// En que estado esta el articulo
				articuloDAO.setIdEstadoItem(itemOrdenLocal.getESTADO());
				//Promos
				//articuloDAO.
				/*if ((itemOrdenLocal.getID_PROMOCION() != null) && (itemOrdenLocal.getPRECIO_PROMOCION() != null)) {
					articuloDAO.setPrecioPromocionSinImpuestos(itemOrdenLocal.getPRECIO_PROMOCION_SIN_IMPUESTOS().doubleValue());
				}*/

				if (itemOrdenLocal.getID_PROMOCION() != null) {
					articuloDAO.setIdPromo1(itemOrdenLocal.getID_PROMOCION().intValue());
					articuloDAO.setNombrePromo1(Promocion2.consultaNombreDePromocion(articuloDAO.getIdPromo1()));
				}
				if (itemOrdenLocal.getID_PROMOCION2() != null) {
					articuloDAO.setIdPromo2(itemOrdenLocal.getID_PROMOCION2().intValue());
					articuloDAO.setNombrePromo2(Promocion2.consultaNombreDePromocion(articuloDAO.getIdPromo2()));
				}
				if (itemOrdenLocal.getID_PROMOCION3() != null) {
					articuloDAO.setIdPromo3(itemOrdenLocal.getID_PROMOCION3().intValue());
					articuloDAO.setNombrePromo3(Promocion2.consultaNombreDePromocion(articuloDAO.getIdPromo3()));
				}
				if (itemOrdenLocal.getID_PROMOCION4() != null) {
					articuloDAO.setIdPromo4(itemOrdenLocal.getID_PROMOCION4().intValue());
					articuloDAO.setNombrePromo4(Promocion2.consultaNombreDePromocion(articuloDAO.getIdPromo4()));
				}
				if (itemOrdenLocal.getID_PROMOCION5() != null) {
					articuloDAO.setIdPromo5(itemOrdenLocal.getID_PROMOCION4().intValue());
					articuloDAO.setNombrePromo5(Promocion2.consultaNombreDePromocion(articuloDAO.getIdPromo5()));
				}
				if (itemOrdenLocal.getID_CAMPAIGN() != null) {
					articuloDAO.setIdCampaign(itemOrdenLocal.getID_CAMPAIGN().intValue());
					articuloDAO.setNombreCampaign(Promocion2.consultaNombreDeCampaign(articuloDAO.getIdCampaign()));
				}
				articuloDAO.setPrecioPromocionSinImpuestos(itemOrdenLocal.getPRECIO_PROMOCION_SIN_IMPUESTOS().doubleValue());
			} catch (Exception e) {
				TmkLogger.error("Orden #" + idOrden + ". No se pudo cargar un articulo historico " + itemOrdenLocal.getID_ARTICULO());
			}

			if (articuloDAO.esGastoDeEnvio()) {
				GastosEnvioDAO gasto = new GastosEnvioDAO(articuloDAO.getId(), itemOrdenLocal.getCANTIDAD().intValue());
				gasto.setPrecio(itemOrdenLocal.getPRECIO_ORIGINAL().doubleValue());
				gasto.setPrecioPromocionSinImpuestos(itemOrdenLocal.getPRECIO_PROMOCION_SIN_IMPUESTOS().doubleValue());
				gasto.setIdPromo1(articuloDAO.getIdPromo1());
				gasto.setIdPromo2(articuloDAO.getIdPromo2());
				gasto.setIdPromo3(articuloDAO.getIdPromo3());
				gasto.setIdPromo4(articuloDAO.getIdPromo4());
				gasto.setIdPromo5(articuloDAO.getIdPromo5());
				gasto.setNombrePromo1(articuloDAO.getNombrePromo1());
				gasto.setNombrePromo2(articuloDAO.getNombrePromo2());
				gasto.setNombrePromo3(articuloDAO.getNombrePromo3());
				gasto.setNombrePromo4(articuloDAO.getNombrePromo4());
				gasto.setNombrePromo5(articuloDAO.getNombrePromo5());
				gasto.setIdCampaign(articuloDAO.getIdCampaign());
				gasto.setNombreCampaign(articuloDAO.getNombreCampaign());
				gastos.add(gasto);
			} else {
				if (articuloDAO.esInteresCobrado()) {
					InteresCobradoDAO interesCobradoDAO = new InteresCobradoDAO(articuloDAO.getId());
					// Le pone el precio como dice
					interesCobradoDAO.setPrecio((itemOrdenLocal.getPRECIO_PROMOCION() == null) ? 0 : itemOrdenLocal.getPRECIO_PROMOCION().doubleValue());
					interesCobradoDAO.setIdPromo1(articuloDAO.getIdPromo1());
					interesCobradoDAO.setIdPromo2(articuloDAO.getIdPromo2());
					interesCobradoDAO.setIdPromo3(articuloDAO.getIdPromo3());
					interesCobradoDAO.setIdPromo4(articuloDAO.getIdPromo4());
					interesCobradoDAO.setIdPromo5(articuloDAO.getIdPromo5());
					interesCobradoDAO.setNombrePromo1(articuloDAO.getNombrePromo1());
					interesCobradoDAO.setNombrePromo2(articuloDAO.getNombrePromo2());
					interesCobradoDAO.setNombrePromo3(articuloDAO.getNombrePromo3());
					interesCobradoDAO.setNombrePromo4(articuloDAO.getNombrePromo4());
					interesCobradoDAO.setNombrePromo5(articuloDAO.getNombrePromo5());
					interesCobradoDAO.setIdCampaign(articuloDAO.getIdCampaign());
					interesCobradoDAO.setNombreCampaign(articuloDAO.getNombreCampaign());
					// Guardar el producto
					ordenDAO.setInteresCobradoDAO(interesCobradoDAO);
				} else {
					articulos.add(articuloDAO);
					TmkLogger.debug("Articulo agregado: " + articuloDAO.getId() + " " + articuloDAO.getCantidad());
				}
			}

			boolean tienePapel = false;
			boolean encontroPapel = false;
			if (itemOrdenLocal.getID_PAPEL_REGALO() != null) {
				TmkLogger.debug("Articulo con papel " + articuloDAO.getId());
				tienePapel = true;
				for (int i = 0; i<articulos.size(); i++) {
					if (((ArticuloDAO)articulos.get(i)).getId() == itemOrdenLocal.getID_PAPEL_REGALO().intValue()) {
						//No puedo comprobar cantidad porque las ordenes viejas no agrupan papeles con articulos
						//por igual cantidad
						TmkLogger.debug("Encuentro papel " + itemOrdenLocal.getID_PAPEL_REGALO().intValue());
						if (articuloDAO.getCantidad() == ((ArticuloDAO)articulos.get(i)).getCantidad()) {
							TmkLogger.debug("misma cantidad " + articuloDAO.getCantidad());
							articuloDAO.setPapelDeRegalo((ArticuloDAO)articulos.remove(i));
							encontroPapel = true;
							break;
						}
					}
				}
				//TmkLogger.debug("ultima version");
				//las cantidades no coinciden son ordenes pre-promo II
				if (tienePapel) {
					if (!encontroPapel) {
						TmkLogger.debug("Entro a modificar papeles");
						for (int i = 0; i<articulos.size(); i++) {
							if (((ArticuloDAO)articulos.get(i)).getId() == itemOrdenLocal.getID_PAPEL_REGALO().intValue()) {
								ArticuloDAO papel = (ArticuloDAO)articulos.get(i);
								if (papel.getCantidad() > articuloDAO.getCantidad()) {
									ArticuloDAO papelNuevo = new ArticuloDAO(
									        itemOrdenLocal.getID_PAPEL_REGALO().intValue(),
									        papel.getCantidad() - articuloDAO.getCantidad());

									//papelNuevo.setPrecio(papel.getPrecioOriginal());
									papelNuevo.setPrecioPromocionSinImpuestos(papel.getPrecioPromocionSinImpuestos());
									papelNuevo.setIdPromo1(papel.getIdPromo1());
									papelNuevo.setIdPromo2(papel.getIdPromo2());
									papelNuevo.setIdPromo3(papel.getIdPromo3());
									papelNuevo.setIdPromo4(papel.getIdPromo4());
									papelNuevo.setIdPromo5(papel.getIdPromo5());
									papelNuevo.setNombrePromo1(papel.getNombrePromo1());
									papelNuevo.setNombrePromo2(papel.getNombrePromo2());
									papelNuevo.setNombrePromo3(papel.getNombrePromo3());
									papelNuevo.setNombrePromo4(papel.getNombrePromo4());
									papelNuevo.setNombrePromo5(papel.getNombrePromo5());
									papelNuevo.setIdCampaign(papel.getIdCampaign());
									papelNuevo.setNombreCampaign(papel.getNombreCampaign());

									papel.setCantidad(articuloDAO.getCantidad());
									articuloDAO.setPapelDeRegalo((ArticuloDAO)articulos.remove(i));
									articulos.add(papelNuevo);
									break;
								}
							}
						}
					}
				}
			}
		}

		TmkLogger.debug("TOTAL de Gastos:" + gastos.size());

		//Asigno los gastos a los articulos
		for(int i=0; i<articulos.size(); i++) {
			ArticuloDAO producto = (ArticuloDAO)articulos.get(i);			
				for (int j=0; j<gastos.size(); j++) {
					//PROMO II --SOLO SIRVE PARA LAS ORDENES NUEVAS A LAS QUE SE LE ASIGNA EL GASTO AL ARTICULO
					if (((GastosEnvioDAO)gastos.get(j)).getCantidad() == producto.getCantidad()) {
						TmkLogger.debug("producto " + producto.getId() + " " + producto.getCantidad() + "  gasto " + ((GastosEnvioDAO)gastos.get(j)).getId() + " " +  ((GastosEnvioDAO)gastos.get(j)).getCantidad());
						producto.setGastoDeEvio((GastosEnvioDAO)gastos.remove(j));
						break;
					}
				}	
		}

		TmkLogger.debug("Gastos colgados " + gastos.size());
		//PROMO II Esto se hace para partir los gastos de las ordenes viejas que no lo asignan por articulos
		if (gastos.size() > 0) {
			TmkLogger.debug("Entra a reasignar Gastos");
			TmkLogger.debug("Articulos " + articulos.size());
			for (int i=0; i<articulos.size(); i++) {
				ArticuloDAO producto = (ArticuloDAO)articulos.get(i);
				
				for (int j=0; j<gastos.size(); j++) {
					if (producto.getGastoDeEvio() == null) {
						TmkLogger.debug("GASTO A ASIGNAR");
						GastosEnvioDAO gastoAnterior = (GastosEnvioDAO)gastos.get(j);
						GastosEnvioDAO gastoNuevo = new GastosEnvioDAO(gastoAnterior.getId(), gastoAnterior.getCantidad() - producto.getCantidad());
						gastoAnterior.setCantidad(producto.getCantidad());
						producto.setGastoDeEvio((GastosEnvioDAO)gastos.remove(j));
						if (gastoNuevo.getCantidad()>0) {
							gastoNuevo.setPrecio(gastoAnterior.getPrecioOriginal());
							gastoNuevo.setPrecioPromocionSinImpuestos(gastoAnterior.getPrecioPromocionSinImpuestos());
							gastoNuevo.setIdPromo1(gastoAnterior.getIdPromo1());
							gastoNuevo.setIdPromo2(gastoAnterior.getIdPromo2());
							gastoNuevo.setIdPromo3(gastoAnterior.getIdPromo3());
							gastoNuevo.setIdPromo4(gastoAnterior.getIdPromo4());
							gastoNuevo.setIdPromo5(gastoAnterior.getIdPromo5());
							gastoNuevo.setNombrePromo1(gastoAnterior.getNombrePromo1());
							gastoNuevo.setNombrePromo2(gastoAnterior.getNombrePromo2());
							gastoNuevo.setNombrePromo3(gastoAnterior.getNombrePromo3());
							gastoNuevo.setNombrePromo4(gastoAnterior.getNombrePromo4());
							gastoNuevo.setNombrePromo5(gastoAnterior.getNombrePromo5());
							gastoNuevo.setIdCampaign(gastoAnterior.getIdCampaign());
							gastoNuevo.setNombreCampaign(gastoAnterior.getNombreCampaign());
							gastos.add(gastoNuevo);
						}
						break;
					}
				}
				
			}
		}

		Iterator direcciones = direccionOrdenLocalHome.findByOrden(idOrden).iterator();
		while (direcciones.hasNext()) {
			DireccionOrdenLocal direccionOrdenLocal = (DireccionOrdenLocal) direcciones.next();
			DomicilioDAO domicilioDAO = DomicilioDAO.load(idSucursal, idSocio, direccionOrdenLocal.getTIPO_DOMICILIO());
			TmkLogger.debug("Orden #" + idOrden + ". Cargando " + domicilioDAO);
			if (domicilioDAO.esEnvio()) {
				ordenDAO.setDomicilioEnvio(domicilioDAO);
			}
			if (domicilioDAO.esFacturacion()) {
				ordenDAO.setDomicilioFacturacion(domicilioDAO);
			}
		}

		Iterator notas = notaRegaloLocalHome.findAllByOrden(idOrden).iterator();
		while (notas.hasNext()) {
			NotaRegaloLocal notaRegaloLocal = (NotaRegaloLocal) notas.next();
			for (int i = 0; i < articulos.size(); i++) {
				ArticuloDAO articuloDAO = (ArticuloDAO) articulos.get(i);
				if (articuloDAO.getId() == notaRegaloLocal.getID_ARTICULO().intValue()) {
					articuloDAO.setNota(notaRegaloLocal.getNOTA_REGALO());
					TmkLogger.debug("Orden #" + idOrden + ". Cargando nota " + Convert.toString(articuloDAO.getNota(), 15));
					break;
				}
			}
		}

		for (int i=0; i<articulos.size(); i++) {
			//ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			//TmkLogger.debug("id " + articulo.getId() + " cantidad " + articulo.getCantidad());
			ordenDAO.addArticuloConPromo((ArticuloDAO)articulos.get(i));
		}

		// carga datos del socio
		SocioPK socioPK = new SocioPK(ordenLocal.getID_SUCURSAL_SOCIO(), ordenLocal.getID_SOCIO());
		//SocioLocal socioLocal = socioLocalHome.findByPrimaryKey(socioPK);
		Socios2 socioLocal = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
		
		// No permito grabar la orden de nuevo
		ordenDAO.cerrarDatosDeCompra(
		        idOrden.intValue(), ordenLocal.getFECHA(),
		        Convert.nombreCompleto(socioLocal.getNombres(), socioLocal.getApellidos()),
		        socioLocal.getlogin());

		// Para la parte de puntos
		cargarCuentaFidelizacion(ordenDAO);

		TmkLogger.debug("Orden #" + idOrden + ". Fecha de cierre: " + ordenDAO.getFechaDeCierre());

		// Guarda la orden en el cache para no recargarla
		//agregarOrdenAlCache(idOrden, ordenDAO);

		return ordenDAO;
	}

	//Consulta a Dinero mail los pagos con cupon de los ultimos 30 dias
	public static Report getReportOrdenesConCupon(String rangoDesde, String rangoHasta) throws Exception {
		
		String startDate=rangoDesde;
		String endDate=rangoHasta;
		
		if((startDate==null)||(startDate.equals(""))
			||(endDate==null)||(endDate.equals(""))){
			//		formato requerido para fecha de comienzo y fin
			SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
			//la fecha de fin es ahora
			Calendar calendar = Calendar.getInstance();
			endDate = format.format(new Date(calendar.getTimeInMillis()));
			//lo seteo una semana atras para la fecha de comienzo
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE)-30);
			startDate = format.format(new Date(calendar.getTimeInMillis()));
		}
		
		Request reqObj = new Request("https://www.dineromail.com/Vender/ConsultaPago.asp", Request.POST);
		//Request reqObj = new Request("http://localhost:8101/prueba/pruebaDM.jsp", Request.POST);
		//los parametros deberan modificarse por los definitivos cuando se implemente
		reqObj.addParam("Email", "tematika.com@gmail.com");
		reqObj.addParam("Acount", "06875883");
		reqObj.addParam("Pin", "XN7MU5R4UX");
		reqObj.addParam("StartDate", startDate);
		reqObj.addParam("EndDate", endDate);
		reqObj.addParam("XML", "1");
		String strXML = null;
		Report report = null;

		try {
			strXML = ClientSocket.sendRequest(reqObj);
			try {
				if (strXML != null) {
					//TmkLogger.debug(strXML);
					strXML = strXML.replaceAll("Email", "eMail");
					strXML = strXML.replaceAll("Acount", "acount");
					strXML = strXML.replaceAll("Pin", "pin");
					strXML = strXML.replaceAll("StartDate", "startDate");
					strXML = strXML.replaceAll("EndDate", "endDate");
					strXML = strXML.replaceAll("State", "state");
					strXML = strXML.replaceAll("Trx_id", "trxId");
					strXML = strXML.replaceAll("Trx_Date", "trxDate");
					strXML = strXML.replaceAll("Trx_Payment", "trxPayment");
					strXML = strXML.replaceAll("Collections", "collections");

					XStream xstream = new XStream(new DomDriver());
					xstream.alias("Report", Report.class);
				    xstream.alias("collections", ArrayList.class);
					xstream.alias("Collection", com.tmk.xml.dm.cupon.Collection.class);
					xstream.useAttributeFor("trxId", String.class);
					xstream.omitField(Object.class, "Pays");
					xstream.omitField(Object.class, "Tickets");
					xstream.omitField(Object.class, "Reception");
					xstream.omitField(Object.class, "Trx_MontoNeto");
					xstream.omitField(Object.class, "Trx_Number");
					xstream.omitField(Object.class, "trxPaymentMean");
					xstream.omitField(Object.class, "Receptions");
					xstream.omitField(Object.class, "Retreats");
					xstream.omitField(Object.class, "Credits");
					xstream.omitField(Object.class, "Debits");




					xstream.useAttributeFor("trxId", String.class);
					report = (Report)xstream.fromXML(strXML);
				}
			} catch (Exception e) {
				TmkLogger.error("Reporte de orden - cupon] error pasando xml a objeto " + e.toString() + MainHelper.getMessage(e));
				throw e;
			}
		} catch (Exception e) {
			TmkLogger.error("Reporte de orden - cupon] error consultando por socket a DM " + e.toString() + MainHelper.getMessage(e));
			throw e;
		}
		return report;

	}

	public static com.tmk.xml.dm.ipn.respuesta.Reporte consultarOrdenConDMaDM(com.tmk.xml.dm.ipn.consulta.Id[] ids) throws Exception {
		String strXML = null;
		com.tmk.xml.dm.ipn.respuesta.Reporte reporteRespuesta = null;
		com.tmk.xml.dm.ipn.consulta.Consulta consulta =
				new com.tmk.xml.dm.ipn.consulta.Consulta("tmkipn12", new Integer(1), ids);
		com.tmk.xml.dm.ipn.consulta.Detalle detalle = new com.tmk.xml.dm.ipn.consulta.Detalle(consulta);
		com.tmk.xml.dm.ipn.consulta.Reporte reporteConsulta = new com.tmk.xml.dm.ipn.consulta.Reporte ("687588", detalle);

		try {
			XStream xstream = new XStream(new DomDriver());
			xstream.setMode(XStream.NO_REFERENCES);
			xstream.alias("REPORTE", com.tmk.xml.dm.ipn.consulta.Reporte.class);

			String strReporteConsulta = xstream.toXML(reporteConsulta);
			strReporteConsulta = strReporteConsulta.replaceAll("<com.tmk.xml.dm.ipn.consulta.Id>", "").replaceAll("</com.tmk.xml.dm.ipn.consulta.Id>", "").replaceAll("\n", "");
			strReporteConsulta = strReporteConsulta.replaceAll("nroCta", "NROCTA");
			strReporteConsulta = strReporteConsulta.replaceAll("detalle", "DETALLE");
			strReporteConsulta = strReporteConsulta.replaceAll("consulta", "CONSULTA");
			strReporteConsulta = strReporteConsulta.replaceAll("clave", "CLAVE");
			strReporteConsulta = strReporteConsulta.replaceAll("tipo", "TIPO");
			strReporteConsulta = strReporteConsulta.replaceAll("operaciones", "OPERACIONES");
			strReporteConsulta = strReporteConsulta.replaceAll("Id", "ID");
			//TmkLogger.debug(strReporteConsulta);
			//Request reqObj = new Request("http://www.dineromail.com/Vender/Consulta_IPN.asp", Request.POST);
			Request reqObj = new Request("https://argentina.dineromail.com/Vender/Consulta_IPN.asp", Request.POST);
			
			
			//Request reqObj = new Request("http://localhost:8101/prueba/pruebaDM2.jsp", Request.POST);
			//los parametros deberan modificarse por los definitivos cuando se implemente
			reqObj.addParam("DATA", strReporteConsulta);
			try {
				strXML = ClientSocket.sendRequest(reqObj);
				try {
					if (strXML != null) {												
						strXML = strXML.replaceAll("REPORTE", "Reporte");
						strXML = strXML.replaceAll("ESTADOREPORTE", "estadoReporte");
						strXML = strXML.replaceAll("DETALLE", "detalle");
						strXML = strXML.replaceAll("OPERACIONES", "operaciones");
						strXML = strXML.replaceAll("OPERACION", "Operacion");
						strXML = strXML.replaceAll("OPERACIÓN", "Operacion");
						strXML = strXML.replaceAll("ID", "id");
						strXML = strXML.replaceAll("FECHA", "fecha");
						strXML = strXML.replaceAll("ESTADO", "estado");
						strXML = strXML.replaceAll("MONTONETO", "montoNeto");
						strXML = strXML.replaceAll("MONTO", "monto");
						strXML = strXML.replaceAll("METODOPAGO", "metodoPago");			
						
						xstream = new XStream(new DomDriver());
						xstream.alias("Reporte", com.tmk.xml.dm.ipn.respuesta.Reporte.class);
						xstream.alias("detalle", com.tmk.xml.dm.ipn.respuesta.Detalle.class);
					    xstream.alias("operaciones", ArrayList.class);
						xstream.alias("Operacion", com.tmk.xml.dm.ipn.respuesta.Operacion.class);
						xstream.omitField(Object.class, "COMPRADOR");
						xstream.omitField(Object.class, "ITEMS");
						//SE OMITEN ESTOS CAMPOS DADO QUE NO SE USAN ACA EN TMK
						xstream.omitField(Object.class, "CUOTAS");
						xstream.omitField(Object.class, "VENDEDOR");						
						xstream.omitField(Object.class, "NUMTRANSACCION");
						xstream.omitField(Object.class, "MEDIOPAGO");
						//FIN BLOQUE
						reporteRespuesta = (com.tmk.xml.dm.ipn.respuesta.Reporte)xstream.fromXML(strXML);

					}
				} catch (Exception e) {
					TmkLogger.error("Reporte de orden - DM] error creando xml de respuesta " + e.toString());
					throw e;
				}
			} catch (Exception e) {
				TmkLogger.error("Reporte de orden - DM] error consultando por socket a DM " + e.toString());
				throw e;
			}
		} catch (Exception e) {
			TmkLogger.error("Reporte de orden - DM] error creando xml de consulta " + e.toString());
			throw e;
		}
		return reporteRespuesta;
	}

	/*formato idEstado = '2','4' idMedios 'EFE','RP'*/
	public static OrdenWrapper[] findOrdenByEstadoMedio (String idEstado, String idMedios) throws Exception {
		Vector aux = new Vector();

		StringBuffer qry = new StringBuffer("");
		qry.append(" SELECT o.id_orden , po.id_medio_cobro,  to_char( o.fecha, 'DD/MM/YYYY') fecha , o.total, cp.codigo");
		qry.append(" FROM ORDEN o, PAGO_ORDEN po, CUPON_DE_PAGO cp");
		qry.append(" WHERE o.id_orden = po.id_orden");
		qry.append(" 	AND o.id_orden = cp.id_orden(+)");
		qry.append(" 	AND estado IN (").append(idEstado).append(")");
		qry.append("	AND id_medio_cobro IN (").append(idMedios).append(")");
		qry.append(" ORDER BY o.fecha");

		Iterator it = MainHelper.getRs(qry.toString());
		while (it.hasNext()) {
			DynaBean dyn = (DynaBean) it.next();
			OrdenWrapper ordenWrapper = new OrdenWrapper();
			ordenWrapper.setIdOrden(new Integer(dyn.get("id_orden").toString()));
			ordenWrapper.setMedioDeCobro(MedioDeCobroDAO.buscaMedioDeCobro(dyn.get("id_medio_cobro").toString()));
			ordenWrapper.setFecha(Convert.toString(Convert.toTimestampFromDDMMYYYY(dyn.get("fecha").toString())));
			ordenWrapper.setTotal((new Double (dyn.get("total").toString())).toString());
			if (dyn.get("codigo") != null) {
				ordenWrapper.setCodigoCupon(dyn.get("codigo").toString());
			}
			aux.add(ordenWrapper);
		}
		return (OrdenWrapper [])aux.toArray(new OrdenWrapper[aux.size()]);

	}

}