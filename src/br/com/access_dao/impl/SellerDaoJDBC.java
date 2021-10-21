package br.com.access_dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.access_dao.db.DB;
import br.com.access_dao.db.DBException;
import br.com.access_dao.model.dao.SellerDao;
import br.com.access_dao.model.entities.Department;
import br.com.access_dao.model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			String stmt = "SELECT seller.*, department.Name as DepartName "
					+ "FROM seller INNER JOIN department "
					+ "ON seller.DepartmentId = department.Id "
					+ "WHERE seller.Id = ?";
			st = conn.prepareStatement(stmt);
			
			st.setInt(1 , id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = instantiateDepartment(rs);				
				Seller obj = instantiateSeller(dep, rs);
				return obj;				
			}
			return null;
		}
		catch(SQLException e) {
			throw new DBException(e.getMessage());
		}
		finally {
			DB.closeStatement(rs);
			DB.closeStatement(st);
		}	
	}

	private Seller instantiateSeller(Department dep, ResultSet rs) throws SQLException {
		Seller obj = new Seller();
		obj.setId(rs.getInt("Id"));
		obj.setName(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setBirthDate(rs.getDate("BirthDate"));
		obj.setBaseSalary(rs.getDouble("BaseSalary"));
		obj.setDepartment(dep);
		return obj;		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepartName"));
		return dep;
	}

	@Override
	public Collection<Seller> findAll() {
		return null;
	}

	@Override
	public List<Seller> findByDepartment(Department department) {
		PreparedStatement ps = null;
		ResultSet rs = null;		
		try {
			ps = conn.prepareStatement("SELECT s.*, "
								+ "d.Name as DepartName FROM "
								+ "seller as s INNER JOIN department as d "
								+ "ON s.DepartmentId = d.Id WHERE "
								+ "s.DepartmentId = ? ORDER BY s.Name");
			
			ps.setInt(1, department.getId());
			rs = ps.executeQuery();
			
			List<Seller> list = new ArrayList<>();
			Map<Integer, Department> map = new HashMap<>();
			
			while(rs.next()) {
				Department dep = map.get(rs.getInt("DepartmentId"));
				if(dep == null) {
					dep = instantiateDepartment(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				Seller obj = instantiateSeller(dep, rs);
				list.add(obj);
			}
			return list;		
		}
		catch(SQLException se) {
			throw new DBException(se.getMessage());
		}
		finally {
			DB.closeStatement(rs);
			DB.closeStatement(rs);
		}		
	}
}
