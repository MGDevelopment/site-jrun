
function isBetween(value, min, max) {
	return (isNaN(value) == false  && value >= min && value <= max);
}

function isMail(value) {
	return (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value));
}

function isEmpty(value) {
	return (/^\s*$/.test(value));
}


function isTarjetaValida(tarjeta, min, max) {
	var patron = /[0-9]/;
/*	if (tarjeta.indexOf(" ") >= 0) return 1;
	if (tarjeta.indexOf("-") >= 0) return 1;
	if (tarjeta.indexOf(".") >= 0) return 1;*/
	if (!patron.test(tarjeta)) return 1;
	if (tarjeta.length < min) return 2;
	if (tarjeta.length > max) return 3;
	return 0;
}

function esEntero(valor) {
	return (!isNaN(valor));
}


function cambiarFoco(event, nextfield) {
	var fn;
	if (event.keyCode == 13) {
		fn = nextfield + '.focus()';
		eval(fn);
	}
}

function enviar(event, fn) {
	if (event.keyCode == 13) {
		eval(fn);
	}
}


function cantidadCaracteres(valor, valorInicio, valorFinal)
{
	if ((valor.length >= valorInicio) && (valor.length <= valorFinal))
	{
		return true
	}else{
		return false
	}
}

function esNumeroValido(valor, cantMinima, cantMaxima) {
	return (valor.length >= cantMinima) && (valor.length <= cantMaxima) && (!isNaN(valor));
}

function isDate(objName) {
 	var strDatestyle = "EU";  //European date style
	var strDate;
	var strDateArray;
	var strDay;
	var strMonth;
	var strYear;
	var intday;
	var intMonth;
	var intYear;
	var booFound = false;
	var datefield = objName;
	var strSeparatorArray = new Array("-", " ", "/", ".");
	var intElementNr;
	var err = 0;
	var strMonthArray = new Array(12);
	strMonthArray[0] = "Jan";
	strMonthArray[1] = "Feb";
	strMonthArray[2] = "Mar";
	strMonthArray[3] = "Apr";
	strMonthArray[4] = "May";
	strMonthArray[5] = "Jun";
	strMonthArray[6] = "Jul";
	strMonthArray[7] = "Aug";
	strMonthArray[8] = "Sep";
	strMonthArray[9] = "Oct";
	strMonthArray[10] = "Nov";
	strMonthArray[11] = "Dec";
	strDate = datefield.value;
	if (strDate.length < 1) {
		return true;
	}
	for (intElementNr = 0; intElementNr < strSeparatorArray.length; intElementNr++) {
		if (strDate.indexOf(strSeparatorArray[intElementNr]) != -1) {
			strDateArray = strDate.split(strSeparatorArray[intElementNr]);
			if (strDateArray.length != 3) {
				err = 1;
				return false;
			} else {
				strDay = strDateArray[0];
				strMonth = strDateArray[1];
				strYear = strDateArray[2];
			}
			booFound = true;
		}
	}
	if (booFound == false) {
		if (strDate.length > 5) {
			strDay = strDate.substr(0, 2);
			strMonth = strDate.substr(2, 2);
			strYear = strDate.substr(4);
		}
	}
	if (strYear.length == 2) {
		strYear = '20' + strYear;
	}

	if (strDatestyle == "US") {
		strTemp = strDay;
		strDay = strMonth;
		strMonth = strTemp;
	}
	intday = parseInt(strDay, 10);
	if (isNaN(intday)) {
		err = 2;
		return false;
	}
	intMonth = parseInt(strMonth, 10);
	if (isNaN(intMonth)) {
		for (i = 0; i < 12; i++) {
			if (strMonth.toUpperCase() == strMonthArray[i].toUpperCase()) {
				intMonth = i + 1;
				strMonth = strMonthArray[i];
				i = 12;
			}
		}
		if (isNaN(intMonth)) {
			err = 3;
			return false;
		}
	}
	intYear = parseInt(strYear, 10);
	if (isNaN(intYear)) {
		err = 4;
		return false;
	}
	if (intMonth > 12 || intMonth < 1) {
		err = 5;
		return false;
	}
	if ((intMonth == 1 || intMonth == 3 || intMonth == 5 || intMonth == 7 || intMonth == 8 || intMonth == 10 || intMonth == 12) && (intday > 31 || intday < 1)) {
		err = 6;
		return false;
	}
	if ((intMonth == 4 || intMonth == 6 || intMonth == 9 || intMonth == 11) && (intday > 30 || intday < 1)) {
		err = 7;
		return false;
	}
	if (intMonth == 2) {
		if (intday < 1) {
			err = 8;
			return false;
		}
		if (LeapYear(intYear) == true) {
			if (intday > 29) {
				err = 9;
				return false;
			}
		} else {
			if (intday > 28) {
				err = 10;
				return false;
			}
		}
	}

	return true;
}

function LeapYear(intYear) {
	if (intYear % 100 == 0) {
		if (intYear % 400 == 0) {
			return true;
		}
	} else {
		if ((intYear % 4) == 0) {
			return true;
		}
	}
	return false;
}

function abrirDetalle(idArticulo) {
	window.opener.location = "/articulo/detalleArticulo.jsp?idArticulo="+idArticulo;
	window.opener.focus();
	window.close();
}

function trim(cadena)
{
	for(i=0; i<cadena.length; )
	{
		if(cadena.charAt(i)==" ")
			cadena=cadena.substring(i+1, cadena.length);
		else
			break;
	}

	for(i=cadena.length-1; i>=0; i=cadena.length-1)
	{
		if(cadena.charAt(i)==" ")
			cadena=cadena.substring(0,i);
		else
			break;
	}

	return cadena;
}
