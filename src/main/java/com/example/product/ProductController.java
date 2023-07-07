package com.example.product;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping(value="/product")
public class ProductController {
	@Autowired
	ProductService prdSer;
	
	static Logger log=Logger.getLogger(ProductController.class);
	
	@PostMapping(value = "/insert")
	public String add(@RequestBody Product e) throws PriceException, Exception {
		return prdSer.add(e);
	}
	
	@PostMapping(value = "/insertAll")
	public String addProduct(@RequestBody List<Product> e) {
		PropertyConfigurator.configure("productadd.properties");
		log.info(prdSer.addProduct(e));
		return prdSer.addProduct(e);
	}

	@GetMapping(value = "/Id/{a}")
	public Product prdById(@PathVariable int a) {
		return prdSer.prdById(a);
	}
    @GetMapping(value="/GetAllPrd")
    public List<Product> prds(){
    	PropertyConfigurator.configure("product.properties");
		log.info(prdSer.prds());
    	return prdSer.prds();
    }
    @DeleteMapping(value="/deleteAll/id")
    public String deleteall() {
    	PropertyConfigurator.configure("productdelete.properties");
		log.info(prdSer.deleteall());
    	return prdSer.deleteall();   	
    }

}
