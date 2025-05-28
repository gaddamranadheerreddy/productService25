package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id);
    List<Product> getAllProducts();
}
