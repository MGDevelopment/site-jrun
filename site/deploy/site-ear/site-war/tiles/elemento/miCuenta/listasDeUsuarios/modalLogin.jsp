<script type="text/javascript" src="/js/jquery-1.4.2.js"></script>
<script type="text/javascript" src="/js/jquery.validate.js"></script>
<script type="text/javascript" src="/js/jquery.metadata.js"></script>
<script type="text/javascript" src="/js/jqueryForm.js"></script>
<script type="text/javascript" src="/js/validationForm.js"></script>

<%--
<script>
$("#frmLogin").validate({
	event: "blur",
	rules: {
		'e_mail': { required: true, email: true },
		'password': "required"
	},
	messages: {
		'password': "Debe ingresar una password",
		'e_mail': "Ingrese una dirección de e-mail válida",
	},
	debug: true,
	errorElement: "label",
	errorContainer: $("#errores"),
	submitHandler: function(form){
		var datos = $('#frmContact').formSerialize();
		$.ajax({
			type: "GET",
			url:"/IniciarSesion",
			contentType: "application/x-www-form-urlencoded",
			processData: false,
			data: datos,
			success: function(data){
				try{
					var obj = jQuery.parseJSON(data);
				}catch(e){						
					$("#divModal").get(0).style.display = 'none';  //html("<strong>La lista se ha guardado correctamente!</strong>");
					$('#divModalOculto').html("<strong>La lista se ha guardado correctamente!</strong>");
					$("#divModalOculto").get(0).style.display = 'block';
					//alert(data);
				}	
			}
		});
	}
});
</script>
--%>

<div class="ventModal-wrapper" id="modalDomLogin" style="display:none;">
	<div class="vModTop">
    	<div class="hModUsrNombre">Login de usuarios</div>
        <a class="hModUsrCerrar" href="javascript:mostrarDiv('modalDomLogin'); javascript:mostrarDiv('modalBack');" title="Cerrar">cerrar</a>
   </div>    
   <div class="vModContent"  id="divModalOculto" style="display:none;"></div>
   <div class="vModContent"  id="divModal">      
    	<div class="cProcFor-wrapper cProcForms">
    		<form id="frmContact">
			<input type="hidden" name="_method" value="POST" />		
				<b><p></p>E-mail:</b>
					<div class="cProcForDom">
        				<input name="e_mail" type="text" class="textField " value="" id="lblE_mail" />
        			</div>
				<b><p></p>Password:</b>
				<div class="cProcForDom" style="font-colo:gray;">
					<input name="password" type="password" class="textField " value="" id="lblPassword" />
				</div>        			
        </div>
        <div style="text-align:center" id="divMensajes">       
        </div>
		<input type="submit"  value="Loguear!" class="groovybutton"/>
	</form>
       <!-- <a href="javascript:enviarForm();" class="vModButton">Crear Lista</a>-->
	</div>
</div>
<div id="modalBack" style="display:none;"></div>
<a href="javascript:mostrarLista();">Crear Lista</a>