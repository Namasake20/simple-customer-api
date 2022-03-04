package com.example.customer.customer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerInterface {
    int insertCustomer(UUID id,Customer customer);
    default int insertCustomer(Customer customer){
        UUID id = UUID.randomUUID();
        return insertCustomer(id,customer);
    }
    List<Customer> getAllCustomers();
    Optional<Customer> getCustomerByID(UUID id);
    int deletePersonById(UUID uuid);
}
