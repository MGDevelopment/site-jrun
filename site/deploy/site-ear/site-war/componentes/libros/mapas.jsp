<%@ page import="javax.servlet.ServletContext,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.site.Pagina,
                 com.tmk.bus.articulo.ArticuloManager,                 
                 com.tmk.setup.Contenido"
%>
<%
ServletContext servletContext = Contenido.getServletContext();	

int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);

Pagina paginaXML = null;

for (int i=0; i<Contenido.getSite().getPaginas().getPaginaCount(); i++) {
	if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {
		paginaXML = Contenido.getSite().getPaginas().getPagina(i);	
	}	
}
int cantidadDeMapas = 0;
if (paginaXML != null) {
	cantidadDeMapas = paginaXML.getMapas().getMapaCount();
}	

int cantidad = 0;

String mapa = "";
String tituloMapa="";	
String urlMapa = "";

%>
<link href="/estilos/comun.css" rel="stylesheet" type="text/css" />
<link href="/estilos/seccion_<%=Globals.seccion(idSeccion)%>.css" rel="stylesheet" type="text/css" />

 <tr>
     <td><table width="386" border="0" cellpadding="0" cellspacing="0" class="modulorecomendadosd">
              <tr>
                  <td width="50" class="titulosceldas"><table width="387" border="0" cellpadding="0" cellspacing="0" class="titulosceldas2">
                     <tr>
                        <td><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-mapas.gif" alt="Mapas" width="43" height="10" /></td>
                     </tr>
                   </table></td>
              </tr>
              <tr>
                 <td> <table width="387" border="0" align="center" cellpadding="0" cellspacing="0">
               
		<%for (int x=0; x<cantidadDeMapas; x=x+3) { %>
			 			 <tr>
						<%for (int i=0+x; i<Math.min(3+x, cantidadDeMapas); i++) { 
							
							mapa = paginaXML.getMapas().getMapa(i).getTipo().toString();				
						
							if("BIOGRAFIA".equals(mapa)){
								tituloMapa="BIOGRAFIAS";
								if (Globals.mapaAutoresBiografia == null) {
									ArticuloManager.getAutoresBiografia(idSeccion,"'A01'",servletContext);
								}
								cantidad = Globals.mapaAutoresBiografia.length;
								urlMapa = "biografias.jsp?idSeccion=" + idSeccion;
								
							}else if("ENTREVISTA".equals(mapa)){
								tituloMapa="ENTREVISTAS";			
								cantidad = (ArticuloManager.getAutorDeEntrevista(idSeccion, servletContext).length) / 3; 
								urlMapa = "entrevistas.jsp?idSeccion=" + idSeccion;
								
							}else if("COMENTARIO".equals(mapa)){								
								tituloMapa="COMENTARIOS DE CLIENTES";							
								cantidad = ArticuloManager.getArticulosConComentarios(idSeccion, servletContext).length;
								urlMapa = "comentarios.jsp?idSeccion=" + idSeccion;
								
							}else if("INDICEDECONTENIDO".equals(mapa)){
								tituloMapa="INDICES DE CONTENIDO";								
								cantidad = ArticuloManager.getArticulosConIndiceDeContenidos(servletContext).length;
								urlMapa = "indiceDeContenidos.jsp?idSeccion=" + idSeccion;
								
							}else if("PRIMERCAPITULO".equals(mapa)){
								tituloMapa="PRIMEROS CAPITULOS";								
								cantidad = ArticuloManager.getArticulosConPrimerCapitulo(servletContext).length;
								urlMapa = "primerosCapitulos.jsp?idSeccion=" + idSeccion;
								
							}else if("EDITORIAL".equals(mapa)){
								tituloMapa="EDITORIAL";								
								cantidad = 0;//FALTA DESARROLLAR
								urlMapa = "";
							}
							
						%>
							<td valign="top"><table width="120" border="0" align="left" cellpadding="0" cellspacing="0" class="mapastablaafuera">
							    <tr>
							      <td><div align="center">
							          <table width="112" border="0" cellspacing="0" cellpadding="0" class="mapastablaint">
							            <tr>
							              <td valign="top" class="mapascelda1"><a href="/mapa/<%=urlMapa%>" class="FProductos"><%=tituloMapa%> <br>(<%=cantidad%>)<br />
							              </a></td>
							            </tr>
							            <tr>
							              <td valign="bottom" class="mapascelda2"><a href="/mapa/<%=urlMapa%>"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/b-mapa.gif" alt="Ir a mapa" width="52" height="8" border="0" /></a></td>
							            </tr>
							          </table>
							      </div></td>
							    </tr>
							</table></td>
						<%}%>
						</tr>
		<%}%>
			</table></td></tr>
	</table></td>
</tr>