var suprimir = new Array("la", "de", "del", "con", "lo", "los", "el", "en", "ante", "por", "este", "esta",
		"estos", "y", "a", "bajo", "contra", "desde", "entre", "hacia", "hasta",
		"para", "segun", "sin", "sobre", "tras", ",", ";", "o", "un", "las", "i", "b", "c", "d", "e", "f",
		"g", "h", "i", "j", "k", "l", "n", "�", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

function searchPrompt(defaultText,cantResultados, treatAsPhrase, textColor, bgColor)
{  	
  var patron = getPatron(defaultText);
  patron = patron.split("-");
  // we can optionally use our own highlight tag values
  if ((!textColor) || (!bgColor)) {
    highlightStartTag = "";
    highlightEndTag = "";
  } else {
	  highlightStartTag = '<h5 class="busqResDest">';
	  highlightEndTag = '</h5>';
  }  
  return highlightSearchTerms(defaultText,cantResultados,patron, highlightStartTag, highlightEndTag);
}

function highlightSearchTerms(searchText,cantResultados,patron,  highlightStartTag, highlightEndTag)
{ 
  var aux = new Array();  
  // creo un vecto de expRegulares
  var vecExp = new Array(patron.length);
  for(var i=0;i < patron.length;i++) {
	  vecExp[i] = new RegExp(patron[i],"gi");
  }
  var cantRes = 0;
  for(cantRes = 0;cantRes < cantResultados;cantRes++) {
	  try {
		  //obtengo el texto que deseo trabajar	  
		  var bodyText = document.getElementById("resultado"+cantRes).innerHTML;
		  try {
			  for(var j=0;j<vecExp.length;j++) {
				  aux = bodyText.match(vecExp[j]);// ontengo todas las coincidencias que pueden aver
				  aux = aux.unique();
				  for (var i = 0; i < aux.length; i++) {
				    bodyText = doHighlight(bodyText,aux[i], highlightStartTag, highlightEndTag);
				  }
		  	  } 
			  document.getElementById("resultado"+cantRes).innerHTML = bodyText;
		  }catch(a) {
			  throw a;
		  }
	  }catch(e) {
		  break;
	  }	  
  }
  return true;
}
/*Elimina los valores duplicados*/
Array.prototype.unique = function( b ) {
	var a = [], i, l = this.length;
	for( i=0; i<l; i++ ) {
	if( a.indexOf( this[i], 0, b ) < 0 ) { 
		a.push( this[i] ); }
	}
	return a;
}; 


function doHighlight(bodyText,searchTerm, highlightStartTag, highlightEndTag){
  var newText = "";
  var i = -1;
  var lcSearchTerm = searchTerm.toLowerCase();
  var lcBodyText = bodyText.toLowerCase();
  while (bodyText.length > 0) {
    i = lcBodyText.indexOf(lcSearchTerm, i+1);    
    if (i < 0) {
      newText += bodyText;
      bodyText = "";
    } else {
      // skip anything inside an HTML tag
      if (bodyText.lastIndexOf(">", i) >= bodyText.lastIndexOf("<", i)) {
        // skip anything inside a <script> block
        if (lcBodyText.lastIndexOf("/script>", i) >= lcBodyText.lastIndexOf("<script", i)) {
          newText += bodyText.substring(0, i) + highlightStartTag + bodyText.substr(i, searchTerm.length) + highlightEndTag;
          bodyText = bodyText.substr(i + searchTerm.length);
          lcBodyText = bodyText.toLowerCase();
          i = -1;
        }
      }
    }
  }
  return newText;
}

// PARAMETRO FALSE SIERVE PARA BUSCAR PALABRAS POR SEPARADO EJ:
//"el codigo" busca y resalta tanto "el" como "codigo", si es true solo busca palabras completas
function getPatron(cadena) {
		var exp = new RegExp("[^0-9-a-z�-�&&\\s]","gi");
		cadena = cadena.replace(exp,' ');
		cadena = getTexto(cadena);
		var aux ='';
		for(var a = 0;a<cadena.length;a++) {
			switch(cadena.charAt(a)) {
				case '�': aux+='a';	break;
				case '�': aux+='e'; break;
				case '�': aux+='i'; break;
				case '�': aux+='o'; break;
				case '�': aux+='u';	break;
				default:
					if(cadena.charAt(a)==' ') {
						while(cadena.charAt(a)== ' ') {
							a++;
						}
						aux+='-';
					}
					aux+=cadena.charAt(a);
			}
		}
		cadena = aux;
		cadena = cadena.replace(/[a]/g,'[a�]');
		cadena = cadena.replace(/[e]/g,'[e�]');
		cadena = cadena.replace(/[i]/g,'[i�]');
		cadena = cadena.replace(/[o]/g,'[o�]');
		cadena = cadena.replace(/[u]/g,'[u�]');
		var a = 0;
		while(cadena.charAt(a)=='-' && a < cadena.length) {
			a++;				
		}
		cadena = cadena.substr(a,cadena.length);	
		if(cadena.charAt(cadena.length-1) == '-')
			cadena = cadena.substr(0,cadena.length-1);
		//return cadena;
		return cadena;
}
/**
 * obtiene el texto sin los caracteres que estan en el array suprimir
 * @param texto original
 * @return texto con las palabas suprimidas
 */
function getTexto(texto) {
	var  aux = texto.split(' ');
	for (var j=0; j<suprimir.length; j++) {
		for (var i=0; i<aux.length; i++) {
			if (aux[i] == suprimir[j]) {
				aux[i] ='';
			}
		}
	}
	var auxTxt = '';
	for (var i=0; i<aux.length; i++) {
		auxTxt = auxTxt + ((!aux[i]=='') ? aux[i] + ' ':'');
	}	
	texto = auxTxt;
	return texto;
}