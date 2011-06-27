//agrega a una tabla las filas y columnas dinamicamente
function addRow(tbl, datos) {
  tbl.insertRow(tbl.rows.length);
  var i;
  for (i=0; i<datos.length; i++) {
    tbl.rows[tbl.rows.length-1].insertCell(i);
    if (datos[i]) {
      tbl.rows[tbl.rows.length-1].cells[i].innerHTML = datos[i];
    } else {
      tbl.rows[tbl.rows.length-1].cells[i].innerHTML = "&nbsp;";
    }
    tbl.rows[tbl.rows.length-1].cells[i].align=tbl.rows[0].cells[i].align;
  }
}

//Borra de la tabla hasta la 2da porque asume que la primera es cabecera
function deleteRows(tbl) {
  while(tbl.rows.length>1) {
    tbl.deleteRow(tbl.rows.length-1);
  }
}

//maneja el enveto del enter
function presionarEnter(event,funcion) {
  if (event.keyCode == 13) {
    eval("("+funcion+")");
  }
}

/*formato de moneda*/
function formatCurrency(num) {
  num = num.toString().replace(/\$|\,/g,'');
  if (isNaN(num))
    num = 0;
  var signo = (num == (num = Math.abs(num)));
  num = Math.floor(num * 100 + 0.50000000001);
  centavos = num % 100;
  num = Math.floor(num / 100).toString();
  if (centavos < 10)
    centavos = '0' + centavos;
  for (var i = 0; i < Math.floor((num.length - (1 + i)) / 3); i++)
    num = num.substring(0, num.length - (4 * i + 3)) + ',' + num.substring(num.length - (4 * i + 3));

  return (((signo) ? '' : '-') + num + '.' + centavos);
}


/*actualiza la posicion del cursor en todo momento*/
function posicRatonXY(e) {
  posicXAnt = posicX;
  posicYAnt = posicY;
/*  if (IE) { posicX = event.clientX + document.body.scrollLeft;
  posicY = event.clientY + document.body.scrollTop}*/
  if (IE) { posicX = event.clientX +  document.documentElement.scrollLeft
  posicY = event.clientY + document.documentElement.scrollTop}
  else { posicX = e.pageX; posicY = e.pageY };
  if (posicX < 0) {posicX = 0};
  if (posicY < 0) {posicY = 0};
  return true
}

/*retorna la posición Y de un elemento*/
function getY( oElement ) {
  var iReturnValue = 0;
  while( oElement != null ) {
    iReturnValue += oElement.offsetTop;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

/*retorna la posición X de un elemento*/
function getX( oElement ) {
  var iReturnValue = 0;
  while( oElement != null ) {
    iReturnValue += oElement.offsetLeft;
    oElement = oElement.offsetParent;
  }
  return iReturnValue;
}

function getScrollXY() {
  var scrOfX = 0, scrOfY = 0;
  if( typeof( window.pageYOffset ) == 'number' ) {
    //Netscape compliant
    scrOfY = window.pageYOffset;
    scrOfX = window.pageXOffset;
  } else if( document.body && ( document.body.scrollLeft || document.body.scrollTop ) ) {
    //DOM compliant
    scrOfY = document.body.scrollTop;
    scrOfX = document.body.scrollLeft;
  } else if( document.documentElement && ( document.documentElement.scrollLeft || document.documentElement.scrollTop ) ) {
    //IE6 standards compliant mode
    scrOfY = document.documentElement.scrollTop;
    scrOfX = document.documentElement.scrollLeft;
  }
  return [ scrOfX, scrOfY ];
}

function getScreenSize(){
  return [screen.width, screen.height];
}


function addEvent(obj, evType, fn){
 if (obj.addEventListener){
   obj.addEventListener(evType, fn, false);
   return true;
 } else if (obj.attachEvent){
   var r = obj.attachEvent("on"+evType, fn);
   return r;
 } else {
   return false;
 }
}
