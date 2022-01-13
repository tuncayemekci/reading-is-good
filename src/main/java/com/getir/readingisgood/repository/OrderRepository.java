package com.getir.readingisgood.repository;

import com.getir.readingisgood.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends MongoRepository<Order, String> {
    List<Order> findAllById(String id);
    List<Order> findAllByCustomer_Id(String id);
    Page<Order> findAllByCustomer_Id(String id, Pageable pageable);
    List<Order> findAllByDateIsBetween(LocalDateTime startDate, LocalDateTime endDate);
}
