package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.CustomerDTO;
import com.getir.readingisgood.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customers")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/getall")
    public List<Customer> fetchAllCustomers() {
        return customerService.getAllCustomers();
    }

    @PostMapping("/add")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody CustomerDTO customerDTO) {
        customerService.createCustomer(customerDTO);
        return ResponseEntity.ok("Customer is created");
    }

}
