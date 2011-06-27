<%@page import="com.tmk.kernel.Convert"%>
<%@page import="com.tmk.src.socio.SocioPK"%> 
<%String nombre = "Mi Cuenta";
	if (request.getSession().getAttribute("Registracion.nombre") != null) {
   		nombre = Convert.toString(request.getSession().getAttribute("Registracion.nombre"), "");
   	}
%>
<div class="hModUsuarioBack"></div>
<div class="hModUsuario">
<div class="hModUsrNombre" style="cursor:pointer" onclick="window.location.href='/miCuenta/modificarSocio.jsp';"><%=nombre%></div>
<%--logica para deterinar y mostrar si esta logueado "salir" de lo contrario no muetra" --%>
<%boolean estaLogueado = (SocioPK)session.getAttribute("Registracion.socioPK") != null; %>
<a id="divSalir" style="visibility:<%=(estaLogueado ? "visible;" : "hidden;")%>" class="hModUsrCerrar" href="/TerminarSesion" title="Salir">salir</a>
<div class="hModUsrExtra">
<%	Integer puntosFidelizacion = (Integer)request.getSession().getAttribute("PuntajeFidelizacion");
	String txtFidelizacion = "Consultá tus";
	String txtPuntosFidelizacion = "puntos";
	if (puntosFidelizacion != null) {
		txtFidelizacion = "Tenés acumulados";
		txtPuntosFidelizacion = Convert.toString(puntosFidelizacion, "") + " puntos";
	}
%>
<%=txtFidelizacion%>
<br/><a id="lnkCantPuntExtra" href="/extra"><%=txtPuntosFidelizacion%></a>eXtra!</div>
<a href="/IniciarCompra" id="textoCarrito" class="hModUsrCarrito" title="Finalizar la compra"></a>
<a href="/compra/carrito.jsp" id="textoCarritoLnk" class="hModUsrCarritoLnk" title="Carrito de compra"></a>
<a href="/miCuenta" class="hModUsrButton" title="Panel de Usuario"></a></div>