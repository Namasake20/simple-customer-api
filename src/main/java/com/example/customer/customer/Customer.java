package com.example.customer.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

public class Customer {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;
    private Integer age;

    public Customer(@JsonProperty("id") UUID id,@JsonProperty("name") String name,@JsonProperty("email") String email,@JsonProperty("age") Integer age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}
