function crearWidgets(estado){
    var callback = function() {
   		//Popego.API.RemoteAuth.LOCALFILE = "http://localhost:8101/prueba/popego.txt";
        var pra = new Popego.API.RemoteAuth({
            iframe_container_id: "iframe_container",
            iframe_background: "#6BBBCF url(https://colourlovers.com.s3.amazonaws.com/images/patterns/149/149184.png) repeat fixed 0 0",
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
			    	  			//chequeo agragado para la nueva ui, cuando se implemente hay que sacarlo
			    	  			if($("#divBntContinuar")!=null) {
			    	  				$("#divBntContinuar").css("display","block");
			    	  			}
							} else {
								$('#result').get(0).innerHTML = "<p style=\"color:red;\">El usuario <em style='color:red'>&laquo;" + username + "&raquo;</em>  ya está en uso. No se puede asociar a tu cuenta</p>";
			    	  			$("#username").get(0).value='';
				    	  	}
				      	} else {
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
function cancelar() {
	$("#lnkpopego").css("display","block");
	$("#divPopego").css("display","none");
	$("#lnkCancelar").css("display","none");
	$("#divBntContinuar").css("display","none");	
	resetUserName();
}
function modificar(div) {
	 div = '#'+div;
	$(div).get(0).style.display = "block";
}
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
function integrarSocio() {
	$("#username").get(0).value='';
	$.ajax({
		dataType:"json",
		type:'GET',
		url:'/AdministrarIntegracion?param='+Math.random(),
		cahce:false,
		beforeSend:function(data) {
			$("#divMensajes").html("");
			$("#divBntContinuar").css("display","none");
		},
		success:function(data) {
			if(data.Resultado.valor) {
				document.location.href = data.Resultado.targetRedirect;				
			}else{
				$("#result").html("");
				$("#username").get(0).value='';
				$("#result").html("<p style=\"color:red;\">"+data.Resultado.mensaje[0]+"<p>");	
			}
		}
	});
}