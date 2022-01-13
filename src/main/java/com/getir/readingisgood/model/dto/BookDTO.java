package com.getir.readingisgood.model.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class BookDTO {

    @NotEmpty(message = "Name can not be empty")
    private String name;

    @NotEmpty(message = "Author can not be empty")
    private String author;

    @NotNull(message = "Price can not be null")
    @Min(value = 0, message = "Price can not be less than zero")
    private Double price;

    @NotNull(message = "Stock can not be null")
    @Min(value = 0, message = "Stock can not be less than zero")
    private Integer stock;

}
