package br.com.access_dao.application;


import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.access_dao.model.dao.DaoFactory;
import br.com.access_dao.model.dao.SellerDao;
import br.com.access_dao.model.entities.Department;
import br.com.access_dao.model.entities.Seller;

public class ProgramSeller {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("==== TEST Seller findById ====");
		Seller seller = sellerDao.findById(9);		
		System.out.println(seller);	
		
		System.out.println("\n==== TEST Seller findByDepartment ====");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj : list) {
			System.out.println(obj);
		}
		System.out.println(list.size());
		
		System.out.println("\n==== TEST Seller findAll ====");
		dep = new Department(2, null);
		list = (List<Seller>) sellerDao.findAll();
		for(Seller obj : list) {
			System.out.println(obj);
		}
		
		System.out.println("\n==== TEST Seller insert ====");
		Seller newSeller = new Seller(null , "Pedro da Rocha", "pedro@gmail.com", new Date(), 2300.00, dep);
		//sellerDao.insert(newSeller);
		System.out.println("Inserted id: " + newSeller.getId());
		
		System.out.println("\n==== TEST Seller update ====");
		Seller otherSeller = sellerDao.findById(5);
		otherSeller.setBaseSalary(1200.00);
		sellerDao.update(otherSeller);;
		System.out.println("Updated!");
		
		System.out.println("\n==== TEST Seller delete ====");
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter id for delete test: ");
		Integer id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Delete complete!");
		sc.close();
		
	}

}
