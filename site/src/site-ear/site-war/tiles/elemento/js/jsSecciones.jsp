<%@page import="com.tmk.generacion.articulo.GeneradorDeArticulo"%>
<%@ taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<tiles:useAttribute name="idGrupo" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<tiles:useAttribute name="idSubFamilia" scope="request" ignore="true" classname="java.lang.String"/>
<script type="text/javascript" src="/js/imagePreloader.js"></script>
<script type="text/javascript" src="/js/hashtable.js"></script>
<script type="text/javascript" src="/js/mesaSeccion.js"></script>
<script type="text/javascript" src="/js/mesaDeSeccion.js"></script>
<script type="text/javascript"> 
idsCat[0]=<%=request.getAttribute("idSeccion")%>; 
tamView[<%=((Integer)request.getAttribute("idSeccion")).intValue()%>] = <%=GeneradorDeArticulo.MESA_TAM_VIEW_SECCION[((Integer)request.getAttribute("idSeccion")).intValue()]%>; 

$(document).ready(function(){
	verificarFiltros();
});
</script>

<script src="http://www.google-analytics.com/urchin.js" type="text/javascript">
</script>
<script type="text/javascript">
	//<![CDATA[ 
	if (typeof(urchinTracker) == 'function') {
    	_uacct = "UA-635166-1";    	
   		urchinTracker();
	}
	//]]>
</script>

<script type="text/javascript">
var divLoading = '<div class="solapaModulos"><img src=\"/imagenes/rediseno/imagenes/comun/loading.gif\" ></div>';
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
			$(div).get(0).innerHTML = divLoading;
		},			
		success: function(data) {
			if(null == data || data=='') {
				var div = '#calles3';
				$(div).get(0).innerHTML = '';
			}else {
				var div = '#'+'divComentarios';
				//var obj = jQuery.parseJSON(data);				
				$(div).get(0).innerHTML = data;
			}
		}
	});	
}
</script>


