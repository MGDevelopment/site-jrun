<%response.addHeader("pragma", "no-cache"); %>
<%@ page import="com.tmk.kernel.Convert,
				com.tmk.kernel.Globals"%>

<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0); 
%>
<script language="javascript" type="text/javascript">

function creaAjax(){
  var objetoAjax=false;
  try {
   /*Para navegadores distintos a internet explorer*/
   objetoAjax = new ActiveXObject("Msxml2.XMLHTTP");
  } catch (e) {
   try {
     /*Para explorer*/
     objetoAjax = new ActiveXObject("Microsoft.XMLHTTP");
     } 
     catch (E) {
     objetoAjax = false;
   }
  }

  if (!objetoAjax && typeof XMLHttpRequest!='undefined') {
   objetoAjax = new XMLHttpRequest();
  }
  return objetoAjax;
}

var http = creaAjax();

function agregarProducto(action) {
    http.open('get', '/AgregarProducto?articulo='+action+ '&idSeccion=' + <%=idSeccion%> + "&home=true");
    //http.open('get', '/prueba/pruebaAjax.jsp?articulo='+action);
    http.onreadystatechange = handleResponse;
    http.send(null);
    idTimeOut=window.setTimeout('refrescarCarrito()', 2000);

}
function refrescarCarrito() {
    http.open('get', '/componentes/comunes/carrito.jsp?idSeccion=' + <%=idSeccion%> + '&param=' + Math.random());
    http.onreadystatechange = handleResponse;
    http.send(null);
}    

function handleResponse() {
    if(http.readyState == 4){
        var response = http.responseText;
       // var update = new Array();

        //if(response.indexOf('|' != -1)) {
          //  update = response.split('|');
            document.getElementById('carrito').innerHTML = response;
            
        //}
    }
}


</script>

<table width="165" border="0" cellpadding="0" cellspacing="0" class="carritotablaActivo">
  <tr>
    <td><table width="135" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="93"><span class="foncarrito02">Articulo NO DISPONIBLE</span></td>
        <td width="52"><div align="right">
        	<img style="padding-left:6px" src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-cerrarcompraActivo.gif" alt="Cerrar Compra" width="51" height="22" border="0" /></a>
        	</div></td>
      </tr>
    </table></td>
  </tr>
</table>