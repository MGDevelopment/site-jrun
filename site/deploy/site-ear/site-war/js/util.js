function accionXONChange(objSel, valor, accionTrue, accionFalse) {
	if (objSel.options[objSel.selectedIndex].value == valor) {
		eval(accionTrue);
	} else {
		eval(accionFalse);	
	}
}