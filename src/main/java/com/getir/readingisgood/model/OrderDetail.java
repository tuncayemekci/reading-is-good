package com.getir.readingisgood.model;

import com.getir.readingisgood.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {

    @DBRef
    private Book book;

    private Integer quantity;

    private Double unitPrice;

}
