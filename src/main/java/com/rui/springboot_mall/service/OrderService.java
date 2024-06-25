package com.rui.springboot_mall.service;

import com.rui.springboot_mall.dto.CreateOrderRequest;

public interface OrderService {

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
