/*mesaInicio*/
function verificarFiltros() {
	$.ajax({
		type : 'GET',
		cache : false,
		url : '/contenidosEstaticos/articulos/mesa/filtroOrden.html',
		data : 'par=' + Math.random(),
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			var cboF = new Array();
			
			//tematika recomienda
		    cboF = new Array();
			if (obj.filtroOrden.M_TMK_RDA) {
				cboF[cboF.length] = new Array('M', 'Últimos tres meses');
			}
			if (obj.filtroOrden.M_TMK_RDA) {
				cboF[cboF.length] = new Array('Y', 'Último año');
			}	
		    if (obj.filtroOrden.M_TMK_RDA) {
			    cboO[cboO.length] = new Array('TMK_RDA', 'Te Recomendamos');
			    hasFiltros.put('TMK_RDA', cboF);
		    }
			
		    cboF = new Array();
			if (obj.filtroOrden.M_MV) {
		    	cboF[cboF.length] = new Array('M', 'Últimos tres meses');
		    }
			if (obj.filtroOrden.Y_MV) {
		    	cboF[cboF.length] = new Array('Y', 'Último año');
		    }   
	
		    if (obj.filtroOrden.M_MV || obj.filtroOrden.Y_MV) {
		    	cboO[cboO.length] = new Array('MV', 'Más Vendidos');
		    	hasFiltros.put('MV', cboF);
		    }
	
			cboF = new Array();
	
			if (obj.filtroOrden.M_MVA) {
				cboF[cboF.length] = new Array('M', 'Últimos tres meses');
			}
			if (obj.filtroOrden.Y_MVA) {
				cboF[cboF.length] = new Array('Y', 'Último año');
			}				
			if (obj.filtroOrden.T_MVA) {
				cboF[cboF.length] = new Array('T', 'Todos');
			}
		    if (obj.filtroOrden.M_MVA || obj.filtroOrden.Y_MVA || obj.filtroOrden.Y_MVA) {
		    	cboO[cboO.length] = new Array('MP', 'Más Populares');
		    	hasFiltros.put('MVA', cboF);
		    }
	
		    cboF = new Array();
	
		    if (obj.filtroOrden.M_MP) {
		    	cboF[cboF.length] = new Array('M', 'Últimos tres meses');
		    }
		    if (obj.filtroOrden.Y_MP) {
				cboF[cboF.length] = new Array('Y', 'Último año');
		    }			    
		    if (obj.filtroOrden.T_MP) {
				cboF[cboF.length] = new Array('T', 'Todos');
		    }
		    if (obj.filtroOrden.M_MP || obj.filtroOrden.Y_MP || obj.filtroOrden.Y_MP) {
			    cboO[cboO.length] = new Array('MVA', 'Más Valorados');
			    hasFiltros.put('MP', cboF);
		    }
		    
			if (cboO.length==0) {
				$('#mesa').get(0).style.display = 'none';
			} else {
				orden = cboO[0][0];
				filtro = hasFiltros.get(orden)[0][0];
				$('#mesa').get(0).style.display = 'block';
			}
			cargarCbos();
			getTotal();
		}
	});
}


//Total de articulos por categoria
function getTotal() {
	inicializarVariables();
	var aux = "";
	$.ajax({
		type : 'GET',
		url : '/contenidosEstaticos/articulos/mesa/total' + filtro + '_' + orden + '.html',
		data : 'par=' + Math.random(),
		cache : false,
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			for (i=0; i<idsCat.length; i++) {
		      	  total[idsCat[i]] = Math.ceil(obj.total[idsCat[i]]/tamView[idsCat[i]]);
 				  totalNro[idsCat[i]] = obj.total[idsCat[i]];
			      getByCategoria(idsCat[i], 0, imgPre, datos);
			      //controlo que se habiliten o no los botones de siguiente y anterior
			      if(totalNro[idsCat[i]] < 5 || (idsCat[i]==4 && totalNro[idsCat[i]]==6)) {
			    	aux = '#siguiente' + idsCat[i];
			    	$(aux).get(0).href = 'javascript:nada()';
			    	aux = '#siguiente'+idsCat[i]+'DIV';
			  		$(aux).get(0).className = 'mesaSiguienteDeshabilitada';
			      }
		      }
		      //la funcion esta en jsSeccionInicio.jsp
		      lanzarMensajes();
		}
	});
}


//Articulos filtrados y ordenados a partir de una pagina (desde)
function getByCategoria(idCategoria, desde, arrIMG, arrDatos){
	var parDesde = (desde==0)?desde+1:desde;
	var url = '/contenidosEstaticos/articulos/mesa/lista' + filtro + '_' + orden + '_sec' + idCategoria + '_pag' + parDesde + '.html';
	$.ajax({
		type : 'GET',
		url : url,
		data : 'par=' + Math.random(),
		cache : false,
		success : function(data) {
			var obj = jQuery.parseJSON(data);
			arrDatos[idCategoria] = obj.lista;
			if (desde == 0) {
			  	cargarImgInicial(idCategoria, arrIMG, arrDatos);
			} else {
				cargarImg(idCategoria, arrIMG, arrDatos);
			}			
		}
	});
}
