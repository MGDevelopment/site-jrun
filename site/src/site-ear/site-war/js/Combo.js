//worflow 707
var bancoPromocion = null;
var puedeAvanzar = true;
//fin

function Combo (id, descripcion) {
    this.id = id;
    this.descripcion = descripcion;
    this.comboDependiente = new Array();
    this.addComboDependiente = Combo_addComboDependiente;
}

function Combo_addComboDependiente (comboDependiente) {
    this.comboDependiente[this.comboDependiente.length] = comboDependiente;
}


function actualizarCombo(frmCombo, frmComboDependiente, combo) {
    INDEX_COMBO = 0;
    var frmIdCombo = frmCombo.options[frmCombo.options.selectedIndex].value;
    
    //(work-flow 707)guardo el id del ultimo medio de cobro seleccionado
    try {
    bancoPromocion = frmIdCombo;
    if(bancoPromocion == null) {
		bancoPromocion = document.frmMedioCobro.TIPO_DE_TARJETA.value;
	}
    if(bancoPromocion != "AMPAT" && bancoPromocion != "VPAT"){
    	setAvance(true);    	
    	$("input[name=CUPON]").attr("disabled",false);
    }else {
    	$("input[name=CUPON]").attr('value','');
    	$("input[name=CUPON]").attr("disabled",true);
    }
    verificarBin(document.frmMedioCobro.NUMERO_DE_TARJETA);
    //fin
    }catch(e){}
    
    frmComboDependiente.options.length = 0;
    for (i =0; i<frmComboDependiente.length; i++ ) {
	    frmComboDependiente.options[i] = null;
    }
    
    for(i = 0; i < combo.length; i++) {

         if(combo[i].id == frmIdCombo) {
        	INDEX_COMBO = i;
        	
	    	for(j = 0; j < combo[INDEX_COMBO].comboDependiente.length; j++) {
	            frmComboDependiente.options[frmComboDependiente.options.length] = new Option(combo[INDEX_COMBO].comboDependiente[j].descripcion, combo[INDEX_COMBO].comboDependiente[j].id);
            }
            return INDEX_COMBO;
        }
    }
}

function verificarBin(obj){
	//si es visa, o amex y es un bin valido
	//en caso de hacer reload.
	if(bancoPromocion == null) {
		bancoPromocion = document.frmMedioCobro.TIPO_DE_TARJETA.value;
	}
	if((bancoPromocion == "AMPAT" || bancoPromocion == "VPAT") && obj.value!=""){
		if(esBinValidoParaTarjeta(bancoPromocion,obj.value)) {	
			puedeAvanzar = true;
		}else {
			puedeAvanzar = false;
		}
	}else{
		setAvance(true);    
	}
}

function esBinValidoParaTarjeta(bancoPromocion,bin) {
	var esBinValido = false;
	var datos = "param="+Math.random()+"&TIPO_TARJETA_BIN="+bancoPromocion+"&"+"BIN="+bin;
	$.ajax({
		cache:false,
		type: "POST",
		url:"/GetBinesValidos",
		contentType: "application/x-www-form-urlencoded",
		dataType:"json",
		data: datos,		
		success: function(objeto){
			esBinValido = objeto.Resultado.valor;
			if(!objeto.Resultado.valor) {
				alert("El número de su tarjeta no pertenece al banco seleccionado, seleccione otra tarjeta.");
				setAvance(false);
			}else{
				setAvance(true);
			}
		}
	});	
	return esBinValido;
}
function setAvance(valor) {
	try {
		if(valor) {
			document.frmMedioCobro.CAMPO_PLAN_DE_CUOTAS.disabled = '';
			puedeAvanzar = true;
		}else{
			document.frmMedioCobro.CAMPO_PLAN_DE_CUOTAS.disabled = 'disabled';
			puedeAvanzar = false;
		}
	}catch(e) {
		
	}
}
//fin