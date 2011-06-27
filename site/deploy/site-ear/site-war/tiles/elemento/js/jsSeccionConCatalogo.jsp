<%@page import="com.tmk.generacion.articulo.GeneradorDeArticulo"%>

<script type="text/javascript" src="/js/imagePreloader.js"></script>
<script type="text/javascript" src="/js/hashtable.js"></script>
<script type="text/javascript" src="/js/mesaSeccion.js"></script>
<script type="text/javascript" src="/js/mesa.js"></script>
<script type="text/javascript" src="/js/buscador.js"></script>
<script type="text/javascript">
//var divLoading = '<div class="solapaModulos"><img src=\"/imagenes/rediseno/imagenes/comun/loading.gif\" ></div>';
function getComentariosSeccion(idSeccion,idGrupo,idFamilia,idSubFamilia) {
	var url = 'idSeccion='+idSeccion+'&cantidad=6&idGrupo='+idGrupo+'&idFamilia='+idFamilia+'&idSubFamilia='+idSubFamilia+'&par='+Math.random();
	//alert(idSeccion+"-"+idGrupo+"-"+idFamilia+"-"+idSubFamilia);	
	$.ajax({
		type:'POST',
		cache:false,
		url: "/GetComentarioSeccion",
		data:url,
		dataType: "html",
		beforeSend: function(obj){
			var div = '#divComentarios';
			$(div).get(0).innerHTML = divLoading2;
		},			
		success: function(data) {
			if(null == data || data=='') {
				var div = '#calles3';
				$(div).get(0).innerHTML = '';
			}else {
				var div = '#divComentarios';			
				$(div).get(0).innerHTML = data;
			}
		}
	});	
}
</script>
<script>
	idsCat[0]=<%=request.getAttribute("idSeccion")%>;
	<%	String idGrupo = request.getParameter("idGrupo");
		String idFamilia = request.getParameter("idFamilia");
		String idSubFamilia = request.getParameter("idSubFamilia");
		if (idGrupo != null) {
			StringBuffer subSec = new StringBuffer();
			subSec.append("subSeccion=\"_");
			subSec.append(idGrupo);
			if (idFamilia != null) {
				subSec.append("_").append(idFamilia);
				if (idSubFamilia != null) {
					subSec.append("_").append(idSubFamilia);
				}
			}
			subSec.append("\";");
			out.print(subSec.toString());
		}
	%>		
	tamView[<%=((Integer)request.getAttribute("idSeccion")).intValue()%>] = <%=GeneradorDeArticulo.MESA_TAM_VIEW_SECCION[((Integer)request.getAttribute("idSeccion")).intValue()]%>;
</script>
<script>
$(document).ready(function() {
	verificarFiltros();
});
</script>