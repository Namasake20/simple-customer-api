package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepository implements CustomerInterface {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int insertCustomer(UUID id, Customer customer) {
        final String sql = "INSERT INTO client (id,name,email,age) VALUES (?,?,?,?)";
        return jdbcTemplate.update(sql,id,customer.getName(),customer.getEmail(),customer.getAge());
    }

    @Override
    public List<Customer> getAllCustomers() {
        final String sql = "SELECT * FROM client";
        return jdbcTemplate.query(sql,(resultSet,i)->{
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Integer age = Integer.valueOf(resultSet.getString("age"));
            return new Customer(id,name,email,age);
        });
    }

    @Override
    public Optional<Customer> getCustomerByID(UUID id) {
        final String sql = "SELECT * FROM client WHERE id = ?";
        Customer customer = jdbcTemplate.queryForObject(sql,new Object[]{id},(resultSet,i)->{
            UUID customerId = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String email = resultSet.getString("email");
            Integer age = Integer.valueOf(resultSet.getString("age"));
            return new Customer(customerId,name,email,age);
        });
        return Optional.ofNullable(customer);
    }

    @Override
    public int deletePersonById(UUID uuid) {
        final String sql = "DELETE FROM client WHERE id = ?";
        jdbcTemplate.update(sql,uuid);
        return 0;
    }

}
