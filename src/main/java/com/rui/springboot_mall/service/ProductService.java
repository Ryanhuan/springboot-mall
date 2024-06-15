package com.rui.springboot_mall.service;

import com.rui.springboot_mall.dto.ProductRequest;
import com.rui.springboot_mall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
