package com.example.BookBridge.controller;

import com.example.BookBridge.entity.Category;
import com.example.BookBridge.service.CategoryService;
import org.hibernate.boot.archive.scan.internal.ScanResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.xml.stream.events.StartElement;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public String findAllCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }
    @GetMapping("/remove-category/{id}")
    public String deleteCategory(@PathVariable Long id,Model model){
        categoryService.deleteCategoryById(id);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "categories";
    }

    @GetMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "update-category";
    }
    @PostMapping("/update-category/{id}")
    public String updateCategory(@PathVariable Long id, Category category, BindingResult result, Model model){
        if(result.hasErrors()){
            return "update-category";
        }
        categoryService.updateCategory(category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }

    @GetMapping("/add-category")
    public String showCreateCategory(Category category,Model model){
        model.addAttribute("category",category);
        return "add-category";
    }
    @PostMapping("/save-category")
    public String saveCategory(Category category,BindingResult result,Model model){
        if(result.hasErrors()){
            return "add-category";
        }
        categoryService.createCategory(category);
        model.addAttribute("categories",categoryService.getAllCategories());
        return "redirect:/categories";
    }
}
