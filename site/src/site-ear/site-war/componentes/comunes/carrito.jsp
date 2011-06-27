<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert"%>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), 0); 
%>


<table id="tablaCarrito" width="165" border="0" cellpadding="0" cellspacing="0" class="carritotabla">
  <tr>
    <td><table width="135" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td width="93">
        	<a href="/compra/carrito.jsp" class="fontcarrito" rel="nofollow">
	        <span id="itemCarrito"></span>
	        </a><br>
	        <span id="importeCarrito" class="foncarrito02">
	        </span>
        </td>
        <td width="52"><div align="right" valign="middle" >
        	<a id="linkCarrito" href="" rel="nofollow"><img id="imagenCarrito" style="padding-left:6px;padding-top:4px" src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-cerrarcompra.gif" alt="Cerrar Compra" width="51" height="22" border="0" /></a>
       	</div></td>
      </tr>
    </table></td>
  </tr>
</table>
<script>
traerCarrito()
</script>
<div id="divPopUp" style="visibility:hidden;"></div>