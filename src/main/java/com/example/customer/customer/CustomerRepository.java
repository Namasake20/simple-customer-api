package com.example.customer.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.util.List;
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

}
