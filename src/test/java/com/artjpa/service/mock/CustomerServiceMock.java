package com.artjpa.service.mock;

import java.util.ArrayList;
import java.util.List;

import com.artjpa.entities.Customer;
import com.artjpa.entities.Order;
import com.artjpa.entities.mock.CustomerMock;

public class CustomerServiceMock {
	
	public static Customer customerMockRequest(){

        Customer customer = CustomerMock.mockRequest();

        Order order = OrderMock.mockRequest();
        order.setCustomer(customer);

        List<Order> orders = new ArrayList<>();
        orders.add(order);
        customer.setOrders(orders);

        return customer;
    }


}
