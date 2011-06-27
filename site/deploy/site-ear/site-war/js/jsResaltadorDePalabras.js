/*jsResaltadorDePalabras.js*/
//eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('3 U=I L("1l","1m","1n","1o","1p","1q","1r","1s","1t","1u","1v","1w","1x","y","a","1y","1z","1A","1B","1C","1D","1E","1F","1G","1H","1I",",",";","o","1J","1K","i","b","c","d","e","f","g","h","i","j","k","l","n","ñ","o","p","q","r","s","t","u","v","w","x","y","z");C 1L(V,M,1M,Z,10){3 8=11(V);8=8.12("-");m((!Z)||(!10)){A="";B=""}13{A=\'<14 1N="1O">\';B=\'</14>\'}D 15(V,M,8,A,B)}C 15(1P,M,8,A,B){3 4=I L();3 N=I L(8.6);7(3 i=0;i<8.6;i++){N[i]=I 16(8[i],"17")}3 E=0;7(E=0;E<M;E++){18{3 5=19.1a("1b"+E).1c;18{7(3 j=0;j<N.6;j++){4=5.1Q(N[j]);4=4.1d();7(3 i=0;i<4.6;i++){5=1e(5,4[i],A,B)}}19.1a("1b"+E).1c=5}1f(a){1R a;}}1f(e){F}}D 1S}L.1T.1d=C(b){3 a=[],i,l=W.6;7(i=0;i<l;i++){m(a.1g(W[i],0,b)<0){a.1U(W[i])}}D a};C 1e(5,O,A,B){3 P="";3 i=-1;3 1h=O.X();3 J=5.X();Y(5.6>0){i=J.1g(1h,i+1);m(i<0){P+=5;5=""}13{m(5.Q(">",i)>=5.Q("<",i)){m(J.Q("/1i>",i)>=J.Q("<1i",i)){P+=5.1V(0,i)+A+5.R(i,O.6)+B;5=5.R(i+O.6);J=5.X();i=-1}}}}D P}C 11(2){3 1j=I 16("[^0-9-a-zá-ú&&\\\\s]","17");2=2.G(1j,\' \');2=1k(2);3 4=\'\';7(3 a=0;a<2.6;a++){1W(2.H(a)){K\'á\':4+=\'a\';F;K\'é\':4+=\'e\';F;K\'í\':4+=\'i\';F;K\'ó\':4+=\'o\';F;K\'ú\':4+=\'u\';F;1X:m(2.H(a)==\' \'){Y(2.H(a)==\' \'){a++}4+=\'-\'}4+=2.H(a)}}2=4;2=2.G(/[a]/g,\'[aá]\');2=2.G(/[e]/g,\'[eé]\');2=2.G(/[i]/g,\'[ií]\');2=2.G(/[o]/g,\'[oó]\');2=2.G(/[u]/g,\'[uú]\');3 a=0;Y(2.H(a)==\'-\'&&a<2.6){a++}2=2.R(a,2.6);m(2.H(2.6-1)==\'-\')2=2.R(0,2.6-1);D 2}C 1k(S){3 4=S.12(\' \');7(3 j=0;j<U.6;j++){7(3 i=0;i<4.6;i++){m(4[i]==U[j]){4[i]=\'\'}}}3 T=\'\';7(3 i=0;i<4.6;i++){T=T+((!4[i]==\'\')?4[i]+\' \':\'\')}S=T;D S}',62,122,'||cadena|var|aux|bodyText|length|for|patron||||||||||||||if||||||||||||||highlightStartTag|highlightEndTag|function|return|cantRes|break|replace|charAt|new|lcBodyText|case|Array|cantResultados|vecExp|searchTerm|newText|lastIndexOf|substr|texto|auxTxt|suprimir|defaultText|this|toLowerCase|while|textColor|bgColor|getPatron|split|else|h5|highlightSearchTerms|RegExp|gi|try|document|getElementById|resultado|innerHTML|unique|doHighlight|catch|indexOf|lcSearchTerm|script|exp|getTexto|la|de|del|con|lo|los|el|en|ante|por|este|esta|estos|bajo|contra|desde|entre|hacia|hasta|para|segun|sin|sobre|tras|un|las|searchPrompt|treatAsPhrase|class|busqResDest|searchText|match|throw|true|prototype|push|substring|switch|default'.split('|'),0,{}))
var suprimir = new Array("la", "de", "del", "con", "lo", "los", "el", "en", "ante", "por", "este", "esta",
		"estos", "y", "a", "bajo", "contra", "desde", "entre", "hacia", "hasta",
		"para", "segun", "sin", "sobre", "tras", ",", ";", "o", "un", "las", "i", "b", "c", "d", "e", "f",
		"g", "h", "i", "j", "k", "l", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

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
		var exp = new RegExp("[^0-9-a-zá-ú&&\\s]","gi");
		cadena = cadena.replace(exp,' ');
		cadena = getTexto(cadena);
		var aux ='';
		for(var a = 0;a<cadena.length;a++) {
			switch(cadena.charAt(a)) {
				case 'á': aux+='a';	break;
				case 'é': aux+='e'; break;
				case 'í': aux+='i'; break;
				case 'ó': aux+='o'; break;
				case 'ú': aux+='u';	break;
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
		cadena = cadena.replace(/[a]/g,'[aá]');
		cadena = cadena.replace(/[e]/g,'[eé]');
		cadena = cadena.replace(/[i]/g,'[ií]');
		cadena = cadena.replace(/[o]/g,'[oó]');
		cadena = cadena.replace(/[u]/g,'[uú]');
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
