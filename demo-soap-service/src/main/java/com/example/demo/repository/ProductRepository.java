package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.soap.category.Category;
import com.example.demo.soap.product.Product;

@Component
public class ProductRepository {
    private static final Map<Category, List<Product>> products = new HashMap<>();
    
    @PostConstruct
    public void initData() {
        // initialize countries map
    	
    	List<Product> domesticProducts = new ArrayList<>();
    	List<Product> internationalProducts = new ArrayList<>();
    	
    	Product product = new Product();
    	product.setId("1");
    	product.setName("Maruti Suzuki Dzire");
    	product.setCategory(Category.DOMESTIC);
    	product.setYear(2015);
    	domesticProducts.add(product);
    	
    	product = new Product();
    	product.setId("2");
    	product.setName("Tata Safari");
    	product.setCategory(Category.DOMESTIC);
    	product.setYear(2016);
    	domesticProducts.add(product);
    	
    	product = new Product();
    	product.setId("3");
    	product.setName("Audi");
    	product.setCategory(Category.INTERNATIONAL);
    	product.setYear(2017);
    	internationalProducts.add(product);
    	
    	product = new Product();
    	product.setId("4");
    	product.setName("Porche");
    	product.setCategory(Category.INTERNATIONAL);
    	product.setYear(2018);
    	internationalProducts.add(product);

    	products.put(Category.DOMESTIC, domesticProducts);
    	products.put(Category.INTERNATIONAL, internationalProducts);
    	
    }
 
    public List<Product> findProducts(String customerId, Category category) {
    	
    	//TODO: 
    	//validate customerId here
    	//get Customer from caustomerId, then based on his category, return the right set of list
    	
        return products.get(category);
    }
}
