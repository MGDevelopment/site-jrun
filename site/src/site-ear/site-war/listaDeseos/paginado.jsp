<%@ page import="com.tmk.kernel.Convert,
                 java.util.Vector"%>
               
<%
int cantArticulosPorPagina = Convert.toNumber(request.getParameter("cantArticulosPorPagina"), 5);

String articulos = Convert.toString(request.getParameter("articulos"));

int comienzo = Convert.toNumber(request.getParameter("comienzo"),1);

String arrArticulos [] = articulos.split(",");
Vector ids = new Vector(arrArticulos.length);
for (int i=0; i<arrArticulos.length; i++) {
	ids.add(arrArticulos[i].trim());
}
%>
<%
String idsArt="";
int totalProductos = ids.size();
int totalPaginas = (int)Math.ceil((double)totalProductos/cantArticulosPorPagina);
int paginaActual = (int)Math.ceil((double)comienzo/cantArticulosPorPagina);
%>

<script language="javascript">
var totalPaginas = <%=totalPaginas%>
function resaltar(nro) {
	for (i=1; i<=totalPaginas; i++) {
		eval("document.getElementById('pagina" + i + "').style.fontWeight = '500';");
	}
	eval("document.getElementById('pagina" + nro + "').style.fontWeight = '900';");
}
</script>

<table align="center">
	<tr>
<%  if (totalPaginas>1) {%>
		<td width=70 align="right">
			<span class="Ftexto05">|</span>
		</td>

		<td  align="center">
<%
       /* for (int x=Math.max(paginaActual-5, 1); 
				x<Math.min(Math.max(paginaActual-5, 1)+10, totalPaginas+1); x++) {*/
    	for (int x = 1; x<=totalPaginas; x++){   
           	idsArt = ids.subList((((x*cantArticulosPorPagina))-cantArticulosPorPagina), Math.min((x*cantArticulosPorPagina), ids.size())).toString().replaceAll("\\[", "").replaceAll("\\]", "");	
%>	
			<% if (x==paginaActual) { %>		
			<a id="pagina<%=x%>" style="font-weight:900" href="javascript:traerLista('<%=idsArt%>');resaltar(<%=x%>)" class="FAyuda"><%=x %></a>
			<%} else { %>
			<a id="pagina<%=x%>"  href="javascript:traerLista('<%=idsArt%>');resaltar(<%=x %>) " class="FAyuda"><%=x %></a>
			<%} %>
	<%	} %>
		</td>

		<td width="70" align="left">
			<span class="Ftexto05">|</span>
		</td>
<%	} %>
	</tr>
</table>	