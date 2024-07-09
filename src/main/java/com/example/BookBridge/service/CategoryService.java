package com.example.BookBridge.service;

import com.example.BookBridge.entity.Category;
import com.example.BookBridge.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id){
        Category cat=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        return cat;
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategoryById(Long id){
        Category cat=categoryRepository.findById(id).orElseThrow(()->new RuntimeException("Category not found"));
        categoryRepository.deleteById(cat.getId());
    }
}
