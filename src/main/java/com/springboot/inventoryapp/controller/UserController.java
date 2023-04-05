package com.springboot.inventoryapp.controller;

import com.springboot.inventoryapp.entity.User;
import com.springboot.inventoryapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public String listUsers(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("users", listUsers);
        return "users";
    }
}
