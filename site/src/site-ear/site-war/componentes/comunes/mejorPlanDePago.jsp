<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.setup.Contenido,
                 com.tmk.kernel.MedioDeCobroDAO"%>
<!-- Plan de pago-->
<%

double precio = Convert.toNumber(request.getParameter("precio"), 0.0);

if (Globals.TARJETAS_DETALLE_ARTICULO.size()>1) {
	int cuotas = Convert.toNumber((String)Globals.TARJETAS_DETALLE_ARTICULO.get(0), 1);
%>
<!--html>

	<head>
        <%//= Globals.estiloBasico() %>
    </head>
    <body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"-->
<table cellpadding=0 cellspacing=2 border=0 >
	<tr>
		<td width=15>
		</td>
		<td style="font-family:verdana;font-size:13px">
		<b><%=Globals.TARJETAS_DETALLE_ARTICULO.get(0).toString()%>&nbsp;
		<%=Convert.plural(cuotas, "cuota", "cuotas")%> sin interés de
		<%=Contenido.precioToString(precio/cuotas)%> c/u.</b>&nbsp;
		</td>
		<td bgcolor="000000" style="font-size:1">
			&nbsp;
		</td>
		<td>
			&nbsp;
		</td>

		<%
		  for (int i = 1; i<Globals.TARJETAS_DETALLE_ARTICULO.size(); i++) {
		%>
		<td style="font-size:3">
			<img src="/imagenes/medioDeCobro<%=((MedioDeCobroDAO)Globals.TARJETAS_DETALLE_ARTICULO.get(i)).getId()%>.gif"
				alt="<%= ((MedioDeCobroDAO)Globals.TARJETAS_DETALLE_ARTICULO.get(i)).getNombre() %>">
		</td>
		<td>
			&nbsp;
		</td>
		<%
		  }
		%>

	</tr>
</table>
<table>
	<tr>
		<td width=15>
		</td>
		<td>
		   <a href="#" onclick="javascript:window.open('/componentes/comunes/planesDePago.jsp?precio=<%=precio%>', '', 'toolbar=0,status=0,scrollbars=yes width=420 height=400 resizable=yes')"><b>Ver plan de cuotas</b></a>
		</td>
	</tr>
</table>

<%
%>
<!--script language="javascript">
 window.parent.document.getElementById("planDePago").height = 90;
</script>
</body>
</html-->
<%
 }
%>
<!-- Plan de pago-->