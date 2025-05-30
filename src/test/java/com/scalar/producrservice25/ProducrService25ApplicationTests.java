package com.scalar.producrservice25;

import com.scalar.producrservice25.Projections.ProductWithTitleAndPrice;
import com.scalar.producrservice25.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProducrService25ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void test1(){
        List<ProductWithTitleAndPrice> products =
                productRepository.getProductTitleAndPriceSQL("Macbook Air", 160000.0);
        for(ProductWithTitleAndPrice p : products){
            System.out.println(p.getTitle() + "-> " + p.getPrice());
        }
    }

    @Test
    void test2(){
        List<ProductWithTitleAndPrice> products =
                productRepository.getProductTitleAndPriceHQL("Macbook Air", 160000.0);
    }

}
