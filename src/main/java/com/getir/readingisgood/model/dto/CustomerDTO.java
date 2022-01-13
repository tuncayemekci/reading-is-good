package com.getir.readingisgood.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class CustomerDTO {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;

    @NotEmpty(message = "Last name can not be empty")
    private String lastName;

    @NotEmpty(message = "Email name can not be empty")
    private String email;

    @NotEmpty(message = "Password name can not be empty")
    private String password;

}
