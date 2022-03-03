package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class CustomerService {
    private final CustomerInterface customerInterface;

    @Autowired
    public CustomerService(CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }

    @PostMapping
    public int addCustomer(Customer customer) {
        return customerInterface.insertCustomer(customer);
    }
}
