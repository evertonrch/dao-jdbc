package br.com.access_dao.application;

import br.com.access_dao.model.dao.DaoFactory;
import br.com.access_dao.model.dao.SellerDao;
import br.com.access_dao.model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller = sellerDao.findById(9);
		
		System.out.println(seller);	
		
	}

}
