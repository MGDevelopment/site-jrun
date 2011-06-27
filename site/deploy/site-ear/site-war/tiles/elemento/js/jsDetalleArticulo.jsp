<script type="text/javascript" src="/js/detalleArticulo.js"></script>
<script type="text/javascript" src="http://assets01.popego.com/javascripts/popego-core.js"></script>
<script type="text/javascript" src="http://www.google.com/jsapi"></script>
<%--agregados para las listas  
<jsp:include page="/tiles/elemento/js/jsListas.jsp"></jsp:include>
<script type="text/javascript" src="/js/validationForm.js"></script>
--%>
<script type="text/javascript">  
$(document).ready(function() {
	getModuloExtra();
	verTodosComentarios1();
	getEvaluacionDeArticulo();
	getArticulosRelacionados();
	lanzarPopego();
});
</script>
