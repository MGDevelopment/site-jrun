package com.tmk.dbo.sql;

import java.util.HashSet;

public class CamposLeftJoinDBO extends HashSet {
	public CamposLeftJoinDBO() {
		super();
	}
	public boolean esCampoDBOLeftJoin(String campo) {
		if (this==null) {
			return false;
		}
		return this.contains(campo.toLowerCase());
	}
	public void setCampoDBOLeftJoin(String campo) {
		this.add(campo.toLowerCase());
	}
}
