package com.artjpa.entities.mock;

import java.util.ArrayList;
import java.util.List;

import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;

public class MockedCustomer {
	
	public static Customer customerMockRequest(){

        Customer customer = CustomerMock.mockRequest();
        Order order = OrdersMock.mockRequest();
        order.setCustomer(customer);
      /*  Order order = OrderMock.mockRequest();
        order.setCustomer(customer);
        order.setCreated("11/11/2011");
        order.setScheduling("11/11/2011");*/
        List<Order> orders = new ArrayList<>();
        orders.add(order);
        customer.setOrders(orders);       

        return customer;
    }

}
