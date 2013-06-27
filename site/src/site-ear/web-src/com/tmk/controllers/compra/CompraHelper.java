/**
 * $Log: CompraHelper.java,v $
 * Revision 1.70  2009/03/25 15:11:25  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.69  2009/03/20 19:02:46  oClopez
 * cambio viernes
 *
 * Revision 1.68  2009/03/04 12:55:04  oClopez
 * micuenta, proceso de compra, popego
 *
 * Revision 1.67  2008/07/07 18:59:48  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.66  2008/05/30 16:05:51  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.65  2008/04/09 20:20:17  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.64  2007/12/18 20:11:51  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.63  2007/09/03 13:42:15  msartori
 * no message
 *
 * Revision 1.62  2006/10/09 13:05:52  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.61  2006/09/28 14:58:18  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.60  2006/09/14 18:25:01  omsartori
 * Promociones II
 *
 * Revision 1.59  2006/08/02 15:20:38  omsartori
 * - Mejoras en busquedas>
 *                    Reemplazo de ejb por 1 solo qry
 *                    Hints no necesarios en qry principales eliminados
 * - Banner promos e institucionales agregados en detalle de producto
 * - Indice agregado a las busquedas por palabra clave
 * - Correccion en resaltado> tags incompletos en el corte
 * - Componente de imagen libre de ejb y qrys
 * - Componente de cotizacion parametrizado por monedas y libre de ejb
 *
 * Revision 1.58  2006/06/22 18:31:36  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.57  2005/12/29 17:45:26  omsartori
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
 * Revision 1.56  2005/12/13 16:16:45  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.55  2005/11/24 15:28:13  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.54  2005/11/14 13:47:54  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.53  2005/11/04 12:55:41  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * - Grabación de hasta 2 formas de pago para la misma orden de compra.
 *
 * Revision 1.51  2005/10/11 16:04:46  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.50  2005/04/08 12:54:58  omsartori
 * - Consultas de Referidos
 * - Banner por seccinon configurable desde xml
 *
 * Revision 1.49  2005/03/24 15:25:15  omsartori
 * - Bug campo de gastos no grabado corregido
 * - Medio de cobro Rio Net Banking
 *
 * Revision 1.48  2005/03/16 16:08:57  omsartori
 * - Manejo de cheque obsequio y articulos con impuestos
 *
 * Revision 1.47  2005/03/15 12:28:13  omsartori
 * -Categoria (3,7,2,0 ) para Cheque obsequio
 * -Correccion del calculo del 5% para recargo EFCO
 * -Reemplazo de 7 x 10% en Afiliados libros
 * -Cambio en barra de titulos.
 * -Bug en lista de deseos.
 * -Eliminacion de jscript en combo convinado de localidades
 *
 * Revision 1.46  2005/02/17 12:14:21  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.45  2005/01/25 15:52:58  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.44  2004/10/22 15:55:37  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.43  2004/10/05 21:29:45  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.42  2004/09/30 14:17:26  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.41  2004/09/24 18:19:23  oGPistoia
 * - Nombres y Apellidos del receptor del pedido terminado.
 *
 * Revision 1.40  2004/09/10 15:13:19  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.39  2004/09/09 16:46:24  omsartori
 * Arreglado bug de redireccion en inicio de sesión
 * bug de tamaño de imagenes
 * imagen y color de seccion en ultimos visitados
 * ultimos visitados en compras
 *
 * Revision 1.38  2004/08/03 15:48:45  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.37  2004/06/15 20:57:34  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.36  2004/05/14 19:19:10  oGPistoia
 * Meta-tag para buscador Google, Yahoo, etc.
 * Campo Fecha de Nacimiento para Socios
 * Correccion de pantalla de registración
 *
 * Revision 1.35  2004/03/25 18:19:53  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.34  2003/12/11 20:53:31  GPistoia
 * -Busqueda de socio por mail
 * -Listado de ordenes por socio
 * -Cambio de tiempos en algunos demonios
 * -Mas informacion en estadisticas
 *
 * Revision 1.33  2003/11/26 15:38:12  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.32  2003/10/28 01:40:24  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.31  2003/10/14 08:53:30  GPistoia
 * -Mail configurable en pedido especial
 *
 * Revision 1.30  2003/10/13 21:43:39  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.29  2003/10/07 14:56:26  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.28  2003/10/03 16:30:18  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.27  2003/09/29 17:21:03  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.26  2003/09/23 13:56:08  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.25  2003/09/19 19:49:08  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.24  2003/09/18 18:56:28  GPistoia
 * -Oculte los radio buttons de ir a papel de regalo.
 * -Iteracion en GPay
 *
 * Revision 1.23  2003/09/17 19:32:17  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.22  2003/09/17 17:31:32  JMembrives
 * no message
 *
 * Revision 1.21  2003/09/15 22:31:43  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.20  2003/09/11 18:09:47  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.19  2003/09/09 17:49:49  SLizardo
 * Modificacion del SocioPK.
 *
 * Revision 1.18  2003/09/08 13:54:44  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.17  2003/09/04 21:40:01  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.16  2003/09/02 19:54:44  NRodriguez
 * manejo del flag de papel de regalo desde el carrito
 *
 * Revision 1.15  2003/08/26 16:19:34  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.14  2003/08/25 20:46:26  SLizardo
 * Optimize Imports
 *
 * Revision 1.13  2003/08/21 17:48:38  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.12  2003/08/14 14:40:02  SLizardo
 * Se actualizo el Logger (Globals. a TmkLogger.)
 *
 * Revision 1.11  2003/08/13 18:51:58  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.10  2003/08/12 22:08:15  GPistoia
 * -Se borraron las paginas viejas
 * -Se agregaron las paginas nuevas
 * -Se actualizo el proyecto y elimino el disco V
 *
 * Revision 1.9  2003/08/12 16:26:09  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.8  2003/08/11 14:26:54  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.7  2003/08/09 22:54:57  SLizardo
 * no message
 *
 * Revision 1.6  2003/08/08 20:13:47  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.5  2003/08/08 19:19:33  SLizardo
 * Modificaciones para Integrar Compra
 *
 * Revision 1.4  2003/08/07 18:10:25  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.3  2003/08/06 21:29:27  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.2  2003/08/04 22:17:57  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.1  2003/08/02 16:58:31  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 */
package com.tmk.controllers.compra;

import com.tmk.kernel.*;
import com.tmk.orden.OrdenDAO;

import com.tmk.setup.Contenido;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
//import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
//import com.tmk.socio.BufferSocioLocal;
//import com.tmk.socio.SocioLocalHome;
//import com.tmk.socio.BufferSocioLocalHome;
import com.tmk.src.socio.BufferSocioPK;
import com.tmk.src.socio.SocioPK;
//import com.tmk.socio.SocioLocal;
import com.tmk.bus.socio.BufferSocios;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.alianza.EstadisticaVisitas;
//import com.tmk.controllers.carrito.CarritoUtil;
//import com.tmk.fidelizacion.PuntajeWrapper;
import com.tmk.src.fidelizacion.PuntajeWrapper;
//import com.tmk.fidelizacion.FidelizacionHelper;
//import com.tmk.util.ShortCuts;
//import javax.ejb.FinderException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Vector;
import java.util.Hashtable;
import com.tmk.orden.Promocion2;

public class CompraHelper {

	public static String PARAMETRO_CUPON = "CUPON";  // Campo publicado, no cambiar

	public static int visitasDePaginaPapeles;
	public static int visitasDePaginaDomicilioDeEnvio;
	public static int visitasDePaginaDomicilioDeFacturacion;
	public static int visitasDePaginaFormaDePago;
	public static int visitasDePaginaConfirmacion;

	public static String FLAG_ES_CARRITO = "CARRITO";

	public static String FLAG_PAPEL = "TIENE_PAPEL";

	public static String CAMPO_PAPEL = "PAPEL_DE_REGALO";
	public static String CAMPO_MENSAJE = "NOTA_DE_REGALO";
	public static String CAMPO_CUPON = "CUPON";
	public static String CAMPO_MEDIO_COBRO = "MEDIO_DE_COBRO";
	public static String CAMPO_TIPO_TARJETA = "TIPO_DE_TARJETA";
	public static String CAMPO_NUMERO_TARJETA = "NUMERO_DE_TARJETA";
	public static String CAMPO_TITULAR = "TITULAR";
	public static String CAMPO_CODIGO = "CODIGO_DE_SEGURIDAD";
	public static String CAMPO_MES = "MES";
	public static String CAMPO_ANO = "AÑO";
	public static String CAMPO_TIPO_DOC = "TIPO_DOCUMENTO";
	public static String CAMPO_NRO_DOC = "NUMERO_DOCUMENTO";
	public static String CAMPO_DOMICILIO_ENVIO = "DOMICILIO_DE_ENVIO";
	public static String CAMPO_TELEFONO = "TELEFONO";
	public static String CAMPO_HORARIO = "HORARIO";
	public static String CAMPO_COMENTARIO = "COMENTARIO";
	public static String CAMPO_TARJETA_EXTRA = "TARJETA_EXTRA";
	public static String CAMPO_PLAN_DE_CUOTAS = "CAMPO_PLAN_DE_CUOTAS";
	public static String CAMPO_NOMBRES_RECEPTOR = "NOMBRES_RECEPTOR";
	public static String CAMPO_APELLIDOS_RECEPTOR = "APELLIDOS_RECEPTOR";
	public static String CAMPO_TIPO_DOC_RECEPTOR = "TIPO_DOC_RECEPTOR";
	public static String CAMPO_NRO_DOC_RECEPTOR = "NRO_DOC_RECEPTOR";
	public static String CAMPO_RANGO_HORARIO_RECEPTOR = "RANGO_HORARIO_RECEPTOR";


	//tarjeta prepaga
	public static String CAMPO_TARJETA_PREPAGA = "TPP";
	public static String CAMPO_TARJETA_PREPAGA1 = "TPP1";
	public static String CAMPO_TARJETA_PREPAGA2 = "TPP2";
	public static String CAMPO_TARJETA_PREPAGA3 = "TPP3";
	public static String CAMPO_TARJETA_PREPAGA4 = "TPP4";
	public static String CAMPO_TARJETA_PREPAGA5 = "TPP5";

	public static final int PAIS_BRASIL = 4;
	public static String CAMPO_CPF_CNPJ = "CAMPO_CPF_CNPJ";
	public static String ES_CPF_CNPJ = "ES_CPF_CNPJ";

	public static String CODIGO_ERROR = "CODIGO_ERROR";

	public static String URL_REDIRECT = "URL_REDIRECT";

	public static String PAGINA_HOME_SITIO          = "/index.jsp";
	public static String PAGINA_CARRITO             = "/compra/carrito.jsp";
	public static String PAGINA_REGISTRACION        = "/miCuenta/index.jsp";
	public static String PAGINA_DOMICILIO_          = "/compra/domicilios.jsp?" + DatosDomicilio.ID + "=";
	public static String PAGINA_MEDIO_DE_COBRO      = "/compra/medioDeCobro.jsp";
	public static String PAGINA_PAPEL_DE_REGALO     = "/compra/papelDeRegalo.do";
	public static String PAGINA_FAX                 = "/compra/pagoPorFax.jsp";
	public static String PAGINA_CONFIRMA_COMPRA     = "/compra/confirmacion.jsp";
	public static String PAGINA_DETALLE_COMPRA_     = "/compra/detalleDeOrden.jsp?idOrden=";
	public static String PAGINA_PAGO_CON_FALLAS     = "/compra/pagoConFallas.jsp";
	public static String PAGINA_MI_CUENTA           = "/compra/misOrdenes.jsp";


	public static final void redirectTo(HttpServletResponse response, String page) throws IOException {
		response.sendRedirect(page);
	}

	public static final void setAttribute(HttpServletRequest request, String field, Object data) {
		request.getSession().setAttribute(field, data);
	}

	/**
	 * CHEQUEA DOS COSAS: 
	 * <pre>Que la orden no sea nula y que no tenga estado readOnly=true</pre>
	 * @param request
	 * @param response
	 * @param ordenDAO
	 * @return boolean, indicando si esta abierta la orden.
	 * @throws IOException
	 */
	public static final boolean verificaOrdenAbierta(HttpServletRequest request, HttpServletResponse response, OrdenDAO ordenDAO) throws IOException {
		TmkLogger.debug("Verifica si tiene una orden...");
		if (ordenDAO == null) {
			redirectTo(response, PAGINA_MI_CUENTA );
			return false;
		}

		TmkLogger.debug("Verifica si se termino la orden...");
		if (ordenDAO.isReadOnly()) {
			redirectTo(response, ProcesoCompraUtil.PAGINA_DETALLE_COMPRA_ + ordenDAO.getIdOrdenProcesada());
			return false;
		}

		return true;
	}
	/**
	 *Metodo que realiza las siguientes valiaciones<br>:
	 * Verifica que el server no este bajando...<br>
	 * Verifica si tiene articulos...<br>
	 * Verifica si esta logueado...<br>
	 * Verifica que el usuario exista y tenga login...<br>
	 * Verifica monto minimo de orden...<br>
	 * Verifica monto maximo de orden...<br>
	 * @param request
	 * @param response
	 * @param ordenDAO
	 * @return
	 * @throws IOException
	 */
	public static final boolean continuaProceso(HttpServletRequest request, HttpServletResponse response, OrdenDAO ordenDAO) throws IOException {
		if (!verificaOrdenAbierta(request, response, ordenDAO)) return false;

		TmkLogger.debug("Verifica que el server no este bajando...");
		if (Globals.baseDeDatosEnMantenimiento()) {
			redirectTo(response, PAGINA_HOME_SITIO);
			return false;
		}

		TmkLogger.debug("Verifica si tiene articulos...");
		if (!ordenDAO.tieneArticulos()) {
			//redirectTo(response, PAGINA_HOME_SITIO);
			redirectTo(response, PAGINA_CARRITO);			
			return false;
		}

		TmkLogger.debug("Verifica si esta logueado...");
		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		if (socioPK == null) {
			if (ordenDAO.getPedirPapelesYNotas()) {
				setAttribute(request, MainHelper.URL_REDIRECT, PAGINA_PAPEL_DE_REGALO);
			} else {
				setAttribute(request, MainHelper.URL_REDIRECT, PAGINA_DOMICILIO_+DomicilioDAO.HEADER_ENVIO);
			}
			redirectTo(response, PAGINA_REGISTRACION);
			return false;
		} else {
			boolean esSocioTMK = Convert.toBoolean((Boolean)request.getSession().getAttribute("socioTMK"), false);
			if (esSocioTMK) {
				if (ordenDAO.getPedirPapelesYNotas()) {
					setAttribute(request, MainHelper.URL_REDIRECT,PAGINA_PAPEL_DE_REGALO);
				} else {
					setAttribute(request, MainHelper.URL_REDIRECT, PAGINA_DOMICILIO_+DomicilioDAO.HEADER_ENVIO);
				}
				redirectTo(response, MainHelper.PAGE_REGISTRO_SOCIO_CADENA);
				return false;
			}else{
				setAttribute(request, MainHelper.URL_REDIRECT, null);
			}
		}

		TmkLogger.debug("Verifica que el usuario exista y tenga login...");
		try {
			SocioPK pk = new SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO);
			Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(pk);
			TmkLogger.debug("Logueado como " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()));
			if ((socio.getId_sucursal() == null) || (socio.getId_socio() == null)) {
				throw new Exception("Uno de los campos requeridos de socio es nulo, o no se pudo cargar el socio.");
			}
			pk = null;
			socio = null;
		//PARCHE PARA SOCIOS UNIFICADOS
		}catch (DBOInexistenteException fe) {
			//Si no encuentro el socio, puede que el proceso de unificacion lo haya borrado
			//Trato de salvar la compra buscando al socio definitivo, a traves de los datos que
			//quedan en buffer socio
			TmkLogger.debug("No encontro el socio por pk, lo busco en buffer");
			try {
				BufferSocios bufferSocio = ServiceLocator.getBufferSocioService().findByPrimaryKey(new BufferSocioPK(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO));
				
				TmkLogger.debug("Socio encontrado en buffer");
				Socios2 socio = (Socios2)ServiceLocator.getSocioService().findRepetidosAUnificar(bufferSocio.getSexo(),
																		bufferSocio.getTipo_doc(),
																		bufferSocio.getNro_doc(),
																		bufferSocio.getNacionalidad()).iterator().next();
				TmkLogger.debug("Socio encontrado en socios por PK Cadena");
				
				TmkLogger.debug("Logueado como " + Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()));
				setAttribute(request, "Registracion.socioPK", new SocioPK(socio.getId_sucursal(), socio.getId_socio()));
				setAttribute(request, "Registracion.nombreCompleto", Convert.nombreCompleto(socio.getNombres(), socio.getApellidos()));
				setAttribute(request, "Registracion.nombre", Convert.capitalizarOriginal(socio.getNombres(), true).toString());
				setAttribute(request, "Registracion.login", socio.getlogin());
				
				//Lo envio a seleccionar de nuevo domicilio porque es probable que no coincida
				redirectTo(response, PAGINA_DOMICILIO_+DomicilioDAO.HEADER_ENVIO);

				MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_WEBMASTER, "TMK - Cambio de socio en compra",
				"El socio " + socioPK.ID_SUCURSAL + "-" + socioPK.ID_SOCIO + " se modifico por el socio "
				+ socio.getId_sucursal() + "-" + socio.getId_socio());
				
				//nuleo los datos
				bufferSocio = null;
				socio = null;
				return false;				
			} catch (Exception e) {
				TmkLogger.error("CompraHelper] " + e.toString() + MainHelper.getMessage(e));
			}
		// FIN PARCHE PARA SOCIOS UNIFICADOS
		} catch (Exception e) {
			String error = "El Socio (" + socioPK.ID_SUCURSAL + ":" + socioPK.ID_SOCIO + ") fallo al intentar comprar. " + e.getMessage();
			TmkLogger.info(error);
			//MailUtil.sendMail(Globals.MAIL_MAILER, new String [] {Globals.MAIL_WEBMASTER, "dwinnik@ilhsa.com", "rmiranda@ilhsa.com", "dwainer@ilhsa.com"}, "Problemas de Registracion", error);
			MailUtil.sendMail(Globals.MAIL_MAILER, new String [] {Globals.MAIL_WEBMASTER}, "Problemas de Registracion", error);
			setAttribute(request, URL_REDIRECT, PAGINA_REGISTRACION);
			setAttribute(request, CODIGO_ERROR, "La dirección de mail es obligatoria para poder comprar productos.");
				redirectTo(response, PAGINA_PAGO_CON_FALLAS);
			return false;
		}

		TmkLogger.debug("Verifica monto minimo de orden...");
		if (ordenDAO.totalSitioCompleto() < Globals.REGLA_LIMITE_COMPRA_MINIMO) {
			setAttribute(request, URL_REDIRECT, PAGINA_CARRITO);
			setAttribute(request, CODIGO_ERROR, "El monto mínimo de compra es de "  + Contenido.precioToString(Globals.REGLA_LIMITE_COMPRA_MINIMO));
				redirectTo(response, PAGINA_PAGO_CON_FALLAS);
			return false;
		}
		TmkLogger.debug("Verifica monto maximo de orden...");
		if (ordenDAO.totalSitioCompleto() > Globals.REGLA_LIMITE_COMPRA_MAXIMO) {
			setAttribute(request, URL_REDIRECT, PAGINA_CARRITO);
			setAttribute(request, CODIGO_ERROR, "El monto máximo de compra es de "  + Contenido.precioToString(Globals.REGLA_LIMITE_COMPRA_MAXIMO));
			redirectTo(response, PAGINA_PAGO_CON_FALLAS);
			return false;
		}

		return true;
	}

	public static final void proximoEstado(HttpServletRequest request, HttpServletResponse response, OrdenDAO ordenDAO) throws IOException {
		// Si la orden termino, la muestra de lectura
		if (!verificaOrdenAbierta(request, response, ordenDAO)) return;

		// No continuar con este proceso
		if (!continuaProceso(request, response, ordenDAO)) return;

		SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
		//Socios2 socioLocal = ShortCuts.findSocioById(socioPK);
		//Socios2 socioLocalDBO = ServiceLocator.getSocioService().findByPK(socioPK);
		Socios2 socioLocal;
		try {
			socioLocal = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
		} catch (Exception e) {
			throw new IOException(e.getMessage());
		}
		TmkLogger.debug("Socio " + socioPK.ID_SUCURSAL + ":" + socioPK.ID_SOCIO);

		// No configuro el papel, entonces lo hace
		TmkLogger.debug("Verifica si necesita papeles y notas...");
		if (ordenDAO.getPedirPapelesYNotas()) {
			redirectTo(response, ProcesoCompraUtil.PAPEL_REGALO);
			return;
		}

		// Solo pide la direccion si tiene articulos a su mombre
		TmkLogger.debug("Verificando si necesita domicilio de envio...");
        if (ordenDAO.getDomicilioEnvio() == null) {
			if (ordenDAO.tieneArticulosPersonales() || (ordenDAO.getDomicilioListaDeDeseos() == null)) {
				redirectTo(response, ProcesoCompraUtil.ENTREGA);	
				return;
			}
		}

		// Solo pide la direccion si tiene articulos a su mombre
		TmkLogger.debug("Verifica si necesita domicilio de facturacion...");
		if (ordenDAO.getDomicilioFacturacion() == null) {
			redirectTo(response, ProcesoCompraUtil.ENTREGA);
			return;
		}

		// Configura como va a pagar las cosas
		TmkLogger.debug("Verifica si necesita medio de cobro...");
		if (ordenDAO.getMedioDeCobro() == null) {
            TmkLogger.debug("inicio medio cobro...");
			// Especialmente para cuotas. Intenta calcular cuanto va hasta ahora ya que va a mostrar el importe de cuotas.
			recalcularConceptosFacturables(ordenDAO, socioPK);

			// Trata de consultar quien es el usuario, y si tiene cuenta
			if (Globals.FIDELIZACION_VIGENTE) {
				//PuntajeWrapper puntajeWrapper = FidelizacionHelper.cargarPuntajeEnSession(request.getSession(), socioLocal);
				PuntajeWrapper puntajeWrapper = com.tmk.src.fidelizacion.FidelizacionHelper.cargarPuntajeEnSession(request.getSession(), socioLocal);
				if (puntajeWrapper == null) {
					TmkLogger.debug("No encontro ninguna cuenta para ponerle los puntos...");
				} else {
					com.tmk.fidelizacion.PuntajeWrapper puntajeEjb = new com.tmk.fidelizacion.PuntajeWrapper(
							puntajeWrapper.getSexo(),
							puntajeWrapper.getTipoDeDocumento(),
							puntajeWrapper.getNumeroDeDocumento(),
							puntajeWrapper.getNacionalidad()
						);
					ordenDAO.setPuntajeWrapper(puntajeEjb);
					ordenDAO.setNumeroTarjetaExtra(puntajeWrapper.getNumeroDeTarjeta());
					// El usuario tiene cuenta, propone sumarle puntos
					TmkLogger.debug("Se le van a cargar puntos a la tarjeta " + ordenDAO.getNumeroTarjetaExtra() + "...");
				}
			}
            TmkLogger.debug("fin medio cobro...");

			// Salta a la pagina de medio de cobro
			redirectTo(response, ProcesoCompraUtil.VISTA_MEDIO_DE_PAGO);	
            return;
		}

		if (ordenDAO.getDomicilioEnvio() != null) {
			if ((ordenDAO.getDomicilioEnvio().getPais().getId() == CompraHelper.PAIS_BRASIL)
					&& ordenDAO.getCPF_CNPJ() == null) {
					redirectTo(response, ProcesoCompraUtil.ENTREGA);			
				return;
			}
		}

		if (!ordenDAO.getPinValido() && ordenDAO.getMedioDeCobro().esTarjeta()) {
			redirectTo(response, ProcesoCompraUtil.ENTREGA+"#MSJ_PIN");
			return;
		}

		TmkLogger.info("Cupon especificado [" + Convert.toString(ordenDAO.getCupon(), "Ninguno") + "]");

		Integer idAlianza = (Integer)request.getSession().getAttribute(EstadisticaVisitas.ID_ALIANZA_SITIO);
		Integer idSeccion = (Integer)request.getSession().getAttribute(EstadisticaVisitas.ID_SECCION_SITIO);
		TmkLogger.debug((idAlianza == null) ? "Sin Alianza" : "Aplica Alianza " + idAlianza + " Seccion " + idSeccion);
		ordenDAO.setAlianza(idAlianza, idSeccion);

		// Para cambios en valores indirectos
		recalcularConceptosFacturables(ordenDAO, socioPK);

		TmkLogger.debug((ordenDAO.getTarjetaPlanDAO() == null) ? "No corresponde pago en cuotas" : ordenDAO.getTarjetaPlanDAO().toString());
		TmkLogger.debug((ordenDAO.getInteresCobradoDAO() == null) ? "No corresponde pago de intereses" : ordenDAO.getInteresCobradoDAO().toString());

		// No tiene mas nada que cambiar, entonces muestra la confirmacion
		TmkLogger.debug("Salta a la pagina de confirmacion...");

		//el valor seguir en el request, indica que el usuario avanza pagina por pagina dentro del proceso, sin importar la hubicacion dentro del mismo.
		//no salta de pantallas automaticamente a la ultima donde estuvo.
		if(request.getAttribute("seguir")!=null){
			redirectTo(response, (String)request.getAttribute("seguir"));
		}
		else {
			redirectTo(response, ProcesoCompraUtil.VISTA_PREVIA);
		}
	}

	public static final void recalcularConceptosFacturables(OrdenDAO ordenDAO, SocioPK socioPK) {

		if (socioPK == null) return;

		cargarGastosDeEnvio(ordenDAO);

		//RECARGO POR PAGO EN EFECTIVO
		double importeExtra = ((ordenDAO.getMedioDeCobro() == null) || (!ordenDAO.getMedioDeCobro().esReembolso()))
        ? 0.0 : Globals.CARGO_POR_ENVIO_CONTRAREEMBOLSO;

		for (int i=0; i<ordenDAO.getArticulos().size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO) ordenDAO.getArticulos().get(i);
			if (articulo.getGastoDeEvio() != null && articulo.getGastoDeEvio().esGastoBasico()) {
				TmkLogger.debug("total orden sin recargo: " + ordenDAO.totalSitioCompleto());
				double monto = (ordenDAO.totalSitioCompleto() * importeExtra) /100;

				// mg20130422: no suma el importe del reembolso a los gastos de envio
				//articulo.getGastoDeEvio().agregarRecargo(monto);
			}
		}

		//bloque validacion quid evito calcular promociones si es la suscripcion
		/*if(!CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
			Promocion2.aplicarPromocion(ordenDAO, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
			ordenDAO.recalcularIntereses();
		}*/
		//fin
		
		Promocion2.aplicarPromocion(ordenDAO, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
		ordenDAO.recalcularIntereses();
		
		// calculo reembolso 
		ordenDAO.setImporteReembolso((ordenDAO.totalSitioCompleto(true) * importeExtra) /100);

		//tarjeta prepaga
		if (ordenDAO.getMedioDeCobro() != null) {
			ordenDAO.setImporteParaOrden(ordenDAO.getTotalMedioDeCobro());
		}
		//tarjeta prepaga
	}

	public static final void cargarGastosDeEnvio(OrdenDAO ordenDAO) {

		// cancela el metodo de envio
		ordenDAO.setMetodoDeEnvio(null);

		// Pone un gasto default
		//ordenDAO.anulaGastosDeEnvio();

		// Si no tiene productos lo tiene que dejar vacio
		if (!ordenDAO.tieneArticulos()) return;

		// El gasto es sobre la direccion de envio
		DomicilioDAO domicilio = ordenDAO.getAlgunDomicilioEnvio();
		if (domicilio == null) return;

		PaisDAO paisDAO = domicilio.getPais();
		if (paisDAO == null) return;

		ProvinciaDAO provinciaDAO = domicilio.getProvincia();
		if (provinciaDAO == null) return;

		TmkLogger.debug("Recalcula gastos de envio...");

//      borro PROMOS
		ordenDAO.eliminarPromos();
//		borro los gastos de envio
		ordenDAO.eliminarGastosDeEnvio();

		try {
			//double totalSitio = ordenDAO.totalSitio();
			//int cantidadDeArticulos = ordenDAO.getCantidadArticulosEnTotal();

			Vector valores = DBUtil.cargarDatosDeGastosDeEnvio(paisDAO, provinciaDAO);
			int parametros = 0;
			double importeBasico = ((Number)valores.get(parametros++)).doubleValue();
			double importeAdicional = ((Number)valores.get(parametros++)).doubleValue();
			String metodoEnvio = (valores.get(parametros++)).toString();
			// configura el metodo de envio que viene segun el gasto
			ordenDAO.setMetodoDeEnvio(metodoEnvio);

			TmkLogger.debug("Gasto de envio para " + paisDAO + ", " + provinciaDAO + " por " + metodoEnvio);

            // configura los importes segun la logica de gastos
            if (importeBasico > 0.0) {
            	//GastosEnvioDAO gastoBasico = null;
                GastosEnvioDAO gastoBasico =
                (paisDAO.esArgentina())
                        ? new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_LOCAL, 1)
                        : new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_EXTERIOR, 1);
               
            	//BLOQUE NECESARIO PARA SUSCRIPCION QUID        
               /* if(paisDAO.esArgentina()){
                	//si la suscripcion esta en la orden aplico el gasto asociado a la suscripcion
                	if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
                		gastoBasico = new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_LOCAL_QUID, 1);
                	}else{
                		//si no es la suscripcion sigo el camino comun, gasto basico 
                		gastoBasico = new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_LOCAL, 1);
                	}
                }else{
                	gastoBasico = new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_EXTERIOR, 1);
                }*/
                //FIN BLOQUE
                gastoBasico.setPrecio(importeBasico); 
               
                //SETEO EL GASTO BASICO AL PRIMER ARTICULO POSIBLE
                if (ordenDAO.getArticulos().size() > 0) {
                	boolean gastoSeteado = false;
                	boolean hayUnArticuloConCantidadUno = false;
                	//busco el primero con catidad uno
                	for (int i=0; i<ordenDAO.getArticulos().size() && !gastoSeteado; i++) {
                		ArticuloDAO articulo = (ArticuloDAO)ordenDAO.getArticulos().get(i);
                		if (articulo.getCantidad() == 1) {
                			hayUnArticuloConCantidadUno = true;
                			gastoSeteado = true;
                			//bloque para suscripcio quid
                			//if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
                			//	gastoBasico = new GastosEnvioDAO(Globals.GASTO_ENVIO_BASICO_MERC_LOCAL_QUID, 1);
                			//	articulo.setGastoDeEvio(gastoBasico);
                            //}else{
                            	articulo.setGastoDeEvio(gastoBasico);
                            //}
                			//fin bloque
                		}
                	}
                	// si no hay un articulo con cantidad uno
                	if (!hayUnArticuloConCantidadUno) {
                		//TmkLogger.debug("No hay articulos con cantidad 1");
	                	for (int i=0; i<ordenDAO.getArticulos().size() && !gastoSeteado; i++) {
	                		ArticuloDAO articulo = (ArticuloDAO)ordenDAO.getArticulos().get(i);
	                		
	            				if (articulo.getCantidad() >1) {
	        						ArticuloDAO nuevo = articulo.duplicate();
	        						nuevo.setCantidad(1);
	        						nuevo.setGastoDeEvio(gastoBasico);
	        						articulo.setCantidad(articulo.getCantidad()-1);

	        						if (articulo.getPapelDeRegalo() != null) {
	        							articulo.getPapelDeRegalo().setCantidad(articulo.getCantidad());
	        							nuevo.getPapelDeRegalo().setCantidad(nuevo.getCantidad());
	        						}
	        						ordenDAO.addArticuloConPromo(nuevo);
	            				} else {
	            					articulo.setGastoDeEvio(gastoBasico);
	            				}
	            				gastoSeteado = true;	                		
	                	}
                	}
                }
            }
            //agrego chequeo quid, no le agrego gasto adicional
            if (importeAdicional>0.0) {
            //if (importeAdicional>0.0 && !CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))) {
            	for (int i=0; i<ordenDAO.getArticulos().size(); i++) {
            		ArticuloDAO articulo = (ArticuloDAO)ordenDAO.getArticulos().get(i);            		
            			if (articulo.getGastoDeEvio() == null) {
            				GastosEnvioDAO gastoAdicional =(paisDAO.esArgentina())
        	            	? new GastosEnvioDAO(Globals.GASTO_ENVIO_ADICIONAL_MERC_LOCAL, 1)
        	    			: new GastosEnvioDAO(Globals.GASTO_ENVIO_ADICIONAL_MERC_EXTERIOR, 1);
        	            	gastoAdicional.setPrecio(importeAdicional);
            				gastoAdicional.setCantidad(articulo.getCantidad());
            				articulo.setGastoDeEvio(gastoAdicional);
            			}            		
            	}
            }

            ordenDAO.reordenarArticulos();
		} catch (Exception e) {
			TmkLogger.error("Error de calculo de gasto de envio." + e.getMessage());
		} finally {

			TmkLogger.debug("Basico: " + Convert.toString(ordenDAO.getGastoDeEnvioBasico(), "NO") + ", Adicional: " + Convert.toString(ordenDAO.getGastoDeEnvioAdicional(), "NO"));

		}

	}

	// Da un mensaje explicando si la tarjeta es seguramente correcta o no
	public static String mensajeComprobacion(com.tmk.orden.OrdenDAO ordenDAO) {
		for (int i = 0; i < Globals.TARJETAS_RANGOS.length; i++) {
			TarjetaRangoDAO tarjetaRangoDAO = Globals.TARJETAS_RANGOS[i];
			String tarjetaIngresada = ordenDAO.get_NumeroTarjetaCompletoDesencriptado();
			int primerosDigitos = Convert.toNumber(tarjetaIngresada.substring(0, tarjetaRangoDAO.getCantidadCaracteres()), 0);
			if ((tarjetaRangoDAO.getNroDesde() >= primerosDigitos) && (tarjetaRangoDAO.getNroHasta() <= primerosDigitos)) {
				if (!tarjetaRangoDAO.getIdMedioDeCobro().equals(ordenDAO.getMedioDeCobro().getId())) return "Cambie la tarjeta a " + MedioDeCobroDAO.buscaMedioDeCobro(tarjetaRangoDAO.getIdMedioDeCobro()).getNombre();
				if (!tarjetaRangoDAO.isPermiteCuotas()) return "La tarjeta no permite cuotas";
				if (tarjetaRangoDAO.getLongitud() != tarjetaIngresada.length()) return "La tarjeta seguramente debería tener " + tarjetaRangoDAO.getLongitud() + " digitos";
			}
		}
		return null; // Significa no mostrar ningun mensaje
	}

	@SuppressWarnings("unchecked")
	public static boolean esPinValido(String nroTarjeta, String idMedioDePago) {
		Hashtable PIN = new Hashtable();
		String PIN_VRIO []={"450980", "450979", "450995", "448459", "493763", "462982", "451766 "};
		String PIN_ARIO []={"377790", "377791"};
		PIN.put("VRIO", PIN_VRIO);
		PIN.put("ARIO", PIN_ARIO);


		String pines [];
		pines = (String[])PIN.get(idMedioDePago);
		if (pines == null || pines.length == 0) {
			return true;
		}
		for (int i=0; i<pines.length; i++) {
			if (nroTarjeta.startsWith(pines[i])) {
				return true;
			}
		}
		return false;
	}

}
