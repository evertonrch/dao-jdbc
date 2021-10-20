package br.com.access_dao.model.dao;

import java.util.Collection;
import br.com.access_dao.model.entities.Seller;

public interface SellerDAO {
	
	void insert(Seller obj);
	void update(Seller obj);
	void deleteById(Integer id);
	void findById(Integer id);
	Collection<Seller> findAll();
}
