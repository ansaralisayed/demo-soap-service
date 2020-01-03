package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.example.demo.soap.category.Category;
import com.example.demo.soap.order.CartEntry;
import com.example.demo.soap.order.Order;
import com.example.demo.soap.order.OrderProductsResponse;
import com.example.demo.soap.order.OrderStatus;
import com.example.demo.soap.product.Product;

@Component
public class OrderRepository {
    private static final Map<String, Order> orders = new HashMap<>();
    private static int currentOrderReferenceNum = 0;
    
    
    @PostConstruct
    public void initData() {
    	
    }
 
    public Order orderProducts(String customerId, List<CartEntry> cartEntries) {
    	
    	//TODO: 
    	//validate customerId here
    	//get Customer from caustomerId, then based on his category, return the right set of list
    	
    	Order order = new Order();
    	order.setCustomerId(customerId);
    	order.setOrderStatus(OrderStatus.CREATED);
    	order.setRefNum(currentOrderReferenceNum + 1 + "");

    	orders.put(customerId, order);
    	
    	return order;
    }
}
