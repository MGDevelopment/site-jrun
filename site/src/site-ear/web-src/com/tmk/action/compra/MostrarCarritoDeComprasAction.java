	package com.tmk.action.compra;

import java.util.Hashtable;
import java.util.Map;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.tmk.bus.articulo.Articulo;
import com.tmk.bus.socio.SocioTMK;
import com.tmk.bus.socio.Socios2;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.orden.OrdenDAO;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.soa.servicios.interfaces.TemplateService;
import com.tmk.src.socio.SocioPK;
import com.tmk.util.HTML.Template;

public class MostrarCarritoDeComprasAction extends Action {

	
	/**
	 * Esta variable indica cual es el procio desde el cual es envio es gratis.
	 */
	private static double precioPromocion = 150;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//obtengo/creo el carrito
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		//si no hay orden la crea vacia
		if (ordenDAO == null) {
			ordenDAO = new OrdenDAO();
		}
					
		Template tmpArticulos = (Template)ServiceLocator.getTemplateService().getTemplate(TemplateService.TMP_CARRITO_COMPRAS);
		
		//hago toda la logica solo si hay articulos
		if(ordenDAO.getArticulos().size() > 0){
			//hash y vector para llenar la template
			Hashtable<String, Object>hasArticulos = null;
			Vector<Hashtable<String, Object>> vecArticulos = new Vector<Hashtable<String,Object>>();
			//esto setea la jsp, no se aun para que es
			request.getSession().setAttribute(CompraHelper.FLAG_ES_CARRITO, "true");
			//loopeo sobre los articulos para setear la template
			ArticuloService servicio = ServiceLocator.getArticuloService();
			boolean esSuscripcionQuid = false;
			for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
				ArticuloDAO articulo = ordenDAO.getArticulo(i);
				Articulo articuloBo = servicio.getArticuloParaCarrito(articulo.getId());
				hasArticulos  = new Hashtable<String, Object>();
				hasArticulos.put("idArticulo", articuloBo.getId_articulo().toString());
				hasArticulos.put("titulo", Convert.corregir(articuloBo.getTitulo(), true));
				hasArticulos.put("precioUnitario",Contenido.precioToString(articuloBo.getPrecio()));
				hasArticulos.put("cantidad", "" + articulo.getCantidad());
				hasArticulos.put("precioSubtotal", Contenido.precioToString(articulo.getCantidad() * articuloBo.getPrecio()));
				hasArticulos.put("urlImagen", articuloBo.getImagen());
				//hasArticulos.put("urlDetalle", articuloBo.getUrlDetalle());
				if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
					//no seteo url detalle por que explota, no se setea por suscripcion quid
					hasArticulos.put("urlDetalle", "#");
					esSuscripcionQuid = true;
				}else{
					hasArticulos.put("urlDetalle", articuloBo.getUrlDetalle());					//
				}
				articuloBo.setUrlBusquedaAutor();
				//seteo los autores, con sus link de busqueda si es que tiene autor, si no nada
				boolean tieneAutor = articuloBo.getAutor() != null;
				if(tieneAutor){
					hasArticulos.put("autores", ServiceLocator.getDetalleArticuloService().getAutores(articuloBo));
					hasArticulos.put("textoAutor", "de");
				}else{
					hasArticulos.put("textoAutor", "&nbsp;");
				}
				//link eliminar articulo
				hasArticulos.put("lnkEliminarArticulo", "/EliminarProducto");
				hasArticulos.put("posicionEnLista", articulo.getPosicionEnLista());
				//indice necesario para las listas
				hasArticulos.put("indice",i);
				vecArticulos.add(hasArticulos);
			}
			tmpArticulos.setParam("articulos", vecArticulos);
			tmpArticulos.setParam("total", Contenido.precioToString(ordenDAO.totalProductos()));
			tmpArticulos.setParam("precioFinalDolar", Contenido.precioDollarToString(ordenDAO.totalProductos()));//.replaceAll(" $&nbsp;", "").replaceAll(".-", ""));
			tmpArticulos.setParam("precioFinalEuro", Contenido.precioEuroToString(ordenDAO.totalProductos()));//.replaceAll(" $&nbsp;", "").replaceAll(".-", ""));
			if(ordenDAO.totalProductos() < precioPromocion && !esSuscripcionQuid) {
				tmpArticulos.setParam("faltanParaPromocion", "true");
			}else {
				tmpArticulos.setParam("faltanParaPromocion", "");
			}
			tmpArticulos.setParam("valorDePromocion",""+Contenido.precioToString(precioPromocion));
			//obtengo la pk del socio para buscarlo con el dao
			SocioPK socioPK = (SocioPK)request.getSession().getAttribute("Registracion.socioPK");
			if(socioPK != null) {
				Socios2 socio = ServiceLocator.getSocioService().findByPK(socioPK);
				if(socio == null) {
					SocioTMK socioTmk = null;
					try {
						socioTmk = ServiceLocator.getSociosTMKService().findSocioTMKByPK(socioPK);
					} catch (Exception e) {
						e.printStackTrace();
					}
					if(socioTmk != null) {
						tmpArticulos.setParam("usuario", socioTmk.getNombres() + " " + socioTmk.getApellidos());
						tmpArticulos.setParam("socioLogueado","true");
					}else {
						tmpArticulos.setParam("socioLogueado","");		
					}
				}else {
					tmpArticulos.setParam("usuario", socio.getNombres() +" " + socio.getApellidos());
					tmpArticulos.setParam("socioLogueado","true");
				}				
			}else {
				tmpArticulos.setParam("socioLogueado","");
			}
			//obtengo las pantallas anterior y siguiente en base a la que estoy parado
			Map<String, String> direcciones = null;
			direcciones = ProcesoCompraUtilImp.getInstance().getDirecciones(ProcesoCompraUtil.CARRITO_COMPRAS);	
			tmpArticulos.setParam("pantallaAnterior", direcciones.get("anterior"));
			tmpArticulos.setParam("pantallaSiguiente", direcciones.get("siguiente"));
		}		
		tmpArticulos.setParam("hayArticulos", (ordenDAO.getArticulos().size()>0) ? "true" : "");
		request.setAttribute("template", tmpArticulos.output());		
		//return null;
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		return mapping.findForward("frwCarrito");
	}
	
	public static void setBaseParaDescuneto(String clave, double nuevoValor){
		if(clave.equals("tematikatematikatematika")){
			precioPromocion = nuevoValor;
		}
	}
}
