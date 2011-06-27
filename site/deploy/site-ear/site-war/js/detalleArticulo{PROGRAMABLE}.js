/* Esta funcion obtien todos los comentarios para un articulo*/
function verTodosComentarios(idArticulo) {
	idArticulo = $('articulo').value;
	var cantidad = $('cantidad').value;
	new Ajax.Request('/GetComentarioXArticuloAction.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo + '&cantidad=' + cantidad, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divComentarios').innerHTML = '';
				$('divComentarios').innerHTML = transport.responseText;
				lanzarPopego();
			} else {
				$('divComentarios').innerHTML = 'Cargando comentarios!!!';
			}
		}
	});
}
/* Obtiene la evaluacion que tiene un articulo */
function getEvaluacionDeArticulo() {
	var idArticulo = $('articulo').value;
	new Ajax.Request('/GetEvaluacionXArticuloAction.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divEvaluacion').innerHTML = '';
				$('divEvaluacion').innerHTML = transport.responseText;
			} else {
				$('divEvaluacion').innerHTML = 'Cargando evaluacion!!!';
			}
		}
	});
}
/* esta funcion se ejecuta cuando se carga la pantalla para mostrar como maximo 4 comentarios */
function verTodosComentarios1(idArticulo) {
	idArticulo = $('articulo').value;
	var cantidad = 4;
	new Ajax.Request('/GetComentarioXArticuloAction.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo + '&cantidad=' + cantidad, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divComentarios').innerHTML = '';
				$('divComentarios').innerHTML = transport.responseText;
				if(transport.responseText=="")
					$('comentarios').style.display="none";
				lanzarPopego();
			} else {
				$('divComentarios').innerHTML = 'Cargando comentarios!!!';
			}
		}
	});
}
/*funcion que obtiene los datos del modulo extra */
function getModuloExtra() {
	var idSeccion = $('idSeccion').value;
	var precio = $('precio').value;
	var estaDisponible = $('estaDisponible').value;
	new Ajax.Request('/GetModuloExtraAction.do?param=' + Math.random()
			+ '&idSeccion=' + idSeccion + '&precio=' + precio + '&idArticulo='
			+ $('idArticulo').value + '&estaDisponible=' + estaDisponible, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				//alert(transport.responseText);
				$('divModuloExtra').innerHTML = '';
				$('divModuloExtra').innerHTML = transport.responseText;
				//agrego llamado para mostrar el div de las redes sociales
				//getDivRedesSociales();
			} else {
				$('divModuloExtra').innerHTML = 'Cargando comentarios!!!';
			}			
		}
	});
}
function getArticulosRelacionados(idArticulo) {
	idArticulo = $('articulo').value;
	new Ajax.Request('/GetArticulosRelacionadosAction.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				//alert(transport.responseText);
				$('divArticulosRelacionados').innerHTML = '';
				$('divArticulosRelacionados').innerHTML = transport.responseText;
			} else {
				$('divArticulosRelacionados').innerHTML = 'Cargando articulos!!!';
			}
		}
	});
}
/* Ejecuta el script de para poder visualizar las pop card de popegos en el detalle de articulo */
function lanzarPopego(param) {
	if($('scriptPopego') == null){
		setTimeout("lanzarPopego()",1000);
	}else {
		var scriptPopego = $('scriptPopego').innerHTML;
		eval(scriptPopego);
	}
}

function mostrarImagen(path) {
	window.open('/componentes/comunes/detalleTapaNuevo.jsp?path='+path+'&textoH1=', '', 'toolbar=0,status=0,scrollbars=no,resizable=yes,width=30,height=30');
}
/*
function getPrimerCapitulo() {
	var idArticulo = $('articulo').value;
	new Ajax.Request('/asociadas/capitulos/'+idArticulo+'.txt', {
		method : 'get',
		parameters: '',
		encoding:'ISO-8859-1',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divPrimerCapitulo').innerHTML = '';
				$('divPrimerCapitulo').innerHTML = '<br/>'+transport.responseText;
			} else {
				$('divPrimerCapitulo').innerHTML = 'Cargando primer capitulo!!!';
			}
		}
	});
}*/
/**
 * Obtiene los contenidos levantano los estaticos.
 */
function getIndiceDeContenido() {
	var idArticulo = $('articulo').value;
	new Ajax.Request('/asociadas/capitulos/'+idArticulo+'.txt', {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divPrimerCapitulo').innerHTML = '';				
				$('divPrimerCapitulo').innerHTML = '<b/><br />'+transport.responseText;
			} else {
				$('divPrimerCapitulo').innerHTML = 'Cargando primer capitulo!!!';
			}
		}
	});
}

function getPrimerCapitulo() {
	var idArticulo = $('articulo').value;
	new Ajax.Request('/GetPrimerCapitulo.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divPrimerCapitulo').innerHTML = '';
				$('divPrimerCapitulo').innerHTML = '<br/>'+transport.responseText;
			} else {
				$('divPrimerCapitulo').innerHTML = 'Cargando primer capitulo!!!';
			}
		}
	});
}
//Obtiene la/s biografia/s para el articulo
function getBiografia() {
	var idArticulo = $('articulo').value;
	new Ajax.Request('/GetBiografiaByIdArticulo.do?param=' + Math.random()
			+ '&idArticulo=' + idArticulo, {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divBiografia').innerHTML = '';
				$('divBiografia').innerHTML = '<br/>'+transport.responseText;
			} else {
				$('divBiografia').innerHTML = 'Cargando biografia!!!';
			}
		}
	});
}
//agregado para las redes sociales
function getDivRedesSociales() {
	var urlPage = $('urlPage').value;
	var titulo = $('titulParaRedSocial').value;	
	new Ajax.Request('/articulo/componentes/compartir.jsp?param=' + Math.random()
			+ '&urlPage=' + urlPage + '&titulo=' + titulo,{
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('compartir').innerHTML = transport.responseText;
			} 
		}
	});
}
function enviarRecomendacion() {
	
	var frm = document.frmRecomendacion;
	
	var params = Math.random()
	   + '&correoAmigo=' + frm.correoAmigo.value
	   + '&correoPropio=' + frm.correoPropio.value
	   + '&nombrePropio=' + frm.nombrePropio.value
	   + '&urlPage=' + frm.urlPage.value;

	new Ajax.Request('/articulo/enviarRecomendacion.jsp?param=' +params,
		{
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('mensajeLoad').style.display = 'none';
				var obj= transport.responseText.evalJSON();
				if (obj.Resultado.valor) {
					$('exito').style.display = '';

				} else {
					verForm();
					resetForm(false);
					$('mensajeError').innerHTML = '';
					if (obj.Resultado.mensaje != null) {
						for(i=0; i<obj.Resultado.mensaje.length; i++) {
							$('mensajeError').innerHTML = $('mensajeError').innerHTML +
							obj.Resultado.mensaje[i] + '<br>';
						}
						$('mensajeError').style.display = "";
					}
					if (obj.Resultado.campo != null) {
						var campo = eval ('document.frmRecomendacion.' + obj.Resultado.campo[0]);
						campo.focus();
						for(i=0; i<obj.Resultado.campo.length; i++) {
							var campo = eval ('document.frmRecomendacion.' + obj.Resultado.campo[i]);
							campo.style.backgroundColor = "#FF6666";
						}
					}
				}				
			} else {
				$('mensajeLoad').style.display = '';
				$('titulo').style.display = 'none';
				$('frmEnvio').style.display = 'none';
				$('enviar').style.display = 'none';
			}			
		}		
	});	
}
function verForm() {
	$('exito').style.display = 'none';
	$('titulo').style.display = '';
	$('frmEnvio').style.display = '';
	$('enviar').style.display = '';
	$('mensajeError').style.display ='none';
}

function resetForm(borrar) {
	var frm = document.frmRecomendacion;
	for (i=0; i<frm.elements.length; i++) {
		if (frm.elements[i].type == 'text') {
			frm.elements[i].style.backgroundColor = "#ffffff";
			if(borrar) {
				frm.elements[i].value = '';
			}
		}
	}
}

function enviarOtraReco() {
	resetForm(true);
	verForm();

}
//Trae las entrevistas
/*function getEntrevista(idArticulo) {
	idArticulo = $('articulo').value;
	new Ajax.Request('/asociadas/entrevistas/'+idArticulo+'.txt', {
		method : 'get',
		encoding:'ISO-8859-1',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divEnrevista').innerHTML = '';
				$('divEnrevista').innerHTML = transport.responseText;
			} else {
				$('divEnrevista').innerHTML = 'Cargando entrevista!!!';
			}
		}
	});
}
*/
function getEntrevista(idArticulo) {
	idArticulo = $('articulo').value;
	new Ajax.Request('/GetEntrevista.do?idArticulo='+idArticulo+'&param='+Math.random(), {
		method : 'get',
		onSuccess : function(transport) {
			if (transport.readyState == 4) {
				$('divEnrevista').innerHTML = '';
				$('divEnrevista').innerHTML = transport.responseText;
			} else {
				$('divEnrevista').innerHTML = 'Cargando entrevista!!!';
			}
		}
	});
}