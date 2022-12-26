package com.pixel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Customer {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String username;
    private String email;

    public Customer(String name, String username, String email) {
        this.name = name;
        this.username = username;
        this.email = email;
    }
}
