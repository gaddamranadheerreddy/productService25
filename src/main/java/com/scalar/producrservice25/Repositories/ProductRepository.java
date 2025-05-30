package com.scalar.producrservice25.Repositories;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
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
}
