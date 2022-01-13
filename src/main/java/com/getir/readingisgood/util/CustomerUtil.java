package com.getir.readingisgood.util;

import com.getir.readingisgood.entity.Customer;
import com.getir.readingisgood.model.dto.CustomerDTO;

public class CustomerUtil {

    public static Customer dtoToCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirstName(customerDTO.getFirstName());
        customer.setLastName(customerDTO.getFirstName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPassword(customerDTO.getEmail());
        return customer;
    }
}
