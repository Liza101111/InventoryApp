package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Brand;
import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.repository.BrandRepository;
import com.springboot.inventoryapp.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BrandController {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/brands/new")
    public String createBrandForm(Model model){
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("listCategories", categoryList);
        model.addAttribute("brand", new Brand());
        return "create_brand";
    }

    @PostMapping("/brands/save")
    public String saveBrand(Brand brand){
        brandRepository.save(brand);
        return "redirect:/";
    }
}
