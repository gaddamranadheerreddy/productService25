package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryService {
    void deleteCategoryById(long id);
}
