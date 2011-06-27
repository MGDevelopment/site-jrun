<script type="text/javascript">	
	<%--@include file="/js/prototype-1.6.0.3.js"--%>
	<%@include file="/js/dropDownMenu.js"%>
	<%@include file="/js/equalcolumnsInicio.js"%>
	<%@include file="/js/menuarbol.js"%>
	<%@include file="/js/buscador.js"%>
	<%@include file="/js/jsutil.js"%>
	<%@include file="/js/carritoNew.js"%>
	<%@include file="/js/popups.js"%>
	<%@include file="/js/mensaje.js"%>
	<%@include file="/js/hashtable.js" %>
	<%@include file="/js/mesa.js" %>
	<%--@include file="/js/imagePreloader.js" --%>
	<%@include file="/js/mesaInicio.js" %>	
</script>

<script type="text/javascript">	
	$(document).ready(function(){
		verificarFiltros();
	});
</script>
<script>
	var idsCat = new Array();
	var catLibro = 1,catPasatiempo = 3,catMusica = 4,catPelicula = 5;
	var tamView = new Array();
	idsCat[0]=catLibro; 
	idsCat[1]=catPasatiempo;
	idsCat[2]=catMusica;
	idsCat[3]=catPelicula;
	tamView[catLibro]= 4;
	tamView[catPasatiempo]=4;
	tamView[catMusica]=6;
	tamView[catPelicula]=4;
</script>

<script language="javascript">
	<%--esta funcion es llamada desde verificarFiltros, una ves que se carga la mesa, para darle mas prioridad a la mesa carga de la misma--%>
	function lanzarMensajes(){
		getVisualizaMensaje();//en carritoNew.js
		carrito_ActualizarCarrito();//en carritoNew.js
		getComentarios();		
	}		
</script>