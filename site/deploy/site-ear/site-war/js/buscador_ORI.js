var hayBusquedaEnProgreso = false;
/*function buscador_setBusqueda(busSeleccionada, texto, idSeccion) {
	var seccionDeBusqueda = "";
	if (texto == '' || texto.length <2) {
		alert('Por favor ingrese una palabra de 2 o más caracteres.');
		return;
	}
	/*alert("/SetearBusqueda?idSeccion=" + idSeccion + "&tipoBusqueda=" +
							busSeleccionada + "&texto=" + texto);*/
	//agrego esta pregunta para poder usar los dos buscadores paralelos
	//hasta dejar el definitivo
	//if(!busquedaNueva) {
		//window.location.href ="/SetearBusqueda?idSeccion=" + idSeccion + "&tipoBusqueda=" +
								//busSeleccionada + "&texto=" + texto +"";
	//}else {
		//window.location.href ="/SetearBusqueda2?idSeccion=" + idSeccion + "&tipoBusqueda=" +
								//busSeleccionada + "&texto=" + texto +"";
	//}
//}


function pressEnter(event) {
	if (event.keyCode == 13) {
		return true;
	}
}


function buscador_setBusqueda(busSeleccionada, texto, idSeccion,idSeccionPropia,seccionDeBusqueda) {	
	if(busSeleccionada=='Todo el Sitio')
		busSeleccionada = 'todo el sitio';
	if (texto == '' || texto.length <2) {
		alert('Por favor ingrese una palabra de 2 o más caracteres.');
		return;
	}
	if(!hayBusquedaEnProgreso) {
		hayBusquedaEnProgreso = true;
		window.location.href ="/SetearBusqueda?idSeccion=" + idSeccion + "&tipoBusqueda=" +
								busSeleccionada + "&texto=" + texto + "&idSeccionPropia=" + 
									idSeccionPropia +"&seccionDeBusqueda=" + seccionDeBusqueda +"";
	}else { 
		return ;
	}
}
function buscador_setBusqueda2(busSeleccionada, texto, idSeccion,idSeccionPropia,seccionDeBusqueda) {
	if(!hayBusquedaEnProgreso) {
		hayBusquedaEnProgreso = true;
		window.location.href ="/SetearBusqueda2?idSeccion=" + idSeccion + "&tipoBusqueda=" +
								busSeleccionada + "&texto=" + texto + "&idSeccionPropia=" + 
									idSeccionPropia +"&seccionDeBusqueda=" + seccionDeBusqueda +"&mantenerIds=true";
	}else {
		return;
	}
}

function getSeccion(id) {
	var str ;
	switch(id) {
		case 1:
			str = 'En Libros'; break;
		case 3:
			str = 'En Pasatiempos'; break;
		case 4:
			str = 'En Musica'; break;
		default :		
			str = 'En Peliculas'; break;
	}
	//alert(str);
	return str;
}

//timer de tarjeta de articulo (window.setTimeout)
var progresoGloboArticulo=null;
var datosDisponibles=null;
var tempo = 10;
var cboO = new Array();
var filtro = "";
var orden = "";
var hasFiltros = new Hashtable();
var articulo = new Hashtable();
var chPagina=10;
var catLibro = 1;
var catPasatiempo = 3;
var catMusica = 4;
var catPelicula = 5;
var idsCat = new Array();
var tamView = new Array();
var cantByRequest = new Array();
var imgPre = new Array();
var imgPreSig = new Array();
var imgPreAnt = new Array();
var objImgPre = new Array();
var index = new Array();
var indexTotal = new Array();
var datos = new Array();
var datosSig = new Array();
var datosAnt = new Array();
var total = new Array();
var totalNro = new Array();
var IE = document.all?true:false
if (!IE) document.captureEvents(Event.MOUSEMOVE)
document.onmousemove = posicRatonXY;
var posicX = 0;
var posicY = 0;
var posicXAnt = 0;
var posicYAnt = 0;
var direccion = new Array();
function inicializarVariables() {
	cantByRequest = new Array();
	for (i = 0; i<idsCat.length; i++) {
		cantByRequest[idsCat[i]] = tamView[idsCat[i]] * chPagina;
	}
	//array de imagenes prelodeadas
	imgPre = new Array();
	for (i=0; i<idsCat.length; i++) {
		imgPre[idsCat[i]] = new Array(cantByRequest[idsCat[i]]);
	}
	imgPreSig = new Array();
	for (i =0; i<idsCat.length; i++) {
		imgPreSig[idsCat[i]] = new Array(cantByRequest[idsCat[i]]);
	}
	imgPreAnt = new Array();
	for (i =0; i<idsCat.length; i++) {
		imgPreAnt[idsCat[i]] = new Array(cantByRequest[idsCat[i]]);
	}
	objImgPre = new Array();
	index = new Array();
	for (i=0; i<idsCat.length; i++) {
		index[idsCat[i]] = 1;
	}
	indexTotal = new Array();
	for (i=0; i<idsCat.length; i++) {
		indexTotal[idsCat[i]] = 1;
	}
	datos = new Array();
	total = new Array();
	for (i=0; i<idsCat.length; i++) {
		var f = ('javascript:siguiente(' + idsCat[i] + ')');
		$('siguiente' + idsCat[i]).href = f;
		$('siguiente' + idsCat[i] + 'DIV').className = 'mesaSiguiente';
		$('anterior' + idsCat[i]).href = 'javascript:nada()';
		$('anterior'+idsCat[i]+'DIV').className = 'mesaAnteriorDeshabilitada';
	}
	direccion = new Array();
	for (i =0; i<idsCat.length; i++) {
		direccion[idsCat[i]] = "SIG";
	}
}
/*se ejecuta ante un cambio de criterio de visualizacion de articulos de la mesa*/
function cambioDeFiltroOrden() {
	if ($('mostrarTiempo').innerHTML != '') {
		for (i=0; i<idsCat.length; i++) {
			$('cat' + idsCat[i] + 'Disabled').style.display="";
			$('anterior'+idsCat[i]).href = 'javascript:nada()';
			$('anterior'+idsCat[i]+'DIV').className = 'mesaAnteriorDeshabilitada';
		}
		$('ctrlDisabled').style.display="";
		var cboF = hasFiltros.get(orden);
		for (i=0; i<cboF.length; i++) {
			if (cboF[i][1] == $('mostrarTiempo').innerHTML) {
				filtro = cboF[i][0];
			}
		}
		getTotal();
	}
}
/*datos de articulo para tarjeta*/
function getArticulo(idArticulo) {
	new Ajax.Request('/contenidosEstaticos/articulos/' + (Math.floor(idArticulo/1000) * 1000) + '/jsonNVL1_' + idArticulo + '.html',
			{ method:'get',
		onSuccess: function(transport){
		var obj= transport.responseText.evalJSON();
		setArticulo(obj.Articulo);
		articulo.put(idArticulo, obj.Articulo);
	}
			}
	);
}
/*FIN PETICIONES AL SERVER*/
/*precarga inicial de imagen ejecuta on preload*/
function cargarImgInicial(idCat, arrIMG, arrDatos) {
	var i;
	for (i=0; i<arrDatos[idCat].length; i++) {
		arrIMG[idCat][i] = "http://www.tematika.com/tapas/sitio/" + arrDatos[idCat][i] + "c0.jpg"
	}
	objImgPre[idCat] =  arrIMG[idCat];
	onPreload(idCat);
}
/*precarga de imagen no ejecuta funcion al terminar*/
function cargarImg(idCat, arrIMG, arrDatos) {
	var i;
	for (i=0; i<arrDatos[idCat].length; i++) {
		arrIMG[idCat][i] = "http://www.tematika.com/tapas/sitio/" + arrDatos[idCat][i] + "c0.jpg"
	}
	//	objImgPre[idCat] =  new ImagePreloader(arrIMG[idCat], nada, idCat);
	objImgPre[idCat] = arrIMG[idCat];
}
function nada() {}
/*seteos necesarios luego de precarga inicial de imagen*/
function onPreload(idCat) {
	setMesa(idCat);
	$('cat' + idCat + 'Disabled').style.display="none"
}
/*setea la mesa por categoria*/
function setMesa(idCategoria){
	var datMesa = "";
	var inicio = (index[idCategoria]-1) * tamView[idCategoria];
	var fin = (index[idCategoria]) * tamView[idCategoria];
	var i;
	var itm =1;
	for (i=inicio; i<fin; i++) {
		if (datos[idCategoria][i] != undefined) {
			$('itm' + idCategoria + '-' + itm).src = imgPre[idCategoria][i];
			$('itm' + idCategoria + '-' + itm).idArticulo = datos[idCategoria][i];
			if (datos[idCategoria][i] == 0) {
				$('itm' + idCategoria + '-' + itm).src = '/tapas/adicionales/blc_'+ idCategoria+ '.jpg';
			}
		} else {
			$('itm' + idCategoria + '-' + itm).src = '/tapas/adicionales/blc_'+ idCategoria+ '.jpg';
			$('itm' + idCategoria + '-' + itm).idArticulo = 0;
		}
		itm++;
	}
	$('ctrlDisabled').style.display="none";
}
/*mueve la mesa a la siguiente pagina por categoria*/
function siguiente(idCategoria) {
	actualizarEstadisticaPaginacion(idCategoria);
	if (index[idCategoria] == chPagina) {
		datos[idCategoria] = new Array();
		imgPre[idCategoria] = new Array();
		for (i=0; i<datosSig[idCategoria].length; i++) {
			datos[idCategoria][i] = datosSig[idCategoria][i];
			imgPre[idCategoria][i] = imgPreSig[idCategoria][i];
		}
		index[idCategoria]=0;
	}
	$('anterior'+idCategoria + 'DIV').className = 'mesaAnterior';
	$('anterior'+idCategoria).href='javascript:anterior(' + idCategoria + ')';
	//if ((indexTotal[idCategoria])+1 == total[idCategoria]) {
	if ((indexTotal[idCategoria]) +1 == total[idCategoria]) {
		$('siguiente'+idCategoria).href = 'javascript:nada();'
			$('siguiente'+idCategoria+'DIV').className = 'mesaSiguienteDeshabilitada';
	} else {
		retardo('siguiente', idCategoria);
		retardo('anterior', idCategoria);
	}
	if (indexTotal[idCategoria] <total[idCategoria]) {
		index[idCategoria]++;
		indexTotal[idCategoria]++;
		setMesaS(idCategoria);
		if (index[idCategoria]==chPagina/2 || direccion[idCategoria]!="SIG") {
			var indice = chPagina - index[idCategoria];
			indice = indexTotal[idCategoria] + Math.abs(indice) + 1;
			if (indice<=total[idCategoria] ) {
				getByCategoria(idCategoria, indice, imgPreSig, datosSig);
			}
			if (indice-chPagina>0) {
				getByCategoria(idCategoria, indice-chPagina, imgPreAnt, datosAnt);
			}
		}
	}
	direccion[idCategoria] = "SIG";
}
/*mueve la mesa a la pagina anterior por categoria*/
function anterior(idCategoria) {
	if (index[idCategoria] == 1 && indexTotal[idCategoria]>index[idCategoria]) {
		datos[idCategoria] = new Array();
		imgPre[idCategoria] = new Array();
		for (i=0; i<datosAnt[idCategoria].length; i++) {
			datos[idCategoria][i] = datosAnt[idCategoria][i];
			imgPre[idCategoria][i] = imgPreAnt[idCategoria][i];
		}
		index[idCategoria]=11;
	}
	if (indexTotal[idCategoria]>1) {
		index[idCategoria]--;
		indexTotal[idCategoria]--;
		setMesaI(idCategoria);
		if (index[idCategoria]==chPagina/2 || direccion[idCategoria]!="ANT") {
			var indice = chPagina - index[idCategoria];
			indice = indexTotal[idCategoria] + Math.abs(indice) + 1;
			indice = indice -chPagina;
			if (indice<=total[idCategoria] ) {
				getByCategoria(idCategoria, indice, imgPreSig, datosSig);
			}
			if (indice-chPagina>0) {
				getByCategoria(idCategoria, indice-chPagina, imgPreAnt, datosAnt);
			}
		}
		direccion[idCategoria]="ANT";
	}
	$('siguiente'+idCategoria+'DIV').className = 'mesaSiguiente';
	$('siguiente'+idCategoria).href = 'javascript:siguiente(' + idCategoria + ')';
	if (indexTotal[idCategoria]==1) {
		$('anterior'+idCategoria+ 'DIV').className = 'mesaAnteriorDeshabilitada';
		$('anterior'+idCategoria).href='javascript:nada()'
	} else {
		retardo('anterior', idCategoria);
		retardo('siguiente', idCategoria);
	}
}
/*Setea la mesa luego de elegir siguiente*/
function setMesaS(idCategoria){
	var inicio = (index[idCategoria]-1) * tamView[idCategoria];
	var fin = (index[idCategoria]) * tamView[idCategoria];
	var i;
	var itm =1;
	for (i=inicio; i<fin; i++) {
		if (datos[idCategoria][i] != undefined) {
			$('itm' + idCategoria + '-so' + itm).src = imgPre[idCategoria][i];
		} else {
			$('itm' + idCategoria + '-so' + itm).src = '/tapas/adicionales/blc_1.jpg';
		}
		itm++;
	}
	mover(20, 0, idCategoria);
}
/*Setea la mesa luego de elegir anterior*/
function setMesaI(idCategoria){
	var inicio = (index[idCategoria]-1) * tamView[idCategoria];
	var fin = (index[idCategoria]) * tamView[idCategoria];
	var i;
	var itm =1;

	for (i=inicio; i<fin; i++) {
		$('itm' + idCategoria + '-io' + itm).style.display = 'block';
		if (datos[idCategoria][i] != undefined) {
			$('itm' + idCategoria + '-io' + itm).src = imgPre[idCategoria][i];
		} else {
			$('itm' + idCategoria + '-io' + itm).src = '/tapas/adicionales/blc_1.jpg';
		}
		itm++;
	}
	mover(-20, 0, idCategoria);
}
/*ejecuta el efecto de movimiento de las imagenes de la mesa.
Segun un desplazamiento definido en px y una cantidad de iteraciones */
function mover(desp, it, idCat) {
	var total = Math.abs(300/desp);
	if (it == total) {
		setMesa(idCat)
		for (i=1; i<=tamView[idCat]; i++) {
			if (desp>0) {
				$('itm' + idCat + '-so' + i).style.top=(parseInt($('itm' + idCat + '-so' + i).style.top)-300) + "px";
				$('itm' + idCat + '-' + i).style.top="0px";
			} else {
				$('itm' + idCat + '-io' + i).style.top=(parseInt($('itm' + idCat + '-io' + i).style.top)+300) + "px";
				$('itm' + idCat + '-' + i).style.top="0px";
			}
		}
	} else {
		it++;
		var funcion = 'mover(' + desp + ',' + it + ',' + idCat + ')';
		window.setTimeout(funcion, 50);
		for (i=1; i<=tamView[idCat]; i++) {
			if (desp>0) {
				$('itm' + idCat + '-so' + i).style.top=(parseInt($('itm' + idCat + '-so' + i).style.top)+desp)+"px";
				$('itm' + idCat + '-' + i).style.top=(parseInt($('itm' + idCat + '-' + i).style.top)+desp)+ "px";
			} else {
				$('itm' + idCat + '-io' + i).style.top=(parseInt($('itm' + idCat + '-io' + i).style.top)+desp) + "px";
				$('itm' + idCat + '-' + i).style.top=(parseInt($('itm' + idCat + '-' + i).style.top)+desp)+ "px";
			}
		}
	}
}
/*Produce un retardo definido de 1 segundo luego de presionar el boton siguiente o anterior*/
function retardo(direccion, idCategoria) {
	var obj = $(direccion + idCategoria);
	var func =  'javascript:' + direccion + '(' + idCategoria + ')';
	if (obj.href != func) {
		obj.href = func;
		$(direccion+idCategoria+'DIV').className = 'mesa'+direccion.substr(0,1).toUpperCase() +direccion.substr(1,direccion.length);
	} else {
		obj.href = 'javascript:nada()';
		$(direccion+idCategoria+'DIV').className = 'mesa'+direccion.substr(0,1).toUpperCase() +direccion.substr(1,direccion.length)+'Deshabilitada';
		window.setTimeout('retardo("' + direccion + '","' + idCategoria + '")', 1500);
	}
}
/*Muestra la tarjeta del articulo*/
function mostrarGlobo(idArticulo, minX, maxX, minY, maxY) {
	if (posicX > getScreenSize()[0]/2) {
		$('globoArticuloTop').className="globoArticuloRightTop";
		$('globoArticuloBottom').className="globoArticuloRightBottom";
		$('globo').style.left =(posicX-25-345) + "px" ;
	} else {
		$('globoArticuloTop').className="globoArticuloTop";
		$('globoArticuloBottom').className="globoArticuloBottom";
		$('globo').style.left = (posicX-5) + "px" ;
	}

	$('globo').style.top = (posicY-5) + "px";
	if (articulo.containsKey(idArticulo)) {
		setArticulo(articulo.get(idArticulo));
	}else {
		getArticulo(idArticulo);
	}
	$('tiempoEntrega').style.display='none';
	$('tiempoEntrega').style.visibility='hidden';
}
/*Permite evaluar luego de un tiempo dado (1 seg) si la posición del cursor se mantiene en los límites de una imagen*/
function evaluarPosicion(ultima, idArticulo, minX, maxX, minY, maxY) {
	if (ultima) {
		if (posicX > minX && posicX < maxX  && posicY > minY && posicY < maxY) {
			mostrarGlobo(idArticulo, minX, maxX, minY, maxY);
		}
	} else {
		var funcion = 'evaluarPosicion(true,' + idArticulo + ',' + minX + ',' + maxX + ',' + minY + ',' + maxY + ')';
		progresoGloboArticulo = window.setTimeout(funcion, 1000);
	}
}
/*Inicia el proceso de muestra de tarjeta de articulo*/
function articuloPopUp(idArticulo, minX, maxX, minY, maxY) {
	if (idArticulo == 0) {
		return;
	}
	window.clearTimeout(progresoGloboArticulo);
	evaluarPosicion(false, idArticulo, minX, maxX, minY, maxY);
}
/*oculta la tarjeta de articulo*/
function ocultarGlobo(){
	$('globo').style.display='none';
}
/*setea los datos del articulo en la tarjeta*/
function setArticulo(objArticulo) {
	$('artTitulo').innerHTML = objArticulo.titulo;
	$('artTitulo').href = objArticulo.cls_urlDetalle;
	$('precioArticulo').innerHTML = '$ ' + formatCurrency(objArticulo.cls_precio);
	if (objArticulo.editor != undefined) {
		if (objArticulo.categoria_seccion == catLibro || objArticulo.categoria_seccion == catPasatiempo) {
			$('editor').innerHTML = 'Editorial';
		}
		if (objArticulo.categoria_seccion == catMusica) {
			$('editor').innerHTML = 'Discográfica';
		}
		if (objArticulo.categoria_seccion == catPelicula) {
			$('editor').innerHTML = 'Productora';
		}
		$('artEditor').innerHTML = objArticulo.editor.nombre;
		$('artEditor').href = objArticulo.editor.cls_urlBusqueda;
		$('trEditor').style.display='';
	} else {
		$('trEditor').style.display='none';
	}
	$('artPublicacion').innerHTML = objArticulo.fecha_alta;
	$('artIdioma').innerHTML = objArticulo.idioma;
	if (objArticulo.paginas != undefined) {
		if (objArticulo.categoria_seccion == catLibro || objArticulo.categoria_seccion == catPasatiempo) {
			$('artPagina').innerHTML = objArticulo.paginas;
			$('pagina').innerHTML = 'Paginas:';
			$('trPagina').style.display = '';
		} else {
			if (objArticulo.categoria_seccion == catPelicula) {
				$('artPagina').innerHTML = objArticulo.paginas;
				$('pagina').innerHTML = 'Duraci&oacute;n:';
				$('trPagina').style.display = '';
			} else {
				$('trPagina').style.display = 'none';
			}
		}
	} else {
		$('trPagina').style.display = 'none';
	}
	if (objArticulo.formato != undefined && objArticulo.formato.rv_meaning != undefined) {
		$('artFormato').innerHTML = objArticulo.formato.rv_meaning;
		$('trFormato').style.display = '';
	} else {
		if (objArticulo.tipoArticulo != undefined && objArticulo.tipoArticulo.descripcion != undefined) {
			$('artFormato').innerHTML = objArticulo.tipoArticulo.descripcion;
			$('trFormato').style.display = '';
		} else {
			$('trFormato').style.display = 'none';
		}
	}
	if (objArticulo.disponibilidad != undefined && objArticulo.disponibilidad.descripcion != undefined) {
		$('artDisponibilidad').innerHTML = objArticulo.disponibilidad.descripcion;
		$('trDisponibilidad').style.display = '';
		if (objArticulo.disponibilidad.pedido_especial == 'S') {
			$('trComprar').style.display = 'none';
			$('trPedir').style.display = '';
			$('trPedir').innerHTML = '<a href="#" id="btnPedir"><div class="globoArticuloPedir"></div></a>';
			$('trComprar').innerHTML = '';
			$('btnPedir').href ='javascript:carrito_Pedir(' + objArticulo.id_articulo + ')';
		} else {
			$('trComprar').style.display = '';
			$('trComprar').innerHTML = '<a href="#" id="btnComprar"><div class="globoArticuloComprar"></div></a>';
			$('trPedir').style.display = 'none';
			$('trPedir').innerHTML = '';
			$('btnComprar').href = 'javascript:carrito_AgregarArticulo(' + objArticulo.id_articulo + ')';
		}
	} else {
		$('trDisponibilidad').style.display = 'none';
		$('trComprar').style.display = 'none';
		$('trPedir').style.display = 'none';
	}
	if (objArticulo.masVendidoSeccion != undefined && objArticulo.masVendidoSeccion.orden != undefined) {
		$('artRanking').innerHTML = objArticulo.masVendidoSeccion.orden;
		$('trRanking').style.display = '';
	} else {
		$('trRanking').style.display = 'none';
	}
	if (objArticulo.articuloAutor != undefined && objArticulo.articuloAutor.length>0) {
		var i;
		$('autor').innerHTML = 'Autor';
		if (objArticulo.categoria_seccion == catPelicula) {
			$('autor').innerHTML ='Director';
		}
		if (objArticulo.categoria_seccion == catMusica) {
			$('autor').innerHTML ='Intérprete';
		}
		$('artAutor').innerHTML ='';
		$('trAutor').style.display = '';

		for (i=0; i<objArticulo.articuloAutor.length && i<3; i++) {
			if (objArticulo.categoria_seccion == catMusica) {
				if (objArticulo.articuloAutor[i].autor.descripcion2 != undefined) {
					$('artAutor').innerHTML = $('artAutor').innerHTML + objArticulo.articuloAutor[i].autor.descripcion2  + "<br>" ;
				} else {
					$('artAutor').innerHTML = $('artAutor').innerHTML + objArticulo.articuloAutor[i].autor.descripcion  + "<br>" ;
				}
			} else {
				$('artAutor').innerHTML = $('artAutor').innerHTML + objArticulo.articuloAutor[i].autor.descripcion  + "<br>" ;
			}
			$('autorURLBusqueda').href = objArticulo.articuloAutor[i].autor.cls_urlBusqueda;
		}
	} else {
		$('trAutor').style.display = 'none';
	}
	var cantidadComentario = Math.round(parseInt(objArticulo.cls_cantidadComentario));
	if (cantidadComentario > 0) {
		$('calificacion').innerHTML = '<span>Calificaci&oacute;n:</span>';
		var cal = 0;
		var evaluacion = Math.round(parseInt(objArticulo.cls_evaluacionComentario));
		for (cal = 1; cal <= evaluacion; cal++) {
			$('calificacion').innerHTML = $('calificacion').innerHTML + '<div class="calificacionStar"></div>';
		}
		for (i = cal; i <= 5; i++) {
			$('calificacion').innerHTML = $('calificacion').innerHTML + '<div class="calificacionStarDes"></div>';
		}
		$('calificacion').innerHTML = $('calificacion').innerHTML + '&nbsp; '
		+ '<a href="'+ objArticulo.cls_urlDetalle + '#coment">' + cantidadComentario + '&nbsp;' + ((cantidadComentario>1)?'comentarios':'comentario') + '</a>';
		$('calificacion').style.display = 'block';
	} else {
		$('calificacion').innerHTML = '';
		$('calificacion').style.display = 'none';
	}
	$('linkDetalleImagen').href = objArticulo.cls_urlDetalle;
	$('urlImagen').src=objArticulo.cls_urlImagen;
	$('linkDetalleInfo').href = objArticulo.cls_urlDetalle;
	$('linkAgregarComentario').href ='/Comentario?ID_ARTICULO=' + objArticulo.id_articulo;

	$('globo').style.display='';
	$('loadArticulo').style.display ='none';
}
/*Carga inicialmente el combo de opciones y filtros*/
function cargarCbos() {
	$('orden').innerHTML = '';
	$('mostrarRanking').innerHTML = '';
	for (i=0; i<cboO.length; i++) {
		$('orden').innerHTML = $('orden').innerHTML
		+ '<li><a id="' + cboO[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboO[i][0] + '\',\'mostrarRanking\',\'orden\');cargarFiltro();">' + cboO[i][1] + '</a></li>';
	}
	$('mostrarRanking').innerHTML = $(orden).innerHTML;
	$('filtro').innerHTML = '';
	$('mostrarTiempo').innerHTML = '';
	var cboF = hasFiltros.get(cboO[0][0]);
	for (i=0; i<cboF.length; i++) {
		$('filtro').innerHTML = $('filtro').innerHTML
		+ '<li><a id="' + cboF[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboF[i][0] + '\',\'mostrarTiempo\',\'orden\');cambioDeFiltroOrden();">' + cboF[i][1] + '</a></li>';
	}
	$('mostrarTiempo').innerHTML = $(filtro).innerHTML;
}
/*carga filtros en base al orden seleccionado*/
function cargarFiltro() {
	for (i=0; i<cboO.length; i++) {
		if ($('mostrarRanking').innerHTML == cboO[i][1]) {
			orden = cboO[i][0];
			break;
		}
	}
	var cboF = hasFiltros.get(orden);
	$('filtro').innerHTML = '';
	$('mostrarTiempo').innerHTML = cboF[0][1];

	for (i=0; i<cboF.length; i++) {
		$('filtro').innerHTML = $('filtro').innerHTML
		+ '<li><a id="' + cboF[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboF[i][0] + '\',\'mostrarTiempo\',\'orden\');cambioDeFiltroOrden();">' + cboF[i][1] + '</a></li>';
	}
	cambioDeFiltroOrden();
}

function actualizarEstadisticaPaginacion(idSeccion) {
		var url = Math.random()+ '&idSeccion=' + idSeccion;
		new Ajax.Request('/ActualizarPaginacion?param=' + url,
			{ method:'post',
		 	   parameters: '',
		   	   contentType: 'application/x-www-form-urlencoded',
				onSuccess: function(transport){
					//nada
				}
			}
		);
	}	
