/*mesaDeSeccion.js*/
var progresoGloboArticulo=null;
var datosDisponibles=null;
var tempo = 10;
var cboO = new Array();
var filtro = "";
var orden = "";
var hasFiltros = new Hashtable();
//Array de articulos visualizados en tarjeta
var articulo = new Hashtable();
//Cantidad de Paginas por pedido al server
var chPagina=10;
//Identificadores de Categorias
var catLibro = 1;
var catPasatiempo = 3;
var catMusica = 4;
var catPelicula = 5;
var idsCat = new Array();
//Tamaño de vista por categoria
var tamView = new Array();
//Cantidad de artículos traidos por request al server
var cantByRequest = new Array();
//array de imagenes prelodeadas
var imgPre = new Array();
//array de imagenes prelodeadas
var imgPreSig = new Array();
//array de imagenes prelodeadas
var imgPreAnt = new Array();
//obj de preload
var objImgPre = new Array();
//pagina relativa que esta mostrando
var index = new Array();
//pagina absoluta que esta mostrando
var indexTotal = new Array();
//Articulos actuales
var datos = new Array();
var datosSig = new Array();
var datosAnt = new Array();
//el total a nivel pagina x categoria
var total = new Array();
//el total real de articulos por categoria
var totalNro = new Array();
//captura de eventos para posición del mouse
var IE = document.all?true:false;
if (!IE) document.captureEvents(Event.MOUSEMOVE);
document.onmousemove = posicRatonXY;
var posicX = 0;
var posicY = 0;
var posicXAnt = 0;
var posicYAnt = 0;
//direcciones
var direccion = new Array();
//Resetea todas las variables al defecto, se utiliza para cambios de filtro-orden
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
		var aux = '#siguiente' + idsCat[i];
		$(aux).get(0).href = f;
		aux = '#siguiente' + idsCat[i] + 'DIV';
		$(aux).get(0).className = 'mesaSiguiente';
		aux = '#anterior' + idsCat[i];
		$(aux).get(0).href = 'javascript:nada()';
		aux = '#anterior'+idsCat[i]+'DIV';
		$(aux).get(0).className = 'mesaAnteriorDeshabilitada';
	}
	direccion = new Array();
	for (i =0; i<idsCat.length; i++) {
		direccion[idsCat[i]] = "SIG";
	}
}
/*se ejecuta ante un cambio de criterio de visualizacion de articulos de la mesa*/
function cambioDeFiltroOrden() {
	var aux = '#mostrarTiempo';
	if ($(aux).get(0).innerHTML != '') {
		for (i=0; i<idsCat.length; i++) {
			aux = '#cat' + idsCat[i] + 'Disabled';
			$(aux).get(0).style.display="";
			aux = '#anterior'+idsCat[i];
			$(aux).get(0).href = 'javascript:nada()';
			aux = '#anterior'+idsCat[i]+'DIV';
			$(aux).get(0).className = 'mesaAnteriorDeshabilitada';
		}
		$('#ctrlDisabled').get(0).style.display="";
		var cboF = hasFiltros.get(orden);
		for (i=0; i<cboF.length; i++) {
			aux = '#mostrarTiempo';
			if (cboF[i][1] == $(aux).get(0).innerHTML) {
				filtro = cboF[i][0];
			}
		}
		getTotal();
	}
}
//datos de articulo para tarjeta
function getArticulo(idArticulo) {
	$.getJSON('/contenidosEstaticos/articulos/' + (Math.floor(idArticulo/1000) * 1000) + '/jsonNVL1_' + idArticulo + '.html',
		function(obj){
			setArticulo(obj.Articulo);
			articulo.put(idArticulo, obj.Articulo);
		}
	);
}
/*FIN PETICIONES AL SERVER*/
/*precarga inicial de imagen ejecuta on preload*/
function cargarImgInicial(idCat, arrIMG, arrDatos) {
	var i;
	for (i=0; i<arrDatos[idCat].length; i++) {
		arrIMG[idCat][i] = "http://img-tmk.tematika.com/tapas/sitio/" + arrDatos[idCat][i] + "c0.jpg";
	}
	objImgPre[idCat] =  arrIMG[idCat];
	onPreload(idCat);
}
/*precarga de imagen no ejecuta funcion al terminar*/
function cargarImg(idCat, arrIMG, arrDatos) {
	//alert("cargarImg(idCat, arrIMG, arrDatos)");
	var i;
	for (i=0; i<arrDatos[idCat].length; i++) {
		arrIMG[idCat][i] = "http://img-tmk.tematika.com/tapas/sitio/" + arrDatos[idCat][i] + "c0.jpg";
	}
//	objImgPre[idCat] =  new ImagePreloader(arrIMG[idCat], nada, idCat);
	objImgPre[idCat] = arrIMG[idCat];
}
function nada() {}
/*seteos necesarios luego de precarga inicial de imagen*/
function onPreload(idCat) {
	var aux = '#cat' + idCat + 'Disabled';
	setMesa(idCat);
	$(aux).get(0).style.display="none";
	//$('cat' + idCat + 'Disabled').style.display="none";
}
/*setea la mesa por categoria*/
function setMesa(idCategoria) {
	var datMesa = "";
	var inicio = (index[idCategoria]-1) * tamView[idCategoria];
	var fin = (index[idCategoria]) * tamView[idCategoria];
	var i;
	var itm =1;
	var aux;
	for (i=inicio; i<fin; i++) {
		if (datos[idCategoria][i] != undefined) {
			aux = "#itm" + idCategoria + "-" + itm;
			$(aux).get(0).src = imgPre[idCategoria][i];
			$(aux).get(0).idArticulo = datos[idCategoria][i];
			var auxi;
			try {
				//if(idCategoria == 4) {
					auxi = "#aitm" + idCategoria + "-" + itm;
					$(auxi).get(0).href = "http://www.tematika.com/articulo/detalleArticulo.jsp?idArticulo=" + datos[idCategoria][i];
				//}
			} catch (e) {}
			if (datos[idCategoria][i] == 0) {
				$(aux).get(0).src = "/tapas/adicionales/blc_" + idCategoria + ".jpg";
				try {
					//if(idCategoria==4){
						auxi = "#aitm" + idCategoria + "-" + itm;
						$(auxi).get(0).href = "#";
					//}
				} catch (e) {}
			}
			} else {
				auxi = "#aitm" + idCategoria + "-" + itm;
				$(auxi).get(0).href = "#"; 
				$(aux).get(0).src = '/tapas/adicionales/blc_'+ idCategoria+ '.jpg';
				$(aux).get(0).idArticulo = 0;
			}
		itm++;
		aux = '#ctrlDisabled';
		$(aux).get(0).style.display="none";
	}
	//$('ctrlDisabled').style.display="none";
}
//mueve la mesa a la siguiente pagina por categoria
function siguiente(idCategoria) {
	var aux;	
	if (index[idCategoria] == chPagina) {
			datos[idCategoria] = new Array();
			imgPre[idCategoria] = new Array();
			for (i=0; i<datosSig[idCategoria].length; i++) {
				datos[idCategoria][i] = datosSig[idCategoria][i];
				imgPre[idCategoria][i] = imgPreSig[idCategoria][i];
			}
			index[idCategoria]=0;
	}
	aux =  '#anterior'+idCategoria + 'DIV';
	$(aux).get(0).className = 'mesaAnterior';
	aux =  '#anterior'+idCategoria;
	$(aux).get(0).href='javascript:anterior(' + idCategoria + ')';
	//if ((indexTotal[idCategoria])+1 == total[idCategoria]) {
	if ((indexTotal[idCategoria]) +1 == total[idCategoria]) {
		aux = '#siguiente'+idCategoria;
		$(aux).get(0).href = 'javascript:nada();';
		aux = '#siguiente'+idCategoria+'DIV';
		$(aux).className = 'mesaSiguienteDeshabilitada';
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
	actualizarEstadisticaPaginacion(idCategoria);
}
/*mueve la mesa a la pagina anterior por categoria*/
function anterior(idCategoria) {
	var aux;
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
	aux = '#siguiente'+idCategoria+'DIV';
	$(aux).get(0).className = 'mesaSiguiente';
	aux = '#siguiente'+idCategoria;
	$(aux).get(0).href = 'javascript:siguiente(' + idCategoria + ')';
	if (indexTotal[idCategoria]==1) {
		aux =  '#anterior'+idCategoria+ 'DIV';
		$(aux).get(0).className = 'mesaAnteriorDeshabilitada';
		aux = '#anterior'+idCategoria;
		$(aux).get(0).href='javascript:nada()';
	} else {
		retardo('anterior', idCategoria);
		retardo('siguiente', idCategoria);
	}
}
//Setea la mesa luego de elegir siguiente
function setMesaS(idCategoria){
	//alert("setMesaS(idCategoria)");
	var inicio = (index[idCategoria]-1) * tamView[idCategoria];
	var fin = (index[idCategoria]) * tamView[idCategoria];
	var i;
	var itm =1;
	var aux;
	for (i=inicio; i<fin; i++) {
		if (datos[idCategoria][i] != undefined) {
			aux = '#itm' + idCategoria + '-so' + itm;
			$(aux).get(0).src = imgPre[idCategoria][i];
		} else {
			aux = '#itm' + idCategoria + '-so' + itm;
			$(aux).get(0).src = '/tapas/adicionales/blc_1.jpg';
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
	var aux;
	aux = '#itm' + idCategoria + '-io' + itm;
	for (i=inicio; i<fin; i++) {
		$(aux).get(0).style.display = 'block';
		if (datos[idCategoria][i] != undefined) {
			aux = '#itm' + idCategoria + '-io' + itm;
			$(aux).get(0).src = imgPre[idCategoria][i];
		} else {
			$(aux).get(0).src = '/tapas/adicionales/blc_1.jpg';
		}
		itm++;
	}
	mover(-20, 0, idCategoria);
}
//ejecuta el efecto de movimiento de las imagenes de la mesa.
//Segun un desplazamiento definido en px y una cantidad de iteraciones
function mover(desp, it, idCat) {
	var total = Math.abs(300/desp);
	var aux  ;
	if (it == total) {
		setMesa(idCat);
		for (i=1; i<=tamView[idCat]; i++) {
			if (desp>0) {
				aux = '#itm' + idCat + '-so' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)-300) + "px";
				aux = '#itm' + idCat + '-' + i;
				$(aux).get(0).style.top="0px";
			} else {
				aux = '#itm' + idCat + '-io' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)+300) + "px";
				aux = '#itm' + idCat + '-' + i;
				$(aux).get(0).style.top="0px";
			}
		}
	} else {
		it++;
		var funcion = 'mover(' + desp + ',' + it + ',' + idCat + ')';
		window.setTimeout(funcion, 50);
		for (i=1; i<=tamView[idCat]; i++) {
			if (desp>0) {
				aux = '#itm' + idCat + '-so' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)+desp)+"px";
				aux = '#itm' + idCat + '-' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)+desp)+ "px";
			} else {
				aux = '#itm' + idCat + '-io' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)+desp) + "px";
				aux = '#itm' + idCat + '-' + i;
				$(aux).get(0).style.top=(parseInt($(aux).get(0).style.top)+desp)+ "px";
			}
		}
	}
}
/*Produce un retardo definido de 1 segundo luego de presionar el boton siguiente o anterior*/
function retardo(direccion, idCategoria) {
	//alert("retardo(direccion, idCategoria)");
	var obj = $(direccion + idCategoria);
	var aux ;
	var func =  'javascript:' + direccion + '(' + idCategoria + ')';
	if (obj.href != func) {
		obj.href = func;
		aux = '#'+direccion+idCategoria+'DIV';
		$(aux).get(0).className = 'mesa'+direccion.substr(0,1).toUpperCase() +direccion.substr(1,direccion.length);
	} else {
		obj.href = 'javascript:nada()';
		aux = '#'+direccion+idCategoria+'DIV';
		$(aux).className = 'mesa'+direccion.substr(0,1).toUpperCase() +direccion.substr(1,direccion.length)+'Deshabilitada';
		window.setTimeout('retardo("' + direccion + '","' + idCategoria + '")', 1500);
	}
}
/*Muestra la tarjeta del articulo*/
function mostrarGlobo(idArticulo, minX, maxX, minY, maxY) {
	//alert("mostrarGlobo(idArticulo, minX, maxX, minY, maxY)");
	if (posicX > getScreenSize()[0]/2) {
		$('#globoArticuloTop').get(0).className="globoArticuloRightTop";
		$('#globoArticuloBottom').get(0).className="globoArticuloRightBottom";
		$('#globo').get(0).style.left =(posicX-25-345) + "px" ;
	} else {
		$('#globoArticuloTop').get(0).className="globoArticuloTop";
		$('#globoArticuloBottom').get(0).className="globoArticuloBottom";
		$('#globo').get(0).style.left = (posicX-5) + "px" ;
	}

	$('#globo').get(0).style.top = (posicY-5) + "px";
	if (articulo.containsKey(idArticulo)) {
		setArticulo(articulo.get(idArticulo));
	}else {
		getArticulo(idArticulo);
	}
	$('#tiempoEntrega').get(0).style.display='none';
	$('#tiempoEntrega').get(0).style.visibility='hidden';
}
//Permite evaluar luego de un tiempo dado (1 seg) si la posición del cursor se mantiene en los límites de una imagen
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
//Inicia el proceso de muestra de tarjeta de articulo
function articuloPopUp(idArticulo, minX, maxX, minY, maxY) {
	if (idArticulo == 0) {
		return;
	}
	window.clearTimeout(progresoGloboArticulo);
	evaluarPosicion(false, idArticulo, minX, maxX, minY, maxY);
}
//oculta la tarjeta de articulo
function ocultarGlobo(){	
	$('#globo').get(0).style.display='none';
}
//
//setea los datos del articulo en la tarjeta
//cuando se pasa el mouse sobre una tapa.
function setArticulo(objArticulo) {
	//alert("setArticulo(objArticulo)");
	 $('#artTitulo').get(0).innerHTML = objArticulo.titulo;
	 $('#artTitulo').get(0).href = objArticulo.cls_urlDetalle;
	 $('#precioArticulo').get(0).innerHTML = '$ ' + formatCurrency(objArticulo.cls_precio);
	 try {
		 $('#precioArticuloDolar').get(0).innerHTML = '$ ' + formatCurrency(objArticulo.cls_precio_dolar);
		 $('#precioArticuloEuro').get(0).innerHTML = '$ ' + formatCurrency(objArticulo.cls_precio_euro);
	 }catch(e){}
	 if (objArticulo.editor != undefined) {
		 if (objArticulo.categoria_seccion == catLibro || objArticulo.categoria_seccion == catPasatiempo) {
			 $('#editor').get(0).innerHTML = 'Editorial';
		 }
		 if (objArticulo.categoria_seccion == catMusica) {
			 $('#editor').get(0).innerHTML = 'Discográfica';
		 }
		 if (objArticulo.categoria_seccion == catPelicula) {
			 $('#editor').get(0).innerHTML = 'Productora';
		 }
		 $('#artEditor').get(0).innerHTML = objArticulo.editor.nombre;
 		 $('#artEditor').get(0).href = objArticulo.editor.cls_urlBusqueda;
		 $('#trEditor').get(0).style.display='';
	 } else {
		 $('#trEditor').get(0).style.display='none';
	 }
	 $('#artPublicacion').get(0).innerHTML = objArticulo.fecha_alta;
	 $('#artIdioma').get(0).innerHTML = objArticulo.idioma;
	 if (objArticulo.paginas != undefined) {
		 if (objArticulo.categoria_seccion == catLibro || objArticulo.categoria_seccion == catPasatiempo) {
			$('#artPagina').get(0).innerHTML = objArticulo.paginas;
			$('#pagina').get(0).innerHTML = 'Paginas:';
			$('#trPagina').get(0).style.display = '';
		 } else {
		 	if (objArticulo.categoria_seccion == catPelicula) {
		 		$('#artPagina').get(0).innerHTML = objArticulo.paginas;
				$('#pagina').get(0).innerHTML = 'Duraci&oacute;n:';
				$('#trPagina').get(0).style.display = '';
		 	} else {
		 		$('#trPagina').get(0).style.display = 'none';
		 	}
		 }
	 } else {
  		$('#trPagina').get(0).style.display = 'none';
	 }
	 if (objArticulo.formato != undefined && objArticulo.formato.rv_meaning != undefined) {
	 		$('#artFormato').get(0).innerHTML = objArticulo.formato.rv_meaning;
	 	$('#trFormato').get(0).style.display = '';
	 } else {
 		 if (objArticulo.tipoArticulo != undefined && objArticulo.tipoArticulo.descripcion != undefined) {
	 			$('#artFormato').get(0).innerHTML = objArticulo.tipoArticulo.descripcion;
	 		$('#trFormato').get(0).style.display = '';
		 } else {
			 $('#trFormato').get(0).style.display = 'none';
		 }
	}
	if (objArticulo.disponibilidad != undefined && objArticulo.disponibilidad.descripcion != undefined) {
	 	$('#artDisponibilidad').get(0).innerHTML = objArticulo.disponibilidad.descripcion;
	 	$('#trDisponibilidad').get(0).style.display = '';
	 	if (objArticulo.disponibilidad.pedido_especial == 'S') {
		 	$('#trComprar').get(0).style.display = 'none';
		 	$('#trPedir').get(0).style.display = '';
		 	$('#trPedir').get(0).innerHTML = '<a href="#" id="btnPedir"><div class="globoArticuloPedir"></div></a>';
		 	$('#trComprar').get(0).innerHTML = '';
		 	$('#btnPedir').get(0).href ='javascript:carrito_Pedir(' + objArticulo.id_articulo + ')';
		} else {
			$('#trComprar').get(0).style.display = '';
			$('#trComprar').get(0).innerHTML = '<a href="#" id="btnComprar"><div class="globoArticuloComprar"></div></a>';
		 	$('#trPedir').get(0).style.display = 'none';
		 	$('#trPedir').get(0).innerHTML = '';
	 		$('#btnComprar').get(0).href = 'javascript:carrito_AgregarArticulo(' + objArticulo.id_articulo + ')';
		}
	} else {
	 	 $('#trDisponibilidad').get(0).style.display = 'none';
	 	 $('#trComprar').get(0).style.display = 'none';
		 $('#trPedir').get(0).style.display = 'none';
	 }
	 if (objArticulo.masVendidoSeccion != undefined && objArticulo.masVendidoSeccion.orden != undefined) {
		$('#artRanking').get(0).innerHTML = objArticulo.masVendidoSeccion.orden;
	 	$('#trRanking').get(0).style.display = '';
		 } else {
		 	 $('#trRanking').get(0).style.display = 'none';
		 }
	 if (objArticulo.articuloAutor != undefined && objArticulo.articuloAutor.length>0) {
	 	var i;
	 	$('#autor').innerHTML = 'Autor';
	 	if (objArticulo.categoria_seccion == catPelicula) {
	 		$('#autor').get(0).innerHTML ='Director';
	 	}
	 	if (objArticulo.categoria_seccion == catMusica) {
	 		$('#autor').get(0).innerHTML ='Intérprete';
	 	}
	 	$('#artAutor').get(0).innerHTML ='';
	 	$('#trAutor').get(0).style.display = '';

		for (i=0; i<objArticulo.articuloAutor.length && i<3; i++) {
			if (objArticulo.categoria_seccion == catMusica) {
				if (objArticulo.articuloAutor[i].autor.descripcion2 != undefined) {
					$('#artAutor').get(0).innerHTML = $('#artAutor').get(0).innerHTML + objArticulo.articuloAutor[i].autor.descripcion2  + "<br>" ;
				} else {
					$('#artAutor').get(0).innerHTML = $('#artAutor').get(0).innerHTML + objArticulo.articuloAutor[i].autor.descripcion  + "<br>" ;
				}
			} else {
				$('#artAutor').get(0).innerHTML = $('#artAutor').get(0).innerHTML + objArticulo.articuloAutor[i].autor.descripcion  + "<br>" ;
			}
		 	$('#autorURLBusqueda').get(0).href = objArticulo.articuloAutor[i].autor.cls_urlBusqueda;
		}
	 } else {
	 	$('#trAutor').get(0).style.display = 'none';
	 }
	 var cantidadComentario = Math.round(parseInt(objArticulo.cls_cantidadComentario));
	 if (cantidadComentario > 0) {
		 $('#calificacion').get(0).innerHTML = '<span>Calificaci&oacute;n:</span>';
		 var cal = 0;
		 var evaluacion = Math.round(parseInt(objArticulo.cls_evaluacionComentario));
		 for (cal = 1; cal <= evaluacion; cal++) {
			 $('#calificacion').get(0).innerHTML = $('#calificacion').get(0).innerHTML + '<div class="calificacionStar"></div>';
		 }
		 for (i = cal; i <= 5; i++) {
			 $('#calificacion').get(0).innerHTML = $('#calificacion').get(0).innerHTML + '<div class="calificacionStarDes"></div>';
		 }
		 $('#calificacion').get(0).innerHTML = $('#calificacion').get(0).innerHTML + '&nbsp; '
		 	+ '<a href="'+ objArticulo.cls_urlDetalle + '#coment">' + cantidadComentario + '&nbsp;' + ((cantidadComentario>1)?'comentarios':'comentario') + '</a>';
 		$('#calificacion').get(0).style.display = 'block';
     } else {
     	$('#calificacion').get(0).innerHTML = '';
		$('#calificacion').get(0).style.display = 'none';
     }
	 $('#linkDetalleImagen').get(0).href = objArticulo.cls_urlDetalle;
	 $('#urlImagen').get(0).src=objArticulo.cls_urlImagen;
	 $('#linkDetalleInfo').get(0).href = objArticulo.cls_urlDetalle;
	 $('#linkAgregarComentario').get(0).href ='/Comentario?ID_ARTICULO=' + objArticulo.id_articulo;

	 $('#globo').get(0).style.display='';
	 $('#loadArticulo').get(0).style.display ='none';
}
//Carga inicialmente el combo de opciones y filtros
function cargarCbos() {
	$('#orden').get(0).innerHTML = '';
	$('#mostrarRanking').get(0).innerHTML = '';
	for (i=0; i<cboO.length; i++) {
		$('#orden').get(0).innerHTML = $('#orden').get(0).innerHTML
		+ '<li><a id="' + cboO[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboO[i][0] + '\',\'mostrarRanking\',\'orden\');cargarFiltro();">' + cboO[i][1] + '</a></li>';
	}
	var aux = "#"+orden;
	$('#mostrarRanking').get(0).innerHTML = $(aux).get(0).innerHTML;
	$('#filtro').get(0).innerHTML = '';
	$('#mostrarTiempo').get(0).innerHTML = '';
	var cboF = hasFiltros.get(cboO[0][0]);
	for (i=0; i<cboF.length; i++) {
		$('#filtro').get(0).innerHTML = $('#filtro').get(0).innerHTML
			+ '<li><a id="' + cboF[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboF[i][0] + '\',\'mostrarTiempo\',\'orden\');cambioDeFiltroOrden();">' + cboF[i][1] + '</a></li>';
	}
	//filtro = '#'+filtro;
	$('#mostrarTiempo').get(0).innerHTML = document.getElementById(filtro).innerHTML;
}
//carga filtros en base al orden seleccionado
function cargarFiltro() {
	for (i=0; i<cboO.length; i++) {
		if ($('#mostrarRanking').get(0).innerHTML == cboO[i][1]) {
			orden = cboO[i][0];
			break;
		}
	}
	var cboF = hasFiltros.get(orden);
	$('#filtro').get(0).innerHTML = '';
	$('#mostrarTiempo').get(0).innerHTML = cboF[0][1];

	for (i=0; i<cboF.length; i++) {
		$('#filtro').get(0).innerHTML = $('#filtro').get(0).innerHTML
			+ '<li><a id="' + cboF[i][0] + '"  href="javascript:mostrarBuscarPor(\'' + cboF[i][0] + '\',\'mostrarTiempo\',\'orden\');cambioDeFiltroOrden();">' + cboF[i][1] + '</a></li>';
	}
	cambioDeFiltroOrden();
}

function actualizarEstadisticaPaginacion(idSeccion) {
	/*var url = 'par='+Math.random()+ '&idSeccion=' + idSeccion;		
	$.ajax({	
		type:'POST',
		cache:false,
		url: "/ActualizarPaginacion",
		data:url,
		success: function(data) {  }
	});	*/
}

function actualizarPaginacion(idSeccion) {
	/*var url = 'par='+Math.random()+ '&idSeccion=' + idSeccion;
	$.ajax({
		type:'POST',			
		url: '/ActualizarCambioFiltro',
		data: url,
		cache:false,
		success: function(data) {  }
	});*/
}