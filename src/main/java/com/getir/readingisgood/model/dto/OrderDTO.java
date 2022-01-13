package com.getir.readingisgood.model.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class OrderDTO {

    @NotBlank(message = "Email can not be blank")
    private String email;

    @NotEmpty(message = "There should be at least one order detail in the list")
    private List<OrderDetailDTO> details;

}
