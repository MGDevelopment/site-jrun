var hayBusquedaEnProgreso = false;
function pressEnter(event) {
	if (event.keyCode == 13) {
		return true;
	}
}
function buscador_setBusqueda(busSeleccionada, texto, idSeccion,idSeccionPropia,seccionDeBusqueda) {	
	if (texto == '' || texto.length <=2) {
		alert('Por favor ingrese una palabra de 2 o más caracteres.');
		return;
	}
	if(!hayBusquedaEnProgreso) {
		hayBusquedaEnProgreso = true;
		window.location.href ="/SetearBusqueda2?idSeccion=" + idSeccion + "&tipoBusqueda=" +
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
	return str;
}