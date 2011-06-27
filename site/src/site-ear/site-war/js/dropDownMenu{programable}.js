// JavaScript Document
var tempo = 10;
function mostrarBuscarPor(filtro, idBuscador, idDropdown) {
	var elementoBusqueda = document.getElementById(idBuscador);
	if (elementoBusqueda != null) {
		elementoBusqueda.innerHTML = document.getElementById(filtro).innerHTML;

	}
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
	
}
function mostrarBuscarPor(filtro, idBuscador, idDropdown,idSeccion,idSeccionPropia,seccionBusqueda) {
	//alert(seccionBusqueda);
	var elementoBusqueda = document.getElementById(idBuscador);
	if (elementoBusqueda != null) {
		elementoBusqueda.innerHTML = document.getElementById(filtro).innerHTML;

	}
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
	$('#idSeccion').value = idSeccion;
	$('#idSeccionPropia').value = idSeccionPropia;
	$('#seccionBusqueda').value = seccionBusqueda;	
	/*alert($('seccionBusqueda').value);
	alert($('idSeccionPropia').value);
	alert($('seccionBusqueda').value);*/
}
/*function desplegarOpciones(idDropdown) {
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'inline';
	}
}*/
function ocultarOpciones(idDropdown) {
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
}

function ocultarOpcionesT(idObjeto) {	
	tempo = setTimeout("ocultarOpciones('"+idObjeto+"')", 200);
}
//para las modificaciones en el buscador 2
function desplegarOpciones(idDropdown) {
	var opciones = document.getElementById(idDropdown);

	if (opciones != null) {
		if(opciones.style.display == 'inline') {
			opciones.style.display = 'none';
		}else{
			opciones.style.display = 'inline';
		}
	}
}