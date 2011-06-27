/**
 * $Log: MedioDeCobroDAO.java,v $
 * Revision 1.35  2008/05/30 16:03:15  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.34  2006/09/28 14:57:33  omsartori
 * - Condigo javascript para Google Analytics en todos los jsps publicos
 * - Proceso de Generacion de SiteMap para Google
 * - Correccion de promo II> no se grababan las campañas aplicadas
 *
 * Revision 1.33  2006/06/22 18:26:36  omsartori
 * - Validacion de pines de tarjetas
 * - Nuevo motor de recomendaciones a aplicado a las recomendaciones de compra
 *
 * Revision 1.32  2006/03/06 15:38:06  omsartori
 * - Medios de cobro VMA y MNA
 * - Indice de contenidos
 * - URL configurable para generacion
 *
 * Revision 1.31  2005/12/29 17:45:11  omsartori
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
 * Revision 1.30  2005/12/13 16:16:37  omsartori
 * - Tarjeta prepaga (sin grabacion de compra)
 * - Correcciones empro
 * - Planes de pago en el detalle del articulo
 * - Tablas de planes de pago
 * - documento 10 de empro (parte 1)
 *
 * Revision 1.29  2005/11/04 12:55:36  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *
 *
 * Revision 1.27  2005/08/03 16:08:31  omsartori
 * - eMPro: Ranking, links a busqueda por atributo principal y por editorial/proveedor
 *                Resultado de busqueda, texto de busqueda explicito
 * - eMPro: Seguimiento google. Reporte de visita, login y registro
 * - Mejoras: Ejb de articulo reducido en ranking, acoplamiento eliminado,
 *                 se reemplazaron los archivos de detalle de cada seccion por uno unico
 *
 * Revision 1.26  2005/05/17 14:38:38  omsartori
 * - Posicionamiento tags en pags desde el home, tags por producto, nueva pagina de biografia
 * - Referido, interface de carga modificada a tres referidos independientes, guarda nombre ap y mail
 *
 * Revision 1.25  2005/03/30 12:52:05  omsartori
 * - Clientes institucionales: nuevo formato para mail de resguardo, controlador evita mails vacios, cantidad de caracteres restringida en campo comentario
 * - Medio de cobro Rio Net Banking: Agregado en compra y en listado de la intranet.
 * - Cupones: anulacion de espacios en blanco y cambio de leyenda.
 * - Revitalizer: el cambio de modo a mantenimiento se efectua luego del anteultimo intento.
 *
 * Revision 1.24  2005/03/24 15:25:04  omsartori
 * - Bug campo de gastos no grabado corregido
 * - Medio de cobro Rio Net Banking
 *
 * Revision 1.23  2005/01/25 15:52:17  oGPistoia
 * - Nuevo parametro en el buscador de novedades para ignorar N primeros dias
 * - Movi las funciones de busquedas de DAOs a los objetos pertinentes
 * - Renombre los buscadores eliminando la palabra DAO
 *
 * Revision 1.22  2004/12/13 13:57:10  oGPistoia
 * - Pago a través de Home Banking
 *
 * Revision 1.21  2004/06/15 20:56:16  oGPistoia
 * - Se elimino fidelizacion para poder hacer un release (en realidad configurable)
 * - Se puede configurar los textos de los titulos a cambiar
 * - Se termino de agregar titulo y autores en tags para Google
 * - Mejoras en el generador de imagenes
 * - Mejoras en las estadisticas
 *
 * Revision 1.20  2004/06/09 18:49:47  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.19  2004/05/04 18:09:34  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.18  2003/12/04 17:19:14  GPistoia
 * -Control del server automatico
 * -Cardinalidad en el archivo de contenido
 * -Estadisticas de hits por paginas
 * -Cache de mas vendidos
 * -Mensajes para errores de GPAY
 * -Paginas estaticas que ahora son dinamicas
 *
 * Revision 1.17  2003/11/07 15:32:59  GPistoia
 * -Nuevos driver especificos de Oracle
 * -Correccion de modificacion de Santiago que estaba a medias
 * -Eliminacion de EJBs para mejorar performance
 *
 * Revision 1.16  2003/10/07 14:52:18  GPistoia
 * -Implementacion de IdProducto en Recorrido por Temas
 * -Cambios para imagenes y tapas
 * -Demonios para base de datos
 * -Medios de cobro opcionales
 *
 * Revision 1.15  2003/10/03 16:29:05  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.14  2003/09/25 19:17:13  GPistoia
 * -Soporte Orden migrada
 * -Metodos en Articulo (sinopsis y directores)
 * -Funciones de presentacion
 *
 * Revision 1.13  2003/09/17 19:32:08  GPistoia
 * -Aplicacion de cupones desde pagina hasta orden
 * -Fecha en orden con hora incluida
 * -Campo dominio en orden
 *
 * Revision 1.12  2003/09/16 18:58:44  NRodriguez
 * - se agrego el metodo toJavaScript para todos los daemons
 *
 * Revision 1.11  2003/09/05 19:56:28  GPistoia
 * -Nuevos parametros
 * -Division de GPay para pago con fax
 * -Configuracion modificada de archivos del server
 *
 * Revision 1.10  2003/09/02 19:08:29  GPistoia
 * -Promociones funcionando (fue un lock en tabla)
 * -Muestra articulo promocionado
 *
 * Revision 1.9  2003/08/29 17:54:23  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.8  2003/08/27 18:43:52  GPistoia
 * -Comienzo Fraude
 *
 * Revision 1.7  2003/08/12 22:06:05  GPistoia
 * -Se borraron las paginas viejas
 * -Se agregaron las paginas nuevas
 * -Se actualizo el proyecto y elimino el disco V
 *
 * Revision 1.6  2003/08/12 16:25:28  GPistoia
 * -Cierre de proceso de compra pre-produccion
 *
 * Revision 1.5  2003/08/06 21:28:22  GPistoia
 * -Termine una version de orden con Alianzas y totales.
 * -Elimine Gasto de Envio como EJB por no tener PK. Usar DBUtil.
 * -Mejoras en GPay
 * -Borre las clases y xml viejos que no se usan mas salvo con algo pendiente
 *
 * Revision 1.4  2003/08/04 22:17:52  GPistoia
 * -Primera version funcional de compra
 *
 * Revision 1.3  2003/08/02 16:58:12  GPistoia
 * -Nuevos campos en la configuracion
 * -Actualizacion de EJB con flags de habilitados
 * -Rutinas de GPay
 * -Promocion
 *
 * Revision 1.2  2003/07/30 15:18:02  GPistoia
 * -Clase para pago via GPay, multiusuario y reconfigurable dinamicamente.
 * -Cerrando proceso de compra
 * -Modificaciones en el archivo de configuracion.
 *
 * Revision 1.1  2003/07/26 19:06:08  GPistoia
 * -OrdenDAO, GastoDeEnvioDAO, MedioDeCobroDAO,
 * ArticuloDAO, PaisDAO, ProvinciaDAO e IdiomaDAO terminados
 *
 */
package com.tmk.kernel;



import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class MedioDeCobroDAO implements Serializable {

	private String id;
	private String nombre;
	private String tipo;
	private boolean habilitado;
	

	public MedioDeCobroDAO(String id, String nombre, String tipo, boolean habilitado) {
		super();
		this.id = id;
		this.nombre = Convert.toJavaScript(nombre, true);
		this.tipo = tipo;
		this.habilitado = habilitado;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public boolean estaHabilitado() {
		return habilitado;
	}

	public boolean consultarEnFidelizacion() {
		return (Convert.toString(Globals.FDN_FORMULARIO_TARJETAS).indexOf(id) >= 0);

	}

	public boolean equals(Object other) {
		return (super.equals(other)) ||
		        ((other instanceof MedioDeCobroDAO) &&
		        (id.equalsIgnoreCase(((MedioDeCobroDAO) other).id)));
	}

	public String toString() {
		return "Medio de Cobro (" + id + ", " + tipo + ") " + nombre;
	}

	public static MedioDeCobroDAO buscaMedioDeCobro(String clave) {
		for (int i = 0; i < Globals.MEDIOS_DE_COBRO.length; i++) {
			if (Globals.MEDIOS_DE_COBRO[i].getId().equalsIgnoreCase(clave)) {
				return Globals.MEDIOS_DE_COBRO[i];
			}
		}
		return Globals.MEDIO_DE_COBRO_DESCONOCIDO;
	}

	public boolean esTarjeta() {
		return Globals.TIPO_MEDIO_DE_COBRO_TARJETAS.equalsIgnoreCase(tipo);
	}


	public boolean esReembolso() {
		return Globals.CLAVE_MEDIO_DE_COBRO_CONTRAREEMBOLSO.equalsIgnoreCase(id);
	}

	public boolean esFax() {
		return Globals.CLAVE_MEDIO_DE_COBRO_FAX.equalsIgnoreCase(id);
	}

	public boolean esHomeBanking() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RIOHB.equalsIgnoreCase(id);
	}

	public boolean esNetBanking() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RIONB.equalsIgnoreCase(id);
	}

	
	public boolean esTarjetaPrePaga() {
		return Globals.CLAVE_MEDIO_DE_COBRO_TARJETA_PREPAGA.equalsIgnoreCase(id);
	}
	public boolean esValidableOnLine() {
		return esTarjeta() || esTarjetaPrePaga();
	}
	
	
	public boolean esRapiPago() {
		return Globals.CLAVE_MEDIO_DE_COBRO_RAPI_PAGO.equalsIgnoreCase(id);
	}

	public boolean esPagoFacil() {
		return Globals.CLAVE_MEDIO_DE_COBRO_PAGO_FACIL.equalsIgnoreCase(id);
	}
	
	public boolean esDineroMail() {
		return Globals.CLAVE_MEDIO_DE_COBRO_DINERO_MAIL.equalsIgnoreCase(id);
	}
	
	public boolean esArcash() {
		return Globals.CLAVE_MEDIO_DE_COBRO_ARCASH.equalsIgnoreCase(id);
	}
	
	public boolean requiereCuponDePago() {
		return esRapiPago() || esPagoFacil();
	}
	
	static {
		new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.UNA_HORA) {
		//new Daemon(Daemon.DIEZ_SEGUNDOS, Daemon.DOS_HORAS) {
			protected void ejecutarTarea() throws Exception {
					
				final Vector mediosDeCobro = new Vector();
				final Vector mediosDeCobroOrdenados = new Vector();
				//21/09/2006 Por ahora el codigo de ordenamiento sobra ya que se unificaron los medios de cobro.
				//Si todo funciona ok y no se vuelve a este sistema de medios se elimina el codigo de ordenamiento
				final String ordenDeMedios [] = {"VIS", "VRIO", "VNA", "AME", "ARIO", "MAS", "MNA", "DIN"};
				
				
				DBUtil.getIdDescripcion(
				        //"SELECT ID_MEDIO_COBRO, DESCRIPCION, TIPO, HABILITADO_TEMATIKA FROM MEDIOS_DE_COBROS ORDER BY TIPO DESC, DESCRIPCION DESC",
				        "SELECT ID_MEDIO_COBRO, DESCRIPCION, TIPO, HABILITADO_TEMATIKA FROM MEDIOS_DE_COBROS WHERE HABILITADO_TEMATIKA = 'S' ORDER BY TIPO DESC, F_ALTA",
				        new DBUtil.ResultSetObserver() {
					        public void onRow(ResultSet resultSet) throws SQLException {
						        mediosDeCobro.add(
						                new MedioDeCobroDAO(
						                        resultSet.getString("ID_MEDIO_COBRO"),
						                        resultSet.getString("DESCRIPCION"),
						                        resultSet.getString("TIPO"),
						                        "S".equalsIgnoreCase(resultSet.getString("HABILITADO_TEMATIKA"))));
					        }
				        });
				
				//tomo los medios de cobro en el orden indicado
				for (int i=0; i<ordenDeMedios.length; i++) {
					for (int j=0; j<mediosDeCobro.size(); j++) {
						if (ordenDeMedios[i].equals(((MedioDeCobroDAO)mediosDeCobro.get(j)).getId())) {
							mediosDeCobroOrdenados.add(mediosDeCobro.get(j));
							mediosDeCobro.remove(j);
						}
					}
				}
				
				//Agrego los medios de cobro que no requieren ordenamiento
				for (int i=0; i<mediosDeCobro.size(); i++) {
					mediosDeCobroOrdenados.add(mediosDeCobro.get(i));
				}
				//Globals.MEDIOS_DE_COBRO = (MedioDeCobroDAO[]) mediosDeCobro.toArray(new MedioDeCobroDAO[mediosDeCobro.size()]);
				Globals.MEDIOS_DE_COBRO = (MedioDeCobroDAO[]) mediosDeCobroOrdenados.toArray(new MedioDeCobroDAO[mediosDeCobroOrdenados.size()]);
				
			}

			protected String getMensaje() {
				return Globals.MEDIOS_DE_COBRO.length + " medios de cobro.";
			}

			protected boolean pausada() {
				return Globals.baseDeDatosEnMantenimiento();
			}
		};
	}

}
