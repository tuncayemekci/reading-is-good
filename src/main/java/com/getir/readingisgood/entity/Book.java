package com.getir.readingisgood.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Book {

    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private String author;

    private Double price;

    private Integer stock;

    public Book(String name, String author, Double price, Integer stock) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }
}
