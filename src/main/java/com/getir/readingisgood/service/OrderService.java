package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.exception.ApiRequestException;
import com.getir.readingisgood.model.OrderDetail;
import com.getir.readingisgood.model.OrderStatus;
import com.getir.readingisgood.model.dto.OrderDTO;
import com.getir.readingisgood.model.dto.OrderDetailDTO;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public List<Order> getAllOrdersById(String id) {
        return orderRepository.findAllById(id);
    }

    @Transactional
    public ResponseEntity<?> addOrder(OrderDTO orderDTO) {
        Optional<Customer> customer = customerRepository.findCustomerByEmail(orderDTO.getEmail());
        if (!customer.isPresent()) {
            throw new ApiRequestException("The customer doesn't exists with email: " + orderDTO.getEmail());
        }

        Order order = new Order();
        List<OrderDetail> orderDetails = new ArrayList<>();
        Double totalPrice = 0.0;

        for (OrderDetailDTO orderDetailDTO : orderDTO.getDetails()) {

            Optional<Book> optionalBook = bookRepository.findBookByName(orderDetailDTO.getBookName());
            if (!optionalBook.isPresent()) {
                throw new ApiRequestException("The book doesn't exists with name: " + orderDetailDTO.getBookName());
            }

            Book book = optionalBook.get();
            if (book.getStock() < 1) {
                throw new ApiRequestException("The book doesn't exists with name: " + orderDetailDTO.getBookName());
            }

            Integer requestedQuantity = orderDetailDTO.getQuantity();
            if (requestedQuantity > book.getStock()) {
                throw new ApiRequestException("Requested quantity is more than existing stock: " + orderDetailDTO.getBookName() + " - Current stock is " + book.getStock());
            }

            orderDetails.add(new OrderDetail(book, requestedQuantity, book.getPrice()));
            totalPrice += book.getPrice() * requestedQuantity;
            book.setStock(book.getStock() - requestedQuantity);
            bookRepository.save(book);
        }

        order.setCustomer(customer.get());
        order.setDate(LocalDateTime.now());
        order.setStatus(OrderStatus.NEW);
        order.setDetails(orderDetails);
        order.setTotalPrice(totalPrice);
        Order newOrder = orderRepository.save(order);
        return new ResponseEntity<>("The order has been created successfully: " + newOrder.getId(), new HttpHeaders(), HttpStatus.CREATED);
    }


}
