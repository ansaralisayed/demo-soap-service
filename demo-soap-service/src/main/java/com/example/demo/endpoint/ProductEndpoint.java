package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.repository.ProductRepository;
import com.example.demo.soap.products.GetProductsRequest;
import com.example.demo.soap.products.GetProductsResponse;

@Endpoint
public class ProductEndpoint {
 
    private static final String NAMESPACE_URI = "http://www.example.com/demo/soap/products";
 
    private ProductRepository productRepository;
 
    @Autowired
    public ProductEndpoint(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getProductsRequest")
    @ResponsePayload
    public GetProductsResponse getProducts(@RequestPayload GetProductsRequest request) {
    	GetProductsResponse response = new GetProductsResponse();
        response.getProducts().addAll((productRepository.findProducts(request.getCustomerId(), request.getCategory())));
 
        return response;
    }
}