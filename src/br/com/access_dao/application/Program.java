package br.com.access_dao.application;

import java.util.Date;

import br.com.access_dao.model.entities.Department;
import br.com.access_dao.model.entities.Seller;

public class Program {

	public static void main(String[] args) {


		Department d = new Department(1, "Design");
		Department d2 = new Department(2, "Design");
		
		Seller s = new Seller(2,"Everton","ever@gmail",new Date(),3000.0,d);
		
		System.out.println(s);
	}

}
