<%@ page import="com.tmk.kernel.Globals,
				 com.tmk.kernel.Convert,
				 com.tmk.kernel.DBUtil,
				 com.tmk.setup.Contenido"%>
<%
int idSeccion = Convert.toNumber(request.getParameter("idSeccion"), Globals.SECCION_LIBRO);
double precio = Convert.toNumber(request.getParameter("precio"), 0.0);
%>
<% try { %>
<table width="178" border="0" align="right" cellpadding="0" cellspacing="0" class="areaExtra">
	<tr>
    	<td align="center" valign="top">

			<table width="156" border="0" cellspacing="0" cellpadding="0">
				<tr>
			    	<td><div align="left"><img src="/imagenes/extra.gif" alt="eXtra!" width="64" height="22" /></div></td>
			    </tr>
			    <tr>
			    	<td class="areaExtra2"><span class="Ftexto02">COMPRANDO ESTE PRODUCTO PODES SUMAR:<br />
          				<div style="padding-top:5px"><strong><%=DBUtil.getPuntos(precio)%> PUNTOS eXtra!</strong></div></span>
          				<span class="Ftexto02"><a href="/fidelizacion/panel/index.jsp" class="Flink01" >Ingresar a eXtra!!</a></span>
          			</td>
			    </tr>
			    <tr>
			  		<td class="areaExtra3"><span class="Ftexto02">GASTOS DE ENVIO DE ESTE<br />
			    		PRODUCTO, A PARTIR DE:<br />
			       	<div style="padding-top:5px"><strong><%=Contenido.precioToString(Globals.MENOR_GASTO_ENVIO)%>
			       	</strong></div>
					<div style="padding-top:5px; padding-bottom:5px"><a href="/ayuda/ayudaEstandar.jsp?url=/ayuda/enviosPlazos.jsp" class="Flink01" rel="nofollow">Ver costos de env&iacute;o y Tiempos de Entrega</a></div>
					</span>
				    <%
					String linkBanner = null;
						for (int i = 0; i< Contenido.getSite().getPaginas().getPaginaCount(); i++) {
							if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {
								linkBanner = Contenido.getSite().getPaginas().getPagina(i).getBannerSuperior().getPaginaFuente();
							}
						}
				   	%>
					<% if (linkBanner != null && !linkBanner.equals("")) {%>
						<jsp:include page="<%= linkBanner%>"/>
					<% }%>
			   		</td>
			   	</tr>
			</table>
	    </td>
	</tr>
</table>
<%} catch (Exception e) { %>
<%out.println (e.toString()); %>
<%}%>