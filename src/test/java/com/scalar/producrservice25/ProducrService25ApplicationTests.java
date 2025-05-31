package com.scalar.producrservice25;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.Projections.ProductWithTitleAndPrice;
import com.scalar.producrservice25.Repositories.CategoryRepository;
import com.scalar.producrservice25.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProducrService25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
        //By default -> EAGER
        Optional<Product> optionalProduct = productRepository.findById(1L);
        System.out.println(optionalProduct.get().getTitle());

        //By default -> LAZY
        Optional<Category> optionalCategory = categoryRepository.findById(1L);
        System.out.println(optionalCategory.get().getName());
    }

//    @Test
//    void test1(){
//        List<ProductWithTitleAndPrice> products =
//                productRepository.getProductTitleAndPriceSQL("Macbook Air", 160000.0);
//        for(ProductWithTitleAndPrice p : products){
//            System.out.println(p.getTitle() + "-> " + p.getPrice());
//        }
//    }
//
//    @Test
//    void test2(){
//        List<ProductWithTitleAndPrice> products =
//                productRepository.getProductTitleAndPriceHQL("Macbook Air", 160000.0);
//    }

}
