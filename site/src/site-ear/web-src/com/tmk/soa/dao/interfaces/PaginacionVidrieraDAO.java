package com.tmk.soa.dao.interfaces;

import java.util.Collection;

import com.tmk.soa.bo.PaginacionVidriera;

public interface PaginacionVidrieraDAO {
	public void insert(PaginacionVidriera datos) throws Throwable;
	public void update(PaginacionVidriera datos) throws Throwable;
	public Collection<PaginacionVidriera> selecAll(PaginacionVidriera datos) throws Throwable;
}
