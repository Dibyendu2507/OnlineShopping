package com.dibyendu.BackendShopping.Product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dibyendu.BackendShopping.Entity.Filter;
import com.dibyendu.BackendShopping.Entity.Product;

@RestController
@CrossOrigin
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/products/addProduct")
	public Product addProduct(@RequestBody Product product){
		return service.saveProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/products/update")
	public Product updateProduct(@RequestBody Product product){
		//return product;
		return service.updateProduct(product);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/all")
	public List<Product> findAllProduts(){
		return service.getProducts();
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/{category}")
	public List<Product> findProdutsByCategory(@PathVariable String category){
		return service.getProductsByCategory(category);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/search/{searchString}")
	public List<Product> findProdutsBysearchString(@PathVariable String searchString){
		return service.getProductsBysearchString(searchString);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/getById/{productId}")
	public Optional<Product> findProdutsById(@PathVariable int productId){
		return service.getProductsById(productId);
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/products/getFilteredProducts")
	public List<Product> findProdutsByFilter(@RequestBody Filter filter){
		return service.getProdutsByFilter(filter);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/products/{minprice}/to/{maxpice}")
	public List<Product> findProdutsByPrice(@PathVariable int minprice, @PathVariable int maxpice){
		return service.getProdutsByPrice(minprice, maxpice);
	}

	
}
