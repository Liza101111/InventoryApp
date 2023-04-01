package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.Category;
import com.springboot.inventoryapp.entity.Product;
import com.springboot.inventoryapp.repository.CategoryRepository;
import com.springboot.inventoryapp.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/products/save")
    public String saveProduct(Product product){
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/products")
    public String listProducts(Model model){
       List<Product> listProducts= productRepository.findAll();
       model.addAttribute("products", listProducts);
       return "products";
    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable("id") Integer id, Model model){
        Product product = productRepository.findById(id).get();
        model.addAttribute("product", product);
        List<Category> categoryList = categoryRepository.findAll();
        model.addAttribute("listCategories", categoryList);
        return "create_product";
    }

    @GetMapping("/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") Integer id, Model model){
        productRepository.deleteById(id);
        return "redirect:/products";
    }



}
