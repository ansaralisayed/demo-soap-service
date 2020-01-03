package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.repository.OrderRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.soap.order.Order;
import com.example.demo.soap.order.OrderProductsRequest;
import com.example.demo.soap.order.OrderProductsResponse;
import com.example.demo.soap.products.GetProductsRequest;
import com.example.demo.soap.products.GetProductsResponse;

@Endpoint
public class OrderEndpoint {
 
    private static final String NAMESPACE_URI = "http://www.example.com/demo/soap/order";
 
    private OrderRepository orderRepository;
 
    @Autowired
    public OrderEndpoint(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "orderProductsRequest")
    @ResponsePayload
    public OrderProductsResponse orderProducts(@RequestPayload OrderProductsRequest request) {
    	
    	Order order = orderRepository.orderProducts(request.getCustomerId(), request.getCartEntries());
    	
        OrderProductsResponse response = new OrderProductsResponse();
        response.setOrderReference(order.getRefNum());
        response.setMessage("Order Created !!");
 
        return response;
    }
}