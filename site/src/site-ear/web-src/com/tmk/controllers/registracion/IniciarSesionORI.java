/**
 * $Log: IniciarSesion.java,v $
 * Revision 1.55  2009/04/03 15:14:31  msartori
 * control de modo - Rediseño
 *
 * Revision 1.54  2009/03/25 15:11:26  oClopez
 * mi cuenta testeado.
 *
 * Revision 1.53  2009/03/20 19:02:47  oClopez
 * cambio viernes
 *
 * Revision 1.52  2009/01/15 12:35:47  msartori
 * no message
 *
 * Revision 1.51  2008/05/30 16:06:05  msartori
 * - Medios de Pago Dinero Mail, Pago Facil y Rapi Pago
 * - Comunicacion en back con DM
 * - Pantallas en la intranet para aprobacion de ordenes DM
 * - Manejo de cupones de pago
 * - Socket cliente
 * - Cambio de grafica en pantalla de puntos FDN para clientes gold
 * - Cambio grafico + link exta de la botonera principal de secciones
 *
 * Revision 1.50  2008/04/09 20:20:22  msartori
 * - Registracion Corta
 * - Modificacion de consulta de puntos
 *
 * Revision 1.49  2007/12/18 20:11:53  msartori
 * - Pantalla de medio de cobro
 * - Links en proceso de compra
 * - Reporte de estadistica separado
 * - Cambio en visualizacion de promocion
 * - Esfumado del carrito y cambio de popup
 *
 * Revision 1.48  2007/10/18 20:07:02  msartori
 * - Wpd 467> Interfaz en la intranet para publicar productos en el catalogo
 * - Wpd 466> Vencimiento de productos publicados en la intranet
 * - Wpd 534> Sinopsis completas, se agregaron en el detalle de los articulos los textos correspondientes a contratapa y solapa.
 * - Lanzador de Reportes
 * - Reporte Actualizacion de datos
 * - Reporte compras tmk
 * - Wpd 540> Autores C01
 * - Wpd 549>Reescritura de URL Etapa 1
 *
 * Revision 1.47  2007/01/22 17:43:21  omsartori
 * - Cambios en detalle de articulos y derivadas, se quitaron algunos componentes Ajax para no afectar el crawling de buscadores
 * - Rediseño de lista de deseos
 *
 * Revision 1.46  2006/11/08 15:41:08  omsartori
 * Rediseño: Homes
 *                    Destacado
 *                    Ultimos Visitados
 *                    Arbol Categorias
 *                    Carrito
 *                    Logo y control de modo
 *
 * Revision 1.45  2006/10/12 14:59:11  omsartori
 * no message
 *
 * Revision 1.44  2006/02/28 19:45:53  omsartori
 * - Fin de ReGeneracion de imagen
 * - Fin de comentarios livra
 * - Modificacion de datos para usuarios de migracion, que no pasan a central
 *
 * Revision 1.43  2006/02/09 16:15:36  omsartori
 * - Correccion del bug de alianza/referer.
 * - Correccion de domicilios nuevos que no viajan a central.
 * - id de socio en alianzas eliminado momentaneamente.
 *
 * Revision 1.42  2006/01/13 15:45:52  omsartori
 * -Doc 11 Empro
 *   -Tracking de Sessiones
 *
 * Revision 1.41  2005/11/04 12:55:42  omsartori
 * - Circuito de compra para dos medios de cobro
 * - Campo item en tablas referenciadas por item_orden
 * - Logica de medio de cobro doble en intranet
 * - Logica de medio de cobro doble en reportes
 *

 * - Grabación de hasta 2 formas de pago para la misma orden de compra.
 *
 * Revision 1.39  2005/10/04 19:59:57  omsartori
 * - correccion reporte beneficios referente
 * - Seguimiento empro, visitas por canal
 *
 * Revision 1.38  2005/08/16 16:09:26  omsartori
 * - Cambios estéticos en home
 * - Posibilidad de incluir un file html en el destacado de las home
 * - Yahoo agregado al seguimiento
 * - Se agregaron las palabras de búsqueda al reporte de seguimiento.
 *
 * Revision 1.37  2005/08/03 16:08:59  omsartori
 * - eMPro: Ranking, links a busqueda por atributo principal y por editorial/proveedor
 *                Resultado de busqueda, texto de busqueda explicito
 * - eMPro: Seguimiento google. Reporte de visita, login y registro
 * - Mejoras: Ejb de articulo reducido en ranking, acoplamiento eliminado,
 *                 se reemplazaron los archivos de detalle de cada seccion por uno unico
 *
 * Revision 1.36  2005/06/28 16:37:48  omsartori
 * - Modificacion integral de referidos
 *
 * Revision 1.35  2005/02/23 13:45:35  omsartori
 * - ingreso a referidos desde mi cuenta.
 * - recuperacion del referido si se cae la sesion
 * - reconocimiento del referente
 * - compra del referente
 *
 * Revision 1.34  2004/10/22 15:55:40  oGPistoia
 * - Mejora en eXtra para evitar doble fidelizacion
 * - Doble lista de productos en inicio
 * - Bug de busqueda avanzada que no respetaba el idioma
 *
 * Revision 1.33  2004/09/23 18:45:10  oGPistoia
 * -Se termino la adaptación de la pantallas de eXtra
 *
 * Revision 1.32  2004/09/14 17:22:25  omsartori
 * Bug de imagenes con tam erroneos
 * Bug de direcciones (otra localidad, otra provincia)
 * Bug de inicio de sesion (link a pagina null)
 *
 * Revision 1.31  2004/09/10 15:13:24  oGPistoia
 * - Control en fidelizacion del proceso de generacion de orden
 * - Correccion autores de musica
 * - Pagina de detalle de codigo de seguridad
 * - Encuestas configurables
 *
 * Revision 1.30  2004/09/09 16:46:27  omsartori
 * Arreglado bug de redireccion en inicio de sesión
 * bug de tamaño de imagenes
 * imagen y color de seccion en ultimos visitados
 * ultimos visitados en compras
 *
 * Revision 1.29  2004/08/03 15:48:49  oGPistoia
 * - Reporte de ordenes retrasadas
 * - Reporte de visitas
 * - Remocion de la columna de estado en la orden
 * - Mail de alianza fallida al administrador
 * - Pagina de recomendados de prueba
 * - Texto de promoción y registración configurables
 *
 * Revision 1.28  2004/06/09 18:50:23  oGPistoia
 * - Alta al programa eXtra
 * - Mejoras en reporte de ordenes y paginas varias
 *
 * Revision 1.27  2004/05/04 18:11:09  oGPistoia
 * Fidelizacion: Consulta de puntos, catalogo y consulta en la registracion.
 *
 * Revision 1.26  2004/04/12 20:19:14  oGPistoia
 * - Cambios en la registracion
 * - Mejoras para las alianzas
 *
 * Revision 1.25  2004/04/06 22:22:43  oGPistoia
 * -Cambios en pantalla de registracion
 * -Pagina de CV corregida
 * -Busqueda sugerida
 * -Biografias, capitulos, prensa, etc
 *
 * Revision 1.24  2004/03/25 18:19:54  oGPistoia
 * -Log de registracion
 * -Mejora de busquedas (comillas, puntos)
 * -Mejora de ortografía
 * -Sincronización durante la compra
 * -ReadOnly para datos vitales del socio
 *
 * Revision 1.23  2003/12/22 22:27:59  GPistoia
 * -Listado de pedidos especiales
 * -Mejora en listado de ordenes
 * -Medio de cobro restringido
 * -Memoria maxima alocable.
 *
 * Revision 1.22  2003/10/22 21:28:34  NRodriguez
 * - Borra el socioPK de la sesion a penas se llama el servlet
 *
 * Revision 1.21  2003/10/13 20:25:39  SLizardo
 * no message
 *
 * Revision 1.20  2003/10/13 04:08:55  SLizardo
 * no message
 *
 * Revision 1.19  2003/10/10 17:21:23  NRodriguez
 * - Mensaje de conexion
 *
 * Revision 1.18  2003/10/09 20:48:45  SLizardo
 * Cierre de Incidentes
 *
 * Revision 1.17  2003/10/07 16:19:28  SLizardo
 * E_MAIL_1 para Socios
 *
 * Revision 1.16  2003/10/04 21:54:59  SLizardo
 * Implementacion de DESede
 *
 * Revision 1.15  2003/10/03 16:30:31  GPistoia
 * -Se agrego Flash para el archivo de sitio
 * -Se eliminan las imagenes del sitio y ahora se toman desde afuera
 *
 * Revision 1.14  2003/09/26 16:04:26  NRodriguez
 * - Logueo del error en la registracion
 *
 * Revision 1.13  2003/09/15 21:21:47  NRodriguez
 * - mensaje de error de logueo
 *
 * Revision 1.12  2003/09/08 13:54:46  GPistoia
 * -Pruebas para mejorar el manejo de pais-provincia-localidad
 *
 * Revision 1.11  2003/08/29 17:55:18  GPistoia
 * - Roles-Usuario para la base de datos nueva y configuracion.
 * - Grabacion de Tarjeta Socio para el caso de ordenes con tarjeta ingresada por el cliente.
 * - Problema de carga de Localidad.
 * - Demonio para borrar productos en carrito muy viejos para mantener la base limpia.
 * - Se cargan todas las provincias para que se pueda armar el arbol completo (para Nicolas).
 *
 * Revision 1.10  2003/08/25 20:46:11  SLizardo
 * Optimize Imports
 *
 * Revision 1.9  2003/08/14 14:40:03  SLizardo
 * Se actualizo el Logger (Globals.XXX a TmkLogger.XXX)
 *
 * Revision 1.8  2003/08/13 18:51:53  SLizardo
 * Unificacion del Socio en Session
 *
 * Revision 1.7  2003/08/09 22:16:01  SLizardo
 * no message
 *
 * Revision 1.6  2003/08/08 19:19:33  SLizardo
 * Modificaciones para Integrar Compra
 *
 */
package com.tmk.controllers.registracion;

import com.tmk.orden.OrdenDAO;
import com.tmk.service.orden.OrdenService;
//import com.tmk.setup.Contenido;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.ShortCuts;
import com.tmk.kernel.Convert;
import com.tmk.kernel.TmkLogger;
import com.tmk.kernel.Globals;
import com.tmk.src.fidelizacion.FidelizacionHelper;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import javax.servlet.ServletException;
import javax.servlet.http.*;
//import java.io.BufferedReader;
import java.io.IOException;
//import java.util.ArrayList;

public class IniciarSesionORI extends HttpServlet {
	
	//private static ArrayList listaUsuarios = new ArrayList();
	
    private static int cantidadSesionesAbiertas;
    private static int cantidadSesionesAbiertasGoogle;
	private static int cantidadSesionesAbiertasYahoo;;
	private static int cantidadSesionesRechazadas;
	private static StringBuffer palabrasClave = new StringBuffer();

	public static int getCantidadSesionesAbiertas() {
        return cantidadSesionesAbiertas;
    }

	public static int getCantidadSesionesAbiertasGoogle() {
        return cantidadSesionesAbiertasGoogle;
    }

	public static int getCantidadSesionesAbiertasYahoo() {
        return cantidadSesionesAbiertasYahoo;
    }

    public static int getCantidadSesionesRechazadas() {
        return cantidadSesionesRechazadas;
    }

    public static void nuevaRegistracion() {
        cantidadSesionesAbiertas++;
    }

	public static void nuevaRegistracionGoogle() {
        cantidadSesionesAbiertasGoogle++;
    }

	public static void nuevaRegistracionYahoo() {
        cantidadSesionesAbiertasYahoo++;
    }

	public static String getPalabrasClave() {
		return palabrasClave.toString();
	}

	public IniciarSesionORI() {
		/*try {
			setListaDeUsuarios("listaDeSocios");
		} catch (Exception e) {
			TmkLogger.error("No se pudo cargar la lista de socios");
		}*/
	}
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //si esta el form de busqueda lo elimino
    	request.getSession().removeAttribute("resultadoBusquedaForm");
    	String LOGIN = request.getParameter("LOGIN").trim();
        LOGIN = LOGIN.toUpperCase();
        String PASSWORD = request.getParameter("PASSWORD");
        String _DISPATCHER = null;
    
        HttpSession session = request.getSession();
        session.removeAttribute("Registracion.socioPK");
        session.removeAttribute("Registracion.nombreCompleto");
        session.removeAttribute("Registracion.nombre");
	    session.removeAttribute("Registracion.login");
        session.removeAttribute("PuntajeFidelizacion");
        session.removeAttribute("socioTMK");

        Socios2 socio = ServiceLocator.getSocioService().findSocioByLoginPassword(LOGIN, PASSWORD);
        
	    //este chequeo es por el problema de los socios de la migracion
        if (socio != null && socio.getTipo_doc().equals("PROV")) {
        	SocioPK pk = new SocioPK(socio.getId_sucursal(), socio.getId_socio());
            session.setAttribute("socioMigracion", pk);
            response.sendRedirect("/miCuenta/modificarSocio.jsp");
		    return;
	    }
	    //este chequeo es por el problema de los socios de la migracion

        SocioPK socioPK = null;
	    String nombreCompleto = null;
	    String nombre = null;

        if (socio == null) {
        	SocioTMK socioTMK = null;
			try {
				socioTMK = ServiceLocator.getSociosTMKService().findSocioTmkByLoginPassword(LOGIN, PASSWORD);
				session.setAttribute("socioTMK", new Boolean(true));
	    		socioPK = new SocioPK(socioTMK.getIdSucursal(), socioTMK.getIdSocio());
	    		nombreCompleto = Convert.nombreCompleto(socioTMK.getNombres(), socioTMK.getApellidos());
	    		nombre = Convert.capitalizarOriginal(socioTMK.getNombres(), true).toString();
			} catch (DBOInexistenteException e) {
	            session.setAttribute("Registracion.feedback","LA CLAVE O NOMBRE DE USUARIO ES INCORRECTO.");
	            TmkLogger.debug("Session rechazada. Login '" + LOGIN + "', Password: '" + PASSWORD );
	            cantidadSesionesRechazadas++;
	            _DISPATCHER = "/miCuenta/index.jsp?LOGIN=" + LOGIN;
			} catch (Exception e) {
				session.setAttribute("Registracion.feedback","ERROR INTERNO, POR FAVOR INTENETA EN UN MOMENTO.");
			}		
        } else {
        	session.setAttribute("socioTMK", new Boolean(false));
        	socioPK = new SocioPK(socio.getId_sucursal(), socio.getId_socio());
        	nombreCompleto = Convert.nombreCompleto(socio.getNombres(), socio.getApellidos());
        	nombre = Convert.capitalizarOriginal(socio.getNombres(), true).toString();
        }
    	if (socioPK != null) {
            session.removeAttribute("Registracion.feedback");
            TmkLogger.debug("Session aprobada. Login '" + LOGIN + "'");
            ShortCuts.findListaBySocio(socioPK);
            session.setAttribute("Registracion.socioPK", socioPK);
            session.setAttribute("Registracion.nombreCompleto", nombreCompleto);
            session.setAttribute("Registracion.nombre", nombre);
	        session.setAttribute("Registracion.login", LOGIN);
	       
            // Agrega el socio a la orden
            OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
            if (ordenDAO == null) {
                ordenDAO = new OrdenDAO();
                session.setAttribute("ordenDAO", ordenDAO);
            }
            // sincroniza el carrito persistente
            boolean teniaArticlosEnCarrito = OrdenService.cargarCarritoCompra(ordenDAO, socioPK);

            //CHEQUEO SUSCRIPCION QUID NO, si el socio tenia un carrito anterior con la suscripcion cargada
            //COMENTADO POR QUE NO ESTA ACTIVA LA FUNCIONALIDAD DE QUID
            //la elimino no puede estar con otra orden
            /*if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0)) && ordenDAO.getArticulos().size() > 1){
            	int pos = 0;
            	for(int i=0;i<ordenDAO.getArticulos().size();i++){
            		if(((ArticuloDAO)ordenDAO.getArticulos().get(i)).getId() == CarritoUtil.getAriculosExcluidos().get(0).intValue()){
            			pos = i;
            			break;
            		}
            	}
            	ordenDAO.getArticulos().remove(pos);
            }*/
            
            //FIN chequeo
	        if (((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_GOOGLE))!= null && ((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_GOOGLE)).booleanValue()) {
                cantidadSesionesAbiertasGoogle++;
		        palabrasClave.append(session.getAttribute(EstadisticaVisitas.PALABRAS_CLAVE)).append("<br>");
	        }
	        if (((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_YAHOO))!= null && ((Boolean)session.getAttribute(EstadisticaVisitas.REFERER_YAHOO)).booleanValue()) {
                cantidadSesionesAbiertasYahoo++;
		        palabrasClave.append(session.getAttribute(EstadisticaVisitas.PALABRAS_CLAVE)).append("<br>");
	        }
            cantidadSesionesAbiertas++;
	        // Ahora que esta registrado carga los puntos
            if (socio  != null) {
            	FidelizacionHelper.cargarPuntajeEnSession(session, socio);
            }

            String URL_REDIRECT = (String) session.getAttribute("URL_REDIRECT");
            String redirect = (String) session.getAttribute(MainHelper.URL_REDIRECT);
            
            if (URL_REDIRECT != null || redirect != null) {
            	if (URL_REDIRECT != null) {
            		_DISPATCHER = URL_REDIRECT;
            		session.removeAttribute("URL_REDIRECT");
            	} else {
            		//chequeo, si tenia articulos en el carrito, quiso pasar al papel de regalos, hago que vuelva al carrito.(antes iba modificarSocios.jsp)
            		if(redirect.endsWith(".do") && teniaArticlosEnCarrito){
            			_DISPATCHER = ProcesoCompraUtil.CARRITO_COMPRAS;
            			session.removeAttribute(MainHelper.URL_REDIRECT);
            		}else{
            			_DISPATCHER = redirect;
            		}
            	}
            } else {
            	_DISPATCHER = "/miCuenta/modificarSocio.jsp?param="+Math.random();
            }         
        }

	    if (Globals.referidoHabilitado()) {
		    ReferidoManager.recuperarReferido (request);
	    }
        response.sendRedirect(_DISPATCHER);
    }
    
    /**
     * Se uso este metodo cuando solicitarion cargar en una lista usuarios que pudieran ver el 
     * proceso de compras rediseñado.
     */
    /*public static void setListaDeUsuarios(String pathFile) throws Exception {
    	
    	String path = Contenido.getServletContext().getRealPath(MainHelper.RES_TMPL_PATH
				+ "/templates/"+pathFile+".htm");
		BufferedReader br = new BufferedReader(new java.io.FileReader(path));
		String line = null;
		while((line=br.readLine()) != null) {
			listaUsuarios.add(line.toUpperCase());			
		}
		br.close();
    }*/
    
}
