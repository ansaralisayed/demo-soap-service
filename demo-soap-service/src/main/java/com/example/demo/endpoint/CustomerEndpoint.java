package com.example.demo.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.repository.CustomerRepository;
import com.example.demo.soap.customer.GetCustomerRequest;
import com.example.demo.soap.customer.GetCustomerResponse;

@Endpoint
public class CustomerEndpoint {
 
    private static final String NAMESPACE_URI = "http://www.example.com/demo/soap/customer";
 
    private CustomerRepository customerRepository;
 
    @Autowired
    public CustomerEndpoint(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
 
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCustomerRequest")
    @ResponsePayload
    public GetCustomerResponse getCountry(@RequestPayload GetCustomerRequest request) {
    	GetCustomerResponse response = new GetCustomerResponse();
        response.setCustomer(customerRepository.findCustomer(request.getId()));
 
        return response;
    }
}