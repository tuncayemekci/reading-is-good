package com.getir.readingisgood.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class BookStockDTO {

    @NotEmpty(message = "The book name can not be empty")
    String name;

    @NotNull(message = "Quantity can not be null")
    Integer quantity;

}
