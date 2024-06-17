package com.rui.springboot_mall.service;

import com.rui.springboot_mall.constant.ProductCategory;
import com.rui.springboot_mall.dto.ProductRequest;
import com.rui.springboot_mall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductCategory category,String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
