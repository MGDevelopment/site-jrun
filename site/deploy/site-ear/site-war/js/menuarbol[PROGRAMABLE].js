//eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('7 l=o q(0,0,0,0);7 1c=o q(0,0,0,0);7 w=o q(0,0,0,0);7 x=o q(0,0,0,0);7 E=o q(\'\',\'\',\'\',\'\');7 F=o q(0,0,0,0);7 s=o q(0,0,0,0);7 y=o q(0,0,0,0);r G(g){8(g.f!=\'O\'){7 A=g.9.H("1d");7 G=\'A\'+A[1];7 m=A[1].P(0,1);7 d=A[1].P(0,1);7 c=13(d);7 6=Q(d);8(w[6]==0){7 d=R.S(c);7 e=d.T(\'U\');7 I;V(e,m,s,y,6);I=J(c);w[6]=I;x[6]=I}8(g.f!="14"){8(g.f=="K"){g.f="W";$(G).h.t="15";l[6]++}u{g.f="K";$(G).h.t="L";l[6]--}}8(16(s,6)==0){7 d=R.S(c);7 e=d.T(\'U\');V(e,m,s,y,6)}8(F[6]==0){8(l[6]>0){8(s[6]>=5||y[6]>=4){$(c).h.v=""}u{$(c).h.v="1e"}}u{$(c).h.v=w[6]+"17"}}}}r 1f(g){7 c=\'1g\'+g.9;7 m=18(g.9);7 6=Q(m);7 d=R.S(c);7 e=d.T(\'U\');7 9="";7 X="";7 i=0;8(x[6]==0){x[6]=J(c);w[6]=J(c)}8(g.f==\'19\'){g.f="1h";$(c).h.v="";Y(i;i<e.z;i++){9=e[i].9;X=e[i].h.t;8(9.B(m)==0){8(X.B(\'n\')==0){e[i].h.t=\'15\';8(E[6]==\'\'){E[6]=9}}}}F[6]=1}u{8(g.f!="O"){g.f="19"}Y(i=(e.z)-1;i>0;i--){7 9=e[i].9;8(E[6]!=9){8(9.B(m)==0){7 M=9.H("-");8(M.z=2){7 a=$("Z"+9);7 b=$(9);8(a.f=="W"){8(l[6]>0){l[6]--}}}7 1a=\'Z\'+9;7 N=$(1a);8(N.f!="14"&&N.f!="O"){N.f=\'K\'}e[i].h.t=\'L\'}$(9).h.t=\'L\'}u{e[i].h.t=\'L\';7 M=9.H("-");8(M.z=2){7 a=$("Z"+9);7 b=$(9);8(a.f=="W"){8(l[6]>0){l[6]--}a.f="K"}}j}}8(10(l[6])==0){w[x[6]]++;$(c).h.v=x[6]+"17"}u{$(c).h.v=""}F[6]=0}}r 18(9){7 d="";11(9){k\'1i\':d=1;j;k\'1j\':d=3;j;k\'1k\':d=4;j;k\'1l\':d=5;j}C d}r Q(d){7 6;11(10(d)){k 1:6=0;j;k 3:6=3;j;k 4:6=1;j;k 5:6=2;j}C 6}r J(c){7 D=$(c).h.v;7 6=D.B(\'p\');D=D.P(0,6);C D}r V(e,m,s,y,6){7 12;Y(i=0;i<e.z;i++){9=e[i].9;12=9.H("-");8(12.z==2){8(9.B(m)==0){s[6]++}}u{y[6]++}}}r 13(d){7 c="";11(10(d)){k 1:c=\'1m\';j;k 3:c=\'1n\';j;k 4:c=\'1o\';j;k 5:c=\'1p\';j}C c}r 16(1b,6){C(1b[6]==0?0:1)}',62,88,'||||||pos|var|if|id|||capa|seccion|familia|className|div|style||break|case|cantExpandidos|numSeccion||new||Array|function|cantXSec|display|else|height|esPrimera|auxesPrimera|cantXSubSec|length|hijo|indexOf|return|alto|nombreId|expandido|mostrar|split|hAux|getH|arbolItemMas|none|cant|link|arbolItemF|substring|getPosicion|document|getElementById|getElementsByTagName|DIV|getCantidadPorSeccion|arbolItemMin|esVisible|for|lnk_|parseInt|switch|tamano|getCapa|arbolItem|block|cantidadCargada|px|getSeccion|arbolItemMax|lnk|cantXsec|auxcantExpandidos|_|147px|mostrarTodo|arbol|arbolItemMini|Libros|Pasatiempos|Musica|Peliculas|arbolLibros|arbolPasatiempos|arbolMusica|arbolPeliculas'.split('|'),0,{}))
var cantExpandidos = 	new Array(0,0,0,0);
	var auxcantExpandidos = new Array(0,0,0,0);
	var esPrimera =			new Array(0,0,0,0);//para la funcion que expande de a uno por ves
	var auxesPrimera = 		new Array(0,0,0,0);//para la funcion que expande todas las opciones
	var nombreId = 			new Array('','','','');//guarda el id de la opciones que
	var expandido = 		new Array(0,0,0,0);//indica si la seccion "pos" ha sido expandida o no
	var cantXSec = 			new Array(0,0,0,0);
	var cantXSubSec = 		new Array(0,0,0,0);


	function mostrar(div) {
		if(div.className != 'arbolItemF')
		{
				var hijo = div.id.split("_");
				var mostrar = 'hijo'+hijo[1];//indica el div que se despleara cuando hacemos click en el '+'
				var numSeccion = hijo[1].substring(0,1);
				var seccion = hijo[1].substring(0,1);		//determino que de que seccion se expandio o se contrajo
				var capa = getCapa(seccion);
				var pos =  getPosicion(seccion);

				if(esPrimera[pos] == 0 ) {
					var seccion = document.getElementById(capa);//id y name iguales
					var familia = seccion.getElementsByTagName('DIV');
					var hAux;
					getCantidadPorSeccion(familia,numSeccion,cantXSec,cantXSubSec,pos);//cantidad de familias por seccion se guardan en el array canXsec
					hAux = getH(capa);
					esPrimera[pos] = hAux;
					auxesPrimera[pos] = hAux;//hAux tamaño predeterminaod predeterinado del div de cada seccion
				}
				if(div.className != "arbolItem") {
					if(div.className == "arbolItemMas") {
						div.className = "arbolItemMin";//cambio '+' por el '-'
						document.getElementById(mostrar).style.display = "block";
						cantExpandidos[pos]++;
					}else{
						div.className = "arbolItemMas";//cambio '-' por el '+'
						document.getElementById(mostrar).style.display = "none";
						cantExpandidos[pos]--;
					}
				}
				//veo si se expandio del todo el menu (si se clikeo el boton desplegar todo el menu)
				if(cantidadCargada(cantXSec,pos) == 0){
					var seccion = document.getElementById(capa);//id y name iguales
					var familia = seccion.getElementsByTagName('DIV');
					getCantidadPorSeccion(familia,numSeccion,cantXSec,cantXSubSec,pos);//cantidad de familias por seccion se guardan en el array canXsec
				}
				if(expandido[pos] == 0){
					if(cantExpandidos[pos] > 0 ){
						if(cantXSec[pos] >= 5 || cantXSubSec[pos] >=4){
							document.getElementById(capa).style.height = "";
						}else{
							document.getElementById(capa).style.height = "147px";
						}
					}else{
						document.getElementById(capa).style.height = esPrimera[pos]+"px";
					}
				}
		}
	}


	/*		permite desplagar todas las familias ocultas de una categoria	*/
	function mostrarTodo(div){
		var capa = 'arbol'+div.id;
		var numSeccion = getSeccion(div.id);
		var pos = getPosicion(numSeccion);
		var seccion = document.getElementById(capa);//id y name iguales
		var familia = seccion.getElementsByTagName('DIV');
		var id = "";
		var esVisible = "";
		var i = 0;

		if(auxesPrimera[pos]==0){
			auxesPrimera[pos] = getH(capa);
			esPrimera[pos] = getH(capa);
		}
		//expandir todos
		if(div.className == 'arbolItemMax'){
			div.className = "arbolItemMini";
			document.getElementById(capa).style.height = "";

			for(i; i < familia.length; i++){
				id =  familia[i].id;
				esVisible =  familia[i].style.display;
				if(id.indexOf(numSeccion) == 0) {
					if(esVisible.indexOf('n') == 0) {
						familia[i].style.display = 'block';
						if(nombreId[pos] == ''){//guarda el id primer elemento que se expande para usarlo como referencia cuando se contraigan
							nombreId[pos] = id;
						}
					}
				}
			}
			expandido[pos] = 1;
		//comprimir todos
		}else{
			if(div.className != "arbolItemF")
				div.className = "arbolItemMax";

			for(i = (familia.length)-1; i > 0 ; i--){
				var id =  familia[i].id;
				if(nombreId[pos] != id) {
					if(id.indexOf(numSeccion) == 0) {
						var cant = id.split("-");
						if(cant.length = 2 ) {//quiere decir que no es un hijo
							var a = document.getElementById("lnk_"+id);
							var b = document.getElementById(id);
							if(a.className == "arbolItemMin"){
								if(cantExpandidos[pos] > 0){
									cantExpandidos[pos]--;
								}
							}
						}

						var lnk = 'lnk_'+id;
						var link = document.getElementById(lnk);
						if(link.className != "arbolItem" && link.className != "arbolItemF") {
							link.className = 'arbolItemMas';
						}
						familia[i].style.display = 'none';
					}
					document.getElementById(id).style.display = 'none';
				}else{
					familia[i].style.display = 'none';
					var cant = id.split("-");
						if(cant.length = 2 ) {		//meneja si se expande alguna opcion
							var a = document.getElementById("lnk_"+id);	//cuando ya se hayan expandido todas las opciones.
							var b = document.getElementById(id);
							if(a.className == "arbolItemMin"){
								if(cantExpandidos[pos] > 0){
									cantExpandidos[pos]--;
								}
								a.className = "arbolItemMas";
							}
						}
					break;
				}
			}

			if(parseInt(cantExpandidos[pos]) == 0) {//si no hay expandidos uso heigth original
				esPrimera[auxesPrimera[pos]]++;
				document.getElementById(capa).style.height = auxesPrimera[pos]+"px";
			}else{
				document.getElementById(capa).style.height = "";
			}
		expandido[pos] = 0;
		}
	}




	/***		FUNCIONES UTILITARIAS  	**/
	/*devueve el numero que corresponde a la seccion dependiendo de la descripcion*/
	function getSeccion(id){
		var seccion = "";
		switch(id){
			case 'Libros':		seccion = 1;	break;
			case 'Pasatiempos':	seccion = 3;	break;
			case 'Musica':		seccion = 4;	break;
			case 'Peliculas':	seccion = 5;	break;
		}
		return seccion;
	}

	/***
		retorna la poscicion dentro del array que le corresponde a una seccion
	***/
	function getPosicion(seccion){
		var pos;
		switch(parseInt(seccion)) {
			case 1:	pos=0;break;
			case 3:	pos=3;break;
			case 4:	pos=1;break;
			case 5:	pos=2;break;
		}
		return pos;
	}

	/***
		retorna el valor numerico de height sin 'px;'
	***/
	function getH(capa){
		var alto = document.getElementById(capa).style.height;
		var pos = alto.indexOf('p');
		alto = alto.substring(0,pos);
		return alto;
	}

	/***
		determina la cantidadd e elementos por seccion
	***/
	function getCantidadPorSeccion(familia,numSeccion,cantXSec,cantXSubSec,pos){
		var tamano;
		for(i = 0 ; i < familia.length; i++){
			id =  familia[i].id;
			tamano = id.split("-");
			if(tamano.length == 2 ){
				if(id.indexOf(numSeccion) == 0) {
					cantXSec[pos]++;//obtengo la cantidd de familias que tiene cada seccion
				}
			}else{
				cantXSubSec[pos]++;
			}
		}
	}

	/***
		devuelve la capa de acuerdo a la seccion
	***/
	function getCapa(seccion){
		var capa ="";
		switch(parseInt(seccion)) {
			case 1:	capa='arbolLibros';break;
			case 3:	capa='arbolPasatiempos';break;
			case 4:	capa='arbolMusica';break;
			case 5:	capa='arbolPeliculas';break;
		}
		return capa;
	}

	/* 	retorna 1 si no esta vacio y 0 si lo esta
		usada en la mostrar para determinar si se cargaron las cantidad de familia por seccion
	*/
	function cantidadCargada(cantXsec,pos) {
		return (cantXsec[pos] == 0 ? 0 : 1);
	}