package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.model.dto.OrderDTO;
import com.getir.readingisgood.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/all")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addOrder(@Valid @RequestBody OrderDTO orderDTO) {
        return orderService.addOrder(orderDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderById(@PathVariable String id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/interval")
    public ResponseEntity getOrdersByDateInterval(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date startDate,
                                                  @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date endDate) {
        return orderService.getOrdersByDateInterval(startDate, endDate);
    }


}
