/**
 * $Log: ArticuloBean.java,v $
 * Revision 1.61  2008/07/07 18:58:52  msartori
 * Correccion de interpretes de musica en todo el sitio.
 * Generador de Feeds de comentarios y listas de deseos
 * Lanzador de generadores generico. Se pasaron los de rss.
 *
 * Revision 1.60  2006/03/30 14:42:38  omsartori
 * - catalogo extra nuevo (deshabilitado:falta diseño)
 * - Correccion de orden interpretes
 * - Resaltado de busqueda
 * - recordar las palabras  en busquedas fallidas o sin resultados
 *
 * Revision 1.59  2006/01/11 17:37:09  omsartori
 * -Dromo
 *    -Se quito el campo fabricante
 *    -Se filtra la seleccion de papel de regalo para articulos (6,7,8)
 *    -Estetica en seleccion de medio de pago
 * -Empro doc 11 (parte 1)
 * -Intranet TMK
 *    -Generacion en otro equipo configurable
 *    -Correccion y configuracion de procesos de generacion de Detalle y recorrido de categorias
 *
 * Revision 1.58  2005/12/29 17:45:09  omsartori
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
 * Revision 1.57  2005/11/24 15:28:06  omsartori
 * - Doble medio de Cobro para DROMO
 *            Circuito de compra
 *            Intranet
 * - Correccion de url para generacion
 * - Correccion del link a url de editorial
 * - Manejo de excepciones y log en obtencion de sequence
 *
 * Revision 1.56  2005/11/11 15:14:49  oDZurita
 * - aplicacion de permisos en la intranet para la generación de los contenidos estáticos.
 * - modificación del listado de autores en el sector de biografías dentro del detalle del artículo.
 * - definición de los nuevos tamaños de las imágenes de los artículos de Dromo.
 * - visualización de la tercer lista de la home de inicio igual a como se ve la primer lista.
 * - pantalla de abm de url de editoriales en la intranet.
 * - visualización del link a la url de la editorial solo en la categoría de libros.
 *
 * Revision 1.55  2005/10/11 16:04:35  omsartori
 * - Seguimiento EMPRO
 *     - Visitas x canal
 *     - Compras x canal
 *     - Registraciones x canal
 *     - Ingresos al detalle de articulo x canal
 * - Filtro de texto en formato de Articulo
 * - Campo adicional en la orden para envios a Brasil (CPF CNPJ)
 *
 * Revision 1.54  2005/09/22 18:38:04  omsartori
 * - EMPro Cambio de tags en detalle de articulo, Generacion de directorio - config por xml.
 * - EJB Articulo Reducido -> Aplicado a resultado de busqueda (detalleReducido) y a ArticuloDAO.
 * - Correccion de Bug en AgregarLista.java
 *
 * Revision 1.53  2005/05/10 14:22:51  omsartori
 * - Posicionamiento: metas por secciones, sucursales. division de links a sucursales y a ranking,
 * link a detalle en resultado de busqueda, palabra de busqueda en resultado de busqueda
 *
 * Revision 1.52  2005/04/26 17:31:49  omsartori
 * - Arreglado bug buscador rapido comilla simple.
 * - Arreglado bug buscador avanzado comilla simple.
 * - Referido circuito completo testeado.
 * - Posicionamiento: metas home, links producto a detalle y a buscador por categoria.
 *
 * Revision 1.51  2005/01/25 15:52:13  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.50  2005/01/20 20:47:56  oGPistoia
 * - Modificacion en buscador por proveedor
 * - Filtro extra para productos deshabilitados con atributos dinámicos
 *
 * Revision 1.49  2005/01/18 19:45:58  oGPistoia
 * - Nuevo EJB de Proveedores
 * - Busqueda por Proveedor
 * - Modificaciones en los reportes
 * - Cambios en clientes institucionales
 *
 * Revision 1.48  2004/12/13 18:52:03  omsartori
 * - reporte de ordenes discriminado por medio de pago
 * - js para validar mail de hotmail en registro del socio
 *
 * Revision 1.47  2004/12/13 13:57:07  oGPistoia
 * - Pago a través de Home Banking
 *
 * Revision 1.46  2004/11/25 21:11:14  omsartori
 * -Toma enter en el buscador rapido del input y del combo, se corrigió el bug que no validaba cuando hacias enter en el input, en vez de click al botón.
 * -Se agragaron todos los archivos para Juguetes.
 * - Se agrego la funcion en Globals textoSolapa, para poner el texto que se ven en la solapa.
 * - Pase prensa.jsp a html.
 *
 * Revision 1.45  2004/11/18 17:03:28  omsartori
 * - Componentes genéricos, en inicio, lista de deseos y resultado de busqueda.
 *
 * Revision 1.44  2004/11/16 21:19:15  oGPistoia
 * - Mejora para mostrar los datos de los artículos
 * - Cambios en las notas de prensa.
 *
 * Revision 1.43  2004/11/15 16:22:37  omsartori
 * - Unificación de detalleReducido.jsp
 * - Cambio en el array de secciones en Globals
 *
 * Revision 1.42  2004/11/11 17:01:56  oGPistoia
 * - Mejoras para AtributosDestacados que ahora soporta todos los casos
 *
 * Revision 1.41  2004/11/10 23:05:58  oGPistoia
 * - Generalizacion de los atributos para mejorar la presentacion y soportar Dromo
 *
 * Revision 1.40  2004/11/09 14:47:58  oGPistoia
 * - Ajustes para el nuevo motor de recomendaciones
 *
 * Revision 1.39  2004/10/19 14:47:39  oGPistoia
 * - Atributos dinámicos
 *
 * Revision 1.38  2004/10/13 22:00:52  oGPistoia
 * - Atributos dinámicos para los artículos
 *
 * Revision 1.37  2004/09/10 15:12:43  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.36  2004/06/15 20:55:58  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.35  2004/03/04 18:51:33  oGPistoia
 * -Disponibilidad Ficticia
 * -Eliminacion de algunos EJB muertos
 * -Correccion en el código de autorización de GPAY
 *
 * Revision 1.34  2004/02/27 13:44:10  GPistoia
 * -Reinicio programado
 * -Correccion de socios
 * -Mejora de logs
 * -Borrado de datos confidenciales. Agregado de visitas.
 * -Mostrar orden similar en intranet
 *
 * Revision 1.33  2004/02/16 20:22:46  GPistoia
 * - Busqueda de recomendados
 * - Mail por cambio de contenido
 * - Eliminacion de DAOs permanentes, reemplazo por las claves
 *
 * Revision 1.32  2004/02/11 19:32:45  GPistoia
 * Buscador Nuevos
 * Mejoras en algunas paginas de reportes, conversion, simbolos, etc.
 *
 * Revision 1.31  2004/01/06 15:28:26  GPistoia
 * Pre-release
 * - ID de alianza en el mail
 * - Notas asociadas al item
 * - ISBN por cada item de la orden
 * - Volver a pantalla de confirmacion si no tiene gastos
 * - Mensajes de GPAY configurables
 *
 * Revision 1.30  2003/11/07 15:32:52  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.29  2003/11/03 20:57:35  SLizardo
 * exception.printStackTrace => TmkLogger.error
 *
 * Revision 1.28  2003/10/21 22:05:31  GPistoia
 * -Arreglo de Formato
 * -Arreglo de recomendar solo disponibles
 * -Arreglo de recorrido por temas de solo disponibles.
 * -Arreglo solo 5 autores recomendados.
 *
 * Revision 1.27  2003/10/15 19:54:39  GPistoia
 * -Solo mostrar sinopsis en español.
 *
 * Revision 1.26  2003/10/13 21:43:24  GPistoia
 * -Mail de reportes de ordenes
 * -Funcion de mail real en socio
 * -Repare PedidoEspecial
 *
 * Revision 1.25  2003/10/09 19:29:54  GPistoia
 * -Tarjeta encriptada en tarjeta_orden, 3 campos nuevos y encriptacion en tarjeta_socio
 * - Cambios para listado de ya enviadas a logistica
 * -Cambios en articulos (correccion de S / D)
 * -Pruebas GPay
 *
 * Revision 1.24  2003/10/03 16:28:43  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.23  2003/09/29 17:20:04  GPistoia
 * -Server de mail en server.xml
 * -Mas configuracion en site.xml
 * -StringBuffer en tags
 * -Preparando para release
 *
 * Revision 1.22  2003/09/26 00:06:05  GPistoia
 * -Ayudas en las paginas.
 *
 * Revision 1.21  2003/09/25 19:17:09  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.20  2003/09/24 23:12:37  GPistoia
 * -Modificacion de descuento de articulo porque puede ser positivo.
 * -Modificacion de contenido con N paginas o solapas principales
 *
 * Revision 1.19  2003/09/23 13:55:07  GPistoia
 * -Importe de articulo minimo, maximo, y limites de compra en base.
 *
 * Revision 1.18  2003/09/19 19:48:57  GPistoia
 * -Gasto de envio local y exterior cerrado
 * -Soporte de back despues de confirma compra.
 *
 * Revision 1.17  2003/09/17 15:13:35  GPistoia
 * -Incidente de link en promociones.
 * -Importe minimo de 0.01 para cualquier producto.
 *
 * Revision 1.16  2003/09/15 22:30:49  GPistoia
 * -Gasto de envio historico
 * -Ordenes por rango y estado
 * -Controller de Pago por fax terminado
 * -Modificacion de recorrido por tema
 * -Biografias
 *
 * Revision 1.15  2003/09/11 18:08:39  GPistoia
 * -Se movieron a los daos los metodos de pais, provincia y localidad
 * -Nuevos campos en site.xml
 * -Correccion de grabacion de tarjeta no aprobada
 * -Mejora de no actualizacion de gasto de envio al agregar o borrar producto
 *
 * Revision 1.14  2003/09/08 13:54:32  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.13  2003/09/02 19:08:26  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.12  2003/09/02 14:23:12  GPistoia
 * -Imagenes de productos grandes
 * -Campos en Articulo
 *
 * Revision 1.11  2003/09/01 13:54:46  GPistoia
 * -Impuestos, biografia, critica, y otros metodos para detalle.
 * -Promocion Historica
 * -Probabilidad es la misma tabla disponibilidad
 *
 * Revision 1.10  2003/08/29 21:56:48  SLizardo
 * Sinopsis Agregada.
 *
 * Revision 1.9  2003/08/26 16:18:48  GPistoia
 * -Correccion para promociones
 * -Carrito persistente
 * -Inicio de fraude
 *
 * Revision 1.8  2003/08/22 14:03:50  GPistoia
 * -Cierre de Orden Historica
 * -Mejora en comportamiento por Disponibilidad
 * -Cambio en XML para presentacion
 *
 * Revision 1.7  2003/08/15 15:58:59  GPistoia
 * -Archivo de Configuracion del server
 * -Cambio de Directorio de configuracion
 * -Campos en Articulo para armar pagina de Detalle
 * -Comienzo Pedido Especial
 *
 */
package com.tmk.articulo;

import com.tmk.kernel.*;
import com.tmk.categoria.*;
import com.tmk.controllers.buscador.BuscadorHelper;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.EntityBean;
import javax.ejb.EntityContext;
import java.util.Iterator;
import java.util.Vector;

public abstract class ArticuloBean implements EntityBean {

	private EntityContext context;

	private double tasaImpuestoGeneral;
	private double tasaImpuestoVideo;
	private double porcentaje;
	private int listaPVP;
    /*url editorial*/
    private String urlEditorial = null;
    /*url editorial*/

	public void ejbLoad() {
		// Lamento decir que hay un bug aparentemente en JRUN porque parece que reusa el EJB y deja sin borrar estas variables
		tasaImpuestoGeneral = 0.0;
		tasaImpuestoVideo = 0.0;
		porcentaje = 0.0;
		listaPVP = 0;

		// consulta de tasas
		try {
			if (getID_IMPUESTO() != null) {
				Pair tasas = DBUtil.calculaTasas(getID_IMPUESTO());
				tasaImpuestoGeneral = Convert.round(((Number) tasas.getValue1()).doubleValue());
				tasaImpuestoVideo = Convert.round(((Number) tasas.getValue2()).doubleValue());
			}
		} catch (Exception e) {
			TmkLogger.warn("No se pudo cargar las tasas del articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
		}

		// pricing
		try {
			Pair pair = DBUtil.calculaPricing(getID_ARTICULO());
			listaPVP = ((Integer) pair.getValue1()).intValue();
			porcentaje = Convert.round(((Double) pair.getValue2()).doubleValue());

		} catch (Exception e) {
			TmkLogger.warn("No se pudo calcular pricing para articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
		}

		//TmkLogger.debug("Articulo " + getID_ARTICULO() + ", imp. " + getID_IMPUESTO() + " %gral. " + tasaImpuestoGeneral + " %video "  + tasaImpuestoVideo + ", lista " + listaPVP + ", %desc " + porcentaje);
	}

	public void ejbStore() {
	}

	public void setEntityContext(EntityContext context) {
		this.context = context;
	}

	public void unsetEntityContext() throws EJBException {
		this.context = null;
	}

	public void ejbRemove() {
	}

	public void ejbActivate() {
	}

	public void ejbPassivate() {
	}

	public Integer ejbCreate(Integer ID_ARTICULO, String TITULO, String CODIGO_PROVEEDOR, String DESCRIPCION, java.sql.Timestamp FECHA_ALTA, String IDIOMA, Integer PAGINAS, Integer PESO, Double PRECIO_VENTA_VIGENTE, Double PRECIO_COMPRA_VIGENTE, Integer DESDE_EDAD, Integer HASTA_EDAD, String MARCA, String AGOTADO, String ACTIVO, String ARCHIVO_EN_SITE, String ARCHIVO_IMAGEN, String ARCHIVO_CAPITULO, Integer ID_ARTICULO_SITE, String ID_TIPO_ARTICULO, String ID_MONEDA_COMPRA, String ID_MONEDA_VENTA, Integer ID_EDITOR, Integer ID_PROVEEDOR, Integer ID_COLECCION, String ID_IMPUESTO, String NOVEDAD, String STOCK, String ES_TEXTO, String ESTADO_INGRESO, Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, Integer CATEGORIA_SUBFAMILIA, Integer ID_ACTIVIDAD_IIBB, Integer ID_COEDITOR, Integer NRO_EDICION, String COLECCION_DIRECTOR, String COLECCION_SERIE, String COLECCION_NUMERO, Integer NRO_VOLUMEN, Integer TOTAL_VOLUMENES, String TRADUCTOR, String COMPILADOR, String ILUSTRADOR, String COD_EXT_VISUAL, String AUXVARCHAR01, String AUXVARCHAR02, String AUXVARCHAR03, String AUXVARCHAR04, String AUXVARCHAR05, String AUXVARCHAR06, String AUXVARCHAR07, String AUXVARCHAR08, String AUXVARCHAR09, String AUXVARCHAR10, String AUXVARCHAR11, String AUXVARCHAR12, String AUXVARCHAR13, String AUXVARCHAR14, String AUXVARCHAR15, Integer AUXNUMBER01, Integer AUXNUMBER02, Integer AUXNUMBER03, Integer AUXNUMBER04, Integer AUXNUMBER05, Integer AUXNUMBER06, Integer AUXNUMBER07, Integer AUXNUMBER08, Integer AUXNUMBER09, Integer AUXNUMBER10, Integer AUXNUMBER11, Integer AUXNUMBER12, Integer AUXNUMBER13, Integer AUXNUMBER14, Integer AUXNUMBER15, String AUXFLAG01, String AUXFLAG02, String AUXFLAG03, String AUXFLAG04, String AUXFLAG05, String AUXFLAG06, String AUXFLAG07, String AUXFLAG08, String AUXFLAG09, String AUXFLAG10, String AUXFLAG11, String AUXFLAG12, String AUXFLAG13, String AUXFLAG14, String AUXFLAG15, String AUXLONGCHAR01, String AUXLONGCHAR02, Integer ID_DISPONIBILIDAD, String HABILITADO_TEMATIKA) throws CreateException {
		setID_ARTICULO(ID_ARTICULO);
		setTITULO(TITULO);
		setCODIGO_PROVEEDOR(CODIGO_PROVEEDOR);
		setDESCRIPCION(DESCRIPCION);
		setFECHA_ALTA(FECHA_ALTA);
		setIDIOMA(IDIOMA);
		setPAGINAS(PAGINAS);
		setPESO(PESO);
		setPRECIO_VENTA_VIGENTE(PRECIO_VENTA_VIGENTE);
		setPRECIO_COMPRA_VIGENTE(PRECIO_COMPRA_VIGENTE);
		setDESDE_EDAD(DESDE_EDAD);
		setHASTA_EDAD(HASTA_EDAD);
		setMARCA(MARCA);
		setAGOTADO(AGOTADO);
		setACTIVO(ACTIVO);
		setARCHIVO_EN_SITE(ARCHIVO_EN_SITE);
		setARCHIVO_IMAGEN(ARCHIVO_IMAGEN);
		setARCHIVO_CAPITULO(ARCHIVO_CAPITULO);
		setID_ARTICULO_SITE(ID_ARTICULO_SITE);
		setID_TIPO_ARTICULO(ID_TIPO_ARTICULO);
		setID_MONEDA_COMPRA(ID_MONEDA_COMPRA);
		setID_MONEDA_VENTA(ID_MONEDA_VENTA);
		setID_EDITOR(ID_EDITOR);
		setID_PROVEEDOR(ID_PROVEEDOR);
		setID_COLECCION(ID_COLECCION);
		setID_IMPUESTO(ID_IMPUESTO);
		setNOVEDAD(NOVEDAD);
		setSTOCK(STOCK);
		setES_TEXTO(ES_TEXTO);
		setESTADO_INGRESO(ESTADO_INGRESO);
		setCATEGORIA_SECCION(CATEGORIA_SECCION);
		setCATEGORIA_GRUPO(CATEGORIA_GRUPO);
		setCATEGORIA_FAMILIA(CATEGORIA_FAMILIA);
		setCATEGORIA_SUBFAMILIA(CATEGORIA_SUBFAMILIA);
		setID_ACTIVIDAD_IIBB(ID_ACTIVIDAD_IIBB);
		setID_COEDITOR(ID_COEDITOR);
		setNRO_EDICION(NRO_EDICION);
		setCOLECCION_DIRECTOR(COLECCION_DIRECTOR);
		setCOLECCION_SERIE(COLECCION_SERIE);
		setCOLECCION_NUMERO(COLECCION_NUMERO);
		setNRO_VOLUMEN(NRO_VOLUMEN);
		setTOTAL_VOLUMENES(TOTAL_VOLUMENES);
		setTRADUCTOR(TRADUCTOR);
		setCOMPILADOR(COMPILADOR);
		setILUSTRADOR(ILUSTRADOR);
		setCOD_EXT_VISUAL(COD_EXT_VISUAL);
		setAUXVARCHAR01(AUXVARCHAR01);
		setAUXVARCHAR02(AUXVARCHAR02);
		setAUXVARCHAR03(AUXVARCHAR03);
		setAUXVARCHAR04(AUXVARCHAR04);
		setAUXVARCHAR05(AUXVARCHAR05);
		setAUXVARCHAR06(AUXVARCHAR06);
		setAUXVARCHAR07(AUXVARCHAR07);
		setAUXVARCHAR08(AUXVARCHAR08);
		setAUXVARCHAR09(AUXVARCHAR09);
		setAUXVARCHAR10(AUXVARCHAR10);
		setAUXVARCHAR11(AUXVARCHAR11);
		setAUXVARCHAR12(AUXVARCHAR12);
		setAUXVARCHAR13(AUXVARCHAR13);
		setAUXVARCHAR14(AUXVARCHAR14);
		setAUXVARCHAR15(AUXVARCHAR15);
		setAUXNUMBER01(AUXNUMBER01);
		setAUXNUMBER01(AUXNUMBER01);
		setAUXNUMBER02(AUXNUMBER02);
		setAUXNUMBER03(AUXNUMBER03);
		setAUXNUMBER04(AUXNUMBER04);
		setAUXNUMBER05(AUXNUMBER05);
		setAUXNUMBER06(AUXNUMBER06);
		setAUXNUMBER07(AUXNUMBER07);
		setAUXNUMBER08(AUXNUMBER08);
		setAUXNUMBER09(AUXNUMBER08);
		setAUXNUMBER10(AUXNUMBER10);
		setAUXNUMBER11(AUXNUMBER11);
		setAUXNUMBER12(AUXNUMBER12);
		setAUXNUMBER13(AUXNUMBER13);
		setAUXNUMBER14(AUXNUMBER14);
		setAUXNUMBER15(AUXNUMBER15);
		setAUXFLAG01(AUXFLAG01);
		setAUXFLAG02(AUXFLAG02);
		setAUXFLAG03(AUXFLAG03);
		setAUXFLAG04(AUXFLAG04);
		setAUXFLAG05(AUXFLAG05);
		setAUXFLAG06(AUXFLAG06);
		setAUXFLAG07(AUXFLAG07);
		setAUXFLAG08(AUXFLAG08);
		setAUXFLAG09(AUXFLAG09);
		setAUXFLAG10(AUXFLAG10);
		setAUXFLAG11(AUXFLAG11);
		setAUXFLAG12(AUXFLAG12);
		setAUXFLAG13(AUXFLAG13);
		setAUXFLAG14(AUXFLAG14);
		setAUXFLAG15(AUXFLAG15);
		setAUXLONGCHAR01(AUXLONGCHAR01);
		setAUXLONGCHAR02(AUXLONGCHAR02);
		setID_DISPONIBILIDAD(ID_DISPONIBILIDAD);
		setHABILITADO_TEMATIKA(HABILITADO_TEMATIKA);
		return null;
	}

	public void ejbPostCreate(Integer ID_ARTICULO, String TITULO, String CODIGO_PROVEEDOR, String DESCRIPCION, java.sql.Timestamp FECHA_ALTA, String IDIOMA, Integer PAGINAS, Integer PESO, Double PRECIO_VENTA_VIGENTE, Double PRECIO_COMPRA_VIGENTE, Integer DESDE_EDAD, Integer HASTA_EDAD, String MARCA, String AGOTADO, String ACTIVO, String ARCHIVO_EN_SITE, String ARCHIVO_IMAGEN, String ARCHIVO_CAPITULO, Integer ID_ARTICULO_SITE, String ID_TIPO_ARTICULO, String ID_MONEDA_COMPRA, String ID_MONEDA_VENTA, Integer ID_EDITOR, Integer ID_PROVEEDOR, Integer ID_COLECCION, String ID_IMPUESTO, String NOVEDAD, String STOCK, String ES_TEXTO, String ESTADO_INGRESO, Integer CATEGORIA_SECCION, Integer CATEGORIA_GRUPO, Integer CATEGORIA_FAMILIA, Integer CATEGORIA_SUBFAMILIA, Integer ID_ACTIVIDAD_IIBB, Integer ID_COEDITOR, Integer NRO_EDICION, String COLECCION_DIRECTOR, String COLECCION_SERIE, String COLECCION_NUMERO, Integer NRO_VOLUMEN, Integer TOTAL_VOLUMENES, String TRADUCTOR, String COMPILADOR, String ILUSTRADOR, String COD_EXT_VISUAL, String AUXVARCHAR01, String AUXVARCHAR02, String AUXVARCHAR03, String AUXVARCHAR04, String AUXVARCHAR05, String AUXVARCHAR06, String AUXVARCHAR07, String AUXVARCHAR08, String AUXVARCHAR09, String AUXVARCHAR10, String AUXVARCHAR11, String AUXVARCHAR12, String AUXVARCHAR13, String AUXVARCHAR14, String AUXVARCHAR15, Integer AUXNUMBER01, Integer AUXNUMBER02, Integer AUXNUMBER03, Integer AUXNUMBER04, Integer AUXNUMBER05, Integer AUXNUMBER06, Integer AUXNUMBER07, Integer AUXNUMBER08, Integer AUXNUMBER09, Integer AUXNUMBER10, Integer AUXNUMBER11, Integer AUXNUMBER12, Integer AUXNUMBER13, Integer AUXNUMBER14, Integer AUXNUMBER15, String AUXFLAG01, String AUXFLAG02, String AUXFLAG03, String AUXFLAG04, String AUXFLAG05, String AUXFLAG06, String AUXFLAG07, String AUXFLAG08, String AUXFLAG09, String AUXFLAG10, String AUXFLAG11, String AUXFLAG12, String AUXFLAG13, String AUXFLAG14, String AUXFLAG15, String AUXLONGCHAR01, String AUXLONGCHAR02, Integer ID_DISPONIBILIDAD, String HABILITADO_TEMATIKA) {
	}

	// cmp field methods
	public abstract Integer getID_ARTICULO();

	public abstract void setID_ARTICULO(Integer ID_ARTICULO);

	public abstract String getTITULO();

	public abstract void setTITULO(String TITULO);

	public abstract String getCODIGO_PROVEEDOR();

	public abstract void setCODIGO_PROVEEDOR(String CODIGO_PROVEEDOR);

	public abstract String getDESCRIPCION();

	public abstract void setDESCRIPCION(String DESCRIPCION);

	public abstract java.sql.Timestamp getFECHA_ALTA();

	public abstract void setFECHA_ALTA(java.sql.Timestamp FECHA_ALTA);

	public abstract String getIDIOMA();

	public abstract void setIDIOMA(String IDIOMA);

	public abstract Integer getPAGINAS();

	public abstract void setPAGINAS(Integer PAGINAS);

	public abstract Integer getPESO();

	public abstract void setPESO(Integer PESO);

	public abstract Double getPRECIO_VENTA_VIGENTE();

	public abstract void setPRECIO_VENTA_VIGENTE(Double PRECIO_VENTA_VIGENTE);

	public abstract Double getPRECIO_COMPRA_VIGENTE();

	public abstract void setPRECIO_COMPRA_VIGENTE(Double PRECIO_COMPRA_VIGENTE);

	public abstract Integer getDESDE_EDAD();

	public abstract void setDESDE_EDAD(Integer DESDE_EDAD);

	public abstract Integer getHASTA_EDAD();

	public abstract void setHASTA_EDAD(Integer HASTA_EDAD);

	public abstract String getMARCA();

	public abstract void setMARCA(String MARCA);

	public abstract String getAGOTADO();

	public abstract void setAGOTADO(String AGOTADO);

	public abstract String getACTIVO();

	public abstract void setACTIVO(String ACTIVO);

	public abstract String getARCHIVO_EN_SITE();

	public abstract void setARCHIVO_EN_SITE(String ARCHIVO_EN_SITE);

	public abstract String getARCHIVO_IMAGEN();

	public abstract void setARCHIVO_IMAGEN(String ARCHIVO_IMAGEN);

	public abstract String getARCHIVO_CAPITULO();

	public abstract void setARCHIVO_CAPITULO(String ARCHIVO_CAPITULO);

	public abstract Integer getID_ARTICULO_SITE();

	public abstract void setID_ARTICULO_SITE(Integer ID_ARTICULO_SITE);

	public abstract String getID_TIPO_ARTICULO();

	public abstract void setID_TIPO_ARTICULO(String ID_TIPO_ARTICULO);

	public abstract String getID_MONEDA_COMPRA();

	public abstract void setID_MONEDA_COMPRA(String ID_MONEDA_COMPRA);

	public abstract String getID_MONEDA_VENTA();

	public abstract void setID_MONEDA_VENTA(String ID_MONEDA_VENTA);

	public abstract Integer getID_EDITOR();

	public abstract void setID_EDITOR(Integer ID_EDITOR);

	public abstract Integer getID_PROVEEDOR();

	public abstract void setID_PROVEEDOR(Integer ID_PROVEEDOR);

	public abstract Integer getID_COLECCION();

	public abstract void setID_COLECCION(Integer ID_COLECCION);

	public abstract String getID_IMPUESTO();

	public abstract void setID_IMPUESTO(String ID_IMPUESTO);

	public abstract String getNOVEDAD();

	public abstract void setNOVEDAD(String NOVEDAD);

	public abstract String getSTOCK();

	public abstract void setSTOCK(String STOCK);

	public abstract String getES_TEXTO();

	public abstract void setES_TEXTO(String ES_TEXTO);

	public abstract String getESTADO_INGRESO();

	public abstract void setESTADO_INGRESO(String ESTADO_INGRESO);

	public abstract Integer getCATEGORIA_SECCION();

	public abstract void setCATEGORIA_SECCION(Integer CATEGORIA_SECCION);

	public abstract Integer getCATEGORIA_GRUPO();

	public abstract void setCATEGORIA_GRUPO(Integer CATEGORIA_GRUPO);

	public abstract Integer getCATEGORIA_FAMILIA();

	public abstract void setCATEGORIA_FAMILIA(Integer CATEGORIA_FAMILIA);

	public abstract Integer getCATEGORIA_SUBFAMILIA();

	public abstract void setCATEGORIA_SUBFAMILIA(Integer CATEGORIA_SUBFAMILIA);

	public abstract Integer getID_ACTIVIDAD_IIBB();

	public abstract void setID_ACTIVIDAD_IIBB(Integer ID_ACTIVIDAD_IIBB);

	public abstract Integer getID_COEDITOR();

	public abstract void setID_COEDITOR(Integer ID_COEDITOR);

	public abstract Integer getNRO_EDICION();

	public abstract void setNRO_EDICION(Integer NRO_EDICION);

	public abstract String getCOLECCION_DIRECTOR();

	public abstract void setCOLECCION_DIRECTOR(String COLECCION_DIRECTOR);

	public abstract String getCOLECCION_SERIE();

	public abstract void setCOLECCION_SERIE(String COLECCION_SERIE);

	public abstract String getCOLECCION_NUMERO();

	public abstract void setCOLECCION_NUMERO(String COLECCION_NUMERO);

	public abstract Integer getNRO_VOLUMEN();

	public abstract void setNRO_VOLUMEN(Integer NRO_VOLUMEN);

	public abstract Integer getTOTAL_VOLUMENES();

	public abstract void setTOTAL_VOLUMENES(Integer TOTAL_VOLUMENES);

	public abstract String getTRADUCTOR();

	public abstract void setTRADUCTOR(String TRADUCTOR);

	public abstract String getCOMPILADOR();

	public abstract void setCOMPILADOR(String COMPILADOR);

	public abstract String getILUSTRADOR();

	public abstract void setILUSTRADOR(String ILUSTRADOR);

	public abstract String getCOD_EXT_VISUAL();

	public abstract void setCOD_EXT_VISUAL(String COD_EXT_VISUAL);

	public abstract String getAUXVARCHAR01();

	public abstract void setAUXVARCHAR01(String AUXVARCHAR01);

	public abstract String getAUXVARCHAR02();

	public abstract void setAUXVARCHAR02(String AUXVARCHAR02);

	public abstract String getAUXVARCHAR03();

	public abstract void setAUXVARCHAR03(String AUXVARCHAR03);

	public abstract String getAUXVARCHAR04();

	public abstract void setAUXVARCHAR04(String AUXVARCHAR04);

	public abstract String getAUXVARCHAR05();

	public abstract void setAUXVARCHAR05(String AUXVARCHAR05);

	public abstract String getAUXVARCHAR06();

	public abstract void setAUXVARCHAR06(String AUXVARCHAR06);

	public abstract String getAUXVARCHAR07();

	public abstract void setAUXVARCHAR07(String AUXVARCHAR07);

	public abstract String getAUXVARCHAR08();

	public abstract void setAUXVARCHAR08(String AUXVARCHAR08);

	public abstract String getAUXVARCHAR09();

	public abstract void setAUXVARCHAR09(String AUXVARCHAR09);

	public abstract String getAUXVARCHAR10();

	public abstract void setAUXVARCHAR10(String AUXVARCHAR10);

	public abstract String getAUXVARCHAR11();

	public abstract void setAUXVARCHAR11(String AUXVARCHAR11);

	public abstract String getAUXVARCHAR12();

	public abstract void setAUXVARCHAR12(String AUXVARCHAR12);

	public abstract String getAUXVARCHAR13();

	public abstract void setAUXVARCHAR13(String AUXVARCHAR13);

	public abstract String getAUXVARCHAR14();

	public abstract void setAUXVARCHAR14(String AUXVARCHAR14);

	public abstract String getAUXVARCHAR15();

	public abstract void setAUXVARCHAR15(String AUXVARCHAR15);

	public abstract Integer getAUXNUMBER01();

	public abstract void setAUXNUMBER01(Integer AUXNUMBER01);

	public abstract Integer getAUXNUMBER02();

	public abstract void setAUXNUMBER02(Integer AUXNUMBER02);

	public abstract Integer getAUXNUMBER03();

	public abstract void setAUXNUMBER03(Integer AUXNUMBER03);

	public abstract Integer getAUXNUMBER04();

	public abstract void setAUXNUMBER04(Integer AUXNUMBER04);

	public abstract Integer getAUXNUMBER05();

	public abstract void setAUXNUMBER05(Integer AUXNUMBER05);

	public abstract Integer getAUXNUMBER06();

	public abstract void setAUXNUMBER06(Integer AUXNUMBER06);

	public abstract Integer getAUXNUMBER07();

	public abstract void setAUXNUMBER07(Integer AUXNUMBER07);

	public abstract Integer getAUXNUMBER08();

	public abstract void setAUXNUMBER08(Integer AUXNUMBER08);

	public abstract Integer getAUXNUMBER09();

	public abstract void setAUXNUMBER09(Integer AUXNUMBER09);

	public abstract Integer getAUXNUMBER10();

	public abstract void setAUXNUMBER10(Integer AUXNUMBER10);

	public abstract Integer getAUXNUMBER11();

	public abstract void setAUXNUMBER11(Integer AUXNUMBER11);

	public abstract Integer getAUXNUMBER12();

	public abstract void setAUXNUMBER12(Integer AUXNUMBER12);

	public abstract Integer getAUXNUMBER13();

	public abstract void setAUXNUMBER13(Integer AUXNUMBER13);

	public abstract Integer getAUXNUMBER14();

	public abstract void setAUXNUMBER14(Integer AUXNUMBER14);

	public abstract Integer getAUXNUMBER15();

	public abstract void setAUXNUMBER15(Integer AUXNUMBER15);

	public abstract String getAUXFLAG01();

	public abstract void setAUXFLAG01(String AUXFLAG01);

	public abstract String getAUXFLAG02();

	public abstract void setAUXFLAG02(String AUXFLAG02);

	public abstract String getAUXFLAG03();

	public abstract void setAUXFLAG03(String AUXFLAG03);

	public abstract String getAUXFLAG04();

	public abstract void setAUXFLAG04(String AUXFLAG04);

	public abstract String getAUXFLAG05();

	public abstract void setAUXFLAG05(String AUXFLAG05);

	public abstract String getAUXFLAG06();

	public abstract void setAUXFLAG06(String AUXFLAG06);

	public abstract String getAUXFLAG07();

	public abstract void setAUXFLAG07(String AUXFLAG07);

	public abstract String getAUXFLAG08();

	public abstract void setAUXFLAG08(String AUXFLAG08);

	public abstract String getAUXFLAG09();

	public abstract void setAUXFLAG09(String AUXFLAG09);

	public abstract String getAUXFLAG10();

	public abstract void setAUXFLAG10(String AUXFLAG10);

	public abstract String getAUXFLAG11();

	public abstract void setAUXFLAG11(String AUXFLAG11);

	public abstract String getAUXFLAG12();

	public abstract void setAUXFLAG12(String AUXFLAG12);

	public abstract String getAUXFLAG13();

	public abstract void setAUXFLAG13(String AUXFLAG13);

	public abstract String getAUXFLAG14();

	public abstract void setAUXFLAG14(String AUXFLAG14);

	public abstract String getAUXFLAG15();

	public abstract void setAUXFLAG15(String AUXFLAG15);

	public abstract String getAUXLONGCHAR01();

	public abstract void setAUXLONGCHAR01(String AUXLONGCHAR01);

	public abstract String getAUXLONGCHAR02();

	public abstract void setAUXLONGCHAR02(String AUXLONGCHAR02);

	public abstract Integer getID_DISPONIBILIDAD();

	public abstract void setID_DISPONIBILIDAD(Integer ID_DISPONIBILIDAD);

	public DisponibilidadDAO getDISPONIBILIDAD_SITIO() {
		return DisponibilidadDAO.buscaDisponibilidad(getID_DISPONIBILIDAD());
	}

	public Integer getID_DISPONIBILIDAD_SITIO() {
		return new Integer(getDISPONIBILIDAD_SITIO().getId());
	}

	public abstract String getHABILITADO_TEMATIKA();

	public abstract void setHABILITADO_TEMATIKA(String HABILITADO_TEMATIKA);

	public boolean getESTA_HABILITADO_TEMATIKA() {
		return "S".equalsIgnoreCase(getHABILITADO_TEMATIKA());
	}

	public Double getPRECIO_ORIGINAL() {
		Double pvp = getPRECIO_VENTA_VIGENTE();
		double importe = Math.max((pvp == null) ? 0.0 : pvp.doubleValue(), Globals.IMPORTE_MINIMO_AFIP);
		return new Double(Convert.round(importe));
	}

	public Double getPRECIO_CON_IMPUESTOS() {
		double importe = Convert.aplicarPorcentaje(getPRECIO_ORIGINAL().doubleValue(), tasaImpuestoGeneral + tasaImpuestoVideo);
		return new Double(Convert.round(importe));
	}

	public Double getPRECIO_CON_DESCUENTO() {
		double importe = Convert.aplicarPorcentaje(getPRECIO_CON_IMPUESTOS().doubleValue(), porcentaje);
		return new Double(Convert.round(importe));
	}

	public Double getAHORRO() {
		double importe = Convert.porcentajeResultante(getPRECIO_CON_IMPUESTOS().doubleValue(), porcentaje);
		return new Double(Convert.round(importe));
	}

	public Double getPRECIO_SITIO() {
		return getPRECIO_CON_DESCUENTO();
	}

	public Double getPORCENTAJE_DESCUENTO() {
		return new Double(porcentaje);
	}

	public Integer getLISTA_PVP() {
		return new Integer(listaPVP);
	}

	public Double getTASA_IMPUESTO_GENERAL() {
		return new Double(tasaImpuestoGeneral);
	}

	public Double getTASA_IMPUESTO_VIDEO() {
		return new Double(tasaImpuestoVideo);
	}

	public boolean getTIENE_DESCUENTO() {
		return (porcentaje < 0.0);
	}

	public Vector getAUTORES() {
		return getNombreRoles("A01");
	}

	public Vector getID_AUTORES() {
		return getClaveRoles("A01");
	}

	public Vector getPRODUCTORES() {
		return getNombreRoles("D01");
	}

	public Vector getPROTAGONISTAS() {
		return getNombreRoles("E01");
	}

	public Vector getDIRECTORES() {
		return getNombreRoles("D02");
	}

	public Vector getID_DIRECTORES() {
		return getClaveRoles("D02");
	}

	public java.sql.Timestamp getFECHA_ESTRENO() {
		return getFECHA_ALTA();
	}

	public Integer getALTO() {
		return getAUXNUMBER05();
	}

	public Integer getANCHO() {
		return getAUXNUMBER06();
	}

	public String getFORMATO() {
		try {
			String claveFormato = getAUXVARCHAR03();
			String result = (claveFormato == null) ? null : DBUtil.cargarDatosGenerico("ONIX:ProductForm", claveFormato);
			if (result != null) {
				if (result.indexOf("ESP-Book Book ¿ detail unspecified") > -1) {
					result = null;
				}
			}

			return (result == null) ? DBUtil.getTipoDeArticulo(getID_TIPO_ARTICULO()) : result;
		} catch (Exception e) {
			return null;
		}
	}

	public String getIDIOMA_ORIGINAL() {
		return getAUXVARCHAR07();
	}

	public Integer getPROFUNDIDAD() {
		return getAUXNUMBER07();
	}

	public String getTIPO_EDICION() {
		return getAUXVARCHAR06();
	}

	public String getSUBTITULO() {
		return getAUXVARCHAR04();
	}

	public String getTITULO_ORIGINAL() {
		return getAUXVARCHAR05();
	}

	public Boolean getESTA_AGOTADO() {
		return new Boolean("SI".equalsIgnoreCase(getAGOTADO()));
	}

	public Integer getPAIS_PUBLICACION() {
		return getAUXNUMBER04();
	}

	public Integer getPAIS_IMPRESION() {
		return getAUXNUMBER08();
	}

	public Integer getANO_IMPRESION() {
		return getAUXNUMBER09();
	}

	public String getCODIGO_DISPONIBILIDAD_ONIX() {
		return getAUXVARCHAR08();
	}

	public String getISBN() {
		return getCOD_EXT_VISUAL();
	}

	public String getCALIFICACION() {
		try {
			String auditorio = DBUtil.getAuditorio(getID_ARTICULO());
			return (auditorio == null) ? null : DBUtil.cargarDatosGenerico("ONIX:AudienceCode", auditorio);
		} catch (Exception e) {
			return null;
		}
	}

	public Integer getDURACION() {
		return getPAGINAS();
	}

	public String getREGION() {
		return getAUXVARCHAR12();
	}

	public String getGENERO() {
		try {
			String genero = DBUtil.getGenero(getID_ARTICULO());
			return (("S/D".equalsIgnoreCase(genero) || "S / D".equalsIgnoreCase(genero))) ? "Sin descripción" : genero;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el genero para el articulo " + getID_ARTICULO());
			return null;
		}
	}

	public String getAUDIO() {
		return getAUXVARCHAR13();
	}

	public String getSINOPSIS() {
		String temp = getArticuloTexto("01", "ES");
		if (temp == null) temp = getArticuloTexto("02", "ES");
		//if (temp!=null) temp = temp.replaceAll("\n","<br>").replaceAll("\r", "<br>");
		return temp;
	}

	public String getTABLA_DE_CONTENIDO() {
		return getArticuloTexto("04");
	}

	public String getCRITICA() {
		String temp = getArticuloTexto("07");
		if (temp == null) temp = getArticuloTexto("08");
		return temp;
	}

	public String getDESCRIPCION_DEL_LECTOR() {
		return getArticuloTexto("12");
	}

	public String getPRIMER_CAPITULO() {
		return getArticuloTexto("24");
	}

	public String getINFORMACION_ADICIONAL() {
		return getArticuloTexto("26");
	}

	public String getINTRODUCCION() {
		return getArticuloTexto("33");
	}

	public Vector getARTICULOS_RECOMENDADOS() {
		try {
			Vector articulosRecomendados = DBUtil.recomendarArticulo(getID_ARTICULO().intValue());
			return (articulosRecomendados.isEmpty()) ? null : articulosRecomendados;

		} catch (Exception e) {
			TmkLogger.error("No se pudo recomendar articulo para el articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
			return null;
		}
	}

	/*public Vector getAUTORES_RECOMENDADOS() {
		try {
			Vector autoresTodosLosRecomendados = null;
			// toma la recomendacion
			Vector articulosRecomendados = getARTICULOS_RECOMENDADOS();
			if ((articulosRecomendados != null) && (!articulosRecomendados.isEmpty())) {
				autoresTodosLosRecomendados = DBUtil.autoresPorArticulos(articulosRecomendados);
			}
			return (autoresTodosLosRecomendados == null || autoresTodosLosRecomendados.isEmpty()) ? null : autoresTodosLosRecomendados;
		} catch (Exception e) {
			TmkLogger.error("No se pudo recomendar autor para el articulo " + getID_ARTICULO() + ". Error " + e.getMessage());
			return null;
		}
	}*/

	public Vector getTEMAS() {
		return DBUtil.getTemasMusicales(getID_ARTICULO().intValue());
	}

	public String getATRIBUTO_PRINCIPAL() {

		String texto = null;
		switch (getCATEGORIA_SECCION().intValue()) {

			case Globals.SECCION_LIBRO:         // Continua abajo para no repetir lo mismo
			case Globals.SECCION_REVISTAS: {
				Vector autores = getAUTORES();
				texto = (autores == null || autores.isEmpty()) ? "" : (autores.size() == 1) ? Convert.nombrePropio(autores.firstElement().toString()) : "Autores varios";

			} break;

			case Globals.SECCION_MUSICA: {
				Vector interpretes = getAUTORES();
				texto = (interpretes == null || interpretes.isEmpty()) ? "" : (interpretes.size() == 1) ? Convert.nombrePropio(interpretes.firstElement().toString()) : "Intérpretes varios";

			} break;

			case Globals.SECCION_PELICULA: {
				Vector directores = getDIRECTORES();
				texto = (directores == null || directores.isEmpty()) ? "" : (directores.size() == 1) ? Convert.nombrePropio(directores.firstElement().toString()) : "Directores varios";

			} break;

			case Globals.SECCION_JUGUETES: {     // Continua abajo para no repetir lo mismo
				// Productora
				try {
					ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
					ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
					texto = Convert.nombrePropio(proveedor.getNOMBRE(), false);
				} catch (Exception e) {
					TmkLogger.debug("No se pudo cargar el Proveedor para " + getID_ARTICULO());
				}


			} break;

			default: {
				TmkLogger.error("ATRIBUTO_PRINCIPAL: Se esta mostrando un producto de una caterogia no registrada. Categoria: " + getCATEGORIA_SECCION() + " Articulo:" + getID_ARTICULO());
			}
		}
		return texto;

	}

	public Vector getATRIBUTOS_DESTACADOS(boolean repetirInformacion, boolean agregarSecundarios, boolean agregarSinopsis) {
		return getATRIBUTOS_DESTACADOS(repetirInformacion, agregarSecundarios, agregarSinopsis, true);
	}

	public Vector getATRIBUTOS_DESTACADOS(boolean repetirInformacion, boolean agregarSecundarios, boolean agregarSinopsis, boolean mejorarTitulo) {

		Vector atributos = new Vector();

		if (repetirInformacion) atributos.add(new Pair("Título", Convert.corregir(getTITULO(), true, mejorarTitulo)));

		switch (getCATEGORIA_SECCION().intValue()) {

			case Globals.SECCION_LIBRO:         // Continua abajo para no repetir lo mismo
			case Globals.SECCION_REVISTAS: {

					// PRIMERO EL NOMBRE DE LOS AUTORES
					Vector nombresAutores = getAUTORES();
					if ((nombresAutores != null) && (!nombresAutores.isEmpty())) {
						StringBuffer nombres = new StringBuffer();
						for (int i = 0; i < nombresAutores.size(); i++) {
							nombres.append((i == 0) ? "" : " / ").append(Convert.nombrePropio(nombresAutores.get(i).toString()));
						}
						atributos.add(new Pair(Convert.plural(nombresAutores.size(), "Autor"), nombres));
					}

					// Editor
					try {
						EditorLocalHome editorHome = (EditorLocalHome) DBUtil.getHome("Editor");
						EditorLocal editor = editorHome.findByPrimaryKey(getID_EDITOR());
						atributos.add(new Pair("Editorial", Convert.nombrePropio(editor.getNOMBRE(), false)));
                        /*url editorial*/

						//urlEditorial =editor.getURL();

                        /*url editorial*/
					} catch (Exception e) {
						TmkLogger.debug("No se pudo cargar el editor para " + getID_ARTICULO());
					}

					// ISBN
					if (getISBN() != null) atributos.add(new Pair("ISBN", Convert.toString(getISBN())));

					// Estos campos van solo para el detalle completo
					if (agregarSecundarios) {

						// Formato
						if (getFORMATO() != null) atributos.add(new Pair("Formato", Convert.toString(Convert.corregir(getFORMATO(), false), "No especificado")));

						// Grupo correspondiente
						try {
							CategGrupoPK pk = new CategGrupoPK();
							pk.CATEGORIA_SECCION = getCATEGORIA_SECCION();
							pk.CATEGORIA_GRUPO = getCATEGORIA_GRUPO();
							CategGrupoLocalHome categGrupoLocalHome = (CategGrupoLocalHome) DBUtil.getHome("CategGrupo");
							CategGrupoLocal categGrupoLocal = categGrupoLocalHome.findByPrimaryKey(pk);
							atributos.add(new Pair("Clasificación", Convert.nombrePropio(categGrupoLocal.getDESCRIPCION(), false)));
						} catch (Exception e) {
							TmkLogger.debug("No se pudo cargar la seccion para " + getID_ARTICULO());
						}

						// Fecha de publicación
						if (getFECHA_ALTA() != null) atributos.add(new Pair("Publicación", Convert.toStringPublicacion(getFECHA_ALTA())));

						// Nro de edicion
						if (getNRO_EDICION() != null) atributos.add(new Pair("Edición", Convert.toString(getNRO_EDICION())));

						// Peso
						if (getPESO() != null) atributos.add(new Pair("Peso", Convert.toGramos(getPESO().intValue())));

						// Cantidad de páginas
						if (getPAGINAS() != null) atributos.add(new Pair("Páginas", Convert.toString(getPAGINAS())));

						// Idioma
						if (getIDIOMA() != null) atributos.add(new Pair("Idioma", IdiomaDAO.buscaIdioma(getIDIOMA()).getNombre()));

						// Medidas
						if ((getALTO() != null) && (getANCHO() != null) && (getPROFUNDIDAD() != null)) {
							StringBuffer medidas = new StringBuffer();
							medidas.append(Convert.toMM(getALTO().doubleValue()));
							medidas.append(" x ");
							medidas.append(Convert.toMM(getANCHO().doubleValue()));
							medidas.append(" x ");
							medidas.append(Convert.toMM(getPROFUNDIDAD().doubleValue()));
							atributos.add(new Pair("Medida", medidas));
						}

						// Productora
						try {
							ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
							ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
							atributos.add(new Pair("Proveedor", Convert.nombrePropio(proveedor.getNOMBRE(), false)));
						} catch (Exception e) {
							TmkLogger.debug("No se pudo cargar el Proveedor para " + getID_ARTICULO());
						}

					}

					break;

			}

			case Globals.SECCION_JUGUETES: {

					// PRIMERO EL NOMBRE DE LOS AUTORES
					Vector nombresAutores = getAUTORES();
					if ((nombresAutores != null) && (!nombresAutores.isEmpty())) {
						StringBuffer nombres = new StringBuffer();
						for (int i = 0; i < nombresAutores.size(); i++) {
							nombres.append((i == 0) ? "" : " / ").append(Convert.nombrePropio(nombresAutores.get(i).toString()));
						}
						atributos.add(new Pair(Convert.plural(nombresAutores.size(), "Autor"), nombres));
					}

					// Editor
					try {
						EditorLocalHome editorHome = (EditorLocalHome) DBUtil.getHome("Editor");
						EditorLocal editor = editorHome.findByPrimaryKey(getID_EDITOR());
						atributos.add(new Pair("Editorial", Convert.nombrePropio(editor.getNOMBRE(), false)));
                        /*url editorial*/
                        //this.urlEditorial = editor.getURL();
                        /*url editorial*/
					} catch (Exception e) {
						TmkLogger.debug("No se pudo cargar el editor para " + getID_ARTICULO());
					}

					// ISBN
					if (getISBN() != null) atributos.add(new Pair("ISBN", Convert.toString(getISBN())));

					if (agregarSecundarios) {
						// Idioma
						if (getIDIOMA() != null) atributos.add(new Pair("Idioma", IdiomaDAO.buscaIdioma(getIDIOMA()).getNombre()));

						// Peso
						if (getPESO() != null) atributos.add(new Pair("Peso", Convert.toGramos(getPESO().intValue())));

						// Cantidad de páginas
						if (getPAGINAS() != null) atributos.add(new Pair("Páginas", Convert.toString(getPAGINAS())));

						// Medidas
						if ((getALTO() != null) && (getANCHO() != null) && (getPROFUNDIDAD() != null)) {
							StringBuffer medidas = new StringBuffer();
							medidas.append(Convert.toMM(getALTO().doubleValue()));
							medidas.append(" x ");
							medidas.append(Convert.toMM(getANCHO().doubleValue()));
							medidas.append(" x ");
							medidas.append(Convert.toMM(getPROFUNDIDAD().doubleValue()));
							atributos.add(new Pair("Medida", medidas));
						}

						// Productora
						try {
							ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
							ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
							atributos.add(new Pair("Proveedor", Convert.nombrePropio(proveedor.getNOMBRE(), false)));
						} catch (Exception e) {
							TmkLogger.debug("No se pudo cargar el Proveedor para " + getID_ARTICULO());
						}

					}
					break;
			}

			case Globals.SECCION_MUSICA: {

					// PRIMERO EL NOMBRE DE LOS INTERPRETES
					Vector nombresInterpretes = getAUTORES();
					if ((nombresInterpretes != null) && (!nombresInterpretes.isEmpty())) {
						StringBuffer nombres = new StringBuffer();
						for (int i = 0; i < nombresInterpretes.size(); i++) {
							//nombres.append((i == 0) ? "" : " / ").append(Convert.nombrePropio(nombresInterpretes.get(i).toString()));
							nombres.append((i == 0) ? "" : " / ").append(Convert.capitalizar(nombresInterpretes.get(i).toString().toUpperCase().replaceFirst("\\[MUS]", ""), true));
						}
						atributos.add(new Pair(Convert.plural(nombresInterpretes.size(), "Intérprete"), nombres));
					}

					// Discografica
					try {
						EditorLocalHome editorHome = (EditorLocalHome) DBUtil.getHome("Editor");
						EditorLocal editor = editorHome.findByPrimaryKey(getID_EDITOR());
						atributos.add(new Pair("Discográfica", Convert.nombrePropio(editor.getNOMBRE(), false)));
                        /*url editorial*/
                        //this.urlEditorial = editor.getURL();
                        /*url editorial*/
					} catch (Exception e) {
						TmkLogger.debug("No se pudo cargar la discografica para " + getID_ARTICULO());
					}

					// Formato
					if (getFORMATO() != null) atributos.add(new Pair("Formato", Convert.toString(Convert.corregir(getFORMATO(), false), "No especificado")));

					// Estos campos van solo para el detalle completo
					if (agregarSecundarios) {

						// Genero
						if (getGENERO() != null) atributos.add(new Pair("Género", Convert.toString(getGENERO())));

						// Fecha de lanzamiento
						if (getFECHA_ALTA() != null) atributos.add(new Pair("Lanzamiento", Convert.toStringPublicacion(getFECHA_ALTA())));

						// Productora
						try {
							ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
							ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
							atributos.add(new Pair("Proveedor", Convert.nombrePropio(proveedor.getNOMBRE(), false)));
						} catch (Exception e) {
							TmkLogger.debug("No se pudo cargar el Proveedor para " + getID_ARTICULO());
						}

					}

					break;
			}

			case Globals.SECCION_PELICULA: {

				// PRIMERO EL NOMBRE DE LOS DIRECTORES
				Vector nombresDirectores = getDIRECTORES();
				if ((nombresDirectores != null) && (!nombresDirectores.isEmpty())) {
					StringBuffer nombres = new StringBuffer();
					for (int i = 0; i < nombresDirectores.size(); i++) {
						nombres.append((i == 0) ? "" : " / ").append(Convert.nombrePropio(nombresDirectores.get(i).toString()));
					}
					atributos.add(new Pair(Convert.plural(nombresDirectores.size(), "Director"), nombres));
				}

				// PRIMERO EL NOMBRE DE LOS PROTAGONISTAS
				Vector nombresProtagonistas = getPROTAGONISTAS();
				if ((nombresProtagonistas != null) && (!nombresProtagonistas.isEmpty())) {
					StringBuffer nombres = new StringBuffer();
					for (int i = 0; i < nombresProtagonistas.size(); i++) {
						nombres.append((i == 0) ? "" : " / ").append(Convert.nombrePropio(nombresProtagonistas.get(i).toString()));
					}
					atributos.add(new Pair(Convert.plural(nombresProtagonistas.size(), "Protagonista"), nombres));
				}

				// Productora
				try {
					EditorLocalHome editorHome = (EditorLocalHome) DBUtil.getHome("Editor");
					EditorLocal editor = editorHome.findByPrimaryKey(getID_EDITOR());
					atributos.add(new Pair("Productora", Convert.nombrePropio(editor.getNOMBRE(), false)));
                    /*url editorial*/
                    //this.urlEditorial = editor.getURL();
                    /*url editorial*/
				} catch (Exception e) {
					TmkLogger.debug("No se pudo cargar el editor para " + getID_ARTICULO());
				}

				// Formato
				if (getFORMATO() != null) atributos.add(new Pair("Formato", Convert.toString(Convert.corregir(getFORMATO(), false), "No especificado")));

				// Estos campos van solo para el detalle completo
				if (agregarSecundarios) {

					// Calificación
					if (getCALIFICACION() != null) atributos.add(new Pair("Calificación", Convert.toString(getCALIFICACION())));

					// Duración
					if (getDURACION() != null) atributos.add(new Pair("Duración", Convert.toMIN(getDURACION().doubleValue())));

					// Audio
					if (getAUDIO() != null) atributos.add(new Pair("Audio", Convert.capitalizar(getAUDIO(), false)));

					// Fecha de publicación
					if (getFECHA_ALTA() != null) atributos.add(new Pair("Estreno", Convert.toStringPublicacion(getFECHA_ALTA())));

					// El generó en peliculas esta en otro lado... jeje... vamos con los ifs...
					try {
						CategGrupoPK pk = new CategGrupoPK();
						pk.CATEGORIA_SECCION = getCATEGORIA_SECCION();
						pk.CATEGORIA_GRUPO = getCATEGORIA_GRUPO();
						CategGrupoLocalHome categGrupoLocalHome = (CategGrupoLocalHome) DBUtil.getHome("CategGrupo");
						CategGrupoLocal categGrupoLocal = categGrupoLocalHome.findByPrimaryKey(pk);
						atributos.add(new Pair("Género", Convert.corregir(categGrupoLocal.getDESCRIPCION(), true)));
					} catch (Exception e) {
						TmkLogger.debug("No se pudo cargar la seccion para " + getID_ARTICULO());
					}

					// Productora
					try {
						ProveedorLocalHome proveedorHome = (ProveedorLocalHome) DBUtil.getHome("Proveedor");
						ProveedorLocal proveedor = proveedorHome.findByPrimaryKey(getID_PROVEEDOR());
						atributos.add(new Pair("Proveedor", Convert.nombrePropio(proveedor.getNOMBRE(), false)));
					} catch (Exception e) {
						TmkLogger.debug("No se pudo cargar el Proveedor para " + getID_ARTICULO());
					}

				}

				break;
			}

			default : {
					TmkLogger.error("ATRIBUTOS_DESTACADOS: Se esta mostrando un producto de una caterogia no registrada. Categoria: " + getCATEGORIA_SECCION() + " Articulo:" + getID_ARTICULO());
			}
		}

		if (repetirInformacion) atributos.add(new Pair("Disponibilidad", getDISPONIBILIDAD_SITIO().getNombre()));

		if (agregarSinopsis) {
			String sinopsis = getSINOPSIS();
			if (sinopsis != null) atributos.add(new Pair("Sinopsis", Convert.toString(sinopsis, 350)));
		}

		return atributos;
	}

	public Vector getATRIBUTOS() {
		try {
			Vector result = getATRIBUTOS_DESTACADOS(false, true, false);
			Vector atributosVarios = DBUtil.getAtributosDinamicos(getID_ARTICULO().intValue(), getCATEGORIA_SECCION(), getCATEGORIA_GRUPO(), getCATEGORIA_FAMILIA());
			if ((atributosVarios != null) && (!atributosVarios.isEmpty())) result.addAll(atributosVarios);
			return result;
		} catch (Exception e) {
			return null; // No tiene nada
		}
	}

	private String getArticuloTexto(String tipo) {
		return getArticuloTexto(tipo, null);
	}

	private String getArticuloTexto(String tipo, String idioma) {
		try {
			StringBuffer buffer = new StringBuffer();

			ArticuloTextoLocalHome articuloTextoLocalHome = (ArticuloTextoLocalHome) DBUtil.getHome("ArticuloTexto");
			Iterator iterator = articuloTextoLocalHome.findTextos(getID_ARTICULO(), tipo).iterator();
			while (iterator.hasNext()) {
				ArticuloTextoLocal articuloTextoLocal = (ArticuloTextoLocal) iterator.next();
				if ((idioma == null) || (idioma.equalsIgnoreCase(articuloTextoLocal.getIDIOMA()))) {
					buffer.append(articuloTextoLocal.getTEXTO());
				}
			}

			return (buffer.length() > 0) ? buffer.toString() : null;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el texto para el articulo " + getID_ARTICULO() + " y tipo " + tipo);
			return null;
		}
	}

	private Vector getNombreRoles(String rol) {
		try {
			Vector result = new Vector();
			ArticuloAutoresLocalHome articuloAutoresLocalHome = (ArticuloAutoresLocalHome) DBUtil.getHome("ArticuloAutores");
			AutorLocalHome autorLocalHome = (AutorLocalHome) DBUtil.getHome("Autor");
			Iterator iterator = articuloAutoresLocalHome.findAutores(getID_ARTICULO(), rol).iterator();
			while (iterator.hasNext()) {
				ArticuloAutoresLocal articuloAutores = (ArticuloAutoresLocal) iterator.next();
				AutorLocal autorLocal = autorLocalHome.findByPrimaryKey(articuloAutores.getID_AUTOR());
				result.add(autorLocal.getDESCRIPCION());
			}
			return result;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el rol para el articulo " + getID_ARTICULO() + " y rol " + rol);
			return null;
		}
	}

	private Vector getClaveRoles(String rol) {
		try {
			Vector result = new Vector();
			ArticuloAutoresLocalHome articuloAutoresLocalHome = (ArticuloAutoresLocalHome) DBUtil.getHome("ArticuloAutores");
			Iterator iterator = articuloAutoresLocalHome.findAutores(getID_ARTICULO(), rol).iterator();
			while (iterator.hasNext()) {
				ArticuloAutoresLocal articuloAutores = (ArticuloAutoresLocal) iterator.next();
				result.add(articuloAutores.getID_AUTOR());
			}
			return result;

		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar el rol para el articulo " + getID_ARTICULO() + " y rol " + rol);
			return null;
		}
	}

  	public String getGrupoDescripcion() {
		CategGrupoPK grupoPK = new CategGrupoPK(this.getCATEGORIA_SECCION(), this.getCATEGORIA_GRUPO());
		try {
			CategGrupoLocalHome grupoHome = (CategGrupoLocalHome)DBUtil.getHome("CategGrupo");
		    CategGrupoLocal grupo = grupoHome.findByPrimaryKey(grupoPK);
			return (grupo.getDESCRIPCION().replaceAll("\\.", "").equals("S / D"))? null:grupo.getDESCRIPCION();
		} catch (Exception e) {
			return null;
		}
	}

	public String getFamiliaDescripcion() {
		 CategFamiliaPK familiaPK = new CategFamiliaPK(this.getCATEGORIA_SECCION(), this.getCATEGORIA_GRUPO(), this.getCATEGORIA_FAMILIA());
		try {
	        CategFamiliaLocalHome familiaHome = (CategFamiliaLocalHome)DBUtil.getHome("CategFamilia");
            CategFamiliaLocal familia = familiaHome.findByPrimaryKey(familiaPK);
			return (familia.getDESCRIPCION().replaceAll("\\.", "").equals("S / D"))? null:familia.getDESCRIPCION();
		} catch (Exception e) {
			return null;
		}
	}

	public String getCategorizacion() {
        return Convert.corregir(Convert.toString(getFamiliaDescripcion(), Convert.toString(getGrupoDescripcion(), "Más Productos")), true);
	}

	public String getSubFamiliaDescripcion() {
		 CategSubFamiliaPK subFamiliaPK = new CategSubFamiliaPK(this.getCATEGORIA_SECCION(), this.getCATEGORIA_GRUPO(), this.getCATEGORIA_FAMILIA(), this.getCATEGORIA_SUBFAMILIA());
		try {
	        CategSubFamiliaLocalHome subFamiliaHome = (CategSubFamiliaLocalHome)DBUtil.getHome("CategSubFamilia");
            CategSubFamiliaLocal subFamilia = subFamiliaHome.findByPrimaryKey(subFamiliaPK);
			return (subFamilia.getDESCRIPCION().replaceAll("\\.", "").equals("S / D"))? null:subFamilia.getDESCRIPCION();
		} catch (Exception e) {
			return null;
		}
	}

	public String getUrlBusquedaXCategoria () {
		StringBuffer pagina = new StringBuffer();
		pagina.append(BuscadorHelper.PAGINA_BUSCADOR).append("?").append(BuscadorHelper.CLAVE_DE_BUSQUEDA).append("=").append(BuscadorHelper.POR_CATEGORIAS);
		if (this.getCATEGORIA_SECCION().intValue() > 0) pagina.append("&").append(BuscadorHelper.CATEGORIA_SECCION).append("=").append(this.getCATEGORIA_SECCION().intValue());
		if (this.getCATEGORIA_GRUPO().intValue() > 0) pagina.append("&").append(BuscadorHelper.CATEGORIA_GRUPO).append("=").append(this.getCATEGORIA_GRUPO().intValue());
		if (this.getCATEGORIA_FAMILIA().intValue() > 0) pagina.append("&").append(BuscadorHelper.CATEGORIA_FAMILIA).append("=").append(this.getCATEGORIA_FAMILIA().intValue());
		if (this.getCATEGORIA_SUBFAMILIA().intValue() > 0) pagina.append("&").append(BuscadorHelper.CATEGORIA_SUBFAMILIA).append("=").append(this.getCATEGORIA_SUBFAMILIA().intValue());
		return pagina.toString();
	}

	public String getUrlBusquedaXAtributoPrincipal () {
		StringBuffer pagina = new StringBuffer();
		String palabraClave = null;
		String criterio = null;
		Vector vec = null;
		switch (this.getCATEGORIA_SECCION().intValue()) {
			case Globals.SECCION_LIBRO:
			case Globals.SECCION_MUSICA:
			case Globals.SECCION_REVISTAS: {
				vec = this.getAUTORES();
				palabraClave = (vec != null && vec.size() > 0)? (String)vec.firstElement() : null;
				criterio = BuscadorHelper.POR_AUTOR;
				break;
			}

			case Globals.SECCION_PELICULA: {
				vec = this.getDIRECTORES();
				palabraClave = (vec != null && vec.size() > 0)? (String)vec.firstElement() : null;
				criterio = BuscadorHelper.POR_AUTOR;
				break;
			}
			case Globals.SECCION_JUGUETES:     // Continua abajo para no repetir lo mismo
			
			default: {
                return null;
			}

		}

		if (palabraClave != null && criterio != null) {
			pagina.append(BuscadorHelper.PAGINA_BUSCADOR).append("?").append(BuscadorHelper.CATEGORIA_SECCION).append("=").append(this.getCATEGORIA_SECCION()).append("&").append(BuscadorHelper.CLAVE_DE_BUSQUEDA).append("=").append(criterio).append("&").append(BuscadorHelper.TEXTO).append("=").append(palabraClave);
			return pagina.toString();
		} else {
			return null;
		}

	}

    /*url editorial*/
    public String getUrlEditorial(){
        return urlEditorial;
    }
    /*url editorial*/
}
