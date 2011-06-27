package com.tmk.controllers.intranet.ordenes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.intranet.admin.LoginIntranet;
import com.tmk.controllers.intranet.admin.UsuarioDAO;
import com.tmk.controllers.referido.ReferidoManager;
import com.tmk.kernel.Convert;
import com.tmk.kernel.EstadoItemOrdenDAO;
import com.tmk.kernel.EstadoOrdenDAO;
import com.tmk.kernel.Globals;
import com.tmk.kernel.TmkLogger;
import com.tmk.service.orden.OrdenService;
import com.tmk.xml.Resultado;
import com.tmk.xml.orden.OrdenWrapper;

public class ModificarEstadoDeOrden extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=ISO-8859-1");
		request.setCharacterEncoding("UTF8");
		int ordenesConCambios = Convert.toNumber(request.getParameter("ordenesConCambios"), 0);
		Resultado resultado = null;
		PrintWriter out = response.getWriter();
		XStream xstream = new XStream(new JsonHierarchicalStreamDriver()); 
		xstream.alias("Resultado", Resultado.class);
		
		UsuarioDAO usuarioDAO = (UsuarioDAO)request.getSession().getAttribute(LoginIntranet.USUARIO_EXTRANET);
		if (usuarioDAO != null) {
			if (ordenesConCambios > 0) {
				Vector msj = new Vector();
				for (int i=1; i<=ordenesConCambios; i++) {
					int idOrden = Convert.toNumber(request.getParameter("orden" + i), 0);
					String estado = request.getParameter("estado" + i);
					String strMensaje ="";
					if (!estado.equals("P")) {
						// Estado al cual debe pasar
						EstadoOrdenDAO estadoOrdenDAO = null;
		
						// Estado para los items
						EstadoItemOrdenDAO estadoItemOrdenDAO = null;
						
						if (estado.equals("A")) {
							estadoOrdenDAO =  EstadoOrdenDAO.buscaEstadoOrden(Globals.ESTADO_ORDEN_INICIA_LOGISTICA.getId());
							strMensaje = "Se ha APROBADO correctamente la orden " + idOrden + ", nuevo estado: " + Globals.ESTADO_ORDEN_INICIA_LOGISTICA.getDescripcion(); 
						}
						if (estado.equals("R")) {
							estadoOrdenDAO =  EstadoOrdenDAO.buscaEstadoOrden(Globals.ESTADO_ORDEN_RECHAZADA.getId());
							strMensaje = "Se ha RECHAZADO correctamente la orden " + idOrden + ", nuevo estado: " + Globals.ESTADO_ORDEN_RECHAZADA.getDescripcion();
						}
						if (estadoOrdenDAO != null) {
							estadoItemOrdenDAO = estadoOrdenDAO.estadoItemsRelacionado();
							
							
							try {
								OrdenService.cambiarEstadoDeOrden(idOrden, estadoOrdenDAO, estadoItemOrdenDAO, usuarioDAO.getNombres() + ", " + usuarioDAO.getApellidos());
								if (Globals.referidoHabilitado()) {
									if (estadoOrdenDAO.getId().equals(Globals.ESTADO_ORDEN_APROBADA.getId())) {
										Integer id_orden =  new Integer (idOrden);
										ReferidoManager.setCompraReferido(id_orden);
									} else {
										if (estadoOrdenDAO.getId().equals(Globals.ESTADO_ORDEN_RECHAZADA.getId())) {
											Integer id_orden =  new Integer (idOrden);
											ReferidoManager.eliminaOrdenReferido (id_orden);
										}
									}
								}
							} catch (Exception e) {
								strMensaje = "ERROR al modificar el estado de la orden " + idOrden;
								TmkLogger.error("ModificarEstadoDeOrden] idOrden " + idOrden + " " + e.toString() + MainHelper.getMessage(e));
								MainHelper.enviarMailDeError("ModificarEstadoDeOrden] idOrden " + idOrden + " " + e.toString() + MainHelper.getMessage(e));
							}
							
						} else {
							strMensaje = "ERROR no se recibio correctamente el estado de la orden " + idOrden;
							TmkLogger.error("ModificarEstadoDeOrden] idOrden " + idOrden + " estado, no encontrado " + estado);
							MainHelper.enviarMailDeError("ModificarEstadoDeOrden] idOrden " + idOrden + " estado, no encontrado " + estado);
						} 
					} else {
						strMensaje = "No se modifica el estado de la orden " + idOrden;
					}
					msj.add(strMensaje);
				}
				resultado = new Resultado(true, (String[]) msj.toArray(new String[msj.size()]), null);
			} else {
				resultado = new Resultado(true, new String[]{"No existen ordenes a modificar"}, null);
			}
		}else {
			resultado = new Resultado (false, null, null);
			resultado.setTargetRedirect(LoginIntranet.PAGINA_PRINCIPAL);
		}
		out.print(xstream.toXML(resultado).replaceAll("\n", ""));
	}
		
}
