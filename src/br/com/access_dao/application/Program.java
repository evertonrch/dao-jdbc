package br.com.access_dao.application;

import java.util.List;

import br.com.access_dao.model.dao.DaoFactory;
import br.com.access_dao.model.dao.SellerDao;
import br.com.access_dao.model.entities.Department;
import br.com.access_dao.model.entities.Seller;

public class Program {

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
		
	}

}
