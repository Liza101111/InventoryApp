package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.entity.Product;
import com.springboot.inventoryapp.repository.CategoryRepository;
import com.springboot.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/products/new")
    public String createProduct(Model model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("product", new Product());
        model.addAttribute("listCategories", categoryList);
        return "create_product";
    }


}
