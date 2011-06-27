/**
 * $Log: OrdenDAO.java,v $
 * Revision 1.74  2008/05/30 16:03:17  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.73  2007/12/18 20:10:33  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.72  2007/05/28 19:19:45  omsartori
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
 * Revision 1.71  2007/02/13 13:17:29  omsartori
 * -Correcciones Rediseño
 * -Ranking estatico
 * -Mas vendidos y arbol de familias estatico
 *
 * Revision 1.70  2006/12/18 20:06:12  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.69  2006/12/13 17:15:50  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.68  2006/10/12 14:59:04  omsartori
 * no message
 *
 * Revision 1.67  2006/10/09 13:05:37  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.66  2006/09/28 14:57:46  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.65  2006/09/14 18:24:47  omsartori
 * Promociones II
 *
 * Revision 1.64  2006/06/22 18:30:43  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.63  2006/05/19 14:24:27  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.62  2006/01/11 17:37:17  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.61  2005/12/29 17:45:18  omsartori
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
 * Revision 1.60  2005/12/13 16:16:38  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.59  2005/11/24 15:28:08  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.58  2005/11/14 13:47:51  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.57  2005/11/04 12:55:37  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.56  2005/10/24 15:09:41  oDZurita
 * - Grabación de hasta 2 formas de pago para la misma orden de compra.
 *
 * Revision 1.55  2005/10/12 15:31:27  oDZurita
 *
 * Revision 1.54  2005/10/11 18:16:49  oDZurita
 *
 * Revision 1.53  2005/10/11 16:04:38  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.52  2005/09/22 18:38:26  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.51  2005/09/16 16:30:53  omsartori
 * - Promo dia de la madre
 *   - validacion de form de envio
 *   - legales y validacion
 *   - pagina reglamento
 * - Descripcion de promo aplicada en la pantalla de confirmacion de compra (modif OrdenDAO).
 *
 * Revision 1.50  2005/07/18 13:52:52  omsartori
 * - Modificaciones en referido
 * - ejb articulo reducido
 * - buscador de editor por id
 *
 * Revision 1.49  2005/02/17 12:13:59  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.48  2005/01/25 15:52:19  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.47  2004/10/08 22:50:06  oGPistoia
 * - Adaptaciones al diseño de eXtra III
 * - Bug en Nombre Receptor en componentes
 * - Interes de 0.01 por redondeo eliminado
 *
 * Revision 1.46  2004/10/05 21:29:24  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.45  2004/09/30 14:17:12  oGPistoia
 * -Pago en tarjeta en cuotas
 *
 * Revision 1.44  2004/09/24 18:19:14  oGPistoia
 * - Nombres y Apellidos del receptor del pedido terminado.
 *
 * Revision 1.43  2004/08/03 15:48:25  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.42  2004/07/08 20:18:57  oGPistoia
 * - Logs en background
 * - Limpieza del cache de ordenes inteligente
 * - Mantenimiento de imagenes sin generar para evitar reincidencia
 *
 * Revision 1.41  2004/06/30 18:23:09  oGPistoia
 * - Resolucion del problema de java al grabar archivo de imagen
 * - Tiempo de demora al generar una orden
 * - Recorrido por categorias ahora segun mas vendidos
 * - ISBN e Idioma para Google
 *
 * Revision 1.40  2004/06/15 20:57:15  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.39  2004/02/16 20:24:04  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.38  2004/01/08 20:30:04  GPistoia
 * - Retoques por release, antes del buscador
 *
 * Revision 1.37  2003/12/22 22:27:43  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.36  2003/12/04 17:20:18  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.35  2003/11/26 15:37:54  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.34  2003/10/28 01:40:04  GPistoia
 * -Mejoras de textos
 * -Alianza y seccion que no grababa en la base
 * -Otros cambios varios desde el viernes, por repositorio roto.
 *
 * Revision 1.33  2003/10/09 19:30:01  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.32  2003/10/07 14:53:15  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.31  2003/10/03 16:29:49  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.30  2003/09/29 17:20:46  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.29  2003/09/19 19:49:01  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.28  2003/09/18 18:56:22  GPistoia
 * -Oculte los radio buttons de ir a papel de regalo.
 * -Iteracion en GPay
 *
 * Revision 1.27  2003/09/17 19:32:12  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.26  2003/09/16 19:31:06  GPistoia
 * -Se agrego la posibilidad de seleccionar nivel de log
 * -Capacidad de limitar la cantidad de caracteres a grabar de la tarjeta
 * -Bug de acentos y tildes contra javascript
 *
 * Revision 1.25  2003/09/15 22:31:29  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.24  2003/09/11 18:09:31  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.23  2003/09/09 13:28:34  GPistoia
 * -Cambio en tabla Disponibilidad
 * -Cambio en package Promocion
 * -Lista de paises-provincias-localidades
 *
 * Revision 1.22  2003/09/08 13:54:40  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.21  2003/09/05 19:57:05  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.20  2003/09/04 21:39:57  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.19  2003/09/02 19:08:31  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.18  2003/08/29 17:55:01  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.17  2003/08/27 18:43:55  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.16  2003/08/26 16:19:28  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.15  2003/08/22 14:03:57  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.14  2003/08/21 17:48:30  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.13  2003/08/15 15:59:58  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.12  2003/08/13 18:51:54  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.11  2003/08/12 22:06:07  GPistoia
 * -Se borraron las paginas viejas
 * -Se agregaron las paginas nuevas
 * -Se actualizo el proyecto y elimino el disco V
 *
 * Revision 1.10  2003/08/12 16:25:32  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.9  2003/08/09 18:22:04  GPistoia
 * -Autores en el articulo
 *
 * Revision 1.8  2003/08/08 20:13:44  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.7  2003/08/07 18:10:21  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.6  2003/08/06 21:28:34  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.5  2003/08/04 22:17:54  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.4  2003/08/04 19:55:01  SLizardo
 * BugFixes and Migration
 *
 * Revision 1.3  2003/08/02 16:58:23  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:05  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:13  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */

package com.tmk.orden;

import com.tmk.kernel.*;
import com.tmk.socio.SocioPK;
import com.tmk.fidelizacion.PuntajeWrapper;

import javax.ejb.FinderException;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.Date;
import java.util.Iterator;
import java.util.Vector;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public class OrdenDAO implements Serializable {

	private int idOrden;

	private Date fechaDeInicio;
	private Date fechaDeCierre;

	private Vector articulos = new Vector();

	private MedioDeCobroDAO medioDeCobro;

	private DomicilioDAO domicilioEnvio;

	private DomicilioDAO domicilioFacturacion;

	private DomicilioDAO domicilioListaDeDeseos;

	private GastosEnvioDAO gastoDeEnvioBasico;
	private GastosEnvioDAO gastoDeEnvioAdicional;

	private byte[] numeroTarjeta;
	private String codigoSeguridad;
	private int mesVencimiento;
	private int anoVencimiento;
	private String nombreCliente;
	private String tipoDocumento;
	private long numeroDocumento;

	private boolean esTarjetaNueva;

	private boolean pedirPapelesYNotas = true;      // a pedido del usuario

	private String domicilioResumen;

	private String estado;

	private String telefonoContacto;
	private String horarioContacto;
	private String comentario;

	private String cupon;

	private boolean readOnly;

	private Integer idAlianza;
	private Integer idSeccion;

	private Integer idDominio;

	private NivelDeRiesgoDAO nivelDeRiesgo;
	private String motivoDeRiesgo;

	private String metodoDeEnvio;

	private String nombreSocio;
	private String mailSocio;

	private Integer gpayCodigoRespuesta;
	private Integer gpayCodigoAutorizacion;
	private String gpayMensajeRespuesta;

	private String numeroTarjetaExtra;
	private PuntajeWrapper puntajeWrapper;

	private String nombresReceptor;
	private String apellidosReceptor;

	private TarjetaPlanDAO tarjetaPlanDAO;

	private InteresCobradoDAO interesCobradoDAO;

	private boolean cheque;

	private double valorDeChequeRestante = 0.0;

	private String CPF_CNPJ = null;
    private Integer NRO_DOC_RECEPTOR = null;
    private String TIPO_DOC_RECEPTOR = null;
    private String RANGO_HORARIO_RECEPTOR = null;

    private boolean pinValido = true;	
    
    private Vector tarjetasPrepagas = new Vector();
        
    
	public OrdenDAO() {
		super();
		// La crea el usuario, registra la fecha de creacion
		fechaDeInicio = new Date();
	}

	public OrdenDAO(int idOrden) {
		super();
		// La crea desde la base, registra el id
		this.idOrden = idOrden;
		// La fuerza a ser readonly
		setReadOnly(true);
	}

	// Se fija de borrar todos los datos importantes para que no continue la compra bajo ningun concepto
	public void cerrarDatosDeCompra(int idOrden, Date fechaDeCierre, String nombreSocio, String mailSocio) {
		//
		// Copia los campos correspondientes
		this.idOrden = idOrden;
		this.fechaDeCierre = fechaDeCierre;
		this.pedirPapelesYNotas = false;
		this.nombreSocio = nombreSocio;
		this.mailSocio = mailSocio;
		// la marca como lectura
		setReadOnly(true);
	}

    public void removeArticuloByPos(int pos) {
    	
    	for (int i =pos+1; i<articulos.size(); i++) {
    		((ArticuloDAO)articulos.get(i)).setPosicionEnLista(((ArticuloDAO)articulos.get(i)).getPosicionEnLista()-1);
    	}
    	articulos.remove(pos);
    }
    
    public void removeArticuloByPosIDArticulo(int pos, int idArticulo) {
    	if (pos < articulos.size()) {
    		if (((ArticuloDAO)articulos.get(pos)).getId() == idArticulo) {
		    	for (int i =pos+1; i<articulos.size(); i++) {
		    		((ArticuloDAO)articulos.get(i)).setPosicionEnLista(((ArticuloDAO)articulos.get(i)).getPosicionEnLista()-1);
		    	}
		    	articulos.remove(pos);
    		}	
    	}	
    }
    
    public void setMedioDeCobro(MedioDeCobroDAO medioDeCobro) {
		this.medioDeCobro = medioDeCobro;
	}

    public int getIdOrdenProcesada() {
		return idOrden;
	}

	public Date getFechaDeInicio() {
		return fechaDeInicio;
	}

	public Date getFechaDeCierre() {
		return fechaDeCierre;
	}

	public String getNombreSocio() {
		return nombreSocio;
	}

	public String getMailSocio() {
		return mailSocio;
	}

	public MedioDeCobroDAO getMedioDeCobro() {
		return medioDeCobro;
	}

	public ArticuloDAO getArticulo(int index) {
		return (ArticuloDAO) articulos.get(index);
	}

	public ArticuloDAO getArticuloById(int idArticulo) {
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO current = (ArticuloDAO) articulos.get(i);
			if (current.getId() == idArticulo) {
				return current;
			}
		}
		return null;
	}

	public void cambiarCantidad(ArticuloDAO articuloDAO, int cantidad, SocioPK socioPK) {
		// llama y luego graba
		cambiarCantidadSinGrabarCarrito(articuloDAO, cantidad);
		// sincroniza el carrito persistente
		grabarCarritoCompra(socioPK);
	}

	public void cambiarCantidadSinGrabarCarrito(ArticuloDAO articuloDAO, int cantidad) {
		// le cambia la cantidad actual y graba el carrito
		articuloDAO.cambiarCantidad(cantidad);
		// no debe mantenerse el anterior
		//anulaGastosDeEnvio();
	}

	
	
	public void addArticulo(ArticuloDAO articuloDAO, SocioPK socioPK) throws FinderException, NamingException {
		articuloDAO.setReadOnly(readOnly);
        boolean found = false;
        for (int i = 0; (i < articulos.size()) && (!found); i++) {
            ArticuloDAO temp = (ArticuloDAO) articulos.get(i);
            found = (temp.getId() == articuloDAO.getId());
            if (found) {
                temp.setCantidad(temp.getCantidad() + articuloDAO.getCantidad());
                if (temp.getPapelDeRegalo() != null) {
                	temp.getPapelDeRegalo().setCantidad(temp.getCantidad());
                }
            }
        }
        if (!found) {
        	articulos.add(articuloDAO);
        	articuloDAO.setPosicionEnLista(articulos.size()-1);
        }
        // guarda la fecha de cuando lo ingreso
		articuloDAO.setFechaDeCarrito(new Date());
		grabarCarritoCompra(socioPK);
	}

	public void addArticuloDesdeCarrito(ArticuloDAO articuloDAO, Date fechaDeCarrito) {
		articuloDAO.setReadOnly(readOnly);
		boolean found = hasArticulo(articuloDAO.getId());
		// no esta, lo agrega
		if (!found) {
			articulos.add(articuloDAO);
			articuloDAO.setPosicionEnLista(articulos.size()-1);
		}
		// guarda la fecha de cuando lo ingreso
		articuloDAO.setFechaDeCarrito(fechaDeCarrito);
		// no debe mantenerse el anterior
		eliminarGastosDeEnvio();
	}


	public void removeArticuloById(int idArticulo, SocioPK socioPK) {
		// borra el articulo
		removeArticuloByIdSinGrabarCarrito(idArticulo);
		// sincroniza el carrito persistente
		grabarCarritoCompra(socioPK);
		if (idArticulo == 418897) {
			removeArticuloById(428081, socioPK);
		}
	}

	public void removeArticuloByIdSinGrabarCarrito(int idArticulo) {
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO temp = (ArticuloDAO) articulos.get(i);
			if (temp.getId() == idArticulo) {
				articulos.remove(i);
				break;
			}
		}
		// no debe mantenerse el anterior
		//anulaGastosDeEnvio();
	}

	public void removeArticulo(int index, SocioPK socioPK) {
		articulos.remove(index);
		grabarCarritoCompra(socioPK);
	}

	public Vector getArticulos() {
		return articulos;
	}
	
	public void setArticulos(Vector articulos) {
		this.articulos = articulos; 
	}

	public boolean hasArticulo(int idArticulo) {
		boolean found = false;
		for (int i = 0; (i < articulos.size()) && (!found); i++) {
			found = (((ArticuloDAO) articulos.get(i)).getId() == idArticulo);
		}
		return found;
	}

	public boolean tieneArticulos() {
		return (!articulos.isEmpty());
	}

	public int getCantidadArticulos() {
		return articulos.size();
	}

	public int getCantidadArticulosEnTotal() {
		int result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articuloDAO = (ArticuloDAO) articulos.get(i);
			result += articuloDAO.getCantidad();
		}
		return result;
	}

	/**
	 * Da los articulos elegidos por el cliente sin incluir papel o gasto
	 */
	public Vector soloLosArticulos() {
		Vector result = new Vector();
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO current = (ArticuloDAO) articulos.get(i);
			result.add(current);
		}
		return result;
	}

	/**
	 * Solo los papeles elegidos
	 */
	private Vector soloPapeles() {
		Vector papeles = new Vector();
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articuloDAO = (ArticuloDAO) articulos.get(i);
			if (articuloDAO.getPapelDeRegalo() != null) {
				/*Lo comente y lo cambie no se porque lo recarga*/
				/*Si hay un cambio de precios durante la compra lo rompe*/
				//ArticuloDAO papelCopiado = articuloDAO.getPapelDeRegalo().duplicate();
				ArticuloDAO papelCopiado = articuloDAO.getPapelDeRegalo();
				papelCopiado.cambiarCantidad(articuloDAO.getCantidad());
				papeles.add(papelCopiado);
			}
		}

		return papeles;
	}




	/**
	 * Articulos elegidos y papeles pero sin el gasto
	 */
	public Vector todosLosArticulosSinGastoDeEnvio() {
		Vector result = new Vector();
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO current = (ArticuloDAO) articulos.get(i);
			result.add(current);
			if (current.getSubArticulo() != null) result.add(current.getSubArticulo());
		}
		return result;
	}

	/**
	 * Absolutamente todos los productos
	 */
	
	public Vector todosLosArticulos() {
		Vector result = new Vector();
		for (int i=0; i< articulos.size(); i++) {
			result.add((ArticuloDAO)articulos.get(i));
			if (((ArticuloDAO)articulos.get(i)).getGastoDeEvio() != null) {
				result.add ((ArticuloDAO)((ArticuloDAO)articulos.get(i)).getGastoDeEvio());
			}
			if (((ArticuloDAO)articulos.get(i)).getPapelDeRegalo() != null) {
				result.add ((ArticuloDAO)((ArticuloDAO)articulos.get(i)).getPapelDeRegalo());
			}
		}
		
		
		return result;
	}

	public boolean soloArticulosPersonales() {
		return (articulosPersonales().size() == articulos.size());
	}

	public boolean tieneArticulosPersonales() {
		return (articulosPersonales().size() > 0);
	}

	public Vector articulosListaDeDeseos() {
		Vector result = new Vector();
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articuloDAO = (ArticuloDAO) articulos.get(i);
			if (articuloDAO.esParaListaDeseos()) {
				result.add(articuloDAO);
			}
		}
		return result;
	}

	public Vector articulosPersonales() {
		Vector result = new Vector();
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articuloDAO = (ArticuloDAO) articulos.get(i);
			if (articuloDAO.esPersonal()) {
				result.add(articuloDAO);
			}
		}
		return result;
	}

	public Vector agruparDuplicados() {
		Vector origen = soloPapeles();
		Vector result = new Vector();
		for (int i = 0; i < origen.size(); i++) {
			ArticuloDAO current = (ArticuloDAO) origen.get(i);
			boolean found = false;
			for (int j = 0; (j < result.size()) && (!found); j++) {
				found = current.equals(result.get(j));
				if (found) {
					ArticuloDAO duplicado = (ArticuloDAO) result.get(j);
					ArticuloDAO copia;
				}
			}
			if (!found) {
				result.add(current);
			}
		}

		return result;
	}

	public double totalConImpuesto() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalConImpuesto();
		}
		return Convert.round(result);
	}

	public double totalOriginalCompleto() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalOriginalCompleto();
			if (((ArticuloDAO) articulos.get(i)).getGastoDeEvio() != null) {
				result += ((ArticuloDAO) articulos.get(i)).getGastoDeEvio().totalOriginalCompleto();
			}
		}
		
		return Convert.round(result);
	}

	public double totalConImpuestoCompleto() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalConImpuestoCompleto();
		}
		return Convert.round(result);
	}

	public double totalSubArticulosConImpuesto() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalSubArticulosConImpuesto();
		}
		return Convert.round(result);
	}

	public double totalSubArticulosSitio() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalSubArticulosSitio();
		}
		return Convert.round(result);
	}

	public double totalSitio() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalSitio();
		}
		return Convert.round(result);
	}

	public double totalSitioCompletoSinGastoDeEnvio() {
		double result = 0;
		for (int i = 0; i < articulos.size(); i++) {
			result += ((ArticuloDAO) articulos.get(i)).totalSitioCompleto();
		}
		return Convert.round(result);
	}

	public double totalSitioCompletoSinIntereses() {
		double result = totalSitioCompletoSinGastoDeEnvio() + totalGastoDeEnvio();
		return Convert.round(result);
	}

	public double totalSitioCompletoParaPlan(TarjetaPlanDAO tarjetaPlanDAO) {
		//double result = totalSitioCompletoSinIntereses();
		double result =  totalProductos() + totalGastos() + totalPapeles();
		result = (tarjetaPlanDAO == null) ? result : tarjetaPlanDAO.calculaTotalConIntereses(result);
		return Convert.round(result);
	}

//PROMO II
	public double interesesSobreTotal() {
		return Convert.round(totalSitioCompleto() - totalSitioCompletoSinIntereses());
	}
	
//PROMO II	
	public double subTotal() {
		double total = 0.0; 
		//double interes = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			double precioArticulo = (articulo.getPrecioPromocion() < articulo.getPrecioConDescuento())?
					articulo.getPrecioPromocion() * articulo.getCantidad():
						articulo.getPrecioConDescuento() * articulo.getCantidad();
			total = total + precioArticulo;
		}
		return Convert.round(total);
	}
	
	
//PROMOII
	public double totalSitioCompleto() {
		double total = 0.0; 
		//double interes = 0.0;
		total = (interesCobradoDAO == null) ? 0.0 : interesCobradoDAO.getPrecioPromocion();
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			double precioArticulo = (articulo.getPrecioPromocion() < articulo.getPrecioConDescuento())?
					articulo.getPrecioPromocion() * articulo.getCantidad():
						articulo.getPrecioConDescuento() * articulo.getCantidad();
			total = total + precioArticulo;
			if (articulo.getGastoDeEvio() != null) {
				total = total + articulo.getGastoDeEvio().getPrecioPromocion() * articulo.getGastoDeEvio().getCantidad();
			}
			if (articulo.getPapelDeRegalo() != null) {
				total = total + articulo.getPapelDeRegalo().getPrecioPromocion() * articulo.getPapelDeRegalo().getCantidad(); 
			}
		}
		return Convert.round(total);
	}

	

	//PROMOCIONES II
	public double totalGastoDeEnvio() {
		double total = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			if (((ArticuloDAO)articulos.get(i)).getGastoDeEvio() != null) {
				total = total + ((ArticuloDAO)articulos.get(i)).getGastoDeEvio().getPrecioPromocion() 
				* ((ArticuloDAO)articulos.get(i)).getGastoDeEvio().getCantidad();
			}
		}
		return Convert.round(total);
	}
	
	//PROMOCIONES II
	public double totalPapelDeRegalo() {
		double total = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			if (((ArticuloDAO)articulos.get(i)).getPapelDeRegalo() != null) {
				total = total + ((ArticuloDAO)articulos.get(i)).getPapelDeRegalo().getPrecioPromocion()
				* ((ArticuloDAO)articulos.get(i)).getPapelDeRegalo().getCantidad();
			}
		}
		return Convert.round(total);
	}

	public double totalGastoDeEnvioSinDescuento() {
		double total = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			if (((ArticuloDAO)articulos.get(i)).getGastoDeEvio() != null) {
				total += ((ArticuloDAO)articulos.get(i)).getGastoDeEvio().getPrecioPromocion() 
				* ((ArticuloDAO)articulos.get(i)).getCantidad();
			}
		}
		return Convert.round(total);
	}

	public boolean tienenSubArticulos() {
		boolean found = false;
		for (int i = 0; i < articulos.size() && (!found); i++) {
			ArticuloDAO articulo = (ArticuloDAO) articulos.get(i);
			found = (articulo.getSubArticulo() != null);
		}
		return found;
	}

	public boolean tienenNotas() {
		boolean found = false;
		for (int i = 0; i < articulos.size() && (!found); i++) {
			ArticuloDAO articulo = (ArticuloDAO) articulos.get(i);
			found = (articulo.getNota() != null && !"".equals(articulo.getNota())); //||
			        //((articulo.getSubArticulo() != null) && (articulo.getSubArticulo().getNota() != null));			
		}
		return found;
	}

	public DomicilioDAO getAlgunDomicilioEnvio() {
		return (domicilioEnvio == null) ? domicilioListaDeDeseos : domicilioEnvio;
	}

	public DomicilioDAO getDomicilioEnvio() {
		return domicilioEnvio;
	}

	public void setDomicilioEnvio(DomicilioDAO domicilioEnvio) {
		this.domicilioEnvio = domicilioEnvio;
	}

	public DomicilioDAO getDomicilioFacturacion() {
		return domicilioFacturacion;
	}

	public void setDomicilioFacturacion(DomicilioDAO domicilioFacturacion) {
		this.domicilioFacturacion = domicilioFacturacion;
	}

	public DomicilioDAO getDomicilioListaDeDeseos() {
		return domicilioListaDeDeseos;
	}

	public void setDomicilioListaDeDeseos(DomicilioDAO domicilioListaDeDeseos) {
		this.domicilioListaDeDeseos = domicilioListaDeDeseos;
	}

	public String get_NumeroTarjetaCompletoDesencriptado() {
		return Seguridad.desencriptarTarjeta(numeroTarjeta);
	}

	public String get_CodigoSeguridad() {
		return codigoSeguridad;
	}

	public int get_MesVencimiento() {
		return mesVencimiento;
	}

	public int get_AnoVencimiento() {
		return anoVencimiento;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Long getNumeroDocumento() {
		return new Long(numeroDocumento);
	}

	public void completarDatosTarjeta(
	        String numeroTarjetaCompleto, String codigoSeguridad,
	        int mesVencimiento, int anoVencimiento,
	        String nombreCliente, String tipoDocumento, long numeroDocumento,
	        String domicilioResumen,
	        MedioDeCobroDAO medioDeCobro,
	        String estado) {

		if (!medioDeCobro.esTarjeta()) throw new Error("No se especifico el medio de pago correcto");
		// la guardo encriptada porque este objeto se baja a disco
		completarDatosTarjeta(numeroTarjetaCompleto, codigoSeguridad,
		        mesVencimiento, anoVencimiento,
		        nombreCliente, tipoDocumento, numeroDocumento, domicilioResumen);
		// medio de cobro a marcar
		this.medioDeCobro = medioDeCobro;
		this.estado = estado;
	}

	public void completarDatosTarjeta(
	        String numeroTarjetaCompleto, String codigoSeguridad,
	        int mesVencimiento, int anoVencimiento,
	        String nombreCliente, String tipoDocumento, long numeroDocumento,
	        String domicilioResumen) {
		// la guardo encriptada porque este objeto se baja a disco
		this.numeroTarjeta = Seguridad.encriptarTarjeta(numeroTarjetaCompleto);
		this.codigoSeguridad = codigoSeguridad;
		this.mesVencimiento = mesVencimiento;
		this.anoVencimiento = anoVencimiento;
		this.nombreCliente = nombreCliente;
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.domicilioResumen = domicilioResumen;
	}

	/**
	 * Agrega a la orden: 
	 *  	String telefonoContacto, String horarioContacto, String comentario,
	        MedioDeCobroDAO medioDeCobro, String estado
	 * @param telefonoContacto
	 * @param horarioContacto
	 * @param comentario
	 * @param medioDeCobro
	 * @param estado
	 */
	public void completarDatosMedioDeCobro(
	        String telefonoContacto, String horarioContacto, String comentario,
	        MedioDeCobroDAO medioDeCobro,
	        String estado) {
		this.telefonoContacto = telefonoContacto;
		this.horarioContacto = horarioContacto;
		this.comentario = comentario;
		this.medioDeCobro = medioDeCobro;
		this.estado = estado;
	}

	public void setTarjetaNueva(boolean esTarjetaNueva) {
		this.esTarjetaNueva = esTarjetaNueva;
	}

	public boolean esTarjetaNueva() {
		return esTarjetaNueva;
	}

	/*CUANDO TERMINE DE SACAR LOS GAASTOS DE LA ORDEN LO BORRO*/
	public GastosEnvioDAO getGastoDeEnvioBasico() {
		return gastoDeEnvioBasico;
	}

	public GastosEnvioDAO getGastoDeEnvioAdicional() {
		return gastoDeEnvioAdicional;
	}

	public void setGastoDeEnvioBasico(GastosEnvioDAO gastoDeEnvioDAO) {
		this.gastoDeEnvioBasico = gastoDeEnvioDAO;
		boolean seteado = false;

		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO art = (ArticuloDAO)articulos.get(i);
			art.setGastoDeEvio(null);
		}

		for (int i=0; i<articulos.size() && !seteado; i++) {
			ArticuloDAO art = (ArticuloDAO)articulos.get(i);
			art.setGastoDeEvio(gastoDeEnvioDAO);
			seteado = true;
		}
	}

	public void setGastoDeEnvioAdicional(GastosEnvioDAO gastoDeEnvioDAO) {
		this.gastoDeEnvioAdicional = gastoDeEnvioDAO;

		for (int i=0; i<articulos.size(); i++) {

			ArticuloDAO art = (ArticuloDAO)articulos.get(i);

			if (art.getGastoDeEvio() == null) {
				art.setGastoDeEvio(gastoDeEnvioDAO);
			}
		}
	}
		

	public String getDomicilioResumen() {
		return domicilioResumen;
	}

	public void setDomicilioResumen(String domicilioResumen) {
		this.domicilioResumen = domicilioResumen;
	}

	public String getIdEstado() {
		return estado;
	}

	public void setIdEstado(String ultimoEstado) {
		this.estado = ultimoEstado;
	}

	public EstadoOrdenDAO getEstado() {
		return EstadoOrdenDAO.buscaEstadoOrden(estado);
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public String getHorarioContacto() {
		return horarioContacto;
	}

	public String getComentario() {
		return comentario;
	}

	public boolean tarjetasIguales(byte[] encriptada) {
		return new String(numeroTarjeta).equalsIgnoreCase(new String(encriptada));
	}

	public String numeroTarjetaAMostrar() {
		return Seguridad.numeroTarjetaAMostrar(numeroTarjeta);
	}

	public byte[] numeroTarjetaAGrabar() {
		return Seguridad.numeroTarjetaAGrabar(numeroTarjeta);
	}

	public byte[] getP1() {
		String parte = Seguridad.desencriptarTarjeta(numeroTarjeta).substring(0, 5); // los primero 5 caracteres
		return CryptUtil.encriptar(parte.getBytes());
	}

	public byte[] getP2() {
		String parte = Seguridad.desencriptarTarjeta(numeroTarjeta).substring(5, 6); // el sexto
		return CryptUtil.encriptar(parte.getBytes());
	}

	public byte[] getP3() {
		String original = Seguridad.desencriptarTarjeta(numeroTarjeta);
		int begin = original.length() - 4;
		int end = original.length();
		String parte = original.substring(begin, end); // los ultimos 4
		return CryptUtil.encriptar(parte.getBytes());
	}

	public boolean getPedirPapelesYNotas() {
        return pedirPapelesYNotas;
        
	}

	public void setPedirPapelesYNotas(boolean pedirPapelesYNotas) {
		this.pedirPapelesYNotas = pedirPapelesYNotas;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
		for (int i = 0; i < articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO) articulos.get(i);
			articulo.setReadOnly(readOnly);
		}
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public boolean isReadWrite() {
		return !readOnly;
	}

	public boolean tieneAlianza() {
		return (idAlianza != null); //|| (idSeccion != null); // podria venir idseccion en null
	}

	public void setAlianza(Integer idAlianza, Integer idSeccion) {
		this.idAlianza = idAlianza;
		this.idSeccion = idSeccion;
	}

	public Integer getIdAlianza() {
		return idAlianza;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setNivelDeRiesgo(NivelDeRiesgoDAO nivelDeRiesgo) {
		this.nivelDeRiesgo = nivelDeRiesgo;
	}

	public NivelDeRiesgoDAO getNivelDeRiesgo() {
		return nivelDeRiesgo;
	}

	public void setMotivoDeRiesgo(String motivoDeRiesgo) {
		this.motivoDeRiesgo = motivoDeRiesgo;
	}

	public String getMotivoDeRiesgo() {
		return motivoDeRiesgo;
	}

	public String getCupon() {
		return cupon;
	}

	public void setCupon(String cupon) {
		this.cupon = (cupon == null) ? null : cupon.toUpperCase().trim();
	}

	public boolean tieneDominio() {
		return (idDominio != null);
	}

	public Integer getIdDominio() {
		return idDominio;
	}

	public void setIdDominio(Integer idDominio) {
		this.idDominio = idDominio;
	}

	public String getMetodoDeEnvio() {
		return metodoDeEnvio;
	}

	public void setMetodoDeEnvio(String metodoDeEnvio) {
		this.metodoDeEnvio = metodoDeEnvio;
	}

	public Integer getGpayCodigoRespuesta() {
		return gpayCodigoRespuesta;
	}

	public void setGpayInfo(Integer gpayCodigoRespuesta, Integer gpayCodigoAutorizacion, String gpayMensajeRespuesta) {
		this.gpayCodigoRespuesta = gpayCodigoRespuesta;
		this.gpayCodigoAutorizacion = gpayCodigoAutorizacion;
		this.gpayMensajeRespuesta = gpayMensajeRespuesta;
	}

	public Integer getGpayCodigoAutorizacion() {
		return gpayCodigoAutorizacion;
	}

	public String getGpayMensajeRespuesta() {
		return gpayMensajeRespuesta;
	}

	public String getNumeroTarjetaExtra() {
		return numeroTarjetaExtra;
	}

	public void setNumeroTarjetaExtra(String numeroTarjetaExtra) {
		this.numeroTarjetaExtra = numeroTarjetaExtra;
	}

	public PuntajeWrapper getPuntajeWrapper() {
		return puntajeWrapper;
	}

	public void setPuntajeWrapper(PuntajeWrapper puntajeWrapper) {
		this.puntajeWrapper = puntajeWrapper;
	}

	public String getNombresReceptor() {
		return nombresReceptor;
	}

	public void setNombresReceptor(String nombresReceptor) {
		this.nombresReceptor = nombresReceptor;
	}

	public String getApellidosReceptor() {
		return apellidosReceptor;
	}

	public void setApellidosReceptor(String apellidosReceptor) {
		this.apellidosReceptor = apellidosReceptor;
	}

	public boolean tieneOtroReceptor() {
		return (nombresReceptor != null) && (apellidosReceptor != null);
	}

	public TarjetaPlanDAO getTarjetaPlanDAO() {
		return tarjetaPlanDAO;
	}

	public void setTarjetaPlanDAO(TarjetaPlanDAO tarjetaPlanDAO) {
		this.tarjetaPlanDAO = tarjetaPlanDAO;
		recalcularIntereses();
	}

	public void setInteresCobradoDAO(InteresCobradoDAO interesCobradoDAO) {
		this.interesCobradoDAO = interesCobradoDAO;
	}

	public InteresCobradoDAO getInteresCobradoDAO() {
		return interesCobradoDAO;
	}

	public void recalcularIntereses() {
		// borrar el interes
		interesCobradoDAO = null;
		try {
			// Si paga en un plan de cuotas y el coeficiente no es 1, es decir, tiene interes
			if ((tarjetaPlanDAO != null) && (tarjetaPlanDAO.getCoeficiente() != 1.0)) {
				interesCobradoDAO = new InteresCobradoDAO(Globals.ID_ARTICULO_INTERES_COBRADO);
				if (medioDeCobro.esTarjeta()) {

					double totalConIntereses = totalSitioCompletoParaPlan(tarjetaPlanDAO);
					if (!interesCobradoDAO.tienePromocion()) {
						interesCobradoDAO.setPrecio(totalConIntereses - (totalProductos() + totalGastos() + totalPapeles()));
					}	
					
				}
			}
		} catch (Exception e) {
			// ERROR
			TmkLogger.info("No se pudo calcular el interes");
		}
	}

	public String toString() {
		return "Orden: " + medioDeCobro + ", articulos: " + articulos.size();
	}

	public boolean tieneCheque() {
		return cheque;
	}

	public void setCheque(boolean parCheque) {
		cheque = parCheque;
	}

	
	public void setCPF_CNPJ (String CPF_CNPJ) {
		this.CPF_CNPJ = CPF_CNPJ;
	}

	public String getCPF_CNPJ() {
		return CPF_CNPJ;
	}



	public Integer getNRO_DOC_RECEPTOR() {
		return NRO_DOC_RECEPTOR;
	}

	public void setNRO_DOC_RECEPTOR(Integer NRO_DOC_RECEPTOR) {
        this.NRO_DOC_RECEPTOR = NRO_DOC_RECEPTOR;
	}

	public String getTIPO_DOC_RECEPTOR() {
		return TIPO_DOC_RECEPTOR;
	}

	public void setTIPO_DOC_RECEPTOR(String TIPO_DOC_RECEPTOR) {
		this.TIPO_DOC_RECEPTOR = TIPO_DOC_RECEPTOR;
	}

	public String getRANGO_HORARIO_RECEPTOR() {
		return RANGO_HORARIO_RECEPTOR;
	}

	public void setRANGO_HORARIO_RECEPTOR(String RANGO_HORARIO_RECEPTOR) {
		this.RANGO_HORARIO_RECEPTOR = RANGO_HORARIO_RECEPTOR;
	}

	public void setValorDeChequeRestante (double valor) {
		this.valorDeChequeRestante = valor;
	}

	public double getValorDeChequeRestante () {
		return valorDeChequeRestante;
	}

    public double getTotalMedioDeCobro() {
	    double totalMedio=0.0;
		totalMedio = totalSitioCompleto();
	    return totalMedio;
    }

  
	/*Tarjeta Prepaga*/
	public void addTarjetaPrepaga(TarjetaPrepaga tarjetaPrepaga) {
		boolean agregar = true;
		for (int i=0; i<tarjetasPrepagas.size(); i++) {
        	if (((TarjetaPrepaga)tarjetasPrepagas.get(i)).getNro().equals(tarjetaPrepaga.getNro())) {
		        agregar = false;
		        i = tarjetasPrepagas.size();
	        }
		}
		if (agregar) {
			tarjetasPrepagas.add(tarjetaPrepaga);
		}
	}

	public void removeTarjetasPrepagas() {
		tarjetasPrepagas.clear();
	}

	public Vector getTarjetasPrepagas() {
		return tarjetasPrepagas;
	}

	public double getSaldoDisponible() {
		double saldo = 0.0;
	    for (int i=0; i<tarjetasPrepagas.size(); i++) {
		    TarjetaPrepaga tarjetaPrepaga = (TarjetaPrepaga) tarjetasPrepagas.get(i);
		    saldo += tarjetaPrepaga.getSaldoDisponible();
	    }
		return Convert.round(saldo);
	}

    public void setImporteParaOrden(double saldoTotal) {
        for (int i=0; i<tarjetasPrepagas.size(); i++) {
            TarjetaPrepaga tarjetaPrepaga = (TarjetaPrepaga) tarjetasPrepagas.get(i);
	        double importeAAplicar = 0.0;
	        if (saldoTotal > tarjetaPrepaga.getSaldoDisponible()) {
                importeAAplicar = tarjetaPrepaga.getSaldoDisponible();
	        } else {
		        importeAAplicar = saldoTotal;
	        }
	        tarjetaPrepaga.setImporteParaOrden(Convert.round(importeAAplicar));
	        saldoTotal = saldoTotal - Convert.round(importeAAplicar);
        }
    }

	public boolean grabarTransaccionDeTarjetasPrepagas(int idOrden) throws Exception {
		boolean retorno = false;
		
		if (tarjetasPrepagas.size()>0) {
			Connection connection = DBUtil.buildConnection();
			try {
				connection.setAutoCommit(false);
				PreparedStatement statement = connection.prepareStatement(
						"  INSERT INTO tarjeta_prepaga_transaccion" +
						"  (nro, tipo, importe, id_orden, id_sucursal)" +
						"  values (?,?,?,?,?)") ;
				try {
					for (int i =0; i<tarjetasPrepagas.size(); i++) {
						TarjetaPrepaga tarjeta = (TarjetaPrepaga) tarjetasPrepagas.get(i);
						if (tarjeta.estaHabilitada() && tarjeta.getImporteParaOrden() > 0) {
							statement.setString(1, tarjeta.getNro());
							statement.setString(2, TarjetaPrepaga.getCodigoDeTransaccion());
							statement.setDouble(3, ((-1) * tarjeta.getImporteParaOrden()));
							statement.setInt(4, idOrden);
							statement.setInt(5, Globals.ID_SUCURSAL_TEMATIKA);
							statement.executeQuery();
						}
					}
					connection.commit();
					retorno = true;
				} catch (Exception e) {
					TmkLogger.error("TARJETA PREPAGA] error al grabar la transaccion. Orden " + idOrden + e.toString());
					connection.rollback();
				} finally {
					statement.close();
				}
			} catch	(Exception e) {
				TmkLogger.error("TARJETA PREPAGA] error al grabar la transaccion. Orden " + idOrden + e.toString());
			} finally {
				connection.close();
			}
		}
		return retorno;
	}

	public String tarjetasPrepagasHabilitadasToString () {
		StringBuffer txt = new StringBuffer();
		for (int i=0; i<tarjetasPrepagas.size(); i++) {
			if (((TarjetaPrepaga)tarjetasPrepagas.get(i)).estaHabilitada()) {
				txt.append(" Tarjeta Nro ");
				txt.append(((TarjetaPrepaga)tarjetasPrepagas.get(i)).getNro());
				txt.append(". ");
			}
		}
		return txt.toString();
	}

	public void setTarjetasPrepagasDeLaOrden(int idOrden) throws Exception {
		removeTarjetasPrepagas();
        Connection connection = DBUtil.buildConnection();
		try {
			 PreparedStatement statement = connection.prepareStatement(
					" SELECT tp.nro, tp.saldo, tp.estado, tpt.importe " +
					" FROM tarjeta_prepaga tp " +
					" INNER JOIN tarjeta_prepaga_transaccion tpt" +
					" ON tp.nro = tpt.nro" +
					" WHERE tpt.id_orden = ?");
				statement.setInt(1, idOrden);
			try {
				ResultSet resultset = statement.executeQuery();
				try {
					while (resultset.next()) {
						this.addTarjetaPrepaga(new TarjetaPrepaga (resultset.getString("nro"),
																   resultset.getString("estado"),
																   resultset.getDouble("saldo"),
																   idOrden,
																   (-1)*resultset.getDouble("importe")));
					}
				} finally {
					resultset.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}
   /*Tarjeta Prepaga*/

	public boolean getPinValido() {
		return pinValido;
	}
	
	public void setPinValido(boolean pinValido) {
		this.pinValido = pinValido;
	}
	
	
	public int getCuotas () {
		return (tarjetaPlanDAO != null)? this.tarjetaPlanDAO.getCuotas(): 0;
	}
	
	
	public void addArticuloConPromo(ArticuloDAO articuloNuevo) {
		int encontrado = -1;
		for (int i=0; i<articulos.size() && (encontrado==-1); i++) {
			ArticuloDAO articuloEnLista = (ArticuloDAO)articulos.get(i);
			if (articuloEnLista.getId() == articuloNuevo.getId() 
					&& articuloEnLista.getIdCampaign() == articuloNuevo.getIdCampaign()
					&& articuloEnLista.getIdPromo1() == articuloNuevo.getIdPromo1()
					&& articuloEnLista.getIdPromo2() == articuloNuevo.getIdPromo2()
					&& articuloEnLista.getIdPromo3() == articuloNuevo.getIdPromo3()
					&& articuloEnLista.getIdPromo4() == articuloNuevo.getIdPromo4()
					&& articuloEnLista.getIdPromo5() == articuloNuevo.getIdPromo5()
					&& articuloEnLista.getPrecioPromocionSinImpuestos() == articuloNuevo.getPrecioPromocionSinImpuestos()
					&& articuloEnLista.tieneMismoGastoDeEnvio(articuloNuevo)
					&& articuloEnLista.tieneMismoPapelDeRegalo(articuloNuevo)
			) { 
				encontrado = i;
				//System.out.println("encontrado");
			}
			
		}
		if (encontrado!= -1) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(encontrado);
			articulo.setCantidad(articulo.getCantidad() + articuloNuevo.getCantidad());
			if (articulo.getGastoDeEvio() != null) {
				articulo.getGastoDeEvio().setCantidad(articulo.getGastoDeEvio().getCantidad() + articuloNuevo.getGastoDeEvio().getCantidad());
			}
			if (articulo.getPapelDeRegalo() != null) {
				articulo.getPapelDeRegalo().setCantidad(articulo.getPapelDeRegalo().getCantidad() + articuloNuevo.getPapelDeRegalo().getCantidad());
			}
			
		} else {
			articulos.add(articuloNuevo);
			articuloNuevo.setPosicionEnLista(articulos.size()-1);
		}
	}
	
	public void eliminarGastosDeEnvio() {
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			articulo.setGastoDeEvio(null);
		}
	}
	
	public void eliminarPromos() {
		if (articulos !=null) {
			for (int i=0; i<articulos.size(); i++) {
				ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
				articulo.borrarPromocion();
				if(articulo.getGastoDeEvio() != null ) {
					articulo.getGastoDeEvio().borrarPromocion();
				}
				if(articulo.getPapelDeRegalo() != null ) {
					articulo.getPapelDeRegalo().borrarPromocion();
				}
			}
		}	
	}
	
	public boolean tieneGastoBasico() {
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo =  (ArticuloDAO)articulos.get(i);
			if(articulo.getGastoDeEvio() != null) {
				if (articulo.getGastoDeEvio().esGastoBasico()) {
					return true;
				}
			}
		}	
		return false;
	}
	
	public double totalProductos() {
		double total = 0.0; 
		//double interes = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			double precioArticulo = (articulo.getPrecioPromocion() < articulo.getPrecioConDescuento())?
					articulo.getPrecioPromocion() * articulo.getCantidad():
						articulo.getPrecioConDescuento() * articulo.getCantidad();
			total = total + precioArticulo;
		}
		return Convert.round(total);
	}
	
	public double totalGastos() {
		double total = 0.0; 
		//double interes = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			if (((ArticuloDAO)articulos.get(i)).getGastoDeEvio() != null) {
				ArticuloDAO articulo = ((ArticuloDAO)articulos.get(i)).getGastoDeEvio();
				double precioArticulo = (articulo.getPrecioPromocion() < articulo.getPrecioConDescuento())?
						articulo.getPrecioPromocion() * articulo.getCantidad():
							articulo.getPrecioConDescuento() * articulo.getCantidad();
				total = total + precioArticulo;
			}	
		}
		return Convert.round(total);
	}
	
	public double totalPapeles() {
		double total = 0.0; 
		//double interes = 0.0;
		for (int i=0; i<articulos.size(); i++) {
			if (((ArticuloDAO)articulos.get(i)).getPapelDeRegalo() != null) {
				ArticuloDAO articulo = ((ArticuloDAO)articulos.get(i)).getPapelDeRegalo();
				double precioArticulo = (articulo.getPrecioPromocion() < articulo.getPrecioConDescuento())?
						articulo.getPrecioPromocion() * articulo.getCantidad():
							articulo.getPrecioConDescuento() * articulo.getCantidad();
				total = total + precioArticulo;
			}	
		}
		return Convert.round(total);
	}

	public String getPromocionesAplicadas(String separador) {
		StringBuffer promos = new StringBuffer("");
		for (int i=0; i<articulos.size(); i++) {
			ArticuloDAO articulo = (ArticuloDAO)articulos.get(i);
			if (articulo.getNombreCampaign() != null && !"".equals(articulo.getNombreCampaign())) {
				if (promos.indexOf(articulo.getNombreCampaign()) == -1) {
					promos.append(separador).append(articulo.getNombreCampaign());
					
				}
			}
			if (articulo.getNombrePromo1() != null && !"".equals(articulo.getNombrePromo1())) {
				if (promos.indexOf(articulo.getNombrePromo1()) == -1) {
					promos.append(separador).append(articulo.getNombrePromo1());
					
				}
			}
			if (articulo.getNombrePromo2() != null && !"".equals(articulo.getNombrePromo2())) {
				if (promos.indexOf(articulo.getNombrePromo2()) == -1) {
					promos.append(separador).append(articulo.getNombrePromo2());
					
				}
			}
			if (articulo.getNombrePromo3() != null && !"".equals(articulo.getNombrePromo3())) {
				if (promos.indexOf(articulo.getNombrePromo3()) == -1) {
					promos.append(separador).append(articulo.getNombrePromo3());
					
				}
			}
			if (articulo.getNombrePromo4() != null && !"".equals(articulo.getNombrePromo4())) {
				if (promos.indexOf(articulo.getNombrePromo4()) == -1) {
					promos.append(separador).append(articulo.getNombrePromo4());
					
				}
			}
			if (articulo.getNombrePromo5() != null && !"".equals(articulo.getNombrePromo5())) {
				if (promos.indexOf(articulo.getNombrePromo5()) == -1) {
					promos.append(separador).append(articulo.getNombrePromo5());
					
				}
			}
			ArticuloDAO gasto = articulo.getGastoDeEvio();
			if (gasto != null) {
				if (gasto.getNombreCampaign() != null && !"".equals(gasto.getNombreCampaign())) {
					if (promos.indexOf(gasto.getNombreCampaign()) == -1) {
						promos.append(separador).append(gasto.getNombreCampaign());
						
					}
				}
				if (gasto.getNombrePromo1() != null && !"".equals(gasto.getNombrePromo1())) {
					if (promos.indexOf(gasto.getNombrePromo1()) == -1) {
						promos.append(separador).append(gasto.getNombrePromo1());
						
					}
				}
				if (gasto.getNombrePromo2() != null && !"".equals(gasto.getNombrePromo2())) {
					if (promos.indexOf(gasto.getNombrePromo2()) == -1) {
						promos.append(separador).append(gasto.getNombrePromo2());
						
					}
				}
				if (gasto.getNombrePromo3() != null && !"".equals(gasto.getNombrePromo3())) {
					if (promos.indexOf(gasto.getNombrePromo3()) == -1) {
						promos.append(separador).append(gasto.getNombrePromo3());
						
					}
				}
				if (gasto.getNombrePromo4() != null && !"".equals(gasto.getNombrePromo4())) {
					if (promos.indexOf(gasto.getNombrePromo4()) == -1) {
						promos.append(separador).append(gasto.getNombrePromo4());
						
					}
				}
				if (gasto.getNombrePromo5() != null && !"".equals(gasto.getNombrePromo5())) {
					if (promos.indexOf(gasto.getNombrePromo5()) == -1) {
						promos.append(separador).append(gasto.getNombrePromo5());
						
					}
				}
			}
			
			ArticuloDAO papel = articulo.getPapelDeRegalo();
			if (papel != null) {
				if (papel.getNombreCampaign() != null && !"".equals(papel.getNombreCampaign())) {
					if (promos.indexOf(papel.getNombreCampaign()) == -1) {
						promos.append(separador).append(papel.getNombreCampaign());
						
					}
				}
				if (papel.getNombrePromo1() != null && !"".equals(papel.getNombrePromo1())) {
					if (promos.indexOf(papel.getNombrePromo1()) == -1) {
						promos.append(separador).append(papel.getNombrePromo1());
						
					}
				}
				if (papel.getNombrePromo2() != null && !"".equals(papel.getNombrePromo2())) {
					if (promos.indexOf(papel.getNombrePromo2()) == -1) {
						promos.append(separador).append(papel.getNombrePromo2());
						
					}
				}
				if (papel.getNombrePromo3() != null && !"".equals(papel.getNombrePromo3())) {
					if (promos.indexOf(papel.getNombrePromo3()) == -1) {
						promos.append(separador).append(papel.getNombrePromo3());
						
					}
				}
				if (papel.getNombrePromo4() != null && !"".equals(papel.getNombrePromo4())) {
					if (promos.indexOf(papel.getNombrePromo4()) == -1) {
						promos.append(separador).append(papel.getNombrePromo4());
						
					}
				}
				if (papel.getNombrePromo5() != null && !"".equals(papel.getNombrePromo5())) {
					if (promos.indexOf(papel.getNombrePromo5()) == -1) {
						promos.append(separador).append(papel.getNombrePromo5());
						
					}
				}
			}
		}
		return promos.toString();
	}
	
	
	public void reordenarArticulos() {
		for (int i =0; i<articulos.size(); i++) {
			for (int j=i+1; j<articulos.size(); j++) {
				ArticuloDAO articulo1 = (ArticuloDAO)articulos.get(i);
				ArticuloDAO articulo2 = (ArticuloDAO)articulos.get(j);
				if (articulo1.getId() == articulo2.getId() 
						&& articulo1.getIdCampaign() == articulo2.getIdCampaign()
						&& articulo1.getIdPromo1() == articulo2.getIdPromo1()
						&& articulo1.getIdPromo2() == articulo2.getIdPromo2()
						&& articulo1.getIdPromo3() == articulo2.getIdPromo3()
						&& articulo1.getIdPromo4() == articulo2.getIdPromo4()
						&& articulo1.getIdPromo5() == articulo2.getIdPromo5()
						&& articulo1.getPrecioPromocionSinImpuestos() == articulo2.getPrecioPromocionSinImpuestos()
						&& articulo1.tieneMismoGastoDeEnvio(articulo2)) {
					articulo1.setCantidad(articulo1.getCantidad() + articulo2.getCantidad());
					if (articulo1.getGastoDeEvio() != null && articulo2.getGastoDeEvio() != null) {
						articulo1.getGastoDeEvio().setCantidad(articulo1.getGastoDeEvio().getCantidad() + articulo2.getGastoDeEvio().getCantidad());
					}
					articulo2 = null;
					articulos.remove(j);
				}
			}
		}
	}
	
	
	
	//Para mover ordenManager saco este metodo de la clase y lo ubico en ordenDAO para que la misma clase
	//lo pueda seguir usando. A futuro se iran migrando todas las clases del ear que no sean ejb a war
	
	public void grabarCarritoCompra(SocioPK socioPK) {

		if (this.isReadOnly()) return;
		if (socioPK == null || socioPK.ID_SOCIO == null || socioPK.ID_SUCURSAL == null) return;

		try {
			CarritoCompraLocalHome carritoCompraLocalHome = (CarritoCompraLocalHome) DBUtil.getHome("CarritoCompra");
			// borra los articulos del carrito persistente
			Iterator carritoCompras = carritoCompraLocalHome.findByUser(socioPK.ID_SUCURSAL, socioPK.ID_SOCIO).iterator();
			while (carritoCompras.hasNext()) {
				CarritoCompraLocal carritoCompraLocal = (CarritoCompraLocal) carritoCompras.next();
				// lo borra
				carritoCompraLocal.remove();
			}
			// log
			TmkLogger.debug("CarritoCompra: usuario " + socioPK.ID_SUCURSAL + ":" + socioPK.ID_SOCIO + " borrado");
			
			// agrega los articulos al carrito persistente
			for (int i = 0; i < this.getCantidadArticulos(); i++) {
				// articulo actual
				ArticuloDAO articuloDAO = this.getArticulo(i);
               	if (articuloDAO.getFechaDeCarrito() == null) {
               		TmkLogger.debug("CarritoCompra: agregado luego de calculo de promos, no se agrega a base, idArticulo " + articuloDAO.getId());
               	}else {
                    TmkLogger.debug("CarritoCompra: grabando " + articuloDAO.getId() + " fecha " + Convert.toString(articuloDAO.getFechaDeCarrito()));
                    carritoCompraLocalHome.create(
                            socioPK.ID_SUCURSAL,
                            socioPK.ID_SOCIO,
                            new Integer(articuloDAO.getId()),
                            new Integer(articuloDAO.getCantidad()),
                            articuloDAO.getFechaDeCarrito());
               	}
			}

		} catch (Exception e) {
			TmkLogger.warn("No se pudo sincronizar el carrito de compra " + e.getMessage());
		}
	}
	
	public void setComentario(String comentario){
		this.comentario = comentario;
	}
	
	
}
