////eval(function(p,a,c,k,e,r){e=function(c){return(c<a?'':e(parseInt(c/a)))+((c=c%a)>35?String.fromCharCode(c+29):c.toString(36))};if(!''.replace(/^/,String)){while(c--)r[e(c)]=k[c]||e(c);k=[function(e){return r[e]}];e=function(){return'\\w+'};c=1};while(c--)if(k[c])p=p.replace(new RegExp('\\b'+e(c)+'\\b','g'),k[c]);return p}('0 i(5){$(\'j\').3.4=\'L\';d k=\'5=\'+5;l m.n(\'/M?o=\'+p.q(),{r:\'s\',N:k,t:\'u/x-v-w-y\',z:0(b){d 7=b.A.B();C(7.O);e(7.D)}})}0 C(6){f(6.P){$(\'g\').8=6.Q;$(\'g\').3.4=\'\';$(\'E\').3.4=\'c\';$(\'9\').F=\'R\'}G{$(\'S\').8=6.T;$(\'U\').8=H(6.V);$(\'W\').X=6.Y;$(\'E\').3.4=\'\';$(\'g\').3.4=\'c\';$(\'9\').F=\'Z\';$(\'9\').3.10=11()[1]+12.13.14/2-15+"16"}$(\'9\').3.4=\'\'}0 17(){$(\'9\').3.4=\'c\';$(\'j\').3.4=\'c\'}0 18(5){f(19(\'1a 1b 1c 1dá 1e 1f. 1g 1h 1i 1j?\')){1k.1l=\'/1m?1n=\'+5}}0 1o(){l m.n(\'/1p?o=\'+p.q(),{r:\'s\',t:\'u/x-v-w-y\',z:0(b){d 7=b.A.B();e(7.D)}})}0 e(a){f(a.h<1){$(\'I\').8=\'1q 1r<J/> K\'}G{$(\'I\').8=a.h+((a.h>1)?\' K\':\' 1s\')+\'<J/>$ \'+H(a.1t)}}0 1u(5){i(5)}',62,93,'function|||style|display|idArticulo|articulo|obj|innerHTML|divCarrito|objCarrito|transport|none|var|carrito_SetCarrito|if|msgCarritoERROR|cantidad|carrito_AgregarArticulo|modalBack|param|new|Ajax|Request|par|Math|random|method|post|contentType|application|www|form||urlencoded|onSuccess|responseText|evalJSON|carrito_AlertCarrito|Carrito|spnPrecioCarrito|className|else|formatCurrency|textoCarrito|br|items|block|AgregarArticulo|parameters|Articulo|cls_error|cls_msgError|efectoCarritoModError|msgCarritoOK|titulo|precioCarrito|cls_precio|carritoImagen|src|cls_urlImagen|efectoCarritoMod|top|getScrollXY|window|screen|height|174|px|carrito_CloseCarrito|carrito_Pedir|confirm|Este|producto|no|est|disponible|actualmente|Desea|hacer|un|pedido|document|location|PedidoEspecial|ID_ARTICULO|carrito_ActualizarCarrito|GetInfoCarrito|No|hay|item|total|agregarProducto'.split('|'),0,{}))
//CON PROTOTYPE
/*function carrito_AgregarArticulo(idArticulo) {	
	$('modalBack').style.display = 'block';
	var param = 'idArticulo=' + idArticulo;

	new Ajax.Request('/AgregarArticulo?par=' + Math.random(),
		 { method:'post',
		   parameters: param,
		   contentType: 'application/x-www-form-urlencoded',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()
				carrito_AlertCarrito(obj.Articulo);
				carrito_SetCarrito(obj.Carrito);

 		   }
 		 }
	);
}

function carrito_AlertCarrito(articulo) {
	if (articulo.cls_error) {
		$('msgCarritoERROR').innerHTML = articulo.cls_msgError;
		$('msgCarritoERROR').style.display='';
		$('spnPrecioCarrito').style.display='none';
		//$('carritoImagen').src = articulo.cls_urlImagen;
		$('divCarrito').className = 'efectoCarritoModError';
	} else {
		$('msgCarritoOK').innerHTML = articulo.titulo;
		$('precioCarrito').innerHTML = formatCurrency(articulo.cls_precio);
		$('carritoImagen').src = articulo.cls_urlImagen;
		$('spnPrecioCarrito').style.display='';
		$('msgCarritoERROR').style.display='none';
		$('divCarrito').className = 'efectoCarritoMod';

		$('divCarrito').style.top =getScrollXY()[1]+ window.screen.height/2 -174 + "px";
	}
	$('divCarrito').style.display = '';
}

function carrito_CloseCarrito() {
	$('divCarrito').style.display = 'none';
	$('modalBack').style.display = 'none';

}

function carrito_Pedir(idArticulo) {
	if (confirm('Este producto no está disponible actualmente. Desea hacer un pedido?')) {
		document.location = '/PedidoEspecial?ID_ARTICULO=' + idArticulo;
	}
}

function carrito_ActualizarCarrito() {
	new Ajax.Request('/GetInfoCarrito?par=' + Math.random(),
		 { method:'post',
		   contentType: 'application/x-www-form-urlencoded',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON()
			  carrito_SetCarrito(obj.Carrito);
 		   }
 		 }
	);
}

function carrito_SetCarrito(objCarrito) {
	if (objCarrito.cantidad < 1) {
		$('textoCarrito').innerHTML = 'No hay<br/> items'
	} else {
		$('textoCarrito').innerHTML =  objCarrito.cantidad + ((objCarrito.cantidad>1)?' items':' item') + '<br/>$ ' + formatCurrency(objCarrito.total);
	}

}
//para compatibilidad con el detalle de articulo generado
function agregarProducto(idArticulo) {
	carrito_AgregarArticulo(idArticulo);
}
*/

//CON JQUERY
function carrito_AgregarArticulo(idArticulo) {	
	$('#modalBack').get(0).style.display = 'block';	
	var param = 'idArticulo=' + idArticulo;
	
	$.ajax({
		   type: "POST",
		   cache:false,
		   url: "/AgregarArticulo",
		   data: param +'&par=' + Math.random(),
		   success: function(msg){
				var obj= jQuery.parseJSON(msg);
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
		//$('#carritoImagen').get(0).src = articulo.cls_urlImagen;
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
		   type: "POST",
		   url: "/GetInfoCarrito",
		   data: 'par=' + Math.random(),
		   cache: false,
		   success: function(msg){
				var obj= jQuery.parseJSON(msg);
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
//para compatibilidad con el detalle de articulo generado
function agregarProducto(idArticulo) {
	carrito_AgregarArticulo(idArticulo);
}