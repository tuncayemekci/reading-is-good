package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.dto.OrderDTO;
import com.getir.readingisgood.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/getAll")
    public List<Order> fetchAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<Order>> fetchAllOrdersById(@Positive @PathVariable String id) {
        return new ResponseEntity<>(orderService.getAllOrdersById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

}
