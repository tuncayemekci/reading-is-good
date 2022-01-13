package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Order;
import com.getir.readingisgood.exception.ApiRequestException;
import com.getir.readingisgood.model.MonthData;
import com.getir.readingisgood.model.Response;
import com.getir.readingisgood.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class StatisticService {

    private final OrderRepository orderRepository;

    public ResponseEntity<?> getMonthlyOrderStatistics(String customerId) {
        List<Order> orders = orderRepository.findAllByCustomer_Id(customerId);

        if (orders.isEmpty()) {
            throw new ApiRequestException("OrderNotFoundException");
        }

        Map<String, MonthData> monthDataMap = new HashMap();
        for (Order order : orders) {
            // Ex. 1 2021
            String keyValue = order.getDate().getMonth().getValue() + " " + order.getDate().getYear();

            Integer totalQuantityInOrder = order.getDetails().stream().mapToInt(d -> d.getQuantity()).sum();

            if (monthDataMap.containsKey(keyValue)) {
                MonthData temp = monthDataMap.get(keyValue);
                temp.setTotalOrderCount(temp.getTotalOrderCount() + 1);
                temp.setTotalBookCount(temp.getTotalOrderCount() + totalQuantityInOrder);
                temp.setTotalPurchasedAmount(temp.getTotalPurchasedAmount() + order.getTotalPrice());
            } else {
                monthDataMap.put(keyValue, MonthData.builder()
                                                    .totalOrderCount(1)
                                                    .totalBookCount(totalQuantityInOrder)
                                                    .totalPurchasedAmount(order.getTotalPrice())
                                                    .build());

            }
        }
        return Response.OK(monthDataMap);
    }
}
