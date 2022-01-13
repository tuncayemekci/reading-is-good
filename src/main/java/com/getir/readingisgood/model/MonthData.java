package com.getir.readingisgood.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class MonthData {

    private Integer totalOrderCount;
    private Integer totalBookCount;
    private Double totalPurchasedAmount;

}
