<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>
<%@page import="com.tmk.soa.servicios.interfaces.DetalleService"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%>
<%@page import="com.tmk.bus.articulo.Articulo"%>
<%@page import="com.tmk.kernel.Convert"%>
<%@page import="java.io.FileNotFoundException"%>
<%@page import="com.tmk.generacion.articulo.GeneradorDeArticulo"%>
<%@page import="java.io.IOException"%>

<%	
	Integer idArticulo = (Integer)request.getAttribute("idArticulo");
	Articulo articulo = ServiceLocator.getArticuloService().getDatosPrincipal(idArticulo);
%>
<!-- DETALLE GENERADO SI ES RELEASE-->
<%  
	String detallePage = "";
	if (Globals.esModoRelease()) {
		try {
			detallePage  = "/contenidosEstaticos/articulos/" + ((int)Math.floor((idArticulo.intValue()/1000)) * 1000) + "/detalle_" + idArticulo.intValue() + ".html";
			pageContext.include(detallePage);
			//System.out.println("Release inserto ok idArticulo "+idArticulo.toString());
		}catch(IOException t ) {
			//System.out.println("Release insreto error idArticulo "+idArticulo.toString());
			articulo = ServiceLocator.getArticuloService().getArticuloById(idArticulo);
			DetalleService servicio = ServiceLocator.getDetalleArticuloService();
			out.println(servicio.getTemplate(articulo,"tmpDetalleGeneral"));
			//GeneradorDeArticulo.generarDetalleRediseno(idArticulo,articulo.getCategoria_seccion());
		}
	} else {
		//System.out.println("Debug insreto idArticulo "+idArticulo.toString());
		articulo = ServiceLocator.getArticuloService().getArticuloById(idArticulo);
		DetalleService servicio = ServiceLocator.getDetalleArticuloService();
		out.println(servicio.getTemplate(articulo,"tmpDetalleGeneral"));
	}
%>
<!-- GOOGLE BOOKS -->
<%if(articulo != null && articulo.getISBN()!=null) { %>
	<script type="text/javascript">
		  google.load("books", "0", {"language": "es"});	  
	      function alertNotFound() {
	        if(document.getElementById('viewerCanvas') != 'undefined'){
	        	document.getElementById('viewerCanvas').innerHTML = '';
	        	document.getElementById('googleBook').innerHTML = '';        	       	
	        }
	      }
	      function alertInitialized() {
	          if(document.getElementById('viewerCanvas')!='undefined') {
		      		var view = document.getElementById('viewerCanvas');
					var viewChildNodes = view.childNodes;
					var nodes = viewChildNodes[0].childNodes;			
					nodes[1].innerHTML = '<div>';
					nodes[1].innerHTML = '<a href=\'http://books.google.com/?hl=es\' target=\'_blank\'> <img style=\'border:none;\'src=\"http://books.google.com/googlebooks/images/poweredby.png\"> </a>'+
										 '</div>';
	          }
	      }
	      function initialize() {
	      	var divVisor = document.getElementById('viewerCanvas');
	        var viewer = new google.books.DefaultViewer(divVisor, {'showLinkChrome': false});
	        <%
	        	String[]isbn_ = articulo.getISBN().split("-");
	          	StringBuffer cadena =  new StringBuffer("");
	          	for(int i=0;i<isbn_.length;i++){
	          		cadena.append(""+isbn_[i]);
	          	}
	        %>
	        viewer.load('ISBN:<%=(cadena.toString())%>', alertNotFound, alertInitialized);
	      }	
	    if(document.getElementById('viewerCanvas') != null){
	  		google.setOnLoadCallback(initialize);
	  	}
	</script>
<%}%>