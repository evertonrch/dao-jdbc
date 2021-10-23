package br.com.access_dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import br.com.access_dao.db.DB;
import br.com.access_dao.db.DBException;
import br.com.access_dao.model.dao.DepartmentDao;
import br.com.access_dao.model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	private Connection conn;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(
					"INSERT INTO department (Name) "
				  + "VALUES (?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, obj.getName());
			
			int rows = ps.executeUpdate();
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeStatement(rs);
			}
		}
		catch(SQLException s) {
			throw new DBException(s.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void update(Department obj) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("UPDATE department SET Name = ? WHERE Id = ?",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getName());
			ps.setInt(2, obj.getId());
			
			int rows = ps.executeUpdate();	
			if(rows > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt("Id");
					obj.setId(id);
				}
			}
		}
		catch(SQLException s) {
			throw new DBException(s.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}		
	}

	@Override
	public void deleteById(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement("DELETE FROM department WHERE Id = ?");			
			ps.setInt(1, id);
			
			ps.executeUpdate();			
		}
		catch(SQLException se) {
			throw new DBException(se.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM department WHERE Id = ?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				Department dep = instantiateDep(rs);
				return dep;
			}
			return null;						
		}
		catch(SQLException s) {
			throw new DBException(s.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
	}
	
	private Department instantiateDep(ResultSet rs) throws SQLException{
		Department dep = new Department();
		dep.setId(rs.getInt(1));
		dep.setName(rs.getString(2));
		return dep;
	}	

	@Override
	public Collection<Department> findAll() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement("SELECT * FROM department");
			rs = ps.executeQuery();
			
			List<Department> list = new ArrayList<>();
			
			while(rs.next()) {
				Department dep = instantiateDep(rs);
				list.add(dep);
			}
			return list;
		}
		catch(SQLException s) {
			throw new DBException(s.getMessage());
		}
		finally {
			DB.closeStatement(rs);
			DB.closeStatement(ps);
		}
	}

}
