package com.tmk.action.compra;

import java.util.Date;
import java.util.HashMap;
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
import com.tmk.controllers.MainHelper;
import com.tmk.controllers.carrito.CarritoUtil;
import com.tmk.controllers.compra.CompraHelper;
import com.tmk.kernel.ArticuloDAO;
import com.tmk.kernel.Convert;
import com.tmk.kernel.Globals;
import com.tmk.kernel.site.PapelesDeRegalo;
import com.tmk.kernel.site.Producto;
import com.tmk.orden.OrdenDAO;
import com.tmk.setup.Contenido;
import com.tmk.soa.servicios.ServiceLocator;
import com.tmk.soa.servicios.implementation.ProcesoCompraUtilImp;
import com.tmk.soa.servicios.interfaces.ArticuloService;
import com.tmk.soa.servicios.interfaces.ProcesoCompraUtil;
import com.tmk.util.HTML.Template;

public class SeleccionarPapelDeRegaloAction extends Action {

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String frwRedirect = ProcesoCompraUtilImp.getInstance().frwRedireccion(request, response,ProcesoCompraUtil.PAPEL_REGALO);
		if(frwRedirect != null ) {
			//indico que cuando se logue vaya directamente al papel de regalo, pero si cuando se logua tiene articulos en el carrito, se cambia la redireccion 
			//para que vea nuevamene el carrito.
			request.getSession().setAttribute(MainHelper.URL_REDIRECT, ProcesoCompraUtil.PAPEL_REGALO);
			return mapping.findForward(frwRedirect);
		}
		frwRedirect = "frwPapelDeRegalo";
		
		OrdenDAO ordenDAO = (OrdenDAO)request.getSession().getAttribute("ordenDAO");
		//inicio el reloj de conteo para los reportes, con la fecha y el mail de socio.
		if(request.getSession().getAttribute("mapaDeDatos") == null) {
			HashMap<String, Object> mapa = new HashMap<String, Object>();
			mapa.put("socioPK", request.getSession().getAttribute("Registracion.socioPK"));
			mapa.put("login", request.getSession().getAttribute("Registracion.login"));
			mapa.put("fechaInicio", new Date(System.currentTimeMillis()));
			mapa.put("fecha", new Date(System.currentTimeMillis()));
			request.getSession().setAttribute("mapaDeDatos", mapa);
		}
		//fin
		
		CompraHelper.visitasDePaginaPapeles++;			
		boolean esSuscripcionQuid = false;
		
		Template tmpArticulos = (Template)ServiceLocator.getTemplateService().getTemplate("tmpPapelDeRegalo");
				
		//hash y vector para llenar la template
		Hashtable<String, Object>hasArticulos = null;
		Vector<Hashtable<String, Object>> vecArticulos = new Vector<Hashtable<String,Object>>();
		//recorro los articulos
		ArticuloService servicio = ServiceLocator.getArticuloService();
		for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
			boolean hayPapelChequeado = false;
            ArticuloDAO articulo = ordenDAO.getArticulo(i);
            //cargo los datos
			Articulo articuloBo = servicio.getArticuloParaCarrito(articulo.getId());
			hasArticulos  = new Hashtable<String, Object>();				
			hasArticulos.put("idArticulo", articuloBo.getId_articulo().toString());
			hasArticulos.put("titulo", Convert.corregir(articuloBo.getTitulo(), true));
			hasArticulos.put("urlImagen", articuloBo.getImagen());
			if(CarritoUtil.estaEnlaOrden(ordenDAO, CarritoUtil.getAriculosExcluidos().get(0))){
				//no seteo url detalle por que explota, no se setea por suscripcion quid
				hasArticulos.put("urlDetalle", "#");
				esSuscripcionQuid = true;				
			}else{
				hasArticulos.put("urlDetalle", articuloBo.getUrlDetalle());
			}
			
			hasArticulos.put("posicionEnLista", articulo.getPosicionEnLista());
			articuloBo.setUrlBusquedaAutor();
			//seteo los autores, con sus link de busqueda si es que tiene autor, si no nada
			boolean tieneAutor = articuloBo.getAutor()!=null;
			if(tieneAutor){
				hasArticulos.put("autores", ServiceLocator.getDetalleArticuloService().getAutores(articuloBo));
				hasArticulos.put("textoAutor", "de");
			}else{
				hasArticulos.put("textoAutor", "&nbsp;");
			}
			hasArticulos.put("posicionEnLista", articulo.getPosicionEnLista());
			vecArticulos.add(hasArticulos);
			//PAPELES DE REGALO POR CADA ARTICULO
			Hashtable<String, Object>hasPapeles = null;
			Vector<Hashtable<String, Object>> vecPapeles = new Vector<Hashtable<String,Object>>();
			PapelesDeRegalo papeles = Contenido.getSite().getPapelesDeRegalo();
			boolean tienePapel = articulo.tieneSubArticulo();
			String nota = Convert.toString(articulo.getNota());
			if (tienePapel) {
				nota = Convert.toString(articulo.getNota());
			}
			//lopeo lso papel de regalo				
			for (int index = 0; index < papeles.getListaProductosTypeItemCount()  && !esSuscripcionQuid; index++) {
				Producto papel = papeles.getListaProductosTypeItem(index).getProducto();
				boolean papelElegido = tienePapel && (articulo.getSubArticulo().getId() == papel.getId());
				double precioDelPapel = Contenido.getPrecioSitio(papel);
				hasPapeles = new Hashtable<String, Object>();
				hasPapeles.put("posicionEnLista", articulo.getPosicionEnLista());
				hasPapeles.put("imagenPapel",Contenido.getTapa(papel, false));					
				hasPapeles.put("nameCampoPapel",CompraHelper.CAMPO_PAPEL);
				hasPapeles.put("valueRadioPapel",papel.getId());
				if(papelElegido){
					hayPapelChequeado = true;
					hasPapeles.put("estaChequeado","checked=\"checked\"");	
				}else{
					hasPapeles.put("estaChequeado","");
				}
				//hasPapeles.put("estaChequeado",(papelElegido) ? "checked=\"chequed\"" : "");
				hasPapeles.put("tipoDePapel",(index==2)? "Papel de Regalo " : "Sobre Polietileno ");
				hasPapeles.put("precioPapel",Contenido.precioToString(precioDelPapel));					
				vecPapeles.add(hasPapeles);
				papel = null;
			}
			if(!hayPapelChequeado){
				hasArticulos.put("chequearSinPapel", "checked=\"checked\"");
			}
			//agreglo los papeles por articulo
			hasArticulos.put("papeles", vecPapeles);
			hasArticulos.put("nombreMensaje", CompraHelper.CAMPO_MENSAJE);
			hasArticulos.put("textoMensaje", nota);
			tmpArticulos.setParam("articulos", vecArticulos);						
		}			
		Map<String, String> direcciones = null;
		direcciones = ProcesoCompraUtilImp.getInstance().getDirecciones(ProcesoCompraUtil.PAPEL_REGALO);	
		tmpArticulos.setParam("pantallaAnterior", direcciones.get("anterior"));
		tmpArticulos.setParam("pantallaSiguiente", direcciones.get("siguiente"));
		
		tmpArticulos.setParam("googleSSL", Globals.getGoogleAnalyticsSSL());
		request.setAttribute("idSeccion", new Integer(Globals.SECCION_HOME));
		request.setAttribute("template",tmpArticulos.output());		
		//obtengo las pantallas anterior y siguiente en base a la que estoy parado		
		
		return mapping.findForward(frwRedirect);		
	}
}