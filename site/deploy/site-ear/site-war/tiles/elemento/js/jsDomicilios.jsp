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
			alert('Ingresá un nombre de calle');
			return;
		}

  	    if (isNaN(form.NUMERO.value) || isEmpty(form.NUMERO.value)) {
			form.NUMERO.focus();
			alert('Debés indicar un número');
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
			alert('Seleccioná una provincia de la lista');
			return;
		}

		if (form.ID_LOCALIDAD.value == -1)
		{
			alert('Seleccioná una localidad de la lista');
			return;
		}
		if (isEmpty(form.CP.value)) {
			form.CP.focus();
			alert('Debés indicar un código postal');
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
		
</script>