<%
String idSeccion = request.getParameter("idSeccion");
String precio = request.getParameter("precio");
%>
<script type="text/javascript">

	var httpModEx = getAjax();
	var http = getAjax();
	var httpComent = getAjax();

	function traerModuloExtra() {
	    httpModEx.open('get', '/articulo/componentes/moduloExtra.jsp?idSeccion=<%=idSeccion%>&precio=<%=precio%>&param=' + Math.random());
	    httpModEx.onreadystatechange = moduloExtra;
	    httpModEx.send(null);
	}

	function moduloExtra() {
	    if(httpModEx.readyState == 4){
	        var response = httpModEx.responseText;
	        document.getElementById('moduloExtra').innerHTML = response;
	    }
	}

	function traerCompartir(urlPage, titulo) {
		ejecutarAjax('/articulo/componentes/compartir.jsp','param=' + Math.random()
		+ '&urlPage=' + urlPage + '&titulo=' + titulo, 'GET', 'traerCompartir');
	}

	function handle(connAj, params) {


		if (params == 'traerCompartir') {

			if(connAj.readyState == 4){
				$('compartir').innerHTML = connAj.responseText;
			} else {
			}
		}
		if (params == 'enviarRecomendacion') {
			if(connAj.readyState == 4){
				$('mensajeLoad').style.display = 'none';
				var obj = (connAj.responseText).evalJSON();
				if (obj.Resultado.valor) {
					$('exito').style.display = '';

				} else {
					verForm();
					resetForm(false);
					$('mensajeError').innerHTML = '';
					if (obj.Resultado.mensaje != null) {
						for(i=0; i<obj.Resultado.mensaje.length; i++) {
							$('mensajeError').innerHTML = $('mensajeError').innerHTML +
							obj.Resultado.mensaje[i] + '<br>';
						}
						$('mensajeError').style.display = "";
					}
					if (obj.Resultado.campo != null) {
						var campo = eval ('document.frmRecomendacion.' + obj.Resultado.campo[0]);
						campo.focus();
						for(i=0; i<obj.Resultado.campo.length; i++) {
							var campo = eval ('document.frmRecomendacion.' + obj.Resultado.campo[i]);
							campo.style.backgroundColor = "#FF6666";
							//campo.style.color = "#FFFFFF";
						}
					}
				}
			} else {
				$('mensajeLoad').style.display = '';
			}
		}
	}

	function enviarRecomendacion() {
		var frm = document.frmRecomendacion;
		var params = 'param=' + Math.random()
				   + '&correoAmigo=' + frm.correoAmigo.value
				   + '&correoPropio=' + frm.correoPropio.value
				   + '&nombrePropio=' + frm.nombrePropio.value
				   + '&urlPage=' + frm.urlPage.value;
		ejecutarAjax('/articulo/enviarRecomendacion.jsp', params, 'POST',
					'enviarRecomendacion');

		$('titulo').style.display = 'none';
		$('frmEnvio').style.display = 'none';
		$('enviar').style.display = 'none';
	}

	function verForm() {
		$('exito').style.display = 'none';
		$('titulo').style.display = '';
		$('frmEnvio').style.display = '';
		$('enviar').style.display = '';
		$('mensajeError').style.display ='none';
	}

	function resetForm(borrar) {
		var frm = document.frmRecomendacion;
		for (i=0; i<frm.elements.length; i++) {
			if (frm.elements[i].type == 'text') {
				frm.elements[i].style.backgroundColor = "#ffffff";
				if(borrar) {
					frm.elements[i].value = '';
				}
			}
		}
	}

	function enviarOtraReco() {
		resetForm(true);
		verForm();

	}
	
	function verMasComentarios(idArticulo, idSeccion, cantidad) {
        new Ajax.Request('/articulo/componentes/comentario.jsp?param=' + Math.random() + '&idArticulo=' + idArticulo 
        		+ '&idSeccion=' + idSeccion + "&cantidad=" + cantidad,        		
                     { method:'get',
                       onSuccess: function(transport){
            				if(transport.readyState==4){
	                            var cont = transport.responseText.split("\"KEY_PARSER_POPEGO\"");
	                            $('comentarios').innerHTML=cont[0];
	                          	eval(cont[1]);
            				}else {
            					if ($('mensajeLoad2')) {
            						$('mensajeLoad2').style.display = 'block';
            					}
            				}
                          }
                     }
              );
	 }

</script>