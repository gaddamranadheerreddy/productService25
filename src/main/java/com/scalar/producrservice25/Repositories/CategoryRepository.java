package com.scalar.producrservice25.Repositories;

import com.scalar.producrservice25.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Override
    Optional<Category> findById(Long id);

    Optional<Category> findByName(String name);
    //select * from categories where name = ?...

    @Override
    Category save(Category category);
}
