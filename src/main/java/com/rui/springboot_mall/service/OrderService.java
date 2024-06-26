package com.rui.springboot_mall.service;

import com.rui.springboot_mall.dto.CreateOrderRequest;
import com.rui.springboot_mall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
