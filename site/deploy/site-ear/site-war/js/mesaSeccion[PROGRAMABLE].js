var subSeccion="";
function verificarFiltros() {
	var url = '/contenidosEstaticos/articulos/mesa/filtroOrdenCat_sec' + idsCat[0];
	if (subSeccion != "") {
		url = url + subSeccion;
	}
	url = url + '_.html?par=' + Math.random();
	new Ajax.Request(url,
		 { method:'get',
		   onSuccess: function(transport){
			    var obj= transport.responseText.evalJSON();
				var cboF = new Array();
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
					$('mesa').style.display = 'none';
				} else {
					orden = cboO[0][0];
					filtro = hasFiltros.get(orden)[0][0];
					$('mesa').style.display = 'block';
				}
				cargarCbos();
				getTotal();
 			}
 		 }
	);
}
//Total de articulos por categoria
function getTotal() {
	inicializarVariables();
	var url = '/contenidosEstaticos/articulos/mesa/totalCat' + filtro + "_" + orden + '_sec' + idsCat[0];
	if (subSeccion != "") {
		url = url + subSeccion;
	}
	url = url + '_.html?par=' + Math.random();
	new Ajax.Request(url,
		 { method:'get',
		   onSuccess: function(transport){
		      var obj= transport.responseText.evalJSON();
		      for (i=0; i<idsCat.length; i++) {
		      	  total[idsCat[i]] = Math.ceil(obj.total/tamView[idsCat[i]]);
   				  totalNro[idsCat[i]] = obj.total;
			      getByCategoria(idsCat[i], 0, imgPre, datos);
		      }
 			}
 		 }
	);
}
//Articulos filtrados y ordenados a partir de una pagina (desde)
function getByCategoria(idCategoria, desde, arrIMG, arrDatos){
	var parDesde = (desde==0)?desde+1:desde;
	var url = '/contenidosEstaticos/articulos/mesa/listaCat' + filtro + '_' + orden + '_sec' + idCategoria;
	if (subSeccion != "") {
		url = url + subSeccion;
	}
	url = url + '__pag' + parDesde + '.html?param=' + Math.random();
	new Ajax.Request(url,
		{
			method:'get',
		   	onSuccess: function(transport){
			var obj= transport.responseText.evalJSON();
				//DIVIDIR
				arrDatos[idCategoria] = obj.lista;
				if (desde == 0) {
				  	cargarImgInicial(idCategoria, arrIMG, arrDatos);
				} else {
					cargarImg(idCategoria, arrIMG, arrDatos);
				}
 			}
 		}
	);
}