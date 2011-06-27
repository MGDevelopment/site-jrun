<%--@ page import="com.tmk.kernel.Globals"--%>
<%--@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles"--%>
<%--@ page isErrorPage="true" --%>

<%--request.setAttribute("idSeccion",Globals.SECCION_GENERAL);--%>
<%--<tiles:insert definition="seccion.error.page"/>--%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
	<script type="text/javascript" src="/js/jquery-1.4.2.min.js"></script>
	<title>Tematika.com - eXtra - Consulta de Puntos</title>
<meta name="keywords" content="tematika, eXtra, fidelización, beneficios, consulta, puntos">
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/carrito.css" rel="stylesheet" type="text/css" />	
<link href="/estilos/seccion_tematika.css" rel="stylesheet" type="text/css" /><link href="/estilos/old/seccion_tematikaGeneral.css" rel="stylesheet" type="text/css" /><link href="/estilos/old/seccion_inicio.css" rel="stylesheet" type="text/css" /><link href="/estilos/old/seccion_tematika.css" rel="stylesheet" type="text/css" /><link href="/estilos/old/comun.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">var ieversion=/*@cc_on function(){ switch(@_jscript_version){ case 1.0:return 3; case 3.0:return 4; case 5.0:return 5; case 5.1:return 5; case 5.5:return 5.5; case 5.6:return 6; case 5.7:return 7; }}()||@*/0;
if (ieversion == 6 || ieversion == 5.5) {document.write('<link href="/estilos/ie6.css" rel="stylesheet" type="text/css" />');}
</script>

<script type="text/javascript">

var tempo = 10;
function mostrarBuscarPor(filtro, idBuscador, idDropdown) {
	var elementoBusqueda = document.getElementById(idBuscador);
	if (elementoBusqueda != null) {
		elementoBusqueda.innerHTML = document.getElementById(filtro).innerHTML;
	}
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
}
function mostrarBuscarPor(filtro, idBuscador, idDropdown,idSeccion,idSeccionPropia,seccionBusqueda) {
	//alert(seccionBusqueda);
	var elementoBusqueda = document.getElementById(idBuscador);
	if (elementoBusqueda != null) {
		elementoBusqueda.innerHTML = document.getElementById(filtro).innerHTML;
	}
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
	document.getElementById('idSeccion').value =idSeccion;
	document.getElementById('idSeccionPropia').value =idSeccion;
	document.getElementById('seccionBusqueda').value =idSeccion;	
}
function ocultarOpciones(idDropdown) {
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		opciones.style.display = 'none';
	}
}
function ocultarOpcionesT(idObjeto) {	
	tempo = setTimeout("ocultarOpciones('"+idObjeto+"')", 200);
}
//para las modificaciones en el buscador 2
function desplegarOpciones(idDropdown) {
	var opciones = document.getElementById(idDropdown);
	if (opciones != null) {
		if(opciones.style.display == 'inline') {
			opciones.style.display = 'none';
		}else{
			opciones.style.display = 'inline';
		}
	}
}
function correctHeights(div1,div2,div3,div4,div5,div6,div7,div8,div9,div0) {
var ddequalcolumns=new Object();
ddequalcolumns.columnswatch=[div1,div2,div3,div4,div5,div6,div7,div8,div9,div0];
ddequalcolumns.setHeights=function(reset){
	var tallest=0;
	var resetit=(typeof reset=="string")? true : false;
	for (var i=0; i<this.columnswatch.length; i++){
		if (document.getElementById(this.columnswatch[i])!=null){
			if (resetit) {
				document.getElementById(this.columnswatch[i]).style.height="auto";
			}	
			if (document.getElementById(this.columnswatch[i]).offsetHeight>tallest) {
				tallest=document.getElementById(this.columnswatch[i]).offsetHeight;
			}	
		}
	}
	if (tallest>0){
		for (var i=0; i<this.columnswatch.length; i++){
			if (document.getElementById(this.columnswatch[i])!=null) {
				if (document.getElementById(this.columnswatch[i]).offsetHeight < tallest) {
					document.getElementById(this.columnswatch[i]).style.height=tallest+"px";
				}
			}	
		}
	}
}
ddequalcolumns.resetHeights=function(){
	this.setHeights("reset");
}
ddequalcolumns.dotask=function(target, functionref, tasktype){ 
	var tasktype=(window.addEventListener)? tasktype : "on"+tasktype;
	if (target.addEventListener) {
		target.addEventListener(tasktype, functionref, false);
	}	
	else { if (target.attachEvent) {
		target.attachEvent(tasktype, functionref);
	}	
	}
}
ddequalcolumns.dotask(window, function(){ddequalcolumns.setHeights()}, "load");
};
correctHeights("arbolLibros", "arbolMusica", "arbolPeliculas", "arbolPasatiempos","","","","","","");
correctHeights("panelSeccSucursales", "panelSeccQuid", "seccionTematika", "panelSeccExtra","panelSeccMusica","panelSeccLibros","panelSeccPeliculas","panelSeccPasatiempos","","");
correctHeights("calleSeparadorComents", "calleLibrosComents", "callePeliculasComents", "calleMusicaComents","callePasatiemposComents","calleSeparadorComents2","calleSeparadorComents3","","","");
correctHeights("comentarios01", "comentarios02", "comentarios03", "comentarios04","","","","","","");
correctHeights("calleSeparadorListas", "calleLibrosListas", "callePeliculasListas", "calleMusicaListas","callePasatiemposListas","calleSeparadorListas2","calleSeparadorListas3","","","");
correctHeights("calleSeparadorUsuarios", "calleLibrosUsuarios", "callePeliculasUsuarios", "calleMusicaUsuarios","callePasatiemposUsuarios","calleSeparadorUsuarios2","calleSeparadorUsuarios3","","","");
correctHeights("calleComents01", "ccalleComents02", "calleComents03", "calleSeparadorComents","calleSeparadorComents2","","","","","");
correctHeights("calleComents04", "ccalleComents05", "calleComents06", "calleSeparadorComents3","calleSeparadorComents4","","","","","");
correctHeights("comentarios01", "comentarios02", "comentarios03", "","","","","","","");
correctHeights("comentarios04", "comentarios05", "comentarios06", "","","","","","","");
correctHeights("dTopRight", "dTopLeft", "", "","","","","","","");
correctHeights("calleLibrosComents2","callePeliculasComents2","calleMusicaComents2","callePasatiemposComents2","calleSeparadorComents4","calleSeparadorComents5","calleSeparadorComents6","","","");
correctHeights("comentarios02", "comentarios03", "comentarios04", "comentarios05","","","","","","");
correctHeights("calleLibrosComents3","callePeliculasComents3","calleMusicaComents3","callePasatiemposComents3","calleSeparadorComents7","calleSeparadorComents8","calleSeparadorComents9","","","");
correctHeights("comentarios06", "comentarios07", "comentarios08", "comentarios09","","","","","","");
correctHeights("calleLibrosComents4","callePeliculasComents4","calleMusicaComents4","callePasatiemposComents4","calleSeparadorComents10","calleSeparadorComents11","calleSeparadorComents12","","","");
correctHeights("comentarios10", "comentarios11", "comentarios12", "comentarios13","","","","","","");
correctHeights("calleLibrosComents5","callePeliculasComents5","calleMusicaComents5","callePasatiemposComents6","calleSeparadorComents13","calleSeparadorComents14","calleSeparadorComents15","","","");
correctHeights("comentarios14", "comentarios15", "comentarios16", "comentarios17","","","","","","");
eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('7 o=r s(0,0,0,0);7 1c=r s(0,0,0,0);7 y=r s(0,0,0,0);7 z=r s(0,0,0,0);7 G=r s(\'\',\'\',\'\',\'\');7 H=r s(0,0,0,0);7 u=r s(0,0,0,0);7 A=r s(0,0,0,0);t I(j){8(j.h!=\'Q\'){7 C=j.9.J("1d");7 I=\'C\'+C[1];7 q=C[1].R(0,1);7 d=C[1].R(0,1);7 c=13(d);7 6=S(d);8(y[6]==0){7 d=e.f(c);7 g=d.T(\'U\');7 K;V(g,q,u,A,6);K=L(c);y[6]=K;z[6]=K}8(j.h!="14"){8(j.h=="M"){j.h="W";e.f(I).k.v="15";o[6]++}w{j.h="M";e.f(I).k.v="N";o[6]--}}8(16(u,6)==0){7 d=e.f(c);7 g=d.T(\'U\');V(g,q,u,A,6)}8(H[6]==0){8(o[6]>0){8(u[6]>=5||A[6]>=4){e.f(c).k.x=""}w{e.f(c).k.x="1e"}}w{e.f(c).k.x=y[6]+"17"}}}}t 1f(j){7 c=\'1g\'+j.9;7 q=18(j.9);7 6=S(q);7 d=e.f(c);7 g=d.T(\'U\');7 9="";7 X="";7 i=0;8(z[6]==0){z[6]=L(c);y[6]=L(c)}8(j.h==\'19\'){j.h="1h";e.f(c).k.x="";Y(i;i<g.B;i++){9=g[i].9;X=g[i].k.v;8(9.D(q)==0){8(X.D(\'n\')==0){g[i].k.v=\'15\';8(G[6]==\'\'){G[6]=9}}}}H[6]=1}w{8(j.h!="Q")j.h="19";Y(i=(g.B)-1;i>0;i--){7 9=g[i].9;8(G[6]!=9){8(9.D(q)==0){7 O=9.J("-");8(O.B=2){7 a=e.f("Z"+9);7 b=e.f(9);8(a.h=="W"){8(o[6]>0){o[6]--}}}7 1a=\'Z\'+9;7 P=e.f(1a);8(P.h!="14"&&P.h!="Q"){P.h=\'M\'}g[i].k.v=\'N\'}e.f(9).k.v=\'N\'}w{g[i].k.v=\'N\';7 O=9.J("-");8(O.B=2){7 a=e.f("Z"+9);7 b=e.f(9);8(a.h=="W"){8(o[6]>0){o[6]--}a.h="M"}}l}}8(10(o[6])==0){y[z[6]]++;e.f(c).k.x=z[6]+"17"}w{e.f(c).k.x=""}H[6]=0}}t 18(9){7 d="";11(9){m\'1i\':d=1;l;m\'1j\':d=3;l;m\'1k\':d=4;l;m\'1l\':d=5;l}E d}t S(d){7 6;11(10(d)){m 1:6=0;l;m 3:6=3;l;m 4:6=1;l;m 5:6=2;l}E 6}t L(c){7 F=e.f(c).k.x;7 6=F.D(\'p\');F=F.R(0,6);E F}t V(g,q,u,A,6){7 12;Y(i=0;i<g.B;i++){9=g[i].9;12=9.J("-");8(12.B==2){8(9.D(q)==0){u[6]++}}w{A[6]++}}}t 13(d){7 c="";11(10(d)){m 1:c=\'1m\';l;m 3:c=\'1n\';l;m 4:c=\'1o\';l;m 5:c=\'1p\';l}E c}t 16(1b,6){E(1b[6]==0?0:1)}',62,88,'||||||pos|var|if|id|||capa|seccion|document|getElementById|familia|className||div|style|break|case||cantExpandidos||numSeccion|new|Array|function|cantXSec|display|else|height|esPrimera|auxesPrimera|cantXSubSec|length|hijo|indexOf|return|alto|nombreId|expandido|mostrar|split|hAux|getH|arbolItemMas|none|cant|link|arbolItemF|substring|getPosicion|getElementsByTagName|DIV|getCantidadPorSeccion|arbolItemMin|esVisible|for|lnk_|parseInt|switch|tamano|getCapa|arbolItem|block|cantidadCargada|px|getSeccion|arbolItemMax|lnk|cantXsec|auxcantExpandidos|_|147px|mostrarTodo|arbol|arbolItemMini|Libros|Pasatiempos|Musica|Peliculas|arbolLibros|arbolPasatiempos|arbolMusica|arbolPeliculas'.split('|'),0,{}))
eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('i 9=u;b v(j){c(j.w==x){a d}}b y(e,0,5,6,7){c(0==\'\'||0.z<=2){A(\'B C D E F G 2 o más H.\');a}c(!9){9=d;k.l.n="/p?5="+5+"&q="+e+"&0="+0+"&6="+6+"&7="+7+""}r{a}}b I(e,0,5,6,7){c(!9){9=d;k.l.n="/p?5="+5+"&q="+e+"&0="+0+"&6="+6+"&7="+7+"&J=d"}r{a}}b K(t){i 8;L(t){h 1:8=\'f M\';g;h 3:8=\'f N\';g;h 4:8=\'f O\';g;P:8=\'f Q\';g}a 8}',53,53,'texto|||||idSeccion|idSeccionPropia|seccionDeBusqueda|str|hayBusquedaEnProgreso|return|function|if|true|busSeleccionada|En|break|case|var|event|window|location||href||SetearBusqueda2|tipoBusqueda|else||id|false|pressEnter|keyCode|13|buscador_setBusqueda|length|alert|Por|favor|ingrese|una|palabra|de|caracteres|buscador_setBusqueda2|mantenerIds|getSeccion|switch|Libros|Pasatiempos|Musica|default|Peliculas'.split('|'),0,{}))
eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('a T(5,u){5.U(5.6.9);d i;E(i=0;i<u.9;i++){5.6[5.6.9-1].V(i);7(u[i]){5.6[5.6.9-1].v[i].F=u[i]}h{5.6[5.6.9-1].v[i].F="&W;"}5.6[5.6.9-1].v[i].G=5.6[0].v[i].G}}a X(5){y(5.6.9>1){5.Y(5.6.9-1)}}a Z(w,H){7(w.11==13){12("("+H+")")}}a 14(2){2=2.I().15(/\\$|\\,/g,\'\');7(16(2)){2=0}d J=(2==(2=x.17(2)));2=x.z(2*A+0.18);k=2%A;2=x.z(2/A).I();7(k<10){k=\'0\'+k}E(d i=0;i<x.z((2.9-(1+i))/3);i++){2=2.K(0,2.9-(4*i+3))+\',\'+2.K(2.9-(4*i+3))}c(((J)?\'\':\'-\')+2+\'.\'+k)}a 19(e){1a=l;1b=m;7(1c){l=w.1d+8.f.n;m=w.1e+8.f.o}h{l=e.1f;m=e.1g}7(l<0){l=0}7(m<0){m=0}c L}a 1h(b){d j=0;y(b!=M){j+=b.1i;b=b.N}c j}a 1j(b){d j=0;y(b!=M){j+=b.1k;b=b.N}c j}a 1l(){d p=0,q=0;7(1m(B.O)==\'1n\'){q=B.O;p=B.1o}h 7(8.s&&(8.s.n||8.s.o)){q=8.s.o;p=8.s.n}h 7(8.f&&(8.f.n||8.f.o)){q=8.f.o;p=8.f.n}c[p,q]}a 1p(){c[P.1q,P.1r]}a 1s(t,C,D){7(t.Q){t.Q(C,D,R);c L}h 7(t.S){d r=t.S("1t"+C,D);c r}h{c R}}',62,92,'||num|||tbl|rows|if|document|length|function|oElement|return|var||documentElement||else||iReturnValue|centavos|posicX|posicY|scrollLeft|scrollTop|scrOfX|scrOfY||body|obj|datos|cells|event|Math|while|floor|100|window|evType|fn|for|innerHTML|align|funcion|toString|signo|substring|true|null|offsetParent|pageYOffset|screen|addEventListener|false|attachEvent|addRow|insertRow|insertCell|nbsp|deleteRows|deleteRow|presionarEnter||keyCode|eval||formatCurrency|replace|isNaN|abs|50000000001|posicRatonXY|posicXAnt|posicYAnt|IE|clientX|clientY|pageX|pageY|getY|offsetTop|getX|offsetLeft|getScrollXY|typeof|number|pageXOffset|getScreenSize|width|height|addEvent|on'.split('|'),0,{}))
function carrito_AgregarArticulo(idArticulo) {	
	$('#modalBack').get(0).style.display = 'block';
	var param = 'idArticulo=' + idArticulo;	
	$.ajax({
		url: '/AgregarArticulo?'+param,
		type:'POST',
		cache:false,
		success: function(data) {
			var obj = jQuery.parseJSON(data);
			carrito_AlertCarrito(obj.Articulo);
			carrito_SetCarrito(obj.Carrito);
		}
	});	
}

function carrito_AlertCarrito(articulo) {
	if (articulo.cls_error) {
		$('#msgCarritoERROR').get(0).innerHTML = articulo.cls_msgError;
		$('#msgCarritoERROR').get(0).style.display='';
		$('#spnPrecioCarrito').get(0).style.display='none';
		$('#divCarrito').get(0).className = 'efectoCarritoModError';
	} else {
		$('#msgCarritoOK').get(0).innerHTML = articulo.titulo;
		$('#precioCarrito').get(0).innerHTML = formatCurrency(articulo.cls_precio);
		$('#carritoImagen').get(0).src = articulo.cls_urlImagen;
		$('#spnPrecioCarrito').get(0).style.display='';
		$('#msgCarritoERROR').get(0).style.display='none';
		$('#divCarrito').get(0).className = 'efectoCarritoMod';
		$('#divCarrito').get(0).style.top =getScrollXY()[1]+ window.screen.height/2 -174 + "px";
	}
	$('#divCarrito').get(0).style.display = '';
}

function carrito_CloseCarrito() {
	$('#divCarrito').get(0).style.display = 'none';
	$('#modalBack').get(0).style.display = 'none';
}
function carrito_Pedir(idArticulo) {
	if (confirm('Este producto no está disponible actualmente. Desea hacer un pedido?')) {
		document.location = '/PedidoEspecial?ID_ARTICULO=' + idArticulo;
	}
}
function carrito_ActualizarCarrito() {
	$.ajax({
		url: '/GetInfoCarrito',
		type:'POST',
		cache:false,
		success: function(data) {
			var obj = jQuery.parseJSON(data);
			carrito_SetCarrito(obj.Carrito);
		}
	});
}
function carrito_SetCarrito(objCarrito) {
	if (objCarrito.cantidad < 1) {
		$('#textoCarrito').get(0).innerHTML = 'No hay<br/> items'
	} else {
		$('#textoCarrito').get(0).innerHTML =  objCarrito.cantidad + ((objCarrito.cantidad>1)?' items':' item') + '<br/>$ ' + formatCurrency(objCarrito.total);
	}
}
function agregarProducto(idArticulo) {
	carrito_AgregarArticulo(idArticulo);
}
function mostrarDiv(id){
if(document.getElementById(id).style.display== "none"){
document.getElementById(id).style.display = "block";
document.getElementById(id).style.visibility='visible'
}else{
document.getElementById(id).style.display = "none";
document.getElementById(id).style.visibility='hidden'
}}
function MM_showHideLayers() {
var i,p,v,obj,args=MM_showHideLayers.arguments;
for (i=0; i<(args.length-2); i+=3)
with (document)if(getElementById && ((obj=getElementById(args[i]))!=null)){v=args[i+2];
if (obj.style){obj=obj.style; v=(v=='show')?'visible':(v=='hide')?'hidden':v; }
obj.visibility=v;}
}
var listaMensaje = null;
var visualizaMensaje = false;
var indiceMensajeActual =0;

function getMensaje() {
	$.ajax({
		  type: "GET", 
		  url: "/GetMensaje?par=" + Math.random(), 
		  success: function (obj) { 
			if (obj.mensajes.lista != undefined) {
				if (obj.mensajes.lista.length > 0) {
					listaMensaje = obj.mensajes.lista;
					getMensajeActual();
				} else {
					$('#msjMin').get(0).style.display='none';
					$('#msjMax').get(0).style.display='none';
				}
	//		  	setMensajeUsuario(indiceMensajeActual);
			  } else {
				  
			  }
		  }, 
		  dataType: "json", 
		  cache: false 
		});
}

function getVisualizaMensaje() {
	
	$.ajax({
		  type: "GET", 
		  url: "/GetMensaje?par=" + Math.random(),
		  cache:false,
		  success: function (obj) { 
			visualizaMensaje = obj.respuesta;
			getMensaje();
		  }
	});	
}

function setMensajeUsuario(indice) {
	$('#totalMsg').get(0).innerHTML = listaMensaje.length;
	$('#pagMsg').get(0).innerHTML = 'Mensaje ' + (indice+1) + '/' + listaMensaje.length + ':';
	$('#textoMsgActual').get(0).innerHTML = listaMensaje[indice].texto;
	if (visualizaMensaje) {
		$('#msjMax').get(0).style.display='block';
		$('#msjMin').get(0).style.display='none';
	} else {
		$('#msjMax').get(0).style.display='none';
		$('#msjMin').get(0).style.display='block';
	}
	if (indice == 0) {
		$('#msgAnterior').get(0).href = 'javascript:nada()';
		$('#msgAnterior').get(0).className = 'linkDisabled';
	} else {
		$('#msgAnterior').get(0).href = 'javascript:msgIrAnterior()';
		$('#msgAnterior').get(0).className = 'pnlMsgComandos';
	}
	if (indice == (listaMensaje.length-1)) {
		$('#msgSiguiente').get(0).href = 'javascript:nada()';
		$('#msgSiguiente').get(0).className = 'linkDisabled';
	} else {
		$('#msgSiguiente').get(0).href = 'javascript:msgIrSiguiente()';
		$('#msgSiguiente').get(0).className = 'pnlMsgComandos';
	}
	$('#msgLeido').get(0).className = 'pnlMsgComandos';
	$('#msgLeido').get(0).href = 'javascript:setMensajeLeido()';
}
function msgIrAnterior() {
	indiceMensajeActual--;
	setMensajeUsuario(indiceMensajeActual);
	setMensajeActual(indiceMensajeActual);
}
function msgIrSiguiente() {
	indiceMensajeActual++;
	setMensajeUsuario(indiceMensajeActual);
	setMensajeActual(indiceMensajeActual);
}
function setVisualizaMensaje(visualiza) {
	$.ajax({
		url: '/SetVisualizaMensaje?par=' + Math.random() + '&visualiza=' + visualiza,
		type:'GET',
		cache:false,
		success: function(data){
			visualizaMensaje = visualiza;
		}
	});	
}

function setMensajeLeido() {
	$('#msgAnterior').get(0).href = 'javascript:nada()';
	$('#msgAnterior').get(0).className = 'linkDisabled';
	$('#msgSiguiente').get(0).href = 'javascript:nada()';
	$('#msgSiguiente').get(0).className = 'linkDisabled';
	$('#msgLeido').get(0).className = 'linkDisabled';
	$('#msgLeido').get(0).href = 'javascript:nada()';
	var id = listaMensaje[indiceMensajeActual].id;
	if (indiceMensajeActual==(listaMensaje.length-1)) {
		indiceMensajeActual--;
		setMensajeActual(indiceMensajeActual);
	}	
	$.ajax({
		url:'/SetMensajeLeido?par=' + Math.random() + '&id=' + id,
		type:'GET',
		cache:false,
		succes: function(data) {
			//var obj = jQuery.parseJson(data);			
		}
	});
	getMensaje();	
}
function setMensajeActual(indice) {
	if (indice != -1) {
		var id = listaMensaje[indice].id;
		var param = 'par=' + Math.random() + '&id=' + id;
		$.ajax({
			url: '/SetMensajeActual?'+param,
			success: function(data) {
				//var obj = jQuery.parseJSON(data);
			}
		});
	}
}
function getMensajeActual() {
	$.getJSON('/GetMensajeActual', 
	function(obj) {
		if (obj.respuesta == -1 || !obj.respuesta) {
  			indiceMensajeActual = 0;
	    } else {
	     	for (i=0; i<listaMensaje.length; i++) {
 			  	if (listaMensaje[i].id == obj.respuesta) {
	 			  	indiceMensajeActual = i;
	 			  	break;
	 			 }
 			}
		}
		setMensajeUsuario(indiceMensajeActual);
	});
}

</script>
<script> 
$(document).ready(function(){
	alert("ready");
	carrito_ActualizarCarrito();
	getVisualizaMensaje();
}
</script>
</head>
<body>
	<center><!--*INICIO DEL CONTENIDO DEL SITIO*-->
		<div class="lienzo">	
		<!--*HEADER*-->
<div class="header">	
	<a href="/" class="hLogo" title="Tematika.com"></a>	
<div class="hBuscador">
<ul class="dropdown">
<li class="dir"	onclick="javascript:desplegarOpciones('listaBuscador');">
<span id="optBusqueda">Todo el Sitio</span>

<ul style="display: none;" id="listaBuscador" onmouseover="clearTimeout(tempo);" onmouseout="ocultarOpcionesT('listaBuscador');">

<li><a id="optBus1"  href="javascript:mostrarBuscarPor('optBus1','optBusqueda','listaBuscador','0','0','En Tematika.com');">Todo el Sitio</a></li>

<li><a id="optBus2"  href="javascript:mostrarBuscarPor('optBus2','optBusqueda','listaBuscador','0','1','En Libros');">En Libros</a></li>

<li><a id="optBus3"  href="javascript:mostrarBuscarPor('optBus3','optBusqueda','listaBuscador','0','4','En Musica');">En Musica</a></li>

<li><a id="optBus4"  href="javascript:mostrarBuscarPor('optBus4','optBusqueda','listaBuscador','0','5','En Peliculas');">En Peliculas</a></li>

<li><a id="optBus5"  href="javascript:mostrarBuscarPor('optBus5','optBusqueda','listaBuscador','0','3','En Pasatiempos');">En Pasatiempos</a></li>

</ul>
</li>
</ul>
<input id="txtBuscar" name="buscadorTxtField" type="text" value="" class="hBuscTxtF" onkeypress="javascript: if(pressEnter(event)) buscador_setBusqueda(document.getElementById('optBusqueda').innerHTML, document.getElementById('txtBuscar').value, '600','0',document.getElementById('seccionBusqueda').value);"/>
<input type="hidden" id="seccionBusqueda" value="En Tematika.com">
<input type="hidden" id="idSeccionPropia" value="0">
<input type="hidden" id="idSeccion" value="0">
<a id="btnBuscar" class="hBuscButton" title="Buscar" href="javascript:buscador_setBusqueda(document.getElementById('optBusqueda').innerHTML,document.getElementById('txtBuscar').value,'600',document.getElementById('idSeccionPropia').value,document.getElementById('seccionBusqueda').value);">&nbsp;</a>
</div>
<a href="/institucional/servicios.jsp#servicios" class="hServClientes" title="Servicio al cliente"></a>

<div class="hModUsuarioBack"></div>
<div class="hModUsuario">
<div class="hModUsrNombre" style="cursor:pointer" onclick="window.location.href='/miCuenta/index.jsp';">Mi Cuenta</div>

<a style="visibility:hidden;" class="hModUsrCerrar" href="/TerminarSesion" title="Salir">salir</a>
<div class="hModUsrExtra">

Consultá tus
<br/><a id="lnkCantPuntExtra" href="/extra">puntos</a>eXtra!</div>
<a href="/IniciarCompra" id="textoCarrito" class="hModUsrCarrito" title="Finalizar la compra"></a>
<a href="/compra/carrito.jsp" id="textoCarritoLnk" class="hModUsrCarritoLnk" title="Carrito de compra"></a>
<a href="/miCuenta" class="hModUsrButton" title="Panel de Usuario"></a></div>
</div><div id="msjMax" class="panelMensajes" style="display:none">
	<div class="panelMsjTit">Tenés&nbsp;<span id="totalMsg"></span> mensajes por leer &gt;</div>

	<div class="panelMsjTxt">	
	<a href="javascript:mostrarDiv('msjMin'); javascript:mostrarDiv('msjMax');javascript:setVisualizaMensaje(false)" class="panelMsjCerrar">cerrar</a>
    	<span id="pagMsg"></span> <span id="textoMsgActual"></span> <div><a href="javascript:nada()" class="pnlMsgComandos" id="msgAnterior">&lt;Anterior</a> | <a href="javascript:nada()" class="pnlMsgComandos" id="msgSiguiente">Siguiente&gt;</a> | <a href="javascript:nada()" class="pnlMsgComandos" id="msgLeido">No volver a mostrar este mensaje</a></div>
    </div>

</div><div id="msjMin" class="panelMensajes" style="display:none"> <div class="panelMsjTxt"><a href="javascript:mostrarDiv('msjMin'); javascript:mostrarDiv('msjMax');javascript:setVisualizaMensaje(true)" class="panelMsjAbrir">abrir panel y ver mensajes</a>   </div></div>
		<!--*BODY*-->
		<!--*BARRA CENTRAL*-->
		<div class="barraCentral" id="barraCentral">
	
<div class="panelSeccionesLeft">

<a href="/libros" id="panelSeccLibros" title="Libros"><span></span></a>


<a href="/musica" id="panelSeccMusica" title="Música"><span></span></a>


<a href="/peliculas" id="panelSeccPeliculas" title="Películas"><span></span></a>


<a href="/juguetes" id="panelSeccPasatiempos" title="Pasatiempos"><span></span></a>


<a href="/sucursales" id="panelSeccSucursales" title="Sucursales"><span></span></a>


<a href="#" onclick="window.open('http://www.yenny-elateneo.com/index.php?idS=1');return false;" id="panelSeccQuid" title="Quid"><span></span></a>


<a href="/extra" id="panelSeccExtra" title="eXtra!"><span></span></a>

</div>

<!--No borrar el comentario es para identificar la pagina por contenido ERROR404ERROR -->
<table width="390" border="0" align="center" cellpadding="0" cellspacing="0" height="250">
            <tr>
                <td><table width="390" border="0" cellpadding="0" cellspacing="0" class="moduloayudatop">
                  <tr>
                    <td class="titulosceldas"></td>
                  </tr>

                  <tr>
					<td class="moduloayuda"><table align="center" border="0" cellpadding="0">
						<tr valign="middle">
							<td>&nbsp;</td>
							<td><img src="/imagenes/miCuenta/baliza.gif"></td>
							<td><div class="FTtit01">No se encuentra la p&aacute;gina solicitada.<br />Disculpe los inconvenientes.</div></td>
						</tr>

		 			</table></td>
                  </tr>
                </table></td>
              </tr>              
            </table>
<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
_uacct = "UA-635166-1";
urchinTracker();
</script>

<div class="panelSecciones">

</div>
		</div>
		<!--*FIN BARRA CENTRAL*-->
		<!--*FOOTER*-->
		<div class="footer">
		
		<div class="footerShadow"></div>
		<div class="footerLogos"></div>
		<div class="footerText"><a href="/">TEMATIKA</a> |
		<a href="/libros">LIBROS</a> |
		<a href="/musica">MUSICA</a> |
		<a href="/peliculas">PELICULAS</a>|
		<a href="/juguetes">PASATIEMPOS</a></div>

		<div class="footerText2"><a href="/rss">
		<img src="/imagenes/rediseno/imagenes/comun/rssLogo.gif" />
		<span>Descargue las Novedades y Lanzamientos de Tematika en su sitio</span></a></div>
		<div class="footerText">
		<a href="/institucional/conozcanos.jsp">MARCAS</a> |
		<a href="/sucursales">SUCURSALES</a> |
		<a href="/institucional/prensa.jsp?page=/asociadas/prensa/prensa1.htm">PRENSA</a> |
		<a href="/institucional/verEventos.jsp">EVENTOS</a> |
		<a href="/ranking/index.jsp?idSeccion=5">RANKING</a> |
		<a href="/indice">MAPA DE PRODUCTOS</a> |
		<a href="/institucional/servicios.jsp#preguntasfrecuentes">PREGUNTAS FRECUENTES</a> |
		<a href="/empleos">EMPLEOS</a> |
		<a href="mailto:librerias@tematika.com">CONTACTO</a> <br />

		<a href="/miCuenta/?seccionMiCuenta=11&opcionMenuReferido=0">PROGRAMA DE REFERIDOS</a> |
		<a href="/afiliados/index.jsp">PROGRAMA DE ASOCIADOS</a> |
		<a href="/institucional/clientesInstitucionales.jsp">VENTAS CORPORATIVAS</a> |
		<a href="/institucional/servicios.jsp#servicios">SERVICIO AL CLIENTE</a> |
		<a href="/ayuda/ayudaEstandar.jsp?url=/ayuda/enviosPlazos.jsp">PLAZOS Y COSTOS DE ENV&Iacute;O</a></div>
		</div></div>

		<!--*FIN DEL CONTENIDO DEL SITIO*-->
	</center>
	
	</body>
<div id="divCarrito" class="efectoCarritoMod" style="display:none"><div class="efectoCarritoTxt"><span class="txtMsgCarritoOK" id="msgCarritoOK"></span><span  id="msgCarritoERROR" style="font-size:12;color:red"></span><br /><span id="spnPrecioCarrito" class="txtPrecioCarrito">PRECIO: $ <span  class="txtPrecioCarrito" id="precioCarrito"></span>.-</span></div><div class="efectoCarritoImages"><img id="carritoImagen"  class="efectoCarritoImag"></div><div id="efectoCarritoB"><a href="javascript:carrito_CloseCarrito()"><img src="/imagenes/b-carrContinuar.gif" alt="Continuar" border="0"></a></div></div><div id="modalBack" style="display:none"></div>
</html>