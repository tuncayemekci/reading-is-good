package com.getir.readingisgood.controller;

import com.getir.readingisgood.service.StatisticService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/statistic")
@AllArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @GetMapping("/monthly/{customerId}")
    public ResponseEntity<?> getMonthlyOrderStatistics(@PathVariable String customerId) {
        return statisticService.getMonthlyOrderStatistics(customerId);
    }

}
