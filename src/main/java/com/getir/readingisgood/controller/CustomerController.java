package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.dto.CustomerDTO;
import com.getir.readingisgood.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
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

    @GetMapping("/{id}/orders")
    public ResponseEntity<?> getOrdersOfCustomerByPagination(@PathVariable String id,
                                                             @Min(0) @RequestParam Integer page,
                                                             @Min(0) @RequestParam Integer size) {
        return customerService.getOrdersOfCustomerByPagination(id, page, size);
    }

}
