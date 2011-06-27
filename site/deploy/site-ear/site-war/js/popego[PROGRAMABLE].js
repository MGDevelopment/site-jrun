function crearWidgets(estado){
    var callback = function() {
   		//Popego.API.RemoteAuth.LOCALFILE = "http://localhost:8101/prueba/popego.txt";
        var pra = new Popego.API.RemoteAuth({
            iframe_container_id: "iframe_container",
            iframe_background: "#6BBBCF url(https://colourlovers.com.s3.amazonaws.com/images/patterns/149/149184.png) repeat fixed 0 0",
            /*
             Cada ves que se presiona el boton de loguear se debe resetear si o si el username por que si se presiona una ves y
             es un user valido se guarda en sesion
            */
            onStart: function(e) {
            	$('#result').get(0).innerHTML ='';
            	$('#divPopego').get(0).style.display = "block";
            	$("#lnkpopego").get(0).style.display = "block";
            	resetUserName();
            },
            onSuccess: function(username, widget_theme) {
            	
            	$.ajax({
            		url:'/RegistrarIntegracion?username='+username+ '&dominio=popego.com&param='+Math.random(),
            		cache:false,
            		type:'POST',
            		success:function(data){
            			var obj = jQuery.parseJSON(data);
            			if (obj.Resultado.valor) {
						    if (obj.Resultado.mensaje == 'Libre') {
			    	  			$("#username").get(0).value = username;
			    	  			$("#lnkpopego").get(0).style.display = "none";
			    	  			$("#lnkCancelar").get(0).style.display = "block";
			    	  			$('#result').get(0).innerHTML = "<b>El usuario <em style='color:red'>&laquo;" + username + "&raquo;</em> de Popego.com es valido.<br/>Cuando continues se asociara a tu cuenta de tematika</b>";
				    	  	/*} else  if(obj.Resultado.mensaje == 'AsociadoAlMismo'){
				    	  		$('result').innerHTML = "<b>El usuario <em style='color:red'>&laquo;" + username + "&raquo;</em> ya esta asociado a tu cuenta.</b>";
				    	  		$("username").get(0).value='';*/
							} else {
								$('#result').get(0).innerHTML = "<b style=\"color:red;\">El usuario <em style='color:red'>&laquo;" + username + "&raquo;</em>  ya está en uso. No se puede asociar a tu cuenta</b>";
			    	  			$("#username").get(0).value='';
				    	  	}
				      	} else {
				      		//si retorna false
				      		if (obj.Resultado.targetRedirect) {
					      		window.location.href = obj.Resultado.targetRedirect;
				      		} else {
				      			if (obj.Resultado.fallaSistema) {
				      				if (obj.Resultado.mensaje != null) {
										$('#mensajeError').get(0).innerHTML = "";
										for(i=0; i<obj.Resultado.mensaje.length; i++) {
											$('#mensajeError').get(0).innerHTML = $('#mensajeError').get(0).innerHTML +
											obj.Resultado.mensaje[i] + '<br>';
										}
										$('#mensajeError').get(0).style.display = "";
										document.location.href = "#anclaMensajeError";
									}
				      			}
				      		}
				      	}
            		}
            	});
            },
            onError: function(description) {
                document.getElementById("result").innerHTML = "<p style='color:red';>No se ha podido autenticar la sesion, verifica tu usuario de popego e intentalo nuevemente.</p>";
                $('#divPopego').get(0).disabled = false;
                $("#username").get(0).value='';
                resetUserName();
            },
            onComplete: function(e) {
            	$('#txtMensaje').get(0).style.display='none';
            }
        });
        var my_button = document.getElementById("lnkpopego");
        my_button.onclick = function() {
            pra.start();
        }
    }

	Popego.use("remote-auth", callback);
}
/*
 Setea la visibilidad del div que tiene el username y el pass de popego
 cuando presione la primera ves el check de completar datos adicionales,
 deja a esPrimeraVes en false, para despues verifiar cada ves que habilita
 o desabilita el ckeck, ver solamente si muestra o no el div y borrar el contenido del
 hidden que guarda el valor del username de popego
*/
function setLoginPopegoVisible(habilitar) {
	if(esPrimeraVes){
		esPrimeraVes = false;
	}else{
		if(habilitar == true){
			$('#username').get(0).value = '';
			$('#divPopego').get(0).style.display = 'block';
		}
		else{
			$('#divPopego').get(0).style.display = 'none';
		}
	}
}
/*
 elimina el valor de la variable username del hidden(cliente),y llama A RegistrarIntegracion
 por post para eliminar el username y el dominio de la sesion
*/
function cancelar() {
	$("#lnkpopego").get(0).style.display = "block";
	$("#divPopego").get(0).style.display='none';
	$("#lnkCancelar").get(0).style.display = "none";
	resetUserName();
}
/*
 permite una ves validado el usuer de popego, modificar en el campo user y pass los valores para loguear con otr
 user, distinto
*/
function modificar(div) {
	 div = '#'+div;
	$(div).get(0).style.display = "block";
}
/*
 Este metodo borra de la sesion los datos de username y dominio.
*/
function resetUserName() {
	$("#username").get(0).value='';
	$.ajax({
		type:'POST',
		url:'/EliminarSessionIntegracion?param='+Math.random(),
		cahce:false,
		success:function(data) {
			$('#username').get(0).value ='';
		}
	});
}
function limpirarResultado(){
	document.getElementById('result').innerHTML='';
}