package com.aditya.learning_boot.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data   // this annotation creates getter, setters, toString(), equals() all at compile time and we need these methods
// because the data is private type
@AllArgsConstructor  // This generates a constructor with all fields as parameters.
@NoArgsConstructor // this is required by entity
@Entity
public class Product {
    @Id // mentioning prodId as primary key which is required by Entity
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // With IDENTITY, ID is generated only when inserting into DB
    private int prodId;
    private String prodName;
    private int price;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy") // to store the date in dd-mm-yyyy format in db
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob // annotation for large object
    private byte[] imageData;
}
