package com.getir.readingisgood.entity;

import com.getir.readingisgood.model.OrderDetail;
import com.getir.readingisgood.model.OrderStatus;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
@NoArgsConstructor
public class Order {

    @Id
    private String id;

    @DBRef
    private Customer customer;

    private LocalDateTime date;

    private OrderStatus status;

    private List<OrderDetail> details;

    private Double totalPrice;

    public Order(Customer customer, LocalDateTime date, OrderStatus status, List<OrderDetail> details, Double totalPrice) {
        this.customer = customer;
        this.date = date;
        this.status = status;
        this.details = details;
        this.totalPrice = totalPrice;
    }
}
