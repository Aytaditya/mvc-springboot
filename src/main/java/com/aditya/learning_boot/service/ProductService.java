package com.aditya.learning_boot.service;

import com.aditya.learning_boot.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service  //service container is a component behind the scene so no need to add component tag here
public class ProductService {
    // inside asList we are creating an object of Product Class
    List<Product> products= new ArrayList<>(Arrays.asList(
            new Product(101,"Macbook",100000),
            new Product(102,"Iphone",50000),
            new Product(103,"Ipod",1000)));


    public List<Product> getProducts(){
        return products;
    }

    public Product getProduct(int id){
        // done using stream api but can also be done using simple for loop
        return products.stream().filter(p->p.getProdId()==id).findFirst().orElse(new Product(0,"",0));
    }

    public List<Product> addProduct(Product prod){
        products.add(prod);
        return products;
    }

    public List<Product> updateProduct(Product prod){
        int index=0;
        for(int i=0;i<products.size();i++){
            if(products.get(i).getProdId()==prod.getProdId()){
                index=i;
            }
        }
        products.set(index,prod);
        return products;
    }
}
