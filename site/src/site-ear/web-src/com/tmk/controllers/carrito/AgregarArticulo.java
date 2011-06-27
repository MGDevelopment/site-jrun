package com.tmk.controllers.carrito;

import java.io.IOException;
import java.io.PrintWriter;
//import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.articulo.CarritoListaDeseos;
//import com.tmk.bus.articulo.Disponibilidad;
import com.tmk.bus.articulo.ListaDeseos;
//import com.tmk.bus.articulo.Tasa;
import com.tmk.controllers.alianza.EstadisticaVisitas;
import com.tmk.dbo.DBO;
//import com.tmk.dbo.sql.CamposABuscarDBO;
//import com.tmk.dbo.sql.CamposLeftJoinDBO;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
//import com.tmk.kernel.DBUtil;
import com.tmk.kernel.DomicilioDAO;
import com.tmk.kernel.Globals;
import com.tmk.kernel.MailUtil;
import com.tmk.kernel.TmkLogger;
import com.tmk.src.listadeseos.CarritoListaDeseosPK;
import com.tmk.src.listadeseos.ListaDeseosPK;
import com.tmk.orden.OrdenDAO;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.interfaces.CarritoListaDeseosService;
import com.tmk.src.socio.SocioPK;
import com.tmk.xml.converter.CapitalizarDescripcionConverter;

public class AgregarArticulo extends HttpServlet {

	private static int cantidadArticulosAgregados;

	public AgregarArticulo() {	}
	
	public static int getCantidadArticulosAgregados() {
		return cantidadArticulosAgregados;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		// Mantiene datos de alianzas y demás
		EstadisticaVisitas.mantenerEstadistica(request, response);
        String idArticulo = request.getParameter("idArticulo");
        PrintWriter out = response.getWriter();

		if (idArticulo != null) {
			StringBuffer JSONCarrito = null;
			Articulo art = new Articulo(new Integer(idArticulo));
			try {
				ArticuloDAO articuloDAO =  new ArticuloDAO(Integer.parseInt(idArticulo));
				SocioPK socioPK = (SocioPK) session.getAttribute("Registracion.socioPK");
				OrdenDAO ordenDAO = (OrdenDAO) session.getAttribute("ordenDAO");
				if (ordenDAO == null) {
					ordenDAO = new OrdenDAO();
					session.setAttribute("ordenDAO", ordenDAO);
				}
				//borro promos
				ordenDAO.eliminarPromos();
				//borro gastos de envio
				ordenDAO.eliminarGastosDeEnvio();
				if (request.getParameter("ID_SUCURSAL") != null && request.getParameter("ID_SOCIO") != null) {
					Integer ID_SUCURSAL_SOCIO = Convert.toNumber(request.getParameter("ID_SUCURSAL"), (Integer)null);
					Integer ID_SOCIO = Convert.toNumber(request.getParameter("ID_SOCIO"), (Integer)null);
					articuloDAO.setSocioListaDD(new com.tmk.socio.SocioPK(ID_SUCURSAL_SOCIO, ID_SOCIO));

					//ListaDeseosLocalHome listaHome = (ListaDeseosLocalHome) DBUtil.getHome("ListaDeseos");
					//ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
					//ListaDeseosLocal lista = listaHome.findByPrimaryKey(listaPK);

					ListaDeseosPK listaPK = new ListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO);
					ListaDeseos listaDBO = ServiceLocator.getListaDeDeseosService().findByPrimaryKey(listaPK);
					
					//bloque agregado
					CarritoListaDeseosPK carritoPK = new CarritoListaDeseosPK(ID_SUCURSAL_SOCIO, ID_SOCIO, new Integer (idArticulo));
					CarritoListaDeseosService servicio = ServiceLocator.getCarritoListaDeseosService();

					CarritoListaDeseos carritoDBO = new CarritoListaDeseos(carritoPK);
					carritoDBO.setEstado(1);
					servicio.update(carritoDBO);
					carritoDBO = null;
					//fin

					if (listaDBO.getTipo_domicilio() != null) {
						articuloDAO.setSocioListaDD(new com.tmk.socio.SocioPK(ID_SUCURSAL_SOCIO, ID_SOCIO));
						DomicilioDAO domicilioLDD = DomicilioDAO.load(ID_SUCURSAL_SOCIO, ID_SOCIO, listaDBO.getTipo_domicilio());
						if (domicilioLDD.esEnvio()) {
							ordenDAO.setDomicilioListaDeDeseos(domicilioLDD);
						} else {
						// no se puede mandar a una direccion que no sea de envio
							String message = "La dirección cargada en la lista no es domicilio de envio, suc: " + ID_SUCURSAL_SOCIO + " socio: " + ID_SOCIO;
							TmkLogger.error(message);
							MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, "Fallo en Lista de Deseos", message);
						}
				   	} else {
						// No tiene tipo_domicilio (hay muchos asi en la base)
						String message = "El producto de la lista no tiene tipo_domicilio, suc: " + ID_SUCURSAL_SOCIO + " socio: " + ID_SOCIO;
						TmkLogger.error(message);
						MailUtil.sendMail(Globals.MAIL_MAILER, Globals.MAIL_ADMINISTRADOR, "Fallo en Lista de Deseos", message);
					}
				}
				//Chequeo de disponibilidad
				art = ServiceLocator.getArticuloService().getArticuloParaChequearDisponibilidad(Integer.parseInt(idArticulo));
				art.setClsPrecio();
				art.setImagen();
				
				if (!art.estaHabilitado()) {
					art.setError(true, "El articulo no esta habilitado.");
				//VALIDACION SUSCRION QUID, si es id de la suscripcion				
				}else if(CarritoUtil.estaEnlaOrden(ordenDAO,CarritoUtil.getAriculosExcluidos().get(0))){
					art.setError(true, "El pedido de suscripci&oacute;n debe realizarse en forma separada a la compra de otros productos.");
				}else if(CarritoUtil.getAriculosExcluidos().contains(new Integer(idArticulo))){
					if(CarritoUtil.puedeAgregarSuscripcion(ordenDAO,idArticulo,CarritoUtil.getAriculosExcluidos())) {
						cantidadArticulosAgregados++;
						ordenDAO.addArticulo(articuloDAO, new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO));
						JSONCarrito = new StringBuffer("");
						JSONCarrito.append(", \"Carrito\": {\"cantidad\":").append(ordenDAO.getCantidadArticulosEnTotal());
						JSONCarrito.append(", \"total\":").append(ordenDAO.totalSitioCompleto()).append("}}");
						art.setError(false, null);
					}
					//si la orden ya tiene algun articulo, y quiero agregar la suscripcion, error
					else{
						art.setError(true, "El pedido de suscripci&oacute;n debe realizarse en forma separada a la compra de otros productos.");					
					}										
				//FIN SUSCRIPCION				
				}else if (!art.getDisponibilidad().tieneStock()) {
					art.setError(true, "El articulo no tiene stock.");
				} else {
					// mantiene el contador
					cantidadArticulosAgregados++;
					ordenDAO.addArticulo(articuloDAO, (socioPK!=null)?new com.tmk.socio.SocioPK(socioPK.ID_SUCURSAL,socioPK.ID_SOCIO):new com.tmk.socio.SocioPK());
					JSONCarrito = new StringBuffer("");
					JSONCarrito.append(", \"Carrito\": {\"cantidad\":").append(ordenDAO.getCantidadArticulosEnTotal());
					JSONCarrito.append(", \"total\":").append(ordenDAO.totalSitioCompleto()).append("}}");
					art.setError(false, null);
				}
			} catch (Exception fe) {
				art.setError(true, "No se pudo agregar el producto al carrito.");
			}
			XStream xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.registerLocalConverter(Articulo.class, "titulo", new CapitalizarDescripcionConverter());
			xstream.alias("Articulo", Articulo.class);
			xstream.omitField(DBO.class, "seteado");

			/*Pattern pt= Pattern.compile("(\\{)(\\\"[^\\\"]+\\\")([^:}]*)(\\})");
			Matcher mt= pt.matcher(xstream.toXML(art));
			String correctJsonStr= mt.replaceAll("$2");
			correctJsonStr = correctJsonStr.replaceAll("\n", "").replaceAll("\r", "");*/
			String correctJsonStr =Convert.toFixedJSON(xstream.toXML(art));
			if (JSONCarrito != null) {
				///
				correctJsonStr = correctJsonStr.substring(0, correctJsonStr.length()-1);
				correctJsonStr = correctJsonStr + JSONCarrito.toString();
			}
			out.print(correctJsonStr);
		}

	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet (request, response);
	}
	
}



/*CamposABuscarDBO camposABuscar = new CamposABuscarDBO();
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".id_articulo");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".titulo");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".tasa");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".precio_venta_vigente");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".fecha_alta");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".disponibilidad");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".habilitado_tematika");
camposABuscar.agregarCampoABusqueda(Articulo.getAlias() + ".categoria_seccion");


camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_general");
camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_adicional");
camposABuscar.agregarCampoABusqueda(Tasa.getAlias() + ".tasa_percep_video");
camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_disponibilidad");
camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".id_esquema");
camposABuscar.agregarCampoABusqueda(Disponibilidad.getAlias() + ".pedido_especial");

CamposLeftJoinDBO camposLeftJoinDBO = new CamposLeftJoinDBO();
camposLeftJoinDBO.setCampoDBOLeftJoin(Articulo.getAlias() + ".tasa");
Connection conn = DBUtil.buildConnection();
try {
	DBO.select(art, conn, camposABuscar, camposLeftJoinDBO);
	art.setClsPrecio();
	art.setImagen();

} finally {
	conn.close();
}*/
