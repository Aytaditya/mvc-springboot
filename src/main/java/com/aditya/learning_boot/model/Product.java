package com.aditya.learning_boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data   // this annotation creates getter, setters, toString(), equals() all at compile time and we need these methods
// because the data is private type
@AllArgsConstructor  // This generates a constructor with all fields as parameters.
public class Product {
    private int prodId;
    private String prodName;
    private int price;
}
