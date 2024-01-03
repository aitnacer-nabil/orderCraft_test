package com.artjpa.entities.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.artjpa.entities.Customer;
import com.artjpa.entities.mock.CustomerMock;


public class CustomerTest {

	    @Test
	    @DisplayName("Test getters and setters methods")
	    public void shouldMakeValidationOfGettersAndSetters(){

	        Customer customer = CustomerMock.mockRequest();
	        Assertions.assertEquals("Customer(id=1, name=lano123, adress=adresse123, phone=000000000, " +
	                "email=lano@gmail.com, orders=null)", customer.toString());    
	}
	    @Test
	    @DisplayName("Test or constructor method with all arguments")
	    public void shouldMakeValidationOfAllArgsConstructor(){
	        Customer customer = new Customer(1L, "lano123", "adresse123", "000000000", "lano@gmail.com", null);
	        Assertions.assertEquals("Customer(id=1, name=lano123, adress=adresse123, phone=000000000, " +
	                "email=lano@email.com, orders=null)", customer.toString());
	    }
	    @Test
	    @DisplayName("Test ClassBuilder")
	    public void shouldMakeValidationOfClassBuilder(){

	        Customer customer = Customer.builder()
	                .id(1L)
	                .name("lano123")
	                .adress("adresse123")
	                .phone("000000000")
	                .email("lano@email.com")
	                .orders(null)
	                .build();

	        Assertions.assertEquals("Customer(id=1, name=lano123, adress=adresse123, phone=000000000, " +
	                "email=lano@email.com, orders=null)", customer.toString());
	    }


}
