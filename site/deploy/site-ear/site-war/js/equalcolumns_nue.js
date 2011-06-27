//** Dynamic Drive Equal Columns Height script v1.01 (Nov 2nd, 06)
//** http://www.dynamicdrive.com/style/blog/entry/css-equal-columns-height-script/

function correctHeights(div1,div2,div3,div4,div5,div6,div7,div8,div9,div0) { 
var ddequalcolumns=new Object();
//Input IDs (id attr) of columns to equalize. Script will check if each corresponding column actually exists:
ddequalcolumns.columnswatch=[div1,div2,div3,div4,div5,div6,div7,div8,div9,div0];

ddequalcolumns.setHeights=function(reset){
	var tallest=0;
	var resetit=(typeof reset=="string")? true : false;
	for (var i=0; i<this.columnswatch.length; i++){
		if (document.getElementById(this.columnswatch[i])!=null){
			if (resetit)
				document.getElementById(this.columnswatch[i]).style.height="auto";
			if (document.getElementById(this.columnswatch[i]).offsetHeight>tallest)
				tallest=document.getElementById(this.columnswatch[i]).offsetHeight;
		}
	}

	if (tallest>0){
		for (var i=0; i<this.columnswatch.length; i++){
			if (document.getElementById(this.columnswatch[i])!=null)
				document.getElementById(this.columnswatch[i]).style.height=tallest+"px";
		}
	}
}

ddequalcolumns.resetHeights=function(){
	this.setHeights("reset");
}

ddequalcolumns.dotask=function(target, functionref, tasktype){ //assign a function to execute to an event handler (ie: onunload)
	var tasktype=(window.addEventListener)? tasktype : "on"+tasktype;
	if (target.addEventListener)
		target.addEventListener(tasktype, functionref, false);
	else if (target.attachEvent)
		target.attachEvent(tasktype, functionref);
}

ddequalcolumns.dotask(window, function(){ddequalcolumns.setHeights()}, "load");
//ddequalcolumns.dotask(window, function(){if (typeof ddequalcolumns.timer!="undefined") clearTimeout(ddequalcolumns.timer); ddequalcolumns.timer=setTimeout("ddequalcolumns.resetHeights()", 200)}, "resize");

}

correctHeights("arbolLibros", "arbolMusica", "arbolPeliculas", "arbolPasatiempos","","","","","","");

correctHeights("panelSeccSucursales", "panelSeccQuid", "seccionTematika", "panelSeccExtra","panelSeccMusica","panelSeccLibros","panelSeccPeliculas","panelSeccPasatiempos","","");

//calles de comentarios de home principal
correctHeights("calleSeparadorComents", "calleLibrosComents", "callePeliculasComents", "calleMusicaComents","callePasatiemposComents","calleSeparadorComents2","calleSeparadorComents3","","","");
correctHeights("comentarios01", "comentarios02", "comentarios03", "comentarios04","","","","","","");

//calles de listas de home principal/secciones
correctHeights("calleSeparadorListas", "calleLibrosListas", "callePeliculasListas", "calleMusicaListas","callePasatiemposListas","calleSeparadorListas2","calleSeparadorListas3","","","");

//calles de usuarios de home principal/secciones
correctHeights("calleSeparadorUsuarios", "calleLibrosUsuarios", "callePeliculasUsuarios", "calleMusicaUsuarios","callePasatiemposUsuarios","calleSeparadorUsuarios2","calleSeparadorUsuarios3","","","");

//calles de comentarios de home de secciones
correctHeights("calleComents01", "ccalleComents02", "calleComents03", "calleSeparadorComents","calleSeparadorComents2","","","","","");
correctHeights("calleComents04", "ccalleComents05", "calleComents06", "calleSeparadorComents3","calleSeparadorComents4","","","","","");
correctHeights("comentarios01", "comentarios02", "comentarios03", "","","","","","","");
correctHeights("comentarios04", "comentarios05", "comentarios06", "","","","","","","");

//detalle de producto/autor
correctHeights("dInfoCompl", "dRecomendaciones", "", "","","","","","","");
correctHeights("dTopRight", "dTopLeft", "", "","","","","","","");

//promociones especiales
correctHeights("calleLibrosComents2","callePeliculasComents2","calleMusicaComents2","callePasatiemposComents2","calleSeparadorComents4","calleSeparadorComents5","calleSeparadorComents6","","","");
correctHeights("comentarios02", "comentarios03", "comentarios04", "comentarios05","","","","","","");

correctHeights("calleLibrosComents3","callePeliculasComents3","calleMusicaComents3","callePasatiemposComents3","calleSeparadorComents7","calleSeparadorComents8","calleSeparadorComents9","","","");
correctHeights("comentarios06", "comentarios07", "comentarios08", "comentarios09","","","","","","");

correctHeights("calleLibrosComents4","callePeliculasComents4","calleMusicaComents4","callePasatiemposComents4","calleSeparadorComents10","calleSeparadorComents11","calleSeparadorComents12","","","");
correctHeights("comentarios10", "comentarios11", "comentarios12", "comentarios13","","","","","","");

correctHeights("calleLibrosComents5","callePeliculasComents5","calleMusicaComents5","callePasatiemposComents6","calleSeparadorComents13","calleSeparadorComents14","calleSeparadorComents15","","","");
correctHeights("comentarios14", "comentarios15", "comentarios16", "comentarios17","","","","","","");
