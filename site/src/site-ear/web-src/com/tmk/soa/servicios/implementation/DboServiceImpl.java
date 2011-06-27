package com.tmk.soa.servicios.implementation;

import java.sql.SQLException;
//import java.util.HashSet;
import com.tmk.dbo.DBO;
import com.tmk.kernel.TmkLogger;
import com.tmk.soa.dao.DAOFactory;
//import com.tmk.soa.exceptions.AplicationException;
import com.tmk.soa.exceptions.DBOInexistenteException;
import com.tmk.soa.exceptions.DuplicateException;
import com.tmk.soa.servicios.interfaces.DboService;

public class DboServiceImpl implements DboService {

	public void insert(DBO dbo) throws DuplicateException, Exception {

		DAOFactory.getDboDAO().insert(dbo);

	}
	
	public void update(DBO dbo)throws DBOInexistenteException,Exception {
		
		DAOFactory.getDboDAO().update(dbo);			
			
	}
	
	public void delete(DBO dbo)throws Exception {
		try {
			DAOFactory.getDboDAO().delete(dbo);
		}catch (SQLException e) {
			TmkLogger.error("DboServiceImpl->delete()->"+e.getMessage()+dbo.getPK());
			throw e;
		}catch (Exception e) {
			TmkLogger.error("DboServiceImpl->delete()->"+e.getMessage()+dbo.getPK());
			throw e;
		} 		
	}
	
	/*public void insert(Object dbo,HashSet<String> objetosAGrabar) throws AplicationException {
		try {
			DAOFactory.getDboDAO().insert(dbo,objetosAGrabar);
		}catch (AplicationException e) {
			TmkLogger.error(e.getMessage());
			throw e;
		}
	}*/
}
