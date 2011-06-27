<%@ page import="javax.naming.InitialContext,
                 com.tmk.setup.Contenido,
                 javax.sql.DataSource,                 
                 com.tmk.kernel.Convert,
                 com.tmk.kernel.Globals,
                 com.tmk.kernel.site.*" %>

<%
	int idSeccion = Convert.toNumber(request.getParameter("idSeccion"),Globals.SECCION_LIBRO);
	String nombreGrupo = Convert.toString(request.getParameter("nombreGrupo"));
	Site site = Contenido.getSite();
	Ranking ranking = site.getRanking();

	if (nombreGrupo == null) {
		for (int i = 0; i < ranking.getRankingSeccionCount(); i++) {
			RankingSeccion rankingSeccionDef = ranking.getRankingSeccion(i);
			if (rankingSeccionDef.getId() == idSeccion) {
				RankingGrupo rankingGrupoDef = rankingSeccionDef.getRankingGrupo(0);
				//nombreGrupo=rankingGrupoDef.getNombre();
				break;
			}
		}
	}
%>


<td><table width="140" border="0" align="center" cellpadding="0" cellspacing="0">
       <tr>
          <td><span class="Ftexto02">OTROS RANKINGS DESPONIBLES:</span></td>
       </tr>
       <tr>
			<td class="moduloordencelda"><span class="Ftexto02"> - </span><a <% if(idSeccion==Globals.SECCION_LIBRO && "".equals(nombreGrupo)){%> class="Ftexto02"<%}else{%> href="/ranking/index.jsp?idSeccion=<%=Globals.SECCION_LIBRO%>" class="Flink02"<%}%>><%=Convert.corregir(Globals.seccion(Globals.SECCION_LIBRO),true)%></a></td>
       </tr>	
       
<%
	  for (int ri = 0; ri < ranking.getRankingSeccionCount(); ri++) {
		RankingSeccion rankingSeccion = ranking.getRankingSeccion(ri);
		if(rankingSeccion.getRankingGrupoCount() > 1){			
				for (int rg = 0; rg < rankingSeccion.getRankingGrupoCount(); rg++) {
					RankingGrupo rankingGrupo= rankingSeccion.getRankingGrupo(rg);
					String pag="/ranking/index.jsp?idSeccion=" + rankingSeccion.getId() + "&nombreGrupo=" + rankingGrupo.getNombre(); 
			%>                     
			<tr>
				<td class="moduloordencelda"><span class="Ftexto02"> - </span><a <% if(rankingGrupo.getNombre().equals(nombreGrupo)){%> class="Ftexto02"<%}else{%> href="<%=pag%>" class="Flink02"<%}%>><%=Convert.corregir(Globals.seccion(rankingSeccion.getId()),true)%> > <%=rankingGrupo.getNombre()%></a></td>
            </tr>	       	       
 	       
 	       <%   }
		}else{%>
			<tr>
				<td class="moduloordencelda"><span class="Ftexto02"> - </span><a href="/ranking/index.jsp?idSeccion=<%=rankingSeccion.getId()%>" <%=(idSeccion==rankingSeccion.getId())?"class=Ftexto02" :"class=Flink02"  %>><%=Convert.corregir(Globals.seccion(rankingSeccion.getId()),true)%></a></td>
            </tr>	      		
<%		} 
     }  
%>
         </table></td>

