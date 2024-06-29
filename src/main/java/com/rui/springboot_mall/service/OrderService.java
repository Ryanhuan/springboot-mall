package com.rui.springboot_mall.service;

import com.rui.springboot_mall.dto.CreateOrderRequest;
import com.rui.springboot_mall.dto.OrderQueryParams;
import com.rui.springboot_mall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

}
