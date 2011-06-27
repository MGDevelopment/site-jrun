var conn = getAjax();

//se dispara con la accion del usuario de agregar al carrito
function agregarProducto(idArticulo) {
	conn.open('POST', '/AgregarProducto', 'true');
    conn.onreadystatechange = handleResponseCarrito;
    conn.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    conn.setRequestHeader("Connection", "close");
    conn.send("articulo=" + idArticulo + "&home=true");
}

//es el manejador de la respuesta del controlador agregarProducto
function handleResponseCarrito() {
    if(conn.readyState == 4){
		var xml = conn.responseXML;
		var error = xml.getElementsByTagName('error');
		if (error[0].firstChild!= null) {
			setPopUpCarritoSinDisponibilidad(error[0].firstChild.nodeValue, '/imagenes/avionPop.jpg');
			//setPopUp('<span style=\"color:red;\">' + error[0].firstChild.nodeValue + '</span>', 'Aceptar', 'actualizarCarrito();', false, '/imagenes/avionPop.jpg', 50, 50);
			enlarge();
		} else {
			var titulo = xml.getElementsByTagName('titulo');
			var txtTitulo = '';
			if (titulo[0].firstChild!= null) {
				 txtTitulo = titulo[0].firstChild.nodeValue;
			}
			var imagen = xml.getElementsByTagName('imagen');
			var precio = xml.getElementsByTagName('precio');

			var msg = xml.getElementsByTagName('msg');
			var txtMsg = '';
			if (msg[0].firstChild!= null) {
				 txtMsg = msg[0].firstChild.nodeValue;
			}

			setPopUpCarrito(txtTitulo, imagen[0].firstChild.nodeValue, precio[0].firstChild.nodeValue, txtMsg);
			enlarge();
		}
    } else {
    	document.getElementById('importeCarrito').innerHTML =  '';
    	document.getElementById('tablaCarrito').className = 'carritotablaActivo';
    	document.getElementById('imagenCarrito').src = document.getElementById('imagenCarrito').src.replace('b-cerrarcompra.gif', 'b-cerrarcompraActivo.gif');
    	document.getElementById('itemCarrito').innerHTML = 'Cargando...';
  }
}

//se dispara al acceptar del popUp y actualiza los datos del carrito
function actualizarCarrito() {
		var xml = conn.responseXML;
        var item = xml.getElementsByTagName('item');
		document.getElementById('itemCarrito').innerHTML = item[0].firstChild.nodeValue
        var importe = xml.getElementsByTagName('importe');
        if (importe[0].firstChild!= null) {
			document.getElementById('importeCarrito').innerHTML =  importe[0].firstChild.nodeValue
		}
  		var link = xml.getElementsByTagName('link');
  		document.getElementById('linkCarrito').href =  link[0].firstChild.nodeValue
  		document.getElementById('tablaCarrito').className = 'carritotabla';
  		document.getElementById('imagenCarrito').src = document.getElementById('imagenCarrito').src.replace('b-cerrarcompraActivo.gif', 'b-cerrarcompra.gif');
  		closepreview();
		//idTimeOut=window.setTimeout('refrescarCarrito()', 500);
}

// se dispara en la carga de cada pagina
function traerCarrito() {
	conn.open('GET', '/componentes/comunes/responseCarrito.jsp?param=' + Math.random(), 'true');
    conn.onreadystatechange = handleResponseCarritoInicial;
    conn.send(null);
}

// actualiza los datos iniciales del carrito, es el manejador de traer carrito.
function handleResponseCarritoInicial() {
    if(conn.readyState == 4){
		var xml = conn.responseXML;
		var item = xml.getElementsByTagName('item');
		document.getElementById('itemCarrito').innerHTML = item[0].firstChild.nodeValue
        var importe = xml.getElementsByTagName('importe');
        if (importe[0].firstChild!= null) {
			document.getElementById('importeCarrito').innerHTML =  importe[0].firstChild.nodeValue
		}
  		var link = xml.getElementsByTagName('link');
  		document.getElementById('linkCarrito').href =  link[0].firstChild.nodeValue
    } else {
    	document.getElementById('itemCarrito').innerHTML = 'Cargando...';
  }
}