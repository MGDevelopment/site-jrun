<script type="text/javascript">
//<![CDATA[ 
function getComentarios(seLanza) {
	if(seLanza) {
		var url = 'par='+Math.random();		
		$.ajax({	
			type:'POST',
			cache:false,
			url: "/GetComentarioHome",
			data:url,
			dataType: "html",
			beforeSend: function(obj){
				var div = '#comentarios';
				$(div).html(divLoading2);
			},			
			success: function(data) {
				var div = '#comentarios';
				$(div).html(data);
				$('#optComentarios').html('&Uacute;ltimos  comentados');
			}
		});
	}	
}	
/**
 * Levanta los cometarios en la home pero cuando se seleccionan mostrar por alguna seccion en particular
 */
function getComentariosB(idSeccion,seLanza) {
	if(seLanza) {
		var url = 'idSeccion='+idSeccion+'&cantidad=4'+'&par='+Math.random();
		if(idSeccion == 1){
			$('#optComentarios').html('Solo libros');
		}else if(idSeccion == 4) {
			$('#optComentarios').html('Solo música');
		}else if(idSeccion == 5) {
			$('#optComentarios').html('Solo peliculas');
		}			
		$.ajax({
			type:'POST',
			cache:false,
			url: "/GetComentarioHome",
			data:url,
			dataType: "html",
			beforeSend: function(obj){
				var div = '#comentarios';
				$(div).html(divLoading2);
			},
			success: function(data) {
				var div = '#comentarios';
				$(div).html(data);
			}
		});
	}	
}
//]]>
</script>
<div class="solapas"><!-- comentarios HOME-->
	<div class="tmtkMesaMenuMod">
    	<div class="solapasTitComent"></div>                
        <ul class="dropdown">
			<li onclick="javascript:desplegarOpciones('listaComentarios');" class="dir">
				<span id="optComentarios">Último comentados</span>
				<ul onmouseout="ocultarOpcionesT('listaComentarios');" onmouseover="clearTimeout(tempo);" id="listaComentarios" style="display: none;">
					<li><a href="javascript:mostrarBuscarPor('lstoptBus1','lstoptBusqueda','listaComentarios');getComentariosB(1,true);" id="lstoptBus1">Solo libros</a></li>
					<li><a href="javascript:mostrarBuscarPor('lstoptBus2','lstoptBusqueda','listaComentarios');getComentariosB(4,true);" id="lstoptBus2">Solo musica</a></li>
					<li><a href="javascript:mostrarBuscarPor('lstoptBus3','lstoptBusqueda','listaComentarios');getComentariosB(5,true);" id="lstoptBus3">Solo peliculas</a></li>
					<li><a href="javascript:mostrarBuscarPor('lstoptBus4','lstoptBusqueda','listaComentarios');getComentarios(true);" id="lstoptBus4">Últimos comentados</a></li>
				</ul>
			</li>
		</ul>                
	</div>
	<div id="comentarios"></div>
</div>
<script type="text/javascript">
//<![CDATA[ 
	getComentarios(true);
//]]>
</script>