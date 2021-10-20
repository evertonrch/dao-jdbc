package br.com.access_dao.model.dao;

import java.util.Collection;
import br.com.access_dao.model.entities.Seller;

public interface SellerDao {
	
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	Seller findById(Integer id);
	Collection<Seller> findAll();
}
