package com.ministore.mini_store.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;

public class Product {
    private  int id;
    private  String name;
    private double price ;
    private String description;
    private Timestamp created_at;

    public Product(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;

    }

    public Product(int id, String name, double price, String description, Timestamp created_at) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.created_at = created_at;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp create_at) {
        this.created_at = create_at;
    }
}
