/**
 * $Log: ArticuloDAO.java,v $
 * Revision 1.60  2008/01/24 20:28:03  msartori
 * no message
 *
 * Revision 1.59  2006/12/18 20:06:11  oLSuarez
 * Rediseño de las paginas del proceso de compras
 *
 * Revision 1.58  2006/12/13 17:15:06  omsartori
 * -Homes Recorridos y Favoritos
 * -Resultado de busquedas
 *
 * Revision 1.57  2006/11/27 13:03:35  omsartori
 * Re Dis Favoritos en Homes
 *
 * Revision 1.56  2006/10/12 14:58:28  omsartori
 * no message
 *
 * Revision 1.55  2006/10/09 13:05:36  omsartori
 * -Google Analitics SSL
 * -Docs EMPro 14,16
 * -Correccion bug de nota de regalo
 * -Reordenamiento de articulos luego de promo
 * -Mejora en seleccion de gasto de envio
 *
 * Revision 1.54  2006/09/14 18:24:37  omsartori
 * Promociones II
 *
 * Revision 1.53  2006/06/05 12:39:51  omsartori
 * - Modificacion de nuevas recomendaciones
 *
 * Revision 1.52  2006/05/19 14:24:25  omsartori
 * - articulos x isbn
 * - recomendaciones nuevas
 * - frm extra compras
 * - modificaciones CV
 * - nombre de usuario aprobador en mail de orden
 *
 * Revision 1.51  2006/01/11 17:37:10  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.50  2005/11/24 15:28:07  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.49  2005/11/14 13:47:50  omsartori
 * -Cheque Obsequio Monsanto
 *
 * Revision 1.48  2005/11/04 12:55:35  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 * Revision 1.46  2005/10/20 19:34:34  omsartori
 * - correccion en recomendados
 *
 * Revision 1.43  2005/09/29 12:44:53  omsartori
 * - Ejb reducido en orden y en resultados de busqueda
 * - Mapa de productos
 * - Promo dia de la madre, pagina de promo.
 * - Seguimiento EMPRO, visitas por canales, registraciones por canales
 *
 * Revision 1.42  2005/09/22 18:38:07  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.41  2005/03/24 15:25:02  omsartori
 * - Bug campo de gastos no grabado corregido
 * - Medio de cobro Rio Net Banking
 *
 * Revision 1.40  2005/03/16 16:08:50  omsartori
 * - Manejo de cheque obsequio y articulos con impuestos
 *
 * Revision 1.39  2005/02/18 13:15:29  omsartori
 * - Correccion en promociones, no enviaba el total de impuestos cuando era mas de un articulo, no grababa las promos sin impuestos.
 *
 * Revision 1.38  2005/02/17 12:13:28  omsartori
 * - Cheque obsequio, modificacion de la logica de promociones
 * - Codigo de tipo de articulo configurable por server.xml
 * - Habilitacion de cheque obsequio por server.xml
 * - Cupon guardado en la orden
 * - Modificacion de OrdenDAO, ArticuloDAO, para cheque obsequio
 *
 * Revision 1.37  2005/01/25 15:52:15  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.36  2004/10/05 21:27:55  oGPistoia
 * - Reporte de imagenes falladas
 * - Cambios minimos en eXtra
 *
 * Revision 1.35  2004/09/10 15:12:52  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.34  2004/06/15 20:56:11  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.33  2004/05/04 18:09:31  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.32  2004/03/04 18:51:40  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.31  2004/02/27 13:44:16  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.30  2004/02/16 20:22:52  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.29  2004/01/06 15:28:30  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.28  2003/11/27 01:57:39  GPistoia
 * -Gasto de envio no tenia impuestos
 *
 * Revision 1.27  2003/11/26 15:36:53  GPistoia
 * -Reporte de estadisticas mejorados
 * -Correccion problemas de ordenes
 * -Otros bugs desde la salida del sitio
 *
 * Revision 1.26  2003/10/07 14:52:13  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.25  2003/10/06 14:17:59  SLizardo
 * Update Socios
 *
 * Revision 1.24  2003/10/03 16:29:02  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.23  2003/09/29 17:20:06  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.22  2003/09/24 23:12:39  GPistoia
 * -Modificacion de descuento de articulo porque puede ser positivo.
 * -Modificacion de contenido con N paginas o solapas principales
 *
 * Revision 1.21  2003/09/23 13:55:10  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.20  2003/09/17 19:32:04  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.19  2003/09/15 22:30:52  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.18  2003/09/08 13:54:36  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.17  2003/09/04 21:39:26  GPistoia
 * -Grabacion de Pedido Especial
 * -Limite de compra
 * -Modificacion de site para mails de oferta de trabajo
 *
 * Revision 1.16  2003/08/29 17:54:19  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.15  2003/08/26 16:18:54  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.14  2003/08/25 18:22:48  SLizardo
 * no message
 *
 * Revision 1.13  2003/08/22 14:03:54  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.12  2003/08/21 17:48:25  GPistoia
 * -Ordenes historicas
 *
 * Revision 1.11  2003/08/15 15:59:19  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 * Revision 1.10  2003/08/12 16:25:24  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.9  2003/08/11 14:26:38  GPistoia
 * -Correccion de domicilio
 * -Cierre de orden
 *
 * Revision 1.8  2003/08/09 18:22:00  GPistoia
 * -Autores en el articulo
 *
 * Revision 1.7  2003/08/08 20:13:40  GPistoia
 * -Primera version cerrada de registracion y compra funcionando.
 *
 * Revision 1.6  2003/08/07 18:10:19  GPistoia
 * -Modificaciones en articulos DAO y EJB
 *
 * Revision 1.5  2003/08/06 21:28:19  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.4  2003/08/04 22:17:50  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.3  2003/08/02 16:58:04  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:17:59  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:05  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.FinderException;
import javax.naming.NamingException;

import com.tmk.articulo.ArticuloReducidoLocal;
import com.tmk.articulo.ArticuloReducidoLocalHome;
import com.tmk.socio.SocioPK;

public class ArticuloDAO implements Serializable {

	protected int id;

	private boolean readOnly;

	protected String titulo;
	protected int categoriaSeccion; 
	protected int categoriaGrupo;
	protected int categoriaFamilia;
	protected int categoriaSubFamilia;
	protected double precioOriginal;
	protected double precioConDescuento;
	protected double precioConImpuesto;
	protected double precioSitio;
	protected int listaPVP;
	protected double porcentajeDescuento;
	protected boolean tieneDescuento;
	protected double ahorro;
	public double tasaImpuestoGeneral;
	protected double tasaImpuestoVideo;
	protected int cantidad;
	protected String nota;
	protected String codExtVisual;
	protected Integer disponibilidad;
	protected boolean habilitado;
	protected boolean cheque;
	//cambia para promoII
	//protected Integer idPromocion;
	//protected String nombrePromocion;
	
	//cambia para promoII
	private Date fechaDeCarrito;
	protected ArticuloDAO subArticulo;
	//protected double chequeSobrante;
	protected double valorDeChequeAplicado = 0.0;

	protected String estadoItem;

	private SocioPK socioLDD;
    private String atributoPrincipal="";
    
	/*Utilizado Para DROMO*/
	private GastosEnvioDAO gastoDeEnvioDAO = null;
	/*Utilizado Para DROMO*/
	
	
	private int posicionEnLista = -1;
	protected double precioPromocionSinImpuestos;
	//PROMO II
	protected int idCampaign;
	protected int idPromo1;
	protected int idPromo2;
	protected int idPromo3;
	protected int idPromo4;
	protected int idPromo5;
	protected String nombreCampaign;
	protected String nombrePromo1;
	protected String nombrePromo2;
	protected String nombrePromo3;
	protected String nombrePromo4;
	protected String nombrePromo5;
	//PROMO II
	
	//PARA PROMOCION ESPECIFICA DE ATENEO
	protected int idEditor;
	//PARA PROMOCION ESPECIFICA DE ATENEO

	public ArticuloDAO(int id, int cantidad) throws NamingException, FinderException {
		super();
		this.id = id;
		this.cantidad = cantidad;
		reloadReducido();
		
		
		
	}

	public ArticuloDAO(int id) throws NamingException, FinderException {
		this(id, 1);
	}

    protected ArticuloDAO() {
		super();
	}

	public ArticuloDAO duplicate() {

		ArticuloDAO copia = new ArticuloDAO();
		copia.cargar(id, titulo,
		        categoriaSeccion, categoriaGrupo, categoriaFamilia, categoriaSubFamilia,
		        precioOriginal, precioConDescuento, precioConImpuesto, precioSitio,
		        listaPVP, porcentajeDescuento, tieneDescuento, ahorro, tasaImpuestoGeneral, tasaImpuestoVideo,
		        codExtVisual,
		        disponibilidad, habilitado);
		copia.cambiarCantidad(cantidad);
		copia.setNota(nota);
		if (getSubArticulo() != null) copia.setPapelDeRegalo(getSubArticulo().duplicate());
		return copia;
	}

	public void cargar(int id,
	                   String titulo,
	                   int categoriaSeccion, int categoriaGrupo, int categoriaFamilia, int categoriaSubFamilia,
	                   double precioOriginal, double precioConDescuento, double precioConImpuesto, double precioSitio,
	                   int listaPVP, double porcentajeDescuento, boolean tieneDescuento, double ahorro, double tasaImpuestoGeneral, double tasaImpuestoVideo,
	                   String codExtVisual,
	                   Integer disponibilidad, boolean habilitado) {
		this.id = id;
		this.titulo = titulo;
		this.categoriaSeccion = categoriaSeccion;
		this.categoriaGrupo = categoriaGrupo;
		this.categoriaFamilia = categoriaFamilia;
		this.categoriaSubFamilia = categoriaSubFamilia;
		this.precioOriginal = precioOriginal;
		this.precioConDescuento = precioConDescuento;
		this.precioConImpuesto = precioConImpuesto;
		this.precioPromocionSinImpuestos = precioOriginal;
		this.precioSitio = precioSitio;
		this.listaPVP = listaPVP;
		this.porcentajeDescuento = porcentajeDescuento;
		this.tieneDescuento = tieneDescuento;
		this.ahorro = ahorro;
		this.tasaImpuestoGeneral = tasaImpuestoGeneral;
		this.tasaImpuestoVideo = tasaImpuestoVideo;
		this.codExtVisual = codExtVisual;
		this.disponibilidad = disponibilidad;
		this.habilitado = habilitado;
	}


    public void reloadReducido() throws NamingException, FinderException {
			ArticuloReducidoLocalHome articuloLocalHome = (ArticuloReducidoLocalHome) DBUtil.getHome("ArticuloReducido");
			ArticuloReducidoLocal articuloLocal = articuloLocalHome.findByPrimaryKey(new Integer(id));
			// Recarga los importes finales

			cargar(articuloLocal.getID_ARTICULO().intValue(),
			Convert.corregir(articuloLocal.getTITULO(), true),
			(articuloLocal.getCATEGORIA_SECCION() == null) ? 0 : articuloLocal.getCATEGORIA_SECCION().intValue(),
			(articuloLocal.getCATEGORIA_GRUPO() == null) ? 0 : articuloLocal.getCATEGORIA_GRUPO().intValue(),
			(articuloLocal.getCATEGORIA_FAMILIA() == null) ? 0 : articuloLocal.getCATEGORIA_FAMILIA().intValue(),
			(articuloLocal.getCATEGORIA_SUBFAMILIA() == null) ? 0 : articuloLocal.getCATEGORIA_SUBFAMILIA().intValue(),
			articuloLocal.getPRECIO_ORIGINAL().doubleValue(),
			articuloLocal.getPRECIO_CON_DESCUENTO().doubleValue(),
			articuloLocal.getPRECIO_CON_IMPUESTOS().doubleValue(),
			articuloLocal.getPRECIO_SITIO().doubleValue(),
			articuloLocal.getListaPVP(),
			articuloLocal.getPORCENTAJE_DESCUENTO().doubleValue(),
			articuloLocal.getTIENE_DESCUENTO(),
			articuloLocal.getAHORRO().doubleValue(),
			articuloLocal.getTASA_IMPUESTO_GENERAL().doubleValue(),
			articuloLocal.getTASA_IMPUESTO_VIDEO().doubleValue(),
			articuloLocal.getCOD_EXT_VISUAL(),
			new Integer (articuloLocal.getDISPONIBILIDAD_SITIO().getId()),
			articuloLocal.getESTA_HABILITADO_TEMATIKA());
			//TmkLogger.debug("AVISO] uso ejb reducido en orden " + articuloLocal);
	        if (articuloLocal.getDESC_ATRIBUTO_PRINCIPAL() != null && articuloLocal.getDESC_ATRIBUTO_PRINCIPAL().toString().length()>2) {
	            this.atributoPrincipal = articuloLocal.getDESC_ATRIBUTO_PRINCIPAL().toString().replaceAll("\\[", "").replaceAll("\\]", "");
	        }
	    	//PARA PROMOCION ESPECIFICA DE ATENEO
	        this.idEditor = articuloLocal.getID_EDITOR().intValue();
	}


	public void setFechaDeCarrito(Date fechaDeCarrito) {
		this.fechaDeCarrito = fechaDeCarrito;
	}

	public Date getFechaDeCarrito() {
		return fechaDeCarrito;
	}

	public double totalOriginalCompleto() {
		double precioSubArticulo = (getSubArticulo() == null) ? 0 : getSubArticulo().getPrecioOriginal();
		return Convert.round(getCantidad() * (getPrecioOriginal() + precioSubArticulo));
	}

	public double totalConImpuesto() {
		return Convert.round(getCantidad() * getPrecioConImpuesto());
	}

	public double totalConImpuestoCompleto() {
		double precioSubArticulo = (getSubArticulo() == null) ? 0 : getSubArticulo().getPrecioConImpuesto();
		return Convert.round(getCantidad() * (getPrecioConImpuesto() + precioSubArticulo));
	}

	public double totalSubArticulosConImpuesto() {
		return Convert.round(getCantidad() * ((getSubArticulo() == null) ? 0 : getSubArticulo().getPrecioConImpuesto()));
	}

	public double totalSubArticulosSitio() {
		return Convert.round(getCantidad() * ((getSubArticulo() == null) ? 0 : getSubArticulo().getPrecioSitio()));
	}

	public double totalSitio() {
		return Convert.round(getCantidad() * getPrecioSitio());
	}

	public double totalSitioCompleto() {
		double precioSubArticulo = (getSubArticulo() == null) ? 0 : getSubArticulo().getPrecioSitio();	
		return Convert.round(getCantidad() * (getPrecioSitio() + precioSubArticulo));
	}

	public boolean equals(Object object) {
		return super.equals(object) ||
		        ((object instanceof ArticuloDAO) && (getId() == ((ArticuloDAO) object).getId()));
	}

	public String toString() {
		return "Articulo (" + id + ") " + titulo + " [" + cantidad + "]";
	}

	public int getId() {
		return id;
	}

	public void setSocioListaDD(SocioPK socioPK) {
		this.socioLDD = socioPK;
	}

	public SocioPK getSocioLDD() {
		return socioLDD;
	}

	public boolean esPersonal() {
		return (socioLDD == null);
	}

	public boolean esParaListaDeseos() {
		return (!esPersonal());
	}

	public String getTitulo() {
		return titulo;
	}

	public int getCategoriaSeccion() {
		return categoriaSeccion;
	}

	public int getCategoriaGrupo() {
		return categoriaGrupo;
	}

	public int getCategoriaFamilia() {
		return categoriaFamilia;
	}

	public int getCategoriaSubFamilia() {
		return categoriaSubFamilia;
	}

	public boolean esGastoDeEnvio() {
		return ((categoriaSeccion == Globals.GASTO_DE_ENVIO_CATEGORIA_SECCION) &&
		        (categoriaGrupo == Globals.GASTO_DE_ENVIO_CATEGORIA_GRUPO) &&
		        (categoriaFamilia == Globals.GASTO_DE_ENVIO_CATEGORIA_FAMILIA));
	}

	public boolean esInteresCobrado() {
		return ((categoriaSeccion == Globals.INTERES_COBRADO_CATEGORIA_SECCION) &&
		        (categoriaGrupo == Globals.INTERES_COBRADO_CATEGORIA_GRUPO) &&
		        (categoriaFamilia == Globals.INTERES_COBRADO_CATEGORIA_FAMILIA));
	}

	public double getPrecioOriginal() {
		return precioOriginal;
	}

	public double getPrecioConDescuento() {
		return precioConDescuento;
	}

	public double getPrecioSinImpuestoConDescuento() {
		return Convert.round(Convert.aplicarPorcentaje(precioOriginal, porcentajeDescuento));
	}

	public double getPrecioConImpuesto() {
		return precioConImpuesto;
	}

	public void setPrecioConImpuesto(double precioConImpuesto) {
		this.precioConImpuesto = precioConImpuesto;
	}

	public double getTotalImpuestosSobrePrecioConDescuento() {
		double importeInicial = getPrecioSinImpuestoConDescuento();
		return Convert.round(
		        Convert.porcentajeResultante(importeInicial, tasaImpuestoGeneral) +
		        Convert.porcentajeResultante(importeInicial, tasaImpuestoVideo));
	}
	
   //modificado por cheque
	public double getPrecioSitio() {
		if (tienePromocion()) {
			return getPrecioPromocion();
		}
		if (cheque) {
			double retorno = getPrecioPromocionSinImpuestos() + getValorImpuestoGeneral() + getValorImpuestoVideo();
			return retorno;
		}
		return precioSitio;

	}
	
	public void setPrecioPromocionSinImpuestos(double precioPromocionSinImpuestos) {
		this.precioPromocionSinImpuestos = precioPromocionSinImpuestos;
	}
	
	public double getPrecioPromocionSinImpuestos() {
		return this.precioPromocionSinImpuestos;
	}
	
	public void borrarPromocion() {
		precioPromocionSinImpuestos = precioOriginal;
		this.idCampaign = 0;
		this.idPromo1 = 0;
		this.idPromo2 = 0;
		this.idPromo3 = 0;
		this.idPromo4 = 0;
		this.idPromo5 = 0;
		this.nombreCampaign = null;
		this.nombrePromo1 = null;
		this.nombrePromo2 = null;
		this.nombrePromo3 = null;
		this.nombrePromo4 = null;
		this.nombrePromo5 = null;
	}

	public boolean tienePromocion() {
		if (this.nombreCampaign != null || this.nombrePromo1 != null || this.nombrePromo2 != null 
				|| this.nombrePromo3 != null || this.nombrePromo4 != null || this.nombrePromo5 != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public double getPrecioPromocion()  {
		double importe = Convert.aplicarPorcentaje(precioPromocionSinImpuestos, tasaImpuestoGeneral + tasaImpuestoVideo);
		return Convert.round(importe);
	}

	public boolean tieneDescuento() {
		return tieneDescuento;
	}

	public double getAhorro() {
		return ahorro;
	}

	public boolean tieneListaPVP() {
		return (listaPVP != 0);
	}

	public int getListaPVP() {
		return listaPVP;
	}

	public double getPorcentajeDescuento() {
		return porcentajeDescuento;
	}

	public double getTasaImpuestoGeneral() {
		return tasaImpuestoGeneral;
	}


	public double getValorImpuestoGeneral() {
		return Convert.round(Convert.porcentajeResultante(precioPromocionSinImpuestos, tasaImpuestoGeneral));
	}

	public double getTasaImpuestoVideo() {
		return tasaImpuestoVideo;
	}

	public double getValorImpuestoVideo() {
		return Convert.round(Convert.porcentajeResultante(precioPromocionSinImpuestos, tasaImpuestoVideo));
	}

	public boolean tieneDisponibilidad() {
		return (disponibilidad == null) || (habilitado && getDisponibilidad().estaDisponible());
	}

	public String getCodExtVisual() {
		return codExtVisual;
	}

	public Integer getIdDisponibilidad() {
		return disponibilidad;
	}

	public DisponibilidadDAO getDisponibilidad() {
		return DisponibilidadDAO.buscaDisponibilidad(disponibilidad);
	}

	public boolean tieneNota() {
		return (nota != null) && (!"".equals(nota.trim()));
	}

	public String getNota() {
		return nota;
	}

	public void cambiarCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setNota(String nota) {
		this.nota = nota;
	}

	public ArticuloDAO getSubArticulo() {
		return subArticulo;
	}

	public void setSubArticulo(ArticuloDAO subArticulo) {
		this.subArticulo = subArticulo;
	}

	public boolean tieneSubArticulo() {
		return (subArticulo != null);
	}

	public ArticuloDAO getPapelDeRegalo() {
		return getSubArticulo();
	}

	public void setPapelDeRegalo(ArticuloDAO papelDeRegalo) {
		this.setSubArticulo(papelDeRegalo);
	}

	//agregado por cheque obsequio
	public void setPrecioSitio(double precio) {
		precioSitio = precio;
	}

	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}

	public boolean isReadOnly() {
		return readOnly;
	}

	public boolean isReadWrite() {
		return !readOnly;
	}

	public boolean estaHabilitado() {
		return habilitado;
	}

	public EstadoItemOrdenDAO getEstadoItem() {
		return EstadoItemOrdenDAO.buscaEstadoItemOrden(estadoItem);
	}

	public String getIdEstadoItem() {
		return estadoItem;
	}

	public void setIdEstadoItem(String estadoItem) {
		this.estadoItem = estadoItem;
	}

	
	public void setCheque(boolean parCheque) {
		cheque = parCheque;
	}

	public boolean getCheque ()  {
		return cheque;
	}

	public void setValorDeChequeAplicado(double valor) {
		this.valorDeChequeAplicado = valor;
	}

	public double getValorDeChequeAplicado() {
		return valorDeChequeAplicado;
	}
	
	

    /*Utilizado Para DROMO*/
	public void setGastoDeEvio(GastosEnvioDAO gasto) {
		gastoDeEnvioDAO = gasto;
	}

	public GastosEnvioDAO getGastoDeEvio() {
		return gastoDeEnvioDAO;
	}
	/*Utilizado Para DROMO*/

	public String getAtributoPrincipal() {
		return atributoPrincipal;
	}

	
	public void setCantidad(int cantidad) {
		if (cantidad > 99) {
			cantidad = 99;
		} else {
			this.cantidad = cantidad;
		}
	}
	
	public int getCantidad() {
		return this.cantidad;
	}
	
	
	public void setIdCampaign(int idCampaign) {
		this.idCampaign = idCampaign;
	}
	
	public int getIdCampaign() {
		return this.idCampaign;
	}
	
	public void setNombreCampaign(String nombreCampaign) {
		this.nombreCampaign = nombreCampaign;
	}
	
	public String getNombreCampaign() {
		return this.nombreCampaign;
	}
	
	
	public void setIdPromo1(int idPromo) {
		this.idPromo1 = idPromo;
	}
	
	public int getIdPromo1() {
		return this.idPromo1;
	}
	
	public void setNombrePromo1(String nombrePromo) {
		this.nombrePromo1 = nombrePromo;
	}
	
	public String getNombrePromo1() {
		return this.nombrePromo1;
	}
	
	
	
	public void setIdPromo2(int idPromo) {
		this.idPromo2 = idPromo;
	}
	
	public int getIdPromo2() {
		return this.idPromo2;
	}
	
	public void setNombrePromo2(String nombrePromo) {
		this.nombrePromo2 = nombrePromo;
	}
	
	public String getNombrePromo2() {
		return this.nombrePromo2;
	}
	
	
	
	public void setIdPromo3(int idPromo) {
		this.idPromo3 = idPromo;
	}

	public int getIdPromo3() {
		return this.idPromo3;
	}
	
	public void setNombrePromo3(String nombrePromo) {
		this.nombrePromo3 = nombrePromo;
	}

	public String getNombrePromo3() {
		return this.nombrePromo3;
	}
	
	
	
	public void setIdPromo4(int idPromo) {
		this.idPromo4 = idPromo;
	}
	
	public int getIdPromo4() {
		return this.idPromo5;
	}
	
	public void setNombrePromo4(String nombrePromo) {
		this.nombrePromo4 = nombrePromo;
	}
	
	public String getNombrePromo4() {
		return this.nombrePromo4;
	}
	
	
	
	public void setIdPromo5(int idPromo) {
		this.idPromo5 = idPromo;
	}
	
	public int getIdPromo5() {
		return this.idPromo5;
	}
	
	public void setNombrePromo5(String nombrePromo) {
		this.nombrePromo5 = nombrePromo;
	}
	
	public String getNombrePromo5() {
		return this.nombrePromo5;
	}
	
	public boolean tieneMismoGastoDeEnvio(ArticuloDAO articulo) {
		if (this.gastoDeEnvioDAO == null && articulo.getGastoDeEvio() == null) {
			return true;
		}
		if (this.gastoDeEnvioDAO == null && articulo.getGastoDeEvio() != null) {
			return false;
		}
		if (this.gastoDeEnvioDAO != null  && articulo.getGastoDeEvio() == null) {
			return false;
		}
		if (this.gastoDeEnvioDAO.getId() == articulo.getGastoDeEvio().getId()
				&& this.gastoDeEnvioDAO.getIdCampaign() == articulo.getGastoDeEvio().getIdCampaign()
				&& this.gastoDeEnvioDAO.getIdPromo1() == articulo.getGastoDeEvio().getIdPromo1()
				&& this.gastoDeEnvioDAO.getIdPromo2() == articulo.getGastoDeEvio().getIdPromo2()
				&& this.gastoDeEnvioDAO.getIdPromo3() == articulo.getGastoDeEvio().getIdPromo3()
				&& this.gastoDeEnvioDAO.getIdPromo4() == articulo.getGastoDeEvio().getIdPromo4()
				&& this.gastoDeEnvioDAO.getIdPromo5() == articulo.getGastoDeEvio().getIdPromo5()
				&& this.gastoDeEnvioDAO.getPrecioPromocionSinImpuestos() == articulo.getGastoDeEvio().getPrecioPromocionSinImpuestos()) {
			return true;
		}
		return false;
	}

	public boolean tieneMismoPapelDeRegalo(ArticuloDAO articulo) {
		if (this.getPapelDeRegalo() == null && articulo.getPapelDeRegalo() == null) {
			return true;
		}
		if (this.getPapelDeRegalo() == null && articulo.getPapelDeRegalo() != null) {
			return false;
		}
		if (this.getPapelDeRegalo() != null  && articulo.getPapelDeRegalo() == null) {
			return false;
		}
		if (this.getPapelDeRegalo().getId() == articulo.getPapelDeRegalo().getId()
				&& this.getPapelDeRegalo().getIdCampaign() == articulo.getPapelDeRegalo().getIdCampaign()
				&& this.getPapelDeRegalo().getIdPromo1() == articulo.getPapelDeRegalo().getIdPromo1()
				&& this.getPapelDeRegalo().getIdPromo2() == articulo.getPapelDeRegalo().getIdPromo2()
				&& this.getPapelDeRegalo().getIdPromo3() == articulo.getPapelDeRegalo().getIdPromo3()
				&& this.getPapelDeRegalo().getIdPromo4() == articulo.getPapelDeRegalo().getIdPromo4()
				&& this.getPapelDeRegalo().getIdPromo5() == articulo.getPapelDeRegalo().getIdPromo5()
				&& this.getPapelDeRegalo().getPrecioPromocionSinImpuestos() == articulo.getPapelDeRegalo().getPrecioPromocionSinImpuestos()) {
			return true;
		}
		return false;
	}

	
	
	public void setPosicionEnLista(int pos) {
		this.posicionEnLista = pos;
	}
	
	public int getPosicionEnLista() {
		return this.posicionEnLista;
	}
	
	//PARA PROMOCION ESPECIFICA DE ATENEO
	public int getIdEditor() {
		return this.idEditor;
	}
	//PARA PROMOCION ESPECIFICA DE ATENEO
}

