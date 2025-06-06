package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(Long id) throws ProductNotFoundException;
    List<Product> getAllProducts();
    Page<Product> getAllProducts(int pageNumber, int pageSize);
    Product createProduct(Product product);
    Product replaceProduct(Long id, Product product) throws ProductNotFoundException;
    void deleteProduct(Long id) throws ProductNotFoundException;
    Product updateProduct(Long id, Product product) throws ProductNotFoundException;
}
