package com.scalar.producrservice25.Repositories;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Models.Product;
import com.scalar.producrservice25.Projections.ProductWithTitleAndPrice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    Optional<Product> findById(Long productId);
    //select * from products where isd = productId;

    @Override
    List<Product> findAll();

    Optional<Product> findByTitleContains(String str);
    //select * from products where tile like '%str%';

    Optional<Product> findByCategory(Category category);

    Optional<Product> findByCategory_Id(Long id);

    @Override
    Product save(Product product);

    //Custom Queries
    //1. HQL -> Hibernate Query Language
    //Based on the Models. (No need of the tables names that are in the DB)
//    @Query("select p.title as title, p.price as price from Product p where p.title = :title and p.price = :price")
//    List<ProductWithTitleAndPrice> getProductTitleAndPriceHQL(String title, Double price);

    //2. SQL -> Structured Query Language -> Native Queries
    //Here the Table names in the DB are must
//    @Query(value = "select p.title, p.price from products p where p.title = :title and p.price = :price", nativeQuery = true)
//    List<ProductWithTitleAndPrice> getProductTitleAndPriceSQL(String title, Double price);
}
