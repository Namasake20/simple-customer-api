package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public void addCustomer(@Validated @NonNull @RequestBody Customer customer){
        customerService.addCustomer(customer);
    }
    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerService.getAllCustomers();
    }
    @GetMapping(path = "{id}")
    public Customer getCustomerById(@PathVariable("id") UUID id){
        return customerService.getCustomerBYId(id).orElse(null);
    }
    @DeleteMapping(path = "{id}")
    public void deleteCustomerById(@PathVariable("id") UUID uuid){
        customerService.deleteCustomerById(uuid);
    }
}
