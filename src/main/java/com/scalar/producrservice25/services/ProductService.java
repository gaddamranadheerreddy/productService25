package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
}
