package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.Repositories.ProductRepository;
import com.scalar.producrservice25.exceptions.ProductNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("selfproductservice")
//@Primary
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    public SelfProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getSingleProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new ProductNotFoundException("Product with given id -> " + id + " is not found");
        }
        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
