<%@ page import="com.tmk.kernel.Globals, 
				 com.tmk.kernel.Convert, 
				 com.tmk.setup.Contenido,
				 com.tmk.kernel.DBUtil,
				 com.tmk.controllers.buscador.BusquedaPorIDdeAutor,
				 com.tmk.controllers.buscador.BuscadorHelper,
				 com.tmk.kernel.TmkLogger,
                 com.tmk.controllers.MainHelper"%>
<%
int idSeccion = Convert.toNumber(request.getParameter(MainHelper.FIELD_ID_SECCION), Globals.SECCION_HOME);
try {

	String role = (idSeccion == Globals.SECCION_PELICULA)?"'E01', 'D02'":"'A01'";
	String idAutor = "";
	for (int i=0; i< Contenido.getSite().getPaginas().getPaginaCount(); i++) {
		if (Contenido.getSite().getPaginas().getPagina(i).getId() == idSeccion) {

			for (int j=0; j<Contenido.getSite().getPaginas().getPagina(i).getFavoritos().getAutorCount(); j++) {
				idAutor = idAutor + Contenido.getSite().getPaginas().getPagina(i).getFavoritos().getAutor(j).getId() + ","; 
			}
			break;
		}
	}

	if (idAutor.length()>0) {
		idAutor = idAutor.substring(0, idAutor.length()-1);
		String [][] favoritos = DBUtil.getFavoritos(idSeccion, role, idAutor);


%>
		<table width="390" border="0" cellpadding="0" cellspacing="0" class="modulosmedio-top">
		  <tr>
		    <td colspan="2" class="titulosceldas"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/t-favorito.gif" /></td>
		  </tr>
<%
		for (int i=0; favoritos != null && i< favoritos.length; i++) {
			if (favoritos[i][0] != null) {
				if (i%2 == 0) {
	%>
			  <tr>
	<%
				}
	%>		  			
				<%
				BusquedaPorIDdeAutor busquedaDAO = new BusquedaPorIDdeAutor ((idSeccion == Globals.SECCION_MUSICA)?favoritos[i][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(favoritos[i][1]).toUpperCase()
						, favoritos[i][0], new Integer(idSeccion), new Integer(0), new Integer(10),BuscadorHelper.CRIT_MAS_VENDIDOS, false);
				
				%>
	
			    <td width="50%"><table width="185" border="0" align="left" cellpadding="0" cellspacing="0" class="artistastablaprin">
			      <tr>
			        <td align="left"><table width="175" border="0" cellpadding="0" cellspacing="0" class="artistastabla2">
			          <tr>
			            <td width="35"><div align="left"><img src="/imagenes/<%=Globals.seccion(idSeccion)%>/artistas-flecha.jpg" width="30" height="21" /></div></td>
			            <td width="140" valign="bottom"><div align="left"><a href="<%=busquedaDAO.salto()%>" class="Fautores<%=idSeccion%>"><%=(idSeccion == Globals.SECCION_MUSICA)?favoritos[i][1].replaceAll("\\[MUS]", ""):Convert.nombrePropio(favoritos[i][1]).toUpperCase()%></a></div></td>
			          </tr>
			          <tr>
			            <td colspan="2" class="artistascelda"><a href="<%=busquedaDAO.salto()%>" class="Fautores"><%=favoritos[i][2]%> <%=Convert.plural(new Integer(favoritos[i][2]).intValue(), Globals.productoSeccion(idSeccion)) %> </a></td>
			          </tr>
			        </table></td>
			      </tr>
			    </table></td>
	<%
					if (i%2 == 1) {
	%>
			    		</tr>					
	<%
					}
	%>		    
	<%
			}
		}
%>		  
		</table>

<%
	}
} catch (Exception e) { 
	TmkLogger.debug("Favoritos] pagina en generacio " + "idSeccion " + idSeccion + " " +  e);
}
%>