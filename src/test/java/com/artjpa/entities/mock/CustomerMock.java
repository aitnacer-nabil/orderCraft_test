package com.artjpa.entities.mock;

import java.util.List;

import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;

public class CustomerMock {
	
	 public static Customer mockRequest(){

	        Customer customer = new Customer();

	        Long id = 1L;
	        customer.getId();
	        String name = "lano123";
	        customer.getName();
	        String adress = "adresse123";
	        customer.getAdress();	        
	        String phone = "000000000";
	        customer.getPhone();
	        String email = "lano@gmail.com";
	        customer.getEmail();
	        List<Order> orders = null;
	        customer.getOrders();

	        customer.setId(id);
	        customer.setName(name);
	        customer.setAdress(adress);
	        customer.setPhone(phone);
	        customer.setEmail(email);
	        customer.setOrders(orders);
	        
	        return customer;
	    }

}
