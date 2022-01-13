package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.dto.CustomerDTO;
import com.getir.readingisgood.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        return customerService.addCustomer(customerDTO);
    }

}
