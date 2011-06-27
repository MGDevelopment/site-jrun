//var divLoading = '<div><img src=\"/imagenes/rediseno/imagenes/comun/loading.gif\"></div>';
//var divLoading2 = '<img style=\"padding-left:40%;width:30px;height:30px;\" src=\"/imagenes/rediseno/imagenes/comun/loading.gif\">';
var ultimoDiv = "";
function validarForm(formulario){
	//Defino una variable boleana, si es 0 es false y si es 1 es true
	var retorno = true;
	var elementos = formulario.elements.length;
	for(i=0; i<elementos && retorno; i++){
		if(formulario.elements[i].type=='text' || formulario.elements[i].type=='textarea') {
			//si el elemento definido en la array formulario esta vacio...
			if(formulario.elements[i].value == ""){
				// cambio de color el fondo a rojo y la letra
				formulario.elements[i].style.backgroundColor = '#ff0000';
				formulario.elements[i].style.color = '#ffffff';
				//cambio el valor de la variable boleana porque el campo esta vacio
				retorno = false;
			}else{
				//si el campo esta relleno de texto le cambio el color a verde
				formulario.elements[i].style.backgroundColor = '#ffffff';
				formulario.elements[i].style.color = '#000000';				
			}
		}
	}
	return retorno; 		
}

function enviarForm(nombre){
	var formName = '#'+nombre;
	if(!validarForm($(formName).get(0))){
		return;
	}
	var datos = $(formName).formSerialize();
	$.ajax({
		cache:false,
		type: "Get",
		dataType:"json",
		url:"/CrearListas",
		data: datos,
		beforeSend: function(obj){
		var div = '#divMensajes';
			$(div).get(0).innerHTML = divLoading;
		},			
		success: function(objeto){
			if(typeof objeto.resultado.id_lista!="undefined") {
				//limpio el div de mensajes
				$('#divMensajes').html("");
				//oculto el div de formulario
				$('#frmContact').css("display","none");
				$('#divMensajes').html("Se ha creado su lista, gracias...");
			}else {
				//retorna un resultado que indica que no esta logueado
				if(objeto.resultado.valor){
					//oculto el div de las listas
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
					mostrarDiv('modalDom');				
					mostrarDiv('modalBack');
					limpiarCampoDeForm('frmLogin','#divMensajesLogin')
					mostrarDiv('modalDomLogin');
					mostrarDiv('modalBack');
					ultimoDiv = formName;
				}else{
					//limpio el div de mensajes
					$('#divMensajes').html("");
					//oculto el div de formulario
					$('#frmContact').css("display","none");
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
				}
				/*" +
				"//oculto el div de las listas
				$('#divMensajes').html(objeto.resultado.mensaje[0]);
				mostrarDiv('modalDom');				
				mostrarDiv('modalBack');
				limpiarCampoDeForm('frmLogin','#divMensajesLogin')
				mostrarDiv('modalDomLogin');
				mostrarDiv('modalBack');
				ultimoDiv = formName;
				*/
			}
			
			/*if(objeto.resultado.valor){
				//oculto el div de las listas
				$('#divMensajes').html(objeto.resultado.mensaje[0]);
				mostrarDiv('modalDom');				
				mostrarDiv('modalBack');
				limpiarCampoDeForm('frmLogin','#divMensajesLogin')
				mostrarDiv('modalDomLogin');
				mostrarDiv('modalBack');
				ultimoDiv = formName;
			}else{
				//limpio el div de mensajes
				$('#divMensajes').html("");
				//oculto el div de formulario
				$('#frmContact').css("display","none");
				$('#divMensajes').html("Se ha creado su lista, gracias...");				
			}*/			
		}
	});	
}
/**
 * Postea un comentario sobre un articulo usando en modal en el detalle de articulo.
 * @param nombre
 * @param action
 * @param divMensaje
 * @param divModal
 * @return
 */
function enviarFormComentario(nombre,action,divMensaje,divModal) {
	var formName = '#'+nombre;
	if(!validarForm($(formName).get(0))) {
		return;
	}
	var datos = $(formName).formSerialize();
	datos += '&idArticulo='+$('#idArticulo').get(0).value;
	var mensaje = '#divMensajes'+divMensaje;
	$.ajax({
		cache:false,
		type: "Get",
		dataType:"json",
		url:action,
		data: datos,
		beforeSend: function(obj) {
			$(mensaje).get(0).innerHTML = divLoading;
		},			
		success: function(objeto){
			if(objeto.resultado.valor) {
				$(formName).css("display","none");
				$(mensaje).html("");
				$(mensaje).html(objeto.resultado.mensaje[0]);				
				ultimoDiv = formName;
				//actualizo el carrito, y los comentarios
				getEvaluacionDeArticulo();
				verTodosComentarios1();				
			}else {
				if(objeto.resultado.fallaSistema) {
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
				}else{
					//si no esta logueado, muestro el modal de logueo
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
					mostrarDiv('modalDom'+divModal);
					mostrarDiv('modalBack');
					mostrarDiv('modalDomLogin');
					mostrarDiv('modalBack');
				}
			}			
		}
	});	
}
/**
 * Usado en la UI de crar mensaje dentro de mi cuenta
 * @param nombre (es el nombre del formulario)
 * @param action indica donde se van a enviar los datos (servlet, action strtus etc.)
 * @param divMensaje (donde se van a mostar los mensajes)
 * @param divModal (nombre del modal que en caso de necesitar se usa para poner en modal la ventana)
 * @return
 */
function sendForm(nombre,action,divMensaje,divModal) {
	var formName = '#'+nombre;
	if(!validarForm($(formName).get(0))) {
		return;
	}
	var method = $(formName).get(0).method.value;//METODO DE PETICION DEFINIDO EN CADA FORMULARIO
	var datos = $(formName).formSerialize();
	var mensaje = '#divMensajes'+divMensaje;
	$.ajax({
		cache:false,
		type: method,
		dataType:"json",
		url:action,
		data: datos,
		beforeSend: function(obj) {
			$(mensaje).get(0).innerHTML = divLoading;
		},			
		success: function(objeto){			
			if(typeof objeto.resultado.id_lista!="undefined") {
				//limpio el div de mensajes
				$('#divMensajes').html("");
				//oculto el div de formulario
				$(formName).css("display","none");
				$('#divMensajes').html("Se ha creado su lista, gracias...");
				//si desde donde se envio el from tiene un boton de continuar lo habilito
				/*if($('#btnContinuar')!=null) {
					$('#btnContinuar').css("visibility","visible");
				}*/
				document.location.href = '/miCuenta/listasDeUsuarios/verTodasMisListas.jsp'
			}else {
				//retorna un resultado que indica que no esta logueado
				if(objeto.resultado.valor){
					//oculto el div de las listas
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
					//mostrarDiv('modalDom');				
					//mostrarDiv('modalBack');
					//limpiarCampoDeForm('frmLogin','#divMensajesLogin')
					//mostrarDiv('modalDomLogin');
					//mostrarDiv('modalBack');
					//ultimoDiv = formName;
					document.location.href = '/miCuenta';
				}else{
					//limpio el div de mensajes
					$('#divMensajes').html("");
					//oculto el div de formulario
					$(formName).css("display","none");
					$('#divMensajes').html(objeto.resultado.mensaje[0]);
				}				
			}
		}
	});	
}

function mostrarListaComentario(nombre,divMsj,modal,idArticulo) {
	var formName = '#'+nombre;	
	limpiarCampoDeForm(formName, '#divMensajes'+divMsj);
	//muestro el modal que quiero
	var divModal = 'modalDom'+modal;
	$(formName).css("display","block");
	mostrarDiv(divModal); 
	mostrarDiv('modalBack');		
}

function mostrarLista(nombre) {
	var formName = '#'+nombre;
	//limpio los datos de los text areas y los text.
	/*var radios = $(formName).get(0);
	for(var i=0;i<radios.elements.length;i++){
		if(radios[i].type=='text' || radios[i].type=='textarea') {
			radios[i].value = '';
		}
	}
	//limpio el div de mensajes
	$("#divMensajes").html("");*/
	limpiarCampoDeForm(formName, '#divMensajes');
	$(formName).css("display","block");
	mostrarDiv('modalDom'); 
	mostrarDiv('modalBack');		
}

function getMisListas(indice,idArticulo) {
	var datos = 'indice='+indice+'&idArticulo='+idArticulo+'&param='+Math.random();
	$.ajax({
		cache:false,
		type: "POST",
		dataType:"html",
		url:"/GetListasTmk",
		data: datos,
		beforeSend: function(obj){
			//muestro cargando en el div donde se van a cargar las listas
			var div = '#detalleList'+indice;
			$(div).html("");
			$(div).html(divLoading2);//un cargando mas chiquito
		},			
		success: function(data){
			var divName = '#detalleList'+indice
			$(divName).html(data);
		}
	});	
}
	
function setArticuloEnLista(idArticulo,formName) {
	var datos = getParametros($(formName).get(0));	
	//si datos = '' no se seleccionaron checkbox de listas
	if(datos == '') {
		alert("Seleccione una lista para");
		return ;
	}
	datos = datos + '&idArticulo='+idArticulo;
	$.ajax({
		cache:false,
		type: "Get",
		dataType:"json",
		url:"/SetArticuloEnLista",
		data: datos,
		beforeSend: function(obj){
			mostrarDiv('modalDomListas'); 
			mostrarDiv('modalBack');
			$('#mensajeRetorno').html("");
			$('#mensajeRetorno').html(divLoading);
		},		
		success: function(data){
			$('#mensajeRetorno').html("");
			var men = "";
			if(data.resultado.respuesta.length > 1) {
				men = data.resultado.respuesta[0]+'<br>';
				men += data.resultado.respuesta[1];
			}else{
				men += data.resultado.respuesta[0];
			}
			$('#mensajeRetorno').html(men);				
		}
	});	
}
/*
function getParametros(form) {
    var getstr = "";
    var cantidad = form.cantidadDeListas.value;
    var indice = 0;
	for(var i = 0;i < cantidad;i++) {
		if(form[i].type=='checkbox') {
			if(form[i].checked) {
				getstr += "lista"+indice +"=" + form[i].value + "&";
	            indice++;
			}
		}
	}
	if(indice == 0) {
		getstr = '';
	}else {
		getstr += "cantidadDeListas=" + indice;
	}
    return getstr;  	   
}*/
/**
 * recorre el formulario de las listas y arma los parametros para enviar al servidor.
 * arma solo con los checkbox que se seleccionaron
 * @param form
 * @return
 */
function getParametros(form) {
	    var getstr = "";
	    form = form.getElementsByTagName("input");
	    var cantidad = form.length;
	    var indice = 0;
		for(var i = 0;i < cantidad;i++) {
			if(form[i].type=='checkbox') {
				if(form[i].checked) {
					getstr += "lista"+indice +"=" + form[i].value + "&";
		            indice++;
				}
			}
		}
		if(indice == 0) {
			getstr = '';
		}else {
			getstr += "cantidadDeListas=" + indice;
		}
	    return getstr;  	   
	}
function manejarEvento(e,diva,divb) {
	var tecla = 0;
	  try {
		  tecla = e.keyCode;
	  }catch(e) {
		  tecla = e.which;
	  }
  switch(tecla) {
  	case  27 : {
  		mostrarDiv(diva); 
  		mostrarDiv(divb);
  		break;
  	}
  	case 13: {
  		return true;
  		break;
  	}
  } 
}

function limpiarCampoDeForm(formName,divMensaje) {
	/*limpio los campos*/
	var radios = $(formName).get(0);
	if(radios!=null && radios!='undefined') {
		for(var i=0;i<radios.elements.length;i++){
			if(radios[i].type=='text' || radios[i].type=='password'|| radios[i].type=='textarea') {
				radios[i].value = '';
			}
		}
	}
	$(divMensaje).html("");
}

function iniciarSesion() {
	var datos = $('#frmLogin').formSerialize();
		
	$.ajax({
		type: "POST",
		url:"/IniciarSesion",
		contentType: "application/x-www-form-urlencoded",
		dataType:"json",
		data: datos,
		beforeSend: function(obj) {
			$('#divMensajeLogin').html("");
			$('#divMensajeLogin').html(divLoading);
		},	
		success: function(data) {
			try {
				$('#divMensajeLogin').html("");
				if(data.resultado.valor){
					mostrarDiv('modalDomLogin');
					mostrarDiv('modalBack');
					if(ultimoDiv == '#frmContact') {
						mostrarLista('frmContact');
					}else {
						mostrarListaComentario('frmComentario','Comentario','Comentario',$('#idArticulo').get(0).value);
					}
					//actualizo el carrito
					carrito_ActualizarCarrito();
				}else {
					$('#divMensajeLogin').html(data.resultado.mensaje[0]);
				}
			}catch(e){
				$('#divMensajeLogin').html("Erro interno, por favor reintente el login");
			}	
		}
	});
}

function actualizarComentario(area,idArticulo,idLista) {
	var datos = 'comentario=' +area.value+ '&id_lista='+idLista+ '&id_articulo='+idArticulo;
	
	$.ajax({
		type: "get",
		url:"/ActualizarComentarioArticuloEnLista",
		dataType:"json",
		data: datos,
		beforeSend: function(obj) {			
			//$('#divMensajeLogin').html(divLoading);
		},	
		success: function(obj) {
			if(!obj.resultado.valor){
				alert(obj.resultado.mensaje[0]);
				if(obj.resultado.targetRedirect!=null) {
					document.location.href = obj.resultado.targetRedirect;
				}
			}else{
				//todo bien
			}
		}
	});
}
