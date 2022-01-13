package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.exception.ApiRequestException;
import com.getir.readingisgood.model.dto.CustomerDTO;
import com.getir.readingisgood.repository.CustomerRepository;
import com.getir.readingisgood.util.CustomerUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public ResponseEntity<?> addCustomer(CustomerDTO customerDTO) {
        if (customerRepository.existsByEmail(customerDTO.getEmail())) {
            throw new ApiRequestException("The customer is already exists with email: " + customerDTO.getEmail());
        }

        Customer customer = CustomerUtil.dtoToCustomer(customerDTO);
        customerRepository.save(customer);
        return new ResponseEntity<>("The customer has been created successfuly: " + customer.getEmail(), new HttpHeaders(), HttpStatus.CREATED);
    }
}
