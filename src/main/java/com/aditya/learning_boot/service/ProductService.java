package com.aditya.learning_boot.service;

import com.aditya.learning_boot.model.Product;
import com.aditya.learning_boot.repository.ProductRepo;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service  //service container is a component behind the scene so no need to add component tag here
public class ProductService {

    @Autowired
    ProductRepo repo;

    // inside asList we are creating an object of Product Class
//    List<Product> products= new ArrayList<>(Arrays.asList(
//            new Product(101,"Macbook",100000),
//            new Product(102,"Iphone",50000),
//            new Product(103,"Ipod",1000)));


    public List<Product> getProducts(){
        return repo.findAll();
    }

    public Product getProduct(int id){
        // done using stream api but can also be done using simple for loop
        return repo.findById(id).orElse(new Product(0,"",0));
    }

    public List<Product> addProduct(Product prod){
        repo.save(prod);
        return repo.findAll();
    }

    public List<Product> updateProduct(Product prod){
        repo.save(prod); // for saving and updating we use this only if data is there it updates else saves
        return repo.findAll();
    }

    public List<Product> deleteProduct(int id){
        repo.deleteById(id);
        return repo.findAll();
    }
}
