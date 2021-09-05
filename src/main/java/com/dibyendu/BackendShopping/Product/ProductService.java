package com.dibyendu.BackendShopping.Product;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.dibyendu.BackendShopping.Entity.Filter;
import com.dibyendu.BackendShopping.Entity.Product;
import com.dibyendu.BackendShopping.Product.ProductRepository;

@Service
public class ProductService {
	
	
	@Autowired
	private ProductRepository productrepository;

	
	public Product saveProduct(Product product){
		return productrepository.save(product);
	}
	
	public Product updateProduct(Product product){
		productrepository.deleteById(product.getProductid());
		return productrepository.save(product);
	}
	
	public List<Product> getProducts(){
		return productrepository.findAll();
	}
	
	public List<Product> getProductsByCategory(String category){
		
		List<Product> AllProds = productrepository.findAll();
		List<Product> FilteredProds = new ArrayList<Product>();
		
		if(category.equals("male")){
			for(int i=0; i<AllProds.size(); i++){
				if(AllProds.get(i).getGender().equals("male")){
					FilteredProds.add(AllProds.get(i));
				}
			}
			return FilteredProds;
		}
		
		else if(category.equals("female")){
			for(int i=0; i<AllProds.size(); i++){
				if(AllProds.get(i).getGender().equals("female")){
					FilteredProds.add(AllProds.get(i));
				}
			}
			return FilteredProds;
		}
		
		else if(category.equals("jeans")){
			for(int i=0; i<AllProds.size(); i++){
				if(AllProds.get(i).getProductcategory().equals("jeans")){
					FilteredProds.add(AllProds.get(i));
				}
			}
			return FilteredProds;
		}
		
		else if(category.equals("shirt")){
			for(int i=0; i<AllProds.size(); i++){
				if(AllProds.get(i).getProductcategory().equals("shirt")){
					FilteredProds.add(AllProds.get(i));
				}
			}
			return FilteredProds;
		}
		
		return null;

	}
	
	public List<Product> getProductsBysearchString(String searchString){
		List<Product> AllProds = productrepository.findAll();
		List<Product> FilteredProds = new ArrayList<Product>();
		
		for(int i=0; i<AllProds.size(); i++){
			if(AllProds.get(i).getName().toLowerCase().contains(searchString.toLowerCase())){
				FilteredProds.add(AllProds.get(i));
			}
		}
		return FilteredProds;
		
	}
	
	public Optional<Product> getProductsById(int productId){
		return productrepository.findById(productId);
	}
	
	public List<Product> getProdutsByFilter(Filter filter){
		
		List<Product> FilteredProds = productrepository.findAll();
		//List<Product> FilteredProds = new ArrayList<Product>();
		
		if(filter.getGents()==true){
			List<Product> RemoveProds = new ArrayList<Product>();
			for(int i=0; i<FilteredProds.size(); i++){
				if(!(FilteredProds.get(i).getGender().equals("male"))){
					RemoveProds.add(FilteredProds.get(i));
				}
			}
			FilteredProds.removeAll(RemoveProds);
		}
		
		if(filter.getLadies()==true){
			List<Product> RemoveProds = new ArrayList<Product>();
			for(int i=0; i<FilteredProds.size(); i++){
				if(!(FilteredProds.get(i).getGender().equals("female"))){
					RemoveProds.add(FilteredProds.get(i));
				}
			}
			FilteredProds.removeAll(RemoveProds);
		}
		
		if(filter.getJeans()==true){
			List<Product> RemoveProds = new ArrayList<Product>();
			for(int i=0; i<FilteredProds.size(); i++){
				if(!(FilteredProds.get(i).getProductcategory().equals("jeans"))){
					RemoveProds.add(FilteredProds.get(i));
				}
			}
			FilteredProds.removeAll(RemoveProds);
		}
		
		if(filter.getShirts()==true){
			List<Product> RemoveProds = new ArrayList<Product>();
			for(int i=0; i<FilteredProds.size(); i++){
				if(!(FilteredProds.get(i).getProductcategory().equals("shirt"))){
					RemoveProds.add(FilteredProds.get(i));
				}
			}
			FilteredProds.removeAll(RemoveProds);
		}
		
		return FilteredProds;
		
	}
	
	public List<Product> getProdutsByPrice(int minprice, int maxpice){
		
		List<Product> AllProds = productrepository.findAll();
		List<Product> FilteredProds = new ArrayList<Product>();
		
		for(int i=0; i<AllProds.size(); i++){
			if(AllProds.get(i).getPrice()>=minprice && AllProds.get(i).getPrice()<=maxpice){
				FilteredProds.add(AllProds.get(i));
			}
		}
		
		return FilteredProds;
		
	}
	
	
}
