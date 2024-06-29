package com.rui.springboot_mall.controller;


import com.rui.springboot_mall.dto.CreateOrderRequest;
import com.rui.springboot_mall.dto.OrderQueryParams;
import com.rui.springboot_mall.model.Order;
import com.rui.springboot_mall.service.OrderService;
import com.rui.springboot_mall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @GetMapping("/users/{userId}/orders")
    public ResponseEntity<Page<Order>> getOrder(
            @PathVariable Integer userId,
            @RequestParam(defaultValue = "10") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset
    ){
        OrderQueryParams orderQueryParams = new OrderQueryParams();
        orderQueryParams.setUserId(userId);
        orderQueryParams.setLimit(limit);
        orderQueryParams.setOffset(offset);

        //取得 order list
        List<Order> orderList = orderService.getOrders(orderQueryParams);

        //取得order總數
        Integer count = orderService.countOrder(orderQueryParams);

        //分頁
        Page<Order> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(count);
        page.setResults(orderList);

        return ResponseEntity.status(HttpStatus.OK).body(page);

    }


    @PostMapping("/users/{userId}/orders")
    public ResponseEntity<?> createOrder(@PathVariable Integer userId,
                                         @RequestBody @Valid CreateOrderRequest createOrderRequest){

       Integer orderId = orderService.createOrder(userId,createOrderRequest);

       Order order = orderService.getOrderById(orderId);

       return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }


}
