package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> listCategories = categoryRepository.findAll();
        model.addAttribute("Categories", listCategories);
        return "categories";
    }
}
