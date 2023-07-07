package com.example.product;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.StaticApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;


@Service
public class ProductService {
@Autowired
ProductDao prdDao;
static Logger log=Logger.getLogger(ProductService.class);
public String add(Product e) throws PriceException,Exception{	
	try {
	PropertyConfigurator.configure("logError.properties");
	if(e.getPrice()<30000) {
	return prdDao.add(e);
}
	else {
		log.error(new PriceException("Over Price"));
		throw new PriceException("Over Price");
	}
	}
	catch (Exception y) {
		return "High Price";
	}
	}
public String addProduct(List<Product> e) {
	return prdDao.addProduct(e);
}

public Product prdById(int a) {
	return prdDao.prdById(a);
}
public List<Product> prds(){
	return prdDao.prds();
}
public String deleteall() {
	return prdDao.deleteall();
}
}
