<script src="/js/imagen.js" type="text/javascript"></script>
<script src="/js/Combo.js" type="text/javascript"></script>
<script src="/js/validationForm.js" type="text/javascript"></script>
<script src="/js/Validation.js" type="text/javascript"></script>
<script src="/js/ajax.js" type="text/javascript"></script>
<script type="text/javascript" src="/js/jqueryForm.js"></script>
<script type="text/javascript" src="/js/equalcolumnsRediseno.js"></script>
<script type="text/javascript">
function iniciarSesion() {
	var datos = $('#frmLogin').formSerialize();
		
	$.ajax({
		cache:false,
		type: "POST",
		url:"/IniciarSesion",
		contentType: "application/x-www-form-urlencoded",
		dataType:"json",
		data: datos,
		beforeSend: function(obj) {
			$('#divMensajeLogin').html("");
			$('#divMensajeLogin').html(divLoading2);
		},	
		success: function(obj) {
			try {
				$('#divMensajeLogin').html("");
				if(obj.resultado.valor){
					$('#divMensajeLogin').html("Sesión aprobada...redireccionando");
					if(obj.resultado.targetRedirect!=null) {
						document.location.href = obj.resultado.targetRedirect;
					}else{
						document.location.href="/miCuenta/modificarSocio.jsp";
					}						
				}else {
					if(typeof(obj.resultado.targetRedirecr) !='undefined'){
						document.location.href = obj.resultado.targetRedirect;
					}	
					$('#divMensajeLogin').html(obj.resultado.mensaje[0]);
				}
			}catch(e){
				$('#divMensajeLogin').html("Error interno, por favor reintente el login");
			}	
		}
	});
}
</script>

<script language="javascript">
	function validarFormCliente() {
		if(isEmpty(document.frmLogin.login.value)) {
			document.frmLogin.login.focus();
			alert('Debés indicar la dirección de e-mail utilizada como usuario de nuestro sitio.');
			return;
		}
		if(isEmpty(document.frmLogin.password.value)) {
			document.frmLogin.password.focus();
			alert('Debés indicar una clave de acceso.');
			return;
		}
		//document.formUsuarioRegistrado.submit();
		iniciarSesion();
	}

	function recuperarClave() {
		document.location = '/miCuenta/recuperarClave.jsp?LOGIN=' + document.frmLogin.login.value;
	}

	function validarFormClienteNuevo() {
		if(isEmpty(document.frmRegistrar.LOGIN.value)) {
			document.frmRegistrar.LOGIN.focus();
			alert('Debés indicar una dirección de e-mail para identificarlo como usuario de nuestro sitio.');
			return;
		}
		//alert("-");
		//Utilizado en MOL
    	 document.location = '/miCuenta/registroSocioTMK.jsp?LOGIN='+ document.frmRegistrar.LOGIN.value;
    	 /*
    	 				   + '&ID_SESSION=' + document.formUsuarioNuevo.ID_SESSION.value
    	 				   + '&PAGE_DBN=' + document.formUsuarioNuevo.PAGE_DBN.value;*/
        //Utilizado en MOL
	}
	//document.frmRegistrar.LOGIN.focus();
</script>
