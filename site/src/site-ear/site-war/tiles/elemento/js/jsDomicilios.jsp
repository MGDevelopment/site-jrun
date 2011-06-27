<script type="text/javascript" src="/js/Combo.js"></script>
<jsp:include page="/js/Combos.jsp"></jsp:include>
<script type="text/javascript" src="/js/Validation.js"></script>
<script type="text/javascript" src="/js/validationForm.js"></script>
<script type="text/javascript">
function controlarDomicilios(seMuestra){
	if(seMuestra){
		$('#divFacturacion').get(0).style.display = 'inline';
	}else{
		$('#divFacturacion').get(0).style.display = 'none';
	}
}
</script>
<script type="text/javascript">
	function validarForm(form){
		var form = document.formDomicilio;

		if (isEmpty(form.CALLE.value)) {
			form.CALLE.focus();
			alert('Ingres� un nombre de calle');
			return;
		}

  	    if (isNaN(form.NUMERO.value) || isEmpty(form.NUMERO.value)) {
			form.NUMERO.focus();
			alert('Deb�s indicar un n�mero');
			return;
		}
  	    
  	  	if (!isEmpty(form.PISO.value) && (isNaN(form.PISO.value) || (form.PISO.value.length>4))) {
			form.PISO.focus();
			alert('El piso debe ser un valor numerico no superior a 4 caracteres');
			return;
		}
  	  	
  	  	if (!isEmpty(form.DEPTO.value) && (form.DEPTO.value.length>4)) {
			form.DEPTO.focus();
			alert('El departamento no debe superar los 4 caracteres');
			return;
		}

		if (form.ID_PROVINCIA.value == -1)
		{
			alert('Seleccion� una provincia de la lista');
			return;
		}

		if (form.ID_LOCALIDAD.value == -1)
		{
			alert('Seleccion� una localidad de la lista');
			return;
		}
		if (isEmpty(form.CP.value)) {
			form.CP.focus();
			alert('Deb�s indicar un c�digo postal');
			return;
		}
		
		form.submit();
	}
	function borrarCamposAntesDeMostrar(TIPO_DOMICILIO_A_AGREGAR){
		$('#TIPO_DOMICILIO_A_AGREGAR').get(0).value = TIPO_DOMICILIO_A_AGREGAR;
		var form = document.formDomicilio;
		form.CALLE.value =''
		form.NUMERO.value=''
		form.PISO.value='';
		form.CP.value='';
		form.DEPTO.value='';
		form.EDIFICIO.value='';		
	}
	
	function submitDireccion(form){
		if (!isEmpty(form.COMENTARIO.value)) {
			var valid = " abcdefghijklmnopqrstuvwxyz0123456789����������!�$%&/()=?��\#@";
			var field=form.COMENTARIO;
			var temp;
			for (var i=0; i<field.value.length; i++) {
				temp = "" + field.value.substring(i, i+1);
				if (valid.indexOf(temp.toLowerCase()) == "-1"){
					form.COMENTARIO.focus();
					alert('El comentario debe poseer solo n�meros y letras');
					return false;
				}
			}
		}
		form.submit();
	}
		
</script>