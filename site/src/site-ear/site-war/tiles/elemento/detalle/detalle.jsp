<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"%>
<%@page import="com.tmk.kernel.Globals"%>
<tiles:useAttribute name="idSeccion" scope="request" ignore="true"	classname="java.lang.Integer" />
<tiles:useAttribute name="articulo" scope="page" ignore="true"	classname="com.tmk.bus.articulo.ArticuloClass" />

<script language="javascript">
	document.expando = true;
</script>

<script type="text/javascript">

		google.load("books", "0", {"language": "es"});


      function alertNotFound() {
        if(document.getElementById('viewerCanvas') != 'undefined'){
        	document.getElementById('viewerCanvas').innerHTML = '';
        }
      }
      function alertInitialized() {
          	if(document.getElementById('viewerCanvas')!='undefined') {
	      		var view = document.getElementById('viewerCanvas');
				var viewChildNodes = view.childNodes;
				var nodes = viewChildNodes[0].childNodes;
				//var text = '<a style="border: 0px none ; margin: 0px; padding: 0px; position: absolute; font-size: 13.28px; font-family: Arial,sans-serif; font-weight: normal; line-height: 1; vertical-align: middle; text-align: left; background-color: transparent; color: rgb(0, 0, 204); text-decoration: underline; left: 5px; top: 514px;" target="_blank" href="http://books.google.com/?hl=es"><div style="border: 0px none ; margin: 0px; padding: 0px; width: 60px; height: 30px; background-image: url(http://books.google.com/googlebooks/images/poweredby.png); background-position: left top; background-repeat: no-repeat; font-size: 13.28px; font-family: Arial,sans-serif; font-weight: normal; line-height: 1; vertical-align: middle; text-align: left; background-color: transparent; color: rgb(0, 0, 0); text-decoration: none;"/></a>';
			
				nodes[1].innerHTML = '<div>';
				nodes[1].innerHTML = '<a href=\'http://books.google.com/?hl=es\' target=\'_blank\'> <img style=\'border:none;\'src=\"http://books.google.com/googlebooks/images/poweredby.png\"> </a>'+
									 '</div>';
				//nodes[1].innerHTML = text;
          	}
      }
      function initialize() {
      	var divVisor = document.getElementById('viewerCanvas');
        var viewer = new google.books.DefaultViewer(divVisor, {'showLinkChrome': false});
        <%String[]isbn_ = articulo.getISBN().split("-");
          StringBuffer cadena =  new StringBuffer("");
          for(int i=0;i<isbn_.length;i++){
          	cadena.append(""+isbn_[i]);
          }
        %>
        viewer.load('ISBN:<%=(cadena.toString())%>', alertNotFound, alertInitialized);
      }
    </script>

<!-- DETALLE GENERADO -->
<%  String detallePage ="";
if (Globals.esModoRelease()) {
		detallePage  = "/contenidosEstaticos/articulos/" + ((int)Math.floor(articulo.getIdArticulo()/1000) * 1000) + "/detalle" + articulo.getIdArticulo() + ".html";
} else {
		detallePage  = "/articulo/componentes/detalle[ORIGINAL].jsp?idArticulo=" + articulo.getIdArticulo() + "&idSeccion=" + idSeccion;
}
%>
<table width="600" border="0" cellpadding="0" cellspacing="0"	class="Gtablacontenido" align="center">
	<jsp:include page="<%=detallePage%>" />
</table>
<script language="javascript">

	var tablas = document.getElementsByTagName('table').length;
	for (i=0; i<tablas; i++) {
		if (document.getElementsByTagName('table')[i].className == 'Gfooter') {
			document.getElementsByTagName('table')[i].style.display = 'none';
			break;
		}
	}
	var div = document.getElementsByTagName('div').length;
	for (i=0; i<div; i++) {
		if (document.getElementsByTagName('div')[i].className == 'Gfooter3') {
			document.getElementsByTagName('div')[i].style.display = 'none';
			break;
		}
	}

	if(document.getElementById('viewerCanvas') != null){
		google.setOnLoadCallback(initialize);
	}

</script>