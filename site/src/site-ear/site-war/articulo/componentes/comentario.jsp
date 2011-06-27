<%@ page import="com.tmk.kernel.Convert,com.tmk.common.ComentarioClass,com.tmk.kernel.Globals,com.tmk.controllers.comentario.ComentarioHelper"
%>

<%
	int idArticulo = Convert.toNumber(request.getParameter("idArticulo"), 0);
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),	Globals.SECCION_LIBRO);
	int cantidad = Convert.toNumber(request.getParameter("cantidad"), 0);
	ComentarioClass comentarios[] = ComentarioClass.getComentariosPorArticulo(idArticulo, cantidad);
	int cantidadAMostrar = (cantidad == 0) ? comentarios.length : 3;
%>
	
<table width="375" border="0" align="center" cellpadding="0"
	cellspacing="0" class="modulosmedio">
	<tr class="modulorecomendadosd">
		<td class="tituloceldasComentario">
		<table width="375" border="0" cellpadding="0" cellspacing="0"
			class="titulosceldas2">
			<tr>
				<td><img
					src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-comentarios.gif"
					alt="Comentarios" /></td>
			</tr>
		</table>
		</td>
	</tr>

	<tr>
		<td width="50" valign="top">
		<table width="375" border="0" cellpadding="0" cellspacing="0"
			class="modulosmedioDetalle3">
			<%
				if (comentarios != null && comentarios.length > 0) {
			%>
			<%
				for (int i = 0; i < Math.min(comentarios.length,cantidadAMostrar); i++) {
			%>
			<tr>
				<td colspan="2">

				<table width="375" border="0" cellpadding="0" cellspacing="0"
					class="Gcomentariostabla">

					<tr>
						<td align="left" valign="bottom" class="GcomentariosceldaUsr">
							<table>
								<tr>
									<td>
										<%=Convert.nombrePropio(comentarios[i].getNickName(), false)%>&nbsp;dijo:
									</td>									
									<%if (comentarios[i].getUserPopego() != null) {%>
									<td>
										<a href="#" onmouseover="($('pe_container_<%=(i + 1)%>').style.display =='block')?$('pe_container_<%=(i + 1)%>').style.display='none':$('pe_container_<%=(i + 1)%>').style.display='block';">
										<img src='/imagenes/popego_favicon.png' width="15px" height="15px" border="0"></a>
									</td>
									<td >
										<a class="Ftexto02" href="#" onmouseover="($('pe_container_<%=(i + 1)%>').style.display =='block')?$('pe_container_<%=(i + 1)%>').style.display='none':$('pe_container_<%=(i + 1)%>').style.display='block';">ver popego de este usuario</a>
									</td>
									<%}%>									
								</tr>
								<%if (comentarios[i].getUserPopego() != null) {%>
								<tr>
									<td colspan="3">
										<div  style="display:none;position:absolute" id="pe_container_<%=(i + 1)%>"></div>
									</td>
								</tr>
								<%}%>								
							</table>
						</td>
					</tr>
					<tr>
						<td align="left" valign="bottom" class="Gcomentarioscelda"><span
							class="Ftexto02"><%=comentarios[i].getTexto().replaceAll("\n", "<br>")%></span>
						</td>
					</tr>
					<tr>
						<td align="left" valign="middle"
							style="text-align: right; background-color: #F3F4F5; border-top: dashed 1px #CCC;">
						<div class="GcomentariosCalif1"><img
							src="/imagenes/coment-<%=comentarios[i].getEvaluacion()%>.gif"></div>
						<div class="GcomentariosCalif2">Calificaci&oacute;n: 
						<%=ComentarioHelper.TEXTOS[comentarios[i].getEvaluacion()- ComentarioHelper.MINIMO_EVALUACION]%></div>
						</td>
					</tr>
				</table>

				</td>
			</tr>

			<%
				}
			%>
			<%
				} else {
			%>
			<tr>
				<td colspan="2">
				<table width="375" border="0" cellpadding="0" cellspacing="0"
					class="Gcomentariostabla">
					<tr>
						<td valign="bottom" align="left" class="Gcomentarioscelda"><span
							class="Ftexto02"> Todavía no se ha realizado ningún
						comentario sobre este producto, podes ser el primero en opinar
						haciendo click en el botón "Agregar comentario". </span></td>
					</tr>
				</table>
				</td>
			</tr>
			<%
				}
			%>
			<tr class="modulosmedio">
				<td width="173">
				<%
					if (comentarios != null && comentarios.length > 3 && cantidad != 0) {
				%><div
					align="left"><a style="cursor: pointer;"
					onclick="verMasComentarios('<%=idArticulo%>', '<%=idSeccion%>', 0)"><img
					src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-vertodos.gif"
					alt="Ver todos los comentarios" border="0" /></a></div>
				<%
					}
				%>
				</td>
				<td width="202">
				<div align="right"><a
					href="/Comentario?ID_ARTICULO=<%=idArticulo%>&idSeccion=<%=idSeccion%>"
					rel="nofollow"><img
					src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-agregarcomentario.gif"
					alt="Agregar comentario" border="0" /></a></div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
"KEY_PARSER_POPEGO"

	

	 var callback = function() {
     var widgets = [];
    /* var my_renderer = new Popego.WidgetRenderer({    	 
         htmlText: "<div class=\"my_widget_css_class\"><table><tr><td><img title=\"Ver Popego de ${user.displayname}\"style=\"width:15px;height:15px;cursor:pointer;\" popego_behavior='onmouseover:show_popcard?toggle=false' src='/imagenes/popego_favicon.png'/>&nbsp;</td><td><a popego_behavior='onmouseover:show_popcard?toggle=false' class='my_link_css_class'>Ver popego de este usuario</a><br/>${user.minibio}</td></tr></table></div>",
         styles: {
             my_link_css_class: {
                 "color":"#F36",
                  "font-size":"10px",
                  "cursor":"pointer"   
             },             
             my_widget_css_class: {
                 "width":"200px"
             },             
             my_widget_css_class_ie6: {
                 "padding":"5px"
             },             
             my_widget_css_class_ie: {
                "padding":"2px"
             }
         }
     });	*/ 	
		<%for (int i = 0; i < comentarios.length; i++) {
				if (comentarios[i].getUserPopego() != null) {%> 
           		widgets.push({
               		key: <%=(1 + i)%>,
               		user: {
                   		username: '<%=(comentarios[i].getUserPopego())%>',
                   		displayname: '<%=(comentarios[i].getNickName())%>'
               		},
               		id: 1,
               		 theme:'t129fc2'/*,
               		renderer: my_renderer*/
           		});
		<%}
			}%>

       	Popego.createWidget(widgets);
       }
       Popego.Config.language = "es";
       Popego.use("widgets", callback);
       
       
       