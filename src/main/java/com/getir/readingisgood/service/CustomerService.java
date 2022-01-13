package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.exception.ApiRequestException;
import com.getir.readingisgood.model.Response;
import com.getir.readingisgood.model.dto.CustomerDTO;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.repository.OrderRepository;
import com.getir.readingisgood.util.CustomerUtil;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public ResponseEntity<?> addCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new ApiRequestException("The customer already exists with email: " + customerDTO.getEmail());
        }

        Customer customer = CustomerUtil.dtoToCustomer(customerDTO);
        customerRepository.save(customer);
        return Response.CREATED("The customer has been created successfully: " + customer.getEmail());
    }

    public ResponseEntity<?> getOrdersOfCustomerByPagination(String id, Integer page, Integer size) {
        if (!customerRepository.existsById(id)) {
            throw new ApiRequestException("The customer doesn't exists with id: " + id);
        }

        Pageable pageable = PageRequest.of(page, size);

        Page<Order> orders = orderRepository.findAllByCustomer_Id(id, pageable);

        return Response.OK(orders);
    }
}
