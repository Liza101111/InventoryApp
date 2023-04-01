package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Product;
import com.springboot.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products/new")
    public String createProduct(Model model){
        model.addAttribute("product", new Product());
        return "create_product";
    }


}
