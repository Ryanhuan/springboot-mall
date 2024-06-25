package com.rui.springboot_mall.service.Impl;

import com.rui.springboot_mall.dao.OrderDao;
import com.rui.springboot_mall.dao.ProductDao;
import com.rui.springboot_mall.dto.BuyItem;
import com.rui.springboot_mall.dto.CreateOrderRequest;
import com.rui.springboot_mall.model.OrderItem;
import com.rui.springboot_mall.model.Product;
import com.rui.springboot_mall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;


    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;

        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //計算總價
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            //轉換buyItem to orderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }


        //創建訂單
        Integer orderId = orderDao.createOrder(userId,totalAmount);

        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }
}
