package com.aditya.learning_boot.service;

import com.aditya.learning_boot.model.Product;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;


@Service  //service container is a component behind the scene so no need to add component tag here
public class ProductService {
    // inside asList we are creating an object of Product Class
    List<Product> products= Arrays.asList(new Product(101,"Macbook",100000),new Product(
            102,"Iphone",50000),new Product(103,"Ipod",1000)
    );

    public List<Product> getProducts(){
        return products;
    }
}
