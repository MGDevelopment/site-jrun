<%@ page import="java.util.Iterator,
                 com.tmk.articulo.Articulo,
		         com.tmk.setup.Contenido,
                 com.tmk.controllers.compra.CompraHelper,
                 com.tmk.controllers.CommonHelper,
                 com.tmk.controllers.intranet.admin.UsuarioDAO,
                 com.tmk.controllers.intranet.admin.LoginIntranet,
                 com.tmk.kernel.ArticuloDAO,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals"%>

<style type="text/css">
	td.columnaProducto
	{
		border-right: 1px solid #B5DEF7;
		border-left: 1px solid #B5DEF7;
	}
</style>

<script type="text/javascript">

function moverHaciaLista(ID_ARTICULO)
{
	if(confirm('¿ Seguro desea mover este articulo a su lista de deseos ?'))
	{
		document.location = '/MoverHaciaLista?ID_ARTICULO='+ID_ARTICULO;
	}
}


</script>



<link href="/estilos/titulos_familia.css" rel="stylesheet" type="text/css">
<%
	int colspanEspacio = 5;
%>

<table style="border-collapse: collapse; border: 2px solid #5AB5DE;" width="90%" border="0" align="center" cellspacing="0" cellpadding="3">
<tr style="font-weight: bold; text-align: center; background-color: #5AB5DE;">
	<%	if (ordenDAO.isReadWrite()) {
		colspanEspacio++;
	%>
			<td width="11%">Mover a Lista de Deseos</td>

	<%	}
	%>

	<td width="5%">Producto</td>

	<% if (ordenDAO.isReadWrite()) { // Como los estados estan llegando mal, es preferible no mostrarlos por ahora
		colspanEspacio++;
	%>
	<td width="7%"><%=(ordenDAO.isReadWrite()) ? "Disponibilidad" : "Estado"%></td>
	<% } %>

	<td width="39%" colspan=2>Descripci&oacute;n</td>

	<td width="10%">Cantidad</td>

	<td width="8%">Precio</td>

	<% if (ordenDAO.isReadWrite()) {
		colspanEspacio++;
	%>
		<td width="15%">Eliminar el Producto</td>
	<% } %>
</tr>

<%
int contadorArticulos = 0;
for (int i = 0; i < ordenDAO.getCantidadArticulos(); i++) {
	contadorArticulos++;
	ArticuloDAO articulo = ordenDAO.getArticulo(i);
	boolean prodPromo = ( (articulo.tienePromocion() && articulo.getPrecioConDescuento() != articulo.getPrecioPromocion())  || ((articulo.getPrecioPromocion() != articulo.getPrecioConImpuesto())
			&& articulo.getPrecioPromocion() != articulo.getPrecioConDescuento())) &&
			(articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion()) > 0.009;


	boolean prodDesc = articulo.tieneDescuento() && (articulo.getPrecioConDescuento() != articulo.getPrecioConImpuesto());
	boolean tieneGasto = (articulo.getGastoDeEvio() != null);
	boolean gasPromo = tieneGasto && (articulo.getGastoDeEvio().tienePromocion() || articulo.getGastoDeEvio().getPrecioPromocion()!= articulo.getGastoDeEvio().getPrecioConImpuesto());
	boolean tienePapel = (articulo.getPapelDeRegalo() != null);
	boolean papPromo = tienePapel && (articulo.getPapelDeRegalo().tienePromocion() || articulo.getPapelDeRegalo().getPrecioPromocion()!= articulo.getPapelDeRegalo().getPrecioConImpuesto());

	boolean encontroPromo = false;

	// nombre de la imagen
   	String base = "productoTipo";
	// categoria
	StringBuffer esperada = new StringBuffer(base).append("_").append(articulo.getCategoriaSeccion());
	// la parte de acuerdo al caso
	if (prodPromo || gasPromo || papPromo) {
		esperada.append("_").append("p");
	} else if (articulo.tieneSubArticulo()) {
		esperada.append("_").append("r");
	}
	esperada.append(".gif");

	// busca la imagen, sino pone una default
	String image = Contenido.getTapa("/imagenes", esperada.toString(), base + ".gif");




%>

<input type="hidden" name="ID_ARTICULO" value="<%= articulo.getId() %>">
<input type="hidden" name="posicionEnLista" value="<%=articulo.getPosicionEnLista()%>">


<tr align="center">
<%
int rowspan = 2;
rowspan = (prodPromo)? rowspan + 1 :rowspan;
rowspan = (prodDesc)? rowspan + 1 :rowspan;
rowspan = (prodPromo || prodDesc)? rowspan + 1 :rowspan;

%>

<% if(ordenDAO.isReadWrite()) { %>

		<td class="columnaProducto" rowspan="<%=rowspan%>">
			<a href="/MoverHaciaLista?ID_ARTICULO=<%= articulo.getId() %>&posicionEnLista=<%=articulo.getPosicionEnLista()%>"><img src="/imagenes/listaDeseos/icono.gif" border="0" id="lista<%=i%>"></a>
		</td>
<% } %>

		<td class="columnaProducto" rowspan="<%=rowspan%>">
	<%
		String conPapel = (articulo.tieneSubArticulo()) ? "Si" : "No";
		String nota = articulo.getNota();
		String subNota = (articulo.tieneSubArticulo()) ? articulo.getSubArticulo().getNota() : null;
		String notaFinal = "Papel: " + conPapel + ", Nota: " + ((nota == null) ? ((subNota == null) ? "ninguna" : subNota) : nota);
	%>
			<a href="/articulo/detalleArticulo.jsp?idArticulo=<%=articulo.getId()%>">
				<img src="<%= image %>" alt="<%=notaFinal%>" border="0">
			</a>
		</td>

 		<% if (ordenDAO.isReadWrite()) { // Como los estados estan llegando mal, es preferible no mostrarlos por ahora %>
		<td class="columnaProducto" valign="middle" rowspan="<%=rowspan%>">
			<%= (articulo.isReadWrite()) ? articulo.getDisponibilidad().getNombre() : articulo.getEstadoItem().getNombre() %>
		</td>
 		<% } %>


		<td colspan=2 align="left">
			<b>
 <%

    
        out.println(Contenido.getTitulo(articulo.getId()));
    
 %>
                        </b><br>
                        <%="(" + Convert.toString(articulo.getCodExtVisual()) + ")"%>
 					   <br>
					    <%=articulo.getAtributoPrincipal()%>
						<br>
					</td>
					<td class="columnaProducto" >

					</td>
					<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">
					</td>
					<% if (ordenDAO.isReadWrite()) { // Como los estados estan llegando mal, es preferible no mostrarlos por ahora %>
					<td >
					</td>
					<%}%>
				</tr>
                <tr>

                    <td align="left" >
						Precio:
					</td>

					<td  align="right" >
 						<%= Contenido.precioToString(articulo.getPrecioConImpuesto()) %>

					</td>

					<%
						rowspan = 1;
						rowspan = (prodPromo)? rowspan + 1 :rowspan;
						rowspan = (prodDesc)? rowspan + 1 :rowspan;
						rowspan = (prodPromo || prodDesc)? rowspan + 1 :rowspan;
						//rowspan = (tieneGasto)? rowspan + 2: rowspan;
						//rowspan = (gasPromo)? rowspan + 3: rowspan;
						//rowspan = (tienePapel)? rowspan + 2: rowspan;
						//rowspan = (papPromo)? rowspan + 3: rowspan;

					%>

					<td class="columnaProducto" align="center" rowspan="<%=rowspan%>">


						<%	if (articulo.isReadOnly()) { %>
								<%= articulo.getCantidad() %>
						<%	} else { %>
								<input type="text" name="CANTIDAD" value="<%= articulo.getCantidad() %>" size="2" maxlength="2" style="text-align: center;">
						<%	}
						%>
					</td>


					<%
						rowspan = 1;
						rowspan = (prodPromo)? rowspan + 1 :rowspan;
						rowspan = (prodDesc)? rowspan + 1 :rowspan;
						rowspan = (prodPromo || prodDesc)? rowspan + 1 :rowspan;

					%>
					<td rowspan="<%=rowspan%>" class="columnaProducto" style="background-color: #B5DEF7;"  align="right">
						<b>
			 				<%= Contenido.precioToString((articulo.getPrecioPromocion()< articulo.getPrecioConDescuento())? articulo.getPrecioPromocion() * articulo.getCantidad(): articulo.getPrecioConDescuento() * articulo.getCantidad()) %>
						</b>
					</td>

					<%
						rowspan = 1;
						rowspan = (prodPromo)? rowspan + 1 :rowspan;
						rowspan = (prodDesc)? rowspan + 1 :rowspan;
						rowspan = (prodPromo || prodDesc)? rowspan + 1 :rowspan;
						//rowspan = (tieneGasto)? rowspan + 2: rowspan;
						//rowspan = (gasPromo)? rowspan + 3: rowspan;
						//rowspan = (tienePapel)? rowspan + 2: rowspan;
						//rowspan = (papPromo)? rowspan + 3: rowspan;

					%>
					<%

					%>
					<% if (articulo.isReadWrite()) { %>
						<td rowspan="<%=rowspan%>" class="columnaProducto" align="center">
							<a href="/EliminarProducto?<%=CommonHelper.ID_ARTICULO%>=<%= articulo.getId() %>&posicionEnLista=<%=articulo.getPosicionEnLista()%>" id="eliminar<%=i%>" onclick="javascript:getElementById('comprar').style.display='none'">
								<img border="0" src="/imagenes/eliminar.gif">
							</a>
						</td>
					<% } %>

	                </tr>
				<%if (prodDesc) { %>
				<tr>

                  	<td align="left">
						Descuento:
					</td>

					<td  align="right">
						<font color="red" size="1">
							-<%= Contenido.precioToString(Math.abs(articulo.getAhorro()))%>
						</font>
					</td>



                </tr>
                <%}%>
				<%if (prodPromo) { %>
                <tr>

                	<td valign="middle" align="left">
                		Promoción:
                	</td>

                	<td valign="middle" align="right">
						<font color="red" size="1">
							-<%= Contenido.precioToString(articulo.getPrecioConImpuesto() + Math.abs(articulo.getAhorro()) - articulo.getPrecioPromocion())%>
						</font>
					</td>

                </tr>
                <%}%>

                <% if (prodDesc && !prodPromo) { %>
                <tr>

                	<td valign="middle" align="left">
                		Precio Final:
                	</td>

                	<td valign="middle" align="right"  style="border-top: 1px solid black">
						<%= Contenido.precioToString(articulo.getPrecioConDescuento())%>
					</td>
                </tr>

                <% } %>
                <% if(prodPromo) { %>
                <tr>

                	<td valign="middle" align="left">
                		Precio Final:
                	</td>

                	<td valign="middle" align="right"  style="border-top: 1px solid black">
						<%= Contenido.precioToString(articulo.getPrecioPromocion())%>
					</td>

                </tr>

                <!-- tr>

                	<td colspan =2>
                	<br>&nbsp; <span style="text-decoration:underline;">Promo Aplicada</span>
                   		<%
	                   		//encontroPromo = false;
                   		%>
                        <% //if (articulo.getNombreCampaign() != null){ %>
                        <br>&nbsp; &middot;<%//=Convert.toString(articulo.getNombreCampaign(), "")%>
                        <%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getNombrePromo1() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getNombrePromo1()%>
                        <%
	                    	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getNombrePromo2() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getNombrePromo2()%>
                        <%
	                    	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getNombrePromo3() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getNombrePromo3()%>
                        <%
	                    	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getNombrePromo4() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getNombrePromo4()%>
                        <%
	                    	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getNombrePromo5() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getNombrePromo5()%>
                        <%
	                    	//encontroPromo = true;
                        	//} %>
                        <% //if (!encontroPromo) {
                        %>
							<br>&nbsp; &middot;Cheque obsequio
                        <%
                        //}
                        %>
                         <br>&nbsp;
                	</td>
                	<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">

					</td>

                </tr-->


                <%} %>



				<%

				//if (articulo.getGastoDeEvio() != null) {%>
				<!-- tr>


                	<td valign="top" align="left" colspan=2>

                		Gasto de Envío <%//=(articulo.getGastoDeEvio().esGastoBasico())?"Básico":"Adicional"%>
            		</td>

					<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">
					</td>


                </tr>
				<tr>

                    <td valign="top" align="left">
						Precio:
					</td>

					<td valign="top" align="right">
 						<%//=Contenido.precioToString(articulo.getGastoDeEvio().getPrecioConImpuesto()) %>
					</td>


					<%
					//rowspan = 1;
					//rowspan = (gasPromo)? rowspan + 2: rowspan;


					%>

					<td rowspan="<%//=rowspan%>" class="columnaProducto" style="background-color: #B5DEF7;"  align="right">
						<b>
			 				<%//= Contenido.precioToString((articulo.getGastoDeEvio().getPrecioPromocion()< articulo.getGastoDeEvio().getPrecioConDescuento())? articulo.getGastoDeEvio().getPrecioPromocion() * articulo.getGastoDeEvio().getCantidad(): articulo.getGastoDeEvio().getPrecioConDescuento() * articulo.getGastoDeEvio().getCantidad()) %>

						</b>
					</td>

                </tr>
                <%		//if(gasPromo) {

				%>
				<tr>

                	<td valign="middle" align="left">
                		Promoción:
                	</td>

                	<td valign="middle" align="right">

						<font color="red" size="1">
							-<%//= Contenido.precioToString(articulo.getGastoDeEvio().getPrecioConImpuesto() - articulo.getGastoDeEvio()
								//	.getPrecioPromocion())%>
						</font>
					</td>



                </tr>
                <tr>

                	<td valign="middle" align="left">
                		Precio Final:
                	</td>

                	<td valign="middle" align="right" style="border-top: 1px solid black">

							<%//= Contenido.precioToString(articulo.getGastoDeEvio().getPrecioPromocion())%>

					</td>


                </tr>

                <tr>

					<td colspan=2>
                	<br>&nbsp; <span style="text-decoration:underline;">Promo Aplicada
                	</span>
                		<%
	                   		//encontroPromo = false;
                   		%>
                        <% //if (articulo.getGastoDeEvio().getNombreCampaign() != null){ %>
                        <br>&nbsp; &middot;<%//=Convert.toString(articulo.getGastoDeEvio().getNombreCampaign(), "")%>
                        <%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getGastoDeEvio().getNombrePromo1() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getGastoDeEvio().getNombrePromo1()%>
                        <%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getGastoDeEvio().getNombrePromo2() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getGastoDeEvio().getNombrePromo2()%>
						<%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getGastoDeEvio().getNombrePromo3() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getGastoDeEvio().getNombrePromo3()%>
                        <%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getGastoDeEvio().getNombrePromo4() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getGastoDeEvio().getNombrePromo4()%>
						<%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (articulo.getGastoDeEvio().getNombrePromo5() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getGastoDeEvio().getNombrePromo5()%>
                        <%
                        	//encontroPromo = true;
                        	//} %>
                        <% //if (!encontroPromo) {
                        %>
							<br>&nbsp; &middot;Cheque obsequio
                        <%
                        //}
                        %>
                        <br>&nbsp;
                	</td>
                	<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">

					</td>

                </tr-->
	                <%//} %>

	 <%//} %>


		<%

		//if (articulo.getPapelDeRegalo() != null) {%>
		<!-- tr>

          	<td valign="top" align="left" colspan=2>
          		<br>
          		<%//=articulo.getPapelDeRegalo().getTitulo()%>
      		</td>

					<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">
					</td>


             </tr>
				<tr>
			        <td valign="top" align="left">
          		<br>
						Precio:
					</td>

					<td valign="top"  align="right">
          		<br>
 						<%//=Contenido.precioToString(articulo.getPapelDeRegalo().getPrecioConImpuesto()) %>
 					</td>

				<%
				//	rowspan = 1;
				//	rowspan = (papPromo)? rowspan + 2: rowspan;


				%>
 				    <td rowspan="<%//=rowspan %>" class="columnaProducto" style="background-color: #B5DEF7;" align="right">
						<b>

	 					<%//= Contenido.precioToString((articulo.getPapelDeRegalo().getPrecioPromocion()< articulo.getPapelDeRegalo().getPrecioConDescuento())? articulo.getPapelDeRegalo().getPrecioPromocion() * articulo.getPapelDeRegalo().getCantidad(): articulo.getPapelDeRegalo().getPrecioConDescuento() * articulo.getPapelDeRegalo().getCantidad()) %>
						</b>
					</td>

                </tr>
                <%	//	if(papPromo) {

				%>
				<tr>
                	<td valign="middle" align="left">
                		Promoción:
                	</td>

                	<td valign="middle" align="right">

						<font color="red" size="1">

							-<%//= Contenido.precioToString(articulo.getPapelDeRegalo().getPrecioConImpuesto() - articulo.getPapelDeRegalo()
							//		.getPrecioPromocion())%>
						</font>
					</td>
                </tr>
                <tr>
                	<td valign="middle" align="left">
                		Precio Final:
                	</td>

                	<td valign="middle" align="right" style="border-top: 1px solid black">

							<%//= Contenido.precioToString(articulo.getPapelDeRegalo().getPrecioPromocion())%>

					</td>
                </tr>

                <tr>
                	<td colspan =2>
                	<br>&nbsp; <span style="text-decoration:underline;">Promo Aplicada</span>
						<%
	                   	//	encontroPromo = false;
                   		%>
                        <%// if (articulo.getPapelDeRegalo().getNombreCampaign() != null){ %>
                        <br>&nbsp; &middot;<%//=Convert.toString(articulo.getPapelDeRegalo().getNombreCampaign(), "")%>
                        <%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (articulo.getPapelDeRegalo().getNombrePromo1() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getPapelDeRegalo().getNombrePromo1()%>
                        <%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (articulo.getPapelDeRegalo().getNombrePromo2() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getPapelDeRegalo().getNombrePromo2()%>
                        <%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (articulo.getPapelDeRegalo().getNombrePromo3() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getPapelDeRegalo().getNombrePromo3()%>
						<%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (articulo.getPapelDeRegalo().getNombrePromo4() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getPapelDeRegalo().getNombrePromo4()%>
                        <%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (articulo.getPapelDeRegalo().getNombrePromo5() != null){ %>
                        <br>&nbsp; &middot;<%//=articulo.getPapelDeRegalo().getNombrePromo5()%>
						<%
                        //	encontroPromo = true;
                        //	} %>
                        <%// if (!encontroPromo) {
                        %>
							<br>&nbsp; &middot;Cheque obsequio
                        <%
                        //}
                        %>
                        <br>&nbsp;
                	</td>
            		<td  class="columnaProducto" style="background-color: #B5DEF7;"  align="right">

					</td>

	                <%//} %>




</tr>
	 <%//} %>

<tr height="1">
	<td colspan = "<%=colspanEspacio%>" style="background-color: #5AB5DE; font-size:1">

	</td>
</tr-->



<tr style="font-size:2">
	<%	if (ordenDAO.isReadWrite()) { %>
	<td class="columnaProducto"></td>
	<td class="columnaProducto"></td>
	<%	}
	%>

	<td class="columnaProducto"></td>


		<td class="columnaProducto" colspan="2">&nbsp;</td>




	<td class="columnaProducto"></td>
	<td class="columnaProducto" style="background-color: #B5DEF7;">

	</td>

	<%	if (ordenDAO.isReadWrite()) { %>
			<td class="columnaProducto"></td>
	<%	}
	%>
</tr>

<tr style="font-size:1">
	<td style="background-color: #B5DEF7" colspan="3"></td>

	<%	if (ordenDAO.isReadWrite()) { %>
		<td style="background-color: #B5DEF7" colspan="2"></td>
	<%	}
	%>

	<td style="background-color: #B5DEF7;" ></td>
		<td style="background-color: #5AB5DE;" ></td>


	<%	if (ordenDAO.isReadWrite()) { %>
			<td style="background-color: #B5DEF7;"></td>
	<%	}
	%>
</tr>

<%
	}
%>



<tr>
	<td style="background-color: #B5DEF7"></td>
	<td style="background-color: #B5DEF7"></td>
	<td style="background-color: #B5DEF7"></td>

	<%	if (ordenDAO.isReadWrite()) { %>
		<td style="background-color: #B5DEF7"></td>
		<td style="background-color: #B5DEF7"></td>
	<%	}
	%>

	<td style="background-color: #B5DEF7; text-align: right;">Subtotal</td>
	<td style="background-color: #5AB5DE;" align="right">
		<b>
 			<%= Contenido.precioToString(ordenDAO.totalProductos()) %>
		</b>
	</td>

	<%	if (ordenDAO.isReadWrite()) { %>
			<td style="background-color: #B5DEF7;">&nbsp;</td>
	<%	}
	%>
</tr>

<%	if (ordenDAO.isReadWrite() && Convert.toBoolean(request.getAttribute(CompraHelper.FLAG_ES_CARRITO), false)) {
		request.removeAttribute(CompraHelper.FLAG_ES_CARRITO);
%>
		<tr style="font-weight: bold; background-color: #5AB5DE;">
			<td colspan="6" style="text-align: right;">
				<i>
					&iquest;Desea utilizar papel de regalo y escribir una dedicatoria ?
				</i>
			</td>

			<td colspan="2" style="text-align: center;">
				<input type="radio" name="<%= CompraHelper.FLAG_PAPEL %>" value="true" <%= ( (ordenDAO.getPedirPapelesYNotas()) ? " checked " : "" ) %>> Si
				<input type="radio" name="<%= CompraHelper.FLAG_PAPEL %>" value="false" <%= ( (!ordenDAO.getPedirPapelesYNotas()) ? " checked " : "" ) %>> No
			</td>
		</tr>
<%	}
%>
<script>
function quitaBotonArticulo() {
	for (i=0; i< <%=contadorArticulos%>; i++) {
		document.getElementById('eliminar'+i).style.display = 'none';
		document.getElementById('lista'+i).style.display = 'none';
	}
}
</script>

</table>
