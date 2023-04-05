package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Brand;
import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.repository.BrandRepository;
import com.springboot.inventoryapp.repository.CategoryRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        return "redirect:/brands";
    }

    @GetMapping("/brands")
    public String listBrands(Model model){
        List<Brand> listBrands = brandRepository.findAll();
        model.addAttribute("brands",listBrands);
        return "brands";
    }

    @GetMapping("/brands/edit/{id}")
    public String editBrandForm(@PathVariable("id") Integer id, Model model){
        List<Category> categoryList = categoryRepository.findAll();
        Brand brand = brandRepository.findById(id).get();
        model.addAttribute("listCategories", categoryList);
        model.addAttribute("brand", brand);
        return "create_brand";
    }

    @GetMapping("/brands/delete/{id}")
    public String deleteBrand(@PathVariable("id") Integer id){
        brandRepository.deleteById(id);
        return "redirect:/brands";
    }


}
