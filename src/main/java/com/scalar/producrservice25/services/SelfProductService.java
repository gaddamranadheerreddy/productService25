package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService {
    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        return new Product();
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
