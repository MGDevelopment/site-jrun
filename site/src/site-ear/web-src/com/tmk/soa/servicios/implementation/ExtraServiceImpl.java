package com.tmk.soa.servicios.implementation;

import com.tmk.kernel.DBUtil;
import com.tmk.soa.servicios.interfaces.ExtraService;

public class ExtraServiceImpl  implements ExtraService{

	/*public String getSequenceNumeroDeFormulario() throws Exception {
		return DBUtil.getSequenceLong("NUMERO_FORMULARIO_EXTRA_SEQ").toString();
	}*/

	public String getNumeroDeFormulario() throws Exception {
		String sequenceNumeroDeFormulario = DBUtil.getSequenceLong("NUMERO_FORMULARIO_EXTRA_SEQ").toString();
		return (sequenceNumeroDeFormulario + DBUtil.getDBFunction("DVC", sequenceNumeroDeFormulario));
	}
	
	/*public String getSequenceNumeroDeTarjeta() throws Exception {
		return DBUtil.getSequenceLong("NUMERO_TARJETA_EXTRA_SEQ").toString();
	}*/
	
	public String getNumeroDeTarjeta() throws Exception {
		String sequenceNumeroDeTarjeta = DBUtil.getSequenceLong("NUMERO_TARJETA_EXTRA_SEQ").toString();
		return(sequenceNumeroDeTarjeta + DBUtil.getDBFunction("DVC", sequenceNumeroDeTarjeta));
	}
	
	public Integer getNumeroDeCuenta() throws Exception {
		return DBUtil.getSequenceValue("FDN_ID_CUENTA_SEQ");
	}

}
