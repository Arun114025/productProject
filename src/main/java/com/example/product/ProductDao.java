package com.example.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {

	@Autowired
	ProductRepository prdRepo;

	public String add(Product e)throws PriceException,Exception{
		prdRepo.save(e);
		return "SuccessFull";
	}

	public String addProduct(List<Product> e) {
		prdRepo.saveAll(e);
		return "SuccessFull";
	}

	public Product prdById(int a) {
		return prdRepo.findById(a).get();
	}

	public List<Product> prds() {
		return prdRepo.findAll();
	}
	public String deleteall() {
		prdRepo.deleteAll();
		return "DeleteAll";
	}
		
}
