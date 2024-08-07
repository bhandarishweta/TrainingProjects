package com.stackroute.springdatajpamysql.entity;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id ;
    @Column
    private String name;

    @Column
    private double price;

    public Product(Long productId, String sampleProduct, double v) {
        this.id = productId;
        this.name = sampleProduct;
        this.price = v;
    }
    //Add Product entity fields, constructors and getters/setters here

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
