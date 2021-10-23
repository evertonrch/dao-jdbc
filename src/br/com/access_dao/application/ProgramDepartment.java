package br.com.access_dao.application;

import java.util.List;

import br.com.access_dao.model.dao.DaoFactory;
import br.com.access_dao.model.dao.DepartmentDao;
import br.com.access_dao.model.entities.Department;

public class ProgramDepartment {

	public static void main(String[] args) {
		
		DepartmentDao department = DaoFactory.createDepartmentDao();
		
		System.out.println("======= TESTE findAll ========");
		List<Department> list = (List<Department>) department.findAll();
		for(Department obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("======= TESTE insert ========");
		Department dep = new Department(null, "Finance");
		//department.insert(dep);
		System.out.println("Id : " + dep.getId());
		
		
		System.out.println("======= TESTE update ========");
		dep = department.findById(4);
		dep.setName("Administration");
		department.update(dep);
		System.out.println("Updated! id: " + dep.getId());
		
		
		
		System.out.println("======= TESTE findById ========");
		dep = department.findById(3);
		System.out.println(dep);
		

		
		System.out.println("======= TESTE delete ========");
		//department.deleteById(5);
		System.out.println("Deleted!");
		
	}
}
