function verTodosComentarios(idArticulo) {
    idArticulo = $('#articulo').get(0).value;
    var cantidad = $('#cantidad').get(0).value;
    $.ajax({
        url: '/GetComentarioXArticuloAction.do?param=' + Math.random() + '&idArticulo=' + idArticulo + '&cantidad=' + cantidad,
        cache: false,
        success: function (data) {
            $('#divComentarios').get(0).innerHTML = '';
            $('#divComentarios').get(0).innerHTML = data;
            if (data == "") {
                $('#comentarios').get(0).style.display = "none"
            }
            lanzarPopego()
        }
    })
}
function getEvaluacionDeArticulo() {
	$('#divEvaluacion').get(0).innerHTML = '<div id="divEvaluacion"><div class="dInfoCalif"><div class="dInfoCalifStarMod"><span>Calificación de lectores:</span><label>	<a href="#">Cargando...</a></label></div><div class="dInfoCalifBoton"><span><a href="#">Cargando...</a></span><a href="#"><div>AGREGAR COMENTARIO</div></a></div></div></div>';
	var idArticulo = $('#articulo').get(0).value;
    $('#divEvaluacion').load('/GetEvaluacionXArticuloAction.do?param=' + Math.random() + '&idArticulo=' + idArticulo)
}
function verTodosComentarios1(idArticulo) {
    idArticulo = $('#articulo').get(0).value;
    var cantidad = 4;
    $.ajax({
        url: '/GetComentarioXArticuloAction.do?param=' + Math.random() + '&idArticulo=' + idArticulo + '&cantidad=' + cantidad,
        cache: false,
        success: function (data) {
            if (data == "" || data.length == 0) {
                $('#comentarios').get(0).style.display = "none"
            } else {
                $('#divComentarios').get(0).innerHTML = '';
                $('#divComentarios').get(0).innerHTML = data;
                lanzarPopego()
            }
        }
    })
}
function getModuloExtra() {
	$('#divModuloExtra').get(0).innerHTML = '<div id="dTopRight"><div class="dCompra"><p align="center">Cargando extra...</p></div></div>';
    var idSeccion = $('#idSeccion').get(0).value;
    var precio = $('#precio').get(0).value;
    var estaDisponible = $('#estaDisponible').get(0).value;
    $('#divModuloExtra').load('/GetModuloExtraAction.do?param=' + Math.random() + '&idSeccion=' + idSeccion + '&precio=' + precio + '&idArticulo=' + $('#idArticulo').get(0).value + '&estaDisponible=' + estaDisponible)
}
function getArticulosRelacionados(idArticulo) {
	$('#divArticulosRelacionados').get(0).innerHTML = '<div class="dRecomendTit" >Cargando obras relacionadas...</div>';
	idArticulo = $('#articulo').get(0).value;
    $('#divArticulosRelacionados').load('/GetArticulosRelacionadosAction.do?param=' + Math.random() + '&idArticulo=' + idArticulo)
}
function lanzarPopego(param) {
    if ($('#scriptPopego').get(0) == null) {
        setTimeout("lanzarPopego()", 1000)
    } else {
        var scriptPopego = $('#scriptPopego').get(0).innerHTML;
        eval(scriptPopego)
    }
}
function mostrarImagen(path) {
    window.open('/componentes/comunes/detalleTapaNuevo.jsp?path=' + path + '&textoH1=', '', 'toolbar=0,status=0,scrollbars=no,resizable=yes,width=30,height=30')
}
function getPrimerCapitulo() {
    var idArticulo = $('#articulo').get(0).value;
    $('#divPrimerCapitulo').load('/GetPrimerCapitulo.do?param=' + Math.random() + '&idArticulo=' + idArticulo)
}
function getBiografia() {
    var idArticulo = $('#articulo').get(0).value;
    $('#divBiografia').load('/GetBiografiaByIdArticulo.do?param=' + Math.random() + '&idArticulo=' + idArticulo)
}
function getEntrevista(idArticulo) {
    var idArticulo = $('#articulo').get(0).value;
    $('#divEnrevista').load('/GetEntrevista.do?idArticulo=' + idArticulo + '&param=' + Math.random())
}