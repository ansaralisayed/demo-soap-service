package com.example.demo.repository;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.soap.category.Category;
import com.example.demo.soap.customer.Customer;

@Component
public class CustomerRepository {
    private static final Map<String, Customer> customers = new HashMap<>();
    
    @PostConstruct
    public void initData() {
        // initialize countries map
    	Customer customer = new Customer();
    	customer.setId("1");
    	customer.setName("Ansar");
    	customer.setCategory(Category.DOMESTIC);
    	customer.setAge(40);
    	customers.put(customer.getId(), customer);
    	
    	customer = new Customer();
    	customer.setId("2");
    	customer.setName("Shoaib");
    	customer.setCategory(Category.DOMESTIC);
    	customer.setAge(5);
    	customers.put(customer.getId(), customer);
    	
    	customer = new Customer();
    	customer.setId("3");
    	customer.setName("John");
    	customer.setCategory(Category.INTERNATIONAL);
    	customer.setAge(30);
    	customers.put(customer.getId(), customer);
    	
    	customer = new Customer();
    	customer.setId("4");
    	customer.setName("Peter");
    	customer.setCategory(Category.INTERNATIONAL);
    	customer.setAge(50);
    	customers.put(customer.getId(), customer);
    	
    }
 
    public Customer findCustomer(String customerId) {
        return customers.get(customerId);
    }
}
