package com.aditya.learning_boot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data   // this annotation creates getter, setters, toString(), equals() all at compile time and we need these methods
// because the data is private type
@AllArgsConstructor  // This generates a constructor with all fields as parameters.
@NoArgsConstructor // this is required by entity
@Entity
public class Product {
    @Id // mentioning prodId as primary key which is required by Entity
    private int prodId;
    private String prodName;
    private int price;
}
