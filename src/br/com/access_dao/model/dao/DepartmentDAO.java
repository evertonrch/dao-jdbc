package br.com.access_dao.model.dao;

import java.util.Collection;
import br.com.access_dao.model.entities.Department;

public interface DepartmentDAO {

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	void findById(Integer id);
	Collection<Department> findAll();
}
