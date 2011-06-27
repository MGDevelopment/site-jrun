function setFileName(theForm, input, valor)
{
	if ( (input == null) || (input == "") ||
		 (valor == null) || (valor == "") )
		return;

	var aspl = valor.split("\\");
	var str;

	document.form.encoding = "multipart/form-data";
	document.form.action = "{POST}abm_det.asp?tabla={TABLA}&id={ROW_ID}&volver={VOLVER}&preset={PRESET}";
	str = "";

	if (aspl.length > 0) {
		str = aspl[aspl.length - 1];
	}
	var p = 'theForm.' + input.substr(2) + '.value="' + str + '"';
	eval(p);
}

function isblank (o)
{
	if (o == null) return true;

	var s;
	s = o.value;

	if ((s == null) || (s == ""))
		return true;

	for (var i=0;i<s.length;i++) {
		var c = s.charAt(i);
		if (o.type == "select")
		{
			if (o.options[o.selectedIndex].value == "") return false;
		} else {
			if ((c != ' ') && (c != '\n') && (c != '\t')) return false;
		}
	}
	return true;
}

/////////////////////////////////////////////////////////////////////
function checkRequiredOK(e)
{
	if (((e.type == "text") ||
		(e.type == "textarea") ||
		(e.type == "password") ||
		(e.type == "select-one")) &&
		!e.optional)
	{
		if (isblank(e) || (e.type == "select-one" && e.value == 0))
		{
			return false;
		}
	}

	return true;
}

function getName(e)
{
	if (e.nombre != null)
		return e.nombre;
	else
		return e.name;
}
/////////////////////////////////////////////////////////////////////
function verify(f)
{
	var msg;
	var empty_fields = "";
	var errors = "";
	var elementoFoco="";

	for (var i=0;i<f.length;i++)
	{
		var e = f.elements[i];
		if (!checkRequiredOK(e))
		{
			if (empty_fields == "")
			{
				elementoFoco = e;
			//	empty_fields = "\n";
			}

			empty_fields += "\n- " + getName(e);
			continue;
		}


		if (e.date && !isblank(e))
		{
			var fec = e.value;
			fec = fec.replace("/", "-");
			fec = fec.replace("/", "-");
			var d = fec.split("-");
			var error;
			error = '';

			if ((e.length < 8) || (d.length != 3) ||
				isNaN(parseFloat(d[0])) ||
				isNaN(parseFloat(d[1])) ||
				isNaN(parseFloat(d[2])) ||
				(d[0] < 1) || (d[0] > 31) ||
				(d[1] < 1) || (d[1] > 12) ||
				(d[2] < 1900)) {

/*				if (errors == "")
				{

					errors = "\n";
				}*/
				errors += "\n- " + "Fecha incorrecta: " + getName(e) + ". El formato es dd-mm-aaaa o dd/mm/aaaa.";
				elementoFoco = e;
			}
		}

		/*agregado mail*/
		if (e.email && !isblank(e)) {
			if (!isMail(e.value)) {
				errors += "\n- " + "Dirección de e-mail incorrecta: " + getName(e) + ". Recuerde que debe contener los caracteres \"@\" y \".\". Ej: micorreo@midominio.com";
				if (elementoFoco == "") {
					elementoFoco = e;
				}
			}
		}
		/*agregado mail*/

		if (e.numeric || (e.min != null) || (e.max != null))
		{
			if (isblank(e)){
				continue;
			}
			var v = parseFloat(e.value);
			if (isNaN(v) ){
				// //
		//		((e.min != null) && (v < e.min)) ||
		//		((e.max != null) && (v > e.max))) {

//				if (errors == "")
//				{
//					errors = "\n";
//				}

				errors += "\n- El campo " + getName(e) + " debe ser numérico.";
				elementoFoco = e;
				if (e.min != null)
					errors += " mayor que " + e.min;
				if (e.max != null && e.min != null)
					errors += " y menor que " + e.max;
				else if (e.max != null)
					errors += " menor que " + e.max;
				errors += ".\n";
			}
		}
	}

	if (!empty_fields && !errors) return true;

	msg = "Se detectaron los siguientes errores. Por favor, verificalos e intentá nuevamente.\n\n";

	if (empty_fields) {
		msg += "Los siguientes campos obligatorios están vacíos: " + empty_fields + "\n";

		//if (errors) msg += "\n";
	}

	msg += errors;
	alert(msg);
	elementoFoco.focus();
	return false;
}

function esFecha(e) {
	if (!isblank(e)) {
		e.value = e.value.replace("/", "-");
		e.value = e.value.replace("/", "-");
		var d = e.value.split("-");
		var error;
		error = '';

		if ((e.length < 8) || (d.length != 3) ||
			isNaN(parseFloat(d[0])) ||
			isNaN(parseFloat(d[1])) ||
			isNaN(parseFloat(d[2])) ||
			(d[0] < 1) || (d[0] > 31) ||
			(d[1] < 1) || (d[1] > 12) ||
			(d[2] < 1900)) {

			return false;
		}
	} else {
		return false;
	}
	return true;
}

function isMail(value) {
	return (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value));
}

function validarTextAreaLength(txarea, digitado, restante, total) {
	tam = txarea.value.length;
	str="";
	str=str+tam;
	document.getElementById(digitado).innerHTML = str;
	document.getElementById(restante).innerHTML = total - str;

	if (tam > total){
		aux = txarea.value;
		txarea.value = aux.substring(0,total);
		document.getElementById(digitado).innerHTML = total
		document.getElementById(restante).innerHTML = 0
	}
}


function presionoEnter(e) {
  tecla = (document.all) ? e.keyCode : e.which;
  if (tecla==13){
  	return true;
  } else {
  	return false;
  }
}

