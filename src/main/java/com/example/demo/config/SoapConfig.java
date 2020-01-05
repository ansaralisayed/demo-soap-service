package com.example.demo.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapConfig extends WsConfigurerAdapter {
    // bean definitions
	@Bean
	public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
	    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
	    servlet.setApplicationContext(applicationContext);
	    servlet.setTransformWsdlLocations(true);
	    return new ServletRegistrationBean<MessageDispatcherServlet>(servlet, "/ws/*");
	}

	
	@Bean(name = "customers")
	public DefaultWsdl11Definition customersWsdl11Definition() {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("CustomersPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://www.example.com/demo/soap/customer");
	    wsdl11Definition.setSchema(customersSchema());
	    return wsdl11Definition;
	}
	 
	@Bean(name = "customersSchema")
	public XsdSchema customersSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("customersSchema.xsd"));
	}

	@Bean(name = "products")
	public DefaultWsdl11Definition productsWsdl11Definition() {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("ProductsPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://www.example.com/demo/soap/products");
	    wsdl11Definition.setSchema(productsSchema());
	    return wsdl11Definition;
	}

	@Bean(name = "productsSchema")
	public XsdSchema productsSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("productsSchema.xsd"));
	}

	@Bean(name = "orders")
	public DefaultWsdl11Definition ordersWsdl11Definition() {
	    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
	    wsdl11Definition.setPortTypeName("OrderPort");
	    wsdl11Definition.setLocationUri("/ws");
	    wsdl11Definition.setTargetNamespace("http://www.example.com/demo/soap/order");
	    wsdl11Definition.setSchema(ordersSchema());
	    return wsdl11Definition;
	}

	@Bean(name = "ordersSchema")
	public XsdSchema ordersSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("ordersSchema.xsd"));
	}

	@Bean(name = "categorySchema")
	public XsdSchema categorySchema() {
	    return new SimpleXsdSchema(new ClassPathResource("categorySchema.xsd"));
	}

	@Bean(name = "productSchema")
	public XsdSchema productSchema() {
	    return new SimpleXsdSchema(new ClassPathResource("productSchema.xsd"));
	}

}