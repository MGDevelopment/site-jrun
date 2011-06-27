<%@ page import="com.tmk.kernel.Globals,
                 com.tmk.kernel.DBUtil,
                 com.tmk.common.PedidoEspecialLocalHome,
                 java.util.Iterator,
                 com.tmk.common.PedidoEspecialLocal,
                 com.tmk.src.socio.SocioPK,
                 com.tmk.kernel.Convert,
                 com.tmk.setup.Contenido,
                 com.tmk.articulo.ArticuloLocal,
                 com.tmk.kernel.Pair,
                 java.util.Vector"%>

<%--
                 //com.tmk.socio.SocioLocal,
				 //com.tmk.socio.SocioLocalHome, 
--%>
<%@page import="com.tmk.bus.socio.Socios2"%>
<%@page import="com.tmk.soa.servicios.ServiceLocator"%><html>

	<body>


		<b>Reporte sobre Encuesta en Pedido Especial</b><br><br>
<%
	String alcance = "PEESP";
	Pair par = DBUtil.getConsulta(alcance);
    if( par != null ) {
%>

	    <table align="center" width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr>
				<td colspan =2>
					<b><%= par.getValue2()%></b>
				</td>
			</tr>
<%
	    Vector vec = DBUtil.getOpinionesPorConsulta((Integer)par.getValue1());
	    for (int i = 0; i< vec.size()-1; i++) {
			Pair opinion =(Pair)vec.get(i);
		    double porc = Convert.toNumber((String)opinion.getValue1(), 0) * 100.0 / ((Integer)vec.get(vec.size()-1)).intValue();

%>
			<tr>
				<td align= "right">
					<%= Contenido.porcentajeToString(porc)%>
									</td>
				<td>
					<%= opinion.getValue2()%>
				</td>
			</tr>

<%
	    }
%>
		</table>

<%
    } else {
%>
	No se han resultados en la encuesta de pedido especial.
<%
    }
%>
	    <P>

		<b>Reporte de Pedidos Especiales realizados</b><br><br>
		<table align="center" width="100%" cellspacing="0" cellpadding="2" border="1" style="border: solid 1px #59B3D9; border-collapse: collapse; font-family: Verdana, Arial; font-size: 11px;">
			<tr align="center" >
				<td>
					<b>Pedido</b>
				</td>
				<td>
					<b>Fecha</b>
				</td>
				<td>
					<b>Artículo</b>
				</td>
				<td>
					<b>Código</b>
				</td>
				<td>
					<b>Título</b>
				</td>
				<td>
					<b>Nombre</b>
				</td>
				<td>
					<b>EMail</b>
				</td>
				<td>

				</td>
			</tr>
			<%
				//SocioLocalHome socioHome = (SocioLocalHome)DBUtil.getHome("Socio");
				PedidoEspecialLocalHome pedidoEspecialLocalHome = (PedidoEspecialLocalHome)DBUtil.getHome("PedidoEspecial");
				Iterator ultimosPedidos = pedidoEspecialLocalHome.findUltimosPedidos().iterator();
				int i = 0;
				while (i++ < 100 && ultimosPedidos.hasNext()) {
					out.flush();

					PedidoEspecialLocal pedidoEspecialLocal = (PedidoEspecialLocal)ultimosPedidos.next();

					ArticuloLocal articuloLocal = Contenido.getArticulo(pedidoEspecialLocal.getID_ARTICULO().intValue());

					SocioPK socioPK = new SocioPK();
					socioPK.ID_SUCURSAL = pedidoEspecialLocal.getID_SUCURSAL_SOCIO();
					socioPK.ID_SOCIO = pedidoEspecialLocal.getID_SOCIO();
					//SocioLocal socio = socioHome.findByPrimaryKey(socioPK);
					Socios2 socio = ServiceLocator.getSocioService().findByPrimaryKey(socioPK);
				%>
			<tr>
				<td align="right">
					<%=Convert.toString(pedidoEspecialLocal.getID_PEDIDO())%>
				</td>
				<td align="center">
					<%=Convert.toString(pedidoEspecialLocal.getFECHA())%>
				</td>
				<td align="right">
					<a href="<%=Globals.PAGINA_SITIO%>/articulo/detalleArticulo.jsp?idArticulo=<%=pedidoEspecialLocal.getID_ARTICULO()%>">
					<%=Convert.toString(pedidoEspecialLocal.getID_ARTICULO())%>
					</a>
				</td>
				<td>
					<%=Convert.toString(articuloLocal.getCODIGO_PROVEEDOR(), "&nbsp;").replaceAll(" ", "&nbsp;")%>
				</td>
				<td>
                    <%=Contenido.getTitulo(pedidoEspecialLocal.getID_ARTICULO().intValue())%><br>
					(<%= Globals.productoSeccion(articuloLocal.getCATEGORIA_SECCION().intValue()) %> a <%=Contenido.precioToString(articuloLocal.getPRECIO_SITIO().doubleValue())%>)
				</td>
				<td>
					<%--=Convert.nombreCompleto(socio.getNOMBRES(), socio.getAPELLIDOS())--%>
					<%=Convert.nombreCompleto(socio.getNombres(), socio.getApellidos())%>
				</td>
				<td>
					<%--=Convert.toString(socio.getEMAIL(), "&nbsp;")--%>
					<%=Convert.toString(socio.getlogin(), "&nbsp;")%>
				</td>
				<td>
					Teléfono: <%=Convert.toString(pedidoEspecialLocal.getTELEFONO(), "&nbsp;")%>
					&nbsp; (<%=Convert.toString(pedidoEspecialLocal.getHORARIO(), "&nbsp;")%>)
					<br>"<%=Convert.toString(pedidoEspecialLocal.getCOMENTARIO(), "&nbsp;")%>"

					<% String opinion = DBUtil.getOpinion(pedidoEspecialLocal.getID_CONSULTA(), pedidoEspecialLocal.getID_OPINION());					%>
					<%=(opinion!="")?"<br>Respuesta: " + opinion:""%>
				</td>
			</tr>
		<%}%>
		</table>
	</body>
</html>
