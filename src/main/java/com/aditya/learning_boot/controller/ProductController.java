package com.aditya.learning_boot.controller;

import com.aditya.learning_boot.model.Product;
import com.aditya.learning_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public List<Product> getProducts(){
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id){
        return service.getProduct(id);
    }

    @PostMapping("/products")
    public List<Product> addedProduct(@RequestBody Product prod){
        return service.addProduct(prod);
    }

    @PutMapping("/products")
    public List<Product> updateProduct(@RequestBody Product prod){
        return service.updateProduct(prod);
    }
}
