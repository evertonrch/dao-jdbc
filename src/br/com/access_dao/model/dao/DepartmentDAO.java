package br.com.access_dao.model.dao;

import java.util.Collection;
import br.com.access_dao.model.entities.Department;

public interface DepartmentDao {

	void insert(Department obj);
	void update(Department obj);
	void deleteById(Integer id);
	Department findById(Integer id);
	Collection<Department> findAll();
}
