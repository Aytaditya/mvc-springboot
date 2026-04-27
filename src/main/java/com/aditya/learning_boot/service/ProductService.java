package com.aditya.learning_boot.service;

import com.aditya.learning_boot.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductService {
    // inside asList we are creating an object of Product Class
    List<Product> products= Arrays.asList(new Product(101,"Macbook",100000));

    public List<Product> getProducts(){
        return null;
    }
}
