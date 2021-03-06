package br.com.access_dao.model.dao;

import br.com.access_dao.db.DB;
import br.com.access_dao.impl.DepartmentDaoJDBC;
import br.com.access_dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConn());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConn());
	}

}
