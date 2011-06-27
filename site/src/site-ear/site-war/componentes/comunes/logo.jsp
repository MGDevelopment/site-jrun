<%@ page import="com.tmk.setup.Contenido,
                 com.tmk.controllers.alianza.EstadisticaVisitas,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals" %>

<%@include file="/componentes/comunes/controlDeModo.jsp"%>

<%if (!(request.getParameter("enFrame") == null ? false:Convert.toBoolean(request.getParameter("enFrame")))) {%>
<script language="JavaScript">
<!--// evito que se cargue en otro frame
//
if (top.location != self.location)top.location = self.location;
//-->
</script>
<%} %>


<div align="left"><a href="/"><img src="/imagenes/<%=Contenido.getLogo()%>" alt="<%=Contenido.getMensajeLogo()%>" width="182" height="36" border="0" /><%//+ Globals.VERSION.replace('$', '\n')%></a></div>
	<%  if (Globals.MOSTRAR_MENSAJE) {%>
			<br>
			<b><%=Globals.MENSAJE_MODO%></b>
			<br><br>
	<%  } %>

	<script language="JavaScript" type="text/JavaScript">
		// Este popup esta disenado para el usuario final
		function abrirPopup(pagina, width, height) {
			window.open(pagina, 'Tematika',
						'toolbar=yes, location=yes, directories=no, status=yes, menubar=yes, scrollbars=yes, resizable=yes, copyhistory=no, width=' + width + ', height=' + height);
		}
	</script>

<%
	// Mantiene la estadistica de quienes entraron, hits, visitas y alianzas
	EstadisticaVisitas.mantenerEstadistica(request, response);
%>



