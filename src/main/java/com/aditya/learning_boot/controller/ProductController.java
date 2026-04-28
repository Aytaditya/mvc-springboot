package com.aditya.learning_boot.controller;

import com.aditya.learning_boot.model.Product;
import com.aditya.learning_boot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@CrossOrigin // cors implemented
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(service.getProducts(),HttpStatus.OK);
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
        return new ResponseEntity<>(service.getProduct(id),HttpStatus.OK); // to return the status code
    }

    @PostMapping("/products")
    public ResponseEntity<?> addedProduct(
            @RequestPart Product prod,
            @RequestPart MultipartFile imageFile) {

        try {
            List<Product> saved = service.addProduct(prod, imageFile);
            return new ResponseEntity<>(saved,HttpStatus.CREATED);

        } catch (IOException e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while processing image file");
        }
    }

    @PutMapping("/products")
    public ResponseEntity<List<Product>> updateProduct(@RequestBody Product prod){
        return new ResponseEntity<>(service.updateProduct(prod),HttpStatus.OK);
    }

    @DeleteMapping("/products/{id}")
    public List<Product> deleteProduct(@PathVariable int id){
        return service.deleteProduct(id);
    }

    // this will implement /products/search?word="x"
    @GetMapping("/products/search")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam String word){
        List<Product> prod=service.searchProduct(word);
        if(prod!=null){
            return new ResponseEntity<>(prod,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
