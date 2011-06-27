function getAjax(){
    var xmlHttp;
	try{ // Firefox, Opera 8.0+, Safari
		xmlHttp=new XMLHttpRequest();
		return xmlHttp;
	}catch (e){// Internet Explorer
		try{
			xmlHttp=new ActiveXObject("Msxml2.XMLHTTP");
			return xmlHttp;
		}catch (e){
			try{
				xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");
				return xmlHttp;
			}catch (e){
				return false;
			}
		}
	}
}

function ejecutarAjax(url, params, method, addPar) {
	//alert(params);
	connAj = getAjax();
	if (method == 'POST') {
		connAj.open(method, url, 'true');
	} else {
		connAj.open(method, url + '?' + params, 'true');
	}

    connAj.onreadystatechange = function () {handle(connAj, addPar)};
    connAj.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

    connAj.setRequestHeader("Connection", "close");
    connAj.send(params);
    return false;
}

function setValues(XML, entidadOK, entidadErr) {
	var entidad = entidadOK;
	var objHTML =  document.getElementById(entidadOK);
	if (XML.getElementsByTagName(entidadOK).length <1) {
//		alert("entro");
		objHTML =  document.getElementById(entidadErr);
		entidad = entidadErr;
	}
	var divs = objHTML.getElementsByTagName("DIV");
	for (i=0; i<divs.length; i++) {
		var tag = XML.getElementsByTagName(divs[i].id);
		if (tag != null && tag.length > 0) {
			divs[i].innerHTML = tag[0].firstChild.nodeValue;
		}
	}
	return entidad;
}

function handleWait(mostrar) {
    var objHTML = document.getElementById('wait');
	var divs = objHTML.getElementsByTagName("DIV");
	if (mostrar) {
		divs[0].innerHTML = "Procesando...";
	} else {
		divs[0].innerHTML = "";
	}
    objHTML.style.display = (mostrar)?'':'none';
}

