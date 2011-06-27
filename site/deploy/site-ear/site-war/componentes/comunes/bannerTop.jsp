<%@ page import="com.tmk.setup.Contenido, 
				 com.tmk.kernel.site.Paginas,
				 com.tmk.kernel.site.Pagina,
				 com.tmk.kernel.Convert,
				 com.tmk.kernel.site.types.TipoUrlType,
				 com.tmk.kernel.Globals "
%>

<table cellspacing=0 cellpadding=0 border=0>
	<tr>		
<%

Paginas paginas = Contenido.getSite().getPaginas();

for (int i = 0; i < paginas.getPaginaCount(); i++) {
	Pagina pagina = paginas.getPagina(i);	
	
	if(pagina.getId() == Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_HOME)){	
		int cantidadBanners = pagina.getBannersTop().getBannerCount();
		
		for (int j = 0; j < cantidadBanners;  j++){
			
			String urlBanner = pagina.getBannersTop().getBanner(j).getUrl();
			TipoUrlType tipoUrl = pagina.getBannersTop().getBanner(j).getTipoUrl();
			
			if(tipoUrl.toString().equals("HTML")){
%>				
				<td> <jsp:include page="<%=urlBanner%>"/> </td>
				
<%					
			}else{				
%>
				<td> <img src ="<%=urlBanner%>"> </td>							
<%
			}		
		}	
	 break;	
	}   
}
%>
	</tr>
</table>
