package com.rui.springboot_mall.dao;

import com.rui.springboot_mall.dto.ProductRequest;
import com.rui.springboot_mall.model.Product;

public interface ProductDao {

     Product getProductById(Integer productId);

     Integer createProduct(ProductRequest productRequest);
}
