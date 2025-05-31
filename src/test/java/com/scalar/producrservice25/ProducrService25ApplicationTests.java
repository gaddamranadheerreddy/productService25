package com.scalar.producrservice25;

import com.scalar.producrservice25.Projections.ProductWithTitleAndPrice;
import com.scalar.producrservice25.Repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProducrService25ApplicationTests {
//    @Autowired
//    private ProductRepository productRepository;

    @Test
    void contextLoads() {
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
git commit -m "Modified the code. Now the application was running successfully.
When started today -> it gave error -> Lonmob related error -> cannot get the getter and setters .
        -> first changed the lombok dependency to the one as present in the deepakkasera github pom.xml file
-> Not worked.
        -> Reverted back to the original one -> As before (Like Yesterday).
        -> Its working now.
Dont now how Lombok is working -> Always Confusing..git commit -m "Modified the code. Now the application was running successfully.
When started today -> it gave error -> Lonmob related error -> cannot get the getter and setters .
        -> first changed the lombok dependency to the one as present in the deepakkasera github pom.xml file
-> Not worked.
        -> Its working now. "he original one -> As before (Like Yesterday).
