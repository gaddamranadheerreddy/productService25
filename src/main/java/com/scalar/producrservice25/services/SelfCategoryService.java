package com.scalar.producrservice25.services;

import com.scalar.producrservice25.Models.Category;
import com.scalar.producrservice25.Repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SelfCategoryService implements CategoryService{
    private CategoryRepository categoryRepository;
    public SelfCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void deleteCategoryById(long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        categoryRepository.delete(optionalCategory.get());
    }
}
