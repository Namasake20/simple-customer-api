package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
    private final CustomerInterface customerInterface;

    @Autowired
    public CustomerService(CustomerInterface customerInterface) {
        this.customerInterface = customerInterface;
    }

    public int addCustomer(Customer customer) {
        return customerInterface.insertCustomer(customer);
    }

    public List<Customer> getAllCustomers(){
        return customerInterface.getAllCustomers();
    }
    public Optional<Customer> getCustomerBYId(UUID id){
        return customerInterface.getCustomerByID(id);
    }
    public int deleteCustomerById(UUID id){
        return customerInterface.deletePersonById(id);
    }
}
