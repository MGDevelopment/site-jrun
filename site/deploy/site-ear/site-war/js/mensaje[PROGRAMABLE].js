var listaMensaje = null;
var visualizaMensaje = false;
var indiceMensajeActual =0;

function getMensaje() {
	$.ajax({
		type:'GET',
		url: '/GetMensaje',
		cache:false,
		data:'par='+ Math.random(),
		success: function(data) {  
			  var obj= jQuery.parseJSON(data);
		      if (obj.mensajes.lista != undefined) {
				if (obj.mensajes.lista.length > 0) {
					listaMensaje = obj.mensajes.lista;
					getMensajeActual();
				} else {
					$('#msjMin').get(0).style.display='none';
					$('#msjMax').get(0).style.display='none';
				}
			  } else { }
		}
	});
		
	/*new Ajax.Request('/GetMensaje?par=' + Math.random(),
		 { method:'get',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()
		      if (obj.mensajes.lista != undefined) {
				if (obj.mensajes.lista.length > 0) {
					listaMensaje = obj.mensajes.lista;
					getMensajeActual();
				} else {
					$('#msjMin').get(0).style.display='none';
					$('#msjMax').get(0).style.display='none';
				}

//			  	setMensajeUsuario(indiceMensajeActual);
			  } else {

			  }
 			}
 		 }
	);*/
}

function getVisualizaMensaje() {
	//el parametro data :... solo es para evitar el cache
	$.ajax({
		type:'GET',
		cache:false,
		url: "/GetVisualizaMensaje",
		data:'par='+ Math.random(),
		success: function(data) {  
			var obj= jQuery.parseJSON(data);
			visualizaMensaje = obj.respuesta;
			getMensaje();
		}
	});	
	
	/*new Ajax.Request('/GetVisualizaMensaje?par=' + Math.random(),
		 { method:'get',
		   onSuccess: function(transport){
		   		var obj= transport.responseText.evalJSON();
		   		visualizaMensaje = obj.respuesta;
	    		getMensaje();
 			}
 		 }
	);*/
}

function setMensajeUsuario(indice) {
	$('#totalMsg').get(0).innerHTML = listaMensaje.length;
	$('#pagMsg').get(0).innerHTML = 'Mensaje ' + (indice+1) + '/' + listaMensaje.length + ':';
	$('#textoMsgActual').get(0).innerHTML = listaMensaje[indice].texto;
	if (visualizaMensaje) {
		$('#msjMax').get(0).style.display='block';
		$('#msjMin').get(0).style.display='none';
	} else {
		$('#msjMax').get(0).style.display='none';
		$('#msjMin').get(0).style.display='block';

	}

	if (indice == 0) {
		$('#msgAnterior').get(0).href = 'javascript:nada()';
		$('#msgAnterior').get(0).className = 'linkDisabled';
	} else {
		$('#msgAnterior').get(0).href = 'javascript:msgIrAnterior()';
		$('#msgAnterior').get(0).className = 'pnlMsgComandos';
	}

	if (indice == (listaMensaje.length-1)) {
		$('#msgSiguiente').get(0).href = 'javascript:nada()';
		$('#msgSiguiente').get(0).className = 'linkDisabled';
	} else {
		$('#msgSiguiente').get(0).href = 'javascript:msgIrSiguiente()';
		$('#msgSiguiente').get(0).className = 'pnlMsgComandos';
	}

	$('#msgLeido').get(0).className = 'pnlMsgComandos';
	$('#msgLeido').get(0).href = 'javascript:setMensajeLeido()';
}

function msgIrAnterior() {
	indiceMensajeActual--;
	setMensajeUsuario(indiceMensajeActual);
	setMensajeActual(indiceMensajeActual);
}

function msgIrSiguiente() {
	indiceMensajeActual++;
	setMensajeUsuario(indiceMensajeActual);
	setMensajeActual(indiceMensajeActual);
}


function setVisualizaMensaje(visualiza) {
	$.({
		url: '/SetVisualizaMensaje',
		cache:false,
		data:'par=' + Math.random() + '&visualiza=' + visualiza,
		success:function(data) {
			var obj= jQuery.parseJSON(data);
			visualizaMensaje = visualiza;
		}
	});
	/*
	new Ajax.Request('/SetVisualizaMensaje?par=' + Math.random() + '&visualiza=' + visualiza,
		 { method:'get',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()
			  visualizaMensaje = visualiza;
 			}
 		 }
	);
	*/
}

function setMensajeLeido() {
	$('#msgAnterior').get(0).href = 'javascript:nada()';
	$('#msgAnterior').get(0).className = 'linkDisabled';
	$('#msgSiguiente').get(0).href = 'javascript:nada()';
	$('#msgSiguiente').get(0).className = 'linkDisabled';
	$('#msgLeido').get(0).className = 'linkDisabled';
	$('#msgLeido').get(0).href = 'javascript:nada()';
	var id = listaMensaje[indiceMensajeActual].id;
	if (indiceMensajeActual==(listaMensaje.length-1)) {
		indiceMensajeActual--;
		setMensajeActual(indiceMensajeActual);
	}	
	$.({
		url: '/SetMensajeLeido',
		cache:false,
		data:'par=' + Math.random() + '&id=' + id,
		success:function(data) {
			var obj= jQuery.parseJSON(data);
			getMensaje();
		}
	});
	/*
	new Ajax.Request('/SetMensajeLeido?par=' + Math.random() + '&id=' + id,
		 { method:'get',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()
		      getMensaje();
 			}
 		 }
	);
	*/
}

function setMensajeActual(indice) {
	if (indice != -1) {
		var id = listaMensaje[indice].id;
		
		$.({
			url:'/SetMensajeActual',
			type:'GET',
			data:'par=' + Math.random() + '&id=' + id,
			cache:false,
			success:function(data){
				var obj= jQuery.parseJSON(data);
			}
		});
		/*
		new Ajax.Request('/SetMensajeActual?par=' + Math.random() + '&id=' + id,
			 { method:'get',
			   onSuccess: function(transport){
			      var obj= transport.responseText.evalJSON()
	 			}
	 		 }
		);
		*/
	}
}
function getMensajeActual() {
	$.({
		url:'/GetMensajeActual',
		type:'GET',
		data:'par=' + Math.random() + '&id=' + id,
		cache:false,
		success:function(data){
			var obj= jQuery.parseJSON(data);
			if (obj.respuesta == -1 || !obj.respuesta) {
      			indiceMensajeActual = 0;
		    }else {
		      	for (i=0; i<listaMensaje.length; i++) {
	 			  	if (listaMensaje[i].id == obj.respuesta) {
		 			  	indiceMensajeActual = i;
		 			  	break;
		 			 }
	 			}
 			}
 			  setMensajeUsuario(indiceMensajeActual);
		}
	});	
	/*
	new Ajax.Request('/GetMensajeActual?par=' + Math.random(),
		 { method:'get',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()

		      if (obj.respuesta == -1 || !obj.respuesta) {
      			indiceMensajeActual = 0;
		      } else {
		      	for (i=0; i<listaMensaje.length; i++) {
	 			  	if (listaMensaje[i].id == obj.respuesta) {
		 			  	indiceMensajeActual = i;
		 			  	break;
		 			 }
	 			}
 			  }
 			  setMensajeUsuario(indiceMensajeActual);
 			}
 		 }
	);
	*/
}
